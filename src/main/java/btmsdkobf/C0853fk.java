package btmsdkobf;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: btmsdkobf.fk */
public class C0853fk extends ThreadPoolExecutor {
    /* renamed from: oo */
    private C0854a f998oo = null;

    /* renamed from: btmsdkobf.fk$a */
    public interface C0854a {
        void afterExecute(Runnable runnable, Throwable th);

        void beforeExecute(Thread thread, Runnable runnable);
    }

    public C0853fk(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, new C0852fj(), rejectedExecutionHandler);
    }

    /* renamed from: a */
    public void mo9568a(C0854a aVar) {
        this.f998oo = aVar;
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        C0854a aVar = this.f998oo;
        if (aVar != null) {
            aVar.afterExecute(runnable, th);
        }
    }

    /* access modifiers changed from: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        C0854a aVar = this.f998oo;
        if (aVar != null) {
            aVar.beforeExecute(thread, runnable);
        }
    }

    public void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
