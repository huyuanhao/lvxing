package btmsdkobf;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: btmsdkobf.fj */
public class C0852fj implements C0865fq, ThreadFactory {
    /* renamed from: ol */
    private final ThreadGroup f995ol = new ThreadGroup("TMS-COMMON");
    /* renamed from: om */
    private final AtomicInteger f996om = new AtomicInteger(1);
    /* renamed from: on */
    private final String f997on;

    C0852fj() {
        StringBuilder sb = new StringBuilder();
        sb.append("Common Thread Pool-");
        sb.append(f1026oM.getAndIncrement());
        sb.append("-Thread-");
        this.f997on = sb.toString();
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f995ol;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f997on);
        sb.append(this.f996om.getAndIncrement());
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
