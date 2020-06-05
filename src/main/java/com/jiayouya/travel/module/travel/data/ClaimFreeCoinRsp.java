package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/ClaimFreeCoinRsp;", "", "coin", "", "seconds", "", "adIdInfoFlow", "", "(DJLjava/lang/String;)V", "getAdIdInfoFlow", "()Ljava/lang/String;", "getCoin", "()D", "getSeconds", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ClaimFreeCoinRsp.kt */
public final class ClaimFreeCoinRsp {
    private final String adIdInfoFlow;
    private final double coin;
    private final long seconds;

    public static /* synthetic */ ClaimFreeCoinRsp copy$default(ClaimFreeCoinRsp claimFreeCoinRsp, double d, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = claimFreeCoinRsp.coin;
        }
        double d2 = d;
        if ((i & 2) != 0) {
            j = claimFreeCoinRsp.seconds;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str = claimFreeCoinRsp.adIdInfoFlow;
        }
        return claimFreeCoinRsp.copy(d2, j2, str);
    }

    public final double component1() {
        return this.coin;
    }

    public final long component2() {
        return this.seconds;
    }

    public final String component3() {
        return this.adIdInfoFlow;
    }

    public final ClaimFreeCoinRsp copy(double d, long j, String str) {
        ClaimFreeCoinRsp claimFreeCoinRsp = new ClaimFreeCoinRsp(d, j, str);
        return claimFreeCoinRsp;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ClaimFreeCoinRsp) {
                ClaimFreeCoinRsp claimFreeCoinRsp = (ClaimFreeCoinRsp) obj;
                if (Double.compare(this.coin, claimFreeCoinRsp.coin) == 0) {
                    if (!(this.seconds == claimFreeCoinRsp.seconds) || !C8271i.m35384a((Object) this.adIdInfoFlow, (Object) claimFreeCoinRsp.adIdInfoFlow)) {
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
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        long j = this.seconds;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.adIdInfoFlow;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClaimFreeCoinRsp(coin=");
        sb.append(this.coin);
        sb.append(", seconds=");
        sb.append(this.seconds);
        sb.append(", adIdInfoFlow=");
        sb.append(this.adIdInfoFlow);
        sb.append(")");
        return sb.toString();
    }

    public ClaimFreeCoinRsp(double d, long j, String str) {
        this.coin = d;
        this.seconds = j;
        this.adIdInfoFlow = str;
    }

    public final String getAdIdInfoFlow() {
        return this.adIdInfoFlow;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final long getSeconds() {
        return this.seconds;
    }
}
