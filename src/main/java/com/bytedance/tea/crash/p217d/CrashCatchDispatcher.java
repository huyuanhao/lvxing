package com.bytedance.tea.crash.p217d;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.ICrashCallback;
import com.bytedance.tea.crash.ICrashFilter;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p221g.NpthLog;
import com.bytedance.tea.crash.p221g.Stack;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* renamed from: com.bytedance.tea.crash.d.a */
public class CrashCatchDispatcher implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static CrashCatchDispatcher f9281a;
    /* renamed from: b */
    private UncaughtExceptionHandler f9282b;
    /* renamed from: c */
    private HashSet<UncaughtExceptionHandler> f9283c = new HashSet<>();
    /* renamed from: d */
    private ICrashDisposer f9284d;
    /* renamed from: e */
    private long f9285e = -1;

    private CrashCatchDispatcher() {
        m12392c();
        m12390b();
    }

    /* renamed from: b */
    private void m12390b() {
        try {
            new Thread() {
                public void run() {
                    super.run();
                    try {
                        while (true) {
                            SystemClock.sleep(Math.abs(new Random().nextLong()) % 5000);
                            CrashCatchDispatcher.this.m12392c();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }.start();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static CrashCatchDispatcher m12387a() {
        if (f9281a == null) {
            f9281a = new CrashCatchDispatcher();
        }
        return f9281a;
    }

    /* renamed from: a */
    public void mo17013a(ICrashDisposer bVar) {
        this.f9284d = bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12392c() {
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.f9282b == null) {
                this.f9282b = defaultUncaughtExceptionHandler;
            } else {
                this.f9283c.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (SystemClock.uptimeMillis() - this.f9285e >= 20000) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.f9285e = SystemClock.uptimeMillis();
                boolean a = m12389a(thread, th);
                if (!a) {
                    m12393c(thread, th);
                    return;
                }
                CrashType cVar = CrashType.JAVA;
                m12391b(thread, th);
                if (a && this.f9284d != null && this.f9284d.mo17017a(th)) {
                    this.f9284d.mo17016a(currentTimeMillis, thread, th);
                    StringBuilder sb = new StringBuilder();
                    sb.append("end dispose ");
                    sb.append(th);
                    Log.i("crash_dispatcher", sb.toString());
                }
                m12393c(thread, th);
            } catch (Throwable th2) {
                m12393c(thread, th);
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private boolean m12389a(Thread thread, Throwable th) {
        ICrashFilter d = NpthBus.m12593b().mo16975d();
        if (d == null) {
            return true;
        }
        try {
            if (d.mo15834a(th, thread)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: b */
    private void m12391b(Thread thread, Throwable th) {
        List<ICrashCallback> b = NpthBus.m12593b().mo16973b();
        CrashType cVar = CrashType.JAVA;
        for (ICrashCallback a : b) {
            try {
                a.mo17018a(cVar, Stack.m12569a(th), thread);
            } catch (Throwable th2) {
                NpthLog.m12550b(th2);
            }
        }
    }

    /* renamed from: c */
    private void m12393c(Thread thread, Throwable th) {
        try {
            Iterator it = this.f9283c.iterator();
            while (it.hasNext()) {
                try {
                    ((UncaughtExceptionHandler) it.next()).uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f9282b.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }
}
