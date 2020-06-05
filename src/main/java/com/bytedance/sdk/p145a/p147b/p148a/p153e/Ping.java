package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.bytedance.sdk.a.b.a.e.l */
final class Ping {
    /* renamed from: a */
    private final CountDownLatch f5646a = new CountDownLatch(1);
    /* renamed from: b */
    private long f5647b = -1;
    /* renamed from: c */
    private long f5648c = -1;

    Ping() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13848a() {
        if (this.f5647b == -1) {
            this.f5647b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo13849b() {
        if (this.f5648c != -1 || this.f5647b == -1) {
            throw new IllegalStateException();
        }
        this.f5648c = System.nanoTime();
        this.f5646a.countDown();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo13850c() {
        if (this.f5648c == -1) {
            long j = this.f5647b;
            if (j != -1) {
                this.f5648c = j - 1;
                this.f5646a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
