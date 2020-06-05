package com.alipay.p099a.p101b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: com.alipay.a.b.a */
public final class C1394a {
    /* renamed from: a */
    public static Class<?> m4064a(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else {
                throw new IllegalArgumentException("TODO");
            }
        }
        return (Class) type;
    }

    /* renamed from: a */
    public static boolean m4065a(Class<?> cls) {
        return cls.isPrimitive() || cls.equals(String.class) || cls.equals(Integer.class) || cls.equals(Long.class) || cls.equals(Double.class) || cls.equals(Float.class) || cls.equals(Boolean.class) || cls.equals(Short.class) || cls.equals(Character.class) || cls.equals(Byte.class) || cls.equals(Void.class);
    }
}
