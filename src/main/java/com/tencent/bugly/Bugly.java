package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.proguard.C7211ad;
import com.tencent.bugly.proguard.C7212ae;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import java.util.Map;

/* compiled from: BUGLY */
public class Bugly {
    /* renamed from: a */
    private static boolean f23641a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (!f23641a) {
                f23641a = true;
                applicationContext = C7232aq.m31172a(context);
                if (applicationContext == null) {
                    Log.e(C7226an.f24396b, "init arg 'context' should not be null!");
                    return;
                }
                C7121b.m30531a((C8712a) CrashModule.getInstance());
                C7121b.m30531a((C8712a) Beta.getInstance());
                C7121b.f23663a = enable;
                C7121b.m30529a(applicationContext, str, z, buglyStrategy);
            }
        }
    }

    public static synchronized String getAppChannel() {
        synchronized (Bugly.class) {
            C7174a b = C7174a.m30754b();
            if (b == null) {
                return null;
            }
            if (TextUtils.isEmpty(b.f24037r)) {
                C7212ae a = C7212ae.m31041a();
                if (a == null) {
                    String str = b.f24037r;
                    return str;
                }
                Map a2 = a.mo34779a(556, (C7211ad) null, true);
                if (a2 != null) {
                    byte[] bArr = (byte[]) a2.get("app_channel");
                    if (bArr != null) {
                        String str2 = new String(bArr);
                        return str2;
                    }
                }
            }
            String str3 = b.f24037r;
            return str3;
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        CrashReport.setIsDevelopmentDevice(context, z);
    }

    public static void setAppChannel(Context context, String str) {
        CrashReport.setAppChannel(context, str);
    }

    public static void setUserId(Context context, String str) {
        CrashReport.setUserId(context, str);
    }

    public static void setUserTag(Context context, int i) {
        CrashReport.setUserSceneTag(context, i);
    }

    public static void putUserData(Context context, String str, String str2) {
        CrashReport.putUserData(context, str, str2);
    }
}
