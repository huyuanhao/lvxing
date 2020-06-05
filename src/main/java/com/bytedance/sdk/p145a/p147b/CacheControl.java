package com.bytedance.sdk.p145a.p147b;

import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.b.g */
public final class CacheControl {
    /* renamed from: a */
    public static final CacheControl f5764a = new C1924a().mo13990a().mo13993c();
    /* renamed from: b */
    public static final CacheControl f5765b = new C1924a().mo13992b().mo13991a(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS).mo13993c();
    /* renamed from: c */
    String f5766c;
    /* renamed from: d */
    private final boolean f5767d;
    /* renamed from: e */
    private final boolean f5768e;
    /* renamed from: f */
    private final int f5769f;
    /* renamed from: g */
    private final int f5770g;
    /* renamed from: h */
    private final boolean f5771h;
    /* renamed from: i */
    private final boolean f5772i;
    /* renamed from: j */
    private final boolean f5773j;
    /* renamed from: k */
    private final int f5774k;
    /* renamed from: l */
    private final int f5775l;
    /* renamed from: m */
    private final boolean f5776m;
    /* renamed from: n */
    private final boolean f5777n;
    /* renamed from: o */
    private final boolean f5778o;

    /* compiled from: CacheControl */
    /* renamed from: com.bytedance.sdk.a.b.g$a */
    public static final class C1924a {
        /* renamed from: a */
        boolean f5779a;
        /* renamed from: b */
        boolean f5780b;
        /* renamed from: c */
        int f5781c = -1;
        /* renamed from: d */
        int f5782d = -1;
        /* renamed from: e */
        int f5783e = -1;
        /* renamed from: f */
        boolean f5784f;
        /* renamed from: g */
        boolean f5785g;
        /* renamed from: h */
        boolean f5786h;

        /* renamed from: a */
        public C1924a mo13990a() {
            this.f5779a = true;
            return this;
        }

        /* renamed from: a */
        public C1924a mo13991a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f5782d = seconds > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("maxStale < 0: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: b */
        public C1924a mo13992b() {
            this.f5784f = true;
            return this;
        }

        /* renamed from: c */
        public CacheControl mo13993c() {
            return new CacheControl(this);
        }
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f5767d = z;
        this.f5768e = z2;
        this.f5769f = i;
        this.f5770g = i2;
        this.f5771h = z3;
        this.f5772i = z4;
        this.f5773j = z5;
        this.f5774k = i3;
        this.f5775l = i4;
        this.f5776m = z6;
        this.f5777n = z7;
        this.f5778o = z8;
        this.f5766c = str;
    }

    CacheControl(C1924a aVar) {
        this.f5767d = aVar.f5779a;
        this.f5768e = aVar.f5780b;
        this.f5769f = aVar.f5781c;
        this.f5770g = -1;
        this.f5771h = false;
        this.f5772i = false;
        this.f5773j = false;
        this.f5774k = aVar.f5782d;
        this.f5775l = aVar.f5783e;
        this.f5776m = aVar.f5784f;
        this.f5777n = aVar.f5785g;
        this.f5778o = aVar.f5786h;
    }

    /* renamed from: a */
    public boolean mo13979a() {
        return this.f5767d;
    }

    /* renamed from: b */
    public boolean mo13980b() {
        return this.f5768e;
    }

    /* renamed from: c */
    public int mo13981c() {
        return this.f5769f;
    }

    /* renamed from: d */
    public boolean mo13982d() {
        return this.f5771h;
    }

    /* renamed from: e */
    public boolean mo13983e() {
        return this.f5772i;
    }

    /* renamed from: f */
    public boolean mo13984f() {
        return this.f5773j;
    }

    /* renamed from: g */
    public int mo13985g() {
        return this.f5774k;
    }

    /* renamed from: h */
    public int mo13986h() {
        return this.f5775l;
    }

    /* renamed from: i */
    public boolean mo13987i() {
        return this.f5776m;
    }

