package btmsdkobf;

import android.os.HandlerThread;
import btmsdkobf.C0863fp.C0864a;

/* renamed from: btmsdkobf.fn */
public class C0860fn extends HandlerThread {
    /* renamed from: lA */
    private long f1019lA;
    /* renamed from: oH */
    private C0864a f1020oH;

    public C0860fn(String str, int i, long j) {
        super(str, i);
        this.f1019lA = j;
    }

    /* renamed from: cZ */
    private C0864a m947cZ() {
        if (this.f1020oH == null) {
            this.f1020oH = C0861fo.m951db();
        }
        return this.f1020oH;
    }

    /* renamed from: by */
    public long mo9590by() {
        return this.f1019lA;
    }

    public void run() {
        m947cZ().beforeExecute(this, null);
        super.run();
        m947cZ().mo9594b(this, null);
    }

    public synchronized void start() {
        m947cZ().mo9593a(this, null);
        super.start();
    }
}
