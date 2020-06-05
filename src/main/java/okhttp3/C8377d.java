package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheControl */
/* renamed from: okhttp3.d */
public final class C8377d {
    /* renamed from: a */
    public static final C8377d f28285a = new C8378a().mo40169a().mo40172c();
    /* renamed from: b */
    public static final C8377d f28286b = new C8378a().mo40171b().mo40170a(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS).mo40172c();
    @Nullable
    /* renamed from: c */
    String f28287c;
    /* renamed from: d */
    private final boolean f28288d;
    /* renamed from: e */
    private final boolean f28289e;
    /* renamed from: f */
    private final int f28290f;
    /* renamed from: g */
    private final int f28291g;
    /* renamed from: h */
    private final boolean f28292h;
    /* renamed from: i */
    private final boolean f28293i;
    /* renamed from: j */
    private final boolean f28294j;
    /* renamed from: k */
    private final int f28295k;
    /* renamed from: l */
    private final int f28296l;
    /* renamed from: m */
    private final boolean f28297m;
    /* renamed from: n */
    private final boolean f28298n;
    /* renamed from: o */
    private final boolean f28299o;

    /* compiled from: CacheControl */
    /* renamed from: okhttp3.d$a */
    public static final class C8378a {
        /* renamed from: a */
        boolean f28300a;
        /* renamed from: b */
        boolean f28301b;
        /* renamed from: c */
        int f28302c = -1;
        /* renamed from: d */
        int f28303d = -1;
        /* renamed from: e */
        int f28304e = -1;
        /* renamed from: f */
        boolean f28305f;
        /* renamed from: g */
        boolean f28306g;
        /* renamed from: h */
        boolean f28307h;

        /* renamed from: a */
        public C8378a mo40169a() {
            this.f28300a = true;
            return this;
        }

        /* renamed from: a */
        public C8378a mo40170a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f28303d = seconds > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("maxStale < 0: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: b */
        public C8378a mo40171b() {
            this.f28305f = true;
            return this;
        }

        /* renamed from: c */
        public C8377d mo40172c() {
            return new C8377d(this);
        }
    }

    private C8377d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f28288d = z;
        this.f28289e = z2;
        this.f28290f = i;
        this.f28291g = i2;
        this.f28292h = z3;
        this.f28293i = z4;
        this.f28294j = z5;
        this.f28295k = i3;
        this.f28296l = i4;
        this.f28297m = z6;
        this.f28298n = z7;
        this.f28299o = z8;
        this.f28287c = str;
    }

    C8377d(C8378a aVar) {
        this.f28288d = aVar.f28300a;
        this.f28289e = aVar.f28301b;
        this.f28290f = aVar.f28302c;
        this.f28291g = -1;
        this.f28292h = false;
        this.f28293i = false;
        this.f28294j = false;
        this.f28295k = aVar.f28303d;
        this.f28296l = aVar.f28304e;
        this.f28297m = aVar.f28305f;
        this.f28298n = aVar.f28306g;
        this.f28299o = aVar.f28307h;
    }

    /* renamed from: a */
    public boolean mo40158a() {
        return this.f28288d;
    }

    /* renamed from: b */
    public boolean mo40159b() {
        return this.f28289e;
    }

    /* renamed from: c */
    public int mo40160c() {
        return this.f28290f;
    }

    /* renamed from: d */
    public boolean mo40161d() {
        return this.f28292h;
    }

    /* renamed from: e */
    public boolean mo40162e() {
        return this.f28293i;
    }

    /* renamed from: f */
    public boolean mo40163f() {
        return this.f28294j;
    }

    /* renamed from: g */
    public int mo40164g() {
        return this.f28295k;
    }

    /* renamed from: h */
    public int mo40165h() {
        return this.f28296l;
    }

    /* renamed from: i */
    public boolean mo40166i() {
        return this.f28297m;
    }

    /* renamed from: j */
    public boolean mo40167j() {
        return this.f28299o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* renamed from: a */
    public static okhttp3.C8377d m35861a(okhttp3.C8504s r22) {
        /*
        r0 = r22
        int r1 = r22.mo40531a()
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
        java.lang.String r2 = r0.mo40532a(r6)
        java.lang.String r4 = r0.mo40534b(r6)
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
        int r3 = okhttp3.internal.p698b.C8409e.m35976a(r4, r2, r3)
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
        int r0 = okhttp3.internal.p698b.C8409e.m35975a(r4, r3)
        int r3 = r4.length()
        if (r0 >= r3) goto L_0x0089
        char r3 = r4.charAt(r0)
        r5 = 34
        if (r3 != r5) goto L_0x0089
        int r0 = r0 + 1
        java.lang.String r3 = "\""
        int r3 = okhttp3.internal.p698b.C8409e.m35976a(r4, r0, r3)
        java.lang.String r0 = r4.substring(r0, r3)
        r5 = 1
        int r3 = r3 + r5
        goto L_0x009d
    L_0x0089:
        r5 = 1
        java.lang.String r3 = ",;"
        int r3 = okhttp3.internal.p698b.C8409e.m35976a(r4, r0, r3)
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
        int r0 = okhttp3.internal.p698b.C8409e.m35983b(r0, r5)
        r11 = r0
        goto L_0x013a
    L_0x00c5:
        java.lang.String r5 = "s-maxage"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x00d5
        r5 = -1
        int r0 = okhttp3.internal.p698b.C8409e.m35983b(r0, r5)
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
        int r0 = okhttp3.internal.p698b.C8409e.m35983b(r0, r2)
        r16 = r0
        r5 = -1
        goto L_0x013a
    L_0x0109:
        java.lang.String r5 = "min-fresh"
        boolean r5 = r5.equalsIgnoreCase(r2)
        if (r5 == 0) goto L_0x0119
        r5 = -1
        int r0 = okhttp3.internal.p698b.C8409e.m35983b(r0, r5)
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
        okhttp3.d r0 = new okhttp3.d
        r8 = r0
        r8.m55377init(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C8377d.m35861a(okhttp3.s):okhttp3.d");
    }

    public String toString() {
        String str = this.f28287c;
        if (str != null) {
            return str;
        }
        String k = m35862k();
        this.f28287c = k;
        return k;
    }

    /* renamed from: k */
    private String m35862k() {
        StringBuilder sb = new StringBuilder();
        if (this.f28288d) {
            sb.append("no-cache, ");
        }
        if (this.f28289e) {
            sb.append("no-store, ");
        }
        String str = ", ";
        if (this.f28290f != -1) {
            sb.append("max-age=");
            sb.append(this.f28290f);
            sb.append(str);
        }
        if (this.f28291g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f28291g);
            sb.append(str);
        }
        if (this.f28292h) {
            sb.append("private, ");
        }
        if (this.f28293i) {
            sb.append("public, ");
        }
        if (this.f28294j) {
            sb.append("must-revalidate, ");
        }
        if (this.f28295k != -1) {
            sb.append("max-stale=");
            sb.append(this.f28295k);
            sb.append(str);
        }
        if (this.f28296l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f28296l);
            sb.append(str);
        }
        if (this.f28297m) {
            sb.append("only-if-cached, ");
        }
        if (this.f28298n) {
            sb.append("no-transform, ");
        }
        if (this.f28299o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
