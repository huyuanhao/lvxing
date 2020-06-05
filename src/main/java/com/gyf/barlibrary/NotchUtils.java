package com.gyf.barlibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;

public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";

    public static boolean hasNotchScreen(Activity activity) {
        return activity != null && (hasNotchAtXiaoMi(activity) || hasNotchAtHuaWei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVIVO(activity) || hasNotchAtAndroidP(activity));
    }

    public static boolean hasNotchScreen(View view) {
        return view != null && (hasNotchAtXiaoMi(view.getContext()) || hasNotchAtHuaWei(view.getContext()) || hasNotchAtOPPO(view.getContext()) || hasNotchAtVIVO(view.getContext()) || hasNotchAtAndroidP(view));
    }

    private static boolean hasNotchAtAndroidP(View view) {
        return getDisplayCutout(view) != null;
    }

    private static boolean hasNotchAtAndroidP(Activity activity) {
        return getDisplayCutout(activity) != null;
    }

    private static DisplayCutout getDisplayCutout(Activity activity) {
        if (VERSION.SDK_INT >= 28 && activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
                if (rootWindowInsets != null) {
                    return rootWindowInsets.getDisplayCutout();
                }
            }
        }
        return null;
    }

    private static DisplayCutout getDisplayCutout(View view) {
        if (VERSION.SDK_INT >= 28 && view != null) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets != null) {
                return rootWindowInsets.getDisplayCutout();
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    private static boolean hasNotchAtXiaoMi(android.content.Context r6) {
        /*
        java.lang.String r0 = android.os.Build.MANUFACTURER
        java.lang.String r1 = "Xiaomi"
        boolean r0 = r1.equals(r0)
        r1 = 1
        r2 = 0
        if (r0 == 0) goto L_0x003e
        java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.String r0 = "android.os.SystemProperties"
        java.lang.Class r6 = r6.loadClass(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.String r0 = "getInt"
        r3 = 2
        java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.Class<java.lang.String> r5 = java.lang.String.class
        r4[r2] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        r4[r1] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.String r4 = "ro.miui.notch"
        r3[r2] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        r3[r1] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.Object r6 = r0.invoke(r6, r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        int r6 = r6.intValue()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
        goto L_0x003f
    L_0x003e:
        r6 = 0
    L_0x003f:
        if (r6 != r1) goto L_0x0042
        goto L_0x0043
    L_0x0042:
        r1 = 0
    L_0x0043:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.barlibrary.NotchUtils.hasNotchAtXiaoMi(android.content.Context):boolean");
    }

    private static boolean hasNotchAtHuaWei(Context context) {
        boolean z = false;
        try {
            Class loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            z = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            return z;
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return z;
        }
    }

    private static boolean hasNotchAtVIVO(Context context) {
        boolean z = false;
        try {
            Class loadClass = context.getClassLoader().loadClass(NOTCH_VIVO);
            z = ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
            return z;
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return z;
        }
    }

    private static boolean hasNotchAtOPPO(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature(NOTCH_OPPO);
        } catch (Exception unused) {
            return false;
        }
    }
}
