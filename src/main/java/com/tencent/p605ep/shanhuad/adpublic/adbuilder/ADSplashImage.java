package com.tencent.p605ep.shanhuad.adpublic.adbuilder;

import android.view.ViewGroup;
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

/* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADSplashImage */
public class ADSplashImage extends C8676b {
    /* renamed from: gk */
    protected AdInfoListener f24760gk;

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.ADSplashImage$AdListenerImpl */
    public class AdListenerImpl implements AdListener {
        public AdListenerImpl() {
        }

        public void onAdClicked(AdDisplayModel adDisplayModel) {
            AdInfoListener adInfoListener = ADSplashImage.this.f24760gk;
            if (adInfoListener != null) {
                adInfoListener.onAdClick(null);
            }
        }

        public void onAdClose(AdDisplayModel adDisplayModel) {
        }

        public void onAdLoaded(C7479Ad ad) {
            ADSplashImage aDSplashImage = ADSplashImage.this;
            if (aDSplashImage.f24760gk != null) {
                aDSplashImage.model = C8677c.m37687a(ad, false);
                if (ADSplashImage.this.model != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new AdMetaInfo(ADSplashImage.this.model));
                    ADSplashImage.this.f24760gk.onAdLoaded(arrayList);
                    return;
                }
                ADSplashImage.this.f24760gk.onAdError((ADError) C8675a.f29514ck.get(Integer.valueOf(100)));
            }
        }

        public void onAdShow(AdDisplayModel adDisplayModel) {
            AdInfoListener adInfoListener = ADSplashImage.this.f24760gk;
            if (adInfoListener != null) {
                adInfoListener.onAdShow();
            }
        }

        public void onError(C7479Ad ad, int i) {
            AdInfoListener adInfoListener = ADSplashImage.this.f24760gk;
            if (adInfoListener != null) {
                adInfoListener.onAdError((ADError) C8675a.f29514ck.get(Integer.valueOf(100)));
            }
        }
    }

    public void load(AdInfoListener adInfoListener, List<AdID> list) {
        this.f24760gk = adInfoListener;
        super.mo41444a(C8680f.m37693b(list, 1, 1), new AdListenerImpl());
    }

    public void registerViewForInteraction(ViewGroup viewGroup) {
        NativeAdList nativeAdList = this.f29515dk;
        if (nativeAdList != null) {
            AdDisplayModel adDisplayModel = this.model;
            if (adDisplayModel != null && viewGroup != null) {
                nativeAdList.registerViewForInteraction(viewGroup, adDisplayModel);
            }
        }
    }
}
