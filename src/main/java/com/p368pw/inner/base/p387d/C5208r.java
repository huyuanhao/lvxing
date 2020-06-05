package com.p368pw.inner.base.p387d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.pw.inner.base.d.r */
public class C5208r {
    /* renamed from: a */
    public static final Executor f16929a;
    /* renamed from: b */
    private static Handler f16930b = new Handler(Looper.getMainLooper());
    /* renamed from: c */
    private static final int f16931c = Runtime.getRuntime().availableProcessors();
    /* renamed from: d */
    private static final int f16932d = Math.max(2, Math.min(f16931c - 1, 4));
    /* renamed from: e */
    private static final ThreadFactory f16933e = new ThreadFactory() {
        /* renamed from: a */
        private final AtomicInteger f16934a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("winss #");
            sb.append(this.f16934a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        }
    };

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f16932d, 1024, 30, TimeUnit.SECONDS, new SynchronousQueue(), f16933e);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new CallerRunsPolicy());
        f16929a = threadPoolExecutor;
    }

    /* renamed from: a */
    public static void m21479a(Runnable runnable) {
        m21480a(runnable, 0);
    }

    /* renamed from: a */
    public static void m21480a(Runnable runnable, long j) {
        if (j <= 0) {
            try {
                f16930b.post(runnable);
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        } else {
            f16930b.postDelayed(runnable, j);
        }
    }

    /* renamed from: a */
    public static boolean m21481a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: b */
    public static void m21482b(Runnable runnable) {
        m21483b(runnable, 0);
    }

    /* renamed from: b */
    public static void m21483b(final Runnable runnable, long j) {
        if (j <= 0) {
            try {
                f16929a.execute(runnable);
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        } else {
            f16930b.postDelayed(new Runnable() {
                public void run() {
                    C5208r.f16929a.execute(runnable);
                }
            }, j);
        }
    }
}
