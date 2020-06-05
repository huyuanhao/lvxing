package com.alipay.p099a.p100a;

import java.lang.reflect.Type;

/* renamed from: com.alipay.a.a.d */
public final class C1385d implements C1390i, C1391j {
    /* renamed from: a */
    public final Object mo11907a(Object obj) {
        return ((Enum) obj).name();
    }

    /* renamed from: a */
    public final Object mo11908a(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    /* renamed from: a */
    public final boolean mo11909a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
