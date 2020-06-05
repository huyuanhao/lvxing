package kotlin.coroutines.intrinsics;

import kotlin.C8242f;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.p679a.C8258m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, mo39189d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: IntrinsicsJvm.kt */
/* renamed from: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3 */
public final class C8212xa50de662 extends RestrictedContinuationImpl {
    final /* synthetic */ Continuation $completion;
    final /* synthetic */ Object $receiver$inlined;
    final /* synthetic */ C8258m $this_createCoroutineUnintercepted$inlined;
    private int label;

    public C8212xa50de662(Continuation aVar, Continuation aVar2, C8258m mVar, Object obj) {
        this.$completion = aVar;
        this.$this_createCoroutineUnintercepted$inlined = mVar;
        this.$receiver$inlined = obj;
        super(aVar2);
    }

    /* access modifiers changed from: protected */
    public Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            this.label = 1;
            C8242f.m35358a(obj);
            Continuation aVar = this;
            C8258m mVar = this.$this_createCoroutineUnintercepted$inlined;
            if (mVar != null) {
                return ((C8258m) TypeIntrinsics.m35418b(mVar, 2)).invoke(this.$receiver$inlined, aVar);
            }
            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } else if (i == 1) {
            this.label = 2;
            C8242f.m35358a(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
