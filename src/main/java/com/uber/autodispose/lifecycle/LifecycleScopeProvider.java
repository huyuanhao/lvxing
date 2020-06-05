package com.uber.autodispose.lifecycle;

import com.uber.autodispose.ScopeProvider;
import p655io.reactivex.Observable;
import p655io.reactivex.annotations.CheckReturnValue;

/* renamed from: com.uber.autodispose.lifecycle.b */
public interface LifecycleScopeProvider<E> extends ScopeProvider {
    @CheckReturnValue
    /* renamed from: a */
    Observable<E> mo37367a();

    @CheckReturnValue
    /* renamed from: b */
    CorrespondingEventsFunction<E> mo37368b();

    /* renamed from: d */
    E mo37370d();
}
