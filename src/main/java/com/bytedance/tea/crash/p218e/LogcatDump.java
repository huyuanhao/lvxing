package com.bytedance.tea.crash.p218e;

import com.bytedance.tea.crash.p221g.IoUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/* renamed from: com.bytedance.tea.crash.e.e */
public class LogcatDump {

    /* compiled from: LogcatDump */
    /* renamed from: com.bytedance.tea.crash.e.e$a */
    private static class C2585a extends Thread {
        /* renamed from: a */
        private InputStream f9332a;
        /* renamed from: b */
        private List<String> f9333b;

        C2585a(InputStream inputStream, List<String> list) {
            this.f9332a = inputStream;
            this.f9333b = list;
        }

        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f9332a));
            int i = 32768;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.startsWith("---------")) {
                        i -= readLine.getBytes("UTF-8").length;
                        if (i < 0) {
                            break;
                        }
                        this.f9333b.add(readLine);
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    IoUtil.m12535a(bufferedReader);
                    throw th;
                }
            }
            IoUtil.m12535a(bufferedReader);
        }
    }

    /* compiled from: LogcatDump */
    /* renamed from: com.bytedance.tea.crash.e.e$b */
    private static class C2586b extends Thread {
        /* renamed from: a */
        private Process f9334a;
        /* renamed from: b */
        private long f9335b;

        public C2586b(Process process, long j) {
            this.f9334a = process;
            this.f9335b = j;
        }

        public void run() {
            try {
                sleep(this.f9335b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Process process = this.f9334a;
            if (process != null) {
                process.destroy();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0061, code lost:
            if (r4 == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0063, code lost:
            r4.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0066, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x005a, code lost:
            if (r4 != null) goto L_0x0063;
     */
    /* renamed from: a */
    public static java.util.List<java.lang.String> m12458a(int r4, int r5) {
        /*
        java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
        r0.<init>()
        r1 = 4
        java.lang.String[] r1 = new java.lang.String[r1]
        r2 = 0
        java.lang.String r3 = "logcat"
        r1[r2] = r3
        r2 = 1
        java.lang.String r3 = "-t"
        r1[r2] = r3
        java.lang.String r4 = java.lang.String.valueOf(r4)
        r2 = 2
        r1[r2] = r4
        java.lang.String r4 = m12457a(r5)
        r5 = 3
        r1[r5] = r4
        r4 = 0
        java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x005d }
        java.lang.Process r4 = r5.exec(r1)     // Catch:{ all -> 0x005d }
        com.bytedance.tea.crash.e.e$a r5 = new com.bytedance.tea.crash.e.e$a     // Catch:{ all -> 0x005d }
        java.io.InputStream r1 = r4.getInputStream()     // Catch:{ all -> 0x005d }
        r5.m44307init(r1, r0)     // Catch:{ all -> 0x005d }
        r5.start()     // Catch:{ all -> 0x005d }
        com.bytedance.tea.crash.e.e$a r5 = new com.bytedance.tea.crash.e.e$a     // Catch:{ all -> 0x005d }
        java.io.InputStream r1 = r4.getErrorStream()     // Catch:{ all -> 0x005d }
        r5.m44307init(r1, r0)     // Catch:{ all -> 0x005d }
        r5.start()     // Catch:{ all -> 0x005d }
        com.bytedance.tea.crash.e.e$b r5 = new com.bytedance.tea.crash.e.e$b     // Catch:{ all -> 0x005d }
        r1 = 3000(0xbb8, double:1.482E-320)
        r5.m44308init(r4, r1)     // Catch:{ all -> 0x005d }
        r5.start()     // Catch:{ all -> 0x005d }
        int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005d }
        r3 = 26
        if (r5 < r3) goto L_0x0057
        java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005d }
        r4.waitFor(r1, r5)     // Catch:{ all -> 0x005d }
        goto L_0x005a
    L_0x0057:
        r4.waitFor()     // Catch:{ all -> 0x005d }
    L_0x005a:
        if (r4 == 0) goto L_0x0066
        goto L_0x0063
    L_0x005d:
        r5 = move-exception
        r5.printStackTrace()     // Catch:{ all -> 0x0067 }
        if (r4 == 0) goto L_0x0066
    L_0x0063:
        r4.destroy()
    L_0x0066:
        return r0
    L_0x0067:
        r5 = move-exception
        if (r4 == 0) goto L_0x006d
        r4.destroy()
    L_0x006d:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p218e.LogcatDump.m12458a(int, int):java.util.List");
    }

    /* renamed from: a */
    private static String m12457a(int i) {
        String[] strArr = {"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"};
        return (i < 0 || i >= strArr.length) ? "*:V" : strArr[i];
    }
}
