package io.arcblock.forge.abtdid;


import com.google.gson.JsonObject;

import org.apache.commons.text.StringEscapeUtils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import io.arcblock.forge.TransactionFactory;
import io.arcblock.forge.did.DidAuthUtils;
import io.arcblock.forge.did.HashType;
import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.did.bean.AppInfo;
import io.arcblock.forge.did.bean.AuthPrincipalClaim;
import io.arcblock.forge.did.bean.IClaim;
import io.arcblock.forge.did.bean.ProfileClaim;
import io.arcblock.forge.did.bean.SignatureClaim;
import io.arcblock.forge.extension.BigIntegerExtKt;
import io.arcblock.forge.extension.BytesExtKt;
import io.arcblock.forge.extension.StringExtensionKt;

/**
 * Author       : shan@arcblock.io
 * Time         : 2020-01-19
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/

public class AbtDidService {

  public AppInfo appInfo;
  public String appHost;
  AbtDidService(AppInfo appInfo, String appHost) {
    this.appInfo = appInfo;
    this.appHost = appHost;
  }

  /**
   * generate deep link url which can invoke ABT Wallet to handle request.
   *
   * @param url your claims' url, usually a auth principle.
   * @return deep link string.
   */
  public String generateDeepLink(String url) {
    return "https://abtwallet.io/i/?action=requestAuth&url="+url;
  }

  /**
   * DID auth first step, require user proof he own some did or let user generate one.
   *
   * @param target if null, wallet will generate one. otherwise, wallet will return his signature use target DID's private key
   * @param walletInfo application wallet used to sign message
   * @param url callback url
   * @return bytes encoded which can be handle by Wallet
   */
  public String authPrinciple(@Nullable String target, WalletInfo walletInfo, String url) {
    String jwt = DidAuthUtils.INSTANCE.createDidAuthToken(new IClaim[]{new AuthPrincipalClaim(target)}, appInfo, System.currentTimeMillis() / 1000, walletInfo,
      url);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("appPk", walletInfo.pkBase58());
    jsonObject.addProperty("authInfo", jwt);
    return StringEscapeUtils.unescapeJson(jsonObject.toString());
  }

  /**
   * generate claims that let wallet provide profile
   *
   * @param items the information you want user to provide, such as: name, gender, birthday, avatar, email or phone.
   * @param wallet application wallet used to sign message
   * @param responseUrl callback url
   * @return bytes encoded which can be handle by Wallet
   */
  public String requireProfile(List<String> items, WalletInfo wallet, String responseUrl) {
    ProfileClaim claim = new ProfileClaim(items, "provide your information for login");
    return requireClaim(new IClaim[]{claim}, wallet, responseUrl);
  }

  /**
   * Generate claims let wallet send some token to receiver's account
   *
   * @param payAmount unsigned pay token amount
   * @param wallet application wallet used to sign message
   * @param responseUrl callback url
   * @return bytes encoded which can be handle by Wallet
   */
  public String requirePayToken(BigInteger payAmount, String chainID, String userDID, byte[] userPk, String recieverDID,
                                String desc, WalletInfo wallet, String responseUrl) {
    byte[] ori = TransactionFactory.INSTANCE
      .unsignTransfer(chainID, userDID, userPk, StringExtensionKt.address(recieverDID),
        BigIntegerExtKt.unSign(payAmount))
      .toByteArray();
    return requireSiganture(ori, desc, "fg:t:transaction", wallet, responseUrl);
  }


  /**
   * Generate claims let wallet sign a information
   *
   * @param needSig the information need to sign
   * @param  dataDescription information description
   * @param dataTypeUrl type of information to let wallet known: support fg:t:transaction, mime:text/plain, mime:text/html
   * @param wallet application wallet used to sign message
   * @param responseUrl callback url
   * @return bytes encoded which can be handle by Wallet
   */
  public String requireSiganture(byte[] needSig, String dataDescription, String dataTypeUrl, WalletInfo wallet, String responseUrl) {
    SignatureClaim signatureClaim = new SignatureClaim("", StringExtensionKt.encodeB58(needSig), StringExtensionKt.encodeB58(BytesExtKt.hash(needSig,
      HashType.SHA3)), dataDescription, dataTypeUrl);
    return requireClaim(new IClaim[]{signatureClaim}, wallet, responseUrl);
  }

  /**
   * generate claims which can be handled by wallet
   *
   * @param claims  array of claims
   * @param wallet application wallet used to sign message
   * @param url callback url
   * @return bytes encoded which can be handle by Wallet
   */
  public String requireClaim(IClaim[] claims, WalletInfo wallet, String url) {
    String jwt = DidAuthUtils.INSTANCE.createDidAuthToken(claims, appInfo, System.currentTimeMillis() / 1000, wallet, url);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("appPk", wallet.pkBase58());
    jsonObject.addProperty("authInfo", jwt);
    return StringEscapeUtils.unescapeJson(jsonObject.toString());
  }

  /**
   * return by this if wallet provide some error information
   *
   * @param wallet application wallet used to sign message
   * @param errorReason the reason why error
   * @return encoded information
   */
  public String errorDIDAuth(WalletInfo wallet, String errorReason) {
    return finishDIDAuth(wallet, false, errorReason, null);
  }

  /**
   * if everything is ok, return this.
   *
   * @param wallet application wallet used to sign message
   * @return encoded information
   */
  public String successDIDAuth(WalletInfo wallet) {
    return successDIDAuth(wallet, null);
  }

  /**
   * return to wallet with some extra information
   */
  public String successDIDAuth(WalletInfo wallet, HashMap<String, String> responseData) {
    return finishDIDAuth(wallet, true, "", responseData);
  }


  /**
   * end did auth
   */
  public String finishDIDAuth(WalletInfo wallet, boolean success, String errorReason, HashMap<String, String> responseData) {
    JsonObject others = new JsonObject();
    if (success) {
      others.addProperty("status", "ok");
      JsonObject responseO = new JsonObject();
      if (responseData != null && responseData.size() > 0) {
        for (String s : responseData.keySet()) {
          responseO.addProperty(s, responseData.get(s));
        }
      }
      others.add("response", responseO);
    } else {
      others.addProperty("status", "error");
      others.addProperty("errorMessage", errorReason);
    }
    String jwt = DidAuthUtils.INSTANCE.createDidAuthToken(new IClaim[]{}, appInfo, System.currentTimeMillis() / 1000, wallet, "", others);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("appPk", wallet.pkBase58());
    jsonObject.addProperty("authInfo", jwt);
    return StringEscapeUtils.unescapeJson(jsonObject.toString());
  }

}
