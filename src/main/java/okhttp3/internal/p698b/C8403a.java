package okhttp3.internal.p698b;

import java.io.IOException;
import java.util.List;
import okhttp3.C8358aa;
import okhttp3.C8362ab;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8364ac;
import okhttp3.C8492l;
import okhttp3.C8493m;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8510v;
import okhttp3.C8518z;
import okhttp3.C8518z.C8519a;
import okhttp3.internal.C8417c;
import okhttp3.internal.C8436d;
import okio.C8533i;
import okio.C8535k;
import okio.C8547r;

/* compiled from: BridgeInterceptor */
/* renamed from: okhttp3.internal.b.a */
public final class C8403a implements C8508u {
    /* renamed from: a */
    private final C8493m f28498a;

    public C8403a(C8493m mVar) {
        this.f28498a = mVar;
    }

    public C8362ab intercept(C8509a aVar) throws IOException {
        C8518z a = aVar.mo40246a();
        C8519a e = a.mo40650e();
        C8358aa d = a.mo40649d();
        String str = "Content-Type";
        String str2 = "Content-Length";
        if (d != null) {
            C8510v b = d.mo40084b();
            if (b != null) {
                e.mo40656a(str, b.toString());
            }
            long c = d.mo40085c();
            String str3 = "Transfer-Encoding";
            if (c != -1) {
                e.mo40656a(str2, Long.toString(c));
                e.mo40661b(str3);
            } else {
                e.mo40656a(str3, "chunked");
                e.mo40661b(str2);
            }
        }
        String str4 = "Host";
        boolean z = false;
        if (a.mo40644a(str4) == null) {
            e.mo40656a(str4, C8417c.m36031a(a.mo40645a(), false));
        }
        String str5 = "Connection";
        if (a.mo40644a(str5) == null) {
            e.mo40656a(str5, "Keep-Alive");
        }
        String str6 = "Accept-Encoding";
        String str7 = "gzip";
        if (a.mo40644a(str6) == null && a.mo40644a("Range") == null) {
            z = true;
            e.mo40656a(str6, str7);
        }
        List a2 = this.f28498a.mo40487a(a.mo40645a());
        if (!a2.isEmpty()) {
            e.mo40656a("Cookie", m35963a(a2));
        }
        String str8 = "User-Agent";
        if (a.mo40644a(str8) == null) {
            e.mo40656a(str8, C8436d.m36139a());
        }
        C8362ab a3 = aVar.mo40244a(e.mo40663b());
        C8409e.m35981a(this.f28498a, a.mo40645a(), a3.mo40096g());
        C8363a a4 = a3.mo40098i().mo40114a(a);
        if (z) {
            String str9 = "Content-Encoding";
            if (str7.equalsIgnoreCase(a3.mo40089b(str9)) && C8409e.m35988d(a3)) {
                C8533i iVar = new C8533i(a3.mo40097h().mo40122c());
                a4.mo40113a(a3.mo40096g().mo40536b().mo40544b(str9).mo40544b(str2).mo40543a());
                a4.mo40111a((C8364ac) new C8412h(a3.mo40089b(str), -1, C8535k.m36849a((C8547r) iVar)));
            }
        }
        return a4.mo40115a();
    }

    /* renamed from: a */
    private String m35963a(List<C8492l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            C8492l lVar = (C8492l) list.get(i);
            sb.append(lVar.mo40481a());
            sb.append('=');
            sb.append(lVar.mo40483b());
        }
        return sb.toString();
    }
}
