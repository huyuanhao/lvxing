package com.jiayouya.travel.module.travel.data;

import com.jiayouya.travel.module.common.data.AdRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/OfflineProfit;", "", "coin", "", "rate", "timeText", "", "adInfo", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "shareLogId", "(DDLjava/lang/String;Lcom/jiayouya/travel/module/common/data/AdRsp;Ljava/lang/String;)V", "getAdInfo", "()Lcom/jiayouya/travel/module/common/data/AdRsp;", "getCoin", "()D", "getRate", "getShareLogId", "()Ljava/lang/String;", "getTimeText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GameIndex.kt */
public final class OfflineProfit {
    private final AdRsp adInfo;
    private final double coin;
    private final double rate;
    private final String shareLogId;
    private final String timeText;

    public static /* synthetic */ OfflineProfit copy$default(OfflineProfit offlineProfit, double d, double d2, String str, AdRsp adRsp, String str2, int i, Object obj) {
        OfflineProfit offlineProfit2 = offlineProfit;
        return offlineProfit.copy((i & 1) != 0 ? offlineProfit2.coin : d, (i & 2) != 0 ? offlineProfit2.rate : d2, (i & 4) != 0 ? offlineProfit2.timeText : str, (i & 8) != 0 ? offlineProfit2.adInfo : adRsp, (i & 16) != 0 ? offlineProfit2.shareLogId : str2);
    }

    public final double component1() {
        return this.coin;
    }

    public final double component2() {
        return this.rate;
    }

    public final String component3() {
        return this.timeText;
    }

    public final AdRsp component4() {
        return this.adInfo;
    }

    public final String component5() {
        return this.shareLogId;
    }

    public final OfflineProfit copy(double d, double d2, String str, AdRsp adRsp, String str2) {
        String str3 = str;
        C8271i.m35386b(str, "timeText");
        OfflineProfit offlineProfit = new OfflineProfit(d, d2, str3, adRsp, str2);
        return offlineProfit;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r4.shareLogId, (java.lang.Object) r5.shareLogId) != false) goto L_0x003d;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x003d
        boolean r0 = r5 instanceof com.jiayouya.travel.module.travel.data.OfflineProfit
        if (r0 == 0) goto L_0x003b
        com.jiayouya.travel.module.travel.data.OfflineProfit r5 = (com.jiayouya.travel.module.travel.data.OfflineProfit) r5
        double r0 = r4.coin
        double r2 = r5.coin
        int r0 = java.lang.Double.compare(r0, r2)
        if (r0 != 0) goto L_0x003b
        double r0 = r4.rate
        double r2 = r5.rate
        int r0 = java.lang.Double.compare(r0, r2)
        if (r0 != 0) goto L_0x003b
        java.lang.String r0 = r4.timeText
        java.lang.String r1 = r5.timeText
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        com.jiayouya.travel.module.common.data.AdRsp r0 = r4.adInfo
        com.jiayouya.travel.module.common.data.AdRsp r1 = r5.adInfo
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.lang.String r0 = r4.shareLogId
        java.lang.String r5 = r5.shareLogId
        boolean r5 = kotlin.jvm.internal.C8271i.m35384a(r0, r5)
        if (r5 == 0) goto L_0x003b
        goto L_0x003d
    L_0x003b:
        r5 = 0
        return r5
    L_0x003d:
        r5 = 1
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.OfflineProfit.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.coin);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.rate);
        int i2 = (i + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        String str = this.timeText;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        AdRsp adRsp = this.adInfo;
        int hashCode2 = (hashCode + (adRsp != null ? adRsp.hashCode() : 0)) * 31;
        String str2 = this.shareLogId;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode2 + i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OfflineProfit(coin=");
        sb.append(this.coin);
        sb.append(", rate=");
        sb.append(this.rate);
        sb.append(", timeText=");
        sb.append(this.timeText);
        sb.append(", adInfo=");
        sb.append(this.adInfo);
        sb.append(", shareLogId=");
        sb.append(this.shareLogId);
        sb.append(")");
        return sb.toString();
    }

    public OfflineProfit(double d, double d2, String str, AdRsp adRsp, String str2) {
        C8271i.m35386b(str, "timeText");
        this.coin = d;
        this.rate = d2;
        this.timeText = str;
        this.adInfo = adRsp;
        this.shareLogId = str2;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final double getRate() {
        return this.rate;
    }

    public final String getTimeText() {
        return this.timeText;
    }

    public final AdRsp getAdInfo() {
        return this.adInfo;
    }

    public final String getShareLogId() {
        return this.shareLogId;
    }
}
