/**
 * Author       : shan@arcblock.io
 * Time         : 2019-12-26
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
class RandowmWallet extends BaseConfig{
  public static void main(String[] args){
//    WalletInfo alice = forge.createWallet();
//    logPretty(alice);
//
//    logger.info("alice sk:"+ StringExtensionKt.encodeB64(alice.getSk()));
//
//    WalletInfo cc = WalletInfo.Companion.fromSk(alice.getSk());
//    logPretty(cc);
    for (int j= 0; j < 10; j++){
      final int tj = j;
      new Thread(new Runnable() {
        public void run() {
          for(int i = 0; i< 1000;i++){
            forge.createWallet();
            logger.info(tj+" created:"+i);
          }
          logger.info(tj+" finish");
        }
      }).start();

    }

  }
}
