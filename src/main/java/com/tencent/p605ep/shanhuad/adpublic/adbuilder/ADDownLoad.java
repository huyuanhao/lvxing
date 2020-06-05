package com.tencent.p605ep.shanhuad.adpublic.adbuilder;

import android.content.Context;
import android.view.View;
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

/* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADDownLoad */
public class ADDownLoad extends C8676b {
    /* access modifiers changed from: private */
    /* renamed from: fk */
    public NativeUnifiedAD f24755fk;
    /* access modifiers changed from: private */
    /* renamed from: gk */
    public AdInfoListener f24756gk;
    /* access modifiers changed from: private */
    /* renamed from: hk */
    public String f24757hk;
    /* access modifiers changed from: private */
    /* renamed from: ik */
    public String f24758ik;
    /* renamed from: jk */
    private int f24759jk;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int positionId;

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADDownLoad$AdListenerImpl */
    public class AdListenerImpl implements AdListener {
        public AdListenerImpl() {
        }

        public void onAdClicked(AdDisplayModel adDisplayModel) {
            if (ADDownLoad.this.f24756gk != null) {
                ADDownLoad.this.f24756gk.onAdClick(null);
            }
        }

        public void onAdClose(AdDisplayModel adDisplayModel) {
        }

        public void onAdLoaded(C7479Ad ad) {
            C8677c.m37689a(((NativeAdList) ad).getAds(), ADDownLoad.this.f29516ek);
            if (ADDownLoad.this.f24756gk != null) {
                List<AdDisplayModel> a = C8677c.m37688a(ad);
                if (a.size() == 1 && ((AdDisplayModel) a.get(0)).sdkADRequest && ((AdDisplayModel) a.get(0)).sdkType == 2) {
                    ADDownLoad aDDownLoad = ADDownLoad.this;
                    aDDownLoad.f24755fk = new NativeUnifiedAD(aDDownLoad.mContext, ((AdDisplayModel) a.get(0)).sdkParamappid, ((AdDisplayModel) a.get(0)).sdkPosId, new NativeADUnifiedListenerImpl());
                    ADDownLoad.this.f24757hk = ((AdDisplayModel) a.get(0)).sdkParamappid;
                    ADDownLoad.this.f24758ik = ((AdDisplayModel) a.get(0)).sdkPosId;
                    ADDownLoad.this.positionId = ((AdDisplayModel) a.get(0)).positionId;
                    ADDownLoad.this.f24755fk.loadData(((AdDisplayModel) a.get(0)).sdkgdtPosAmount);
                    ADDownLoad aDDownLoad2 = ADDownLoad.this;
                    aDDownLoad2.mo41443a(10, true, "", aDDownLoad2.f24758ik, ADDownLoad.this.f24757hk, 0.0d, ADDownLoad.this.positionId);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (AdDisplayModel adMetaInfo : a) {
                    arrayList.add(new AdMetaInfo(adMetaInfo));
                }
                ADDownLoad.this.f24756gk.onAdLoaded(arrayList);
            }
        }

        public void onAdShow(AdDisplayModel adDisplayModel) {
            if (ADDownLoad.this.f24756gk != null) {
                ADDownLoad.this.f24756gk.onAdShow();
            }
        }

        public void onError(C7479Ad ad, int i) {
            if (ADDownLoad.this.f24756gk != null) {
                ADDownLoad.this.f24756gk.onAdError((ADError) C8675a.f29514ck.get(Integer.valueOf(100)));
            }
        }
    }

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADDownLoad$NativeADEventListenerImpl */
    private class NativeADEventListenerImpl implements NativeADEventListener {
        private NativeUnifiedADData mNativeUnifiedADData;

        public void onADClicked() {
            ADDownLoad aDDownLoad = ADDownLoad.this;
            aDDownLoad.mo41443a(6, true, "", aDDownLoad.f24758ik, ADDownLoad.this.f24757hk, (double) this.mNativeUnifiedADData.getECPM(), ADDownLoad.this.positionId);
            if (ADDownLoad.this.f24756gk != null) {
                ADDownLoad.this.f24756gk.onAdClick(this.mNativeUnifiedADData);
            }
        }

        public void onADError(AdError adError) {
            ADDownLoad.this.mo41443a(0, false, adError.getErrorMsg(), ADDownLoad.this.f24758ik, ADDownLoad.this.f24757hk, (double) this.mNativeUnifiedADData.getECPM(), ADDownLoad.this.positionId);
            if (ADDownLoad.this.f24756gk != null) {
                ADError aDError = (ADError) C8675a.f29514ck.get(Integer.valueOf(101));
                StringBuilder sb = new StringBuilder();
                sb.append(aDError.msg);
                sb.append(" gdt code ");
                sb.append(adError.getErrorCode());
                sb.append(" , gdt msg ");
                sb.append(adError.getErrorMsg());
                aDError.msg = sb.toString();
                ADDownLoad.this.f24756gk.onAdError(aDError);
            }
        }

