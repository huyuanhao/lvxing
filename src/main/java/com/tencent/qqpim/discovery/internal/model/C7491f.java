package com.tencent.qqpim.discovery.internal.model;

import java.util.ArrayList;

/* renamed from: com.tencent.qqpim.discovery.internal.model.f */
public class C7491f {
    /* renamed from: Ge */
    public String f25078Ge;
    /* renamed from: He */
    public boolean f25079He;
    /* renamed from: Ie */
    public int f25080Ie;
    /* renamed from: Je */
    public boolean f25081Je;
    /* renamed from: Ke */
    public int f25082Ke;
    /* renamed from: Le */
    public String f25083Le;
    /* renamed from: Ma */
    public int f25084Ma;
    /* renamed from: Me */
    public ArrayList<String> f25085Me;
    /* renamed from: Ne */
    public ArrayList<String> f25086Ne;
    /* renamed from: Oa */
    public String f25087Oa;
    /* renamed from: Oe */
    public ArrayList<String> f25088Oe;
    /* renamed from: Pe */
    public ArrayList<String> f25089Pe;
    /* renamed from: Qe */
    public ArrayList<String> f25090Qe;
    /* renamed from: Re */
    public ArrayList<String> f25091Re;
    /* renamed from: Se */
    public ArrayList<String> f25092Se;
    /* renamed from: Te */
    public ArrayList<String> f25093Te;
    /* renamed from: Ue */
    public ArrayList<String> f25094Ue;
    /* renamed from: Ve */
    public ArrayList<String> f25095Ve;
    /* renamed from: We */
    public ArrayList<String> f25096We;
    /* renamed from: Xe */
    public ClickDataModel f25097Xe;
    public String appDownloadUrl;
    public String channelId;
    public int contentType;
    public byte[] context;
    public int continuousExposureTime;
    public int effectiveTime;
    public int exposureInterval;
    public String imageUrl1;
    public String imageUrl2;
    public String imageUrl3;
    public ArrayList<String> imgList;
    public boolean isAutoAppDownload;
    public boolean isDeepLink;
    public boolean isneedGuide;
    public String jumpUrl;
    public String notifyContent;
    public int notifyInterval;
    public String packageName;
    public int percentSpent;
    public int positionId;
    public long predisplaytime;
    /* renamed from: rc */
    public int f25098rc;
    public boolean rotation;
    public int scenes;
    public boolean sdkADRequest = false;
    public String sdkParamappid;
    public String sdkPosId;
    public int sdkType = 0;
    public int sdkgdtPosAmount;
    public int sdkgdtrequestTimeout;
    public int templateType;
    public String text1;
    public String text2;
    public String text3;
    public String text4;
    public String uniqueKey;
    public String videoUrl;
    public String zipUrl;

    public C7491f() {
        String str = "";
        this.sdkParamappid = str;
        this.sdkPosId = str;
        this.sdkgdtPosAmount = 0;
        this.sdkgdtrequestTimeout = 0;
        this.f25078Ge = str;
        this.positionId = 0;
        this.f25098rc = 0;
        this.isneedGuide = false;
        this.f25079He = false;
        this.notifyInterval = 0;
        this.notifyContent = str;
        this.percentSpent = 0;
        this.effectiveTime = 0;
        this.continuousExposureTime = 0;
        this.exposureInterval = 0;
        this.f25084Ma = 0;
        this.f25087Oa = str;
        this.channelId = str;
        this.imgList = null;
        this.f25081Je = false;
        this.f25082Ke = -1;
        this.f25083Le = str;
        this.f25085Me = null;
        this.f25086Ne = null;
        this.f25088Oe = null;
        this.f25089Pe = null;
        this.f25090Qe = null;
        this.f25091Re = null;
        this.f25092Se = null;
        this.f25093Te = null;
        this.f25094Ue = null;
        this.f25095Ve = null;
        this.f25096We = null;
        this.f25097Xe = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnifiedAdData [activityId=");
        sb.append(this.f25078Ge);
        sb.append(", positionId=");
        sb.append(this.positionId);
        sb.append(", expiredTime=");
        sb.append(this.f25098rc);
        sb.append(", isneedGuide=");
        sb.append(this.isneedGuide);
        sb.append(", isShareable=");
        sb.append(this.f25079He);
        sb.append(", templateType=");
        sb.append(this.templateType);
        sb.append(", text1=");
        sb.append(this.text1);
        sb.append(", text2=");
        sb.append(this.text2);
        sb.append(", text3=");
        sb.append(this.text3);
        sb.append(", text4=");
        sb.append(this.text4);
        sb.append(", imageUrl1=");
        sb.append(this.imageUrl1);
        sb.append(", imageUrl2=");
        sb.append(this.imageUrl2);
        sb.append(", imageUrl3=");
        sb.append(this.imageUrl3);
        sb.append(", videoUrl=");
        sb.append(this.videoUrl);
        sb.append(", zipUrl=");
        sb.append(this.zipUrl);
        sb.append(", notifyInterval=");
        sb.append(this.notifyInterval);
        sb.append(", notifyContent=");
        sb.append(this.notifyContent);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", jumpUrl=");
        sb.append(this.jumpUrl);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", uniqueKey=");
        sb.append(this.uniqueKey);
        sb.append(", percentSpent=");
        sb.append(this.percentSpent);
        sb.append(", effectivetime=");
        sb.append(this.effectiveTime);
        sb.append(", continuousExposureTime=");
        sb.append(this.continuousExposureTime);
        sb.append(", exposureInterval=");
        sb.append(this.exposureInterval);
        sb.append(", scenes=");
        sb.append(this.scenes);
        sb.append(", predisplaytime=");
        sb.append(this.predisplaytime);
        sb.append(", appDownloadUrl=");
        sb.append(this.appDownloadUrl);
        sb.append(", isAutoAppDownload=");
        sb.append(this.isAutoAppDownload);
        sb.append(", isDeepLink=");
        sb.append(this.isDeepLink);
        sb.append(", rotation=");
        sb.append(this.rotation);
        sb.append(", desttype=");
        sb.append(this.f25084Ma);
        sb.append(", customedUrl=");
        sb.append(this.f25087Oa);
        sb.append(", channelId=");
        sb.append(this.channelId);
        sb.append(", imgList=");
        sb.append(this.imgList);
        sb.append(", extraDataType=");
        sb.append(this.f25082Ke);
        sb.append(", extraDataJSON=");
        sb.append(this.f25083Le);
        sb.append(", displayInVipmode=");
        sb.append(this.f25081Je);
        sb.append("]");
        return sb.toString();
    }
}
