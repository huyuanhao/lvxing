package com.tencent.dynamicbundle.reflect;

import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class RefFloat {
    private Field field;

    public RefFloat(Class cls, Field field2) {
        this.field = cls.getDeclaredField(field2.getName());
        this.field.setAccessible(true);
    }

    public float get(Object obj) {
        try {
            return this.field.getFloat(obj);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public void set(Object obj, float f) {
        try {
            this.field.setFloat(obj, f);
        } catch (Exception unused) {
        }
    }
}
