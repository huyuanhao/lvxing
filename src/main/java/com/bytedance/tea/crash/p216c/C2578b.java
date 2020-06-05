package com.bytedance.tea.crash.p216c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.p003os.EnvironmentCompat;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p218e.CommonParams;
import com.bytedance.tea.crash.p221g.C2598l;
import com.bytedance.tea.crash.p221g.Device;
import com.bytedance.tea.crash.p221g.Net;
import com.bytedance.tea.crash.p221g.NpthLog;
import com.tencent.stat.common.DeviceInfo;
import discoveryAD.C7895e;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Header */
/* renamed from: com.bytedance.tea.crash.c.b */
public final class C2578b {
    /* renamed from: a */
    private static final String[] f9274a = {"version_code", "manifest_version_code", DeviceInfo.TAG_ANDROID_ID, "update_version_code"};
    /* renamed from: b */
    private Context f9275b;
    /* renamed from: c */
    private JSONObject f9276c = new JSONObject();

    public C2578b(Context context) {
        this.f9275b = context;
    }

    /* renamed from: a */
    public static C2578b m12359a(Context context) {
        C2578b bVar = new C2578b(context);
        JSONObject a = bVar.mo17002a();
        bVar.m12360a(a);
        bVar.m12364c(a);
        bVar.m12365d(a);
        bVar.m12366e(a);
        bVar.m12367f(a);
        bVar.m12368g(a);
        bVar.m12362b(a);
        return bVar;
    }

    /* renamed from: a */
    private void m12360a(JSONObject jSONObject) {
        try {
            PackageInfo packageInfo = this.f9275b.getPackageManager().getPackageInfo(this.f9275b.getPackageName(), 0);
            if (packageInfo.applicationInfo != null) {
                int i = packageInfo.applicationInfo.labelRes;
                if (i > 0) {
                    jSONObject.put("display_name", this.f9275b.getString(i));
                }
            }
            jSONObject.put("sdk_version", 22130);
            jSONObject.put("sdk_version_name", "2.2.1-alpha.30");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", m12363c());
            jSONObject.put("os_api", VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", m12361b());
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private String m12361b() {
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            StringBuilder sb = new StringBuilder();
            if (VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) {
                sb = new StringBuilder(Build.CPU_ABI);
            } else {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            }
            if (TextUtils.isEmpty(sb.toString())) {
                return str;
            }
            return sb.toString();
        } catch (Exception e) {
            NpthLog.m12550b(e);
            return str;
        }
    }

    /* renamed from: b */
    private void m12362b(JSONObject jSONObject) {
        CommonParams a = NpthBus.m12591a();
        if (a != null && jSONObject != null) {
            Map b = a.mo17020b();
            if (b != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : b.keySet()) {
                        if (!TextUtils.isEmpty(str)) {
                            Object obj = b.get(str);
                            if (obj != null) {
                                jSONObject2.put(str, obj);
                            }
                        }
                    }
                    jSONObject.put("custom", jSONObject2);
                } catch (Exception e) {
                    NpthLog.m12550b(e);
                }
            }
        }
    }

    /* renamed from: c */
    private String m12363c() {
        String str = VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        return sb.toString();
    }

