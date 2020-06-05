package com.bytedance.sdk.p145a.p147b.p148a;

/* renamed from: com.bytedance.sdk.a.b.a.b */
public abstract class NamedRunnable implements Runnable {
    /* renamed from: a */
    protected final String f5349a;

    /* renamed from: a */
    public abstract void mo13684a();

    public NamedRunnable(String str, Object... objArr) {
        this.f5349a = C1876c.m6955a(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f5349a);
        try {
            mo13684a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
