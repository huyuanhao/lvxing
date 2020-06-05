package com.qiyukf.unicorn.p516j;

import android.os.Handler;
import android.os.Looper;
import com.qiyukf.basesdk.p412c.C5361a;

/* renamed from: com.qiyukf.unicorn.j.e */
public final class C6218e {
    /* renamed from: a */
    private static Handler f19405a;

    /* renamed from: a */
    private static synchronized Handler m24650a() {
        Handler handler;
        synchronized (C6218e.class) {
            if (f19405a == null) {
                f19405a = C5361a.m22014b();
            }
            handler = f19405a;
        }
        return handler;
    }

    /* renamed from: a */
    public static void m24651a(Runnable runnable) {
        m24652b(runnable);
    }

    /* renamed from: b */
    public static void m24652b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            m24650a().post(runnable);
        }
    }
}
