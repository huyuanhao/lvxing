package com.bytedance.tea.crash.p216c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tea.crash.p218e.p219a.ActivityDataManager;
import com.bytedance.tea.crash.p221g.App;
import com.bytedance.tea.crash.p221g.NpthLog;
import com.bytedance.tea.crash.p221g.Stack;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import discoveryAD.C7880W.C7881a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.c.a */
public class CrashBody {
    /* renamed from: a */
    protected JSONObject f9273a;

    public CrashBody() {
        this.f9273a = new JSONObject();
    }

    public CrashBody(JSONObject jSONObject) {
        this.f9273a = jSONObject;
    }

    /* renamed from: a */
    public static CrashBody m12345a(long j, Context context, Thread thread, Throwable th) {
        String str;
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        CrashBody aVar = new CrashBody();
        aVar.mo16998a("isJava", (Object) Integer.valueOf(1));
        aVar.mo16998a("event_type", (Object) "java_crash");
        aVar.mo16998a(C7881a.TIMESTAMP, (Object) Long.valueOf(System.currentTimeMillis()));
        aVar.mo16998a("data", (Object) Stack.m12569a(th));
        aVar.mo16998a("isOOM", (Object) Boolean.valueOf(Stack.m12576b(th)));
        aVar.mo16998a("crash_time", (Object) Long.valueOf(j));
        aVar.mo16998a("process_name", (Object) App.m12504d(context));
        if (!App.m12502b(context)) {
            aVar.mo16998a("remote_process", (Object) Integer.valueOf(1));
        }
        App.m12497a(context, aVar.mo16997a());
        if (thread == null) {
            str = null;
        } else {
            str = thread.getName();
        }
        if (str != null) {
            aVar.mo16998a("crash_thread_name", (Object) str);
        }
        aVar.mo16998a("all_thread_stacks", (Object) Stack.m12572a(str));
        return aVar;
    }

    /* renamed from: a */
    public JSONObject mo16997a() {
        return this.f9273a;
    }

    /* renamed from: a */
    public CrashBody mo16991a(C2578b bVar) {
        mo16998a("header", (Object) bVar.mo17002a());
        return this;
    }

    /* renamed from: a */
    public CrashBody mo16990a(long j) {
        try {
            mo16998a("start_time", (Object) Long.valueOf(j));
            mo16998a("app_start_time_readable", (Object) new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /* renamed from: a */
    public CrashBody mo16993a(String str) {
        if (!TextUtils.isEmpty(str)) {
            mo16998a(AccountConst.KEY_SESSION_ID, (Object) str);
        }
        return this;
    }

    /* renamed from: a */
    public CrashBody mo16992a(ActivityDataManager bVar) {
        mo16998a("activity_trace", (Object) bVar.mo17025a());
        mo16998a("running_tasks", (Object) bVar.mo17026b());
        return this;
    }

    /* renamed from: a */
    public CrashBody mo16995a(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        String str = "plugin_info";
        if (map == null) {
            try {
                this.f9273a.put(str, jSONArray);
                return this;
            } catch (Exception unused) {
            }
        } else {
            for (String str2 : map.keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", str2);
                jSONObject.put("version_code", map.get(str2));
                jSONArray.put(jSONObject);
            }
            this.f9273a.put(str, jSONArray);
            return this;
        }
    }

    /* renamed from: b */
    public CrashBody mo17000b(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    NpthLog.m12550b(e);
                }
            }
            try {
                this.f9273a.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    /* renamed from: a */
    public CrashBody mo16989a(int i, String str) {
        try {
            this.f9273a.put("miniapp_id", i);
            this.f9273a.put("miniapp_version", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    /* renamed from: a */
    public CrashBody mo16994a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        String str = "patch_info";
        if (list == null || list.isEmpty()) {
            mo16998a(str, (Object) jSONArray);
            return this;
        }
        for (String put : list) {
            jSONArray.put(put);
        }
        mo16998a(str, (Object) jSONArray);
        return this;
    }

    /* renamed from: a */
    public CrashBody mo16996a(JSONObject jSONObject) {
        mo16998a("storage", (Object) jSONObject);
        return this;
    }

    /* renamed from: b */
    public CrashBody mo16999b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        mo16998a("logcat", (Object) jSONArray);
        return this;
    }

    /* renamed from: c */
    public CrashBody mo17001c(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            mo16998a("filters", (Object) jSONObject);
        }
        return this;
    }

    /* renamed from: a */
    public void mo16998a(String str, Object obj) {
        try {
            this.f9273a.put(str, obj);
        } catch (Exception e) {
            NpthLog.m12550b(e);
        }
    }
}
