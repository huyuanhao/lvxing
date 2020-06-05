package com.jiayouya.travel.module.group.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B­\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÕ\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001c¨\u0006K"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/GroupIndexRsp;", "", "members", "", "avatars", "", "percent", "", "nowProfit", "profitRate", "targetProfit", "targetText", "invalidNum", "lockProfit", "fansProfit", "travelProfit", "childrenProfit", "targetRewards", "Lcom/jiayouya/travel/module/group/data/TargetRewards;", "h5Url", "parent", "Lcom/jiayouya/travel/module/group/data/Parent;", "star", "activeNum", "channel", "Lcom/jiayouya/travel/module/group/data/Channel;", "(Ljava/lang/String;Ljava/util/List;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/jiayouya/travel/module/group/data/Parent;Lcom/jiayouya/travel/module/group/data/Parent;Ljava/lang/String;Lcom/jiayouya/travel/module/group/data/Channel;)V", "getActiveNum", "()Ljava/lang/String;", "getAvatars", "()Ljava/util/List;", "getChannel", "()Lcom/jiayouya/travel/module/group/data/Channel;", "getChildrenProfit", "getFansProfit", "getH5Url", "getInvalidNum", "getLockProfit", "getMembers", "getNowProfit", "getParent", "()Lcom/jiayouya/travel/module/group/data/Parent;", "getPercent", "()F", "getProfitRate", "getStar", "getTargetProfit", "getTargetRewards", "getTargetText", "getTravelProfit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GroupIndexRsp.kt */
public final class GroupIndexRsp {
    private final String activeNum;
    private final List<String> avatars;
    private final Channel channel;
    private final String childrenProfit;
    private final String fansProfit;
    private final String h5Url;
    private final String invalidNum;
    private final String lockProfit;
    private final String members;
    private final String nowProfit;
    private final Parent parent;
    private final float percent;
    private final String profitRate;
    private final Parent star;
    private final String targetProfit;
    private final List<TargetRewards> targetRewards;
    private final String targetText;
    private final String travelProfit;

    public static /* synthetic */ GroupIndexRsp copy$default(GroupIndexRsp groupIndexRsp, String str, List list, float f, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list2, String str11, Parent parent2, Parent parent3, String str12, Channel channel2, int i, Object obj) {
        GroupIndexRsp groupIndexRsp2 = groupIndexRsp;
        int i2 = i;
        return groupIndexRsp.copy((i2 & 1) != 0 ? groupIndexRsp2.members : str, (i2 & 2) != 0 ? groupIndexRsp2.avatars : list, (i2 & 4) != 0 ? groupIndexRsp2.percent : f, (i2 & 8) != 0 ? groupIndexRsp2.nowProfit : str2, (i2 & 16) != 0 ? groupIndexRsp2.profitRate : str3, (i2 & 32) != 0 ? groupIndexRsp2.targetProfit : str4, (i2 & 64) != 0 ? groupIndexRsp2.targetText : str5, (i2 & 128) != 0 ? groupIndexRsp2.invalidNum : str6, (i2 & 256) != 0 ? groupIndexRsp2.lockProfit : str7, (i2 & 512) != 0 ? groupIndexRsp2.fansProfit : str8, (i2 & 1024) != 0 ? groupIndexRsp2.travelProfit : str9, (i2 & 2048) != 0 ? groupIndexRsp2.childrenProfit : str10, (i2 & 4096) != 0 ? groupIndexRsp2.targetRewards : list2, (i2 & 8192) != 0 ? groupIndexRsp2.h5Url : str11, (i2 & 16384) != 0 ? groupIndexRsp2.parent : parent2, (i2 & 32768) != 0 ? groupIndexRsp2.star : parent3, (i2 & 65536) != 0 ? groupIndexRsp2.activeNum : str12, (i2 & 131072) != 0 ? groupIndexRsp2.channel : channel2);
    }

    public final String component1() {
        return this.members;
    }

    public final String component10() {
        return this.fansProfit;
    }

    public final String component11() {
        return this.travelProfit;
    }

    public final String component12() {
        return this.childrenProfit;
    }

    public final List<TargetRewards> component13() {
        return this.targetRewards;
    }

    public final String component14() {
        return this.h5Url;
    }

    public final Parent component15() {
        return this.parent;
    }

    public final Parent component16() {
        return this.star;
    }

    public final String component17() {
        return this.activeNum;
    }

    public final Channel component18() {
        return this.channel;
    }

    public final List<String> component2() {
        return this.avatars;
    }

    public final float component3() {
        return this.percent;
    }

    public final String component4() {
        return this.nowProfit;
    }

    public final String component5() {
        return this.profitRate;
    }

