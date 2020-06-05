package kotlin.p677d;

import kotlin.Metadata;
import kotlin.collections.C8193x;
import kotlin.internal.progressionUtil;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, mo39189d2 = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Progressions.kt */
/* renamed from: kotlin.d.k */
public class C8233k implements Iterable<Long> {
    /* renamed from: a */
    public static final C8234a f27767a = new C8234a(null);
    /* renamed from: b */
    private final long f27768b;
    /* renamed from: c */
    private final long f27769c;
    /* renamed from: d */
    private final long f27770d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, mo39189d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Progressions.kt */
    /* renamed from: kotlin.d.k$a */
    public static final class C8234a {
        private C8234a() {
        }

        public /* synthetic */ C8234a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public C8233k(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j3 != Long.MIN_VALUE) {
            this.f27768b = j;
            this.f27769c = progressionUtil.m35363a(j, j2, j3);
            this.f27770d = j3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final long mo39417a() {
        return this.f27768b;
    }

    /* renamed from: b */
    public final long mo39418b() {
        return this.f27769c;
    }

    /* renamed from: c */
    public C8193x iterator() {
        C8235l lVar = new C8235l(this.f27768b, this.f27769c, this.f27770d);
        return lVar;
    }

    /* renamed from: d */
    public boolean mo39420d() {
        int i = (this.f27770d > 0 ? 1 : (this.f27770d == 0 ? 0 : -1));
        long j = this.f27768b;
        long j2 = this.f27769c;
        if (i > 0) {
            if (j > j2) {
                return true;
            }
        } else if (j < j2) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
            if (r5.f27770d == r6.f27770d) goto L_0x002d;
     */
    public boolean equals(java.lang.Object r6) {
        /*
        r5 = this;
        boolean r0 = r6 instanceof kotlin.p677d.C8233k
        if (r0 == 0) goto L_0x002f
        boolean r0 = r5.mo39420d()
        if (r0 == 0) goto L_0x0013
        r0 = r6
        kotlin.d.k r0 = (kotlin.p677d.C8233k) r0
        boolean r0 = r0.mo39420d()
        if (r0 != 0) goto L_0x002d
    L_0x0013:
        long r0 = r5.f27768b
        kotlin.d.k r6 = (kotlin.p677d.C8233k) r6
        long r2 = r6.f27768b
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 != 0) goto L_0x002f
        long r0 = r5.f27769c
        long r2 = r6.f27769c
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 != 0) goto L_0x002f
        long r0 = r5.f27770d
        long r2 = r6.f27770d
        int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r6 != 0) goto L_0x002f
    L_0x002d:
        r6 = 1
        goto L_0x0030
    L_0x002f:
        r6 = 0
    L_0x0030:
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.C8233k.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (mo39420d()) {
            return -1;
        }
        long j = (long) 31;
        long j2 = this.f27768b;
        long j3 = (j2 ^ (j2 >>> 32)) * j;
        long j4 = this.f27769c;
        long j5 = j * (j3 + (j4 ^ (j4 >>> 32)));
        long j6 = this.f27770d;
        return (int) (j5 + (j6 ^ (j6 >>> 32)));
    }

    public String toString() {
        StringBuilder sb;
        long j;
        String str = " step ";
        if (this.f27770d > 0) {
            sb = new StringBuilder();
            sb.append(this.f27768b);
            sb.append("..");
            sb.append(this.f27769c);
            sb.append(str);
            j = this.f27770d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f27768b);
            sb.append(" downTo ");
            sb.append(this.f27769c);
            sb.append(str);
            j = -this.f27770d;
        }
        sb.append(j);
        return sb.toString();
    }
}
