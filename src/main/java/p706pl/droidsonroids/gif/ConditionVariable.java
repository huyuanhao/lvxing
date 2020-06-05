package p706pl.droidsonroids.gif;

/* renamed from: pl.droidsonroids.gif.b */
class ConditionVariable {
    /* renamed from: a */
    private volatile boolean f29259a;

    ConditionVariable() {
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo41220a(boolean z) {
        if (z) {
            mo41219a();
        } else {
            mo41221b();
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo41219a() {
        boolean z = this.f29259a;
        this.f29259a = true;
        if (!z) {
            notify();
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized void mo41221b() {
        this.f29259a = false;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: c */
    public synchronized void mo41222c() throws InterruptedException {
        while (!this.f29259a) {
            wait();
        }
    }
}
