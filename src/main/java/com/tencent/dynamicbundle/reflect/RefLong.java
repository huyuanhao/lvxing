package com.tencent.dynamicbundle.reflect;

import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class RefLong {
    private Field field;

    public RefLong(Class cls, Field field2) {
        this.field = cls.getDeclaredField(field2.getName());
        this.field.setAccessible(true);
    }

    public long get(Object obj) {
        try {
            return this.field.getLong(obj);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void set(Object obj, long j) {
        try {
            this.field.setLong(obj, j);
        } catch (Exception unused) {
        }
    }
}
