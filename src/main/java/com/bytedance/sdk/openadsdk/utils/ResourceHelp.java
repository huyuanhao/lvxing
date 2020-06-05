package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.android.tpush.SettingsContentProvider;

/* renamed from: com.bytedance.sdk.openadsdk.utils.ab */
public final class ResourceHelp {
    /* renamed from: a */
    private static String f9109a;
    /* renamed from: b */
    private static Resources f9110b;

    /* renamed from: a */
    private static String m11930a(Context context) {
        if (f9109a == null) {
            f9109a = context.getPackageName();
        }
        return f9109a;
    }

    /* renamed from: a */
    private static int m11929a(Context context, String str, String str2) {
        if (f9110b == null) {
            f9110b = context.getResources();
        }
        return f9110b.getIdentifier(str, str2, m11930a(context));
    }

    /* renamed from: a */
    public static String m11931a(Context context, String str) {
        return context.getResources().getString(m11932b(context, str));
    }

    /* renamed from: b */
    public static int m11932b(Context context, String str) {
        return m11929a(context, str, SettingsContentProvider.STRING_TYPE);
    }

    /* renamed from: c */
    public static Drawable m11933c(Context context, String str) {
        return context.getResources().getDrawable(m11934d(context, str));
    }

    /* renamed from: d */
    public static int m11934d(Context context, String str) {
        return m11929a(context, str, "drawable");
    }

    /* renamed from: e */
    public static int m11935e(Context context, String str) {
        return m11929a(context, str, "id");
    }

    /* renamed from: f */
    public static int m11936f(Context context, String str) {
        return m11929a(context, str, "layout");
    }

    /* renamed from: g */
    public static int m11937g(Context context, String str) {
        return m11929a(context, str, "style");
    }

    /* renamed from: h */
    public static int m11938h(Context context, String str) {
        return m11929a(context, str, "dimen");
    }

    /* renamed from: i */
    public static int m11939i(Context context, String str) {
        return context.getResources().getColor(m11940j(context, str));
    }

    /* renamed from: j */
    public static int m11940j(Context context, String str) {
        return m11929a(context, str, "color");
    }

    /* renamed from: k */
    public static int m11941k(Context context, String str) {
        return m11929a(context, str, SettingsContentProvider.INT_TYPE);
    }

    /* renamed from: l */
    public static int m11942l(Context context, String str) {
        return context.getResources().getInteger(m11941k(context, str));
    }
}
