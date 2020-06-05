package com.jiayouya.travel.module.explore.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/data/TeamItem;", "", "num", "", "dogId", "(II)V", "getDogId", "()I", "getNum", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExploreIndex.kt */
public final class TeamItem {
    private final int dogId;
    private final int num;

    public static /* synthetic */ TeamItem copy$default(TeamItem teamItem, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = teamItem.num;
        }
        if ((i3 & 2) != 0) {
            i2 = teamItem.dogId;
        }
        return teamItem.copy(i, i2);
    }

    public final int component1() {
        return this.num;
    }

    public final int component2() {
        return this.dogId;
    }

    public final TeamItem copy(int i, int i2) {
        return new TeamItem(i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TeamItem) {
                TeamItem teamItem = (TeamItem) obj;
                if (this.num == teamItem.num) {
                    if (this.dogId == teamItem.dogId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.num * 31) + this.dogId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TeamItem(num=");
        sb.append(this.num);
        sb.append(", dogId=");
        sb.append(this.dogId);
        sb.append(")");
        return sb.toString();
    }

    public TeamItem(int i, int i2) {
        this.num = i;
        this.dogId = i2;
    }

    public final int getDogId() {
        return this.dogId;
    }

    public final int getNum() {
        return this.num;
    }
}
