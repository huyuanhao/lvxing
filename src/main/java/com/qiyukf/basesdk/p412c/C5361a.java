package com.qiyukf.basesdk.p412c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.qiyukf.basesdk.c.a */
public final class C5361a {
    /* renamed from: a */
    private static C5361a f17302a;
    /* renamed from: b */
    private static Handler f17303b;
    /* renamed from: c */
    private final HashMap<String, HandlerThread> f17304c = new HashMap<>();

    private C5361a() {
    }

    /* renamed from: a */
    public static synchronized C5361a m22013a() {
        C5361a aVar;
        synchronized (C5361a.class) {
            if (f17302a == null) {
                f17302a = new C5361a();
            }
            aVar = f17302a;
        }
        return aVar;
    }

    /* renamed from: b */
    public static Handler m22014b() {
        if (f17303b == null) {
            f17303b = new Handler(Looper.getMainLooper());
        }
        return f17303b;
    }

    /* renamed from: b */
    private HandlerThread m22015b(String str) {
        HandlerThread handlerThread;
        synchronized (this.f17304c) {
            handlerThread = (HandlerThread) this.f17304c.get(str);
            if (handlerThread == null) {
                StringBuilder sb = new StringBuilder("HT-");
                sb.append(TextUtils.isEmpty(str) ? "Default" : str);
                handlerThread = new HandlerThread(sb.toString());
                handlerThread.start();
                this.f17304c.put(str, handlerThread);
            }
        }
        return handlerThread;
    }

    /* renamed from: a */
    public final Handler mo27316a(String str) {
        return new Handler(m22015b(str).getLooper());
    }

    /* renamed from: c */
    public final Handler mo27317c() {
        return mo27316a("Default");
    }
}
