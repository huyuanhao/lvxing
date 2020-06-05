package okhttp3.internal.p701e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod */
/* renamed from: okhttp3.internal.e.e */
class C8446e<T> {
    /* renamed from: a */
    private final Class<?> f28644a;
    /* renamed from: b */
    private final String f28645b;
    /* renamed from: c */
    private final Class[] f28646c;

    C8446e(Class<?> cls, String str, Class... clsArr) {
        this.f28644a = cls;
        this.f28645b = str;
        this.f28646c = clsArr;
    }

    /* renamed from: a */
    public boolean mo40342a(T t) {
        return m36188a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo40341a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m36188a(t.getClass());
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
    public Object mo40343b(T t, Object... objArr) {
        try {
            return mo40341a(t, objArr);
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
    public Object mo40344c(T t, Object... objArr) throws InvocationTargetException {
        Method a = m36188a(t.getClass());
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
            sb2.append(this.f28645b);
            sb2.append(" not supported for object ");
            sb2.append(t);
            throw new AssertionError(sb2.toString());
        }
    }

    /* renamed from: d */
    public Object mo40345d(T t, Object... objArr) {
        try {
            return mo40344c(t, objArr);
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
    private Method m36188a(Class<?> cls) {
        String str = this.f28645b;
        if (str == null) {
            return null;
        }
        Method a = m36189a(cls, str, this.f28646c);
        if (a != null) {
            Class<?> cls2 = this.f28644a;
            if (cls2 != null && !cls2.isAssignableFrom(a.getReturnType())) {
                return null;
            }
        }
        return a;
    }

    /* renamed from: a */
    private static Method m36189a(Class<?> cls, String str, Class[] clsArr) {
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
