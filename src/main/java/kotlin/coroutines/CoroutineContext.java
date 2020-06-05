package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8258m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0002¨\u0006\u0013"}, mo39189d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.coroutines.c */
public interface CoroutineContext {

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoroutineContext.kt */
    /* renamed from: kotlin.coroutines.c$a */
    public static final class C8200a {

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.c$a$a */
        static final class C8201a extends Lambda implements C8258m<CoroutineContext, C8202b, CoroutineContext> {
            public static final C8201a INSTANCE = new C8201a();

            C8201a() {
                super(2);
            }

            public final CoroutineContext invoke(CoroutineContext cVar, C8202b bVar) {
                CoroutineContext cVar2;
                C8271i.m35386b(cVar, "acc");
                C8271i.m35386b(bVar, "element");
                CoroutineContext minusKey = cVar.minusKey(bVar.mo39350a());
                if (minusKey == EmptyCoroutineContext.INSTANCE) {
                    return bVar;
                }
                ContinuationInterceptor bVar2 = (ContinuationInterceptor) minusKey.get(ContinuationInterceptor.f27732a);
                if (bVar2 == null) {
                    cVar2 = new CombinedContext(minusKey, bVar);
                } else {
                    CoroutineContext minusKey2 = minusKey.minusKey(ContinuationInterceptor.f27732a);
                    if (minusKey2 == EmptyCoroutineContext.INSTANCE) {
                        cVar2 = new CombinedContext(bVar, bVar2);
                    } else {
                        cVar2 = new CombinedContext(new CombinedContext(minusKey2, bVar), bVar2);
                    }
                }
                return cVar2;
            }
        }

        /* renamed from: a */
        public static CoroutineContext m35295a(CoroutineContext cVar, CoroutineContext cVar2) {
            C8271i.m35386b(cVar2, "context");
            return cVar2 == EmptyCoroutineContext.INSTANCE ? cVar : (CoroutineContext) cVar2.fold(cVar, C8201a.INSTANCE);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, mo39189d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: CoroutineContext.kt */
    /* renamed from: kotlin.coroutines.c$b */
    public interface C8202b extends CoroutineContext {
        /* renamed from: a */
        C8203c<?> mo39350a();

        <E extends C8202b> E get(C8203c<E> cVar);
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, mo39189d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: CoroutineContext.kt */
    /* renamed from: kotlin.coroutines.c$c */
    public interface C8203c<E extends C8202b> {
    }

    <R> R fold(R r, C8258m<? super R, ? super C8202b, ? extends R> mVar);

    <E extends C8202b> E get(C8203c<E> cVar);

    CoroutineContext minusKey(C8203c<?> cVar);

    CoroutineContext plus(CoroutineContext cVar);
}
