package com.alibaba.mtl.log.p077d;

/* renamed from: com.alibaba.mtl.log.d.f */
public class IntUtils {
    /* renamed from: a */
    public static byte[] m3820a(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i % 256);
        int i2 = i >> 8;
        bArr[2] = (byte) (i2 % 256);
        int i3 = i2 >> 8;
        bArr[1] = (byte) (i3 % 256);
        bArr[0] = (byte) ((i3 >> 8) % 256);
        return bArr;
    }
}
