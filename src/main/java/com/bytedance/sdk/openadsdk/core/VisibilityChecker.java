package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.openadsdk.core.y */
public class VisibilityChecker {
    /* renamed from: a */
    private static boolean m11003a(View view, int i) {
        boolean z = false;
        if (!(view == null || view.getVisibility() != 0 || view.getParent() == null)) {
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return false;
            }
            long height = ((long) rect.height()) * ((long) rect.width());
            long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
            if (height2 > 0 && height * 100 >= ((long) i) * height2) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m11001a(Context context) throws Throwable {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        Method method = powerManager != null ? powerManager.getClass().getMethod("isScreenOn", new Class[0]) : null;
        return ((Boolean) (method != null ? method.invoke(powerManager, new Object[0]) : Boolean.valueOf(false))).booleanValue();
    }

    /* renamed from: a */
    private static boolean m11002a(View view) {
        return view != null && view.isShown();
    }

    /* renamed from: b */
    private static boolean m11006b(View view, int i) {
        return view.getWidth() >= m11007c(view, i) && view.getHeight() >= m11008d(view, i);
    }

    /* renamed from: c */
    private static int m11007c(View view, int i) {
        if (i == 3) {
            return (int) (((double) UIUtils.m12078c(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    /* renamed from: d */
    private static int m11008d(View view, int i) {
        if (i == 3) {
            return UIUtils.m12084d(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    /* renamed from: b */
    private static int m11005b(View view, int i, int i2) throws Throwable {
        if (!m11001a(view.getContext())) {
            return 4;
        }
        if (!m11002a(view)) {
            return 1;
        }
        if (!m11006b(view, i2)) {
            return 6;
        }
        return !m11003a(view, i) ? 3 : 0;
    }

    /* renamed from: a */
    public static boolean m11004a(View view, int i, int i2) {
        try {
            return m11005b(view, i, i2) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
