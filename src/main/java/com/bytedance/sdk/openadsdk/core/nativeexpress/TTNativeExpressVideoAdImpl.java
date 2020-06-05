package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.n */
public class TTNativeExpressVideoAdImpl extends TTNativeExpressAdImpl {
    public TTNativeExpressVideoAdImpl(Context context, MaterialMeta kVar, AdSlot adSlot) {
        super(context, kVar, adSlot);
    }

    /* renamed from: a */
    public void mo15911a(Context context, MaterialMeta kVar, AdSlot adSlot) {
        this.f7850a = new NativeExpressVideoView(context, kVar, adSlot, "embeded_ad");
        mo15912a(this.f7850a, this.f7852c);
    }

    public void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener) {
        if (this.f7850a != null) {
            this.f7850a.setVideoAdListener(expressVideoAdListener);
        }
    }

    public VideoControllerDataModel getVideoModel() {
        if (this.f7850a != null) {
            return ((NativeExpressVideoView) this.f7850a).getVideoModel();
        }
        return null;
    }
}
