package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.m */
public class TTNativeExpressDrawVideoAdImpl extends TTNativeExpressVideoAdImpl {
    public TTNativeExpressDrawVideoAdImpl(Context context, MaterialMeta kVar, AdSlot adSlot) {
        super(context, kVar, adSlot);
    }

    /* renamed from: a */
    public void mo15911a(Context context, MaterialMeta kVar, AdSlot adSlot) {
        String str = "draw_ad";
        this.f7853d = str;
        this.f7850a = new NativeExpressVideoView(context, kVar, adSlot, str);
        mo15912a(this.f7850a, this.f7852c);
    }

    public void setCanInterruptVideoPlay(boolean z) {
        if (this.f7850a != null) {
            ((NativeExpressVideoView) this.f7850a).setCanInterruptVideoPlay(z);
        }
    }
}
