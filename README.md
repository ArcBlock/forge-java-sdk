# Java-SDK

## forge-java-sdk

forge sdk for java development.
For Forge-related setup, please checkout [Forge](https://github.com/ArcBlock/forge)
A detailed reference manual for forge-python-sdk can be found [here](../../../forge-java-sdk).

## Installation

if you are using gradle ,you have to add url to your repositories

``` gradle
 repositories {
    maven { url "http://android-docs.arcblock.io/release" }
 }

 dependencies {
    implementation("io.arcblock.forge:core:${forge_version}")
 }
```

and java version must >= 8.

## Usage

### Step 0

First get your Forge running on local with [Forge CLI](../tools/forge_cli.md).
Or you know another's node config info.

### Step 1

Find the config your forge is using by `forge config`, find forge section, and get sock_grpc.

## Tutorials

### Step 0: create a project.

Create a SpringBoot gradle project. and add forge-java-sdk to it's dependencies.

### Step 1: connect to Forge Node.

add forge.host and forge.port to your application.properties.

```
forge.host="127.0.0.1"
forge.port=28210
```

and add `forge = ForgeSDK.connectTo(host, port);` when you application init

### Step 2: create a wallet.

```kotlin
val Alice = forge.createWallet(Rpc.RequestCreateWallet.newBuilder()
                        .setMoniker(usr)
                        .setPassphrase(pass)
                        .setType(Type.WalletType.getDefaultInstance())
                        .build())
// Alice contains:

```

::: tip Notes
`moniker` is a nickname for this wallet on Forge. `passphrase` is used by Forge to encrypt the wallet into a keystore file. More details about wallet declaration rules are [here](../intro/concepts).
:::

### Step 3: Query your account information.

``` kotlin
forge.getForgeSDK().getAccountState()
```

### Step 4: Poke your wallet to get some token.

```kotlin
forge.
val tx = WalletKit.poke(WalletInfo(Alice), forge)
val response = forge.sendTx(Rpc.RequestSendTx.newBuilder()
                    .setToken(appDid.getToken())
                    .setTx(createTxResp.getTx())
                    .build());
```

wait some seconds, check your account balance .

### Step 5: Transfer your token to other.

create another wallet (suppose: Bob) as step 2.

``` kotlin
//create TransferTx
val sendToken = BigInteger.valueOf(1L).plus(BigDecimal("1e$decimal").toBigInteger())
val itx = Transfer.TransferTx.newBuilder()
                .setValue(Type.BigUint.newBuilder().setValue(ByteString.copyFrom(sendToken.toByteArray())).build())
                .setTo(Bob.address)
                .build()
val tx = WalletKit.createTx(Alice, 123L, chainId, itx)
val response = forge.sendTx(Rpc.RequestSendTx.newBuilder()
                    .setToken(appDid.getToken())
                    .setTx(createTxResp.getTx())
                    .build());
```

if it works, response will return a hash string. you can query this hash use forgeSDK,or query it in forgeWeb. After this tx confirmed, check Alice and Bob 's accounts to confirm if this transaction successfully.

::: tip Notes
**TBA** is the default currency on Forge Chain. 1 TBA has 16 digits, so it shows as `10000000000000000`.
and decimal is 16.
:::

🎉 Congratulations! You have finished the tutorial! Now you should have a general sense about how Forge works. Now continue to explore !

## Welcome contribution

Want to contribute? Great! First, read this page

### Setup Develop Environment

first, you have to install [forge-cli](https://docs.arcblock.io/forge/latest/tools/forge_cli.html) and setup a local chain.

make sure you have installed java ,make and ktlint.

clone this Repo. and open terminal in this Repo. run:

```shell

make build

//if you want update protobuf, run first
make download-proto
make genForgeSDK

```

it will start a SpringBoot example.

```shell
curl http://localhost:8081/
```

and it will return forge info.

Now, you can add your code to this project and feel free to create request pull or issue .

### Code reviews

All submissions, including submissions by project members, require review. We
use GitHub pull requests for this purpose.

Before you commit your code ,please run `make test` to make sure all test is passed. and there is a pre-commit to check kotlin code.

Thank you for considering contributing, and feel free to contribute .
