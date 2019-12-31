import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.extension.StringExtensionKt;

/**
 * Author       : shan@arcblock.io
 * Time         : 2019-12-26
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
class RandowmWallet extends BaseConfig{
  public static void main(String[] args){
    WalletInfo alice = forge.createWallet();
    logPretty(alice);

    logger.info("alice sk:"+ StringExtensionKt.encodeB64(alice.getSk()));

    WalletInfo cc = WalletInfo.Companion.fromSk(alice.getSk());
    logPretty(cc);
  }
}
