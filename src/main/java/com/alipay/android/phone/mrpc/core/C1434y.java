package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.alipay.android.phone.mrpc.core.y */
public final class C1434y implements InvocationHandler {
    /* renamed from: a */
    protected C1415g f3684a;
    /* renamed from: b */
    protected Class<?> f3685b;
    /* renamed from: c */
    protected C1435z f3686c;

    public C1434y(C1415g gVar, Class<?> cls, C1435z zVar) {
        this.f3684a = gVar;
        this.f3685b = cls;
        this.f3686c = zVar;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f3686c.mo12002a(method, objArr);
    }
}
