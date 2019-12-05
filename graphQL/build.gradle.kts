
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import io.aexp.nodes.graphql.annotations.GraphQLProperty
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


buildscript {
  repositories {
    mavenCentral()
    maven(url = "https://dl.bintray.com/americanexpress/maven/")
  }

  dependencies {
    classpath("com.github.jengelman.gradle.plugins:shadow:5.1.0")

    classpath("io.aexp.nodes.graphql:nodes:0.5.0")
    classpath("com.squareup.okhttp3:okhttp:4.0.1")
    classpath("com.squareup:kotlinpoet:1.4.4")
    classpath("com.google.code.gson:gson:2.3.1")
  }
}

plugins {
  kotlin("jvm") version "1.3.31"
  `maven-publish`
  id("org.jetbrains.dokka") version ("0.10.0")
  id("com.github.johnrengelman.shadow") version ("5.1.0")

}
//apply(plugin = "maven-publish")
group = "io.arcblock.forge"
version = "1.0.2"


repositories {
  mavenCentral()
  maven(url = "https://dl.bintray.com/americanexpress/maven/")
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  implementation("com.google.code.gson:gson:2.3.1")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.1")
  compile("io.aexp.nodes.graphql:nodes:0.5.0")
  testCompile(group = "junit", name = "junit", version = "4.12")
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}


tasks.withType<ShadowJar> {
  this.baseName = "graphql"
  this.version = project.file("../version")
    .readLines()
    .first()
}

publishing {
  repositories {
    maven {
      val releaseUrl = "s3://android-docs.arcblock.io.s3.amazonaws.com/release"
      val snapshotUrl = "s3://android-docs.arcblock.io.s3.amazonaws.com/snapshot"
      this.setUrl(releaseUrl)
      this.credentials(AwsCredentials::class.java, Action<AwsCredentials> {
        this.accessKey = if (project.hasProperty("AWS_S3_ACCESSKEY")) project.properties["AWS_S3_ACCESSKEY"].toString() else System.getenv("AWS_S3_ACCESSKEY")
        this.secretKey = if (project.hasProperty("AWS_S3_SECRETKEY")) project.properties["AWS_S3_SECRETKEY"].toString() else System.getenv("AWS_S3_SECRETKEY")
      })
    }
  }
  publications {
    create<MavenPublication>("mavenJava") {
      this.groupId = project.group.toString()
      this.artifactId = "graphql"
      this.version = project.version.toString()
      this.from(components.findByName("java"))
    }
  }

}








/**
 * auto generate gql data structure
 */
open class GenerateGQLQuery : DefaultTask() {
  var annotationMap = mutableMapOf<String, Any>()

  @TaskAction
  fun generate() {
    val json = querySchema()
    val fileBuilder = FileSpec.builder("${project.group}.graphql", "GraphQLEntities")
      .addImport("io.aexp.nodes.graphql.annotations", "GraphQLArgument")
    json.getAsJsonArray("types")
      .find { it.asJsonObject["name"].asString == "RootQueryType" }
      ?.apply {
        generateQuery(this.asJsonObject["fields"].asJsonArray)
      }
    json.getAsJsonArray("types")
      .filter {
        it.asJsonObject["name"].asString !in listOf("RootQueryType", "RootMutationType", "RootSubscriptionType", "ResponseSubscribe")
          && !it.asJsonObject["name"].asString.startsWith("__")
      }
      .forEach {
        generateBaseBean(it.asJsonObject)?.forEach { ts ->
          fileBuilder.addType(ts)
        }
      }
    //val trueFile = File("${project.path}")
    val file = project.file("src/main/kotlin/")
    //fileBuilder.build().writeTo(System.out)
    fileBuilder.build()
      .writeTo(file)
  }

