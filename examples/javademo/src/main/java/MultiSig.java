import java.math.BigInteger;
import java.util.UUID;

import forge_abi.Rpc;
import forge_abi.Type;
import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.Result;
import io.arcblock.forge.TransactionFactory;
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
class MultiSig extends BaseConfig {
  public static void main(String[] args) {
    ForgeSDK forge = ForgeSDK.Companion.connect("localhost", BaseConfig.serverPort);
    Rpc.ResponseSendTx response;


    WalletInfo alice = forge.createWallet();
    response = forge.declare("Alice", alice);
    WalletInfo Thomas = forge.createWallet();
    response = forge.declare("Thomas", Thomas);

    forge.poke(alice);
    //create Asset for Thomas
    Result result = forge.createAsset("json",("{\"a\":"+ UUID
      .randomUUID().toString() +"}").getBytes(), "testAsset", Thomas);
    response = result.getResponse();//create asset transaction response
    String assetAddress = result.getAddress();

    //prepare Transaction
    Type.Transaction preTx = TransactionFactory.INSTANCE.preExchange("default",alice.getAddress(), alice.getPk(), Thomas.getAddress(), BigInteger.TEN, assetAddress);
    preTx = TransactionExtKt.signTx(preTx, alice.getSk());
    //MultiSig Transaction
    Type.Transaction finalTx = TransactionFactory.INSTANCE.finalizeMultiSig(preTx, Thomas);

    response = forge.sendTx(finalTx);

    logger.info(response.toString());

  }
}
