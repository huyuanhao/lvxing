package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.AdPreference;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p174h.ApplistHelper;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.bytedance.sdk.openadsdk.utils.p */
public class InstallAppUtils {
    /* renamed from: a */
    public static JSONArray m12199a(final Context context) {
        if (!InternalContainer.m10069h().mo15768P() || !GlobalInfo.m9616c().mo15672d().alist() || !SdkSettingsHelper.m9748d() || !m12205e(context)) {
            return null;
        }
        TTExecutor.m11692a().mo16808c(new Runnable() {
            public void run() {
                InstallAppUtils.m12204d(context);
            }
        }, 1);
        return m12203c(context);
    }

    /* renamed from: c */
    private static JSONArray m12203c(Context context) {
        try {
            String b = AdPreference.m9212a(context).mo15327b("install_app_incremental_string", (String) null);
            if (!TextUtils.isEmpty(b)) {
                return new JSONArray(m12198a(b));
            }
        } catch (Throwable th) {
            C2564t.m12216a("InstallAppUtils", "getCacheIncrementalApps error: ", th);
        }
        return null;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static void m12204d(Context context) {
        try {
            List a = ApplistHelper.m9686a().mo15715a(context);
            if (a != null) {
                if (!a.isEmpty()) {
                    List a2 = m12198a(AdPreference.m9212a(context).mo15327b("install_app_string", (String) null));
                    m12200a(context, m12197a(a));
                    if (a2 != null && !a2.isEmpty()) {
                        a.removeAll(a2);
                    }
                    m12202b(context, m12197a(a));
                }
            }
        } catch (Exception e) {
            C2564t.m12216a("InstallAppUtils", "loadIncrementInstallApps error: ", e);
        }
    }

    /* renamed from: a */
    private static void m12200a(Context context, String str) {
        AdPreference.m9212a(context).mo15322a("install_app_string", str);
    }

    /* renamed from: b */
    private static void m12202b(Context context, String str) {
        AdPreference a = AdPreference.m9212a(context);
        a.mo15322a("install_app_incremental_string", str);
        a.mo15321a("apptime", System.currentTimeMillis());
    }

    /* renamed from: e */
    private static boolean m12205e(Context context) {
        long longValue = AdPreference.m9212a(context).mo15326b("apptime", -1).longValue();
        return longValue == -1 || System.currentTimeMillis() - longValue > 43200000;
    }

    /* renamed from: a */
    private static List<String> m12198a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(StorageInterface.KEY_SPLITER));
    }

    /* renamed from: a */
    private static String m12197a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append((String) list.get(i));
            if (i != list.size() - 1) {
                sb.append(StorageInterface.KEY_SPLITER);
            }
        }
        return sb.toString().trim();
    }
}
