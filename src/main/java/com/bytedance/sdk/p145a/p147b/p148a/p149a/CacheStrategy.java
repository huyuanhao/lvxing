package com.bytedance.sdk.p145a.p147b.p148a.p149a;

import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.C1935u;
import com.bytedance.sdk.p145a.p147b.C1935u.C1936a;
import com.bytedance.sdk.p145a.p147b.CacheControl;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.Response.C1921a;
import com.bytedance.sdk.p145a.p147b.p148a.Internal;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpDate;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.b.a.a.c */
public final class CacheStrategy {
    /* renamed from: a */
    public final C1918ab f5309a;
    /* renamed from: b */
    public final Response f5310b;

    /* compiled from: CacheStrategy */
    /* renamed from: com.bytedance.sdk.a.b.a.a.c$a */
    public static class C1870a {
        /* renamed from: a */
        final long f5311a;
        /* renamed from: b */
        final C1918ab f5312b;
        /* renamed from: c */
        final Response f5313c;
        /* renamed from: d */
        private Date f5314d;
        /* renamed from: e */
        private String f5315e;
        /* renamed from: f */
        private Date f5316f;
        /* renamed from: g */
        private String f5317g;
        /* renamed from: h */
        private Date f5318h;
        /* renamed from: i */
        private long f5319i;
        /* renamed from: j */
        private long f5320j;
        /* renamed from: k */
        private String f5321k;
        /* renamed from: l */
        private int f5322l = -1;

        public C1870a(long j, C1918ab abVar, Response bVar) {
            this.f5311a = j;
            this.f5312b = abVar;
            this.f5313c = bVar;
            if (bVar != null) {
                this.f5319i = bVar.mo13950k();
                this.f5320j = bVar.mo13951l();
                C1935u f = bVar.mo13945f();
                int a = f.mo14069a();
                for (int i = 0; i < a; i++) {
                    String a2 = f.mo14070a(i);
                    String b = f.mo14073b(i);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f5314d = HttpDate.m6989a(b);
                        this.f5315e = b;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.f5318h = HttpDate.m6989a(b);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f5316f = HttpDate.m6989a(b);
                        this.f5317g = b;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.f5321k = b;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.f5322l = HttpHeaders.m6997b(b, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        public CacheStrategy mo13667a() {
            CacheStrategy b = m6871b();
            return (b.f5309a == null || !this.f5312b.mo13916f().mo13987i()) ? b : new CacheStrategy(null, null);
        }

        /* renamed from: b */
        private CacheStrategy m6871b() {
            if (this.f5313c == null) {
                return new CacheStrategy(this.f5312b, null);
            }
            if (this.f5312b.mo13917g() && this.f5313c.mo13944e() == null) {
                return new CacheStrategy(this.f5312b, null);
            }
            if (!CacheStrategy.m6869a(this.f5313c, this.f5312b)) {
                return new CacheStrategy(this.f5312b, null);
            }
            CacheControl f = this.f5312b.mo13916f();
            if (f.mo13979a() || m6870a(this.f5312b)) {
                return new CacheStrategy(this.f5312b, null);
            }
            CacheControl j = this.f5313c.mo13949j();
            if (j.mo13988j()) {
                return new CacheStrategy(null, this.f5313c);
            }
            long d = m6873d();
            long c = m6872c();
            if (f.mo13981c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis((long) f.mo13981c()));
            }
            long j2 = 0;
            long millis = f.mo13986h() != -1 ? TimeUnit.SECONDS.toMillis((long) f.mo13986h()) : 0;
            if (!j.mo13984f() && f.mo13985g() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) f.mo13985g());
            }
            if (!j.mo13979a()) {
                long j3 = millis + d;
                if (j3 < j2 + c) {
                    C1921a h = this.f5313c.mo13947h();
                    String str = "Warning";
                    if (j3 >= c) {
                        h.mo13962a(str, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d > 86400000 && m6874e()) {
                        h.mo13962a(str, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, h.mo13963a());
                }
            }
            String str2 = this.f5321k;
            String str3 = "If-Modified-Since";
            if (str2 != null) {
                str3 = "If-None-Match";
            } else if (this.f5316f != null) {
                str2 = this.f5317g;
            } else if (this.f5314d == null) {
                return new CacheStrategy(this.f5312b, null);
            } else {
                str2 = this.f5315e;
            }
            C1936a b = this.f5312b.mo13913c().mo14072b();
            Internal.f5302a.mo13661a(b, str3, str2);
            return new CacheStrategy(this.f5312b.mo13915e().mo13921a(b.mo14080a()).mo13933d(), this.f5313c);
        }

        /* renamed from: c */
        private long m6872c() {
            CacheControl j = this.f5313c.mo13949j();
            if (j.mo13981c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) j.mo13981c());
            }
            long j2 = 0;
            if (this.f5318h != null) {
                Date date = this.f5314d;
                long time = this.f5318h.getTime() - (date != null ? date.getTime() : this.f5320j);
                if (time > 0) {
                    j2 = time;
                }
                return j2;
            }
            if (this.f5316f != null && this.f5313c.mo13937a().mo13910a().mo14098k() == null) {
                Date date2 = this.f5314d;
                long time2 = (date2 != null ? date2.getTime() : this.f5319i) - this.f5316f.getTime();
                if (time2 > 0) {
                    j2 = time2 / 10;
                }
            }
            return j2;
        }

        /* renamed from: d */
        private long m6873d() {
            Date date = this.f5314d;
            long j = 0;
            if (date != null) {
                j = Math.max(0, this.f5320j - date.getTime());
            }
            if (this.f5322l != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.f5322l));
            }
            long j2 = this.f5320j;
            return j + (j2 - this.f5319i) + (this.f5311a - j2);
        }

