package com.example.demo;

import forge_abi.Rpc;
import io.arcblock.forge.ForgeSDK;


public class ForgeConfig {


    public ForgeSDK forgeSDK(){
        System.out.println("connect host");
        ForgeSDK forge = ForgeSDK.Companion.connect("localhost",27210);
        Rpc.ResponseGetChainInfo chainInfo = forge.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance());
        System.out.println("xxx:"+chainInfo.getInfo().toString());

        return forge;
    }

}
