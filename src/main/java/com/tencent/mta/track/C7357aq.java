package com.tencent.mta.track;

import android.content.DialogInterface.OnClickListener;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.aq */
class C7357aq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ JSONObject f24904a;
    /* renamed from: b */
    final /* synthetic */ int f24905b;
    /* renamed from: c */
    final /* synthetic */ C7355ao f24906c;

    C7357aq(C7355ao aoVar, JSONObject jSONObject, int i) {
        this.f24906c = aoVar;
        this.f24904a = jSONObject;
        this.f24905b = i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:7|8|9|(1:11)(2:12|13)|14|15|16|17|18|19|(1:21)(1:22)|23|(1:32)(2:27|33)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0091 */
    public void onClick(android.content.DialogInterface r8, int r9) {
        /*
        r7 = this;
        java.lang.String r9 = "app_version"
        java.lang.String r0 = ""
        java.lang.String r1 = "main_bundle_identifier"
        java.lang.String r2 = "Android"
        java.lang.String r3 = "support_gzip"
        r8.dismiss()
        org.json.JSONObject r8 = r7.f24904a     // Catch:{ JSONException -> 0x0024 }
        java.lang.String r4 = "payload"
        org.json.JSONObject r8 = r8.getJSONObject(r4)     // Catch:{ JSONException -> 0x0024 }
        boolean r4 = r8.has(r3)     // Catch:{ JSONException -> 0x0024 }
        if (r4 == 0) goto L_0x0024
        com.tencent.mta.track.ao r4 = r7.f24906c     // Catch:{ JSONException -> 0x0024 }
        boolean r8 = r8.getBoolean(r3)     // Catch:{ JSONException -> 0x0024 }
        r4.f24900h = r8     // Catch:{ JSONException -> 0x0024 }
    L_0x0024:
        com.tencent.mta.track.ao r8 = r7.f24906c
        android.content.Context r8 = r8.f24897e
        android.content.pm.PackageManager r8 = r8.getPackageManager()
        com.tencent.mta.track.ao r3 = r7.f24906c
        android.content.Context r3 = r3.f24897e
        android.content.res.Resources r3 = r3.getResources()
        android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x00fc }
        r4.<init>()     // Catch:{ all -> 0x00fc }
        java.lang.String r5 = "lib"
        r4.put(r5, r2)     // Catch:{ all -> 0x00fc }
        java.lang.String r5 = "lib_version"
        java.lang.String r6 = "3.4.0"
        r4.put(r5, r6)     // Catch:{ all -> 0x00fc }
        java.lang.String r5 = "os"
        r4.put(r5, r2)     // Catch:{ all -> 0x00fc }
        java.lang.String r2 = "os_version"
        java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x00fc }
        java.lang.String r6 = "UNKNOWN"
        if (r5 != 0) goto L_0x005c
        r5 = r6
        goto L_0x005e
    L_0x005c:
        java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x00fc }
    L_0x005e:
        r4.put(r2, r5)     // Catch:{ all -> 0x00fc }
        java.lang.String r2 = "screen_height"
        int r5 = r3.heightPixels     // Catch:{ all -> 0x00fc }
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00fc }
        r4.put(r2, r5)     // Catch:{ all -> 0x00fc }
        java.lang.String r2 = "screen_width"
        int r3 = r3.widthPixels     // Catch:{ all -> 0x00fc }
        java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00fc }
        r4.put(r2, r3)     // Catch:{ all -> 0x00fc }
        com.tencent.mta.track.ao r2 = r7.f24906c     // Catch:{ NameNotFoundException -> 0x0091 }
        android.content.Context r2 = r2.f24897e     // Catch:{ NameNotFoundException -> 0x0091 }
        java.lang.String r2 = r2.getPackageName()     // Catch:{ NameNotFoundException -> 0x0091 }
        r3 = 0
        android.content.pm.PackageInfo r8 = r8.getPackageInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x0091 }
        java.lang.String r2 = r8.packageName     // Catch:{ NameNotFoundException -> 0x0091 }
        r4.put(r1, r2)     // Catch:{ NameNotFoundException -> 0x0091 }
        java.lang.String r8 = r8.versionName     // Catch:{ NameNotFoundException -> 0x0091 }
        r4.put(r9, r8)     // Catch:{ NameNotFoundException -> 0x0091 }
        goto L_0x0097
    L_0x0091:
        r4.put(r1, r0)     // Catch:{ all -> 0x00fc }
        r4.put(r9, r0)     // Catch:{ all -> 0x00fc }
    L_0x0097:
        java.lang.String r8 = "device_name"
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
        r9.<init>()     // Catch:{ all -> 0x00fc }
        java.lang.String r0 = android.os.Build.BRAND     // Catch:{ all -> 0x00fc }
        r9.append(r0)     // Catch:{ all -> 0x00fc }
        java.lang.String r0 = "/"
        r9.append(r0)     // Catch:{ all -> 0x00fc }
        java.lang.String r0 = android.os.Build.MODEL     // Catch:{ all -> 0x00fc }
        r9.append(r0)     // Catch:{ all -> 0x00fc }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00fc }
        r4.put(r8, r9)     // Catch:{ all -> 0x00fc }
        java.lang.String r8 = "device_model"
        java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x00fc }
        if (r9 != 0) goto L_0x00bb
        goto L_0x00bd
    L_0x00bb:
        java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x00fc }
    L_0x00bd:
        r4.put(r8, r6)     // Catch:{ all -> 0x00fc }
        java.lang.String r8 = "device_id"
        com.tencent.mta.track.ao r9 = r7.f24906c     // Catch:{ all -> 0x00fc }
        android.content.Context r9 = r9.f24897e     // Catch:{ all -> 0x00fc }
        java.lang.String r9 = com.tencent.mta.track.util.C7468g.m32342b(r9)     // Catch:{ all -> 0x00fc }
        r4.put(r8, r9)     // Catch:{ all -> 0x00fc }
        com.tencent.mta.track.ao r8 = r7.f24906c     // Catch:{ all -> 0x00fc }
        com.tencent.mta.track.q r8 = r8.f24895c     // Catch:{ all -> 0x00fc }
        if (r8 == 0) goto L_0x0104
        com.tencent.mta.track.ao r8 = r7.f24906c     // Catch:{ all -> 0x00fc }
        com.tencent.mta.track.q r8 = r8.f24895c     // Catch:{ all -> 0x00fc }
        boolean r8 = r8.mo35930a()     // Catch:{ all -> 0x00fc }
        if (r8 == 0) goto L_0x0104
        com.tencent.mta.track.ao r8 = r7.f24906c     // Catch:{ all -> 0x00fc }
        com.tencent.mta.track.q r8 = r8.f24895c     // Catch:{ all -> 0x00fc }
        com.tencent.mta.track.ao r9 = r7.f24906c     // Catch:{ all -> 0x00fc }
        java.lang.String r0 = "device_info_response"
        org.json.JSONObject r9 = r9.m31733a(r0, r4)     // Catch:{ all -> 0x00fc }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00fc }
        int r0 = r7.f24905b     // Catch:{ all -> 0x00fc }
        r1 = 2
        r8.mo35928a(r9, r0, r1)     // Catch:{ all -> 0x00fc }
        goto L_0x0104
    L_0x00fc:
        r8 = move-exception
        java.lang.String r9 = "ViewCrawler"
        java.lang.String r0 = "Can't write the response for device information."
        android.util.Log.w(r9, r0, r8)
    L_0x0104:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.C7357aq.onClick(android.content.DialogInterface, int):void");
    }
}