        /* renamed from: e */
        private boolean m6874e() {
            return this.f5313c.mo13949j().mo13981c() == -1 && this.f5318h == null;
        }

        /* renamed from: a */
        private static boolean m6870a(C1918ab abVar) {
            return (abVar.mo13911a("If-Modified-Since") == null && abVar.mo13911a("If-None-Match") == null) ? false : true;
        }
    }

    CacheStrategy(C1918ab abVar, Response bVar) {
        this.f5309a = abVar;
        this.f5310b = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
            if (r3.mo13949j().mo13982d() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
            return false;
     */
    /* renamed from: a */
    public static boolean m6869a(com.bytedance.sdk.p145a.p147b.Response r3, com.bytedance.sdk.p145a.p147b.C1918ab r4) {
        /*
        int r0 = r3.mo13941c()
        r1 = 200(0xc8, float:2.8E-43)
        r2 = 0
        if (r0 == r1) goto L_0x005a
        r1 = 410(0x19a, float:5.75E-43)
        if (r0 == r1) goto L_0x005a
        r1 = 414(0x19e, float:5.8E-43)
        if (r0 == r1) goto L_0x005a
        r1 = 501(0x1f5, float:7.02E-43)
        if (r0 == r1) goto L_0x005a
        r1 = 203(0xcb, float:2.84E-43)
        if (r0 == r1) goto L_0x005a
        r1 = 204(0xcc, float:2.86E-43)
        if (r0 == r1) goto L_0x005a
        r1 = 307(0x133, float:4.3E-43)
        if (r0 == r1) goto L_0x0031
        r1 = 308(0x134, float:4.32E-43)
        if (r0 == r1) goto L_0x005a
        r1 = 404(0x194, float:5.66E-43)
        if (r0 == r1) goto L_0x005a
        r1 = 405(0x195, float:5.68E-43)
        if (r0 == r1) goto L_0x005a
        switch(r0) {
            case 300: goto L_0x005a;
            case 301: goto L_0x005a;
            case 302: goto L_0x0031;
            default: goto L_0x0030;
        }
    L_0x0030:
        goto L_0x0059
    L_0x0031:
        java.lang.String r0 = "Expires"
        java.lang.String r0 = r3.mo13938a(r0)
        if (r0 != 0) goto L_0x005a
        com.bytedance.sdk.a.b.g r0 = r3.mo13949j()
        int r0 = r0.mo13981c()
        r1 = -1
        if (r0 != r1) goto L_0x005a
        com.bytedance.sdk.a.b.g r0 = r3.mo13949j()
        boolean r0 = r0.mo13983e()
        if (r0 != 0) goto L_0x005a
        com.bytedance.sdk.a.b.g r0 = r3.mo13949j()
        boolean r0 = r0.mo13982d()
        if (r0 == 0) goto L_0x0059
        goto L_0x005a
    L_0x0059:
        return r2
    L_0x005a:
        com.bytedance.sdk.a.b.g r3 = r3.mo13949j()
        boolean r3 = r3.mo13980b()
        if (r3 != 0) goto L_0x006f
        com.bytedance.sdk.a.b.g r3 = r4.mo13916f()
        boolean r3 = r3.mo13980b()
        if (r3 != 0) goto L_0x006f
        r2 = 1
    L_0x006f:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p149a.CacheStrategy.m6869a(com.bytedance.sdk.a.b.b, com.bytedance.sdk.a.b.ab):boolean");
    }
}
