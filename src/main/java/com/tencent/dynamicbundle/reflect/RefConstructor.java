package com.tencent.dynamicbundle.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class RefConstructor<T> {
    private Constructor<?> ctor;

    public RefConstructor(Class<?> cls, Field field) {
        if (field.isAnnotationPresent(MethodParams.class)) {
            this.ctor = cls.getDeclaredConstructor(((MethodParams) field.getAnnotation(MethodParams.class)).value());
        } else {
            int i = 0;
            if (field.isAnnotationPresent(MethodReflectParams.class)) {
                String[] value = ((MethodReflectParams) field.getAnnotation(MethodReflectParams.class)).value();
                Class[] clsArr = new Class[value.length];
                while (i < value.length) {
                    try {
                        clsArr[i] = Class.forName(value[i]);
                        i++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.ctor = cls.getDeclaredConstructor(clsArr);
            } else {
                this.ctor = cls.getDeclaredConstructor(new Class[0]);
            }
        }
        Constructor<?> constructor = this.ctor;
        if (constructor != null && !constructor.isAccessible()) {
            this.ctor.setAccessible(true);
        }
    }

    public T newInstance() {
        try {
            return this.ctor.newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public T newInstance(Object... objArr) {
        try {
            return this.ctor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
