package com.bytedance.sdk.p145a.p146a;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* renamed from: com.bytedance.sdk.a.a.f */
public class ByteString implements Serializable, Comparable<ByteString> {
    /* renamed from: a */
    static final char[] f5245a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: b */
    public static final ByteString f5246b = m6703a(new byte[0]);
    /* renamed from: c */
    final byte[] f5247c;
    /* renamed from: d */
    transient int f5248d;
    /* renamed from: e */
    transient String f5249e;

    ByteString(byte[] bArr) {
        this.f5247c = bArr;
    }

    /* renamed from: a */
    public static ByteString m6703a(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: a */
    public static ByteString m6702a(String str) {
        if (str != null) {
            ByteString fVar = new ByteString(str.getBytes(C1868u.f5290a));
            fVar.f5249e = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: a */
    public String mo13587a() {
        String str = this.f5249e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f5247c, C1868u.f5290a);
        this.f5249e = str2;
        return str2;
    }

    /* renamed from: b */
    public String mo13593b() {
        return C1861b.m6611a(this.f5247c);
    }

    /* renamed from: c */
    public ByteString mo13594c() {
        return m6705c("SHA-1");
    }

    /* renamed from: d */
    public ByteString mo13596d() {
        return m6705c("SHA-256");
    }

    /* renamed from: c */
    private ByteString m6705c(String str) {
        try {
            return m6703a(MessageDigest.getInstance(str).digest(this.f5247c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: e */
    public String mo13597e() {
        byte[] bArr = this.f5247c;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f5245a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static ByteString m6704b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((m6700a(str.charAt(i2)) << 4) + m6700a(str.charAt(i2 + 1)));
            }
            return m6703a(bArr);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected hex string: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private static int m6700a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected hex digit: ");
                sb.append(c);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: f */
    public ByteString mo13599f() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f5247c;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    /* renamed from: a */
    public ByteString mo13586a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f5247c;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f5247c, i, bArr2, 0, i3);
                    return new ByteString(bArr2);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("endIndex > length(");
                sb.append(this.f5247c.length);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* renamed from: a */
    public byte mo13585a(int i) {
        return this.f5247c[i];
    }

    /* renamed from: g */
    public int mo13600g() {
        return this.f5247c.length;
    }

    /* renamed from: h */
    public byte[] mo13601h() {
        return (byte[]) this.f5247c.clone();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13588a(Buffer cVar) {
        byte[] bArr = this.f5247c;
        cVar.mo13538c(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo13589a(int i, ByteString fVar, int i2, int i3) {
        return fVar.mo13590a(i2, this.f5247c, i, i3);
    }

    /* renamed from: a */
    public boolean mo13590a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f5247c;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C1868u.m6836a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo13591a(ByteString fVar) {
        return mo13589a(0, fVar, 0, fVar.mo13600g());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
            if (r6.mo13590a(0, r3, 0, r3.length) != false) goto L_0x001d;
     */
    public boolean equals(java.lang.Object r6) {
        /*
        r5 = this;
        r0 = 1
        if (r6 != r5) goto L_0x0004
        return r0
    L_0x0004:
        boolean r1 = r6 instanceof com.bytedance.sdk.p145a.p146a.ByteString
        r2 = 0
        if (r1 == 0) goto L_0x001c
        com.bytedance.sdk.a.a.f r6 = (com.bytedance.sdk.p145a.p146a.ByteString) r6
        int r1 = r6.mo13600g()
        byte[] r3 = r5.f5247c
        int r4 = r3.length
        if (r1 != r4) goto L_0x001c
        int r1 = r3.length
        boolean r6 = r6.mo13590a(r2, r3, r2, r1)
        if (r6 == 0) goto L_0x001c
        goto L_0x001d
    L_0x001c:
        r0 = 0
    L_0x001d:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p146a.ByteString.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = this.f5248d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f5247c);
        this.f5248d = hashCode;
        return hashCode;
    }

    /* renamed from: b */
    public int compareTo(ByteString fVar) {
        int g = mo13600g();
        int g2 = fVar.mo13600g();
        int min = Math.min(g, g2);
        int i = 0;
        while (true) {
            int i2 = -1;
            if (i < min) {
                byte a = mo13585a(i) & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                byte a2 = fVar.mo13585a(i) & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (a == a2) {
                    i++;
                } else {
                    if (a >= a2) {
                        i2 = 1;
                    }
                    return i2;
                }
            } else if (g == g2) {
                return 0;
            } else {
                if (g >= g2) {
                    i2 = 1;
                }
                return i2;
            }
        }
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (this.f5247c.length == 0) {
            return "[size=0]";
        }
        String a = mo13587a();
        int a2 = m6701a(a, 64);
        String str2 = "…]";
        String str3 = "[size=";
        String str4 = "]";
        if (a2 == -1) {
            if (this.f5247c.length <= 64) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[hex=");
                sb2.append(mo13597e());
                sb2.append(str4);
                str = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(this.f5247c.length);
                sb3.append(" hex=");
                sb3.append(mo13586a(0, 64).mo13597e());
                sb3.append(str2);
                str = sb3.toString();
            }
            return str;
        }
        String replace = a.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a2 < a.length()) {
            sb = new StringBuilder();
            sb.append(str3);
            sb.append(this.f5247c.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append(str2);
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append(str4);
        }
        return sb.toString();
    }

    /* renamed from: a */
    static int m6701a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
