package com.p530ss.android.socialbase.downloader.p561f;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: Logger */
/* renamed from: com.ss.android.socialbase.downloader.f.a */
public class C6704a {
    /* renamed from: a */
    private static int f21949a = 4;
    /* renamed from: b */
    private static C6705a f21950b;

    /* compiled from: Logger */
    /* renamed from: com.ss.android.socialbase.downloader.f.a$a */
    public static abstract class C6705a {
        /* renamed from: a */
        public void mo32088a(String str, String str2) {
        }

        /* renamed from: a */
        public void mo32089a(String str, String str2, Throwable th) {
        }

        /* renamed from: b */
        public void mo32090b(String str, String str2) {
        }

        /* renamed from: c */
        public void mo32091c(String str, String str2) {
        }
    }

    /* renamed from: a */
    public static void m27752a(int i) {
        f21949a = i;
    }

    /* renamed from: a */
    public static boolean m27756a() {
        return f21949a <= 3;
    }

    /* renamed from: a */
    public static void m27754a(String str, String str2) {
        if (str2 != null && f21949a <= 2) {
            Log.v(str, str2);
        }
    }

    /* renamed from: a */
    public static void m27753a(String str) {
        m27758b("DownloaderLogger", str);
    }

    /* renamed from: b */
    public static String m27757b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Downloader-");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    public static void m27758b(String str, String str2) {
        if (str2 != null && f21949a <= 3) {
            Log.d(m27757b(str), str2);
        }
    }

    /* renamed from: a */
    public static void m27755a(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && f21949a <= 3) {
            Log.d(m27757b(str), str2, th);
        }
    }

    /* renamed from: c */
    public static void m27760c(String str, String str2) {
        if (str2 != null) {
            if (f21949a <= 4) {
                Log.i(m27757b(str), str2);
            }
            C6705a aVar = f21950b;
            if (aVar != null) {
                aVar.mo32088a(m27757b(str), str2);
            }
        }
    }

    /* renamed from: d */
    public static void m27761d(String str, String str2) {
        if (str2 != null) {
            if (f21949a <= 5) {
                Log.w(m27757b(str), str2);
            }
            C6705a aVar = f21950b;
            if (aVar != null) {
                aVar.mo32091c(m27757b(str), str2);
            }
        }
    }

    /* renamed from: e */
    public static void m27762e(String str, String str2) {
        if (str2 != null) {
            if (f21949a <= 6) {
                Log.e(m27757b(str), str2);
            }
            C6705a aVar = f21950b;
            if (aVar != null) {
                aVar.mo32090b(m27757b(str), str2);
            }
        }
    }

    /* renamed from: b */
    public static void m27759b(String str, String str2, Throwable th) {
        if (str2 != null || th != null) {
            if (f21949a <= 6) {
                Log.e(m27757b(str), str2, th);
            }
            C6705a aVar = f21950b;
            if (aVar != null) {
                aVar.mo32089a(m27757b(str), str2, th);
            }
        }
    }
}
