package com.kwad.sdk.p306a;

import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4321b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.a.e */
public class C3800e {
    /* renamed from: a */
    public static <T> List<T> m15744a(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static JSONArray m15745a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static void m15746a(JSONArray jSONArray, JSONObject jSONObject) {
        jSONArray.put(jSONObject);
    }

    /* renamed from: a */
    public static void m15747a(JSONObject jSONObject, String str, double d) {
        try {
            jSONObject.put(str, d);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public static void m15748a(JSONObject jSONObject, String str, float f) {
        try {
            jSONObject.put(str, (double) f);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public static void m15749a(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public static void m15750a(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public static void m15751a(JSONObject jSONObject, String str, C4321b bVar) {
        if (bVar != null) {
            try {
                jSONObject.put(str, bVar.toJson());
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m15752a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public static void m15753a(JSONObject jSONObject, String str, List<? extends C4321b> list) {
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            for (C4321b json : list) {
                m15746a(jSONArray, json.toJson());
            }
            m15754a(jSONObject, str, jSONArray);
        }
    }

    /* renamed from: a */
    public static void m15754a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public static void m15755a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public static void m15756a(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
        } catch (JSONException unused) {
        }
    }
}
