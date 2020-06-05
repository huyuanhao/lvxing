package com.tencent.dynamicbundle.reflect;

import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class RefStaticFloat {
    private Field field;

    public RefStaticFloat(Class<?> cls, Field field2) {
        this.field = cls.getDeclaredField(field2.getName());
        this.field.setAccessible(true);
    }

    public float get() {
        try {
            return this.field.getFloat(null);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public void set(int i) {
        try {
            this.field.setFloat(null, (float) i);
        } catch (Exception unused) {
        }
    }
}
