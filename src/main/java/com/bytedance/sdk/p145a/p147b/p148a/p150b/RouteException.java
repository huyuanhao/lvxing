package com.bytedance.sdk.p145a.p147b.p148a.p150b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.a.b.a.b.e */
public final class RouteException extends RuntimeException {
    /* renamed from: a */
    private static final Method f5370a;
    /* renamed from: b */
    private IOException f5371b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
            method = null;
        }
        f5370a = method;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f5371b = iOException;
    }

    /* renamed from: a */
    public IOException mo13703a() {
        return this.f5371b;
    }

    /* renamed from: a */
    public void mo13704a(IOException iOException) {
        m6916a(iOException, this.f5371b);
        this.f5371b = iOException;
    }

    /* renamed from: a */
    private void m6916a(IOException iOException, IOException iOException2) {
        Method method = f5370a;
        if (method != null) {
            try {
                method.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
