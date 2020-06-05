package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.C7174a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ac */
public class C7208ac {
    /* renamed from: a */
    public static final long f24294a = System.currentTimeMillis();
    /* renamed from: b */
    private static C7208ac f24295b;
    /* renamed from: c */
    private Context f24296c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public String f24297d = C7174a.m30754b().f24024e;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public Map<Integer, Map<String, C7207ab>> f24298e = new HashMap();
    /* access modifiers changed from: private */
    /* renamed from: f */
    public SharedPreferences f24299f;

    public C7208ac(Context context) {
        this.f24296c = context;
        this.f24299f = context.getSharedPreferences("crashrecord", 0);
    }

    /* renamed from: a */
    public static synchronized C7208ac m31022a(Context context) {
        C7208ac acVar;
        synchronized (C7208ac.class) {
            if (f24295b == null) {
                f24295b = new C7208ac(context);
            }
            acVar = f24295b;
        }
        return acVar;
    }

    /* renamed from: a */
    public static synchronized C7208ac m31021a() {
        C7208ac acVar;
        synchronized (C7208ac.class) {
            acVar = f24295b;
        }
        return acVar;
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
            return true;
     */
    /* renamed from: b */
    public synchronized boolean m31028b(int r13) {
        /*
        r12 = this;
        monitor-enter(r12)
        r0 = 0
        java.util.List r1 = r12.m31031c(r13)     // Catch:{ Exception -> 0x0082 }
        if (r1 != 0) goto L_0x000a
        monitor-exit(r12)
        return r0
    L_0x000a:
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0082 }
        java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0082 }
        r4.<init>()     // Catch:{ Exception -> 0x0082 }
        java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0082 }
        r5.<init>()     // Catch:{ Exception -> 0x0082 }
        java.util.Iterator r6 = r1.iterator()     // Catch:{ Exception -> 0x0082 }
    L_0x001c:
        boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0082 }
        r8 = 86400000(0x5265c00, double:4.2687272E-316)
        if (r7 == 0) goto L_0x004b
        java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0082 }
        com.tencent.bugly.proguard.ab r7 = (com.tencent.bugly.proguard.C7207ab) r7     // Catch:{ Exception -> 0x0082 }
        java.lang.String r10 = r7.f24288b     // Catch:{ Exception -> 0x0082 }
        if (r10 == 0) goto L_0x0040
        java.lang.String r10 = r7.f24288b     // Catch:{ Exception -> 0x0082 }
        java.lang.String r11 = r12.f24297d     // Catch:{ Exception -> 0x0082 }
        boolean r10 = r10.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0082 }
        if (r10 == 0) goto L_0x0040
        int r10 = r7.f24290d     // Catch:{ Exception -> 0x0082 }
        if (r10 <= 0) goto L_0x0040
        r4.add(r7)     // Catch:{ Exception -> 0x0082 }
    L_0x0040:
        long r10 = r7.f24289c     // Catch:{ Exception -> 0x0082 }
        long r10 = r10 + r8
        int r8 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
        if (r8 >= 0) goto L_0x001c
        r5.add(r7)     // Catch:{ Exception -> 0x0082 }
        goto L_0x001c
    L_0x004b:
        java.util.Collections.sort(r4)     // Catch:{ Exception -> 0x0082 }
        int r6 = r4.size()     // Catch:{ Exception -> 0x0082 }
        r7 = 2
        if (r6 < r7) goto L_0x0078
        int r5 = r4.size()     // Catch:{ Exception -> 0x0082 }
        r6 = 1
        if (r5 <= 0) goto L_0x0076
        int r5 = r4.size()     // Catch:{ Exception -> 0x0082 }
        int r5 = r5 - r6
        java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x0082 }
        com.tencent.bugly.proguard.ab r4 = (com.tencent.bugly.proguard.C7207ab) r4     // Catch:{ Exception -> 0x0082 }
        long r4 = r4.f24289c     // Catch:{ Exception -> 0x0082 }
        long r4 = r4 + r8
        int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
        if (r7 >= 0) goto L_0x0076
        r1.clear()     // Catch:{ Exception -> 0x0082 }
        r12.m31025a(r13, (T) r1)     // Catch:{ Exception -> 0x0082 }
        monitor-exit(r12)
        return r0
    L_0x0076:
        monitor-exit(r12)
        return r6
    L_0x0078:
        r1.removeAll(r5)     // Catch:{ Exception -> 0x0082 }
        r12.m31025a(r13, (T) r1)     // Catch:{ Exception -> 0x0082 }
        monitor-exit(r12)
        return r0
    L_0x0080:
        r13 = move-exception
        goto L_0x008b
    L_0x0082:
        java.lang.String r13 = "isFrequentCrash failed"
        java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0080 }
        com.tencent.bugly.proguard.C7226an.m31149e(r13, r1)     // Catch:{ all -> 0x0080 }
        monitor-exit(r12)
        return r0
    L_0x008b:
        monitor-exit(r12)
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7208ac.m31028b(int):boolean");
    }

    /* renamed from: a */
    public void mo34768a(final int i, final int i2) {
        C7224am.m31132a().mo34832a(new Runnable() {
            public void run() {
                C7207ab abVar;
                try {
                    if (!TextUtils.isEmpty(C7208ac.this.f24297d)) {
                        List<C7207ab> a = C7208ac.this.m31031c(i);
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        if (C7208ac.this.f24298e.get(Integer.valueOf(i)) == null) {
                            C7208ac.this.f24298e.put(Integer.valueOf(i), new HashMap());
                        }
                        if (((Map) C7208ac.this.f24298e.get(Integer.valueOf(i))).get(C7208ac.this.f24297d) == null) {
                            abVar = new C7207ab();
                            abVar.f24287a = (long) i;
                            abVar.f24293g = C7208ac.f24294a;
                            abVar.f24288b = C7208ac.this.f24297d;
                            abVar.f24292f = C7174a.m30754b().f24035p;
                            C7174a.m30754b().getClass();
                            abVar.f24291e = "3.1.0";
                            abVar.f24289c = System.currentTimeMillis();
                            abVar.f24290d = i2;
                            ((Map) C7208ac.this.f24298e.get(Integer.valueOf(i))).put(C7208ac.this.f24297d, abVar);
                        } else {
                            abVar = (C7207ab) ((Map) C7208ac.this.f24298e.get(Integer.valueOf(i))).get(C7208ac.this.f24297d);
                            abVar.f24290d = i2;
                        }
                        ArrayList arrayList = new ArrayList();
                        boolean z = false;
                        for (C7207ab abVar2 : a) {
                            if (abVar2.f24293g == abVar.f24293g && abVar2.f24288b != null && abVar2.f24288b.equalsIgnoreCase(abVar.f24288b)) {
                                z = true;
                                abVar2.f24290d = abVar.f24290d;
                            }
                            if ((abVar2.f24291e != null && !abVar2.f24291e.equalsIgnoreCase(abVar.f24291e)) || ((abVar2.f24292f != null && !abVar2.f24292f.equalsIgnoreCase(abVar.f24292f)) || abVar2.f24290d <= 0)) {
                                arrayList.add(abVar2);
                            }
                        }
                        a.removeAll(arrayList);
                        if (!z) {
                            a.add(abVar);
                        }
                        C7208ac.this.m31025a(i, a);
                    }
                } catch (Exception unused) {
                    C7226an.m31149e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
            if (r6 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0057, code lost:
            if (r6 != null) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005d A[SYNTHETIC, Splitter:B:35:0x005d] */
    /* renamed from: c */
    public synchronized <T extends java.util.List<?>> T m31031c(int r6) {
        /*
        r5 = this;
        monitor-enter(r5)
        r0 = 0
        r1 = 0
        java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0063 }
        android.content.Context r3 = r5.f24296c     // Catch:{ Exception -> 0x0063 }
        java.lang.String r4 = "crashrecord"
        java.io.File r3 = r3.getDir(r4, r1)     // Catch:{ Exception -> 0x0063 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
        r4.<init>()     // Catch:{ Exception -> 0x0063 }
        r4.append(r6)     // Catch:{ Exception -> 0x0063 }
        java.lang.String r6 = ""
        r4.append(r6)     // Catch:{ Exception -> 0x0063 }
        java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x0063 }
        r2.<init>(r3, r6)     // Catch:{ Exception -> 0x0063 }
        boolean r6 = r2.exists()     // Catch:{ Exception -> 0x0063 }
        if (r6 != 0) goto L_0x0029
        monitor-exit(r5)
        return r0
    L_0x0029:
        java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x0041, all -> 0x003e }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x0041, all -> 0x003e }
        r3.<init>(r2)     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x0041, all -> 0x003e }
        r6.<init>(r3)     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x0041, all -> 0x003e }
        java.lang.Object r2 = r6.readObject()     // Catch:{ IOException -> 0x0050, ClassNotFoundException -> 0x0042 }
        java.util.List r2 = (java.util.List) r2     // Catch:{ IOException -> 0x0050, ClassNotFoundException -> 0x0042 }
        r6.close()     // Catch:{ Exception -> 0x0063 }
        monitor-exit(r5)
        return r2
    L_0x003e:
        r2 = move-exception
        r6 = r0
        goto L_0x005b
    L_0x0041:
        r6 = r0
    L_0x0042:
        java.lang.String r2 = "get object error"
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x005a }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ all -> 0x005a }
        if (r6 == 0) goto L_0x006a
    L_0x004b:
        r6.close()     // Catch:{ Exception -> 0x0063 }
        goto L_0x006a
    L_0x004f:
        r6 = r0
    L_0x0050:
        java.lang.String r2 = "open record file error"
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x005a }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ all -> 0x005a }
        if (r6 == 0) goto L_0x006a
        goto L_0x004b
    L_0x005a:
        r2 = move-exception
    L_0x005b:
        if (r6 == 0) goto L_0x0060
        r6.close()     // Catch:{ Exception -> 0x0063 }
    L_0x0060:
        throw r2     // Catch:{ Exception -> 0x0063 }
    L_0x0061:
        r6 = move-exception
        goto L_0x006c
    L_0x0063:
        java.lang.String r6 = "readCrashRecord error"
        java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0061 }
        com.tencent.bugly.proguard.C7226an.m31149e(r6, r1)     // Catch:{ all -> 0x0061 }
    L_0x006a:
        monitor-exit(r5)
        return r0
    L_0x006c:
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7208ac.m31031c(int):java.util.List");
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d A[SYNTHETIC, Splitter:B:23:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053 A[Catch:{ Exception -> 0x0059 }] */
    /* renamed from: a */
    public synchronized <T extends java.util.List<?>> void m31025a(int r5, T r6) {
        /*
        r4 = this;
        monitor-enter(r4)
        if (r6 != 0) goto L_0x0005
        monitor-exit(r4)
        return
    L_0x0005:
        r0 = 0
        java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0059 }
        android.content.Context r2 = r4.f24296c     // Catch:{ Exception -> 0x0059 }
        java.lang.String r3 = "crashrecord"
        java.io.File r2 = r2.getDir(r3, r0)     // Catch:{ Exception -> 0x0059 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
        r3.<init>()     // Catch:{ Exception -> 0x0059 }
        r3.append(r5)     // Catch:{ Exception -> 0x0059 }
        java.lang.String r5 = ""
        r3.append(r5)     // Catch:{ Exception -> 0x0059 }
        java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x0059 }
        r1.<init>(r2, r5)     // Catch:{ Exception -> 0x0059 }
        r5 = 0
        java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0040 }
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0040 }
        r3.<init>(r1)     // Catch:{ IOException -> 0x0040 }
        r2.<init>(r3)     // Catch:{ IOException -> 0x0040 }
        r2.writeObject(r6)     // Catch:{ IOException -> 0x003a, all -> 0x0036 }
        r2.close()     // Catch:{ Exception -> 0x0059 }
        goto L_0x0060
    L_0x0036:
        r5 = move-exception
        r6 = r5
        r5 = r2
        goto L_0x0051
    L_0x003a:
        r5 = move-exception
        r6 = r5
        r5 = r2
        goto L_0x0041
    L_0x003e:
        r6 = move-exception
        goto L_0x0051
    L_0x0040:
        r6 = move-exception
    L_0x0041:
        r6.printStackTrace()     // Catch:{ all -> 0x003e }
        java.lang.String r6 = "open record file error"
        java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x003e }
        com.tencent.bugly.proguard.C7226an.m31141a(r6, r1)     // Catch:{ all -> 0x003e }
        if (r5 == 0) goto L_0x0060
        r5.close()     // Catch:{ Exception -> 0x0059 }
        goto L_0x0060
    L_0x0051:
        if (r5 == 0) goto L_0x0056
        r5.close()     // Catch:{ Exception -> 0x0059 }
    L_0x0056:
        throw r6     // Catch:{ Exception -> 0x0059 }
    L_0x0057:
        r5 = move-exception
        goto L_0x0062
    L_0x0059:
        java.lang.String r5 = "writeCrashRecord error"
        java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x0057 }
        com.tencent.bugly.proguard.C7226an.m31149e(r5, r6)     // Catch:{ all -> 0x0057 }
    L_0x0060:
        monitor-exit(r4)
        return
    L_0x0062:
        monitor-exit(r4)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7208ac.m31025a(int, java.util.List):void");
    }

    /* renamed from: a */
    public synchronized boolean mo34769a(final int i) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f24299f;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("_");
            sb.append(this.f24297d);
            z = sharedPreferences.getBoolean(sb.toString(), true);
            C7224am.m31132a().mo34832a(new Runnable() {
                public void run() {
                    boolean b = C7208ac.this.m31028b(i);
                    Editor edit = C7208ac.this.f24299f.edit();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append("_");
                    sb.append(C7208ac.this.f24297d);
                    edit.putBoolean(sb.toString(), !b).commit();
                }
            });
        } catch (Exception unused) {
            C7226an.m31149e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
