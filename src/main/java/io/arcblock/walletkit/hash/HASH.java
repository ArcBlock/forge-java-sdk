package io.arcblock.walletkit.hash;

import static io.arcblock.walletkit.utils.ArrayUtils.arrayCopy;
import static io.arcblock.walletkit.utils.ConvertUtils.bytes2hex;

/**
 * Created by Nate Gu on 2019/2/16
 */
public abstract class HASH extends MsgDigest{

  // 消息摘要结果的长度（以字节为单位）
  private final int digestLength;

  protected final int getDigestLength() {
    return digestLength;
  }

  // 字节缓冲区
  protected byte[] buffer;
  // 缓冲区大小
  private final int blockSize;
  // 缓冲区的偏移值
  private int bufOfs;

  // 已经处理的字节数
  protected long bytesProcessed;

  protected static final byte[] padding;

  static {
    padding = new byte[136];
    padding[0] = (byte) 0x80;
  }

  public HASH(String algorithm, int digestLength, int blockSize) {
    super(algorithm);
    this.digestLength = digestLength;
    this.blockSize = blockSize;
    this.buffer = new byte[blockSize];
  }

  @Override
  public final void reset() {
    if (bytesProcessed != 0) {
      implReset();
      bufOfs = 0;
      bytesProcessed = 0;
    }
  }

  @Override
  public final void update(byte[] b) {
    update(b, 0, b.length);
  }

  @Override
  public final void update(byte[] b, int ofs, int len) {
    if (len == 0) {
      return;
    }
    if ((ofs < 0) || (len < 0) || (ofs > b.length - len)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (bytesProcessed < 0) {
      reset();
    }
    bytesProcessed += len;
    if (bufOfs != 0) {
      int n = blockSize - bufOfs;
      n = len <= n ? len : n;
      arrayCopy(b, ofs, buffer, bufOfs, n);
      bufOfs += n;
      ofs += n;
      len -= n;
      if (bufOfs >= blockSize) {
        implCompress(buffer, 0);
        bufOfs = 0;
      }
    }
    if (len >= blockSize) {
      int limit = ofs + len;
      ofs = implCompressMultiBlock(b, ofs, limit - blockSize);
      len = limit - ofs;
    }
    if (len > 0) {
      arrayCopy(b, ofs, buffer, 0, len);
      bufOfs = len;
    }
  }

  @Override
  public final byte[] digest() {
    byte[] b = new byte[digestLength];
    digest(b, 0, b.length);
    return b;
  }

  private void digest(byte[] out, int ofs, int len) {
    if (bytesProcessed < 0) {
      reset();
    }
    implDigest(out, ofs);
    bytesProcessed = -1;
  }

  @Override
  public String toString() {
    return bytes2hex(digest());
  }

  private int implCompressMultiBlock(byte[] b, int ofs, int limit) {
    while (ofs <= limit) {
      implCompress(b, ofs);
      ofs += blockSize;
    }
    return ofs;
  }

  // 重置方法
  public abstract void implReset();

  // 运算方法
  public abstract void implCompress(byte[] buf, int ofs);

  // 生成方法
  public abstract void implDigest(byte[] out, int ofs);
}
