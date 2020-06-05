package com.p368pw.inner.base.p387d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.p368pw.inner.C5233e;
import com.tencent.mid.core.Constants;
import java.util.Calendar;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.d.e */
public class C5187e {
    /* renamed from: a */
    public static void m21369a() {
        Context applicationContext = C5233e.m21559b().getApplicationContext();
        String str = Constants.PERMISSION_READ_PHONE_STATE;
        if (!m21374b(applicationContext, str)) {
            m21370a(new String[]{str});
        }
        String str2 = Constants.PERMISSION_WRITE_EXTERNAL_STORAGE;
        if (!m21374b(applicationContext, str2)) {
            m21370a(new String[]{str2});
        }
        String str3 = "android.permission.READ_EXTERNAL_STORAGE";
        if (!m21374b(applicationContext, str3)) {
            m21370a(new String[]{str3});
        }
    }

    /* renamed from: a */
    public static void m21370a(String[] strArr) {
        if (strArr != null) {
            try {
                if (r0 > 0) {
                    for (String checkSelfPermission : strArr) {
                        if (ContextCompat.checkSelfPermission(C5233e.m21559b(), checkSelfPermission) == 0) {
                            C5205o.m21462a("req permiss result is has");
                        } else {
                            ActivityCompat.requestPermissions(C5233e.m21558a().mo26930e(), strArr, 200);
                        }
                    }
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m21371a(long j) {
        return j >= m21373b() && j <= m21375c();
    }

    /* renamed from: a */
    public static boolean m21372a(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            if ("".equals(str)) {
                return false;
            }
            return new JSONObject(C5162b.m21305a().mo26771b(str)).optJSONObject("res_status").optInt("resp_code") == 200;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static long m21373b() {
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(1), instance.get(2), instance.get(5), 0, 0, 0);
        return instance.getTime().getTime();
    }

    /* renamed from: b */
    public static boolean m21374b(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static long m21375c() {
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(1), instance.get(2), instance.get(5), 23, 59, 59);
        return instance.getTime().getTime();
    }

    /* renamed from: c */
    public static void m21376c(Context context, String str) {
        String str2 = "android.intent.category.LAUNCHER";
        String str3 = "android.intent.action.MAIN";
        if (TextUtils.isEmpty(str)) {
            C5205o.m21462a("name is null");
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                C5205o.m21462a("info is null");
                return;
            }
            Intent intent = new Intent(str3, null);
            intent.addCategory(str2);
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                String str4 = resolveInfo.activityInfo.packageName;
                String str5 = resolveInfo.activityInfo.name;
                Intent intent2 = new Intent(str3);
                intent2.addCategory(str2);
                intent2.setComponent(new ComponentName(str4, str5));
                intent2.setFlags(268435456);
                context.startActivity(intent2);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
