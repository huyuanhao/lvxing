package com.tencent.bugly.beta.upgrade;

import com.tencent.bugly.proguard.C7218aj;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.upgrade.a */
public class C7150a implements C7218aj {
    /* renamed from: a */
    public final int f23825a;
    /* renamed from: b */
    public final int f23826b;
    /* renamed from: c */
    public final Object[] f23827c;
    /* renamed from: d */
    public boolean f23828d = false;

    /* renamed from: a */
    public void mo34468a(int i) {
    }

    public C7150a(int i, int i2, Object... objArr) {
        this.f23825a = i;
        this.f23826b = i2;
        this.f23827c = objArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x013d, code lost:
            return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a8 A[Catch:{ Exception -> 0x0132 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa A[Catch:{ Exception -> 0x0132 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b1 A[Catch:{ Exception -> 0x0132 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011c A[Catch:{ Exception -> 0x0132 }] */
    /* renamed from: a */
    public synchronized void mo34469a(int r12, com.tencent.bugly.proguard.C7251bi r13, long r14, long r16, boolean r18, java.lang.String r19) {
        /*
        r11 = this;
        r1 = r11
        r0 = r13
        monitor-enter(r11)
        boolean r2 = r1.f23828d     // Catch:{ Exception -> 0x0132 }
        if (r2 != 0) goto L_0x013c
        int r2 = r1.f23826b     // Catch:{ Exception -> 0x0132 }
        r3 = r12
        if (r3 != r2) goto L_0x013c
        java.lang.String r2 = "upload %s:[%d] [sended %d] [recevied %d]"
        r4 = 4
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0132 }
        if (r18 == 0) goto L_0x0016
        java.lang.String r5 = "succ"
        goto L_0x0018
    L_0x0016:
        java.lang.String r5 = "err"
    L_0x0018:
        r6 = 0
        r4[r6] = r5     // Catch:{ Exception -> 0x0132 }
        java.lang.Integer r3 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0132 }
        r5 = 1
        r4[r5] = r3     // Catch:{ Exception -> 0x0132 }
        java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ Exception -> 0x0132 }
        r7 = 2
        r4[r7] = r3     // Catch:{ Exception -> 0x0132 }
        java.lang.Long r3 = java.lang.Long.valueOf(r16)     // Catch:{ Exception -> 0x0132 }
        r8 = 3
        r4[r8] = r3     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r4)     // Catch:{ Exception -> 0x0132 }
        int r2 = r1.f23825a     // Catch:{ Exception -> 0x0132 }
        if (r2 == r5) goto L_0x0067
        if (r2 == r7) goto L_0x003b
        goto L_0x012d
    L_0x003b:
        java.lang.Object[] r2 = r1.f23827c     // Catch:{ Exception -> 0x0132 }
        r2 = r2[r6]     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.proguard.x r2 = (com.tencent.bugly.proguard.C7281x) r2     // Catch:{ Exception -> 0x0132 }
        int r2 = r1.f23826b     // Catch:{ Exception -> 0x0132 }
        r3 = 803(0x323, float:1.125E-42)
        if (r2 == r3) goto L_0x0049
        monitor-exit(r11)
        return
    L_0x0049:
        if (r18 == 0) goto L_0x012d
        if (r0 == 0) goto L_0x0060
        byte[] r0 = r0.f24514c     // Catch:{ Exception -> 0x0132 }
        java.lang.Class<com.tencent.bugly.proguard.aa> r2 = com.tencent.bugly.proguard.C7206aa.class
        com.tencent.bugly.proguard.m r0 = com.tencent.bugly.proguard.C7216ah.m31077a(r0, r2)     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.proguard.aa r0 = (com.tencent.bugly.proguard.C7206aa) r0     // Catch:{ Exception -> 0x0132 }
        if (r0 == 0) goto L_0x0060
        com.tencent.bugly.beta.upgrade.c r2 = com.tencent.bugly.beta.upgrade.C7152c.f23830a     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.proguard.bk r0 = r0.f24285a     // Catch:{ Exception -> 0x0132 }
        r2.mo34473a(r0)     // Catch:{ Exception -> 0x0132 }
    L_0x0060:
        com.tencent.bugly.proguard.p r0 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x0132 }
        r0.mo34954b()     // Catch:{ Exception -> 0x0132 }
        goto L_0x012d
    L_0x0067:
        java.lang.Object[] r2 = r1.f23827c     // Catch:{ Exception -> 0x0132 }
        r2 = r2[r6]     // Catch:{ Exception -> 0x0132 }
        java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0132 }
        boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0132 }
        java.lang.Object[] r3 = r1.f23827c     // Catch:{ Exception -> 0x0132 }
        r3 = r3[r5]     // Catch:{ Exception -> 0x0132 }
        java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x0132 }
        boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x0132 }
        int r4 = r1.f23826b     // Catch:{ Exception -> 0x0132 }
        r9 = 804(0x324, float:1.127E-42)
        if (r4 == r9) goto L_0x0083
        monitor-exit(r11)
        return
    L_0x0083:
        r4 = 0
        if (r18 == 0) goto L_0x0099
        if (r0 == 0) goto L_0x0099
        byte[] r0 = r0.f24514c     // Catch:{ Exception -> 0x0132 }
        java.lang.Class<com.tencent.bugly.proguard.aa> r9 = com.tencent.bugly.proguard.C7206aa.class
        com.tencent.bugly.proguard.m r0 = com.tencent.bugly.proguard.C7216ah.m31077a(r0, r9)     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.proguard.aa r0 = (com.tencent.bugly.proguard.C7206aa) r0     // Catch:{ Exception -> 0x0132 }
        if (r0 == 0) goto L_0x0099
        com.tencent.bugly.proguard.bk r9 = r0.f24285a     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.proguard.y r0 = r0.f24286b     // Catch:{ Exception -> 0x0132 }
        goto L_0x009b
    L_0x0099:
        r0 = r4
        r9 = r0
    L_0x009b:
        com.tencent.bugly.beta.upgrade.c r10 = com.tencent.bugly.beta.upgrade.C7152c.f23830a     // Catch:{ Exception -> 0x0132 }
        r10.mo34473a(r9)     // Catch:{ Exception -> 0x0132 }
        java.lang.Object[] r9 = r1.f23827c     // Catch:{ Exception -> 0x0132 }
        r9 = r9[r7]     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r9 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r9     // Catch:{ Exception -> 0x0132 }
        if (r0 == 0) goto L_0x00aa
        r4 = r0
        goto L_0x00ae
    L_0x00aa:
        if (r9 == 0) goto L_0x00ae
        com.tencent.bugly.proguard.y r4 = r9.f23818a     // Catch:{ Exception -> 0x0132 }
    L_0x00ae:
        r9 = -1
        if (r4 == 0) goto L_0x011c
        int r4 = r4.f24668p     // Catch:{ Exception -> 0x0132 }
        if (r4 == r5) goto L_0x0107
        if (r4 == r7) goto L_0x012d
        if (r4 == r8) goto L_0x00c2
        java.lang.String r0 = "unexpected updatetype"
        java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.proguard.C7226an.m31141a(r0, r2)     // Catch:{ Exception -> 0x0132 }
        goto L_0x012d
    L_0x00c2:
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x0132 }
        r4.f23729ae = r8     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.proguard.q r4 = com.tencent.bugly.proguard.C7271q.f24601a     // Catch:{ Exception -> 0x0132 }
        if (r18 == 0) goto L_0x00cb
        r9 = 0
    L_0x00cb:
        r4.mo34960a(r9, r0, r6)     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.C7152c.f23830a     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r0 = r0.f23835f     // Catch:{ Exception -> 0x0132 }
        if (r0 == 0) goto L_0x00f3
        com.tencent.bugly.beta.global.d r0 = new com.tencent.bugly.beta.global.d     // Catch:{ Exception -> 0x0132 }
        r3 = 18
        java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.beta.upgrade.c r8 = com.tencent.bugly.beta.upgrade.C7152c.f23830a     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r8 = r8.f23835f     // Catch:{ Exception -> 0x0132 }
        r4[r6] = r8     // Catch:{ Exception -> 0x0132 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0132 }
        r4[r5] = r6     // Catch:{ Exception -> 0x0132 }
        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0132 }
        r4[r7] = r2     // Catch:{ Exception -> 0x0132 }
        r0.m52393init(r3, r4)     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.beta.utils.C7159e.m30681a(r0)     // Catch:{ Exception -> 0x0132 }
        goto L_0x012d
    L_0x00f3:
        if (r2 == 0) goto L_0x012d
        if (r3 != 0) goto L_0x012d
        com.tencent.bugly.beta.global.d r0 = new com.tencent.bugly.beta.global.d     // Catch:{ Exception -> 0x0132 }
        r2 = 5
        java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0132 }
        java.lang.String r4 = com.tencent.bugly.beta.Beta.strToastYourAreTheLatestVersion     // Catch:{ Exception -> 0x0132 }
        r3[r6] = r4     // Catch:{ Exception -> 0x0132 }
        r0.m52393init(r2, r3)     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.beta.utils.C7159e.m30681a(r0)     // Catch:{ Exception -> 0x0132 }
        goto L_0x012d
    L_0x0107:
        com.tencent.bugly.beta.upgrade.c r4 = com.tencent.bugly.beta.upgrade.C7152c.f23830a     // Catch:{ Exception -> 0x0132 }
        if (r18 == 0) goto L_0x010c
        r9 = 0
    L_0x010c:
        r12 = r4
        r13 = r2
        r14 = r3
        r15 = r9
        r16 = r0
        r17 = r19
        r12.mo34475a(r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0132 }
        com.tencent.bugly.beta.global.e r0 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x0132 }
        r0.f23729ae = r5     // Catch:{ Exception -> 0x0132 }
        goto L_0x012d
    L_0x011c:
        com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.C7152c.f23830a     // Catch:{ Exception -> 0x0132 }
        if (r18 == 0) goto L_0x0121
        r9 = 0
    L_0x0121:
        r4 = 0
        r12 = r0
        r13 = r2
        r14 = r3
        r15 = r9
        r16 = r4
        r17 = r19
        r12.mo34475a(r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0132 }
    L_0x012d:
        r1.f23828d = r5     // Catch:{ Exception -> 0x0132 }
        goto L_0x013c
    L_0x0130:
        r0 = move-exception
        goto L_0x013e
    L_0x0132:
        r0 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31145b(r0)     // Catch:{ all -> 0x0130 }
        if (r2 != 0) goto L_0x013c
        r0.printStackTrace()     // Catch:{ all -> 0x0130 }
    L_0x013c:
        monitor-exit(r11)
        return
    L_0x013e:
        monitor-exit(r11)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.C7150a.mo34469a(int, com.tencent.bugly.proguard.bi, long, long, boolean, java.lang.String):void");
    }
}
