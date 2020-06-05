package com.bytedance.sdk.openadsdk.p190h.p195e;

import com.bytedance.sdk.adnet.core.C1969a;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.openadsdk.p190h.C2482i.C2484b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.h.e.g */
public class VolleyResponseWrapper extends AbsResponseWrapper {
    /* renamed from: c */
    private HttpResponse f8854c;

    /* renamed from: e */
    public String mo16748e() {
        return "http/1.1";
    }

    public VolleyResponseWrapper(HttpResponse bVar, VideoRequest fVar) {
        this.f8854c = bVar;
        this.f8845a = new ArrayList();
        for (int i = 0; i < this.f8854c.mo14312b().size(); i++) {
            C1969a aVar = (C1969a) this.f8854c.mo14312b().get(i);
            if (aVar != null) {
                this.f8845a.add(new C2484b(aVar.mo14306a(), aVar.mo14307b()));
            }
        }
        this.f8846b = fVar;
    }

    /* renamed from: a */
    public int mo16741a() {
        return this.f8854c.mo14311a();
    }

    /* renamed from: b */
    public boolean mo16745b() {
        return this.f8854c.mo14311a() >= 200 && this.f8854c.mo14311a() < 300;
    }

    /* renamed from: a */
    public String mo16744a(String str, String str2) {
        return mo16742a(str) != null ? mo16742a(str).f8932b : str2;
    }

    /* renamed from: c */
    public List<C2484b> mo16746c() {
        return this.f8845a;
    }

    /* renamed from: d */
    public InputStream mo16747d() {
        return this.f8854c.mo14314d();
    }

    /* renamed from: f */
    public String mo16749f() {
        return mo16743a(this.f8854c.mo14311a());
    }
}
