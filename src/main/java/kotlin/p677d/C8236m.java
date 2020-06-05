package kotlin.p677d;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, mo39189d2 = {"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Ranges.kt */
/* renamed from: kotlin.d.m */
public final class C8236m extends C8233k implements Range<Long> {
    /* renamed from: b */
    public static final C8237a f27775b = new C8237a(null);
    /* renamed from: c */
    private static final C8236m f27776c = new C8236m(1, 0);

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo39189d2 = {"Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Ranges.kt */
    /* renamed from: kotlin.d.m$a */
    public static final class C8237a {
        private C8237a() {
        }

        public /* synthetic */ C8237a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public C8236m(long j, long j2) {
        super(j, j2, 1);
    }

    /* renamed from: e */
    public Long getStart() {
        return Long.valueOf(mo39417a());
    }

    /* renamed from: f */
    public Long getEndInclusive() {
        return Long.valueOf(mo39418b());
    }

    /* renamed from: d */
    public boolean mo39420d() {
        return mo39417a() > mo39418b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
            if (mo39418b() == r6.mo39418b()) goto L_0x002d;
     */
    public boolean equals(java.lang.Object r6) {
        /*
        r5 = this;
        boolean r0 = r6 instanceof kotlin.p677d.C8236m
        if (r0 == 0) goto L_0x002f
        boolean r0 = r5.mo39420d()
        if (r0 == 0) goto L_0x0013
        r0 = r6
        kotlin.d.m r0 = (kotlin.p677d.C8236m) r0
        boolean r0 = r0.mo39420d()
        if (r0 != 0) goto L_0x002d
    L_0x0013:
        long r0 = r5.mo39417a()
        kotlin.d.m r6 = (kotlin.p677d.C8236m) r6
        long r2 = r6.mo39417a()
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 != 0) goto L_0x002f
        long r0 = r5.mo39418b()
        long r2 = r6.mo39418b()
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.C8236m.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (mo39420d()) {
            return -1;
        }
        return (int) ((((long) 31) * (mo39417a() ^ (mo39417a() >>> 32))) + (mo39418b() ^ (mo39418b() >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo39417a());
        sb.append("..");
        sb.append(mo39418b());
        return sb.toString();
    }
}
