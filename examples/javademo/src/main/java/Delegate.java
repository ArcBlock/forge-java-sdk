import java.util.ArrayList;

import forge_abi.Rpc;
import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.TypeUrls;
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
class Delegate extends BaseConfig {
  public static void main(String[] args){
    ForgeSDK forge = ForgeSDK.Companion.connect("localhost", BaseConfig.serverPort);
    Rpc.ResponseSendTx response;


    WalletInfo alice = forge.createWallet();
    response=forge.declare("Alice", alice);
    WalletInfo Thomas = forge.createWallet();
    response=forge.declare("Thomas", Thomas);
    WalletInfo Bruce = forge.createWallet();
    response=forge.declare("Bruce", Bruce);

    forge.poke(alice);

    response = forge.createDelegate(alice, Thomas ,new ArrayList<String>(), TypeUrls.TRANSFER);

    response = forge.transfer(Thomas, Bruce.getAddress(), BigIntegerExt.INSTANCE.createWithDecimal(3.3,18),null, alice.getAddress());
    logger.info(response.toString());
  }
}
