package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.InitHelper;
import com.bytedance.sdk.openadsdk.core.TTAdManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;

@Deprecated
public class TTAdManagerFactory {
    /* renamed from: a */
    private static final TTAdManager f6412a = new TTAdManagerImpl();

    private TTAdManagerFactory() {
    }

    public static TTAdManager getInstance(Context context) {
        return getInstance(context, false);
    }

    public static TTAdManager getInstance(Context context, boolean z) {
        if (z) {
            MultiGlobalInfo.m11807a();
        }
        InitHelper.m9879a(context);
        return f6412a;
    }

    /* renamed from: a */
    static TTAdManager m7994a() {
        return f6412a;
    }
}
