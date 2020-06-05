package com.p570ta.utdid2.p572b.p573a;

/* compiled from: IntUtils */
/* renamed from: com.ta.utdid2.b.a.e */
public class C6801e {
    public static byte[] getBytes(int i) {
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
