import forge_abi.Rpc;
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
class Transfer extends BaseConfig {
  public static void main(String[] args){
    WalletInfo alice = forge.createWallet();
    forge.declare("Alice", alice);
    WalletInfo bob = forge.createWallet();
    forge.declare("Bobby", bob);

    printAccountBalance(alice.getAddress());
    printAccountBalance(bob.getAddress());

    forge.checkin(alice);
    waitForBlockCommit();
    printAccountBalance(alice.getAddress());
    Rpc.ResponseSendTx response = forge.transfer(alice, bob.getAddress(), BigIntegerExt.INSTANCE.createWithDecimal(9, 18));
    logger.info(response.toString());

    waitForBlockCommit();
    printAccountBalance(alice.getAddress());
    printAccountBalance(bob.getAddress());
  }
}
