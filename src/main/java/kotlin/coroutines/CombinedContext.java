package kotlin.coroutines;

import com.tencent.android.tpush.SettingsContentProvider;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext.C8200a;
import kotlin.coroutines.CoroutineContext.C8202b;
import kotlin.coroutines.CoroutineContext.C8203c;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.p679a.C8258m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo39189d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CoroutineContextImpl.kt */
public final class CombinedContext implements Serializable, CoroutineContext {
    private final C8202b element;
    private final CoroutineContext left;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, mo39189d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: kotlin.coroutines.CombinedContext$a */
    private static final class C8195a implements Serializable {
        public static final C8196a Companion = new C8196a(null);
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo39189d2 = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: CoroutineContextImpl.kt */
        /* renamed from: kotlin.coroutines.CombinedContext$a$a */
        public static final class C8196a {
            private C8196a() {
            }

            public /* synthetic */ C8196a(DefaultConstructorMarker fVar) {
                this();
            }
        }

        public C8195a(CoroutineContext[] cVarArr) {
            C8271i.m35386b(cVarArr, "elements");
            this.elements = cVarArr;
        }

        public final CoroutineContext[] getElements() {
            return this.elements;
        }

        private final Object readResolve() {
            CoroutineContext[] cVarArr = this.elements;
            CoroutineContext cVar = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext plus : cVarArr) {
                cVar = cVar.plus(plus);
            }
            return cVar;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: kotlin.coroutines.CombinedContext$b */
    static final class C8197b extends Lambda implements C8258m<String, C8202b, String> {
        public static final C8197b INSTANCE = new C8197b();

        C8197b() {
            super(2);
        }

        public final String invoke(String str, C8202b bVar) {
            C8271i.m35386b(str, "acc");
            C8271i.m35386b(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(", ");
            sb.append(bVar);
            return sb.toString();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: kotlin.coroutines.CombinedContext$c */
    static final class C8198c extends Lambda implements C8258m<Unit, C8202b, Unit> {
        final /* synthetic */ CoroutineContext[] $elements;
        final /* synthetic */ IntRef $index;

        C8198c(CoroutineContext[] cVarArr, IntRef intRef) {
            this.$elements = cVarArr;
            this.$index = intRef;
            super(2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Unit) obj, (C8202b) obj2);
            return Unit.f27778a;
        }

        public final void invoke(Unit jVar, C8202b bVar) {
            C8271i.m35386b(jVar, "<anonymous parameter 0>");
            C8271i.m35386b(bVar, "element");
            CoroutineContext[] cVarArr = this.$elements;
            IntRef intRef = this.$index;
            int i = intRef.element;
            intRef.element = i + 1;
            cVarArr[i] = bVar;
        }
    }

    public CombinedContext(CoroutineContext cVar, C8202b bVar) {
        C8271i.m35386b(cVar, "left");
        C8271i.m35386b(bVar, "element");
        this.left = cVar;
        this.element = bVar;
    }

    public CoroutineContext plus(CoroutineContext cVar) {
        C8271i.m35386b(cVar, "context");
        return C8200a.m35295a(this, cVar);
    }

    public <E extends C8202b> E get(C8203c<E> cVar) {
        C8271i.m35386b(cVar, SettingsContentProvider.KEY);
        CoroutineContext cVar2 = this;
        while (true) {
            CombinedContext combinedContext = (CombinedContext) cVar2;
            E e = combinedContext.element.get(cVar);
            if (e != null) {
                return e;
            }
            cVar2 = combinedContext.left;
            if (!(cVar2 instanceof CombinedContext)) {
                return cVar2.get(cVar);
            }
        }
    }

    public <R> R fold(R r, C8258m<? super R, ? super C8202b, ? extends R> mVar) {
        C8271i.m35386b(mVar, "operation");
        return mVar.invoke(this.left.fold(r, mVar), this.element);
    }

    public CoroutineContext minusKey(C8203c<?> cVar) {
        CoroutineContext cVar2;
        C8271i.m35386b(cVar, SettingsContentProvider.KEY);
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        CoroutineContext minusKey = this.left.minusKey(cVar);
        if (minusKey == this.left) {
            cVar2 = this;
        } else if (minusKey == EmptyCoroutineContext.INSTANCE) {
            cVar2 = this.element;
        } else {
            cVar2 = new CombinedContext(minusKey, this.element);
        }
        return cVar2;
    }

    private final int size() {
        CombinedContext combinedContext = this;
        int i = 2;
        while (true) {
            CoroutineContext cVar = combinedContext.left;
            if (!(cVar instanceof CombinedContext)) {
                cVar = null;
            }
            combinedContext = (CombinedContext) cVar;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final boolean contains(C8202b bVar) {
        return C8271i.m35384a((Object) get(bVar.mo39350a()), (Object) bVar);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            CoroutineContext cVar = combinedContext.left;
            if (cVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) cVar;
            } else if (cVar != null) {
                return contains((C8202b) cVar);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
            if (r3.containsAll(r2) != false) goto L_0x001e;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        r0 = r2
        kotlin.coroutines.CombinedContext r0 = (kotlin.coroutines.CombinedContext) r0
        if (r0 == r3) goto L_0x001e
        boolean r0 = r3 instanceof kotlin.coroutines.CombinedContext
        if (r0 == 0) goto L_0x001c
        kotlin.coroutines.CombinedContext r3 = (kotlin.coroutines.CombinedContext) r3
        int r0 = r3.size()
        int r1 = r2.size()
        if (r0 != r1) goto L_0x001c
        boolean r3 = r3.containsAll(r2)
        if (r3 == 0) goto L_0x001c
        goto L_0x001e
    L_0x001c:
        r3 = 0
        goto L_0x001f
    L_0x001e:
        r3 = 1
    L_0x001f:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.CombinedContext.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append((String) fold("", C8197b.INSTANCE));
        sb.append("]");
        return sb.toString();
    }

    private final Object writeReplace() {
        int size = size();
        CoroutineContext[] cVarArr = new CoroutineContext[size];
        IntRef intRef = new IntRef();
        boolean z = false;
        intRef.element = 0;
        fold(Unit.f27778a, new C8198c(cVarArr, intRef));
        if (intRef.element == size) {
            z = true;
        }
        if (z) {
            return new C8195a(cVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
