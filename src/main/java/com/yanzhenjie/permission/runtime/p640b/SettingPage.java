package com.yanzhenjie.permission.runtime.p640b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import com.yanzhenjie.permission.source.C7847b;

/* renamed from: com.yanzhenjie.permission.runtime.b.b */
public class SettingPage {
    /* renamed from: a */
    private static final String f26674a = Build.MANUFACTURER.toLowerCase();
    /* renamed from: b */
    private C7847b f26675b;

    public SettingPage(C7847b bVar) {
        this.f26675b = bVar;
    }

    /* renamed from: a */
    public void mo38070a(int i) {
        Intent intent;
        if (f26674a.contains(OEM.HUAWEI)) {
            intent = m34095b(this.f26675b.mo38075a());
        } else if (f26674a.contains("xiaomi")) {
            intent = m34096c(this.f26675b.mo38075a());
        } else if (f26674a.contains("oppo")) {
            intent = m34098e(this.f26675b.mo38075a());
        } else if (f26674a.contains("vivo")) {
            intent = m34097d(this.f26675b.mo38075a());
        } else if (f26674a.contains("meizu")) {
            intent = m34099f(this.f26675b.mo38075a());
        } else {
            intent = m34093a(this.f26675b.mo38075a());
        }
        try {
            this.f26675b.mo38077a(intent, i);
        } catch (Exception unused) {
            this.f26675b.mo38077a(m34093a(this.f26675b.mo38075a()), i);
        }
    }

    /* renamed from: a */
    private static Intent m34093a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m34095b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m34094a(context, intent)) {
            return intent;
        }
        return m34093a(context);
    }

    /* renamed from: c */
    private static Intent m34096c(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m34094a(context, intent)) {
            return intent;
        }
        String str = "com.miui.securitycenter";
        intent.setClassName(str, "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m34094a(context, intent)) {
            return intent;
        }
        intent.setClassName(str, "com.miui.permcenter.permissions.PermissionsEditorActivity");
        if (m34094a(context, intent)) {
            return intent;
        }
        return m34093a(context);
    }

    /* renamed from: d */
    private static Intent m34097d(Context context) {
        Intent intent = new Intent();
        intent.putExtra(C7887a.f26868th, context.getPackageName());
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        if (m34094a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m34094a(context, intent)) {
            return intent;
        }
        return m34093a(context);
    }

    /* renamed from: e */
    private static Intent m34098e(Context context) {
        Intent intent = new Intent();
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        if (m34094a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m34094a(context, intent)) {
            return intent;
        }
        return m34093a(context);
    }

    /* renamed from: f */
    private static Intent m34099f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m34094a(context, intent)) {
            return intent;
        }
        return m34093a(context);
    }

    /* renamed from: a */
    private static boolean m34094a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
