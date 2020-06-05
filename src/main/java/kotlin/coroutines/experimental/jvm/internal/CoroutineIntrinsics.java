package kotlin.coroutines.experimental.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.experimental.C8205b;
import kotlin.coroutines.experimental.C8207c;
import kotlin.coroutines.experimental.Coroutines;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a \u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\u0007"}, mo39189d2 = {"interceptContinuationIfNeeded", "Lkotlin/coroutines/experimental/Continuation;", "T", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "continuation", "normalizeContinuation", "kotlin-stdlib-coroutines"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.coroutines.experimental.jvm.internal.a */
public final class CoroutineIntrinsics {
    /* renamed from: a */
    public static final <T> Coroutines<T> m35300a(C8207c cVar, Coroutines<? super T> aVar) {
        C8271i.m35386b(cVar, "context");
        C8271i.m35386b(aVar, "continuation");
        C8205b bVar = (C8205b) cVar.mo39355a(C8205b.f27734a);
        if (bVar != null) {
            Coroutines<T> a = bVar.mo39354a(aVar);
            if (a != null) {
                return a;
            }
        }
        return aVar;
    }
}
