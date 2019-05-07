package com.example.demo;

import forge_abi.Rpc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Test
	public void contextLoads() {
//		ForgeSDK forgeSDK =
		ForgeSDK forgeSDK = ForgeSDK.getInstance("localhost",27210);

		Rpc.ResponseGetChainInfo chainInfo = forgeSDK.getChainInfo(Rpc.RequestGetChainInfo.newBuilder().build());
		System.out.println(chainInfo.toString());
		try {
			forgeSDK.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
