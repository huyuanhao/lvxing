package com.bytedance.sdk.openadsdk.p198i;

import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.i.a */
public class TTExecutor {
    /* renamed from: a */
    private static volatile TTExecutor f8950a;
    /* renamed from: b */
    private static volatile ThreadPoolExecutor f8951b;
    /* renamed from: c */
    private static volatile ThreadPoolExecutor f8952c;
    /* renamed from: d */
    private static volatile ThreadPoolExecutor f8953d;
    /* renamed from: e */
    private static volatile ThreadPoolExecutor f8954e;
    /* renamed from: f */
    private static volatile ScheduledExecutorService f8955f;
    /* renamed from: g */
    private static ConcurrentHashMap<String, TTRunnable> f8956g;
    /* renamed from: h */
    private static final ConcurrentHashMap<String, TTRunnable> f8957h = new ConcurrentHashMap<>();
    /* renamed from: i */
    private static final ConcurrentHashMap<String, TTRunnable> f8958i = new ConcurrentHashMap<>();
    /* renamed from: j */
    private static final ConcurrentHashMap<String, TTRunnable> f8959j = new ConcurrentHashMap<>();
    /* renamed from: k */
    private static final AtomicBoolean f8960k = new AtomicBoolean();

    /* renamed from: a */
    public static void m11693a(boolean z) {
        if (!f8960k.get()) {
            f8951b = TTThreadPool.m11707a();
            f8952c = TTThreadPool.m11708b();
            f8955f = TTThreadPool.m11709c();
            f8954e = TTThreadPool.m11711e();
            if (z) {
                f8953d = TTThreadPool.m11710d();
                f8956g = new ConcurrentHashMap<>();
            }
            f8960k.set(true);
        }
    }

    /* renamed from: a */
    public static TTExecutor m11692a() {
        if (f8950a == null) {
            synchronized (TTExecutor.class) {
                if (f8950a == null) {
                    f8950a = new TTExecutor();
                }
            }
        }
        return f8950a;
    }

    private TTExecutor() {
        if (!f8960k.get()) {
            m11693a(false);
        }
    }

    /* renamed from: b */
    public ExecutorService mo16805b() {
        if (f8954e == null) {
            f8954e = TTThreadPool.m11711e();
        }
        return f8954e;
    }

    /* renamed from: a */
    public void mo16804a(final Runnable runnable, int i) {
        if (runnable == null) {
            if (C2564t.m12224c()) {
                C2564t.m12226e("", "executeAIDLTask -> runnable param is not be null");
            }
            return;
        }
        m11694c();
        f8953d.execute(new TTRunnable(i) {
            public void run() {
                runnable.run();
            }
        });
    }

    /* renamed from: c */
    private void m11694c() {
        if (f8953d == null) {
            f8953d = TTThreadPool.m11710d();
            f8956g = new ConcurrentHashMap<>();
        }
    }

    /* renamed from: a */
    public void mo16803a(TTRunnable cVar) {
        if (cVar == null) {
            if (C2564t.m12224c()) {
                C2564t.m12226e("", "executeApiTask->TTRunnable param is not be null");
            }
            return;
        }
        if (f8951b != null) {
            f8951b.execute(cVar);
        }
    }

    /* renamed from: b */
    public void mo16807b(final Runnable runnable, int i) {
        if (runnable == null) {
            if (C2564t.m12224c()) {
                C2564t.m12226e("", "executeApiTask->runnable param is not be null");
            }
            return;
        }
        if (f8951b != null) {
            f8951b.execute(new TTRunnable(i) {
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    /* renamed from: b */
    public void mo16806b(TTRunnable cVar) {
        if (cVar == null) {
            if (C2564t.m12224c()) {
                C2564t.m12226e("", "executeDefaultTask -> runnable param is not be null");
            }
            return;
        }
        if (f8952c != null) {
            f8952c.execute(cVar);
        }
    }

    /* renamed from: c */
    public void mo16808c(final Runnable runnable, int i) {
        if (runnable == null) {
            if (C2564t.m12224c()) {
                C2564t.m12226e("", "executeDefaultTask -> runnable param is not be null");
            }
            return;
        }
        if (f8952c != null) {
            f8952c.execute(new TTRunnable(i) {
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    /* renamed from: d */
    public void mo16809d(final Runnable runnable, int i) {
        if (runnable == null) {
            if (C2564t.m12224c()) {
                C2564t.m12226e("", "executeLogUploadTask（Runnable） -> runnable param is not be null");
            }
            return;
        }
        if (f8954e != null) {
            f8954e.execute(new TTRunnable(i) {
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    /* renamed from: a */
    public ScheduledFuture<?> mo16802a(Runnable runnable, long j) {
        if (runnable == null) {
            if (C2564t.m12224c()) {
                C2564t.m12226e("", "delayExecuteTask->runnable param is not be null");
            }
            return null;
        } else if (j > 0) {
            return f8955f.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            f8955f.execute(runnable);
            return null;
        }
    }
}
