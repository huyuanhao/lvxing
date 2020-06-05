package p655io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.internal.schedulers.g */
public final class SchedulerPoolFactory {
    /* renamed from: a */
    public static final boolean f27659a;
    /* renamed from: b */
    public static final int f27660b;
    /* renamed from: c */
    static final AtomicReference<ScheduledExecutorService> f27661c = new AtomicReference<>();
    /* renamed from: d */
    static final Map<ScheduledThreadPoolExecutor, Object> f27662d = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory */
    /* renamed from: io.reactivex.internal.schedulers.g$a */
    static final class C8151a {
        /* renamed from: a */
        boolean f27663a;
        /* renamed from: b */
        int f27664b;

        C8151a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo39062a(Properties properties) {
            String str = "rx2.purge-enabled";
            if (properties.containsKey(str)) {
                this.f27663a = Boolean.parseBoolean(properties.getProperty(str));
            } else {
                this.f27663a = true;
            }
            if (this.f27663a) {
                String str2 = "rx2.purge-period-seconds";
                if (properties.containsKey(str2)) {
                    try {
                        this.f27664b = Integer.parseInt(properties.getProperty(str2));
                        return;
                    } catch (NumberFormatException unused) {
                        this.f27664b = 1;
                        return;
                    }
                }
            }
            this.f27664b = 1;
        }
    }

    /* compiled from: SchedulerPoolFactory */
    /* renamed from: io.reactivex.internal.schedulers.g$b */
    static final class C8152b implements Runnable {
        C8152b() {
        }

        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.f27662d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f27662d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        C8151a aVar = new C8151a();
        aVar.mo39062a(properties);
        f27659a = aVar.f27663a;
        f27660b = aVar.f27664b;
        m35150a();
    }

    /* renamed from: a */
    public static void m35150a() {
        m35151a(f27659a);
    }

    /* renamed from: a */
    static void m35151a(boolean z) {
        if (z) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) f27661c.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (f27661c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        C8152b bVar = new C8152b();
                        int i = f27660b;
                        newScheduledThreadPool.scheduleAtFixedRate(bVar, (long) i, (long) i, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m35149a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        m35152a(f27659a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    /* renamed from: a */
    static void m35152a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f27662d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }
}
