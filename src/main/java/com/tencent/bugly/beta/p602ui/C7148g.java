package com.tencent.bugly.beta.p602ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Build.VERSION;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bugly.beta.global.C7130d;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.beta.upgrade.C7152c;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.proguard.C7226an;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.g */
public class C7148g {
    /* renamed from: a */
    public static final Map<Integer, C7143b> f23798a = new ConcurrentHashMap();
    /* renamed from: b */
    public static final Map<Integer, C7130d> f23799b = new ConcurrentHashMap();
    /* renamed from: c */
    public static final Map<Integer, C7130d> f23800c = new ConcurrentHashMap();
    /* renamed from: d */
    private static C7130d f23801d;

    /* renamed from: a */
    public static synchronized void m30581a(C7143b bVar, boolean z) {
        synchronized (C7148g.class) {
            if (VERSION.SDK_INT >= 14) {
                m30582a(bVar, z, false, 5000);
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) C7131e.f23698E.f23747s.getSystemService(Constants.FLAG_ACTIVITY_NAME);
                    if (activityManager != null) {
                        activityManager.getRunningTasks(1);
                        m30582a(bVar, z, false, 5000);
                    }
                } catch (SecurityException unused) {
                    if (z) {
                        m30582a(bVar, z, true, 0);
                        return;
                    }
                    C7226an.m31149e("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
                    if (!(C7152c.f23830a.f23831b == null || C7152c.f23830a.f23831b.f23818a == null)) {
                        C7144c.f23780a.mo34445a(C7152c.f23830a.f23831b.f23818a, bVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x012b, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0130, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m30582a(com.tencent.bugly.beta.p602ui.C7143b r15, boolean r16, boolean r17, long r18) {
        /*
        r0 = r15
        r1 = r18
        java.lang.Class<com.tencent.bugly.beta.ui.g> r3 = com.tencent.bugly.beta.p602ui.C7148g.class
        monitor-enter(r3)
        if (r0 == 0) goto L_0x012f
        boolean r4 = r15.mo34442b()     // Catch:{ all -> 0x012c }
        if (r4 == 0) goto L_0x0010
        goto L_0x012f
    L_0x0010:
        int r4 = r15.hashCode()     // Catch:{ all -> 0x012c }
        boolean r5 = r0 instanceof com.tencent.bugly.beta.p602ui.C7149h     // Catch:{ all -> 0x012c }
        r6 = 11
        r7 = 4
        r8 = 1
        r9 = 0
        r10 = 3
        r11 = 2
        if (r5 == 0) goto L_0x00a4
        com.tencent.bugly.beta.global.d r5 = f23801d     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.C7159e.m30683b(r5)     // Catch:{ all -> 0x012c }
        r5 = r0
        com.tencent.bugly.beta.ui.h r5 = (com.tencent.bugly.beta.p602ui.C7149h) r5     // Catch:{ all -> 0x012c }
        com.tencent.bugly.proguard.y r5 = r5.f23808p     // Catch:{ all -> 0x012c }
        byte r5 = r5.f24659g     // Catch:{ all -> 0x012c }
        if (r5 != r11) goto L_0x0053
        com.tencent.bugly.beta.global.d r5 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x012c }
        r12 = 15
        java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ all -> 0x012c }
        r13[r9] = r0     // Catch:{ all -> 0x012c }
        java.lang.Boolean r14 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x012c }
        r13[r8] = r14     // Catch:{ all -> 0x012c }
        java.lang.Boolean r14 = java.lang.Boolean.valueOf(r17)     // Catch:{ all -> 0x012c }
        r13[r11] = r14     // Catch:{ all -> 0x012c }
        java.lang.Long r14 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x012c }
        r13[r10] = r14     // Catch:{ all -> 0x012c }
        r5.m52393init(r12, r13)     // Catch:{ all -> 0x012c }
        f23801d = r5     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.global.d r5 = f23801d     // Catch:{ all -> 0x012c }
        r12 = 3000(0xbb8, double:1.482E-320)
        com.tencent.bugly.beta.utils.C7159e.m30682a(r5, r12)     // Catch:{ all -> 0x012c }
    L_0x0053:
        if (r16 != 0) goto L_0x0095
        boolean r5 = m30583b()     // Catch:{ all -> 0x012c }
        if (r5 != 0) goto L_0x0095
        java.util.Map<java.lang.Integer, com.tencent.bugly.beta.global.d> r5 = f23799b     // Catch:{ all -> 0x012c }
        java.lang.Integer r12 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
        java.lang.Object r5 = r5.get(r12)     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.global.d r5 = (com.tencent.bugly.beta.global.C7130d) r5     // Catch:{ all -> 0x012c }
        if (r5 != 0) goto L_0x008d
        com.tencent.bugly.beta.global.d r5 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x012c }
        java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x012c }
        r7[r9] = r0     // Catch:{ all -> 0x012c }
        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x012c }
        r7[r8] = r0     // Catch:{ all -> 0x012c }
        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r17)     // Catch:{ all -> 0x012c }
        r7[r11] = r0     // Catch:{ all -> 0x012c }
        java.lang.Long r0 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x012c }
        r7[r10] = r0     // Catch:{ all -> 0x012c }
        r5.m52393init(r6, r7)     // Catch:{ all -> 0x012c }
        java.util.Map<java.lang.Integer, com.tencent.bugly.beta.global.d> r0 = f23799b     // Catch:{ all -> 0x012c }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
        r0.put(r4, r5)     // Catch:{ all -> 0x012c }
    L_0x008d:
        com.tencent.bugly.beta.utils.C7159e.m30683b(r5)     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.C7159e.m30682a(r5, r1)     // Catch:{ all -> 0x012c }
        monitor-exit(r3)
        return
    L_0x0095:
        java.util.Map<java.lang.Integer, com.tencent.bugly.beta.global.d> r5 = f23799b     // Catch:{ all -> 0x012c }
        java.lang.Integer r12 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
        java.lang.Object r5 = r5.remove(r12)     // Catch:{ all -> 0x012c }
        java.lang.Runnable r5 = (java.lang.Runnable) r5     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.C7159e.m30683b(r5)     // Catch:{ all -> 0x012c }
    L_0x00a4:
        if (r17 != 0) goto L_0x00ea
        com.tencent.bugly.beta.global.e r5 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x012c }
        android.content.Context r5 = r5.f23747s     // Catch:{ all -> 0x012c }
        boolean r5 = com.tencent.bugly.proguard.C7232aq.m31213b(r5)     // Catch:{ all -> 0x012c }
        if (r5 != 0) goto L_0x00ea
        java.util.Map<java.lang.Integer, com.tencent.bugly.beta.global.d> r5 = f23800c     // Catch:{ all -> 0x012c }
        java.lang.Integer r12 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
        java.lang.Object r5 = r5.get(r12)     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.global.d r5 = (com.tencent.bugly.beta.global.C7130d) r5     // Catch:{ all -> 0x012c }
        if (r5 != 0) goto L_0x00e2
        com.tencent.bugly.beta.global.d r5 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x012c }
        java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x012c }
        r7[r9] = r0     // Catch:{ all -> 0x012c }
        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x012c }
        r7[r8] = r0     // Catch:{ all -> 0x012c }
        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r17)     // Catch:{ all -> 0x012c }
        r7[r11] = r0     // Catch:{ all -> 0x012c }
        java.lang.Long r0 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x012c }
        r7[r10] = r0     // Catch:{ all -> 0x012c }
        r5.m52393init(r6, r7)     // Catch:{ all -> 0x012c }
        java.util.Map<java.lang.Integer, com.tencent.bugly.beta.global.d> r0 = f23800c     // Catch:{ all -> 0x012c }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
        r0.put(r4, r5)     // Catch:{ all -> 0x012c }
    L_0x00e2:
        com.tencent.bugly.beta.utils.C7159e.m30683b(r5)     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.C7159e.m30682a(r5, r1)     // Catch:{ all -> 0x012c }
        monitor-exit(r3)
        return
    L_0x00ea:
        java.util.Map<java.lang.Integer, com.tencent.bugly.beta.global.d> r1 = f23800c     // Catch:{ all -> 0x012c }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
        java.lang.Object r1 = r1.remove(r2)     // Catch:{ all -> 0x012c }
        java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.C7159e.m30683b(r1)     // Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.global.d r1 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x012c }
        r2 = 17
        java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x012c }
        java.util.Map<java.lang.Integer, com.tencent.bugly.beta.ui.b> r6 = f23798a     // Catch:{ all -> 0x012c }
        r5[r9] = r6     // Catch:{ all -> 0x012c }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
        r5[r8] = r4     // Catch:{ all -> 0x012c }
        r5[r11] = r0     // Catch:{ all -> 0x012c }
        r1.m52393init(r2, r5)     // Catch:{ all -> 0x012c }
        androidx.fragment.app.FragmentActivity r0 = r15.getActivity()     // Catch:{ all -> 0x012c }
        if (r0 == 0) goto L_0x0127
        boolean r2 = r0 instanceof com.tencent.bugly.beta.p602ui.BetaActivity     // Catch:{ all -> 0x012c }
        if (r2 == 0) goto L_0x011e
        r2 = r0
        com.tencent.bugly.beta.ui.BetaActivity r2 = (com.tencent.bugly.beta.p602ui.BetaActivity) r2     // Catch:{ all -> 0x012c }
        r2.onDestroyRunnable = r1     // Catch:{ all -> 0x012c }
        goto L_0x0123
    L_0x011e:
        r4 = 400(0x190, double:1.976E-321)
        com.tencent.bugly.beta.utils.C7159e.m30682a(r1, r4)     // Catch:{ all -> 0x012c }
    L_0x0123:
        r0.finish()     // Catch:{ all -> 0x012c }
        goto L_0x012a
    L_0x0127:
        r1.run()     // Catch:{ all -> 0x012c }
    L_0x012a:
        monitor-exit(r3)
        return
    L_0x012c:
        r0 = move-exception
        monitor-exit(r3)
        throw r0
    L_0x012f:
        monitor-exit(r3)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.p602ui.C7148g.m30582a(com.tencent.bugly.beta.ui.b, boolean, boolean, long):void");
    }

    /* renamed from: a */
    public static String m30580a() {
        try {
            if (VERSION.SDK_INT >= 14) {
                return C7174a.m30754b().f24041v;
            }
            ActivityManager activityManager = (ActivityManager) C7131e.f23698E.f23747s.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                List runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks != null && !runningTasks.isEmpty()) {
                    return ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName();
                }
            }
            return null;
        } catch (SecurityException unused) {
            C7226an.m31149e("无法获取Activity信息，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008c, code lost:
            return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0092, code lost:
            return false;
     */
    /* renamed from: b */
    public static synchronized boolean m30583b() {
        /*
        java.lang.Class<com.tencent.bugly.beta.ui.g> r0 = com.tencent.bugly.beta.p602ui.C7148g.class
        monitor-enter(r0)
        java.lang.String r1 = m30580a()     // Catch:{ all -> 0x0093 }
        r2 = 0
        if (r1 == 0) goto L_0x0091
        java.lang.String r3 = "background"
        boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x0093 }
        if (r3 != 0) goto L_0x0091
        java.lang.String r3 = "unknown"
        boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x0093 }
        if (r3 == 0) goto L_0x001c
        goto L_0x0091
    L_0x001c:
        r3 = 0
        java.lang.Class r3 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0022 }
        goto L_0x0026
    L_0x0022:
        r4 = move-exception
        r4.printStackTrace()     // Catch:{ all -> 0x0093 }
    L_0x0026:
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0093 }
        java.util.List<java.lang.Class<? extends android.app.Activity>> r4 = r4.f23741m     // Catch:{ all -> 0x0093 }
        boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0093 }
        r5 = 1
        if (r4 != 0) goto L_0x005b
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0093 }
        java.util.List<java.lang.Class<? extends android.app.Activity>> r4 = r4.f23741m     // Catch:{ all -> 0x0093 }
        java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0093 }
    L_0x0039:
        boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0093 }
        if (r6 == 0) goto L_0x0059
        java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0093 }
        java.lang.Class r6 = (java.lang.Class) r6     // Catch:{ all -> 0x0093 }
        java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x0093 }
        boolean r7 = android.text.TextUtils.equals(r7, r1)     // Catch:{ all -> 0x0093 }
        if (r7 != 0) goto L_0x0057
        if (r3 == 0) goto L_0x0039
        boolean r6 = r6.isAssignableFrom(r3)     // Catch:{ all -> 0x0093 }
        if (r6 == 0) goto L_0x0039
    L_0x0057:
        monitor-exit(r0)
        return r5
    L_0x0059:
        monitor-exit(r0)
        return r2
    L_0x005b:
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0093 }
        java.util.List<java.lang.Class<? extends android.app.Activity>> r4 = r4.f23742n     // Catch:{ all -> 0x0093 }
        boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0093 }
        if (r4 != 0) goto L_0x008f
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0093 }
        java.util.List<java.lang.Class<? extends android.app.Activity>> r4 = r4.f23742n     // Catch:{ all -> 0x0093 }
        java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0093 }
    L_0x006d:
        boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0093 }
        if (r6 == 0) goto L_0x008d
        java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0093 }
        java.lang.Class r6 = (java.lang.Class) r6     // Catch:{ all -> 0x0093 }
        java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x0093 }
        boolean r7 = android.text.TextUtils.equals(r7, r1)     // Catch:{ all -> 0x0093 }
        if (r7 != 0) goto L_0x008b
        if (r3 == 0) goto L_0x006d
        boolean r6 = r6.isAssignableFrom(r3)     // Catch:{ all -> 0x0093 }
        if (r6 == 0) goto L_0x006d
    L_0x008b:
        monitor-exit(r0)
        return r2
    L_0x008d:
        monitor-exit(r0)
        return r5
    L_0x008f:
        monitor-exit(r0)
        return r5
    L_0x0091:
        monitor-exit(r0)
        return r2
    L_0x0093:
        r1 = move-exception
        monitor-exit(r0)
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.p602ui.C7148g.m30583b():boolean");
    }
}
