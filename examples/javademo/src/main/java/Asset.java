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

    waitForBlockCommit();

    //create Asset for Thomas
//    Result result = forge.createAsset("json",("{\"a\":"+ UUID
//      .randomUUID().toString() +"}").getBytes(), "testAsset", Thomas);
    Result result = forge.createAsset("json",("{\"a\":"+
      "abcd" +"}").getBytes(), "testAsset", Thomas);
    forge_abi.Type.ChainInfo lazyChainInfo = forge.getLazyChainInfo().getValue();
    logger.info(lazyChainInfo.toString());


    result = forge.createAsset("json",
      "cd74fb7e0c6d646056649e4c325dfa032f89adbd4007c4b753a6afb8c1d4f800287608c38e21e561ee9524cea3bedce0f0c15f099459ec02c23f7bc5b72409b86013aa58a70768f06f45523cfbaecae556e86212a76358a1ca452ac53f742e878e732598837a916e41ea8e698fbf024a61331023fbc183dd77e754cee30a8a9d1a7a014677fbc8861ac265eb1ca1f06c5f768c1bf4c01cccd15621c0d6938677327a3f9a41ab6b865a9ef80bb43b746b87f7a4db2086c9f29774a3c20a7b827a0da02d3aa78623e780bd072028d473d46a8e01df2b4bdc68187bc41ebcff73f64f1031b48d87ea8f18eee93e84dc5c09e01c44a1e6d5488220e23eb4edd297b8635e4622e256f44d503cd6e680f709403c4596c8bcf06f2431d3cba924bb408f136be10e5c444db4dedeeaa7665158850d2198d987b3e2f21c64d3b9ddfb7deadcc1816addcf6fd56df3001d6ebf1ff0cc06af0edbb23d45de7031d0e860f444ebfcd2b2a94928ed15efe6fd0b16423ebd9191a479b79bd46fbbc0c18b73b5be".getBytes(), "unsupportdata",Thomas);

    forge_abi.Type.ChainInfo info = forge.getChainInfo().getInfo();
    logger.info(info.toString());
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
