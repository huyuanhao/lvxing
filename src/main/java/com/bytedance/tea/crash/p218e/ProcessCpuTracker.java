package com.bytedance.tea.crash.p218e;

import android.os.Build.VERSION;
import android.system.Os;
import android.system.OsConstants;

/* renamed from: com.bytedance.tea.crash.e.i */
public class ProcessCpuTracker {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static long f9352a = -1;

    /* compiled from: ProcessCpuTracker */
    /* renamed from: com.bytedance.tea.crash.e.i$a */
    static class C2588a {
        /* renamed from: a */
        private static long f9353a = -1;

        /* renamed from: a */
        public static long m12478a(long j) {
            long j2 = f9353a;
            if (j2 > 0) {
                return j2;
            }
            long j3 = VERSION.SDK_INT >= 21 ? Os.sysconf(OsConstants._SC_CLK_TCK) : VERSION.SDK_INT >= 14 ? m12479a("_SC_CLK_TCK", j) : j;
            if (j3 > 0) {
                j = j3;
            }
            f9353a = j;
            return f9353a;
        }

        /* renamed from: a */
        public static long m12477a() {
            if (ProcessCpuTracker.f9352a == -1) {
                ProcessCpuTracker.f9352a = 1000 / m12480b();
            }
            return ProcessCpuTracker.f9352a;
        }

        /* renamed from: b */
        public static long m12480b() {
            return m12478a(100);
        }

        /* renamed from: a */
        private static long m12479a(String str, long j) {
            try {
                int i = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                Class cls = Class.forName("libcore.io.Libcore");
                Class cls2 = Class.forName("libcore.io.Os");
                Object obj = cls.getField("os").get(null);
                return ((Long) cls2.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)})).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return j;
            }
        }
    }
}
