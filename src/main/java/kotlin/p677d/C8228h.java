package kotlin.p677d;

import kotlin.Metadata;
import kotlin.collections.C8192w;
import kotlin.internal.progressionUtil;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo39189d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Progressions.kt */
/* renamed from: kotlin.d.h */
public class C8228h implements Iterable<Integer> {
    /* renamed from: a */
    public static final C8229a f27757a = new C8229a(null);
    /* renamed from: b */
    private final int f27758b;
    /* renamed from: c */
    private final int f27759c;
    /* renamed from: d */
    private final int f27760d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, mo39189d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Progressions.kt */
    /* renamed from: kotlin.d.h$a */
    public static final class C8229a {
        private C8229a() {
        }

        public /* synthetic */ C8229a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public final C8228h mo39412a(int i, int i2, int i3) {
            return new C8228h(i, i2, i3);
        }
    }

    public C8228h(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f27758b = i;
            this.f27759c = progressionUtil.m35361a(i, i2, i3);
            this.f27760d = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final int mo39403a() {
        return this.f27758b;
    }

    /* renamed from: b */
    public final int mo39404b() {
        return this.f27759c;
    }

    /* renamed from: c */
    public final int mo39405c() {
        return this.f27760d;
    }

    /* renamed from: d */
    public C8192w iterator() {
        return new C8230i(this.f27758b, this.f27759c, this.f27760d);
    }

    /* renamed from: e */
    public boolean mo39407e() {
        if (this.f27760d > 0) {
            if (this.f27758b > this.f27759c) {
                return true;
            }
        } else if (this.f27758b < this.f27759c) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            if (r2.f27760d == r3.f27760d) goto L_0x0027;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        boolean r0 = r3 instanceof kotlin.p677d.C8228h
        if (r0 == 0) goto L_0x0029
        boolean r0 = r2.mo39407e()
        if (r0 == 0) goto L_0x0013
        r0 = r3
        kotlin.d.h r0 = (kotlin.p677d.C8228h) r0
        boolean r0 = r0.mo39407e()
        if (r0 != 0) goto L_0x0027
    L_0x0013:
        int r0 = r2.f27758b
        kotlin.d.h r3 = (kotlin.p677d.C8228h) r3
        int r1 = r3.f27758b
        if (r0 != r1) goto L_0x0029
        int r0 = r2.f27759c
        int r1 = r3.f27759c
        if (r0 != r1) goto L_0x0029
        int r0 = r2.f27760d
        int r3 = r3.f27760d
        if (r0 != r3) goto L_0x0029
    L_0x0027:
        r3 = 1
        goto L_0x002a
    L_0x0029:
        r3 = 0
    L_0x002a:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.C8228h.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (mo39407e()) {
            return -1;
        }
        return (((this.f27758b * 31) + this.f27759c) * 31) + this.f27760d;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        String str = " step ";
        if (this.f27760d > 0) {
            sb = new StringBuilder();
            sb.append(this.f27758b);
            sb.append("..");
            sb.append(this.f27759c);
            sb.append(str);
            i = this.f27760d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f27758b);
            sb.append(" downTo ");
            sb.append(this.f27759c);
            sb.append(str);
            i = -this.f27760d;
        }
        sb.append(i);
        return sb.toString();
    }
}
