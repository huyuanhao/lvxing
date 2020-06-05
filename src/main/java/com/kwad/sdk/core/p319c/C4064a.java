package com.kwad.sdk.core.p319c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.kwad.sdk.core.c.a */
public class C4064a {
    /* renamed from: a */
    private static final Object f13664a = new Object();
    /* renamed from: b */
    private static ConcurrentLinkedQueue<List<String>> f13665b = new ConcurrentLinkedQueue<>();
    /* renamed from: c */
    private static File f13666c;
    /* renamed from: d */
    private static String f13667d;
    /* renamed from: e */
    private static String f13668e;
    /* renamed from: f */
    private static boolean f13669f;

    /* renamed from: a */
    public static void m16860a(Context context, boolean z, File file) {
        if (z) {
            String str = "KSAdSDK_2.6.5.2";
            if (file == null) {
                Log.e(str, "LogToFile init logDir is null");
                return;
            }
            f13666c = file;
            if (f13666c.exists() || f13666c.mkdirs()) {
                StringBuilder sb = new StringBuilder();
                sb.append(Process.myPid());
                sb.append("/");
                sb.append(context.getApplicationContext().getPackageName());
                f13667d = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("-----BRAND=");
                sb2.append(Build.BRAND);
                sb2.append("--MODEL=");
                sb2.append(Build.MODEL);
                sb2.append("--VERSION=");
                sb2.append(VERSION.RELEASE);
                sb2.append("--SDK_INT=");
                sb2.append(VERSION.SDK_INT);
                sb2.append("--MANUFACTURER=");
                sb2.append(Build.MANUFACTURER);
                sb2.append("--CPU_ABI=");
                sb2.append(Build.CPU_ABI);
                sb2.append("-----\n");
                f13668e = sb2.toString();
                f13669f = true;
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("LogToFile init slogDir mkdirs fail: ");
            sb3.append(file);
            Log.e(str, sb3.toString());
        }
    }
}
