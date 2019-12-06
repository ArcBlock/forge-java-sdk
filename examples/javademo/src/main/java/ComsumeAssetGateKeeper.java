import com.google.protobuf.Any;
import com.google.protobuf.ByteString;

import java.util.UUID;

import forge_abi.Rpc;
import forge_abi.Type;
import io.arcblock.forge.Result;
import io.arcblock.forge.TransactionFactory;
import io.arcblock.forge.TypeUrls;
import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.extension.BigIntegerExt;
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
class ComsumeAssetGateKeeper extends BaseConfig {
  public static void main(String[] args) {

    Rpc.ResponseSendTx response;
    Type.ChainInfo chainInfo = forge
      .getChainInfo()
      .getInfo();

    WalletInfo Issuer = forge.createWallet();
    response = forge.declare("Issuer", Issuer);
    WalletInfo GateKeeper = forge.createWallet();
    response = forge.declare("GateKeeper", GateKeeper, Issuer.getAddress());
    WalletInfo customer = forge.createWallet();
    response = forge.declare("Custumer", customer);

    forge.checkin(customer);// consumer get money
    waitForBlockCommit();
    printAccountBalance(customer.getAddress());

    //create Asset for Thomas
    Result result = forge.createAsset("json", ("{\"a\":" + UUID
      .randomUUID()
      .toString() + "}").getBytes(), "testAsset", Issuer);
    response = result.getResponse();//create asset transaction response
    String assetAddress = result.getAddress();

    waitForBlockCommit();

    //Conusmer buy the asset
    response = forge.exchange(customer, Issuer, BigIntegerExt.INSTANCE.createWithDecimal(11,18) , assetAddress);

    waitForBlockCommit();
    printAccountBalance(customer.getAddress());
    //Prepare unsigned consume asset Transaction, wait for asset Holder to finalize signature
    Type.Transaction tx = TransactionFactory.INSTANCE.preUnsignConusmeAsset(chainInfo.getNetwork(), GateKeeper.getAddress(), GateKeeper.getPk(),
      Issuer.getAddress());
    tx = TransactionExtKt.signTx(tx, GateKeeper.getSk());


    //ConsumeAsset multiSig must add asset address to data ,so any asset holder can use prepared un finalize Transaction to finalize it.
    Any data = Any
      .newBuilder()
      .setValue(ByteString.copyFrom(assetAddress.getBytes()))
      .setTypeUrl(TypeUrls.CONSUME_ASSET_ADDRESS)
      .build();
    tx = TransactionFactory.INSTANCE.finalizeMultiSig(tx, customer, null, data);

    //send tx
    response = forge.sendTx(tx);

    waitForBlockCommit();
    TransactionInfo info = gql.getTx(response.getHash()).getResponse().getInfo();
    logPretty(info);

  }


}
