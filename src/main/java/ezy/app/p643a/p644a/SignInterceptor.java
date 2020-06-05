package ezy.app.p643a.p644a;

import java.io.IOException;
import java.net.URI;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;
import kotlin.text.Charsets;
import okhttp3.C8358aa;
import okhttp3.C8362ab;
import okhttp3.C8506t.C8507a;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8510v;
import okhttp3.C8518z;
import okhttp3.FormBody;
import okio.C8525c;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo39189d2 = {"Lezy/app/net/interceptor/SignInterceptor;", "Lokhttp3/Interceptor;", "secretKey", "", "timestampKey", "(Ljava/lang/String;Ljava/lang/String;)V", "hashBody", "request", "Lokhttp3/Request;", "body", "Lokhttp3/RequestBody;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isValid", "", "contentType", "sign", "uri", "Ljava/net/URI;", "sortQuery", "query", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: ezy.app.a.a.c */
public final class SignInterceptor implements C8508u {
    /* renamed from: a */
    private final String f27254a;
    /* renamed from: b */
    private final String f27255b;

    public SignInterceptor(String str, String str2) {
        C8271i.m35386b(str, "secretKey");
        this.f27254a = str;
        this.f27255b = str2;
    }

    public /* synthetic */ SignInterceptor(String str, String str2, int i, DefaultConstructorMarker fVar) {
        if ((i & 2) != 0) {
            str2 = "ts";
        }
        this(str, str2);
    }

    public C8362ab intercept(C8509a aVar) throws IOException {
        C8271i.m35386b(aVar, "chain");
        C8518z a = aVar.mo40246a();
        C8507a q = a.mo40645a().mo40568q();
        String str = this.f27255b;
        if (str != null) {
            q.mo40573a(str, String.valueOf(System.currentTimeMillis()));
        }
        C8271i.m35382a((Object) a, "request");
        URI a2 = q.mo40580c().mo40548a();
        C8271i.m35382a((Object) a2, "newUrl.build().uri()");
        q.mo40573a("sign", m34758a(a, a2));
        C8362ab a3 = aVar.mo40244a(a.mo40650e().mo40660a(q.mo40580c()).mo40663b());
        C8271i.m35382a((Object) a3, "chain.proceed(request.ne…(newUrl.build()).build())");
        return a3;
    }

    /* renamed from: a */
    private final String m34758a(C8518z zVar, URI uri) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27254a);
        String b = zVar.mo40646b();
        C8271i.m35382a((Object) b, "request.method()");
        if (b != null) {
            String lowerCase = b.toLowerCase();
            C8271i.m35382a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append(uri.getPath());
            String query = uri.getQuery();
            C8271i.m35382a((Object) query, "uri.query");
            sb.append(m34755a(query));
            sb.append(m34757a(zVar));
            String sb2 = sb.toString();
            C8525c cVar = new C8525c();
            cVar.mo40726a(sb2, Charsets.f27799a);
            String hex = cVar.mo40783u().hex();
            C8271i.m35382a((Object) hex, "sign");
            return hex;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private final String m34755a(String str) {
        String str2 = "&";
        return C8187k.m35283a(C8187k.m35285b((Iterable) C8313m.m35485b((CharSequence) str, new String[]{str2}, false, 0, 6, (Object) null)), str2, null, null, 0, null, null, 62, null);
    }

    /* renamed from: b */
    private final boolean m34759b(String str) {
        CharSequence charSequence = str;
        return C8313m.m35480a(charSequence, (CharSequence) "application/x-www-form-urlencoded", false, 2, (Object) null) || C8313m.m35480a(charSequence, (CharSequence) "application/json", false, 2, (Object) null);
    }

    /* renamed from: a */
    private final String m34757a(C8518z zVar) {
        C8358aa d = zVar.mo40649d();
        String str = "";
        if (d != null) {
            if (d instanceof FormBody) {
                return m34756a(d);
            }
            String a = zVar.mo40644a("Content-Type");
            String str2 = "it";
            String str3 = "contentType";
            if (a != null) {
                C8271i.m35382a((Object) a, str3);
                if (m34759b(a)) {
                    C8271i.m35382a((Object) d, str2);
                    return m34756a(d);
                }
            }
            C8510v b = d.mo40084b();
            if (b != null) {
                String vVar = b.toString();
                if (vVar != null) {
                    C8271i.m35382a((Object) vVar, str3);
                    if (m34759b(vVar)) {
                        C8271i.m35382a((Object) d, str2);
                        return m34756a(d);
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    private final String m34756a(C8358aa aaVar) {
        C8525c cVar = new C8525c();
        aaVar.mo40083a(cVar);
        String hex = cVar.mo40783u().hex();
        C8271i.m35382a((Object) hex, "buffer.md5().hex()");
        return hex;
    }
}
