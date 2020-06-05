package com.tencent.p605ep.shanhuad.adpublic.adbuilder;

import com.p522qq.p523e.ads.nativ.NativeUnifiedADData;
import com.tencent.p605ep.shanhuad.adpublic.ADError;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import java.util.List;

/* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.AdInfoListener */
public interface AdInfoListener {
    void onAdClick(NativeUnifiedADData nativeUnifiedADData);

    void onAdError(ADError aDError);

    void onAdLoaded(List<AdMetaInfo> list);

    void onAdShow();

    void onGDTEventStatusChanged(int i);
}
