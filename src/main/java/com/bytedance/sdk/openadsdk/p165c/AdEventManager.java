package com.bytedance.sdk.openadsdk.p165c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.SecSdkHelper;
import com.bytedance.sdk.openadsdk.core.p168b.FrequentCallEventHelper;
import com.bytedance.sdk.openadsdk.core.p170d.ClickEventModel;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.DislikeDispatcher;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import discoveryAD.C7880W.C7881a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.c.d */
public class AdEventManager {
    /* renamed from: a */
    public static void m8392a(MaterialMeta kVar) {
    }

    /* renamed from: a */
    public static void m8389a(Context context, MaterialMeta kVar, String str, Map<String, Object> map) {
        Context a = context == null ? InternalContainer.m10059a() : context;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", DeviceUtils.m12167d(a).toString());
            jSONObject2.put("is_cache", kVar.mo15434V() ? 1 : 0);
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", kVar.mo15428P());
            float floatValue = Double.valueOf(((double) (System.currentTimeMillis() / 1000)) - ToolUtils.m12030g(kVar.mo15428P())).floatValue();
            String str2 = "show_time";
            if (floatValue <= 0.0f) {
                floatValue = 0.0f;
            }
            jSONObject.putOpt(str2, Float.valueOf(floatValue));
        } catch (JSONException unused) {
        }
        InternalContainer.m10064c().mo14998a(AdEvent.m8353a(a, str, "show", kVar.mo15425M(), jSONObject));
        String a2 = IdUtils.m9858a(InternalContainer.m10059a());
        if (!TextUtils.isEmpty(a2)) {
            InternalContainer.m10068g().mo16824a(a2, kVar.mo15420H(), true);
        }
        if (C2564t.m12224c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("show ");
            sb.append(kVar.mo15425M());
            C2564t.m12222c("AdEvent", sb.toString());
        }
        if (!TextUtils.isEmpty(IdUtils.m9858a(context))) {
            SecSdkHelper.m10148b(IdUtils.m9858a(context)).mo15924c("AdShow");
        }
    }

    /* renamed from: a */
    public static void m8393a(MaterialMeta kVar, String str, String str2, long j) {
        String str3 = "load_ad_duration";
        String str4 = "download_creative_duration";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", DeviceUtils.m12167d(InternalContainer.m10059a()).toString());
            if (str2.equals(str4)) {
                jSONObject2.put(str4, j);
            } else if (str2.equals(str3)) {
                jSONObject2.put(str3, j);
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", kVar.mo15428P());
        } catch (JSONException unused) {
        }
        InternalContainer.m10064c().mo14998a(AdEvent.m8353a(InternalContainer.m10059a(), str, str2, kVar.mo15425M(), jSONObject));
    }

    /* renamed from: a */
    public static void m8394a(MaterialMeta kVar, String str, Map<String, Object> map) {
        Context a = InternalContainer.m10059a();
        JSONObject jSONObject = new JSONObject();
        String str2 = "load_ad_duration";
        if (map == null || map.size() <= 0) {
            m8401c(a, kVar, str, str2);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", DeviceUtils.m12167d(a).toString());
            Object remove = map.remove("total_time");
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            String str3 = "duration";
            if (remove instanceof Long) {
                jSONObject.put(str3, remove);
            } else {
                jSONObject.put(str3, 0);
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(a, kVar, str, str2, jSONObject);
    }

    /* renamed from: a */
    public static void m8391a(Context context, String str, MaterialMeta kVar, ClickEventModel eVar, String str2, boolean z, Map<String, Object> map) {
        if (context == null) {
            context = InternalContainer.m10059a();
        }
        JSONObject jSONObject = new JSONObject();
        if (eVar != null) {
            try {
                JSONObject a = eVar.mo15359a();
                a.put("device", DeviceUtils.m12167d(context).toString());
                a.put("is_valid", z);
                if (map != null) {
                    for (Entry entry : map.entrySet()) {
                        a.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", a.toString());
            } catch (JSONException unused) {
            }
        }
        jSONObject.putOpt("log_extra", kVar.mo15428P());
        float floatValue = Double.valueOf(((double) (System.currentTimeMillis() / 1000)) - ToolUtils.m12030g(kVar.mo15428P())).floatValue();
        String str3 = "show_time";
        if (floatValue <= 0.0f) {
            floatValue = 0.0f;
        }
        jSONObject.putOpt(str3, Float.valueOf(floatValue));
        InternalContainer.m10064c().mo14998a(AdEvent.m8353a(context, str2, str, kVar.mo15425M(), jSONObject));
        String a2 = IdUtils.m9858a(InternalContainer.m10059a());
        if (!TextUtils.isEmpty(a2) && "click".equals(str)) {
            InternalContainer.m10068g().mo16824a(a2, kVar.mo15421I(), true);
        }
        if (C2564t.m12224c()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(kVar.mo15425M());
            C2564t.m12222c("AdEvent", sb.toString());
        }
    }

    /* renamed from: b */
    public static void m8400b(Context context, MaterialMeta kVar, String str, Map<String, Object> map) {
        if (context == null) {
            context = InternalContainer.m10059a();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", kVar.mo15428P());
        } catch (Exception unused) {
        }
        InternalContainer.m10064c().mo14998a(AdEvent.m8353a(context, str, "render_h5_detect", kVar.mo15425M(), jSONObject));
    }

    /* renamed from: a */
    public static void m8388a(Context context, MaterialMeta kVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m8403c(context, kVar, str, str2, jSONObject2);
            return;
        }
        m8401c(context, kVar, str, str2);
    }

    /* renamed from: a */
    public static void m8387a(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str, str2);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: a */
    public static void m8380a(Context context, MaterialMeta kVar) {
        m8401c(context, kVar, "install_warn", "install_again");
    }

    /* renamed from: c */
    public static void m8404c(Context context, MaterialMeta kVar, String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        String str2 = "install_warn";
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str2, str);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str2, str, jSONObject);
    }

    /* renamed from: b */
    public static void m8398b(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str, str2);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: c */
    public static void m8402c(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str, str2);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: a */
    public static void m8384a(Context context, MaterialMeta kVar, String str, String str2, int i, String str3, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fail_status", i);
            jSONObject.put("fail_msg", str3);
            if (map != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: d */
    public static void m8405d(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str, str2);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: a */
    public static void m8385a(Context context, MaterialMeta kVar, String str, String str2, int i, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_value", i);
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: e */
    public static void m8406e(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str, str2);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: f */
    public static void m8407f(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str, str2);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: g */
    public static void m8408g(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str, str2);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: h */
    public static void m8409h(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            m8401c(context, kVar, str, str2);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: i */
    public static void m8410i(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("refer", "auto_control");
            if (map != null && map.size() > 0) {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: a */
    public static void m8395a(MaterialMeta kVar, List<FilterWord> list) {
        DislikeDispatcher.m11044a().mo16452a(kVar, list);
        if (C2564t.m12224c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("tt_dislike_icon ");
            sb.append(kVar.mo15425M());
            C2564t.m12222c("AdEvent", sb.toString());
        }
    }

    /* renamed from: a */
    public static void m8379a(Context context, long j, MaterialMeta kVar) {
        if (context != null && kVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m8403c(context, kVar, "splash_ad", "skip", jSONObject);
        }
    }

    /* renamed from: a */
    public static void m8381a(Context context, MaterialMeta kVar, String str) {
        m8401c(context, kVar, str, "click_close");
    }

    /* renamed from: j */
    public static void m8411j(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                C2564t.m12219b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        m8403c(context, kVar, str, str2, jSONObject2);
    }

    /* renamed from: k */
    public static void m8412k(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                C2564t.m12219b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        m8403c(context, kVar, str, str2, jSONObject2);
    }

    /* renamed from: l */
    public static void m8413l(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        m8414m(context, kVar, str, str2, map);
    }

    /* renamed from: m */
    public static void m8414m(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                C2564t.m12219b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        m8403c(context, kVar, str, str2, jSONObject2);
    }

    /* renamed from: a */
    public static void m8386a(Context context, MaterialMeta kVar, String str, String str2, long j, int i, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("duration", j);
            jSONObject.put("percent", i);
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: n */
    public static void m8415n(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: o */
    public static void m8416o(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: a */
    public static void m8382a(Context context, MaterialMeta kVar, String str, String str2) {
        m8401c(context, kVar, str, str2);
    }

    /* renamed from: b */
    public static void m8397b(Context context, MaterialMeta kVar, String str, String str2) {
        m8401c(context, kVar, str, str2);
    }

    /* renamed from: p */
    public static void m8417p(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: q */
    public static void m8418q(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("refer", str2);
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Throwable unused) {
        }
        m8403c(context, kVar, str, "click_open", jSONObject);
    }

    /* renamed from: c */
    private static void m8401c(Context context, MaterialMeta kVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", kVar.mo15428P());
        } catch (JSONException unused) {
        }
        InternalContainer.m10064c().mo14998a(AdEvent.m8353a(context, str, str2, kVar.mo15425M(), jSONObject));
        if (C2564t.m12224c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("tag: ");
            sb.append(str);
            sb.append("label: ");
            sb.append(str2);
            sb.append(" ");
            sb.append(kVar.mo15425M());
            C2564t.m12222c("AdEvent", sb.toString());
        }
    }

    /* renamed from: c */
    private static void m8403c(Context context, MaterialMeta kVar, String str, String str2, JSONObject jSONObject) {
        if (kVar != null) {
            if (jSONObject != null) {
                try {
                    jSONObject.putOpt("log_extra", kVar.mo15428P());
                } catch (JSONException unused) {
                }
            }
            InternalContainer.m10064c().mo14998a(AdEvent.m8353a(context, str, str2, kVar.mo15425M(), jSONObject));
            if (C2564t.m12224c()) {
                StringBuilder sb = new StringBuilder();
                sb.append("tag: ");
                sb.append(str);
                sb.append("label: ");
                sb.append(str2);
                sb.append(" ");
                sb.append(kVar.mo15425M());
                C2564t.m12222c("AdEvent", sb.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m8390a(Context context, String str, long j) {
        FrequentCallEventHelper.m9105a(context, str, j);
    }

    /* renamed from: a */
    public static void m8396a(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        String str4 = "ad_extra_data";
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String optString = jSONObject.optString(str4, null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                jSONObject2.put("device", DeviceUtils.m12167d(InternalContainer.m10059a()).toString());
                jSONObject.put(str4, jSONObject2.toString());
                jSONObject.put("tag", str2);
                if ("click".equals(str3)) {
                    float floatValue = Double.valueOf(((double) (System.currentTimeMillis() / 1000)) - ToolUtils.m12030g(jSONObject.optString("log_extra"))).floatValue();
                    String str5 = "show_time";
                    if (floatValue <= 0.0f) {
                        floatValue = 0.0f;
                    }
                    jSONObject.putOpt(str5, Float.valueOf(floatValue));
                }
            } catch (JSONException unused) {
            }
        }
        InternalContainer.m10064c().mo14998a(AdEvent.m8355a(str, str2, str3, j, j2, jSONObject));
        if (C2564t.m12224c()) {
            C2564t.m12222c("AdEvent", "sendJsAdEvent");
        }
    }

    /* renamed from: b */
    public static void m8399b(Context context, MaterialMeta kVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: r */
    public static void m8419r(Context context, MaterialMeta kVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        m8403c(context, kVar, str, str2, jSONObject);
    }

    /* renamed from: a */
    public static void m8383a(Context context, MaterialMeta kVar, String str, String str2, int i) {
        if (kVar != null && context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("color_percent", Integer.valueOf(i));
            if (kVar.mo15512z() != null) {
                hashMap.put("playable_url", kVar.mo15512z().mo15604h());
            }
            hashMap.put("memory_total", Integer.valueOf(ToolUtils.m12033h()));
            hashMap.put("memory_use", Integer.valueOf(ToolUtils.m12038j() - ToolUtils.m12036i()));
            hashMap.put("request_id", ToolUtils.m12034h(kVar.mo15428P()));
            hashMap.put(C7881a.TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
            m8419r(context, kVar, str, str2, hashMap);
        }
    }
}
