package okhttp3.internal.p698b;

import java.io.IOException;
import java.util.List;
import okhttp3.C8362ab;
import okhttp3.C8379e;
import okhttp3.C8387i;
import okhttp3.C8498p;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8518z;
import okhttp3.internal.connection.C8430c;
import okhttp3.internal.connection.C8434f;

/* compiled from: RealInterceptorChain */
/* renamed from: okhttp3.internal.b.g */
public final class C8411g implements C8509a {
    /* renamed from: a */
    private final List<C8508u> f28505a;
    /* renamed from: b */
    private final C8434f f28506b;
    /* renamed from: c */
    private final C8406c f28507c;
    /* renamed from: d */
    private final C8430c f28508d;
    /* renamed from: e */
    private final int f28509e;
    /* renamed from: f */
    private final C8518z f28510f;
    /* renamed from: g */
    private final C8379e f28511g;
    /* renamed from: h */
    private final C8498p f28512h;
    /* renamed from: i */
    private final int f28513i;
    /* renamed from: j */
    private final int f28514j;
    /* renamed from: k */
    private final int f28515k;
    /* renamed from: l */
    private int f28516l;

    public C8411g(List<C8508u> list, C8434f fVar, C8406c cVar, C8430c cVar2, int i, C8518z zVar, C8379e eVar, C8498p pVar, int i2, int i3, int i4) {
        this.f28505a = list;
        this.f28508d = cVar2;
        this.f28506b = fVar;
        this.f28507c = cVar;
        this.f28509e = i;
        this.f28510f = zVar;
        this.f28511g = eVar;
        this.f28512h = pVar;
        this.f28513i = i2;
        this.f28514j = i3;
        this.f28515k = i4;
    }

    /* renamed from: e */
    public C8387i mo40250e() {
        return this.f28508d;
    }

    /* renamed from: b */
    public int mo40247b() {
        return this.f28513i;
    }

    /* renamed from: c */
    public int mo40248c() {
        return this.f28514j;
    }

    /* renamed from: d */
    public int mo40249d() {
        return this.f28515k;
    }

    /* renamed from: f */
    public C8434f mo40251f() {
        return this.f28506b;
    }

    /* renamed from: g */
    public C8406c mo40252g() {
        return this.f28507c;
    }

    /* renamed from: h */
    public C8379e mo40253h() {
        return this.f28511g;
    }

    /* renamed from: i */
    public C8498p mo40254i() {
        return this.f28512h;
    }

    /* renamed from: a */
    public C8518z mo40246a() {
        return this.f28510f;
    }

    /* renamed from: a */
    public C8362ab mo40244a(C8518z zVar) throws IOException {
        return mo40245a(zVar, this.f28506b, this.f28507c, this.f28508d);
    }

    /* renamed from: a */
    public C8362ab mo40245a(C8518z zVar, C8434f fVar, C8406c cVar, C8430c cVar2) throws IOException {
        if (this.f28509e < this.f28505a.size()) {
            this.f28516l++;
            String str = "network interceptor ";
            if (this.f28507c == null || this.f28508d.mo40283a(zVar.mo40645a())) {
                String str2 = " must call proceed() exactly once";
                if (this.f28507c == null || this.f28516l <= 1) {
                    C8411g gVar = new C8411g(this.f28505a, fVar, cVar, cVar2, this.f28509e + 1, zVar, this.f28511g, this.f28512h, this.f28513i, this.f28514j, this.f28515k);
                    C8508u uVar = (C8508u) this.f28505a.get(this.f28509e);
                    C8362ab intercept = uVar.intercept(gVar);
                    if (cVar == null || this.f28509e + 1 >= this.f28505a.size() || gVar.f28516l == 1) {
                        String str3 = "interceptor ";
                        if (intercept == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append(uVar);
                            sb.append(" returned null");
                            throw new NullPointerException(sb.toString());
                        } else if (intercept.mo40097h() != null) {
                            return intercept;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str3);
                            sb2.append(uVar);
                            sb2.append(" returned a response with no body");
                            throw new IllegalStateException(sb2.toString());
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(uVar);
                        sb3.append(str2);
                        throw new IllegalStateException(sb3.toString());
                    }
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(this.f28505a.get(this.f28509e - 1));
                    sb4.append(str2);
                    throw new IllegalStateException(sb4.toString());
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(this.f28505a.get(this.f28509e - 1));
                sb5.append(" must retain the same host and port");
                throw new IllegalStateException(sb5.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
