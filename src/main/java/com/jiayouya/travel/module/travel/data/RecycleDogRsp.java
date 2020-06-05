package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/RecycleDogRsp;", "", "type", "", "number", "", "(ID)V", "getNumber", "()D", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RecycleDogRsp.kt */
public final class RecycleDogRsp {
    private final double number;
    private final int type;

    public static /* synthetic */ RecycleDogRsp copy$default(RecycleDogRsp recycleDogRsp, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = recycleDogRsp.type;
        }
        if ((i2 & 2) != 0) {
            d = recycleDogRsp.number;
        }
        return recycleDogRsp.copy(i, d);
    }

    public final int component1() {
        return this.type;
    }

    public final double component2() {
        return this.number;
    }

    public final RecycleDogRsp copy(int i, double d) {
        return new RecycleDogRsp(i, d);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RecycleDogRsp) {
                RecycleDogRsp recycleDogRsp = (RecycleDogRsp) obj;
                if (!(this.type == recycleDogRsp.type) || Double.compare(this.number, recycleDogRsp.number) != 0) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.type * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.number);
        return i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RecycleDogRsp(type=");
        sb.append(this.type);
        sb.append(", number=");
        sb.append(this.number);
        sb.append(")");
        return sb.toString();
    }

    public RecycleDogRsp(int i, double d) {
        this.type = i;
        this.number = d;
    }

    public final double getNumber() {
        return this.number;
    }

    public final int getType() {
        return this.type;
    }
}
