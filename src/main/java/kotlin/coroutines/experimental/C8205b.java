package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.C8207c.C8208a;
import kotlin.coroutines.experimental.C8207c.C8209b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H&¨\u0006\u0007"}, mo39189d2 = {"Lkotlin/coroutines/experimental/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/experimental/Continuation;", "T", "continuation", "Key", "kotlin-stdlib-coroutines"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ContinuationInterceptor.kt */
/* renamed from: kotlin.coroutines.experimental.b */
public interface C8205b extends C8208a {
    /* renamed from: a */
    public static final C8206a f27734a = C8206a.f27735a;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo39189d2 = {"Lkotlin/coroutines/experimental/ContinuationInterceptor$Key;", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "()V", "kotlin-stdlib-coroutines"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: ContinuationInterceptor.kt */
    /* renamed from: kotlin.coroutines.experimental.b$a */
    public static final class C8206a implements C8209b<C8205b> {
        /* renamed from: a */
        static final /* synthetic */ C8206a f27735a = new C8206a();

        private C8206a() {
        }
    }

    /* renamed from: a */
    <T> Coroutines<T> mo39354a(Coroutines<? super T> aVar);
}
