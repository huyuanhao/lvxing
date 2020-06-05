package com.yanzhenjie.permission.p636d.p637a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import com.yanzhenjie.permission.source.C7847b;

/* renamed from: com.yanzhenjie.permission.d.a.a */
public class LSettingPage {
    /* renamed from: a */
    private static final String f26659a = Build.MANUFACTURER.toLowerCase();
    /* renamed from: b */
    private C7847b f26660b;

    public LSettingPage(C7847b bVar) {
        this.f26660b = bVar;
    }

    /* renamed from: a */
    public void mo38049a(int i) {
        Intent intent;
        if (f26659a.contains(OEM.HUAWEI)) {
            intent = m34055b(this.f26660b.mo38075a());
        } else if (f26659a.contains("xiaomi")) {
            intent = m34056c(this.f26660b.mo38075a());
        } else if (f26659a.contains("oppo")) {
            intent = m34057d(this.f26660b.mo38075a());
        } else if (f26659a.contains("vivo")) {
            intent = m34058e(this.f26660b.mo38075a());
        } else if (f26659a.contains("meizu")) {
            intent = m34059f(this.f26660b.mo38075a());
        } else {
            intent = m34053a(this.f26660b.mo38075a());
        }
        try {
            this.f26660b.mo38077a(intent, i);
        } catch (Exception unused) {
            this.f26660b.mo38077a(m34053a(this.f26660b.mo38075a()), i);
        }
    }

    /* renamed from: a */
    private static Intent m34053a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    /* renamed from: b */
    private Intent m34055b(Context context) {
        Intent intent = new Intent();
        String str = "package";
        intent.putExtra(str, context.getPackageName());
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setData(Uri.fromParts(str, context.getPackageName(), null));
        String str2 = "com.huawei.systemmanager";
        intent.setClassName(str2, "com.huawei.permissionmanager.ui.MainActivity");
        if (m34054a(context, intent)) {
            return intent;
        }
        intent.setClassName(str2, "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        if (m34054a(context, intent)) {
            return intent;
        }
        intent.setClassName(str2, "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        if (m34054a(context, intent)) {
            return intent;
        }
        return m34053a(context);
    }

    /* renamed from: c */
    private Intent m34056c(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m34054a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m34054a(context, intent)) {
            return intent;
        }
        return m34053a(context);
    }

    /* renamed from: d */
    private Intent m34057d(Context context) {
        Intent intent = new Intent();
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (m34054a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (m34054a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m34054a(context, intent)) {
            return intent;
        }
        return m34053a(context);
    }

    /* renamed from: e */
    private Intent m34058e(Context context) {
        Intent intent = new Intent();
        String str = "com.iqoo.secure";
        intent.setClassName(str, "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra(C7887a.f26868th, context.getPackageName());
        if (m34054a(context, intent)) {
            return intent;
        }
        intent.setClassName(str, "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m34054a(context, intent)) {
            return intent;
        }
        return m34053a(context);
    }

    /* renamed from: f */
    private Intent m34059f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        if (m34054a(context, intent)) {
            return intent;
        }
        return m34053a(context);
    }

    /* renamed from: a */
    private static boolean m34054a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
