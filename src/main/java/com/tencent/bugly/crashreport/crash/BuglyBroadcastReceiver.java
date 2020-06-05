package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;

/* compiled from: BUGLY */
public class BuglyBroadcastReceiver extends BroadcastReceiver {
    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static BuglyBroadcastReceiver f24086d;
    /* access modifiers changed from: private */
    /* renamed from: a */
    public IntentFilter f24087a = new IntentFilter();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f24088b;
    /* renamed from: c */
    private String f24089c;
    /* renamed from: e */
    private boolean f24090e = true;

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f24086d == null) {
                f24086d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f24086d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f24087a.hasAction(str)) {
            this.f24087a.addAction(str);
        }
        C7226an.m31147c("add action %s", str);
    }

    public synchronized void register(Context context) {
        this.f24088b = context;
        C7232aq.m31195a((Runnable) new Runnable() {
            public void run() {
                try {
                    C7226an.m31140a(BuglyBroadcastReceiver.f24086d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.f24088b.registerReceiver(BuglyBroadcastReceiver.f24086d, BuglyBroadcastReceiver.this.f24087a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            C7226an.m31140a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f24088b = context;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            mo34627a(context, intent);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected|final|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c9, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d7, code lost:
            return false;
     */
    /* renamed from: a */
    public final synchronized boolean mo34627a(android.content.Context r12, android.content.Intent r13) {
        /*
        r11 = this;
        monitor-enter(r11)
        r0 = 0
        if (r12 == 0) goto L_0x00d6
        if (r13 == 0) goto L_0x00d6
        java.lang.String r13 = r13.getAction()     // Catch:{ all -> 0x00d3 }
        java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
        boolean r13 = r13.equals(r1)     // Catch:{ all -> 0x00d3 }
        if (r13 != 0) goto L_0x0014
        goto L_0x00d6
    L_0x0014:
        boolean r13 = r11.f24090e     // Catch:{ all -> 0x00d3 }
        r1 = 1
        if (r13 == 0) goto L_0x001d
        r11.f24090e = r0     // Catch:{ all -> 0x00d3 }
        monitor-exit(r11)
        return r1
    L_0x001d:
        android.content.Context r13 = r11.f24088b     // Catch:{ all -> 0x00d3 }
        java.lang.String r13 = com.tencent.bugly.crashreport.common.info.C7175b.m30828f(r13)     // Catch:{ all -> 0x00d3 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
        r2.<init>()     // Catch:{ all -> 0x00d3 }
        java.lang.String r3 = "is Connect BC "
        r2.append(r3)     // Catch:{ all -> 0x00d3 }
        r2.append(r13)     // Catch:{ all -> 0x00d3 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d3 }
        java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r3)     // Catch:{ all -> 0x00d3 }
        java.lang.String r2 = "network %s changed to %s"
        r3 = 2
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00d3 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
        r4.<init>()     // Catch:{ all -> 0x00d3 }
        java.lang.String r5 = ""
        r4.append(r5)     // Catch:{ all -> 0x00d3 }
        java.lang.String r5 = r11.f24089c     // Catch:{ all -> 0x00d3 }
        r4.append(r5)     // Catch:{ all -> 0x00d3 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d3 }
        r3[r0] = r4     // Catch:{ all -> 0x00d3 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
        r4.<init>()     // Catch:{ all -> 0x00d3 }
        java.lang.String r5 = ""
        r4.append(r5)     // Catch:{ all -> 0x00d3 }
        r4.append(r13)     // Catch:{ all -> 0x00d3 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d3 }
        r3[r1] = r4     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ all -> 0x00d3 }
        if (r13 != 0) goto L_0x0070
        r12 = 0
        r11.f24089c = r12     // Catch:{ all -> 0x00d3 }
        monitor-exit(r11)
        return r1
    L_0x0070:
        java.lang.String r2 = r11.f24089c     // Catch:{ all -> 0x00d3 }
        r11.f24089c = r13     // Catch:{ all -> 0x00d3 }
        long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.crashreport.common.strategy.a r5 = com.tencent.bugly.crashreport.common.strategy.C7177a.m30857a()     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.proguard.ak r6 = com.tencent.bugly.proguard.C7219ak.m31089a()     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.crashreport.common.info.a r12 = com.tencent.bugly.crashreport.common.info.C7174a.m30753a(r12)     // Catch:{ all -> 0x00d3 }
        if (r5 == 0) goto L_0x00ca
        if (r6 == 0) goto L_0x00ca
        if (r12 != 0) goto L_0x008b
        goto L_0x00ca
    L_0x008b:
        boolean r12 = r13.equals(r2)     // Catch:{ all -> 0x00d3 }
        if (r12 != 0) goto L_0x00c8
        int r12 = com.tencent.bugly.crashreport.crash.C7192c.f24187a     // Catch:{ all -> 0x00d3 }
        long r12 = r6.mo34806a(r12)     // Catch:{ all -> 0x00d3 }
        long r12 = r3 - r12
        r7 = 30000(0x7530, double:1.4822E-319)
        int r2 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
        if (r2 <= 0) goto L_0x00b1
        java.lang.String r12 = "try to upload crash on network changed."
        java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.proguard.C7226an.m31141a(r12, r13)     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.crashreport.crash.c r12 = com.tencent.bugly.crashreport.crash.C7192c.m30937a()     // Catch:{ all -> 0x00d3 }
        if (r12 == 0) goto L_0x00b1
        r9 = 0
        r12.mo34687a(r9)     // Catch:{ all -> 0x00d3 }
    L_0x00b1:
        r12 = 1001(0x3e9, float:1.403E-42)
        long r12 = r6.mo34806a(r12)     // Catch:{ all -> 0x00d3 }
        long r3 = r3 - r12
        int r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
        if (r12 <= 0) goto L_0x00c8
        java.lang.String r12 = "try to upload userinfo on network changed."
        java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.proguard.C7226an.m31141a(r12, r13)     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.crashreport.biz.a r12 = com.tencent.bugly.crashreport.biz.C7170b.f23942b     // Catch:{ all -> 0x00d3 }
        r12.mo34534b()     // Catch:{ all -> 0x00d3 }
    L_0x00c8:
        monitor-exit(r11)
        return r1
    L_0x00ca:
        java.lang.String r12 = "not inited BC not work"
        java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d3 }
        com.tencent.bugly.proguard.C7226an.m31148d(r12, r13)     // Catch:{ all -> 0x00d3 }
        monitor-exit(r11)
        return r1
    L_0x00d3:
        r12 = move-exception
        monitor-exit(r11)
        throw r12
    L_0x00d6:
        monitor-exit(r11)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.mo34627a(android.content.Context, android.content.Intent):boolean");
    }
}
