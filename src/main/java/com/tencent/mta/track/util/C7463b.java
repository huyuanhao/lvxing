package com.tencent.mta.track.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread.State;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.util.b */
public class C7463b {
    /* renamed from: a */
    private static HandlerThread f25024a;
    /* renamed from: b */
    private static Handler f25025b;

    private C7463b() {
    }

    /* renamed from: a */
    public static C7463b m32331a() {
        m32332b();
        return C7465d.f25026a;
    }

    /* renamed from: a */
    public boolean mo36422a(Runnable runnable) {
        Handler handler = f25025b;
        if (handler != null) {
            return handler.post(runnable);
        }
        return false;
    }

    /* renamed from: b */
    private static void m32332b() {
        try {
            if (f25024a == null || !f25024a.isAlive() || f25024a.isInterrupted() || f25024a.getState() == State.TERMINATED) {
                f25024a = new HandlerThread("tpush.working.thread");
                f25024a.start();
                Looper looper = f25024a.getLooper();
                if (looper != null) {
                    f25025b = new Handler(looper);
                } else {
                    Log.e("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable unused) {
        }
    }
}
