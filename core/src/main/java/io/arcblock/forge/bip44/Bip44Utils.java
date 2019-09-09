package io.arcblock.forge.bip44;


import com.google.common.io.BaseEncoding;

import org.bitcoinj.core.Base58;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDKeyDerivation;
import org.bitcoinj.wallet.DeterministicSeed;
import org.web3j.crypto.ECKeyPair;

import java.security.SecureRandom;

import io.arcblock.forge.hash.ArcKeccakf1600Hasher;

/**
 *  Utils to generate BIP44 Wallet
 **/
public class Bip44Utils {

  /**
   * （imtoken jaxx Metamask myetherwallet）
   */
  private static String ETH_JAXX_TYPE = "m/44'/60'/0'/0/0";

  private static final SecureRandom secureRandom = SecureRandomUtils.secureRandom();

  /**
   * Generate a secure seed for HD wallet
   *
   */
  public static DeterministicSeed genSeed(String secretCode, String recoverCode,
                                          String passphrase) {
    long creationTimeSeconds = System.currentTimeMillis() / 1000;
    //    byte[] x = getEntropy(secureRandom, 128);
    //    this.mnemonicCode = MnemonicCode.INSTANCE.toMnemonic(entropy);
    return new DeterministicSeed(getEntropy(secretCode, recoverCode), passphrase,
      creationTimeSeconds);
  }

  /**
   * generate a recover code
   * @return
   */
  public static String genRecoverCode() {
    byte[] seed = new byte[16];
    secureRandom.nextBytes(seed);

    return Base58.encode(seed);
  }

  private static byte[] getEntropy(String secretCode, String recoverCode) {
    String result = BaseEncoding.base16()
      .encode(ArcKeccakf1600Hasher.sha256(
        (BaseEncoding.base16().encode(ArcKeccakf1600Hasher.sha256(secretCode.getBytes(), 1))
          + recoverCode).getBytes(), 1));

    return result.substring(0, 32).getBytes();
  }

  /**
   * Generate KeyPair by seed
   */
  public static ECKeyPair genKeyPair(DeterministicSeed seed) {
    return genKeyPair(seed, ETH_JAXX_TYPE);
  }

  /**
   * Generate KeyPair by seed and custom path
   */
  public static ECKeyPair genKeyPair(DeterministicSeed seed, String path) {
    String[] pathArray = path.split("/");
    DeterministicKey dkKey = HDKeyDerivation.createMasterPrivateKey(seed.getSeedBytes());
    for (int i = 1; i < pathArray.length; i++) {
      ChildNumber childNumber;
      if (pathArray[i].endsWith("'")) {
        int number = Integer.parseInt(pathArray[i].substring(0,
          pathArray[i].length() - 1));
        childNumber = new ChildNumber(number, true);
      } else {
        int number = Integer.parseInt(pathArray[i]);
        childNumber = new ChildNumber(number, false);
      }
      dkKey = HDKeyDerivation.deriveChildKey(dkKey, childNumber);
    }
    return ECKeyPair.create(dkKey.getPrivKeyBytes());
  }
}
