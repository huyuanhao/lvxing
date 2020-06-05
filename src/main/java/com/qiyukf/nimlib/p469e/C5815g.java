package com.qiyukf.nimlib.p469e;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qiyukf.nimlib.e.g */
public final class C5815g {
    /* renamed from: a */
    private final Map<Class<?>, Object> f18478a = new HashMap();

    /* renamed from: a */
    public final <T> T mo28110a(Class<T> cls) {
        T t;
        if (cls.isInterface()) {
            synchronized (this.f18478a) {
                t = this.f18478a.get(cls);
                if (t == null) {
                    t = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C5812e());
                    if (t != null) {
                        this.f18478a.put(cls, t);
                    }
                }
            }
            return t;
        }
        StringBuilder sb = new StringBuilder("Only accept interface: ");
        sb.append(cls);
        throw new IllegalArgumentException(sb.toString());
    }
}
