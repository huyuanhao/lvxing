package com.qiyukf.basesdk.p412c.p417d;

import android.content.Context;
import android.content.res.Resources;

/* renamed from: com.qiyukf.basesdk.c.d.d */
public final class C5412d {
    /* renamed from: a */
    private static Context f17385a;

    /* renamed from: a */
    public static int m22145a() {
        return f17385a.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: a */
    public static int m22146a(float f) {
        return (int) ((f * f17385a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static void m22147a(Context context) {
        f17385a = context.getApplicationContext();
    }

    /* renamed from: b */
    public static int m22148b() {
        return f17385a.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: c */
    public static int m22149c() {
        return Math.min(m22145a(), m22148b());
    }

    /* renamed from: d */
    public static int m22150d() {
        Resources resources = f17385a.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: e */
    public static int m22151e() {
        Resources resources = f17385a.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