    /* renamed from: c */
    private void m12364c(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = this.f9275b.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.heightPixels);
            sb.append("x");
            sb.append(displayMetrics.widthPixels);
            jSONObject.put("resolution", sb.toString());
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    private void m12365d(JSONObject jSONObject) {
        try {
            String language = this.f9275b.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / C7895e.f26887Bc;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    private void m12366e(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (Device.m12521c()) {
                sb.append("MIUI-");
            } else if (Device.m12522d()) {
                sb.append("FLYME-");
            } else {
                String a = Device.m12517a();
                if (Device.m12518a(a)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(a)) {
                    sb.append(a);
                    sb.append("-");
                }
            }
            sb.append(VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", C2598l.m12554a());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    private void m12367f(JSONObject jSONObject) {
        try {
            jSONObject.put("access", Net.m12544a(this.f9275b));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m12368g(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f9275b.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    jSONObject.put("mcc_mnc", networkOperator);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|36) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* renamed from: a */
    public org.json.JSONObject mo17004a(java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
        r9 = this;
        java.lang.String r0 = "manifest_version_code"
        java.lang.String r1 = "version_code"
        java.lang.String r2 = "iid"
        if (r10 != 0) goto L_0x000b
        org.json.JSONObject r10 = r9.f9276c     // Catch:{ all -> 0x0098 }
        return r10
    L_0x000b:
        java.util.Set r3 = r10.entrySet()     // Catch:{ all -> 0x0098 }
        java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0098 }
    L_0x0013:
        boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0098 }
        if (r4 == 0) goto L_0x003d
        java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0098 }
        java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0098 }
        org.json.JSONObject r5 = r9.f9276c     // Catch:{ all -> 0x0098 }
        java.lang.Object r6 = r4.getKey()     // Catch:{ all -> 0x0098 }
        java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0098 }
        boolean r5 = r5.has(r6)     // Catch:{ all -> 0x0098 }
        if (r5 != 0) goto L_0x0013
        org.json.JSONObject r5 = r9.f9276c     // Catch:{ all -> 0x0098 }
        java.lang.Object r6 = r4.getKey()     // Catch:{ all -> 0x0098 }
        java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0098 }
        java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0098 }
        r5.put(r6, r4)     // Catch:{ all -> 0x0098 }
        goto L_0x0013
    L_0x003d:
        java.lang.String[] r3 = f9274a     // Catch:{ all -> 0x0098 }
        int r4 = r3.length     // Catch:{ all -> 0x0098 }
        r5 = 0
    L_0x0041:
        if (r5 >= r4) goto L_0x0067
        r6 = r3[r5]     // Catch:{ all -> 0x0098 }
        boolean r7 = r10.containsKey(r6)     // Catch:{ all -> 0x0098 }
        if (r7 == 0) goto L_0x0064
        java.lang.Object r7 = r10.get(r6)     // Catch:{ Exception -> 0x005b }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x005b }
        int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x005b }
        org.json.JSONObject r8 = r9.f9276c     // Catch:{ Exception -> 0x005b }
        r8.put(r6, r7)     // Catch:{ Exception -> 0x005b }
        goto L_0x0064
    L_0x005b:
        org.json.JSONObject r7 = r9.f9276c     // Catch:{ all -> 0x0098 }
        java.lang.Object r8 = r10.get(r6)     // Catch:{ all -> 0x0098 }
        r7.put(r6, r8)     // Catch:{ all -> 0x0098 }
    L_0x0064:
        int r5 = r5 + 1
        goto L_0x0041
    L_0x0067:
        boolean r3 = r10.containsKey(r1)     // Catch:{ all -> 0x0098 }
        if (r3 == 0) goto L_0x0082
        boolean r3 = r10.containsKey(r0)     // Catch:{ all -> 0x0098 }
        if (r3 != 0) goto L_0x0082
        java.lang.Object r1 = r10.get(r1)     // Catch:{ all -> 0x0098 }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0098 }
        int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0098 }
        org.json.JSONObject r3 = r9.f9276c     // Catch:{ all -> 0x0098 }
        r3.put(r0, r1)     // Catch:{ all -> 0x0098 }
    L_0x0082:
        boolean r0 = r10.containsKey(r2)     // Catch:{ all -> 0x0098 }
        if (r0 == 0) goto L_0x0098
        org.json.JSONObject r0 = r9.f9276c     // Catch:{ all -> 0x0098 }
        java.lang.String r1 = "udid"
        java.lang.Object r10 = r10.get(r2)     // Catch:{ all -> 0x0098 }
        r0.put(r1, r10)     // Catch:{ all -> 0x0098 }
        org.json.JSONObject r10 = r9.f9276c     // Catch:{ all -> 0x0098 }
        r10.remove(r2)     // Catch:{ all -> 0x0098 }
    L_0x0098:
        org.json.JSONObject r10 = r9.f9276c
        return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p216c.C2578b.mo17004a(java.util.Map):org.json.JSONObject");
    }

    /* renamed from: a */
    public JSONObject mo17003a(String str) {
        try {
            this.f9276c.put("device_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.f9276c;
    }

    /* renamed from: b */
    public JSONObject mo17005b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f9276c.put("user_id", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.f9276c;
    }

    /* renamed from: a */
    public JSONObject mo17002a() {
        return this.f9276c;
    }
}
