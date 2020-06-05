package com.jiayouya.travel.module.group.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/Parent;", "", "avatar", "", "inviteNum", "todayProfit", "historyProfit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getHistoryProfit", "getInviteNum", "getTodayProfit", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GroupIndexRsp.kt */
public final class Parent {
    private final String avatar;
    private final String historyProfit;
    private final String inviteNum;
    private final String todayProfit;

    public static /* synthetic */ Parent copy$default(Parent parent, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parent.avatar;
        }
        if ((i & 2) != 0) {
            str2 = parent.inviteNum;
        }
        if ((i & 4) != 0) {
            str3 = parent.todayProfit;
        }
        if ((i & 8) != 0) {
            str4 = parent.historyProfit;
        }
        return parent.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.inviteNum;
    }

    public final String component3() {
        return this.todayProfit;
    }

    public final String component4() {
        return this.historyProfit;
    }

    public final Parent copy(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, "avatar");
        C8271i.m35386b(str2, "inviteNum");
        C8271i.m35386b(str3, "todayProfit");
        C8271i.m35386b(str4, "historyProfit");
        return new Parent(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.historyProfit, (java.lang.Object) r3.historyProfit) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033
        boolean r0 = r3 instanceof com.jiayouya.travel.module.group.data.Parent
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.group.data.Parent r3 = (com.jiayouya.travel.module.group.data.Parent) r3
        java.lang.String r0 = r2.avatar
        java.lang.String r1 = r3.avatar
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.inviteNum
        java.lang.String r1 = r3.inviteNum
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.todayProfit
        java.lang.String r1 = r3.todayProfit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.historyProfit
        java.lang.String r3 = r3.historyProfit
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.group.data.Parent.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.avatar;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.inviteNum;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.todayProfit;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.historyProfit;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parent(avatar=");
        sb.append(this.avatar);
        sb.append(", inviteNum=");
        sb.append(this.inviteNum);
        sb.append(", todayProfit=");
        sb.append(this.todayProfit);
        sb.append(", historyProfit=");
        sb.append(this.historyProfit);
        sb.append(")");
        return sb.toString();
    }

    public Parent(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, "avatar");
        C8271i.m35386b(str2, "inviteNum");
        C8271i.m35386b(str3, "todayProfit");
        C8271i.m35386b(str4, "historyProfit");
        this.avatar = str;
        this.inviteNum = str2;
        this.todayProfit = str3;
        this.historyProfit = str4;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getInviteNum() {
        return this.inviteNum;
    }

    public final String getTodayProfit() {
        return this.todayProfit;
    }

    public final String getHistoryProfit() {
        return this.historyProfit;
    }
}
