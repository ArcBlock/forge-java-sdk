# abtdid-spring-boot-starter

This repo help user to generate DID auth easily.

[what's did auth?](https://github.com/ArcBlock/abt-did-spec)

## install

maven

``` xml
<dependency>
  <groupId>io.arcblock.forge</groupId>
  <artifactId>abtdid-spring-boot-starter</artifactId>
  <version>version</version>
  <type>pom</type>
</dependency>
```

gradle

``` groovy
implementation 'io.arcblock.forge:abtdid-spring-boot-starter:version'
```

## usage

in `application.properties` add your applicaiton infomation:

``` java
abt.did.enabled=true
//chain host
abt.did.app.chainHost=http://10.165.110.234:8210/api
//application host
abt.did.app.host=10.165.110.234:9090
//application name
abt.did.app.name=test
abt.did.app.logo=https://avatars2.com
abt.did.app.desc=description
//application signature privateKey's DID
abt.did.app.publisher=did:abt:zasdfasdf
```

then create your own controller, in controller inject AbtDidSerivce

``` java
  @Autowired
  private AbtDidService didService;
```


create a deep link for web to genrate QR code.

``` java
abtDidService.generateDeepLink(url);//url is wallet request claims url
```

 create methods that application want wallet to provide. such as:

``` java
//profile
didService.requireProfile(arrayListOf("fullname", "email", "phone"), forge.wallet, url)

//payment
didService.requirePayToken(BigDecimal("5E18").toBigInteger().unSign(), chainID.value, jwt.iss.address(), body.userPk!!.decodeB58(), forge.wallet.address, "Pay 5 TBA", forge.wallet, url)

//signature
didService.requireSiganture(unsignedTx.toByteArray(), "CheckIn and Get 25 TBA", "fg:t:transaction", forge.wallet, url)
```

at last, finish DID-auth

``` java
didService.successDIDAuth(wallet);
//or
d
didService.errorDIDAuth(wallet, reason);
```

