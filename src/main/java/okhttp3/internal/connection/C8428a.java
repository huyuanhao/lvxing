package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.C8362ab;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8513x;
import okhttp3.C8518z;
import okhttp3.internal.p698b.C8411g;

/* compiled from: ConnectInterceptor */
/* renamed from: okhttp3.internal.connection.a */
public final class C8428a implements C8508u {
    /* renamed from: a */
    public final C8513x f28574a;

    public C8428a(C8513x xVar) {
        this.f28574a = xVar;
    }

    public C8362ab intercept(C8509a aVar) throws IOException {
        C8411g gVar = (C8411g) aVar;
        C8518z a = gVar.mo40246a();
        C8434f f = gVar.mo40251f();
        return gVar.mo40245a(a, f, f.mo40301a(this.f28574a, aVar, !a.mo40646b().equals("GET")), f.mo40306c());
    }
}
