package com.tencent.mta.track;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.au */
class C7361au implements Callable {
    /* renamed from: a */
    private C7348ah f24922a;
    /* renamed from: b */
    private final List f24923b = new ArrayList();
    /* renamed from: c */
    private final DisplayMetrics f24924c = new DisplayMetrics();
    /* renamed from: d */
    private final C7359as f24925d = new C7359as();
    /* renamed from: e */
    private final int f24926e = 160;

    /* renamed from: a */
    public void mo35894a(C7348ah ahVar) {
        this.f24922a = ahVar;
    }

    /* renamed from: a */
    public List call() {
        try {
            this.f24923b.clear();
            for (Activity activity : this.f24922a.mo35862a()) {
                String canonicalName = activity.getClass().getCanonicalName();
                View rootView = activity.getWindow().getDecorView().getRootView();
                activity.getWindowManager().getDefaultDisplay().getMetrics(this.f24924c);
                this.f24923b.add(new C7362av(canonicalName, rootView));
            }
            if (this.f24923b.size() > 0) {
                m31769a((C7362av) this.f24923b.get(0));
            }
        } catch (Throwable unused) {
        }
        return this.f24923b;
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [android.graphics.Bitmap] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061 A[SYNTHETIC, Splitter:B:15:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    private void m31769a(com.tencent.mta.track.C7362av r14) {
        /*
        r13 = this;
        java.lang.String r0 = "Snapshot"
        android.view.View r1 = r14.f24928b
        r2 = 0
        r3 = 0
        r4 = 1
        java.lang.Class<android.view.View> r5 = android.view.View.class
        java.lang.String r6 = "createSnapshot"
        r7 = 3
        java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        java.lang.Class<android.graphics.Bitmap$Config> r9 = android.graphics.Bitmap.Config.class
        r8[r3] = r9     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        r8[r4] = r9     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        r10 = 2
        r8[r10] = r9     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r8)     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        r5.setAccessible(r4)     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        r6[r3] = r7     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        r7 = -1
        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        r6[r4] = r7     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        r6[r10] = r7     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        java.lang.Object r5 = r5.invoke(r1, r6)     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch:{ NoSuchMethodException -> 0x0058, IllegalArgumentException -> 0x0051, InvocationTargetException -> 0x004a, IllegalAccessException -> 0x0043, ClassCastException -> 0x003c }
        goto L_0x005f
    L_0x003c:
        r5 = move-exception
        java.lang.String r6 = "createSnapshot didn't return a bitmap?"
        android.util.Log.e(r0, r6, r5)
        goto L_0x005e
    L_0x0043:
        r5 = move-exception
        java.lang.String r6 = "Can't access createSnapshot, using drawCache"
        android.util.Log.e(r0, r6, r5)
        goto L_0x005e
    L_0x004a:
        r5 = move-exception
        java.lang.String r6 = "Exception when calling createSnapshot"
        android.util.Log.e(r0, r6, r5)
        goto L_0x005e
    L_0x0051:
        r5 = move-exception
        java.lang.String r6 = "Can't call createSnapshot with arguments"
        android.util.Log.i(r0, r6, r5)
        goto L_0x005e
    L_0x0058:
        r5 = move-exception
        java.lang.String r6 = "Can't call createSnapshot, will use drawCache"
        android.util.Log.i(r0, r6, r5)
    L_0x005e:
        r5 = r2
    L_0x005f:
        if (r5 != 0) goto L_0x008f
        boolean r6 = r1.isDrawingCacheEnabled()     // Catch:{ RuntimeException -> 0x0075 }
        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r6)     // Catch:{ RuntimeException -> 0x0075 }
        r1.setDrawingCacheEnabled(r4)     // Catch:{ RuntimeException -> 0x0075 }
        r1.buildDrawingCache(r4)     // Catch:{ RuntimeException -> 0x0075 }
        android.graphics.Bitmap r0 = r1.getDrawingCache()     // Catch:{ RuntimeException -> 0x0075 }
        r5 = r0
        goto L_0x008f
    L_0x0075:
        r4 = move-exception
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        java.lang.String r7 = "Can't take a bitmap snapshot of view "
        r6.append(r7)
        r6.append(r1)
        java.lang.String r7 = ", skipping for now."
        r6.append(r7)
        java.lang.String r6 = r6.toString()
        android.util.Log.w(r0, r6, r4)
    L_0x008f:
        r0 = 1065353216(0x3f800000, float:1.0)
        if (r5 == 0) goto L_0x00ca
        int r4 = r5.getDensity()
        if (r4 == 0) goto L_0x009d
        r0 = 1126170624(0x43200000, float:160.0)
        float r4 = (float) r4
        float r0 = r0 / r4
    L_0x009d:
        int r4 = r5.getWidth()
        int r6 = r5.getHeight()
        int r7 = r5.getWidth()
        float r7 = (float) r7
        float r7 = r7 * r0
        double r7 = (double) r7
        r9 = 4602678819172646912(0x3fe0000000000000, double:0.5)
        double r7 = r7 + r9
        int r7 = (int) r7
        int r8 = r5.getHeight()
        float r8 = (float) r8
        float r8 = r8 * r0
        double r11 = (double) r8
        double r11 = r11 + r9
        int r8 = (int) r11
        if (r4 <= 0) goto L_0x00ca
        if (r6 <= 0) goto L_0x00ca
        if (r7 <= 0) goto L_0x00ca
        if (r8 <= 0) goto L_0x00ca
        com.tencent.mta.track.as r4 = r13.f24925d
        r6 = 160(0xa0, float:2.24E-43)
        r4.mo35889a(r7, r8, r6, r5)
    L_0x00ca:
        if (r2 == 0) goto L_0x00d5
        boolean r2 = r2.booleanValue()
        if (r2 != 0) goto L_0x00d5
        r1.setDrawingCacheEnabled(r3)
    L_0x00d5:
        r14.f24930d = r0
        com.tencent.mta.track.as r0 = r13.f24925d
        r14.f24929c = r0
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.C7361au.m31769a(com.tencent.mta.track.av):void");
    }
}
