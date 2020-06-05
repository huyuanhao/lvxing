package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/TodayPorfitLogsItem;", "", "num", "", "profit", "avatar", "nickname", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getNickname", "getNum", "getProfit", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TodayPorfitLogsItem.kt */
public final class TodayPorfitLogsItem {
    private final String avatar;
    private final String nickname;
    private final String num;
    private final String profit;

    public static /* synthetic */ TodayPorfitLogsItem copy$default(TodayPorfitLogsItem todayPorfitLogsItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = todayPorfitLogsItem.num;
        }
        if ((i & 2) != 0) {
            str2 = todayPorfitLogsItem.profit;
        }
        if ((i & 4) != 0) {
            str3 = todayPorfitLogsItem.avatar;
        }
        if ((i & 8) != 0) {
            str4 = todayPorfitLogsItem.nickname;
        }
        return todayPorfitLogsItem.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.num;
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

    public final TodayPorfitLogsItem copy(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, "num");
        C8271i.m35386b(str2, "profit");
        C8271i.m35386b(str3, "avatar");
        C8271i.m35386b(str4, "nickname");
        return new TodayPorfitLogsItem(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.nickname, (java.lang.Object) r3.nickname) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033
        boolean r0 = r3 instanceof com.jiayouya.travel.module.travel.data.TodayPorfitLogsItem
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.travel.data.TodayPorfitLogsItem r3 = (com.jiayouya.travel.module.travel.data.TodayPorfitLogsItem) r3
        java.lang.String r0 = r2.num
        java.lang.String r1 = r3.num
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.profit
        java.lang.String r1 = r3.profit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.avatar
        java.lang.String r1 = r3.avatar
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.nickname
        java.lang.String r3 = r3.nickname
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.TodayPorfitLogsItem.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.num;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.profit;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.avatar;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nickname;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TodayPorfitLogsItem(num=");
        sb.append(this.num);
        sb.append(", profit=");
        sb.append(this.profit);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(")");
        return sb.toString();
    }

    public TodayPorfitLogsItem(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, "num");
        C8271i.m35386b(str2, "profit");
        C8271i.m35386b(str3, "avatar");
        C8271i.m35386b(str4, "nickname");
        this.num = str;
        this.profit = str2;
        this.avatar = str3;
        this.nickname = str4;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getNum() {
        return this.num;
    }

    public final String getProfit() {
        return this.profit;
    }
}
