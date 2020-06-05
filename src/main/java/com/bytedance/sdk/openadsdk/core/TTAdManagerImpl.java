package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadController;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.p174h.ISettings;
import com.bytedance.sdk.openadsdk.core.p174h.SdkDnsHelper;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.TTReflectUtils;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.openadsdk.core.v */
public class TTAdManagerImpl implements TTAdManager {
    /* renamed from: a */
    String f7926a = "com.union_test.toutiao";
    /* renamed from: b */
    String f7927b = "5001121";

    public TTGlobalAppDownloadController getGlobalAppDownloadController(Context context) {
        return null;
    }

    public String getSDKVersion() {
        return "2.9.5.5";
    }

    /* renamed from: a */
    public TTAdManagerImpl setAppId(String str) {
        GlobalInfo.m9616c().mo15660a(str);
        SdkDnsHelper.m9732a((ISettings) InternalContainer.m10070i()).mo15746a();
        SdkSettingsHelper.m9740a((ISettings) InternalContainer.m10069h()).mo15749c();
        return this;
    }

    /* renamed from: b */
    public TTAdManagerImpl setName(String str) {
        GlobalInfo.m9616c().mo15666b(str);
        return this;
    }

    /* renamed from: a */
    public TTAdManagerImpl setPaid(boolean z) {
        GlobalInfo.m9616c().mo15661a(z);
        return this;
    }

    /* renamed from: c */
    public TTAdManagerImpl setKeywords(String str) {
        GlobalInfo.m9616c().mo15670c(str);
        return this;
    }

    /* renamed from: d */
    public TTAdManagerImpl setData(String str) {
        GlobalInfo.m9616c().mo15673d(str);
        return this;
    }

    public TTAdManager setTitleBarTheme(int i) {
        GlobalInfo.m9616c().mo15654a(i);
        return this;
    }

    public TTAdManager setAllowShowNotifiFromSDK(boolean z) {
        GlobalInfo.m9616c().mo15667b(z);
        return this;
    }

    public TTAdManager openDebugMode() {
        C2564t.m12218b();
        AdNetSdk.m7651c();
        return this;
    }

    public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z) {
        GlobalInfo.m9616c().mo15671c(z);
        return this;
    }

    public TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        GlobalInfo.m9616c().mo15658a(tTGlobalAppDownloadListener);
        return this;
    }

    public TTAdManager setDirectDownloadNetworkType(int... iArr) {
        GlobalInfo.m9616c().mo15662a(iArr);
        return this;
    }

    public TTAdNative createAdNative(Context context) {
        GlobalInfo.m9616c().mo15685o();
        return new TTAdNativeImpl(context);
    }

    public TTAdManager isUseTextureView(boolean z) {
        GlobalInfo.m9616c().mo15674d(z);
        return this;
    }

    public TTAdManager setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
        GlobalInfo.m9616c().mo15657a(tTDownloadEventLogger);
        return this;
    }

    public TTAdManager setTTSecAbs(TTSecAbs tTSecAbs) {
        GlobalInfo.m9616c().mo15659a(tTSecAbs);
        return this;
    }

    public TTAdManager setCustomController(TTCustomController tTCustomController) {
        GlobalInfo.m9616c().mo15656a(tTCustomController);
        return this;
    }

    public TTAdManager setNeedClearTaskReset(String[] strArr) {
        GlobalInfo.m9616c().mo15663a(strArr);
        return this;
    }

    public void requestPermissionIfNecessary(Context context) {
        TTCustomController d = GlobalInfo.m9616c().mo15672d();
        if (d != null) {
            boolean isCanUseLocation = d.isCanUseLocation();
            boolean isCanUsePhoneState = d.isCanUsePhoneState();
            boolean isCanUseWriteExternal = d.isCanUseWriteExternal();
            if (!isCanUseLocation && !isCanUsePhoneState && !isCanUseWriteExternal) {
                return;
            }
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        if (context != null) {
            ActivityUtil.m12108a(context, intent, null);
        }
    }

    public boolean tryShowInstallDialogWhenExit(Context context, ExitInstallListener exitInstallListener) {
        return TTDownloadFactory.m11074a(context, exitInstallListener);
    }

    public boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (!this.f7926a.equals(InternalContainer.m10059a().getPackageName()) || !this.f7927b.equals(GlobalInfo.m9616c().mo15675e()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Method a = TTReflectUtils.m11989a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
            if (a != null) {
                a.invoke(null, new Object[]{str, Integer.valueOf(i), str2, str3, str4});
            }
        } catch (Throwable th) {
            C2564t.m12221b("TTAdManagerImpl", "reward component maybe not exist, pls check", th);
        }
        return true;
    }
}
