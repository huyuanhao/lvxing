package kotlin.text;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.p677d.C8231j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo39189d2 = {"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Regex.kt */
/* renamed from: kotlin.text.g */
public final class C8306g {
    /* renamed from: a */
    private final String f27816a;
    /* renamed from: b */
    private final C8231j f27817b;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.f27817b, (java.lang.Object) r3.f27817b) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof kotlin.text.C8306g
        if (r0 == 0) goto L_0x001d
        kotlin.text.g r3 = (kotlin.text.C8306g) r3
        java.lang.String r0 = r2.f27816a
        java.lang.String r1 = r3.f27816a
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        kotlin.d.j r0 = r2.f27817b
        kotlin.d.j r3 = r3.f27817b
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x001d
        goto L_0x001f
    L_0x001d:
        r3 = 0
        return r3
    L_0x001f:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.C8306g.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f27816a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        C8231j jVar = this.f27817b;
        if (jVar != null) {
            i = jVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MatchGroup(value=");
        sb.append(this.f27816a);
        sb.append(", range=");
        sb.append(this.f27817b);
        sb.append(")");
        return sb.toString();
    }

    public C8306g(String str, C8231j jVar) {
        C8271i.m35386b(str, ArgKey.KEY_VALUE);
        C8271i.m35386b(jVar, "range");
        this.f27816a = str;
        this.f27817b = jVar;
    }
}