  fun querySchema(): JsonObject {
    val bodyStr = "query IntrospectionQuery {__schema { queryType { name } mutationType { name } subscriptionType { name } types { ...FullType } directives {" +
      " name description locations args { ...InputValue } } } } fragment FullType on __Type { kind name description fields(includeDeprecated: true) { name description args { ...InputValue } type { ...TypeRef } isDeprecated deprecationReason } inputFields { ...InputValue } interfaces { ...TypeRef } enumValues(includeDeprecated: true) { name description isDeprecated deprecationReason } possibleTypes { ...TypeRef } } fragment InputValue on __InputValue { name description type { ...TypeRef } defaultValue } fragment TypeRef on __Type { kind name ofType { kind name ofType { kind name ofType { kind name ofType { kind name ofType { kind name ofType { kind name ofType { kind name } } } } } } } } "
    val schemaJson = OkHttpClient().newCall(Request.Builder()
      .url("http://localhost:8212/api")
      .header("Content-Type", "text/plain")
      .post(bodyStr.toRequestBody())
      .build())
      .execute()
      .body?.string()
    println("response schema:$schemaJson")
    return JsonParser().parse(schemaJson)?.asJsonObject?.getAsJsonObject("data")?.getAsJsonObject("__schema") ?: JsonObject()
  }

  /**
   * parse like
   *         {
  "description": "",
  "enumValues": null,
  "fields": [
  {
  "args": [],
  "deprecationReason": null,
  "description": null,
  "isDeprecated": false,
  "name": "address",
  "type": {
  "kind": "SCALAR",
  "name": "String",
  "ofType": null
  }
  },

  "inputFields": null,
  "interfaces": [],
  "kind": "OBJECT",
  "name": "ChainInfo",
  "possibleTypes": null

   */
  fun generateBaseBean(js: JsonObject): List<TypeSpec>? {

    if (js["kind"].asString in listOf("OBJECT")) {
      val className = js["name"].asString
      //val tsb = TypeSpec.classBuilder(className)
      val primaryFun = FunSpec.constructorBuilder()
        .addAnnotation(JvmOverloads::class.java)
      val properties = mutableListOf<PropertySpec>()
      //some input params is in inputFields
      (if (js.get("fields").isJsonNull) js.getAsJsonArray("inputFields") else
        js.getAsJsonArray("fields"))
        .forEach {
          val paramsName = it.asJsonObject["name"].asString
          val kind = it.asJsonObject["type"].asJsonObject["kind"].asString
          val type = when (kind) {
            in listOf("SCALAR", "OBJECT", "ENUM", "NON_NULL") -> {
              val ofKind = it.asJsonObject["type"].asJsonObject["ofType"]
              if (ofKind.isJsonNull || ofKind?.asJsonObject?.get("kind")?.asString ?: "" != "UNION") {
                val kindName = it.asJsonObject["type"].asJsonObject["name"]
                val clazz = strToClass(it.asJsonObject["type"].asJsonObject)
                primaryFun.addParameter(ParameterSpec.builder(paramsName, clazz.copy(nullable = true))
                  .defaultValue("null")
                  .build())
                properties.add(PropertySpec.builder(paramsName, clazz.copy(nullable = true)).initializer(paramsName).build())
              } else ""
            }
            "LIST" -> {
              val ofKind = it.asJsonObject["type"].asJsonObject["ofType"]
              if (ofKind.isJsonNull || ofKind?.asJsonObject?.get("kind")?.asString ?: "" != "UNION") {
                val kindName = it.asJsonObject["type"].asJsonObject["name"]
                val clazz = LIST.parameterizedBy(strToClass(it.asJsonObject["type"].asJsonObject))
                primaryFun.addParameter(ParameterSpec.builder(paramsName, clazz.copy(nullable = true))
                  .defaultValue("null")
                  .build())
                properties.add(PropertySpec.builder(paramsName, clazz.copy(nullable = true)).initializer(paramsName).build())
              } else ""

            }
            else -> ""
          }
        }
      if (primaryFun.parameters.size > 0) {

        val listOfClass = mutableListOf<TypeSpec>()
        if (className in annotationMap.keys) {
          val anno = annotationMap[className]
          if (anno != null) {
            if (anno is AnnotationSpec) {
              val tsb = TypeSpec.classBuilder(className)
                .primaryConstructor(primaryFun.build())
              tsb.addProperties(properties)
                .addAnnotation(anno)
              listOfClass.add(tsb.addModifiers(KModifier.DATA).build())
            } else if (anno is List<*>) {
              (anno as List<AnnotationSpec>).forEach {
                val name = it.members.find {
                  it.toString()
                    .startsWith("name=")
                }
                  .toString()
                  .removePrefix("name=")
                  .replace("\"", "")
                  .capitalize()
                listOfClass.add(TypeSpec.classBuilder(name)
                  .addModifiers(KModifier.DATA)
                  .primaryConstructor(primaryFun.build())
                  .addProperties(properties).addAnnotation(it).build())
              }
            }
          }
          return listOfClass
        } else return listOf(
          TypeSpec.classBuilder(className).primaryConstructor(primaryFun.build()).addProperties(properties).addModifiers(KModifier.DATA).build())
      } else return listOf(TypeSpec.classBuilder(className).primaryConstructor(primaryFun.build()).addProperties(properties).build())
    } else if (js["kind"].asString == "ENUM") {
      val className = js["name"].asString
      val tsb = TypeSpec.enumBuilder(className)
      js["enumValues"].asJsonArray.map { it.asJsonObject["name"].asString }
        .forEach { tsb.addEnumConstant(it) }
      return listOf(tsb.build())
//    }else if(js["kind"].asString == "SCALAR"){
//      if (js["name"].asString == "Json"){
//        return TypeSpec.classBuilder("Json").build()
//      }else return null
    } else return null
  }

