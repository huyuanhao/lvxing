package com.bytedance.embedapplog.p143c;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.util.UriConfig;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.stat.common.DeviceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.c.a */
public class C1835a {
    /* renamed from: a */
    public static JSONObject f5134a;
    /* renamed from: b */
    static final String[] f5135b = {DeviceInfo.TAG_ANDROID_ID, "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    /* renamed from: c */
    public static final String[] f5136c;
    /* renamed from: d */
    private static final String[] f5137d = {"GET", "POST"};
    /* renamed from: e */
    private static final String[] f5138e;
    /* renamed from: f */
    private static UriConfig f5139f = UriConfig.creatUriConfig(0);

    static {
        String str = "tt_data";
        f5138e = new String[]{DeviceInfo.TAG_ANDROID_ID, "app_version", str, "device_id"};
        f5136c = new String[]{str, "device_platform"};
    }

    /* renamed from: a */
    private static String m6433a(String str) {
        String[] strArr;
        if (TextUtils.isEmpty(str) || !AppLog.getEncryptAndCompress()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        ArrayList<Pair> arrayList = new ArrayList<>();
        for (String str2 : f5138e) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (Pair pair : arrayList) {
            buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(AppLog.toEncryptByte(query), 8)));
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    public static String m6434a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d5 A[SYNTHETIC, Splitter:B:89:0x01d5] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01dc A[SYNTHETIC, Splitter:B:93:0x01dc] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e4  */
    /* renamed from: a */
    public static java.lang.String m6432a(int r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, byte[] r10) {
        /*
        java.lang.String r0 = "gzip"
        boolean r1 = com.bytedance.embedapplog.util.C1856h.f5226b
        r2 = 0
        if (r1 == 0) goto L_0x0089
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r3 = "http: "
        r1.append(r3)
        r1.append(r8)
        java.lang.String r1 = r1.toString()
        com.bytedance.embedapplog.util.C1856h.m6581a(r1, r2)
        if (r9 == 0) goto L_0x0072
        java.util.Set r1 = r9.entrySet()
        java.util.Iterator r1 = r1.iterator()
    L_0x0025:
        boolean r3 = r1.hasNext()
        if (r3 == 0) goto L_0x0072
        java.lang.Object r3 = r1.next()
        java.util.Map$Entry r3 = (java.util.Map.Entry) r3
        java.lang.Object r4 = r3.getKey()
        java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        boolean r4 = android.text.TextUtils.isEmpty(r4)
        if (r4 != 0) goto L_0x0025
        java.lang.Object r4 = r3.getValue()
        java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        boolean r4 = android.text.TextUtils.isEmpty(r4)
        if (r4 != 0) goto L_0x0025
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r5 = "http headers key:"
        r4.append(r5)
        java.lang.Object r5 = r3.getKey()
        java.lang.String r5 = (java.lang.String) r5
        r4.append(r5)
        java.lang.String r5 = " value:"
        r4.append(r5)
        java.lang.Object r3 = r3.getValue()
        java.lang.String r3 = (java.lang.String) r3
        r4.append(r3)
        java.lang.String r3 = r4.toString()
        com.bytedance.embedapplog.util.C1856h.m6581a(r3, r2)
        goto L_0x0025
    L_0x0072:
        if (r10 == 0) goto L_0x0089
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r3 = "http data length:"
        r1.append(r3)
        int r3 = r10.length
        r1.append(r3)
        java.lang.String r1 = r1.toString()
        com.bytedance.embedapplog.util.C1856h.m6581a(r1, r2)
    L_0x0089:
        java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x01cc }
        r1.<init>(r8)     // Catch:{ all -> 0x01cc }
        java.net.URLConnection r8 = r1.openConnection()     // Catch:{ all -> 0x01cc }
        java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ all -> 0x01cc }
        if (r7 != 0) goto L_0x009b
        r1 = 0
        r8.setDoOutput(r1)     // Catch:{ all -> 0x01cc }
        goto L_0x00a5
    L_0x009b:
        r1 = 1
        if (r7 != r1) goto L_0x00a2
        r8.setDoOutput(r1)     // Catch:{ all -> 0x01cc }
        goto L_0x00a5
    L_0x00a2:
        com.bytedance.embedapplog.util.C1856h.m6582a(r2)     // Catch:{ all -> 0x01cc }
    L_0x00a5:
        java.lang.String[] r1 = f5137d     // Catch:{ all -> 0x01cc }
        r7 = r1[r7]     // Catch:{ all -> 0x01cc }
        r8.setRequestMethod(r7)     // Catch:{ all -> 0x01cc }
        if (r9 == 0) goto L_0x00f4
        boolean r7 = r9.isEmpty()     // Catch:{ all -> 0x01cc }
        if (r7 != 0) goto L_0x00f4
        java.util.Set r7 = r9.entrySet()     // Catch:{ all -> 0x01cc }
        java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x01cc }
    L_0x00bc:
        boolean r9 = r7.hasNext()     // Catch:{ all -> 0x01cc }
        if (r9 == 0) goto L_0x00f4
        java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x01cc }
        java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x01cc }
        java.lang.Object r1 = r9.getKey()     // Catch:{ all -> 0x01cc }
        java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x01cc }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01cc }
        if (r1 != 0) goto L_0x00f0
        java.lang.Object r1 = r9.getValue()     // Catch:{ all -> 0x01cc }
        java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x01cc }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01cc }
        if (r1 != 0) goto L_0x00f0
        java.lang.Object r1 = r9.getKey()     // Catch:{ all -> 0x01cc }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x01cc }
        java.lang.Object r9 = r9.getValue()     // Catch:{ all -> 0x01cc }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x01cc }
        r8.addRequestProperty(r1, r9)     // Catch:{ all -> 0x01cc }
        goto L_0x00bc
    L_0x00f0:
        com.bytedance.embedapplog.util.C1856h.m6582a(r2)     // Catch:{ all -> 0x01cc }
        goto L_0x00bc
    L_0x00f4:
        java.lang.String r7 = "Accept-Encoding"
        r8.setRequestProperty(r7, r0)     // Catch:{ all -> 0x01cc }
        if (r10 == 0) goto L_0x0111
        int r7 = r10.length     // Catch:{ all -> 0x01cc }
        if (r7 <= 0) goto L_0x0111
        java.io.DataOutputStream r7 = new java.io.DataOutputStream     // Catch:{ all -> 0x01cc }
        java.io.OutputStream r9 = r8.getOutputStream()     // Catch:{ all -> 0x01cc }
        r7.<init>(r9)     // Catch:{ all -> 0x01cc }
        r7.write(r10)     // Catch:{ all -> 0x01c5 }
        r7.flush()     // Catch:{ all -> 0x01c5 }
        r7.close()     // Catch:{ all -> 0x01c5 }
        goto L_0x0112
    L_0x0111:
        r7 = r2
    L_0x0112:
        int r9 = r8.getResponseCode()     // Catch:{ all -> 0x01c5 }
        java.lang.String r10 = "http_code"
        r1 = 200(0xc8, float:2.8E-43)
        if (r9 != r1) goto L_0x0188
        int r9 = r8.getContentLength()     // Catch:{ all -> 0x01c5 }
        r3 = 10240(0x2800, float:1.4349E-41)
        if (r9 >= r3) goto L_0x0182
        java.io.InputStream r9 = r8.getInputStream()     // Catch:{ all -> 0x01c5 }
        java.lang.String r8 = r8.getContentEncoding()     // Catch:{ all -> 0x01c5 }
        boolean r8 = r0.equalsIgnoreCase(r8)     // Catch:{ all -> 0x01c5 }
        if (r8 == 0) goto L_0x0142
        java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x01c5 }
        java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x01c5 }
        java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x01c5 }
        r3.<init>(r9)     // Catch:{ all -> 0x01c5 }
        r0.<init>(r3)     // Catch:{ all -> 0x01c5 }
        r8.<init>(r0)     // Catch:{ all -> 0x01c5 }
        goto L_0x014c
    L_0x0142:
        java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x01c5 }
        java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x01c5 }
        r0.<init>(r9)     // Catch:{ all -> 0x01c5 }
        r8.<init>(r0)     // Catch:{ all -> 0x01c5 }
    L_0x014c:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x017b }
        int r9 = r9.available()     // Catch:{ all -> 0x017b }
        r0.<init>(r9)     // Catch:{ all -> 0x017b }
    L_0x0155:
        java.lang.String r9 = r8.readLine()     // Catch:{ all -> 0x017b }
        if (r9 == 0) goto L_0x0164
        r0.append(r9)     // Catch:{ all -> 0x017b }
        java.lang.String r9 = "\n"
        r0.append(r9)     // Catch:{ all -> 0x017b }
        goto L_0x0155
    L_0x0164:
        java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x017b }
        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0175 }
        r0.<init>(r9)     // Catch:{ all -> 0x0175 }
        r0.put(r10, r1)     // Catch:{ all -> 0x0175 }
        java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0175 }
        goto L_0x01b0
    L_0x0175:
        r10 = move-exception
        r6 = r8
        r8 = r7
        r7 = r10
        r10 = r9
        goto L_0x0180
    L_0x017b:
        r9 = move-exception
        r10 = r2
        r6 = r8
        r8 = r7
        r7 = r9
    L_0x0180:
        r9 = r6
        goto L_0x01d0
    L_0x0182:
        com.bytedance.embedapplog.util.C1856h.m6582a(r2)     // Catch:{ all -> 0x01c5 }
        r8 = r2
        r9 = r8
        goto L_0x01b0
    L_0x0188:
        org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x01c5 }
        r8.<init>()     // Catch:{ all -> 0x01c5 }
        org.json.JSONObject r8 = r8.put(r10, r9)     // Catch:{ all -> 0x01c5 }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01c5 }
        java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ all -> 0x01bf }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bf }
        r0.<init>()     // Catch:{ all -> 0x01bf }
        java.lang.String r1 = "HttpCode:"
        r0.append(r1)     // Catch:{ all -> 0x01bf }
        r0.append(r9)     // Catch:{ all -> 0x01bf }
        java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x01bf }
        r10.<init>(r9)     // Catch:{ all -> 0x01bf }
        r10.printStackTrace()     // Catch:{ all -> 0x01bf }
        r9 = r8
        r8 = r2
    L_0x01b0:
        if (r7 == 0) goto L_0x01b7
        r7.close()     // Catch:{ IOException -> 0x01b6 }
        goto L_0x01b7
    L_0x01b7:
        if (r8 == 0) goto L_0x01e0
        r8.close()     // Catch:{ IOException -> 0x01bd }
        goto L_0x01e0
        goto L_0x01e0
    L_0x01bf:
        r9 = move-exception
        r10 = r8
        r8 = r7
        r7 = r9
        r9 = r2
        goto L_0x01d0
    L_0x01c5:
        r8 = move-exception
        r9 = r2
        r10 = r9
        r6 = r8
        r8 = r7
        r7 = r6
        goto L_0x01d0
    L_0x01cc:
        r7 = move-exception
        r8 = r2
        r9 = r8
        r10 = r9
    L_0x01d0:
        com.bytedance.embedapplog.util.C1856h.m6582a(r7)     // Catch:{ all -> 0x01f9 }
        if (r8 == 0) goto L_0x01da
        r8.close()     // Catch:{ IOException -> 0x01d9 }
        goto L_0x01da
    L_0x01da:
        if (r9 == 0) goto L_0x01df
        r9.close()     // Catch:{ IOException -> 0x01df }
    L_0x01df:
        r9 = r10
    L_0x01e0:
        boolean r7 = com.bytedance.embedapplog.util.C1856h.f5226b
        if (r7 == 0) goto L_0x01f8
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r8 = "http response: "
        r7.append(r8)
        r7.append(r9)
        java.lang.String r7 = r7.toString()
        com.bytedance.embedapplog.util.C1856h.m6581a(r7, r2)
    L_0x01f8:
        return r9
    L_0x01f9:
        r7 = move-exception
        if (r8 == 0) goto L_0x0201
        r8.close()     // Catch:{ IOException -> 0x0200 }
        goto L_0x0201
    L_0x0201:
        if (r9 == 0) goto L_0x0206
        r9.close()     // Catch:{ IOException -> 0x0206 }
    L_0x0206:
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p143c.C1835a.m6432a(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    /* renamed from: a */
    public static void m6436a(int i) {
        f5139f = UriConfig.creatUriConfig(i);
    }

    /* renamed from: a */
    public static UriConfig m6431a() {
        return f5139f;
    }

    /* renamed from: a */
    public static JSONObject m6435a(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap(2);
        String str2 = "Content-Type";
        if (AppLog.getEncryptAndCompress()) {
            hashMap.put(str2, "application/octet-stream;tt-data=a");
        } else {
            hashMap.put(str2, "application/json; charset=utf-8");
        }
        String a = m6432a(1, m6433a(str), hashMap, AppLog.toEncryptByte(jSONObject.toString()));
        if (a == null) {
            return null;
        }
        try {
            return new JSONObject(a);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m6438b(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(str);
        float rawOffset = (((float) TimeZone.getDefault().getRawOffset()) * 1.0f) / 3600000.0f;
        if (rawOffset < -12.0f) {
            rawOffset = -12.0f;
        }
        if (rawOffset > 12.0f) {
            rawOffset = 12.0f;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(rawOffset);
        String str2 = "";
        sb2.append(str2);
        m6437a(sb, "timezone", sb2.toString());
        String str3 = "sim_serial_number";
        JSONArray optJSONArray = jSONObject.optJSONArray(str3);
        if (optJSONArray != null) {
            try {
                String optString = ((JSONObject) optJSONArray.get(0)).optString(str3);
                for (int i = 1; i < optJSONArray.length(); i++) {
                    String optString2 = ((JSONObject) optJSONArray.get(i)).optString(str3);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(optString);
                    sb3.append(StorageInterface.KEY_SPLITER);
                    sb3.append(optString2);
                    optString = sb3.toString();
                }
                m6437a(sb, str3, optString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        String a = m6432a(0, m6433a(sb.toString()), null, null);
        if (a != null) {
            try {
                jSONObject2 = new JSONObject(a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONObject2 != null) {
            if ("success".equals(jSONObject2.optString("message", str2))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected static void m6437a(StringBuilder sb, String str, String str2) {
        if (sb != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (sb.toString().indexOf(63) < 0) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(Uri.encode(str2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089 A[SYNTHETIC, Splitter:B:32:0x0089] */
    /* renamed from: a */
    public static int m6430a(java.lang.String[] r9, byte[] r10, com.bytedance.embedapplog.p142b.C1821h r11) {
        /*
        java.lang.String r0 = "server_time"
        java.util.HashMap r1 = new java.util.HashMap
        r2 = 2
        r1.<init>(r2)
        boolean r2 = com.bytedance.embedapplog.AppLog.getEncryptAndCompress()
        java.lang.String r3 = "Content-Type"
        if (r2 == 0) goto L_0x0016
        java.lang.String r2 = "application/octet-stream;tt-data=a"
        r1.put(r3, r2)
        goto L_0x001b
    L_0x0016:
        java.lang.String r2 = "application/json; charset=utf-8"
        r1.put(r3, r2)
    L_0x001b:
        int r2 = r9.length
        r3 = 0
        r4 = 0
        r6 = r3
        r5 = 0
    L_0x0020:
        if (r5 >= r2) goto L_0x0033
        r6 = r9[r5]
        r7 = 1
        java.lang.String r6 = m6432a(r7, r6, r1, r10)
        boolean r7 = android.text.TextUtils.isEmpty(r6)
        if (r7 != 0) goto L_0x0030
        goto L_0x0033
    L_0x0030:
        int r5 = r5 + 1
        goto L_0x0020
    L_0x0033:
        r9 = 200(0xc8, float:2.8E-43)
        boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0081 }
        if (r10 != 0) goto L_0x007f
        org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0081 }
        r10.<init>(r6)     // Catch:{ JSONException -> 0x0081 }
        java.lang.String r1 = "http_code"
        int r1 = r10.optInt(r1)     // Catch:{ JSONException -> 0x007d }
        if (r1 != r9) goto L_0x0087
        java.lang.String r1 = "ss_app_log"
        java.lang.String r2 = "magic_tag"
        java.lang.String r2 = r10.optString(r2)     // Catch:{ JSONException -> 0x007d }
        boolean r1 = r1.equals(r2)     // Catch:{ JSONException -> 0x007d }
        if (r1 == 0) goto L_0x0072
        java.lang.String r1 = "success"
        java.lang.String r2 = "message"
        java.lang.String r2 = r10.optString(r2)     // Catch:{ JSONException -> 0x007d }
        boolean r1 = r1.equals(r2)     // Catch:{ JSONException -> 0x007d }
        if (r1 == 0) goto L_0x0067
        r1 = 200(0xc8, float:2.8E-43)
        goto L_0x0087
    L_0x0067:
        java.lang.String r1 = "101"
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ JSONException -> 0x007d }
        int r1 = r1.intValue()     // Catch:{ JSONException -> 0x007d }
        goto L_0x0087
    L_0x0072:
        java.lang.String r1 = "102"
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ JSONException -> 0x007d }
        int r1 = r1.intValue()     // Catch:{ JSONException -> 0x007d }
        goto L_0x0087
    L_0x007d:
        r1 = move-exception
        goto L_0x0083
    L_0x007f:
        r10 = r3
        goto L_0x0086
    L_0x0081:
        r1 = move-exception
        r10 = r3
    L_0x0083:
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)
    L_0x0086:
        r1 = 0
    L_0x0087:
        if (r1 != r9) goto L_0x0104
        long r5 = r10.optLong(r0)     // Catch:{ Exception -> 0x00aa }
        r7 = 0
        int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r9 <= 0) goto L_0x00ae
        org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00aa }
        r9.<init>()     // Catch:{ Exception -> 0x00aa }
        r9.put(r0, r5)     // Catch:{ Exception -> 0x00aa }
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00aa }
        r7 = 1000(0x3e8, double:4.94E-321)
        long r5 = r5 / r7
        java.lang.String r0 = "local_time"
        r9.put(r0, r5)     // Catch:{ Exception -> 0x00aa }
        f5134a = r9     // Catch:{ Exception -> 0x00aa }
        goto L_0x00ae
    L_0x00aa:
        r9 = move-exception
        com.bytedance.embedapplog.util.C1856h.m6582a(r9)
    L_0x00ae:
        java.lang.String r9 = "blacklist"
        org.json.JSONObject r9 = r10.optJSONObject(r9)
        if (r9 == 0) goto L_0x0104
        java.lang.String r10 = "v1"
        org.json.JSONArray r10 = r9.optJSONArray(r10)
        if (r10 == 0) goto L_0x00c3
        int r0 = r10.length()
        goto L_0x00c4
    L_0x00c3:
        r0 = 0
    L_0x00c4:
        java.util.HashSet r2 = new java.util.HashSet
        r2.<init>(r0)
        r5 = 0
    L_0x00ca:
        if (r5 >= r0) goto L_0x00dc
        java.lang.String r6 = r10.optString(r5, r3)
        boolean r7 = android.text.TextUtils.isEmpty(r6)
        if (r7 != 0) goto L_0x00d9
        r2.add(r6)
    L_0x00d9:
        int r5 = r5 + 1
        goto L_0x00ca
    L_0x00dc:
        java.lang.String r10 = "v3"
        org.json.JSONArray r9 = r9.optJSONArray(r10)
        if (r9 == 0) goto L_0x00e9
        int r10 = r9.length()
        goto L_0x00ea
    L_0x00e9:
        r10 = 0
    L_0x00ea:
        java.util.HashSet r0 = new java.util.HashSet
        r0.<init>(r10)
    L_0x00ef:
        if (r4 >= r10) goto L_0x0101
        java.lang.String r5 = r9.optString(r4, r3)
        boolean r6 = android.text.TextUtils.isEmpty(r5)
        if (r6 != 0) goto L_0x00fe
        r0.add(r5)
    L_0x00fe:
        int r4 = r4 + 1
        goto L_0x00ef
    L_0x0101:
        r11.mo13390a(r2, r0)
    L_0x0104:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p143c.C1835a.m6430a(java.lang.String[], byte[], com.bytedance.embedapplog.b.h):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
            if ("ss_app_log".equals(r4.optString("magic_tag", "")) != false) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* renamed from: c */
    public static org.json.JSONObject m6439c(java.lang.String r3, org.json.JSONObject r4) {
        /*
        java.lang.String r4 = r4.toString()
        byte[] r4 = r4.getBytes()
        r0 = 1
        r1 = 0
        java.lang.String r3 = m6432a(r0, r3, r1, r4)
        if (r3 == 0) goto L_0x001a
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0016 }
        r4.<init>(r3)     // Catch:{ JSONException -> 0x0016 }
        goto L_0x001b
    L_0x0016:
        r3 = move-exception
        r3.printStackTrace()
    L_0x001a:
        r4 = r1
    L_0x001b:
        if (r4 == 0) goto L_0x002e
        java.lang.String r3 = "magic_tag"
        java.lang.String r2 = ""
        java.lang.String r3 = r4.optString(r3, r2)
        java.lang.String r2 = "ss_app_log"
        boolean r3 = r2.equals(r3)
        if (r3 == 0) goto L_0x002e
        goto L_0x002f
    L_0x002e:
        r0 = 0
    L_0x002f:
        if (r0 == 0) goto L_0x0038
        java.lang.String r3 = "config"
        org.json.JSONObject r3 = r4.optJSONObject(r3)
        return r3
    L_0x0038:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p143c.C1835a.m6439c(java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
            if ("success".equals(r4.optString("message", "")) != false) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* renamed from: d */
    public static org.json.JSONObject m6440d(java.lang.String r3, org.json.JSONObject r4) {
        /*
        java.lang.String r4 = r4.toString()
        byte[] r4 = r4.getBytes()
        r0 = 1
        r1 = 0
        java.lang.String r3 = m6432a(r0, r3, r1, r4)
        if (r3 == 0) goto L_0x001a
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0016 }
        r4.<init>(r3)     // Catch:{ JSONException -> 0x0016 }
        goto L_0x001b
    L_0x0016:
        r3 = move-exception
        r3.printStackTrace()
    L_0x001a:
        r4 = r1
    L_0x001b:
        if (r4 == 0) goto L_0x002e
        java.lang.String r3 = "message"
        java.lang.String r2 = ""
        java.lang.String r3 = r4.optString(r3, r2)
        java.lang.String r2 = "success"
        boolean r3 = r2.equals(r3)
        if (r3 == 0) goto L_0x002e
        goto L_0x002f
    L_0x002e:
        r0 = 0
    L_0x002f:
        if (r0 == 0) goto L_0x0038
        java.lang.String r3 = "data"
        org.json.JSONObject r3 = r4.optJSONObject(r3)
        return r3
    L_0x0038:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p143c.C1835a.m6440d(java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }
}
