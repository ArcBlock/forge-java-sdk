package io.arcblock.forge.hash;

import org.spongycastle.jcajce.provider.digest.Keccak;

/**
 * Created by Nate Gu on 2019/2/16
 */
public class ArcKeccakf1600Hasher {
  private ArcKeccakf1600Hasher() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  /**
   * default with sha256 and the round = 2
   */
  public static byte[] sha(byte[] input) {
    return sha256(input, 1);
  }

  /**
   * default round = 2
   */
  public static byte[] sha224(byte[] input) {
    return sha224(input, 1);
  }

  public static byte[] sha224(byte[] input, int round) {
    if (round < 1) {
      throw new RuntimeException("round can't less than 1");
    }
    Keccak.DigestKeccak kecc = new Keccak.Digest224();
    kecc.update(input, 0, input.length);
    if (round == 1) {
      return kecc.digest();
    } else {
      return sha224(kecc.digest(), round - 1);
    }
  }

  /**
   * default round = 2
   */
  public static byte[] sha256(byte[] input) {
    return sha256(input, 1);
  }

  public static byte[] sha256(byte[] input, int round) {
    if (round < 1) {
      throw new RuntimeException("round can't less than 1");
    }
    Keccak.DigestKeccak kecc = new Keccak.Digest256();
    kecc.update(input, 0, input.length);
    if (round == 1) {
      return kecc.digest();
    } else {
      return sha256(kecc.digest(), round - 1);
    }
  }

  /**
   * default round = 2
   */
  public static byte[] sha384(byte[] input) {
    return sha384(input, 1);
  }

  public static byte[] sha384(byte[] input, int round) {
    if (round < 1) {
      throw new RuntimeException("round can't less than 1");
    }
    Keccak.DigestKeccak kecc = new Keccak.Digest384();
    kecc.update(input, 0, input.length);
    if (round == 1) {
      return kecc.digest();
    } else {
      return sha384(kecc.digest(), round - 1);
    }
  }

  /**
   * default round = 2
   */
  public static byte[] sha512(byte[] input) {
    return sha512(input, 1);
  }

  public static byte[] sha512(byte[] input, int round) {
    if (round < 1) {
      throw new RuntimeException("round can't less than 1");
    }
    Keccak.DigestKeccak kecc = new Keccak.Digest512();
    kecc.update(input, 0, input.length);
    if (round == 1) {
      return kecc.digest();
    } else {
      return sha512(kecc.digest(), round - 1);
    }
  }
}
