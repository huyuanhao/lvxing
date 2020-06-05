package okhttp3.internal;

/* compiled from: NamedRunnable */
/* renamed from: okhttp3.internal.b */
public abstract class C8402b implements Runnable {
    /* renamed from: b */
    protected final String f28497b;

    /* renamed from: c */
    public abstract void mo40233c();

    public C8402b(String str, Object... objArr) {
        this.f28497b = C8417c.m36030a(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f28497b);
        try {
            mo40233c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
