package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;
import p655io.reactivex.p664d.Function;

/* renamed from: com.uber.autodispose.lifecycle.a */
public interface CorrespondingEventsFunction<E> extends Function<E, E> {
    E apply(E e) throws OutsideScopeException;
}
