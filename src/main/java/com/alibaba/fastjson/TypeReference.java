package com.alibaba.fastjson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.alibaba.fastjson.h */
public class TypeReference<T> {
    /* renamed from: a */
    static ConcurrentMap<Type, Type> f2682a = new ConcurrentHashMap(16, 0.75f, 1);
    /* renamed from: c */
    public static final Type f2683c = new TypeReference<List<String>>() {
    }.mo11111a();
    /* renamed from: b */
    protected final Type f2684b;

    protected TypeReference() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = (Type) f2682a.get(type);
        if (type2 == null) {
            f2682a.putIfAbsent(type, type);
            type2 = (Type) f2682a.get(type);
        }
        this.f2684b = type2;
    }

    /* renamed from: a */
    public Type mo11111a() {
        return this.f2684b;
    }
}
