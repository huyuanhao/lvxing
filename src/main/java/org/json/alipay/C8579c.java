package org.json.alipay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* renamed from: org.json.alipay.c */
public final class C8579c {
    /* renamed from: a */
    private int f29205a;
    /* renamed from: b */
    private Reader f29206b;
    /* renamed from: c */
    private char f29207c;
    /* renamed from: d */
    private boolean f29208d;

    private C8579c(Reader reader) {
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader);
        }
        this.f29206b = reader;
        this.f29208d = false;
        this.f29205a = 0;
    }

    public C8579c(String str) {
        this((Reader) new StringReader(str));
    }

    /* renamed from: a */
    private String m37307a(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.f29208d) {
            this.f29208d = false;
            cArr[0] = this.f29207c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.f29206b.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (IOException e) {
                throw new JSONException((Throwable) e);
            }
        }
        this.f29205a += i2;
        if (i2 >= i) {
            this.f29207c = cArr[i - 1];
            return new String(cArr);
        }
        throw mo41015a("Substring bounds error");
    }

    /* renamed from: a */
    public final JSONException mo41015a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(toString());
        return new JSONException(sb.toString());
    }

    /* renamed from: a */
    public final void mo41016a() {
        if (!this.f29208d) {
            int i = this.f29205a;
            if (i > 0) {
                this.f29205a = i - 1;
                this.f29208d = true;
                return;
            }
        }
        throw new JSONException("Stepping back two steps is not supported");
    }

    /* renamed from: b */
    public final char mo41017b() {
        if (this.f29208d) {
            this.f29208d = false;
            if (this.f29207c != 0) {
                this.f29205a++;
            }
            return this.f29207c;
        }
        try {
            int read = this.f29206b.read();
            if (read <= 0) {
                this.f29207c = 0;
                return 0;
            }
            this.f29205a++;
            this.f29207c = (char) read;
            return this.f29207c;
        } catch (IOException e) {
            throw new JSONException((Throwable) e);
        }
    }

    /* renamed from: c */
    public final char mo41018c() {
        char b;
        while (true) {
            b = mo41017b();
            if (b == '/') {
                char b2 = mo41017b();
                if (b2 != '*') {
                    if (b2 == '/') {
                        while (true) {
                            char b3 = mo41017b();
                            if (b3 != 10 && b3 != 13) {
                                if (b3 == 0) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } else {
                        mo41016a();
                        return '/';
                    }
                } else {
                    while (true) {
                        char b4 = mo41017b();
                        if (b4 != 0) {
                            if (b4 == '*') {
                                if (mo41017b() == '/') {
                                    break;
                                }
                                mo41016a();
                            }
                        } else {
                            throw mo41015a("Unclosed comment");
                        }
                    }
                }
            } else if (b == '#') {
                while (true) {
                    char b5 = mo41017b();
                    if (b5 != 10 && b5 != 13) {
                        if (b5 == 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (b == 0 || b > ' ') {
                return b;
            }
        }
        return b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:56|57|58) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:42|(2:51|52)(3:48|49|50))|53|54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bd, code lost:
            return new java.lang.Long(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c3, code lost:
            return new java.lang.Double(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c4, code lost:
            return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00b2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00b8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00be */
    /* renamed from: d */
    public final java.lang.Object mo41019d() {
        /*
        r10 = this;
        char r0 = r10.mo41018c()
        r1 = 34
        r2 = 8
        r3 = 120(0x78, float:1.68E-43)
        r4 = 2
        r5 = 16
        if (r0 == r1) goto L_0x00de
        r1 = 91
        if (r0 == r1) goto L_0x00d5
        r1 = 123(0x7b, float:1.72E-43)
        if (r0 == r1) goto L_0x00cc
        r1 = 39
        if (r0 == r1) goto L_0x00de
        r1 = 40
        if (r0 == r1) goto L_0x00d5
        java.lang.StringBuffer r1 = new java.lang.StringBuffer
        r1.<init>()
        r6 = r0
    L_0x0025:
        r7 = 32
        if (r6 < r7) goto L_0x0039
        java.lang.String r7 = ",:]}/\\\"[{;=#"
        int r7 = r7.indexOf(r6)
        if (r7 >= 0) goto L_0x0039
        r1.append(r6)
        char r6 = r10.mo41017b()
        goto L_0x0025
    L_0x0039:
        r10.mo41016a()
        java.lang.String r1 = r1.toString()
        java.lang.String r1 = r1.trim()
        java.lang.String r6 = ""
        boolean r6 = r1.equals(r6)
        if (r6 != 0) goto L_0x00c5
        java.lang.String r6 = "true"
        boolean r6 = r1.equalsIgnoreCase(r6)
        if (r6 == 0) goto L_0x0057
        java.lang.Boolean r0 = java.lang.Boolean.TRUE
        return r0
    L_0x0057:
        java.lang.String r6 = "false"
        boolean r6 = r1.equalsIgnoreCase(r6)
        if (r6 == 0) goto L_0x0062
        java.lang.Boolean r0 = java.lang.Boolean.FALSE
        return r0
    L_0x0062:
        java.lang.String r6 = "null"
        boolean r6 = r1.equalsIgnoreCase(r6)
        if (r6 == 0) goto L_0x006d
        java.lang.Object r0 = org.json.alipay.C8577b.f29203a
        return r0
    L_0x006d:
        r6 = 48
        if (r0 < r6) goto L_0x0075
        r7 = 57
        if (r0 <= r7) goto L_0x0083
    L_0x0075:
        r7 = 46
        if (r0 == r7) goto L_0x0083
        r7 = 45
        if (r0 == r7) goto L_0x0083
        r7 = 43
        if (r0 != r7) goto L_0x0082
        goto L_0x0083
    L_0x0082:
        return r1
    L_0x0083:
        if (r0 != r6) goto L_0x00b2
        int r0 = r1.length()
        if (r0 <= r4) goto L_0x00a8
        r0 = 1
        char r6 = r1.charAt(r0)
        if (r6 == r3) goto L_0x009a
        char r0 = r1.charAt(r0)
        r3 = 88
        if (r0 != r3) goto L_0x00a8
    L_0x009a:
        java.lang.Integer r0 = new java.lang.Integer     // Catch:{ Exception -> 0x00b2 }
        java.lang.String r2 = r1.substring(r4)     // Catch:{ Exception -> 0x00b2 }
        int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ Exception -> 0x00b2 }
        r0.<init>(r2)     // Catch:{ Exception -> 0x00b2 }
        return r0
    L_0x00a8:
        java.lang.Integer r0 = new java.lang.Integer     // Catch:{ Exception -> 0x00b2 }
        int r2 = java.lang.Integer.parseInt(r1, r2)     // Catch:{ Exception -> 0x00b2 }
        r0.<init>(r2)     // Catch:{ Exception -> 0x00b2 }
        return r0
    L_0x00b2:
        java.lang.Integer r0 = new java.lang.Integer     // Catch:{ Exception -> 0x00b8 }
        r0.<init>(r1)     // Catch:{ Exception -> 0x00b8 }
        return r0
    L_0x00b8:
        java.lang.Long r0 = new java.lang.Long     // Catch:{ Exception -> 0x00be }
        r0.<init>(r1)     // Catch:{ Exception -> 0x00be }
        return r0
    L_0x00be:
        java.lang.Double r0 = new java.lang.Double     // Catch:{ Exception -> 0x00c4 }
        r0.<init>(r1)     // Catch:{ Exception -> 0x00c4 }
        return r0
    L_0x00c4:
        return r1
    L_0x00c5:
        java.lang.String r0 = "Missing value"
        org.json.alipay.JSONException r0 = r10.mo41015a(r0)
        throw r0
    L_0x00cc:
        r10.mo41016a()
        org.json.alipay.b r0 = new org.json.alipay.b
        r0.m55739init(r10)
        return r0
    L_0x00d5:
        r10.mo41016a()
        org.json.alipay.a r0 = new org.json.alipay.a
        r0.m55734init(r10)
        return r0
    L_0x00de:
        java.lang.StringBuffer r1 = new java.lang.StringBuffer
        r1.<init>()
    L_0x00e3:
        char r6 = r10.mo41017b()
        if (r6 == 0) goto L_0x0141
        r7 = 10
        if (r6 == r7) goto L_0x0141
        r8 = 13
        if (r6 == r8) goto L_0x0141
        r9 = 92
        if (r6 == r9) goto L_0x0100
        if (r6 != r0) goto L_0x00fc
        java.lang.String r0 = r1.toString()
        return r0
    L_0x00fc:
        r1.append(r6)
        goto L_0x00e3
    L_0x0100:
        char r6 = r10.mo41017b()
        r9 = 98
        if (r6 == r9) goto L_0x013d
        r9 = 102(0x66, float:1.43E-43)
        if (r6 == r9) goto L_0x013a
        r9 = 110(0x6e, float:1.54E-43)
        if (r6 == r9) goto L_0x0136
        r7 = 114(0x72, float:1.6E-43)
        if (r6 == r7) goto L_0x0132
        if (r6 == r3) goto L_0x012d
        r7 = 116(0x74, float:1.63E-43)
        if (r6 == r7) goto L_0x012a
        r7 = 117(0x75, float:1.64E-43)
        if (r6 == r7) goto L_0x011f
        goto L_0x00fc
    L_0x011f:
        r6 = 4
        java.lang.String r6 = r10.m37307a(r6)
    L_0x0124:
        int r6 = java.lang.Integer.parseInt(r6, r5)
        char r6 = (char) r6
        goto L_0x00fc
    L_0x012a:
        r6 = 9
        goto L_0x00fc
    L_0x012d:
        java.lang.String r6 = r10.m37307a(r4)
        goto L_0x0124
    L_0x0132:
        r1.append(r8)
        goto L_0x00e3
    L_0x0136:
        r1.append(r7)
        goto L_0x00e3
    L_0x013a:
        r6 = 12
        goto L_0x00fc
    L_0x013d:
        r1.append(r2)
        goto L_0x00e3
    L_0x0141:
        java.lang.String r0 = "Unterminated string"
        org.json.alipay.JSONException r0 = r10.mo41015a(r0)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.C8579c.mo41019d():java.lang.Object");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" at character ");
        sb.append(this.f29205a);
        return sb.toString();
    }
}
