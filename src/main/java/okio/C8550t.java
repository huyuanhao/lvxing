package okio;

import com.tencent.android.tpush.common.Constants;
import java.nio.charset.Charset;

/* compiled from: Util */
/* renamed from: okio.t */
final class C8550t {
    /* renamed from: a */
    public static final Charset f29059a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static int m36936a(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: a */
    public static short m36937a(short s) {
        short s2 = s & Constants.PROTOCOL_NONE;
        return (short) (((s2 & 255) << 8) | ((-256 & s2) >>> 8));
    }

    /* renamed from: a */
    public static void m36938a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: a */
    public static void m36939a(Throwable th) {
        m36941b(th);
    }

    /* renamed from: b */
    private static <T extends Throwable> void m36941b(Throwable th) throws Throwable {
        throw th;
    }

    /* renamed from: a */
    public static boolean m36940a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
