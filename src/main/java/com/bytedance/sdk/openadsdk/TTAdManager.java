package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;

public interface TTAdManager {
    TTAdNative createAdNative(Context context);

    @Deprecated
    TTGlobalAppDownloadController getGlobalAppDownloadController(Context context);

    String getSDKVersion();

    @Deprecated
    TTAdManager isUseTextureView(boolean z);

    boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4);

    @Deprecated
    TTAdManager openDebugMode();

    void requestPermissionIfNecessary(Context context);

    @Deprecated
    TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z);

    @Deprecated
    TTAdManager setAllowShowNotifiFromSDK(boolean z);

    @Deprecated
    TTAdManager setAppId(String str);

    @Deprecated
    TTAdManager setCustomController(TTCustomController tTCustomController);

    @Deprecated
    TTAdManager setData(String str);

    @Deprecated
    TTAdManager setDirectDownloadNetworkType(int... iArr);

    @Deprecated
    TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener);

    @Deprecated
    TTAdManager setKeywords(String str);

    @Deprecated
    TTAdManager setName(String str);

    @Deprecated
    TTAdManager setNeedClearTaskReset(String[] strArr);

    @Deprecated
    TTAdManager setPaid(boolean z);

    @Deprecated
    TTAdManager setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger);

    @Deprecated
    TTAdManager setTTSecAbs(TTSecAbs tTSecAbs);

    @Deprecated
    TTAdManager setTitleBarTheme(int i);

    boolean tryShowInstallDialogWhenExit(Context context, ExitInstallListener exitInstallListener);
}
