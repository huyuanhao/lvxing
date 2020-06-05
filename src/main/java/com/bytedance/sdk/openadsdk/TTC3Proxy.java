package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener;
import com.bytedance.sdk.openadsdk.component.reward.FullScreenVideoLoadManager;
import com.bytedance.sdk.openadsdk.component.reward.PlayableVerityHelper;
import com.bytedance.sdk.openadsdk.component.reward.RewardVideoLoadManager;

public class TTC3Proxy {
    public static void verityPlayable(String str, int i, String str2, String str3, String str4) {
        PlayableVerityHelper.m8718a(str, i, str2, str3, str4);
    }

    public static void loadReward(Context context, AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener) {
        RewardVideoLoadManager.m8752a(context).mo15140a(adSlot, rewardVideoAdListener);
    }

    public static void loadFull(Context context, AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener) {
        FullScreenVideoLoadManager.m8697a(context).mo15115a(adSlot, fullScreenVideoAdListener);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
    /* renamed from: a */
    public static void m7997a(android.content.Context r1) {
        /*
        com.bytedance.sdk.openadsdk.component.reward.g r0 = com.bytedance.sdk.openadsdk.component.reward.RewardVideoLoadManager.m8752a(r1)     // Catch:{ all -> 0x0007 }
        r0.mo15143b()     // Catch:{ all -> 0x0007 }
    L_0x0007:
        com.bytedance.sdk.openadsdk.component.reward.c r1 = com.bytedance.sdk.openadsdk.component.reward.FullScreenVideoLoadManager.m8697a(r1)     // Catch:{ all -> 0x000e }
        r1.mo15113a()     // Catch:{ all -> 0x000e }
    L_0x000e:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.TTC3Proxy.m7997a(android.content.Context):void");
    }
}
