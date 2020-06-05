package com.kwad.sdk.p306a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.android.tpush.SettingsContentProvider;

/* renamed from: com.kwad.sdk.a.l */
public class C3809l {
    /* renamed from: a */
    public static int m15789a(Context context, String str) {
        return m15790a(context, str, "id");
    }

    /* renamed from: a */
    private static int m15790a(Context context, String str, String str2) {
        return m15791a(context).getIdentifier(str, str2, m15793b(context));
    }

    /* renamed from: a */
    private static Resources m15791a(Context context) {
        return context.getResources();
    }

    /* renamed from: b */
    public static int m15792b(Context context, String str) {
        return m15790a(context, str, "layout");
    }

    /* renamed from: b */
    private static String m15793b(Context context) {
        return context.getPackageName();
    }

    /* renamed from: c */
    public static int m15794c(Context context, String str) {
        return m15790a(context, str, "dimen");
    }

    /* renamed from: d */
    public static int m15795d(Context context, String str) {
        return m15790a(context, str, "drawable");
    }

    /* renamed from: e */
    public static String m15796e(Context context, String str) {
        return m15791a(context).getString(m15790a(context, str, SettingsContentProvider.STRING_TYPE));
    }

    /* renamed from: f */
    public static Drawable m15797f(Context context, String str) {
        return m15791a(context).getDrawable(m15790a(context, str, "drawable"));
    }

    /* renamed from: g */
    public static int m15798g(Context context, String str) {
        return m15790a(context, str, "raw");
    }
}
