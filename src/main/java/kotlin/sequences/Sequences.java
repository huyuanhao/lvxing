package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo39189d2 = {"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.sequences.a */
final class Sequences<T> implements Sequence<T> {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final C8246a<T> f27787a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final C8247b<T, T> f27788b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, mo39189d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Sequences.kt */
    /* renamed from: kotlin.sequences.a$a */
    public static final class C8288a implements Iterator<T> {
        /* renamed from: a */
        final /* synthetic */ Sequences f27789a;
        /* renamed from: b */
        private T f27790b;
        /* renamed from: c */
        private int f27791c = -2;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C8288a(Sequences aVar) {
            this.f27789a = aVar;
        }

        /* renamed from: a */
        private final void m35421a() {
            T t;
            if (this.f27791c == -2) {
                t = this.f27789a.f27787a.invoke();
            } else {
                C8247b b = this.f27789a.f27788b;
                T t2 = this.f27790b;
                if (t2 == null) {
                    C8271i.m35380a();
                }
                t = b.invoke(t2);
            }
            this.f27790b = t;
            this.f27791c = this.f27790b == null ? 0 : 1;
        }

        public T next() {
            if (this.f27791c < 0) {
                m35421a();
            }
            if (this.f27791c != 0) {
                T t = this.f27790b;
                if (t != null) {
                    this.f27791c = -1;
                    return t;
                }
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f27791c < 0) {
                m35421a();
            }
            return this.f27791c == 1;
        }
    }

    public Sequences(C8246a<? extends T> aVar, C8247b<? super T, ? extends T> bVar) {
        C8271i.m35386b(aVar, "getInitialValue");
        C8271i.m35386b(bVar, "getNextValue");
        this.f27787a = aVar;
        this.f27788b = bVar;
    }

    public Iterator<T> iterator() {
        return new C8288a<>(this);
    }
}
