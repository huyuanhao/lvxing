package com.jiayouya.travel.module.p276me.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/DogAnalysisRsp;", "", "level", "", "merge", "Lcom/jiayouya/travel/module/me/data/AnalysisItem;", "adVideo", "invite", "city", "adFee", "percent", "", "(Ljava/lang/String;Lcom/jiayouya/travel/module/me/data/AnalysisItem;Lcom/jiayouya/travel/module/me/data/AnalysisItem;Lcom/jiayouya/travel/module/me/data/AnalysisItem;Lcom/jiayouya/travel/module/me/data/AnalysisItem;Lcom/jiayouya/travel/module/me/data/AnalysisItem;F)V", "getAdFee", "()Lcom/jiayouya/travel/module/me/data/AnalysisItem;", "getAdVideo", "getCity", "getInvite", "getLevel", "()Ljava/lang/String;", "getMerge", "getPercent", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogAnalysisRsp.kt */
/* renamed from: com.jiayouya.travel.module.me.data.DogAnalysisRsp */
public final class DogAnalysisRsp {
    private final AnalysisItem adFee;
    private final AnalysisItem adVideo;
    private final AnalysisItem city;
    private final AnalysisItem invite;
    private final String level;
    private final AnalysisItem merge;
    private final float percent;

    public static /* synthetic */ DogAnalysisRsp copy$default(DogAnalysisRsp dogAnalysisRsp, String str, AnalysisItem analysisItem, AnalysisItem analysisItem2, AnalysisItem analysisItem3, AnalysisItem analysisItem4, AnalysisItem analysisItem5, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dogAnalysisRsp.level;
        }
        if ((i & 2) != 0) {
            analysisItem = dogAnalysisRsp.merge;
        }
        AnalysisItem analysisItem6 = analysisItem;
        if ((i & 4) != 0) {
            analysisItem2 = dogAnalysisRsp.adVideo;
        }
        AnalysisItem analysisItem7 = analysisItem2;
        if ((i & 8) != 0) {
            analysisItem3 = dogAnalysisRsp.invite;
        }
        AnalysisItem analysisItem8 = analysisItem3;
        if ((i & 16) != 0) {
            analysisItem4 = dogAnalysisRsp.city;
        }
        AnalysisItem analysisItem9 = analysisItem4;
        if ((i & 32) != 0) {
            analysisItem5 = dogAnalysisRsp.adFee;
        }
        AnalysisItem analysisItem10 = analysisItem5;
        if ((i & 64) != 0) {
            f = dogAnalysisRsp.percent;
        }
        return dogAnalysisRsp.copy(str, analysisItem6, analysisItem7, analysisItem8, analysisItem9, analysisItem10, f);
    }

    public final String component1() {
        return this.level;
    }

    public final AnalysisItem component2() {
        return this.merge;
    }

    public final AnalysisItem component3() {
        return this.adVideo;
    }

    public final AnalysisItem component4() {
        return this.invite;
    }

    public final AnalysisItem component5() {
        return this.city;
    }

    public final AnalysisItem component6() {
        return this.adFee;
    }

    public final float component7() {
        return this.percent;
    }

    public final DogAnalysisRsp copy(String str, AnalysisItem analysisItem, AnalysisItem analysisItem2, AnalysisItem analysisItem3, AnalysisItem analysisItem4, AnalysisItem analysisItem5, float f) {
        String str2 = str;
        C8271i.m35386b(str, "level");
        AnalysisItem analysisItem6 = analysisItem;
        C8271i.m35386b(analysisItem, "merge");
        AnalysisItem analysisItem7 = analysisItem2;
        C8271i.m35386b(analysisItem2, "adVideo");
        AnalysisItem analysisItem8 = analysisItem3;
        C8271i.m35386b(analysisItem3, "invite");
        AnalysisItem analysisItem9 = analysisItem4;
        C8271i.m35386b(analysisItem4, "city");
        AnalysisItem analysisItem10 = analysisItem5;
        C8271i.m35386b(analysisItem5, "adFee");
        DogAnalysisRsp dogAnalysisRsp = new DogAnalysisRsp(str2, analysisItem6, analysisItem7, analysisItem8, analysisItem9, analysisItem10, f);
        return dogAnalysisRsp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
            if (java.lang.Float.compare(r2.percent, r3.percent) == 0) goto L_0x0051;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0051
        boolean r0 = r3 instanceof com.jiayouya.travel.module.p276me.data.DogAnalysisRsp
        if (r0 == 0) goto L_0x004f
        com.jiayouya.travel.module.me.data.DogAnalysisRsp r3 = (com.jiayouya.travel.module.p276me.data.DogAnalysisRsp) r3
        java.lang.String r0 = r2.level
        java.lang.String r1 = r3.level
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x004f
        com.jiayouya.travel.module.me.data.AnalysisItem r0 = r2.merge
        com.jiayouya.travel.module.me.data.AnalysisItem r1 = r3.merge
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x004f
        com.jiayouya.travel.module.me.data.AnalysisItem r0 = r2.adVideo
        com.jiayouya.travel.module.me.data.AnalysisItem r1 = r3.adVideo
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x004f
        com.jiayouya.travel.module.me.data.AnalysisItem r0 = r2.invite
        com.jiayouya.travel.module.me.data.AnalysisItem r1 = r3.invite
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x004f
        com.jiayouya.travel.module.me.data.AnalysisItem r0 = r2.city
        com.jiayouya.travel.module.me.data.AnalysisItem r1 = r3.city
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x004f
        com.jiayouya.travel.module.me.data.AnalysisItem r0 = r2.adFee
        com.jiayouya.travel.module.me.data.AnalysisItem r1 = r3.adFee
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x004f
        float r0 = r2.percent
        float r3 = r3.percent
        int r3 = java.lang.Float.compare(r0, r3)
        if (r3 != 0) goto L_0x004f
        goto L_0x0051
    L_0x004f:
        r3 = 0
        return r3
    L_0x0051:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p276me.data.DogAnalysisRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.level;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AnalysisItem analysisItem = this.merge;
        int hashCode2 = (hashCode + (analysisItem != null ? analysisItem.hashCode() : 0)) * 31;
        AnalysisItem analysisItem2 = this.adVideo;
        int hashCode3 = (hashCode2 + (analysisItem2 != null ? analysisItem2.hashCode() : 0)) * 31;
        AnalysisItem analysisItem3 = this.invite;
        int hashCode4 = (hashCode3 + (analysisItem3 != null ? analysisItem3.hashCode() : 0)) * 31;
        AnalysisItem analysisItem4 = this.city;
        int hashCode5 = (hashCode4 + (analysisItem4 != null ? analysisItem4.hashCode() : 0)) * 31;
        AnalysisItem analysisItem5 = this.adFee;
        if (analysisItem5 != null) {
            i = analysisItem5.hashCode();
        }
        return ((hashCode5 + i) * 31) + Float.floatToIntBits(this.percent);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DogAnalysisRsp(level=");
        sb.append(this.level);
        sb.append(", merge=");
        sb.append(this.merge);
        sb.append(", adVideo=");
        sb.append(this.adVideo);
        sb.append(", invite=");
        sb.append(this.invite);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", adFee=");
        sb.append(this.adFee);
        sb.append(", percent=");
        sb.append(this.percent);
        sb.append(")");
        return sb.toString();
    }

    public DogAnalysisRsp(String str, AnalysisItem analysisItem, AnalysisItem analysisItem2, AnalysisItem analysisItem3, AnalysisItem analysisItem4, AnalysisItem analysisItem5, float f) {
        C8271i.m35386b(str, "level");
        C8271i.m35386b(analysisItem, "merge");
        C8271i.m35386b(analysisItem2, "adVideo");
        C8271i.m35386b(analysisItem3, "invite");
        C8271i.m35386b(analysisItem4, "city");
        C8271i.m35386b(analysisItem5, "adFee");
        this.level = str;
        this.merge = analysisItem;
        this.adVideo = analysisItem2;
        this.invite = analysisItem3;
        this.city = analysisItem4;
        this.adFee = analysisItem5;
        this.percent = f;
    }

    public final AnalysisItem getAdVideo() {
        return this.adVideo;
    }

    public final String getLevel() {
        return this.level;
    }

    public final AnalysisItem getMerge() {
        return this.merge;
    }

    public final AnalysisItem getAdFee() {
        return this.adFee;
    }

    public final AnalysisItem getCity() {
        return this.city;
    }

    public final AnalysisItem getInvite() {
        return this.invite;
    }

    public final float getPercent() {
        return this.percent;
    }
}
