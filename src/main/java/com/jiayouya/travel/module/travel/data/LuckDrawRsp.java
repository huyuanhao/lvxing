package com.jiayouya.travel.module.travel.data;

import com.jiayouya.travel.module.common.data.AdRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003JW\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006("}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/LuckDrawRsp;", "", "coin", "", "tickets", "", "prizeId", "", "timeText", "hbInfo", "Lcom/jiayouya/travel/module/travel/data/HbInformation;", "adInfo", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "adIdInfoFlow", "(DILjava/lang/String;Ljava/lang/String;Lcom/jiayouya/travel/module/travel/data/HbInformation;Lcom/jiayouya/travel/module/common/data/AdRsp;Ljava/lang/String;)V", "getAdIdInfoFlow", "()Ljava/lang/String;", "getAdInfo", "()Lcom/jiayouya/travel/module/common/data/AdRsp;", "getCoin", "()D", "getHbInfo", "()Lcom/jiayouya/travel/module/travel/data/HbInformation;", "getPrizeId", "getTickets", "()I", "getTimeText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LuckDrawRsp.kt */
public final class LuckDrawRsp {
    private final String adIdInfoFlow;
    private final AdRsp adInfo;
    private final double coin;
    private final HbInformation hbInfo;
    private final String prizeId;
    private final int tickets;
    private final String timeText;

    public static /* synthetic */ LuckDrawRsp copy$default(LuckDrawRsp luckDrawRsp, double d, int i, String str, String str2, HbInformation hbInformation, AdRsp adRsp, String str3, int i2, Object obj) {
        LuckDrawRsp luckDrawRsp2 = luckDrawRsp;
        return luckDrawRsp.copy((i2 & 1) != 0 ? luckDrawRsp2.coin : d, (i2 & 2) != 0 ? luckDrawRsp2.tickets : i, (i2 & 4) != 0 ? luckDrawRsp2.prizeId : str, (i2 & 8) != 0 ? luckDrawRsp2.timeText : str2, (i2 & 16) != 0 ? luckDrawRsp2.hbInfo : hbInformation, (i2 & 32) != 0 ? luckDrawRsp2.adInfo : adRsp, (i2 & 64) != 0 ? luckDrawRsp2.adIdInfoFlow : str3);
    }

    public final double component1() {
        return this.coin;
    }

    public final int component2() {
        return this.tickets;
    }

    public final String component3() {
        return this.prizeId;
    }

    public final String component4() {
        return this.timeText;
    }

    public final HbInformation component5() {
        return this.hbInfo;
    }

    public final AdRsp component6() {
        return this.adInfo;
    }

    public final String component7() {
        return this.adIdInfoFlow;
    }

    public final LuckDrawRsp copy(double d, int i, String str, String str2, HbInformation hbInformation, AdRsp adRsp, String str3) {
        String str4 = str;
        C8271i.m35386b(str, "prizeId");
        LuckDrawRsp luckDrawRsp = new LuckDrawRsp(d, i, str4, str2, hbInformation, adRsp, str3);
        return luckDrawRsp;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LuckDrawRsp) {
                LuckDrawRsp luckDrawRsp = (LuckDrawRsp) obj;
                if (Double.compare(this.coin, luckDrawRsp.coin) == 0) {
                    if (!(this.tickets == luckDrawRsp.tickets) || !C8271i.m35384a((Object) this.prizeId, (Object) luckDrawRsp.prizeId) || !C8271i.m35384a((Object) this.timeText, (Object) luckDrawRsp.timeText) || !C8271i.m35384a((Object) this.hbInfo, (Object) luckDrawRsp.hbInfo) || !C8271i.m35384a((Object) this.adInfo, (Object) luckDrawRsp.adInfo) || !C8271i.m35384a((Object) this.adIdInfoFlow, (Object) luckDrawRsp.adIdInfoFlow)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.coin);
        int i = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + this.tickets) * 31;
        String str = this.prizeId;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.timeText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        HbInformation hbInformation = this.hbInfo;
        int hashCode3 = (hashCode2 + (hbInformation != null ? hbInformation.hashCode() : 0)) * 31;
        AdRsp adRsp = this.adInfo;
        int hashCode4 = (hashCode3 + (adRsp != null ? adRsp.hashCode() : 0)) * 31;
        String str3 = this.adIdInfoFlow;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LuckDrawRsp(coin=");
        sb.append(this.coin);
        sb.append(", tickets=");
        sb.append(this.tickets);
        sb.append(", prizeId=");
        sb.append(this.prizeId);
        sb.append(", timeText=");
        sb.append(this.timeText);
        sb.append(", hbInfo=");
        sb.append(this.hbInfo);
        sb.append(", adInfo=");
        sb.append(this.adInfo);
        sb.append(", adIdInfoFlow=");
        sb.append(this.adIdInfoFlow);
        sb.append(")");
        return sb.toString();
    }

    public LuckDrawRsp(double d, int i, String str, String str2, HbInformation hbInformation, AdRsp adRsp, String str3) {
        C8271i.m35386b(str, "prizeId");
        this.coin = d;
        this.tickets = i;
        this.prizeId = str;
        this.timeText = str2;
        this.hbInfo = hbInformation;
        this.adInfo = adRsp;
        this.adIdInfoFlow = str3;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final int getTickets() {
        return this.tickets;
    }

    public final String getPrizeId() {
        return this.prizeId;
    }

    public final String getTimeText() {
        return this.timeText;
    }

    public final HbInformation getHbInfo() {
        return this.hbInfo;
    }

    public final AdRsp getAdInfo() {
        return this.adInfo;
    }

    public final String getAdIdInfoFlow() {
        return this.adIdInfoFlow;
    }
}