    public final String component6() {
        return this.targetProfit;
    }

    public final String component7() {
        return this.targetText;
    }

    public final String component8() {
        return this.invalidNum;
    }

    public final String component9() {
        return this.lockProfit;
    }

    public final GroupIndexRsp copy(String str, List<String> list, float f, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<TargetRewards> list2, String str11, Parent parent2, Parent parent3, String str12, Channel channel2) {
        String str13 = str;
        List<String> list3 = list;
        float f2 = f;
        String str14 = str2;
        String str15 = str3;
        String str16 = str4;
        String str17 = str5;
        String str18 = str6;
        String str19 = str7;
        String str20 = str8;
        String str21 = str9;
        String str22 = str10;
        List<TargetRewards> list4 = list2;
        String str23 = str11;
        Parent parent4 = parent2;
        Parent parent5 = parent3;
        String str24 = str12;
        Channel channel3 = channel2;
        String str25 = str13;
        C8271i.m35386b(str13, "members");
        C8271i.m35386b(list, "avatars");
        C8271i.m35386b(str2, "nowProfit");
        C8271i.m35386b(str3, "profitRate");
        C8271i.m35386b(str4, "targetProfit");
        C8271i.m35386b(str5, "targetText");
        C8271i.m35386b(str8, "fansProfit");
        C8271i.m35386b(str9, "travelProfit");
        C8271i.m35386b(str10, "childrenProfit");
        C8271i.m35386b(str11, "h5Url");
        C8271i.m35386b(str12, "activeNum");
        GroupIndexRsp groupIndexRsp = new GroupIndexRsp(str25, list3, f2, str14, str15, str16, str17, str18, str19, str20, str21, str22, list4, str23, parent4, parent5, str24, channel3);
        return groupIndexRsp;
    }

