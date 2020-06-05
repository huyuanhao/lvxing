package com.ksad.download;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.content.FileProvider;
import java.io.File;

/* renamed from: com.ksad.download.g */
public class C3614g {
    /* renamed from: a */
    public static PendingIntent m15077a(DownloadTask downloadTask) {
        File file = new File(downloadTask.getTargetFilePath());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.addFlags(3);
        Context a = C3603b.m15023a();
        Uri a2 = m15078a(a, file);
        intent.setDataAndType(a2, "application/vnd.android.package-archive");
        for (ResolveInfo resolveInfo : a.getPackageManager().queryIntentActivities(intent, 65536)) {
            a.grantUriPermission(resolveInfo.activityInfo.packageName, a2, 3);
        }
        return PendingIntent.getActivity(a, downloadTask.getId(), intent, 134217728);
    }

    /* renamed from: a */
    private static Uri m15078a(Context context, File file) {
        if (VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".adFileProvider");
        return FileProvider.getUriForFile(context, sb.toString(), file);
    }
}
