package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, mo39189d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LazyJVM.kt */
/* renamed from: kotlin.g */
final class C8243g<T> implements Serializable, Lazy<T> {
    private volatile Object _value;
    private C8246a<? extends T> initializer;
    private final Object lock;

    public C8243g(C8246a<? extends T> aVar, Object obj) {
        C8271i.m35386b(aVar, "initializer");
        this.initializer = aVar;
        this._value = C8244i.f27777a;
        if (obj == 0) {
            obj = this;
        }
        this.lock = obj;
    }

    public /* synthetic */ C8243g(C8246a aVar, Object obj, int i, DefaultConstructorMarker fVar) {
        if ((i & 2) != 0) {
            obj = null;
        }
        this(aVar, obj);
    }

    public T getValue() {
        T t;
        T t2 = this._value;
        if (t2 != C8244i.f27777a) {
            return t2;
        }
        synchronized (this.lock) {
            t = this._value;
            if (t == C8244i.f27777a) {
                C8246a<? extends T> aVar = this.initializer;
                if (aVar == null) {
                    C8271i.m35380a();
                }
                t = aVar.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != C8244i.f27777a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
