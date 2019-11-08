package com.example.demo

import forge_abi.Rpc.*
import io.arcblock.forge.ForgeSDK
import io.grpc.stub.StreamObserver
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*




@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@Component
class InitLine : CommandLineRunner {
	var logger = LoggerFactory.getLogger("Forge Init")
	override fun run(vararg args: String?) {
		// Connect forge chain node
		val forge = ForgeSDK.connect("localhost",28210)
		// Query Chain info
		val chainInfo = forge.getChainInfo().info
		logger.info("\nchain info:\n$chainInfo\n\n\n")

		// create two wallet
		val alice = forge.createWallet()
    forge.declare("Alice",alice)
		val bob = forge.createWallet()
    forge.declare("Booooob",bob)
		logger.info("\n\n\n Alice\n $alice\n\n\n")
		Thread.sleep(5000) //wait for block to commit

		// create a stream to listen account state
		val accountRequest = forge.getAccountState(object : StreamObserver<ResponseGetAccountState> {
			override fun onNext(value: ResponseGetAccountState?) {
				logger.info("\nAccountState balance:\n${BigInteger(value?.state?.balance?.value?.toByteArray())}")
			}
			override fun onError(t: Throwable?) {}
			override fun onCompleted() {}
		})
		accountRequest.onNext(RequestGetAccountState.newBuilder().setAddress(alice.address).build())
		val hashQuery = forge.getTx(object : StreamObserver<ResponseGetTx>{
			override fun onError(t: Throwable?) {
				logger.error(t?.message)
			} override fun onCompleted() {}
			override fun onNext(value: ResponseGetTx?) {
				logger.info("\n\n\nHash State:\n$value")
				logger.info("\nCode::${value?.code}")
			}
		})


		forge.poke(alice)
		Thread.sleep(5000) //wait for block to commit
		//Query account balance and transaction hash
		accountRequest.onNext(RequestGetAccountState.newBuilder().setAddress(alice.address).build())




		//create a transfer tx and send
		forge.transfer(alice, bob.address, BigDecimal("2E18").toBigInteger())

		Thread.sleep(5000) //wait for block to commit
		//Query account balance again
		accountRequest.onNext(RequestGetAccountState.newBuilder().setAddress(alice.address).build())


		//Create stream listener of asset
		val queryAsset = forge.getAssetState(object : StreamObserver<ResponseGetAssetState>{
			override fun onNext(value: ResponseGetAssetState?) {
				logger.info("\n@@@@@@@ Asset @@@@@@@")
				logger.info("\n@@@@@@@ Asset @@@@@@@\n${value}")
			}
			override fun onError(t: Throwable?) {}
			override fun onCompleted() {}
		})

		//create simple asset
		val ( assetResponse, assetAddress) = forge.createAsset("string","abcdefg-${UUID.randomUUID().toString()}".toByteArray(),"MonikerCan'tBeEmpty",alice)
		logger.info("\n\n\n@@@@@@@ Create Asset @@@@@@@ $assetAddress")
		logger.info("\n $assetResponse")
		Thread.sleep(5000) //wait for block to commit
		queryAsset.onNext(RequestGetAssetState.newBuilder().setAddress(assetAddress)
			.build())
		Thread.sleep(1000) //wait for block to commit

	}
}
