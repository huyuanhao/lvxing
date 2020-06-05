package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/TempBonusItem;", "", "time", "", "amount", "", "(JLjava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TempBonusItem.kt */
public final class TempBonusItem {
    private final String amount;
    private final long time;

    public static /* synthetic */ TempBonusItem copy$default(TempBonusItem tempBonusItem, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = tempBonusItem.time;
        }
        if ((i & 2) != 0) {
            str = tempBonusItem.amount;
        }
        return tempBonusItem.copy(j, str);
    }

    public final long component1() {
        return this.time;
    }

    public final String component2() {
        return this.amount;
    }

    public final TempBonusItem copy(long j, String str) {
        C8271i.m35386b(str, "amount");
        return new TempBonusItem(j, str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TempBonusItem) {
                TempBonusItem tempBonusItem = (TempBonusItem) obj;
                if (!(this.time == tempBonusItem.time) || !C8271i.m35384a((Object) this.amount, (Object) tempBonusItem.amount)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.time;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.amount;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TempBonusItem(time=");
        sb.append(this.time);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(")");
        return sb.toString();
    }

    public TempBonusItem(long j, String str) {
        C8271i.m35386b(str, "amount");
        this.time = j;
        this.amount = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final long getTime() {
        return this.time;
    }
}
