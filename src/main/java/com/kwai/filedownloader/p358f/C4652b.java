package com.kwai.filedownloader.p358f;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwai.filedownloader.f.b */
public class C4652b {

    /* renamed from: com.kwai.filedownloader.f.b$a */
    static class C4653a implements ThreadFactory {
        /* renamed from: a */
        private static final AtomicInteger f15174a = new AtomicInteger(1);
        /* renamed from: b */
        private final String f15175b;
        /* renamed from: c */
        private final ThreadGroup f15176c = Thread.currentThread().getThreadGroup();
        /* renamed from: d */
        private final AtomicInteger f15177d = new AtomicInteger(1);

        C4653a(String str) {
            this.f15175b = C4664f.m19160i(str);
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f15176c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f15175b);
            sb.append(this.f15177d.getAndIncrement());
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

    /* renamed from: a */
    public static ThreadPoolExecutor m19102a(int i, String str) {
        return m19103a(i, new LinkedBlockingQueue(), str);
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m19103a(int i, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 15, TimeUnit.SECONDS, linkedBlockingQueue, new C4653a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m19104a(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 15, TimeUnit.SECONDS, new SynchronousQueue(), new C4653a(str));
        return threadPoolExecutor;
    }
}
