package btmsdkobf;

/* renamed from: btmsdkobf.fp */
public class C0863fp extends Thread {
    /* renamed from: oH */
    private C0864a f1024oH;
    /* renamed from: oL */
    private Runnable f1025oL;

    /* renamed from: btmsdkobf.fp$a */
    public interface C0864a {
        /* renamed from: a */
        void mo9593a(Thread thread, Runnable runnable);

        /* renamed from: b */
        void mo9594b(Thread thread, Runnable runnable);

        void beforeExecute(Thread thread, Runnable runnable);
    }

    public void run() {
        C0864a aVar = this.f1024oH;
        if (aVar != null) {
            aVar.beforeExecute(this, this.f1025oL);
        }
        super.run();
        C0864a aVar2 = this.f1024oH;
        if (aVar2 != null) {
            aVar2.mo9594b(this, this.f1025oL);
        }
    }

    public synchronized void start() {
        if (this.f1024oH != null) {
            this.f1024oH.mo9593a(this, this.f1025oL);
        }
        super.start();
    }
}
