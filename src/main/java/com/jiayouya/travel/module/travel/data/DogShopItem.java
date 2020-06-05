package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b&\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003Jw\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eHÆ\u0001J\u0013\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018¨\u00064"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "", "dogId", "", "level", "buyNum", "isLock", "", "name", "", "initPrice", "", "photo", "coinProfit", "", "recyclePrice", "maxPrice", "riseRate", "(IIIZLjava/lang/String;JLjava/lang/String;DDDD)V", "getBuyNum", "()I", "setBuyNum", "(I)V", "getCoinProfit", "()D", "getDogId", "getInitPrice", "()J", "()Z", "getLevel", "getMaxPrice", "getName", "()Ljava/lang/String;", "getPhoto", "getRecyclePrice", "getRiseRate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogShopItem.kt */
public final class DogShopItem {
    private int buyNum;
    private final double coinProfit;
    private final int dogId;
    private final long initPrice;
    private final boolean isLock;
    private final int level;
    private final double maxPrice;
    private final String name;
    private final String photo;
    private final double recyclePrice;
    private final double riseRate;

    public static /* synthetic */ DogShopItem copy$default(DogShopItem dogShopItem, int i, int i2, int i3, boolean z, String str, long j, String str2, double d, double d2, double d3, double d4, int i4, Object obj) {
        DogShopItem dogShopItem2 = dogShopItem;
        int i5 = i4;
        return dogShopItem.copy((i5 & 1) != 0 ? dogShopItem2.dogId : i, (i5 & 2) != 0 ? dogShopItem2.level : i2, (i5 & 4) != 0 ? dogShopItem2.buyNum : i3, (i5 & 8) != 0 ? dogShopItem2.isLock : z, (i5 & 16) != 0 ? dogShopItem2.name : str, (i5 & 32) != 0 ? dogShopItem2.initPrice : j, (i5 & 64) != 0 ? dogShopItem2.photo : str2, (i5 & 128) != 0 ? dogShopItem2.coinProfit : d, (i5 & 256) != 0 ? dogShopItem2.recyclePrice : d2, (i5 & 512) != 0 ? dogShopItem2.maxPrice : d3, (i5 & 1024) != 0 ? dogShopItem2.riseRate : d4);
    }

    public final int component1() {
        return this.dogId;
    }

    public final double component10() {
        return this.maxPrice;
    }

    public final double component11() {
        return this.riseRate;
    }

    public final int component2() {
        return this.level;
    }

    public final int component3() {
        return this.buyNum;
    }

    public final boolean component4() {
        return this.isLock;
    }

    public final String component5() {
        return this.name;
    }

    public final long component6() {
        return this.initPrice;
    }

    public final String component7() {
        return this.photo;
    }

    public final double component8() {
        return this.coinProfit;
    }

    public final double component9() {
        return this.recyclePrice;
    }

    public final DogShopItem copy(int i, int i2, int i3, boolean z, String str, long j, String str2, double d, double d2, double d3, double d4) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        boolean z2 = z;
        String str3 = str;
        long j2 = j;
        String str4 = str2;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "photo");
        DogShopItem dogShopItem = new DogShopItem(i, i5, i6, z2, str3, j2, str4, d5, d6, d7, d8);
        return dogShopItem;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DogShopItem) {
                DogShopItem dogShopItem = (DogShopItem) obj;
                if (this.dogId == dogShopItem.dogId) {
                    if (this.level == dogShopItem.level) {
                        if (this.buyNum == dogShopItem.buyNum) {
                            if ((this.isLock == dogShopItem.isLock) && C8271i.m35384a((Object) this.name, (Object) dogShopItem.name)) {
                                if (!((this.initPrice == dogShopItem.initPrice) && C8271i.m35384a((Object) this.photo, (Object) dogShopItem.photo) && Double.compare(this.coinProfit, dogShopItem.coinProfit) == 0 && Double.compare(this.recyclePrice, dogShopItem.recyclePrice) == 0 && Double.compare(this.maxPrice, dogShopItem.maxPrice) == 0 && Double.compare(this.riseRate, dogShopItem.riseRate) == 0)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((((this.dogId * 31) + this.level) * 31) + this.buyNum) * 31;
        boolean z = this.isLock;
        if (z) {
            z = true;
        }
        int i2 = (i + z) * 31;
        String str = this.name;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.initPrice;
        int i4 = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.photo;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        int i5 = (i4 + i3) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.coinProfit);
        int i6 = (i5 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.recyclePrice);
        int i7 = (i6 + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        long doubleToLongBits3 = Double.doubleToLongBits(this.maxPrice);
        int i8 = (i7 + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31;
        long doubleToLongBits4 = Double.doubleToLongBits(this.riseRate);
        return i8 + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DogShopItem(dogId=");
        sb.append(this.dogId);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", buyNum=");
        sb.append(this.buyNum);
        sb.append(", isLock=");
        sb.append(this.isLock);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", initPrice=");
        sb.append(this.initPrice);
        sb.append(", photo=");
        sb.append(this.photo);
        sb.append(", coinProfit=");
        sb.append(this.coinProfit);
        sb.append(", recyclePrice=");
        sb.append(this.recyclePrice);
        sb.append(", maxPrice=");
        sb.append(this.maxPrice);
        sb.append(", riseRate=");
        sb.append(this.riseRate);
        sb.append(")");
        return sb.toString();
    }

    public DogShopItem(int i, int i2, int i3, boolean z, String str, long j, String str2, double d, double d2, double d3, double d4) {
        String str3 = str;
        String str4 = str2;
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "photo");
        this.dogId = i;
        this.level = i2;
        this.buyNum = i3;
        this.isLock = z;
        this.name = str3;
        this.initPrice = j;
        this.photo = str4;
        this.coinProfit = d;
        this.recyclePrice = d2;
        this.maxPrice = d3;
        this.riseRate = d4;
    }

    public final int getBuyNum() {
        return this.buyNum;
    }

    public final int getDogId() {
        return this.dogId;
    }

    public final int getLevel() {
        return this.level;
    }

    public final boolean isLock() {
        return this.isLock;
    }

    public final void setBuyNum(int i) {
        this.buyNum = i;
    }

    public final double getCoinProfit() {
        return this.coinProfit;
    }

    public final long getInitPrice() {
        return this.initPrice;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhoto() {
        return this.photo;
    }

    public final double getMaxPrice() {
        return this.maxPrice;
    }

    public final double getRecyclePrice() {
        return this.recyclePrice;
    }

    public final double getRiseRate() {
        return this.riseRate;
    }
}
