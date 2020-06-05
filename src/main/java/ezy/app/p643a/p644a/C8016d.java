package ezy.app.p643a.p644a;

import java.net.URI;
import kotlin.Metadata;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;
import kotlin.text.Charsets;
import okio.C8525c;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, mo39189d2 = {"apiSign", "", "secretKey", "method", "uri", "Ljava/net/URI;", "hashBody", "lib.framework_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: SignInterceptor.kt */
/* renamed from: ezy.app.a.a.d */
public final class C8016d {
    /* renamed from: a */
    public static final String m34760a(String str, String str2, URI uri, String str3) {
        C8271i.m35386b(str, "secretKey");
        C8271i.m35386b(str2, "method");
        C8271i.m35386b(uri, "uri");
        C8271i.m35386b(str3, "hashBody");
        String query = uri.getQuery();
        C8271i.m35382a((Object) query, "uri.query");
        String str4 = "&";
        String a = C8187k.m35283a(C8187k.m35285b((Iterable) C8313m.m35485b((CharSequence) query, new String[]{str4}, false, 0, 6, (Object) null)), str4, null, null, 0, null, null, 62, null);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String lowerCase = str2.toLowerCase();
        C8271i.m35382a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        sb.append(uri.getPath());
        sb.append(a);
        sb.append(str3);
        String sb2 = sb.toString();
        C8525c cVar = new C8525c();
        cVar.mo40726a(sb2, Charsets.f27799a);
        String hex = cVar.mo40783u().hex();
        C8271i.m35382a((Object) hex, "buffer.md5().hex()");
        return hex;
    }
}
