package com.pgl.p359a.p361b;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.pgl.a.b.c */
public class C4784c {
    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f15431a = new HashMap();

    /* renamed from: com.pgl.a.b.c$a */
    public static class C4785a<T> {
        /* renamed from: a */
        public final Class<? extends T> f15432a;
        /* renamed from: b */
        public final T f15433b;
    }

    static {
        f15431a.put(Boolean.class, Boolean.TYPE);
        f15431a.put(Byte.class, Byte.TYPE);
        f15431a.put(Character.class, Character.TYPE);
        f15431a.put(Short.class, Short.TYPE);
        f15431a.put(Integer.class, Integer.TYPE);
        f15431a.put(Float.class, Float.TYPE);
        f15431a.put(Long.class, Long.TYPE);
        f15431a.put(Double.class, Double.TYPE);
        f15431a.put(Boolean.TYPE, Boolean.TYPE);
        f15431a.put(Byte.TYPE, Byte.TYPE);
        f15431a.put(Character.TYPE, Character.TYPE);
        f15431a.put(Short.TYPE, Short.TYPE);
        f15431a.put(Integer.TYPE, Integer.TYPE);
        f15431a.put(Float.TYPE, Float.TYPE);
        f15431a.put(Long.TYPE, Long.TYPE);
        f15431a.put(Double.TYPE, Double.TYPE);
    }

    /* renamed from: a */
    private static Method m19612a(Class<?> cls, String str, Class... clsArr) {
        Method a = m19613a(cls.getDeclaredMethods(), str, (Class<?>[]) clsArr);
        if (a != null) {
            a.setAccessible(true);
            return a;
        } else if (cls.getSuperclass() != null) {
            return m19612a(cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    /* renamed from: a */
    private static Method m19613a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            int length = methodArr.length;
            for (int i = 0; i < length; i++) {
                Method method = methodArr[i];
                if (method.getName().equals(str) && m19616a(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    /* renamed from: a */
    public static void m19614a(Class<?> cls, String str, Object... objArr) {
        m19612a(cls, str, m19617a(objArr)).invoke(null, m19618b(objArr));
    }

    /* renamed from: a */
    public static void m19615a(String str, String str2, Object... objArr) {
        try {
            m19614a(Class.forName(str), str2, objArr);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static boolean m19616a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z = true;
        if (clsArr == null) {
            if (!(clsArr2 == null || clsArr2.length == 0)) {
                z = false;
            }
            return z;
        } else if (clsArr2 == null) {
            if (clsArr.length != 0) {
                z = false;
            }
            return z;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            int i = 0;
            while (i < clsArr.length) {
                if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!f15431a.containsKey(clsArr[i]) || !((Class) f15431a.get(clsArr[i])).equals(f15431a.get(clsArr2[i])))) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }

    /* renamed from: a */
    private static Class<?>[] m19617a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            C4785a aVar = objArr[i];
            if (aVar == null || !(aVar instanceof C4785a)) {
                clsArr[i] = aVar == null ? null : aVar.getClass();
            } else {
                clsArr[i] = aVar.f15432a;
            }
        }
        return clsArr;
    }

    /* renamed from: b */
    private static Object[] m19618b(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            C4785a aVar = objArr[i];
            if (aVar == null || !(aVar instanceof C4785a)) {
                objArr2[i] = aVar;
            } else {
                objArr2[i] = aVar.f15433b;
            }
        }
        return objArr2;
    }
}
