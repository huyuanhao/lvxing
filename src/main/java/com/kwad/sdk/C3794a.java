package com.kwad.sdk;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.core.download.p323a.C4093d;
import com.kwad.sdk.core.download.p325c.C4099b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p326e.p328b.C4108b;
import com.kwad.sdk.core.p326e.p329c.C4109a;
import com.kwad.sdk.core.p326e.p329c.C4110b;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import java.io.File;

/* renamed from: com.kwad.sdk.a */
public class C3794a {
    /* renamed from: a */
    static AdDownloadProxy m15722a(Context context, AdInstallProxy adInstallProxy, boolean z) {
        try {
            return C4093d.m16998a(context, m15724a(context), adInstallProxy, z);
        } catch (Throwable th) {
            C4065b.m16865a(th);
            return null;
        }
    }

    /* renamed from: a */
    static AdHttpProxy m15723a() {
        try {
            return C4108b.m17066a() != null ? new C4110b() : new C4109a();
        } catch (Throwable unused) {
            return new C4109a();
        }
    }

    /* renamed from: a */
    public static File m15724a(Context context) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        String str2 = null;
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                str2 = externalFilesDir.getPath();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getCacheDir().getPath();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(File.separator);
        sb.append("Download");
        return new File(sb.toString());
    }

    /* renamed from: b */
    static AdInstallProxy m15725b() {
        return new C4099b();
    }

    /* renamed from: b */
    public static File m15726b(Context context) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        String str2 = null;
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                str2 = externalCacheDir.getPath();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getCacheDir().getPath();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(File.separator);
        sb.append("ksadsdk");
        return new File(sb.toString());
    }

    /* renamed from: c */
    public static File m15727c(Context context) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        String str2 = null;
        if ("mounted".equals(str)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                str2 = externalFilesDir.getPath();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getCacheDir().getPath();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(File.separator);
        sb.append("ksadlog");
        return new File(sb.toString());
    }
}
