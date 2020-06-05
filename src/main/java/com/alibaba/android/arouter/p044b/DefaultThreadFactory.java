package com.alibaba.android.arouter.p044b;

import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.p043a.ARouter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alibaba.android.arouter.b.c */
public class DefaultThreadFactory implements ThreadFactory {
    /* renamed from: a */
    private static final AtomicInteger f2267a = new AtomicInteger(1);
    /* renamed from: b */
    private final AtomicInteger f2268b = new AtomicInteger(1);
    /* renamed from: c */
    private final ThreadGroup f2269c;
    /* renamed from: d */
    private final String f2270d;

    public DefaultThreadFactory() {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f2269c = threadGroup;
        StringBuilder sb = new StringBuilder();
        sb.append("ARouter task pool No.");
        sb.append(f2267a.getAndIncrement());
        sb.append(", thread No.");
        this.f2270d = sb.toString();
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2270d);
        sb.append(this.f2268b.getAndIncrement());
        String sb2 = sb.toString();
        ILogger iLogger = ARouter.f2236a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Thread production, name is [");
        sb3.append(sb2);
        sb3.append("]");
        iLogger.info(ILogger.defaultTag, sb3.toString());
        Thread thread = new Thread(this.f2269c, runnable, sb2, 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                ILogger iLogger = ARouter.f2236a;
                StringBuilder sb = new StringBuilder();
                sb.append("Running task appeared exception! Thread [");
                sb.append(thread.getName());
                sb.append("], because [");
                sb.append(th.getMessage());
                sb.append("]");
                iLogger.info(ILogger.defaultTag, sb.toString());
            }
        });
        return thread;
    }
}
