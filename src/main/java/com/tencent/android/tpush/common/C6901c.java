package com.tencent.android.tpush.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.android.tpush.p580b.C6864a;
import java.lang.Thread.State;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.c */
public class C6901c {
    /* renamed from: a */
    private static HandlerThread f22972a;
    /* renamed from: b */
    private static Handler f22973b;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.common.c$a */
    public static class C6903a {
        /* renamed from: a */
        public static C6901c f22974a = new C6901c();
    }

    private C6901c() {
    }

    /* renamed from: a */
    public static C6901c m29459a() {
        m29460c();
        return C6903a.f22974a;
    }

    /* renamed from: a */
    public boolean mo33104a(Runnable runnable) {
        Handler handler = f22973b;
        if (handler != null) {
            return handler.post(runnable);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo33106a(Runnable runnable, long j) {
        Handler handler = f22973b;
        if (handler != null) {
            return handler.postDelayed(runnable, j);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo33105a(Runnable runnable, int i, long j) {
        Handler handler = f22973b;
        if (handler != null) {
            return handler.postAtTime(runnable, Integer.valueOf(i), SystemClock.uptimeMillis() + j);
        }
        return false;
    }

    /* renamed from: a */
    public void mo33103a(int i) {
        Handler handler = f22973b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(Integer.valueOf(i));
        }
    }

    /* renamed from: b */
    public Handler mo33107b() {
        return f22973b;
    }

    /* renamed from: c */
    private static void m29460c() {
        try {
            if (f22972a == null || !f22972a.isAlive() || f22972a.isInterrupted() || f22972a.getState() == State.TERMINATED) {
                f22972a = new HandlerThread("tpush.working.thread");
                f22972a.start();
                Looper looper = f22972a.getLooper();
                if (looper != null) {
                    f22973b = new Handler(looper);
                } else {
                    C6864a.m29308i("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable unused) {
        }
    }
}
