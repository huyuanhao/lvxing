package p655io.reactivex.internal.operators.maybe;

import org.p705b.Publisher;
import p655io.reactivex.MaybeSource;
import p655io.reactivex.p664d.Function;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeToPublisher */
public enum MaybeToPublisher implements Function<MaybeSource<Object>, Publisher<Object>> {
    INSTANCE;

    public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
        return INSTANCE;
    }

    public Publisher<Object> apply(MaybeSource<Object> hVar) throws Exception {
        return new MaybeToFlowable(hVar);
    }
}
