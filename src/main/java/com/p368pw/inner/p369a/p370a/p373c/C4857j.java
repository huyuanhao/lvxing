package com.p368pw.inner.p369a.p370a.p373c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.p368pw.inner.C5229d;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.appwall.C5005h;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5131a.C5134a;
import com.p368pw.inner.base.p386c.C5143a;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5204n;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.C5213t;
import com.p368pw.inner.base.p387d.p391d.C5183b;
import com.p368pw.inner.base.stat.C5222c;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.C4819a.C4820a;
import com.p368pw.inner.p369a.C4911e;
import com.p368pw.inner.p369a.C4967g;
import com.p368pw.inner.p369a.p370a.p371a.C4822b;
import com.p368pw.inner.p369a.p370a.p371a.C4827e;
import com.p368pw.inner.p369a.p370a.p373c.p374a.C4840a;
import com.p368pw.inner.p369a.p370a.p373c.p375b.C4842a;
import com.p368pw.inner.p369a.p376b.C4879b;
import com.p368pw.inner.p369a.p376b.C4880c;
import com.p368pw.inner.p369a.p377c.C4896a;
import com.p368pw.inner.p369a.p378d.C4898a;
import com.p368pw.inner.p369a.p378d.C4906b;
import com.p368pw.inner.p369a.p379e.C4933e;
import com.p368pw.inner.p369a.p379e.C4942g;
import com.p368pw.inner.p369a.p379e.C4958h;
import com.p368pw.inner.p369a.p379e.C4960j;
import com.p368pw.p392us.AdInfo;
import com.p368pw.p392us.Setting;
import com.p368pw.view.NativeAdContainer;
import com.p522qq.p523e.ads.nativ.NativeUnifiedADData;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.shanhuad.adpublic.ADError;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADBanner;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADCard;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADDownLoad;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADFeed;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADNative;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADScreen;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADSplashImage;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.AdInfoListener;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.RewardVideo;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.RewardVideo.RVListener;
import com.tencent.p605ep.shanhuad.adpublic.models.AdID;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tmsdk.module.coin.AdConfig;
import com.tmsdk.module.coin.AdConfig.AD_KEY;
import com.tmsdk.module.coin.AdConfigManager;
import com.tmsdk.module.coin.AdRequestData;
import com.tmsdk.module.coin.Coin;
import com.tmsdk.module.coin.CoinManager;
import com.tmsdk.module.coin.CoinRequestInfo;
import com.tmsdk.module.coin.CoinTask;
import com.tmsdk.module.coin.CoinTaskType;
import com.tmsdk.module.coin.ErrorCode;
import com.tmsdk.module.coin.ManagerCreator;
import com.tmsdk.module.coin.SubmitResultItem;
import com.tmsdk.module.coin.TMSDKContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.pw.inner.a.a.c.j */
public class C4857j {
    /* renamed from: a */
    private String f15640a;
    /* renamed from: b */
    private String f15641b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f15642c = 343;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public int f15643d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f15644e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public int f15645f;
    /* renamed from: g */
    private CoinManager f15646g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public HashMap<Setting, AdMetaInfo> f15647h;

