package com.bytedance.tea.crash.p221g;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.g.n */
public class Storage {
    /* renamed from: a */
    public static JSONObject m12581a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", m12584b(context));
            jSONObject.put("inner_free", m12583b());
            jSONObject.put("inner_total", m12586c());
            jSONObject.put("sdcard_app_used", m12587c(context));
            jSONObject.put("sdcard_free", m12589d());
            jSONObject.put("sdcard_total", m12590e());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static long m12584b(Context context) {
        try {
            return m12588c(context.getFilesDir().getParentFile());
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private static long m12583b() {
        try {
            return m12585b(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: c */
    private static long m12586c() {
        try {
            return m12580a(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: c */
    private static long m12587c(Context context) {
        try {
            if (m12582a()) {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    return m12588c(externalFilesDir.getParentFile());
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* renamed from: d */
    private static long m12589d() {
        try {
            if (m12582a()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* renamed from: e */
    private static long m12590e() {
        try {
            if (m12582a()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* renamed from: a */
    public static boolean m12582a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: a */
    public static long m12580a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: b */
    public static long m12585b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (VERSION.SDK_INT >= 18) {
                return statFs.getFreeBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: c */
    public static long m12588c(File file) {
        long j;
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                j = m12588c(file2);
            } else {
                j = file2.length();
            }
            j2 += j;
        }
        return j2;
    }
}
