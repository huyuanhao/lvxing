package com.tencent.mta.track;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.d */
class C7373d {
    /* renamed from: a */
    private final String f24948a;
    /* renamed from: b */
    private final Object[] f24949b;
    /* renamed from: c */
    private final Class f24950c;
    /* renamed from: d */
    private final Class f24951d;
    /* renamed from: e */
    private final Method f24952e;

    public C7373d(Class cls, String str, Object[] objArr, Class cls2) {
        this.f24948a = str;
        this.f24949b = objArr;
        this.f24950c = cls2;
        this.f24952e = m31787b(cls);
        Method method = this.f24952e;
        if (method != null) {
            this.f24951d = method.getDeclaringClass();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(cls.getName());
        sb.append(".");
        sb.append(this.f24948a);
        sb.append(" doesn't exit");
        throw new NoSuchMethodException(sb.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Caller ");
        sb.append(this.f24948a);
        sb.append("(");
        sb.append(this.f24949b);
        sb.append(")");
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    public Object mo35910a(View view) {
        return mo35911a(view, this.f24949b);
    }

    /* renamed from: a */
    public Object mo35911a(View view, Object[] objArr) {
        String str = "Method ";
        String str2 = "Caller";
        if (this.f24951d.isAssignableFrom(view.getClass())) {
            try {
                return this.f24952e.invoke(view, objArr);
            } catch (IllegalAccessException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(this.f24952e.getName());
                sb.append(" appears not to be public");
                Log.e(str2, sb.toString(), e);
            } catch (IllegalArgumentException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f24952e.getName());
                sb2.append(" called with arguments of the wrong type");
                Log.e(str2, sb2.toString(), e2);
            } catch (InvocationTargetException e3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(this.f24952e.getName());
                sb3.append(" threw an exception");
                Log.e(str2, sb3.toString(), e3);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Class m31786a(Class cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return cls == Character.class ? Character.TYPE : cls;
    }

    /* renamed from: b */
    private Method m31787b(Class cls) {
        Class[] clsArr = new Class[this.f24949b.length];
        int i = 0;
        while (true) {
            Object[] objArr = this.f24949b;
            if (i >= objArr.length) {
                break;
            }
            clsArr[i] = objArr[i].getClass();
            i++;
        }
        Method[] methods = cls.getMethods();
        int length = methods.length;
        for (int i2 = 0; i2 < length; i2++) {
            Method method = methods[i2];
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.f24948a) && parameterTypes.length == this.f24949b.length && m31786a(this.f24950c).isAssignableFrom(m31786a(method.getReturnType()))) {
                boolean z = true;
                for (int i3 = 0; i3 < parameterTypes.length && z; i3++) {
                    z = m31786a(parameterTypes[i3]).isAssignableFrom(m31786a(clsArr[i3]));
                }
                if (z) {
                    return method;
                }
            }
        }
        return null;
    }
}
