package com.tencent.bugly.beta.upgrade;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.upgrade.b */
public class C7151b {
    /* renamed from: a */
    public static C7151b f23829a = new C7151b();

    /* access modifiers changed from: protected|declared_synchronized */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0283  */
    /* renamed from: a */
    public synchronized void mo34470a(int r18, byte[] r19, com.tencent.bugly.beta.upgrade.C7150a r20, boolean r21, java.lang.String r22) {
        /*
        r17 = this;
        monitor-enter(r17)
        com.tencent.bugly.crashreport.common.info.a r0 = com.tencent.bugly.crashreport.common.info.C7174a.m30754b()     // Catch:{ all -> 0x0297 }
        com.tencent.bugly.beta.global.e r1 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x027a }
        android.content.Context r1 = r1.f23747s     // Catch:{ all -> 0x027a }
        r3 = r18
        r2 = r19
        com.tencent.bugly.proguard.bh r1 = com.tencent.bugly.proguard.C7216ah.m31073a(r1, r3, r2)     // Catch:{ all -> 0x0278 }
        if (r1 == 0) goto L_0x0295
        com.tencent.bugly.beta.global.e r2 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0278 }
        java.lang.String r4 = r2.f23749u     // Catch:{ all -> 0x0278 }
        r1.f24487b = r4     // Catch:{ all -> 0x0278 }
        java.lang.String r4 = r2.f23714P     // Catch:{ all -> 0x0278 }
        boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0278 }
        if (r4 != 0) goto L_0x0025
        java.lang.String r4 = r2.f23714P     // Catch:{ all -> 0x0278 }
        r1.f24490e = r4     // Catch:{ all -> 0x0278 }
    L_0x0025:
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        if (r4 == 0) goto L_0x0295
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G6"
        java.lang.String r6 = r2.f23750v     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G10"
        java.lang.String r6 = "1.4.2"
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G3"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r2.f23752x     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G11"
        int r6 = r2.f23751w     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G7"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r0.mo34600m()     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G8"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r0.mo34598k()     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G9"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r0.mo34599l()     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G2"
        com.tencent.bugly.beta.global.e r6 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0278 }
        android.content.Context r6 = r6.f23747s     // Catch:{ all -> 0x0278 }
        int r6 = com.tencent.bugly.beta.global.C7127a.m30539a(r6)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G12"
        int r6 = r2.f23743o     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "A21"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r0.mo34593g()     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "A22"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r0.mo34595h()     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G13"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r2.f23708J     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G14"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r2.f23709K     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G15"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r2.f23711M     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G17"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.Boolean r7 = r0.mo34611x()     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "C01"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        int r7 = r0.mo34562H()     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = "G18"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r6.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = ""
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r0.mo34593g()     // Catch:{ all -> 0x0278 }
        r6.append(r7)     // Catch:{ all -> 0x0278 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0278 }
        r4.put(r5, r6)     // Catch:{ all -> 0x0278 }
        java.util.Map r4 = r0.mo34556B()     // Catch:{ all -> 0x0278 }
        if (r4 == 0) goto L_0x01f1
        int r5 = r4.size()     // Catch:{ all -> 0x0278 }
        if (r5 <= 0) goto L_0x01f1
        java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x0278 }
        java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0278 }
    L_0x01c4:
        boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0278 }
        if (r5 == 0) goto L_0x01f1
        java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0278 }
        java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0278 }
        java.util.Map<java.lang.String, java.lang.String> r6 = r1.f24496k     // Catch:{ all -> 0x0278 }
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r7.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r8 = "C03_"
        r7.append(r8)     // Catch:{ all -> 0x0278 }
        java.lang.Object r8 = r5.getKey()     // Catch:{ all -> 0x0278 }
        java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0278 }
        r7.append(r8)     // Catch:{ all -> 0x0278 }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0278 }
        java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0278 }
        r6.put(r7, r5)     // Catch:{ all -> 0x0278 }
        goto L_0x01c4
    L_0x01f1:
        java.lang.String r4 = "app version is: [%s.%s], [deviceId:%s], channel: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s]"
        r5 = 7
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0278 }
        r6 = 0
        java.lang.String r7 = r2.f23752x     // Catch:{ all -> 0x0278 }
        r5[r6] = r7     // Catch:{ all -> 0x0278 }
        r6 = 1
        int r7 = r2.f23751w     // Catch:{ all -> 0x0278 }
        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0278 }
        r5[r6] = r7     // Catch:{ all -> 0x0278 }
        r6 = 2
        java.lang.String r0 = r0.mo34595h()     // Catch:{ all -> 0x0278 }
        r5[r6] = r0     // Catch:{ all -> 0x0278 }
        r0 = 3
        java.lang.String r6 = r1.f24490e     // Catch:{ all -> 0x0278 }
        r5[r0] = r6     // Catch:{ all -> 0x0278 }
        r0 = 4
        java.lang.String r6 = r2.f23708J     // Catch:{ all -> 0x0278 }
        r5[r0] = r6     // Catch:{ all -> 0x0278 }
        r0 = 5
        java.lang.String r6 = r2.f23709K     // Catch:{ all -> 0x0278 }
        r5[r0] = r6     // Catch:{ all -> 0x0278 }
        r0 = 6
        java.lang.String r2 = r2.f23711M     // Catch:{ all -> 0x0278 }
        r5[r0] = r2     // Catch:{ all -> 0x0278 }
        com.tencent.bugly.proguard.C7226an.m31147c(r4, r5)     // Catch:{ all -> 0x0278 }
        java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0278 }
        r0.<init>()     // Catch:{ all -> 0x0278 }
        java.lang.String r2 = "grayStrategyUpdateTime"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0278 }
        r4.<init>()     // Catch:{ all -> 0x0278 }
        com.tencent.bugly.beta.global.e r5 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0278 }
        com.tencent.bugly.beta.upgrade.BetaUploadStrategy r5 = r5.f23704F     // Catch:{ all -> 0x0278 }
        long r5 = r5.f23824b     // Catch:{ all -> 0x0278 }
        r4.append(r5)     // Catch:{ all -> 0x0278 }
        java.lang.String r5 = ""
        r4.append(r5)     // Catch:{ all -> 0x0278 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0278 }
        r0.put(r2, r4)     // Catch:{ all -> 0x0278 }
        if (r21 == 0) goto L_0x0260
        com.tencent.bugly.proguard.ak r6 = com.tencent.bugly.proguard.C7219ak.m31089a()     // Catch:{ all -> 0x0278 }
        r7 = 1002(0x3ea, float:1.404E-42)
        int r8 = r1.f24492g     // Catch:{ all -> 0x0278 }
        byte[] r9 = com.tencent.bugly.proguard.C7216ah.m31079a(r1)     // Catch:{ all -> 0x0278 }
        r13 = 0
        r14 = 1
        r15 = 1
        r10 = r22
        r11 = r22
        r12 = r20
        r16 = r0
        r6.mo34808a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0278 }
        goto L_0x0295
    L_0x0260:
        com.tencent.bugly.proguard.ak r6 = com.tencent.bugly.proguard.C7219ak.m31089a()     // Catch:{ all -> 0x0278 }
        r7 = 1002(0x3ea, float:1.404E-42)
        int r8 = r1.f24492g     // Catch:{ all -> 0x0278 }
        byte[] r9 = com.tencent.bugly.proguard.C7216ah.m31079a(r1)     // Catch:{ all -> 0x0278 }
        r13 = 0
        r10 = r22
        r11 = r22
        r12 = r20
        r14 = r0
        r6.mo34810a(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0278 }
        goto L_0x0295
    L_0x0278:
        r0 = move-exception
        goto L_0x027d
    L_0x027a:
        r0 = move-exception
        r3 = r18
    L_0x027d:
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x0297 }
        if (r1 != 0) goto L_0x0286
        r0.printStackTrace()     // Catch:{ all -> 0x0297 }
    L_0x0286:
        r4 = 0
        r5 = 0
        r7 = 0
        r9 = 0
        java.lang.String r10 = "sendRequest failed"
        r2 = r20
        r3 = r18
        r2.mo34469a(r3, r4, r5, r7, r9, r10)     // Catch:{ all -> 0x0297 }
    L_0x0295:
        monitor-exit(r17)
        return
    L_0x0297:
        r0 = move-exception
        monitor-exit(r17)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.C7151b.mo34470a(int, byte[], com.tencent.bugly.beta.upgrade.a, boolean, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo34471a(com.tencent.bugly.proguard.C7281x r8, boolean r9) {
        /*
        r7 = this;
        monitor-enter(r7)
        if (r8 != 0) goto L_0x0005
        monitor-exit(r7)
        return
    L_0x0005:
        byte[] r2 = com.tencent.bugly.proguard.C7216ah.m31078a(r8)     // Catch:{ all -> 0x002d }
        r1 = 803(0x323, float:1.125E-42)
        com.tencent.bugly.beta.upgrade.a r3 = new com.tencent.bugly.beta.upgrade.a     // Catch:{ all -> 0x002d }
        r0 = 803(0x323, float:1.125E-42)
        r4 = 2
        java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x002d }
        r6 = 0
        r5[r6] = r8     // Catch:{ all -> 0x002d }
        r8 = 1
        java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x002d }
        r5[r8] = r9     // Catch:{ all -> 0x002d }
        r3.m52440init(r4, r0, r5)     // Catch:{ all -> 0x002d }
        r4 = 0
        com.tencent.bugly.beta.global.e r8 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x002d }
        com.tencent.bugly.beta.upgrade.BetaUploadStrategy r8 = r8.f23704F     // Catch:{ all -> 0x002d }
        com.tencent.bugly.proguard.bk r8 = r8.f23823a     // Catch:{ all -> 0x002d }
        java.lang.String r5 = r8.f24528d     // Catch:{ all -> 0x002d }
        r0 = r7
        r0.mo34470a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x002d }
        goto L_0x0037
    L_0x002d:
        r8 = move-exception
        boolean r9 = com.tencent.bugly.proguard.C7226an.m31145b(r8)     // Catch:{ all -> 0x0039 }
        if (r9 != 0) goto L_0x0037
        r8.printStackTrace()     // Catch:{ all -> 0x0039 }
    L_0x0037:
        monitor-exit(r7)
        return
    L_0x0039:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.C7151b.mo34471a(com.tencent.bugly.proguard.x, boolean):void");
    }
}
