package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* renamed from: com.alipay.android.phone.mrpc.core.x */
public final class C1433x {
    /* renamed from: a */
    private C1415g f3682a;
    /* renamed from: b */
    private C1435z f3683b = new C1435z(this);

    public C1433x(C1415g gVar) {
        this.f3682a = gVar;
    }

    /* renamed from: a */
    public final C1415g mo11999a() {
        return this.f3682a;
    }

    /* renamed from: a */
    public final <T> T mo12000a(Class<T> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C1434y(this.f3682a, cls, this.f3683b));
    }
}
