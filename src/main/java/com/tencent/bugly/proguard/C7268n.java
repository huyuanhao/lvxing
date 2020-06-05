package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.n */
public final class C7268n {
    /* renamed from: a */
    private static final byte[] f24588a;
    /* renamed from: b */
    private static final byte[] f24589b;

    /* renamed from: a */
    public static boolean m31400a(byte b, byte b2) {
        return b == b2;
    }

    /* renamed from: a */
    public static boolean m31401a(int i, int i2) {
        return i == i2;
    }

    /* renamed from: a */
    public static boolean m31402a(long j, long j2) {
        return j == j2;
    }

    /* renamed from: a */
    public static boolean m31404a(boolean z, boolean z2) {
        return z == z2;
    }

    /* renamed from: a */
    public static boolean m31403a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static byte[] m31405a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        return bArr;
    }

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
        f24588a = bArr2;
        f24589b = bArr3;
    }
}
