package com.kingja.loadsir;

import android.os.Looper;

/* renamed from: com.kingja.loadsir.a */
public class LoadSirUtil {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* renamed from: a */
    public static com.kingja.loadsir.core.TargetContext m14975a(java.lang.Object r7) {
        /*
        boolean r0 = r7 instanceof android.app.Activity
        if (r0 == 0) goto L_0x0011
        r0 = r7
        android.app.Activity r0 = (android.app.Activity) r0
        r1 = 16908290(0x1020002, float:2.3877235E-38)
        android.view.View r1 = r0.findViewById(r1)
        android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        goto L_0x0024
    L_0x0011:
        boolean r0 = r7 instanceof android.view.View
        if (r0 == 0) goto L_0x0071
        r0 = r7
        android.view.View r0 = (android.view.View) r0
        android.view.ViewParent r1 = r0.getParent()
        android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        android.content.Context r0 = r0.getContext()
    L_0x0024:
        r2 = 0
        if (r1 != 0) goto L_0x0029
        r3 = 0
        goto L_0x002d
    L_0x0029:
        int r3 = r1.getChildCount()
    L_0x002d:
        boolean r4 = r7 instanceof android.view.View
        if (r4 == 0) goto L_0x0041
        r4 = r7
        android.view.View r4 = (android.view.View) r4
        r5 = 0
    L_0x0035:
        if (r5 >= r3) goto L_0x004a
        android.view.View r6 = r1.getChildAt(r5)
        if (r6 != r4) goto L_0x003e
        goto L_0x004b
    L_0x003e:
        int r5 = r5 + 1
        goto L_0x0035
    L_0x0041:
        if (r1 == 0) goto L_0x0048
        android.view.View r3 = r1.getChildAt(r2)
        goto L_0x0049
    L_0x0048:
        r3 = 0
    L_0x0049:
        r4 = r3
    L_0x004a:
        r5 = 0
    L_0x004b:
        if (r4 == 0) goto L_0x0058
        if (r1 == 0) goto L_0x0052
        r1.removeView(r4)
    L_0x0052:
        com.kingja.loadsir.core.d r7 = new com.kingja.loadsir.core.d
        r7.m47362init(r0, r1, r4, r5)
        return r7
    L_0x0058:
        java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
        r1 = 1
        java.lang.Object[] r1 = new java.lang.Object[r1]
        java.lang.Class r7 = r7.getClass()
        java.lang.String r7 = r7.getSimpleName()
        r1[r2] = r7
        java.lang.String r7 = "enexpected error when register LoadSir in %s"
        java.lang.String r7 = java.lang.String.format(r7, r1)
        r0.<init>(r7)
        throw r0
    L_0x0071:
        java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
        java.lang.String r0 = "The target must be within Activity, Fragment, View."
        r7.<init>(r0)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingja.loadsir.LoadSirUtil.m14975a(java.lang.Object):com.kingja.loadsir.core.d");
    }

    /* renamed from: a */
    public static boolean m14976a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
