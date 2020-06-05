package com.qiyukf.basesdk.p394b.p395a.p397b.p402e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.basesdk.b.a.b.e.b */
public class C5308b {
    /* renamed from: a */
    private static final String f17210a = C5309c.m21831a(C5308b.class);

    /* renamed from: a */
    private static String m21819a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, null);
    }

    /* renamed from: a */
    private static String m21820a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        int i = 0;
        String str = "";
        while (i < jSONArray.length()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(jSONArray.getString(i));
                str = sb.toString();
                if (i != jSONArray.length() - 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(";");
                    str = sb2.toString();
                }
                i++;
            } catch (JSONException e) {
                C5264a.m21621b(f17210a, "get json string exception", e);
            }
        }
        return str;
    }

    /* renamed from: a */
    private static void m21821a(Context context, String str, String str2) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    /* renamed from: a */
    public static void m21822a(Context context, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("lbs");
            String str = f17210a;
            StringBuilder sb = new StringBuilder("lbs ip: ");
            sb.append(string);
            C5264a.m21624d(str, sb.toString());
            String a = m21820a(jSONObject.getJSONArray("upload"));
            String str2 = f17210a;
            StringBuilder sb2 = new StringBuilder("upload server ip string: ");
            sb2.append(a);
            C5264a.m21624d(str2, sb2.toString());
            if (!TextUtils.isEmpty(string)) {
                m21821a(context, "netease_pomelo_nos_lbs", string);
            }
            if (!TextUtils.isEmpty(a)) {
                m21821a(context, "netease_pomelo_nos_server", a);
                String str3 = f17210a;
                StringBuilder sb3 = new StringBuilder("save http upload server ip: ");
                sb3.append(a);
                C5264a.m21624d(str3, sb3.toString());
                String replaceAll = a.replaceAll("http://", "https://");
                m21821a(context, "netease_pomelo_nos_https_server", replaceAll);
                String str4 = f17210a;
                StringBuilder sb4 = new StringBuilder("save https upload server ip: ");
                sb4.append(replaceAll);
                C5264a.m21624d(str4, sb4.toString());
            }
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("netease_pomelo_nos_last_save_time", currentTimeMillis);
            edit.commit();
            C5264a.m21624d(f17210a, "save lbs response data");
        } catch (JSONException e) {
            C5264a.m21621b(f17210a, "get json array exception", e);
        }
    }

    /* renamed from: a */
    public static boolean m21823a(Context context) {
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("netease_pomelo_nos_last_save_time", 0);
        boolean z = false;
        if (j <= 0) {
            return false;
        }
        if (System.currentTimeMillis() - j <= 86400000) {
            z = true;
        }
        if (!z) {
            m21821a(context, "netease_pomelo_nos_lbs", null);
        }
        return z;
    }

    /* renamed from: a */
    public static String[] m21824a(Context context, boolean z) {
        String a = m21819a(context, !z ? "netease_pomelo_nos_server" : "netease_pomelo_nos_https_server");
        if (a == null) {
            return null;
        }
        return a.split(";");
    }

    /* renamed from: b */
    public static String m21825b(Context context) {
        return m21819a(context, "netease_pomelo_nos_lbs");
    }

    /* renamed from: c */
    public static void m21826c(Context context) {
        m21821a(context, "netease_pomelo_nos_lbs", null);
    }
}
