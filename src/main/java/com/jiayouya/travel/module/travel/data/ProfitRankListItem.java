package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/ProfitRankListItem;", "", "position", "", "profit", "", "avatar", "nickname", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getNickname", "getPosition", "()I", "getProfit", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ProfitRankListItem.kt */
public final class ProfitRankListItem {
    private final String avatar;
    private final String nickname;
    private final int position;
    private final String profit;

    public static /* synthetic */ ProfitRankListItem copy$default(ProfitRankListItem profitRankListItem, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = profitRankListItem.position;
        }
        if ((i2 & 2) != 0) {
            str = profitRankListItem.profit;
        }
        if ((i2 & 4) != 0) {
            str2 = profitRankListItem.avatar;
        }
        if ((i2 & 8) != 0) {
            str3 = profitRankListItem.nickname;
        }
        return profitRankListItem.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.position;
    }

    public final String component2() {
        return this.profit;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.nickname;
    }

    public final ProfitRankListItem copy(int i, String str, String str2, String str3) {
        C8271i.m35386b(str, "profit");
        C8271i.m35386b(str2, "avatar");
        C8271i.m35386b(str3, "nickname");
        return new ProfitRankListItem(i, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ProfitRankListItem) {
                ProfitRankListItem profitRankListItem = (ProfitRankListItem) obj;
                if (!(this.position == profitRankListItem.position) || !C8271i.m35384a((Object) this.profit, (Object) profitRankListItem.profit) || !C8271i.m35384a((Object) this.avatar, (Object) profitRankListItem.avatar) || !C8271i.m35384a((Object) this.nickname, (Object) profitRankListItem.nickname)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.position * 31;
        String str = this.profit;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.avatar;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nickname;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProfitRankListItem(position=");
        sb.append(this.position);
        sb.append(", profit=");
        sb.append(this.profit);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(")");
        return sb.toString();
    }

    public ProfitRankListItem(int i, String str, String str2, String str3) {
        C8271i.m35386b(str, "profit");
        C8271i.m35386b(str2, "avatar");
        C8271i.m35386b(str3, "nickname");
        this.position = i;
        this.profit = str;
        this.avatar = str2;
        this.nickname = str3;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getProfit() {
        return this.profit;
    }
}
