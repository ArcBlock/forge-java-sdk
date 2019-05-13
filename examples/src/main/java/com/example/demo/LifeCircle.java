package com.example.demo;

import io.arcblock.forge.did.DIDGenerator;
import io.arcblock.forge.did.HashType;

import io.arcblock.forge.did.KeyType;
import io.arcblock.forge.did.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCircle implements InitializingBean, DisposableBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {


    }

    public void createDid(){

        String did = DIDGenerator.INSTANCE.sk2did(RoleType.ACCOUNT, KeyType.ED25519,HashType.SHA3,"".getBytes());
    }




    @PostConstruct
    public void start() throws Exception{

    }

    @PreDestroy
    public void stop() throws Exception{

    }

}
