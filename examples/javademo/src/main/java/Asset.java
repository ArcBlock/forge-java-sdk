import java.util.UUID;

import forge_abi.Enum;
import forge_abi.Rpc;
import io.arcblock.forge.Result;
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
class Asset extends BaseConfig{

  public static void main(String[] args){
    Rpc.ResponseSendTx response;

    WalletInfo Thomas = forge.createWallet();
    response=forge.declare("Thomas", Thomas);

    //create Asset for Thomas
    Result result = forge.createAsset("json",("{\"a\":"+ UUID
      .randomUUID().toString() +"}").getBytes(), "testAsset", Thomas);
    response = result.getResponse();//create asset transaction response
    String assetAddress = result.getAddress();

    waitForBlockCommit();

    if (response.getCode() == Enum.StatusCode.ok){
      logger.info("assetAddress:"+assetAddress);
    }else {
      logger.error(response.getCode().toString());
    }
  }
}