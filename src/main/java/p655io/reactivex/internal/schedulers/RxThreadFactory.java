package p655io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.reactivex.internal.schedulers.RxThreadFactory */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    /* renamed from: io.reactivex.internal.schedulers.RxThreadFactory$a */
    static final class C8144a extends Thread {
        C8144a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = z;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder(this.prefix);
        sb.append('-');
        sb.append(incrementAndGet());
        String sb2 = sb.toString();
        Thread aVar = this.nonBlocking ? new C8144a(runnable, sb2) : new Thread(runnable, sb2);
        aVar.setPriority(this.priority);
        aVar.setDaemon(true);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RxThreadFactory[");
        sb.append(this.prefix);
        sb.append("]");
        return sb.toString();
    }
}
