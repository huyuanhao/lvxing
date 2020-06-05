package com.jiayouya.travel.module.group.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/ClaimCityReward;", "", "score", "", "percent", "(Ljava/lang/String;Ljava/lang/String;)V", "getPercent", "()Ljava/lang/String;", "getScore", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ClaimCityReward.kt */
public final class ClaimCityReward {
    private final String percent;
    private final String score;

    public static /* synthetic */ ClaimCityReward copy$default(ClaimCityReward claimCityReward, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = claimCityReward.score;
        }
        if ((i & 2) != 0) {
            str2 = claimCityReward.percent;
        }
        return claimCityReward.copy(str, str2);
    }

    public final String component1() {
        return this.score;
    }

    public final String component2() {
        return this.percent;
    }

    public final ClaimCityReward copy(String str, String str2) {
        C8271i.m35386b(str, "score");
        C8271i.m35386b(str2, "percent");
        return new ClaimCityReward(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.percent, (java.lang.Object) r3.percent) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof com.jiayouya.travel.module.group.data.ClaimCityReward
        if (r0 == 0) goto L_0x001d
        com.jiayouya.travel.module.group.data.ClaimCityReward r3 = (com.jiayouya.travel.module.group.data.ClaimCityReward) r3
        java.lang.String r0 = r2.score
        java.lang.String r1 = r3.score
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        java.lang.String r0 = r2.percent
        java.lang.String r3 = r3.percent
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.group.data.ClaimCityReward.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.score;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.percent;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClaimCityReward(score=");
        sb.append(this.score);
        sb.append(", percent=");
        sb.append(this.percent);
        sb.append(")");
        return sb.toString();
    }

    public ClaimCityReward(String str, String str2) {
        C8271i.m35386b(str, "score");
        C8271i.m35386b(str2, "percent");
        this.score = str;
        this.percent = str2;
    }

    public final String getPercent() {
        return this.percent;
    }

    public final String getScore() {
        return this.score;
    }
}
