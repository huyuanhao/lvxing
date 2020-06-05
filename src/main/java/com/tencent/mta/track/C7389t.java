package com.tencent.mta.track;

import android.content.Context;
import com.tencent.mta.track.util.ThrifClient;
import java.net.URI;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.t */
class C7389t extends ThrifClient {
    /* renamed from: a */
    final /* synthetic */ C7386q f24981a;

    public C7389t(C7386q qVar, URI uri, int i, Context context) {
        this.f24981a = qVar;
        super(uri, i, context);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.tencent.mta.track.thrift.CommonRequest>, for r7v0, types: [java.util.List, java.util.List<com.tencent.mta.track.thrift.CommonRequest>] */
    /* renamed from: a */
    public void mo35931a(java.util.List<com.tencent.mta.track.thrift.CommonRequest> r7) {
        /*
        r6 = this;
        java.util.Iterator r7 = r7.iterator()
    L_0x0004:
        boolean r0 = r7.hasNext()
        if (r0 == 0) goto L_0x00d2
        java.lang.Object r0 = r7.next()
        com.tencent.mta.track.thrift.CommonRequest r0 = (com.tencent.mta.track.thrift.CommonRequest) r0
        if (r0 == 0) goto L_0x0004
        com.tencent.mta.track.thrift.CommonCmdType r1 = r0.cmdType
        java.lang.String r2 = r0.body
        int r0 = r0.seq
        com.tencent.mta.track.q r3 = r6.f24981a
        android.content.Context r3 = r3.f24979d
        com.tencent.mta.track.StatisticsDataAPI r3 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r3)
        boolean r3 = r3.isDebugMode()
        java.lang.String r4 = "track"
        if (r3 == 0) goto L_0x003e
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = "tell phone what to do next by polling : "
        r3.append(r5)
        r3.append(r1)
        java.lang.String r3 = r3.toString()
        android.util.Log.i(r4, r3)
    L_0x003e:
        int[] r3 = com.tencent.mta.track.C7387r.f24980a
        int r1 = r1.ordinal()
        r1 = r3[r1]
        r3 = 1
        if (r1 == r3) goto L_0x00bc
        r3 = 2
        if (r1 == r3) goto L_0x0082
        r3 = 3
        if (r1 == r3) goto L_0x006e
        r0 = 4
        if (r1 == r0) goto L_0x0064
        r0 = 5
        if (r1 == r0) goto L_0x0056
        goto L_0x0004
    L_0x0056:
        com.tencent.mta.track.q r0 = r6.f24981a
        android.content.Context r0 = r0.f24979d
        com.tencent.mta.track.StatisticsDataAPI r0 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r0)
        r0.checkConfig()
        goto L_0x0004
    L_0x0064:
        com.tencent.mta.track.q r0 = r6.f24981a
        com.tencent.mta.track.s r0 = r0.f24976a
        r0.mo35866a()
        goto L_0x0004
    L_0x006e:
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007d }
        r1.<init>(r2)     // Catch:{ JSONException -> 0x007d }
        com.tencent.mta.track.q r2 = r6.f24981a     // Catch:{ JSONException -> 0x007d }
        com.tencent.mta.track.s r2 = r2.f24976a     // Catch:{ JSONException -> 0x007d }
        r2.mo35868b(r1, r0)     // Catch:{ JSONException -> 0x007d }
        goto L_0x0004
    L_0x007d:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x0004
    L_0x0082:
        com.tencent.mta.track.q r1 = r6.f24981a     // Catch:{ JSONException -> 0x00b6 }
        android.content.Context r1 = r1.f24979d     // Catch:{ JSONException -> 0x00b6 }
        com.tencent.mta.track.StatisticsDataAPI r1 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r1)     // Catch:{ JSONException -> 0x00b6 }
        boolean r1 = r1.isDebugMode()     // Catch:{ JSONException -> 0x00b6 }
        if (r1 == 0) goto L_0x00a6
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00b6 }
        r1.<init>()     // Catch:{ JSONException -> 0x00b6 }
        java.lang.String r3 = "start Snapshot seq : "
        r1.append(r3)     // Catch:{ JSONException -> 0x00b6 }
        r1.append(r0)     // Catch:{ JSONException -> 0x00b6 }
        java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x00b6 }
        android.util.Log.i(r4, r1)     // Catch:{ JSONException -> 0x00b6 }
    L_0x00a6:
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b6 }
        r1.<init>(r2)     // Catch:{ JSONException -> 0x00b6 }
        com.tencent.mta.track.q r2 = r6.f24981a     // Catch:{ JSONException -> 0x00b6 }
        com.tencent.mta.track.s r2 = r2.f24976a     // Catch:{ JSONException -> 0x00b6 }
        r2.mo35867a(r1, r0)     // Catch:{ JSONException -> 0x00b6 }
        goto L_0x0004
    L_0x00b6:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x0004
    L_0x00bc:
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00cc }
        r1.<init>(r2)     // Catch:{ JSONException -> 0x00cc }
        com.tencent.mta.track.q r2 = r6.f24981a     // Catch:{ JSONException -> 0x00cc }
        com.tencent.mta.track.s r2 = r2.f24976a     // Catch:{ JSONException -> 0x00cc }
        r2.mo35869c(r1, r0)     // Catch:{ JSONException -> 0x00cc }
        goto L_0x0004
    L_0x00cc:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x0004
    L_0x00d2:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.C7389t.mo35931a(java.util.List):void");
    }
}
