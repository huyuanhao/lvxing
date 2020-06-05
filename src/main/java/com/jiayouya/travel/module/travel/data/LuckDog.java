package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/LuckDog;", "", "id", "", "level", "amount", "", "timeText", "(IILjava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getId", "()I", "getLevel", "getTimeText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: IndexPop.kt */
public final class LuckDog {
    private final String amount;
    /* renamed from: id */
    private final int f11906id;
    private final int level;
    private final String timeText;

    public static /* synthetic */ LuckDog copy$default(LuckDog luckDog, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = luckDog.f11906id;
        }
        if ((i3 & 2) != 0) {
            i2 = luckDog.level;
        }
        if ((i3 & 4) != 0) {
            str = luckDog.amount;
        }
        if ((i3 & 8) != 0) {
            str2 = luckDog.timeText;
        }
        return luckDog.copy(i, i2, str, str2);
    }

    public final int component1() {
        return this.f11906id;
    }

    public final int component2() {
        return this.level;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.timeText;
    }

    public final LuckDog copy(int i, int i2, String str, String str2) {
        C8271i.m35386b(str, "amount");
        C8271i.m35386b(str2, "timeText");
        return new LuckDog(i, i2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LuckDog) {
                LuckDog luckDog = (LuckDog) obj;
                if (this.f11906id == luckDog.f11906id) {
                    if (!(this.level == luckDog.level) || !C8271i.m35384a((Object) this.amount, (Object) luckDog.amount) || !C8271i.m35384a((Object) this.timeText, (Object) luckDog.timeText)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.f11906id * 31) + this.level) * 31;
        String str = this.amount;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.timeText;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LuckDog(id=");
        sb.append(this.f11906id);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", timeText=");
        sb.append(this.timeText);
        sb.append(")");
        return sb.toString();
    }

    public LuckDog(int i, int i2, String str, String str2) {
        C8271i.m35386b(str, "amount");
        C8271i.m35386b(str2, "timeText");
        this.f11906id = i;
        this.level = i2;
        this.amount = str;
        this.timeText = str2;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final int getId() {
        return this.f11906id;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getTimeText() {
        return this.timeText;
    }
}
