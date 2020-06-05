package com.tencent.android.tpush.cloudctr.p583b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.android.tpush.p580b.C6864a;
import java.lang.Thread.State;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.cloudctr.b.c */
public class C6891c {
    /* renamed from: a */
    private String f22951a = "common work thread";
    /* renamed from: b */
    private HandlerThread f22952b;
    /* renamed from: c */
    private Handler f22953c;

    public C6891c(String str) {
        if (str != null) {
            this.f22951a = str;
        }
        m29432a();
    }

    /* renamed from: a */
    public void mo33077a(Runnable runnable) {
        m29432a();
        Handler handler = this.f22953c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    /* renamed from: a */
    private void m29432a() {
        try {
            synchronized (C6891c.class) {
                if (this.f22952b == null || !this.f22952b.isAlive() || this.f22952b.isInterrupted() || this.f22952b.getState() == State.TERMINATED) {
                    this.f22952b = new HandlerThread(this.f22951a);
                    this.f22952b.start();
                    Looper looper = this.f22952b.getLooper();
                    if (looper != null) {
                        this.f22953c = new Handler(looper);
                    } else {
                        C6864a.m29308i(this.f22951a, "Create new working thread false, cause thread.getLooper()==null");
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
