package com.tencent.bugly.proguard;

import com.tencent.bugly.C7121b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.am */
public class C7224am {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final AtomicInteger f24391a = new AtomicInteger(1);
    /* renamed from: b */
    private static C7224am f24392b;
    /* renamed from: c */
    private ScheduledExecutorService f24393c;

    protected C7224am() {
        this.f24393c = null;
        this.f24393c = Executors.newScheduledThreadPool(3, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("BuglyThread-");
                sb.append(C7224am.f24391a.getAndIncrement());
                thread.setName(sb.toString());
                return thread;
            }
        });
        ScheduledExecutorService scheduledExecutorService = this.f24393c;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            C7226an.m31148d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    /* renamed from: a */
    public static synchronized C7224am m31132a() {
        C7224am amVar;
        synchronized (C7224am.class) {
            if (f24392b == null) {
                f24392b = new C7224am();
            }
            amVar = f24392b;
        }
        return amVar;
    }

    /* renamed from: a */
    public synchronized boolean mo34833a(Runnable runnable, long j) {
        if (!mo34835c()) {
            C7226an.m31148d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            C7226an.m31148d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            if (j <= 0) {
                j = 0;
            }
            C7226an.m31147c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
            try {
                this.f24393c.schedule(runnable, j, TimeUnit.MILLISECONDS);
                return true;
            } catch (Throwable th) {
                if (C7121b.f23665c) {
                    th.printStackTrace();
                }
                return false;
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean mo34832a(Runnable runnable) {
        if (!mo34835c()) {
            C7226an.m31148d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            C7226an.m31148d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            C7226an.m31147c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            try {
                this.f24393c.execute(runnable);
                return true;
            } catch (Throwable th) {
                if (C7121b.f23665c) {
                    th.printStackTrace();
                }
                return false;
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo34834b() {
        if (this.f24393c != null && !this.f24393c.isShutdown()) {
            C7226an.m31147c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f24393c.shutdownNow();
        }
    }

    /* renamed from: c */
    public synchronized boolean mo34835c() {
        boolean z;
        z = this.f24393c != null && !this.f24393c.isShutdown();
        return z;
    }
}
