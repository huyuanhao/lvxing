package com.bytedance.sdk.p145a.p146a;

import com.tencent.android.tpush.common.Constants;
import java.nio.charset.Charset;

/* compiled from: Util */
/* renamed from: com.bytedance.sdk.a.a.u */
final class C1868u {
    /* renamed from: a */
    public static final Charset f5290a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static int m6832a(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: a */
    public static short m6833a(short s) {
        short s2 = s & Constants.PROTOCOL_NONE;
        return (short) (((s2 & 255) << 8) | ((-256 & s2) >>> 8));
    }

    /* renamed from: a */
    public static void m6834a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: a */
    public static void m6835a(Throwable th) {
        m6837b(th);
    }

    /* renamed from: b */
    private static <T extends Throwable> void m6837b(Throwable th) throws Throwable {
        throw th;
    }

    /* renamed from: a */
    public static boolean m6836a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
