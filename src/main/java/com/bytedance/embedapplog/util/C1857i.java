package com.bytedance.embedapplog.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.util.i */
public class C1857i {
    /* renamed from: a */
    private static String f5227a = null;
    /* renamed from: b */
    private static String f5228b = ":push";

    /* renamed from: a */
    public static String m6590a(boolean z) {
        return z ? "yes" : "no";
    }

    /* renamed from: a */
    public static boolean m6591a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static boolean m6592a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return m6591a((Object) jSONObject, (Object) jSONObject2);
        }
        return jSONObject.toString().equals(jSONObject2.toString());
    }

    /* renamed from: a */
    public static String m6587a(Context context) {
        String str = f5227a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            Iterator it = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                if (runningAppProcessInfo.pid == myPid) {
                    f5227a = runningAppProcessInfo.processName;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f5227a = m6586a();
        if (C1856h.f5226b) {
            StringBuilder sb = new StringBuilder();
            sb.append("getProcessName, ");
            sb.append(f5227a);
            C1856h.m6581a(sb.toString(), null);
        }
        return f5227a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC, Splitter:B:17:0x0049] */
    /* renamed from: a */
    private static java.lang.String m6586a() {
        /*
        r0 = 0
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0046 }
        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0046 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0046 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
        r4.<init>()     // Catch:{ all -> 0x0046 }
        java.lang.String r5 = "/proc/"
        r4.append(r5)     // Catch:{ all -> 0x0046 }
        int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0046 }
        r4.append(r5)     // Catch:{ all -> 0x0046 }
        java.lang.String r5 = "/cmdline"
        r4.append(r5)     // Catch:{ all -> 0x0046 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0046 }
        r3.<init>(r4)     // Catch:{ all -> 0x0046 }
        java.lang.String r4 = "iso-8859-1"
        r2.<init>(r3, r4)     // Catch:{ all -> 0x0046 }
        r1.<init>(r2)     // Catch:{ all -> 0x0046 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
        r2.<init>()     // Catch:{ all -> 0x0044 }
    L_0x0031:
        int r3 = r1.read()     // Catch:{ all -> 0x0044 }
        if (r3 <= 0) goto L_0x003c
        char r3 = (char) r3     // Catch:{ all -> 0x0044 }
        r2.append(r3)     // Catch:{ all -> 0x0044 }
        goto L_0x0031
    L_0x003c:
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0044 }
        r1.close()     // Catch:{ Exception -> 0x0043 }
    L_0x0043:
        return r0
        goto L_0x0047
    L_0x0046:
        r1 = r0
    L_0x0047:
        if (r1 == 0) goto L_0x004c
        r1.close()     // Catch:{ Exception -> 0x004c }
    L_0x004c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.util.C1857i.m6586a():java.lang.String");
    }

    /* renamed from: b */
    public static boolean m6594b(Context context) {
        String a = m6587a(context);
        return a != null && a.endsWith(f5228b);
    }

    /* renamed from: b */
    public static JSONObject m6593b(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                jSONObject.put(str, jSONObject2.opt(str));
            }
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static String m6589a(String str, HashMap<String, String> hashMap, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : hashMap.keySet()) {
            String a = m6588a(str3, str2);
            String str4 = (String) hashMap.get(str3);
            String a2 = str4 != null ? m6588a(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(a);
            sb.append("=");
            sb.append(a2);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m6588a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }
}
