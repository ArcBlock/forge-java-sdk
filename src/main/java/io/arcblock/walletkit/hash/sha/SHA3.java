package io.arcblock.walletkit.hash.sha;

import io.arcblock.walletkit.hash.HASH;

import static io.arcblock.walletkit.utils.ArrayUtils.arrayCopy;
import static io.arcblock.walletkit.utils.ArrayUtils.fill;
import static io.arcblock.walletkit.utils.BytesUtils.b2iLittle;
import static io.arcblock.walletkit.utils.BytesUtils.i2bLittle;

/**
 * Created by Nate Gu on 2019/2/16
 */
public abstract class SHA3 extends HASH {

  private static final int WIDTH = 200;

  private static final int DM = 5;

  private static final int NR = 24;

  private static final long[] RC_CONSTANTS = {
      0x01L, 0x8082L, 0x800000000000808aL,
      0x8000000080008000L, 0x808bL, 0x80000001L,
      0x8000000080008081L, 0x8000000000008009L, 0x8aL,
      0x88L, 0x80008009L, 0x8000000aL,
      0x8000808bL, 0x800000000000008bL, 0x8000000000008089L,
      0x8000000000008003L, 0x8000000000008002L, 0x8000000000000080L,
      0x800aL, 0x800000008000000aL, 0x8000000080008081L,
      0x8000000000008080L, 0x80000001L, 0x8000000080008008L,
  };

  private byte[] state = new byte[WIDTH];
  private final long[] lanes = new long[DM * DM];

  public SHA3(String name, int digestLength) {
    super(name, digestLength, (WIDTH - (2 * digestLength)));
  }

  @Override
  public void implReset() {
    fill(state, (byte) 0);
    fill(lanes, 0L);
  }

  @Override
  public void implCompress(byte[] buf, int ofs) {
    for (int i = 0; i < buffer.length; i++) {
      state[i] ^= buf[ofs++];
    }
    keccak();
  }

  @Override
  public void implDigest(byte[] out, int ofs) {
    setPaddingBytes(buffer, (int) (bytesProcessed % buffer.length));
    for (int i = 0; i < buffer.length; i++) {
      state[i] ^= buffer[i];
    }
    keccak();
    arrayCopy(state, 0, out, ofs, getDigestLength());
  }

  /**
   * Keccak算法
   */
  private void keccak() {
    bytes2Lanes(state, lanes);

    for (int ir = 0; ir < NR; ir++) {
      smIota(smChi(smPiRho(smTheta(lanes))), ir);
    }

    lanes2Bytes(lanes, state);
  }

  private void setPaddingBytes(byte[] in, int len) {
    if (len != in.length) {
      for (int i = len; i < in.length; i++) in[i] = (byte) 0;
      in[len] |= (byte) 0x06;
      in[in.length - 1] |= (byte) 0x80;
    }
  }

  private void bytes2Lanes(byte[] s, long[] m) {
    int sOfs = 0;
    for (int y = 0; y < DM; y++, sOfs += 40) {
      b2iLittle(s, sOfs, m, DM * y, 40);
    }
  }

  private void lanes2Bytes(long[] m, byte[] s) {
    int sOfs = 0;
    for (int y = 0; y < DM; y++, sOfs += 40) {
      i2bLittle(m, DM * y, s, sOfs, 40);
    }
  }

  private long rotateLeft(long i, int distance) {
    return (i << distance) | (i >>> -distance);
  }

  private long[] smTheta(long[] a) {
    long c0 = a[0] ^ a[5] ^ a[10] ^ a[15] ^ a[20];
    long c1 = a[1] ^ a[6] ^ a[11] ^ a[16] ^ a[21];
    long c2 = a[2] ^ a[7] ^ a[12] ^ a[17] ^ a[22];
    long c3 = a[3] ^ a[8] ^ a[13] ^ a[18] ^ a[23];
    long c4 = a[4] ^ a[9] ^ a[14] ^ a[19] ^ a[24];
    long d0 = c4 ^ rotateLeft(c1, 1);
    long d1 = c0 ^ rotateLeft(c2, 1);
    long d2 = c1 ^ rotateLeft(c3, 1);
    long d3 = c2 ^ rotateLeft(c4, 1);
    long d4 = c3 ^ rotateLeft(c0, 1);
    for (int y = 0; y < a.length; y += DM) {
      a[y] ^= d0;
      a[y + 1] ^= d1;
      a[y + 2] ^= d2;
      a[y + 3] ^= d3;
      a[y + 4] ^= d4;
    }
    return a;
  }

  private long[] smPiRho(long[] a) {
    long tmp = rotateLeft(a[10], 3);
    a[10] = rotateLeft(a[1], 1);
    a[1] = rotateLeft(a[6], 44);
    a[6] = rotateLeft(a[9], 20);
    a[9] = rotateLeft(a[22], 61);
    a[22] = rotateLeft(a[14], 39);
    a[14] = rotateLeft(a[20], 18);
    a[20] = rotateLeft(a[2], 62);
    a[2] = rotateLeft(a[12], 43);
    a[12] = rotateLeft(a[13], 25);
    a[13] = rotateLeft(a[19], 8);
    a[19] = rotateLeft(a[23], 56);
    a[23] = rotateLeft(a[15], 41);
    a[15] = rotateLeft(a[4], 27);
    a[4] = rotateLeft(a[24], 14);
    a[24] = rotateLeft(a[21], 2);
    a[21] = rotateLeft(a[8], 55);
    a[8] = rotateLeft(a[16], 45);
    a[16] = rotateLeft(a[5], 36);
    a[5] = rotateLeft(a[3], 28);
    a[3] = rotateLeft(a[18], 21);
    a[18] = rotateLeft(a[17], 15);
    a[17] = rotateLeft(a[11], 10);
    a[11] = rotateLeft(a[7], 6);
    a[7] = tmp;
    return a;
  }

  private long[] smChi(long[] a) {
    for (int y = 0; y < a.length; y += DM) {
      long ay0 = a[y];
      long ay1 = a[y + 1];
      long ay2 = a[y + 2];
      long ay3 = a[y + 3];
      long ay4 = a[y + 4];
      a[y] = ay0 ^ ((~ay1) & ay2);
      a[y + 1] = ay1 ^ ((~ay2) & ay3);
      a[y + 2] = ay2 ^ ((~ay3) & ay4);
      a[y + 3] = ay3 ^ ((~ay4) & ay0);
      a[y + 4] = ay4 ^ ((~ay0) & ay1);
    }
    return a;
  }

  private void smIota(long[] a, int rndIndex) {
    a[0] ^= RC_CONSTANTS[rndIndex];
  }
}