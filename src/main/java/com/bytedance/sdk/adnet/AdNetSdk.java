package com.bytedance.sdk.adnet;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.QueueManager;
import com.bytedance.sdk.adnet.core.RequestQueue;
import com.bytedance.sdk.adnet.core.TTDnsProxy;
import com.bytedance.sdk.adnet.core.VNetLog;
import com.bytedance.sdk.adnet.p158a.AppConfig;
import com.bytedance.sdk.adnet.p160c.ApiRequestInterceptor;
import com.bytedance.sdk.adnet.p160c.ITTAdNetDepend;
import com.bytedance.sdk.adnet.p160c.TNCManager;
import com.bytedance.sdk.adnet.p161d.C1987d;
import com.bytedance.sdk.adnet.p161d.C1987d.C1989a;
import com.bytedance.sdk.adnet.p161d.ProcessUtils;
import com.bytedance.sdk.adnet.p162e.IHttpStack;
import java.io.File;

/* renamed from: com.bytedance.sdk.adnet.a */
public class AdNetSdk {
    /* renamed from: a */
    public static TTDnsProxy f6053a = null;
    /* renamed from: b */
    private static String f6054b = null;
    /* renamed from: c */
    private static ITTAdNetDepend f6055c = null;
    /* renamed from: d */
    private static boolean f6056d = true;
    /* renamed from: e */
    private static ApiRequestInterceptor f6057e;

    /* renamed from: a */
    public static RequestQueue m7641a(Context context) {
        return QueueManager.m7904a(context);
    }

    /* renamed from: a */
    public static RequestQueue m7642a(Context context, IHttpStack aVar) {
        return QueueManager.m7905a(context, aVar);
    }

    /* renamed from: b */
    public static String m7649b(Context context) {
        try {
            if (TextUtils.isEmpty(f6054b)) {
                File file = new File(context.getCacheDir(), "VAdNetSdk");
                file.mkdirs();
                f6054b = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            VNetLog.m7927a(th, "init adnetsdk default directory error ", new Object[0]);
        }
        return f6054b;
    }

    /* renamed from: a */
    public static void m7647a(TTDnsProxy qVar) {
        f6053a = qVar;
    }

    /* renamed from: a */
    public static void m7646a(ITTAdNetDepend bVar) {
        f6055c = bVar;
    }

    /* renamed from: a */
    public static ITTAdNetDepend m7640a() {
        ITTAdNetDepend bVar = f6055c;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    /* renamed from: a */
    public static void m7648a(boolean z) {
        f6056d = z;
    }

    /* renamed from: b */
    public static boolean m7650b() {
        return f6056d;
    }

    /* renamed from: c */
    public static void m7651c() {
        C1987d.m7946a(C1989a.DEBUG);
    }

    /* renamed from: a */
    public static void m7645a(ApiRequestInterceptor aVar) {
        f6057e = aVar;
    }

    /* renamed from: d */
    public static ApiRequestInterceptor m7652d() {
        return f6057e;
    }

    /* renamed from: a */
    public static void m7644a(Context context, Application application, boolean z) {
        if (context != null) {
            TNCManager.m7771a().mo14245a(context, ProcessUtils.m7957b(context));
            if (ProcessUtils.m7956a(context) || (!ProcessUtils.m7957b(context) && z)) {
                AppConfig.m7653a(context).mo14166c();
                AppConfig.m7653a(context).mo14161a();
            }
            if (ProcessUtils.m7957b(context)) {
                AppConfig.m7653a(context);
                if (application != null) {
                    application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                        public void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        public void onActivityDestroyed(Activity activity) {
                        }

                        public void onActivityPaused(Activity activity) {
                        }

                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        public void onActivityStarted(Activity activity) {
                        }

                        public void onActivityStopped(Activity activity) {
                        }

                        public void onActivityResumed(Activity activity) {
                            AdNetSdk.m7643a(activity);
                        }
                    });
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("tryInitAdTTNet context is null");
    }

    /* renamed from: a */
    public static void m7643a(Activity activity) {
        if (activity != null) {
            final Context applicationContext = activity.getApplicationContext();
            new Thread("load_config") {
                public void run() {
                    AppConfig.m7653a(applicationContext).mo14166c();
                    AppConfig.m7653a(applicationContext);
                    AppConfig.m7660b(applicationContext);
                }
            }.start();
        }
    }
}
