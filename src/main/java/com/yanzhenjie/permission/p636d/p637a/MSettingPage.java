package com.yanzhenjie.permission.p636d.p637a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.common.Constants;
import com.yanzhenjie.permission.source.C7847b;

/* renamed from: com.yanzhenjie.permission.d.a.b */
public class MSettingPage {
    /* renamed from: a */
    private static final String f26661a = Build.MANUFACTURER.toLowerCase();
    /* renamed from: b */
    private C7847b f26662b;

    public MSettingPage(C7847b bVar) {
        this.f26662b = bVar;
    }

    /* renamed from: a */
    public void mo38050a(int i) {
        Intent intent;
        if (f26661a.contains("meizu")) {
            intent = m34064c(this.f26662b.mo38075a());
        } else {
            intent = m34063b(this.f26662b.mo38075a());
        }
        try {
            this.f26662b.mo38077a(intent, i);
        } catch (Exception unused) {
            this.f26662b.mo38077a(m34061a(this.f26662b.mo38075a()), i);
        }
    }

    /* renamed from: a */
    private static Intent m34061a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m34063b(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        if (m34062a(context, intent)) {
            return intent;
        }
        return m34061a(context);
    }

    /* renamed from: c */
    private static Intent m34064c(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m34062a(context, intent)) {
            return intent;
        }
        return m34063b(context);
    }

    /* renamed from: a */
    private static boolean m34062a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
