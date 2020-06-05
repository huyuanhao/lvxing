package com.uber.autodispose;

import p655io.reactivex.CompletableSource;
import p655io.reactivex.annotations.CheckReturnValue;

/* renamed from: com.uber.autodispose.m */
public interface ScopeProvider {
    /* renamed from: a */
    public static final ScopeProvider f26001a = C7693$$Lambda$jksEYnxnXGOwPMa8q0PZn_f91H8.INSTANCE;

    @CheckReturnValue
    CompletableSource requestScope() throws Exception;
}
