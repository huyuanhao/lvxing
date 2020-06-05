package com.alipay.p099a.p100a;

import com.alipay.p099a.p101b.C1394a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import org.json.alipay.C8576a;

/* renamed from: com.alipay.a.a.b */
public final class C1383b implements C1390i, C1391j {
    /* renamed from: a */
    private static Collection<Object> m4034a(Class<?> cls, Type type) {
        if (cls == AbstractCollection.class) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder("create instane error, class ");
            sb.append(cls.getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public final Object mo11907a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object b : (Iterable) obj) {
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
        Collection a = m4034a(C1394a.m4064a(type), type);
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            for (int i = 0; i < aVar.mo41005a(); i++) {
                a.add(C1386e.m4044a(aVar.mo41006a(i), type2));
            }
            return a;
        }
        throw new IllegalArgumentException("Does not support the implement for generics.");
    }

    /* renamed from: a */
    public final boolean mo11909a(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }
}
