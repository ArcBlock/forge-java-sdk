import forge_abi.Rpc;
import forge_abi.Type;
import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.TransactionFactory;
import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.extension.StringExtensionKt;
import io.arcblock.forge.extension.TransactionExtKt;
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
class Declare extends BaseConfig {

  public static void main(String[] args){

    ForgeSDK forge = ForgeSDK.Companion.connect("localhost", BaseConfig.serverPort);
    Rpc.ResponseSendTx response;


    //Random wallet declare
    WalletInfo alice = forge.createWallet();
    response=forge.declare("Alice", alice);



    //Random wallet from custom Private Key
    //send second time will failed because it has been declared
    WalletInfo Slider = WalletInfo.Companion.fromSk(StringExtensionKt.decodeB64Url("W3Cgl4_YvG-h0g61LrhgWoXRW_RtWXKNKu7d-hZWtTAthAlt0e6Om" +
      "-yPEL2_uqHQYNF2IAO_wHI_SbnGqOGsyA=="));
    response=forge.declare("Slider", Slider);



    //Custom sign
    WalletInfo Mark = forge.createWallet();
    Type.Transaction declare = TransactionFactory.INSTANCE.declare("default", Mark.getAddress(), Mark.getPk(),"Mark");
    Type.Transaction signedTx = TransactionExtKt.signTx(declare, Mark.getSk());
    response = forge.sendTx(signedTx);
    logger.info(response.toString());

    waitForBlockCommit();
    TransactionInfo info = gql.getTx(response.getHash()).getResponse().getInfo();
    logger.info(info.toString());

  }
}
