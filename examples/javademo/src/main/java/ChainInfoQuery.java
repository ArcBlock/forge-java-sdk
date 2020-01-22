import forge_abi.Rpc;

/**
 * Author       : shan@arcblock.io
 * Time         : 2019-12-05
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
class ChainInfoQuery extends BaseConfig{

  public static void main(String[] args){
//    ChainInfo chainInfo = gql.getChainInfo().getResponse().getInfo();
//    logPretty(chainInfo);
    Rpc.ResponseGetChainInfo info = forge.getChainInfo();
    logger.info(info.toString());
    //ForgeSDK.Companion.connect(ManagedChannelBuilder.forAddress("",28210).)
    try {
      forge.shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
