package com.tencent.bugly.crashreport;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.bugly.C7121b;
import com.tencent.bugly.C8712a;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.biz.C7170b;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.C7192c;
import com.tencent.bugly.crashreport.crash.C7195d;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.p603h5.C7201b;
import com.tencent.bugly.crashreport.crash.p603h5.H5JavaScriptInterface;
import com.tencent.bugly.proguard.C7214af;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7227ao;
import com.tencent.bugly.proguard.C7232aq;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
public class CrashReport {
    /* renamed from: a */
    private static Context f23906a;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.CrashReport$CrashHandleCallback */
    public static class CrashHandleCallback extends C7120a {
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.CrashReport$UserStrategy */
    public static class UserStrategy extends BuglyStrategy {
        /* renamed from: a */
        CrashHandleCallback f23908a;

        public UserStrategy(Context context) {
        }

        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f23908a;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f23908a = crashHandleCallback;
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.CrashReport$WebViewInterface */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void enableBugly(boolean z) {
        C7121b.f23663a = z;
    }

    public static void initCrashReport(Context context) {
        f23906a = context;
        C7121b.m30531a((C8712a) CrashModule.getInstance());
        C7121b.m30527a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        f23906a = context;
        C7121b.m30531a((C8712a) CrashModule.getInstance());
        C7121b.m30528a(context, (BuglyStrategy) userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, null);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context != null) {
            f23906a = context;
            C7121b.m30531a((C8712a) CrashModule.getInstance());
            C7121b.m30529a(context, str, z, userStrategy);
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return C7174a.m30753a(context).mo34584c();
        }
        C7226an.m31148d("Please call with context.", new Object[0]);
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static void testJavaCrash() {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not test Java crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C7174a b = C7174a.m30754b();
            if (b != null) {
                b.mo34580b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C7226an.m31141a("start to create a native crash for test!", new Object[0]);
            C7192c.m30937a().mo34691a(z, z2, z3);
        }
    }

    public static void testANRCrash() {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C7226an.m31141a("start to create a anr crash for test!", new Object[0]);
            C7192c.m30937a().mo34701k();
        }
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C7195d.m30963a(thread, i, str, str2, str3, map);
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            C7226an.m31148d("throwable is null, just return", new Object[0]);
        } else {
            if (thread == null) {
                thread = Thread.currentThread();
            }
            C7192c.m30937a().mo34690a(thread, th, false, (String) null, (byte[]) null, z);
        }
    }

