package com.jiayouya.travel.module.p276me.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/BonusDetailRsp;", "", "num", "", "h5Url", "price", "history", "yesterday", "scorePercent", "", "superDogIntro", "news", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;)V", "getH5Url", "()Ljava/lang/String;", "getHistory", "getNews", "getNum", "getPrice", "getScorePercent", "()F", "getSuperDogIntro", "getYesterday", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BonusDetailRsp.kt */
/* renamed from: com.jiayouya.travel.module.me.data.BonusDetailRsp */
public final class BonusDetailRsp {
    private final String h5Url;
    private final String history;
    private final String news;
    private final String num;
    private final String price;
    private final float scorePercent;
    private final String superDogIntro;
    private final String yesterday;

    public static /* synthetic */ BonusDetailRsp copy$default(BonusDetailRsp bonusDetailRsp, String str, String str2, String str3, String str4, String str5, float f, String str6, String str7, int i, Object obj) {
        BonusDetailRsp bonusDetailRsp2 = bonusDetailRsp;
        int i2 = i;
        return bonusDetailRsp.copy((i2 & 1) != 0 ? bonusDetailRsp2.num : str, (i2 & 2) != 0 ? bonusDetailRsp2.h5Url : str2, (i2 & 4) != 0 ? bonusDetailRsp2.price : str3, (i2 & 8) != 0 ? bonusDetailRsp2.history : str4, (i2 & 16) != 0 ? bonusDetailRsp2.yesterday : str5, (i2 & 32) != 0 ? bonusDetailRsp2.scorePercent : f, (i2 & 64) != 0 ? bonusDetailRsp2.superDogIntro : str6, (i2 & 128) != 0 ? bonusDetailRsp2.news : str7);
    }

    public final String component1() {
        return this.num;
    }

    public final String component2() {
        return this.h5Url;
    }

    public final String component3() {
        return this.price;
    }

    public final String component4() {
        return this.history;
    }

    public final String component5() {
        return this.yesterday;
    }

    public final float component6() {
        return this.scorePercent;
    }

    public final String component7() {
        return this.superDogIntro;
    }

    public final String component8() {
        return this.news;
    }

    public final BonusDetailRsp copy(String str, String str2, String str3, String str4, String str5, float f, String str6, String str7) {
        String str8 = str;
        C8271i.m35386b(str, "num");
        String str9 = str2;
        C8271i.m35386b(str2, "h5Url");
        String str10 = str3;
        C8271i.m35386b(str3, "price");
        String str11 = str4;
        C8271i.m35386b(str4, "history");
        String str12 = str5;
        C8271i.m35386b(str5, "yesterday");
        String str13 = str6;
        C8271i.m35386b(str13, "superDogIntro");
        String str14 = str7;
        C8271i.m35386b(str14, "news");
        BonusDetailRsp bonusDetailRsp = new BonusDetailRsp(str8, str9, str10, str11, str12, f, str13, str14);
        return bonusDetailRsp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.news, (java.lang.Object) r3.news) != false) goto L_0x005b;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x005b
        boolean r0 = r3 instanceof com.jiayouya.travel.module.p276me.data.BonusDetailRsp
        if (r0 == 0) goto L_0x0059
        com.jiayouya.travel.module.me.data.BonusDetailRsp r3 = (com.jiayouya.travel.module.p276me.data.BonusDetailRsp) r3
        java.lang.String r0 = r2.num
        java.lang.String r1 = r3.num
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0059
        java.lang.String r0 = r2.h5Url
        java.lang.String r1 = r3.h5Url
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0059
        java.lang.String r0 = r2.price
        java.lang.String r1 = r3.price
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0059
        java.lang.String r0 = r2.history
        java.lang.String r1 = r3.history
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0059
        java.lang.String r0 = r2.yesterday
        java.lang.String r1 = r3.yesterday
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0059
        float r0 = r2.scorePercent
        float r1 = r3.scorePercent
        int r0 = java.lang.Float.compare(r0, r1)
        if (r0 != 0) goto L_0x0059
        java.lang.String r0 = r2.superDogIntro
        java.lang.String r1 = r3.superDogIntro
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0059
        java.lang.String r0 = r2.news
        java.lang.String r3 = r3.news
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0059
        goto L_0x005b
    L_0x0059:
        r3 = 0
        return r3
    L_0x005b:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p276me.data.BonusDetailRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.num;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.h5Url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.price;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.history;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.yesterday;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + Float.floatToIntBits(this.scorePercent)) * 31;
        String str6 = this.superDogIntro;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.news;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BonusDetailRsp(num=");
        sb.append(this.num);
        sb.append(", h5Url=");
        sb.append(this.h5Url);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", history=");
        sb.append(this.history);
        sb.append(", yesterday=");
        sb.append(this.yesterday);
        sb.append(", scorePercent=");
        sb.append(this.scorePercent);
        sb.append(", superDogIntro=");
        sb.append(this.superDogIntro);
        sb.append(", news=");
        sb.append(this.news);
        sb.append(")");
        return sb.toString();
    }

    public BonusDetailRsp(String str, String str2, String str3, String str4, String str5, float f, String str6, String str7) {
        C8271i.m35386b(str, "num");
        C8271i.m35386b(str2, "h5Url");
        C8271i.m35386b(str3, "price");
        C8271i.m35386b(str4, "history");
        C8271i.m35386b(str5, "yesterday");
        C8271i.m35386b(str6, "superDogIntro");
        C8271i.m35386b(str7, "news");
        this.num = str;
        this.h5Url = str2;
        this.price = str3;
        this.history = str4;
        this.yesterday = str5;
        this.scorePercent = f;
        this.superDogIntro = str6;
        this.news = str7;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final String getHistory() {
        return this.history;
    }

    public final String getNum() {
        return this.num;
    }

    public final String getPrice() {
        return this.price;
    }

    public final float getScorePercent() {
        return this.scorePercent;
    }

    public final String getSuperDogIntro() {
        return this.superDogIntro;
    }

    public final String getYesterday() {
        return this.yesterday;
    }

    public final String getNews() {
        return this.news;
    }
}
