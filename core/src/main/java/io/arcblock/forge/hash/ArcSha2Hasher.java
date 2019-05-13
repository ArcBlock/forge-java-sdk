package io.arcblock.forge.hash;


import io.arcblock.forge.utils.EncryptUtils;

/**
 * Created by Nate Gu on 2019/2/16
 */
public class ArcSha2Hasher {

  private ArcSha2Hasher() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  /**
   * default with sha256 and the round = 2
   */
  public static byte[] sha(byte[] input) {
    return sha256(input, 2);
  }

  /**
   * default round = 2
   */
  public static byte[] sha224(byte[] input) {
    return sha224(input, 2);
  }

  /**
   * sha224 with custom round
   */
  public static byte[] sha224(byte[] input, int round) {
    if (round < 1) {
      throw new RuntimeException("round can't less than 1");
    }
    if (round == 1) {
      return EncryptUtils.encryptSHA224(input);
    } else {
      return sha224(EncryptUtils.encryptSHA224(input), round - 1);
    }
  }

  /**
   * default round = 2
   */
  public static byte[] sha256(byte[] input) {
    return sha256(input, 2);
  }

  /**
   * sha256 with custom round
   */
  public static byte[] sha256(byte[] input, int round) {
    if (round < 1) {
      throw new RuntimeException("round can't less than 1");
    }
    if (round == 1) {
      return EncryptUtils.encryptSHA256(input);
    } else {
      return sha256(EncryptUtils.encryptSHA256(input), round - 1);
    }
  }

  /**
   * default round = 2
   */
  public static byte[] sha384(byte[] input) {
    return sha384(input, 2);
  }

  /**
   * sha384 with custom round
   */
  public static byte[] sha384(byte[] input, int round) {
    if (round < 1) {
      throw new RuntimeException("round can't less than 1");
    }
    if (round == 1) {
      return EncryptUtils.encryptSHA384(input);
    } else {
      return sha384(EncryptUtils.encryptSHA384(input), round - 1);
    }
  }

  /**
   * default round = 2
   */
  public static byte[] sha512(byte[] input) {
    return sha512(input, 2);
  }

  /**
   * sha512 with custom round
   */
  public static byte[] sha512(byte[] input, int round) {
    if (round < 1) {
      throw new RuntimeException("round can't less than 1");
    }
    if (round == 1) {
      return EncryptUtils.encryptSHA512(input);
    } else {
      return sha512(EncryptUtils.encryptSHA512(input), round - 1);
    }
  }
}
