package com.alibaba.android.arouter.p044b;

import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.p043a.ARouter;
import com.alibaba.android.arouter.p045c.TextUtils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.alibaba.android.arouter.b.b */
public class DefaultPoolExecutor extends ThreadPoolExecutor {
    /* renamed from: a */
    private static final int f2263a = Runtime.getRuntime().availableProcessors();
    /* renamed from: b */
    private static final int f2264b = (f2263a + 1);
    /* renamed from: c */
    private static final int f2265c = f2264b;
    /* renamed from: d */
    private static DefaultPoolExecutor f2266d;

    /* renamed from: a */
    public static DefaultPoolExecutor m2151a() {
        if (f2266d == null) {
            synchronized (DefaultPoolExecutor.class) {
                if (f2266d == null) {
                    DefaultPoolExecutor bVar = new DefaultPoolExecutor(f2264b, f2265c, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new DefaultThreadFactory());
                    f2266d = bVar;
                }
            }
        }
        return f2266d;
    }

    private DefaultPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                ARouter.f2236a.error(ILogger.defaultTag, "Task rejected, too many task!");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (CancellationException e) {
                th = e;
            } catch (ExecutionException e2) {
                th = e2.getCause();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (th != null) {
            ILogger iLogger = ARouter.f2236a;
            StringBuilder sb = new StringBuilder();
            sb.append("Running task appeared exception! Thread [");
            sb.append(Thread.currentThread().getName());
            sb.append("], because [");
            sb.append(th.getMessage());
            sb.append("]\n");
            sb.append(TextUtils.m2164a(th.getStackTrace()));
            iLogger.warning(ILogger.defaultTag, sb.toString());
        }
    }
}
