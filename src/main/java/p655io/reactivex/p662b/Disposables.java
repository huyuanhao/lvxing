package p655io.reactivex.p662b;

import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.p669a.ObjectHelper;

/* renamed from: io.reactivex.b.c */
public final class Disposables {
    /* renamed from: a */
    public static Disposable m34930a(Runnable runnable) {
        ObjectHelper.m35048a(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    /* renamed from: a */
    public static Disposable m34929a() {
        return EmptyDisposable.INSTANCE;
    }
}
