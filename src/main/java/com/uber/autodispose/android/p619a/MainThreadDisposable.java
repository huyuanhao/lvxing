package com.uber.autodispose.android.p619a;

import java.util.concurrent.atomic.AtomicBoolean;
import p655io.reactivex.p659a.p661b.AndroidSchedulers;
import p655io.reactivex.p662b.Disposable;

/* renamed from: com.uber.autodispose.android.a.b */
public abstract class MainThreadDisposable implements Disposable {
    /* renamed from: a */
    private final AtomicBoolean f25975a = new AtomicBoolean();

    /* renamed from: a */
    public abstract void mo37361a();

    public final boolean isDisposed() {
        return this.f25975a.get();
    }

    public final void dispose() {
        if (!this.f25975a.compareAndSet(false, true)) {
            return;
        }
        if (AutoDisposeAndroidUtil.m33058a()) {
            mo37361a();
        } else {
            AndroidSchedulers.m34919a().mo39064a(new Runnable() {
                public final void run() {
                    MainThreadDisposable.this.mo37361a();
                }
            });
        }
    }
}
