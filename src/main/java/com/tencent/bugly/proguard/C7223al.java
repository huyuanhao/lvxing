package com.tencent.bugly.proguard;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.al */
public class C7223al implements Runnable {
    /* renamed from: a */
    public int f24371a;
    /* renamed from: b */
    public int f24372b;
    /* renamed from: c */
    protected int f24373c;
    /* renamed from: d */
    protected long f24374d;
    /* renamed from: e */
    protected long f24375e;
    /* renamed from: f */
    protected boolean f24376f;
    /* renamed from: g */
    private final Context f24377g;
    /* renamed from: h */
    private final int f24378h;
    /* renamed from: i */
    private final byte[] f24379i;
    /* renamed from: j */
    private final C7174a f24380j;
    /* renamed from: k */
    private final C7177a f24381k;
    /* renamed from: l */
    private final C7217ai f24382l;
    /* renamed from: m */
    private final C7219ak f24383m;
    /* renamed from: n */
    private final int f24384n;
    /* renamed from: o */
    private final C7218aj f24385o;
    /* renamed from: p */
    private final C7218aj f24386p;
    /* renamed from: q */
    private String f24387q;
    /* renamed from: r */
    private final String f24388r;
    /* renamed from: s */
    private final Map<String, String> f24389s;
    /* renamed from: t */
    private boolean f24390t;

