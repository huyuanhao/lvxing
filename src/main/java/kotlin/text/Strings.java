package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8258m;
import kotlin.p677d.C8231j;
import kotlin.p677d.C8238n;
import kotlin.sequences.Sequence;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo39189d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.text.e */
final class Strings implements Sequence<C8231j> {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final CharSequence f27806a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final int f27807b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final int f27808c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final C8258m<CharSequence, Integer, Pair<Integer, Integer>> f27809d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, mo39189d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Strings.kt */
    /* renamed from: kotlin.text.e$a */
    public static final class C8304a implements Iterator<C8231j> {
        /* renamed from: a */
        final /* synthetic */ Strings f27810a;
        /* renamed from: b */
        private int f27811b = -1;
        /* renamed from: c */
        private int f27812c;
        /* renamed from: d */
        private int f27813d;
        /* renamed from: e */
        private C8231j f27814e;
        /* renamed from: f */
        private int f27815f;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C8304a(Strings eVar) {
            this.f27810a = eVar;
            this.f27812c = C8238n.m35352a(eVar.f27807b, 0, eVar.f27806a.length());
            this.f27813d = this.f27812c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
            if (r6.f27815f < kotlin.text.Strings.m35434a(r6.f27810a)) goto L_0x0027;
     */
        /* renamed from: b */
        private final void m35438b() {
            /*
            r6 = this;
            int r0 = r6.f27813d
            r1 = 0
            if (r0 >= 0) goto L_0x000e
            r6.f27811b = r1
            r0 = 0
            kotlin.d.j r0 = (kotlin.p677d.C8231j) r0
            r6.f27814e = r0
            goto L_0x00a4
        L_0x000e:
            kotlin.text.e r0 = r6.f27810a
            int r0 = r0.f27808c
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L_0x0027
            int r0 = r6.f27815f
            int r0 = r0 + r3
            r6.f27815f = r0
            int r0 = r6.f27815f
            kotlin.text.e r4 = r6.f27810a
            int r4 = r4.f27808c
            if (r0 >= r4) goto L_0x0035
        L_0x0027:
            int r0 = r6.f27813d
            kotlin.text.e r4 = r6.f27810a
            java.lang.CharSequence r4 = r4.f27806a
            int r4 = r4.length()
            if (r0 <= r4) goto L_0x004b
        L_0x0035:
            int r0 = r6.f27812c
            kotlin.d.j r1 = new kotlin.d.j
            kotlin.text.e r4 = r6.f27810a
            java.lang.CharSequence r4 = r4.f27806a
            int r4 = kotlin.text.C8313m.m35488d(r4)
            r1.m55040init(r0, r4)
            r6.f27814e = r1
            r6.f27813d = r2
            goto L_0x00a2
        L_0x004b:
            kotlin.text.e r0 = r6.f27810a
            kotlin.jvm.a.m r0 = r0.f27809d
            kotlin.text.e r4 = r6.f27810a
            java.lang.CharSequence r4 = r4.f27806a
            int r5 = r6.f27813d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.invoke(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L_0x007b
            int r0 = r6.f27812c
            kotlin.d.j r1 = new kotlin.d.j
            kotlin.text.e r4 = r6.f27810a
            java.lang.CharSequence r4 = r4.f27806a
            int r4 = kotlin.text.C8313m.m35488d(r4)
            r1.m55040init(r0, r4)
            r6.f27814e = r1
            r6.f27813d = r2
            goto L_0x00a2
        L_0x007b:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.f27812c
            kotlin.d.j r4 = kotlin.p677d.C8238n.m35354b(r4, r2)
            r6.f27814e = r4
            int r2 = r2 + r0
            r6.f27812c = r2
            int r2 = r6.f27812c
            if (r0 != 0) goto L_0x009f
            r1 = 1
        L_0x009f:
            int r2 = r2 + r1
            r6.f27813d = r2
        L_0x00a2:
            r6.f27811b = r3
        L_0x00a4:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Strings.C8304a.m35438b():void");
        }

        /* renamed from: a */
        public C8231j next() {
            if (this.f27811b == -1) {
                m35438b();
            }
            if (this.f27811b != 0) {
                C8231j jVar = this.f27814e;
                if (jVar != null) {
                    this.f27814e = null;
                    this.f27811b = -1;
                    return jVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f27811b == -1) {
                m35438b();
            }
            return this.f27811b == 1;
        }
    }

    public Strings(CharSequence charSequence, int i, int i2, C8258m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        C8271i.m35386b(charSequence, "input");
        C8271i.m35386b(mVar, "getNextMatch");
        this.f27806a = charSequence;
        this.f27807b = i;
        this.f27808c = i2;
        this.f27809d = mVar;
    }

    public Iterator<C8231j> iterator() {
        return new C8304a<>(this);
    }
}
