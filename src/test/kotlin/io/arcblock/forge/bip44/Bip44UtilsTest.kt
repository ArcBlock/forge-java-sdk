package io.arcblock.forge.bip44

import org.junit.Assert
import org.junit.Test

class Bip44UtilsTest {

  @Test
  fun genSeed(){
    val seed = Bip44Utils.genSeed("asdf","asdf","")
    Assert.assertTrue(seed.seedBytes!!.isNotEmpty())
  }

  fun genRecoverCode(){
    val rc = Bip44Utils.genRecoverCode()
    Assert.assertTrue(rc.isNotEmpty())
  }


  fun testRecover(){
    val rc = Bip44Utils.genRecoverCode()
    val seed = Bip44Utils.genSeed("asdf",rc,"")
    Assert.assertTrue(seed.seedBytes!!.isNotEmpty())
  }

  fun genKeyPair(){
    val seed = Bip44Utils.genSeed("asdf","asdf","")
    val ecKey = Bip44Utils.genKeyPair(seed)
    Assert.assertTrue(ecKey.privateKey != null)
  }

  fun genKeyPair1(){
    val seed = Bip44Utils.genSeed("asdf","asdf","")

    val ecKey = Bip44Utils.genKeyPair(seed,"m/44'/60'/0'/2/1")
    Assert.assertTrue(ecKey.privateKey != null)
  }



}
