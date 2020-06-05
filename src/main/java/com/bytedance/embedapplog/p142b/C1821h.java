package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.bytedance.embedapplog.InitConfig;
import com.bytedance.embedapplog.p144d.C1838a;
import com.bytedance.embedapplog.util.C1855g;
import com.bytedance.embedapplog.util.C1856h;
import com.bytedance.embedapplog.util.C1857i;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.h */
public class C1821h {
    /* renamed from: a */
    private final Context f5103a;
    /* renamed from: b */
    private final InitConfig f5104b;
    /* renamed from: c */
    private final SharedPreferences f5105c = this.f5103a.getSharedPreferences("embed_header_custom", 0);
    /* renamed from: d */
    private final SharedPreferences f5106d = this.f5103a.getSharedPreferences("embed_last_sp_session", 0);
    /* renamed from: e */
    private final SharedPreferences f5107e = this.f5103a.getSharedPreferences("embed_applog_stats", 0);
    /* renamed from: f */
    private volatile JSONObject f5108f;
    /* renamed from: g */
    private volatile JSONObject f5109g;
    /* renamed from: h */
    private volatile HashSet<Integer> f5110h;

    /* access modifiers changed from: 0000 */
    /* renamed from: C */
    public String mo13368C() {
        return null;
    }

    /* renamed from: F */
    public long mo13371F() {
        return 10000;
    }

    /* renamed from: a */
    public void mo13387a(long j) {
    }

