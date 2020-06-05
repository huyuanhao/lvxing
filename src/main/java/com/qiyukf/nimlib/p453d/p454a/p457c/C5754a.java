package com.qiyukf.nimlib.p453d.p454a.p457c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.qiyukf.nimlib.d.a.c.a */
public final class C5754a {
    /* renamed from: a */
    private static C5754a f18339a;
    /* renamed from: b */
    private static Handler f18340b;
    /* renamed from: c */
    private final HashMap<String, HandlerThread> f18341c = new HashMap<>();

    private C5754a() {
    }

    /* renamed from: a */
    public static Handler m23150a(Context context) {
        if (f18340b == null) {
            f18340b = new Handler(context.getMainLooper());
        }
        return f18340b;
    }

    /* renamed from: a */
    public static synchronized C5754a m23151a() {
        C5754a aVar;
        synchronized (C5754a.class) {
            if (f18339a == null) {
                f18339a = new C5754a();
            }
            aVar = f18339a;
        }
        return aVar;
    }

    /* renamed from: b */
    public static Handler m23152b(Context context) {
        return new Handler(context.getMainLooper());
    }

    /* renamed from: b */
    private HandlerThread m23153b(String str) {
        HandlerThread handlerThread;
        synchronized (this.f18341c) {
            handlerThread = (HandlerThread) this.f18341c.get(str);
            if (handlerThread == null) {
                StringBuilder sb = new StringBuilder("HT-");
                sb.append(TextUtils.isEmpty(str) ? "Default" : str);
                handlerThread = new HandlerThread(sb.toString());
                handlerThread.start();
                this.f18341c.put(str, handlerThread);
            }
        }
        return handlerThread;
    }

    /* renamed from: a */
    public final Handler mo28030a(String str) {
        return new Handler(m23153b(str).getLooper());
    }
}
