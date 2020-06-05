package com.ali.auth.third.core.p030h.p031a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ali.auth.third.core.p030h.C1012b;
import com.ali.auth.third.core.p033j.C1018a;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.ali.auth.third.core.h.a.b */
public final class C1008b implements C1012b {
    /* renamed from: a */
    private final Handler f1966a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    private ThreadPoolExecutor f1967b;
    /* renamed from: c */
    private final BlockingQueue<Runnable> f1968c = new LinkedBlockingQueue(128);
    /* renamed from: d */
    private final HandlerThread f1969d = new HandlerThread("SDK Looper Thread");
    /* renamed from: e */
    private final Handler f1970e;

    /* renamed from: com.ali.auth.third.core.h.a.b$a */
    public static class C1011a implements RejectedExecutionHandler {
        /* renamed from: a */
        private BlockingQueue<Runnable> f1975a;

        public C1011a(BlockingQueue<Runnable> blockingQueue) {
            this.f1975a = blockingQueue;
        }

        /* renamed from: a */
        private Object m1938a(Object obj) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("this$0");
                declaredField.setAccessible(true);
                obj = declaredField.get(obj);
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
                return obj;
            }
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Object[] array = this.f1975a.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            int length = array.length;
            for (int i = 0; i < length; i++) {
                Object obj = array[i];
                sb.append(obj.getClass().isAnonymousClass() ? m1938a(obj) : obj.getClass());
                sb.append(',');
                sb.append(' ');
            }
            sb.append(']');
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Task ");
            sb2.append(runnable.toString());
            sb2.append(" rejected from ");
            sb2.append(threadPoolExecutor.toString());
            sb2.append(" in ");
            sb2.append(sb.toString());
            throw new RejectedExecutionException(sb2.toString());
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0028 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0028 A[LOOP:0: B:2:0x0028->B:16:0x0028, LOOP_START, SYNTHETIC] */
    public C1008b() {
        /*
        r11 = this;
        r11.<init>()
        android.os.Handler r0 = new android.os.Handler
        android.os.Looper r1 = android.os.Looper.getMainLooper()
        r0.<init>(r1)
        r11.f1966a = r0
        java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
        r1 = 128(0x80, float:1.794E-43)
        r0.<init>(r1)
        r11.f1968c = r0
        android.os.HandlerThread r0 = new android.os.HandlerThread
        java.lang.String r1 = "SDK Looper Thread"
        r0.<init>(r1)
        r11.f1969d = r0
        android.os.HandlerThread r0 = r11.f1969d
        r0.start()
        android.os.HandlerThread r0 = r11.f1969d
        monitor-enter(r0)
    L_0x0028:
        android.os.HandlerThread r1 = r11.f1969d     // Catch:{ all -> 0x0061 }
        android.os.Looper r1 = r1.getLooper()     // Catch:{ all -> 0x0061 }
        if (r1 != 0) goto L_0x0036
        android.os.HandlerThread r1 = r11.f1969d     // Catch:{ InterruptedException -> 0x0028 }
        r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
        goto L_0x0028
    L_0x0036:
        monitor-exit(r0)     // Catch:{ all -> 0x0061 }
        android.os.Handler r0 = new android.os.Handler
        android.os.HandlerThread r1 = r11.f1969d
        android.os.Looper r1 = r1.getLooper()
        r0.<init>(r1)
        r11.f1970e = r0
        r3 = 8
        r4 = 16
        r0 = 1
        com.ali.auth.third.core.h.a.b$1 r9 = new com.ali.auth.third.core.h.a.b$1
        r9.m41159init()
        java.util.concurrent.ThreadPoolExecutor r1 = new java.util.concurrent.ThreadPoolExecutor
        long r5 = (long) r0
        java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
        java.util.concurrent.BlockingQueue<java.lang.Runnable> r8 = r11.f1968c
        com.ali.auth.third.core.h.a.b$a r10 = new com.ali.auth.third.core.h.a.b$a
        r10.m41161init(r8)
        r2 = r1
        r2.<init>(r3, r4, r5, r7, r8, r9, r10)
        r11.f1967b = r1
        return
    L_0x0061:
        r1 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0061 }
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.p030h.p031a.C1008b.m41158init():void");
    }

    /* renamed from: a */
    public void mo10335a(final Runnable runnable) {
        this.f1966a.post(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    C1018a.m1960a("kernel", th.getMessage(), th);
                }
            }
        });
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f1967b.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f1967b.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f1967b.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f1967b.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f1967b.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f1967b.invokeAny(collection, j, timeUnit);
    }

    public boolean isShutdown() {
        return this.f1967b.isShutdown();
    }

    public boolean isTerminated() {
        return this.f1967b.isTerminated();
    }

    public void shutdown() {
        this.f1967b.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f1967b.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f1967b.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f1967b.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f1967b.submit(callable);
    }
}
