package io.arcblock.walletkit.utils;

/**
 * Created by Nate Gu on 2019/2/16
 */
public class ConvertUtils {
  public static byte[] long2bytes(long val) {
    byte[] out;
    if (val> 0xFFFFFFFFL){
      out = new byte[8];
      for (int i = 0; i < 8; i++) {
        int offset = (out.length - 1 - i) * 8;
        out[i] = (byte) ((val >>> offset) & 0xFF);
      }
    }else{
      out = new byte[4];
      for (int i = 0; i < 4; i++) {
        int offset = (out.length - 1 - i) * 8;
        out[i] = (byte) ((val >>> offset) & 0xFF);
      }
    }
    return out;
  }

  public static String bytes2hex(byte[] bytes) {
    char[] table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    int length = bytes.length;
    char[] temp = new char[length << 1];
    int i = 0;
    int var = 0;
    while (i < length) {
      temp[var++] = table[(240 & bytes[i]) >>> 4];
      temp[var++] = table[15 & bytes[i++]];
    }
    return new String(temp);
  }
}
