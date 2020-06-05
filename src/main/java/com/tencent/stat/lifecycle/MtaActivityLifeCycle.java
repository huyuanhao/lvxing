package com.tencent.stat.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;

public class MtaActivityLifeCycle {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static StatLogger f25860a = StatCommonHelper.getLogger();

    public static Boolean registerActivityLifecycleCallbacks(Application application, final MtaActivityLifecycleCallback mtaActivityLifecycleCallback) {
        Boolean valueOf = Boolean.valueOf(false);
        if (!(application == null || mtaActivityLifecycleCallback == null || VERSION.SDK_INT < 14)) {
            try {
                f25860a.mo37101d("............ start registerActivityLifecycleCallbacks.");
                application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                    public void onActivityStopped(Activity activity) {
                        mtaActivityLifecycleCallback.onActivityStopped(activity);
                    }

                    public void onActivityStarted(Activity activity) {
                        mtaActivityLifecycleCallback.onActivityStarted(activity);
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        mtaActivityLifecycleCallback.onActivitySaveInstanceState(activity, bundle);
                    }

                    public void onActivityResumed(Activity activity) {
                        StatLogger a = MtaActivityLifeCycle.f25860a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onActivityResumed ");
                        sb.append(activity.getClass().getSimpleName());
                        a.mo37101d(sb.toString());
                        mtaActivityLifecycleCallback.onActivityResumed(activity);
                    }

                    public void onActivityPaused(Activity activity) {
                        StatLogger a = MtaActivityLifeCycle.f25860a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onActivityPaused ");
                        sb.append(activity.getClass().getSimpleName());
                        a.mo37101d(sb.toString());
                        mtaActivityLifecycleCallback.onActivityPaused(activity);
                    }

                    public void onActivityDestroyed(Activity activity) {
                        mtaActivityLifecycleCallback.onActivityDestroyed(activity);
                    }

                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        mtaActivityLifecycleCallback.onActivityCreated(activity, bundle);
                    }
                });
                f25860a.mo37101d("............ end registerActivityLifecycleCallbacks.");
                return Boolean.valueOf(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return valueOf;
    }
}
