package com.yanzhenjie.permission;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import com.yanzhenjie.permission.p633a.DoubleChecker;
import com.yanzhenjie.permission.p633a.PermissionChecker;
import com.yanzhenjie.permission.p635c.C7836a;
import com.yanzhenjie.permission.source.C7846a;
import com.yanzhenjie.permission.source.C7847b;
import com.yanzhenjie.permission.source.ContextSource;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.b */
public class AndPermission {
    /* renamed from: a */
    private static final PermissionChecker f26637a = new DoubleChecker();

    /* renamed from: a */
    public static String m33994a(Context context, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".andpermission.bridge");
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(".");
            sb2.append(str);
            str2 = sb2.toString();
        }
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static C7836a m33993a(Context context) {
        return new Boot(m33998b(context));
    }

    /* renamed from: a */
    public static C7836a m33992a(Activity activity) {
        return new Boot(new C7846a(activity));
    }

    /* renamed from: a */
    public static boolean m33996a(Context context, List<String> list) {
        return m33997a(m33998b(context), list);
    }

    /* renamed from: a */
    public static boolean m33995a(Activity activity, List<String> list) {
        return m33997a((C7847b) new C7846a(activity), list);
    }

    /* renamed from: a */
    private static boolean m33997a(C7847b bVar, List<String> list) {
        for (String a : list) {
            if (!bVar.mo38078a(a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static C7847b m33998b(Context context) {
        if (context instanceof Activity) {
            return new C7846a((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            return m33998b(((ContextWrapper) context).getBaseContext());
        }
        return new ContextSource(context);
    }
}