    /* JADX INFO: used method not loaded: kotlin.jvm.internal.i.a(java.lang.Object, java.lang.Object):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ba, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.channel, (java.lang.Object) r3.channel) != false) goto L_0x00bf;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x00bf
        boolean r0 = r3 instanceof com.jiayouya.travel.module.group.data.GroupIndexRsp
        if (r0 == 0) goto L_0x00bd
        com.jiayouya.travel.module.group.data.GroupIndexRsp r3 = (com.jiayouya.travel.module.group.data.GroupIndexRsp) r3
        java.lang.String r0 = r2.members
        java.lang.String r1 = r3.members
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.util.List<java.lang.String> r0 = r2.avatars
        java.util.List<java.lang.String> r1 = r3.avatars
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        float r0 = r2.percent
        float r1 = r3.percent
        int r0 = java.lang.Float.compare(r0, r1)
        if (r0 != 0) goto L_0x00bd
        java.lang.String r0 = r2.nowProfit
        java.lang.String r1 = r3.nowProfit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.profitRate
        java.lang.String r1 = r3.profitRate
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.targetProfit
        java.lang.String r1 = r3.targetProfit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.targetText
        java.lang.String r1 = r3.targetText
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.invalidNum
        java.lang.String r1 = r3.invalidNum
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.lockProfit
        java.lang.String r1 = r3.lockProfit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.fansProfit
        java.lang.String r1 = r3.fansProfit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.travelProfit
        java.lang.String r1 = r3.travelProfit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.childrenProfit
        java.lang.String r1 = r3.childrenProfit
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.util.List<com.jiayouya.travel.module.group.data.TargetRewards> r0 = r2.targetRewards
        java.util.List<com.jiayouya.travel.module.group.data.TargetRewards> r1 = r3.targetRewards
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.h5Url
        java.lang.String r1 = r3.h5Url
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        com.jiayouya.travel.module.group.data.Parent r0 = r2.parent
        com.jiayouya.travel.module.group.data.Parent r1 = r3.parent
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        com.jiayouya.travel.module.group.data.Parent r0 = r2.star
        com.jiayouya.travel.module.group.data.Parent r1 = r3.star
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        java.lang.String r0 = r2.activeNum
        java.lang.String r1 = r3.activeNum
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x00bd
        com.jiayouya.travel.module.group.data.Channel r0 = r2.channel
        com.jiayouya.travel.module.group.data.Channel r3 = r3.channel
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x00bd
        goto L_0x00bf
    L_0x00bd:
        r3 = 0
        return r3
    L_0x00bf:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.group.data.GroupIndexRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.members;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.avatars;
        int hashCode2 = (((hashCode + (list != null ? list.hashCode() : 0)) * 31) + Float.floatToIntBits(this.percent)) * 31;
        String str2 = this.nowProfit;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.profitRate;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.targetProfit;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.targetText;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.invalidNum;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.lockProfit;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.fansProfit;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.travelProfit;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.childrenProfit;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        List<TargetRewards> list2 = this.targetRewards;
        int hashCode12 = (hashCode11 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str11 = this.h5Url;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Parent parent2 = this.parent;
        int hashCode14 = (hashCode13 + (parent2 != null ? parent2.hashCode() : 0)) * 31;
        Parent parent3 = this.star;
        int hashCode15 = (hashCode14 + (parent3 != null ? parent3.hashCode() : 0)) * 31;
        String str12 = this.activeNum;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 31;
        Channel channel2 = this.channel;
        if (channel2 != null) {
            i = channel2.hashCode();
        }
        return hashCode16 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupIndexRsp(members=");
        sb.append(this.members);
        sb.append(", avatars=");
        sb.append(this.avatars);
        sb.append(", percent=");
        sb.append(this.percent);
        sb.append(", nowProfit=");
        sb.append(this.nowProfit);
        sb.append(", profitRate=");
        sb.append(this.profitRate);
        sb.append(", targetProfit=");
        sb.append(this.targetProfit);
        sb.append(", targetText=");
        sb.append(this.targetText);
        sb.append(", invalidNum=");
        sb.append(this.invalidNum);
        sb.append(", lockProfit=");
        sb.append(this.lockProfit);
        sb.append(", fansProfit=");
        sb.append(this.fansProfit);
        sb.append(", travelProfit=");
        sb.append(this.travelProfit);
        sb.append(", childrenProfit=");
        sb.append(this.childrenProfit);
        sb.append(", targetRewards=");
        sb.append(this.targetRewards);
        sb.append(", h5Url=");
        sb.append(this.h5Url);
        sb.append(", parent=");
        sb.append(this.parent);
        sb.append(", star=");
        sb.append(this.star);
        sb.append(", activeNum=");
        sb.append(this.activeNum);
        sb.append(", channel=");
        sb.append(this.channel);
        sb.append(")");
        return sb.toString();
    }

    public GroupIndexRsp(String str, List<String> list, float f, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<TargetRewards> list2, String str11, Parent parent2, Parent parent3, String str12, Channel channel2) {
        String str13 = str;
        List<String> list3 = list;
        String str14 = str2;
        String str15 = str3;
        String str16 = str4;
        String str17 = str5;
        String str18 = str8;
        String str19 = str9;
        String str20 = str10;
        String str21 = str11;
        String str22 = str12;
        C8271i.m35386b(str, "members");
        C8271i.m35386b(list, "avatars");
        C8271i.m35386b(str14, "nowProfit");
        C8271i.m35386b(str15, "profitRate");
        C8271i.m35386b(str16, "targetProfit");
        C8271i.m35386b(str17, "targetText");
        C8271i.m35386b(str18, "fansProfit");
        C8271i.m35386b(str19, "travelProfit");
        C8271i.m35386b(str20, "childrenProfit");
        C8271i.m35386b(str21, "h5Url");
        C8271i.m35386b(str22, "activeNum");
        this.members = str13;
        this.avatars = list3;
        this.percent = f;
        this.nowProfit = str14;
        this.profitRate = str15;
        this.targetProfit = str16;
        this.targetText = str17;
        this.invalidNum = str6;
        this.lockProfit = str7;
        this.fansProfit = str18;
        this.travelProfit = str19;
        this.childrenProfit = str20;
        this.targetRewards = list2;
        this.h5Url = str21;
        this.parent = parent2;
        this.star = parent3;
        this.activeNum = str22;
        this.channel = channel2;
    }

    public final List<String> getAvatars() {
        return this.avatars;
    }

    public final String getMembers() {
        return this.members;
    }

    public final float getPercent() {
        return this.percent;
    }

    public final String getNowProfit() {
        return this.nowProfit;
    }

    public final String getProfitRate() {
        return this.profitRate;
    }

    public final String getTargetProfit() {
        return this.targetProfit;
    }

    public final String getInvalidNum() {
        return this.invalidNum;
    }

    public final String getLockProfit() {
        return this.lockProfit;
    }

    public final String getTargetText() {
        return this.targetText;
    }

    public final String getChildrenProfit() {
        return this.childrenProfit;
    }

    public final String getFansProfit() {
        return this.fansProfit;
    }

    public final String getTravelProfit() {
        return this.travelProfit;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final Parent getParent() {
        return this.parent;
    }

    public final List<TargetRewards> getTargetRewards() {
        return this.targetRewards;
    }

    public final Parent getStar() {
        return this.star;
    }

    public final String getActiveNum() {
        return this.activeNum;
    }

    public final Channel getChannel() {
        return this.channel;
    }
}
