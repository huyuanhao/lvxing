package okhttp3.internal.p697a;

import com.tencent.p605ep.commonbase.network.HttpStatus;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.C8362ab;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8364ac;
import okhttp3.C8504s;
import okhttp3.C8504s.C8505a;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8518z;
import okhttp3.Protocol;
import okhttp3.internal.C8388a;
import okhttp3.internal.C8417c;
import okhttp3.internal.p697a.C8392c.C8393a;
import okhttp3.internal.p698b.C8409e;
import okhttp3.internal.p698b.C8410f;
import okhttp3.internal.p698b.C8412h;
import okio.C8525c;
import okio.C8528d;
import okio.C8529e;
import okio.C8535k;
import okio.C8546q;
import okio.C8547r;
import okio.C8548s;

/* compiled from: CacheInterceptor */
/* renamed from: okhttp3.internal.a.a */
public final class C8389a implements C8508u {
    /* renamed from: a */
    final C8401f f28433a;

    public C8389a(C8401f fVar) {
        this.f28433a = fVar;
    }

    public C8362ab intercept(C8509a aVar) throws IOException {
        C8401f fVar = this.f28433a;
        C8362ab a = fVar != null ? fVar.mo40145a(aVar.mo40246a()) : null;
        C8392c a2 = new C8393a(System.currentTimeMillis(), aVar.mo40246a(), a).mo40204a();
        C8518z zVar = a2.f28439a;
        C8362ab abVar = a2.f28440b;
        C8401f fVar2 = this.f28433a;
        if (fVar2 != null) {
            fVar2.mo40149a(a2);
        }
        if (a != null && abVar == null) {
            C8417c.m36040a((Closeable) a.mo40097h());
        }
        if (zVar == null && abVar == null) {
            return new C8363a().mo40114a(aVar.mo40246a()).mo40109a(Protocol.HTTP_1_1).mo40105a((int) HttpStatus.SC_GATEWAY_TIMEOUT).mo40107a("Unsatisfiable Request (only-if-cached)").mo40111a(C8417c.f28530c).mo40106a(-1).mo40116b(System.currentTimeMillis()).mo40115a();
        }
        if (zVar == null) {
            return abVar.mo40098i().mo40118b(m35907a(abVar)).mo40115a();
        }
        try {
            C8362ab a3 = aVar.mo40244a(zVar);
            if (a3 == null && a != null) {
            }
            if (abVar != null) {
                if (a3.mo40091c() == 304) {
                    C8362ab a4 = abVar.mo40098i().mo40113a(m35909a(abVar.mo40096g(), a3.mo40096g())).mo40106a(a3.mo40102m()).mo40116b(a3.mo40103n()).mo40118b(m35907a(abVar)).mo40110a(m35907a(a3)).mo40115a();
                    a3.mo40097h().close();
                    this.f28433a.mo40147a();
                    this.f28433a.mo40148a(abVar, a4);
                    return a4;
                }
                C8417c.m36040a((Closeable) abVar.mo40097h());
            }
            C8362ab a5 = a3.mo40098i().mo40118b(m35907a(abVar)).mo40110a(m35907a(a3)).mo40115a();
            if (this.f28433a != null) {
                if (C8409e.m35988d(a5) && C8392c.m35916a(a5, zVar)) {
                    return m35908a(this.f28433a.mo40146a(a5), a5);
                }
                if (C8410f.m35990a(zVar.mo40646b())) {
                    try {
                        this.f28433a.mo40150b(zVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a5;
        } finally {
            if (a != null) {
                C8417c.m36040a((Closeable) a.mo40097h());
            }
        }
    }

    /* renamed from: a */
    private static C8362ab m35907a(C8362ab abVar) {
        return (abVar == null || abVar.mo40097h() == null) ? abVar : abVar.mo40098i().mo40111a((C8364ac) null).mo40115a();
    }

    /* renamed from: a */
    private C8362ab m35908a(final C8391b bVar, C8362ab abVar) throws IOException {
        if (bVar == null) {
            return abVar;
        }
        C8546q b = bVar.mo40152b();
        if (b == null) {
            return abVar;
        }
        final C8529e c = abVar.mo40097h().mo40122c();
        final C8528d a = C8535k.m36848a(b);
        C83901 r2 = new C8547r() {
            /* renamed from: a */
            boolean f28434a;

            /* renamed from: a */
            public long mo40202a(C8525c cVar, long j) throws IOException {
                try {
                    long a = c.mo40202a(cVar, j);
                    if (a == -1) {
                        if (!this.f28434a) {
                            this.f28434a = true;
                            a.close();
                        }
                        return -1;
                    }
                    cVar.mo40728a(a.mo40741c(), cVar.mo40734b() - a, a);
                    a.mo40787x();
                    return a;
                } catch (IOException e) {
                    if (!this.f28434a) {
                        this.f28434a = true;
                        bVar.mo40151a();
                    }
                    throw e;
                }
            }

            /* renamed from: a */
            public C8548s mo40203a() {
                return c.mo40203a();
            }

            public void close() throws IOException {
                if (!this.f28434a && !C8417c.m36046a((C8547r) this, 100, TimeUnit.MILLISECONDS)) {
                    this.f28434a = true;
                    bVar.mo40151a();
                }
                c.close();
            }
        };
        return abVar.mo40098i().mo40111a((C8364ac) new C8412h(abVar.mo40089b("Content-Type"), abVar.mo40097h().mo40121b(), C8535k.m36849a((C8547r) r2))).mo40115a();
    }

    /* renamed from: a */
    private static C8504s m35909a(C8504s sVar, C8504s sVar2) {
        C8505a aVar = new C8505a();
        int a = sVar.mo40531a();
        for (int i = 0; i < a; i++) {
            String a2 = sVar.mo40532a(i);
            String b = sVar.mo40534b(i);
            if ((!"Warning".equalsIgnoreCase(a2) || !b.startsWith("1")) && (m35911b(a2) || !m35910a(a2) || sVar2.mo40533a(a2) == null)) {
                C8388a.f28432a.mo40198a(aVar, a2, b);
            }
        }
        int a3 = sVar2.mo40531a();
        for (int i2 = 0; i2 < a3; i2++) {
            String a4 = sVar2.mo40532a(i2);
            if (!m35911b(a4) && m35910a(a4)) {
                C8388a.f28432a.mo40198a(aVar, a4, sVar2.mo40534b(i2));
            }
        }
        return aVar.mo40543a();
    }

    /* renamed from: a */
    static boolean m35910a(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    /* renamed from: b */
    static boolean m35911b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
