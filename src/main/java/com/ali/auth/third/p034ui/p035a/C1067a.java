package com.ali.auth.third.p034ui.p035a;

import android.app.Activity;
import android.content.Intent;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.p034ui.p036b.C1071a;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.ali.auth.third.ui.a.a */
public class C1067a {
    /* renamed from: a */
    public static volatile Object f2147a;
    /* renamed from: b */
    public static C0985c f2148b;
    /* renamed from: c */
    public static volatile WeakReference<Activity> f2149c;
    /* renamed from: d */
    private static final String f2150d = C1067a.class.getSimpleName();

    /* renamed from: a */
    public static void m2074a(Activity activity) {
        f2149c = new WeakReference<>(activity);
    }

    /* renamed from: a */
    public static boolean m2075a(int i, int i2, Intent intent) {
        return m2076a(f2149c != null ? (Activity) f2149c.get() : null, i, i2, intent);
    }

    /* renamed from: a */
    public static boolean m2076a(Activity activity, int i, int i2, Intent intent) {
        String str = f2150d;
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult requestCode=");
        sb.append(i);
        sb.append(" resultCode = ");
        sb.append(i2);
        sb.append(" authCode = ");
        sb.append(intent == null ? "" : intent.getStringExtra(ArgKey.KEY_RESULT));
        C1018a.m1964b(str, sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("requestCodeKey", String.valueOf(i));
        C1071a aVar = (C1071a) C0989a.m1883a(C1071a.class, hashMap);
        if (aVar == null) {
            String str2 = f2150d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No ActivityResultHandler handler to support the request code ");
            sb2.append(i);
            C1018a.m1959a(str2, sb2.toString());
            return false;
        } else if (activity == null) {
            String str3 = f2150d;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("No active activity is set, ignore invoke ");
            sb3.append(aVar);
            C1018a.m1967d(str3, sb3.toString());
            return false;
        } else {
            aVar.mo10423a(1, i, i2, intent, activity, null, null);
            return true;
        }
    }
}