  /**
   *               "type": {
   *                 "kind": "NON_NULL",
   *                 "name": null,
   *                 "ofType": {
   *                   "kind": "SCALAR",
   *                   "name": "Json",
   *                   "ofType": null
   *                 }
   *               }
   */
  fun strToClass(js: JsonObject): ClassName {
    val kind = js["kind"].asString
    val name = if (js["name"].isJsonNull) {
      js["ofType"].asJsonObject["name"].asString
    } else {
      js["name"].asString
    }

    return when (name) {
      in listOf("String", "DateTime", "StatusCode", "Json") -> STRING
//      in listOf("Int","EncodingType","HashType","KeyType","RoleType") -> INT
      else -> ClassName("${project.group}.graphql", name)
    }

  }


  fun generateQuery(querys: JsonArray) {
    querys.map { it.asJsonObject }
      .forEach {
        singleQuery(it)
      }
  }

  /**
   *
  {
  "args": [
  {
  "defaultValue": null,
  "description": "",
  "name": "address",
  "type": {
  "kind": "SCALAR",
  "name": "String",
  "ofType": null
  }
  },
  }
  ],
  "deprecationReason": null,
  "description": "",
  "isDeprecated": false,
  "name": "getAccountState",
  "type": {
  "kind": "OBJECT",
  "name": "ResponseGetAccountState",
  "ofType": null
  }
  },

   */
  fun singleQuery(json: JsonObject) {
    val queryName = json["name"].asString
    val queryParams = AnnotationSpec.builder(GraphQLProperty::class.java)
      .addMember("name=\"$queryName\"")
    var params = "arguments=arrayOf("
    val argssss = json["args"].toString()
    json["args"].asJsonArray.forEach { je ->
      var paramsName = je.asJsonObject["name"].asString
      params = params.plus("GraphQLArgument(name=\"$paramsName\", optional = true ),")
    }
    queryParams.addMember(params.removeSuffix(",").plus(")"))

    val keyName = json["type"].asJsonObject["name"].asString
    if (!annotationMap.containsKey(keyName)) {
      annotationMap[keyName] = queryParams.build()
    } else {
      if (annotationMap[keyName] is AnnotationSpec) {
        val value = annotationMap[keyName]
        annotationMap[keyName] = mutableListOf(value, queryParams.build())
      } else if (annotationMap[keyName] is List<*>) {
        (annotationMap[keyName] as MutableList<Any>).add(queryParams.build())
      }
    }
  }
}

tasks.register<GenerateGQLQuery>("generateGql")

