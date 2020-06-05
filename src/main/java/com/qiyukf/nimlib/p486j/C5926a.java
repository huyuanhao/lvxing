package com.qiyukf.nimlib.p486j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.C5407d;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p450b.C5723c;

/* renamed from: com.qiyukf.nimlib.j.a */
public final class C5926a {
    /* renamed from: a */
    private Handler f18731a;

    /* renamed from: com.qiyukf.nimlib.j.a$a */
    private static class C5929a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C5926a f18737a = new C5926a(0);
    }

    private C5926a() {
        this.f18731a = C5361a.m22013a().mo27316a("MISC");
    }

    /* synthetic */ C5926a(byte b) {
        this();
    }

    /* renamed from: a */
    public static C5926a m23780a() {
        return C5929a.f18737a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00eb A[Catch:{ JSONException -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0109 A[Catch:{ JSONException -> 0x010f }] */
    /* renamed from: a */
    static /* synthetic */ void m23781a(android.content.Context r9, boolean r10) {
        /*
        com.qiyukf.nimlib.j.a.a$a r0 = com.qiyukf.nimlib.p486j.p487a.C5930a.m23787a(r9)
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r2 = "get connected wifi info "
        r1.<init>(r2)
        if (r0 == 0) goto L_0x0010
        java.lang.String r2 = "success"
        goto L_0x0012
    L_0x0010:
        java.lang.String r2 = "failed"
    L_0x0012:
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "stat"
        com.qiyukf.basesdk.p393a.C5264a.m21620b(r2, r1)
        java.util.List r9 = com.qiyukf.nimlib.p486j.p487a.C5930a.m23789b(r9)
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r3 = "get wifi list, total count="
        r1.<init>(r3)
        r3 = 0
        if (r9 != 0) goto L_0x002e
        r4 = 0
        goto L_0x0032
    L_0x002e:
        int r4 = r9.size()
    L_0x0032:
        r1.append(r4)
        java.lang.String r1 = r1.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21620b(r2, r1)
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x010f }
        r1.<init>()     // Catch:{ JSONException -> 0x010f }
        java.lang.String r4 = "event"
        java.lang.String r5 = "wifi"
        r1.put(r4, r5)     // Catch:{ JSONException -> 0x010f }
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x010f }
        r4.<init>()     // Catch:{ JSONException -> 0x010f }
        java.lang.String r5 = "attributes"
        r1.put(r5, r4)     // Catch:{ JSONException -> 0x010f }
        r5 = 0
        if (r0 == 0) goto L_0x0088
        java.lang.String r6 = "current"
        java.lang.String r7 = r0.f18742e     // Catch:{ JSONException -> 0x010f }
        r4.put(r6, r7)     // Catch:{ JSONException -> 0x010f }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x010f }
        java.lang.String r7 = "wifi{bssid='"
        r6.<init>(r7)     // Catch:{ JSONException -> 0x010f }
        java.lang.String r7 = r0.f18742e     // Catch:{ JSONException -> 0x010f }
        r6.append(r7)     // Catch:{ JSONException -> 0x010f }
        r7 = 39
        r6.append(r7)     // Catch:{ JSONException -> 0x010f }
        java.lang.String r8 = ",ssid='"
        r6.append(r8)     // Catch:{ JSONException -> 0x010f }
        java.lang.String r0 = r0.f18743f     // Catch:{ JSONException -> 0x010f }
        r6.append(r0)     // Catch:{ JSONException -> 0x010f }
        r6.append(r7)     // Catch:{ JSONException -> 0x010f }
        r0 = 125(0x7d, float:1.75E-43)
        r6.append(r0)     // Catch:{ JSONException -> 0x010f }
        java.lang.String r0 = r6.toString()     // Catch:{ JSONException -> 0x010f }
        java.lang.String r0 = com.qiyukf.basesdk.p412c.p416c.C5405c.m22113a(r0)     // Catch:{ JSONException -> 0x010f }
        goto L_0x0089
    L_0x0088:
        r0 = r5
    L_0x0089:
        if (r9 == 0) goto L_0x00ab
        org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x010f }
        r6.<init>()     // Catch:{ JSONException -> 0x010f }
        java.util.Iterator r9 = r9.iterator()     // Catch:{ JSONException -> 0x010f }
    L_0x0094:
        boolean r7 = r9.hasNext()     // Catch:{ JSONException -> 0x010f }
        if (r7 == 0) goto L_0x00a6
        java.lang.Object r7 = r9.next()     // Catch:{ JSONException -> 0x010f }
        com.qiyukf.nimlib.j.a.a$b r7 = (com.qiyukf.nimlib.p486j.p487a.C5930a.C5933b) r7     // Catch:{ JSONException -> 0x010f }
        java.lang.String r7 = r7.f18742e     // Catch:{ JSONException -> 0x010f }
        r6.put(r7)     // Catch:{ JSONException -> 0x010f }
        goto L_0x0094
    L_0x00a6:
        java.lang.String r9 = "list"
        r4.put(r9, r6)     // Catch:{ JSONException -> 0x010f }
    L_0x00ab:
        java.lang.String r9 = r1.toString()     // Catch:{ JSONException -> 0x010f }
        boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ JSONException -> 0x010f }
        if (r1 != 0) goto L_0x010e
        if (r10 == 0) goto L_0x010e
        boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x010f }
        r1 = 1
        if (r10 != 0) goto L_0x00e8
        java.lang.String r10 = "stat_md5_1"
        android.content.SharedPreferences r4 = m23784b()     // Catch:{ JSONException -> 0x010f }
        java.lang.String r10 = r4.getString(r10, r5)     // Catch:{ JSONException -> 0x010f }
        boolean r10 = r0.equals(r10)     // Catch:{ JSONException -> 0x010f }
        if (r10 != 0) goto L_0x00cf
        goto L_0x00e9
    L_0x00cf:
        java.lang.String r10 = "stat_time_1"
        android.content.SharedPreferences r4 = m23784b()     // Catch:{ JSONException -> 0x010f }
        r5 = 0
        long r4 = r4.getLong(r10, r5)     // Catch:{ JSONException -> 0x010f }
        long r6 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x010f }
        long r6 = r6 - r4
        r4 = 1800000(0x1b7740, double:8.89318E-318)
        int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
        if (r10 <= 0) goto L_0x00e8
        goto L_0x00e9
    L_0x00e8:
        r1 = 0
    L_0x00e9:
        if (r1 == 0) goto L_0x0109
        com.qiyukf.nimlib.a.c r10 = com.qiyukf.nimlib.p429a.C5668c.m22861a()     // Catch:{ JSONException -> 0x010f }
        com.qiyukf.nimlib.a.c.a.b r1 = new com.qiyukf.nimlib.a.c.a.b     // Catch:{ JSONException -> 0x010f }
        r1.m49853init(r9, r0)     // Catch:{ JSONException -> 0x010f }
        r10.mo27864a(r1)     // Catch:{ JSONException -> 0x010f }
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x010f }
        java.lang.String r0 = "report wifi info : "
        r10.<init>(r0)     // Catch:{ JSONException -> 0x010f }
        r10.append(r9)     // Catch:{ JSONException -> 0x010f }
        java.lang.String r9 = r10.toString()     // Catch:{ JSONException -> 0x010f }
        com.qiyukf.basesdk.p393a.C5264a.m21620b(r2, r9)     // Catch:{ JSONException -> 0x010f }
        return
    L_0x0109:
        java.lang.String r9 = "should not report wifi info, as connected wifi info has not changed"
        com.qiyukf.basesdk.p393a.C5264a.m21620b(r2, r9)     // Catch:{ JSONException -> 0x010f }
    L_0x010e:
        return
    L_0x010f:
        r9 = move-exception
        r9.printStackTrace()
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        java.lang.String r0 = "build wifi report error, e="
        r10.<init>(r0)
        java.lang.String r9 = r9.getMessage()
        r10.append(r9)
        java.lang.String r9 = r10.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21620b(r2, r9)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p486j.C5926a.m23781a(android.content.Context, boolean):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m23782a(C5926a aVar, final Context context) {
        if (context == null) {
            context = C5718b.m23009a();
        }
        if (C5723c.m23046e().mo27969a()) {
            aVar.f18731a.post(new Runnable() {
                /* renamed from: b */
                final /* synthetic */ boolean f18735b = true;

                public final void run() {
                    C5926a.m23781a(context, this.f18735b);
                }
            });
            return;
        }
        C5264a.m21620b("stat", "unable to scan wifi info, as server is not granted");
    }

    /* renamed from: a */
    public static void m23783a(String str) {
        C5407d.m22127a(m23784b(), "stat_md5_1", str);
        C5407d.m22126a(m23784b(), "stat_time_1", System.currentTimeMillis());
    }

    /* renamed from: b */
    private static SharedPreferences m23784b() {
        Context a = C5718b.m23009a();
        StringBuilder sb = new StringBuilder("NIMSDK_STAT_");
        sb.append(C5718b.m23020g());
        return a.getSharedPreferences(sb.toString(), 0);
    }

    /* renamed from: a */
    public final void mo28363a(Context context) {
        final Context applicationContext = context.getApplicationContext();
        this.f18731a.postDelayed(new Runnable() {
            public final void run() {
                if (C5411c.m22139f(applicationContext)) {
                    C5264a.m21620b("stat", "collect and upload stat on UI login done...");
                    C5926a.m23782a(C5926a.this, applicationContext);
                }
            }
        }, 5000);
    }
}
