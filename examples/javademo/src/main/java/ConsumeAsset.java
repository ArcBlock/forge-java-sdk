import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
class ConsumeAsset extends BaseConfig {

  public static void main(String[] args){
    Rpc.ResponseSendTx response;


//    WalletInfo alice = forge.createWallet();
//    response=forge.declare("Alice", alice);
//
//    final WalletInfo Thomas = forge.createWallet();
//    response=forge.declare("Thomas", Thomas);
//
//    forge.checkin(alice);
    final ArrayList<WalletInfo> wallets = new ArrayList<WalletInfo>();
    for (int i = 0; i < 200; i++) {
      WalletInfo walletInfo = forge.createWallet();
      forge.declare("test_asset", walletInfo);
      wallets.add(walletInfo);
    }

    waitForBlockCommit();

    ThreadPoolExecutor tp = new ThreadPoolExecutor(500, 500, 10L, TimeUnit.MINUTES,new  ArrayBlockingQueue(200));
    //create Asset for Thomas
    for (int j = 0; j < 500; j++) {
      final int walletIndex = j;
        tp.submit(new Runnable() {
          public void run() {
            for (int i = 0; i < 1000; i++) {
              Result result = forge.createAsset("json",("{\"a\":"+ UUID
                .randomUUID().toString() +"}").getBytes(), "testAsset",wallets.get(walletIndex));
              logger.info(i +"times:"+"  rst:"+result.getResponse().getCode().name());
              if (!result.getResponse().getCode().name().equalsIgnoreCase("ok")){
                logger.error(walletIndex +"  rst:"+result.getResponse().getCode().name());
                break;
              }
            }
          }
        });
    }

//    Result result = forge.createAsset("json",("{\"a\":"+ UUID
//      .randomUUID().toString() +"}").getBytes(), "testAsset", Thomas);
//    response = result.getResponse();//create asset transaction response
//    String assetAddress = result.getAddress();
//
//    waitForBlockCommit();
//
//    //simple exchange
//    response = forge.exchange(alice, Thomas, BigIntegerExt.INSTANCE.createWithDecimal(10,18), assetAddress);
//
//
//    response = forge.consumeAsset(assetAddress, Thomas, alice);
//    logger.info(response.toString());
//
//    waitForBlockCommit();
//    AssetState assetState = gql.getAssetState(assetAddress).getResponse().getState();
//    logPretty(assetState);
    try {
      Thread.sleep(200000);
    }catch (Exception e){}

  }
}
