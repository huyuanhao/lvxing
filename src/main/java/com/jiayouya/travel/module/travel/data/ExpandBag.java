package com.jiayouya.travel.module.travel.data;

import com.jiayouya.travel.module.common.data.AdRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/ExpandBag;", "", "maxNum", "", "coin", "", "timeText", "adInfo", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "(Ljava/lang/String;DLjava/lang/String;Lcom/jiayouya/travel/module/common/data/AdRsp;)V", "getAdInfo", "()Lcom/jiayouya/travel/module/common/data/AdRsp;", "getCoin", "()D", "getMaxNum", "()Ljava/lang/String;", "getTimeText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExpandBag.kt */
public final class ExpandBag {
    private final AdRsp adInfo;
    private final double coin;
    private final String maxNum;
    private final String timeText;

    public static /* synthetic */ ExpandBag copy$default(ExpandBag expandBag, String str, double d, String str2, AdRsp adRsp, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expandBag.maxNum;
        }
        if ((i & 2) != 0) {
            d = expandBag.coin;
        }
        double d2 = d;
        if ((i & 4) != 0) {
            str2 = expandBag.timeText;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            adRsp = expandBag.adInfo;
        }
        return expandBag.copy(str, d2, str3, adRsp);
    }

    public final String component1() {
        return this.maxNum;
    }

    public final double component2() {
        return this.coin;
    }

    public final String component3() {
        return this.timeText;
    }

    public final AdRsp component4() {
        return this.adInfo;
    }

    public final ExpandBag copy(String str, double d, String str2, AdRsp adRsp) {
        C8271i.m35386b(str, "maxNum");
        C8271i.m35386b(str2, "timeText");
        ExpandBag expandBag = new ExpandBag(str, d, str2, adRsp);
        return expandBag;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r4.adInfo, (java.lang.Object) r5.adInfo) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x0033
        boolean r0 = r5 instanceof com.jiayouya.travel.module.travel.data.ExpandBag
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.travel.data.ExpandBag r5 = (com.jiayouya.travel.module.travel.data.ExpandBag) r5
        java.lang.String r0 = r4.maxNum
        java.lang.String r1 = r5.maxNum
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        double r0 = r4.coin
        double r2 = r5.coin
        int r0 = java.lang.Double.compare(r0, r2)
        if (r0 != 0) goto L_0x0031
        java.lang.String r0 = r4.timeText
        java.lang.String r1 = r5.timeText
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.common.data.AdRsp r0 = r4.adInfo
        com.jiayouya.travel.module.common.data.AdRsp r5 = r5.adInfo
        boolean r5 = kotlin.jvm.internal.C8271i.m35384a(r0, r5)
        if (r5 == 0) goto L_0x0031
        goto L_0x0033
    L_0x0031:
        r5 = 0
        return r5
    L_0x0033:
        r5 = 1
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.ExpandBag.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.maxNum;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.coin);
        int i2 = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        String str2 = this.timeText;
        int hashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        AdRsp adRsp = this.adInfo;
        if (adRsp != null) {
            i = adRsp.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExpandBag(maxNum=");
        sb.append(this.maxNum);
        sb.append(", coin=");
        sb.append(this.coin);
        sb.append(", timeText=");
        sb.append(this.timeText);
        sb.append(", adInfo=");
        sb.append(this.adInfo);
        sb.append(")");
        return sb.toString();
    }

    public ExpandBag(String str, double d, String str2, AdRsp adRsp) {
        C8271i.m35386b(str, "maxNum");
        C8271i.m35386b(str2, "timeText");
        this.maxNum = str;
        this.coin = d;
        this.timeText = str2;
        this.adInfo = adRsp;
    }

    public final AdRsp getAdInfo() {
        return this.adInfo;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final String getMaxNum() {
        return this.maxNum;
    }

    public final String getTimeText() {
        return this.timeText;
    }
}
