package io.arcblock.forge

import forge_abi.Enum
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.math.BigInteger

/**
 *
 *     █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 *    ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 *    ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 *    ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 *    ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 *    ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : shan@arcblock.io
 * Time         : 2019-09-10
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/

@Ignore
class TransferTest {

  @Test
  fun testTranser(){
    val forge = ForgeSDK.connect("localhost",28210)
    val alice =  forge.createWallet("alice","123qweASD").wallet
    val bob =  forge.createWallet("bobbb","123qweASD").wallet
    forge.poke(alice, forge.getForgeState().state.pokeConfig)
    val response = forge.transfer(alice, bob, BigInteger.ONE)
    Assert.assertEquals(" send multi sig transaction:", Enum.StatusCode.ok, response.code)

  }
}