    /* renamed from: com.pw.inner.a.a.c.j$a */
    private static class C4874a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C4857j f15736a = new C4857j();
    }

    /* renamed from: a */
    private C4841b m19932a(int i, C4847e eVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C4841b bVar = new C4841b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AdID(i, null, 968, 300));
        ADDownLoad aDDownLoad = new ADDownLoad();
        Context b = C5233e.m21559b();
        final C4841b bVar2 = bVar;
        final ADDownLoad aDDownLoad2 = aDDownLoad;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final C4847e eVar2 = eVar;
        C48581 r0 = new AdInfoListener() {
            public void onAdClick(NativeUnifiedADData nativeUnifiedADData) {
                C5205o.m21461a();
                eVar2.mo25855a(nativeUnifiedADData);
            }

            public void onAdError(ADError aDError) {
                C5205o.m21462a(aDError.msg);
                countDownLatch2.countDown();
            }

            public void onAdLoaded(List<AdMetaInfo> list) {
                C4841b bVar = bVar2;
                bVar.f15603a = list;
                bVar.f15604b = aDDownLoad2;
                bVar.f15605c = true;
                countDownLatch2.countDown();
            }

            public void onAdShow() {
                C5205o.m21461a();
                eVar2.mo25854a();
            }

            public void onGDTEventStatusChanged(int i) {
            }
        };
        aDDownLoad.load(b, r0, arrayList);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C5205o.m21464a((Throwable) e);
        }
        return bVar;
    }

    /* renamed from: a */
    private C4841b m19933a(int i, C4848f fVar) {
        C4841b bVar = new C4841b();
        RewardVideo rewardVideo = new RewardVideo();
        new ArrayList().add(new AdID(i, null, 968, 300));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final C4841b bVar2 = bVar;
        final RewardVideo rewardVideo2 = rewardVideo;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final C4848f fVar2 = fVar;
        C48654 r0 = new RVListener() {
            public void loaded() {
                C4841b bVar = bVar2;
                bVar.f15603a = null;
                bVar.f15604b = rewardVideo2;
                bVar.f15605c = true;
                countDownLatch2.countDown();
            }

            public void onAdError(ADError aDError) {
                C5205o.m21462a(aDError.msg);
                countDownLatch2.countDown();
            }

            public void onClick() {
                C5205o.m21461a();
                fVar2.mo25858c();
            }

            public void onClose() {
                C5205o.m21461a();
                fVar2.mo25859d();
            }

            public void onVideoComplete() {
                C5205o.m21461a();
                fVar2.mo25856a();
            }

            public void onVideoPlay() {
                C5205o.m21461a();
                fVar2.mo25857b();
            }
        };
        rewardVideo.load(r0, C5233e.m21559b(), new AdID(i, null, 968, 300));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C5205o.m21464a((Throwable) e);
        }
        return bVar;
    }

    /* renamed from: a */
    private C4841b m19934a(String str, AdRequestData adRequestData, C4850h hVar) {
        C5205o.m21462a(str);
        if (str.equals("COIN_DOWNLOAD_APP_AD")) {
            return m19932a(adRequestData.positionId, hVar.mo25861a());
        }
        if (str.equals("COIN_VIDEO_EXIT")) {
            return m19933a(adRequestData.positionId, hVar.mo25863b());
        }
        if (str.equals("COIN_CARD_GIVE")) {
            return m19950b(adRequestData.positionId, hVar.mo25861a());
        }
        if (str.equals("COIN_FEED_EXIT")) {
            return m19959e(adRequestData.positionId, hVar.mo25861a());
        }
        if (str.equals("COIN_SCROLL_EXIT")) {
            return m19958d(adRequestData.positionId, hVar.mo25861a());
        }
        if (str.equals("COIN_BANNER_EXIT")) {
            return m19955c(adRequestData.positionId, hVar.mo25861a());
        }
        if (str.equals("COIN_TIPS_EXIT")) {
            return m19961f(adRequestData.positionId, hVar.mo25861a());
        }
        if (str.equals("COIN_SPLASH_EXIT")) {
            return m19962g(adRequestData.positionId, hVar.mo25861a());
        }
        if (str.equals("COIN_SLASH_VIDEO")) {
            C5205o.m21462a("unsupport");
        }
        return new C4841b();
    }

    /* renamed from: a */
    public static C4857j m19935a() {
        return C4874a.f15736a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|(3:8|9|(1:13))|14|15|(1:17)(2:18|(1:20))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0096 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a0 A[Catch:{ all -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a5 A[Catch:{ all -> 0x00bb }] */
    /* renamed from: a */
    private com.p368pw.inner.p369a.p376b.C4879b m19936a(com.p368pw.inner.p369a.p370a.p373c.C4850h r5, com.p368pw.p392us.Setting r6) {
        /*
        r4 = this;
        com.pw.inner.a.b.b r0 = new com.pw.inner.a.b.b
        r0.m48961init()
        java.util.List<com.tencent.ep.shanhuad.adpublic.models.AdMetaInfo> r1 = r5.f15620b     // Catch:{ all -> 0x00bb }
        if (r1 == 0) goto L_0x00bf
        java.util.List<com.tencent.ep.shanhuad.adpublic.models.AdMetaInfo> r1 = r5.f15620b     // Catch:{ all -> 0x00bb }
        int r1 = r1.size()     // Catch:{ all -> 0x00bb }
        if (r1 <= 0) goto L_0x00bf
        java.util.List<com.tencent.ep.shanhuad.adpublic.models.AdMetaInfo> r1 = r5.f15620b     // Catch:{ all -> 0x00bb }
        int r1 = r1.size()     // Catch:{ all -> 0x00bb }
        r2 = 0
        com.p368pw.inner.C5238g.m21603a(r2, r1)     // Catch:{ all -> 0x00bb }
        java.util.List<com.tencent.ep.shanhuad.adpublic.models.AdMetaInfo> r1 = r5.f15620b     // Catch:{ all -> 0x00bb }
        java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00bb }
        com.tencent.ep.shanhuad.adpublic.models.AdMetaInfo r1 = (com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo) r1     // Catch:{ all -> 0x00bb }
        java.lang.String r2 = r1.cta     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r2 = r0.mo25921h(r2)     // Catch:{ all -> 0x00bb }
        java.lang.String r3 = r1.desc     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r2 = r2.mo25912d(r3)     // Catch:{ all -> 0x00bb }
        java.lang.String r3 = r1.title     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r2 = r2.mo25909c(r3)     // Catch:{ all -> 0x00bb }
        java.lang.String r3 = r1.icon     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r2 = r2.mo25917f(r3)     // Catch:{ all -> 0x00bb }
        java.lang.String r3 = r1.getDownLoadUrl()     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r2 = r2.mo25923i(r3)     // Catch:{ all -> 0x00bb }
        java.lang.String r3 = com.p368pw.inner.p369a.p370a.p373c.C4839a.m19869c(r1)     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r2 = r2.mo25925j(r3)     // Catch:{ all -> 0x00bb }
        java.util.Map<java.lang.String, java.lang.String> r5 = r5.f15627i     // Catch:{ all -> 0x00bb }
        java.lang.String r3 = com.p368pw.inner.p369a.p370a.p373c.C4839a.m19865a(r1)     // Catch:{ all -> 0x00bb }
        java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x00bb }
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r5 = r2.mo25927k(r5)     // Catch:{ all -> 0x00bb }
        java.lang.String r2 = com.p368pw.inner.p369a.p370a.p373c.C4839a.m19870d(r1)     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r5 = r5.mo25919g(r2)     // Catch:{ all -> 0x00bb }
        int r2 = java.lang.System.identityHashCode(r1)     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r5 = r5.mo25902a(r2)     // Catch:{ all -> 0x00bb }
        java.lang.String r2 = com.p368pw.inner.p369a.p370a.p373c.C4839a.m19865a(r1)     // Catch:{ all -> 0x00bb }
        com.pw.inner.a.b.b r5 = r5.mo25906b(r2)     // Catch:{ all -> 0x00bb }
        r2 = 5
        r5.mo25908c(r2)     // Catch:{ all -> 0x00bb }
        java.lang.Object r5 = r6.getObject3()     // Catch:{ all -> 0x00bb }
        if (r5 == 0) goto L_0x0096
        java.lang.Object r5 = r6.getObject3()     // Catch:{ all -> 0x0096 }
        com.pw.us.AdInfo r5 = (com.p368pw.p392us.AdInfo) r5     // Catch:{ all -> 0x0096 }
        if (r5 == 0) goto L_0x0096
        java.lang.String r6 = r5.getImageUrl()     // Catch:{ all -> 0x0096 }
        boolean r6 = com.p368pw.inner.base.p387d.C5207q.m21478b(r6)     // Catch:{ all -> 0x0096 }
        if (r6 == 0) goto L_0x0096
        java.lang.String r5 = r5.getImageUrl()     // Catch:{ all -> 0x0096 }
        r0.mo25927k(r5)     // Catch:{ all -> 0x0096 }
    L_0x0096:
        java.lang.String r5 = com.p368pw.inner.p369a.p370a.p373c.C4839a.m19869c(r1)     // Catch:{ all -> 0x00bb }
        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00bb }
        if (r5 != 0) goto L_0x00a5
        r5 = 1
        r0.mo25914e(r5)     // Catch:{ all -> 0x00bb }
        goto L_0x00bf
    L_0x00a5:
        java.lang.String r5 = r1.getDownLoadUrl()     // Catch:{ all -> 0x00bb }
        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00bb }
        r6 = 2
        if (r5 != 0) goto L_0x00b4
    L_0x00b0:
        r0.mo25914e(r6)     // Catch:{ all -> 0x00bb }
        goto L_0x00bf
    L_0x00b4:
        com.tencent.qqpim.discovery.AdDisplayModel r5 = r1.getAdDisplayModel()     // Catch:{ all -> 0x00bb }
        if (r5 != 0) goto L_0x00bf
        goto L_0x00b0
    L_0x00bb:
        r5 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r5)
    L_0x00bf:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.p369a.p370a.p373c.C4857j.m19936a(com.pw.inner.a.a.c.h, com.pw.us.Setting):com.pw.inner.a.b.b");
    }

    /* renamed from: a */
    private C4958h m19937a(C4850h hVar, AdInfo adInfo) {
        C4958h hVar2;
        try {
            if (hVar.f15620b != null && hVar.f15620b.size() > 0) {
                int size = hVar.f15620b.size();
                int i = 0;
                while (i < size) {
                    AdMetaInfo adMetaInfo = (AdMetaInfo) hVar.f15620b.get(i);
                    if (!C5213t.m21487a(C4839a.m19870d(adMetaInfo), adInfo.getPkgName()) || !C5213t.m21487a(adMetaInfo.icon, adInfo.getIconUrl()) || !C5207q.m21478b((CharSequence) adMetaInfo.getDownLoadUrl())) {
                        i++;
                    } else {
                        hVar2 = new C4958h();
                        try {
                            hVar2.mo26224e(adMetaInfo.cta).mo26212a(C4839a.m19867b(adMetaInfo)).mo26228g(adMetaInfo.desc).mo26230h(adMetaInfo.title).mo26226f(adMetaInfo.icon).mo26219c(adMetaInfo.getDownLoadUrl()).mo26222d(C4839a.m19870d(adMetaInfo)).mo26211a(System.identityHashCode(adMetaInfo));
                            return hVar2;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            hVar2 = null;
            C5205o.m21464a(th);
            return hVar2;
        }
    }

    /* renamed from: a */
    private C4958h m19938a(C4850h hVar, Setting setting, C4911e eVar) {
        AdMetaInfo adMetaInfo;
        Object obj;
        C4958h hVar2 = new C4958h();
        try {
            if (hVar.f15620b == null || hVar.f15620b.size() <= 0) {
                C5205o.m21462a("normal视频");
            } else {
                C5205o.m21462a("generateVideoBeanAndCache原生拼装视频");
                if (hVar.f15623e) {
                    adMetaInfo = (AdMetaInfo) hVar.f15620b.get(0);
                    C5205o.m21462a("下载类offer缓存命中");
                } else {
                    int size = hVar.f15620b.size();
                    ArrayList<AdMetaInfo> arrayList = new ArrayList<>();
                    ArrayList arrayList2 = new ArrayList();
                    for (AdMetaInfo add : hVar.f15620b) {
                        arrayList.add(add);
                    }
                    boolean z = true;
                    C5205o.m21462a(String.format("一共%d个广告，其中下载类%d个，非下载类%d个", new Object[]{Integer.valueOf(size), Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size())}));
                    int O = C5125f.m21216a().mo26727d().mo26687O();
                    if (arrayList.size() < size) {
                        if (O > 0) {
                            if (O != 100) {
                                if (C5238g.m21603a(1, 101) > O) {
                                    z = false;
                                }
                                if (z) {
                                    if (arrayList.size() > 0) {
                                        C5205o.m21462a("tx vd hit down");
                                        obj = arrayList.remove(C5238g.m21603a(0, arrayList.size()));
                                    } else {
                                        C5205o.m21462a("tx vd hit down but no");
                                        return null;
                                    }
                                } else if (arrayList2.size() > 0) {
                                    C5205o.m21462a("tx vd hit jmp");
                                    obj = arrayList2.get(C5238g.m21603a(0, arrayList2.size()));
                                } else {
                                    C5205o.m21462a("tx vd hit jmp but no");
                                    return null;
                                }
                            } else if (arrayList.size() > 0) {
                                C5205o.m21462a("tx vd must get down");
                                obj = arrayList.remove(C5238g.m21603a(0, arrayList.size()));
                            } else {
                                C5205o.m21462a("tx vd must but no down");
                                return null;
                            }
                        } else if (arrayList2.size() > 0) {
                            C5205o.m21462a("tx vd must get jmp");
                            obj = arrayList2.get(C5238g.m21603a(0, arrayList2.size()));
                        } else {
                            C5205o.m21462a("tx vd must but no jmp");
                            return null;
                        }
                        AdMetaInfo adMetaInfo2 = (AdMetaInfo) obj;
                        if (arrayList.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (AdMetaInfo adMetaInfo3 : arrayList) {
                                hashMap.put(adMetaInfo3, hVar.f15621c.get(adMetaInfo3));
                            }
                            C4842a.m19880a(C5233e.m21559b()).mo25849a(setting.getPlacementId(), (Map<AdMetaInfo, CoinTask>) hashMap);
                        }
                        adMetaInfo = adMetaInfo2;
                    } else if (O == 0 || arrayList.size() <= 0) {
                        return null;
                    } else {
                        adMetaInfo = (AdMetaInfo) hVar.f15620b.get(C5238g.m21603a(0, size));
                    }
                }
                hVar2.mo26224e(adMetaInfo.cta).mo26228g(adMetaInfo.desc).mo26230h(adMetaInfo.title).mo26226f(adMetaInfo.icon).mo26219c(adMetaInfo.getDownLoadUrl()).mo26222d(C4839a.m19870d(adMetaInfo)).mo26211a(System.identityHashCode(adMetaInfo)).mo26218c(eVar.f15873d).mo26221d(eVar.f15874e).mo26212a(C4839a.m19867b(adMetaInfo)).mo26232i(C4839a.m19869c(adMetaInfo)).mo26217b(C4839a.m19865a(adMetaInfo));
            }
            if (setting != null) {
                hVar2.mo26240m(setting.getUuid());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return hVar2;
    }

    /* renamed from: a */
    private AdInfo m19939a(C4850h hVar) {
        AdInfo adInfo = null;
        try {
            if (hVar.f15620b == null || hVar.f15620b.size() <= 0) {
                return null;
            }
            AdMetaInfo adMetaInfo = (AdMetaInfo) hVar.f15620b.get(C5238g.m21603a(0, hVar.f15620b.size()));
            AdInfo adInfo2 = new AdInfo(adMetaInfo.title, adMetaInfo.desc, adMetaInfo.icon, C4839a.m19870d(adMetaInfo), adMetaInfo.cta, "http://zhizh-front.oss-cn-shenzhen.aliyuncs.com/2/20191204/AD_icon.png.png", adMetaInfo.image);
            try {
                adInfo2.setAdMetaInfoIdentity(System.identityHashCode(adMetaInfo));
                return adInfo2;
            } catch (Throwable th) {
                th = th;
                adInfo = adInfo2;
                C5205o.m21464a(th);
                return adInfo;
            }
        } catch (Throwable th2) {
            th = th2;
            C5205o.m21464a(th);
            return adInfo;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public AdMetaInfo m19940a(C4850h hVar, C4933e eVar) {
        try {
            if (hVar.f15620b == null || hVar.f15620b.size() <= 0) {
                return null;
            }
            int size = hVar.f15620b.size();
            C4958h c = eVar.mo26149c();
            for (int i = 0; i < size; i++) {
                AdMetaInfo adMetaInfo = (AdMetaInfo) hVar.f15620b.get(i);
                if (C5213t.m21487a(C4839a.m19870d(adMetaInfo), c.mo26229g()) && C5213t.m21487a(adMetaInfo.icon, c.mo26231h())) {
                    return adMetaInfo;
                }
            }
            return null;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* renamed from: a */
    private void m19942a(Context context, Setting setting, int i, String str, int i2, C4850h hVar, C4820a aVar) {
        Setting setting2 = setting;
        int i3 = i;
        C4850h hVar2 = hVar;
        C4820a aVar2 = aVar;
        if (hVar2 == null || !hVar2.f15619a) {
            C5205o.m21462a("开屏广告加载失败");
            C5224e.m21525a().mo26909a(2, 0, "", i, str, setting.getPlacementId(), this.f15642c, this.f15643d, this.f15644e, this.f15645f, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, 0, "", "", "", -1, "", "", "", "", 0, 0);
            if (aVar2 != null) {
                aVar2.mo25759a(setting.getThPlacementBean().mo26309h().f15875f, aVar2);
            }
            return;
        }
        AdInfo a = m19939a(hVar2);
        String str2 = (String) new C4896a(setting.getPlacementId(), i3, a.getPkgName(), a.getTitle()).mo26659b();
        setting2.setObject3(new AdInfo(a, str2));
        C4967g thPlacementBean = setting.getThPlacementBean();
        C4879b a2 = m19936a(hVar2, setting2);
        a2.mo25929l(setting.getUuid()).mo25931m(setting.getPlacementId()).mo25905b(setting.getAdType()).mo25908c(i3).mo25934n(str);
        int i4 = (!TextUtils.isEmpty(a2.mo25944s()) || !TextUtils.isEmpty(a2.mo25926j())) ? 500 : 501;
        a2.mo25911d(i4);
        int j = C5125f.m21216a().mo26727d().mo26706j();
        if (j == 502 && !TextUtils.isEmpty(a2.mo25928k())) {
            a2.mo25911d(502);
        }
        if (j == 503 && !TextUtils.isEmpty(a2.mo25928k())) {
            a2.mo25911d(503);
        }
        final Setting setting3 = setting;
        C4898a aVar3 = new C4898a(context, a2, i, setting3, hVar, thPlacementBean.mo26307f(), true);
        final Context context2 = context;
        final C4879b bVar = a2;
        final C4898a aVar4 = aVar3;
        final int i5 = i;
        C48739 r12 = r0;
        final C4850h hVar3 = hVar;
        C48739 r0 = new C4847e() {
            /* renamed from: a */
            public void mo25854a() {
                C5205o.m21462a("珊瑚开屏onAdShow");
                C4906b.m20273a().mo26040a(context2, bVar, setting3, aVar4);
            }

            /* renamed from: a */
            public void mo25855a(NativeUnifiedADData nativeUnifiedADData) {
                C5205o.m21462a("珊瑚开屏onAdClick");
                C4906b a = C4906b.m20273a();
                Context b = C5233e.m21559b();
                Setting setting = setting3;
                C4898a aVar = aVar4;
                a.mo26041a(b, setting, aVar, bVar, i5, aVar.getClickLocation(), aVar4.getSpMngListener());
                new C4849g(((AdMetaInfo) hVar3.f15620b.get(0)).title, C4839a.m19870d((AdMetaInfo) hVar3.f15620b.get(0))).mo26660c();
            }
        };
        hVar2.mo25862a((C4847e) r12);
        ADDownLoad aDDownLoad = (ADDownLoad) hVar2.f15622d;
        aVar3.allowAddView = false;
        aDDownLoad.registerViewForInteraction((AdMetaInfo) hVar2.f15620b.get(0), aVar3, aVar3.getViewGroup());
        aVar3.allowAddView = true;
        setting2.setAdObject(aVar3);
        C5205o.m21462a("s open screen onAdLoaded");
        C4898a aVar5 = aVar3;
        String str3 = str2;
        C5224e.m21525a().mo26909a(2, 1, "", i, str, setting.getPlacementId(), this.f15642c, this.f15643d, this.f15644e, this.f15645f, 0, setting.getUuid(), String.valueOf(setting.getAdType()), a2.mo25939q(), a2.mo25941r(), "", "", "", -1, a2.mo25904a(), a2.mo25913d(), str3, "", 0, 0);
        if (setting.getSplashAdListener() != null) {
            setting.getSplashAdListener().onLoaded(aVar5, setting2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19943a(Context context, Setting setting, C4911e eVar, int i, C5183b bVar) {
        Toast makeText;
        Context context2 = context;
        Setting setting2 = setting;
        try {
            final C4850h hVar = (C4850h) setting.getAdObject();
            final AdInfo adInfo = (AdInfo) setting.getObject3();
            C4958h a = m19937a(hVar, adInfo);
            final AdMetaInfo b = m19951b(hVar, adInfo);
            if (this.f15647h != null) {
                if (((AdMetaInfo) this.f15647h.get(setting2)) == null) {
                    C5205o.m21462a("s sh n no ck");
                    this.f15647h.put(setting2, b);
                } else {
                    C5205o.m21462a("s sh n has ck");
                }
            }
            if (a == null) {
                C5205o.m21462a("广点通广告，下载链接为空，广点通已经自己处理了，不需要我们自己下载");
                return;
            }
            final Setting setting3 = setting;
            final C4911e eVar2 = eVar;
            final int i2 = i;
            final C4958h hVar2 = a;
            final Context context3 = context;
            C48718 r1 = new C4827e() {
                /* renamed from: a */
                public void mo25787a() {
                }

                /* renamed from: a */
                public void mo25788a(int i) {
                }

                /* renamed from: a */
                public void mo25789a(int i, C5183b bVar) {
                }

                /* renamed from: a */
                public void mo25790a(String str) {
                    C5205o.m21462a("s native start download");
                    if (setting3.getAdListener() != null) {
                        setting3.getAdListener().onDownloadStarted();
                    }
                    C4857j.this.mo25870a(5, b, "", hVar);
                }

                /* renamed from: a */
                public void mo25791a(String str, String str2) {
                    String str3 = str2;
                    C5205o.m21462a("s native download finish");
                    C5224e.m21525a().mo26909a(6, 1, "", eVar2.f15870a, eVar2.f15871b, setting3.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting3.getUuid(), String.valueOf(setting3.getAdType()), i2, 2, C4839a.m19865a(b), "", "", -1, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), "", 0, 0);
                    if (setting3.getAdListener() != null) {
                        setting3.getAdListener().onDownloadFinished(str3);
                    }
                    C4857j.this.mo25870a(6, b, str3, hVar);
                    C5005h.m20951a().mo26405a(b, (CoinTask) hVar.f15621c.get(b), hVar2.mo26235j(), hVar2.mo26233i(), hVar2.mo26231h(), str, str2, 1, 0, eVar2.f15870a, eVar2.f15871b, setting3.getPlacementId(), String.valueOf(setting3.getAdType()), i2, C4839a.m19865a(b), hVar2.mo26248t(), 1, null);
                    C5005h a = C5005h.m20951a();
                    Context context = context3;
                    int i = eVar2.f15870a;
                    Context context2 = context;
                    int i2 = i;
                    String str4 = str;
                    a.mo26400a(context2, i2, setting3.getAdType(), str4, hVar2.mo26235j(), hVar2.mo26233i(), hVar2.mo26231h(), adInfo.getImageUrl(), hVar2.mo26214a(), hVar2.mo26227f(), b, (CoinTask) hVar.f15621c.get(b));
                }

                /* renamed from: b */
                public void mo25792b() {
                }

                /* renamed from: b */
                public void mo25793b(int i) {
                }

                /* renamed from: b */
                public void mo25794b(String str) {
                }

                /* renamed from: b */
                public void mo25795b(String str, String str2) {
                    final String str3 = str2;
                    C5205o.m21462a("s native install finish");
                    C5224e.m21525a().mo26909a(7, 1, "", eVar2.f15870a, eVar2.f15871b, setting3.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting3.getUuid(), String.valueOf(setting3.getAdType()), i2, 2, C4839a.m19865a(b), "", "", -1, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), "", 0, 0);
                    if (setting3.getAdListener() != null) {
                        setting3.getAdListener().onInstalled();
                    }
                    C4857j.this.mo25870a(7, b, str3, hVar);
                    C5005h.m20951a().mo26406a(hVar2.mo26229g(), 2, 0, (C5134a) null);
                    final String str4 = str;
                    C5208r.m21483b(new Runnable() {
                        public void run() {
                            if (!C4857j.this.mo25874a(context3)) {
                                C5005h.m20951a().mo26405a(b, (CoinTask) hVar.f15621c.get(b), hVar2.mo26235j(), hVar2.mo26233i(), hVar2.mo26231h(), str4, str3, 2, 0, eVar2.f15870a, eVar2.f15871b, setting3.getPlacementId(), String.valueOf(setting3.getAdType()), i2, C4839a.m19865a(b), hVar2.mo26248t(), 1, null);
                            } else if (hVar.f15626h.compareAndSet(false, true)) {
                                C4857j.this.mo25870a(8, b, "", hVar);
                                C5224e.m21525a().mo26909a(8001, 1, "", eVar2.f15870a, eVar2.f15871b, setting3.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting3.getUuid(), String.valueOf(setting3.getAdType()), i2, 2, C4839a.m19865a(b), "", "", -1, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), "", 0, 0);
                                C5005h.m20951a().mo26406a(hVar2.mo26229g(), 2, 1, (C5134a) null);
                            }
                        }
                    }, (long) (C5125f.m21216a().mo26727d().mo26681I() * 1000));
                }

                /* renamed from: c */
                public void mo25796c() {
                }

                /* renamed from: c */
                public void mo25797c(int i) {
                }

                /* renamed from: d */
                public void mo25798d() {
                    C5224e.m21525a().mo26909a(9, 1, "", eVar2.f15870a, eVar2.f15871b, setting3.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting3.getUuid(), String.valueOf(setting3.getAdType()), i2, 2, C4839a.m19865a(b), "", "", -1, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), "", 0, 0);
                }

                /* renamed from: d */
                public void mo25799d(int i) {
                }

                /* renamed from: e */
                public void mo25800e() {
                }

                /* renamed from: f */
                public void mo25801f() {
                }

                /* renamed from: g */
                public void mo25802g() {
                }

                /* renamed from: h */
                public void mo25803h() {
                }

                /* renamed from: i */
                public void mo25804i() {
                }

                /* renamed from: j */
                public void mo25805j() {
                    C5205o.m21462a("s native active");
                    C5224e.m21525a().mo26909a(8, 1, "", eVar2.f15870a, eVar2.f15871b, setting3.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting3.getUuid(), String.valueOf(setting3.getAdType()), i2, 2, C4839a.m19865a(b), "", "", -1, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), "", 0, 0);
                    if (hVar.f15626h.compareAndSet(false, true)) {
                        C4857j.this.mo25870a(8, b, "", hVar);
                        C5005h.m20951a().mo26406a(hVar2.mo26229g(), 2, 1, (C5134a) null);
                    }
                }

                /* renamed from: k */
                public void mo25806k() {
                }

                /* renamed from: l */
                public void mo25807l() {
                }
            };
            int a2 = C4960j.m20728a(context, a, bVar, r1, null);
            if (a2 == 1) {
                makeText = Toast.makeText(context, "开始下载", 0);
            } else if (a2 == 2) {
                makeText = Toast.makeText(context, "正在下载，请稍后", 0);
            } else if (a2 == 3) {
                makeText = Toast.makeText(context, "已经下载，开始安装", 0);
            } else {
                if (a2 == 4) {
                    makeText = Toast.makeText(context, "已经安装，打开该应用", 0);
                }
            }
            makeText.show();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    private void m19944a(C4850h hVar, int i, int i2) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("请求珊瑚广告,taskType：");
        sb.append(i);
        C5205o.m21462a(sb.toString());
        CoinRequestInfo coinRequestInfo = new CoinRequestInfo();
        coinRequestInfo.accountId = this.f15640a;
        coinRequestInfo.loginKey = this.f15641b;
        ArrayList arrayList = new ArrayList();
        Coin coin = new Coin();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(i));
        int GetTasks = this.f15646g.GetTasks(coinRequestInfo, arrayList2, coin, arrayList);
        if (GetTasks != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("拉取珊瑚任务失败：");
            sb2.append(GetTasks);
            str = sb2.toString();
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(AD_KEY.AD_NUM.name(), i2);
            bundle.putString(AD_KEY.AD_CHANNEL_NO.name(), C5237f.m21578b(C5233e.m21559b()));
            AdConfig adConfig = new AdConfig(i, bundle);
            C5123d d = C5125f.m21216a().mo26727d();
            AdRequestData simplePositionAdConfig = AdConfigManager.getSimplePositionAdConfig(AdConfigManager.checkParam(adConfig, ((long) (d.mo26700d() > 0 ? d.mo26700d() : 5)) * 1000));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(simplePositionAdConfig.business);
            sb3.append("");
            C4841b a = m19934a(sb3.toString(), simplePositionAdConfig, hVar);
            hVar.f15620b = new ArrayList();
            hVar.f15621c = new HashMap();
            hVar.f15622d = a.f15604b;
            hVar.f15619a = a.f15605c;
            if (a.f15604b == null || !C5188f.m21379b(a.f15603a)) {
                str = "未拿到广告";
            } else {
                C4839a.m19868b((AdMetaInfo) a.f15603a.get(0), null);
                hVar.f15620b.add(a.f15603a.get(0));
                List<AdMetaInfo> list = hVar.f15620b;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("metaInfos json = ");
                sb4.append(C5204n.m21460a(list));
                C5205o.m21462a(sb4.toString());
                CoinTaskType coinTaskType = (CoinTaskType) arrayList.get(0);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("coinTaskType json = ");
                sb5.append(C5204n.m21460a(coinTaskType));
                C5205o.m21462a(sb5.toString());
                Iterator it = coinTaskType.coinTasks.iterator();
                while (it.hasNext()) {
                    CoinTask coinTask = (CoinTask) it.next();
                    if (coinTask.task_status == 1) {
                        if (!C5188f.m21377a((Collection) list)) {
                            for (AdMetaInfo adMetaInfo : list) {
                                if (!hVar.f15621c.containsKey(adMetaInfo)) {
                                    hVar.f15621c.put(adMetaInfo, coinTask);
                                    hVar.f15620b.add(adMetaInfo);
                                }
                            }
                        }
                    }
                }
                return;
            }
        }
        C5205o.m21462a(str);
    }

    /* renamed from: a */
    private void m19945a(C4850h hVar, AdMetaInfo adMetaInfo) {
        String sb;
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(hVar.f15621c.get(adMetaInfo));
            CoinRequestInfo coinRequestInfo = new CoinRequestInfo();
            coinRequestInfo.accountId = this.f15640a;
            coinRequestInfo.loginKey = this.f15641b;
            ArrayList arrayList2 = new ArrayList();
            int SubmitBatchTask = this.f15646g.SubmitBatchTask(coinRequestInfo, arrayList, new Coin(), arrayList2);
            String str = "submit result error code: ";
            if (SubmitBatchTask == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(((SubmitResultItem) arrayList2.get(0)).errorCode);
                sb2.append("; add coin：");
                sb2.append(((SubmitResultItem) arrayList2.get(0)).coinNum);
                sb = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(SubmitBatchTask);
                sb = sb3.toString();
            }
            C5205o.m21462a(sb);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    private void m19946a(C4850h hVar, String str) {
        String str2;
        String str3;
        StringBuilder sb;
        if (C5188f.m21377a((Collection) hVar.f15620b)) {
            C5205o.m21462a("原生下载组装视频失败，没有拿到offer");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdMetaInfo adMetaInfo : hVar.f15620b) {
            if (adMetaInfo != null) {
                if (C5207q.m21478b((CharSequence) C4839a.m19870d(adMetaInfo))) {
                    arrayList.add(C4839a.m19870d(adMetaInfo));
                }
                if (C5207q.m21478b((CharSequence) adMetaInfo.title)) {
                    arrayList2.add(adMetaInfo.title);
                }
            }
        }
        C4840a c = new C4840a().mo25844a(C5233e.m21558a().mo26928c()).mo25847c(str);
        if (C5188f.m21379b(arrayList)) {
            c.mo25845a((List<String>) arrayList);
        } else {
            c.mo25846b((List<String>) arrayList2);
        }
        Map map = (Map) c.mo26659b();
        String str4 = null;
        if (!C5188f.m21378a(map)) {
            Iterator it = map.entrySet().iterator();
            String str5 = null;
            while (it.hasNext() && (C5207q.m21476a((CharSequence) str4) || C5207q.m21476a((CharSequence) str5))) {
                Entry entry = (Entry) it.next();
                str4 = (String) entry.getKey();
                str5 = (String) entry.getValue();
            }
            Iterator it2 = hVar.f15620b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                AdMetaInfo adMetaInfo2 = (AdMetaInfo) it2.next();
                boolean b = C5188f.m21379b(arrayList);
                str2 = StorageInterface.KEY_SPLITER;
                str3 = "原生下载组装视频成功：";
                if (b) {
                    if (C5213t.m21487a(C4839a.m19870d(adMetaInfo2), str4)) {
                        C4839a.m19866a(adMetaInfo2, str5);
                        hVar.f15620b = new ArrayList();
                        hVar.f15620b.add(adMetaInfo2);
                        CoinTask coinTask = (CoinTask) hVar.f15621c.get(adMetaInfo2);
                        hVar.f15621c.clear();
                        hVar.f15621c.put(adMetaInfo2, coinTask);
                        hVar.f15624f = true;
                        sb = new StringBuilder();
                        break;
                    }
                } else if (C5213t.m21487a(adMetaInfo2.title, str4)) {
                    C4839a.m19866a(adMetaInfo2, str5);
                    hVar.f15620b = new ArrayList();
                    hVar.f15620b.add(adMetaInfo2);
                    CoinTask coinTask2 = (CoinTask) hVar.f15621c.get(adMetaInfo2);
                    hVar.f15621c.clear();
                    hVar.f15621c.put(adMetaInfo2, coinTask2);
                    hVar.f15624f = true;
                    sb = new StringBuilder();
                    break;
                }
            }
            sb.append(str3);
            sb.append(str4);
            sb.append(str2);
            sb.append(str5);
            C5205o.m21462a(sb.toString());
            return;
        }
        hVar.f15620b = null;
        hVar.f15621c = null;
        throw new C5143a("原生下载组装视频失败，没有在服务器匹配到视频素材");
    }

    /* renamed from: a */
    private void m19948a(Setting setting, int i, String str, int i2, C4850h hVar, C4820a aVar) {
        String str2;
        String str3;
        int i3;
        Setting setting2 = setting;
        C4850h hVar2 = hVar;
        C4820a aVar2 = aVar;
        String str4 = "";
        String str5 = "";
        if (hVar2 != null) {
            try {
                if (hVar2.f15619a) {
                    if (hVar2.f15620b == null || hVar2.f15620b.isEmpty()) {
                        str3 = str4;
                        str2 = str5;
                        i3 = 0;
                    } else {
                        int i4 = !TextUtils.isEmpty(C4839a.m19869c((AdMetaInfo) hVar2.f15620b.get(0))) ? 1 : 2;
                        String d = C4839a.m19870d((AdMetaInfo) hVar2.f15620b.get(0));
                        str2 = ((AdMetaInfo) hVar2.f15620b.get(0)).title;
                        i3 = i4;
                        str3 = d;
                    }
                    AdInfo a = m19939a(hVar2);
                    String str6 = "";
                    C5224e.m21525a().mo26909a(2, 1, "", i, str, setting.getPlacementId(), this.f15642c, this.f15643d, this.f15644e, this.f15645f, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, i3, "", "", "", -1, str3, str2, str6, "", 0, 0);
                    AdInfo adInfo = new AdInfo(a, str6);
                    setting2.setAdObject(hVar2);
                    setting2.setObject3(adInfo);
                    C5205o.m21462a("插屏广告加载成功");
                    if (setting.getInterstitialListener() != null) {
                        setting.getInterstitialListener().onLoaded(setting2);
                        return;
                    }
                    return;
                }
            } catch (Throwable unused) {
                if (aVar2 != null) {
                    aVar2.mo25759a(setting.getThPlacementBean().mo26309h().f15875f, aVar2);
                    return;
                }
                return;
            }
        }
        C5205o.m21462a("插屏广告加载失败");
        C5224e.m21525a().mo26909a(2, 0, "", i, str, setting.getPlacementId(), this.f15642c, this.f15643d, this.f15644e, this.f15645f, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, 0, "", "", "", -1, str4, str5, "", "", 0, 0);
        if (aVar2 != null) {
            aVar2.mo25759a(setting.getThPlacementBean().mo26309h().f15875f, aVar2);
        }
    }

    /* renamed from: b */
    private C4841b m19950b(int i, C4847e eVar) {
        C4841b bVar = new C4841b();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AdID(i, null, 968, 300));
        ADCard aDCard = new ADCard();
        Context b = C5233e.m21559b();
        final C4841b bVar2 = bVar;
        final ADCard aDCard2 = aDCard;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final C4847e eVar2 = eVar;
        C485910 r0 = new AdInfoListener() {
            public void onAdClick(NativeUnifiedADData nativeUnifiedADData) {
                eVar2.mo25855a(nativeUnifiedADData);
            }

            public void onAdError(ADError aDError) {
                C5205o.m21462a(aDError.msg);
                countDownLatch2.countDown();
            }

            public void onAdLoaded(List<AdMetaInfo> list) {
                C4841b bVar = bVar2;
                bVar.f15603a = list;
                bVar.f15604b = aDCard2;
                bVar.f15605c = true;
                countDownLatch2.countDown();
            }

            public void onAdShow() {
                eVar2.mo25854a();
            }

            public void onGDTEventStatusChanged(int i) {
            }
        };
        aDCard.load(b, r0, arrayList);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C5205o.m21464a((Throwable) e);
        }
        return bVar;
    }

    /* renamed from: b */
    private AdMetaInfo m19951b(C4850h hVar, AdInfo adInfo) {
        try {
            if (hVar.f15620b == null || hVar.f15620b.size() <= 0) {
                return null;
            }
            int size = hVar.f15620b.size();
            for (int i = 0; i < size; i++) {
                AdMetaInfo adMetaInfo = (AdMetaInfo) hVar.f15620b.get(i);
                if (C5213t.m21487a(adMetaInfo.icon, adInfo.getIconUrl())) {
                    return adMetaInfo;
                }
            }
            return null;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* renamed from: b */
    private void m19952b(Context context) {
        try {
            C5123d d = C5125f.m21216a().mo26727d();
            if (d != null) {
                this.f15642c = 343;
                this.f15643d = d.mo26711o();
                this.f15644e = d.mo26712p();
                this.f15645f = d.mo26713q();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private void m19953b(C4850h hVar) {
        if (hVar != null) {
            AdMetaInfo c = m19956c(hVar);
            if (c != null) {
                hVar.f15620b.clear();
                hVar.f15620b.add(c);
                return;
            }
            hVar.f15619a = false;
        }
    }

    /* renamed from: c */
    private C4841b m19955c(int i, C4847e eVar) {
        C4841b bVar = new C4841b();
        ADBanner aDBanner = new ADBanner();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AdID(i, null, 968, 300));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final C4841b bVar2 = bVar;
        final ADBanner aDBanner2 = aDBanner;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final C4847e eVar2 = eVar;
        C486011 r0 = new AdInfoListener() {
            public void onAdClick(NativeUnifiedADData nativeUnifiedADData) {
                eVar2.mo25855a(nativeUnifiedADData);
            }

            public void onAdError(ADError aDError) {
                C5205o.m21462a(aDError.msg);
                countDownLatch2.countDown();
            }

            public void onAdLoaded(List<AdMetaInfo> list) {
                C4841b bVar = bVar2;
                bVar.f15603a = list;
                bVar.f15604b = aDBanner2;
                bVar.f15605c = true;
                countDownLatch2.countDown();
            }

            public void onAdShow() {
                eVar2.mo25854a();
            }

            public void onGDTEventStatusChanged(int i) {
            }
        };
        aDBanner.load(r0, arrayList);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C5205o.m21464a((Throwable) e);
        }
        return bVar;
    }

    /* renamed from: c */
    private AdMetaInfo m19956c(C4850h hVar) {
        try {
            List<AdMetaInfo> list = hVar.f15620b;
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (AdMetaInfo adMetaInfo : list) {
                    if (!z && C5207q.m21478b((CharSequence) adMetaInfo.image) && !TextUtils.isEmpty(adMetaInfo.icon)) {
                        z = true;
                        if (!TextUtils.isEmpty(adMetaInfo.image)) {
                            hVar.f15627i.put(C4839a.m19865a(adMetaInfo), adMetaInfo.image);
                            return adMetaInfo;
                        }
                    }
                    if (!TextUtils.isEmpty(adMetaInfo.getDownLoadUrl())) {
                        return adMetaInfo;
                    }
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return null;
    }

    /* renamed from: d */
    private C4841b m19958d(int i, C4847e eVar) {
        C4841b bVar = new C4841b();
        ADNative aDNative = new ADNative();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AdID(i, null, 968, 300));
        List<AdMetaInfo>[] listArr = {null};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final List[] listArr2 = listArr;
        final C4841b bVar2 = bVar;
        final ADNative aDNative2 = aDNative;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final C4847e eVar2 = eVar;
        C486112 r0 = new AdInfoListener() {
            public void onAdClick(NativeUnifiedADData nativeUnifiedADData) {
                eVar2.mo25855a(nativeUnifiedADData);
            }

            public void onAdError(ADError aDError) {
                C5205o.m21462a(aDError.msg);
                countDownLatch2.countDown();
            }

            public void onAdLoaded(List<AdMetaInfo> list) {
                listArr2[0] = list;
                C4841b bVar = bVar2;
                bVar.f15604b = aDNative2;
                bVar.f15605c = true;
                countDownLatch2.countDown();
            }

            public void onAdShow() {
                eVar2.mo25854a();
            }

            public void onGDTEventStatusChanged(int i) {
            }
        };
        aDNative.load(r0, arrayList);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C5205o.m21464a((Throwable) e);
        }
        bVar.f15603a = listArr[0];
        return bVar;
    }

    /* renamed from: e */
    private C4841b m19959e(int i, C4847e eVar) {
        C4841b bVar = new C4841b();
        ADFeed aDFeed = new ADFeed();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AdID(i, null, 968, 300));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final C4841b bVar2 = bVar;
        final ADFeed aDFeed2 = aDFeed;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final C4847e eVar2 = eVar;
        C486213 r0 = new AdInfoListener() {
            public void onAdClick(NativeUnifiedADData nativeUnifiedADData) {
                eVar2.mo25855a(nativeUnifiedADData);
            }

            public void onAdError(ADError aDError) {
                C5205o.m21462a(aDError.msg);
                countDownLatch2.countDown();
            }

            public void onAdLoaded(List<AdMetaInfo> list) {
                C4841b bVar = bVar2;
                bVar.f15603a = list;
                bVar.f15604b = aDFeed2;
                bVar.f15605c = true;
                countDownLatch2.countDown();
            }

            public void onAdShow() {
                eVar2.mo25854a();
            }

            public void onGDTEventStatusChanged(int i) {
            }
        };
        aDFeed.load(r0, arrayList);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C5205o.m21464a((Throwable) e);
        }
        return bVar;
    }

    /* renamed from: f */
    private C4841b m19961f(int i, C4847e eVar) {
        C4841b bVar = new C4841b();
        ADScreen aDScreen = new ADScreen();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AdID(i, null, 968, 300));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final C4841b bVar2 = bVar;
        final ADScreen aDScreen2 = aDScreen;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final C4847e eVar2 = eVar;
        C48632 r0 = new AdInfoListener() {
            public void onAdClick(NativeUnifiedADData nativeUnifiedADData) {
                eVar2.mo25855a(nativeUnifiedADData);
            }

            public void onAdError(ADError aDError) {
                C5205o.m21462a(aDError.msg);
                countDownLatch2.countDown();
            }

            public void onAdLoaded(List<AdMetaInfo> list) {
                C4841b bVar = bVar2;
                bVar.f15603a = list;
                bVar.f15604b = aDScreen2;
                bVar.f15605c = true;
                countDownLatch2.countDown();
            }

            public void onAdShow() {
                eVar2.mo25854a();
            }

            public void onGDTEventStatusChanged(int i) {
            }
        };
        aDScreen.load(r0, arrayList);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C5205o.m21464a((Throwable) e);
        }
        return bVar;
    }

    /* renamed from: g */
    private C4841b m19962g(int i, C4847e eVar) {
        C4841b bVar = new C4841b();
        ADSplashImage aDSplashImage = new ADSplashImage();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AdID(i, null, 968, 300));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final C4841b bVar2 = bVar;
        final ADSplashImage aDSplashImage2 = aDSplashImage;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final C4847e eVar2 = eVar;
        C48643 r0 = new AdInfoListener() {
            public void onAdClick(NativeUnifiedADData nativeUnifiedADData) {
                C5205o.m21461a();
                eVar2.mo25855a(nativeUnifiedADData);
            }

            public void onAdError(ADError aDError) {
                C5205o.m21462a(aDError.msg);
                countDownLatch2.countDown();
            }

            public void onAdLoaded(List<AdMetaInfo> list) {
                C4841b bVar = bVar2;
                bVar.f15603a = list;
                bVar.f15604b = aDSplashImage2;
                bVar.f15605c = true;
                countDownLatch2.countDown();
            }

            public void onAdShow() {
                C5205o.m21461a();
                eVar2.mo25854a();
            }

            public void onGDTEventStatusChanged(int i) {
            }
        };
        aDSplashImage.load(r0, arrayList);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C5205o.m21464a((Throwable) e);
        }
        return bVar;
    }

    /* renamed from: a */
    public C4850h mo25868a(Context context, String str, int i, int i2, boolean z) {
        String str2;
        C5123d d = C5125f.m21216a().mo26727d();
        if (d != null && d.mo26715s() == 0) {
            str2 = "珊瑚请求失败，策略禁止请求广告";
        } else if (!C4853i.f15634a) {
            str2 = "珊瑚请求失败，珊瑚未初始化";
        } else {
            C4850h hVar = new C4850h();
            hVar.f15619a = false;
            m19952b(context);
            this.f15640a = C5191i.m21387a(context);
            this.f15641b = C5238g.m21604a(context);
            StringBuilder sb = new StringBuilder();
            sb.append("s imei = ");
            sb.append(C5191i.m21416s(context));
            C5205o.m21462a(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("s guiid = ");
            sb2.append(TMSDKContext.getGUID());
            C5205o.m21462a(sb2.toString());
            if (i == 104 || z) {
                try {
                    i2 = C5125f.m21216a().mo26727d().mo26686N();
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                    try {
                        if (th.toString().contains("getGuid()")) {
                            C4853i.m19921a().mo25864a(context);
                        }
                    } catch (Throwable unused) {
                        C5205o.m21464a(th);
                    }
                    return hVar;
                }
            }
            m19944a(hVar, i, i2);
            if (hVar.f15622d == null || C5188f.m21377a((Collection) hVar.f15620b)) {
                C5205o.m21462a("没有拿到珊瑚的广告");
                return null;
            }
            if (z) {
                m19946a(hVar, str);
            }
            if (hVar.f15619a) {
                if (hVar.f15622d != null) {
                    hVar.f15619a = true;
                    return hVar;
                }
            }
            C5205o.m21462a("no offers");
            return null;
        }
        C5205o.m21462a(str2);
        return null;
    }

    /* renamed from: a */
    public AdMetaInfo mo25869a(C4850h hVar, C4879b bVar) {
        try {
            if (hVar.f15620b == null || hVar.f15620b.size() <= 0) {
                return null;
            }
            int size = hVar.f15620b.size();
            for (int i = 0; i < size; i++) {
                AdMetaInfo adMetaInfo = (AdMetaInfo) hVar.f15620b.get(i);
                if (C5213t.m21487a(C4839a.m19870d(adMetaInfo), bVar.mo25904a()) && C5213t.m21487a(adMetaInfo.icon, bVar.mo25920g())) {
                    return adMetaInfo;
                }
            }
            return null;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* renamed from: a */
    public void mo25870a(int i, AdMetaInfo adMetaInfo, String str, C4850h hVar) {
        if (adMetaInfo == null || adMetaInfo.getAdDisplayModel() == null) {
            C5205o.m21464a((Throwable) new C5143a("珊瑚统计事件上报失败，AdMetaInfo和内部AdDisplayModel对象不能为null"));
            return;
        }
        if (hVar.f15624f) {
            C4839a.m19866a(adMetaInfo, null);
        }
        if (i == 3) {
            C4845c.m19895e(adMetaInfo);
        } else if (i == 5) {
            C4845c.m19890a(adMetaInfo);
        } else if (i == 6) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            C4845c.m19891a(adMetaInfo, str);
        } else if (i == 7) {
            C4845c.m19893c(adMetaInfo);
        } else if (i == 8) {
            try {
                C4845c.m19894d(adMetaInfo);
                m19945a(hVar, adMetaInfo);
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }

    /* renamed from: a */
    public void mo25871a(Setting setting, int i) {
        try {
            if (setting.getRegViewContainer() != null) {
                if (setting.getRegViewGroup() != null) {
                    C5205o.m21462a("s native registerAd");
                    final C4911e a = C5229d.m21541a().mo26916a(setting.getThPlacementBean());
                    a.f15872c = C5229d.m21541a().mo26915a(setting);
                    C4850h hVar = (C4850h) setting.getAdObject();
                    final AdInfo adInfo = (AdInfo) setting.getObject3();
                    final AdMetaInfo b = m19951b(hVar, adInfo);
                    ADDownLoad aDDownLoad = (ADDownLoad) hVar.f15622d;
                    final Setting setting2 = setting;
                    final int i2 = i;
                    final C4850h hVar2 = hVar;
                    C48707 r2 = new C4847e() {
                        /* renamed from: a */
                        public void mo25854a() {
                            C5205o.m21462a("珊瑚native show");
                            C5224e.m21525a().mo26909a(4, 1, "", a.f15870a, a.f15871b, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i2, 2, C4839a.m19865a(b), "", "", -1, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), "", 0, 0);
                            if (setting2.getAdListener() != null) {
                                setting2.getAdListener().onShowed();
                            }
                        }

                        /* renamed from: a */
                        public void mo25855a(NativeUnifiedADData nativeUnifiedADData) {
                            C4839a.m19868b(b, null);
                            C5205o.m21462a("珊瑚native click");
                            C5224e.m21525a().mo26909a(5, 1, "", a.f15870a, a.f15871b, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i2, 2, C4839a.m19865a(b), "", "", -1, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), "", 0, 0);
                            if (setting2.getAdListener() != null) {
                                setting2.getAdListener().onClicked();
                            }
                            C4857j.this.m19943a(C5233e.m21559b(), setting2, a, i2, (C5183b) null);
                            new C4849g(((AdMetaInfo) hVar2.f15620b.get(0)).title, C4839a.m19870d((AdMetaInfo) hVar2.f15620b.get(0))).mo26660c();
                        }
                    };
                    hVar.mo25862a((C4847e) r2);
                    NativeAdContainer regViewContainer = setting.getRegViewContainer();
                    regViewContainer.allowAddView = false;
                    aDDownLoad.registerViewForInteraction((AdMetaInfo) hVar.f15620b.get(0), regViewContainer, setting.getRegViewGroup());
                    regViewContainer.allowAddView = true;
                    return;
                }
            }
            C5205o.m21462a("s native not set viewgroup or clickviewlist");
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo25872a(Setting setting, int i, String str, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("s video show thPlacementId = ");
        sb.append(str);
        C5205o.m21462a(sb.toString());
        C5205o.m21462a("s video show");
        final C4850h hVar = (C4850h) setting.getObject3();
        final C4933e eVar = (C4933e) setting.getAdObject();
        final C4958h c = eVar.mo26149c();
        final int i3 = hVar.f15624f ? 3 : TextUtils.isEmpty(eVar.mo26149c().mo26239l()) ? 2 : 1;
        final String e = TextUtils.isEmpty(eVar.mo26149c().mo26225e()) ? "0" : eVar.mo26149c().mo26225e();
        final C4911e h = setting.getThPlacementBean().mo26309h();
        eVar.mo26152f().mo26181c(false);
        ADDownLoad aDDownLoad = (ADDownLoad) hVar.f15622d;
        final boolean[] zArr = {false};
        hVar.mo25862a((C4847e) new C4847e() {
            /* renamed from: a */
            public void mo25854a() {
                C5205o.m21462a("珊瑚原生组装视频:onAdShow");
                zArr[0] = true;
            }

            /* renamed from: a */
            public void mo25855a(NativeUnifiedADData nativeUnifiedADData) {
                C5205o.m21462a("珊瑚原生组装视频:onAdClick");
                if (eVar.mo26152f().f16013a) {
                    C5205o.m21462a("珊瑚原生组装视频，web点击，已经处理过了，直接return");
                    return;
                }
                C5205o.m21462a("珊瑚原生组装视频，非web点击，处理");
                eVar.mo26152f().getPlayerEventListener().mo26159b(null, true);
                new C4849g(((AdMetaInfo) hVar.f15620b.get(0)).title, C4839a.m19870d((AdMetaInfo) hVar.f15620b.get(0))).mo26660c();
            }
        });
        C4942g f = eVar.mo26152f();
        f.allowAddView = false;
        aDDownLoad.registerViewForInteraction((AdMetaInfo) hVar.f15620b.get(0), eVar.mo26152f(), eVar.mo26152f().getClickViewGroup());
        f.allowAddView = true;
        final int i4 = i;
        final String str2 = str;
        final Setting setting2 = setting;
        final int i5 = i2;
        C48676 r1 = r2;
        final C4933e eVar2 = eVar;
        C48676 r2 = new C4827e() {
            /* renamed from: a */
            public void mo25787a() {
                C5205o.m21462a("s video showed");
                C5224e.m21525a().mo26909a(4, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onShowed();
                }
                C5208r.m21480a(new Runnable() {
                    public void run() {
                        if (!zArr[0]) {
                            C4857j.this.mo25870a(3, C4857j.this.m19940a(hVar, eVar2), "", hVar);
                        }
                    }
                }, 300);
            }

            /* renamed from: a */
            public void mo25788a(int i) {
                int i2 = i;
                C5205o.m21462a("s cls btn click");
                if (i2 == 1) {
                    C5224e.m21525a().mo26909a(5004, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                }
                if (i2 == 2) {
                    C5224e.m21525a().mo26909a(5006, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                }
            }

            /* renamed from: a */
            public void mo25789a(int i, C5183b bVar) {
                C5205o.m21462a("s video click");
                if (C4857j.this.f15647h != null) {
                    if (((AdMetaInfo) C4857j.this.f15647h.get(setting2)) == null) {
                        if (!hVar.f15625g) {
                            C5205o.m21462a("s sh dip < ");
                            hVar.f15625g = true;
                        }
                        C5205o.m21462a("s sh v no ck");
                        C4857j.this.f15647h.put(setting2, C4857j.this.m19940a(hVar, eVar2));
                    } else {
                        C5205o.m21462a("s sh v has ck");
                    }
                }
                if (i == 2) {
                    C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_INVALID, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                }
            }

            /* renamed from: a */
            public void mo25790a(String str) {
                C5205o.m21462a("s video download start");
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onDownloadStarted(str);
                }
                C4857j.this.mo25870a(5, C4857j.this.m19940a(hVar, eVar2), "", hVar);
            }

            /* renamed from: a */
            public void mo25791a(String str, String str2) {
                String str3 = str2;
                C5205o.m21462a("s video download finish");
                C5224e.m21525a().mo26909a(6, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onDownloadFinished(str, str3);
                } else {
                    String str4 = str;
                }
                AdMetaInfo a = C4857j.this.m19940a(hVar, eVar2);
                AdMetaInfo adMetaInfo = a;
                C4857j.this.mo25870a(6, a, str3, hVar);
                AdMetaInfo adMetaInfo2 = a;
                C5005h.m20951a().mo26405a(adMetaInfo, (CoinTask) hVar.f15621c.get(a), eVar2.mo26149c().mo26235j(), eVar2.mo26149c().mo26233i(), eVar2.mo26149c().mo26231h(), str, str2, 1, 0, h.f15870a, h.f15871b, setting2.getPlacementId(), String.valueOf(setting2.getAdType()), i5, C4839a.m19865a(adMetaInfo2), eVar2.mo26149c().mo26248t(), 3, null);
                AdMetaInfo adMetaInfo3 = adMetaInfo2;
                String str5 = str;
                C5005h.m20951a().mo26400a(C5233e.m21559b(), i4, setting2.getAdType(), str5, c.mo26235j(), c.mo26233i(), c.mo26231h(), "", c.mo26214a(), c.mo26227f(), adMetaInfo3, (CoinTask) hVar.f15621c.get(adMetaInfo3));
            }

            /* renamed from: b */
            public void mo25792b() {
                C5205o.m21462a("s video close");
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onClosed();
                }
            }

            /* renamed from: b */
            public void mo25793b(int i) {
                int i2 = i;
                if (i2 == 0 || i2 == 25 || i2 == 50 || i2 == 75 || i2 == 100) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("s percent = ");
                    sb.append(i2);
                    C5205o.m21462a(sb.toString());
                    int i3 = 0;
                    if (i2 == 0) {
                        i3 = 1100;
                    }
                    if (i2 == 25) {
                        i3 = 1101;
                    }
                    if (i2 == 50) {
                        i3 = 1102;
                    }
                    if (i2 == 75) {
                        i3 = 1103;
                    }
                    C5224e.m21525a().mo26909a(i2 == 100 ? 1104 : i3, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                }
            }

            /* renamed from: b */
            public void mo25794b(String str) {
                String str2 = str;
                StringBuilder sb = new StringBuilder();
                sb.append("s pg pol: ");
                sb.append(str2);
                C5205o.m21462a(sb.toString());
                if (str2.startsWith("video://retain.close")) {
                    C5224e.m21525a().mo26909a(5006, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                } else if (str2.startsWith("video://download")) {
                    if (!eVar2.f15966c) {
                        C5224e.m21525a().mo26909a(5003, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                        eVar2.f15966c = true;
                    }
                } else if (str2.startsWith("video://retain.download") && !eVar2.f15967d) {
                    C5224e.m21525a().mo26909a(5005, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                    eVar2.f15967d = true;
                }
            }

            /* renamed from: b */
            public void mo25795b(String str, String str2) {
                final String str3 = str;
                final String str4 = str2;
                C5205o.m21462a("s video installed");
                C5224e.m21525a().mo26909a(7, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onInstalled(str3, str4);
                }
                final AdMetaInfo a = C4857j.this.m19940a(hVar, eVar2);
                C4857j.this.mo25870a(7, a, str4, hVar);
                C5005h.m20951a().mo26406a(eVar2.mo26149c().mo26229g(), 2, 0, (C5134a) null);
                C5208r.m21483b(new Runnable() {
                    public void run() {
                        if (!C4857j.this.mo25874a(C5233e.m21559b())) {
                            C5005h.m20951a().mo26405a(a, (CoinTask) hVar.f15621c.get(a), eVar2.mo26149c().mo26235j(), eVar2.mo26149c().mo26233i(), eVar2.mo26149c().mo26231h(), str3, str4, 2, 0, h.f15870a, h.f15871b, setting2.getPlacementId(), String.valueOf(setting2.getAdType()), i5, C4839a.m19865a(a), eVar2.mo26149c().mo26248t(), 3, null);
                        } else if (hVar.f15626h.compareAndSet(false, true)) {
                            C4857j.this.mo25870a(8, a, "", hVar);
                            C5224e.m21525a().mo26909a(8001, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                            C5005h.m20951a().mo26406a(eVar2.mo26149c().mo26229g(), 2, 1, (C5134a) null);
                        }
                    }
                }, (long) (C5125f.m21216a().mo26727d().mo26681I() * 1000));
            }

            /* renamed from: c */
            public void mo25796c() {
                C5205o.m21462a("s video complete");
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onVideoComplete();
                }
            }

            /* renamed from: c */
            public void mo25797c(int i) {
                int i2 = i;
                long u = (long) C5125f.m21216a().mo26727d().mo26717u();
                if (u <= 0) {
                    u = 10;
                }
                long j = (long) i2;
                if (j >= u * 1000 && j < (u + 1) * 1000) {
                    if (!eVar2.f15968e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("s zz pl ");
                        sb.append(i2);
                        C5205o.m21462a(sb.toString());
                        eVar2.f15968e = true;
                        C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_PARAM_INVALID, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                    }
                    if (!hVar.f15625g) {
                        C5205o.m21462a("s sh dip > ");
                        hVar.f15625g = true;
                    }
                }
            }

            /* renamed from: d */
            public void mo25798d() {
                C5224e.m21525a().mo26909a(9, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
            }

            /* renamed from: d */
            public void mo25799d(int i) {
                if (i == 1) {
                    C5205o.m21462a("s dp close");
                    C5224e.m21525a().mo26909a(5008, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                }
            }

            /* renamed from: e */
            public void mo25800e() {
            }

            /* renamed from: f */
            public void mo25801f() {
                C5205o.m21462a("s end page show");
                String str = "";
                C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_PRODUCT_INVALID, 1, str, i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", Math.round(((float) eVar2.mo26150d()) / 1000.0f), Math.round(((float) eVar2.mo26151e()) / 1000.0f));
                if (C5125f.m21216a().mo26727d().mo26697a() && C5207q.m21478b((CharSequence) setting2.getUserId())) {
                    new C5222c().mo26896d(c.mo26229g()).mo26894a(i4).mo26895c(setting2.getPlacementId()).mo26897e(setting2.getUserId()).mo26898f(setting2.getUuid()).mo26660c();
                }
            }

            /* renamed from: g */
            public void mo25802g() {
                C5205o.m21462a("s retain page show");
                C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_ACCOUNT_INVALID, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
            }

            /* renamed from: h */
            public void mo25803h() {
                C5205o.m21462a("s jump click");
                C5224e.m21525a().mo26909a(5002, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
            }

            /* renamed from: i */
            public void mo25804i() {
            }

            /* renamed from: j */
            public void mo25805j() {
                C5205o.m21462a("s video active");
                if (hVar.f15626h.compareAndSet(false, true)) {
                    C4857j.this.mo25870a(8, C4857j.this.m19940a(hVar, eVar2), "", hVar);
                    C5005h.m20951a().mo26406a(eVar2.mo26149c().mo26229g(), 2, 1, (C5134a) null);
                }
                C5224e.m21525a().mo26909a(8, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
            }

            /* renamed from: k */
            public void mo25806k() {
                if (!eVar2.f15965b) {
                    C5205o.m21462a("s bn click");
                    C5224e.m21525a().mo26909a(5001, 1, "", i4, str2, setting2.getPlacementId(), C4857j.this.f15642c, C4857j.this.f15643d, C4857j.this.f15644e, C4857j.this.f15645f, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i5, i3, e, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", "", 0, 0);
                    eVar2.f15965b = true;
                }
            }

            /* renamed from: l */
            public void mo25807l() {
            }
        };
        eVar.mo26146a((C4827e) r1, setting.getOrientation());
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0218  */
    /* renamed from: a */
    public void mo25873a(com.p368pw.p392us.Setting r37, int r38, java.lang.String r39, int r40, com.p368pw.inner.p369a.C4819a.C4820a r41) {
        /*
        r36 = this;
        r7 = r36
        r0 = r37
        r8 = r41
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "s video load thPlacementId = "
        r1.append(r2)
        r14 = r39
        r1.append(r14)
        java.lang.String r1 = r1.toString()
        com.p368pw.inner.base.p387d.C5205o.m21462a(r1)
        java.lang.String r3 = r37.getPlacementId()
        com.pw.inner.a.g r1 = r37.getThPlacementBean()
        com.pw.inner.a.e r15 = r1.mo26309h()
        boolean r2 = com.p368pw.inner.p369a.p370a.p373c.C4853i.f15634a
        if (r2 != 0) goto L_0x0039
        java.lang.String r0 = "加载腾讯珊瑚sdk视频广告失败，珊瑚未初始化"
        com.p368pw.inner.base.p387d.C5205o.m21462a(r0)
        if (r8 == 0) goto L_0x0038
        int r0 = r15.f15875f
        r8.mo25759a(r0, r8)
    L_0x0038:
        return
    L_0x0039:
        com.pw.inner.base.a.f r2 = com.p368pw.inner.base.p384a.C5125f.m21216a()
        com.pw.inner.base.a.d r35 = r2.mo26727d()
        int r1 = r1.mo26310i()     // Catch:{ all -> 0x0211 }
        r2 = 2
        r13 = 0
        r9 = 0
        if (r1 != r2) goto L_0x004d
        r1 = r13
        r2 = 0
        goto L_0x006b
    L_0x004d:
        android.content.Context r2 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0211 }
        int r1 = r35.mo26698b()     // Catch:{ all -> 0x0211 }
        r4 = 1
        if (r1 != r4) goto L_0x005d
        r1 = 103(0x67, float:1.44E-43)
        r4 = 103(0x67, float:1.44E-43)
        goto L_0x0061
    L_0x005d:
        r1 = 134(0x86, float:1.88E-43)
        r4 = 134(0x86, float:1.88E-43)
    L_0x0061:
        r5 = 6
        r10 = 1
        r1 = r36
        r6 = r10
        com.pw.inner.a.a.c.h r1 = r1.mo25868a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0211 }
        r2 = 1
    L_0x006b:
        if (r1 == 0) goto L_0x01a9
        boolean r4 = r1.f15619a     // Catch:{ all -> 0x0211 }
        if (r4 != 0) goto L_0x0073
        goto L_0x01a9
    L_0x0073:
        com.pw.inner.a.e.h r4 = r7.m19938a(r1, r0, r15)     // Catch:{ all -> 0x0211 }
        if (r4 != 0) goto L_0x00e4
        java.lang.String r1 = "加载珊瑚视频广告失败:过滤后为null"
        com.p368pw.inner.base.p387d.C5205o.m21462a(r1)     // Catch:{ all -> 0x0211 }
        com.pw.inner.base.stat.e r1 = com.p368pw.inner.base.stat.C5224e.m21525a()     // Catch:{ all -> 0x0211 }
        r10 = 2
        r11 = 0
        java.lang.String r12 = ""
        java.lang.String r4 = r37.getPlacementId()     // Catch:{ all -> 0x0211 }
        int r5 = r7.f15642c     // Catch:{ all -> 0x0211 }
        int r6 = r7.f15643d     // Catch:{ all -> 0x0211 }
        int r13 = r7.f15644e     // Catch:{ all -> 0x0211 }
        int r3 = r7.f15645f     // Catch:{ all -> 0x0211 }
        r20 = 0
        java.lang.String r21 = r37.getUuid()     // Catch:{ all -> 0x0211 }
        int r0 = r37.getAdType()     // Catch:{ all -> 0x0211 }
        java.lang.String r22 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0211 }
        if (r2 == 0) goto L_0x00a5
        r24 = 3
        goto L_0x00a7
    L_0x00a5:
        r24 = 0
    L_0x00a7:
        java.lang.String r25 = ""
        int r0 = r15.f15873d     // Catch:{ all -> 0x0211 }
        java.lang.String r26 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0211 }
        int r0 = r15.f15874e     // Catch:{ all -> 0x0211 }
        java.lang.String r27 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0211 }
        r28 = -1
        java.lang.String r29 = ""
        java.lang.String r30 = ""
        java.lang.String r31 = ""
        java.lang.String r32 = ""
        r33 = 0
        r34 = 0
        r9 = r1
        r0 = r13
        r13 = r38
        r14 = r39
        r1 = r15
        r15 = r4
        r16 = r5
        r17 = r6
        r18 = r0
        r19 = r3
        r23 = r40
        r9.mo26909a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x00e0 }
        if (r8 == 0) goto L_0x00df
        int r0 = r1.f15875f     // Catch:{ all -> 0x00e0 }
        r8.mo25759a(r0, r8)     // Catch:{ all -> 0x00e0 }
    L_0x00df:
        return
    L_0x00e0:
        r0 = move-exception
        r3 = r1
        goto L_0x0213
    L_0x00e4:
        r3 = r15
        java.lang.String r5 = "TxMng"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x020f }
        r6.<init>()     // Catch:{ all -> 0x020f }
        java.lang.String r10 = "加载广告成功，是否来自缓存？"
        r6.append(r10)     // Catch:{ all -> 0x020f }
        boolean r10 = r1.f15623e     // Catch:{ all -> 0x020f }
        r6.append(r10)     // Catch:{ all -> 0x020f }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x020f }
        com.p368pw.inner.base.p387d.C5205o.m21463a(r5, r6)     // Catch:{ all -> 0x020f }
        com.pw.inner.base.stat.e r5 = com.p368pw.inner.base.stat.C5224e.m21525a()     // Catch:{ all -> 0x020f }
        r10 = 2
        java.lang.String r12 = ""
        java.lang.String r15 = r37.getPlacementId()     // Catch:{ all -> 0x020f }
        int r6 = r7.f15642c     // Catch:{ all -> 0x020f }
        int r11 = r7.f15643d     // Catch:{ all -> 0x020f }
        r18 = r11
        int r11 = r7.f15644e     // Catch:{ all -> 0x020f }
        r19 = r11
        int r11 = r7.f15645f     // Catch:{ all -> 0x020f }
        r20 = 0
        java.lang.String r21 = r37.getUuid()     // Catch:{ all -> 0x020f }
        int r22 = r37.getAdType()     // Catch:{ all -> 0x020f }
        java.lang.String r22 = java.lang.String.valueOf(r22)     // Catch:{ all -> 0x020f }
        if (r2 == 0) goto L_0x0127
        r24 = 3
        goto L_0x0129
    L_0x0127:
        r24 = 0
    L_0x0129:
        java.lang.String r25 = r4.mo26225e()     // Catch:{ all -> 0x020f }
        int r9 = r3.f15873d     // Catch:{ all -> 0x020f }
        java.lang.String r26 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x020f }
        int r9 = r3.f15874e     // Catch:{ all -> 0x020f }
        java.lang.String r27 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x020f }
        r28 = -1
        java.lang.String r29 = r4.mo26229g()     // Catch:{ all -> 0x020f }
        java.lang.String r30 = r4.mo26235j()     // Catch:{ all -> 0x020f }
        java.lang.String r31 = ""
        java.lang.String r32 = ""
        r33 = 0
        r34 = 0
        r9 = r5
        r17 = r18
        r18 = r19
        r5 = 1
        r19 = r11
        r11 = r5
        r5 = r13
        r13 = r38
        r14 = r39
        r16 = r6
        r23 = r40
        r9.mo26909a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x020f }
        com.pw.inner.a.g r6 = r37.getThPlacementBean()     // Catch:{ all -> 0x020f }
        com.pw.inner.a.e.e r9 = new com.pw.inner.a.e.e     // Catch:{ all -> 0x020f }
        android.content.Context r10 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x020f }
        r9.m49014init(r10)     // Catch:{ all -> 0x020f }
        r9.f15964a = r2     // Catch:{ all -> 0x020f }
        int r18 = r35.mo26689Q()     // Catch:{ all -> 0x020f }
        int r19 = r6.mo26307f()     // Catch:{ all -> 0x020f }
        int r20 = r6.mo26308g()     // Catch:{ all -> 0x020f }
        int r21 = r35.mo26696X()     // Catch:{ all -> 0x020f }
        r16 = r9
        r17 = r4
        r16.mo26147a(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x020f }
        r0.setAdObject(r9)     // Catch:{ all -> 0x020f }
        r0.setObject3(r1)     // Catch:{ all -> 0x020f }
        if (r2 == 0) goto L_0x0195
        android.content.Context r1 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x020f }
        r9.mo26145a(r1, r5)     // Catch:{ all -> 0x020f }
    L_0x0195:
        java.lang.String r1 = "s load vd success"
        com.p368pw.inner.base.p387d.C5205o.m21462a(r1)     // Catch:{ all -> 0x020f }
        com.pw.us.IRewardAdListener r1 = r37.getIRewardAdListener()     // Catch:{ all -> 0x020f }
        if (r1 == 0) goto L_0x021d
        com.pw.us.IRewardAdListener r1 = r37.getIRewardAdListener()     // Catch:{ all -> 0x020f }
        r1.onLoaded(r0)     // Catch:{ all -> 0x020f }
        goto L_0x021d
    L_0x01a9:
        r3 = r15
        java.lang.String r1 = "加载珊瑚视频广告失败"
        com.p368pw.inner.base.p387d.C5205o.m21462a(r1)     // Catch:{ all -> 0x020f }
        com.pw.inner.base.stat.e r1 = com.p368pw.inner.base.stat.C5224e.m21525a()     // Catch:{ all -> 0x020f }
        r10 = 2
        r11 = 0
        java.lang.String r12 = ""
        java.lang.String r15 = r37.getPlacementId()     // Catch:{ all -> 0x020f }
        int r4 = r7.f15642c     // Catch:{ all -> 0x020f }
        int r5 = r7.f15643d     // Catch:{ all -> 0x020f }
        int r6 = r7.f15644e     // Catch:{ all -> 0x020f }
        int r13 = r7.f15645f     // Catch:{ all -> 0x020f }
        r20 = 0
        java.lang.String r21 = r37.getUuid()     // Catch:{ all -> 0x020f }
        int r0 = r37.getAdType()     // Catch:{ all -> 0x020f }
        java.lang.String r22 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x020f }
        if (r2 == 0) goto L_0x01d6
        r24 = 3
        goto L_0x01d8
    L_0x01d6:
        r24 = 0
    L_0x01d8:
        java.lang.String r25 = ""
        int r0 = r3.f15873d     // Catch:{ all -> 0x020f }
        java.lang.String r26 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x020f }
        int r0 = r3.f15874e     // Catch:{ all -> 0x020f }
        java.lang.String r27 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x020f }
        r28 = -1
        java.lang.String r29 = ""
        java.lang.String r30 = ""
        java.lang.String r31 = ""
        java.lang.String r32 = ""
        r33 = 0
        r34 = 0
        r9 = r1
        r0 = r13
        r13 = r38
        r14 = r39
        r16 = r4
        r17 = r5
        r18 = r6
        r19 = r0
        r23 = r40
        r9.mo26909a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x020f }
        if (r8 == 0) goto L_0x020e
        int r0 = r3.f15875f     // Catch:{ all -> 0x020f }
        r8.mo25759a(r0, r8)     // Catch:{ all -> 0x020f }
    L_0x020e:
        return
    L_0x020f:
        r0 = move-exception
        goto L_0x0213
    L_0x0211:
        r0 = move-exception
        r3 = r15
    L_0x0213:
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
        if (r8 == 0) goto L_0x021d
        int r0 = r3.f15875f
        r8.mo25759a(r0, r8)
    L_0x021d:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.p369a.p370a.p373c.C4857j.mo25873a(com.pw.us.Setting, int, java.lang.String, int, com.pw.inner.a.a$a):void");
    }

    /* renamed from: a */
    public boolean mo25874a(Context context) {
        try {
            return C4822b.m19710a(1, 11) <= C5125f.m21216a().mo26727d().mo26682J();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    /* renamed from: b */
    public void mo25875b() {
        try {
            this.f15646g = (CoinManager) ManagerCreator.getManager(CoinManager.class);
            this.f15647h = new HashMap<>();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    public void mo25876b(Setting setting, int i, String str, int i2) {
        Setting setting2 = setting;
        try {
            C5205o.m21462a("s ins show");
            if (setting2 != null) {
                C4879b a = m19936a((C4850h) setting.getAdObject(), setting2);
                C4880c.m20089a().mo25951a(setting, a, i, str, i2);
                String placementId = setting.getPlacementId();
                int i3 = this.f15642c;
                int i4 = this.f15643d;
                int i5 = this.f15644e;
                C5224e.m21525a().mo26909a(3, 1, "", i, str, placementId, i3, i4, i5, this.f15645f, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, a.mo25941r(), a.mo25910c(), "", "", -1, a.mo25904a(), a.mo25913d(), a.mo25928k(), "", 0, 0);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    public void mo25877b(Setting setting, int i, String str, int i2, C4820a aVar) {
        Setting setting2 = setting;
        C4820a aVar2 = aVar;
        C5205o.m21461a();
        C4911e h = setting.getThPlacementBean().mo26309h();
        if (!C4853i.f15634a) {
            if (aVar2 != null) {
                aVar2.mo25759a(h.f15875f, aVar2);
            }
            return;
        }
        C4850h a = mo25868a(C5233e.m21559b(), setting.getPlacementId(), C5125f.m21216a().mo26727d().mo26698b() == 1 ? 103 : 134, 2, false);
        if (a != null) {
            try {
                if (a.f15619a) {
                    C5205o.m21462a("珊瑚原生下载广告拉取成功");
                    AdInfo a2 = m19939a(a);
                    String imageUrl = a2.getImageUrl();
                    C5224e.m21525a().mo26909a(2, 1, "", i, str, setting.getPlacementId(), this.f15642c, this.f15643d, this.f15644e, this.f15645f, 0, setting.getUuid(), String.valueOf(setting.getAdType()), 300, 2, "", "", "", -1, a2.getPkgName(), a2.getTitle(), imageUrl, "", 0, 0);
                    if (C5207q.m21476a((CharSequence) a2.getBtnText())) {
                        a2.setBtnText("查看");
                    }
                    setting2.setAdObject(a);
                    setting2.setObject3(a2);
                    if (setting.getAdListener() != null) {
                        setting.getAdListener().onLoaded(a2, setting2);
                    }
                    return;
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
                if (aVar2 != null) {
                    aVar2.mo25759a(h.f15875f, aVar2);
                }
            }
        }
        C5205o.m21462a("珊瑚原生下载广告拉取失败");
        C5224e.m21525a().mo26909a(2, 0, "", i, str, setting.getPlacementId(), this.f15642c, this.f15643d, this.f15644e, this.f15645f, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, 2, "", "", "", -1, "", "", "", "", 0, 0);
        if (aVar2 != null) {
            aVar2.mo25759a(h.f15875f, aVar2);
        }
    }

    /* renamed from: c */
    public void mo25878c(Setting setting, int i, String str, int i2, C4820a aVar) {
        int i3;
        try {
            C5205o.m21462a("s interstital load");
            C5123d d = C5125f.m21216a().mo26727d();
            if (d.mo26683K() == 1) {
                i3 = d.mo26698b() == 1 ? 103 : 134;
            } else {
                i3 = 102;
            }
            C4911e h = setting.getThPlacementBean().mo26309h();
            if (!C4853i.f15634a) {
                if (aVar != null) {
                    aVar.mo25759a(h.f15875f, aVar);
                }
                return;
            }
            C4850h a = mo25868a(C5233e.m21559b(), setting.getPlacementId(), i3, 2, false);
            m19953b(a);
            m19948a(setting, i, str, i2, a, aVar);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: d */
    public void mo25879d(Setting setting, int i, String str, int i2, C4820a aVar) {
        int i3;
        C4820a aVar2 = aVar;
        C4911e h = setting.getThPlacementBean().mo26309h();
        try {
            C5205o.m21461a();
            C5123d d = C5125f.m21216a().mo26727d();
            if (d.mo26684L() == 1) {
                i3 = d.mo26698b() == 1 ? 103 : 134;
            } else {
                i3 = 102;
            }
            if (!C4853i.f15634a) {
                if (aVar2 != null) {
                    aVar2.mo25759a(h.f15875f, aVar2);
                }
                return;
            }
            C4850h a = mo25868a(C5233e.m21559b(), setting.getPlacementId(), i3, 2, false);
            try {
                m19953b(a);
                m19942a(C5233e.m21559b(), setting, i, str, i2, a, aVar);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            C5205o.m21464a(th);
            if (aVar2 != null) {
                aVar2.mo25759a(h.f15875f, aVar2);
            }
        }
    }
}
