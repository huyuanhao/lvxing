package p655io.reactivex.internal.operators.flowable;

import org.p705b.Subscription;
import p655io.reactivex.p664d.Consumer;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper */
public final class FlowableInternalHelper {

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$RequestMax */
    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        public void accept(Subscription cVar) throws Exception {
            cVar.request(Long.MAX_VALUE);
        }
    }
}
