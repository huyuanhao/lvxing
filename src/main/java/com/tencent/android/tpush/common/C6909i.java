package com.tencent.android.tpush.common;

import android.content.Context;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.i */
public class C6909i {
    /* renamed from: a */
    private static C6909i f22978a;
    /* renamed from: b */
    private Context f22979b = null;
    /* renamed from: c */
    private String f22980c = null;
    /* renamed from: d */
    private String f22981d = null;

    private C6909i(Context context) {
        this.f22979b = context.getApplicationContext();
        this.f22980c = C6914l.m29525f(context);
        this.f22981d = String.valueOf(4.03f);
    }

    /* renamed from: a */
    public static synchronized C6909i m29488a(Context context) {
        C6909i iVar;
        synchronized (C6909i.class) {
            if (f22978a == null) {
                f22978a = new C6909i(context);
            }
            iVar = f22978a;
        }
        return iVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b2 A[Catch:{ Exception -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00df A[Catch:{ Exception -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e6 A[ADDED_TO_REGION, Catch:{ Exception -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0109 A[Catch:{ Exception -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011f A[Catch:{ Exception -> 0x012a }] */
    /* renamed from: a */
    public java.lang.String mo33108a() {
        /*
        r14 = this;
        java.lang.String r0 = ".installtime"
        java.lang.String r1 = ""
        java.lang.String r2 = ".usertype"
        org.json.JSONObject r3 = new org.json.JSONObject
        r3.<init>()
        java.lang.String r4 = "appVer"
        java.lang.String r5 = r14.f22980c     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.common.C6900b.m29457a(r3, r4, r5)     // Catch:{ Exception -> 0x012a }
        java.lang.String r4 = "appSdkVer"
        java.lang.String r5 = r14.f22981d     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.common.C6900b.m29457a(r3, r4, r5)     // Catch:{ Exception -> 0x012a }
        java.lang.String r4 = "ch"
        android.content.Context r5 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = com.tencent.android.tpush.XGPushConfig.getInstallChannel(r5)     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.common.C6900b.m29457a(r3, r4, r5)     // Catch:{ Exception -> 0x012a }
        java.lang.String r4 = "gs"
        android.content.Context r5 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = com.tencent.android.tpush.XGPushConfig.getGameServer(r5)     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.common.C6900b.m29457a(r3, r4, r5)     // Catch:{ Exception -> 0x012a }
        r4 = -1
        android.content.Context r5 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.common.k r5 = com.tencent.android.tpush.common.C6913k.m29501a(r5)     // Catch:{ Exception -> 0x012a }
        boolean r5 = r5.mo33121c()     // Catch:{ Exception -> 0x012a }
        java.lang.String r6 = "XGOtherPush"
        r7 = 0
        r8 = 1
        if (r5 != 0) goto L_0x0058
        android.content.Context r5 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        boolean r5 = com.tencent.android.tpush.XGPushConfig.isUsedOtherPush(r5)     // Catch:{ Exception -> 0x012a }
        if (r5 == 0) goto L_0x0055
        android.content.Context r5 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.d.d r5 = com.tencent.android.tpush.p584d.C6927d.m29569a(r5)     // Catch:{ Exception -> 0x012a }
        boolean r5 = r5.mo33132a()     // Catch:{ Exception -> 0x012a }
        if (r5 == 0) goto L_0x0055
        goto L_0x0058
    L_0x0055:
        r4 = 0
        r5 = 0
        goto L_0x00b0
    L_0x0058:
        android.content.Context r5 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.d.d r5 = com.tencent.android.tpush.p584d.C6927d.m29569a(r5)     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = r5.mo33136f()     // Catch:{ Exception -> 0x012a }
        android.content.Context r9 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.d.d r9 = com.tencent.android.tpush.p584d.C6927d.m29569a(r9)     // Catch:{ Exception -> 0x012a }
        java.lang.String r9 = r9.mo33135d()     // Catch:{ Exception -> 0x012a }
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012a }
        r10.<init>()     // Catch:{ Exception -> 0x012a }
        java.lang.String r11 = "Reservert info: other push token is : "
        r10.append(r11)     // Catch:{ Exception -> 0x012a }
        r10.append(r9)     // Catch:{ Exception -> 0x012a }
        java.lang.String r11 = "  other push type: "
        r10.append(r11)     // Catch:{ Exception -> 0x012a }
        r10.append(r5)     // Catch:{ Exception -> 0x012a }
        java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.p580b.C6864a.m29305f(r6, r10)     // Catch:{ Exception -> 0x012a }
        boolean r10 = com.tencent.android.tpush.common.C6914l.m29521c(r5)     // Catch:{ Exception -> 0x012a }
        if (r10 != 0) goto L_0x0099
        boolean r10 = com.tencent.android.tpush.common.C6914l.m29521c(r9)     // Catch:{ Exception -> 0x012a }
        if (r10 != 0) goto L_0x0099
        com.tencent.android.tpush.common.C6900b.m29457a(r3, r5, r9)     // Catch:{ Exception -> 0x012a }
        r5 = 1
        goto L_0x009a
    L_0x0099:
        r5 = 0
    L_0x009a:
        android.content.Context r9 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.common.k r9 = com.tencent.android.tpush.common.C6913k.m29501a(r9)     // Catch:{ Exception -> 0x012a }
        boolean r9 = r9.mo33121c()     // Catch:{ Exception -> 0x012a }
        if (r9 == 0) goto L_0x00a7
        r4 = 2
    L_0x00a7:
        android.content.Context r9 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        boolean r9 = com.tencent.android.tpush.XGPushConfig.isUsedOtherPush(r9)     // Catch:{ Exception -> 0x012a }
        if (r9 == 0) goto L_0x00b0
        r4 = 1
    L_0x00b0:
        if (r5 != 0) goto L_0x00c1
        java.lang.String r5 = "Reservert info: use normal xg token register"
        com.tencent.android.tpush.p580b.C6864a.m29305f(r6, r5)     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = "fcm"
        com.tencent.android.tpush.common.C6900b.m29457a(r3, r5, r1)     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = "miid"
        com.tencent.android.tpush.common.C6900b.m29457a(r3, r5, r1)     // Catch:{ Exception -> 0x012a }
    L_0x00c1:
        android.content.Context r1 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = ".firstregister"
        int r1 = com.tencent.android.tpush.common.C6908h.m29480a(r1, r5, r8)     // Catch:{ Exception -> 0x012a }
        android.content.Context r5 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        int r5 = com.tencent.android.tpush.common.C6908h.m29480a(r5, r2, r7)     // Catch:{ Exception -> 0x012a }
        android.content.Context r6 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        r9 = 0
        long r6 = com.tencent.android.tpush.common.C6908h.m29481a(r6, r0, r9)     // Catch:{ Exception -> 0x012a }
        long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012a }
        int r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
        if (r13 != 0) goto L_0x00e6
        android.content.Context r2 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.common.C6908h.m29486b(r2, r0, r11)     // Catch:{ Exception -> 0x012a }
        r6 = r11
        goto L_0x0102
    L_0x00e6:
        if (r5 != 0) goto L_0x0102
        if (r1 == r8) goto L_0x0102
        java.lang.String r0 = com.tencent.android.tpush.common.C6914l.m29506a(r6)     // Catch:{ Exception -> 0x012a }
        long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012a }
        java.lang.String r9 = com.tencent.android.tpush.common.C6914l.m29506a(r9)     // Catch:{ Exception -> 0x012a }
        boolean r0 = r0.equals(r9)     // Catch:{ Exception -> 0x012a }
        if (r0 != 0) goto L_0x0102
        android.content.Context r0 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        com.tencent.android.tpush.common.C6908h.m29485b(r0, r2, r8)     // Catch:{ Exception -> 0x012a }
        r5 = 1
    L_0x0102:
        java.lang.String r0 = "ut"
        r3.put(r0, r5)     // Catch:{ Exception -> 0x012a }
        if (r1 != r8) goto L_0x010e
        java.lang.String r0 = "freg"
        r3.put(r0, r8)     // Catch:{ Exception -> 0x012a }
    L_0x010e:
        java.lang.String r0 = "it"
        r1 = 1000(0x3e8, double:4.94E-321)
        long r6 = r6 / r1
        int r1 = (int) r6     // Catch:{ Exception -> 0x012a }
        r3.put(r0, r1)     // Catch:{ Exception -> 0x012a }
        android.content.Context r0 = r14.f22979b     // Catch:{ Exception -> 0x012a }
        boolean r0 = com.tencent.android.tpush.common.C6914l.m29518b(r0)     // Catch:{ Exception -> 0x012a }
        if (r0 == 0) goto L_0x0124
        java.lang.String r0 = "aidl"
        r3.put(r0, r8)     // Catch:{ Exception -> 0x012a }
    L_0x0124:
        java.lang.String r0 = "push_type"
        r3.put(r0, r4)     // Catch:{ Exception -> 0x012a }
        goto L_0x0132
    L_0x012a:
        r0 = move-exception
        java.lang.String r1 = "RegisterReservedInfo"
        java.lang.String r2 = "toSting"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r2, r0)
    L_0x0132:
        java.lang.String r0 = r3.toString()
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.common.C6909i.mo33108a():java.lang.String");
    }
}
