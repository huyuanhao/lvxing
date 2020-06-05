package kotlin.p677d;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, mo39189d2 = {"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(CC)V", "getEndInclusive", "()Ljava/lang/Character;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.d.c */
public final class Ranges extends Progressions implements Range<Character> {
    /* renamed from: b */
    public static final C8224a f27751b = new C8224a(null);
    /* renamed from: c */
    private static final Ranges f27752c = new Ranges((char) 1, (char) 0);

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo39189d2 = {"Lkotlin/ranges/CharRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/CharRange;", "getEMPTY", "()Lkotlin/ranges/CharRange;", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Ranges.kt */
    /* renamed from: kotlin.d.c$a */
    public static final class C8224a {
        private C8224a() {
        }

        public /* synthetic */ C8224a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public Ranges(char c, char c2) {
        super(c, c2, 1);
    }

    /* renamed from: e */
    public Character getStart() {
        return Character.valueOf(mo39380a());
    }

    /* renamed from: f */
    public Character getEndInclusive() {
        return Character.valueOf(mo39381b());
    }

    /* renamed from: d */
    public boolean mo39383d() {
        return mo39380a() > mo39381b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
            if (mo39381b() == r3.mo39381b()) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        boolean r0 = r3 instanceof kotlin.p677d.Ranges
        if (r0 == 0) goto L_0x002b
        boolean r0 = r2.mo39383d()
        if (r0 == 0) goto L_0x0013
        r0 = r3
        kotlin.d.c r0 = (kotlin.p677d.Ranges) r0
        boolean r0 = r0.mo39383d()
        if (r0 != 0) goto L_0x0029
    L_0x0013:
        char r0 = r2.mo39380a()
        kotlin.d.c r3 = (kotlin.p677d.Ranges) r3
        char r1 = r3.mo39380a()
        if (r0 != r1) goto L_0x002b
        char r0 = r2.mo39381b()
        char r3 = r3.mo39381b()
        if (r0 != r3) goto L_0x002b
    L_0x0029:
        r3 = 1
        goto L_0x002c
    L_0x002b:
        r3 = 0
    L_0x002c:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.Ranges.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (mo39383d()) {
            return -1;
        }
        return (mo39380a() * 31) + mo39381b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo39380a());
        sb.append("..");
        sb.append(mo39381b());
        return sb.toString();
    }
}
