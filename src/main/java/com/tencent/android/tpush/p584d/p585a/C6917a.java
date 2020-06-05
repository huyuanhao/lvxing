package com.tencent.android.tpush.p584d.p585a;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p584d.C6916a;
import com.tencent.android.tpush.p584d.C6926c;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.d.a.a */
public class C6917a extends C6926c {
    /* renamed from: a */
    public String mo33123a() {
        return "fcm";
    }

    /* renamed from: a */
    public void mo33124a(Context context) {
        String str = Constants.OTHER_PUSH_TAG;
        try {
            Class cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            cls.getMethod("registerPush", new Class[]{Context.class}).invoke(cls, new Object[]{context});
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            StringBuilder sb = new StringBuilder();
            sb.append("registerPush FCM Error for InvocationTargetException: ");
            sb.append(cause.getMessage());
            C6864a.m29309j(str, sb.toString());
            cause.printStackTrace();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("registerPush FCM Error, are you import otherpush package? ");
            sb2.append(e2);
            C6864a.m29309j(str, sb2.toString());
        }
    }

    /* renamed from: b */
    public void mo33125b(Context context) {
        try {
            Class cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            cls.getMethod("unregisterPush", new Class[]{Context.class}).invoke(cls, new Object[]{context});
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("unregisterPush FCM Error, are you import otherpush package? ");
            sb.append(e);
            C6864a.m29309j(Constants.OTHER_PUSH_TAG, sb.toString());
        }
    }

    /* renamed from: c */
    public String mo33126c(Context context) {
        String str = Constants.OTHER_PUSH_TAG;
        try {
            Class cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            Object invoke = cls.getMethod("getToken", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            if (invoke != null) {
                return invoke.toString();
            }
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            StringBuilder sb = new StringBuilder();
            sb.append("getToken Error for InvocationTargetException: ");
            sb.append(cause.getMessage());
            C6864a.m29309j(str, sb.toString());
            cause.printStackTrace();
        } catch (Exception e2) {
            C6864a.m29304e(str, "getToken Error", e2);
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo33127d(Context context) {
        String str = Constants.OTHER_PUSH_TAG;
        try {
            if (context.getResources().getAssets().open("google-services.json") == null) {
                C6864a.m29309j(str, "isConfig : no google-services.json file");
                return false;
            } else if (!C6916a.m29536a(context, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl")) {
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("isConfig :");
            sb.append(e);
            C6864a.m29309j(str, sb.toString());
            return false;
        }
    }
}
