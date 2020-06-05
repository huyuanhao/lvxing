package com.bytedance.embed_device_register;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.embedapplog.IOaidObserver;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.embed_device_register.b */
public final class C1779b {
    /* renamed from: a */
    private static final String f4928a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(C1779b.class.getSimpleName());
        sb.append("#");
        f4928a = sb.toString();
    }

    /* renamed from: a */
    public static void m6171a(Context context, SharedPreferences sharedPreferences) {
        C1790g.m6215a(context, sharedPreferences);
    }

    /* renamed from: a */
    public static String m6169a(SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String a = C1778a.m6168a(sharedPreferences);
        StringBuilder sb = new StringBuilder();
        sb.append(f4928a);
        sb.append("getCdid takes ");
        sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
        sb.append(" ms");
        C1780c.m6176a("TrackerDr", sb.toString());
        return a;
    }

    /* renamed from: b */
    public static Map<String, String> m6173b(Context context, SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, String> b = C1790g.m6218b(context, sharedPreferences);
        StringBuilder sb = new StringBuilder();
        sb.append(f4928a);
        sb.append("getOaid takes ");
        sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
        sb.append(" ms");
        C1780c.m6176a("TrackerDr", sb.toString());
        return b;
    }

    /* renamed from: a */
    public static String m6170a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    /* renamed from: a */
    public static void m6172a(IOaidObserver iOaidObserver) {
        C1790g.m6217a(iOaidObserver);
    }
}
