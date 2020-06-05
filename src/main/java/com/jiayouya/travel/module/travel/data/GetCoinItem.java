package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/GetCoinItem;", "", "title", "", "desc", "coin", "", "adIdInfoFlow", "isLong", "", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Z)V", "getAdIdInfoFlow", "()Ljava/lang/String;", "getCoin", "()D", "getDesc", "()Z", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GetCoinItem.kt */
public final class GetCoinItem {
    private final String adIdInfoFlow;
    private final double coin;
    private final String desc;
    private final boolean isLong;
    private final String title;

    public static /* synthetic */ GetCoinItem copy$default(GetCoinItem getCoinItem, String str, String str2, double d, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getCoinItem.title;
        }
        if ((i & 2) != 0) {
            str2 = getCoinItem.desc;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            d = getCoinItem.coin;
        }
        double d2 = d;
        if ((i & 8) != 0) {
            str3 = getCoinItem.adIdInfoFlow;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            z = getCoinItem.isLong;
        }
        return getCoinItem.copy(str, str4, d2, str5, z);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.desc;
    }

    public final double component3() {
        return this.coin;
    }

    public final String component4() {
        return this.adIdInfoFlow;
    }

    public final boolean component5() {
        return this.isLong;
    }

    public final GetCoinItem copy(String str, String str2, double d, String str3, boolean z) {
        C8271i.m35386b(str, "title");
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        GetCoinItem getCoinItem = new GetCoinItem(str, str2, d, str3, z);
        return getCoinItem;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GetCoinItem) {
                GetCoinItem getCoinItem = (GetCoinItem) obj;
                if (C8271i.m35384a((Object) this.title, (Object) getCoinItem.title) && C8271i.m35384a((Object) this.desc, (Object) getCoinItem.desc) && Double.compare(this.coin, getCoinItem.coin) == 0 && C8271i.m35384a((Object) this.adIdInfoFlow, (Object) getCoinItem.adIdInfoFlow)) {
                    if (this.isLong == getCoinItem.isLong) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.desc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.coin);
        int i2 = (hashCode2 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        String str3 = this.adIdInfoFlow;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i3 = (i2 + i) * 31;
        boolean z = this.isLong;
        if (z) {
            z = true;
        }
        return i3 + z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetCoinItem(title=");
        sb.append(this.title);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", coin=");
        sb.append(this.coin);
        sb.append(", adIdInfoFlow=");
        sb.append(this.adIdInfoFlow);
        sb.append(", isLong=");
        sb.append(this.isLong);
        sb.append(")");
        return sb.toString();
    }

    public GetCoinItem(String str, String str2, double d, String str3, boolean z) {
        C8271i.m35386b(str, "title");
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        this.title = str;
        this.desc = str2;
        this.coin = d;
        this.adIdInfoFlow = str3;
        this.isLong = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final String getAdIdInfoFlow() {
        return this.adIdInfoFlow;
    }

    public /* synthetic */ GetCoinItem(String str, String str2, double d, String str3, boolean z, int i, DefaultConstructorMarker fVar) {
        this(str, str2, d, str3, (i & 16) != 0 ? false : z);
    }

    public final boolean isLong() {
        return this.isLong;
    }
}
