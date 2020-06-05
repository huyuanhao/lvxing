package com.bytedance.sdk.adnet.p160c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.p161d.C1987d;
import com.bytedance.sdk.adnet.p161d.MultiProcessFileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.adnet.c.e */
public class TNCConfigHandler {
    /* renamed from: d */
    private static final Object f6162d = new Object();
    /* renamed from: a */
    private Context f6163a;
    /* renamed from: b */
    private TNCConfig f6164b;
    /* renamed from: c */
    private boolean f6165c = true;

    public TNCConfigHandler(Context context, boolean z) {
        this.f6163a = context;
        this.f6165c = z;
        this.f6164b = new TNCConfig();
    }

    /* renamed from: a */
    public void mo14241a(JSONObject jSONObject) {
        String str;
        if (!this.f6165c) {
            C1987d.m7948b("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        TNCManager.m7771a().mo14246b();
        String str2 = "";
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (AdNetSdk.m7650b() && z && optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = ((JSONObject) optJSONArray.get(i)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    jSONObject2 = new JSONObject();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObject4 = (JSONObject) it.next();
                        Iterator keys = jSONObject4.keys();
                        while (keys.hasNext()) {
                            String str3 = (String) keys.next();
                            jSONObject2.put(str3, jSONObject4.getString(str3));
                        }
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tnc_config");
            if (optJSONObject == null && jSONObject2 == null) {
                C1987d.m7947a("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                optJSONObject.put("host_replace_map", jSONObject2);
            }
            TNCConfig b = m7766b(optJSONObject);
            String str4 = "TNCConfigHandler";
            StringBuilder sb = new StringBuilder();
            sb.append("handleConfigChanged, newConfig: ");
            if (b == null) {
                str = "null";
            } else {
                str = b.toString();
            }
            sb.append(str);
            C1987d.m7948b(str4, sb.toString());
            if (b == null) {
                synchronized (f6162d) {
                    this.f6163a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", str2).apply();
                    MultiProcessFileUtils.m7953a(this.f6163a, 1, str2);
                }
                return;
            }
            this.f6164b = b;
            String jSONObject5 = optJSONObject.toString();
            synchronized (f6162d) {
                this.f6163a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", jSONObject5).apply();
                MultiProcessFileUtils.m7953a(this.f6163a, 1, jSONObject5);
            }
        } catch (Throwable th) {
            synchronized (f6162d) {
                this.f6163a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", str2).apply();
                MultiProcessFileUtils.m7953a(this.f6163a, 1, str2);
                throw th;
            }
        }
    }

    /* renamed from: a */
    public void mo14240a() {
        if (this.f6165c) {
            String string = this.f6163a.getSharedPreferences("ttnet_tnc_config", 0).getString("tnc_config_str", null);
            String str = "TNCConfigHandler";
            if (TextUtils.isEmpty(string)) {
                C1987d.m7948b(str, "loadLocalConfig: no existed");
                return;
            }
            try {
                TNCConfig b = m7766b(new JSONObject(string));
                if (b != null) {
                    this.f6164b = b;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(b == null ? "null" : b.toString());
                C1987d.m7948b(str, sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("loadLocalConfig: except: ");
                sb2.append(th.getMessage());
                C1987d.m7948b(str, sb2.toString());
            }
        }
    }

    /* renamed from: b */
    public void mo14242b() {
        String str;
        String str2 = "TNCConfigHandler";
        try {
            String a = MultiProcessFileUtils.m7952a(this.f6163a, 1);
            if (TextUtils.isEmpty(a)) {
                C1987d.m7948b(str2, "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            TNCConfig b = m7766b(new JSONObject(a));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            if (b == null) {
                str = "null";
            } else {
                str = b.toString();
            }
            sb.append(str);
            C1987d.m7948b(str2, sb.toString());
            if (b != null) {
                this.f6164b = b;
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadLocalConfigForOtherProcess, except: ");
            sb2.append(th.getMessage());
            C1987d.m7948b(str2, sb2.toString());
        }
    }

    /* renamed from: c */
    public TNCConfig mo14243c() {
        return this.f6164b;
    }

    /* renamed from: b */
    private TNCConfig m7766b(JSONObject jSONObject) {
        String str = "host_replace_map";
        String str2 = "local_host_filter";
        String str3 = "probe_enable";
        String str4 = "local_enable";
        try {
            TNCConfig dVar = new TNCConfig();
            boolean z = true;
            if (jSONObject.has(str4)) {
                dVar.f6147a = jSONObject.getInt(str4) != 0;
            }
            if (jSONObject.has(str3)) {
                if (jSONObject.getInt(str3) == 0) {
                    z = false;
                }
                dVar.f6148b = z;
            }
            if (jSONObject.has(str2)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str2);
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, Integer.valueOf(0));
                        }
                    }
                }
                dVar.f6149c = hashMap;
            } else {
                dVar.f6149c = null;
            }
            if (jSONObject.has(str)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String str5 = (String) keys.next();
                        String string2 = jSONObject2.getString(str5);
                        if (!TextUtils.isEmpty(str5)) {
                            if (!TextUtils.isEmpty(string2)) {
                                hashMap2.put(str5, string2);
                            }
                        }
                    }
                }
                dVar.f6150d = hashMap2;
            } else {
                dVar.f6150d = null;
            }
            dVar.f6151e = jSONObject.optInt("req_to_cnt", dVar.f6151e);
            dVar.f6152f = jSONObject.optInt("req_to_api_cnt", dVar.f6152f);
            dVar.f6153g = jSONObject.optInt("req_to_ip_cnt", dVar.f6153g);
            dVar.f6154h = jSONObject.optInt("req_err_cnt", dVar.f6154h);
            dVar.f6155i = jSONObject.optInt("req_err_api_cnt", dVar.f6155i);
            dVar.f6156j = jSONObject.optInt("req_err_ip_cnt", dVar.f6156j);
            dVar.f6157k = jSONObject.optInt("update_interval", dVar.f6157k);
            dVar.f6158l = jSONObject.optInt("update_random_range", dVar.f6158l);
            dVar.f6159m = jSONObject.optString("http_code_black", dVar.f6159m);
            return dVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
