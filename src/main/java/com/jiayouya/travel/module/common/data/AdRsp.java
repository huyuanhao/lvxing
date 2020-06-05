package com.jiayouya.travel.module.common.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/AdRsp;", "", "adPlat", "", "adLogId", "", "adIdVideo", "adIdBanner", "adNumVideo", "adIdInfoFlow", "adDesc", "adVideoList", "", "Lcom/jiayouya/travel/module/common/data/Platform;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAdDesc", "()Ljava/lang/String;", "getAdIdBanner", "getAdIdInfoFlow", "getAdIdVideo", "getAdLogId", "getAdNumVideo", "()I", "getAdPlat", "getAdVideoList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AdRsp.kt */
public final class AdRsp {
    private final String adDesc;
    private final String adIdBanner;
    private final String adIdInfoFlow;
    private final String adIdVideo;
    private final String adLogId;
    private final int adNumVideo;
    private final int adPlat;
    private final List<Platform> adVideoList;

    public static /* synthetic */ AdRsp copy$default(AdRsp adRsp, int i, String str, String str2, String str3, int i2, String str4, String str5, List list, int i3, Object obj) {
        AdRsp adRsp2 = adRsp;
        int i4 = i3;
        return adRsp.copy((i4 & 1) != 0 ? adRsp2.adPlat : i, (i4 & 2) != 0 ? adRsp2.adLogId : str, (i4 & 4) != 0 ? adRsp2.adIdVideo : str2, (i4 & 8) != 0 ? adRsp2.adIdBanner : str3, (i4 & 16) != 0 ? adRsp2.adNumVideo : i2, (i4 & 32) != 0 ? adRsp2.adIdInfoFlow : str4, (i4 & 64) != 0 ? adRsp2.adDesc : str5, (i4 & 128) != 0 ? adRsp2.adVideoList : list);
    }

    public final int component1() {
        return this.adPlat;
    }

    public final String component2() {
        return this.adLogId;
    }

    public final String component3() {
        return this.adIdVideo;
    }

    public final String component4() {
        return this.adIdBanner;
    }

    public final int component5() {
        return this.adNumVideo;
    }

    public final String component6() {
        return this.adIdInfoFlow;
    }

    public final String component7() {
        return this.adDesc;
    }

    public final List<Platform> component8() {
        return this.adVideoList;
    }

    public final AdRsp copy(int i, String str, String str2, String str3, int i2, String str4, String str5, List<Platform> list) {
        String str6 = str;
        C8271i.m35386b(str, "adLogId");
        String str7 = str2;
        C8271i.m35386b(str2, "adIdVideo");
        String str8 = str3;
        C8271i.m35386b(str3, "adIdBanner");
        String str9 = str5;
        C8271i.m35386b(str9, "adDesc");
        AdRsp adRsp = new AdRsp(i, str6, str7, str8, i2, str4, str9, list);
        return adRsp;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AdRsp) {
                AdRsp adRsp = (AdRsp) obj;
                if ((this.adPlat == adRsp.adPlat) && C8271i.m35384a((Object) this.adLogId, (Object) adRsp.adLogId) && C8271i.m35384a((Object) this.adIdVideo, (Object) adRsp.adIdVideo) && C8271i.m35384a((Object) this.adIdBanner, (Object) adRsp.adIdBanner)) {
                    if (!(this.adNumVideo == adRsp.adNumVideo) || !C8271i.m35384a((Object) this.adIdInfoFlow, (Object) adRsp.adIdInfoFlow) || !C8271i.m35384a((Object) this.adDesc, (Object) adRsp.adDesc) || !C8271i.m35384a((Object) this.adVideoList, (Object) adRsp.adVideoList)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.adPlat * 31;
        String str = this.adLogId;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.adIdVideo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.adIdBanner;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.adNumVideo) * 31;
        String str4 = this.adIdInfoFlow;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.adDesc;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<Platform> list = this.adVideoList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdRsp(adPlat=");
        sb.append(this.adPlat);
        sb.append(", adLogId=");
        sb.append(this.adLogId);
        sb.append(", adIdVideo=");
        sb.append(this.adIdVideo);
        sb.append(", adIdBanner=");
        sb.append(this.adIdBanner);
        sb.append(", adNumVideo=");
        sb.append(this.adNumVideo);
        sb.append(", adIdInfoFlow=");
        sb.append(this.adIdInfoFlow);
        sb.append(", adDesc=");
        sb.append(this.adDesc);
        sb.append(", adVideoList=");
        sb.append(this.adVideoList);
        sb.append(")");
        return sb.toString();
    }

    public AdRsp(int i, String str, String str2, String str3, int i2, String str4, String str5, List<Platform> list) {
        C8271i.m35386b(str, "adLogId");
        C8271i.m35386b(str2, "adIdVideo");
        C8271i.m35386b(str3, "adIdBanner");
        C8271i.m35386b(str5, "adDesc");
        this.adPlat = i;
        this.adLogId = str;
        this.adIdVideo = str2;
        this.adIdBanner = str3;
        this.adNumVideo = i2;
        this.adIdInfoFlow = str4;
        this.adDesc = str5;
        this.adVideoList = list;
    }

    public final int getAdPlat() {
        return this.adPlat;
    }

    public final String getAdLogId() {
        return this.adLogId;
    }

    public final String getAdIdVideo() {
        return this.adIdVideo;
    }

    public final String getAdIdBanner() {
        return this.adIdBanner;
    }

    public final int getAdNumVideo() {
        return this.adNumVideo;
    }

    public final String getAdIdInfoFlow() {
        return this.adIdInfoFlow;
    }

    public final String getAdDesc() {
        return this.adDesc;
    }

    public final List<Platform> getAdVideoList() {
        return this.adVideoList;
    }
}
