package com.tencent.android.tpush.common;

import android.content.Context;
import com.tencent.android.tpush.encrypt.C6931a;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.cache.C6999a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.g */
public class C6907g {
    /* renamed from: a */
    private static String m29476a(String str) {
        return C6931a.m29598a(str);
    }

    /* renamed from: a */
    public static boolean m29478a(Context context, String str, String str2, boolean z) {
        if (z) {
            try {
                String str3 = (String) C6999a.m29930a(str);
                if (str3 != null && str2 != null && str3.equals(str2)) {
                    return true;
                }
                C6999a.m29931a(str, str2);
            } catch (Exception e) {
                C6864a.m29302d("PushMd5Pref", "putString", e);
                return false;
            }
        }
        C6908h.m29487b(context, m29476a(str), str2);
        return true;
    }

    /* renamed from: a */
    public static String m29475a(Context context, String str, boolean z) {
        if (!z) {
            return C6908h.m29483a(context, m29476a(str), (String) null);
        }
        try {
            String str2 = (String) C6999a.m29930a(str);
            if (str2 == null) {
                str2 = C6908h.m29483a(context, m29476a(str), (String) null);
                C6999a.m29931a(str, str2);
            }
            return str2;
        } catch (Exception e) {
            C6864a.m29302d("PushMd5Pref", "getString", e);
            return "";
        }
    }

    /* renamed from: a */
    public static boolean m29477a(Context context, String str, int i) {
        try {
            C6908h.m29485b(context, m29476a(str), i);
            return true;
        } catch (Exception e) {
            C6864a.m29302d("PushMd5Pref", "putInt", e);
            return false;
        }
    }

    /* renamed from: b */
    public static int m29479b(Context context, String str, int i) {
        try {
            return C6908h.m29480a(context, m29476a(str), i);
        } catch (Exception e) {
            C6864a.m29302d("PushMd5Pref", "getInt", e);
            return 0;
        }
    }
}
