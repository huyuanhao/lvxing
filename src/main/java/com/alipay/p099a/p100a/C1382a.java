package com.alipay.p099a.p100a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.alipay.C8576a;

/* renamed from: com.alipay.a.a.a */
public final class C1382a implements C1390i, C1391j {
    /* renamed from: a */
    public final Object mo11907a(Object obj) {
        Object[] objArr = (Object[]) obj;
        ArrayList arrayList = new ArrayList();
        for (Object b : objArr) {
            arrayList.add(C1387f.m4047b(b));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final Object mo11908a(Object obj, Type type) {
        if (!obj.getClass().equals(C8576a.class)) {
            return null;
        }
        C8576a aVar = (C8576a) obj;
        if (!(type instanceof GenericArrayType)) {
            Class componentType = ((Class) type).getComponentType();
            int a = aVar.mo41005a();
            Object newInstance = Array.newInstance(componentType, a);
            for (int i = 0; i < a; i++) {
                Array.set(newInstance, i, C1386e.m4044a(aVar.mo41006a(i), (Type) componentType));
            }
            return newInstance;
        }
        throw new IllegalArgumentException("Does not support generic array!");
    }

    /* renamed from: a */
    public final boolean mo11909a(Class<?> cls) {
        return cls.isArray();
    }
}
