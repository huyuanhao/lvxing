package com.qiyukf.basesdk.p412c;

import android.os.Build.VERSION;
import com.tencent.bugly.BuglyStrategy.C7120a;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.basesdk.c.e */
public final class C5420e implements Executor {
    /* renamed from: a */
    public static final Executor f17393a = new Executor() {
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    /* renamed from: b */
    public static C5423a f17394b = new C5423a(3, 5, true);
    /* renamed from: c */
    public static C5423a f17395c = new C5423a(1, 1, false);
    /* renamed from: d */
    Comparator<Runnable> f17396d = new Comparator<Runnable>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return C5424b.m22172a((C5424b) ((Runnable) obj), (C5424b) ((Runnable) obj2));
        }
    };
    /* renamed from: e */
    private final String f17397e;
    /* renamed from: f */
    private final C5423a f17398f;
    /* renamed from: g */
    private ExecutorService f17399g;

    /* renamed from: com.qiyukf.basesdk.c.e$a */
    public static class C5423a {
        /* renamed from: a */
        public int f17401a;
        /* renamed from: b */
        public int f17402b;
        /* renamed from: c */
        public int f17403c = C7120a.MAX_USERDATA_VALUE_LENGTH;
        /* renamed from: d */
        public boolean f17404d;

        public C5423a(int i, int i2, boolean z) {
            this.f17401a = i;
            this.f17402b = i2;
            this.f17404d = z;
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.e$b */
    private static class C5424b implements Runnable {
        /* renamed from: a */
        private static int f17405a;
        /* renamed from: b */
        private Runnable f17406b;
        /* renamed from: c */
        private int f17407c;
        /* renamed from: d */
        private int f17408d;

        public C5424b(Runnable runnable, int i) {
            int i2 = f17405a;
            f17405a = i2 + 1;
            this.f17408d = i2;
            this.f17406b = runnable;
            this.f17407c = i;
        }

        /* renamed from: a */
        public static final int m22172a(C5424b bVar, C5424b bVar2) {
            int i = bVar.f17407c;
            int i2 = bVar2.f17407c;
            return i != i2 ? i2 - i : bVar.f17408d - bVar2.f17408d;
        }

        public final void run() {
            Runnable runnable = this.f17406b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.e$c */
    static class C5425c implements ThreadFactory {
        /* renamed from: a */
        private final ThreadGroup f17409a;
        /* renamed from: b */
        private final AtomicInteger f17410b = new AtomicInteger(1);
        /* renamed from: c */
        private final String f17411c;

        C5425c(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f17409a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("#");
            this.f17411c = sb.toString();
        }

        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f17409a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f17411c);
            sb.append(this.f17410b.getAndIncrement());
            Thread thread = new Thread(threadGroup, runnable, sb.toString(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public C5420e(String str, C5423a aVar, boolean z) {
        this.f17397e = str;
        this.f17398f = aVar;
        if (z) {
            mo27364a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
            return;
     */
    /* renamed from: a */
    private void m22168a(java.lang.Runnable r2) {
        /*
        r1 = this;
        monitor-enter(r1)
        java.util.concurrent.ExecutorService r0 = r1.f17399g     // Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0015
        java.util.concurrent.ExecutorService r0 = r1.f17399g     // Catch:{ all -> 0x0017 }
        boolean r0 = r0.isShutdown()     // Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x000e
        goto L_0x0015
    L_0x000e:
        java.util.concurrent.ExecutorService r0 = r1.f17399g     // Catch:{ all -> 0x0017 }
        r0.execute(r2)     // Catch:{ all -> 0x0017 }
        monitor-exit(r1)     // Catch:{ all -> 0x0017 }
        return
    L_0x0015:
        monitor-exit(r1)     // Catch:{ all -> 0x0017 }
        return
    L_0x0017:
        r2 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x0017 }
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.C5420e.m22168a(java.lang.Runnable):void");
    }

    /* renamed from: a */
    public final void mo27364a() {
        synchronized (this) {
            if (this.f17399g == null || this.f17399g.isShutdown()) {
                C5423a aVar = this.f17398f;
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(aVar.f17401a, aVar.f17402b, (long) aVar.f17403c, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, this.f17396d), new C5425c(this.f17397e), new DiscardPolicy());
                boolean z = aVar.f17404d;
                if (VERSION.SDK_INT >= 9) {
                    threadPoolExecutor.allowCoreThreadTimeOut(z);
                }
                this.f17399g = threadPoolExecutor;
            }
        }
    }

    /* renamed from: a */
    public final void mo27365a(Runnable runnable, int i) {
        m22168a(new C5424b(runnable, i));
    }

    /* renamed from: b */
    public final void mo27366b() {
        ExecutorService executorService;
        synchronized (this) {
            if (this.f17399g != null) {
                executorService = this.f17399g;
                this.f17399g = null;
            } else {
                executorService = null;
            }
        }
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    public final void execute(Runnable runnable) {
        m22168a(new C5424b(runnable, 0));
    }
}
