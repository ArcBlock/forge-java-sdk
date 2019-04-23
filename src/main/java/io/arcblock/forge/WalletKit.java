package io.arcblock.forge;


import io.arcblock.forge.bip44.Bip44Utils;
import java.util.Collections;
import java.util.List;
import org.bitcoinj.wallet.DeterministicSeed;
import org.web3j.crypto.ECKeyPair;

/**
 * Author       :paperhuang
 * Time         :2019/1/3
 * Edited By    :
 * Edited Time  :
 **/
public class WalletKit {
  public static WalletKit instance;

  public static WalletKit newInstance() {
    synchronized (WalletKit.class) {
      if (instance == null) {
        instance = new WalletKit();
      }
    }
    return instance;
  }

  private DeterministicSeed seed;

  WalletKit() {

  }

  public List<String> genMnimonics() {
    if (seed == null)
      throw new RuntimeException("You have't create a wallet");
    return seed == null ? Collections.<String>emptyList() : seed.getMnemonicCode();
  }

  public ECKeyPair createWallet(String secretCode, String recoverCode) {
    seed = Bip44Utils.genSeed(secretCode, recoverCode, "");

    ECKeyPair key = Bip44Utils.genKeyPair(seed);
    return key;
  }

  public ECKeyPair recoverWallet(String secretCode, String recoverCode) {
    seed = Bip44Utils.genSeed(secretCode, recoverCode, "");
    return Bip44Utils.genKeyPair(seed);
  }

  public DeterministicSeed getSeed() {
    if (seed == null)
      throw new RuntimeException("You have't create a wallet");
    return seed;
  }
}
