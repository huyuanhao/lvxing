package com.tencent.bugly.beta.global;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.d */
public class C7130d implements Runnable {
    /* renamed from: a */
    int f23696a;
    /* renamed from: b */
    public final Object[] f23697b;

    public C7130d(int i, Object... objArr) {
        this.f23696a = i;
        this.f23697b = objArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:168|169|172|173|174|(1:176)|177|(1:179)|180|(3:184|(2:186|(3:188|(1:193)(1:192)|194)(1:195))|196)|197|198) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:172:0x0511 */
    public void run() {
        /*
        r21 = this;
        r1 = r21
        int r2 = r1.f23696a     // Catch:{ Exception -> 0x064c }
        r3 = 4
        r4 = 0
        r5 = 3
        r6 = 2
        r7 = 1
        r8 = 0
        switch(r2) {
            case 1: goto L_0x04ed;
            case 2: goto L_0x04d8;
            case 3: goto L_0x0469;
            case 4: goto L_0x0410;
            case 5: goto L_0x0401;
            case 6: goto L_0x03dc;
            case 7: goto L_0x03d1;
            case 8: goto L_0x03ad;
            case 9: goto L_0x0366;
            case 10: goto L_0x0332;
            case 11: goto L_0x02eb;
            case 12: goto L_0x02a1;
            case 13: goto L_0x01c3;
            case 14: goto L_0x015d;
            case 15: goto L_0x0110;
            case 16: goto L_0x00d7;
            case 17: goto L_0x0068;
            case 18: goto L_0x0028;
            case 19: goto L_0x000f;
            default: goto L_0x000d;
        }     // Catch:{ Exception -> 0x064c }
    L_0x000d:
        goto L_0x0657
    L_0x000f:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x064c }
        boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x064c }
        boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.Beta.checkUpgrade(r2, r3)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0028:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r2 = (com.tencent.bugly.beta.upgrade.UpgradeStateListener) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x064c }
        int r3 = r3.intValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r6]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x064c }
        boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x064c }
        r8 = -1
        if (r3 == r8) goto L_0x0063
        if (r3 == 0) goto L_0x005e
        if (r3 == r7) goto L_0x0059
        if (r3 == r6) goto L_0x0054
        if (r3 == r5) goto L_0x004f
        goto L_0x0657
    L_0x004f:
        r2.onDownloadCompleted(r4)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0054:
        r2.onUpgrading(r4)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0059:
        r2.onUpgradeNoVersion(r4)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x005e:
        r2.onUpgradeSuccess(r4)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0063:
        r2.onUpgradeFailed(r4)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0068:
        com.tencent.bugly.beta.global.e r2 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x00c3 }
        android.content.Context r2 = r2.f23747s     // Catch:{ Exception -> 0x00c3 }
        android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x00c3 }
        if (r2 == 0) goto L_0x008a
        android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ Exception -> 0x00c3 }
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x00c3 }
        android.content.Context r4 = r4.f23747s     // Catch:{ Exception -> 0x00c3 }
        java.lang.Class<com.tencent.bugly.beta.ui.BetaActivity> r5 = com.tencent.bugly.beta.p602ui.BetaActivity.class
        java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x00c3 }
        r3.<init>(r4, r5)     // Catch:{ Exception -> 0x00c3 }
        int r4 = r2.getComponentEnabledSetting(r3)     // Catch:{ Exception -> 0x00c3 }
        if (r4 != r6) goto L_0x008a
        r2.setComponentEnabledSetting(r3, r7, r7)     // Catch:{ Exception -> 0x00c3 }
    L_0x008a:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x00c3 }
        r2 = r2[r8]     // Catch:{ Exception -> 0x00c3 }
        java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x00c3 }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x00c3 }
        r3 = r3[r7]     // Catch:{ Exception -> 0x00c3 }
        java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x00c3 }
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x00c3 }
        r4 = r4[r6]     // Catch:{ Exception -> 0x00c3 }
        com.tencent.bugly.beta.ui.b r4 = (com.tencent.bugly.beta.p602ui.C7143b) r4     // Catch:{ Exception -> 0x00c3 }
        r2.put(r3, r4)     // Catch:{ Exception -> 0x00c3 }
        android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x00c3 }
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x00c3 }
        android.content.Context r3 = r3.f23747s     // Catch:{ Exception -> 0x00c3 }
        java.lang.Class<com.tencent.bugly.beta.ui.BetaActivity> r4 = com.tencent.bugly.beta.p602ui.BetaActivity.class
        r2.<init>(r3, r4)     // Catch:{ Exception -> 0x00c3 }
        java.lang.String r3 = "frag"
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x00c3 }
        r4 = r4[r7]     // Catch:{ Exception -> 0x00c3 }
        java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x00c3 }
        r2.putExtra(r3, r4)     // Catch:{ Exception -> 0x00c3 }
        r3 = 268435456(0x10000000, float:2.5243549E-29)
        r2.setFlags(r3)     // Catch:{ Exception -> 0x00c3 }
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x00c3 }
        android.content.Context r3 = r3.f23747s     // Catch:{ Exception -> 0x00c3 }
        r3.startActivity(r2)     // Catch:{ Exception -> 0x00c3 }
        goto L_0x0657
    L_0x00c3:
        r0 = move-exception
        r2 = r0
        java.lang.String r3 = "无法正常弹窗，请在AndroidManifest.xml中添加BetaActivity声明：\n<activity\n    android:name=\"com.tencent.bugly.beta.ui.BetaActivity\"\n    android:theme=\"@android:style/Theme.Translucent\" />"
        java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.C7226an.m31149e(r3, r4)     // Catch:{ Exception -> 0x064c }
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31145b(r2)     // Catch:{ Exception -> 0x064c }
        if (r3 != 0) goto L_0x0657
        r2.printStackTrace()     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x00d7:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.upgrade.UpgradeListener r2 = (com.tencent.bugly.beta.upgrade.UpgradeListener) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r8 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r7 = r8[r7]     // Catch:{ Exception -> 0x064c }
        java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x064c }
        int r7 = r7.intValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r8 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r6 = r8[r6]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r6 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r6     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r8 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r5 = r8[r5]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x064c }
        boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r8 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r8[r3]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x064c }
        boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x064c }
        if (r6 != 0) goto L_0x0104
        goto L_0x010b
    L_0x0104:
        com.tencent.bugly.beta.UpgradeInfo r4 = new com.tencent.bugly.beta.UpgradeInfo     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r6 = r6.f23818a     // Catch:{ Exception -> 0x064c }
        r4.m52380init(r6)     // Catch:{ Exception -> 0x064c }
    L_0x010b:
        r2.onUpgrade(r7, r4, r5, r3)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0110:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.ui.b r2 = (com.tencent.bugly.beta.p602ui.C7143b) r2     // Catch:{ Exception -> 0x064c }
        boolean r2 = r2.mo34442b()     // Catch:{ Exception -> 0x064c }
        if (r2 != 0) goto L_0x0156
        java.lang.String r2 = com.tencent.bugly.beta.p602ui.C7148g.m30580a()     // Catch:{ Exception -> 0x064c }
        java.lang.Class<com.tencent.bugly.beta.ui.BetaActivity> r3 = com.tencent.bugly.beta.p602ui.BetaActivity.class
        java.lang.String r3 = r3.getCanonicalName()     // Catch:{ Exception -> 0x064c }
        boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ Exception -> 0x064c }
        if (r2 == 0) goto L_0x012d
        goto L_0x0156
    L_0x012d:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.ui.b r2 = (com.tencent.bugly.beta.p602ui.C7143b) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x064c }
        boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r6]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x064c }
        boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r6 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r5 = r6[r5]     // Catch:{ Exception -> 0x064c }
        java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ Exception -> 0x064c }
        long r5 = r5.longValue()     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.p602ui.C7148g.m30582a(r2, r3, r4, r5)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0156:
        r2 = 3000(0xbb8, double:1.482E-320)
        com.tencent.bugly.beta.utils.C7159e.m30682a(r1, r2)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x015d:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadTask r2 = (com.tencent.bugly.beta.download.DownloadTask) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r3 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r3     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r6]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x064c }
        boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x064c }
        if (r2 == 0) goto L_0x01bb
        if (r3 != 0) goto L_0x0178
        goto L_0x01bb
    L_0x0178:
        int r2 = r2.getStatus()     // Catch:{ Exception -> 0x064c }
        if (r2 == r6) goto L_0x0657
        r3.f23821d = r8     // Catch:{ Exception -> 0x064c }
        long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r3.f23820c = r8     // Catch:{ Exception -> 0x064c }
        if (r4 != 0) goto L_0x0193
        com.tencent.bugly.proguard.y r2 = r3.f23818a     // Catch:{ Exception -> 0x064c }
        byte r2 = r2.f24659g     // Catch:{ Exception -> 0x064c }
        if (r2 == r6) goto L_0x0193
        int r2 = r3.f23819b     // Catch:{ Exception -> 0x064c }
        int r2 = r2 + r7
        r3.f23819b = r2     // Catch:{ Exception -> 0x064c }
    L_0x0193:
        java.lang.String r2 = "st.bch"
        com.tencent.bugly.beta.global.C7127a.m30553a(r2, r3)     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.p r2 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.w r15 = new com.tencent.bugly.proguard.w     // Catch:{ Exception -> 0x064c }
        java.lang.String r5 = "pop"
        long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r8 = 2
        r9 = 0
        com.tencent.bugly.proguard.y r4 = r3.f23818a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.v r11 = r4.f24657e     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r4 = r3.f23818a     // Catch:{ Exception -> 0x064c }
        java.lang.String r12 = r4.f24665m     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r3 = r3.f23818a     // Catch:{ Exception -> 0x064c }
        int r13 = r3.f24668p     // Catch:{ Exception -> 0x064c }
        r14 = 0
        r4 = r15
        r4.m52629init(r5, r6, r8, r9, r11, r12, r13, r14)     // Catch:{ Exception -> 0x064c }
        r2.mo34953a(r15)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x01bb:
        java.lang.String r2 = "strategyTask or betaStrategy is null"
        java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ Exception -> 0x064c }
        return
    L_0x01c3:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadTask r2 = (com.tencent.bugly.beta.download.DownloadTask) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r4 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r4     // Catch:{ Exception -> 0x064c }
        if (r2 == 0) goto L_0x0299
        if (r4 != 0) goto L_0x01d5
        goto L_0x0299
    L_0x01d5:
        int r8 = r2.getStatus()     // Catch:{ Exception -> 0x064c }
        if (r8 == 0) goto L_0x01ed
        if (r8 == r7) goto L_0x01ed
        if (r8 == r6) goto L_0x01e8
        if (r8 == r5) goto L_0x01ed
        if (r8 == r3) goto L_0x01ed
        r3 = 5
        if (r8 == r3) goto L_0x01ed
        goto L_0x0657
    L_0x01e8:
        r2.stop()     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x01ed:
        boolean r3 = r4.f23821d     // Catch:{ Exception -> 0x064c }
        if (r3 != 0) goto L_0x01fe
        r4.f23821d = r7     // Catch:{ Exception -> 0x064c }
        long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r4.f23820c = r8     // Catch:{ Exception -> 0x064c }
        java.lang.String r3 = "st.bch"
        com.tencent.bugly.beta.global.C7127a.m30553a(r3, r4)     // Catch:{ Exception -> 0x064c }
    L_0x01fe:
        int r3 = r2.getStatus()     // Catch:{ Exception -> 0x064c }
        if (r3 == r6) goto L_0x0257
        int r3 = r2.getStatus()     // Catch:{ Exception -> 0x064c }
        if (r3 != r7) goto L_0x0231
        com.tencent.bugly.proguard.p r3 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.w r5 = new com.tencent.bugly.proguard.w     // Catch:{ Exception -> 0x064c }
        java.lang.String r9 = "pop"
        long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r12 = 4
        r13 = 0
        com.tencent.bugly.proguard.y r6 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.v r15 = r6.f24657e     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r6 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        java.lang.String r6 = r6.f24665m     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r8 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        int r8 = r8.f24668p     // Catch:{ Exception -> 0x064c }
        r18 = 0
        r17 = r8
        r8 = r5
        r16 = r6
        r8.m52629init(r9, r10, r12, r13, r15, r16, r17, r18)     // Catch:{ Exception -> 0x064c }
        r3.mo34953a(r5)     // Catch:{ Exception -> 0x064c }
        goto L_0x0257
    L_0x0231:
        com.tencent.bugly.proguard.p r3 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.w r5 = new com.tencent.bugly.proguard.w     // Catch:{ Exception -> 0x064c }
        java.lang.String r9 = "pop"
        long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r12 = 3
        r13 = 0
        com.tencent.bugly.proguard.y r6 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.v r15 = r6.f24657e     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r6 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        java.lang.String r6 = r6.f24665m     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r8 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        int r8 = r8.f24668p     // Catch:{ Exception -> 0x064c }
        r18 = 0
        r17 = r8
        r8 = r5
        r16 = r6
        r8.m52629init(r9, r10, r12, r13, r15, r16, r17, r18)     // Catch:{ Exception -> 0x064c }
        r3.mo34953a(r5)     // Catch:{ Exception -> 0x064c }
    L_0x0257:
        int r3 = r2.getStatus()     // Catch:{ Exception -> 0x064c }
        if (r3 != r7) goto L_0x0294
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x064c }
        android.content.Context r3 = r3.f23747s     // Catch:{ Exception -> 0x064c }
        java.io.File r5 = r2.getSaveFile()     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r6 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.u r6 = r6.f24658f     // Catch:{ Exception -> 0x064c }
        java.lang.String r6 = r6.f24617a     // Catch:{ Exception -> 0x064c }
        boolean r3 = com.tencent.bugly.beta.global.C7127a.m30549a(r3, r5, r6)     // Catch:{ Exception -> 0x064c }
        if (r3 == 0) goto L_0x0294
        com.tencent.bugly.proguard.p r2 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.w r3 = new com.tencent.bugly.proguard.w     // Catch:{ Exception -> 0x064c }
        java.lang.String r6 = "install"
        long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r9 = 0
        r10 = 0
        com.tencent.bugly.proguard.y r5 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.v r12 = r5.f24657e     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r5 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        java.lang.String r13 = r5.f24665m     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r4 = r4.f23818a     // Catch:{ Exception -> 0x064c }
        int r14 = r4.f24668p     // Catch:{ Exception -> 0x064c }
        r15 = 0
        r5 = r3
        r5.m52629init(r6, r7, r9, r10, r12, r13, r14, r15)     // Catch:{ Exception -> 0x064c }
        r2.mo34953a(r3)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0294:
        r2.download()     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0299:
        java.lang.String r2 = "strategyTask or betaStrategy is null"
        java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ Exception -> 0x064c }
        return
    L_0x02a1:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x064c }
        boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.upgrade.a r3 = (com.tencent.bugly.beta.upgrade.C7150a) r3     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r7]     // Catch:{ Exception -> 0x064c }
        monitor-enter(r4)     // Catch:{ Exception -> 0x064c }
        if (r2 != 0) goto L_0x02e4
        boolean r2 = r3.f23828d     // Catch:{ all -> 0x02e7 }
        if (r2 != 0) goto L_0x02e4
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ all -> 0x02e7 }
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x02e7 }
        r2[r8] = r5     // Catch:{ all -> 0x02e7 }
        int r10 = r3.f23826b     // Catch:{ all -> 0x02e7 }
        r11 = 0
        r12 = 0
        r14 = 0
        r16 = 0
        java.lang.String r17 = "request is not finished"
        r9 = r3
        r9.mo34469a(r10, r11, r12, r14, r16, r17)     // Catch:{ all -> 0x02e7 }
        java.lang.Object[] r2 = r3.f23827c     // Catch:{ all -> 0x02e7 }
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x02e7 }
        r2[r7] = r5     // Catch:{ all -> 0x02e7 }
        r3.f23828d = r8     // Catch:{ all -> 0x02e7 }
        java.lang.String r2 = "request is not finished"
        java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ all -> 0x02e7 }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ all -> 0x02e7 }
    L_0x02e4:
        monitor-exit(r4)     // Catch:{ all -> 0x02e7 }
        goto L_0x0657
    L_0x02e7:
        r0 = move-exception
        r2 = r0
        monitor-exit(r4)     // Catch:{ all -> 0x02e7 }
        throw r2     // Catch:{ Exception -> 0x064c }
    L_0x02eb:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.ui.b r2 = (com.tencent.bugly.beta.p602ui.C7143b) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x064c }
        boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r6]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x064c }
        boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r6 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r5 = r6[r5]     // Catch:{ Exception -> 0x064c }
        java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ Exception -> 0x064c }
        long r5 = r5.longValue()     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.p602ui.C7148g.m30582a(r2, r3, r4, r5)     // Catch:{ Exception -> 0x064c }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x064c }
        r2.<init>()     // Catch:{ Exception -> 0x064c }
        java.lang.String r3 = "BetaAct TYPE_actCanShow checking : "
        r2.append(r3)     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r8]     // Catch:{ Exception -> 0x064c }
        int r3 = r3.hashCode()     // Catch:{ Exception -> 0x064c }
        r2.append(r3)     // Catch:{ Exception -> 0x064c }
        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0332:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x064c }
        if (r2 == 0) goto L_0x0657
        java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x064c }
    L_0x033e:
        boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x064c }
        if (r3 == 0) goto L_0x0657
        java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadListener r3 = (com.tencent.bugly.beta.download.DownloadListener) r3     // Catch:{ Exception -> 0x064c }
        if (r3 == 0) goto L_0x033e
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadTask r4 = (com.tencent.bugly.beta.download.DownloadTask) r4     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r8 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r8 = r8[r6]     // Catch:{ Exception -> 0x064c }
        java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x064c }
        int r8 = r8.intValue()     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r9 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r9 = r9[r5]     // Catch:{ Exception -> 0x064c }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x064c }
        r3.onFailed(r4, r8, r9)     // Catch:{ Exception -> 0x064c }
        goto L_0x033e
    L_0x0366:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x064c }
        if (r2 == 0) goto L_0x038a
        java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x064c }
    L_0x0372:
        boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x064c }
        if (r3 == 0) goto L_0x038a
        java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadListener r3 = (com.tencent.bugly.beta.download.DownloadListener) r3     // Catch:{ Exception -> 0x064c }
        if (r3 == 0) goto L_0x0372
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadTask r4 = (com.tencent.bugly.beta.download.DownloadTask) r4     // Catch:{ Exception -> 0x064c }
        r3.onReceive(r4)     // Catch:{ Exception -> 0x064c }
        goto L_0x0372
    L_0x038a:
        com.tencent.bugly.beta.global.e r2 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.interfaces.BetaPatchListener r2 = r2.f23721W     // Catch:{ Exception -> 0x064c }
        if (r2 == 0) goto L_0x0657
        com.tencent.bugly.beta.global.e r2 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x064c }
        int r2 = r2.f23729ae     // Catch:{ Exception -> 0x064c }
        if (r2 != r5) goto L_0x0657
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadTask r2 = (com.tencent.bugly.beta.download.DownloadTask) r2     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.interfaces.BetaPatchListener r3 = r3.f23721W     // Catch:{ Exception -> 0x064c }
        long r4 = r2.getSavedLength()     // Catch:{ Exception -> 0x064c }
        long r6 = r2.getTotalLength()     // Catch:{ Exception -> 0x064c }
        r3.onDownloadReceived(r4, r6)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x03ad:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x064c }
        if (r2 == 0) goto L_0x0657
        java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x064c }
    L_0x03b9:
        boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x064c }
        if (r3 == 0) goto L_0x0657
        java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadListener r3 = (com.tencent.bugly.beta.download.DownloadListener) r3     // Catch:{ Exception -> 0x064c }
        if (r3 == 0) goto L_0x03b9
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadTask r4 = (com.tencent.bugly.beta.download.DownloadTask) r4     // Catch:{ Exception -> 0x064c }
        r3.onCompleted(r4)     // Catch:{ Exception -> 0x064c }
        goto L_0x03b9
    L_0x03d1:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.ui.h r2 = (com.tencent.bugly.beta.p602ui.C7149h) r2     // Catch:{ Exception -> 0x064c }
        r2.mo34449c()     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x03dc:
        monitor-enter(r21)     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ all -> 0x03fd }
        r2 = r2[r8]     // Catch:{ all -> 0x03fd }
        java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x03fd }
        boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x03fd }
        if (r2 != 0) goto L_0x03fa
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ all -> 0x03fd }
        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x03fd }
        r2[r8] = r3     // Catch:{ all -> 0x03fd }
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ all -> 0x03fd }
        r2 = r2[r7]     // Catch:{ all -> 0x03fd }
        java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x03fd }
        r2.run()     // Catch:{ all -> 0x03fd }
    L_0x03fa:
        monitor-exit(r21)     // Catch:{ all -> 0x03fd }
        goto L_0x0657
    L_0x03fd:
        r0 = move-exception
        r2 = r0
        monitor-exit(r21)     // Catch:{ all -> 0x03fd }
        throw r2     // Catch:{ Exception -> 0x064c }
    L_0x0401:
        com.tencent.bugly.beta.global.e r2 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x064c }
        android.content.Context r2 = r2.f23747s     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r8]     // Catch:{ Exception -> 0x064c }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.utils.C7160f.m30684a(r2, r3)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0410:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadTask r3 = (com.tencent.bugly.beta.download.DownloadTask) r3     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r4 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r4 = r4[r6]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x064c }
        boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x064c }
        int r3 = r3.getStatus()     // Catch:{ Exception -> 0x064c }
        if (r3 == r6) goto L_0x0657
        r2.f23821d = r8     // Catch:{ Exception -> 0x064c }
        long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r2.f23820c = r8     // Catch:{ Exception -> 0x064c }
        if (r4 != 0) goto L_0x0441
        com.tencent.bugly.proguard.y r3 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        byte r3 = r3.f24659g     // Catch:{ Exception -> 0x064c }
        if (r3 == r6) goto L_0x0441
        int r3 = r2.f23819b     // Catch:{ Exception -> 0x064c }
        int r3 = r3 + r7
        r2.f23819b = r3     // Catch:{ Exception -> 0x064c }
    L_0x0441:
        java.lang.String r3 = "st.bch"
        com.tencent.bugly.beta.global.C7127a.m30553a(r3, r2)     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.p r3 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.w r15 = new com.tencent.bugly.proguard.w     // Catch:{ Exception -> 0x064c }
        java.lang.String r5 = "pop"
        long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r8 = 2
        r9 = 0
        com.tencent.bugly.proguard.y r4 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.v r11 = r4.f24657e     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r4 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        java.lang.String r12 = r4.f24665m     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r2 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        int r13 = r2.f24668p     // Catch:{ Exception -> 0x064c }
        r14 = 0
        r4 = r15
        r4.m52629init(r5, r6, r8, r9, r11, r12, r13, r14)     // Catch:{ Exception -> 0x064c }
        r3.mo34953a(r15)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x0469:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.download.DownloadTask r3 = (com.tencent.bugly.beta.download.DownloadTask) r3     // Catch:{ Exception -> 0x064c }
        boolean r4 = r2.f23821d     // Catch:{ Exception -> 0x064c }
        if (r4 != 0) goto L_0x0486
        r2.f23821d = r7     // Catch:{ Exception -> 0x064c }
        long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r2.f23820c = r4     // Catch:{ Exception -> 0x064c }
        java.lang.String r4 = "st.bch"
        com.tencent.bugly.beta.global.C7127a.m30553a(r4, r2)     // Catch:{ Exception -> 0x064c }
    L_0x0486:
        int r4 = r3.getStatus()     // Catch:{ Exception -> 0x064c }
        if (r4 == r6) goto L_0x0657
        int r3 = r3.getStatus()     // Catch:{ Exception -> 0x064c }
        if (r3 != r7) goto L_0x04b5
        com.tencent.bugly.proguard.p r3 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.w r15 = new com.tencent.bugly.proguard.w     // Catch:{ Exception -> 0x064c }
        java.lang.String r5 = "pop"
        long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r8 = 4
        r9 = 0
        com.tencent.bugly.proguard.y r4 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.v r11 = r4.f24657e     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r4 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        java.lang.String r12 = r4.f24665m     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r2 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        int r13 = r2.f24668p     // Catch:{ Exception -> 0x064c }
        r14 = 0
        r4 = r15
        r4.m52629init(r5, r6, r8, r9, r11, r12, r13, r14)     // Catch:{ Exception -> 0x064c }
        r3.mo34953a(r15)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x04b5:
        com.tencent.bugly.proguard.p r3 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.w r15 = new com.tencent.bugly.proguard.w     // Catch:{ Exception -> 0x064c }
        java.lang.String r5 = "pop"
        long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x064c }
        r8 = 3
        r9 = 0
        com.tencent.bugly.proguard.y r4 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.v r11 = r4.f24657e     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r4 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        java.lang.String r12 = r4.f24665m     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.proguard.y r2 = r2.f23818a     // Catch:{ Exception -> 0x064c }
        int r13 = r2.f24668p     // Catch:{ Exception -> 0x064c }
        r14 = 0
        r4 = r15
        r4.m52629init(r5, r6, r8, r9, r11, r12, r13, r14)     // Catch:{ Exception -> 0x064c }
        r3.mo34953a(r15)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x04d8:
        java.lang.Object[] r2 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r2 = r2[r8]     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.ui.b r2 = (com.tencent.bugly.beta.p602ui.C7143b) r2     // Catch:{ Exception -> 0x064c }
        java.lang.Object[] r3 = r1.f23697b     // Catch:{ Exception -> 0x064c }
        r3 = r3[r7]     // Catch:{ Exception -> 0x064c }
        java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x064c }
        boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x064c }
        com.tencent.bugly.beta.p602ui.C7148g.m30581a(r2, r3)     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x04ed:
        java.lang.String r2 = "Beta async init start..."
        java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0640 }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ Exception -> 0x0640 }
        com.tencent.bugly.beta.global.e r2 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x0640 }
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x0640 }
        monitor-enter(r3)     // Catch:{ Exception -> 0x0640 }
        java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0511 }
        android.content.pm.PackageInfo r9 = r2.f23754z     // Catch:{ Exception -> 0x0511 }
        android.content.pm.ApplicationInfo r9 = r9.applicationInfo     // Catch:{ Exception -> 0x0511 }
        java.lang.String r9 = r9.publicSourceDir     // Catch:{ Exception -> 0x0511 }
        r5.<init>(r9)     // Catch:{ Exception -> 0x0511 }
        java.lang.String r9 = "MD5"
        java.lang.String r5 = com.tencent.bugly.proguard.C7232aq.m31182a(r5, r9)     // Catch:{ Exception -> 0x0511 }
        r2.f23750v = r5     // Catch:{ Exception -> 0x0511 }
        goto L_0x0513
    L_0x050d:
        r0 = move-exception
        r2 = r0
        goto L_0x063e
    L_0x0511:
        r2.f23750v = r4     // Catch:{ all -> 0x050d }
    L_0x0513:
        java.lang.String r5 = r2.f23750v     // Catch:{ all -> 0x050d }
        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x050d }
        if (r5 == 0) goto L_0x0526
        java.lang.String r5 = "null"
        r2.f23750v = r5     // Catch:{ all -> 0x050d }
        java.lang.String r5 = "无法获取md5值"
        java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.C7226an.m31149e(r5, r9)     // Catch:{ all -> 0x050d }
    L_0x0526:
        boolean r5 = r2.f23702C     // Catch:{ all -> 0x050d }
        if (r5 == 0) goto L_0x052f
        java.io.File r5 = r2.f23748t     // Catch:{ all -> 0x050d }
        com.tencent.bugly.beta.global.C7127a.m30546a(r5)     // Catch:{ all -> 0x050d }
    L_0x052f:
        java.lang.String r5 = "st.bch"
        android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaGrayStrategy> r9 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR     // Catch:{ all -> 0x050d }
        android.os.Parcelable r5 = com.tencent.bugly.beta.global.C7127a.m30544a(r5, r9)     // Catch:{ all -> 0x050d }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r5 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r5     // Catch:{ all -> 0x050d }
        if (r5 == 0) goto L_0x05f3
        com.tencent.bugly.proguard.y r9 = r5.f23818a     // Catch:{ all -> 0x050d }
        if (r9 == 0) goto L_0x05f3
        com.tencent.bugly.proguard.y r9 = r5.f23818a     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.v r9 = r9.f24657e     // Catch:{ all -> 0x050d }
        java.lang.String r9 = r9.f24631i     // Catch:{ all -> 0x050d }
        java.lang.String r9 = r9.toUpperCase()     // Catch:{ all -> 0x050d }
        java.lang.String r10 = r2.f23750v     // Catch:{ all -> 0x050d }
        boolean r9 = android.text.TextUtils.equals(r9, r10)     // Catch:{ all -> 0x050d }
        if (r9 == 0) goto L_0x05de
        java.lang.String r9 = "st.bch"
        boolean r9 = com.tencent.bugly.beta.global.C7127a.m30552a(r9)     // Catch:{ all -> 0x050d }
        if (r9 == 0) goto L_0x05d7
        java.lang.String r9 = "installApkMd5"
        java.lang.String r9 = com.tencent.bugly.beta.global.C7127a.m30555b(r9, r4)     // Catch:{ all -> 0x050d }
        boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x050d }
        if (r10 != 0) goto L_0x0599
        java.lang.String r10 = r2.f23750v     // Catch:{ all -> 0x050d }
        boolean r9 = android.text.TextUtils.equals(r9, r10)     // Catch:{ all -> 0x050d }
        if (r9 == 0) goto L_0x0599
        com.tencent.bugly.proguard.p r9 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.w r15 = new com.tencent.bugly.proguard.w     // Catch:{ all -> 0x050d }
        java.lang.String r11 = "active"
        long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x050d }
        r14 = 0
        r16 = 0
        r18 = 0
        com.tencent.bugly.proguard.y r10 = r5.f23818a     // Catch:{ all -> 0x050d }
        java.lang.String r10 = r10.f24665m     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.y r6 = r5.f23818a     // Catch:{ all -> 0x050d }
        int r6 = r6.f24668p     // Catch:{ all -> 0x050d }
        r20 = 0
        r19 = r10
        r10 = r15
        r7 = r15
        r15 = r16
        r17 = r18
        r18 = r19
        r19 = r6
        r10.m52629init(r11, r12, r14, r15, r17, r18, r19, r20)     // Catch:{ all -> 0x050d }
        r9.mo34953a(r7)     // Catch:{ all -> 0x050d }
        goto L_0x05a0
    L_0x0599:
        java.lang.String r6 = "activated from the other way"
        java.lang.Object[] r7 = new java.lang.Object[r8]     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.C7226an.m31141a(r6, r7)     // Catch:{ all -> 0x050d }
    L_0x05a0:
        android.content.SharedPreferences r6 = r2.f23700A     // Catch:{ all -> 0x050d }
        android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ all -> 0x050d }
        java.lang.String r7 = "installApkMd5"
        android.content.SharedPreferences$Editor r6 = r6.remove(r7)     // Catch:{ all -> 0x050d }
        r6.apply()     // Catch:{ all -> 0x050d }
        com.tencent.bugly.beta.download.b r6 = r2.f23744p     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.y r7 = r5.f23818a     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.u r7 = r7.f24658f     // Catch:{ all -> 0x050d }
        java.lang.String r7 = r7.f24618b     // Catch:{ all -> 0x050d }
        java.io.File r9 = r2.f23748t     // Catch:{ all -> 0x050d }
        java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ all -> 0x050d }
        com.tencent.bugly.beta.download.DownloadTask r4 = r6.mo34326a(r7, r9, r4, r4)     // Catch:{ all -> 0x050d }
        r6 = 1
        r4.delete(r6)     // Catch:{ all -> 0x050d }
        java.io.File r4 = r2.f23748t     // Catch:{ all -> 0x050d }
        com.tencent.bugly.beta.global.C7127a.m30546a(r4)     // Catch:{ all -> 0x050d }
        com.tencent.bugly.beta.global.f r4 = com.tencent.bugly.beta.global.C7132f.f23755a     // Catch:{ all -> 0x050d }
        r4.mo34340a()     // Catch:{ all -> 0x050d }
        java.lang.String r4 = "upgrade success"
        java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.C7226an.m31141a(r4, r6)     // Catch:{ all -> 0x050d }
        goto L_0x05de
    L_0x05d7:
        java.lang.String r4 = "delete strategy failed"
        java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.C7226an.m31148d(r4, r6)     // Catch:{ all -> 0x050d }
    L_0x05de:
        java.lang.String r4 = "[this md5:%s] [strategy md5:%s]"
        r6 = 2
        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x050d }
        java.lang.String r7 = r2.f23750v     // Catch:{ all -> 0x050d }
        r6[r8] = r7     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.y r5 = r5.f23818a     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.v r5 = r5.f24657e     // Catch:{ all -> 0x050d }
        java.lang.String r5 = r5.f24631i     // Catch:{ all -> 0x050d }
        r7 = 1
        r6[r7] = r5     // Catch:{ all -> 0x050d }
        com.tencent.bugly.proguard.C7226an.m31141a(r4, r6)     // Catch:{ all -> 0x050d }
    L_0x05f3:
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x050d }
        r4.notifyAll()     // Catch:{ all -> 0x050d }
        monitor-exit(r3)     // Catch:{ all -> 0x050d }
        android.content.Context r3 = r2.f23747s     // Catch:{ Exception -> 0x0640 }
        com.tencent.bugly.beta.download.BetaReceiver r4 = new com.tencent.bugly.beta.download.BetaReceiver     // Catch:{ Exception -> 0x0640 }
        r4.m52382init()     // Catch:{ Exception -> 0x0640 }
        android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0640 }
        java.lang.String r6 = "android.net.conn.CONNECTIVITY_CHANGE"
        r5.<init>(r6)     // Catch:{ Exception -> 0x0640 }
        r3.registerReceiver(r4, r5)     // Catch:{ Exception -> 0x0640 }
        boolean r2 = r2.f23732d     // Catch:{ Exception -> 0x0640 }
        if (r2 == 0) goto L_0x0611
        com.tencent.bugly.beta.Beta.checkUpgrade(r8, r8)     // Catch:{ Exception -> 0x0640 }
    L_0x0611:
        com.tencent.bugly.beta.global.e r2 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x0640 }
        com.tencent.bugly.beta.upgrade.BetaUploadStrategy r2 = r2.f23704F     // Catch:{ Exception -> 0x0640 }
        com.tencent.bugly.proguard.bk r2 = r2.f23823a     // Catch:{ Exception -> 0x0640 }
        boolean r2 = r2.f24526b     // Catch:{ Exception -> 0x0640 }
        if (r2 == 0) goto L_0x0636
        com.tencent.bugly.proguard.p r2 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x0640 }
        java.util.List r2 = r2.mo34950a()     // Catch:{ Exception -> 0x0640 }
        java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x0640 }
        if (r2 == 0) goto L_0x0636
        boolean r3 = r2.isEmpty()     // Catch:{ Exception -> 0x0640 }
        if (r3 != 0) goto L_0x0636
        com.tencent.bugly.beta.upgrade.b r3 = com.tencent.bugly.beta.upgrade.C7151b.f23829a     // Catch:{ Exception -> 0x0640 }
        com.tencent.bugly.proguard.x r4 = new com.tencent.bugly.proguard.x     // Catch:{ Exception -> 0x0640 }
        r4.m52632init(r2)     // Catch:{ Exception -> 0x0640 }
        r2 = 1
        r3.mo34471a(r4, r2)     // Catch:{ Exception -> 0x0640 }
    L_0x0636:
        java.lang.String r2 = "Beta async init end..."
        java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0640 }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ Exception -> 0x0640 }
        goto L_0x0657
    L_0x063e:
        monitor-exit(r3)     // Catch:{ all -> 0x050d }
        throw r2     // Catch:{ Exception -> 0x0640 }
    L_0x0640:
        r0 = move-exception
        r2 = r0
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31145b(r2)     // Catch:{ Exception -> 0x064c }
        if (r3 != 0) goto L_0x0657
        r2.printStackTrace()     // Catch:{ Exception -> 0x064c }
        goto L_0x0657
    L_0x064c:
        r0 = move-exception
        r2 = r0
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31145b(r2)
        if (r3 != 0) goto L_0x0657
        r2.printStackTrace()
    L_0x0657:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C7130d.run():void");
    }
}
