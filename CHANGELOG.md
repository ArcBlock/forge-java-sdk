## 1.0.9 (March 26, 2020)

  - fix bug
  - add gradle publish
  - resolve enum name
  - add vc moudle
  
## 1.0.8 (March 04, 2020)

## 1.0.7 (January 22, 2020)
  - add spring boot starter

## 1.0.6 (December 31, 2019)
  - fix bug: random wallet generate error

## 1.0.5 (December 24, 2019)
  - fix bug: gql cache remove
  - change itx type from string to json

## 1.0.4 (December 09, 2019)
  - add mutation support for gql
  

## 1.0.3 (December 05, 2019)
 - add graphQL interface support
 - add a pure Java and Maven example

## 1.0.2 (December 02, 2019)
  - BigIntegerExt.createWithDecimal(amount, decimal) to easy create big integer
  - TransactionFactory no need to pass wallet sk
  - rename lazy chainInfo
  - add a examples mvn and Java.

## 1.0.1 (November 19, 2019)
  - remove auth protocol claim: meta
  - consume asset
  - add more usage

## 1.0.0 (November 12, 2019)
  - version 1.0.0

## 0.39.3 (November 08, 2019)


## 0.39.1 (November 01, 2019)
  - creat wallet add default method for java user
  - support fat jar

## 0.39.0 (October 31, 2019)
- deprecated interface use token
- create a wallet locally
- multisig locally
- transer add parameter `assets`
- wallet need declare at first time to use
- Reformat extention method

### Simple Usage

```kotlin
forge = ForgeSDK.connect("localhost", 28212)
alice = forge.createWallet()
bob = forge.createWallet()
forge.declare("alice",alice)
forge.declare("Bobb",bob)
forge.poke(alice)
forge.transfer(alice, bob, BigInteger.ONE)

```

### For java user

Java user can use kotlin object like below:

```java
ForgeSDK.Companion.connect("localhost",28210)
```

and use kotlin extention like below:

```
TransactionExtKt.multiSig(tx, alice)
```
## 0.38.0 (September 29, 2019)
  - add proto
  - remove poke config
  - add token swap protocol

## 0.37.2 (September 16, 2019)
  - Add delegate method
  - Add delegatee parameter for some interface
  - Add Unit Test

## 0.35.0 (September 03, 2019)
  - update protocal to support delegate
  - Merge branch 'version/0.32' into feature/delegate
  - Add delegate protocol
  - add did poke demo
  - fix error import
  - bump version

## 0.30.0 (June 20, 2019)
  - common update

## 0.28.0 (June 19, 2019)
update proto buf
prepare cross chain

## 0.27.0 (June 06, 2019)


## 0.27.0 (May 29, 2019)
  - v0.27

## 0.26 (May 14, 2019)


## 0.2.0 (May 06, 2019)


## 0.1.1 (April 19, 2019)


