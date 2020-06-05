package com.alipay.p109b.p110a.p111a.p115c;

import com.alipay.p109b.p110a.p111a.p117e.p119b.C1485a;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.alipay.b.a.a.c.b */
public final class C1472b {
    /* renamed from: a */
    private File f3746a = null;
    /* renamed from: b */
    private C1485a f3747b = null;

    public C1472b(String str, C1485a aVar) {
        this.f3746a = new File(str);
        this.f3747b = aVar;
    }

    /* renamed from: a */
    private static String m4289a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
            return;
     */
    /* renamed from: b */
    public synchronized void m4291b() {
        /*
        r7 = this;
        monitor-enter(r7)
        java.io.File r0 = r7.f3746a     // Catch:{ all -> 0x00be }
        if (r0 != 0) goto L_0x0007
        monitor-exit(r7)
        return
    L_0x0007:
        java.io.File r0 = r7.f3746a     // Catch:{ all -> 0x00be }
        boolean r0 = r0.exists()     // Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x00bc
        java.io.File r0 = r7.f3746a     // Catch:{ all -> 0x00be }
        boolean r0 = r0.isDirectory()     // Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x00bc
        java.io.File r0 = r7.f3746a     // Catch:{ all -> 0x00be }
        java.lang.String[] r0 = r0.list()     // Catch:{ all -> 0x00be }
        int r0 = r0.length     // Catch:{ all -> 0x00be }
        if (r0 != 0) goto L_0x0022
        goto L_0x00bc
    L_0x0022:
        java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00be }
        r0.<init>()     // Catch:{ all -> 0x00be }
        java.io.File r1 = r7.f3746a     // Catch:{ all -> 0x00be }
        java.lang.String[] r1 = r1.list()     // Catch:{ all -> 0x00be }
        int r2 = r1.length     // Catch:{ all -> 0x00be }
        r3 = 0
        r4 = 0
    L_0x0030:
        if (r4 >= r2) goto L_0x003a
        r5 = r1[r4]     // Catch:{ all -> 0x00be }
        r0.add(r5)     // Catch:{ all -> 0x00be }
        int r4 = r4 + 1
        goto L_0x0030
    L_0x003a:
        java.util.Collections.sort(r0)     // Catch:{ all -> 0x00be }
        int r1 = r0.size()     // Catch:{ all -> 0x00be }
        int r1 = r1 + -1
        java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x00be }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00be }
        int r2 = r0.size()     // Catch:{ all -> 0x00be }
        java.util.Calendar r4 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x00be }
        java.util.Date r4 = r4.getTime()     // Catch:{ all -> 0x00be }
        java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x00be }
        java.lang.String r6 = "yyyyMMdd"
        r5.<init>(r6)     // Catch:{ all -> 0x00be }
        java.lang.String r4 = r5.format(r4)     // Catch:{ all -> 0x00be }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
        r5.<init>()     // Catch:{ all -> 0x00be }
        r5.append(r4)     // Catch:{ all -> 0x00be }
        java.lang.String r4 = ".log"
        r5.append(r4)     // Catch:{ all -> 0x00be }
        java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x00be }
        boolean r4 = r1.equals(r4)     // Catch:{ all -> 0x00be }
        if (r4 == 0) goto L_0x008d
        int r1 = r0.size()     // Catch:{ all -> 0x00be }
        r4 = 2
        if (r1 >= r4) goto L_0x0080
        monitor-exit(r7)
        return
    L_0x0080:
        int r1 = r0.size()     // Catch:{ all -> 0x00be }
        int r1 = r1 - r4
        java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x00be }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00be }
        int r2 = r2 + -1
    L_0x008d:
        java.io.File r4 = r7.f3746a     // Catch:{ all -> 0x00be }
        java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x00be }
        java.lang.String r1 = com.alipay.p109b.p110a.p111a.p112a.C1464b.m4279a(r4, r1)     // Catch:{ all -> 0x00be }
        java.lang.String r1 = m4289a(r1)     // Catch:{ all -> 0x00be }
        com.alipay.b.a.a.e.b.a r4 = r7.f3747b     // Catch:{ all -> 0x00be }
        boolean r1 = r4.mo12095a(r1)     // Catch:{ all -> 0x00be }
        if (r1 != 0) goto L_0x00a5
        int r2 = r2 + -1
    L_0x00a5:
        if (r3 >= r2) goto L_0x00ba
        java.lang.Object r1 = r0.get(r3)     // Catch:{ all -> 0x00be }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00be }
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00be }
        java.io.File r5 = r7.f3746a     // Catch:{ all -> 0x00be }
        r4.<init>(r5, r1)     // Catch:{ all -> 0x00be }
        r4.delete()     // Catch:{ all -> 0x00be }
        int r3 = r3 + 1
        goto L_0x00a5
    L_0x00ba:
        monitor-exit(r7)
        return
    L_0x00bc:
        monitor-exit(r7)
        return
    L_0x00be:
        r0 = move-exception
        monitor-exit(r7)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p115c.C1472b.m4291b():void");
    }

    /* renamed from: a */
    public final void mo12030a() {
        new Thread(new C1473c(this)).start();
    }
}
