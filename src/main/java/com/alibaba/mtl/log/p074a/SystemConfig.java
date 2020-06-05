package com.alibaba.mtl.log.p074a;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.log.a.e */
public class SystemConfig {
    /* JADX WARNING: Can't wrap try/catch for region: R(12:7|8|(1:10)|11|12|(1:14)|15|16|17|18|(2:20|(1:22)(1:(1:24)))(2:25|(1:27))|(3:28|29|(1:43)(2:33|44))) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x006b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00d1 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055 A[Catch:{ all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c4 A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d7 A[Catch:{ all -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    public static void m3728a(java.lang.String r12) {
        /*
        java.lang.String r0 = "cdb"
        java.lang.String r1 = "discard"
        java.lang.String r2 = ""
        java.lang.String r3 = "fg_interval"
        java.lang.String r4 = "bg_interval"
        java.lang.String r5 = "SYSTEM"
        java.lang.String r6 = "SystemConfig"
        boolean r7 = android.text.TextUtils.isEmpty(r12)
        if (r7 != 0) goto L_0x00f4
        org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x00ee }
        r7.<init>(r12)     // Catch:{ all -> 0x00ee }
        boolean r8 = r7.has(r5)     // Catch:{ all -> 0x00ee }
        if (r8 == 0) goto L_0x00f4
        r8 = 2
        java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x00ee }
        java.lang.String r10 = "server system config "
        r11 = 0
        r9[r11] = r10     // Catch:{ all -> 0x00ee }
        r10 = 1
        r9[r10] = r12     // Catch:{ all -> 0x00ee }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r6, r9)     // Catch:{ all -> 0x00ee }
        org.json.JSONObject r12 = r7.optJSONObject(r5)     // Catch:{ all -> 0x00ee }
        if (r12 == 0) goto L_0x00f4
        boolean r5 = r12.has(r4)     // Catch:{ all -> 0x004f }
        if (r5 == 0) goto L_0x004f
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
        r5.<init>()     // Catch:{ all -> 0x004f }
        int r4 = r12.getInt(r4)     // Catch:{ all -> 0x004f }
        r5.append(r4)     // Catch:{ all -> 0x004f }
        r5.append(r2)     // Catch:{ all -> 0x004f }
        java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x004f }
        com.alibaba.mtl.log.p074a.Config.m3708b(r4)     // Catch:{ all -> 0x004f }
    L_0x004f:
        boolean r4 = r12.has(r3)     // Catch:{ all -> 0x006b }
        if (r4 == 0) goto L_0x006b
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
        r4.<init>()     // Catch:{ all -> 0x006b }
        int r3 = r12.getInt(r3)     // Catch:{ all -> 0x006b }
        r4.append(r3)     // Catch:{ all -> 0x006b }
        r4.append(r2)     // Catch:{ all -> 0x006b }
        java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x006b }
        com.alibaba.mtl.log.p074a.Config.m3710c(r2)     // Catch:{ all -> 0x006b }
    L_0x006b:
        java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x00ee }
        java.lang.String r3 = "UTDC.bSendToNewLogStore:"
        r2[r11] = r3     // Catch:{ all -> 0x00ee }
        boolean r3 = com.alibaba.mtl.log.UTDC.f3277h     // Catch:{ all -> 0x00ee }
        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00ee }
        r2[r10] = r3     // Catch:{ all -> 0x00ee }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r6, r2)     // Catch:{ all -> 0x00ee }
        java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x00ee }
        java.lang.String r3 = "Config.BACKGROUND_PERIOD:"
        r2[r11] = r3     // Catch:{ all -> 0x00ee }
        long r3 = com.alibaba.mtl.log.p074a.Config.m3714e()     // Catch:{ all -> 0x00ee }
        java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00ee }
        r2[r10] = r3     // Catch:{ all -> 0x00ee }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r6, r2)     // Catch:{ all -> 0x00ee }
        java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x00ee }
        java.lang.String r3 = "Config.FOREGROUND_PERIOD:"
        r2[r11] = r3     // Catch:{ all -> 0x00ee }
        long r3 = com.alibaba.mtl.log.p074a.Config.m3712d()     // Catch:{ all -> 0x00ee }
        java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00ee }
        r2[r10] = r3     // Catch:{ all -> 0x00ee }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r6, r2)     // Catch:{ all -> 0x00ee }
        boolean r2 = r12.has(r1)     // Catch:{ all -> 0x00d1 }
        if (r2 == 0) goto L_0x00c4
        int r1 = r12.getInt(r1)     // Catch:{ all -> 0x00d1 }
        if (r1 != r10) goto L_0x00b8
        com.alibaba.mtl.log.p074a.Config.f3287e = r10     // Catch:{ all -> 0x00d1 }
        com.alibaba.mtl.log.f.a r1 = com.alibaba.mtl.log.p079f.UploadEngine.m3889a()     // Catch:{ all -> 0x00d1 }
        r1.mo11831d()     // Catch:{ all -> 0x00d1 }
        goto L_0x00d1
    L_0x00b8:
        if (r1 != 0) goto L_0x00d1
        com.alibaba.mtl.log.p074a.Config.f3287e = r11     // Catch:{ all -> 0x00d1 }
        com.alibaba.mtl.log.f.a r1 = com.alibaba.mtl.log.p079f.UploadEngine.m3889a()     // Catch:{ all -> 0x00d1 }
        r1.mo11829b()     // Catch:{ all -> 0x00d1 }
        goto L_0x00d1
    L_0x00c4:
        boolean r1 = com.alibaba.mtl.log.p074a.Config.f3287e     // Catch:{ all -> 0x00d1 }
        if (r1 == 0) goto L_0x00d1
        com.alibaba.mtl.log.p074a.Config.f3287e = r11     // Catch:{ all -> 0x00d1 }
        com.alibaba.mtl.log.f.a r1 = com.alibaba.mtl.log.p079f.UploadEngine.m3889a()     // Catch:{ all -> 0x00d1 }
        r1.mo11829b()     // Catch:{ all -> 0x00d1 }
    L_0x00d1:
        boolean r1 = r12.has(r0)     // Catch:{ all -> 0x00f4 }
        if (r1 == 0) goto L_0x00f4
        int r12 = r12.getInt(r0)     // Catch:{ all -> 0x00f4 }
        int r0 = m3727a()     // Catch:{ all -> 0x00f4 }
        if (r12 <= r0) goto L_0x00f4
        com.alibaba.mtl.log.d.r r12 = com.alibaba.mtl.log.p077d.TaskExecutor.m3867a()     // Catch:{ all -> 0x00f4 }
        com.alibaba.mtl.log.a.e$1 r0 = new com.alibaba.mtl.log.a.e$1     // Catch:{ all -> 0x00f4 }
        r0.m41883init()     // Catch:{ all -> 0x00f4 }
        r12.mo11811a(r0)     // Catch:{ all -> 0x00f4 }
        goto L_0x00f4
    L_0x00ee:
        r12 = move-exception
        java.lang.String r0 = "updateconfig"
        com.alibaba.mtl.log.p077d.Logger.m3832a(r6, r0, r12)
    L_0x00f4:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p074a.SystemConfig.m3728a(java.lang.String):void");
    }

    /* renamed from: a */
    public static int m3727a() {
        String str = "cdb";
        String str2 = "SYSTEM";
        String f = Config.m3717f();
        if (TextUtils.isEmpty(f)) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(f);
            if (!jSONObject.has(str2)) {
                return 0;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (jSONObject2 == null || !jSONObject2.has(str)) {
                return 0;
            }
            return jSONObject2.getInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
