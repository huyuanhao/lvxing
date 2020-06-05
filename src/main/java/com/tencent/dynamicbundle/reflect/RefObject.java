package com.tencent.dynamicbundle.reflect;

import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class RefObject<T> {
    private Field field;

    public RefObject(Class<?> cls, Field field2) {
        this.field = cls.getDeclaredField(field2.getName());
        this.field.setAccessible(true);
    }

    public T get(Object obj) {
        try {
            return this.field.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public void set(Object obj, T t) {
        try {
            this.field.set(obj, t);
        } catch (Exception unused) {
        }
    }
}
