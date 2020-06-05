package com.qiyukf.nimlib.p488k.p491c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.qiyukf.nimlib.k.c.c */
public final class C5946c {
    /* renamed from: a */
    public static String m23834a(String str, C5944b bVar) {
        String a = C5943a.m23823a().mo28376a(str, bVar);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        File parentFile = new File(a).getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return a;
    }

    /* renamed from: a */
    public static void m23835a(Context context) {
        C5943a.m23823a().mo28377a(context);
    }

    /* renamed from: a */
    public static void m23836a(File file) {
        m23837a(file, false);
    }

    /* renamed from: a */
    private static void m23837a(File file, boolean z) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        m23837a(a, false);
                    }
                }
            }
            if (file.isFile() || !z) {
                file.delete();
            }
        }
    }

    /* renamed from: a */
    public static boolean m23838a() {
        C5943a.m23823a();
        return C5943a.m23825b();
    }

    /* renamed from: a */
    public static boolean m23839a(C5944b bVar) {
        C5943a.m23823a();
        return C5943a.m23825b() && C5943a.m23823a().mo28379c() >= bVar.mo28381b();
    }

    /* renamed from: b */
    public static String m23840b() {
        String absolutePath;
        StringBuilder sb;
        String str = "/qiyu/";
        if (VERSION.SDK_INT >= 8) {
            absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            sb = new StringBuilder();
        } else {
            absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
            sb = new StringBuilder();
        }
        sb.append(absolutePath);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m23841b(C5944b bVar) {
        return C5943a.m23823a().mo28375a(bVar);
    }

    /* renamed from: b */
    public static String m23842b(String str, C5944b bVar) {
        return C5943a.m23823a().mo28378b(str, bVar);
    }

    /* renamed from: c */
    public static boolean m23843c(C5944b bVar) {
        m23837a(new File(C5943a.m23823a().mo28375a(bVar)), true);
        return true;
    }
}
