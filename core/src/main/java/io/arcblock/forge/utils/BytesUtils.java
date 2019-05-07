package io.arcblock.forge.utils;

/**
 * Created by Nate Gu on 2019/2/16
 */
public class BytesUtils {
  public static void b2iLittle(byte[] in, int inOfs, int[] out, int outOfs, int len) {
    if ((inOfs < 0) || ((in.length - inOfs) < len) ||
        (outOfs < 0) || ((out.length - outOfs) < len / 4)) {
      //数组越界
      throw new ArrayIndexOutOfBoundsException();
    }
    len += inOfs;
    while (inOfs < len) {
      out[outOfs++] = ((in[inOfs] & 0xff))
          | ((in[inOfs + 1] & 0xff) << 8)
          | ((in[inOfs + 2] & 0xff) << 16)
          | ((in[inOfs + 3]) << 24);
      inOfs += 4;
    }
  }

  public static void b2iLittle(byte[] in, int inOfs, long[] out, int outOfs, int len) {
    if ((inOfs < 0) || ((in.length - inOfs) < len) ||
        ((outOfs < 0) || (out.length - outOfs) < len / 8)) {
      throw new ArrayIndexOutOfBoundsException();
    }

    len += inOfs;
    while (inOfs < len) {
      out[outOfs++] = ((in[inOfs] & 0xffL)
          | ((in[inOfs + 1] & 0xffL) << 8)
          | ((in[inOfs + 2] & 0xffL) << 16)
          | ((in[inOfs + 3] & 0xffL) << 24)
          | ((in[inOfs + 4] & 0xffL) << 32)
          | ((in[inOfs + 5] & 0xffL) << 40)
          | ((in[inOfs + 6] & 0xffL) << 48)
          | ((in[inOfs + 7] & 0xffL) << 56));
      inOfs += 8;
    }
  }

  public static void b2iBig(byte[] in, int inOfs, int[] out, int outOfs, int len) {
    if ((inOfs < 0) || ((in.length - inOfs) < len) ||
        (outOfs < 0) || ((out.length - outOfs) < len / 4)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    len += inOfs;
    while (inOfs < len) {
      out[outOfs++] = ((in[inOfs + 3] & 0xff))
          | ((in[inOfs + 2] & 0xff) << 8)
          | ((in[inOfs + 1] & 0xff) << 16)
          | ((in[inOfs]) << 24);
      inOfs += 4;
    }
  }

  public static void b2iBig(byte[] in, int inOfs, long[] out, int outOfs, int len) {
    if ((inOfs < 0) || ((in.length - inOfs) < len) ||
        (outOfs < 0) || ((out.length - outOfs) < len / 8)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    len += inOfs;
    while (inOfs < len) {
      int i1 = ((in[inOfs + 3] & 0xff))
          | ((in[inOfs + 2] & 0xff) << 8)
          | ((in[inOfs + 1] & 0xff) << 16)
          | ((in[inOfs]) << 24);
      inOfs += 4;
      int i2 = ((in[inOfs + 3] & 0xff))
          | ((in[inOfs + 2] & 0xff) << 8)
          | ((in[inOfs + 1] & 0xff) << 16)
          | ((in[inOfs]) << 24);
      out[outOfs++] = ((long) i1 << 32) | (i2 & 0xffffffffL);
      inOfs += 4;
    }
  }

  public static void i2bLittle(int[] in, int inOfs, byte[] out, int outOfs, int len) {
    if ((inOfs < 0) || ((in.length - inOfs) < len / 4) ||
        (outOfs < 0) || ((out.length - outOfs) < len)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    len += outOfs;
    while (outOfs < len) {
      int i = in[inOfs++];
      out[outOfs++] = (byte) (i);
      out[outOfs++] = (byte) (i >> 8);
      out[outOfs++] = (byte) (i >> 16);
      out[outOfs++] = (byte) (i >> 24);
    }
  }

  public static void i2bLittle(long[] in, int inOfs, byte[] out, int outOfs, int len) {
    if ((inOfs < 0) || ((in.length - inOfs) < len / 8) ||
        (outOfs < 0) || ((out.length - outOfs) < len)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    len += outOfs;
    while (outOfs < len) {
      long i = in[inOfs++];
      out[outOfs++] = (byte) (i);
      out[outOfs++] = (byte) (i >> 8);
      out[outOfs++] = (byte) (i >> 16);
      out[outOfs++] = (byte) (i >> 24);
      out[outOfs++] = (byte) (i >> 32);
      out[outOfs++] = (byte) (i >> 40);
      out[outOfs++] = (byte) (i >> 48);
      out[outOfs++] = (byte) (i >> 56);
    }
  }

  public static void i2bLittle4(int val, byte[] out, int outOfs) {
    if ((outOfs < 0) || ((out.length - outOfs) < 4)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    out[outOfs] = (byte) (val);
    out[outOfs + 1] = (byte) (val >> 8);
    out[outOfs + 2] = (byte) (val >> 16);
    out[outOfs + 3] = (byte) (val >> 24);
  }

  public static void b2iLittle64(byte[] in, int inOfs, int[] out) {
    if ((inOfs < 0) || ((in.length - inOfs) < 64) ||
        (out.length < 16)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    b2iLittle(in, inOfs, out, 0, 64);
  }

  public static void i2bBig(int[] in, int inOfs, byte[] out, int outOfs, int len) {
    if ((inOfs < 0) || ((in.length - inOfs) < len / 4) ||
        (outOfs < 0) || ((out.length - outOfs) < len)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    len += outOfs;
    while (outOfs < len) {
      int i = in[inOfs++];
      out[outOfs++] = (byte) (i >> 24);
      out[outOfs++] = (byte) (i >> 16);
      out[outOfs++] = (byte) (i >> 8);
      out[outOfs++] = (byte) (i);
    }
  }

  public static void i2bBig(long[] in, int inOfs, byte[] out, int outOfs, int len) {
    if ((inOfs < 0) || ((in.length - inOfs) < len / 8) ||
        (outOfs < 0) || ((out.length - outOfs) < len)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    len += outOfs;
    while (outOfs < len) {
      long i = in[inOfs++];
      out[outOfs++] = (byte) (i >> 56);
      out[outOfs++] = (byte) (i >> 48);
      out[outOfs++] = (byte) (i >> 40);
      out[outOfs++] = (byte) (i >> 32);
      out[outOfs++] = (byte) (i >> 24);
      out[outOfs++] = (byte) (i >> 16);
      out[outOfs++] = (byte) (i >> 8);
      out[outOfs++] = (byte) (i);

    }
  }

  public static void i2bBig4(int val, byte[] out, int outOfs) {
    if ((outOfs < 0) || ((out.length - outOfs) < 4)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    out[outOfs] = (byte) (val >> 24);
    out[outOfs + 1] = (byte) (val >> 16);
    out[outOfs + 2] = (byte) (val >> 8);
    out[outOfs + 3] = (byte) (val);
  }

  public static void b2iBig64(byte[] in, int inOfs, int[] out) {
    if ((inOfs < 0) || ((in.length - inOfs) < 64) ||
        (out.length < 16)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    b2iBig(in, inOfs, out, 0, 64);
  }

  public static void b2iBig128(byte[] in, int inOfs, long[] out) {
    if ((inOfs < 0) || ((in.length - inOfs) < 128) ||
        (out.length < 16)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    b2iBig(in, inOfs, out, 0, 128);
  }
}
