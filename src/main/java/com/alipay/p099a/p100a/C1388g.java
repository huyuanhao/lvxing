package com.alipay.p099a.p100a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;
import org.json.alipay.C8577b;

/* renamed from: com.alipay.a.a.g */
public final class C1388g implements C1390i, C1391j {
    /* renamed from: a */
    public final Object mo11907a(Object obj) {
        TreeMap treeMap = new TreeMap();
        Class cls = obj.getClass();
        while (true) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (cls.equals(Object.class)) {
                return treeMap;
            }
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    Object obj2 = null;
                    if (!(field == null || obj == null)) {
                        if (!"this$0".equals(field.getName())) {
                            boolean isAccessible = field.isAccessible();
                            field.setAccessible(true);
                            Object obj3 = field.get(obj);
                            if (obj3 != null) {
                                field.setAccessible(isAccessible);
                                obj2 = C1387f.m4047b(obj3);
                            }
                        }
                    }
                    if (obj2 != null) {
                        treeMap.put(field.getName(), obj2);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
    }

    /* renamed from: a */
    public final Object mo11908a(Object obj, Type type) {
        if (!obj.getClass().equals(C8577b.class)) {
            return null;
        }
        C8577b bVar = (C8577b) obj;
        Class cls = (Class) type;
        Object newInstance = cls.newInstance();
        while (!cls.equals(Object.class)) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    String name = field.getName();
                    Type genericType = field.getGenericType();
                    if (bVar.mo41010b(name)) {
                        field.setAccessible(true);
                        field.set(newInstance, C1386e.m4044a(bVar.mo41008a(name), genericType));
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return newInstance;
    }

    /* renamed from: a */
    public final boolean mo11909a(Class<?> cls) {
        return true;
    }
}
