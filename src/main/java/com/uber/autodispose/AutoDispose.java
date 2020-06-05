package com.uber.autodispose;

import java.util.concurrent.Callable;
import p655io.reactivex.Completable;
import p655io.reactivex.CompletableSource;
import p655io.reactivex.Observable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Consumer;

/* renamed from: com.uber.autodispose.c */
public final class AutoDispose {
    /* renamed from: a */
    public static <T> AutoDisposeConverter<T> m33075a(ScopeProvider mVar) {
        AutoDisposeUtil.m33087a(mVar, "provider == null");
        return m33076a((CompletableSource) Completable.m34908a((Callable<? extends CompletableSource>) new Callable() {
            public final Object call() {
                return AutoDispose.m33077b(ScopeProvider.this);
            }
        }));
    }

    /* access modifiers changed from: private|static|synthetic */
    /* renamed from: b */
    public static /* synthetic */ CompletableSource m33077b(ScopeProvider mVar) throws Exception {
        try {
            return mVar.requestScope();
        } catch (OutsideScopeException e) {
            Consumer b = AutoDisposePlugins.m33086b();
            if (b == null) {
                return Completable.m34907a((Throwable) e);
            }
            b.accept(e);
            return Completable.m34906a();
        }
    }

    /* renamed from: a */
    public static <T> AutoDisposeConverter<T> m33076a(final CompletableSource cVar) {
        AutoDisposeUtil.m33087a(cVar, "scope == null");
        return new AutoDisposeConverter<T>() {
            /* renamed from: a */
            public ObservableSubscribeProxy<T> mo37373b(final Observable<T> iVar) {
                return new ObservableSubscribeProxy<T>() {
                    /* renamed from: a */
                    public Disposable mo37374a(Consumer<? super T> gVar) {
                        return new AutoDisposeObservable(iVar, CompletableSource.this).mo38904c(gVar);
                    }
                };
            }
        };
    }
}
