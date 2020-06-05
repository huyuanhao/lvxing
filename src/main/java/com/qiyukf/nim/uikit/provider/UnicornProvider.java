package com.qiyukf.nim.uikit.provider;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.content.FileProvider;
import com.qiyukf.basesdk.p393a.C5264a;
import java.io.File;

public class UnicornProvider extends FileProvider {
    /* renamed from: a */
    public static Uri m22378a(Context context, File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".unicorn.fileprovider");
        return getUriForFile(context, sb.toString(), file);
    }

    /* renamed from: a */
    public static boolean m22379a(Context context) {
        if (VERSION.SDK_INT >= 24) {
            try {
                return context.getPackageManager().getProviderInfo(new ComponentName(context, UnicornProvider.class), 128) != null;
            } catch (NameNotFoundException e) {
                C5264a.m21621b("UnicornProvider", "useFileProvider is error", e);
            }
        }
        return false;
    }
}
