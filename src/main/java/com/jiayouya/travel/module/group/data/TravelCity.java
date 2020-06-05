package com.jiayouya.travel.module.group.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/TravelCity;", "", "city", "", "Lcom/jiayouya/travel/module/group/data/City;", "nowCity", "Lcom/jiayouya/travel/module/group/data/NowCity;", "nextCity", "Lcom/jiayouya/travel/module/group/data/NextCity;", "rewardList", "Lcom/jiayouya/travel/module/group/data/RewardItem;", "(Ljava/util/List;Lcom/jiayouya/travel/module/group/data/NowCity;Lcom/jiayouya/travel/module/group/data/NextCity;Ljava/util/List;)V", "getCity", "()Ljava/util/List;", "getNextCity", "()Lcom/jiayouya/travel/module/group/data/NextCity;", "getNowCity", "()Lcom/jiayouya/travel/module/group/data/NowCity;", "getRewardList", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TravelCity.kt */
public final class TravelCity {
    private final List<City> city;
    private final NextCity nextCity;
    private final NowCity nowCity;
    private final List<RewardItem> rewardList;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.group.data.City>, for r1v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.group.data.RewardItem>, for r4v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.group.data.TravelCity copy$default(com.jiayouya.travel.module.group.data.TravelCity r0, java.util.List<com.jiayouya.travel.module.group.data.City> r1, com.jiayouya.travel.module.group.data.NowCity r2, com.jiayouya.travel.module.group.data.NextCity r3, java.util.List<com.jiayouya.travel.module.group.data.RewardItem> r4, int r5, java.lang.Object r6) {
        /*
        r6 = r5 & 1
        if (r6 == 0) goto L_0x0006
        java.util.List<com.jiayouya.travel.module.group.data.City> r1 = r0.city
    L_0x0006:
        r6 = r5 & 2
        if (r6 == 0) goto L_0x000c
        com.jiayouya.travel.module.group.data.NowCity r2 = r0.nowCity
    L_0x000c:
        r6 = r5 & 4
        if (r6 == 0) goto L_0x0012
        com.jiayouya.travel.module.group.data.NextCity r3 = r0.nextCity
    L_0x0012:
        r5 = r5 & 8
        if (r5 == 0) goto L_0x0018
        java.util.List<com.jiayouya.travel.module.group.data.RewardItem> r4 = r0.rewardList
    L_0x0018:
        com.jiayouya.travel.module.group.data.TravelCity r0 = r0.copy(r1, r2, r3, r4)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.group.data.TravelCity.copy$default(com.jiayouya.travel.module.group.data.TravelCity, java.util.List, com.jiayouya.travel.module.group.data.NowCity, com.jiayouya.travel.module.group.data.NextCity, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.group.data.TravelCity");
    }

    public final List<City> component1() {
        return this.city;
    }

    public final NowCity component2() {
        return this.nowCity;
    }

    public final NextCity component3() {
        return this.nextCity;
    }

    public final List<RewardItem> component4() {
        return this.rewardList;
    }

    public final TravelCity copy(List<City> list, NowCity nowCity2, NextCity nextCity2, List<RewardItem> list2) {
        C8271i.m35386b(list, "city");
        C8271i.m35386b(nowCity2, "nowCity");
        C8271i.m35386b(nextCity2, "nextCity");
        C8271i.m35386b(list2, "rewardList");
        return new TravelCity(list, nowCity2, nextCity2, list2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.rewardList, (java.lang.Object) r3.rewardList) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033
        boolean r0 = r3 instanceof com.jiayouya.travel.module.group.data.TravelCity
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.group.data.TravelCity r3 = (com.jiayouya.travel.module.group.data.TravelCity) r3
        java.util.List<com.jiayouya.travel.module.group.data.City> r0 = r2.city
        java.util.List<com.jiayouya.travel.module.group.data.City> r1 = r3.city
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.group.data.NowCity r0 = r2.nowCity
        com.jiayouya.travel.module.group.data.NowCity r1 = r3.nowCity
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.group.data.NextCity r0 = r2.nextCity
        com.jiayouya.travel.module.group.data.NextCity r1 = r3.nextCity
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.util.List<com.jiayouya.travel.module.group.data.RewardItem> r0 = r2.rewardList
        java.util.List<com.jiayouya.travel.module.group.data.RewardItem> r3 = r3.rewardList
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0031
        goto L_0x0033
    L_0x0031:
        r3 = 0
        return r3
    L_0x0033:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.group.data.TravelCity.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<City> list = this.city;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        NowCity nowCity2 = this.nowCity;
        int hashCode2 = (hashCode + (nowCity2 != null ? nowCity2.hashCode() : 0)) * 31;
        NextCity nextCity2 = this.nextCity;
        int hashCode3 = (hashCode2 + (nextCity2 != null ? nextCity2.hashCode() : 0)) * 31;
        List<RewardItem> list2 = this.rewardList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TravelCity(city=");
        sb.append(this.city);
        sb.append(", nowCity=");
        sb.append(this.nowCity);
        sb.append(", nextCity=");
        sb.append(this.nextCity);
        sb.append(", rewardList=");
        sb.append(this.rewardList);
        sb.append(")");
        return sb.toString();
    }

    public TravelCity(List<City> list, NowCity nowCity2, NextCity nextCity2, List<RewardItem> list2) {
        C8271i.m35386b(list, "city");
        C8271i.m35386b(nowCity2, "nowCity");
        C8271i.m35386b(nextCity2, "nextCity");
        C8271i.m35386b(list2, "rewardList");
        this.city = list;
        this.nowCity = nowCity2;
        this.nextCity = nextCity2;
        this.rewardList = list2;
    }

    public final List<City> getCity() {
        return this.city;
    }

    public final NowCity getNowCity() {
        return this.nowCity;
    }

    public final NextCity getNextCity() {
        return this.nextCity;
    }

    public final List<RewardItem> getRewardList() {
        return this.rewardList;
    }
}
