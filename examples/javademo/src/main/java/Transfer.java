import java.math.BigInteger;

import forge_abi.Rpc;
import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.did.WalletInfo;

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
class Transfer extends BaseConfig {
  public static void main(String[] args){

    ForgeSDK forge = ForgeSDK.Companion.connect("localhost",BaseConfig.serverPort);
    WalletInfo alice = forge.createWallet();
    forge.declare("Alice", alice);
    WalletInfo bob = forge.createWallet();
    forge.declare("Bobby", bob);

    forge.checkin(alice);
    Rpc.ResponseSendTx response = forge.transfer(alice, bob.getAddress(), BigInteger.TEN);
    logger.info(response.toString());
  }
}
