package com.tencent.p605ep.shanhuad.adpublic.adbuilder;

import android.content.Context;
import android.view.ViewGroup;
import com.p522qq.p523e.ads.nativ.NativeADEventListener;
import com.p522qq.p523e.ads.nativ.NativeADUnifiedListener;
import com.p522qq.p523e.ads.nativ.NativeUnifiedAD;
import com.p522qq.p523e.ads.nativ.NativeUnifiedADData;
import com.p522qq.p523e.ads.nativ.widget.NativeAdContainer;
import com.p522qq.p523e.comm.util.AdError;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.p605ep.shanhuad.adpublic.ADError;
import com.tencent.p605ep.shanhuad.adpublic.models.AdID;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdListener;
import com.tencent.qqpim.discovery.C7479Ad;
import com.tencent.qqpim.discovery.NativeAdList;
import java.util.ArrayList;
import java.util.List;
import shanhuAD.C8675a;
import shanhuAD.C8676b;
import shanhuAD.C8677c;
import shanhuAD.C8680f;

/* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADCard */
public class ADCard extends C8676b {
    /* access modifiers changed from: private */
    /* renamed from: fk */
    public NativeUnifiedAD f24751fk;
    /* access modifiers changed from: private */
    /* renamed from: gk */
    public AdInfoListener f24752gk;
    /* access modifiers changed from: private */
    /* renamed from: hk */
    public String f24753hk;
    /* access modifiers changed from: private */
    /* renamed from: ik */
    public String f24754ik;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int positionId;

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADCard$AdListenerImpl */
    public class AdListenerImpl implements AdListener {
        public AdListenerImpl() {
        }

        public void onAdClicked(AdDisplayModel adDisplayModel) {
            if (ADCard.this.f24752gk != null) {
                ADCard.this.f24752gk.onAdClick(null);
            }
        }

        public void onAdClose(AdDisplayModel adDisplayModel) {
        }

        public void onAdLoaded(C7479Ad ad) {
            C8677c.m37689a(((NativeAdList) ad).getAds(), ADCard.this.f29516ek);
            if (ADCard.this.f24752gk != null) {
                AdDisplayModel a = C8677c.m37687a(ad, true);
                if (a != null && a.sdkADRequest && a.sdkType == 2) {
                    ADCard.this.f24753hk = a.sdkParamappid;
                    ADCard.this.f24754ik = a.sdkPosId;
                    ADCard.this.positionId = a.positionId;
                    ADCard aDCard = ADCard.this;
                    aDCard.f24751fk = new NativeUnifiedAD(aDCard.mContext, a.sdkParamappid, a.sdkPosId, new NativeADUnifiedListenerImpl());
                    ADCard.this.f24751fk.loadData(a.sdkgdtPosAmount);
                    ADCard aDCard2 = ADCard.this;
                    aDCard2.mo41443a(10, true, "", aDCard2.f24754ik, ADCard.this.f24753hk, 0.0d, ADCard.this.positionId);
                    ADCard.this.model = a;
                } else if (ADCard.this.f24752gk != null) {
                    ADCard.this.f24752gk.onAdError((ADError) C8675a.f29514ck.get(Integer.valueOf(100)));
                }
            }
        }

        public void onAdShow(AdDisplayModel adDisplayModel) {
            if (ADCard.this.f24752gk != null) {
                ADCard.this.f24752gk.onAdShow();
            }
        }

        public void onError(C7479Ad ad, int i) {
            if (ADCard.this.f24752gk != null) {
                ADCard.this.f24752gk.onAdError((ADError) C8675a.f29514ck.get(Integer.valueOf(100)));
            }
        }
    }

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADCard$NativeADEventListenerImpl */
    private class NativeADEventListenerImpl implements NativeADEventListener {
        private NativeUnifiedADData mNativeUnifiedADData;

        public void onADClicked() {
            ADCard aDCard = ADCard.this;
            aDCard.mo41443a(6, true, "", aDCard.f24754ik, ADCard.this.f24753hk, (double) this.mNativeUnifiedADData.getECPM(), ADCard.this.positionId);
            if (ADCard.this.f24752gk != null) {
                ADCard.this.f24752gk.onAdClick(this.mNativeUnifiedADData);
            }
        }

        public void onADError(AdError adError) {
            ADCard.this.mo41443a(0, false, adError.getErrorMsg(), ADCard.this.f24754ik, ADCard.this.f24753hk, (double) this.mNativeUnifiedADData.getECPM(), ADCard.this.positionId);
            if (ADCard.this.f24752gk != null) {
                ADError aDError = (ADError) C8675a.f29514ck.get(Integer.valueOf(101));
                StringBuilder sb = new StringBuilder();
                sb.append(aDError.msg);
                sb.append(" gdt code ");
                sb.append(adError.getErrorCode());
                sb.append(" , gdt msg ");
                sb.append(adError.getErrorMsg());
                aDError.msg = sb.toString();
                ADCard.this.f24752gk.onAdError(aDError);
            }
        }

