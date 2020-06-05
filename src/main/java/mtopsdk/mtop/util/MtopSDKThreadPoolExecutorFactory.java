package mtopsdk.mtop.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.C8330d;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.TBSdkLog;

/* renamed from: mtopsdk.mtop.util.b */
public class MtopSDKThreadPoolExecutorFactory {
    /* renamed from: a */
    private static int f28023a = 10;
    /* renamed from: b */
    private static volatile ThreadPoolExecutor f28024b;
    /* renamed from: c */
    private static volatile ThreadPoolExecutor f28025c;
    /* renamed from: d */
    private static volatile ThreadPoolExecutor f28026d;
    /* renamed from: e */
    private static volatile ExecutorService[] f28027e;

    /* compiled from: MtopSDKThreadPoolExecutorFactory */
    /* renamed from: mtopsdk.mtop.util.b$a */
    static class C8337a implements ThreadFactory {
        /* renamed from: a */
        int f28028a = 10;
        /* renamed from: b */
        private final AtomicInteger f28029b = new AtomicInteger();
        /* renamed from: c */
        private String f28030c = "";

        public C8337a(int i) {
            this.f28028a = i;
        }

        public C8337a(int i, String str) {
            this.f28028a = i;
            this.f28030c = str;
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("MTOPSDK ");
            if (C8330d.m35523a(this.f28030c)) {
                sb.append(this.f28030c);
                sb.append(" ");
            } else {
                sb.append("DefaultPool ");
            }
            sb.append("Thread:");
            sb.append(this.f28029b.getAndIncrement());
            return new C8338c(this, runnable, sb.toString());
        }
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m35584a() {
        if (f28024b == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                if (f28024b == null) {
                    f28024b = m35585a(3, 3, 60, 128, new C8337a(f28023a));
                }
            }
        }
        return f28024b;
    }

    /* renamed from: b */
    public static ThreadPoolExecutor m35586b() {
        if (f28025c == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                if (f28025c == null) {
                    f28025c = m35585a(4, 4, 60, 0, new C8337a(f28023a, "RequestPool"));
                }
            }
        }
        return f28025c;
    }

    /* renamed from: c */
    public static ExecutorService[] m35587c() {
        Class<MtopSDKThreadPoolExecutorFactory> cls = MtopSDKThreadPoolExecutorFactory.class;
        if (RemoteConfig.m35521a().f27857j) {
            if (f28026d == null) {
                synchronized (cls) {
                    if (f28026d == null) {
                        f28026d = m35585a(2, 2, 20, 0, new C8337a(f28023a, "CallbackPool"));
                    }
                }
            }
            return new ExecutorService[]{f28026d};
        }
        if (f28027e == null) {
            synchronized (cls) {
                if (f28027e == null) {
                    ExecutorService[] executorServiceArr = new ExecutorService[2];
                    for (int i = 0; i < 2; i++) {
                        int i2 = f28023a;
                        StringBuilder sb = new StringBuilder("CallbackPool");
                        sb.append(i);
                        executorServiceArr[i] = m35585a(1, 1, 60, 0, new C8337a(i2, sb.toString()));
                    }
                    f28027e = executorServiceArr;
                }
            }
        }
        return f28027e;
    }

    /* renamed from: a */
    public static Future<?> m35583a(Runnable runnable) {
        try {
            return m35584a().submit(runnable);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("[submit]submit runnable to Mtop Default ThreadPool error ---");
            sb.append(th.toString());
            TBSdkLog.m35510c("mtopsdk.MtopSDKThreadPoolExecutorFactory", sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static Future<?> m35582a(int i, Runnable runnable) {
        try {
            if (RemoteConfig.m35521a().f27857j) {
                return m35587c()[0].submit(runnable);
            }
            ExecutorService[] c = m35587c();
            return c[Math.abs(i % c.length)].submit(runnable);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("[submitCallbackTask]submit runnable to Mtop Callback ThreadPool error ---");
            sb.append(th.toString());
            TBSdkLog.m35510c("mtopsdk.MtopSDKThreadPoolExecutorFactory", sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m35585a(int i, int i2, int i3, int i4, ThreadFactory threadFactory) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i4 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i4);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        int i5 = i;
        int i6 = i2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i5, i6, (long) i3, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        if (i3 > 0) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return threadPoolExecutor;
    }
}
