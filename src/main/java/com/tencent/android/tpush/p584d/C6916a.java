package com.tencent.android.tpush.p584d;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.d.a */
public class C6916a {
    /* renamed from: a */
    private static final String[] f22995a = {"com.tencent.android.tpush.otherpush.mipush.impl.OtherPushImpl", "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl"};
    /* renamed from: b */
    private static int f22996b = -2;
    /* renamed from: c */
    private static String f22997c = null;

    /* renamed from: a */
    public static boolean m29535a(Context context) {
        boolean z = false;
        if (f22996b == -2) {
            int i = 0;
            while (true) {
                String[] strArr = f22995a;
                if (i >= strArr.length) {
                    f22996b = -1;
                    break;
                }
                try {
                    Class.forName(strArr[i]);
                    if (m29536a(context, f22995a[i])) {
                        f22996b = i;
                        f22997c = f22995a[i];
                        return true;
                    }
                    i++;
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        if (f22996b > -1) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m29536a(Context context, String str) {
        boolean z;
        String str2 = Constants.OTHER_PUSH_TAG;
        boolean z2 = false;
        try {
            Class cls = Class.forName(str);
            z2 = ((Boolean) cls.getMethod("checkDevice", new Class[]{Context.class}).invoke(cls, new Object[]{context})).booleanValue();
            return z2;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            StringBuilder sb = new StringBuilder();
            sb.append("checkDevice Error for InvocationTargetException: ");
            sb.append(cause.getMessage());
            C6864a.m29309j(str2, sb.toString());
            cause.printStackTrace();
            return z;
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkDevice Error, are you import otherpush package? ");
            sb2.append(e2);
            C6864a.m29309j(str2, sb2.toString());
            return z2;
        }
    }

    /* renamed from: b */
    public static void m29537b(Context context, String str) {
        m29534a(context, str, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
    }

    /* renamed from: a */
    private static void m29534a(Context context, String str, String str2) {
        try {
            Class cls = Class.forName(str2);
            cls.getMethod("setAppid", new Class[]{Context.class, String.class}).invoke(cls, new Object[]{context, str});
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("setAppid Error, are you import otherpush package? ");
            sb.append(e);
            C6864a.m29307h(Constants.OTHER_PUSH_TAG, sb.toString());
        }
    }
}
