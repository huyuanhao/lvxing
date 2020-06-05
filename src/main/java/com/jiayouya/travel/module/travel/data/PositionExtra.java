package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/PositionExtra;", "", "expire", "", "amount", "", "logId", "", "(JDI)V", "getAmount", "()D", "getExpire", "()J", "getLogId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PositionItem.kt */
public final class PositionExtra {
    private final double amount;
    private final long expire;
    private final int logId;

    public static /* synthetic */ PositionExtra copy$default(PositionExtra positionExtra, long j, double d, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = positionExtra.expire;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            d = positionExtra.amount;
        }
        double d2 = d;
        if ((i2 & 4) != 0) {
            i = positionExtra.logId;
        }
        return positionExtra.copy(j2, d2, i);
    }

    public final long component1() {
        return this.expire;
    }

    public final double component2() {
        return this.amount;
    }

    public final int component3() {
        return this.logId;
    }

    public final PositionExtra copy(long j, double d, int i) {
        PositionExtra positionExtra = new PositionExtra(j, d, i);
        return positionExtra;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PositionExtra) {
                PositionExtra positionExtra = (PositionExtra) obj;
                if ((this.expire == positionExtra.expire) && Double.compare(this.amount, positionExtra.amount) == 0) {
                    if (this.logId == positionExtra.logId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.expire;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.amount);
        return ((i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.logId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PositionExtra(expire=");
        sb.append(this.expire);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", logId=");
        sb.append(this.logId);
        sb.append(")");
        return sb.toString();
    }

    public PositionExtra(long j, double d, int i) {
        this.expire = j;
        this.amount = d;
        this.logId = i;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final long getExpire() {
        return this.expire;
    }

    public final int getLogId() {
        return this.logId;
    }
}
