package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.bytedance.sdk.adnet.core.r */
public class VNetLog {
    /* renamed from: a */
    public static boolean f6301a = Log.isLoggable(f6302b, 2);
    /* renamed from: b */
    private static String f6302b = "VNetLog";

    /* compiled from: VNetLog */
    /* renamed from: com.bytedance.sdk.adnet.core.r$a */
    static class C1984a {
        /* renamed from: a */
        public static final boolean f6303a = VNetLog.f6301a;
        /* renamed from: b */
        private final List<C1985a> f6304b = new ArrayList();
        /* renamed from: c */
        private boolean f6305c = false;

        /* compiled from: VNetLog */
        /* renamed from: com.bytedance.sdk.adnet.core.r$a$a */
        private static class C1985a {
            /* renamed from: a */
            public final String f6306a;
            /* renamed from: b */
            public final long f6307b;
            /* renamed from: c */
            public final long f6308c;

            public C1985a(String str, long j, long j2) {
                this.f6306a = str;
                this.f6307b = j;
                this.f6308c = j2;
            }
        }

        C1984a() {
        }

        /* renamed from: a */
        public synchronized void mo14377a(String str, long j) {
            if (!this.f6305c) {
                List<C1985a> list = this.f6304b;
                C1985a aVar = new C1985a(str, j, SystemClock.elapsedRealtime());
                list.add(aVar);
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        /* renamed from: a */
        public synchronized void mo14376a(String str) {
            this.f6305c = true;
            long a = m7932a();
            if (a > 0) {
                long j = ((C1985a) this.f6304b.get(0)).f6308c;
                VNetLog.m7928b("(%-4d ms) %s", Long.valueOf(a), str);
                for (C1985a aVar : this.f6304b) {
                    long j2 = aVar.f6308c;
                    VNetLog.m7928b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(aVar.f6307b), aVar.f6306a);
                    j = j2;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.f6305c) {
                mo14376a("Request on the loose");
                VNetLog.m7929c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        /* renamed from: a */
        private long m7932a() {
            if (this.f6304b.size() == 0) {
                return 0;
            }
            long j = ((C1985a) this.f6304b.get(0)).f6308c;
            List<C1985a> list = this.f6304b;
            return ((C1985a) list.get(list.size() - 1)).f6308c - j;
        }
    }

    /* renamed from: a */
    public static void m7926a(String str, Object... objArr) {
        if (f6301a) {
            Log.v(f6302b, m7931e(str, objArr));
        }
    }

    /* renamed from: b */
    public static void m7928b(String str, Object... objArr) {
        Log.d(f6302b, m7931e(str, objArr));
    }

    /* renamed from: c */
    public static void m7929c(String str, Object... objArr) {
        Log.e(f6302b, m7931e(str, objArr));
    }

    /* renamed from: a */
    public static void m7927a(Throwable th, String str, Object... objArr) {
        Log.e(f6302b, m7931e(str, objArr), th);
    }

    /* renamed from: d */
    public static void m7930d(String str, Object... objArr) {
        Log.wtf(f6302b, m7931e(str, objArr));
    }

    /* renamed from: e */
    private static String m7931e(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals("com.bytedance.sdk.adnet.VNetLog")) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                StringBuilder sb = new StringBuilder();
                sb.append(substring2);
                sb.append(".");
                sb.append(stackTrace[i].getMethodName());
                str2 = sb.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