    public static void closeNativeReport() {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not close native report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C7192c.m30937a().mo34697g();
        }
    }

    public static void startCrashReport() {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not start crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C7192c.m30937a().mo34693c();
        }
    }

    public static void closeCrashReport() {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not close crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C7192c.m30937a().mo34694d();
        }
    }

    public static void closeBugly() {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (f23906a != null) {
            BuglyBroadcastReceiver instance = BuglyBroadcastReceiver.getInstance();
            if (instance != null) {
                instance.unregister(f23906a);
            }
            closeCrashReport();
            C7170b.m30714a(f23906a);
            C7224am a = C7224am.m31132a();
            if (a != null) {
                a.mo34834b();
            }
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(C7226an.f24396b, "setTag args context should not be null");
        } else {
            if (i <= 0) {
                C7226an.m31148d("setTag args tagId should > 0", new Object[0]);
            }
            C7174a.m30753a(context).mo34575a(i);
            C7226an.m31144b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context != null) {
            return C7174a.m30753a(context).mo34562H();
        } else {
            Log.e(C7226an.f24396b, "getUserSceneTagId args context should not be null");
            return -1;
        }
    }

    public static String getUserData(Context context, String str) {
        boolean z = C7121b.f23663a;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (!z) {
            Log.w(C7226an.f24396b, "Can not get user data because bugly is disable.");
            return str2;
        } else if (context == null) {
            Log.e(C7226an.f24396b, "getUserDataValue args context should not be null");
            return str2;
        } else if (C7232aq.m31196a(str)) {
            return null;
        } else {
            return C7174a.m30753a(context).mo34594g(str);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(C7226an.f24396b, "putUserData args context should not be null");
        } else {
            String str3 = "";
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str);
                sb.toString();
                C7226an.m31148d("putUserData args key should not be null or empty", new Object[0]);
            } else if (str2 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(str2);
                sb2.toString();
                C7226an.m31148d("putUserData args value should not be null", new Object[0]);
            } else if (!str.matches("[a-zA-Z[0-9]]+")) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("putUserData args key should match [a-zA-Z[0-9]]+  {");
                sb3.append(str);
                sb3.append("}");
                C7226an.m31148d(sb3.toString(), new Object[0]);
            } else {
                if (str2.length() > 200) {
                    C7226an.m31148d("user data value length over limit %d, it will be cutted!", Integer.valueOf(200));
                    str2 = str2.substring(0, 200);
                }
                C7174a a = C7174a.m30753a(context);
                if (a.mo34559E().contains(str)) {
                    NativeCrashHandler instance = NativeCrashHandler.getInstance();
                    if (instance != null) {
                        instance.putKeyValueToNative(str, str2);
                    }
                    C7174a.m30753a(context).mo34582b(str, str2);
                    C7226an.m31147c("replace KV %s %s", str, str2);
                } else if (a.mo34558D() >= 10) {
                    C7226an.m31148d("user data size is over limit %d, it will be cutted!", Integer.valueOf(10));
                } else {
                    if (str.length() > 50) {
                        C7226an.m31148d("user data key length over limit %d , will drop this new key %s", Integer.valueOf(50), str);
                        str = str.substring(0, 50);
                    }
                    NativeCrashHandler instance2 = NativeCrashHandler.getInstance();
                    if (instance2 != null) {
                        instance2.putKeyValueToNative(str, str2);
                    }
                    C7174a.m30753a(context).mo34582b(str, str2);
                    C7226an.m31144b("[param] set user data: %s - %s", str, str2);
                }
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        boolean z = C7121b.f23663a;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (!z) {
            Log.w(C7226an.f24396b, "Can not remove user data because bugly is disable.");
            return str2;
        } else if (context == null) {
            Log.e(C7226an.f24396b, "removeUserData args context should not be null");
            return str2;
        } else if (C7232aq.m31196a(str)) {
            return null;
        } else {
            C7226an.m31144b("[param] remove user data: %s", str);
            return C7174a.m30753a(context).mo34592f(str);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context != null) {
            return C7174a.m30753a(context).mo34559E();
        } else {
            Log.e(C7226an.f24396b, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context != null) {
            return C7174a.m30753a(context).mo34558D();
        } else {
            Log.e(C7226an.f24396b, "getUserDatasSize args context should not be null");
            return -1;
        }
    }

    public static String getAppID() {
        boolean z = C7121b.f23663a;
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        if (!z) {
            Log.w(C7226an.f24396b, "Can not get App ID because bugly is disable.");
            return str;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return C7174a.m30753a(f23906a).mo34591f();
        } else {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return str;
        }
    }

    public static void setUserId(String str) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set user ID because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserId(f23906a, str);
        }
    }

    public static void setUserId(Context context, String str) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(C7226an.f24396b, "Context should not be null when bugly has not been initialed!");
        } else if (str == null) {
            C7226an.m31148d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                C7226an.m31148d("userId %s length is over limit %d substring to %s", str, Integer.valueOf(100), substring);
                str = substring;
            }
            if (!str.equals(C7174a.m30753a(context).mo34593g())) {
                C7174a.m30753a(context).mo34581b(str);
                C7226an.m31144b("[user] set userId : %s", str);
                NativeCrashHandler instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.setNativeUserId(str);
                }
                if (CrashModule.getInstance().hasInitialized()) {
                    C7170b.m30712a();
                }
            }
        }
    }

    public static String getUserId() {
        boolean z = C7121b.f23663a;
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        if (!z) {
            Log.w(C7226an.f24396b, "Can not get user ID because bugly is disable.");
            return str;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return C7174a.m30753a(f23906a).mo34593g();
        } else {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return str;
        }
    }

    public static String getAppVer() {
        boolean z = C7121b.f23663a;
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        if (!z) {
            Log.w(C7226an.f24396b, "Can not get app version because bugly is disable.");
            return str;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return C7174a.m30753a(f23906a).f24035p;
        } else {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return str;
        }
    }

    public static String getAppChannel() {
        boolean z = C7121b.f23663a;
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        if (!z) {
            Log.w(C7226an.f24396b, "Can not get App channel because bugly is disable.");
            return str;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return C7174a.m30753a(f23906a).f24037r;
        } else {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return str;
        }
    }

    public static void setContext(Context context) {
        f23906a = context;
    }

    public static boolean isLastSessionCrash() {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return C7192c.m30937a().mo34692b();
        } else {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        }
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not put SDK extra data because bugly is disable.");
            return;
        }
        if (context != null && !C7232aq.m31196a(str) && !C7232aq.m31196a(str2)) {
            C7174a.m30753a(context).mo34577a(str, str2);
        }
    }

    public static Map<String, String> getSdkExtraData() {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (CrashModule.getInstance().hasInitialized()) {
            return C7174a.m30753a(f23906a).f23971I;
        } else {
            Log.e(C7226an.f24396b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (context != null) {
            return C7174a.m30753a(context).f23971I;
        } else {
            C7226an.m31148d("Context should not be null.", new Object[0]);
            return null;
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context != null && !C7232aq.m31196a(str) && !C7232aq.m31196a(str2)) {
            String replace = str.replace("[a-zA-Z[0-9]]+", "");
            if (replace.length() > 100) {
                Log.w(C7226an.f24396b, String.format("putSdkData key length over limit %d, will be cutted.", new Object[]{Integer.valueOf(50)}));
                replace = replace.substring(0, 50);
            }
            if (str2.length() > 500) {
                Log.w(C7226an.f24396b, String.format("putSdkData value length over limit %d, will be cutted!", new Object[]{Integer.valueOf(200)}));
                str2 = str2.substring(0, 200);
            }
            C7174a.m30753a(context).mo34586c(replace, str2);
            C7226an.m31144b(String.format("[param] putSdkData data: %s - %s", new Object[]{replace, str2}), new Object[0]);
        }
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set 'isAppForeground' because bugly is disable.");
        } else if (context == null) {
            C7226an.m31148d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                C7226an.m31147c("App is in foreground.", new Object[0]);
            } else {
                C7226an.m31147c("App is in background.", new Object[0]);
            }
            C7174a.m30753a(context).mo34578a(z);
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            C7226an.m31148d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                C7226an.m31147c("This is a development device.", new Object[0]);
            } else {
                C7226an.m31147c("This is not a development device.", new Object[0]);
            }
            C7174a.m30753a(context).f23967E = z;
        }
    }

    public static void setSessionIntervalMills(long j) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        } else {
            C7170b.m30713a(j);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(C7226an.f24396b, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(C7226an.f24396b, "App version is null, will not set");
        } else {
            C7174a.m30753a(context).f24035p = str;
            NativeCrashHandler instance = NativeCrashHandler.getInstance();
            if (instance != null) {
                instance.setNativeAppVersion(str);
            }
        }
    }

    public static void setAppChannel(Context context, String str) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set App channel because Bugly is disable.");
        } else if (context == null) {
            Log.w(C7226an.f24396b, "setAppChannel args context should not be null");
        } else if (str == null) {
            Log.w(C7226an.f24396b, "App channel is null, will not set");
        } else {
            C7174a.m30753a(context).f24037r = str;
            NativeCrashHandler instance = NativeCrashHandler.getInstance();
            if (instance != null) {
                instance.setNativeAppChannel(str);
            }
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(C7226an.f24396b, "setAppPackage args context should not be null");
        } else if (str == null) {
            Log.w(C7226an.f24396b, "App package is null, will not set");
        } else {
            C7174a.m30753a(context).f24023d = str;
            NativeCrashHandler instance = NativeCrashHandler.getInstance();
            if (instance != null) {
                instance.setNativeAppPackage(str);
            }
        }
    }

    public static void setCrashFilter(String str) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set App package because bugly is disable.");
            return;
        }
        String str2 = C7226an.f24396b;
        StringBuilder sb = new StringBuilder();
        sb.append("Set crash stack filter: ");
        sb.append(str);
        Log.i(str2, sb.toString());
        C7192c.f24200n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set App package because bugly is disable.");
            return;
        }
        String str2 = C7226an.f24396b;
        StringBuilder sb = new StringBuilder();
        sb.append("Set crash stack filter: ");
        sb.append(str);
        Log.i(str2, sb.toString());
        C7192c.f24201o = str;
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set App package because bugly is disable.");
            return;
        }
        String str = C7226an.f24396b;
        StringBuilder sb = new StringBuilder();
        sb.append("Should handle native crash in Java profile after handled in native profile: ");
        sb.append(z);
        Log.i(str, sb.toString());
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setBuglyDbName(String str) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set DB name because bugly is disable.");
            return;
        }
        String str2 = C7226an.f24396b;
        StringBuilder sb = new StringBuilder();
        sb.append("Set Bugly DB name: ");
        sb.append(str);
        Log.i(str2, sb.toString());
        C7214af.f24326a = str;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set DB name because bugly is disable.");
        } else if (context == null) {
            Log.w(C7226an.f24396b, "enableObtainId args context should not be null");
        } else {
            String str = C7226an.f24396b;
            StringBuilder sb = new StringBuilder();
            sb.append("Enable identification obtaining? ");
            sb.append(z);
            Log.i(str, sb.toString());
            C7174a.m30753a(context).mo34583b(z);
        }
    }

    public static void setAuditEnable(Context context, boolean z) {
        if (!C7121b.f23663a) {
            Log.w(C7226an.f24396b, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(C7226an.f24396b, "setAppPackage args context should not be null");
        } else {
            String str = C7226an.f24396b;
            StringBuilder sb = new StringBuilder();
            sb.append("Set audit enable: ");
            sb.append(z);
            Log.i(str, sb.toString());
            C7174a.m30753a(context).f23972J = z;
        }
    }

    public static void setServerUrl(String str) {
        if (C7232aq.m31196a(str) || !C7232aq.m31221c(str)) {
            Log.i(C7226an.f24396b, "URL is invalid.");
            return;
        }
        C7177a.m30859a(str);
        StrategyBean.f24052b = str;
        StrategyBean.f24053c = str;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView != null) {
            return setJavascriptMonitor((WebViewInterface) new WebViewInterface() {
                public String getUrl() {
                    return webView.getUrl();
                }

                public void setJavaScriptEnabled(boolean z) {
                    WebSettings settings = webView.getSettings();
                    if (!settings.getJavaScriptEnabled()) {
                        settings.setJavaScriptEnabled(true);
                    }
                }

                public void loadUrl(String str) {
                    webView.loadUrl(str);
                }

                public void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                    webView.addJavascriptInterface(h5JavaScriptInterface, str);
                }

                public CharSequence getContentDescription() {
                    return webView.getContentDescription();
                }
            }, z, z2);
        }
        Log.w(C7226an.f24396b, "WebView is null.");
        return false;
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            Log.w(C7226an.f24396b, "WebViewInterface is null.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            C7226an.m31149e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        } else {
            C7226an.m31141a("Set Javascript exception monitor of webview.", new Object[0]);
            if (!C7121b.f23663a) {
                Log.w(C7226an.f24396b, "Can not set JavaScript monitor because bugly is disable.");
                return false;
            }
            C7226an.m31147c("URL of webview is %s", webViewInterface.getUrl());
            if (z2 || VERSION.SDK_INT >= 19) {
                C7226an.m31141a("Enable the javascript needed by webview monitor.", new Object[0]);
                webViewInterface.setJavaScriptEnabled(true);
                H5JavaScriptInterface instance = H5JavaScriptInterface.getInstance(webViewInterface);
                if (instance != null) {
                    C7226an.m31141a("Add a secure javascript interface to the webview.", new Object[0]);
                    webViewInterface.addJavascriptInterface(instance, "exceptionUploader");
                }
                if (z) {
                    C7226an.m31141a("Inject bugly.js(v%s) to the webview.", C7201b.m30988b());
                    String a = C7201b.m30987a();
                    if (a == null) {
                        C7226an.m31149e("Failed to inject Bugly.js.", C7201b.m30988b());
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("javascript:");
                    sb.append(a);
                    webViewInterface.loadUrl(sb.toString());
                }
                return true;
            }
            C7226an.m31149e("This interface is only available for Android 4.4 or later.", new Object[0]);
            return false;
        }
    }

    public static void setHttpProxy(String str, int i) {
        C7227ao.m31152a(str, i);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i) {
        C7227ao.m31153a(inetAddress, i);
    }

    public static Proxy getHttpProxy() {
        return C7227ao.m31151a();
    }
}
