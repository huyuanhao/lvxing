package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import com.bytedance.sdk.p145a.p146a.ByteString;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.b.a.e.e */
public final class Http2 {
    /* renamed from: a */
    static final ByteString f5510a = ByteString.m6702a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    /* renamed from: b */
    static final String[] f5511b = new String[64];
    /* renamed from: c */
    static final String[] f5512c = new String[256];
    /* renamed from: d */
    private static final String[] f5513d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        String str;
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f5512c;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = C1876c.m6955a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f5511b;
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
            String[] strArr3 = f5511b;
            int i5 = i4 | 8;
            StringBuilder sb = new StringBuilder();
            sb.append(f5511b[i4]);
            sb.append(str);
            strArr3[i5] = sb.toString();
            i3++;
        }
        String[] strArr4 = f5511b;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        for (int i6 : new int[]{4, 32, 36}) {
            for (int i7 : iArr2) {
                String[] strArr5 = f5511b;
                int i8 = i7 | i6;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f5511b[i7]);
                sb2.append('|');
                sb2.append(f5511b[i6]);
                strArr5[i8] = sb2.toString();
                String[] strArr6 = f5511b;
                int i9 = i8 | 8;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(f5511b[i7]);
                sb3.append('|');
                sb3.append(f5511b[i6]);
                sb3.append(str);
                strArr6[i9] = sb3.toString();
            }
        }
        while (true) {
            String[] strArr7 = f5511b;
            if (i < strArr7.length) {
                if (strArr7[i] == null) {
                    strArr7[i] = f5512c[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private Http2() {
    }

    /* renamed from: a */
    static IllegalArgumentException m7085a(String str, Object... objArr) {
        throw new IllegalArgumentException(C1876c.m6955a(str, objArr));
    }

    /* renamed from: b */
    static IOException m7088b(String str, Object... objArr) throws IOException {
        throw new IOException(C1876c.m6955a(str, objArr));
    }

    /* renamed from: a */
    static String m7087a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f5513d;
        String a = b < strArr.length ? strArr[b] : C1876c.m6955a("0x%02x", Byte.valueOf(b));
        String a2 = m7086a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a;
        objArr[4] = a2;
        return C1876c.m6955a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    static String m7086a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (!(b == 2 || b == 3)) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : f5512c[b2];
            } else if (!(b == 7 || b == 8)) {
                String[] strArr = f5511b;
                String str = b2 < strArr.length ? strArr[b2] : f5512c[b2];
                if (b == 5 && (b2 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b != 0 || (b2 & 32) == 0) {
                    return str;
                }
                return str.replace("PRIORITY", "COMPRESSED");
            }
        }
        return f5512c[b2];
    }
}
