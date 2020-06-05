package com.kwad.sdk.p306a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;

/* renamed from: com.kwad.sdk.a.k */
public class C3808k {
    /* renamed from: a */
    public static boolean m15786a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static void m15787b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(337641472);
                    context.startActivity(launchIntentForPackage);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public static void m15788c(Context context, String str) {
        Uri uri;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.addFlags(3);
                if (VERSION.SDK_INT >= 24) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getPackageName());
                    sb.append(".adFileProvider");
                    uri = FileProvider.getUriForFile(context, sb.toString(), file);
                } else {
                    uri = Uri.fromFile(file);
                }
                intent.setDataAndType(uri, "application/vnd.android.package-archive");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                    context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
                }
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }
}
