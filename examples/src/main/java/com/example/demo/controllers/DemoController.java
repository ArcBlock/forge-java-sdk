package com.example.demo.controllers;

import com.example.demo.beans.AppDid;
import com.example.demo.components.ForgeSDKComponent;
import com.google.gson.Gson;
import com.google.protobuf.Any;
import forge_abi.Declare;
import forge_abi.Enum;
import forge_abi.Poke;
import forge_abi.Rpc;
import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.TypeUrls;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashMap;

@Controller
public class DemoController extends BaseController {

  @Autowired
  public ForgeSDKComponent forge;
  @Resource(name = "a")
  public AppDid appDid;
  @Autowired
  Gson gson;

  @RequestMapping("/")
  @ResponseBody
  public String index() {

    ForgeSDK forgeSDK = forge.getForgeSDK();
    Rpc.ResponseGetChainInfo chainInfo = forgeSDK.getChainInfo(
      Rpc.RequestGetChainInfo.getDefaultInstance()
    );
    String ret = new Gson().toJson(chainInfo);
    Rpc.ResponseGetChainInfo other = forgeSDK.getChainInfo(
      Rpc.RequestGetChainInfo.getDefaultInstance()
    );

    return ret;
  }

  @RequestMapping("/declare")
  @ResponseBody
  public String declare() {
    Declare.DeclareTx itx = Declare.DeclareTx.newBuilder()
      .setMoniker("paper").setIssuer(appDid.getAddress()).build();
    Rpc.RequestCreateTx createTx = Rpc.RequestCreateTx.newBuilder()
      .setFrom(appDid.getAddress())
      .setItx(Any.newBuilder()
        .setTypeUrl(TypeUrls.DECLARE)
        .setValue(itx.toByteString())
        .build())
      .setNonce(1L)
      .setToken(appDid.getToken())
      .build();
    Rpc.ResponseCreateTx createTxResp = forge.getForgeSDK().createTx(createTx);


    Rpc.ResponseSendTx sendResponse = forge.getForgeSDK().sendTx(Rpc.RequestSendTx.newBuilder()
      .setToken(appDid.getToken())
      .setTx(createTxResp.getTx())
      .build());
    if (sendResponse.getCode() == Enum.StatusCode.ok) {
      return "{status: \"ok\"}";
    } else return "{error:\"" + sendResponse.getCode().name() + "\"}";

  }

  @RequestMapping("/poke")
  @ResponseBody
  public String poke() {
    Rpc.ResponseGetForgeState forgeState = forge.getForgeSDK()
      .getForgeState(Rpc.RequestGetForgeState.newBuilder()
        .build());

    Poke.PokeTx itx = Poke.PokeTx.newBuilder()
      .setAddress(forgeState.getState().getPokeConfig().getAddress())
      .setDate(LocalDate.now().toString())
      .build();
    Rpc.RequestCreateTx createTx = Rpc.RequestCreateTx.newBuilder()
      .setFrom(appDid.getAddress())
      .setItx(Any.newBuilder()
        .setTypeUrl(TypeUrls.POKE)
        .setValue(itx.toByteString())
        .build())
      .setNonce(0L)
      .setToken(appDid.getToken())
      .build();
    Rpc.ResponseCreateTx createTxResp = forge.getForgeSDK().createTx(createTx);


    Rpc.ResponseSendTx sendResponse = forge.getForgeSDK()
      .sendTx(Rpc.RequestSendTx.newBuilder()
        .setTx(createTxResp.getTx())
        .build());
    if (sendResponse.getCode() == Enum.StatusCode.ok) {
      return "{status: \"ok\"}";
    } else return "{error:\"" + sendResponse.getCode().name() + "\"}";
  }

  @RequestMapping("/account")
  @ResponseBody
  public String accountState() {
    HashMap<String, String> map = new HashMap<>();
    final Thread thread = Thread.currentThread();
    StreamObserver<Rpc.RequestGetAccountState>
      accountStateResponse = forge.getForgeSDK().getAccountState(new StreamObserver<Rpc.ResponseGetAccountState>() {
      @Override
      public void onNext(Rpc.ResponseGetAccountState value) {
        logger.info(value.toString());
        map.put("ret", gson.toJson(value.getState()));
        synchronized (thread) {
          thread.notify();
        }
      }

      @Override
      public void onError(Throwable t) {
        logger.info("======ERRoR=====>" + t.getMessage());
        map.put("ret", "{error:\"" + t.getMessage() + "\"}");
        synchronized (thread) {
          thread.notify();
        }
      }

      @Override
      public void onCompleted() {
      }
    });
    synchronized (thread) {
      try {
        accountStateResponse.onNext(Rpc.RequestGetAccountState.newBuilder()
          .setAddress(appDid.getAddress())
          .build());
        accountStateResponse.onCompleted();
        thread.wait(6000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        return "{error:\"timeout\"}";
      }

      return map.get("ret");
    }

  }

  @RequestMapping("/tx")
  @ResponseBody
  public String transaction(String hash) {
    HashMap<String, String> map = new HashMap<>();
    final Thread thread = Thread.currentThread();
    StreamObserver<Rpc.RequestGetTx> request = forge.getForgeSDK().getTx(new StreamObserver<Rpc.ResponseGetTx>() {

      @Override
      public void onNext(Rpc.ResponseGetTx value) {
        logger.info(value.toString());
        map.put("ret", gson.toJson(value.getInfo()));
        synchronized (thread) {
          thread.notify();
        }
      }

      @Override
      public void onError(Throwable t) {
        logger.info("======ERRoR=====>" + t.getMessage());
        map.put("ret", "{error:\"" + t.getMessage() + "\"}");
        synchronized (thread) {
          thread.notify();
        }
      }

      @Override
      public void onCompleted() {

      }
    });
    synchronized (thread) {
      try {
        request.onNext(Rpc.RequestGetTx.newBuilder()
          .setHash(hash)
          .build());
        request.onCompleted();
        thread.wait(6000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        return "{error:\"timeout\"}";
      }

      return map.get("ret");

    }
  }

  @RequestMapping("/forge")
  @ResponseBody
  public String forgeState(){
    Rpc.ResponseGetForgeStats response = forge.getForgeSDK().getForgeStats(Rpc.RequestGetForgeStats.getDefaultInstance());
    return response.toString();
  }

}
