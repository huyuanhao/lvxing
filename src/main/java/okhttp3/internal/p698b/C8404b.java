package okhttp3.internal.p698b;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.C8362ab;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8518z;
import okhttp3.internal.C8417c;
import okhttp3.internal.connection.C8430c;
import okhttp3.internal.connection.C8434f;
import okio.C8525c;
import okio.C8528d;
import okio.C8530f;
import okio.C8535k;
import okio.C8546q;

/* compiled from: CallServerInterceptor */
/* renamed from: okhttp3.internal.b.b */
public final class C8404b implements C8508u {
    /* renamed from: a */
    private final boolean f28499a;

    /* compiled from: CallServerInterceptor */
    /* renamed from: okhttp3.internal.b.b$a */
    static final class C8405a extends C8530f {
        /* renamed from: a */
        long f28500a;

        C8405a(C8546q qVar) {
            super(qVar);
        }

        /* renamed from: a_ */
        public void mo40231a_(C8525c cVar, long j) throws IOException {
            super.mo40231a_(cVar, j);
            this.f28500a += j;
        }
    }

    public C8404b(boolean z) {
        this.f28499a = z;
    }

    public C8362ab intercept(C8509a aVar) throws IOException {
        C8362ab abVar;
        C8411g gVar = (C8411g) aVar;
        C8406c g = gVar.mo40252g();
        C8434f f = gVar.mo40251f();
        C8430c cVar = (C8430c) gVar.mo40250e();
        C8518z a = gVar.mo40246a();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.mo40254i().mo40511c(gVar.mo40253h());
        g.mo40239a(a);
        gVar.mo40254i().mo40507a(gVar.mo40253h(), a);
        C8363a aVar2 = null;
        if (C8410f.m35992c(a.mo40646b()) && a.mo40649d() != null) {
            if ("100-continue".equalsIgnoreCase(a.mo40644a("Expect"))) {
                g.mo40238a();
                gVar.mo40254i().mo40513e(gVar.mo40253h());
                aVar2 = g.mo40235a(true);
            }
            if (aVar2 == null) {
                gVar.mo40254i().mo40512d(gVar.mo40253h());
                C8405a aVar3 = new C8405a(g.mo40237a(a, a.mo40649d().mo40085c()));
                C8528d a2 = C8535k.m36848a((C8546q) aVar3);
                a.mo40649d().mo40083a(a2);
                a2.close();
                gVar.mo40254i().mo40497a(gVar.mo40253h(), aVar3.f28500a);
            } else if (!cVar.mo40288e()) {
                f.mo40308e();
            }
        }
        g.mo40240b();
        if (aVar2 == null) {
            gVar.mo40254i().mo40513e(gVar.mo40253h());
            aVar2 = g.mo40235a(false);
        }
        C8362ab a3 = aVar2.mo40114a(a).mo40112a(f.mo40306c().mo40287d()).mo40106a(currentTimeMillis).mo40116b(System.currentTimeMillis()).mo40115a();
        int c = a3.mo40091c();
        if (c == 100) {
            a3 = g.mo40235a(false).mo40114a(a).mo40112a(f.mo40306c().mo40287d()).mo40106a(currentTimeMillis).mo40116b(System.currentTimeMillis()).mo40115a();
            c = a3.mo40091c();
        }
        gVar.mo40254i().mo40504a(gVar.mo40253h(), a3);
        if (!this.f28499a || c != 101) {
            abVar = a3.mo40098i().mo40111a(g.mo40236a(a3)).mo40115a();
        } else {
            abVar = a3.mo40098i().mo40111a(C8417c.f28530c).mo40115a();
        }
        String str = "Connection";
        String str2 = "close";
        if (str2.equalsIgnoreCase(abVar.mo40088a().mo40644a(str)) || str2.equalsIgnoreCase(abVar.mo40089b(str))) {
            f.mo40308e();
        }
        if ((c != 204 && c != 205) || abVar.mo40097h().mo40121b() <= 0) {
            return abVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(c);
        sb.append(" had non-zero Content-Length: ");
        sb.append(abVar.mo40097h().mo40121b());
        throw new ProtocolException(sb.toString());
    }
}
