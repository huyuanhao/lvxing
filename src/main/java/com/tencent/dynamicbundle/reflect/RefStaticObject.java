package com.tencent.dynamicbundle.reflect;

import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class RefStaticObject<T> {
    private Field field;

    public RefStaticObject(Class<?> cls, Field field2) {
        this.field = cls.getDeclaredField(field2.getName());
        this.field.setAccessible(true);
    }

    public Class<?> type() {
        return this.field.getType();
    }

    public T get() {
        T t = null;
        try {
            t = this.field.get(null);
            return t;
        } catch (Exception unused) {
            return t;
        }
    }

    public void set(T t) {
        try {
            this.field.set(null, t);
        } catch (Exception unused) {
        }
    }
}
