package com.tencent.dynamicbundle.reflect;

import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class RefBoolean {
    private Field field;

    public RefBoolean(Class<?> cls, Field field2) {
        this.field = cls.getDeclaredField(field2.getName());
        this.field.setAccessible(true);
    }

    public boolean get(Object obj) {
        try {
            return this.field.getBoolean(obj);
        } catch (Exception unused) {
            return false;
        }
    }

    public void set(Object obj, boolean z) {
        try {
            this.field.setBoolean(obj, z);
        } catch (Exception unused) {
        }
    }
}
