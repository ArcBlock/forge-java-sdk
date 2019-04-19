package io.arcblock.walletkit.hash;

import io.arcblock.walletkit.hash.sha.impl.SHA3_224;
import io.arcblock.walletkit.hash.sha.impl.SHA3_256;
import io.arcblock.walletkit.hash.sha.impl.SHA3_384;
import io.arcblock.walletkit.hash.sha.impl.SHA3_512;

/**
 * Created by Nate Gu on 2019/2/16
 */
public class ArcSha3Hasher {

  private ArcSha3Hasher() {
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
    MsgDigest msgDigest = new SHA3_224();
    msgDigest.update(input, 0, input.length);
    if (round == 1) {
      return msgDigest.digest();
    } else {
      return sha224(msgDigest.digest(), round - 1);
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

    MsgDigest msgDigest = new SHA3_256();
    msgDigest.update(input, 0, input.length);
    if (round == 1) {
      return msgDigest.digest();
    } else {
      return sha256(msgDigest.digest(), round - 1);
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
    MsgDigest msgDigest = new SHA3_384();
    msgDigest.update(input, 0, input.length);
    if (round == 1) {
      return msgDigest.digest();
    } else {
      return sha384(msgDigest.digest(), round - 1);
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
    MsgDigest msgDigest = new SHA3_512();
    msgDigest.update(input, 0, input.length);
    if (round == 1) {
      return msgDigest.digest();
    } else {
      return sha512(msgDigest.digest(), round - 1);
    }
  }
}
