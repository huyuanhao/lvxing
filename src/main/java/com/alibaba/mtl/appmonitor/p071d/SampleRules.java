package com.alibaba.mtl.appmonitor.p071d;

import android.content.Context;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.alibaba.mtl.appmonitor.d.j */
public class SampleRules {
    /* renamed from: a */
    private static final String f3223a = null;
    /* renamed from: c */
    private static SampleRules f3224c;
    /* renamed from: b */
    private Map<EventType, EventTypeSampling> f3225b = new HashMap();
    /* renamed from: d */
    private int f3226d;
    /* renamed from: e */
    private String f3227e;

    private SampleRules() {
        EventType[] values;
        for (EventType fVar : EventType.values()) {
            if (fVar == EventType.ALARM) {
                this.f3225b.put(fVar, new AlarmSampling(fVar, fVar.mo11575e()));
            } else {
                this.f3225b.put(fVar, new EventTypeSampling(fVar, fVar.mo11575e()));
            }
        }
    }

    /* renamed from: a */
    public static SampleRules m3572a() {
        if (f3224c == null) {
            synchronized (SampleRules.class) {
                if (f3224c == null) {
                    f3224c = new SampleRules();
                }
            }
        }
        return f3224c;
    }

    /* renamed from: a */
    public void mo11649a(Context context) {
        mo11652b();
    }

    /* renamed from: a */
    public static boolean m3573a(EventType fVar, String str, String str2) {
        return m3572a().mo11653b(fVar, str, str2, null);
    }

    /* renamed from: a */
    public static boolean m3574a(EventType fVar, String str, String str2, Map<String, String> map) {
        return m3572a().mo11653b(fVar, str, str2, map);
    }

    /* renamed from: a */
    public static boolean m3575a(String str, String str2, Boolean bool, Map<String, String> map) {
        return m3572a().mo11654b(str, str2, bool, map);
    }

    /* renamed from: b */
    public boolean mo11653b(EventType fVar, String str, String str2, Map<String, String> map) {
        EventTypeSampling gVar = (EventTypeSampling) this.f3225b.get(fVar);
        if (gVar != null) {
            return gVar.mo11645a(this.f3226d, str, str2, map);
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo11654b(String str, String str2, Boolean bool, Map<String, String> map) {
        EventTypeSampling gVar = (EventTypeSampling) this.f3225b.get(EventType.ALARM);
        if (gVar == null || !(gVar instanceof AlarmSampling)) {
            return false;
        }
        return ((AlarmSampling) gVar).mo11644a(this.f3226d, str, str2, bool, map);
    }

    /* renamed from: b */
    public void mo11652b() {
        this.f3226d = new Random(System.currentTimeMillis()).nextInt(C7516p.f25219Cf);
    }

    /* JADX INFO: used method not loaded: com.alibaba.mtl.appmonitor.d.g.b(org.json.JSONObject):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r1 = new org.json.JSONObject(r13);
            r4 = com.alibaba.mtl.appmonitor.p068a.EventType.values();
            r5 = r4.length;
            r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
            if (r6 >= r5) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
            r7 = r4[r6];
            r8 = r1.optJSONObject(r7.toString());
            r9 = (com.alibaba.mtl.appmonitor.p071d.EventTypeSampling) r12.f3225b.get(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
            if (r8 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
            if (r9 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
            com.alibaba.mtl.log.p077d.Logger.m3833a(f3223a, r7, r8);
            r9.mo11647b(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
            r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
            r12.f3227e = r13;
     */
    /* renamed from: a */
    public void mo11651a(java.lang.String r13) {
        /*
        r12 = this;
        r0 = 2
        java.lang.Object[] r1 = new java.lang.Object[r0]
        r2 = 0
        java.lang.String r3 = "config:"
        r1[r2] = r3
        r3 = 1
        r1[r3] = r13
        java.lang.String r4 = "SampleRules"
        com.alibaba.mtl.log.p077d.Logger.m3833a(r4, r1)
        monitor-enter(r12)
        boolean r1 = com.alibaba.mtl.appmonitor.p073f.StringUtils.m3590b(r13)     // Catch:{ all -> 0x005e }
        if (r1 != 0) goto L_0x005c
        java.lang.String r1 = r12.f3227e     // Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x0024
        java.lang.String r1 = r12.f3227e     // Catch:{ all -> 0x005e }
        boolean r1 = r1.equals(r13)     // Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x0024
        goto L_0x005c
    L_0x0024:
        monitor-exit(r12)     // Catch:{ all -> 0x005e }
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x005b }
        r1.<init>(r13)     // Catch:{ all -> 0x005b }
        com.alibaba.mtl.appmonitor.a.f[] r4 = com.alibaba.mtl.appmonitor.p068a.EventType.values()     // Catch:{ all -> 0x005b }
        int r5 = r4.length     // Catch:{ all -> 0x005b }
        r6 = 0
    L_0x0030:
        if (r6 >= r5) goto L_0x0059
        r7 = r4[r6]     // Catch:{ all -> 0x005b }
        java.lang.String r8 = r7.toString()     // Catch:{ all -> 0x005b }
        org.json.JSONObject r8 = r1.optJSONObject(r8)     // Catch:{ all -> 0x005b }
        java.util.Map<com.alibaba.mtl.appmonitor.a.f, com.alibaba.mtl.appmonitor.d.g> r9 = r12.f3225b     // Catch:{ all -> 0x005b }
        java.lang.Object r9 = r9.get(r7)     // Catch:{ all -> 0x005b }
        com.alibaba.mtl.appmonitor.d.g r9 = (com.alibaba.mtl.appmonitor.p071d.EventTypeSampling) r9     // Catch:{ all -> 0x005b }
        if (r8 == 0) goto L_0x0056
        if (r9 == 0) goto L_0x0056
        java.lang.String r10 = f3223a     // Catch:{ all -> 0x005b }
        java.lang.Object[] r11 = new java.lang.Object[r0]     // Catch:{ all -> 0x005b }
        r11[r2] = r7     // Catch:{ all -> 0x005b }
        r11[r3] = r8     // Catch:{ all -> 0x005b }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r10, r11)     // Catch:{ all -> 0x005b }
        r9.mo11647b(r8)     // Catch:{ all -> 0x005b }
    L_0x0056:
        int r6 = r6 + 1
        goto L_0x0030
    L_0x0059:
        r12.f3227e = r13     // Catch:{ all -> 0x005b }
    L_0x005b:
        return
    L_0x005c:
        monitor-exit(r12)     // Catch:{ all -> 0x005e }
        return
    L_0x005e:
        r13 = move-exception
        monitor-exit(r12)     // Catch:{ all -> 0x005e }
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.p071d.SampleRules.mo11651a(java.lang.String):void");
    }

    /* renamed from: a */
    public void mo11650a(EventType fVar, int i) {
        EventTypeSampling gVar = (EventTypeSampling) this.f3225b.get(fVar);
        if (gVar != null) {
            gVar.mo11646b(i);
        }
    }
}
