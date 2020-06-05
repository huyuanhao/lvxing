package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener;
import com.bytedance.sdk.openadsdk.component.splash.SplashAdLoadManager;
import com.bytedance.sdk.openadsdk.component.splash.SplashUtils;

public class TTC2Proxy {
    public static void load(Context context, AdSlot adSlot, SplashAdListener splashAdListener, int i) {
        SplashAdLoadManager.m8915a(context).mo15247a(adSlot, splashAdListener, i);
    }

    /* renamed from: a */
    public static void m7996a(Context context) {
        SplashUtils.m8965a(context);
    }
}
