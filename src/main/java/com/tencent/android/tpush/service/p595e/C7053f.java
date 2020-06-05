package com.tencent.android.tpush.service.p595e;

import android.content.Context;
import com.tencent.android.tpush.encrypt.C6931a;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.f */
public class C7053f {
    /* renamed from: a */
    private static String m30152a(String str) {
        return C6931a.m29598a(str);
    }

    /* renamed from: a */
    public static boolean m30155a(Context context, String str, String str2) {
        try {
            C7054g.m30165b(context, m30152a(str), str2);
            return true;
        } catch (Exception e) {
            C6864a.m29302d("ServicePushInfoMd5Pref", "putString", e);
            return false;
        }
    }

    /* renamed from: a */
    public static String m30151a(Context context, String str) {
        try {
            return C7054g.m30161a(context, m30152a(str), (String) null);
        } catch (Exception e) {
            C6864a.m29302d("ServicePushInfoMd5Pref", "getString", e);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m30154a(Context context, String str, long j) {
        try {
            C7054g.m30164b(context, m30152a(str), j);
        } catch (Exception e) {
            C6864a.m29302d("ServicePushInfoMd5Pref", "putLong", e);
        }
        return false;
    }

    /* renamed from: b */
    public static long m30157b(Context context, String str, long j) {
        try {
            return C7054g.m30159a(context, m30152a(str), j);
        } catch (Exception e) {
            C6864a.m29302d("ServicePushInfoMd5Pref", "getLong", e);
            return 0;
        }
    }

    /* renamed from: a */
    public static boolean m30153a(Context context, String str, int i) {
        try {
            C7054g.m30163b(context, m30152a(str), i);
            return true;
        } catch (Exception e) {
            C6864a.m29302d("ServicePushInfoMd5Pref", "putInt", e);
            return false;
        }
    }

    /* renamed from: b */
    public static int m30156b(Context context, String str, int i) {
        try {
            return C7054g.m30158a(context, m30152a(str), i);
        } catch (Exception e) {
            C6864a.m29302d("ServicePushInfoMd5Pref", "getInt", e);
            return 0;
        }
    }
}
