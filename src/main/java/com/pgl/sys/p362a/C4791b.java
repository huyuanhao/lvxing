package com.pgl.sys.p362a;

import android.content.Context;
import com.pgl.sys.p362a.p363a.C4790a;

/* renamed from: com.pgl.sys.a.b */
public class C4791b implements Runnable {
    /* renamed from: a */
    private C4790a f15441a;
    /* renamed from: b */
    private Context f15442b;

    C4791b(Context context, C4790a aVar) {
        this.f15441a = aVar;
        this.f15442b = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f1, code lost:
            com.pgl.sys.p362a.C4789a.f15436a = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f3, code lost:
            r1 = com.pgl.sys.ces.C4804b.m19658a();
            r2 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0105 */
    public void run() {
        /*
        r12 = this;
        java.lang.String r0 = "SS-"
        long r1 = java.lang.System.currentTimeMillis()
        java.lang.String r1 = java.lang.String.valueOf(r1)
        java.lang.String r2 = com.pgl.p359a.p360a.C4777a.m19590b()
        r3 = 500(0x1f4, float:7.0E-43)
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
        r4.<init>()     // Catch:{ all -> 0x0105 }
        r4.append(r2)     // Catch:{ all -> 0x0105 }
        java.lang.String r2 = "/v1/getInfoPgl"
        r4.append(r2)     // Catch:{ all -> 0x0105 }
        java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0105 }
        com.pgl.sys.ces.b r4 = com.pgl.sys.ces.C4804b.m19658a()     // Catch:{ all -> 0x0105 }
        boolean r4 = r4.f15458a     // Catch:{ all -> 0x0105 }
        r5 = 0
        if (r4 == 0) goto L_0x0034
        java.util.Calendar r4 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x0105 }
        long r7 = r4.getTimeInMillis()     // Catch:{ all -> 0x0105 }
        goto L_0x0035
    L_0x0034:
        r7 = r5
    L_0x0035:
        r4 = 301(0x12d, float:4.22E-43)
        android.content.Context r9 = r12.f15442b     // Catch:{ all -> 0x0105 }
        r10 = 0
        java.lang.Object r4 = com.pgl.sys.ces.C4795a.meta(r4, r9, r10)     // Catch:{ all -> 0x0105 }
        byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x0105 }
        byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x0105 }
        com.pgl.sys.ces.b r9 = com.pgl.sys.ces.C4804b.m19658a()     // Catch:{ all -> 0x0105 }
        boolean r9 = r9.f15458a     // Catch:{ all -> 0x0105 }
        if (r9 == 0) goto L_0x0052
        java.util.Calendar r5 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x0105 }
        long r5 = r5.getTimeInMillis()     // Catch:{ all -> 0x0105 }
    L_0x0052:
        com.pgl.sys.ces.b r9 = com.pgl.sys.ces.C4804b.m19658a()     // Catch:{ all -> 0x0105 }
        boolean r9 = r9.f15458a     // Catch:{ all -> 0x0105 }
        if (r9 == 0) goto L_0x0071
        java.lang.String r9 = "CZL_Efficient"
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
        r10.<init>()     // Catch:{ all -> 0x0105 }
        java.lang.String r11 = "[Efficient] selas : "
        r10.append(r11)     // Catch:{ all -> 0x0105 }
        long r5 = r5 - r7
        r10.append(r5)     // Catch:{ all -> 0x0105 }
        java.lang.String r5 = r10.toString()     // Catch:{ all -> 0x0105 }
        android.util.Log.d(r9, r5)     // Catch:{ all -> 0x0105 }
    L_0x0071:
        if (r4 == 0) goto L_0x00fd
        int r5 = r4.length     // Catch:{ all -> 0x0105 }
        if (r5 <= 0) goto L_0x00fd
        java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0105 }
        r5.<init>()     // Catch:{ all -> 0x0105 }
        java.lang.String r6 = "os"
        java.lang.String r7 = "android"
        r5.put(r6, r7)     // Catch:{ all -> 0x0105 }
        java.lang.String r6 = "app_key"
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
        r7.<init>()     // Catch:{ all -> 0x0105 }
        java.lang.String r8 = com.pgl.sys.p362a.C4789a.f15438c     // Catch:{ all -> 0x0105 }
        r7.append(r8)     // Catch:{ all -> 0x0105 }
        java.lang.String r8 = ""
        r7.append(r8)     // Catch:{ all -> 0x0105 }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0105 }
        r5.put(r6, r7)     // Catch:{ all -> 0x0105 }
        java.lang.String r6 = "version"
        java.lang.String r7 = "1.0.3"
        r5.put(r6, r7)     // Catch:{ all -> 0x0105 }
        java.lang.String r6 = "version_code"
        java.lang.String r7 = "4"
        r5.put(r6, r7)     // Catch:{ all -> 0x0105 }
        java.lang.String r6 = "time"
        r5.put(r6, r1)     // Catch:{ all -> 0x0105 }
        r1 = 0
        r6 = 0
    L_0x00af:
        r7 = 3
        if (r1 >= r7) goto L_0x00f1
        java.lang.String r6 = com.pgl.sys.p362a.p364b.C4794c.m19629a(r2, r5, r4)     // Catch:{ all -> 0x0105 }
        org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0105 }
        r7.<init>(r6)     // Catch:{ all -> 0x0105 }
        java.lang.String r6 = "code"
        int r6 = r7.getInt(r6)     // Catch:{ all -> 0x0105 }
        if (r6 != r3) goto L_0x00ce
        int r1 = r1 + 1
        int r7 = r1 * 3
        int r7 = r7 * 1000
        long r7 = (long) r7     // Catch:{ all -> 0x0105 }
        com.pgl.p359a.p361b.C4788f.m19625a(r7)     // Catch:{ all -> 0x0105 }
        goto L_0x00af
    L_0x00ce:
        r1 = 200(0xc8, float:2.8E-43)
        java.lang.String r2 = "token_id"
        r4 = 1
        if (r6 != r1) goto L_0x00de
        com.pgl.sys.p362a.C4789a.f15437b = r4     // Catch:{ all -> 0x0105 }
        java.lang.String r1 = r7.getString(r2)     // Catch:{ all -> 0x0105 }
        com.pgl.sys.p362a.C4789a.f15439d = r1     // Catch:{ all -> 0x0105 }
        goto L_0x00f1
    L_0x00de:
        r1 = 202(0xca, float:2.83E-43)
        if (r6 != r1) goto L_0x00f1
        com.pgl.sys.p362a.C4789a.f15437b = r4     // Catch:{ all -> 0x0105 }
        java.lang.String r1 = r7.getString(r2)     // Catch:{ all -> 0x0105 }
        com.pgl.sys.p362a.C4789a.f15439d = r1     // Catch:{ all -> 0x0105 }
        r2 = 302(0x12e, float:4.23E-43)
        android.content.Context r4 = r12.f15442b     // Catch:{ all -> 0x0105 }
        com.pgl.sys.ces.C4795a.meta(r2, r4, r1)     // Catch:{ all -> 0x0105 }
    L_0x00f1:
        com.pgl.sys.p362a.C4789a.f15436a = r6     // Catch:{ all -> 0x0105 }
        com.pgl.sys.ces.b r1 = com.pgl.sys.ces.C4804b.m19658a()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        goto L_0x0110
    L_0x00fd:
        java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x0105 }
        java.lang.String r2 = "NullPointerException"
        r1.<init>(r2)     // Catch:{ all -> 0x0105 }
        throw r1     // Catch:{ all -> 0x0105 }
    L_0x0105:
        com.pgl.sys.p362a.C4789a.f15436a = r3     // Catch:{ all -> 0x012b }
        com.pgl.sys.ces.b r1 = com.pgl.sys.ces.C4804b.m19658a()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
    L_0x0110:
        r2.append(r0)
        int r0 = com.pgl.sys.p362a.C4789a.f15436a
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        r1.reportNow(r0)
        com.pgl.sys.a.a.a r0 = r12.f15441a
        if (r0 == 0) goto L_0x012a
        java.lang.String r1 = com.pgl.sys.p362a.C4789a.m19626a()
        r0.mo25732a(r1)
    L_0x012a:
        return
    L_0x012b:
        r1 = move-exception
        com.pgl.sys.ces.b r2 = com.pgl.sys.ces.C4804b.m19658a()
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r0)
        int r0 = com.pgl.sys.p362a.C4789a.f15436a
        r3.append(r0)
        java.lang.String r0 = r3.toString()
        r2.reportNow(r0)
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.p362a.C4791b.run():void");
    }
}
