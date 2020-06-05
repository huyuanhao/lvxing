package ezy.app.p643a.p644a;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8362ab;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8518z;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo39189d2 = {"Lezy/app/net/interceptor/MockInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: ezy.app.a.a.b */
public final class MockInterceptor implements C8508u {
    public C8362ab intercept(C8509a aVar) throws IOException {
        C8271i.m35386b(aVar, "chain");
        C8518z a = aVar.mo40246a();
        String str = "mock";
        String a2 = a.mo40644a(str);
        if (a2 != null) {
            C8362ab a3 = aVar.mo40244a(a.mo40650e().mo40655a(a2).mo40656a("mock-original-url", a.mo40645a().toString()).mo40661b(str).mo40663b());
            C8271i.m35382a((Object) a3, "chain.proceed(request.ne…                .build())");
            return a3;
        }
        C8362ab a4 = aVar.mo40244a(a);
        C8271i.m35382a((Object) a4, "chain.proceed(request)");
        return a4;
    }
}
