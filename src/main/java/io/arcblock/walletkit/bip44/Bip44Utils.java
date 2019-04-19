package io.arcblock.walletkit.bip44;


import com.google.common.io.BaseEncoding;
import io.arcblock.walletkit.hash.ArcKeccakf1600Hasher;

import java.security.SecureRandom;
import java.util.List;

import org.bitcoinj.core.Base58;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDKeyDerivation;
import org.bitcoinj.crypto.MnemonicCode;
import org.bitcoinj.wallet.DeterministicSeed;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.utils.Numeric;

/**
 * Author       :paperhuang
 * Time         :2019/1/3
 * Edited By    :
 * Edited Time  :
 **/
public class Bip44Utils {

  /**
   * （imtoken jaxx Metamask myetherwallet）
   */
  public static String ETH_JAXX_TYPE = "m/44'/60'/0'/0/0";

  private static final SecureRandom secureRandom = SecureRandomUtils.secureRandom();

  public static DeterministicSeed genSeed(String secretCode, String recoverCode,
                                          String passphrase) {
    long creationTimeSeconds = System.currentTimeMillis() / 1000;
    //    byte[] x = getEntropy(secureRandom, 128);
    //    this.mnemonicCode = MnemonicCode.INSTANCE.toMnemonic(entropy);
    return new DeterministicSeed(getEntropy(secretCode, recoverCode), passphrase,
      creationTimeSeconds);
  }

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

  public static ECKeyPair genKeyPair(DeterministicSeed seed) {
    return genKeyPair(seed, ETH_JAXX_TYPE);
  }

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

//
//  /**
//   * recovery eckey by mnemonics
//   *
//   * @param path m/44/60/0/0/0
//   * @param list mnemonics
//   */
//  public static ECKeyPair importMnemonic(String path, List<String> list) {
//    if (!path.startsWith("m") && !path.startsWith("M")) {
//      return null;
//    }
//    String[] pathArray = path.split("/");
//    if (pathArray.length <= 1) {
//      return null;
//    }
//    String passphrase = "";
//    long creationTimeSeconds = System.currentTimeMillis() / 1000;
//    DeterministicSeed ds = new DeterministicSeed(list, null, passphrase, creationTimeSeconds);
//    return genKeyPair(ds);
//  }
}
