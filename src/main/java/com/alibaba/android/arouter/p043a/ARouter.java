package com.alibaba.android.arouter.p043a;

import android.app.Application;
import android.content.Context;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;

/* renamed from: com.alibaba.android.arouter.a.a */
public final class ARouter {
    /* renamed from: a */
    public static ILogger f2236a = null;
    /* renamed from: b */
    private static volatile ARouter f2237b = null;
    /* renamed from: c */
    private static volatile boolean f2238c = false;

    private ARouter() {
    }

    /* renamed from: a */
    public static void m2128a(Application application) {
        if (!f2238c) {
            f2236a = _ARouter.f2239a;
            ILogger iLogger = _ARouter.f2239a;
            String str = ILogger.defaultTag;
            iLogger.info(str, "ARouter init start.");
            f2238c = _ARouter.m2140a(application);
            if (f2238c) {
                _ARouter.m2144c();
            }
            _ARouter.f2239a.info(str, "ARouter init over.");
        }
    }

    /* renamed from: a */
    public static ARouter m2127a() {
        if (f2238c) {
            if (f2237b == null) {
                synchronized (ARouter.class) {
                    if (f2237b == null) {
                        f2237b = new ARouter();
                    }
                }
            }
            return f2237b;
        }
        throw new InitException("ARouter::Init::Invoke init(context) first!");
    }

    /* renamed from: b */
    public static boolean m2129b() {
        return _ARouter.m2143b();
    }

    /* renamed from: a */
    public void mo10489a(Object obj) {
        _ARouter.m2138a(obj);
    }

    /* renamed from: a */
    public Postcard mo10486a(String str) {
        return _ARouter.m2134a().mo10490a(str);
    }

    /* renamed from: a */
    public <T> T mo10488a(Class<? extends T> cls) {
        return _ARouter.m2134a().mo10493a(cls);
    }

    /* renamed from: a */
    public Object mo10487a(Context context, Postcard postcard, int i, NavigationCallback navigationCallback) {
        return _ARouter.m2134a().mo10492a(context, postcard, i, navigationCallback);
    }
}
