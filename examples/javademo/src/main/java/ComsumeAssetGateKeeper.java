import com.google.protobuf.Any;
import com.google.protobuf.ByteString;

import java.math.BigDecimal;
import java.util.UUID;

import forge_abi.Rpc;
import forge_abi.Type;
import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.Result;
import io.arcblock.forge.TransactionFactory;
import io.arcblock.forge.TypeUrls;
import io.arcblock.forge.did.WalletInfo;
import io.arcblock.forge.extension.BigIntegerExtKt;
import io.arcblock.forge.extension.TransactionExtKt;

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
  public static void main(String[] args){
    ForgeSDK forge = ForgeSDK.Companion.connect("localhost", BaseConfig.serverPort);
    Rpc.ResponseSendTx response;
    Type.ChainInfo chainInfo = forge.getChainInfo().getInfo();

    WalletInfo Issuer = forge.createWallet();
    response = forge.declare("Issuer", Issuer);
    WalletInfo GateKeeper = forge.createWallet();
    response =forge.declare("GateKeeper", GateKeeper, Issuer.getAddress());
    WalletInfo Consumer = forge.createWallet();
    response =forge.declare("Consumer", Consumer);

    forge.poke(Consumer);// consumer get money

    //create Asset for Thomas
    Result result = forge.createAsset("json",("{\"a\":"+ UUID
      .randomUUID().toString() +"}").getBytes(), "testAsset", Issuer);
    response = result.getResponse();//create asset transaction response
    String assetAddress = result.getAddress();


    //wait for block commit
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //Conusmer buy the asset
    response = forge.exchange(Consumer, Issuer, BigIntegerExtKt.unSign(new BigDecimal("10E18").toBigInteger()), assetAddress);

    //wait for block commit
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }



    //Prepare unsigned consume asset Transaction, wait for asset Holder to finalize signature
    Type.Transaction tx = TransactionFactory.INSTANCE.preUnsignConusmeAsset(chainInfo.getNetwork(), GateKeeper.getAddress(), GateKeeper.getPk(),
      Issuer.getAddress());
    tx = TransactionExtKt.signTx(tx, GateKeeper.getSk());


    //ConsumeAsset multiSig must add asset address to data ,so any asset holder can use prepared un finalize Transaction to finalize it.
    Any data = Any.newBuilder()
      .setValue(ByteString.copyFrom(assetAddress.getBytes()))
      .setTypeUrl(TypeUrls.CONSUME_ASSET_ADDRESS)
      .build();
    tx = TransactionFactory.INSTANCE.finalizeMultiSig(tx, Consumer, null, data);

    //send tx
    response = forge.sendTx(tx);
    logger.info(response.toString());


  }
}
