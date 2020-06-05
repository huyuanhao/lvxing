package com.alibaba.mtl.log.p077d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.appmonitor.p069b.ExceptionEventBuilder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alibaba.mtl.log.d.r */
public class TaskExecutor {
    /* renamed from: a */
    public static TaskExecutor f3419a = null;
    /* renamed from: b */
    private static ThreadPoolExecutor f3420b = null;
    /* renamed from: c */
    private static int f3421c = 1;
    /* renamed from: d */
    private static int f3422d = 2;
    /* renamed from: e */
    private static int f3423e = 10;
    /* renamed from: f */
    private static int f3424f = 60;
    /* access modifiers changed from: private|static|final */
    /* renamed from: i */
    public static final AtomicInteger f3425i = new AtomicInteger();
    /* renamed from: g */
    private HandlerThread f3426g = new HandlerThread("AppMonitor");
    /* renamed from: h */
    private Handler f3427h;

    /* compiled from: TaskExecutor */
    /* renamed from: com.alibaba.mtl.log.d.r$a */
    static class C1330a implements ThreadFactory {
        /* renamed from: a */
        private int f3429a;

        public C1330a(int i) {
            this.f3429a = i;
        }

        public Thread newThread(Runnable runnable) {
            int andIncrement = TaskExecutor.f3425i.getAndIncrement();
            StringBuilder sb = new StringBuilder();
            sb.append("AppMonitor:");
            sb.append(andIncrement);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setPriority(this.f3429a);
            return thread;
        }
    }

    /* renamed from: a */
    private static ThreadPoolExecutor m3868a(int i, int i2, int i3, int i4, int i5) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i5 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i5);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        int i6 = i2;
        int i7 = i3;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i6, i7, (long) i4, TimeUnit.SECONDS, linkedBlockingQueue, new C1330a(i), new DiscardOldestPolicy());
        return threadPoolExecutor;
    }

    /* access modifiers changed from: private|static|declared_synchronized */
    /* renamed from: d */
    public static synchronized ThreadPoolExecutor m3871d() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (TaskExecutor.class) {
            if (f3420b == null) {
                f3420b = m3868a(f3421c, f3422d, f3423e, f3424f, 500);
            }
            threadPoolExecutor = f3420b;
        }
        return threadPoolExecutor;
    }

    /* renamed from: a */
    public static synchronized TaskExecutor m3867a() {
        TaskExecutor rVar;
        synchronized (TaskExecutor.class) {
            if (f3419a == null) {
                f3419a = new TaskExecutor();
            }
            rVar = f3419a;
        }
        return rVar;
    }

    private TaskExecutor() {
        this.f3426g.start();
        this.f3427h = new Handler(this.f3426g.getLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    if (message.obj != null && (message.obj instanceof Runnable)) {
                        TaskExecutor.m3871d().submit((Runnable) message.obj);
                    }
                } catch (Throwable unused) {
                }
            }
        };
    }

    /* renamed from: a */
    public final void mo11810a(int i, Runnable runnable, long j) {
        try {
            Message obtain = Message.obtain(this.f3427h, i);
            obtain.obj = runnable;
            this.f3427h.sendMessageDelayed(obtain, j);
        } catch (Exception e) {
            ExceptionEventBuilder.m3405a(e);
        }
    }

    /* renamed from: a */
    public final void mo11809a(int i) {
        this.f3427h.removeMessages(i);
    }

    /* renamed from: b */
    public final boolean mo11812b(int i) {
        return this.f3427h.hasMessages(i);
    }

    /* renamed from: a */
    public void mo11811a(Runnable runnable) {
        try {
            m3871d().submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
