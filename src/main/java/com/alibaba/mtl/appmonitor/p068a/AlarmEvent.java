package com.alibaba.mtl.appmonitor.p068a;

import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.ReuseJSONArray;
import com.alibaba.mtl.appmonitor.p070c.ReuseJSONObject;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.a.a */
public class AlarmEvent extends Event {
    /* renamed from: a */
    public int f3139a = 0;
    /* renamed from: b */
    public int f3140b = 0;
    /* renamed from: c */
    public Map<String, String> f3141c;
    /* renamed from: d */
    public Map<String, Integer> f3142d;

    /* renamed from: a */
    public synchronized void mo11542a() {
        this.f3139a++;
    }

    /* renamed from: b */
    public synchronized void mo11544b() {
        this.f3140b++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo11543a(java.lang.String r4, java.lang.String r5) {
        /*
        r3 = this;
        monitor-enter(r3)
        boolean r0 = com.alibaba.mtl.appmonitor.p073f.StringUtils.m3590b(r4)     // Catch:{ all -> 0x0067 }
        if (r0 == 0) goto L_0x0009
        monitor-exit(r3)
        return
    L_0x0009:
        java.util.Map<java.lang.String, java.lang.String> r0 = r3.f3141c     // Catch:{ all -> 0x0067 }
        if (r0 != 0) goto L_0x0014
        java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0067 }
        r0.<init>()     // Catch:{ all -> 0x0067 }
        r3.f3141c = r0     // Catch:{ all -> 0x0067 }
    L_0x0014:
        java.util.Map<java.lang.String, java.lang.Integer> r0 = r3.f3142d     // Catch:{ all -> 0x0067 }
        if (r0 != 0) goto L_0x001f
        java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0067 }
        r0.<init>()     // Catch:{ all -> 0x0067 }
        r3.f3142d = r0     // Catch:{ all -> 0x0067 }
    L_0x001f:
        boolean r0 = com.alibaba.mtl.appmonitor.p073f.StringUtils.m3589a(r5)     // Catch:{ all -> 0x0067 }
        if (r0 == 0) goto L_0x003c
        r0 = 0
        int r1 = r5.length()     // Catch:{ all -> 0x0067 }
        r2 = 100
        if (r1 <= r2) goto L_0x002f
        goto L_0x0033
    L_0x002f:
        int r2 = r5.length()     // Catch:{ all -> 0x0067 }
    L_0x0033:
        java.lang.String r5 = r5.substring(r0, r2)     // Catch:{ all -> 0x0067 }
        java.util.Map<java.lang.String, java.lang.String> r0 = r3.f3141c     // Catch:{ all -> 0x0067 }
        r0.put(r4, r5)     // Catch:{ all -> 0x0067 }
    L_0x003c:
        java.util.Map<java.lang.String, java.lang.Integer> r5 = r3.f3142d     // Catch:{ all -> 0x0067 }
        boolean r5 = r5.containsKey(r4)     // Catch:{ all -> 0x0067 }
        r0 = 1
        if (r5 != 0) goto L_0x004f
        java.util.Map<java.lang.String, java.lang.Integer> r5 = r3.f3142d     // Catch:{ all -> 0x0067 }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0067 }
        r5.put(r4, r0)     // Catch:{ all -> 0x0067 }
        goto L_0x0065
    L_0x004f:
        java.util.Map<java.lang.String, java.lang.Integer> r5 = r3.f3142d     // Catch:{ all -> 0x0067 }
        java.util.Map<java.lang.String, java.lang.Integer> r1 = r3.f3142d     // Catch:{ all -> 0x0067 }
        java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0067 }
        java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0067 }
        int r1 = r1.intValue()     // Catch:{ all -> 0x0067 }
        int r1 = r1 + r0
        java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0067 }
        r5.put(r4, r0)     // Catch:{ all -> 0x0067 }
    L_0x0065:
        monitor-exit(r3)
        return
    L_0x0067:
        r4 = move-exception
        monitor-exit(r3)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.p068a.AlarmEvent.mo11543a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: c */
    public synchronized JSONObject mo11545c() {
        JSONObject c;
        c = super.mo11545c();
        try {
            c.put("successCount", this.f3139a);
            c.put("failCount", this.f3140b);
            if (this.f3142d != null) {
                JSONArray jSONArray = (JSONArray) BalancedPool.m3491a().mo11627a(ReuseJSONArray.class, new Object[0]);
                for (Entry entry : this.f3142d.entrySet()) {
                    JSONObject jSONObject = (JSONObject) BalancedPool.m3491a().mo11627a(ReuseJSONObject.class, new Object[0]);
                    String str = (String) entry.getKey();
                    jSONObject.put("errorCode", str);
                    jSONObject.put("errorCount", entry.getValue());
                    if (this.f3141c.containsKey(str)) {
                        jSONObject.put("errorMsg", this.f3141c.get(str));
                    }
                    jSONArray.put(jSONObject);
                }
                c.put("errors", jSONArray);
            }
        } catch (Exception unused) {
        }
        return c;
    }

    /* renamed from: d */
    public synchronized void mo11546d() {
        super.mo11546d();
        this.f3139a = 0;
        this.f3140b = 0;
        if (this.f3141c != null) {
            this.f3141c.clear();
        }
        if (this.f3142d != null) {
            this.f3142d.clear();
        }
    }
}
