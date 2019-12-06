import java.math.BigInteger;
import java.util.ArrayList;
import java.util.UUID;

import forge_abi.Rpc;
import forge_abi.Type;
import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.Result;
import io.arcblock.forge.TransactionFactory;
import io.arcblock.forge.TypeUrls;
import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.extension.TransactionExtKt;

/**
 * █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 * ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 * ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 * ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 * ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 * ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : shan@arcblock.io
 * Time         : 2019-11-29
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
class DelegateWithMultiSig extends BaseConfig {
  public static void main(String[] args) {
    ForgeSDK forge = ForgeSDK.Companion.connect("localhost", BaseConfig.serverPort);
    Rpc.ResponseSendTx response;

    //create two account
    WalletInfo alice = forge.createWallet();
    response = forge.declare("Alice", alice);
    WalletInfo Thomas = forge.createWallet();
    response = forge.declare("Thomas", Thomas);

    //create other two account
    WalletInfo AliceDele = forge.createWallet();
    response = forge.declare("AliceDele", AliceDele);
    WalletInfo ThomasDele = forge.createWallet();
    response = forge.declare("ThomasDele", ThomasDele);

    //create delegation
    response = forge.createDelegate(alice, AliceDele ,new ArrayList<String>(), TypeUrls.EXCHANGE);
    response = forge.createDelegate(Thomas, ThomasDele ,new ArrayList<String>(), TypeUrls.EXCHANGE);

    // alice get money
    forge.checkin(alice);
    //create Asset for Thomas
    Result result = forge.createAsset("json",("{\"a\":"+ UUID
      .randomUUID().toString() +"}").getBytes(), "testAsset", Thomas);
    response = result.getResponse();//create asset transaction response
    String assetAddress = result.getAddress();


    waitForBlockCommit();
    printAccountBalance(alice.getAddress());
    printAccountBalance(Thomas.getAddress());



    //prepare Transaction
    Type.Transaction preTx = TransactionFactory.INSTANCE.preExchange("default", AliceDele.getAddress(), AliceDele.getPk(), Thomas.getAddress(),
      BigInteger.TEN, assetAddress, alice.getAddress());
    // use DeleAlice to sign ,no need alice self
    preTx = TransactionExtKt.signTx(preTx, AliceDele.getSk());

    //MultiSig Transaction, user TomasDele to sign, just need Thomas did/address
    Type.Transaction finalTx = TransactionFactory.INSTANCE.finalizeMultiSig(preTx, ThomasDele, Thomas.getAddress());

    response = forge.sendTx(finalTx);


    waitForBlockCommit();
    printAccountBalance(alice.getAddress());
    printAccountBalance(Thomas.getAddress());



  }

}
