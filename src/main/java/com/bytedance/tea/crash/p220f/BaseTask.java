package com.bytedance.tea.crash.p220f;

import android.os.Handler;

/* renamed from: com.bytedance.tea.crash.f.a */
public abstract class BaseTask implements Runnable {
    /* renamed from: a */
    private Handler f9355a;
    /* renamed from: b */
    private final long f9356b;
    /* renamed from: c */
    private final long f9357c;

    BaseTask(Handler handler, long j, long j2) {
        this.f9355a = handler;
        this.f9356b = j;
        this.f9357c = j2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17061a() {
        if (mo17063b() > 0) {
            this.f9355a.postDelayed(this, mo17063b());
        } else {
            this.f9355a.post(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17062a(long j) {
        if (j > 0) {
            this.f9355a.postDelayed(this, j);
        } else {
            this.f9355a.post(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo17063b() {
        return this.f9356b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public long mo17064c() {
        return this.f9357c;
    }
}
