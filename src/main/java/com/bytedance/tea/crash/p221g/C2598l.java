package com.bytedance.tea.crash.p221g;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* compiled from: RomUtils */
/* renamed from: com.bytedance.tea.crash.g.l */
public class C2598l {
    /* renamed from: a */
    private static final CharSequence f9376a = "sony";
    /* renamed from: b */
    private static final CharSequence f9377b = "amigo";
    /* renamed from: c */
    private static final CharSequence f9378c = "funtouch";

    /* renamed from: a */
    public static String m12554a() {
        if (Device.m12521c()) {
            return m12564j();
        }
        if (Device.m12522d()) {
            return m12566l();
        }
        if (m12567m()) {
            return m12568n();
        }
        String k = m12565k();
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        if (m12559e()) {
            return m12558d();
        }
        if (m12560f()) {
            return m12561g();
        }
        if (m12557c()) {
            return m12556b();
        }
        String h = m12562h();
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        return Build.DISPLAY;
    }

    /* renamed from: b */
    public static String m12556b() {
        StringBuilder sb = new StringBuilder();
        sb.append(m12555a("ro.build.uiversion"));
        sb.append("_");
        sb.append(Build.DISPLAY);
        return sb.toString();
    }

    /* renamed from: c */
    public static boolean m12557c() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(Build.BRAND);
        String sb2 = sb.toString();
        boolean z = false;
        if (TextUtils.isEmpty(sb2)) {
            return false;
        }
        String lowerCase = sb2.toLowerCase(Locale.getDefault());
        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
            z = true;
        }
        return z;
    }

    /* renamed from: d */
    public static String m12558d() {
        StringBuilder sb = new StringBuilder();
        sb.append(m12555a("ro.vivo.os.build.display.id"));
        sb.append("_");
        sb.append(m12555a("ro.vivo.product.version"));
        return sb.toString();
    }

    /* renamed from: e */
    public static boolean m12559e() {
        String a = m12555a("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(a) && a.toLowerCase(Locale.getDefault()).contains(f9378c);
    }

    /* renamed from: f */
    public static boolean m12560f() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(f9377b);
    }

    /* renamed from: g */
    public static String m12561g() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.DISPLAY);
        sb.append("_");
        sb.append(m12555a("ro.gn.sv.version"));
        return sb.toString();
    }

    /* renamed from: h */
    public static String m12562h() {
        if (!m12563i()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("eui_");
        sb.append(m12555a("ro.letv.release.version"));
        sb.append("_");
        sb.append(Build.DISPLAY);
        return sb.toString();
    }

    /* renamed from: i */
    public static boolean m12563i() {
        return !TextUtils.isEmpty(m12555a("ro.letv.release.version"));
    }

    /* renamed from: j */
    public static String m12564j() {
        if (!Device.m12521c()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("miui_");
        sb.append(m12555a("ro.miui.ui.version.name"));
        sb.append("_");
        sb.append(VERSION.INCREMENTAL);
        return sb.toString();
    }

    /* renamed from: k */
    public static String m12565k() {
        String a = Device.m12517a();
        if (a == null || !a.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("_");
        sb.append(Build.DISPLAY);
        return sb.toString();
    }

    /* renamed from: l */
    public static String m12566l() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    /* renamed from: m */
    public static boolean m12567m() {
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            return str.toLowerCase(Locale.getDefault()).contains("oppo");
        }
        return false;
    }

    /* renamed from: n */
    public static String m12568n() {
        if (!m12567m()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("coloros_");
        sb.append(m12555a("ro.build.version.opporom"));
        sb.append("_");
        sb.append(Build.DISPLAY);
        return sb.toString();
    }

    /* renamed from: a */
    private static String m12555a(String str) {
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            StringBuilder sb = new StringBuilder();
            sb.append("getprop ");
            sb.append(str);
            Process exec = runtime.exec(sb.toString());
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader2.readLine();
                exec.destroy();
                IoUtil.m12535a(bufferedReader2);
                return str2;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                IoUtil.m12535a(bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
            IoUtil.m12535a(bufferedReader);
            return str2;
        }
    }
}
