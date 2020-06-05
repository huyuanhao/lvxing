package com.qiyukf.nim.uikit;

import android.content.Context;
import com.qiyukf.nim.uikit.session.C5516b;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;

/* renamed from: com.qiyukf.nim.uikit.b */
public final class C5433b {
    /* renamed from: a */
    private static Context f17426a;
    /* renamed from: b */
    private static String f17427b;
    /* renamed from: c */
    private static C5516b f17428c;

    /* renamed from: a */
    public static Context m22189a() {
        return f17426a;
    }

    /* renamed from: a */
    public static void m22190a(Context context, UserInfoProvider userInfoProvider) {
        f17426a = context.getApplicationContext();
        C5718b.m23017d().userInfoProvider = userInfoProvider;
        C5426a.m22176a(context);
    }

    /* renamed from: a */
    public static void m22191a(String str) {
        f17427b = str;
    }

    /* renamed from: b */
    public static String m22192b() {
        return f17427b;
    }

    /* renamed from: c */
    public static C5516b m22193c() {
        return f17428c;
    }
}
