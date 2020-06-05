package com.tencent.android.tpush.cloudctr.p582a;

import android.content.Context;
import android.os.Environment;
import com.tencent.android.tpush.cloudctr.p583b.C6889a;
import com.tencent.android.tpush.cloudctr.p583b.C6890b;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.mid.core.Constants;
import java.io.File;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.cloudctr.a.b */
public class C6888b {
    /* renamed from: a */
    private static boolean m29426a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            C6864a.m29302d("cc public storage", "checkPermission error", th);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m29424a(Context context) {
        if (m29426a(context, Constants.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m29427b(Context context) {
        if (m29426a(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static File m29428c(Context context) {
        if (!m29424a(context) || !m29427b(context)) {
            return null;
        }
        File file = new File(Environment.getExternalStorageDirectory(), ".mtacc");
        boolean exists = file.exists();
        if (exists && !file.isDirectory()) {
            file.delete();
            exists = false;
        }
        if (exists || file.mkdir()) {
        }
        return file;
    }

    /* renamed from: a */
    public static boolean m29425a(Context context, File file) {
        if (m29428c(context) == null) {
            return false;
        }
        String name = file.getName();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append(".mtacc/");
        sb.append(name);
        if (C6889a.m29429a(file, new File(externalStorageDirectory, sb.toString()))) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cache File: ");
        sb2.append(file.getName());
        sb2.append(" error");
        C6864a.m29308i("cc public storage", sb2.toString());
        return false;
    }

    /* renamed from: a */
    public static String m29423a(Context context, String str, String str2) {
        if (m29428c(context) == null) {
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append(".mtacc/");
        sb.append(str);
        File file = new File(externalStorageDirectory, sb.toString());
        if (!file.exists()) {
            return null;
        }
        if (file.isDirectory()) {
            file.delete();
            return null;
        } else if (C6890b.m29431a(str2, file)) {
            return file.getAbsolutePath();
        } else {
            file.delete();
            return null;
        }
    }
}
