package com.p530ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.p530ss.android.socialbase.appdownloader.NotificationPermissionHelper;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.commonbase.software.AppEntity;

/* renamed from: com.ss.android.socialbase.appdownloader.view.a */
public class NotificationPermissionRequestFragment extends Fragment {
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|12)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0012 */
    /* renamed from: a */
    public void mo31641a() {
        /*
        r2 = this;
        r0 = 1000(0x3e8, float:1.401E-42)
        android.content.Intent r1 = r2.m26960f()     // Catch:{ all -> 0x000a }
        r2.startActivityForResult(r1, r0)     // Catch:{ all -> 0x000a }
        goto L_0x0021
    L_0x000a:
        android.content.Intent r1 = r2.mo31642b()     // Catch:{ all -> 0x0012 }
        r2.startActivityForResult(r1, r0)     // Catch:{ all -> 0x0012 }
        goto L_0x0021
    L_0x0012:
        android.content.Intent r1 = r2.mo31643c()     // Catch:{ all -> 0x001a }
        r2.startActivityForResult(r1, r0)     // Catch:{ all -> 0x001a }
        goto L_0x0021
    L_0x001a:
        android.content.Intent r1 = m26958d()
        r2.startActivityForResult(r1, r0)
    L_0x0021:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.view.NotificationPermissionRequestFragment.mo31641a():void");
    }

    /* renamed from: b */
    public Intent mo31642b() {
        Context e = m26959e();
        if (e == null) {
            return null;
        }
        String packageName = e.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            boolean contains = lowerCase.contains("oppo");
            String str = Constants.FLAG_PACKAGE_NAME;
            if (contains) {
                Intent intent = new Intent();
                intent.putExtra(str, packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            } else if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra(C7887a.f26868th, packageName);
                if (VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            } else if (lowerCase.contains("meizu") && VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra(str, packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(e.getPackageName());
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sb.toString()));
    }

    /* renamed from: e */
    private Context m26959e() {
        Context B = C6694b.m27342B();
        return (B != null || getActivity() == null || getActivity().isFinishing()) ? B : getActivity().getApplicationContext();
    }

    /* renamed from: c */
    public Intent mo31643c() {
        Context e = m26959e();
        if (e == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(e.getPackageName());
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sb.toString()));
    }

    /* renamed from: f */
    private Intent m26960f() {
        Context e = m26959e();
        if (e == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = e.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = e.getApplicationInfo().uid;
        intent.putExtra(AppEntity.KEY_UID, i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    /* renamed from: d */
    public static Intent m26958d() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (NotificationPermissionHelper.m26942a()) {
            NotificationPermissionHelper.m26941a(true);
        } else {
            NotificationPermissionHelper.m26941a(false);
        }
    }
}
