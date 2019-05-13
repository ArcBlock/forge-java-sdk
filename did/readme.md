# DID

did module is help developer to implement [DID protocol](https://github.com/ArcBlock/ABT-DID-Protocol) easily.

## Claims

did module provide four kinds of Claim : profile, agreement, sign and did.

`profile` type can require client return user's profile such as: username, phone or avatar

`agreement` type sent a doc to user so user can signature it and return it.

`Signature` type provide a origin transaction, If user want to sent this transaction ,just need signature this transaction and return result.

`did` type require user to provide an asset or an account DID to proof he match some case. such as: proof his account has enough Token or he has a target asset.

## Usage

first, you have to create a api for client to query claim. and put it as a parameter of <https://abtwallet.io/i/> and use this url to generate a QR code which can be scan by Wallet App.

In this api, you have to claim what information your application really want.

```kotlin
    //declare your application app info
    val appInfo = AppInfo()
    //declare a claim
    val claim1 = ProfileClaim(MetaInfo("profile info",""),arrayListOf("username","email"))
    //the wallet info of your application
    val wallet = WalletInfo("zXXXXXXXX")
    // get the JWT token of claims
    val token = DidAuthUtils.createDidAuthToken(arrayOf(claim1),appInfo,System.currentTimeMillis(),wallet)
    //return response to client
    return DidResponseBody(wallet.pkBase58(),token)
```

and the Wallet App will feedback user's PK and another jwt token contains information which you have claimed.

```json
{
  "userInfo": "eyJhbGciOiJFZDI1NTE5IiwidHlwIjoiSldUIn0.eyJleHAiOiIxNTU3NzM0Mzk5IiwiaWF0IjoiMTU1NzczDMzOSIsImlzcyI6ImRpZDphYnQ6ejFrWEc3emdOVlFnZ0p4OHJSUXB2b0hYQ1dKbjd5bmF0eEQiLCJuYmYiOiIxNTU3NzM0MzM5IiwicmVxdWVzdGVkQ2xhaW1zIjpbeyJ0eXBlIjoicHJvZmlsZSIsImZ1bGxOYW1lIjoicCJ9XX0.MkE_pvfNyN_7r3MqRYDPSUAfg6GwSW_CofRJtn8a9k25FBE7zuR1zq0rBegTeSTEQTn1OIaZq-N5Coa6XQMoDQ",
  "userPk": "z8ovDmcoZzw6vfszgjfLQgtGncCJvMzaADbvvq7j3SBHe"
}
```

you can use `DidAuthUtils.parseJWT(token)` to get your result. before you handle the information, you have to verify JWT.
