package com.jiayouya.travel.module.travel.data;

import com.jiayouya.travel.module.common.data.AdRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "", "coin", "", "position", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "suggest", "Lcom/jiayouya/travel/module/travel/data/SuggestBuyItem;", "adInfo", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "timeText", "", "(DLcom/jiayouya/travel/module/travel/data/PositionItem;Lcom/jiayouya/travel/module/travel/data/SuggestBuyItem;Lcom/jiayouya/travel/module/common/data/AdRsp;Ljava/lang/String;)V", "getAdInfo", "()Lcom/jiayouya/travel/module/common/data/AdRsp;", "getCoin", "()D", "getPosition", "()Lcom/jiayouya/travel/module/travel/data/PositionItem;", "getSuggest", "()Lcom/jiayouya/travel/module/travel/data/SuggestBuyItem;", "getTimeText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BuyDogRsp.kt */
public final class BuyDogRsp {
    private final AdRsp adInfo;
    private final double coin;
    private final PositionItem position;
    private final SuggestBuyItem suggest;
    private final String timeText;

    public static /* synthetic */ BuyDogRsp copy$default(BuyDogRsp buyDogRsp, double d, PositionItem positionItem, SuggestBuyItem suggestBuyItem, AdRsp adRsp, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = buyDogRsp.coin;
        }
        double d2 = d;
        if ((i & 2) != 0) {
            positionItem = buyDogRsp.position;
        }
        PositionItem positionItem2 = positionItem;
        if ((i & 4) != 0) {
            suggestBuyItem = buyDogRsp.suggest;
        }
        SuggestBuyItem suggestBuyItem2 = suggestBuyItem;
        if ((i & 8) != 0) {
            adRsp = buyDogRsp.adInfo;
        }
        AdRsp adRsp2 = adRsp;
        if ((i & 16) != 0) {
            str = buyDogRsp.timeText;
        }
        return buyDogRsp.copy(d2, positionItem2, suggestBuyItem2, adRsp2, str);
    }

    public final double component1() {
        return this.coin;
    }

    public final PositionItem component2() {
        return this.position;
    }

    public final SuggestBuyItem component3() {
        return this.suggest;
    }

    public final AdRsp component4() {
        return this.adInfo;
    }

    public final String component5() {
        return this.timeText;
    }

    public final BuyDogRsp copy(double d, PositionItem positionItem, SuggestBuyItem suggestBuyItem, AdRsp adRsp, String str) {
        C8271i.m35386b(str, "timeText");
        BuyDogRsp buyDogRsp = new BuyDogRsp(d, positionItem, suggestBuyItem, adRsp, str);
        return buyDogRsp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r4.timeText, (java.lang.Object) r5.timeText) != false) goto L_0x003d;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x003d
        boolean r0 = r5 instanceof com.jiayouya.travel.module.travel.data.BuyDogRsp
        if (r0 == 0) goto L_0x003b
        com.jiayouya.travel.module.travel.data.BuyDogRsp r5 = (com.jiayouya.travel.module.travel.data.BuyDogRsp) r5
        double r0 = r4.coin
        double r2 = r5.coin
        int r0 = java.lang.Double.compare(r0, r2)
        if (r0 != 0) goto L_0x003b
        com.jiayouya.travel.module.travel.data.PositionItem r0 = r4.position
        com.jiayouya.travel.module.travel.data.PositionItem r1 = r5.position
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        com.jiayouya.travel.module.travel.data.SuggestBuyItem r0 = r4.suggest
        com.jiayouya.travel.module.travel.data.SuggestBuyItem r1 = r5.suggest
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        com.jiayouya.travel.module.common.data.AdRsp r0 = r4.adInfo
        com.jiayouya.travel.module.common.data.AdRsp r1 = r5.adInfo
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.lang.String r0 = r4.timeText
        java.lang.String r5 = r5.timeText
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.BuyDogRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.coin);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        PositionItem positionItem = this.position;
        int i2 = 0;
        int hashCode = (i + (positionItem != null ? positionItem.hashCode() : 0)) * 31;
        SuggestBuyItem suggestBuyItem = this.suggest;
        int hashCode2 = (hashCode + (suggestBuyItem != null ? suggestBuyItem.hashCode() : 0)) * 31;
        AdRsp adRsp = this.adInfo;
        int hashCode3 = (hashCode2 + (adRsp != null ? adRsp.hashCode() : 0)) * 31;
        String str = this.timeText;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BuyDogRsp(coin=");
        sb.append(this.coin);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", suggest=");
        sb.append(this.suggest);
        sb.append(", adInfo=");
        sb.append(this.adInfo);
        sb.append(", timeText=");
        sb.append(this.timeText);
        sb.append(")");
        return sb.toString();
    }

    public BuyDogRsp(double d, PositionItem positionItem, SuggestBuyItem suggestBuyItem, AdRsp adRsp, String str) {
        C8271i.m35386b(str, "timeText");
        this.coin = d;
        this.position = positionItem;
        this.suggest = suggestBuyItem;
        this.adInfo = adRsp;
        this.timeText = str;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final PositionItem getPosition() {
        return this.position;
    }

    public final SuggestBuyItem getSuggest() {
        return this.suggest;
    }

    public final AdRsp getAdInfo() {
        return this.adInfo;
    }

    public final String getTimeText() {
        return this.timeText;
    }
}
