package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C7174a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ap */
public class C7228ap {
    /* renamed from: a */
    public static boolean f24399a = true;
    /* renamed from: b */
    private static SimpleDateFormat f24400b = null;
    /* renamed from: c */
    private static int f24401c = 5120;
    /* renamed from: d */
    private static StringBuilder f24402d = null;
    /* renamed from: e */
    private static StringBuilder f24403e = null;
    /* renamed from: f */
    private static boolean f24404f = false;
    /* renamed from: g */
    private static C7231a f24405g = null;
    /* renamed from: h */
    private static String f24406h = null;
    /* renamed from: i */
    private static String f24407i = null;
    /* renamed from: j */
    private static Context f24408j = null;
    /* renamed from: k */
    private static String f24409k = null;
    /* renamed from: l */
    private static boolean f24410l = false;
    /* renamed from: m */
    private static boolean f24411m = false;
    /* renamed from: n */
    private static ExecutorService f24412n;
    /* renamed from: o */
    private static int f24413o;
    /* renamed from: p */
    private static final Object f24414p = new Object();

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ap$a */
    public static class C7231a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean f24421a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public File f24422b;
        /* renamed from: c */
        private String f24423c;
        /* renamed from: d */
        private long f24424d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public long f24425e = 30720;

        public C7231a(String str) {
            if (str != null && !str.equals("")) {
                this.f24423c = str;
                this.f24421a = m31167a();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m31167a() {
            try {
                this.f24422b = new File(this.f24423c);
                if (this.f24422b.exists() && !this.f24422b.delete()) {
                    this.f24421a = false;
                    return false;
                } else if (this.f24422b.createNewFile()) {
                    return true;
                } else {
                    this.f24421a = false;
                    return false;
                }
            } catch (Throwable th) {
                C7226an.m31142a(th);
                this.f24421a = false;
                return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0036 A[SYNTHETIC, Splitter:B:19:0x0036] */
        /* renamed from: a */
        public boolean mo34839a(java.lang.String r10) {
            /*
            r9 = this;
            boolean r0 = r9.f24421a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x002d }
            java.io.File r3 = r9.f24422b     // Catch:{ all -> 0x002d }
            r4 = 1
            r2.<init>(r3, r4)     // Catch:{ all -> 0x002d }
            java.lang.String r0 = "UTF-8"
            byte[] r10 = r10.getBytes(r0)     // Catch:{ all -> 0x002b }
            r2.write(r10)     // Catch:{ all -> 0x002b }
            r2.flush()     // Catch:{ all -> 0x002b }
            r2.close()     // Catch:{ all -> 0x002b }
            long r5 = r9.f24424d     // Catch:{ all -> 0x002b }
            int r10 = r10.length     // Catch:{ all -> 0x002b }
            long r7 = (long) r10     // Catch:{ all -> 0x002b }
            long r5 = r5 + r7
            r9.f24424d = r5     // Catch:{ all -> 0x002b }
            r9.f24421a = r4     // Catch:{ all -> 0x002b }
            r2.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            return r4
        L_0x002b:
            r10 = move-exception
            goto L_0x002f
        L_0x002d:
            r10 = move-exception
            r2 = r0
        L_0x002f:
            com.tencent.bugly.proguard.C7226an.m31142a(r10)     // Catch:{ all -> 0x003a }
            r9.f24421a = r1     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0039
            r2.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            return r1
        L_0x003a:
            r10 = move-exception
            if (r2 == 0) goto L_0x0040
            r2.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7228ap.C7231a.mo34839a(java.lang.String):boolean");
        }
    }

    static {
        try {
            f24400b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static boolean m31164d(String str, String str2, String str3) {
        try {
            C7174a b = C7174a.m30754b();
            if (!(b == null || b.f23975M == null)) {
                return b.f23975M.appendLogToNative(str, str2, str3);
            }
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: b */
    private static String m31161b() {
        try {
            C7174a b = C7174a.m30754b();
            if (!(b == null || b.f23975M == null)) {
                return b.f23975M.getLogFromNative();
            }
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m31156a(android.content.Context r3) {
        /*
        java.lang.Class<com.tencent.bugly.proguard.ap> r0 = com.tencent.bugly.proguard.C7228ap.class
        monitor-enter(r0)
        boolean r1 = f24410l     // Catch:{ all -> 0x0077 }
        if (r1 != 0) goto L_0x0075
        if (r3 == 0) goto L_0x0075
        boolean r1 = f24399a     // Catch:{ all -> 0x0077 }
        if (r1 != 0) goto L_0x000e
        goto L_0x0075
    L_0x000e:
        java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newSingleThreadExecutor()     // Catch:{ all -> 0x0070 }
        f24412n = r1     // Catch:{ all -> 0x0070 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
        r2 = 0
        r1.<init>(r2)     // Catch:{ all -> 0x0070 }
        f24403e = r1     // Catch:{ all -> 0x0070 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
        r1.<init>(r2)     // Catch:{ all -> 0x0070 }
        f24402d = r1     // Catch:{ all -> 0x0070 }
        f24408j = r3     // Catch:{ all -> 0x0070 }
        com.tencent.bugly.crashreport.common.info.a r3 = com.tencent.bugly.crashreport.common.info.C7174a.m30753a(r3)     // Catch:{ all -> 0x0070 }
        java.lang.String r1 = r3.f24024e     // Catch:{ all -> 0x0070 }
        f24406h = r1     // Catch:{ all -> 0x0070 }
        r3.getClass()     // Catch:{ all -> 0x0070 }
        java.lang.String r3 = ""
        f24407i = r3     // Catch:{ all -> 0x0070 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
        r3.<init>()     // Catch:{ all -> 0x0070 }
        android.content.Context r1 = f24408j     // Catch:{ all -> 0x0070 }
        java.io.File r1 = r1.getFilesDir()     // Catch:{ all -> 0x0070 }
        java.lang.String r1 = r1.getPath()     // Catch:{ all -> 0x0070 }
        r3.append(r1)     // Catch:{ all -> 0x0070 }
        java.lang.String r1 = "/"
        r3.append(r1)     // Catch:{ all -> 0x0070 }
        java.lang.String r1 = "buglylog_"
        r3.append(r1)     // Catch:{ all -> 0x0070 }
        java.lang.String r1 = f24406h     // Catch:{ all -> 0x0070 }
        r3.append(r1)     // Catch:{ all -> 0x0070 }
        java.lang.String r1 = "_"
        r3.append(r1)     // Catch:{ all -> 0x0070 }
        java.lang.String r1 = f24407i     // Catch:{ all -> 0x0070 }
        r3.append(r1)     // Catch:{ all -> 0x0070 }
        java.lang.String r1 = ".txt"
        r3.append(r1)     // Catch:{ all -> 0x0070 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0070 }
        f24409k = r3     // Catch:{ all -> 0x0070 }
        int r3 = android.os.Process.myPid()     // Catch:{ all -> 0x0070 }
        f24413o = r3     // Catch:{ all -> 0x0070 }
    L_0x0070:
        r3 = 1
        f24410l = r3     // Catch:{ all -> 0x0077 }
        monitor-exit(r0)
        return
    L_0x0075:
        monitor-exit(r0)
        return
    L_0x0077:
        r3 = move-exception
        monitor-exit(r0)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7228ap.m31156a(android.content.Context):void");
    }

    /* renamed from: a */
    public static void m31155a(int i) {
        synchronized (f24414p) {
            f24401c = i;
            if (i < 0) {
                f24401c = 0;
            } else if (i > 10240) {
                f24401c = 10240;
            }
        }
    }

    /* renamed from: a */
    public static void m31159a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LogUtil] Whether can record user log into native: ");
        sb.append(z);
        C7226an.m31141a(sb.toString(), new Object[0]);
        f24411m = z;
    }

    /* renamed from: a */
    public static void m31158a(String str, String str2, Throwable th) {
        if (th != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            sb.append(10);
            sb.append(C7232aq.m31206b(th));
            m31157a(str, str2, sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m31157a(final java.lang.String r3, final java.lang.String r4, final java.lang.String r5) {
        /*
        java.lang.Class<com.tencent.bugly.proguard.ap> r0 = com.tencent.bugly.proguard.C7228ap.class
        monitor-enter(r0)
        boolean r1 = f24410l     // Catch:{ all -> 0x002e }
        if (r1 == 0) goto L_0x002c
        boolean r1 = f24399a     // Catch:{ all -> 0x002e }
        if (r1 != 0) goto L_0x000c
        goto L_0x002c
    L_0x000c:
        boolean r1 = f24411m     // Catch:{ Exception -> 0x0026 }
        if (r1 == 0) goto L_0x001b
        java.util.concurrent.ExecutorService r1 = f24412n     // Catch:{ Exception -> 0x0026 }
        com.tencent.bugly.proguard.ap$1 r2 = new com.tencent.bugly.proguard.ap$1     // Catch:{ Exception -> 0x0026 }
        r2.m52560init(r3, r4, r5)     // Catch:{ Exception -> 0x0026 }
        r1.execute(r2)     // Catch:{ Exception -> 0x0026 }
        goto L_0x002a
    L_0x001b:
        java.util.concurrent.ExecutorService r1 = f24412n     // Catch:{ Exception -> 0x0026 }
        com.tencent.bugly.proguard.ap$2 r2 = new com.tencent.bugly.proguard.ap$2     // Catch:{ Exception -> 0x0026 }
        r2.m52561init(r3, r4, r5)     // Catch:{ Exception -> 0x0026 }
        r1.execute(r2)     // Catch:{ Exception -> 0x0026 }
        goto L_0x002a
    L_0x0026:
        r3 = move-exception
        com.tencent.bugly.proguard.C7226an.m31145b(r3)     // Catch:{ all -> 0x002e }
    L_0x002a:
        monitor-exit(r0)
        return
    L_0x002c:
        monitor-exit(r0)
        return
    L_0x002e:
        r3 = move-exception
        monitor-exit(r0)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7228ap.m31157a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private|static|declared_synchronized */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:19|20|21|(1:23)(2:24|(1:28))|29|(1:31)|32|33|34|35) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0078 */
    /* renamed from: e */
    public static synchronized void m31165e(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
        java.lang.Class<com.tencent.bugly.proguard.ap> r0 = com.tencent.bugly.proguard.C7228ap.class
        monitor-enter(r0)
        int r1 = android.os.Process.myTid()     // Catch:{ all -> 0x007e }
        long r1 = (long) r1     // Catch:{ all -> 0x007e }
        java.lang.String r5 = m31154a(r5, r6, r7, r1)     // Catch:{ all -> 0x007e }
        java.lang.Object r6 = f24414p     // Catch:{ all -> 0x007e }
        monitor-enter(r6)     // Catch:{ all -> 0x007e }
        java.lang.StringBuilder r7 = f24403e     // Catch:{ all -> 0x0078 }
        r7.append(r5)     // Catch:{ all -> 0x0078 }
        java.lang.StringBuilder r5 = f24403e     // Catch:{ all -> 0x0078 }
        int r5 = r5.length()     // Catch:{ all -> 0x0078 }
        int r7 = f24401c     // Catch:{ all -> 0x0078 }
        if (r5 > r7) goto L_0x0021
        monitor-exit(r6)     // Catch:{ all -> 0x007b }
        monitor-exit(r0)
        return
    L_0x0021:
        boolean r5 = f24404f     // Catch:{ all -> 0x0078 }
        if (r5 == 0) goto L_0x0028
        monitor-exit(r6)     // Catch:{ all -> 0x007b }
        monitor-exit(r0)
        return
    L_0x0028:
        r5 = 1
        f24404f = r5     // Catch:{ all -> 0x0078 }
        com.tencent.bugly.proguard.ap$a r5 = f24405g     // Catch:{ all -> 0x0078 }
        if (r5 != 0) goto L_0x0039
        com.tencent.bugly.proguard.ap$a r5 = new com.tencent.bugly.proguard.ap$a     // Catch:{ all -> 0x0078 }
        java.lang.String r7 = f24409k     // Catch:{ all -> 0x0078 }
        r5.m52562init(r7)     // Catch:{ all -> 0x0078 }
        f24405g = r5     // Catch:{ all -> 0x0078 }
        goto L_0x0062
    L_0x0039:
        com.tencent.bugly.proguard.ap$a r5 = f24405g     // Catch:{ all -> 0x0078 }
        java.io.File r5 = r5.f24422b     // Catch:{ all -> 0x0078 }
        if (r5 == 0) goto L_0x005d
        com.tencent.bugly.proguard.ap$a r5 = f24405g     // Catch:{ all -> 0x0078 }
        java.io.File r5 = r5.f24422b     // Catch:{ all -> 0x0078 }
        long r1 = r5.length()     // Catch:{ all -> 0x0078 }
        java.lang.StringBuilder r5 = f24403e     // Catch:{ all -> 0x0078 }
        int r5 = r5.length()     // Catch:{ all -> 0x0078 }
        long r3 = (long) r5     // Catch:{ all -> 0x0078 }
        long r1 = r1 + r3
        com.tencent.bugly.proguard.ap$a r5 = f24405g     // Catch:{ all -> 0x0078 }
        long r3 = r5.f24425e     // Catch:{ all -> 0x0078 }
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 <= 0) goto L_0x0062
    L_0x005d:
        com.tencent.bugly.proguard.ap$a r5 = f24405g     // Catch:{ all -> 0x0078 }
        r5.m31167a()     // Catch:{ all -> 0x0078 }
    L_0x0062:
        com.tencent.bugly.proguard.ap$a r5 = f24405g     // Catch:{ all -> 0x0078 }
        java.lang.StringBuilder r7 = f24403e     // Catch:{ all -> 0x0078 }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0078 }
        boolean r5 = r5.mo34839a(r7)     // Catch:{ all -> 0x0078 }
        if (r5 == 0) goto L_0x0078
        java.lang.StringBuilder r5 = f24403e     // Catch:{ all -> 0x0078 }
        r7 = 0
        r5.setLength(r7)     // Catch:{ all -> 0x0078 }
        f24404f = r7     // Catch:{ all -> 0x0078 }
    L_0x0078:
        monitor-exit(r6)     // Catch:{ all -> 0x007b }
        monitor-exit(r0)
        return
    L_0x007b:
        r5 = move-exception
        monitor-exit(r6)     // Catch:{ all -> 0x007b }
        throw r5     // Catch:{ all -> 0x007e }
    L_0x007e:
        r5 = move-exception
        monitor-exit(r0)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7228ap.m31165e(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    private static String m31154a(String str, String str2, String str3, long j) {
        String str4;
        f24402d.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f24400b;
        if (simpleDateFormat != null) {
            str4 = simpleDateFormat.format(date);
        } else {
            str4 = date.toString();
        }
        StringBuilder sb = f24402d;
        sb.append(str4);
        String str5 = " ";
        sb.append(str5);
        sb.append(f24413o);
        sb.append(str5);
        sb.append(j);
        sb.append(str5);
        sb.append(str);
        sb.append(str5);
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f24402d.toString();
    }

    /* renamed from: a */
    public static byte[] m31160a() {
        if (!f24399a) {
            return null;
        }
        if (f24411m) {
            C7226an.m31141a("[LogUtil] Get user log from native.", new Object[0]);
            String b = m31161b();
            if (b != null) {
                C7226an.m31141a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(b.length()));
                return C7232aq.m31200a((File) null, b, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (f24414p) {
            if (f24405g != null && f24405g.f24421a && f24405g.f24422b != null && f24405g.f24422b.length() > 0) {
                sb.append(C7232aq.m31181a(f24405g.f24422b, 30720, true));
            }
            if (f24403e != null && f24403e.length() > 0) {
                sb.append(f24403e.toString());
            }
        }
        return C7232aq.m31200a((File) null, sb.toString(), "BuglyLog.txt");
    }
}
