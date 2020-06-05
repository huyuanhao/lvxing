package com.alipay.p099a.p100a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.C8576a;

/* renamed from: com.alipay.a.a.k */
public final class C1392k implements C1390i {
    /* renamed from: a */
    public final Object mo11908a(Object obj, Type type) {
        if (!obj.getClass().equals(C8576a.class)) {
            return null;
        }
        C8576a aVar = (C8576a) obj;
        HashSet hashSet = new HashSet();
        Type type2 = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class;
        for (int i = 0; i < aVar.mo41005a(); i++) {
            hashSet.add(C1386e.m4044a(aVar.mo41006a(i), type2));
        }
        return hashSet;
    }

    /* renamed from: a */
    public final boolean mo11909a(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}
