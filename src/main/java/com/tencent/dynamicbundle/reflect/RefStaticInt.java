package com.tencent.dynamicbundle.reflect;

import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class RefStaticInt {
    private Field field;

    public RefStaticInt(Class<?> cls, Field field2) {
        this.field = cls.getDeclaredField(field2.getName());
        this.field.setAccessible(true);
    }

    public int get() {
        try {
            return this.field.getInt(null);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void set(int i) {
        try {
            this.field.setInt(null, i);
        } catch (Exception unused) {
        }
    }
}
