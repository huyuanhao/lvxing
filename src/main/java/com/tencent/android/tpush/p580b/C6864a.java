package com.tencent.android.tpush.p580b;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushMsg;
import com.tencent.android.tpush.service.p595e.C7049b;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.b.a */
public class C6864a {
    /* renamed from: a */
    public static boolean f22835a = false;
    /* renamed from: b */
    public static String f22836b = null;
    /* renamed from: c */
    protected static volatile ExecutorService f22837c = Executors.newSingleThreadExecutor(new C6866a());
    /* renamed from: d */
    public static AtomicInteger f22838d = new AtomicInteger();
    /* renamed from: e */
    public static AtomicInteger f22839e = new AtomicInteger();
    /* renamed from: f */
    public static AtomicInteger f22840f = new AtomicInteger();
    /* renamed from: g */
    public static AtomicInteger f22841g = new AtomicInteger();
    /* renamed from: h */
    public static AtomicInteger f22842h = new AtomicInteger();
    /* renamed from: i */
    public static AtomicInteger f22843i = new AtomicInteger();
    /* renamed from: j */
    public static AtomicInteger f22844j = new AtomicInteger();
    /* renamed from: k */
    public static AtomicInteger f22845k = new AtomicInteger();
    /* renamed from: l */
    public static AtomicInteger f22846l = new AtomicInteger();
    /* renamed from: m */
    public static AtomicInteger f22847m = new AtomicInteger();
    /* renamed from: n */
    public static AtomicInteger f22848n = new AtomicInteger();
    /* renamed from: o */
    private static boolean f22849o = false;
    /* renamed from: p */
    private static final SimpleDateFormat f22850p = new SimpleDateFormat("MM.dd_HH:mm:ss_SSS");
    /* renamed from: q */
    private static List<String> f22851q = Collections.synchronizedList(new ArrayList());
    /* renamed from: r */
    private static boolean f22852r = false;
    /* renamed from: s */
    private static boolean f22853s = false;
    /* renamed from: t */
    private static String f22854t = null;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.b.a$a */
    public static class C6866a implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(10);
            return thread;
        }
    }

    /* renamed from: a */
    public static boolean m29290a(Context context) {
        return true;
    }

    /* renamed from: b */
    private static boolean m29295b(int i) {
        return true;
    }

    /* renamed from: a */
    public static void m29282a(int i) {
        if (i == 0) {
            f22835a = true;
        } else if (i == 1) {
            f22849o = true;
        } else if (i == 2) {
            f22849o = true;
            f22835a = true;
        } else if (i != 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("TLogger ->setLogToFile unknown cmd ");
            sb.append(i);
            Log.e("XGLogger", sb.toString());
        } else {
            f22849o = false;
            f22835a = false;
        }
    }

    /* renamed from: a */
    public static void m29286a(String str, String str2) {
        if (f22835a && m29295b(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.v("XINGE", sb.toString());
        }
        m29287a("TRACE", str, str2, null);
    }

    /* renamed from: b */
    public static void m29293b(String str, String str2) {
        if (m29295b(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.v("XINGE", sb.toString());
        }
        m29287a("TRACE", str, str2, null);
    }

    /* renamed from: c */
    public static void m29298c(String str, String str2) {
        if (f22835a && m29295b(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.d("XINGE", sb.toString());
        }
        m29287a("DEBUG", str, str2, null);
    }

    /* renamed from: d */
    public static void m29301d(String str, String str2) {
        if (m29295b(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.d("XINGE", sb.toString());
        }
        m29287a("DEBUG", str, str2, null);
    }

    /* renamed from: e */
    public static void m29303e(String str, String str2) {
        if (f22835a && m29295b(4)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.i("XINGE", sb.toString());
        }
        m29287a("INFO", str, str2, null);
    }

    /* renamed from: f */
    public static void m29305f(String str, String str2) {
        if (m29295b(4)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.i("XINGE", sb.toString());
        }
        m29287a("INFO", str, str2, null);
    }

    /* renamed from: g */
    public static void m29306g(String str, String str2) {
        if (f22835a && m29295b(5)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.w("XINGE", sb.toString());
        }
        m29287a("WARN", str, str2, null);
    }

    /* renamed from: h */
    public static void m29307h(String str, String str2) {
        if (m29295b(5)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.w("XINGE", sb.toString());
        }
        m29287a("WARN", str, str2, null);
    }

    /* renamed from: i */
    public static void m29308i(String str, String str2) {
        if (f22835a && m29295b(6)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.e("XINGE", sb.toString());
        }
        m29287a("ERROR", str, str2, null);
    }

    /* renamed from: j */
    public static void m29309j(String str, String str2) {
        if (m29295b(6)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.e("XINGE", sb.toString());
        }
        m29287a("ERROR", str, str2, null);
    }

    /* renamed from: a */
    public static void m29288a(String str, String str2, Throwable th) {
        if (f22835a && m29295b(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.v("XINGE", sb.toString(), th);
        }
        m29287a("TRACE", str, str2, th);
    }

    /* renamed from: b */
    public static void m29294b(String str, String str2, Throwable th) {
        if (f22835a && m29295b(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.d("XINGE", sb.toString(), th);
        }
        m29287a("DEBUG", str, str2, th);
    }

    /* renamed from: c */
    public static void m29299c(String str, String str2, Throwable th) {
        if (f22835a && m29295b(5)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.w("XINGE", sb.toString(), th);
        }
        m29287a("WARN", str, str2, th);
    }

    /* renamed from: d */
    public static void m29302d(String str, String str2, Throwable th) {
        if (f22835a && m29295b(6)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.e("XINGE", sb.toString(), th);
        }
        m29287a("ERROR", str, str2, th);
    }

    /* renamed from: e */
    public static void m29304e(String str, String str2, Throwable th) {
        if (m29295b(6)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            Log.e("XINGE", sb.toString(), th);
        }
        m29287a("ERROR", str, str2, th);
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("tencent");
        sb.append(File.separator);
        sb.append(Constants.LogTag);
        sb.append(File.separator);
        sb.append("Logs");
        f22836b = sb.toString();
    }

    /* renamed from: a */
    private static void m29287a(String str, String str2, String str3, Throwable th) {
        String str4 = " ";
        if (f22849o || m29290a(C6973b.m29776f())) {
            String str5 = "";
            if (str2 == null || str2.trim().equals(str5)) {
                str2 = "XGLogger";
            }
            String format = f22850p.format(new Date());
            if (str3 == null) {
                str3 = str5;
            }
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str3), 256);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str2);
            sb.append("]");
            String a = C7056i.m30178a(sb.toString(), 24);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(format);
                    sb2.append(str4);
                    sb2.append(C7056i.m30178a(str, 5));
                    sb2.append(str4);
                    sb2.append(a);
                    sb2.append(str4);
                    sb2.append(readLine);
                    m29285a(sb2.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(format);
                sb3.append(str4);
                sb3.append(str);
                sb3.append(stringWriter2);
                m29285a(sb3.toString());
            }
        }
    }

    /* renamed from: a */
    private static void m29285a(String str) {
        if (!f22853s) {
            f22851q.add(str);
            if (f22851q.size() == 100) {
                List<String> list = f22851q;
                f22851q = Collections.synchronizedList(new ArrayList());
                f22852r = DeviceInfos.isSDCardMounted();
                String str2 = "XGLogger";
                if (f22852r) {
                    Log.v(str2, "have writable external storage, write log file!");
                    m29289a(list);
                } else {
                    Log.v(str2, "no writable external storage");
                }
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static String m29296c() {
        String str = f22854t;
        if (str != null) {
            return str;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            sb.append(File.separator);
            sb.append(f22836b);
            f22854t = sb.toString();
            return f22854t;
        } catch (Throwable th) {
            Log.e("XGLogger", "TLogger ->getFileNamePre", th);
            return null;
        }
    }

    /* renamed from: a */
    private static void m29289a(final List<String> list) {
        m29290a(C6973b.m29776f());
        if (f22849o) {
            try {
                f22837c.execute(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:40:0x0101 A[Catch:{ Exception -> 0x0114 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:47:0x0110 A[Catch:{ Exception -> 0x0114 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:55:0x0123 A[Catch:{ Exception -> 0x0127 }] */
                    public void run() {
                        /*
                        r10 = this;
                        java.lang.String r0 = "-"
                        java.lang.String r1 = "close file stream error"
                        java.lang.String r2 = "XGLogger"
                        r3 = 0
                        java.lang.String r4 = com.tencent.android.tpush.p580b.C6864a.m29296c()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        if (r4 != 0) goto L_0x0018
                        java.util.List r0 = r2     // Catch:{ Exception -> 0x0013 }
                        r0.clear()     // Catch:{ Exception -> 0x0013 }
                        goto L_0x0017
                    L_0x0013:
                        r0 = move-exception
                        android.util.Log.e(r2, r1, r0)
                    L_0x0017:
                        return
                    L_0x0018:
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.<init>()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r4)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r4 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r4)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r4 = "log"
                        r5.append(r4)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r4 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.<init>()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r4)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r6 = com.tencent.android.tpush.service.p595e.C7049b.m30143a()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r6)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r6 = "_1.txt"
                        r5.append(r6)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.io.File r7 = r6.getParentFile()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r7.mkdirs()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r7 = 2
                    L_0x0056:
                        boolean r8 = r6.exists()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        if (r8 == 0) goto L_0x0091
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.<init>()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r4)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r6 = com.tencent.android.tpush.service.p595e.C7049b.m30143a()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r6)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r6 = "_"
                        r5.append(r6)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r6 = ".txt"
                        r5.append(r6)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r8 = 10
                        if (r7 <= r8) goto L_0x008e
                        java.lang.String r0 = "Unexpected error here, so many existed error file."
                        android.util.Log.w(r2, r0)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        goto L_0x0091
                    L_0x008e:
                        int r7 = r7 + 1
                        goto L_0x0056
                    L_0x0091:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r0.<init>()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r4 = "Write log file: "
                        r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r4 = r6.getName()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        android.util.Log.v(r2, r0)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0105, Exception -> 0x00f4 }
                        java.util.List r3 = r2     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        java.util.Iterator r3 = r3.iterator()     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                    L_0x00b9:
                        boolean r4 = r3.hasNext()     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        if (r4 == 0) goto L_0x00da
                        java.lang.Object r4 = r3.next()     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        java.lang.String r4 = (java.lang.String) r4     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        r5.<init>()     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        r5.append(r4)     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        java.lang.String r4 = "\n"
                        r5.append(r4)     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        java.lang.String r4 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        r0.write(r4)     // Catch:{ FileNotFoundException -> 0x00ed, Exception -> 0x00e8, all -> 0x00e3 }
                        goto L_0x00b9
                    L_0x00da:
                        java.util.List r3 = r2     // Catch:{ Exception -> 0x0114 }
                        r3.clear()     // Catch:{ Exception -> 0x0114 }
                        r0.close()     // Catch:{ Exception -> 0x0114 }
                        goto L_0x0118
                    L_0x00e3:
                        r3 = move-exception
                        r9 = r3
                        r3 = r0
                        r0 = r9
                        goto L_0x011c
                    L_0x00e8:
                        r3 = move-exception
                        r9 = r3
                        r3 = r0
                        r0 = r9
                        goto L_0x00f5
                    L_0x00ed:
                        r3 = move-exception
                        r9 = r3
                        r3 = r0
                        r0 = r9
                        goto L_0x0106
                    L_0x00f2:
                        r0 = move-exception
                        goto L_0x011c
                    L_0x00f4:
                        r0 = move-exception
                    L_0x00f5:
                        java.lang.String r4 = "write logs to file error"
                        android.util.Log.e(r2, r4, r0)     // Catch:{ all -> 0x00f2 }
                        java.util.List r0 = r2     // Catch:{ Exception -> 0x0114 }
                        r0.clear()     // Catch:{ Exception -> 0x0114 }
                        if (r3 == 0) goto L_0x0118
                        r3.close()     // Catch:{ Exception -> 0x0114 }
                        goto L_0x0118
                    L_0x0105:
                        r0 = move-exception
                    L_0x0106:
                        r0.printStackTrace()     // Catch:{ all -> 0x00f2 }
                        java.util.List r0 = r2     // Catch:{ Exception -> 0x0114 }
                        r0.clear()     // Catch:{ Exception -> 0x0114 }
                        if (r3 == 0) goto L_0x0118
                        r3.close()     // Catch:{ Exception -> 0x0114 }
                        goto L_0x0118
                    L_0x0114:
                        r0 = move-exception
                        android.util.Log.e(r2, r1, r0)
                    L_0x0118:
                        com.tencent.android.tpush.p580b.C6864a.m29300d()
                        return
                    L_0x011c:
                        java.util.List r4 = r2     // Catch:{ Exception -> 0x0127 }
                        r4.clear()     // Catch:{ Exception -> 0x0127 }
                        if (r3 == 0) goto L_0x012b
                        r3.close()     // Catch:{ Exception -> 0x0127 }
                        goto L_0x012b
                    L_0x0127:
                        r3 = move-exception
                        android.util.Log.e(r2, r1, r3)
                    L_0x012b:
                        throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.p580b.C6864a.C68651.run():void");
                    }
                });
            } catch (Exception e) {
                Log.e("XGLogger", "savelog error", e);
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static void m29300d() {
        File[] listFiles;
        String str = "removeOldDebugLogFiles";
        String str2 = "XGLogger";
        try {
            String c = m29296c();
            if (c != null) {
                File file = new File(c);
                if (file.exists()) {
                    int length = c.length() + 5;
                    int length2 = C7049b.f23431a.length() + length;
                    if (file.listFiles() != null && file.listFiles().length > 0) {
                        for (File file2 : file.listFiles()) {
                            if (file2.isFile()) {
                                String absolutePath = file2.getAbsolutePath();
                                if (C7049b.m30145a(C7049b.m30144a(absolutePath.substring(length, length2)), 7)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("delete logs file ");
                                    sb.append(absolutePath);
                                    Log.d(str2, sb.toString());
                                    file2.delete();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(str2, str, th);
        }
    }

    /* renamed from: a */
    public static void m29284a(int i, List<TpnsPushClientReport> list) {
        if (f22849o) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (TpnsPushClientReport tpnsPushClientReport : list) {
                    arrayList.add(Long.valueOf(tpnsPushClientReport.msgId));
                }
            }
            if (arrayList.size() > 0) {
                m29297c(i, (List<Long>) arrayList);
            }
        }
    }

    /* renamed from: b */
    public static void m29292b(int i, List<TpnsPushMsg> list) {
        if (f22849o) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (TpnsPushMsg tpnsPushMsg : list) {
                    arrayList.add(Long.valueOf(tpnsPushMsg.msgId));
                }
            }
            if (arrayList.size() > 0) {
                m29297c(i, (List<Long>) arrayList);
            }
        }
    }

    /* renamed from: a */
    public static void m29283a(int i, long j) {
        if (f22849o) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            if (arrayList.size() > 0) {
                m29297c(i, (List<Long>) arrayList);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:51|(2:53|54)|55|56) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0190, code lost:
            if (r1 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            r1.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x01b0 */
    /* renamed from: c */
    public static synchronized void m29297c(int r6, java.util.List<java.lang.Long> r7) {
        /*
        java.lang.Class<com.tencent.android.tpush.b.a> r0 = com.tencent.android.tpush.p580b.C6864a.class
        monitor-enter(r0)
        boolean r1 = f22849o     // Catch:{ all -> 0x01b1 }
        if (r1 != 0) goto L_0x0009
        monitor-exit(r0)
        return
    L_0x0009:
        r1 = 0
        java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
        r2.<init>(r3)     // Catch:{ all -> 0x019d }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r3.<init>()     // Catch:{ all -> 0x019d }
        java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x019d }
        r3.append(r4)     // Catch:{ all -> 0x019d }
        java.lang.String r4 = "/"
        r3.append(r4)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x019d }
        switch(r6) {
            case 0: goto L_0x0123;
            case 1: goto L_0x010b;
            case 2: goto L_0x00f3;
            case 3: goto L_0x00db;
            case 4: goto L_0x00c3;
            case 5: goto L_0x00aa;
            case 6: goto L_0x0091;
            case 7: goto L_0x0078;
            case 8: goto L_0x005f;
            case 9: goto L_0x0029;
            case 10: goto L_0x0029;
            case 11: goto L_0x0046;
            case 12: goto L_0x002d;
            default: goto L_0x0029;
        }     // Catch:{ all -> 0x019d }
    L_0x0029:
        java.lang.String r6 = "XGLogger"
        goto L_0x0196
    L_0x002d:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_12notList"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22848n     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x0046:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_11unequal"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22847m     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x005f:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_8ServiceRecAckFromServer_failed"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22846l     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x0078:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_7ServiceRecAckFromServer.txt"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22845k     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x0091:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_6ServiceRecAckFromSdk3.txt"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22844j     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x00aa:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_5ServiceRecAckFromSdk2.txt"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22843i     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x00c3:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_4ServiceRecAckFromSdk1.txt"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22842h     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x00db:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_3SdkSendAckToService.txt"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22841g     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x00f3:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_2XgSdkReceiveFromXGService.txt"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22840f     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x010b:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_1ServiceAckToServer.txt"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22839e     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
        goto L_0x013a
    L_0x0123:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019d }
        r6.<init>()     // Catch:{ all -> 0x019d }
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r3 = "_0ServerSendToService.txt"
        r6.append(r3)     // Catch:{ all -> 0x019d }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019d }
        java.util.concurrent.atomic.AtomicInteger r3 = f22838d     // Catch:{ all -> 0x019d }
        int r3 = r3.getAndIncrement()     // Catch:{ all -> 0x019d }
    L_0x013a:
        java.lang.String r4 = "android.permission.WRITE_EXTERNAL_STORAGE"
        boolean r4 = com.tencent.android.tpush.common.C6906f.m29472a(r4)     // Catch:{ all -> 0x019d }
        if (r4 == 0) goto L_0x0190
        java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ all -> 0x019d }
        r5 = 1
        r4.<init>(r6, r5)     // Catch:{ all -> 0x019d }
        java.util.Iterator r6 = r7.iterator()     // Catch:{ all -> 0x018d }
    L_0x014c:
        boolean r7 = r6.hasNext()     // Catch:{ all -> 0x018d }
        if (r7 == 0) goto L_0x018b
        java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x018d }
        java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x018d }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018d }
        r1.<init>()     // Catch:{ all -> 0x018d }
        java.lang.String r5 = ""
        r1.append(r5)     // Catch:{ all -> 0x018d }
        r1.append(r3)     // Catch:{ all -> 0x018d }
        java.lang.String r5 = "\t"
        r1.append(r5)     // Catch:{ all -> 0x018d }
        java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x018d }
        r5.<init>()     // Catch:{ all -> 0x018d }
        java.lang.String r5 = r2.format(r5)     // Catch:{ all -> 0x018d }
        r1.append(r5)     // Catch:{ all -> 0x018d }
        java.lang.String r5 = "\tmsgid: "
        r1.append(r5)     // Catch:{ all -> 0x018d }
        r1.append(r7)     // Catch:{ all -> 0x018d }
        java.lang.String r7 = "\n"
        r1.append(r7)     // Catch:{ all -> 0x018d }
        java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x018d }
        r4.write(r7)     // Catch:{ all -> 0x018d }
        goto L_0x014c
    L_0x018b:
        r1 = r4
        goto L_0x0190
    L_0x018d:
        r6 = move-exception
        r1 = r4
        goto L_0x019e
    L_0x0190:
        if (r1 == 0) goto L_0x01a8
    L_0x0192:
        r1.close()     // Catch:{ IOException -> 0x01a8 }
        goto L_0x01a8
    L_0x0196:
        java.lang.String r7 = "unknown case"
        m29308i(r6, r7)     // Catch:{ all -> 0x019d }
        monitor-exit(r0)
        return
    L_0x019d:
        r6 = move-exception
    L_0x019e:
        java.lang.String r7 = "XGLogger"
        java.lang.String r2 = "writeMsgSession error"
        m29302d(r7, r2, r6)     // Catch:{ all -> 0x01aa }
        if (r1 == 0) goto L_0x01a8
        goto L_0x0192
    L_0x01a8:
        monitor-exit(r0)
        return
    L_0x01aa:
        r6 = move-exception
        if (r1 == 0) goto L_0x01b0
        r1.close()     // Catch:{ IOException -> 0x01b0 }
    L_0x01b0:
        throw r6     // Catch:{ all -> 0x01b1 }
    L_0x01b1:
        r6 = move-exception
        monitor-exit(r0)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.p580b.C6864a.m29297c(int, java.util.List):void");
    }
}
