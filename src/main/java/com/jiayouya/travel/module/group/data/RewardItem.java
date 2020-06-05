package com.jiayouya.travel.module.group.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/RewardItem;", "", "id", "", "status", "", "percent", "isNowCity", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getPercent", "setPercent", "(Ljava/lang/String;)V", "getStatus", "()I", "setStatus", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RewardItem.kt */
public final class RewardItem {
    /* renamed from: id */
    private final String f11485id;
    private final boolean isNowCity;
    private String percent;
    private int status;

    public static /* synthetic */ RewardItem copy$default(RewardItem rewardItem, String str, int i, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rewardItem.f11485id;
        }
        if ((i2 & 2) != 0) {
            i = rewardItem.status;
        }
        if ((i2 & 4) != 0) {
            str2 = rewardItem.percent;
        }
        if ((i2 & 8) != 0) {
            z = rewardItem.isNowCity;
        }
        return rewardItem.copy(str, i, str2, z);
    }

    public final String component1() {
        return this.f11485id;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.percent;
    }

    public final boolean component4() {
        return this.isNowCity;
    }

    public final RewardItem copy(String str, int i, String str2, boolean z) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "percent");
        return new RewardItem(str, i, str2, z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RewardItem) {
                RewardItem rewardItem = (RewardItem) obj;
                if (C8271i.m35384a((Object) this.f11485id, (Object) rewardItem.f11485id)) {
                    if ((this.status == rewardItem.status) && C8271i.m35384a((Object) this.percent, (Object) rewardItem.percent)) {
                        if (this.isNowCity == rewardItem.isNowCity) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f11485id;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.status) * 31;
        String str2 = this.percent;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.isNowCity;
        if (z) {
            z = true;
        }
        return i2 + z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RewardItem(id=");
        sb.append(this.f11485id);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", percent=");
        sb.append(this.percent);
        sb.append(", isNowCity=");
        sb.append(this.isNowCity);
        sb.append(")");
        return sb.toString();
    }

    public RewardItem(String str, int i, String str2, boolean z) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "percent");
        this.f11485id = str;
        this.status = i;
        this.percent = str2;
        this.isNowCity = z;
    }

    public final String getId() {
        return this.f11485id;
    }

    public final String getPercent() {
        return this.percent;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean isNowCity() {
        return this.isNowCity;
    }

    public final void setPercent(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.percent = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }
}
