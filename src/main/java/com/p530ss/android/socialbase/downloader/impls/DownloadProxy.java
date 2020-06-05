package com.p530ss.android.socialbase.downloader.impls;

import com.p530ss.android.socialbase.downloader.downloader.IDownloadProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.ss.android.socialbase.downloader.impls.l */
public class DownloadProxy {
    /* renamed from: a */
    private static volatile IDownloadProxy f22213a;
    /* renamed from: b */
    private static volatile IDownloadProxy f22214b;

    /* compiled from: DownloadProxy */
    /* renamed from: com.ss.android.socialbase.downloader.impls.l$a */
    private static class C6732a implements InvocationHandler {
        /* renamed from: a */
        private volatile IDownloadProxy f22215a;

        public C6732a(boolean z) {
            if (!z) {
                this.f22215a = new ProcessDownloadHandler();
            } else {
                this.f22215a = new IndependentProcessDownloadHandler();
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (this.f22215a != null) {
                    return method.invoke(this.f22215a, objArr);
                }
                return null;
            } catch (InvocationTargetException e) {
                if (e.getCause() != null) {
                    e.getCause().printStackTrace();
                }
                throw e.getCause();
            }
        }
    }

    /* renamed from: a */
    public static IDownloadProxy m28368a(boolean z) {
        Class<DownloadProxy> cls = DownloadProxy.class;
        if (z) {
            if (f22214b == null) {
                synchronized (cls) {
                    if (f22214b == null) {
                        f22214b = (IDownloadProxy) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{IDownloadProxy.class}, new C6732a(true));
                    }
                }
            }
            return f22214b;
        }
        if (f22213a == null) {
            synchronized (cls) {
                if (f22213a == null) {
                    f22213a = (IDownloadProxy) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{IDownloadProxy.class}, new C6732a(false));
                }
            }
        }
        return f22213a;
    }
}
