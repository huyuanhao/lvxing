package kotlin.p677d;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, mo39189d2 = {"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Ranges.kt */
/* renamed from: kotlin.d.d */
final class C8225d implements C8226f<Double> {
    /* renamed from: a */
    private final double f27753a;
    /* renamed from: b */
    private final double f27754b;

    /* renamed from: a */
    public Double getStart() {
        return Double.valueOf(this.f27753a);
    }

    /* renamed from: b */
    public Double getEndInclusive() {
        return Double.valueOf(this.f27754b);
    }

    /* renamed from: c */
    public boolean mo39393c() {
        return this.f27753a > this.f27754b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
            if (r5.f27754b == r6.f27754b) goto L_0x0025;
     */
    public boolean equals(java.lang.Object r6) {
        /*
        r5 = this;
        boolean r0 = r6 instanceof kotlin.p677d.C8225d
        if (r0 == 0) goto L_0x0027
        boolean r0 = r5.mo39393c()
        if (r0 == 0) goto L_0x0013
        r0 = r6
        kotlin.d.d r0 = (kotlin.p677d.C8225d) r0
        boolean r0 = r0.mo39393c()
        if (r0 != 0) goto L_0x0025
    L_0x0013:
        double r0 = r5.f27753a
        kotlin.d.d r6 = (kotlin.p677d.C8225d) r6
        double r2 = r6.f27753a
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 != 0) goto L_0x0027
        double r0 = r5.f27754b
        double r2 = r6.f27754b
        int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r6 != 0) goto L_0x0027
    L_0x0025:
        r6 = 1
        goto L_0x0028
    L_0x0027:
        r6 = 0
    L_0x0028:
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.C8225d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (mo39393c()) {
            return -1;
        }
        return (Double.valueOf(this.f27753a).hashCode() * 31) + Double.valueOf(this.f27754b).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27753a);
        sb.append("..");
        sb.append(this.f27754b);
        return sb.toString();
    }
}
