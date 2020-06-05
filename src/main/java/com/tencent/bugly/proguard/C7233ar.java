package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ar */
public class C7233ar implements Runnable {
    /* renamed from: a */
    private final Handler f24428a;
    /* renamed from: b */
    private final String f24429b;
    /* renamed from: c */
    private long f24430c;
    /* renamed from: d */
    private final long f24431d;
    /* renamed from: e */
    private boolean f24432e = true;
    /* renamed from: f */
    private long f24433f;

    C7233ar(Handler handler, String str, long j) {
        this.f24428a = handler;
        this.f24429b = str;
        this.f24430c = j;
        this.f24431d = j;
    }

    /* renamed from: a */
    public void mo34840a() {
        if (this.f24432e) {
            this.f24432e = false;
            this.f24433f = SystemClock.uptimeMillis();
            this.f24428a.postAtFrontOfQueue(this);
        }
    }

    /* renamed from: b */
    public boolean mo34842b() {
        return !this.f24432e && SystemClock.uptimeMillis() > this.f24433f + this.f24430c;
    }

    /* renamed from: c */
    public int mo34843c() {
        if (this.f24432e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f24433f < this.f24430c ? 1 : 3;
    }

    /* renamed from: d */
    public Thread mo34844d() {
        return this.f24428a.getLooper().getThread();
    }

    /* renamed from: e */
    public String mo34845e() {
        return this.f24429b;
    }

    public void run() {
        this.f24432e = true;
        mo34846f();
    }

    /* renamed from: a */
    public void mo34841a(long j) {
        this.f24430c = j;
    }

    /* renamed from: f */
    public void mo34846f() {
        this.f24430c = this.f24431d;
    }
}
