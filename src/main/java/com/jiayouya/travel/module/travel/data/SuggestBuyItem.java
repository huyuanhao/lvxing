package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/SuggestBuyItem;", "", "dogId", "", "level", "price", "", "(IID)V", "getDogId", "()I", "getLevel", "getPrice", "()D", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SuggestBuyItem.kt */
public final class SuggestBuyItem {
    private final int dogId;
    private final int level;
    private final double price;

    public static /* synthetic */ SuggestBuyItem copy$default(SuggestBuyItem suggestBuyItem, int i, int i2, double d, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = suggestBuyItem.dogId;
        }
        if ((i3 & 2) != 0) {
            i2 = suggestBuyItem.level;
        }
        if ((i3 & 4) != 0) {
            d = suggestBuyItem.price;
        }
        return suggestBuyItem.copy(i, i2, d);
    }

    public final int component1() {
        return this.dogId;
    }

    public final int component2() {
        return this.level;
    }

    public final double component3() {
        return this.price;
    }

    public final SuggestBuyItem copy(int i, int i2, double d) {
        return new SuggestBuyItem(i, i2, d);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SuggestBuyItem) {
                SuggestBuyItem suggestBuyItem = (SuggestBuyItem) obj;
                if (this.dogId == suggestBuyItem.dogId) {
                    if (!(this.level == suggestBuyItem.level) || Double.compare(this.price, suggestBuyItem.price) != 0) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.dogId * 31) + this.level) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.price);
        return i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SuggestBuyItem(dogId=");
        sb.append(this.dogId);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(")");
        return sb.toString();
    }

    public SuggestBuyItem(int i, int i2, double d) {
        this.dogId = i;
        this.level = i2;
        this.price = d;
    }

    public final int getDogId() {
        return this.dogId;
    }

    public final int getLevel() {
        return this.level;
    }

    public final double getPrice() {
        return this.price;
    }
}
