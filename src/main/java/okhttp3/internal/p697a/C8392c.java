package okhttp3.internal.p697a;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C8362ab;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8377d;
import okhttp3.C8504s;
import okhttp3.C8504s.C8505a;
import okhttp3.C8518z;
import okhttp3.internal.C8388a;
import okhttp3.internal.p698b.C8407d;
import okhttp3.internal.p698b.C8409e;

/* compiled from: CacheStrategy */
/* renamed from: okhttp3.internal.a.c */
public final class C8392c {
    @Nullable
    /* renamed from: a */
    public final C8518z f28439a;
    @Nullable
    /* renamed from: b */
    public final C8362ab f28440b;

    /* compiled from: CacheStrategy */
    /* renamed from: okhttp3.internal.a.c$a */
    public static class C8393a {
        /* renamed from: a */
        final long f28441a;
        /* renamed from: b */
        final C8518z f28442b;
        /* renamed from: c */
        final C8362ab f28443c;
        /* renamed from: d */
        private Date f28444d;
        /* renamed from: e */
        private String f28445e;
        /* renamed from: f */
        private Date f28446f;
        /* renamed from: g */
        private String f28447g;
        /* renamed from: h */
        private Date f28448h;
        /* renamed from: i */
        private long f28449i;
        /* renamed from: j */
        private long f28450j;
        /* renamed from: k */
        private String f28451k;
        /* renamed from: l */
        private int f28452l = -1;

        public C8393a(long j, C8518z zVar, C8362ab abVar) {
            this.f28441a = j;
            this.f28442b = zVar;
            this.f28443c = abVar;
            if (abVar != null) {
                this.f28449i = abVar.mo40102m();
                this.f28450j = abVar.mo40103n();
                C8504s g = abVar.mo40096g();
                int a = g.mo40531a();
                for (int i = 0; i < a; i++) {
                    String a2 = g.mo40532a(i);
                    String b = g.mo40534b(i);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f28444d = C8407d.m35973a(b);
                        this.f28445e = b;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.f28448h = C8407d.m35973a(b);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f28446f = C8407d.m35973a(b);
                        this.f28447g = b;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.f28451k = b;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.f28452l = C8409e.m35983b(b, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        public C8392c mo40204a() {
            C8392c b = m35918b();
            return (b.f28439a == null || !this.f28442b.mo40651f().mo40166i()) ? b : new C8392c(null, null);
        }

        /* renamed from: b */
        private C8392c m35918b() {
            if (this.f28443c == null) {
                return new C8392c(this.f28442b, null);
            }
            if (this.f28442b.mo40652g() && this.f28443c.mo40095f() == null) {
                return new C8392c(this.f28442b, null);
            }
            if (!C8392c.m35916a(this.f28443c, this.f28442b)) {
                return new C8392c(this.f28442b, null);
            }
            C8377d f = this.f28442b.mo40651f();
            if (f.mo40158a() || m35917a(this.f28442b)) {
                return new C8392c(this.f28442b, null);
            }
            C8377d l = this.f28443c.mo40101l();
            if (l.mo40167j()) {
                return new C8392c(null, this.f28443c);
            }
            long d = m35920d();
            long c = m35919c();
            if (f.mo40160c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis((long) f.mo40160c()));
            }
            long j = 0;
            long millis = f.mo40165h() != -1 ? TimeUnit.SECONDS.toMillis((long) f.mo40165h()) : 0;
            if (!l.mo40163f() && f.mo40164g() != -1) {
                j = TimeUnit.SECONDS.toMillis((long) f.mo40164g());
            }
            if (!l.mo40158a()) {
                long j2 = millis + d;
                if (j2 < j + c) {
                    C8363a i = this.f28443c.mo40098i();
                    String str = "Warning";
                    if (j2 >= c) {
                        i.mo40117b(str, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d > 86400000 && m35921e()) {
                        i.mo40117b(str, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new C8392c(null, i.mo40115a());
                }
            }
            String str2 = this.f28451k;
            String str3 = "If-Modified-Since";
            if (str2 != null) {
                str3 = "If-None-Match";
            } else if (this.f28446f != null) {
                str2 = this.f28447g;
            } else if (this.f28444d == null) {
                return new C8392c(this.f28442b, null);
            } else {
                str2 = this.f28445e;
            }
            C8505a b = this.f28442b.mo40648c().mo40536b();
            C8388a.f28432a.mo40198a(b, str3, str2);
            return new C8392c(this.f28442b.mo40650e().mo40659a(b.mo40543a()).mo40663b(), this.f28443c);
        }

        /* renamed from: c */
        private long m35919c() {
            long j;
            long j2;
            C8377d l = this.f28443c.mo40101l();
            if (l.mo40160c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) l.mo40160c());
            }
            long j3 = 0;
            if (this.f28448h != null) {
                Date date = this.f28444d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.f28450j;
                }
                long time = this.f28448h.getTime() - j2;
                if (time > 0) {
                    j3 = time;
                }
                return j3;
            }
            if (this.f28446f != null && this.f28443c.mo40088a().mo40645a().mo40564m() == null) {
                Date date2 = this.f28444d;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.f28449i;
                }
                long time2 = j - this.f28446f.getTime();
                if (time2 > 0) {
                    j3 = time2 / 10;
                }
            }
            return j3;
        }

        /* renamed from: d */
        private long m35920d() {
            Date date = this.f28444d;
            long j = 0;
            if (date != null) {
                j = Math.max(0, this.f28450j - date.getTime());
            }
            if (this.f28452l != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.f28452l));
            }
            long j2 = this.f28450j;
            return j + (j2 - this.f28449i) + (this.f28441a - j2);
        }

        /* renamed from: e */
        private boolean m35921e() {
            return this.f28443c.mo40101l().mo40160c() == -1 && this.f28448h == null;
        }

        /* renamed from: a */
        private static boolean m35917a(C8518z zVar) {
            return (zVar.mo40644a("If-Modified-Since") == null && zVar.mo40644a("If-None-Match") == null) ? false : true;
        }
    }

    C8392c(C8518z zVar, C8362ab abVar) {
        this.f28439a = zVar;
        this.f28440b = abVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
            if (r3.mo40101l().mo40161d() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
            return false;
     */
    /* renamed from: a */
    public static boolean m35916a(okhttp3.C8362ab r3, okhttp3.C8518z r4) {
        /*
        int r0 = r3.mo40091c()
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
        java.lang.String r0 = r3.mo40089b(r0)
        if (r0 != 0) goto L_0x005a
        okhttp3.d r0 = r3.mo40101l()
        int r0 = r0.mo40160c()
        r1 = -1
        if (r0 != r1) goto L_0x005a
        okhttp3.d r0 = r3.mo40101l()
        boolean r0 = r0.mo40162e()
        if (r0 != 0) goto L_0x005a
        okhttp3.d r0 = r3.mo40101l()
        boolean r0 = r0.mo40161d()
        if (r0 == 0) goto L_0x0059
        goto L_0x005a
    L_0x0059:
        return r2
    L_0x005a:
        okhttp3.d r3 = r3.mo40101l()
        boolean r3 = r3.mo40159b()
        if (r3 != 0) goto L_0x006f
        okhttp3.d r3 = r4.mo40651f()
        boolean r3 = r3.mo40159b()
        if (r3 != 0) goto L_0x006f
        r2 = 1
    L_0x006f:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p697a.C8392c.m35916a(okhttp3.ab, okhttp3.z):boolean");
    }
}
