package com.alibaba.wireless.security.open.p084e;

import android.content.Context;
import com.alibaba.wireless.security.framework.C1338c;
import com.alibaba.wireless.security.open.SecException;

/* renamed from: com.alibaba.wireless.security.open.e.c */
public class C1363c implements C1361a {
    /* renamed from: a */
    C1364d f3564a;

    public C1363c() {
        this.f3564a = new C1364d();
    }

    public C1363c(String str) {
        this.f3564a = new C1364d(str);
    }

    /* renamed from: a */
    public int mo11887a(Context context) throws SecException {
        return mo11891b(context);
    }

    /* renamed from: a */
    public C1338c mo11890a() {
        return this.f3564a.mo11893a();
    }

    /* renamed from: b */
    public int mo11891b(Context context) throws SecException {
        return this.f3564a.mo11892a(context, null, true, false);
    }
}
