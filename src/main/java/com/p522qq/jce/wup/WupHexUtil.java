package com.p522qq.jce.wup;

import java.nio.ByteBuffer;

/* renamed from: com.qq.jce.wup.WupHexUtil */
public class WupHexUtil {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] emptybytes = new byte[0];

    public static String byte2HexStr(byte b) {
        char[] cArr = new char[2];
        char[] cArr2 = digits;
        cArr[1] = cArr2[b & 15];
        cArr[0] = cArr2[((byte) (b >>> 4)) & 15];
        return new String(cArr);
    }

    public static String bytes2HexStr(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.flip();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        return bytes2HexStr(bArr);
    }

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            int i3 = i2 + 1;
            char[] cArr2 = digits;
            cArr[i3] = cArr2[b & 15];
            cArr[i2 + 0] = cArr2[((byte) (b >>> 4)) & 15];
        }
        return new String(cArr);
    }

    public static byte char2Byte(char c) {
        int i;
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    return 0;
                }
            }
            i = (c - c2) + 10;
        } else {
            i = c - '0';
        }
        return (byte) i;
    }

    public static byte hexStr2Byte(String str) {
        if (str == null || str.length() != 1) {
            return 0;
        }
        return char2Byte(str.charAt(0));
    }

    public static byte[] hexStr2Bytes(String str) {
        if (str == null || str.equals("")) {
            return emptybytes;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((char2Byte(str.charAt(i2)) * 16) + char2Byte(str.charAt(i2 + 1)));
        }
        return bArr;
    }
}
