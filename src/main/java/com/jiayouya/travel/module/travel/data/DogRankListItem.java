package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/DogRankListItem;", "", "num", "", "profit", "avatar", "nickname", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getNickname", "getNum", "getProfit", "getSource", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogRankListItem.kt */
public final class DogRankListItem {
    private final String avatar;
    private final String nickname;
    private final String num;
    private final String profit;
    private final String source;

    public static /* synthetic */ DogRankListItem copy$default(DogRankListItem dogRankListItem, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dogRankListItem.num;
        }
        if ((i & 2) != 0) {
            str2 = dogRankListItem.profit;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = dogRankListItem.avatar;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = dogRankListItem.nickname;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = dogRankListItem.source;
        }
        return dogRankListItem.copy(str, str6, str7, str8, str5);
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

    public final String component5() {
        return this.source;
    }

    public final DogRankListItem copy(String str, String str2, String str3, String str4, String str5) {
        C8271i.m35386b(str, "num");
        C8271i.m35386b(str2, "profit");
        C8271i.m35386b(str3, "avatar");
        C8271i.m35386b(str4, "nickname");
        C8271i.m35386b(str5, ArgKey.KEY_SOURCE);
        DogRankListItem dogRankListItem = new DogRankListItem(str, str2, str3, str4, str5);
        return dogRankListItem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.source, (java.lang.Object) r3.source) != false) goto L_0x003d;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x003d
        boolean r0 = r3 instanceof com.jiayouya.travel.module.travel.data.DogRankListItem
        if (r0 == 0) goto L_0x003b
        com.jiayouya.travel.module.travel.data.DogRankListItem r3 = (com.jiayouya.travel.module.travel.data.DogRankListItem) r3
        java.lang.String r0 = r2.num
        java.lang.String r1 = r3.num
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.lang.String r0 = r2.profit
        java.lang.String r1 = r3.profit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.lang.String r0 = r2.avatar
        java.lang.String r1 = r3.avatar
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.lang.String r0 = r2.nickname
        java.lang.String r1 = r3.nickname
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.lang.String r0 = r2.source
        java.lang.String r3 = r3.source
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x003b
        goto L_0x003d
    L_0x003b:
        r3 = 0
        return r3
    L_0x003d:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.DogRankListItem.equals(java.lang.Object):boolean");
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
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.source;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DogRankListItem(num=");
        sb.append(this.num);
        sb.append(", profit=");
        sb.append(this.profit);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(")");
        return sb.toString();
    }

    public DogRankListItem(String str, String str2, String str3, String str4, String str5) {
        C8271i.m35386b(str, "num");
        C8271i.m35386b(str2, "profit");
        C8271i.m35386b(str3, "avatar");
        C8271i.m35386b(str4, "nickname");
        C8271i.m35386b(str5, ArgKey.KEY_SOURCE);
        this.num = str;
        this.profit = str2;
        this.avatar = str3;
        this.nickname = str4;
        this.source = str5;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNum() {
        return this.num;
    }

    public final String getProfit() {
        return this.profit;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getSource() {
        return this.source;
    }
}
