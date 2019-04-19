package io.arcblock.walletkit

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class WalletKitTest {

  @Test
  fun newInstance() {
    val wk = WalletKit.newInstance()
    Assert.assertTrue(wk.seed.seedBytes!!.isNotEmpty())

  }

  @Test
  fun genMnimonics() {
    val wk = WalletKit.newInstance()
    val eckey = wk.createWallet("acb","ccd")
    Assert.assertTrue(wk.genMnimonics().size  == 12)
  }

  @Test
  fun createWallet() {
    val wk = WalletKit.newInstance()
    val eckey = wk.createWallet("acb","ccd")
    Assert.assertTrue(eckey.privateKey != null)
  }

  @Test
  fun recoverWallet() {
    val wk = WalletKit.newInstance()
    val eckey = wk.recoverWallet("acb","ccd")
    Assert.assertTrue(eckey.privateKey != null)
  }

  @Test
  fun getSeed() {
    val wk = WalletKit.newInstance()
    val eckey = wk.createWallet("acb","ccd")
    Assert.assertTrue(wk.seed.seedBytes!!.isNotEmpty())
  }
}
