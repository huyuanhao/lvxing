package com.p368pw.inner.p369a.p370a.p373c;

import com.google.gson.Gson;
import com.p368pw.inner.base.p387d.C5205o;
import com.tencent.p605ep.shanhuad.adpublic.ShanHuAD;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.NativeAd;
import com.tmsdk.module.coin.AppRetainModel;
import com.tmsdk.module.coin.AppRetainSpUtil;
import com.tmsdk.module.coin.AppRetainUtil;

/* renamed from: com.pw.inner.a.a.c.c */
public class C4845c {
    /* renamed from: a */
    public static Gson f15616a = new Gson();

    /* renamed from: a */
    public static void m19890a(AdMetaInfo adMetaInfo) {
        C5205o.m21462a("应用广告开始下载上报");
        ShanHuAD.reportStartDownload(adMetaInfo.getAdDisplayModel());
    }

    /* renamed from: a */
    public static void m19891a(AdMetaInfo adMetaInfo, String str) {
        C5205o.m21462a("应用广告下载成功上报");
        ShanHuAD.reportDownloadFinish(adMetaInfo.getAdDisplayModel());
        String d = C4839a.m19870d(adMetaInfo);
        AppRetainModel appRetainModel = new AppRetainModel(System.currentTimeMillis(), C4839a.m19870d(adMetaInfo), -1, adMetaInfo.getAdDisplayModel().uniqueKey, str, 1, adMetaInfo.title, adMetaInfo.cta, adMetaInfo.icon);
        AppRetainUtil.putDownloadAppToSp(d, appRetainModel);
    }

    /* renamed from: b */
    public static void m19892b(AdMetaInfo adMetaInfo) {
        C5205o.m21462a("应用广告下载完成上报");
        ShanHuAD.reportDownloadFinish(adMetaInfo.getAdDisplayModel());
    }

    /* renamed from: c */
    public static void m19893c(AdMetaInfo adMetaInfo) {
        C5205o.m21462a("应用广告安装成功上报");
        ShanHuAD.reportInstalled(adMetaInfo.getAdDisplayModel());
        String d = C4839a.m19870d(adMetaInfo);
        AppRetainModel appRetainModel = new AppRetainModel(System.currentTimeMillis(), C4839a.m19870d(adMetaInfo), -1, adMetaInfo.getAdDisplayModel().uniqueKey, "", 2, adMetaInfo.title, adMetaInfo.cta, adMetaInfo.icon);
        AppRetainUtil.putInstalledAppToSp(d, appRetainModel);
    }

    /* renamed from: d */
    public static void m19894d(AdMetaInfo adMetaInfo) {
        C5205o.m21462a("应用广告打开成功上报");
        ShanHuAD.reportActive(adMetaInfo.getAdDisplayModel());
        AppRetainModel appRetainModel = (AppRetainModel) f15616a.fromJson(AppRetainSpUtil.getISharePreferenceImp().getString(C4839a.m19870d(adMetaInfo), ""), AppRetainModel.class);
        if (adMetaInfo != null) {
            appRetainModel.clickNum = 1;
        }
        AppRetainUtil.putInstalledAppToSp(C4839a.m19870d(adMetaInfo), appRetainModel);
    }

    /* renamed from: e */
    public static void m19895e(AdMetaInfo adMetaInfo) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adMetaInfo.getAdDisplayModel(), 3, 0);
    }
}
