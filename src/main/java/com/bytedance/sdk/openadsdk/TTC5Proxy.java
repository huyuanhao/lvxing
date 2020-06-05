package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener;
import com.bytedance.sdk.openadsdk.component.p166a.FeedAdManager;

public class TTC5Proxy {
    public static void loadFeed(Context context, AdSlot adSlot, FeedAdListener feedAdListener) {
        FeedAdManager.m8531a().mo15043a(context, adSlot, feedAdListener);
    }

    public static void loadDraw(Context context, AdSlot adSlot, DrawFeedAdListener drawFeedAdListener) {
        FeedAdManager.m8531a().mo15042a(context, adSlot, drawFeedAdListener);
    }
}
