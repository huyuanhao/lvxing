package kotlin.p677d;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, mo39189d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Ranges.kt */
/* renamed from: kotlin.d.j */
public final class C8231j extends C8228h implements Range<Integer> {
    /* renamed from: b */
    public static final C8232a f27765b = new C8232a(null);
    /* access modifiers changed from: private|static|final */
    /* renamed from: c */
    public static final C8231j f27766c = new C8231j(1, 0);

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo39189d2 = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Ranges.kt */
    /* renamed from: kotlin.d.j$a */
    public static final class C8232a {
        private C8232a() {
        }

        public /* synthetic */ C8232a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public final C8231j mo39416a() {
            return C8231j.f27766c;
        }
    }

    public C8231j(int i, int i2) {
        super(i, i2, 1);
    }

    /* renamed from: f */
    public Integer getStart() {
        return Integer.valueOf(mo39403a());
    }

    /* renamed from: g */
    public Integer getEndInclusive() {
        return Integer.valueOf(mo39404b());
    }

    /* renamed from: e */
    public boolean mo39407e() {
        return mo39403a() > mo39404b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
            if (mo39404b() == r3.mo39404b()) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        boolean r0 = r3 instanceof kotlin.p677d.C8231j
        if (r0 == 0) goto L_0x002b
        boolean r0 = r2.mo39407e()
        if (r0 == 0) goto L_0x0013
        r0 = r3
        kotlin.d.j r0 = (kotlin.p677d.C8231j) r0
        boolean r0 = r0.mo39407e()
        if (r0 != 0) goto L_0x0029
    L_0x0013:
        int r0 = r2.mo39403a()
        kotlin.d.j r3 = (kotlin.p677d.C8231j) r3
        int r1 = r3.mo39403a()
        if (r0 != r1) goto L_0x002b
        int r0 = r2.mo39404b()
        int r3 = r3.mo39404b()
        if (r0 != r3) goto L_0x002b
    L_0x0029:
        r3 = 1
        goto L_0x002c
    L_0x002b:
        r3 = 0
    L_0x002c:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.C8231j.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (mo39407e()) {
            return -1;
        }
        return (mo39403a() * 31) + mo39404b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo39403a());
        sb.append("..");
        sb.append(mo39404b());
        return sb.toString();
    }
}
