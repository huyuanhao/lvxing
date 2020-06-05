package com.alipay.p099a.p100a;

import java.lang.reflect.Type;
import java.util.Date;

/* renamed from: com.alipay.a.a.c */
public final class C1384c implements C1390i, C1391j {
    /* renamed from: a */
    public final Object mo11907a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    /* renamed from: a */
    public final Object mo11908a(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    /* renamed from: a */
    public final boolean mo11909a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}
