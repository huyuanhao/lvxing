package com.bumptech.glide.load.engine.p138b;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.Log;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bumptech.glide.load.engine.b.a */
public final class GlideExecutor implements ExecutorService {
    /* renamed from: a */
    private static final long f4493a = TimeUnit.SECONDS.toMillis(10);
    /* renamed from: b */
    private static volatile int f4494b;
    /* renamed from: c */
    private final ExecutorService f4495c;

    /* compiled from: GlideExecutor */
    /* renamed from: com.bumptech.glide.load.engine.b.a$a */
    private static final class C1648a implements ThreadFactory {
        /* renamed from: a */
        final C1650b f4496a;
        /* renamed from: b */
        final boolean f4497b;
        /* renamed from: c */
        private final String f4498c;
        /* renamed from: d */
        private int f4499d;

        C1648a(String str, C1650b bVar, boolean z) {
            this.f4498c = str;
            this.f4496a = bVar;
            this.f4497b = z;
        }

        public synchronized Thread newThread(Runnable runnable) {
            C16491 r0;
            StringBuilder sb = new StringBuilder();
            sb.append("glide-");
            sb.append(this.f4498c);
            sb.append("-thread-");
            sb.append(this.f4499d);
            r0 = new Thread(runnable, sb.toString()) {
                public void run() {
                    Process.setThreadPriority(9);
                    if (C1648a.this.f4497b) {
                        StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        C1648a.this.f4496a.mo12774a(th);
                    }
                }
            };
            this.f4499d++;
            return r0;
        }
    }

    /* compiled from: GlideExecutor */
    /* renamed from: com.bumptech.glide.load.engine.b.a$b */
    public interface C1650b {
        /* renamed from: a */
        public static final C1650b f4501a = new C1650b() {
            /* renamed from: a */
            public void mo12774a(Throwable th) {
            }
        };
        /* renamed from: b */
        public static final C1650b f4502b = new C1650b() {
            /* renamed from: a */
            public void mo12774a(Throwable th) {
                if (th != null) {
                    String str = "GlideExecutor";
                    if (Log.isLoggable(str, 6)) {
                        Log.e(str, "Request threw uncaught throwable", th);
                    }
                }
            }
        };
        /* renamed from: c */
        public static final C1650b f4503c = new C1650b() {
            /* renamed from: a */
            public void mo12774a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };
        /* renamed from: d */
        public static final C1650b f4504d = f4502b;

        /* renamed from: a */
        void mo12774a(Throwable th);
    }

    /* renamed from: a */
    public static GlideExecutor m5506a() {
        return m5508a(1, "disk-cache", C1650b.f4504d);
    }

    /* renamed from: a */
    public static GlideExecutor m5508a(int i, String str, C1650b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1648a(str, bVar, true));
        return new GlideExecutor(threadPoolExecutor);
    }

    /* renamed from: b */
    public static GlideExecutor m5509b() {
        return m5510b(m5513e(), ArgKey.KEY_SOURCE, C1650b.f4504d);
    }

    /* renamed from: b */
    public static GlideExecutor m5510b(int i, String str, C1650b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1648a(str, bVar, false));
        return new GlideExecutor(threadPoolExecutor);
    }

    /* renamed from: c */
    public static GlideExecutor m5511c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, f4493a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new C1648a("source-unlimited", C1650b.f4504d, false));
        return new GlideExecutor(threadPoolExecutor);
    }

    /* renamed from: d */
    public static GlideExecutor m5512d() {
        return m5507a(m5513e() >= 4 ? 2 : 1, C1650b.f4504d);
    }

    /* renamed from: a */
    public static GlideExecutor m5507a(int i, C1650b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, i, f4493a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1648a("animation", bVar, true));
        return new GlideExecutor(threadPoolExecutor);
    }

    GlideExecutor(ExecutorService executorService) {
        this.f4495c = executorService;
    }

    public void execute(Runnable runnable) {
        this.f4495c.execute(runnable);
    }

    public Future<?> submit(Runnable runnable) {
        return this.f4495c.submit(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f4495c.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f4495c.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f4495c.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f4495c.invokeAny(collection, j, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f4495c.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f4495c.submit(callable);
    }

    public void shutdown() {
        this.f4495c.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f4495c.shutdownNow();
    }

    public boolean isShutdown() {
        return this.f4495c.isShutdown();
    }

    public boolean isTerminated() {
        return this.f4495c.isTerminated();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f4495c.awaitTermination(j, timeUnit);
    }

    public String toString() {
        return this.f4495c.toString();
    }

    /* renamed from: e */
    public static int m5513e() {
        if (f4494b == 0) {
            f4494b = Math.min(4, RuntimeCompat.m5518a());
        }
        return f4494b;
    }
}
