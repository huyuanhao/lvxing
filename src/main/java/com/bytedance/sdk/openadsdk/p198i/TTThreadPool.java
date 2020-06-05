package com.bytedance.sdk.openadsdk.p198i;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.openadsdk.i.e */
public class TTThreadPool {
    /* renamed from: a */
    private static final int f8978a = Runtime.getRuntime().availableProcessors();
    /* renamed from: b */
    private static final int f8979b;
    /* renamed from: c */
    private static final int f8980c;
    /* renamed from: d */
    private static final int f8981d;
    /* renamed from: e */
    private static final PriorityBlockingQueue<Runnable> f8982e = new PriorityBlockingQueue<>();
    /* renamed from: f */
    private static final PriorityBlockingQueue<Runnable> f8983f = new PriorityBlockingQueue<>();
    /* renamed from: g */
    private static final PriorityBlockingQueue<Runnable> f8984g = new PriorityBlockingQueue<>();
    /* renamed from: h */
    private static final ArrayBlockingQueue<Runnable> f8985h = new ArrayBlockingQueue<>(4);

    static {
        int i = f8978a;
        f8979b = (i / 2) + 1 < 4 ? 4 : (i / 2) + 1;
        int i2 = f8978a;
        f8980c = (i2 / 2) + 1 < 4 ? 4 : (i2 / 2) + 1;
        int i3 = f8978a;
        f8981d = (i3 / 2) + 1 > 4 ? 4 : (i3 / 2) + 1;
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m11707a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f8979b, 5, TimeUnit.SECONDS, f8982e, new TTThreadFactory(5, "tt-api-thread-"), m11712f());
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static ThreadPoolExecutor m11708b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f8980c, 5, TimeUnit.SECONDS, f8983f, new TTThreadFactory(5, "tt-background-thread-"), m11712f());
        return threadPoolExecutor;
    }

    /* renamed from: c */
    public static ScheduledExecutorService m11709c() {
        return Executors.newSingleThreadScheduledExecutor(new TTThreadFactory(1, "tt-delay-thread-"));
    }

    /* renamed from: d */
    public static ThreadPoolExecutor m11710d() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 2, 5, TimeUnit.SECONDS, f8984g, new TTThreadFactory(5, "tt-aidl-thread-"), m11712f());
        return threadPoolExecutor;
    }

    /* renamed from: e */
    public static ThreadPoolExecutor m11711e() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, f8985h, new TTThreadFactory(5, "tt-file-log-upload-thread-"), m11712f());
        return threadPoolExecutor;
    }

    /* renamed from: f */
    public static RejectedExecutionHandler m11712f() {
        return new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
