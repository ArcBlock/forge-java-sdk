import java.util.UUID;

import forge_abi.Rpc;
import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.Result;
import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.extension.BigIntegerExt;

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
class ConsumeAsset extends BaseConfig {

  public static void main(String[] args){
    ForgeSDK forge = ForgeSDK.Companion.connect("localhost", BaseConfig.serverPort);
    Rpc.ResponseSendTx response;


    WalletInfo alice = forge.createWallet();
    response=forge.declare("Alice", alice);

    WalletInfo Thomas = forge.createWallet();
    response=forge.declare("Thomas", Thomas);

    forge.checkin(alice);

    //create Asset for Thomas
    Result result = forge.createAsset("json",("{\"a\":"+ UUID
      .randomUUID().toString() +"}").getBytes(), "testAsset", Thomas);
    response = result.getResponse();//create asset transaction response
    String assetAddress = result.getAddress();

    //wait for block commit
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //simple exchange
    response = forge.exchange(alice, Thomas, BigIntegerExt.INSTANCE.createWithDecimal(10,18), assetAddress);


    response = forge.consumeAsset(assetAddress, Thomas, alice);
    logger.info(response.toString());



  }
}
