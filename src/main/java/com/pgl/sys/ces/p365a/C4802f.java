package com.pgl.sys.ces.p365a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.pgl.p359a.p361b.C4786d;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.pgl.sys.ces.a.f */
public class C4802f {

    /* renamed from: com.pgl.sys.ces.a.f$a */
    static class C4803a implements Comparator<Object> {
        C4803a() {
        }

        public final int compare(Object obj, Object obj2) {
            int abs = Math.abs(((ScanResult) obj).level);
            int abs2 = Math.abs(((ScanResult) obj2).level);
            if (abs > abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    /* renamed from: a */
    public static String m19655a(Context context) {
        String str;
        String str2 = "[<!>]";
        String str3 = "";
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            String bssid = connectionInfo.getBSSID();
            String trim = bssid == null ? str3 : bssid.trim();
            String ssid = connectionInfo.getSSID();
            String replace = (ssid == null ? str3 : ssid.trim()).replace(' ', ' ').replace('\'', ' ').replace('\"', ' ');
            String num = Integer.toString(connectionInfo.getIpAddress());
            String trim2 = num == null ? str3 : num.trim();
            StringBuilder sb = new StringBuilder();
            sb.append(trim);
            sb.append(str2);
            sb.append(replace);
            sb.append(str2);
            sb.append(trim2);
            sb.append(str2);
            str = sb.toString();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? str3 : str.trim();
    }

    /* renamed from: b */
    public static String m19656b(Context context) {
        String str;
        String str2 = "_";
        String str3 = "\"";
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            C4786d.m19619a("Context Instance is null...");
            return jSONArray.toString();
        }
        try {
            List scanResults = ((WifiManager) context.getSystemService("wifi")).getScanResults();
            if (scanResults != null) {
                if (scanResults.size() > 0) {
                    Collections.sort(scanResults, new C4803a());
                    int i = 0;
                    while (true) {
                        if (i < scanResults.size()) {
                            if (i >= 10) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("ss", ((ScanResult) scanResults.get(i)).SSID.replaceAll(str3, str2));
                                jSONObject.put("bs", ((ScanResult) scanResults.get(i)).BSSID.replaceAll(str3, str2));
                                jSONArray.put(jSONObject);
                            } catch (JSONException unused) {
                            }
                            i++;
                        }
                    }
                    str = jSONArray.toString();
                    return str == null ? "[]" : str.trim();
                }
            }
            C4786d.m19619a("WifiList is null");
            return jSONArray.toString();
        } catch (Throwable unused2) {
            str = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    public static java.lang.String m19657c(android.content.Context r6) {
        /*
        java.lang.String r0 = ""
        r1 = 0
        java.lang.String r2 = "location"
        java.lang.Object r6 = r6.getSystemService(r2)     // Catch:{ all -> 0x007c }
        android.location.LocationManager r6 = (android.location.LocationManager) r6     // Catch:{ all -> 0x007c }
        java.lang.String r2 = "gps"
        android.location.Location r2 = r6.getLastKnownLocation(r2)     // Catch:{ all -> 0x007c }
        java.lang.String r3 = ","
        if (r2 == 0) goto L_0x0034
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
        r6.<init>()     // Catch:{ all -> 0x007c }
        r6.append(r0)     // Catch:{ all -> 0x007c }
        double r4 = r2.getLongitude()     // Catch:{ all -> 0x007c }
        r6.append(r4)     // Catch:{ all -> 0x007c }
        r6.append(r3)     // Catch:{ all -> 0x007c }
        double r2 = r2.getLatitude()     // Catch:{ all -> 0x007c }
        r6.append(r2)     // Catch:{ all -> 0x007c }
    L_0x002e:
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x007c }
    L_0x0032:
        r1 = r6
        goto L_0x007d
    L_0x0034:
        java.lang.String r2 = "network"
        android.location.Location r2 = r6.getLastKnownLocation(r2)     // Catch:{ all -> 0x007c }
        if (r2 == 0) goto L_0x0056
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
        r6.<init>()     // Catch:{ all -> 0x007c }
        r6.append(r0)     // Catch:{ all -> 0x007c }
        double r4 = r2.getLongitude()     // Catch:{ all -> 0x007c }
        r6.append(r4)     // Catch:{ all -> 0x007c }
        r6.append(r3)     // Catch:{ all -> 0x007c }
        double r2 = r2.getLatitude()     // Catch:{ all -> 0x007c }
        r6.append(r2)     // Catch:{ all -> 0x007c }
        goto L_0x002e
    L_0x0056:
        java.lang.String r2 = "passive"
        android.location.Location r6 = r6.getLastKnownLocation(r2)     // Catch:{ all -> 0x007c }
        if (r6 == 0) goto L_0x007d
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
        r2.<init>()     // Catch:{ all -> 0x007c }
        r2.append(r0)     // Catch:{ all -> 0x007c }
        double r4 = r6.getLongitude()     // Catch:{ all -> 0x007c }
        r2.append(r4)     // Catch:{ all -> 0x007c }
        r2.append(r3)     // Catch:{ all -> 0x007c }
        double r3 = r6.getLatitude()     // Catch:{ all -> 0x007c }
        r2.append(r3)     // Catch:{ all -> 0x007c }
        java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x007c }
        goto L_0x0032
    L_0x007d:
        if (r1 != 0) goto L_0x0080
        goto L_0x0084
    L_0x0080:
        java.lang.String r0 = r1.trim()
    L_0x0084:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.ces.p365a.C4802f.m19657c(android.content.Context):java.lang.String");
    }
}
