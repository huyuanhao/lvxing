package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.ISensitiveInfoProvider;
import com.bytedance.embedapplog.InitConfig;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.p160c.ITTAdNetDepend;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.p173g.PlayableCache;
import com.bytedance.sdk.openadsdk.core.p174h.ApplistHelper;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.TTMultiInitHelper;
import com.bytedance.sdk.openadsdk.p188g.TTAdNetDepend;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.OAIDHelper;
import com.bytedance.sdk.openadsdk.utils.RomUtils;
import com.bytedance.sdk.openadsdk.utils.TTCrashHandler;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.bytedance.tea.crash.ICommonParams;
import com.bytedance.tea.crash.ICrashFilter;
import com.bytedance.tea.crash.Npth;
import com.tencent.stat.common.DeviceInfo;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Marker;

/* renamed from: com.bytedance.sdk.openadsdk.core.l */
public class InitHelper {
    /* renamed from: a */
    public static volatile boolean f7724a = false;
    /* renamed from: b */
    public static volatile TTCustomController f7725b;
    /* renamed from: c */
    private static AtomicBoolean f7726c = new AtomicBoolean(false);

    /* renamed from: a */
    public static void m9879a(Context context) {
        if (!f7726c.get()) {
            synchronized (TTAdManagerFactory.class) {
                if (!f7726c.get()) {
                    m9883c(context);
                    f7726c.set(true);
                }
            }
        }
    }

