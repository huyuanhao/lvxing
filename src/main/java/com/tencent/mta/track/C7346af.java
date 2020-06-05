package com.tencent.mta.track;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mta.track.util.C7468g;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.af */
class C7346af implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    final /* synthetic */ StatisticsDataAPI f24872a;
    /* renamed from: b */
    private boolean f24873b = false;
    /* renamed from: c */
    private Integer f24874c = Integer.valueOf(0);

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public C7346af(StatisticsDataAPI statisticsDataAPI) {
        this.f24872a = statisticsDataAPI;
    }

    public void onActivityStarted(Activity activity) {
        synchronized (this.f24874c) {
            if (this.f24874c.intValue() == 0) {
                if (this.f24872a.f24850k) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("resume_from_background", this.f24873b);
                        this.f24872a.track("AppStart", jSONObject);
                        this.f24872a.trackTimer("AppEnd", TimeUnit.SECONDS);
                    } catch (Throwable th) {
                        Log.w("StatisticsDataAPI", th);
                    }
                }
                this.f24873b = true;
            }
            this.f24874c = Integer.valueOf(this.f24874c.intValue() + 1);
        }
    }

    public void onActivityResumed(Activity activity) {
        boolean z = this.f24872a.f24858s == null || !this.f24872a.f24858s.contains(activity.getClass().getCanonicalName());
        if (this.f24872a.f24850k && z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("screen_name", activity.getClass().getCanonicalName());
                try {
                    String charSequence = activity.getTitle().toString();
                    ActionBar actionBar = activity.getActionBar();
                    if (actionBar != null && !TextUtils.isEmpty(actionBar.getTitle())) {
                        charSequence = actionBar.getTitle().toString();
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        PackageManager packageManager = activity.getPackageManager();
                        if (packageManager != null) {
                            ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 0);
                            if (activityInfo != null) {
                                charSequence = activityInfo.loadLabel(packageManager).toString();
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        jSONObject.put("title", charSequence);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (activity instanceof C7344ad) {
                    C7344ad adVar = (C7344ad) activity;
                    String a = adVar.mo35842a();
                    JSONObject b = adVar.mo35843b();
                    if (b != null) {
                        StatisticsDataAPI.m31654b(b, jSONObject);
                    }
                    this.f24872a.trackViewScreen(a, jSONObject);
                    return;
                }
                this.f24872a.track("AppViewScreen", jSONObject);
            } catch (Exception e2) {
                Log.w("StatisticsDataAPI", e2);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        synchronized (this.f24874c) {
            this.f24874c = Integer.valueOf(this.f24874c.intValue() - 1);
            if (this.f24874c.intValue() == 0) {
                if (this.f24872a.f24850k) {
                    try {
                        this.f24872a.track("AppEnd");
                    } catch (Exception e) {
                        Log.w("StatisticsDataAPI", e);
                    }
                }
                try {
                    if (C7468g.m32347g(this.f24872a.f24854o)) {
                        this.f24872a.f24855p.mo35834a();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return;
    }
}