    public C7223al(Context context, int i, int i2, byte[] bArr, String str, String str2, C7218aj ajVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, ajVar, z, 2, C7120a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    public C7223al(Context context, int i, int i2, byte[] bArr, String str, String str2, C7218aj ajVar, boolean z, int i3, int i4, boolean z2, Map<String, String> map) {
        this.f24371a = 2;
        this.f24372b = C7120a.MAX_USERDATA_VALUE_LENGTH;
        this.f24387q = null;
        this.f24373c = 0;
        this.f24374d = 0;
        this.f24375e = 0;
        this.f24376f = true;
        this.f24390t = false;
        this.f24377g = context;
        this.f24380j = C7174a.m30753a(context);
        this.f24379i = bArr;
        this.f24381k = C7177a.m30857a();
        this.f24382l = C7217ai.m31080a(context);
        this.f24383m = C7219ak.m31089a();
        this.f24384n = i;
        this.f24387q = str;
        this.f24388r = str2;
        this.f24385o = ajVar;
        this.f24386p = this.f24383m.f24341a;
        this.f24376f = z;
        this.f24378h = i2;
        if (i3 > 0) {
            this.f24371a = i3;
        }
        if (i4 > 0) {
            this.f24372b = i4;
        }
        this.f24390t = z2;
        this.f24389s = map;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34825a() {
        this.f24383m.mo34811a(this.f24384n, System.currentTimeMillis());
        C7218aj ajVar = this.f24385o;
        if (ajVar != null) {
            ajVar.mo34468a(this.f24378h);
        }
        C7218aj ajVar2 = this.f24386p;
        if (ajVar2 != null) {
            ajVar2.mo34468a(this.f24378h);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34826a(int i, String str) {
        C7226an.m31149e("[Upload] Failed to upload(%d): %s", Integer.valueOf(i), str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo34828a(com.tencent.bugly.proguard.C7251bi r14, boolean r15, int r16, java.lang.String r17, int r18) {
        /*
        r13 = this;
        r0 = r13
        int r1 = r0.f24378h
        r2 = 630(0x276, float:8.83E-43)
        if (r1 == r2) goto L_0x001b
        r2 = 640(0x280, float:8.97E-43)
        if (r1 == r2) goto L_0x0018
        r2 = 830(0x33e, float:1.163E-42)
        if (r1 == r2) goto L_0x001b
        r2 = 840(0x348, float:1.177E-42)
        if (r1 == r2) goto L_0x0018
        java.lang.String r1 = java.lang.String.valueOf(r1)
        goto L_0x001d
    L_0x0018:
        java.lang.String r1 = "userinfo"
        goto L_0x001d
    L_0x001b:
        java.lang.String r1 = "crash"
    L_0x001d:
        r2 = 1
        r3 = 0
        if (r15 == 0) goto L_0x002b
        java.lang.Object[] r2 = new java.lang.Object[r2]
        r2[r3] = r1
        java.lang.String r1 = "[Upload] Success: %s"
        com.tencent.bugly.proguard.C7226an.m31141a(r1, r2)
        goto L_0x004a
    L_0x002b:
        r4 = 3
        java.lang.Object[] r4 = new java.lang.Object[r4]
        java.lang.Integer r5 = java.lang.Integer.valueOf(r16)
        r4[r3] = r5
        r4[r2] = r1
        r1 = 2
        r4[r1] = r17
        java.lang.String r1 = "[Upload] Failed to upload(%d) %s: %s"
        com.tencent.bugly.proguard.C7226an.m31149e(r1, r4)
        boolean r1 = r0.f24376f
        if (r1 == 0) goto L_0x004a
        com.tencent.bugly.proguard.ak r1 = r0.f24383m
        r2 = 0
        r3 = r18
        r1.mo34814a(r3, r2)
    L_0x004a:
        long r1 = r0.f24374d
        long r3 = r0.f24375e
        long r1 = r1 + r3
        r3 = 0
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 <= 0) goto L_0x006a
        com.tencent.bugly.proguard.ak r1 = r0.f24383m
        boolean r2 = r0.f24390t
        long r1 = r1.mo34807a(r2)
        long r3 = r0.f24374d
        long r1 = r1 + r3
        long r3 = r0.f24375e
        long r1 = r1 + r3
        com.tencent.bugly.proguard.ak r3 = r0.f24383m
        boolean r4 = r0.f24390t
        r3.mo34815a(r1, r4)
    L_0x006a:
        com.tencent.bugly.proguard.aj r4 = r0.f24385o
        if (r4 == 0) goto L_0x007b
        int r5 = r0.f24378h
        long r7 = r0.f24374d
        long r9 = r0.f24375e
        r6 = r14
        r11 = r15
        r12 = r17
        r4.mo34469a(r5, r6, r7, r9, r11, r12)
    L_0x007b:
        com.tencent.bugly.proguard.aj r4 = r0.f24386p
        if (r4 == 0) goto L_0x008c
        int r5 = r0.f24378h
        long r7 = r0.f24374d
        long r9 = r0.f24375e
        r6 = r14
        r11 = r15
        r12 = r17
        r4.mo34469a(r5, r6, r7, r9, r11, r12)
    L_0x008c:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7223al.mo34828a(com.tencent.bugly.proguard.bi, boolean, int, java.lang.String, int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo34830a(C7251bi biVar, C7174a aVar, C7177a aVar2) {
        if (biVar == null) {
            C7226an.m31148d("resp == null!", new Object[0]);
            return false;
        } else if (biVar.f24512a != 0) {
            C7226an.m31149e("resp result error %d", Byte.valueOf(biVar.f24512a));
            return false;
        } else {
            try {
                String str = "UTF-8";
                if (!C7232aq.m31196a(biVar.f24515d)) {
                    if (!C7174a.m30754b().mo34596i().equals(biVar.f24515d)) {
                        C7212ae.m31041a().mo34782a(C7177a.f24076a, "gateway", biVar.f24515d.getBytes(str), (C7211ad) null, true);
                        aVar.mo34588d(biVar.f24515d);
                    }
                }
                if (!C7232aq.m31196a(biVar.f24518g) && !C7174a.m30754b().mo34597j().equals(biVar.f24518g)) {
                    C7212ae.m31041a().mo34782a(C7177a.f24076a, "device", biVar.f24518g.getBytes(str), (C7211ad) null, true);
                    aVar.mo34590e(biVar.f24518g);
                }
            } catch (Throwable th) {
                C7226an.m31142a(th);
            }
            aVar.f24034o = biVar.f24516e;
            if (biVar.f24513b == 510) {
                if (biVar.f24514c == null) {
                    C7226an.m31149e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(biVar.f24513b));
                    return false;
                }
                C7253bk bkVar = (C7253bk) C7216ah.m31077a(biVar.f24514c, C7253bk.class);
                if (bkVar == null) {
                    C7226an.m31149e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(biVar.f24513b));
                    return false;
                }
                aVar2.mo34622a(bkVar);
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0307, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0308, code lost:
            r2 = com.tencent.bugly.proguard.C7232aq.m31215b(r0, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x030c, code lost:
            if (r2 != null) goto L_0x031a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x030e, code lost:
            mo34828a(null, false, 1, "failed unzip(Gzip) response from server", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0319, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x031a, code lost:
            r2 = com.tencent.bugly.proguard.C7216ah.m31074a(r2, r5, r7.f24376f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0320, code lost:
            if (r2 != null) goto L_0x032e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0322, code lost:
            mo34828a(null, false, 1, "failed to decode response package", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x032d, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0330, code lost:
            if (r7.f24376f == false) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0332, code lost:
            r7.f24383m.mo34814a(r9, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0337, code lost:
            r0 = "[Upload] Response cmd is: %d, length of sBuffer is: %d";
            r3 = new java.lang.Object[2];
            r3[0] = java.lang.Integer.valueOf(r2.f24513b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0345, code lost:
            if (r2.f24514c != null) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0348, code lost:
            r1 = r2.f24514c.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x034b, code lost:
            r3[1] = java.lang.Integer.valueOf(r1);
            com.tencent.bugly.proguard.C7226an.m31147c(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x035c, code lost:
            if (mo34830a(r2, r7.f24380j, r7.f24381k) != false) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x035e, code lost:
            mo34828a(r2, false, 2, "failed to process response package", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0368, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0369, code lost:
            mo34828a(r2, true, 2, "successfully uploaded", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0373, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x020a, code lost:
            if (r9 == 0) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x020c, code lost:
            if (r9 != 2) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0217, code lost:
            if ((r7.f24374d + r7.f24375e) <= 0) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0219, code lost:
            r7.f24383m.mo34815a((r7.f24383m.mo34807a(r7.f24390t) + r7.f24374d) + r7.f24375e, r7.f24390t);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x022e, code lost:
            r7.f24383m.mo34814a(r9, (com.tencent.bugly.proguard.C7251bi) null);
            com.tencent.bugly.proguard.C7226an.m31141a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            r7.f24383m.mo34808a(r7.f24384n, r7.f24378h, r7.f24379i, r7.f24387q, r7.f24388r, r7.f24385o, r7.f24371a, r7.f24372b, true, r7.f24389s);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x026d, code lost:
            r0 = new java.lang.StringBuilder();
            r0.append("status of server is ");
            r0.append(r9);
            mo34828a(null, false, 1, r0.toString(), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0287, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02ab, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("[Upload] Received %d bytes", java.lang.Integer.valueOf(r2.length));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02bb, code lost:
            if (r7.f24376f == false) goto L_0x031a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02be, code lost:
            if (r2.length != 0) goto L_0x02f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02c0, code lost:
            r0 = r3.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02cc, code lost:
            if (r0.hasNext() == false) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02ce, code lost:
            r2 = (java.util.Map.Entry) r0.next();
            com.tencent.bugly.proguard.C7226an.m31147c("[Upload] HTTP headers from server: key = %s, value = %s", r2.getKey(), r2.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02e8, code lost:
            mo34828a(null, false, 1, "response data from server is empty", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02f3, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02f4, code lost:
            r0 = r7.f24383m.mo34821b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02fa, code lost:
            if (r0 != null) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02fc, code lost:
            mo34828a(null, false, 1, "failed to decrypt response from server", 0);
     */
    public void run() {
        /*
        r19 = this;
        r7 = r19
        java.lang.String r0 = "[Upload] Failed to upload for no status header."
        r1 = 0
        r7.f24373c = r1     // Catch:{ all -> 0x0398 }
        r2 = 0
        r7.f24374d = r2     // Catch:{ all -> 0x0398 }
        r7.f24375e = r2     // Catch:{ all -> 0x0398 }
        byte[] r4 = r7.f24379i     // Catch:{ all -> 0x0398 }
        android.content.Context r5 = r7.f24377g     // Catch:{ all -> 0x0398 }
        java.lang.String r5 = com.tencent.bugly.crashreport.common.info.C7175b.m30828f(r5)     // Catch:{ all -> 0x0398 }
        if (r5 != 0) goto L_0x0023
        r2 = 0
        r3 = 0
        r4 = 0
        java.lang.String r5 = "network is not available"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x0023:
        if (r4 == 0) goto L_0x038c
        int r5 = r4.length     // Catch:{ all -> 0x0398 }
        if (r5 != 0) goto L_0x002a
        goto L_0x038c
    L_0x002a:
        java.lang.String r5 = "[Upload] Run upload task with cmd: %d"
        r6 = 1
        java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x0398 }
        int r9 = r7.f24378h     // Catch:{ all -> 0x0398 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0398 }
        r8[r1] = r9     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r5, r8)     // Catch:{ all -> 0x0398 }
        android.content.Context r5 = r7.f24377g     // Catch:{ all -> 0x0398 }
        if (r5 == 0) goto L_0x0380
        com.tencent.bugly.crashreport.common.info.a r5 = r7.f24380j     // Catch:{ all -> 0x0398 }
        if (r5 == 0) goto L_0x0380
        com.tencent.bugly.crashreport.common.strategy.a r5 = r7.f24381k     // Catch:{ all -> 0x0398 }
        if (r5 == 0) goto L_0x0380
        com.tencent.bugly.proguard.ai r5 = r7.f24382l     // Catch:{ all -> 0x0398 }
        if (r5 != 0) goto L_0x004c
        goto L_0x0380
    L_0x004c:
        com.tencent.bugly.crashreport.common.strategy.a r5 = r7.f24381k     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.crashreport.common.strategy.StrategyBean r5 = r5.mo34624c()     // Catch:{ all -> 0x0398 }
        if (r5 != 0) goto L_0x0060
        r2 = 0
        r3 = 0
        r4 = 0
        java.lang.String r5 = "illegal local strategy"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x0060:
        java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x0398 }
        r8.<init>()     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = "prodId"
        com.tencent.bugly.crashreport.common.info.a r10 = r7.f24380j     // Catch:{ all -> 0x0398 }
        java.lang.String r10 = r10.mo34591f()     // Catch:{ all -> 0x0398 }
        r8.put(r9, r10)     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = "bundleId"
        com.tencent.bugly.crashreport.common.info.a r10 = r7.f24380j     // Catch:{ all -> 0x0398 }
        java.lang.String r10 = r10.f24023d     // Catch:{ all -> 0x0398 }
        r8.put(r9, r10)     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = "appVer"
        com.tencent.bugly.crashreport.common.info.a r10 = r7.f24380j     // Catch:{ all -> 0x0398 }
        java.lang.String r10 = r10.f24035p     // Catch:{ all -> 0x0398 }
        r8.put(r9, r10)     // Catch:{ all -> 0x0398 }
        java.util.Map<java.lang.String, java.lang.String> r9 = r7.f24389s     // Catch:{ all -> 0x0398 }
        if (r9 == 0) goto L_0x008b
        java.util.Map<java.lang.String, java.lang.String> r9 = r7.f24389s     // Catch:{ all -> 0x0398 }
        r8.putAll(r9)     // Catch:{ all -> 0x0398 }
    L_0x008b:
        boolean r9 = r7.f24376f     // Catch:{ all -> 0x0398 }
        r10 = 2
        if (r9 == 0) goto L_0x00f5
        java.lang.String r9 = "cmd"
        int r11 = r7.f24378h     // Catch:{ all -> 0x0398 }
        java.lang.String r11 = java.lang.Integer.toString(r11)     // Catch:{ all -> 0x0398 }
        r8.put(r9, r11)     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = "platformId"
        java.lang.String r11 = java.lang.Byte.toString(r6)     // Catch:{ all -> 0x0398 }
        r8.put(r9, r11)     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = "sdkVer"
        com.tencent.bugly.crashreport.common.info.a r11 = r7.f24380j     // Catch:{ all -> 0x0398 }
        r11.getClass()     // Catch:{ all -> 0x0398 }
        java.lang.String r11 = "3.1.0"
        r8.put(r9, r11)     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = "strategylastUpdateTime"
        long r11 = r5.f24066p     // Catch:{ all -> 0x0398 }
        java.lang.String r11 = java.lang.Long.toString(r11)     // Catch:{ all -> 0x0398 }
        r8.put(r9, r11)     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.ak r9 = r7.f24383m     // Catch:{ all -> 0x0398 }
        boolean r9 = r9.mo34816a(r8)     // Catch:{ all -> 0x0398 }
        if (r9 != 0) goto L_0x00cf
        r2 = 0
        r3 = 0
        r4 = 0
        java.lang.String r5 = "failed to add security info to HTTP headers"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x00cf:
        byte[] r4 = com.tencent.bugly.proguard.C7232aq.m31201a(r4, r10)     // Catch:{ all -> 0x0398 }
        if (r4 != 0) goto L_0x00e1
        r2 = 0
        r3 = 0
        r4 = 0
        java.lang.String r5 = "failed to zip request body"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x00e1:
        com.tencent.bugly.proguard.ak r9 = r7.f24383m     // Catch:{ all -> 0x0398 }
        byte[] r4 = r9.mo34817a(r4)     // Catch:{ all -> 0x0398 }
        if (r4 != 0) goto L_0x00f5
        r2 = 0
        r3 = 0
        r4 = 0
        java.lang.String r5 = "failed to encrypt request body"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x00f5:
        r19.mo34825a()     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = r7.f24387q     // Catch:{ all -> 0x0398 }
        r11 = -1
        r12 = r9
        r9 = 0
        r11 = 0
        r13 = -1
    L_0x00ff:
        int r14 = r9 + 1
        int r15 = r7.f24371a     // Catch:{ all -> 0x0398 }
        if (r9 >= r15) goto L_0x0374
        if (r14 <= r6) goto L_0x012b
        java.lang.String r9 = "[Upload] Failed to upload last time, wait and try(%d) again."
        java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ all -> 0x0398 }
        java.lang.Integer r15 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x0398 }
        r11[r1] = r15     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31148d(r9, r11)     // Catch:{ all -> 0x0398 }
        int r9 = r7.f24372b     // Catch:{ all -> 0x0398 }
        long r2 = (long) r9     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7232aq.m31209b(r2)     // Catch:{ all -> 0x0398 }
        int r2 = r7.f24371a     // Catch:{ all -> 0x0398 }
        if (r14 != r2) goto L_0x012b
        java.lang.String r2 = "[Upload] Use the back-up url at the last time: %s"
        java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = r7.f24388r     // Catch:{ all -> 0x0398 }
        r3[r1] = r9     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31148d(r2, r3)     // Catch:{ all -> 0x0398 }
        java.lang.String r12 = r7.f24388r     // Catch:{ all -> 0x0398 }
    L_0x012b:
        java.lang.String r2 = "[Upload] Send %d bytes"
        java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0398 }
        int r9 = r4.length     // Catch:{ all -> 0x0398 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0398 }
        r3[r1] = r9     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r3)     // Catch:{ all -> 0x0398 }
        boolean r2 = r7.f24376f     // Catch:{ all -> 0x0398 }
        if (r2 == 0) goto L_0x0142
        java.lang.String r2 = m31124a(r12)     // Catch:{ all -> 0x0398 }
        r12 = r2
    L_0x0142:
        java.lang.String r2 = "[Upload] Upload to %s with cmd %d (pid=%d | tid=%d)."
        r3 = 4
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0398 }
        r3[r1] = r12     // Catch:{ all -> 0x0398 }
        int r9 = r7.f24378h     // Catch:{ all -> 0x0398 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0398 }
        r3[r6] = r9     // Catch:{ all -> 0x0398 }
        int r9 = android.os.Process.myPid()     // Catch:{ all -> 0x0398 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0398 }
        r3[r10] = r9     // Catch:{ all -> 0x0398 }
        int r9 = android.os.Process.myTid()     // Catch:{ all -> 0x0398 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0398 }
        r11 = 3
        r3[r11] = r9     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r3)     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.ai r2 = r7.f24382l     // Catch:{ all -> 0x0398 }
        byte[] r2 = r2.mo34804a(r12, r4, r7, r8)     // Catch:{ all -> 0x0398 }
        if (r2 != 0) goto L_0x017b
        java.lang.String r2 = "Failed to upload for no response!"
        r7.mo34826a(r6, r2)     // Catch:{ all -> 0x0398 }
    L_0x0176:
        r9 = r14
        r2 = 0
    L_0x0179:
        r11 = 1
        goto L_0x00ff
    L_0x017b:
        com.tencent.bugly.proguard.ai r3 = r7.f24382l     // Catch:{ all -> 0x0398 }
        java.util.Map<java.lang.String, java.lang.String> r3 = r3.f24339b     // Catch:{ all -> 0x0398 }
        boolean r9 = r7.f24376f     // Catch:{ all -> 0x0398 }
        if (r9 == 0) goto L_0x02aa
        boolean r9 = m31125a(r3)     // Catch:{ all -> 0x0398 }
        if (r9 != 0) goto L_0x01dd
        java.lang.String r2 = "[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d)."
        java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x0398 }
        int r11 = android.os.Process.myPid()     // Catch:{ all -> 0x0398 }
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0398 }
        r9[r1] = r11     // Catch:{ all -> 0x0398 }
        int r11 = android.os.Process.myTid()     // Catch:{ all -> 0x0398 }
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0398 }
        r9[r6] = r11     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r9)     // Catch:{ all -> 0x0398 }
        r7.mo34826a(r6, r0)     // Catch:{ all -> 0x0398 }
        if (r3 == 0) goto L_0x01d7
        java.util.Set r2 = r3.entrySet()     // Catch:{ all -> 0x0398 }
        java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0398 }
    L_0x01b1:
        boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0398 }
        if (r3 == 0) goto L_0x01d7
        java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0398 }
        java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0398 }
        java.lang.String r9 = "[key]: %s, [value]: %s"
        java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x0398 }
        java.lang.Object r17 = r3.getKey()     // Catch:{ all -> 0x0398 }
        r11[r1] = r17     // Catch:{ all -> 0x0398 }
        java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0398 }
        r11[r6] = r3     // Catch:{ all -> 0x0398 }
        java.lang.String r3 = java.lang.String.format(r9, r11)     // Catch:{ all -> 0x0398 }
        java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r3, r9)     // Catch:{ all -> 0x0398 }
        goto L_0x01b1
    L_0x01d7:
        java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r2)     // Catch:{ all -> 0x0398 }
        goto L_0x0176
    L_0x01dd:
        java.lang.String r9 = "status"
        java.lang.Object r9 = r3.get(r9)     // Catch:{ all -> 0x028c }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x028c }
        int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028c }
        java.lang.String r13 = "[Upload] Status from server is %d (pid=%d | tid=%d)."
        java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x0288 }
        java.lang.Integer r17 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0288 }
        r11[r1] = r17     // Catch:{ all -> 0x0288 }
        int r17 = android.os.Process.myPid()     // Catch:{ all -> 0x0288 }
        java.lang.Integer r17 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x0288 }
        r11[r6] = r17     // Catch:{ all -> 0x0288 }
        int r17 = android.os.Process.myTid()     // Catch:{ all -> 0x0288 }
        java.lang.Integer r17 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x0288 }
        r11[r10] = r17     // Catch:{ all -> 0x0288 }
        com.tencent.bugly.proguard.C7226an.m31147c(r13, r11)     // Catch:{ all -> 0x0288 }
        if (r9 == 0) goto L_0x02ab
        if (r9 != r10) goto L_0x026d
        long r2 = r7.f24374d     // Catch:{ all -> 0x0398 }
        long r4 = r7.f24375e     // Catch:{ all -> 0x0398 }
        long r2 = r2 + r4
        r15 = 0
        int r0 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
        if (r0 <= 0) goto L_0x022e
        com.tencent.bugly.proguard.ak r0 = r7.f24383m     // Catch:{ all -> 0x0398 }
        boolean r2 = r7.f24390t     // Catch:{ all -> 0x0398 }
        long r2 = r0.mo34807a(r2)     // Catch:{ all -> 0x0398 }
        long r4 = r7.f24374d     // Catch:{ all -> 0x0398 }
        long r2 = r2 + r4
        long r4 = r7.f24375e     // Catch:{ all -> 0x0398 }
        long r2 = r2 + r4
        com.tencent.bugly.proguard.ak r0 = r7.f24383m     // Catch:{ all -> 0x0398 }
        boolean r4 = r7.f24390t     // Catch:{ all -> 0x0398 }
        r0.mo34815a(r2, r4)     // Catch:{ all -> 0x0398 }
    L_0x022e:
        com.tencent.bugly.proguard.ak r0 = r7.f24383m     // Catch:{ all -> 0x0398 }
        r2 = 0
        r0.mo34814a(r9, r2)     // Catch:{ all -> 0x0398 }
        java.lang.String r0 = "[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d)."
        java.lang.Object[] r2 = new java.lang.Object[r10]     // Catch:{ all -> 0x0398 }
        int r3 = android.os.Process.myPid()     // Catch:{ all -> 0x0398 }
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0398 }
        r2[r1] = r3     // Catch:{ all -> 0x0398 }
        int r1 = android.os.Process.myTid()     // Catch:{ all -> 0x0398 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0398 }
        r2[r6] = r1     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31141a(r0, r2)     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.ak r8 = r7.f24383m     // Catch:{ all -> 0x0398 }
        int r9 = r7.f24384n     // Catch:{ all -> 0x0398 }
        int r10 = r7.f24378h     // Catch:{ all -> 0x0398 }
        byte[] r11 = r7.f24379i     // Catch:{ all -> 0x0398 }
        java.lang.String r12 = r7.f24387q     // Catch:{ all -> 0x0398 }
        java.lang.String r13 = r7.f24388r     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.aj r14 = r7.f24385o     // Catch:{ all -> 0x0398 }
        int r15 = r7.f24371a     // Catch:{ all -> 0x0398 }
        int r0 = r7.f24372b     // Catch:{ all -> 0x0398 }
        r17 = 1
        java.util.Map<java.lang.String, java.lang.String> r1 = r7.f24389s     // Catch:{ all -> 0x0398 }
        r16 = r0
        r18 = r1
        r8.mo34808a(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0398 }
        goto L_0x0287
    L_0x026d:
        r2 = 0
        r3 = 0
        r4 = 1
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0398 }
        r0.<init>()     // Catch:{ all -> 0x0398 }
        java.lang.String r1 = "status of server is "
        r0.append(r1)     // Catch:{ all -> 0x0398 }
        r0.append(r9)     // Catch:{ all -> 0x0398 }
        java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0398 }
        r1 = r19
        r6 = r9
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
    L_0x0287:
        return
    L_0x0288:
        r15 = 0
        r13 = r9
        goto L_0x028e
    L_0x028c:
        r15 = 0
    L_0x028e:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0398 }
        r2.<init>()     // Catch:{ all -> 0x0398 }
        java.lang.String r3 = "[Upload] Failed to upload for format of status header is invalid: "
        r2.append(r3)     // Catch:{ all -> 0x0398 }
        java.lang.String r3 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x0398 }
        r2.append(r3)     // Catch:{ all -> 0x0398 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0398 }
        r7.mo34826a(r6, r2)     // Catch:{ all -> 0x0398 }
        r9 = r14
        r2 = r15
        goto L_0x0179
    L_0x02aa:
        r9 = r13
    L_0x02ab:
        java.lang.String r0 = "[Upload] Received %d bytes"
        java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ all -> 0x0398 }
        int r8 = r2.length     // Catch:{ all -> 0x0398 }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0398 }
        r4[r1] = r8     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r4)     // Catch:{ all -> 0x0398 }
        boolean r0 = r7.f24376f     // Catch:{ all -> 0x0398 }
        if (r0 == 0) goto L_0x031a
        int r0 = r2.length     // Catch:{ all -> 0x0398 }
        if (r0 != 0) goto L_0x02f4
        java.util.Set r0 = r3.entrySet()     // Catch:{ all -> 0x0398 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0398 }
    L_0x02c8:
        boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0398 }
        if (r2 == 0) goto L_0x02e8
        java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0398 }
        java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0398 }
        java.lang.String r3 = "[Upload] HTTP headers from server: key = %s, value = %s"
        java.lang.Object[] r4 = new java.lang.Object[r10]     // Catch:{ all -> 0x0398 }
        java.lang.Object r5 = r2.getKey()     // Catch:{ all -> 0x0398 }
        r4[r1] = r5     // Catch:{ all -> 0x0398 }
        java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0398 }
        r4[r6] = r2     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r3, r4)     // Catch:{ all -> 0x0398 }
        goto L_0x02c8
    L_0x02e8:
        r2 = 0
        r3 = 0
        r4 = 1
        java.lang.String r5 = "response data from server is empty"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x02f4:
        com.tencent.bugly.proguard.ak r0 = r7.f24383m     // Catch:{ all -> 0x0398 }
        byte[] r0 = r0.mo34821b(r2)     // Catch:{ all -> 0x0398 }
        if (r0 != 0) goto L_0x0308
        r2 = 0
        r3 = 0
        r4 = 1
        java.lang.String r5 = "failed to decrypt response from server"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x0308:
        byte[] r2 = com.tencent.bugly.proguard.C7232aq.m31215b(r0, r10)     // Catch:{ all -> 0x0398 }
        if (r2 != 0) goto L_0x031a
        r2 = 0
        r3 = 0
        r4 = 1
        java.lang.String r5 = "failed unzip(Gzip) response from server"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x031a:
        boolean r0 = r7.f24376f     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.bi r2 = com.tencent.bugly.proguard.C7216ah.m31074a(r2, r5, r0)     // Catch:{ all -> 0x0398 }
        if (r2 != 0) goto L_0x032e
        r2 = 0
        r3 = 0
        r4 = 1
        java.lang.String r5 = "failed to decode response package"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x032e:
        boolean r0 = r7.f24376f     // Catch:{ all -> 0x0398 }
        if (r0 == 0) goto L_0x0337
        com.tencent.bugly.proguard.ak r0 = r7.f24383m     // Catch:{ all -> 0x0398 }
        r0.mo34814a(r9, r2)     // Catch:{ all -> 0x0398 }
    L_0x0337:
        java.lang.String r0 = "[Upload] Response cmd is: %d, length of sBuffer is: %d"
        java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ all -> 0x0398 }
        int r4 = r2.f24513b     // Catch:{ all -> 0x0398 }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0398 }
        r3[r1] = r4     // Catch:{ all -> 0x0398 }
        byte[] r4 = r2.f24514c     // Catch:{ all -> 0x0398 }
        if (r4 != 0) goto L_0x0348
        goto L_0x034b
    L_0x0348:
        byte[] r1 = r2.f24514c     // Catch:{ all -> 0x0398 }
        int r1 = r1.length     // Catch:{ all -> 0x0398 }
    L_0x034b:
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0398 }
        r3[r6] = r1     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r3)     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.crashreport.common.info.a r0 = r7.f24380j     // Catch:{ all -> 0x0398 }
        com.tencent.bugly.crashreport.common.strategy.a r1 = r7.f24381k     // Catch:{ all -> 0x0398 }
        boolean r0 = r7.mo34830a(r2, r0, r1)     // Catch:{ all -> 0x0398 }
        if (r0 != 0) goto L_0x0369
        r3 = 0
        r4 = 2
        java.lang.String r5 = "failed to process response package"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x0369:
        r3 = 1
        r4 = 2
        java.lang.String r5 = "successfully uploaded"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x0374:
        r2 = 0
        r3 = 0
        java.lang.String r5 = "failed after many attempts"
        r6 = 0
        r1 = r19
        r4 = r11
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        goto L_0x03a2
    L_0x0380:
        r2 = 0
        r3 = 0
        r4 = 0
        java.lang.String r5 = "illegal access error"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x038c:
        r2 = 0
        r3 = 0
        r4 = 0
        java.lang.String r5 = "request package is empty!"
        r6 = 0
        r1 = r19
        r1.mo34828a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0398 }
        return
    L_0x0398:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x03a2
        r0.printStackTrace()
    L_0x03a2:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7223al.run():void");
    }

    /* renamed from: a */
    public void mo34829a(String str, long j, String str2) {
        this.f24373c++;
        this.f24374d += j;
    }

    /* renamed from: a */
    public void mo34827a(long j) {
        this.f24375e += j;
    }

    /* renamed from: a */
    private static String m31124a(String str) {
        if (C7232aq.m31196a(str)) {
            return str;
        }
        try {
            str = String.format("%s?aid=%s", new Object[]{str, UUID.randomUUID().toString()});
            return str;
        } catch (Throwable th) {
            C7226an.m31142a(th);
            return str;
        }
    }

    /* renamed from: a */
    private static boolean m31125a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            C7226an.m31148d("[Upload] Headers is empty.", new Object[0]);
            return false;
        }
        String str = NotificationCompat.CATEGORY_STATUS;
        String str2 = "[Upload] Headers does not contain %s";
        if (!map.containsKey(str)) {
            C7226an.m31148d(str2, str);
            return false;
        }
        String str3 = "Bugly-Version";
        if (!map.containsKey(str3)) {
            C7226an.m31148d(str2, str3);
            return false;
        }
        String str4 = (String) map.get(str3);
        if (!str4.contains("bugly")) {
            C7226an.m31148d("[Upload] Bugly version is not valid: %s", str4);
            return false;
        }
        C7226an.m31147c("[Upload] Bugly version from headers is: %s", str4);
        return true;
    }
}
