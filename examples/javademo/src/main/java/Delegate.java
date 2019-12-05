import java.util.ArrayList;

import forge_abi.Rpc;
import io.arcblock.forge.TypeUrls;
import io.arcblock.forge.did.DIDGenerator;
import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.extension.BigIntegerExt;
import io.arcblock.forge.graphql.DelegateState;

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
    Rpc.ResponseSendTx response;


    WalletInfo alice = forge.createWallet();
    response=forge.declare("Alice", alice);
    WalletInfo Thomas = forge.createWallet();
    response=forge.declare("Thomas", Thomas);
    WalletInfo Bruce = forge.createWallet();
    response=forge.declare("Bruce", Bruce);

    forge.checkin(alice);

    waitForBlockCommit();
    printAccountBalance(alice.getAddress());
    printAccountBalance(Thomas.getAddress());
    printAccountBalance(Bruce.getAddress());

    response = forge.createDelegate(alice, Thomas ,new ArrayList<String>(), TypeUrls.TRANSFER);
    String delegationAddress = DIDGenerator.INSTANCE.genDelegateAddress(alice.getAddress(),Thomas.getAddress());

    response = forge.transfer(Thomas, Bruce.getAddress(), BigIntegerExt.INSTANCE.createWithDecimal(3.3,18),null, alice.getAddress());
    logger.info(response.toString());

    waitForBlockCommit();
    printAccountBalance(alice.getAddress());
    printAccountBalance(Thomas.getAddress());
    printAccountBalance(Bruce.getAddress());

    DelegateState state = gql.getDelegationState(delegationAddress).getResponse().getState();
    logPretty(state);

  }
}
