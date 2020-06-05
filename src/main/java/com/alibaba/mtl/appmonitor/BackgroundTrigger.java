package com.alibaba.mtl.appmonitor;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.appmonitor.p071d.SampleRules;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.p077d.AppInfoUtil;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.TaskExecutor;

/* renamed from: com.alibaba.mtl.appmonitor.g */
class BackgroundTrigger implements Runnable {
    /* renamed from: a */
    private static boolean f3231a = false;
    /* renamed from: d */
    private static boolean f3232d = false;
    /* renamed from: b */
    private Application f3233b;
    /* renamed from: c */
    private boolean f3234c = true;

    /* compiled from: BackgroundTrigger */
    /* renamed from: com.alibaba.mtl.appmonitor.g$a */
    class C1300a implements ActivityLifecycleCallbacks {
        /* renamed from: b */
        private Runnable f3236b;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        C1300a(Runnable runnable) {
            this.f3236b = runnable;
        }

        public void onActivityStarted(Activity activity) {
            TaskExecutor.m3867a().mo11809a(4);
            TaskExecutor.m3867a().mo11810a(4, this.f3236b, 60000);
        }

        public void onActivityStopped(Activity activity) {
            TaskExecutor.m3867a().mo11809a(4);
            TaskExecutor.m3867a().mo11810a(4, this.f3236b, 60000);
        }
    }

    /* renamed from: a */
    public static void m3595a(Application application) {
        if (!f3231a) {
            Logger.m3833a("BackgroundTrigger", "init BackgroundTrigger");
            f3232d = m3596a(application.getApplicationContext());
            BackgroundTrigger gVar = new BackgroundTrigger(application);
            if (f3232d) {
                TaskExecutor.m3867a().mo11810a(4, gVar, 60000);
            } else if (VERSION.SDK_INT >= 14) {
                gVar.getClass();
                application.registerActivityLifecycleCallbacks(new C1300a(gVar));
            }
            f3231a = true;
        }
    }

    public BackgroundTrigger(Application application) {
        this.f3233b = application;
    }

    public void run() {
        int i = 0;
        Logger.m3833a("BackgroundTrigger", "[bg check]");
        boolean a = AppInfoUtil.m3792a(this.f3233b.getApplicationContext());
        if (this.f3234c != a) {
            this.f3234c = a;
            if (a) {
                SampleRules.m3572a().mo11652b();
                EventType[] values = EventType.values();
                int length = values.length;
                while (i < length) {
                    EventType fVar = values[i];
                    AppMonitorDelegate.m3368a(fVar, fVar.mo11572c());
                    i++;
                }
                UTDC.m3696b();
            } else {
                EventType[] values2 = EventType.values();
                int length2 = values2.length;
                while (i < length2) {
                    EventType fVar2 = values2[i];
                    AppMonitorDelegate.m3368a(fVar2, fVar2.mo11574d());
                    i++;
                }
                AppMonitorDelegate.m3377b();
                UTDC.m3691a();
            }
        }
        if (f3232d) {
            TaskExecutor.m3867a().mo11810a(4, this, 60000);
        }
    }

    /* renamed from: a */
    private static boolean m3596a(Context context) {
        String b = AppInfoUtil.m3794b(context);
        Logger.m3833a("BackgroundTrigger", "[checkRuningProcess]:", b);
        return !TextUtils.isEmpty(b) && b.indexOf(":") != -1;
    }
}