        public void onADExposed() {
            ADDownLoad aDDownLoad = ADDownLoad.this;
            aDDownLoad.mo41443a(4, true, "", aDDownLoad.f24758ik, ADDownLoad.this.f24757hk, (double) this.mNativeUnifiedADData.getECPM(), ADDownLoad.this.positionId);
            if (ADDownLoad.this.f24756gk != null) {
                ADDownLoad.this.f24756gk.onAdShow();
            }
        }

        public void onADStatusChanged() {
            StringBuilder sb = new StringBuilder();
            sb.append("onADStatusChanged : ");
            sb.append(this.mNativeUnifiedADData.getAppStatus());
            Log.m31477d("GDTEvent", sb.toString());
            if (ADDownLoad.this.f24756gk != null) {
                int appStatus = this.mNativeUnifiedADData.getAppStatus();
                ADDownLoad.this.f24756gk.onGDTEventStatusChanged(appStatus);
                ADDownLoad aDDownLoad = ADDownLoad.this;
                aDDownLoad.mo41442a(appStatus, aDDownLoad.f24758ik, ADDownLoad.this.f24757hk, ADDownLoad.this.positionId);
            }
        }

        private NativeADEventListenerImpl(NativeUnifiedADData nativeUnifiedADData) {
            this.mNativeUnifiedADData = nativeUnifiedADData;
        }
    }

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADDownLoad$NativeADUnifiedListenerImpl */
    private class NativeADUnifiedListenerImpl implements NativeADUnifiedListener {
        private NativeADUnifiedListenerImpl() {
        }

        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list != null && list.size() > 0 && ADDownLoad.this.f24756gk != null) {
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
                        StringBuilder sb = new StringBuilder();
                        sb.append("gdt data : ");
                        sb.append(adMetaInfo.toString());
                        Log.m31477d("ADdownLoad", sb.toString());
                    }
                }
                ADDownLoad.this.f24756gk.onAdLoaded(arrayList);
                ADDownLoad aDDownLoad = ADDownLoad.this;
                aDDownLoad.mo41443a(1, true, "", aDDownLoad.f24758ik, ADDownLoad.this.f24757hk, 0.0d, ADDownLoad.this.positionId);
            }
        }

        public void onNoAD(AdError adError) {
            ADDownLoad.this.mo41443a(9, false, adError.getErrorMsg(), ADDownLoad.this.f24758ik, ADDownLoad.this.f24757hk, 0.0d, ADDownLoad.this.positionId);
            if (ADDownLoad.this.f24756gk != null) {
                ADError aDError = (ADError) C8675a.f29514ck.get(Integer.valueOf(101));
                StringBuilder sb = new StringBuilder();
                sb.append(aDError.msg);
                sb.append(" gdt code ");
                sb.append(adError.getErrorCode());
                sb.append(" , gdt msg ");
                sb.append(adError.getErrorMsg());
                aDError.msg = sb.toString();
                ADDownLoad.this.f24756gk.onAdError(aDError);
            }
        }
    }

    public ADDownLoad(int i) {
        this.f24759jk = i;
    }

    public void load(Context context, AdInfoListener adInfoListener, List<AdID> list) {
        this.mContext = context;
        this.f24756gk = adInfoListener;
        super.mo41444a(C8680f.m37693b(list, 9, this.f24759jk), new AdListenerImpl());
    }

    public void registerViewForInteraction(AdMetaInfo adMetaInfo, NativeAdContainer nativeAdContainer, ViewGroup viewGroup) {
        NativeUnifiedADData nativeUnifiedADData = adMetaInfo.mNativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            m31551a(nativeAdContainer, nativeUnifiedADData, viewGroup);
        } else if (this.f29515dk != null && adMetaInfo != null && adMetaInfo.getAdDisplayModel() != null && viewGroup != null) {
            this.f29515dk.registerViewForInteraction(viewGroup, adMetaInfo.getAdDisplayModel());
        }
    }

    public ADDownLoad() {
        this.f24759jk = 1;
    }

    /* renamed from: a */
    private void m31551a(NativeAdContainer nativeAdContainer, NativeUnifiedADData nativeUnifiedADData, View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        nativeUnifiedADData.bindAdToView(this.mContext, nativeAdContainer, null, arrayList);
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListenerImpl(nativeUnifiedADData));
    }
}
