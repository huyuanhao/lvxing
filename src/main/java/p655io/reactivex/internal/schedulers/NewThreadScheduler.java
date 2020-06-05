package p655io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;

/* renamed from: io.reactivex.internal.schedulers.e */
public final class NewThreadScheduler extends Scheduler {
    /* renamed from: c */
    private static final RxThreadFactory f27655c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    /* renamed from: b */
    final ThreadFactory f27656b;

    public NewThreadScheduler() {
        this(f27655c);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f27656b = threadFactory;
    }

    /* renamed from: a */
    public C8167c mo38822a() {
        return new NewThreadWorker(this.f27656b);
    }
}
