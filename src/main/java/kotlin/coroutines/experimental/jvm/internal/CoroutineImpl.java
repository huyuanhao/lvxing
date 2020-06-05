package kotlin.coroutines.experimental.jvm.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.C8207c;
import kotlin.coroutines.experimental.Coroutines;
import kotlin.coroutines.experimental.p676a.C8204a;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H$J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00038\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00058\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo39189d2 = {"Lkotlin/coroutines/experimental/jvm/internal/CoroutineImpl;", "Lkotlin/jvm/internal/Lambda;", "", "Lkotlin/coroutines/experimental/Continuation;", "arity", "", "completion", "(ILkotlin/coroutines/experimental/Continuation;)V", "_context", "Lkotlin/coroutines/experimental/CoroutineContext;", "_facade", "context", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "facade", "getFacade", "()Lkotlin/coroutines/experimental/Continuation;", "label", "create", "", "value", "doResume", "data", "exception", "", "resume", "resumeWithException", "kotlin-stdlib-coroutines"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CoroutineImpl.kt */
public abstract class CoroutineImpl extends Lambda<Object> implements Coroutines<Object> {
    private final C8207c _context;
    private Coroutines<Object> _facade;
    protected Coroutines<Object> completion;
    protected int label;

    public abstract Object doResume(Object obj, Throwable th);

    public CoroutineImpl(int i, Coroutines<Object> aVar) {
        super(i);
        this.completion = aVar;
        this.label = this.completion != null ? 0 : -1;
        Coroutines<Object> aVar2 = this.completion;
        this._context = aVar2 != null ? aVar2.getContext() : null;
    }

    public C8207c getContext() {
        C8207c cVar = this._context;
        if (cVar == null) {
            C8271i.m35380a();
        }
        return cVar;
    }

    public final Coroutines<Object> getFacade() {
        if (this._facade == null) {
            C8207c cVar = this._context;
            if (cVar == null) {
                C8271i.m35380a();
            }
            this._facade = CoroutineIntrinsics.m35300a(cVar, this);
        }
        Coroutines<Object> aVar = this._facade;
        if (aVar == null) {
            C8271i.m35380a();
        }
        return aVar;
    }

    public void resume(Object obj) {
        Coroutines<Object> aVar = this.completion;
        if (aVar == null) {
            C8271i.m35380a();
        }
        try {
            Object doResume = doResume(obj, null);
            if (doResume == C8204a.m35297a()) {
                return;
            }
            if (aVar != null) {
                aVar.resume(doResume);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
        } catch (Throwable th) {
            aVar.resumeWithException(th);
        }
    }

    public void resumeWithException(Throwable th) {
        C8271i.m35386b(th, "exception");
        Coroutines<Object> aVar = this.completion;
        if (aVar == null) {
            C8271i.m35380a();
        }
        try {
            Object doResume = doResume(null, th);
            if (doResume == C8204a.m35297a()) {
                return;
            }
            if (aVar != null) {
                aVar.resume(doResume);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
        } catch (Throwable th2) {
            aVar.resumeWithException(th2);
        }
    }

    public Coroutines<Unit> create(Coroutines<?> aVar) {
        C8271i.m35386b(aVar, "completion");
        throw new IllegalStateException("create(Continuation) has not been overridden");
    }

    public Coroutines<Unit> create(Object obj, Coroutines<?> aVar) {
        C8271i.m35386b(aVar, "completion");
        throw new IllegalStateException("create(Any?;Continuation) has not been overridden");
    }
}
