package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.biz.b */
public class C7170b {
    /* renamed from: a */
    public static boolean f23941a = false;
    /* renamed from: b */
    public static C7164a f23942b = null;
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static int f23943c = 10;
    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static long f23944d = 300000;
    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static long f23945e = 30000;
    /* access modifiers changed from: private|static */
    /* renamed from: f */
    public static long f23946f = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: g */
    public static int f23947g = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: h */
    public static long f23948h = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static long f23949i = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: j */
    public static long f23950j = 0;
    /* renamed from: k */
    private static ActivityLifecycleCallbacks f23951k = null;
    /* access modifiers changed from: private|static */
    /* renamed from: l */
    public static Class<?> f23952l = null;
    /* access modifiers changed from: private|static */
    /* renamed from: m */
    public static boolean f23953m = true;

    /* renamed from: g */
    static /* synthetic */ int m30730g() {
        int i = f23947g;
        f23947g = i + 1;
        return i;
    }

    /* renamed from: m */
    private static void m30736m() {
        StackTraceElement[] stackTrace;
        C7174a b = C7174a.m30754b();
        if (b != null) {
            String str = null;
            boolean z = false;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getMethodName().equals("onCreate")) {
                    str = stackTraceElement.getClassName();
                }
                if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                    z = true;
                }
            }
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            } else if (z) {
                b.mo34578a(true);
            } else {
                str = "background";
            }
            b.f24041v = str;
        }
    }

    /* renamed from: b */
    private static boolean m30721b(Context context) {
        C7174a a = C7174a.m30753a(context);
        List a2 = f23942b.mo34529a(a.f24024e);
        if (a2 == null) {
            return true;
        }
        for (int i = 0; i < a2.size(); i++) {
            UserInfoBean userInfoBean = (UserInfoBean) a2.get(i);
            if (userInfoBean.f23922n.equals(a.f24035p) && userInfoBean.f23910b == 1) {
                long b = C7232aq.m31204b();
                if (b <= 0) {
                    return true;
                }
                if (userInfoBean.f23913e >= b) {
                    if (userInfoBean.f23914f <= 0) {
                        f23942b.mo34534b();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m30725c(Context context, BuglyStrategy buglyStrategy) {
        boolean z;
        boolean z2;
        if (buglyStrategy != null) {
            z2 = buglyStrategy.recordUserInfoOnceADay();
            z = buglyStrategy.isEnableUserInfo();
        } else {
            z = true;
            z2 = false;
        }
        if (z2) {
            if (m30721b(context)) {
                z = false;
            } else {
                return;
            }
        }
        m30736m();
        if (z) {
            m30724c(context);
        }
        if (f23953m) {
            m30737n();
            f23942b.mo34530a();
            f23942b.mo34535b(21600000);
        }
    }

    /* renamed from: a */
    public static void m30715a(final Context context, final BuglyStrategy buglyStrategy) {
        long j;
        if (!f23941a) {
            f23953m = C7174a.m30753a(context).f24027h;
            f23942b = new C7164a(context, f23953m);
            f23941a = true;
            if (buglyStrategy != null) {
                f23952l = buglyStrategy.getUserInfoActivity();
                j = buglyStrategy.getAppReportDelay();
            } else {
                j = 0;
            }
            if (j <= 0) {
                m30725c(context, buglyStrategy);
            } else {
                C7224am.m31132a().mo34833a(new Runnable() {
                    public void run() {
                        C7170b.m30725c(context, buglyStrategy);
                    }
                }, j);
            }
        }
    }

    /* renamed from: a */
    public static void m30713a(long j) {
        if (j < 0) {
            j = C7177a.m30857a().mo34624c().f24067q;
        }
        f23946f = j;
    }

    /* renamed from: a */
    public static void m30716a(StrategyBean strategyBean, boolean z) {
        C7164a aVar = f23942b;
        if (aVar != null && !z) {
            aVar.mo34534b();
        }
        if (strategyBean != null) {
            if (strategyBean.f24067q > 0) {
                f23945e = strategyBean.f24067q;
            }
            if (strategyBean.f24073w > 0) {
                f23943c = strategyBean.f24073w;
            }
            if (strategyBean.f24074x > 0) {
                f23944d = strategyBean.f24074x;
            }
        }
    }

    /* renamed from: n */
    private static void m30737n() {
        f23949i = System.currentTimeMillis();
        f23942b.mo34531a(1, false, 0);
        C7226an.m31141a("[session] launch app, new start", new Object[0]);
    }

    /* renamed from: a */
    public static void m30712a() {
        C7164a aVar = f23942b;
        if (aVar != null) {
            aVar.mo34531a(2, false, 0);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static String m30719b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(C7232aq.m31178a());
        String str3 = "  ";
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: c */
    private static void m30724c(Context context) {
        if (VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (f23951k == null) {
                        f23951k = new ActivityLifecycleCallbacks() {
                            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            }

                            public void onActivityStarted(Activity activity) {
                            }

                            public void onActivityStopped(Activity activity) {
                            }

                            public void onActivityResumed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
                                if (C7170b.f23952l == null || C7170b.f23952l.getName().equals(name)) {
                                    C7226an.m31147c(">>> %s onResumed <<<", name);
                                    C7174a b = C7174a.m30754b();
                                    if (b != null) {
                                        b.f23973K.add(C7170b.m30719b(name, "onResumed"));
                                        b.mo34578a(true);
                                        b.f24041v = name;
                                        b.f24042w = System.currentTimeMillis();
                                        b.f24045z = b.f24042w - C7170b.f23949i;
                                        long d = b.f24042w - C7170b.f23948h;
                                        if (d > (C7170b.f23946f > 0 ? C7170b.f23946f : C7170b.f23945e)) {
                                            b.mo34587d();
                                            C7170b.m30730g();
                                            C7226an.m31141a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(d / 1000), Long.valueOf(C7170b.f23945e / 1000));
                                            if (C7170b.f23947g % C7170b.f23943c == 0) {
                                                C7170b.f23942b.mo34531a(4, C7170b.f23953m, 0);
                                            } else {
                                                C7170b.f23942b.mo34531a(4, false, 0);
                                                long currentTimeMillis = System.currentTimeMillis();
                                                if (currentTimeMillis - C7170b.f23950j > C7170b.f23944d) {
                                                    C7170b.f23950j = currentTimeMillis;
                                                    C7226an.m31141a("add a timer to upload hot start user info", new Object[0]);
                                                    if (C7170b.f23953m) {
                                                        C7170b.f23942b.mo34532a(C7170b.f23944d);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            public void onActivityPaused(Activity activity) {
                                String str = EnvironmentCompat.MEDIA_UNKNOWN;
                                String name = activity != null ? activity.getClass().getName() : str;
                                if (C7170b.f23952l == null || C7170b.f23952l.getName().equals(name)) {
                                    C7226an.m31147c(">>> %s onPaused <<<", name);
                                    C7174a b = C7174a.m30754b();
                                    if (b != null) {
                                        b.f23973K.add(C7170b.m30719b(name, "onPaused"));
                                        b.mo34578a(false);
                                        b.f24043x = System.currentTimeMillis();
                                        b.f24044y = b.f24043x - b.f24042w;
                                        C7170b.f23948h = b.f24043x;
                                        if (b.f24044y < 0) {
                                            b.f24044y = 0;
                                        }
                                        if (activity != null) {
                                            b.f24041v = "background";
                                        } else {
                                            b.f24041v = str;
                                        }
                                    }
                                }
                            }

                            public void onActivityDestroyed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
                                if (C7170b.f23952l == null || C7170b.f23952l.getName().equals(name)) {
                                    C7226an.m31147c(">>> %s onDestroyed <<<", name);
                                    C7174a b = C7174a.m30754b();
                                    if (b != null) {
                                        b.f23973K.add(C7170b.m30719b(name, "onDestroyed"));
                                    }
                                }
                            }

                            public void onActivityCreated(Activity activity, Bundle bundle) {
                                String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
                                if (C7170b.f23952l == null || C7170b.f23952l.getName().equals(name)) {
                                    C7226an.m31147c(">>> %s onCreated <<<", name);
                                    C7174a b = C7174a.m30754b();
                                    if (b != null) {
                                        b.f23973K.add(C7170b.m30719b(name, "onCreated"));
                                    }
                                }
                            }
                        };
                    }
                    application.registerActivityLifecycleCallbacks(f23951k);
                } catch (Exception e) {
                    if (!C7226an.m31142a(e)) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private static void m30727d(Context context) {
        if (VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (f23951k != null) {
                        application.unregisterActivityLifecycleCallbacks(f23951k);
                    }
                } catch (Exception e) {
                    if (!C7226an.m31142a(e)) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m30714a(Context context) {
        if (f23941a && context != null) {
            m30727d(context);
            f23941a = false;
        }
    }
}
