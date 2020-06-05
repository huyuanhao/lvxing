package com.ali.auth.third.core.util;

import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p033j.C1018a;
import com.tencent.android.tpush.SettingsContentProvider;

/* renamed from: com.ali.auth.third.core.util.f */
public class C1041f {
    /* renamed from: a */
    public static int m2003a(Context context, String str, String str2) {
        String packageName = !TextUtils.isEmpty(C0989a.f1897l) ? C0989a.f1897l : context.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append("resources = ");
        sb.append(C0989a.f1898m);
        sb.append(" packageName = ");
        sb.append(C0989a.f1897l);
        C1018a.m1959a("resources", sb.toString());
        return (C0989a.f1898m != null ? C0989a.f1898m : context.getResources()).getIdentifier(str2, str, packageName);
    }

    /* renamed from: a */
    public static String m2004a(Context context, String str) {
        return (C0989a.f1898m != null ? C0989a.f1898m : context.getResources()).getString(m2003a(context, SettingsContentProvider.STRING_TYPE, str));
    }

    /* renamed from: a */
    public static String m2005a(String str) {
        return m2004a(C0989a.m1887c(), str);
    }

    /* renamed from: b */
    public static float m2006b(Context context, String str) {
        return (C0989a.f1898m != null ? C0989a.f1898m : context.getResources()).getDimension(m2003a(context, "dimen", str));
    }
}
