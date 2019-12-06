import java.math.BigInteger;
import java.util.UUID;

import forge_abi.Rpc;
import forge_abi.Type;
import io.arcblock.forge.Result;
import io.arcblock.forge.TransactionFactory;
import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.extension.TransactionExtKt;
import io.arcblock.forge.graphql.AssetState;
import io.arcblock.forge.graphql.TransactionInfo;

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

    Rpc.ResponseSendTx response;


    WalletInfo alice = forge.createWallet();
    response = forge.declare("Alice", alice);
    WalletInfo Thomas = forge.createWallet();
    response = forge.declare("Thomas", Thomas);

    forge.checkin(alice);

    //create Asset for Thomas
    Result result = forge.createAsset("json",("{\"a\":"+ UUID
      .randomUUID().toString() +"}").getBytes(), "testAsset", Thomas);
    response = result.getResponse();//create asset transaction response
    String assetAddress = result.getAddress();

    waitForBlockCommit();
    printAccountBalance(alice.getAddress());
    printAccountBalance(Thomas.getAddress());
    AssetState asset = gql.getAssetState(assetAddress).getResponse().getState();
    System.out.println("\n\nAsset:"+asset.toString()+"\n\n");


    //prepare Transaction
    Type.Transaction preTx = TransactionFactory.INSTANCE.preExchange("default",alice.getAddress(), alice.getPk(), Thomas.getAddress(), BigInteger.TEN, assetAddress);
    preTx = TransactionExtKt.signTx(preTx, alice.getSk());

    //MultiSig Transaction
    Type.Transaction finalTx = TransactionFactory.INSTANCE.finalizeMultiSig(preTx, Thomas);

    response = forge.sendTx(finalTx);

    waitForBlockCommit();
    printAccountBalance(alice.getAddress());
    printAccountBalance(Thomas.getAddress());

    TransactionInfo info = gql.getTx(response.getHash()).getResponse().getInfo();
    logPretty(info);

  }
}