        public void onADExposed() {
            if (ADCard.this.f24752gk != null) {
                ADCard.this.f24752gk.onAdShow();
            }
            ADCard aDCard = ADCard.this;
            aDCard.mo41443a(4, true, "", aDCard.f24754ik, ADCard.this.f24753hk, (double) this.mNativeUnifiedADData.getECPM(), ADCard.this.positionId);
        }

        public void onADStatusChanged() {
            StringBuilder sb = new StringBuilder();
            sb.append("onADStatusChanged : ");
            sb.append(this.mNativeUnifiedADData.getAppStatus());
            Log.m31477d("GDTEvent", sb.toString());
            if (ADCard.this.f24752gk != null) {
                int appStatus = this.mNativeUnifiedADData.getAppStatus();
                ADCard.this.f24752gk.onGDTEventStatusChanged(appStatus);
                ADCard aDCard = ADCard.this;
                aDCard.mo41442a(appStatus, aDCard.f24754ik, ADCard.this.f24753hk, ADCard.this.positionId);
            }
        }

        private NativeADEventListenerImpl(NativeUnifiedADData nativeUnifiedADData) {
            this.mNativeUnifiedADData = nativeUnifiedADData;
        }
    }

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADCard$NativeADUnifiedListenerImpl */
    private class NativeADUnifiedListenerImpl implements NativeADUnifiedListener {
        private NativeADUnifiedListenerImpl() {
        }

        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list != null && list.size() > 0 && ADCard.this.f24752gk != null) {
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    nativeUnifiedADData.getECPM();
                    if (nativeUnifiedADData.getAdPatternType() != 2) {
                        AdMetaInfo adMetaInfo = new AdMetaInfo();
                        adMetaInfo.icon = nativeUnifiedADData.getIconUrl();
                        adMetaInfo.title = nativeUnifiedADData.getTitle();
                        adMetaInfo.desc = nativeUnifiedADData.getDesc();
                        adMetaInfo.image = nativeUnifiedADData.getImgUrl();
                        adMetaInfo.cta = nativeUnifiedADData.getCTAText();
                        adMetaInfo.imageList = nativeUnifiedADData.getImgList();
                        adMetaInfo.mNativeUnifiedADData = nativeUnifiedADData;
                        arrayList.add(adMetaInfo);
                    }
                }
                ADCard.this.f24752gk.onAdLoaded(arrayList);
                ADCard aDCard = ADCard.this;
                aDCard.mo41443a(1, true, "", aDCard.f24754ik, ADCard.this.f24753hk, 0.0d, ADCard.this.positionId);
            }
        }

        public void onNoAD(AdError adError) {
            Log.m31477d("ADCard", adError.getErrorMsg());
            ADCard.this.mo41443a(9, false, adError.getErrorMsg(), ADCard.this.f24754ik, ADCard.this.f24753hk, 0.0d, ADCard.this.positionId);
            if (ADCard.this.f24752gk != null) {
                ADError aDError = (ADError) C8675a.f29514ck.get(Integer.valueOf(101));
                StringBuilder sb = new StringBuilder();
                sb.append(aDError.msg);
                sb.append(" gdt code ");
                sb.append(adError.getErrorCode());
                sb.append(" , gdt msg ");
                sb.append(adError.getErrorMsg());
                aDError.msg = sb.toString();
                ADCard.this.f24752gk.onAdError(aDError);
            }
        }
    }

    public void load(Context context, AdInfoListener adInfoListener, List<AdID> list) {
        this.mContext = context;
        this.f24752gk = adInfoListener;
        super.mo41444a(C8680f.m37693b(list, 8, 1), new AdListenerImpl());
    }

    public void registerViewForInteraction(AdMetaInfo adMetaInfo, NativeAdContainer nativeAdContainer, ViewGroup viewGroup) {
        NativeUnifiedADData nativeUnifiedADData = adMetaInfo.mNativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            m31532a(nativeAdContainer, nativeUnifiedADData, viewGroup);
        }
    }

    /* renamed from: a */
    private void m31532a(NativeAdContainer nativeAdContainer, NativeUnifiedADData nativeUnifiedADData, ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewGroup);
        nativeUnifiedADData.bindAdToView(this.mContext, nativeAdContainer, null, arrayList);
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListenerImpl(nativeUnifiedADData));
    }
}
