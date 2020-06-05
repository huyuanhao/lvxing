package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.util.C1553o.C1554a;
import com.p522qq.p523e.comm.constants.Constants.KEYS;

/* renamed from: com.alipay.sdk.util.f */
public class C1543f {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Activity f3952a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public IAlixPay f3953b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Object f3954c = IAlixPay.class;
    /* renamed from: d */
    private boolean f3955d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C1544a f3956e;
    /* renamed from: f */
    private ServiceConnection f3957f = new C1545g(this);
    /* access modifiers changed from: private */
    /* renamed from: g */
    public String f3958g = null;
    /* renamed from: h */
    private IRemoteServiceCallback f3959h = new C1547i(this);

    /* renamed from: com.alipay.sdk.util.f$a */
    public interface C1544a {
        /* renamed from: a */
        void mo12127a();

        /* renamed from: b */
        void mo12128b();
    }

    public C1543f(Activity activity, C1544a aVar) {
        this.f3952a = activity;
        this.f3956e = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0055 A[Catch:{ all -> 0x005e }] */
    /* renamed from: a */
    public java.lang.String mo12216a(java.lang.String r6) {
        /*
        r5 = this;
        java.lang.String r0 = ""
        r1 = 0
        com.alipay.sdk.b.a r2 = com.alipay.sdk.p121b.C1508a.m4475g()     // Catch:{ all -> 0x005e }
        java.util.List r2 = r2.mo12159f()     // Catch:{ all -> 0x005e }
        com.alipay.sdk.b.a r3 = com.alipay.sdk.p121b.C1508a.m4475g()     // Catch:{ all -> 0x005e }
        boolean r3 = r3.f3866a     // Catch:{ all -> 0x005e }
        if (r3 == 0) goto L_0x0015
        if (r2 != 0) goto L_0x0017
    L_0x0015:
        java.util.List<com.alipay.sdk.b.a$a> r2 = com.alipay.sdk.app.C1502i.f3836a     // Catch:{ all -> 0x005e }
    L_0x0017:
        android.app.Activity r3 = r5.f3952a     // Catch:{ all -> 0x005e }
        com.alipay.sdk.util.o$a r2 = com.alipay.sdk.util.C1553o.m4666a(r3, r2)     // Catch:{ all -> 0x005e }
        java.lang.String r3 = "failed"
        if (r2 == 0) goto L_0x005d
        boolean r4 = r2.mo12220a()     // Catch:{ all -> 0x005e }
        if (r4 != 0) goto L_0x005d
        boolean r4 = r2.mo12221b()     // Catch:{ all -> 0x005e }
        if (r4 == 0) goto L_0x002e
        goto L_0x005d
    L_0x002e:
        android.content.pm.PackageInfo r4 = r2.f3966a     // Catch:{ all -> 0x005e }
        boolean r4 = com.alipay.sdk.util.C1553o.m4675a(r4)     // Catch:{ all -> 0x005e }
        if (r4 == 0) goto L_0x0037
        return r3
    L_0x0037:
        android.content.pm.PackageInfo r3 = r2.f3966a     // Catch:{ all -> 0x005e }
        if (r3 == 0) goto L_0x004d
        java.lang.String r3 = "com.eg.android.AlipayGphone"
        android.content.pm.PackageInfo r4 = r2.f3966a     // Catch:{ all -> 0x005e }
        java.lang.String r4 = r4.packageName     // Catch:{ all -> 0x005e }
        boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x005e }
        if (r3 == 0) goto L_0x0048
        goto L_0x004d
    L_0x0048:
        android.content.pm.PackageInfo r3 = r2.f3966a     // Catch:{ all -> 0x005e }
        java.lang.String r0 = r3.packageName     // Catch:{ all -> 0x005e }
        goto L_0x0051
    L_0x004d:
        java.lang.String r0 = com.alipay.sdk.util.C1553o.m4668a()     // Catch:{ all -> 0x005e }
    L_0x0051:
        android.content.pm.PackageInfo r3 = r2.f3966a     // Catch:{ all -> 0x005e }
        if (r3 == 0) goto L_0x0059
        android.content.pm.PackageInfo r3 = r2.f3966a     // Catch:{ all -> 0x005e }
        int r1 = r3.versionCode     // Catch:{ all -> 0x005e }
    L_0x0059:
        r5.m4641a(r2)     // Catch:{ all -> 0x005e }
        goto L_0x0066
    L_0x005d:
        return r3
    L_0x005e:
        r2 = move-exception
        java.lang.String r3 = "biz"
        java.lang.String r4 = "CheckClientSignEx"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r3, r4, r2)
    L_0x0066:
        java.lang.String r6 = r5.m4640a(r6, r0, r1)
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.C1543f.mo12216a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private void m4641a(C1554a aVar) throws InterruptedException {
        if (aVar != null) {
            PackageInfo packageInfo = aVar.f3966a;
            if (packageInfo != null) {
                String str = packageInfo.packageName;
                Intent intent = new Intent();
                intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
                try {
                    this.f3952a.startActivity(intent);
                } catch (Throwable th) {
                    C1505a.m4453a(KEYS.BIZ, "StartLaunchAppTransEx", th);
                }
                Thread.sleep(200);
            }
        }
    }

    /* JADX INFO: unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:40:0x0105 in {} preds:[B:46:0x010e, B:58:0x01a7]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.calcImmediateDominators(BlockProcessor.java:303)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:255)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:55)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: a */
    private java.lang.String m4640a(java.lang.String r17, java.lang.String r18, int r19) {
        /*
        r16 = this;
        r1 = r16
        r2 = r17
        r3 = r18
        r0 = r19
        java.lang.String r4 = "sc"
        java.lang.String r5 = r16.m4639a(r17, r18)
        com.alipay.sdk.b.a r6 = com.alipay.sdk.p121b.C1508a.m4475g()
        boolean r6 = r6.mo12155b()
        java.lang.String r7 = "failed"
        boolean r8 = r7.equals(r5)
        r9 = 125(0x7d, float:1.75E-43)
        java.lang.String r10 = "com.eg.android.AlipayGphone"
        java.lang.String r11 = ""
        java.lang.String r12 = "biz"
        if (r8 == 0) goto L_0x0035
        boolean r8 = r10.equals(r3)
        if (r8 == 0) goto L_0x0035
        if (r0 <= r9) goto L_0x0035
        if (r6 != 0) goto L_0x0035
        java.lang.String r8 = "BSPNotStartByConfig"
        com.alipay.sdk.app.statistic.C1505a.m4452a(r12, r8, r11)
    L_0x0035:
        boolean r7 = r7.equals(r5)
        if (r7 == 0) goto L_0x01e7
        boolean r7 = r10.equals(r3)
        if (r7 == 0) goto L_0x01e7
        if (r0 <= r9) goto L_0x01e7
        if (r6 == 0) goto L_0x01e7
        android.app.Activity r0 = r1.f3952a
        java.lang.String r5 = "scheme_failed"
        if (r0 == 0) goto L_0x01e7
        boolean r0 = m4642a(r3, r0)
        if (r0 != 0) goto L_0x0053
        goto L_0x01e7
    L_0x0053:
        java.util.concurrent.CountDownLatch r6 = new java.util.concurrent.CountDownLatch
        r0 = 1
        r6.<init>(r0)
        r7 = 32
        java.lang.String r7 = com.alipay.sdk.util.C1553o.m4669a(r7)
        java.lang.String r8 = "BSPStart"
        com.alipay.sdk.app.statistic.C1505a.m4452a(r12, r8, r7)
        com.alipay.sdk.util.h r8 = new com.alipay.sdk.util.h
        r8.m42173init(r1, r6)
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.sdk.app.AlipayResultActivity$a> r9 = com.alipay.sdk.app.AlipayResultActivity.f3789a
        r9.put(r7, r8)
        java.lang.String r9 = "&"
        r10 = -1
        java.lang.String[] r9 = r2.split(r9, r10)     // Catch:{ Exception -> 0x010b }
        int r10 = r9.length     // Catch:{ Exception -> 0x010b }
        r13 = 0     // Catch:{ Exception -> 0x010b }
        r14 = 0     // Catch:{ Exception -> 0x010b }
    L_0x0078:
        r15 = 0     // Catch:{ Exception -> 0x010b }
        if (r14 >= r10) goto L_0x00c7     // Catch:{ Exception -> 0x010b }
        r15 = r9[r14]     // Catch:{ Exception -> 0x010b }
        java.lang.String r8 = "bizcontext="     // Catch:{ Exception -> 0x010b }
        boolean r8 = r15.startsWith(r8)     // Catch:{ Exception -> 0x010b }
        if (r8 == 0) goto L_0x00c4     // Catch:{ Exception -> 0x010b }
        java.lang.String r8 = "{"     // Catch:{ Exception -> 0x010b }
        int r8 = r15.indexOf(r8)     // Catch:{ Exception -> 0x010b }
        java.lang.String r9 = "}"     // Catch:{ Exception -> 0x010b }
        int r9 = r15.lastIndexOf(r9)     // Catch:{ Exception -> 0x010b }
        int r9 = r9 + r0     // Catch:{ Exception -> 0x010b }
        java.lang.String r0 = r15.substring(r8, r9)     // Catch:{ Exception -> 0x010b }
        int r8 = r15.indexOf(r0)     // Catch:{ Exception -> 0x010b }
        java.lang.String r9 = r15.substring(r13, r8)     // Catch:{ Exception -> 0x010b }
        int r10 = r0.length()     // Catch:{ Exception -> 0x010b }
        int r8 = r8 + r10     // Catch:{ Exception -> 0x010b }
        java.lang.String r8 = r15.substring(r8)     // Catch:{ Exception -> 0x010b }
        org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x010b }
        r10.<init>(r0)     // Catch:{ Exception -> 0x010b }
        java.lang.String r0 = r10.optString(r4)     // Catch:{ Exception -> 0x010b }
        java.lang.String r13 = "h5tonative"     // Catch:{ Exception -> 0x010b }
        boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x010b }
        if (r0 == 0) goto L_0x00be     // Catch:{ Exception -> 0x010b }
        java.lang.String r0 = "h5tonative_scheme"     // Catch:{ Exception -> 0x010b }
        r10.put(r4, r0)     // Catch:{ Exception -> 0x010b }
        goto L_0x00ca     // Catch:{ Exception -> 0x010b }
    L_0x00be:
        java.lang.String r0 = "h5tonative_sdkscheme"     // Catch:{ Exception -> 0x010b }
        r10.put(r4, r0)     // Catch:{ Exception -> 0x010b }
        goto L_0x00ca     // Catch:{ Exception -> 0x010b }
    L_0x00c4:
        int r14 = r14 + 1     // Catch:{ Exception -> 0x010b }
        goto L_0x0078     // Catch:{ Exception -> 0x010b }
    L_0x00c7:
        r8 = r11     // Catch:{ Exception -> 0x010b }
        r9 = r8     // Catch:{ Exception -> 0x010b }
        r10 = r15     // Catch:{ Exception -> 0x010b }
    L_0x00ca:
        boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x010b }
        if (r0 != 0) goto L_0x00fd     // Catch:{ Exception -> 0x010b }
        int r0 = r2.indexOf(r15)     // Catch:{ Exception -> 0x010b }
        int r4 = r2.lastIndexOf(r15)     // Catch:{ Exception -> 0x010b }
        if (r0 != r4) goto L_0x00f5     // Catch:{ Exception -> 0x010b }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
        r0.<init>()     // Catch:{ Exception -> 0x010b }
        r0.append(r9)     // Catch:{ Exception -> 0x010b }
        java.lang.String r4 = r10.toString()     // Catch:{ Exception -> 0x010b }
        r0.append(r4)     // Catch:{ Exception -> 0x010b }
        r0.append(r8)     // Catch:{ Exception -> 0x010b }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x010b }
        java.lang.String r0 = r2.replace(r15, r0)     // Catch:{ Exception -> 0x010b }
        goto L_0x011b     // Catch:{ Exception -> 0x010b }
    L_0x00f5:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x010b }
        java.lang.String r4 = "multi ctx_args"     // Catch:{ Exception -> 0x010b }
        r0.<init>(r4)     // Catch:{ Exception -> 0x010b }
        throw r0     // Catch:{ Exception -> 0x010b }
    L_0x00fd:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x010b }
        java.lang.String r4 = "empty ctx_args"     // Catch:{ Exception -> 0x010b }
        r0.<init>(r4)     // Catch:{ Exception -> 0x010b }
        throw r0     // Catch:{ Exception -> 0x010b }
    L_0x0105:
        r0 = move-exception
        goto L_0x01cc
    L_0x0108:
        r0 = move-exception
        goto L_0x01d2
    L_0x010b:
        r0 = move-exception
        java.lang.String r4 = "BSPSCReplaceEx"
        byte[] r8 = r17.getBytes()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r9 = 2     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r8 = android.util.Base64.encodeToString(r8, r9)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        com.alipay.sdk.app.statistic.C1505a.m4454a(r12, r4, r0, r8)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r0 = r2     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
    L_0x011b:
        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.<init>()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r4 = "sourcePid"     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        int r8 = android.os.Binder.getCallingPid()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.put(r4, r8)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r4 = "external_info"     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.put(r4, r0)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r0 = "pkgName"     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        android.app.Activity r4 = r1.f3952a     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r4 = r4.getPackageName()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.put(r0, r4)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r0 = "session"     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.put(r0, r7)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r0 = r2.toString()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r2 = "UTF-8"     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        byte[] r0 = r0.getBytes(r2)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2 = 2     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.<init>()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r4 = "alipays://platformapi/startapp?appId=20000125&mqpSchemePay="     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.append(r4)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r0 = android.net.Uri.encode(r0)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.append(r0)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r0 = r2.toString()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        android.content.Intent r2 = new android.content.Intent     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.<init>()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.setPackage(r3)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r3 = 268435456(0x10000000, float:2.5243549E-29)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.addFlags(r3)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r2.setData(r0)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        android.app.Activity r0 = r1.f3952a     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r0.startActivity(r2)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        com.alipay.sdk.b.a r0 = com.alipay.sdk.p121b.C1508a.m4475g()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        android.app.Activity r2 = r1.f3952a     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        android.content.Context r2 = r2.getApplicationContext()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r0.mo12154a(r2)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r6.await()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r2 = r1.f3958g     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r3 = "unknown"     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.util.Map r0 = com.alipay.sdk.util.C1551m.m4662a(r2)     // Catch:{ all -> 0x01a3 }
        java.lang.String r4 = "resultStatus"     // Catch:{ all -> 0x01a3 }
        java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x01a3 }
        r4 = r0     // Catch:{ all -> 0x01a3 }
        java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x01a3 }
        if (r4 != 0) goto L_0x01aa
        java.lang.String r4 = "null"
        goto L_0x01aa
    L_0x01a1:
        r0 = move-exception
        goto L_0x01a5
    L_0x01a3:
        r0 = move-exception
        r4 = r3
    L_0x01a5:
        java.lang.String r3 = "BSPStatEx"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r12, r3, r0)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
    L_0x01aa:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r0.<init>()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r3 = "BSPDone-"     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r0.append(r3)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        r0.append(r4)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r0 = r0.toString()     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        com.alipay.sdk.app.statistic.C1505a.m4452a(r12, r0, r11)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        if (r0 == 0) goto L_0x01ca     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        java.lang.String r0 = "BSPEmpty"     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        com.alipay.sdk.app.statistic.C1505a.m4452a(r12, r0, r11)     // Catch:{ InterruptedException -> 0x0108, all -> 0x0105 }
        goto L_0x01e7
    L_0x01ca:
        r5 = r2
        goto L_0x01e7
    L_0x01cc:
        java.lang.String r2 = "BSPEx"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r12, r2, r0)
        goto L_0x01e7
    L_0x01d2:
        java.lang.String r2 = "BSPWaiting"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r12, r2, r0)
        com.alipay.sdk.app.k r0 = com.alipay.sdk.app.C1504k.PAY_WAITTING
        int r0 = r0.mo12142a()
        com.alipay.sdk.app.k r2 = com.alipay.sdk.app.C1504k.PAY_WAITTING
        java.lang.String r2 = r2.mo12145b()
        java.lang.String r5 = com.alipay.sdk.app.C1503j.m4438a(r0, r2, r11)
    L_0x01e7:
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.C1543f.m4640a(java.lang.String, java.lang.String, int):java.lang.String");
    }

    /* renamed from: a */
    private static boolean m4642a(String str, Context context) {
        String str2 = "BSPDetectFail";
        String str3 = KEYS.BIZ;
        try {
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            C1505a.m4452a(str3, str2, "");
            return false;
        } catch (Throwable th) {
            C1505a.m4453a(str3, str2, th);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ed, code lost:
            if (r9 != null) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ef, code lost:
            r9.setRequestedOrientation(0);
            r7.f3955d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x012b, code lost:
            if (r9 != null) goto L_0x00ef;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0129  */
    /* renamed from: a */
    private java.lang.String m4639a(java.lang.String r8, java.lang.String r9) {
        /*
        r7 = this;
        android.content.Intent r0 = new android.content.Intent
        r0.<init>()
        r0.setPackage(r9)
        java.lang.String r1 = com.alipay.sdk.util.C1553o.m4671a(r9)
        r0.setAction(r1)
        android.app.Activity r1 = r7.f3952a
        java.lang.String r1 = com.alipay.sdk.util.C1553o.m4670a(r1, r9)
        android.app.Activity r2 = r7.f3952a     // Catch:{ all -> 0x016d }
        android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x016d }
        android.content.ServiceConnection r3 = r7.f3957f     // Catch:{ all -> 0x016d }
        r4 = 1
        boolean r0 = r2.bindService(r0, r3, r4)     // Catch:{ all -> 0x016d }
        if (r0 == 0) goto L_0x0165
        java.lang.Object r0 = r7.f3954c
        monitor-enter(r0)
        com.alipay.android.app.IAlixPay r2 = r7.f3953b     // Catch:{ all -> 0x0162 }
        if (r2 != 0) goto L_0x0042
        java.lang.Object r2 = r7.f3954c     // Catch:{ InterruptedException -> 0x003a }
        com.alipay.sdk.b.a r3 = com.alipay.sdk.p121b.C1508a.m4475g()     // Catch:{ InterruptedException -> 0x003a }
        int r3 = r3.mo12153a()     // Catch:{ InterruptedException -> 0x003a }
        long r5 = (long) r3     // Catch:{ InterruptedException -> 0x003a }
        r2.wait(r5)     // Catch:{ InterruptedException -> 0x003a }
        goto L_0x0042
    L_0x003a:
        r2 = move-exception
        java.lang.String r3 = "biz"
        java.lang.String r5 = "BindWaitTimeoutEx"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r3, r5, r2)     // Catch:{ all -> 0x0162 }
    L_0x0042:
        monitor-exit(r0)     // Catch:{ all -> 0x0162 }
        r0 = 0
        r2 = 0
        com.alipay.android.app.IAlixPay r3 = r7.f3953b     // Catch:{ all -> 0x00f5 }
        if (r3 != 0) goto L_0x009e
        android.app.Activity r8 = r7.f3952a     // Catch:{ all -> 0x00f5 }
        java.lang.String r8 = com.alipay.sdk.util.C1553o.m4670a(r8, r9)     // Catch:{ all -> 0x00f5 }
        java.lang.String r9 = "biz"
        java.lang.String r3 = "ClientBindFailed"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
        r4.<init>()     // Catch:{ all -> 0x00f5 }
        r4.append(r1)     // Catch:{ all -> 0x00f5 }
        java.lang.String r1 = "|"
        r4.append(r1)     // Catch:{ all -> 0x00f5 }
        r4.append(r8)     // Catch:{ all -> 0x00f5 }
        java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00f5 }
        com.alipay.sdk.app.statistic.C1505a.m4452a(r9, r3, r8)     // Catch:{ all -> 0x00f5 }
        java.lang.String r8 = "failed"
        com.alipay.android.app.IAlixPay r9 = r7.f3953b     // Catch:{ all -> 0x0074 }
        com.alipay.android.app.IRemoteServiceCallback r1 = r7.f3959h     // Catch:{ all -> 0x0074 }
        r9.unregisterCallback(r1)     // Catch:{ all -> 0x0074 }
        goto L_0x0078
    L_0x0074:
        r9 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r9)
    L_0x0078:
        android.app.Activity r9 = r7.f3952a     // Catch:{ all -> 0x0084 }
        android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x0084 }
        android.content.ServiceConnection r1 = r7.f3957f     // Catch:{ all -> 0x0084 }
        r9.unbindService(r1)     // Catch:{ all -> 0x0084 }
        goto L_0x0088
    L_0x0084:
        r9 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r9)
    L_0x0088:
        r7.f3956e = r2
        r7.f3959h = r2
        r7.f3957f = r2
        r7.f3953b = r2
        boolean r9 = r7.f3955d
        if (r9 == 0) goto L_0x009d
        android.app.Activity r9 = r7.f3952a
        if (r9 == 0) goto L_0x009d
        r9.setRequestedOrientation(r0)
        r7.f3955d = r0
    L_0x009d:
        return r8
    L_0x009e:
        com.alipay.sdk.util.f$a r9 = r7.f3956e     // Catch:{ all -> 0x00f5 }
        if (r9 == 0) goto L_0x00a7
        com.alipay.sdk.util.f$a r9 = r7.f3956e     // Catch:{ all -> 0x00f5 }
        r9.mo12127a()     // Catch:{ all -> 0x00f5 }
    L_0x00a7:
        android.app.Activity r9 = r7.f3952a     // Catch:{ all -> 0x00f5 }
        int r9 = r9.getRequestedOrientation()     // Catch:{ all -> 0x00f5 }
        if (r9 != 0) goto L_0x00b6
        android.app.Activity r9 = r7.f3952a     // Catch:{ all -> 0x00f5 }
        r9.setRequestedOrientation(r4)     // Catch:{ all -> 0x00f5 }
        r7.f3955d = r4     // Catch:{ all -> 0x00f5 }
    L_0x00b6:
        com.alipay.android.app.IAlixPay r9 = r7.f3953b     // Catch:{ all -> 0x00f5 }
        com.alipay.android.app.IRemoteServiceCallback r1 = r7.f3959h     // Catch:{ all -> 0x00f5 }
        r9.registerCallback(r1)     // Catch:{ all -> 0x00f5 }
        com.alipay.android.app.IAlixPay r9 = r7.f3953b     // Catch:{ all -> 0x00f5 }
        java.lang.String r8 = r9.Pay(r8)     // Catch:{ all -> 0x00f5 }
        com.alipay.android.app.IAlixPay r9 = r7.f3953b     // Catch:{ all -> 0x00cb }
        com.alipay.android.app.IRemoteServiceCallback r1 = r7.f3959h     // Catch:{ all -> 0x00cb }
        r9.unregisterCallback(r1)     // Catch:{ all -> 0x00cb }
        goto L_0x00cf
    L_0x00cb:
        r9 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r9)
    L_0x00cf:
        android.app.Activity r9 = r7.f3952a     // Catch:{ all -> 0x00db }
        android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x00db }
        android.content.ServiceConnection r1 = r7.f3957f     // Catch:{ all -> 0x00db }
        r9.unbindService(r1)     // Catch:{ all -> 0x00db }
        goto L_0x00df
    L_0x00db:
        r9 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r9)
    L_0x00df:
        r7.f3956e = r2
        r7.f3959h = r2
        r7.f3957f = r2
        r7.f3953b = r2
        boolean r9 = r7.f3955d
        if (r9 == 0) goto L_0x012e
        android.app.Activity r9 = r7.f3952a
        if (r9 == 0) goto L_0x012e
    L_0x00ef:
        r9.setRequestedOrientation(r0)
        r7.f3955d = r0
        goto L_0x012e
    L_0x00f5:
        r8 = move-exception
        java.lang.String r9 = "biz"
        java.lang.String r1 = "ClientBindException"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r9, r1, r8)     // Catch:{ all -> 0x012f }
        java.lang.String r8 = com.alipay.sdk.app.C1503j.m4442c()     // Catch:{ all -> 0x012f }
        com.alipay.android.app.IAlixPay r9 = r7.f3953b     // Catch:{ all -> 0x0109 }
        com.alipay.android.app.IRemoteServiceCallback r1 = r7.f3959h     // Catch:{ all -> 0x0109 }
        r9.unregisterCallback(r1)     // Catch:{ all -> 0x0109 }
        goto L_0x010d
    L_0x0109:
        r9 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r9)
    L_0x010d:
        android.app.Activity r9 = r7.f3952a     // Catch:{ all -> 0x0119 }
        android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x0119 }
        android.content.ServiceConnection r1 = r7.f3957f     // Catch:{ all -> 0x0119 }
        r9.unbindService(r1)     // Catch:{ all -> 0x0119 }
        goto L_0x011d
    L_0x0119:
        r9 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r9)
    L_0x011d:
        r7.f3956e = r2
        r7.f3959h = r2
        r7.f3957f = r2
        r7.f3953b = r2
        boolean r9 = r7.f3955d
        if (r9 == 0) goto L_0x012e
        android.app.Activity r9 = r7.f3952a
        if (r9 == 0) goto L_0x012e
        goto L_0x00ef
    L_0x012e:
        return r8
    L_0x012f:
        r8 = move-exception
        com.alipay.android.app.IAlixPay r9 = r7.f3953b     // Catch:{ all -> 0x0138 }
        com.alipay.android.app.IRemoteServiceCallback r1 = r7.f3959h     // Catch:{ all -> 0x0138 }
        r9.unregisterCallback(r1)     // Catch:{ all -> 0x0138 }
        goto L_0x013c
    L_0x0138:
        r9 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r9)
    L_0x013c:
        android.app.Activity r9 = r7.f3952a     // Catch:{ all -> 0x0148 }
        android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x0148 }
        android.content.ServiceConnection r1 = r7.f3957f     // Catch:{ all -> 0x0148 }
        r9.unbindService(r1)     // Catch:{ all -> 0x0148 }
        goto L_0x014c
    L_0x0148:
        r9 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r9)
    L_0x014c:
        r7.f3956e = r2
        r7.f3959h = r2
        r7.f3957f = r2
        r7.f3953b = r2
        boolean r9 = r7.f3955d
        if (r9 == 0) goto L_0x0161
        android.app.Activity r9 = r7.f3952a
        if (r9 == 0) goto L_0x0161
        r9.setRequestedOrientation(r0)
        r7.f3955d = r0
    L_0x0161:
        throw r8
    L_0x0162:
        r8 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0162 }
        throw r8
    L_0x0165:
        java.lang.Throwable r8 = new java.lang.Throwable     // Catch:{ all -> 0x016d }
        java.lang.String r9 = "bindService fail"
        r8.<init>(r9)     // Catch:{ all -> 0x016d }
        throw r8     // Catch:{ all -> 0x016d }
    L_0x016d:
        r8 = move-exception
        java.lang.String r9 = "biz"
        java.lang.String r0 = "ClientBindServiceFailed"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r9, r0, r8)
        java.lang.String r8 = "failed"
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.C1543f.m4639a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public void mo12217a() {
        this.f3952a = null;
    }
}
