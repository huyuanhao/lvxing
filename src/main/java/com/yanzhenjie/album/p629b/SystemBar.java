package com.yanzhenjie.album.p629b;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.yanzhenjie.album.b.b */
public class SystemBar {
    /* renamed from: a */
    public static void m33556a(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            m33558a(activity.getWindow(), i);
        }
    }

    /* renamed from: a */
    public static void m33558a(Window window, int i) {
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
    }

    /* renamed from: b */
    public static void m33562b(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            m33564b(activity.getWindow(), i);
        }
    }

    /* renamed from: b */
    public static void m33564b(Window window, int i) {
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i);
    }

    /* renamed from: a */
    public static void m33555a(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            m33557a(activity.getWindow());
        }
    }

    /* renamed from: a */
    public static void m33557a(Window window) {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
        window.setStatusBarColor(0);
    }

    /* renamed from: b */
    public static void m33561b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            m33563b(activity.getWindow());
        }
    }

    /* renamed from: b */
    public static void m33563b(Window window) {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 512 | 256);
        window.setNavigationBarColor(0);
    }

    /* renamed from: a */
    public static boolean m33559a(Activity activity, boolean z) {
        return m33560a(activity.getWindow(), z);
    }

    /* renamed from: a */
    public static boolean m33560a(Window window, boolean z) {
        if (m33566c(window, z)) {
            m33567d(window, z);
            return true;
        } else if (!m33565b(window, z)) {
            return m33567d(window, z);
        } else {
            m33567d(window, z);
            return true;
        }
    }

    /* renamed from: b */
    private static boolean m33565b(Window window, boolean z) {
        try {
            LayoutParams attributes = window.getAttributes();
            Field declaredField = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
            window.setAttributes(attributes);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m33566c(Window window, boolean z) {
        Class cls = window.getClass();
        try {
            Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            if (z) {
                method.invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
            } else {
                method.invoke(window, new Object[]{Integer.valueOf(0), Integer.valueOf(i)});
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m33567d(Window window, boolean z) {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        View decorView = window.getDecorView();
        if (z) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        } else {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -8193);
        }
        return true;
    }
}
