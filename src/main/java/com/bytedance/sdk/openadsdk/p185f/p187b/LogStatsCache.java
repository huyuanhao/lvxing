package com.bytedance.sdk.openadsdk.p185f.p187b;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.f.b.b */
public class LogStatsCache {
    /* renamed from: a */
    private static volatile LogStatsCache f8657a;
    /* renamed from: b */
    private Context f8658b;
    /* renamed from: c */
    private AtomicBoolean f8659c = new AtomicBoolean(false);

    /* renamed from: a */
    public static LogStatsCache m11341a() {
        if (f8657a == null) {
            synchronized (LogStatsCache.class) {
                if (f8657a == null) {
                    f8657a = new LogStatsCache();
                }
            }
        }
        return f8657a;
    }

    private LogStatsCache() {
        mo16619b();
    }

    /* renamed from: b */
    public void mo16619b() {
        if (!this.f8659c.get() && InternalContainer.m10059a() != null) {
            this.f8658b = InternalContainer.m10059a();
            this.f8659c.set(true);
        }
    }

    /* renamed from: c */
    public synchronized void mo16620c() {
        if (!this.f8659c.get()) {
            mo16619b();
        } else {
            try {
                DBMultiAdapter.m11758a(this.f8658b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:13|14|15|16|32|29|11|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
            if (r1 != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
            throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006b, code lost:
            return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0035 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035 A[LOOP:0: B:10:0x0035->B:29:0x0035, LOOP_START, SYNTHETIC, Splitter:B:10:0x0035] */
    /* renamed from: d */
    public synchronized java.util.List<com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a> mo16621d() {
        /*
        r9 = this;
        monitor-enter(r9)
        java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x006c }
        r0.<init>()     // Catch:{ all -> 0x006c }
        java.util.concurrent.atomic.AtomicBoolean r1 = r9.f8659c     // Catch:{ all -> 0x006c }
        boolean r1 = r1.get()     // Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x0013
        r9.mo16619b()     // Catch:{ all -> 0x006c }
        monitor-exit(r9)
        return r0
    L_0x0013:
        android.content.Context r1 = r9.f8658b     // Catch:{ all -> 0x006c }
        java.lang.String r2 = "logstats"
        java.lang.String r3 = "id"
        java.lang.String r4 = "value"
        java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ all -> 0x006c }
        java.lang.String r4 = "retry <?"
        r5 = 1
        java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x006c }
        r6 = 0
        r7 = 5
        java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x006c }
        r5[r6] = r7     // Catch:{ all -> 0x006c }
        r6 = 0
        r7 = 0
        r8 = 0
        android.database.Cursor r1 = com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter.m11760a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x006a
    L_0x0035:
        boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x005d
        java.lang.String r2 = "id"
        int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x0063 }
        java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x0063 }
        java.lang.String r3 = "value"
        int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0063 }
        java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0063 }
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0035 }
        r4.<init>(r3)     // Catch:{ Exception -> 0x0035 }
        com.bytedance.sdk.openadsdk.f.b.c$a r3 = new com.bytedance.sdk.openadsdk.f.b.c$a     // Catch:{ Exception -> 0x0035 }
        r3.m44016init(r2, r4)     // Catch:{ Exception -> 0x0035 }
        r0.add(r3)     // Catch:{ Exception -> 0x0035 }
        goto L_0x0035
    L_0x005d:
        if (r1 == 0) goto L_0x006a
        r1.close()     // Catch:{ all -> 0x006c }
        goto L_0x006a
    L_0x0063:
        r0 = move-exception
        if (r1 == 0) goto L_0x0069
        r1.close()     // Catch:{ all -> 0x006c }
    L_0x0069:
        throw r0     // Catch:{ all -> 0x006c }
    L_0x006a:
        monitor-exit(r9)
        return r0
    L_0x006c:
        r0 = move-exception
        monitor-exit(r9)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p185f.p187b.LogStatsCache.mo16621d():java.util.List");
    }
}