    /* renamed from: c */
    private static void m9883c(final Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("init start: ");
        sb.append(f7724a);
        String str = "InitHelper";
        Log.d(str, sb.toString());
        TTExecutor.m11693a(MultiGlobalInfo.m11808b());
        InternalContainer.m10061a(context.getApplicationContext());
        if (SdkSwitch.m9757a()) {
            TTMultiInitHelper.m11863a(context);
            if (f7724a) {
                TTExecutor.m11692a().mo16808c(new Runnable() {
                    public void run() {
                        InitHelper.m9884d(context);
                    }
                }, 10);
            } else {
                m9884d(context);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("init over: ");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            Log.d(str, sb2.toString());
        }
    }

    /* renamed from: a */
    private static void m9878a() {
        if (InternalContainer.m10069h().mo15785e()) {
            Context a = InternalContainer.m10059a();
            if (a != null) {
                try {
                    AdNetSdk.m7646a((ITTAdNetDepend) new TTAdNetDepend(a));
                    AdNetSdk.m7648a(true);
                    AdNetSdk.m7644a(a, (Application) a, MultiGlobalInfo.m11808b());
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: b */
    private static void m9880b() {
        if (VERSION.SDK_INT >= 28) {
            try {
                Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(new Class[]{String.class}).setAccessible(true);
                Class cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
                declaredField.setAccessible(true);
                declaredField.setBoolean(invoke, true);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static void m9884d(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        m9885e(context);
        m9880b();
        m9887g(context);
        TTCrashHandler.m11983a();
        InternalContainer.m10069h().mo15741a();
        UIUtils.m12054a(context);
        m9886f(context);
        InternalContainer.m10064c().mo14997a();
        InternalContainer.m10066e().mo14997a();
        InternalContainer.m10065d().mo14997a();
        InternalContainer.m10071j().mo16615a();
        String a = IdUtils.m9858a(context);
        if (!TextUtils.isEmpty(a)) {
            InternalContainer.m10068g().mo16823a(a);
        }
        SecSdkHelper.m10148b(a);
        LibHolder.m11227a(context);
        m9882c();
        TTDynamic.m10863a();
        PlayableCache.m9577a().mo15644b();
        m9878a();
        StringBuilder sb = new StringBuilder();
        sb.append("do async task: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        Log.d("InitHelper", sb.toString());
    }

    /* renamed from: e */
    private static void m9885e(Context context) {
        InitConfig initConfig = new InitConfig(String.valueOf(164362), "unionser_slardar_applog");
        if (f7725b != null) {
            initConfig.setImeiEnable(f7725b.isCanUsePhoneState());
            if (!f7725b.isCanUsePhoneState()) {
                initConfig.setAppImei(f7725b.getDevImei());
            }
            initConfig.setMacEnable(f7725b.isCanUseWifiState());
        }
        initConfig.setSensitiveInfoProvider(new ISensitiveInfoProvider() {
            public String getImsi() {
                if (InitHelper.f7725b == null || InitHelper.f7725b.isCanUsePhoneState()) {
                    return IdUtils.m9868f(InternalContainer.m10059a());
                }
                return InitHelper.f7725b.getDevImei();
            }

            public String getMac() {
                if (InitHelper.f7725b == null || InitHelper.f7725b.isCanUseWifiState()) {
                    return IdUtils.m9870h(InternalContainer.m10059a());
                }
                return null;
            }
        });
        initConfig.setUriConfig(0);
        AppLog.setEnableLog(C2564t.m12224c());
        AppLog.init(context, initConfig);
        OAIDHelper.m12250a(context);
    }

    /* renamed from: c */
    private static void m9882c() {
        ApplistHelper.m9686a().mo15716b();
    }

    /* renamed from: f */
    private static void m9886f(Context context) {
        AdPreference.m9212a(context).mo15322a("uuid", UUID.randomUUID().toString());
    }

    /* renamed from: g */
    private static void m9887g(final Context context) {
        Npth.m12490a(context.getApplicationContext(), new ICommonParams() {
            /* renamed from: e */
            public Map<String, Integer> mo15831e() {
                return null;
            }

            /* renamed from: f */
            public List<String> mo15832f() {
                return null;
            }

            /* renamed from: a */
            public Map<String, Object> mo15827a() {
                HashMap hashMap = new HashMap();
                String a = IdUtils.m9858a(context);
                if (!TextUtils.isEmpty(a)) {
                    hashMap.put("device_id", a);
                }
                hashMap.put("ac", C2566w.m12247f(context));
                hashMap.put(DeviceInfo.TAG_ANDROID_ID, Integer.valueOf(164362));
                hashMap.put("app_name", "unionser_slardar_applog");
                String f = ToolUtils.m12027f();
                if (!TextUtils.isEmpty(f)) {
                    hashMap.put("app_version", f);
                }
                String e = ToolUtils.m12023e();
                if (!TextUtils.isEmpty(e)) {
                    hashMap.put("version_code", e);
                    hashMap.put("update_version_code", e);
                }
                hashMap.put("version_name", "2.9.5.5");
                hashMap.put("device_platform", "android");
                hashMap.put("os", "Android");
                hashMap.put("device_type", Build.MODEL);
                hashMap.put("device_mode", Build.MODEL);
                hashMap.put("rom", RomUtils.m11943a());
                hashMap.put("cpu_abi", Build.CPU_ABI);
                hashMap.put("device_brand", Build.BRAND);
                hashMap.put("language", Locale.getDefault().getLanguage());
                hashMap.put("os_api", String.valueOf(VERSION.SDK_INT));
                try {
                    String str = VERSION.RELEASE;
                    if (str != null && str.length() > 10) {
                        str = str.substring(0, 10);
                    }
                    hashMap.put("os_version", str);
                } catch (Exception unused) {
                }
                hashMap.put("openudid", IdUtils.m9865c(context));
                hashMap.put("dpi", String.valueOf(UIUtils.m12089f(context)));
                StringBuilder sb = new StringBuilder();
                sb.append(UIUtils.m12078c(context));
                sb.append(Marker.ANY_MARKER);
                sb.append(UIUtils.m12084d(context));
                hashMap.put("resolution", sb.toString());
                return hashMap;
            }

            /* renamed from: b */
            public String mo15828b() {
                return IdUtils.m9858a(context);
            }

            /* renamed from: c */
            public String mo15829c() {
                return AppLog.getUserUniqueID();
            }

            /* renamed from: d */
            public String mo15830d() {
                return AppLog.getSsid();
            }

            /* renamed from: g */
            public Map<String, Object> mo15833g() {
                HashMap hashMap = new HashMap();
                String e = GlobalInfo.m9616c().mo15675e();
                if (TextUtils.isEmpty(e)) {
                    e = String.valueOf(164362);
                }
                hashMap.put("host_appid", e);
                hashMap.put("sdk_version", "2.9.5.5");
                return hashMap;
            }
        }, true, false);
        Npth.m12493a(new ICrashFilter() {
            /* renamed from: a */
            public boolean mo15834a(Throwable th, Thread thread) {
                try {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    if (stringWriter2 != null && stringWriter2.contains(AdSlot.class.getPackage().getName())) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
                return false;
            }
        });
    }
}
