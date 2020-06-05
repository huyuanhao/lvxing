package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener;
import com.bytedance.sdk.openadsdk.component.interaction.InteractionAdManager;

public class TTC4Proxy {
    public static void load(Context context, AdSlot adSlot, InteractionAdListener interactionAdListener) {
        InteractionAdManager.m8633a().mo15084a(context, adSlot, interactionAdListener);
    }
}
