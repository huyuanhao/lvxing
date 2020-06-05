package com.alibaba.baichuan.trade.common.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.alibaba.baichuan.trade.common.utils.b */
public class C1227b {
    /* renamed from: d */
    private static volatile C1227b f2518d;
    /* renamed from: a */
    private Handler f2519a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    private HandlerThread f2520b = new HandlerThread("SDK Looper Thread");
    /* renamed from: c */
    private Handler f2521c;

    private C1227b() {
        this.f2520b.start();
        while (this.f2520b.getLooper() == null) {
            try {
                this.f2520b.wait();
            } catch (InterruptedException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("创建handlerThread错误：");
                sb.append(e.getMessage());
                C1224a.m2406d("ExecutorServiceUtils", sb.toString());
            }
        }
        this.f2521c = new Handler(this.f2520b.getLooper()) {
            public void handleMessage(Message message) {
                try {
                    super.handleMessage(message);
                } catch (Throwable th) {
                    C1224a.m2404b("ExecutorServiceUtils", th.getMessage());
                }
            }
        };
    }

    /* renamed from: a */
    public static C1227b m2414a() {
        if (f2518d == null) {
            synchronized (C1227b.class) {
                if (f2518d == null) {
                    f2518d = new C1227b();
                }
            }
        }
        return f2518d;
    }

    /* renamed from: a */
    public void mo10881a(Runnable runnable) {
        this.f2521c.post(runnable);
    }

    /* renamed from: b */
    public void mo10882b(Runnable runnable) {
        this.f2519a.post(runnable);
    }
}
