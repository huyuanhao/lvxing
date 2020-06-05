package com.qiyukf.nimlib.p453d.p454a.p457c;

import android.os.Build.VERSION;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.nimlib.d.a.c.b */
public final class C5755b implements Executor {
    /* renamed from: a */
    public static final Executor f18342a = new Executor() {
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    /* renamed from: b */
    private final String f18343b;
    /* renamed from: c */
    private final C5757a f18344c;
    /* renamed from: d */
    private ExecutorService f18345d;

    /* renamed from: com.qiyukf.nimlib.d.a.c.b$a */
    public static class C5757a {
        /* renamed from: a */
        public int f18346a = 1;
        /* renamed from: b */
        public int f18347b = 2;
        /* renamed from: c */
        public int f18348c = C7516p.f25219Cf;
        /* renamed from: d */
        public boolean f18349d = true;
    }

    /* renamed from: com.qiyukf.nimlib.d.a.c.b$b */
    static class C5758b implements ThreadFactory {
        /* renamed from: a */
        private final ThreadGroup f18350a;
        /* renamed from: b */
        private final AtomicInteger f18351b = new AtomicInteger(1);
        /* renamed from: c */
        private final String f18352c;

        C5758b(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f18350a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("#");
            this.f18352c = sb.toString();
        }

        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f18350a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f18352c);
            sb.append(this.f18351b.getAndIncrement());
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

    public C5755b(String str, C5757a aVar) {
        this(str, aVar, 0);
    }

    private C5755b(String str, C5757a aVar, byte b) {
        this.f18343b = str;
        this.f18344c = aVar;
        synchronized (this) {
            if (this.f18345d == null || this.f18345d.isShutdown()) {
                C5757a aVar2 = this.f18344c;
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(aVar2.f18346a, aVar2.f18347b, (long) aVar2.f18348c, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(20), new C5758b(this.f18343b), new DiscardPolicy());
                if (VERSION.SDK_INT > 8) {
                    threadPoolExecutor.allowCoreThreadTimeOut(aVar2.f18349d);
                }
                this.f18345d = threadPoolExecutor;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
            return;
     */
    public final void execute(java.lang.Runnable r2) {
        /*
        r1 = this;
        monitor-enter(r1)
        java.util.concurrent.ExecutorService r0 = r1.f18345d     // Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0015
        java.util.concurrent.ExecutorService r0 = r1.f18345d     // Catch:{ all -> 0x0017 }
        boolean r0 = r0.isShutdown()     // Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x000e
        goto L_0x0015
    L_0x000e:
        java.util.concurrent.ExecutorService r0 = r1.f18345d     // Catch:{ all -> 0x0017 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p454a.p457c.C5755b.execute(java.lang.Runnable):void");
    }
}
