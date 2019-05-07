package com.example.demo.controllers;


import com.example.demo.beans.AppDid;
import com.example.demo.components.ForgeSDKComponent;
import com.google.gson.Gson;
import forge_abi.Enum;
import forge_abi.Rpc;
import forge_abi.Type;
import io.arcblock.forge.utils.Base58Btc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired public ForgeSDKComponent forgeSDKComponent;
    @Autowired public Gson gson;
    @Resource(name = "a")

    public AppDid appDid;

    @Resource(name = "b")
    public AppDid other;



    @RequestMapping("/create")
    @ResponseBody
    public String createWallet(String usr,String pass){
        Rpc.ResponseCreateWallet respone = forgeSDKComponent.getForgeSDK()
                .createWallet(Rpc.RequestCreateWallet.newBuilder()
                        .setMoniker(usr)
                        .setPassphrase(pass)
                        .setType(Type.WalletType.getDefaultInstance())
                        .build()
                );

        if (respone.getCode() == Enum.StatusCode.ok){
            appDid.setToken(respone.getToken());
            appDid.setAddress(respone.getWallet().getAddress());
            appDid.setPk(respone.getWallet().getPk().toByteArray());
            appDid.setSk(respone.getWallet().getSk().toByteArray());
            return gson.toJson(respone.getWallet());
        }else return "{\"error\":"+respone.getCode().name()+"}";
    }

    @RequestMapping("/load")
    @ResponseBody
    public String loadWallet(String address,String pass){
        Rpc.ResponseLoadWallet respone = forgeSDKComponent.getForgeSDK()
                .loadWallet(Rpc.RequestLoadWallet.newBuilder()
                        .setAddress(address)
                        .setPassphrase(pass)
                        .build()
                );

        if (respone.getCode() == Enum.StatusCode.ok){
            appDid.setToken(respone.getToken());
            appDid.setAddress(respone.getWallet().getAddress());
            appDid.setPk(respone.getWallet().getPk().toByteArray());
            appDid.setSk(Base58Btc.INSTANCE.decode("z3K3dTJsZqJR1B9EEMwsAiiDH2hyZs4JnB1Y7ohtaspw8AFQkEPyBgzpdrpbYiXKpC2z9Qqoo3yzJq9ZLQ2s42JXA"));
            return gson.toJson(appDid);
        }else return "{\"error\":"+respone.getCode().name()+"}";
    }


    @RequestMapping("/load2")
    @ResponseBody
    public String loadWallet2(String address,String pass){
        Rpc.ResponseLoadWallet respone = forgeSDKComponent.getForgeSDK()
                .loadWallet(Rpc.RequestLoadWallet.newBuilder()
                        .setAddress(address)
                        .setPassphrase(pass)
                        .build()
                );

        if (respone.getCode() == Enum.StatusCode.ok){
            other.setToken(respone.getToken());
            other.setAddress(respone.getWallet().getAddress());
            other.setPk(respone.getWallet().getPk().toByteArray());
            other.setSk(Base58Btc.INSTANCE.decode("z5Uk9fJF4TAestw8KukRHG1mfds5zkZfiBrfSmiGF23DH4GQwMQHUitDDFFhVNVGdDGSjmBgYX4WaATws1dKHbnCa"));
            return gson.toJson(other);
        }else return "{\"error\":"+respone.getCode().name()+"}";
    }



}
