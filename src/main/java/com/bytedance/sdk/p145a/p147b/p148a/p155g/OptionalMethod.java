package com.bytedance.sdk.p145a.p147b.p148a.p155g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.a.b.a.g.d */
class OptionalMethod<T> {
    /* renamed from: a */
    private final Class<?> f5677a;
    /* renamed from: b */
    private final String f5678b;
    /* renamed from: c */
    private final Class[] f5679c;

    OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f5677a = cls;
        this.f5678b = str;
        this.f5679c = clsArr;
    }

    /* renamed from: a */
    public boolean mo13889a(T t) {
        return m7286a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo13888a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m7286a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public Object mo13890b(T t, Object... objArr) {
        try {
            return mo13888a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: c */
    public Object mo13891c(T t, Object... objArr) throws InvocationTargetException {
        Method a = m7286a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpectedly could not call: ");
                sb.append(a);
                AssertionError assertionError = new AssertionError(sb.toString());
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Method ");
            sb2.append(this.f5678b);
            sb2.append(" not supported for object ");
            sb2.append(t);
            throw new AssertionError(sb2.toString());
        }
    }

    /* renamed from: d */
    public Object mo13892d(T t, Object... objArr) {
        try {
            return mo13891c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private Method m7286a(Class<?> cls) {
        String str = this.f5678b;
        if (str == null) {
            return null;
        }
        Method a = m7287a(cls, str, this.f5679c);
        if (a != null) {
            Class<?> cls2 = this.f5677a;
            if (cls2 != null && !cls2.isAssignableFrom(a.getReturnType())) {
                return null;
            }
        }
        return a;
    }

    /* renamed from: a */
    private static Method m7287a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) != 0) {
                    return method;
                }
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
        }
        return null;
    }
}