    /* renamed from: j */
    public boolean mo13988j() {
        return this.f5778o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* renamed from: a */
    public static com.bytedance.sdk.p145a.p147b.CacheControl m7420a(com.bytedance.sdk.p145a.p147b.C1935u r22) {
        /*
        r0 = r22
        int r1 = r22.mo14069a()
        r6 = 0
        r7 = 1
        r8 = 0
        r9 = 0
        r10 = 0
        r11 = -1
        r12 = -1
        r13 = 0
        r14 = 0
        r15 = 0
        r16 = -1
        r17 = -1
        r18 = 0
        r19 = 0
        r20 = 0
    L_0x001a:
        if (r6 >= r1) goto L_0x0146
        java.lang.String r2 = r0.mo14070a(r6)
        java.lang.String r4 = r0.mo14073b(r6)
        java.lang.String r3 = "Cache-Control"
        boolean r3 = r2.equalsIgnoreCase(r3)
        if (r3 == 0) goto L_0x0031
        if (r8 == 0) goto L_0x002f
        goto L_0x0039
    L_0x002f:
        r8 = r4
        goto L_0x003a
    L_0x0031:
        java.lang.String r3 = "Pragma"
        boolean r2 = r2.equalsIgnoreCase(r3)
        if (r2 == 0) goto L_0x013f
    L_0x0039:
        r7 = 0
    L_0x003a:
        r2 = 0
    L_0x003b:
        int r3 = r4.length()
        if (r2 >= r3) goto L_0x013f
        java.lang.String r3 = "=,;"
        int r3 = com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders.m6992a(r4, r2, r3)
        java.lang.String r2 = r4.substring(r2, r3)
        java.lang.String r2 = r2.trim()
        int r5 = r4.length()
        if (r3 == r5) goto L_0x0099
        char r5 = r4.charAt(r3)
        r0 = 44
        if (r5 == r0) goto L_0x0099
        char r0 = r4.charAt(r3)
        r5 = 59
        if (r0 != r5) goto L_0x0066
        goto L_0x0099
    L_0x0066:
        int r3 = r3 + 1
        int r0 = com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders.m6991a(r4, r3)
        int r3 = r4.length()
        if (r0 >= r3) goto L_0x0089
        char r3 = r4.charAt(r0)
        r5 = 34
        if (r3 != r5) goto L_0x0089
        int r0 = r0 + 1
        java.lang.String r3 = "\""
        int r3 = com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders.m6992a(r4, r0, r3)
        java.lang.String r0 = r4.substring(r0, r3)
        r5 = 1
        int r3 = r3 + r5
        goto L_0x009d
    L_0x0089:
        r5 = 1
        java.lang.String r3 = ",;"
        int r3 = com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders.m6992a(r4, r0, r3)
        java.lang.String r0 = r4.substring(r0, r3)
        java.lang.String r0 = r0.trim()
        goto L_0x009d
    L_0x0099:
        r5 = 1
        int r3 = r3 + 1
        r0 = 0
    L_0x009d:
        java.lang.String r5 = "no-cache"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x00a9
        r5 = -1
        r9 = 1
        goto L_0x013a
    L_0x00a9:
        java.lang.String r5 = "no-store"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x00b5
        r5 = -1
        r10 = 1
        goto L_0x013a
    L_0x00b5:
        java.lang.String r5 = "max-age"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x00c5
        r5 = -1
        int r0 = com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders.m6997b(r0, r5)
        r11 = r0
        goto L_0x013a
    L_0x00c5:
        java.lang.String r5 = "s-maxage"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x00d5
        r5 = -1
        int r0 = com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders.m6997b(r0, r5)
        r12 = r0
        goto L_0x013a
    L_0x00d5:
        java.lang.String r5 = "private"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x00e0
        r5 = -1
        r13 = 1
        goto L_0x013a
    L_0x00e0:
        java.lang.String r5 = "public"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x00eb
        r5 = -1
        r14 = 1
        goto L_0x013a
    L_0x00eb:
        java.lang.String r5 = "must-revalidate"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x00f6
        r5 = -1
        r15 = 1
        goto L_0x013a
    L_0x00f6:
        java.lang.String r5 = "max-stale"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x0109
        r2 = 2147483647(0x7fffffff, float:NaN)
        int r0 = com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders.m6997b(r0, r2)
        r16 = r0
        r5 = -1
        goto L_0x013a
    L_0x0109:
        java.lang.String r5 = "min-fresh"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x0119
        r5 = -1
        int r0 = com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders.m6997b(r0, r5)
        r17 = r0
        goto L_0x013a
    L_0x0119:
        r5 = -1
        java.lang.String r0 = "only-if-cached"
        boolean r0 = r0.equalsIgnoreCase(r2)
        if (r0 == 0) goto L_0x0125
        r18 = 1
        goto L_0x013a
    L_0x0125:
        java.lang.String r0 = "no-transform"
        boolean r0 = r0.equalsIgnoreCase(r2)
        if (r0 == 0) goto L_0x0130
        r19 = 1
        goto L_0x013a
    L_0x0130:
        java.lang.String r0 = "immutable"
        boolean r0 = r0.equalsIgnoreCase(r2)
        if (r0 == 0) goto L_0x013a
        r20 = 1
    L_0x013a:
        r0 = r22
        r2 = r3
        goto L_0x003b
    L_0x013f:
        r5 = -1
        int r6 = r6 + 1
        r0 = r22
        goto L_0x001a
    L_0x0146:
        if (r7 != 0) goto L_0x014b
        r21 = 0
        goto L_0x014d
    L_0x014b:
        r21 = r8
    L_0x014d:
        com.bytedance.sdk.a.b.g r0 = new com.bytedance.sdk.a.b.g
        r8 = r0
        r8.m43052init(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.CacheControl.m7420a(com.bytedance.sdk.a.b.u):com.bytedance.sdk.a.b.g");
    }

    public String toString() {
        String str = this.f5766c;
        if (str != null) {
            return str;
        }
        String k = m7421k();
        this.f5766c = k;
        return k;
    }

    /* renamed from: k */
    private String m7421k() {
        StringBuilder sb = new StringBuilder();
        if (this.f5767d) {
            sb.append("no-cache, ");
        }
        if (this.f5768e) {
            sb.append("no-store, ");
        }
        String str = ", ";
        if (this.f5769f != -1) {
            sb.append("max-age=");
            sb.append(this.f5769f);
            sb.append(str);
        }
        if (this.f5770g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f5770g);
            sb.append(str);
        }
        if (this.f5771h) {
            sb.append("private, ");
        }
        if (this.f5772i) {
            sb.append("public, ");
        }
        if (this.f5773j) {
            sb.append("must-revalidate, ");
        }
        if (this.f5774k != -1) {
            sb.append("max-stale=");
            sb.append(this.f5774k);
            sb.append(str);
        }
        if (this.f5775l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f5775l);
            sb.append(str);
        }
        if (this.f5776m) {
            sb.append("only-if-cached, ");
        }
        if (this.f5777n) {
            sb.append("no-transform, ");
        }
        if (this.f5778o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
