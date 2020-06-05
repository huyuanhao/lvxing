package com.tencent.mta.track;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.c */
class C7372c extends Handler {
    /* renamed from: a */
    final /* synthetic */ C7367b f24947a;

    public C7372c(C7367b bVar, Looper looper) {
        this.f24947a = bVar;
        super(looper);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:31|32|(2:34|56)(1:52)) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e0, code lost:
            if (com.tencent.mta.track.StatisticsDataAPI.f24839a.booleanValue() != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e2, code lost:
            r11 = new java.lang.StringBuilder();
            r11.append("Failed to load SDK configure with");
            r11.append(r3);
            android.util.Log.i(r2, r11.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00da */
    public void handleMessage(android.os.Message r11) {
        /*
        r10 = this;
        java.lang.String r0 = "payload"
        java.lang.String r1 = "events"
        java.lang.String r2 = "AnalyticsMessages"
        int r3 = r11.what     // Catch:{ RuntimeException -> 0x0136 }
        r4 = 3
        if (r3 != r4) goto L_0x000d
        goto L_0x013c
    L_0x000d:
        int r3 = r11.what     // Catch:{ RuntimeException -> 0x0136 }
        r4 = 4
        if (r3 != r4) goto L_0x0121
        java.lang.Object r11 = r11.obj     // Catch:{ RuntimeException -> 0x0136 }
        com.tencent.mta.track.h r11 = (com.tencent.mta.track.C7377h) r11     // Catch:{ RuntimeException -> 0x0136 }
        com.tencent.mta.track.b r3 = r10.f24947a     // Catch:{ RuntimeException -> 0x0136 }
        com.tencent.mta.track.a r3 = r3.f24938a     // Catch:{ RuntimeException -> 0x0136 }
        android.content.Context r3 = r3.f24863b     // Catch:{ RuntimeException -> 0x0136 }
        com.tencent.mta.track.StatisticsDataAPI r3 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r3)     // Catch:{ RuntimeException -> 0x0136 }
        java.lang.String r3 = r3.mo35811b()     // Catch:{ RuntimeException -> 0x0136 }
        r11.mo35916a(r3)     // Catch:{ RuntimeException -> 0x0136 }
        com.tencent.mta.track.b r3 = r10.f24947a     // Catch:{ all -> 0x00f7 }
        com.tencent.mta.track.a r3 = r3.f24938a     // Catch:{ all -> 0x00f7 }
        java.lang.String r3 = r3.m31668b()     // Catch:{ all -> 0x00f7 }
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00da }
        r4.<init>(r3)     // Catch:{ JSONException -> 0x00da }
        com.tencent.mta.track.b r5 = r10.f24947a     // Catch:{ JSONException -> 0x00da }
        com.tencent.mta.track.a r5 = r5.f24938a     // Catch:{ JSONException -> 0x00da }
        android.content.Context r5 = r5.f24863b     // Catch:{ JSONException -> 0x00da }
        com.tencent.mta.track.StatisticsDataAPI r5 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r5)     // Catch:{ JSONException -> 0x00da }
        boolean r5 = r5.isDebugMode()     // Catch:{ JSONException -> 0x00da }
        if (r5 == 0) goto L_0x0062
        java.lang.String r5 = "track"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00da }
        r6.<init>()     // Catch:{ JSONException -> 0x00da }
        java.lang.String r7 = " configureJson = "
        r6.append(r7)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r7 = r4.toString()     // Catch:{ JSONException -> 0x00da }
        r6.append(r7)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x00da }
        android.util.Log.i(r5, r6)     // Catch:{ JSONException -> 0x00da }
    L_0x0062:
        java.lang.String r5 = "data"
        org.json.JSONArray r5 = r4.optJSONArray(r5)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r6 = "cfgVersion"
        r4.getString(r6)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r6 = "reqType"
        r4.getString(r6)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r6 = "retCode"
        r4.getInt(r6)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r6 = "seq"
        r4.getString(r6)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r6 = "ts"
        r4.getLong(r6)     // Catch:{ JSONException -> 0x00da }
        int r6 = r5.length()     // Catch:{ JSONException -> 0x00da }
        if (r6 <= 0) goto L_0x00d4
        r7 = 0
    L_0x0088:
        if (r7 >= r6) goto L_0x00d4
        org.json.JSONObject r8 = r5.optJSONObject(r7)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r9 = "cmdNumber"
        r8.getString(r9)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r9 = "config"
        java.lang.String r8 = r8.getString(r9)     // Catch:{ JSONException -> 0x00da }
        java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00da }
        org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00da }
        r9.<init>(r8)     // Catch:{ JSONException -> 0x00da }
        java.lang.Object r8 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00da }
        boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x00da }
        if (r8 != 0) goto L_0x00d1
        boolean r8 = r9.has(r0)     // Catch:{ JSONException -> 0x00da }
        if (r8 == 0) goto L_0x00d1
        org.json.JSONObject r8 = r9.optJSONObject(r0)     // Catch:{ JSONException -> 0x00da }
        java.lang.Object r9 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00da }
        boolean r9 = r9.equals(r8)     // Catch:{ JSONException -> 0x00da }
        if (r9 != 0) goto L_0x00d1
        boolean r9 = r8.has(r1)     // Catch:{ JSONException -> 0x00da }
        if (r9 == 0) goto L_0x00d1
        java.lang.Object r9 = r8.get(r1)     // Catch:{ JSONException -> 0x00da }
        boolean r9 = r9 instanceof org.json.JSONArray     // Catch:{ JSONException -> 0x00da }
        if (r9 == 0) goto L_0x00d1
        org.json.JSONArray r8 = r8.getJSONArray(r1)     // Catch:{ JSONException -> 0x00da }
        r11.mo35917a(r8)     // Catch:{ JSONException -> 0x00da }
    L_0x00d1:
        int r7 = r7 + 1
        goto L_0x0088
    L_0x00d4:
        java.lang.String r11 = "vtrack_server_url"
        r4.optString(r11)     // Catch:{ JSONException -> 0x00da }
        goto L_0x013c
    L_0x00da:
        java.lang.Boolean r11 = com.tencent.mta.track.StatisticsDataAPI.f24839a     // Catch:{ all -> 0x00f7 }
        boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x00f7 }
        if (r11 == 0) goto L_0x013c
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
        r11.<init>()     // Catch:{ all -> 0x00f7 }
        java.lang.String r0 = "Failed to load SDK configure with"
        r11.append(r0)     // Catch:{ all -> 0x00f7 }
        r11.append(r3)     // Catch:{ all -> 0x00f7 }
        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00f7 }
        android.util.Log.i(r2, r11)     // Catch:{ all -> 0x00f7 }
        goto L_0x013c
    L_0x00f7:
        r11 = move-exception
        com.tencent.mta.track.b r0 = r10.f24947a     // Catch:{ RuntimeException -> 0x0136 }
        com.tencent.mta.track.a r0 = r0.f24938a     // Catch:{ RuntimeException -> 0x0136 }
        android.content.Context r0 = r0.f24863b     // Catch:{ RuntimeException -> 0x0136 }
        com.tencent.mta.track.StatisticsDataAPI r0 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r0)     // Catch:{ RuntimeException -> 0x0136 }
        boolean r0 = r0.isDebugMode()     // Catch:{ RuntimeException -> 0x0136 }
        if (r0 == 0) goto L_0x013c
        java.lang.String r0 = "Track"
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0136 }
        r1.<init>()     // Catch:{ RuntimeException -> 0x0136 }
        java.lang.String r3 = " configureJson parse = "
        r1.append(r3)     // Catch:{ RuntimeException -> 0x0136 }
        r1.append(r11)     // Catch:{ RuntimeException -> 0x0136 }
        java.lang.String r11 = r1.toString()     // Catch:{ RuntimeException -> 0x0136 }
        android.util.Log.i(r0, r11)     // Catch:{ RuntimeException -> 0x0136 }
        goto L_0x013c
    L_0x0121:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0136 }
        r0.<init>()     // Catch:{ RuntimeException -> 0x0136 }
        java.lang.String r1 = "Unexpected message received by StatisticsData worker: "
        r0.append(r1)     // Catch:{ RuntimeException -> 0x0136 }
        r0.append(r11)     // Catch:{ RuntimeException -> 0x0136 }
        java.lang.String r11 = r0.toString()     // Catch:{ RuntimeException -> 0x0136 }
        android.util.Log.e(r2, r11)     // Catch:{ RuntimeException -> 0x0136 }
        goto L_0x013c
    L_0x0136:
        r11 = move-exception
        java.lang.String r0 = "Worker threw an unhandled exception"
        android.util.Log.e(r2, r0, r11)
    L_0x013c:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.C7372c.handleMessage(android.os.Message):void");
    }
}
