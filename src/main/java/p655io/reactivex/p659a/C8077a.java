package p655io.reactivex.p659a;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import p655io.reactivex.p659a.p661b.AndroidSchedulers;
import p655io.reactivex.p662b.Disposable;

/* compiled from: MainThreadDisposable */
/* renamed from: io.reactivex.a.a */
public abstract class C8077a implements Disposable {
    /* renamed from: a */
    private final AtomicBoolean f27394a = new AtomicBoolean();

    /* renamed from: a */
    public abstract void mo19784a();

    public final boolean isDisposed() {
        return this.f27394a.get();
    }

    public final void dispose() {
        if (!this.f27394a.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mo19784a();
        } else {
            AndroidSchedulers.m34919a().mo39064a(new Runnable() {
                public void run() {
                    C8077a.this.mo19784a();
                }
            });
        }
    }
}
