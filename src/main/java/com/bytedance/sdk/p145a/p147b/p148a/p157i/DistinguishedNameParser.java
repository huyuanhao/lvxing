package com.bytedance.sdk.p145a.p147b.p148a.p157i;

import javax.security.auth.x500.X500Principal;

/* renamed from: com.bytedance.sdk.a.b.a.i.d */
final class DistinguishedNameParser {
    /* renamed from: a */
    private final String f5692a;
    /* renamed from: b */
    private final int f5693b = this.f5692a.length();
    /* renamed from: c */
    private int f5694c;
    /* renamed from: d */
    private int f5695d;
    /* renamed from: e */
    private int f5696e;
    /* renamed from: f */
    private int f5697f;
    /* renamed from: g */
    private char[] f5698g;

    DistinguishedNameParser(X500Principal x500Principal) {
        this.f5692a = x500Principal.getName("RFC2253");
    }

    /* renamed from: a */
    private String m7319a() {
        while (true) {
            int i = this.f5694c;
            if (i >= this.f5693b || this.f5698g[i] != ' ') {
                int i2 = this.f5694c;
            } else {
                this.f5694c = i + 1;
            }
        }
        int i22 = this.f5694c;
        if (i22 == this.f5693b) {
            return null;
        }
        this.f5695d = i22;
        this.f5694c = i22 + 1;
        while (true) {
            int i3 = this.f5694c;
            if (i3 >= this.f5693b) {
                break;
            }
            char[] cArr = this.f5698g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f5694c = i3 + 1;
        }
        int i4 = this.f5694c;
        String str = "Unexpected end of DN: ";
        if (i4 < this.f5693b) {
            this.f5696e = i4;
            if (this.f5698g[i4] == ' ') {
                while (true) {
                    int i5 = this.f5694c;
                    if (i5 >= this.f5693b) {
                        break;
                    }
                    char[] cArr2 = this.f5698g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f5694c = i5 + 1;
                }
                char[] cArr3 = this.f5698g;
                int i6 = this.f5694c;
                if (cArr3[i6] != '=' || i6 == this.f5693b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(this.f5692a);
                    throw new IllegalStateException(sb.toString());
                }
            }
            this.f5694c++;
            while (true) {
                int i7 = this.f5694c;
                if (i7 >= this.f5693b || this.f5698g[i7] != ' ') {
                    int i8 = this.f5696e;
                    int i9 = this.f5695d;
                } else {
                    this.f5694c = i7 + 1;
                }
            }
            int i82 = this.f5696e;
            int i92 = this.f5695d;
            if (i82 - i92 > 4) {
                char[] cArr4 = this.f5698g;
                if (cArr4[i92 + 3] == '.' && (cArr4[i92] == 'O' || cArr4[i92] == 'o')) {
                    char[] cArr5 = this.f5698g;
                    int i10 = this.f5695d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f5698g;
                        int i11 = this.f5695d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f5695d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f5698g;
            int i12 = this.f5695d;
            return new String(cArr7, i12, this.f5696e - i12);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.f5692a);
        throw new IllegalStateException(sb2.toString());
    }

    /* renamed from: b */
    private String m7320b() {
        this.f5694c++;
        this.f5695d = this.f5694c;
        this.f5696e = this.f5695d;
        while (true) {
            int i = this.f5694c;
            if (i != this.f5693b) {
                char[] cArr = this.f5698g;
                if (cArr[i] == '\"') {
                    this.f5694c = i + 1;
                    while (true) {
                        int i2 = this.f5694c;
                        if (i2 >= this.f5693b || this.f5698g[i2] != ' ') {
                            char[] cArr2 = this.f5698g;
                            int i3 = this.f5695d;
                        } else {
                            this.f5694c = i2 + 1;
                        }
                    }
                    char[] cArr22 = this.f5698g;
                    int i32 = this.f5695d;
                    return new String(cArr22, i32, this.f5696e - i32);
                }
                if (cArr[i] == '\\') {
                    cArr[this.f5696e] = m7323e();
                } else {
                    cArr[this.f5696e] = cArr[i];
                }
                this.f5694c++;
                this.f5696e++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected end of DN: ");
                sb.append(this.f5692a);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    /* renamed from: c */
    private String m7321c() {
        int i = this.f5694c;
        String str = "Unexpected end of DN: ";
        if (i + 4 < this.f5693b) {
            this.f5695d = i;
            this.f5694c = i + 1;
            while (true) {
                int i2 = this.f5694c;
                if (i2 == this.f5693b) {
                    break;
                }
                char[] cArr = this.f5698g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f5696e = i2;
                    this.f5694c = i2 + 1;
                    while (true) {
                        int i3 = this.f5694c;
                        if (i3 >= this.f5693b || this.f5698g[i3] != ' ') {
                            break;
                        }
                        this.f5694c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f5694c++;
                }
            }
            this.f5696e = this.f5694c;
            int i4 = this.f5696e;
            int i5 = this.f5695d;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(this.f5692a);
                throw new IllegalStateException(sb.toString());
            }
            byte[] bArr = new byte[(i6 / 2)];
            int i7 = i5 + 1;
            for (int i8 = 0; i8 < bArr.length; i8++) {
                bArr[i8] = (byte) m7318a(i7);
                i7 += 2;
            }
            return new String(this.f5698g, this.f5695d, i6);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.f5692a);
        throw new IllegalStateException(sb2.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
            r1 = r8.f5698g;
            r2 = r8.f5695d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
            return new java.lang.String(r1, r2, r8.f5697f - r2);
     */
    /* renamed from: d */
    private java.lang.String m7322d() {
        /*
        r8 = this;
        int r0 = r8.f5694c
        r8.f5695d = r0
        r8.f5696e = r0
    L_0x0006:
        int r0 = r8.f5694c
        int r1 = r8.f5693b
        if (r0 < r1) goto L_0x0019
        java.lang.String r0 = new java.lang.String
        char[] r1 = r8.f5698g
        int r2 = r8.f5695d
        int r3 = r8.f5696e
        int r3 = r3 - r2
        r0.<init>(r1, r2, r3)
        return r0
    L_0x0019:
        char[] r1 = r8.f5698g
        char r2 = r1[r0]
        r3 = 44
        r4 = 43
        r5 = 59
        r6 = 32
        if (r2 == r6) goto L_0x0060
        if (r2 == r5) goto L_0x0053
        r5 = 92
        if (r2 == r5) goto L_0x0040
        if (r2 == r4) goto L_0x0053
        if (r2 == r3) goto L_0x0053
        int r2 = r8.f5696e
        int r3 = r2 + 1
        r8.f5696e = r3
        char r3 = r1[r0]
        r1[r2] = r3
        int r0 = r0 + 1
        r8.f5694c = r0
        goto L_0x0006
    L_0x0040:
        int r0 = r8.f5696e
        int r2 = r0 + 1
        r8.f5696e = r2
        char r2 = r8.m7323e()
        r1[r0] = r2
        int r0 = r8.f5694c
        int r0 = r0 + 1
        r8.f5694c = r0
        goto L_0x0006
    L_0x0053:
        java.lang.String r0 = new java.lang.String
        char[] r1 = r8.f5698g
        int r2 = r8.f5695d
        int r3 = r8.f5696e
        int r3 = r3 - r2
        r0.<init>(r1, r2, r3)
        return r0
    L_0x0060:
        int r2 = r8.f5696e
        r8.f5697f = r2
        int r0 = r0 + 1
        r8.f5694c = r0
        int r0 = r2 + 1
        r8.f5696e = r0
        r1[r2] = r6
    L_0x006e:
        int r0 = r8.f5694c
        int r1 = r8.f5693b
        if (r0 >= r1) goto L_0x0087
        char[] r1 = r8.f5698g
        char r2 = r1[r0]
        if (r2 != r6) goto L_0x0087
        int r2 = r8.f5696e
        int r7 = r2 + 1
        r8.f5696e = r7
        r1[r2] = r6
        int r0 = r0 + 1
        r8.f5694c = r0
        goto L_0x006e
    L_0x0087:
        int r0 = r8.f5694c
        int r1 = r8.f5693b
        if (r0 == r1) goto L_0x009b
        char[] r1 = r8.f5698g
        char r2 = r1[r0]
        if (r2 == r3) goto L_0x009b
        char r2 = r1[r0]
        if (r2 == r4) goto L_0x009b
        char r0 = r1[r0]
        if (r0 != r5) goto L_0x0006
    L_0x009b:
        java.lang.String r0 = new java.lang.String
        char[] r1 = r8.f5698g
        int r2 = r8.f5695d
        int r3 = r8.f5697f
        int r3 = r3 - r2
        r0.<init>(r1, r2, r3)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p157i.DistinguishedNameParser.m7322d():java.lang.String");
    }

    /* renamed from: e */
    private char m7323e() {
        this.f5694c++;
        int i = this.f5694c;
        if (i != this.f5693b) {
            char c = this.f5698g[i];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#')) {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return m7324f();
                        }
                }
            }
            return this.f5698g[this.f5694c];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected end of DN: ");
        sb.append(this.f5692a);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: f */
    private char m7324f() {
        int i;
        int i2;
        int a = m7318a(this.f5694c);
        this.f5694c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i2 = a & 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f5694c++;
            int i4 = this.f5694c;
            if (i4 == this.f5693b || this.f5698g[i4] != '\\') {
                return '?';
            }
            this.f5694c = i4 + 1;
            int a2 = m7318a(this.f5694c);
            this.f5694c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: a */
    private int m7318a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        String str = "Malformed DN: ";
        if (i4 < this.f5693b) {
            char c = this.f5698g[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(this.f5692a);
                throw new IllegalStateException(sb.toString());
            } else {
                i2 = c - '7';
            }
            char c2 = this.f5698g[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f5692a);
                throw new IllegalStateException(sb2.toString());
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(this.f5692a);
        throw new IllegalStateException(sb3.toString());
    }

    /* renamed from: a */
    public String mo13898a(String str) {
        this.f5694c = 0;
        this.f5695d = 0;
        this.f5696e = 0;
        this.f5697f = 0;
        this.f5698g = this.f5692a.toCharArray();
        String a = m7319a();
        if (a == null) {
            return null;
        }
        while (true) {
            int i = this.f5694c;
            if (i == this.f5693b) {
                return null;
            }
            char c = this.f5698g[i];
            String str2 = c != '\"' ? c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : m7322d() : m7321c() : m7320b();
            if (str.equalsIgnoreCase(a)) {
                return str2;
            }
            int i2 = this.f5694c;
            if (i2 >= this.f5693b) {
                return null;
            }
            char[] cArr = this.f5698g;
            String str3 = "Malformed DN: ";
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.f5694c++;
                a = m7319a();
                if (a == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(this.f5692a);
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(this.f5692a);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
