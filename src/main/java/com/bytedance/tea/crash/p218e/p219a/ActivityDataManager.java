package com.bytedance.tea.crash.p218e.p219a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.e.a.b */
public class ActivityDataManager {
    /* renamed from: a */
    private Application f9291a;
    /* renamed from: b */
    private Context f9292b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<String> f9293c = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: d */
    public List<Long> f9294d = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<String> f9295e = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: f */
    public List<Long> f9296f = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: g */
    public String f9297g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public long f9298h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public String f9299i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public long f9300j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public String f9301k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public long f9302l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public String f9303m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public long f9304n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public String f9305o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public long f9306p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public int f9307q;
    /* renamed from: r */
    private final ActivityLifecycleCallbacks f9308r = new ActivityLifecycleCallbacks() {
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            ActivityDataManager.this.f9297g = activity.getClass().getName();
            ActivityDataManager.this.f9298h = System.currentTimeMillis();
            ActivityDataManager.this.f9293c.add(ActivityDataManager.this.f9297g);
            ActivityDataManager.this.f9294d.add(Long.valueOf(ActivityDataManager.this.f9298h));
        }

        public void onActivityStarted(Activity activity) {
            ActivityDataManager.this.f9299i = activity.getClass().getName();
            ActivityDataManager.this.f9300j = System.currentTimeMillis();
        }

        public void onActivityResumed(Activity activity) {
            ActivityDataManager.this.f9301k = activity.getClass().getName();
            ActivityDataManager.this.f9302l = System.currentTimeMillis();
            ActivityDataManager.this.f9307q = ActivityDataManager.this.f9307q + 1;
        }

        public void onActivityPaused(Activity activity) {
            ActivityDataManager.this.f9303m = activity.getClass().getName();
            ActivityDataManager.this.f9304n = System.currentTimeMillis();
            ActivityDataManager.this.f9307q = ActivityDataManager.this.f9307q - 1;
        }

        public void onActivityStopped(Activity activity) {
            ActivityDataManager.this.f9305o = activity.getClass().getName();
            ActivityDataManager.this.f9306p = System.currentTimeMillis();
        }

        public void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            int indexOf = ActivityDataManager.this.f9293c.indexOf(name);
            if (indexOf > -1 && indexOf < ActivityDataManager.this.f9293c.size()) {
                ActivityDataManager.this.f9293c.remove(indexOf);
                ActivityDataManager.this.f9294d.remove(indexOf);
            }
            ActivityDataManager.this.f9295e.add(name);
            ActivityDataManager.this.f9296f.add(Long.valueOf(System.currentTimeMillis()));
        }
    };

    ActivityDataManager(Context context) {
        this.f9292b = context;
        if (this.f9292b instanceof Application) {
            this.f9291a = (Application) context;
        }
        m12417c();
    }

    /* renamed from: c */
    private void m12417c() {
        if (VERSION.SDK_INT >= 14) {
            Application application = this.f9291a;
            if (application != null) {
                application.registerActivityLifecycleCallbacks(this.f9308r);
            }
        }
    }

    /* renamed from: d */
    private JSONArray m12421d() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f9293c;
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < this.f9293c.size()) {
                try {
                    jSONArray.put(m12410a((String) this.f9293c.get(i), ((Long) this.f9294d.get(i)).longValue()));
                    i++;
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: e */
    private JSONArray m12425e() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f9295e;
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < this.f9295e.size()) {
                try {
                    jSONArray.put(m12410a((String) this.f9295e.get(i), ((Long) this.f9296f.get(i)).longValue()));
                    i++;
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    private JSONObject m12410a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ArgKey.KEY_NAME, str);
            jSONObject.put("time", j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: a */
    public JSONObject mo17025a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", m12410a(this.f9297g, this.f9298h));
            jSONObject.put("last_start_activity", m12410a(this.f9299i, this.f9300j));
            jSONObject.put("last_resume_activity", m12410a(this.f9301k, this.f9302l));
            jSONObject.put("last_pause_activity", m12410a(this.f9303m, this.f9304n));
            jSONObject.put("last_stop_activity", m12410a(this.f9305o, this.f9306p));
            jSONObject.put("alive_activities", m12421d());
            jSONObject.put("finish_activities", m12425e());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    public JSONArray mo17026b() {
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.f9292b.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager == null) {
                return jSONArray;
            }
            List<RunningTaskInfo> runningTasks = activityManager.getRunningTasks(5);
            if (runningTasks == null) {
                return jSONArray;
            }
            for (RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null) {
                    if (runningTaskInfo.baseActivity != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", runningTaskInfo.id);
                            jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                            jSONObject.put("description", runningTaskInfo.description);
                            jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                            jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                            jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                            jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
            return jSONArray;
        } catch (Exception unused2) {
        }
    }
}
