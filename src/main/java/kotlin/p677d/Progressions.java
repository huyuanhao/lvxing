package kotlin.p677d;

import kotlin.Metadata;
import kotlin.collections.C8186j;
import kotlin.internal.progressionUtil;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo39189d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.d.a */
public class Progressions implements Iterable<Character> {
    /* renamed from: a */
    public static final C8223a f27743a = new C8223a(null);
    /* renamed from: b */
    private final char f27744b;
    /* renamed from: c */
    private final char f27745c;
    /* renamed from: d */
    private final int f27746d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, mo39189d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/CharProgression;", "rangeStart", "", "rangeEnd", "step", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Progressions.kt */
    /* renamed from: kotlin.d.a$a */
    public static final class C8223a {
        private C8223a() {
        }

        public /* synthetic */ C8223a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public Progressions(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i != Integer.MIN_VALUE) {
            this.f27744b = c;
            this.f27745c = (char) progressionUtil.m35361a((int) c, (int) c2, i);
            this.f27746d = i;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final char mo39380a() {
        return this.f27744b;
    }

    /* renamed from: b */
    public final char mo39381b() {
        return this.f27745c;
    }

    /* renamed from: c */
    public C8186j iterator() {
        return new ProgressionIterators(this.f27744b, this.f27745c, this.f27746d);
    }

    /* renamed from: d */
    public boolean mo39383d() {
        if (this.f27746d > 0) {
            if (this.f27744b > this.f27745c) {
                return true;
            }
        } else if (this.f27744b < this.f27745c) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            if (r2.f27746d == r3.f27746d) goto L_0x0027;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        boolean r0 = r3 instanceof kotlin.p677d.Progressions
        if (r0 == 0) goto L_0x0029
        boolean r0 = r2.mo39383d()
        if (r0 == 0) goto L_0x0013
        r0 = r3
        kotlin.d.a r0 = (kotlin.p677d.Progressions) r0
        boolean r0 = r0.mo39383d()
        if (r0 != 0) goto L_0x0027
    L_0x0013:
        char r0 = r2.f27744b
        kotlin.d.a r3 = (kotlin.p677d.Progressions) r3
        char r1 = r3.f27744b
        if (r0 != r1) goto L_0x0029
        char r0 = r2.f27745c
        char r1 = r3.f27745c
        if (r0 != r1) goto L_0x0029
        int r0 = r2.f27746d
        int r3 = r3.f27746d
        if (r0 != r3) goto L_0x0029
    L_0x0027:
        r3 = 1
        goto L_0x002a
    L_0x0029:
        r3 = 0
    L_0x002a:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.Progressions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (mo39383d()) {
            return -1;
        }
        return (((this.f27744b * 31) + this.f27745c) * 31) + this.f27746d;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        String str = " step ";
        if (this.f27746d > 0) {
            sb = new StringBuilder();
            sb.append(this.f27744b);
            sb.append("..");
            sb.append(this.f27745c);
            sb.append(str);
            i = this.f27746d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f27744b);
            sb.append(" downTo ");
            sb.append(this.f27745c);
            sb.append(str);
            i = -this.f27746d;
        }
        sb.append(i);
        return sb.toString();
    }
}
