import io.arcblock.forge.graphql.ChainInfo;

/**
 * Author       : shan@arcblock.io
 * Time         : 2019-12-05
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
class ChainInfoQuery extends BaseConfig{

  public static void main(String[] args){
    ChainInfo chainInfo = gql.getChainInfo().getResponse().getInfo();
    logPretty(chainInfo);

  }
}
