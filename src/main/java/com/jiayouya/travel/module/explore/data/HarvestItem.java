package com.jiayouya.travel.module.explore.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/data/HarvestItem;", "", "type", "", "value", "", "(ID)V", "getType", "()I", "setType", "(I)V", "getValue", "()D", "setValue", "(D)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExploreIndex.kt */
public final class HarvestItem {
    private int type;
    private double value;

    public static /* synthetic */ HarvestItem copy$default(HarvestItem harvestItem, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = harvestItem.type;
        }
        if ((i2 & 2) != 0) {
            d = harvestItem.value;
        }
        return harvestItem.copy(i, d);
    }

    public final int component1() {
        return this.type;
    }

    public final double component2() {
        return this.value;
    }

    public final HarvestItem copy(int i, double d) {
        return new HarvestItem(i, d);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HarvestItem) {
                HarvestItem harvestItem = (HarvestItem) obj;
                if (!(this.type == harvestItem.type) || Double.compare(this.value, harvestItem.value) != 0) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.type * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        return i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HarvestItem(type=");
        sb.append(this.type);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(")");
        return sb.toString();
    }

    public HarvestItem(int i, double d) {
        this.type = i;
        this.value = d;
    }

    public final int getType() {
        return this.type;
    }

    public final double getValue() {
        return this.value;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setValue(double d) {
        this.value = d;
    }
}