    /* renamed from: a */
    public void mo13390a(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    /* renamed from: a */
    public boolean mo13393a(ArrayList<C1838a> arrayList) {
        return true;
    }

    public C1821h(Context context, InitConfig initConfig) {
        this.f5103a = context;
        this.f5104b = initConfig;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo13386a() {
        return this.f5104b.getAliyunUdid();
    }

    /* renamed from: b */
    public String mo13394b() {
        return this.f5106d.getString("session_last_day", "");
    }

    /* renamed from: a */
    public void mo13389a(String str, int i) {
        this.f5106d.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    /* renamed from: c */
    public int mo13397c() {
        return this.f5106d.getInt("session_order", 0);
    }

    /* renamed from: d */
    public SharedPreferences mo13399d() {
        return this.f5107e;
    }

    /* renamed from: e */
    public boolean mo13402e() {
        return this.f5104b.isPlayEnable();
    }

    /* renamed from: f */
    public JSONObject mo13403f() {
        return this.f5109g;
    }

    /* renamed from: a */
    public void mo13392a(JSONObject jSONObject, boolean z, String str) {
        JSONObject jSONObject2 = jSONObject;
        if (C1856h.f5226b) {
            StringBuilder sb = new StringBuilder();
            sb.append("setConfig, ");
            sb.append(jSONObject.toString());
            C1856h.m6581a(sb.toString(), null);
        }
        this.f5109g = jSONObject2;
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.f5107e.edit();
        String str2 = "session_interval";
        long optInt = (long) jSONObject2.optInt(str2, 0);
        if (optInt <= 0 || optInt > 604800) {
            edit.remove(str2);
        } else {
            edit.putLong(str2, optInt * 1000);
        }
        String str3 = "batch_event_interval";
        long optInt2 = (long) jSONObject2.optInt(str3, 0);
        if (optInt2 <= 0 || optInt2 > 604800) {
            edit.remove(str3);
        } else {
            edit.putLong(str3, optInt2 * 1000);
        }
        String str4 = "send_launch_timely";
        int optInt3 = jSONObject2.optInt(str4, 0);
        if (optInt3 <= 0 || ((long) optInt3) > 604800) {
            edit.remove(str4);
        } else {
            edit.putInt(str4, optInt3);
        }
        String str5 = "abtest_fetch_interval";
        long optInt4 = (long) jSONObject2.optInt(str5, 0);
        if (optInt4 <= 20 || optInt4 > 604800) {
            edit.remove(str5);
        } else {
            edit.putLong(str5, optInt4 * 1000);
        }
        String str6 = "bav_log_collect";
        boolean optBoolean = jSONObject2.optBoolean(str6, true);
        if (optBoolean) {
            edit.putBoolean(str6, true);
        } else {
            edit.remove(str6);
        }
        C1856h.f5225a = optBoolean;
        String str7 = "bav_ab_config";
        if (jSONObject2.optBoolean(str7, false)) {
            edit.putBoolean(str7, true);
        } else {
            edit.remove(str7);
        }
        String str8 = "fingerprint_codes";
        JSONArray optJSONArray = jSONObject2.optJSONArray(str8);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            edit.remove(str8);
        } else {
            edit.putString(str8, optJSONArray.toString());
        }
        this.f5110h = null;
        String str9 = "bav_monitor_rate";
        int optInt5 = jSONObject2.optInt(str9, 0);
        if (optInt5 <= 0 || optInt5 > 100) {
            edit.remove(str9);
            C1855g.m6576a(false);
        } else {
            edit.putInt(str9, optInt5);
            C1855g.m6576a(true);
        }
        if (z) {
            edit.putLong("send_fingerprint_time", currentTimeMillis);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString("last_wifi_bssid", str);
            edit.putLong("last_check_bssid_time", currentTimeMillis);
        }
        edit.putLong("app_log_last_config_time", currentTimeMillis);
        edit.apply();
    }

    /* renamed from: g */
    public long mo13404g() {
        return this.f5107e.getLong("app_log_last_config_time", 0);
    }

    /* renamed from: h */
    public HashSet<Integer> mo13405h() {
        HashSet<Integer> hashSet = this.f5110h;
        if (hashSet == null) {
            try {
                JSONArray jSONArray = new JSONArray(this.f5107e.getString("fingerprint_codes", "[]"));
                int length = jSONArray.length();
                HashSet<Integer> hashSet2 = new HashSet<>(length);
                for (int i = 0; i < length; i++) {
                    int i2 = jSONArray.getInt(i);
                    if (i2 > 0) {
                        hashSet2.add(Integer.valueOf(i2));
                    }
                }
                hashSet = hashSet2;
            } catch (Throwable th) {
                C1856h.m6582a(th);
                hashSet = new HashSet<>();
            }
            this.f5110h = hashSet;
        }
        return hashSet;
    }

    /* renamed from: i */
    public Long mo13406i() {
        if (mo13405h().size() > 0) {
            return Long.valueOf(this.f5107e.getLong("send_fingerprint_time", 0));
        }
        return null;
    }

    /* renamed from: j */
    public String mo13407j() {
        return this.f5107e.getString("last_wifi_bssid", null);
    }

    /* renamed from: k */
    public Long mo13408k() {
        if (mo13405h().contains(Integer.valueOf(6))) {
            return Long.valueOf(this.f5107e.getLong("last_check_bssid_time", 0));
        }
        return null;
    }

    /* renamed from: l */
    public int mo13409l() {
        return this.f5107e.getInt("bav_monitor_rate", 0);
    }

    /* renamed from: m */
    public String mo13410m() {
        return this.f5104b.getAid();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public String mo13411n() {
        return this.f5104b.getChannel();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public String mo13412o() {
        return this.f5104b.getGoogleAid();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public String mo13413p() {
        return this.f5104b.getLanguage();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public String mo13414q() {
        return this.f5104b.getRegion();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13391a(JSONObject jSONObject) {
        this.f5105c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public String mo13415r() {
        return this.f5105c.getString("header_custom_info", null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13388a(String str) {
        this.f5105c.edit().putString("ab_sdk_version", str).apply();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public String mo13416s() {
        return this.f5105c.getString("ab_sdk_version", "");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo13395b(String str) {
        this.f5105c.edit().putString("user_unique_id", str).apply();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public String mo13417t() {
        return this.f5105c.getString("user_unique_id", null);
    }

    /* renamed from: u */
    public boolean mo13418u() {
        if (this.f5104b.getProcess() == 0) {
            this.f5104b.setProcess(!C1857i.m6587a(this.f5103a).contains(":"));
        }
        if (this.f5104b.getProcess() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: v */
    public long mo13419v() {
        return this.f5107e.getLong("abtest_fetch_interval", 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo13396b(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("setAbConfig, ");
        sb.append(jSONObject.toString());
        C1856h.m6581a(sb.toString(), null);
        this.f5105c.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f5108f = null;
    }

    /* renamed from: w */
    public String mo13420w() {
        if (!TextUtils.isEmpty(this.f5104b.getAbVersion())) {
            return this.f5104b.getAbVersion();
        }
        return this.f5105c.getString("ab_version", null);
    }

    /* renamed from: x */
    public JSONObject mo13421x() {
        JSONObject jSONObject = this.f5108f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (mo13422y()) {
                        jSONObject = new JSONObject(this.f5105c.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f5108f = jSONObject;
            }
        }
        return jSONObject;
    }

    /* renamed from: c */
    public JSONObject mo13398c(String str) {
        return mo13421x().optJSONObject(str);
    }

    /* renamed from: y */
    public boolean mo13422y() {
        return this.f5107e.getBoolean("bav_ab_config", false);
    }

    /* renamed from: z */
    public boolean mo13423z() {
        return this.f5107e.getBoolean("bav_log_collect", false);
    }

    /* renamed from: A */
    public long mo13366A() {
        return this.f5107e.getLong("session_interval", 30000);
    }

    /* renamed from: B */
    public long mo13367B() {
        return this.f5107e.getLong("batch_event_interval", 30000);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: D */
    public String mo13369D() {
        return this.f5104b.getReleaseBuild();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: E */
    public String mo13370E() {
        return this.f5107e.getString("user_agent", null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo13400d(String str) {
        this.f5107e.edit().putString("user_agent", str).apply();
    }

    /* renamed from: G */
    public String mo13372G() {
        return this.f5104b.getAppName();
    }

    /* renamed from: H */
    public int mo13373H() {
        return this.f5104b.getVersionCode();
    }

    /* renamed from: I */
    public int mo13374I() {
        return this.f5104b.getUpdateVersionCode();
    }

    /* renamed from: J */
    public int mo13375J() {
        return this.f5104b.getManifestVersionCode();
    }

    /* renamed from: K */
    public String mo13376K() {
        return this.f5104b.getVersion();
    }

    /* renamed from: L */
    public String mo13377L() {
        return this.f5104b.getTweakedChannel();
    }

    /* renamed from: M */
    public String mo13378M() {
        return this.f5104b.getAbClient();
    }

    /* renamed from: N */
    public String mo13379N() {
        return this.f5104b.getAbGroup();
    }

    /* renamed from: O */
    public String mo13380O() {
        return this.f5104b.getAbFeature();
    }

    /* renamed from: P */
    public String mo13381P() {
        return this.f5104b.getVersionMinor();
    }

    /* renamed from: Q */
    public String mo13382Q() {
        return this.f5104b.getAppImei() == null ? "" : this.f5104b.getAppImei();
    }

    /* renamed from: R */
    public boolean mo13383R() {
        return this.f5104b.isImeiEnable();
    }

    /* renamed from: S */
    public InitConfig mo13384S() {
        return this.f5104b;
    }

    /* renamed from: e */
    public void mo13401e(String str) {
        this.f5105c.edit().putString("ab_version", str).apply();
    }

    /* renamed from: T */
    public CharSequence mo13385T() {
        return this.f5104b.getZiJieCloudPkg();
    }
}
