package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ai */
public class C7217ai {
    /* renamed from: c */
    private static C7217ai f24337c;
    /* renamed from: a */
    protected Context f24338a;
    /* renamed from: b */
    public Map<String, String> f24339b = null;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo34803a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 307;
    }

    private C7217ai(Context context) {
        this.f24338a = context;
    }

    /* renamed from: a */
    public static C7217ai m31080a(Context context) {
        if (f24337c == null) {
            f24337c = new C7217ai(context);
        }
        return f24337c;
    }

    /* JADX INFO: unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:8:0x0045 in {} preds:[B:7:0x0019, B:19:0x0090]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.calcImmediateDominators(BlockProcessor.java:303)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:255)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:55)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: a */
    public byte[] mo34804a(java.lang.String r23, byte[] r24, com.tencent.bugly.proguard.C7223al r25, java.util.Map<java.lang.String, java.lang.String> r26) {
        /*
        r22 = this;
        r1 = r22
        r2 = r24
        r3 = r25
        r4 = 0
        r5 = 0
        if (r23 != 0) goto L_0x0012
        java.lang.Object[] r0 = new java.lang.Object[r5]
        java.lang.String r2 = "Failed for no URL."
        com.tencent.bugly.proguard.C7226an.m31149e(r2, r0)
        return r4
    L_0x0012:
        if (r2 != 0) goto L_0x0017
        r8 = 0
        goto L_0x0019
    L_0x0017:
        int r0 = r2.length
        long r8 = (long) r0
    L_0x0019:
        r0 = 4
        java.lang.Object[] r0 = new java.lang.Object[r0]
        r0[r5] = r23
        java.lang.Long r10 = java.lang.Long.valueOf(r8)
        r11 = 1
        r0[r11] = r10
        int r10 = android.os.Process.myPid()
        java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
        r12 = 2
        r0[r12] = r10
        r10 = 3
        int r13 = android.os.Process.myTid()
        java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
        r0[r10] = r13
        java.lang.String r10 = "request: %s, send: %d (pid=%d | tid=%d)"
        com.tencent.bugly.proguard.C7226an.m31147c(r10, r0)
        r14 = r23
        r0 = 0
        r10 = 0
        r13 = 0
    L_0x0045:
        if (r0 >= r11) goto L_0x01c4
        if (r10 >= r11) goto L_0x01c4
        if (r13 == 0) goto L_0x004e
        r6 = r0
        r13 = 0
        goto L_0x0080
    L_0x004e:
        int r0 = r0 + 1
        if (r0 <= r11) goto L_0x007f
        java.lang.StringBuilder r15 = new java.lang.StringBuilder
        r15.<init>()
        java.lang.String r6 = "try time: "
        r15.append(r6)
        r15.append(r0)
        java.lang.String r6 = r15.toString()
        java.lang.Object[] r7 = new java.lang.Object[r5]
        com.tencent.bugly.proguard.C7226an.m31147c(r6, r7)
        java.util.Random r6 = new java.util.Random
        long r11 = java.lang.System.currentTimeMillis()
        r6.<init>(r11)
        r11 = 10000(0x2710, float:1.4013E-41)
        int r6 = r6.nextInt(r11)
        long r11 = (long) r6
        r18 = 10000(0x2710, double:4.9407E-320)
        long r11 = r11 + r18
        android.os.SystemClock.sleep(r11)
    L_0x007f:
        r6 = r0
    L_0x0080:
        android.content.Context r0 = r1.f24338a
        java.lang.String r0 = com.tencent.bugly.crashreport.common.info.C7175b.m30828f(r0)
        if (r0 != 0) goto L_0x0093
        java.lang.Object[] r0 = new java.lang.Object[r5]
        java.lang.String r11 = "Failed to request for network not avail"
        com.tencent.bugly.proguard.C7226an.m31148d(r11, r0)
        r0 = r6
    L_0x0090:
        r11 = 1
        r12 = 2
        goto L_0x0045
    L_0x0093:
        r3.mo34829a(r14, r8, r0)
        r11 = r26
        java.net.HttpURLConnection r12 = r1.mo34802a(r14, r2, r0, r11)
        if (r12 == 0) goto L_0x01af
        int r0 = r12.getResponseCode()     // Catch:{ IOException -> 0x017f }
        r7 = 200(0xc8, float:2.8E-43)
        if (r0 != r7) goto L_0x00d1
        java.util.Map r0 = r1.m31081b(r12)     // Catch:{ IOException -> 0x00ca }
        r1.f24339b = r0     // Catch:{ IOException -> 0x00ca }
        byte[] r7 = r1.mo34805a(r12)     // Catch:{ IOException -> 0x00ca }
        if (r7 != 0) goto L_0x00b5     // Catch:{ IOException -> 0x00ca }
        r4 = 0     // Catch:{ IOException -> 0x00ca }
        goto L_0x00b7     // Catch:{ IOException -> 0x00ca }
    L_0x00b5:
        int r0 = r7.length     // Catch:{ IOException -> 0x00ca }
        long r4 = (long) r0     // Catch:{ IOException -> 0x00ca }
    L_0x00b7:
        r3.mo34827a(r4)     // Catch:{ IOException -> 0x00ca }
        r12.disconnect()     // Catch:{ all -> 0x00be }
        goto L_0x00c9
    L_0x00be:
        r0 = move-exception
        r2 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r2)
        if (r0 != 0) goto L_0x00c9
        r2.printStackTrace()
    L_0x00c9:
        return r7
    L_0x00ca:
        r0 = move-exception
        r5 = r6
        r20 = r8
    L_0x00ce:
        r15 = 1
        goto L_0x0184
    L_0x00d1:
        boolean r4 = r1.mo34803a(r0)     // Catch:{ IOException -> 0x017f }
        if (r4 == 0) goto L_0x013a
        java.lang.String r4 = "Location"
        java.lang.String r4 = r12.getHeaderField(r4)     // Catch:{ IOException -> 0x0132 }
        if (r4 != 0) goto L_0x010e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0108 }
        r4.<init>()     // Catch:{ IOException -> 0x0108 }
        java.lang.String r5 = "Failed to redirect: %d"     // Catch:{ IOException -> 0x0108 }
        r4.append(r5)     // Catch:{ IOException -> 0x0108 }
        r4.append(r0)     // Catch:{ IOException -> 0x0108 }
        java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x0108 }
        r4 = 0     // Catch:{ IOException -> 0x0108 }
        java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0108 }
        com.tencent.bugly.proguard.C7226an.m31149e(r0, r5)     // Catch:{ IOException -> 0x0108 }
        r12.disconnect()     // Catch:{ all -> 0x00fb }
    L_0x00f9:
        r2 = 0
        goto L_0x0107
    L_0x00fb:
        r0 = move-exception
        r2 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r2)
        if (r0 != 0) goto L_0x00f9
        r2.printStackTrace()
        goto L_0x00f9
    L_0x0107:
        return r2
    L_0x0108:
        r0 = move-exception
        r5 = r6
        r20 = r8
        r13 = 1
        goto L_0x00ce
    L_0x010e:
        int r10 = r10 + 1
        java.lang.String r5 = "redirect code: %d ,to:%s"
        r7 = 2
        java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0128 }
        java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0128 }
        r14 = 0     // Catch:{ IOException -> 0x0128 }
        r6[r14] = r13     // Catch:{ IOException -> 0x0128 }
        r15 = 1
        r6[r15] = r4     // Catch:{ IOException -> 0x0126 }
        com.tencent.bugly.proguard.C7226an.m31147c(r5, r6)     // Catch:{ IOException -> 0x0126 }
        r14 = r4
        r5 = 0
        r13 = 1
        goto L_0x013d
    L_0x0126:
        r0 = move-exception
        goto L_0x012d
    L_0x0128:
        r0 = move-exception
        goto L_0x012c
    L_0x012a:
        r0 = move-exception
        r7 = 2
    L_0x012c:
        r15 = 1
    L_0x012d:
        r14 = r4
        r20 = r8
        r5 = 0
        goto L_0x0138
    L_0x0132:
        r0 = move-exception
        r7 = 2
        r15 = 1
        r5 = r6
        r20 = r8
    L_0x0138:
        r13 = 1
        goto L_0x0184
    L_0x013a:
        r7 = 2
        r15 = 1
        r5 = r6
    L_0x013d:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0178 }
        r4.<init>()     // Catch:{ IOException -> 0x0178 }
        java.lang.String r6 = "response code "     // Catch:{ IOException -> 0x0178 }
        r4.append(r6)     // Catch:{ IOException -> 0x0178 }
        r4.append(r0)     // Catch:{ IOException -> 0x0178 }
        java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x0178 }
        r4 = 0     // Catch:{ IOException -> 0x0178 }
        java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0178 }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r6)     // Catch:{ IOException -> 0x0178 }
        int r0 = r12.getContentLength()     // Catch:{ IOException -> 0x0178 }
        r20 = r8
        long r7 = (long) r0
        r16 = 0
        int r0 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
        if (r0 >= 0) goto L_0x0163
        r7 = 0
    L_0x0163:
        r3.mo34827a(r7)     // Catch:{ IOException -> 0x0176 }
        r12.disconnect()     // Catch:{ all -> 0x016a }
        goto L_0x019a
    L_0x016a:
        r0 = move-exception
        r6 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r6)
        if (r0 != 0) goto L_0x019a
    L_0x0172:
        r6.printStackTrace()
        goto L_0x019a
    L_0x0176:
        r0 = move-exception
        goto L_0x0184
    L_0x0178:
        r0 = move-exception
        r20 = r8
        goto L_0x0184
    L_0x017c:
        r0 = move-exception
        r2 = r0
        goto L_0x019f
    L_0x017f:
        r0 = move-exception
        r20 = r8
        r15 = 1
        r5 = r6
    L_0x0184:
        boolean r6 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x017c }
        if (r6 != 0) goto L_0x018d     // Catch:{ all -> 0x017c }
        r0.printStackTrace()     // Catch:{ all -> 0x017c }
    L_0x018d:
        r12.disconnect()     // Catch:{ all -> 0x0191 }
        goto L_0x019a
    L_0x0191:
        r0 = move-exception
        r6 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r6)
        if (r0 != 0) goto L_0x019a
        goto L_0x0172
    L_0x019a:
        r0 = r5
        r5 = 0
        r7 = 0
        goto L_0x01bf
    L_0x019f:
        r12.disconnect()     // Catch:{ all -> 0x01a3 }
        goto L_0x01ae
    L_0x01a3:
        r0 = move-exception
        r3 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r3)
        if (r0 != 0) goto L_0x01ae
        r3.printStackTrace()
    L_0x01ae:
        throw r2
    L_0x01af:
        r20 = r8
        r15 = 1
        java.lang.Object[] r0 = new java.lang.Object[r5]
        java.lang.String r7 = "Failed to execute post."
        com.tencent.bugly.proguard.C7226an.m31147c(r7, r0)
        r7 = 0
        r3.mo34827a(r7)
        r0 = r6
    L_0x01bf:
        r8 = r20
        r4 = 0
        goto L_0x0090
    L_0x01c4:
        r2 = r4
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7217ai.mo34804a(java.lang.String, byte[], com.tencent.bugly.proguard.al, java.util.Map):byte[]");
    }

    /* renamed from: b */
    private Map<String, String> m31081b(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List list = (List) headerFields.get(str);
            if (list.size() >= 1) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003b A[Catch:{ all -> 0x0049, all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040 A[SYNTHETIC, Splitter:B:24:0x0040] */
    /* renamed from: a */
    public byte[] mo34805a(java.net.HttpURLConnection r6) {
        /*
        r5 = this;
        r0 = 0
        if (r6 != 0) goto L_0x0004
        return r0
    L_0x0004:
        java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0033 }
        java.io.InputStream r6 = r6.getInputStream()     // Catch:{ all -> 0x0033 }
        r1.<init>(r6)     // Catch:{ all -> 0x0033 }
        java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0031 }
        r6.<init>()     // Catch:{ all -> 0x0031 }
        r2 = 1024(0x400, float:1.435E-42)
        byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0031 }
    L_0x0016:
        int r3 = r1.read(r2)     // Catch:{ all -> 0x0031 }
        if (r3 <= 0) goto L_0x0021
        r4 = 0
        r6.write(r2, r4, r3)     // Catch:{ all -> 0x0031 }
        goto L_0x0016
    L_0x0021:
        r6.flush()     // Catch:{ all -> 0x0031 }
        byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x0031 }
        r1.close()     // Catch:{ all -> 0x002c }
        goto L_0x0030
    L_0x002c:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0030:
        return r6
    L_0x0031:
        r6 = move-exception
        goto L_0x0035
    L_0x0033:
        r6 = move-exception
        r1 = r0
    L_0x0035:
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x0049 }
        if (r2 != 0) goto L_0x003e
        r6.printStackTrace()     // Catch:{ all -> 0x0049 }
    L_0x003e:
        if (r1 == 0) goto L_0x0048
        r1.close()     // Catch:{ all -> 0x0044 }
        goto L_0x0048
    L_0x0044:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0048:
        return r0
    L_0x0049:
        r6 = move-exception
        if (r1 == 0) goto L_0x0054
        r1.close()     // Catch:{ all -> 0x0050 }
        goto L_0x0054
    L_0x0050:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0054:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7217ai.mo34805a(java.net.HttpURLConnection):byte[]");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo34802a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            C7226an.m31149e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection a = mo34801a(str2, str);
        if (a == null) {
            C7226an.m31149e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a.setRequestProperty("wup_version", "3.0");
            String str3 = "utf-8";
            if (map != null) {
                if (map.size() > 0) {
                    for (Entry entry : map.entrySet()) {
                        a.setRequestProperty((String) entry.getKey(), URLEncoder.encode((String) entry.getValue(), str3));
                    }
                }
            }
            a.setRequestProperty("A37", URLEncoder.encode(str2, str3));
            a.setRequestProperty("A38", URLEncoder.encode(str2, str3));
            OutputStream outputStream = a.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            C7226an.m31149e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo34801a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (C7227ao.m31151a() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(C7227ao.m31151a());
            } else if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(C7120a.MAX_USERDATA_VALUE_LENGTH);
            httpURLConnection.setReadTimeout(C7516p.f25219Cf);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
