package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.InitHelper;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.InitChecker;
import com.bytedance.sdk.openadsdk.utils.Predicate;
import java.util.concurrent.atomic.AtomicBoolean;

public final class TTAdSdk {
    /* renamed from: a */
    private static AtomicBoolean f6413a = new AtomicBoolean(false);

    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        Predicate.m12255a((Object) context, "Context is null, please check.");
        Predicate.m12255a((Object) tTAdConfig, "TTAdConfig is null, please check.");
        if (!f6413a.get()) {
            m7995a(context, tTAdConfig);
            f6413a.set(true);
        }
        return getAdManager();
    }

    public static TTAdManager getAdManager() {
        return TTAdManagerFactory.m7994a();
    }

    /* renamed from: a */
    private static void m7995a(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig.getHttpStack() != null) {
            TTNetClient.m11429a(tTAdConfig.getHttpStack());
        }
        InitHelper.f7724a = tTAdConfig.isAsyncInit();
        InitHelper.f7725b = tTAdConfig.getCustomController();
        if (tTAdConfig.isDebug()) {
            C2564t.m12218b();
        }
        TTAdManager instance = TTAdManagerFactory.getInstance(context, tTAdConfig.isSupportMultiProcess());
        if (tTAdConfig.isDebug()) {
            instance.openDebugMode();
        }
        instance.setAppId(tTAdConfig.getAppId()).setName(tTAdConfig.getAppName()).setPaid(tTAdConfig.isPaid()).setKeywords(tTAdConfig.getKeywords()).setData(tTAdConfig.getData()).setTitleBarTheme(tTAdConfig.getTitleBarTheme()).setAllowShowNotifiFromSDK(tTAdConfig.isAllowShowNotify()).setAllowLandingPageShowWhenScreenLock(tTAdConfig.isAllowShowPageWhenScreenLock()).setDirectDownloadNetworkType(tTAdConfig.getDirectDownloadNetworkType()).isUseTextureView(tTAdConfig.isUseTextureView()).setTTDownloadEventLogger(tTAdConfig.getTTDownloadEventLogger()).setNeedClearTaskReset(tTAdConfig.getNeedClearTaskReset()).setTTSecAbs(tTAdConfig.getTTSecAbs()).setCustomController(tTAdConfig.getCustomController());
        try {
            InitChecker.m12193a();
        } catch (Throwable unused) {
        }
    }
}
