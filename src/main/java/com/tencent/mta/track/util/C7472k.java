package com.tencent.mta.track.util;

import android.os.Handler;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.util.k */
class C7472k extends Handler {
    /* renamed from: a */
    final /* synthetic */ ThrifClient f25031a;

    private C7472k(ThrifClient thrifClient) {
        this.f25031a = thrifClient;
    }

    /* synthetic */ C7472k(ThrifClient thrifClient, C7469h hVar) {
        this(thrifClient);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x03a7 */
    public void handleMessage(android.os.Message r10) {
        /*
        r9 = this;
        int r0 = r10.what     // Catch:{ all -> 0x03a7 }
        r1 = 0
        r2 = 4
        java.lang.String r3 = ""
        r4 = 3
        r5 = 0
        r6 = 1
        r7 = 2
        if (r0 == 0) goto L_0x02c4
        if (r0 == r6) goto L_0x00cc
        if (r0 == r7) goto L_0x0070
        if (r0 == r4) goto L_0x0014
        goto L_0x03ae
    L_0x0014:
        com.tencent.mta.track.thrift.TrackPollReq r10 = new com.tencent.mta.track.thrift.TrackPollReq     // Catch:{ all -> 0x03a7 }
        r10.m53216init()     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r0 = r0.f25014i     // Catch:{ all -> 0x03a7 }
        r10.sessionId = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.CommonResponse r0 = new com.tencent.mta.track.thrift.CommonResponse     // Catch:{ all -> 0x03a7 }
        r0.m53152init()     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.CommonCmdType r1 = com.tencent.mta.track.thrift.CommonCmdType.DisConnectRsp     // Catch:{ all -> 0x03a7 }
        r0.cmdType = r1     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.ReqResult r1 = new com.tencent.mta.track.thrift.ReqResult     // Catch:{ all -> 0x03a7 }
        r1.m53191init()     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.ErrorCode r2 = com.tencent.mta.track.thrift.ErrorCode.Ok     // Catch:{ all -> 0x03a7 }
        r1.errorCode = r2     // Catch:{ all -> 0x03a7 }
        r0.result = r1     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.util.ArrayList r1 = r1.f25013h     // Catch:{ all -> 0x03a7 }
        r1.clear()     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.util.ArrayList r1 = r1.f25013h     // Catch:{ all -> 0x03a7 }
        r1.add(r0)     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.util.ArrayList r0 = r0.f25013h     // Catch:{ all -> 0x03a7 }
        r10.sRspList = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.l r0 = r0.f25010e     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.TrackPollRsp r10 = r0.mo36389a(r10)     // Catch:{ all -> 0x03a7 }
        if (r10 == 0) goto L_0x03ae
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.k r10 = r10.f25009d     // Catch:{ all -> 0x03a7 }
        android.os.Message r10 = r10.obtainMessage(r7)     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.k r0 = r0.f25009d     // Catch:{ all -> 0x03a7 }
        r0.sendMessage(r10)     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x0070:
        com.tencent.mta.track.thrift.TrackDisConnectReq r10 = new com.tencent.mta.track.thrift.TrackDisConnectReq     // Catch:{ all -> 0x03a7 }
        r10.m53206init()     // Catch:{ all -> 0x03a7 }
        java.lang.String r0 = "MESSAGE_DISCONNECT"
        r10.reason = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r0 = r0.f25014i     // Catch:{ all -> 0x03a7 }
        r10.sessionId = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.l r0 = r0.f25010e     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.TrackDisConnectRsp r10 = r0.mo36388a(r10)     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.ReqResult r10 = r10.result     // Catch:{ all -> 0x03a7 }
        if (r10 == 0) goto L_0x03ae
        com.tencent.mta.track.thrift.ErrorCode r10 = r10.errorCode     // Catch:{ all -> 0x03a7 }
        int[] r0 = com.tencent.mta.track.util.C7470i.f25029a     // Catch:{ all -> 0x03a7 }
        int r10 = r10.ordinal()     // Catch:{ all -> 0x03a7 }
        r10 = r0[r10]     // Catch:{ all -> 0x03a7 }
        if (r10 == r6) goto L_0x00be
        if (r10 == r7) goto L_0x00b5
        if (r10 == r4) goto L_0x00ac
        if (r10 == r2) goto L_0x00a3
        goto L_0x03ae
    L_0x00a3:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.NOT_YET_CONNECTED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x00ac:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.NOT_YET_CONNECTED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x00b5:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.NOT_YET_CONNECTED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x00be:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        r10.f25014i = r3     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.CLOSED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x00cc:
        com.tencent.mta.track.thrift.TrackPollReq r0 = new com.tencent.mta.track.thrift.TrackPollReq     // Catch:{ all -> 0x03a7 }
        r0.m53216init()     // Catch:{ all -> 0x03a7 }
        java.lang.Object r2 = r10.obj     // Catch:{ all -> 0x03a7 }
        java.lang.String r4 = "track"
        if (r2 == 0) goto L_0x0289
        com.tencent.mta.track.thrift.CommonResponse r2 = new com.tencent.mta.track.thrift.CommonResponse     // Catch:{ all -> 0x03a7 }
        r2.m53152init()     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r6 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.Object r8 = r10.obj     // Catch:{ all -> 0x03a7 }
        java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x03a7 }
        r6.f25012g = r8     // Catch:{ all -> 0x03a7 }
        org.json.JSONTokener r6 = new org.json.JSONTokener     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r8 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r8 = r8.f25012g     // Catch:{ JSONException -> 0x0268 }
        r6.<init>(r8)     // Catch:{ JSONException -> 0x0268 }
        java.lang.Object r6 = r6.nextValue()     // Catch:{ JSONException -> 0x0268 }
        boolean r8 = r6 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0268 }
        if (r8 == 0) goto L_0x0104
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r6 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r6 = r6.f25012g     // Catch:{ JSONException -> 0x0268 }
        r1.<init>(r6)     // Catch:{ JSONException -> 0x0268 }
        goto L_0x0119
    L_0x0104:
        boolean r8 = r6 instanceof org.json.JSONArray     // Catch:{ JSONException -> 0x0268 }
        if (r8 == 0) goto L_0x0118
        org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch:{ JSONException -> 0x0268 }
        int r8 = r6.length()     // Catch:{ JSONException -> 0x0268 }
        if (r8 != 0) goto L_0x0111
        return
    L_0x0111:
        java.lang.Object r1 = r6.opt(r1)     // Catch:{ JSONException -> 0x0268 }
        org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x0268 }
        goto L_0x0119
    L_0x0118:
        r1 = r5
    L_0x0119:
        java.lang.String r6 = "type"
        java.lang.String r1 = r1.getString(r6)     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r6 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        android.content.Context r6 = r6.f25016k     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.StatisticsDataAPI r6 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r6)     // Catch:{ JSONException -> 0x0268 }
        boolean r6 = r6.isDebugMode()     // Catch:{ JSONException -> 0x0268 }
        if (r6 == 0) goto L_0x0143
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0268 }
        r6.<init>()     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r8 = "poll type : "
        r6.append(r8)     // Catch:{ JSONException -> 0x0268 }
        r6.append(r1)     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x0268 }
        android.util.Log.i(r4, r6)     // Catch:{ JSONException -> 0x0268 }
    L_0x0143:
        java.lang.String r6 = "device_info_response"
        boolean r6 = r1.equals(r6)     // Catch:{ JSONException -> 0x0268 }
        if (r6 == 0) goto L_0x0182
        com.tencent.mta.track.thrift.CommonCmdType r1 = com.tencent.mta.track.thrift.CommonCmdType.DeviceInfoRsp     // Catch:{ JSONException -> 0x0268 }
        r2.cmdType = r1     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r1 = r1.f25012g     // Catch:{ JSONException -> 0x0268 }
        r2.body = r1     // Catch:{ JSONException -> 0x0268 }
        int r10 = r10.arg1     // Catch:{ JSONException -> 0x0268 }
        r2.seq = r10     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.thrift.ReqResult r10 = new com.tencent.mta.track.thrift.ReqResult     // Catch:{ JSONException -> 0x0268 }
        r10.m53191init()     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.thrift.ErrorCode r1 = com.tencent.mta.track.thrift.ErrorCode.Ok     // Catch:{ JSONException -> 0x0268 }
        r10.errorCode = r1     // Catch:{ JSONException -> 0x0268 }
        r2.result = r10     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r10.clear()     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r10.add(r2)     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r0.sRspList = r10     // Catch:{ JSONException -> 0x0268 }
        goto L_0x028b
    L_0x0182:
        java.lang.String r6 = "event_binding_response"
        boolean r6 = r1.equals(r6)     // Catch:{ JSONException -> 0x0268 }
        if (r6 == 0) goto L_0x01bb
        com.tencent.mta.track.thrift.CommonCmdType r1 = com.tencent.mta.track.thrift.CommonCmdType.EventBindRsp     // Catch:{ JSONException -> 0x0268 }
        r2.cmdType = r1     // Catch:{ JSONException -> 0x0268 }
        r2.body = r3     // Catch:{ JSONException -> 0x0268 }
        int r10 = r10.arg1     // Catch:{ JSONException -> 0x0268 }
        r2.seq = r10     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.thrift.ReqResult r10 = new com.tencent.mta.track.thrift.ReqResult     // Catch:{ JSONException -> 0x0268 }
        r10.m53191init()     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.thrift.ErrorCode r1 = com.tencent.mta.track.thrift.ErrorCode.Ok     // Catch:{ JSONException -> 0x0268 }
        r10.errorCode = r1     // Catch:{ JSONException -> 0x0268 }
        r2.result = r10     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r10.clear()     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r10.add(r2)     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r0.sRspList = r10     // Catch:{ JSONException -> 0x0268 }
        goto L_0x028b
    L_0x01bb:
        java.lang.String r3 = "snapshot_response"
        boolean r3 = r1.equals(r3)     // Catch:{ JSONException -> 0x0268 }
        if (r3 == 0) goto L_0x01fa
        com.tencent.mta.track.thrift.CommonCmdType r1 = com.tencent.mta.track.thrift.CommonCmdType.ScreenShotRsp     // Catch:{ JSONException -> 0x0268 }
        r2.cmdType = r1     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r1 = r1.f25012g     // Catch:{ JSONException -> 0x0268 }
        r2.body = r1     // Catch:{ JSONException -> 0x0268 }
        int r10 = r10.arg1     // Catch:{ JSONException -> 0x0268 }
        r2.seq = r10     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.thrift.ReqResult r10 = new com.tencent.mta.track.thrift.ReqResult     // Catch:{ JSONException -> 0x0268 }
        r10.m53191init()     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.thrift.ErrorCode r1 = com.tencent.mta.track.thrift.ErrorCode.Ok     // Catch:{ JSONException -> 0x0268 }
        r10.errorCode = r1     // Catch:{ JSONException -> 0x0268 }
        r2.result = r10     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r10.clear()     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r10.add(r2)     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.util.ArrayList r10 = r10.f25013h     // Catch:{ JSONException -> 0x0268 }
        r0.sRspList = r10     // Catch:{ JSONException -> 0x0268 }
        goto L_0x028b
    L_0x01fa:
        java.lang.String r2 = "debug_track"
        boolean r1 = r1.equals(r2)     // Catch:{ JSONException -> 0x0268 }
        if (r1 == 0) goto L_0x028b
        com.tencent.mta.track.thrift.CommonRequest r1 = new com.tencent.mta.track.thrift.CommonRequest     // Catch:{ JSONException -> 0x0268 }
        r1.m53147init()     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.thrift.CommonCmdType r2 = com.tencent.mta.track.thrift.CommonCmdType.TrackReq     // Catch:{ JSONException -> 0x0268 }
        r1.cmdType = r2     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r2 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r2 = r2.f25012g     // Catch:{ JSONException -> 0x0268 }
        r1.body = r2     // Catch:{ JSONException -> 0x0268 }
        int r10 = r10.arg1     // Catch:{ JSONException -> 0x0268 }
        r1.seq = r10     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r2 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        int r2 = r2.f25019o     // Catch:{ JSONException -> 0x0268 }
        int r2 = r2 + r7
        r10.f25019o = r2     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        int r10 = r10.f25019o     // Catch:{ JSONException -> 0x0268 }
        r1.seq = r10     // Catch:{ JSONException -> 0x0268 }
        r0.sRspList = r5     // Catch:{ JSONException -> 0x0268 }
        r0.cRequest = r1     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        android.content.Context r10 = r10.f25016k     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.StatisticsDataAPI r10 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r10)     // Catch:{ JSONException -> 0x0268 }
        boolean r10 = r10.isDebugMode()     // Catch:{ JSONException -> 0x0268 }
        if (r10 == 0) goto L_0x028b
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0268 }
        r10.<init>()     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r1 = " debug_track = "
        r10.append(r1)     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r1 = r1.f25012g     // Catch:{ JSONException -> 0x0268 }
        r10.append(r1)     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r1 = "  , sessionId = "
        r10.append(r1)     // Catch:{ JSONException -> 0x0268 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r1 = r1.f25014i     // Catch:{ JSONException -> 0x0268 }
        r10.append(r1)     // Catch:{ JSONException -> 0x0268 }
        java.lang.String r10 = r10.toString()     // Catch:{ JSONException -> 0x0268 }
        android.util.Log.i(r4, r10)     // Catch:{ JSONException -> 0x0268 }
        goto L_0x028b
    L_0x0268:
        r10 = move-exception
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r2 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.UNKNOW     // Catch:{ all -> 0x03a7 }
        r1.f25018n = r2     // Catch:{ all -> 0x03a7 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x03a7 }
        r1.<init>()     // Catch:{ all -> 0x03a7 }
        java.lang.String r2 = "poll json exception "
        r1.append(r2)     // Catch:{ all -> 0x03a7 }
        java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x03a7 }
        r1.append(r10)     // Catch:{ all -> 0x03a7 }
        java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x03a7 }
        android.util.Log.i(r4, r10)     // Catch:{ all -> 0x03a7 }
        goto L_0x028b
    L_0x0289:
        r0.sRspList = r5     // Catch:{ all -> 0x03a7 }
    L_0x028b:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r10 = r10.f25014i     // Catch:{ all -> 0x03a7 }
        r0.sessionId = r10     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        android.content.Context r10 = r10.f25016k     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.StatisticsDataAPI r10 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r10)     // Catch:{ all -> 0x03a7 }
        boolean r10 = r10.isDebugMode()     // Catch:{ all -> 0x03a7 }
        if (r10 == 0) goto L_0x02bd
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x03a7 }
        r10.<init>()     // Catch:{ all -> 0x03a7 }
        java.lang.String r1 = "poll sessionId : "
        r10.append(r1)     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r1 = r1.f25014i     // Catch:{ all -> 0x03a7 }
        r10.append(r1)     // Catch:{ all -> 0x03a7 }
        java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x03a7 }
        android.util.Log.i(r4, r10)     // Catch:{ all -> 0x03a7 }
    L_0x02bd:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        r10.m32304a(r0)     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x02c4:
        com.tencent.mta.track.thrift.TrackConnectReq r10 = new com.tencent.mta.track.thrift.TrackConnectReq     // Catch:{ all -> 0x03a7 }
        r10.m53196init()     // Catch:{ all -> 0x03a7 }
        r10.sessionId = r3     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r0 = r0.m32318g()     // Catch:{ all -> 0x03a7 }
        r10.lastSessionId = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r0 = r0.m32314e()     // Catch:{ all -> 0x03a7 }
        r10.deviceInfo = r0     // Catch:{ all -> 0x03a7 }
        short r0 = com.tencent.mta.track.StatisticsDataAPI.PROTOCOLVERSION     // Catch:{ all -> 0x03a7 }
        r10.version = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.DeviceType r0 = com.tencent.mta.track.thrift.DeviceType.Android     // Catch:{ all -> 0x03a7 }
        r10.deviceType = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        android.content.Context r0 = r0.f25016k     // Catch:{ all -> 0x03a7 }
        java.lang.String r3 = "TA_APPKEY"
        java.lang.Object r0 = com.tencent.mta.track.util.C7468g.m32339a(r0, r3, r5)     // Catch:{ all -> 0x03a7 }
        if (r0 == 0) goto L_0x0302
        com.tencent.mta.track.util.ThrifClient r3 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03a7 }
        r3.f25017l = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r0 = r0.f25017l     // Catch:{ all -> 0x03a7 }
        r10.appKey = r0     // Catch:{ all -> 0x03a7 }
    L_0x0302:
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.l r0 = r0.f25010e     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.thrift.TrackConnectRsp r10 = r0.mo36387a(r10)     // Catch:{ all -> 0x03a7 }
        if (r10 != 0) goto L_0x0316
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.NOT_YET_CONNECTED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        return
    L_0x0316:
        com.tencent.mta.track.thrift.ReqResult r0 = r10.result     // Catch:{ all -> 0x03a7 }
        if (r0 != 0) goto L_0x0335
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.NOT_YET_CONNECTED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.k r10 = r10.f25009d     // Catch:{ all -> 0x03a7 }
        android.os.Message r10 = r10.obtainMessage(r1)     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.k r0 = r0.f25009d     // Catch:{ all -> 0x03a7 }
        r0.sendMessage(r10)     // Catch:{ all -> 0x03a7 }
        return
    L_0x0335:
        com.tencent.mta.track.thrift.ErrorCode r0 = r0.errorCode     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        int r3 = r10.pollInterval     // Catch:{ all -> 0x03a7 }
        r1.f25011f = r3     // Catch:{ all -> 0x03a7 }
        int[] r1 = com.tencent.mta.track.util.C7470i.f25029a     // Catch:{ all -> 0x03a7 }
        int r0 = r0.ordinal()     // Catch:{ all -> 0x03a7 }
        r0 = r1[r0]     // Catch:{ all -> 0x03a7 }
        if (r0 == r6) goto L_0x0367
        if (r0 == r7) goto L_0x035f
        if (r0 == r4) goto L_0x0357
        if (r0 == r2) goto L_0x034f
        goto L_0x03ae
    L_0x034f:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.NOT_YET_CONNECTED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x0357:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.NOT_YET_CONNECTED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x035f:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.NOT_YET_CONNECTED     // Catch:{ all -> 0x03a7 }
        r10.f25018n = r0     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x0367:
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r1 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.OPEN     // Catch:{ all -> 0x03a7 }
        r0.f25018n = r1     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r1 = r10.sessionId     // Catch:{ all -> 0x03a7 }
        r0.f25014i = r1     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r1 = r1.f25014i     // Catch:{ all -> 0x03a7 }
        r0.f25015j = r1     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        android.content.Context r0 = r0.f25016k     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r1 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        java.lang.String r1 = r1.f25014i     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.C7468g.m32341a(r0, r1)     // Catch:{ all -> 0x03a7 }
        short r10 = r10.version     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.StatisticsDataAPI.PROTOCOLVERSION = r10     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.k r10 = r10.f25009d     // Catch:{ all -> 0x03a7 }
        android.os.Message r10 = r10.obtainMessage(r6)     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.ThrifClient r0 = r9.f25031a     // Catch:{ all -> 0x03a7 }
        com.tencent.mta.track.util.k r0 = r0.f25009d     // Catch:{ all -> 0x03a7 }
        r0.sendMessage(r10)     // Catch:{ all -> 0x03a7 }
        goto L_0x03ae
    L_0x03a7:
        com.tencent.mta.track.util.ThrifClient r10 = r9.f25031a     // Catch:{ all -> 0x03af }
        com.tencent.mta.track.util.ThrifClient$THRIFTSTATE r0 = com.tencent.mta.track.util.ThrifClient.THRIFTSTATE.UNKNOW     // Catch:{ all -> 0x03af }
        r10.f25018n = r0     // Catch:{ all -> 0x03af }
    L_0x03ae:
        return
    L_0x03af:
        r10 = move-exception
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.util.C7472k.handleMessage(android.os.Message):void");
    }
}
