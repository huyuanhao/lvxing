package com.bytedance.tea.crash.p221g;

import android.content.Context;
import java.io.File;

/* renamed from: com.bytedance.tea.crash.g.h */
public class LogPath {
    /* renamed from: a */
    public static File m12539a(Context context) {
        return new File(m12543c(context), "CrashLogJava");
    }

    /* renamed from: b */
    public static File m12541b(Context context) {
        return new File(m12543c(context), "crash_history");
    }

    /* renamed from: a */
    public static String m12540a() {
        return String.format("java_%s.npth", new Object[]{String.valueOf(System.nanoTime())});
    }

    /* renamed from: b */
    public static String m12542b() {
        return String.format("anr_%s.npth", new Object[]{String.valueOf(System.nanoTime())});
    }

    /* renamed from: c */
    private static String m12543c(Context context) {
        String str;
        try {
            if (context.getFilesDir() != null) {
                str = context.getFilesDir().getPath();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("/data/data/");
                sb.append(context.getPackageName());
                sb.append("/files/");
                File dir = context.getDir(sb.toString(), 0);
                str = dir != null ? dir.getPath() : null;
            }
            if (str != null) {
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/sdcard/";
    }
}
