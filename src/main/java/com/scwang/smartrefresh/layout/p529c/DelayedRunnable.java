package com.scwang.smartrefresh.layout.p529c;

/* renamed from: com.scwang.smartrefresh.layout.c.a */
public class DelayedRunnable implements Runnable {
    /* renamed from: a */
    public long f20841a;
    /* renamed from: b */
    private Runnable f20842b = null;

    public DelayedRunnable(Runnable runnable, long j) {
        this.f20842b = runnable;
        this.f20841a = j;
    }

    public void run() {
        try {
            if (this.f20842b != null) {
                this.f20842b.run();
                this.f20842b = null;
            }
        } catch (Throwable th) {
            if (!(th instanceof NoClassDefFoundError)) {
                th.printStackTrace();
            }
        }
    }
}
