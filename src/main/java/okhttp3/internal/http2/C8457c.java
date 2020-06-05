package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.C8417c;
import okio.ByteString;

/* compiled from: Http2 */
/* renamed from: okhttp3.internal.http2.c */
public final class C8457c {
    /* renamed from: a */
    static final ByteString f28681a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    /* renamed from: b */
    static final String[] f28682b = new String[64];
    /* renamed from: c */
    static final String[] f28683c = new String[256];
    /* renamed from: d */
    private static final String[] f28684d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        String str;
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f28683c;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = C8417c.m36030a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f28682b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr2 = {1};
        strArr2[8] = "PADDED";
        int length = iArr2.length;
        int i3 = 0;
        while (true) {
            str = "|PADDED";
            if (i3 >= length) {
                break;
            }
            int i4 = iArr2[i3];
            String[] strArr3 = f28682b;
            int i5 = i4 | 8;
            StringBuilder sb = new StringBuilder();
            sb.append(f28682b[i4]);
            sb.append(str);
            strArr3[i5] = sb.toString();
            i3++;
        }
        String[] strArr4 = f28682b;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        for (int i6 : new int[]{4, 32, 36}) {
            for (int i7 : iArr2) {
                String[] strArr5 = f28682b;
                int i8 = i7 | i6;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f28682b[i7]);
                sb2.append('|');
                sb2.append(f28682b[i6]);
                strArr5[i8] = sb2.toString();
                String[] strArr6 = f28682b;
                int i9 = i8 | 8;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(f28682b[i7]);
                sb3.append('|');
                sb3.append(f28682b[i6]);
                sb3.append(str);
                strArr6[i9] = sb3.toString();
            }
        }
        while (true) {
            String[] strArr7 = f28682b;
            if (i < strArr7.length) {
                if (strArr7[i] == null) {
                    strArr7[i] = f28683c[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private C8457c() {
    }

    /* renamed from: a */
    static IllegalArgumentException m36252a(String str, Object... objArr) {
        throw new IllegalArgumentException(C8417c.m36030a(str, objArr));
    }

    /* renamed from: b */
    static IOException m36255b(String str, Object... objArr) throws IOException {
        throw new IOException(C8417c.m36030a(str, objArr));
    }

    /* renamed from: a */
    static String m36254a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f28684d;
        String a = b < strArr.length ? strArr[b] : C8417c.m36030a("0x%02x", Byte.valueOf(b));
        String a2 = m36253a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a;
        objArr[4] = a2;
        return C8417c.m36030a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    static String m36253a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (!(b == 2 || b == 3)) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : f28683c[b2];
            } else if (!(b == 7 || b == 8)) {
                String[] strArr = f28682b;
                String str = b2 < strArr.length ? strArr[b2] : f28683c[b2];
                if (b == 5 && (b2 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b != 0 || (b2 & 32) == 0) {
                    return str;
                }
                return str.replace("PRIORITY", "COMPRESSED");
            }
        }
        return f28683c[b2];
    }
}
