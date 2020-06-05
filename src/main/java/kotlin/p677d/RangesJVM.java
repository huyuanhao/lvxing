package kotlin.p677d;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, mo39189d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.d.e */
final class RangesJVM implements C8226f<Float> {
    /* renamed from: a */
    private final float f27755a;
    /* renamed from: b */
    private final float f27756b;

    /* renamed from: a */
    public Float getStart() {
        return Float.valueOf(this.f27755a);
    }

    /* renamed from: b */
    public Float getEndInclusive() {
        return Float.valueOf(this.f27756b);
    }

    /* renamed from: c */
    public boolean mo39399c() {
        return this.f27755a > this.f27756b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
            if (r2.f27756b == r3.f27756b) goto L_0x0025;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        boolean r0 = r3 instanceof kotlin.p677d.RangesJVM
        if (r0 == 0) goto L_0x0027
        boolean r0 = r2.mo39399c()
        if (r0 == 0) goto L_0x0013
        r0 = r3
        kotlin.d.e r0 = (kotlin.p677d.RangesJVM) r0
        boolean r0 = r0.mo39399c()
        if (r0 != 0) goto L_0x0025
    L_0x0013:
        float r0 = r2.f27755a
        kotlin.d.e r3 = (kotlin.p677d.RangesJVM) r3
        float r1 = r3.f27755a
        int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
        if (r0 != 0) goto L_0x0027
        float r0 = r2.f27756b
        float r3 = r3.f27756b
        int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
        if (r3 != 0) goto L_0x0027
    L_0x0025:
        r3 = 1
        goto L_0x0028
    L_0x0027:
        r3 = 0
    L_0x0028:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.RangesJVM.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (mo39399c()) {
            return -1;
        }
        return (Float.valueOf(this.f27755a).hashCode() * 31) + Float.valueOf(this.f27756b).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27755a);
        sb.append("..");
        sb.append(this.f27756b);
        return sb.toString();
    }
}
