package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.diskcache.p322b.C4079a;
import com.kwad.sdk.core.diskcache.p322b.C4080b.C4082a;
import com.kwad.sdk.core.download.C4100d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p330f.C4111a;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.p333g.C4149f;
import com.kwad.sdk.core.request.C4259b;
import com.kwad.sdk.core.request.C4283f;
import com.kwad.sdk.export.p347i.IAdRequestManager;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import com.kwad.sdk.export.proxy.AdJumpProxy;
import com.kwad.sdk.export.proxy.AdLocationProxy;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.p306a.C3807j;

public class KsAdSDK {
    private static AdInstallProxy mAdInstallProxy = null;
    private static AdJumpProxy mAdJumpProxy = null;
    private static AdRequestExtentParamsProxy mAdRequestExtentParamsProxy = null;
    private static IAdRequestManager mAdRequestManager = null;
    private static Context mAppContext = null;
    private static String mAppId = null;
    private static String mAppName = null;
    private static AdDownloadProxy mDownloadProxy = null;
    private static boolean mEnableDebug = false;
    private static AdHttpProxy mHttpProxy = null;
    private static volatile boolean mIsSdkInit = false;
    private static AdLocationProxy mLocationProxy;

    public static void deleteCache() {
        C4079a.m16947a().mo23763c();
    }

    public static IAdRequestManager getAdManager() {
        C3807j.m15782a(Boolean.valueOf(!mIsSdkInit), "sdk must be init first");
        if (mAdRequestManager == null) {
            mAdRequestManager = new C4259b();
        }
        return mAdRequestManager;
    }

    public static String getAppId() {
        if (!TextUtils.isEmpty(mAppId)) {
            return mAppId;
        }
        String format = String.format("[%s]", new Object[]{"KSAdSDK_2.6.5.2"});
        StringBuilder sb = new StringBuilder();
        sb.append("sdk is not init mAppId is empty:");
        sb.append(mIsSdkInit);
        C4065b.m16869d(format, sb.toString());
        return "";
    }

    public static String getAppName() {
        return mAppName;
    }

    public static Context getContext() {
        if (!mIsSdkInit) {
            String str = "getContext sdk is not init";
            C4065b.m16864a(String.format("[%s]", new Object[]{"KSAdSDK_2.6.5.2"}), str, new RuntimeException().fillInStackTrace());
        }
        return mAppContext;
    }

    public static AdInstallProxy getProxyForAdInstall() {
        AdInstallProxy adInstallProxy = mAdInstallProxy;
        return adInstallProxy != null ? adInstallProxy : C3794a.m15725b();
    }

    public static AdLocationProxy getProxyForAdLocation() {
        return mLocationProxy;
    }

    public static AdDownloadProxy getProxyForDownload() {
        return mDownloadProxy;
    }

    public static AdHttpProxy getProxyForHttp() {
        AdHttpProxy adHttpProxy = mHttpProxy;
        return adHttpProxy != null ? adHttpProxy : C3794a.m15723a();
    }

    public static AdRequestExtentParamsProxy getRequestExtentParamsProxy() {
        return mAdRequestExtentParamsProxy;
    }

    public static String getSDKVersion() {
        return "2.6.5.2";
    }

    public static void init(Context context, SdkConfig sdkConfig) {
        C3807j.m15783a((Object) context, "context must not be null");
        C3807j.m15783a((Object) sdkConfig, "config must not be null");
        C3807j.m15784a(sdkConfig.appId, "appId must not be null");
        mAppContext = context.getApplicationContext();
        mEnableDebug = sdkConfig.enableDebug;
        mAppId = sdkConfig.appId;
        mAppName = sdkConfig.appName;
        C4111a.m17074a(mAppContext);
        initSdkLog();
        initHttpProxy(sdkConfig);
        initInstallProxy(sdkConfig);
        initDownloadProxy(mAppContext, sdkConfig);
        initJumpProxy(sdkConfig);
        initLocationProxy(sdkConfig);
        initRequestExtentParamsProxy(sdkConfig);
        initDiskCache(mAppContext);
        initImageLoader(mAppContext);
        C4149f.m17182a(mAppContext);
        C4145c.m17153a();
        C4065b.m16863a("init", "HOST=https://open.e.kuaishou.com");
        mIsSdkInit = true;
        C4283f.m17560a(mAppContext);
    }

    private static void initDiskCache(Context context) {
        C4079a.m16947a().mo23758a(new C4082a(context).mo23764a(1).mo23766a(C3794a.m15726b(context)).mo23765a(200).mo23767a());
    }

    private static void initDownloadProxy(Context context, SdkConfig sdkConfig) {
        mDownloadProxy = sdkConfig.downloadProxy != null ? sdkConfig.downloadProxy : C3794a.m15722a(context, mAdInstallProxy, sdkConfig.showNotification);
    }

    private static void initHttpProxy(SdkConfig sdkConfig) {
        mHttpProxy = sdkConfig.httpProxy != null ? sdkConfig.httpProxy : C3794a.m15723a();
    }

    private static void initImageLoader(Context context) {
        KSImageLoader.init(context);
    }

    private static void initInstallProxy(SdkConfig sdkConfig) {
        mAdInstallProxy = sdkConfig.installProxy != null ? sdkConfig.installProxy : C3794a.m15725b();
    }

    private static void initJumpProxy(SdkConfig sdkConfig) {
        mAdJumpProxy = sdkConfig.jumpProxy;
    }

    private static void initLocationProxy(SdkConfig sdkConfig) {
        mLocationProxy = sdkConfig.locationProxy;
    }

    private static void initRequestExtentParamsProxy(SdkConfig sdkConfig) {
        mAdRequestExtentParamsProxy = sdkConfig.adRequestExtentParamsProxy;
    }

    private static void initSdkLog() {
        Context context = mAppContext;
        C4065b.m16862a(context, "KSAdSDK_2.6.5.2", mEnableDebug, false, C3794a.m15727c(context));
    }

    public static boolean isDebugLogEnable() {
        return mEnableDebug;
    }

    public static void unInit() {
        C4100d.m17028a(getContext());
    }
}
