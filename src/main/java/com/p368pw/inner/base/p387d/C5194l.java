package com.p368pw.inner.base.p387d;

import android.os.Build.VERSION;
import java.util.List;
import java.util.Map;

/* renamed from: com.pw.inner.base.d.l */
public class C5194l {
    /* renamed from: a */
    private static volatile String f16898a;
    /* renamed from: b */
    private int f16899b;
    /* renamed from: c */
    private Map<String, List<String>> f16900c;
    /* renamed from: d */
    private String f16901d;
    /* renamed from: e */
    private boolean f16902e;
    /* renamed from: f */
    private int f16903f = 60000;
    /* renamed from: g */
    private int f16904g = 60000;
    /* renamed from: h */
    private boolean f16905h;
    /* renamed from: i */
    private boolean f16906i;
    /* renamed from: j */
    private String f16907j;
    /* renamed from: k */
    private String f16908k;

    private C5194l(String str, boolean z) {
        this.f16907j = str;
        this.f16902e = z;
    }

    /* renamed from: a */
    public static String m21428a(String str) {
        return VERSION.SDK_INT < 28 ? str : m21431b(str);
    }

    /* renamed from: a */
    public static String m21429a(String str, String str2) {
        return m21436e(str).mo26816h(str2).mo26813a();
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r5v18, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7 A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011e A[Catch:{ Exception -> 0x00d9 }, DONT_GENERATE] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: b */
    private java.lang.String m21430b() {
        /*
        r10 = this;
        java.lang.String r0 = "https://"
        java.lang.String r1 = ""
        java.lang.String r2 = r10.f16907j
        com.p368pw.inner.base.p387d.C5213t.m21486a(r2)
        java.lang.String r2 = r10.f16908k
        com.p368pw.inner.base.p387d.C5213t.m21486a(r2)
        r2 = 0
        r3 = 0
        java.lang.String r4 = r10.f16907j     // Catch:{ all -> 0x00ec }
        boolean r4 = r4.startsWith(r0)     // Catch:{ all -> 0x00ec }
        if (r4 == 0) goto L_0x001b
        com.p368pw.inner.base.p387d.p389b.C5165a.m21319a()     // Catch:{ all -> 0x00ec }
    L_0x001b:
        java.net.URL r4 = new java.net.URL     // Catch:{ all -> 0x00ec }
        java.lang.String r5 = r10.f16907j     // Catch:{ all -> 0x00ec }
        r4.<init>(r5)     // Catch:{ all -> 0x00ec }
        java.net.URLConnection r4 = r4.openConnection()     // Catch:{ all -> 0x00ec }
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x00ec }
        java.lang.String r5 = "POST"
        r4.setRequestMethod(r5)     // Catch:{ all -> 0x00e9 }
        java.lang.String r5 = "accept"
        java.lang.String r6 = "*/*"
        r4.setRequestProperty(r5, r6)     // Catch:{ all -> 0x00e9 }
        java.lang.String r5 = "connection"
        java.lang.String r6 = "Keep-Alive"
        r4.setRequestProperty(r5, r6)     // Catch:{ all -> 0x00e9 }
        java.lang.String r5 = "Content-Type"
        java.lang.String r6 = "application/json"
        r4.setRequestProperty(r5, r6)     // Catch:{ all -> 0x00e9 }
        java.lang.String r5 = "charset"
        java.lang.String r6 = "utf-8"
        r4.setRequestProperty(r5, r6)     // Catch:{ all -> 0x00e9 }
        java.lang.String r5 = "User-agent"
        java.lang.String r6 = m21435d()     // Catch:{ all -> 0x00e9 }
        r4.setRequestProperty(r5, r6)     // Catch:{ all -> 0x00e9 }
        r4.setUseCaches(r2)     // Catch:{ all -> 0x00e9 }
        r5 = 1
        r4.setDoOutput(r5)     // Catch:{ all -> 0x00e9 }
        r4.setDoInput(r5)     // Catch:{ all -> 0x00e9 }
        int r5 = r10.f16903f     // Catch:{ all -> 0x00e9 }
        r4.setReadTimeout(r5)     // Catch:{ all -> 0x00e9 }
        int r5 = r10.f16904g     // Catch:{ all -> 0x00e9 }
        r4.setConnectTimeout(r5)     // Catch:{ all -> 0x00e9 }
        int r5 = r10.f16903f     // Catch:{ all -> 0x00e9 }
        if (r5 <= 0) goto L_0x006f
        int r5 = r10.f16903f     // Catch:{ all -> 0x00e9 }
        r4.setReadTimeout(r5)     // Catch:{ all -> 0x00e9 }
    L_0x006f:
        int r5 = r10.f16904g     // Catch:{ all -> 0x00e9 }
        if (r5 <= 0) goto L_0x0078
        int r5 = r10.f16904g     // Catch:{ all -> 0x00e9 }
        r4.setConnectTimeout(r5)     // Catch:{ all -> 0x00e9 }
    L_0x0078:
        java.lang.String r5 = r10.f16908k     // Catch:{ all -> 0x00e9 }
        if (r5 == 0) goto L_0x009a
        java.lang.String r5 = r10.f16908k     // Catch:{ all -> 0x00e9 }
        java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x00e9 }
        boolean r5 = r5.equals(r1)     // Catch:{ all -> 0x00e9 }
        if (r5 != 0) goto L_0x009a
        java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ all -> 0x00e9 }
        java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ all -> 0x00e9 }
        r5.<init>(r6)     // Catch:{ all -> 0x00e9 }
        java.lang.String r6 = r10.f16908k     // Catch:{ all -> 0x00e3 }
        r5.print(r6)     // Catch:{ all -> 0x00e3 }
        r5.flush()     // Catch:{ all -> 0x00e3 }
        goto L_0x009b
    L_0x009a:
        r5 = r3
    L_0x009b:
        java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x00e3 }
        java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ all -> 0x00e3 }
        java.io.InputStream r8 = r4.getInputStream()     // Catch:{ all -> 0x00e3 }
        r7.<init>(r8)     // Catch:{ all -> 0x00e3 }
        r6.<init>(r7)     // Catch:{ all -> 0x00e3 }
    L_0x00a9:
        java.lang.String r3 = r6.readLine()     // Catch:{ all -> 0x00de }
        if (r3 == 0) goto L_0x00bf
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00de }
        r7.<init>()     // Catch:{ all -> 0x00de }
        r7.append(r1)     // Catch:{ all -> 0x00de }
        r7.append(r3)     // Catch:{ all -> 0x00de }
        java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x00de }
        goto L_0x00a9
    L_0x00bf:
        int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x00d9 }
        r10.f16899b = r0     // Catch:{ Exception -> 0x00d9 }
        java.util.Map r0 = r4.getHeaderFields()     // Catch:{ Exception -> 0x00d9 }
        r10.f16900c = r0     // Catch:{ Exception -> 0x00d9 }
        r10.f16901d = r1     // Catch:{ Exception -> 0x00d9 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r5)     // Catch:{ Exception -> 0x00d9 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r6)     // Catch:{ Exception -> 0x00d9 }
        if (r4 == 0) goto L_0x0121
        r4.disconnect()     // Catch:{ Exception -> 0x00d9 }
        goto L_0x0121
    L_0x00d9:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
        goto L_0x0121
    L_0x00de:
        r3 = move-exception
        r9 = r5
        r5 = r3
        r3 = r9
        goto L_0x00f0
    L_0x00e3:
        r6 = move-exception
        r9 = r6
        r6 = r3
        r3 = r5
        r5 = r9
        goto L_0x00f0
    L_0x00e9:
        r5 = move-exception
        r6 = r3
        goto L_0x00f0
    L_0x00ec:
        r4 = move-exception
        r6 = r3
        r5 = r4
        r4 = r6
    L_0x00f0:
        com.p368pw.inner.base.p387d.C5205o.m21464a(r5)     // Catch:{ all -> 0x0122 }
        boolean r5 = r10.f16906i     // Catch:{ all -> 0x0122 }
        if (r5 == 0) goto L_0x0108
        java.lang.String r5 = r10.f16907j     // Catch:{ all -> 0x0122 }
        java.lang.String r7 = "http://"
        java.lang.String r0 = r5.replaceAll(r7, r0)     // Catch:{ all -> 0x0122 }
        r10.f16907j = r0     // Catch:{ all -> 0x0122 }
        r10.f16906i = r2     // Catch:{ all -> 0x0122 }
        java.lang.String r0 = r10.m21430b()     // Catch:{ all -> 0x0122 }
        r1 = r0
    L_0x0108:
        int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x00d9 }
        r10.f16899b = r0     // Catch:{ Exception -> 0x00d9 }
        java.util.Map r0 = r4.getHeaderFields()     // Catch:{ Exception -> 0x00d9 }
        r10.f16900c = r0     // Catch:{ Exception -> 0x00d9 }
        r10.f16901d = r1     // Catch:{ Exception -> 0x00d9 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r3)     // Catch:{ Exception -> 0x00d9 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r6)     // Catch:{ Exception -> 0x00d9 }
        if (r4 == 0) goto L_0x0121
        r4.disconnect()     // Catch:{ Exception -> 0x00d9 }
    L_0x0121:
        return r1
    L_0x0122:
        r0 = move-exception
        int r2 = r4.getResponseCode()     // Catch:{ Exception -> 0x013d }
        r10.f16899b = r2     // Catch:{ Exception -> 0x013d }
        java.util.Map r2 = r4.getHeaderFields()     // Catch:{ Exception -> 0x013d }
        r10.f16900c = r2     // Catch:{ Exception -> 0x013d }
        r10.f16901d = r1     // Catch:{ Exception -> 0x013d }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r3)     // Catch:{ Exception -> 0x013d }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r6)     // Catch:{ Exception -> 0x013d }
        if (r4 == 0) goto L_0x0141
        r4.disconnect()     // Catch:{ Exception -> 0x013d }
        goto L_0x0141
    L_0x013d:
        r1 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r1)
    L_0x0141:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.base.p387d.C5194l.m21430b():java.lang.String");
    }

    /* renamed from: b */
    public static String m21431b(String str) {
        return C5207q.m21476a((CharSequence) str) ? str : str.replaceAll("http://", "https://");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r5v13, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r1v12, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v8
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY]]
  uses: [?[OBJECT, ARRAY], java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.io.InputStream]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0101 A[Catch:{ Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0106 A[Catch:{ Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0128 A[Catch:{ Exception -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012d A[Catch:{ Exception -> 0x0131 }] */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* renamed from: c */
    private java.lang.String m21432c() {
        /*
        r10 = this;
        java.lang.String r0 = "https://"
        java.lang.String r1 = r10.f16907j
        com.p368pw.inner.base.p387d.C5213t.m21486a(r1)
        java.lang.String r1 = ""
        r2 = 0
        r3 = 0
        java.lang.String r4 = r10.f16907j     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
        boolean r4 = r4.startsWith(r0)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
        if (r4 == 0) goto L_0x0016
        com.p368pw.inner.base.p387d.p389b.C5165a.m21319a()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
    L_0x0016:
        java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
        java.lang.String r5 = r10.f16907j     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
        r4.<init>(r5)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
        java.net.URLConnection r4 = r4.openConnection()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
        java.lang.String r5 = "GET"
        r4.setRequestMethod(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        r4.setUseCaches(r2)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        int r5 = r10.f16903f     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        r4.setReadTimeout(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        int r5 = r10.f16904g     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        java.lang.String r5 = "User-agent"
        java.lang.String r6 = m21435d()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        boolean r5 = r10.f16905h     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        r4.setInstanceFollowRedirects(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        java.io.InputStream r5 = r4.getInputStream()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        int r6 = r4.getResponseCode()     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        r7 = 200(0xc8, float:2.8E-43)
        if (r6 == r7) goto L_0x006d
        int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x0068 }
        r10.f16899b = r0     // Catch:{ Exception -> 0x0068 }
        java.util.Map r0 = r4.getHeaderFields()     // Catch:{ Exception -> 0x0068 }
        r10.f16900c = r0     // Catch:{ Exception -> 0x0068 }
        r10.f16901d = r1     // Catch:{ Exception -> 0x0068 }
        if (r5 == 0) goto L_0x0062
        r5.close()     // Catch:{ Exception -> 0x0068 }
    L_0x0062:
        if (r4 == 0) goto L_0x006c
        r4.disconnect()     // Catch:{ Exception -> 0x0068 }
        goto L_0x006c
    L_0x0068:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
    L_0x006c:
        return r3
    L_0x006d:
        java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        r6.<init>(r5)     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        r7.<init>(r6)     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
    L_0x0077:
        java.lang.String r6 = r7.readLine()     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        if (r6 == 0) goto L_0x008d
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        r8.<init>()     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        r8.append(r1)     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        r8.append(r6)     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        java.lang.String r1 = r8.toString()     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
        goto L_0x0077
    L_0x008d:
        int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x00a7 }
        r10.f16899b = r0     // Catch:{ Exception -> 0x00a7 }
        java.util.Map r0 = r4.getHeaderFields()     // Catch:{ Exception -> 0x00a7 }
        r10.f16900c = r0     // Catch:{ Exception -> 0x00a7 }
        r10.f16901d = r1     // Catch:{ Exception -> 0x00a7 }
        if (r5 == 0) goto L_0x00a0
        r5.close()     // Catch:{ Exception -> 0x00a7 }
    L_0x00a0:
        if (r4 == 0) goto L_0x010f
        r4.disconnect()     // Catch:{ Exception -> 0x00a7 }
        goto L_0x010f
    L_0x00a7:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
        goto L_0x010f
    L_0x00ad:
        r0 = move-exception
        r3 = r5
        goto L_0x0118
    L_0x00b1:
        r6 = move-exception
        r9 = r6
        r6 = r1
        r1 = r5
        r5 = r9
        goto L_0x00c6
    L_0x00b7:
        r0 = move-exception
        goto L_0x0118
    L_0x00ba:
        r5 = move-exception
        r6 = r1
        r1 = r3
        goto L_0x00c6
    L_0x00be:
        r0 = move-exception
        r4 = r3
        goto L_0x0118
    L_0x00c1:
        r4 = move-exception
        r6 = r1
        r1 = r3
        r5 = r4
        r4 = r1
    L_0x00c6:
        com.p368pw.inner.base.p387d.C5205o.m21464a(r5)     // Catch:{ all -> 0x0115 }
        boolean r6 = r5 instanceof javax.net.ssl.SSLException     // Catch:{ all -> 0x0110 }
        if (r6 != 0) goto L_0x00dd
        boolean r6 = r5 instanceof java.io.IOException     // Catch:{ all -> 0x0110 }
        if (r6 == 0) goto L_0x00f1
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0110 }
        java.lang.String r6 = "Cleartext HTTP traffic"
        boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x0110 }
        if (r5 == 0) goto L_0x00f1
    L_0x00dd:
        boolean r5 = r10.f16906i     // Catch:{ all -> 0x0110 }
        if (r5 == 0) goto L_0x00f1
        java.lang.String r5 = r10.f16907j     // Catch:{ all -> 0x0110 }
        java.lang.String r6 = "http://"
        java.lang.String r0 = r5.replaceAll(r6, r0)     // Catch:{ all -> 0x0110 }
        r10.f16907j = r0     // Catch:{ all -> 0x0110 }
        r10.f16906i = r2     // Catch:{ all -> 0x0110 }
        java.lang.String r3 = r10.m21432c()     // Catch:{ all -> 0x0110 }
    L_0x00f1:
        int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x010a }
        r10.f16899b = r0     // Catch:{ Exception -> 0x010a }
        java.util.Map r0 = r4.getHeaderFields()     // Catch:{ Exception -> 0x010a }
        r10.f16900c = r0     // Catch:{ Exception -> 0x010a }
        r10.f16901d = r3     // Catch:{ Exception -> 0x010a }
        if (r1 == 0) goto L_0x0104
        r1.close()     // Catch:{ Exception -> 0x010a }
    L_0x0104:
        if (r4 == 0) goto L_0x010e
        r4.disconnect()     // Catch:{ Exception -> 0x010a }
        goto L_0x010e
    L_0x010a:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
    L_0x010e:
        r1 = r3
    L_0x010f:
        return r1
    L_0x0110:
        r0 = move-exception
        r9 = r3
        r3 = r1
        r1 = r9
        goto L_0x0118
    L_0x0115:
        r0 = move-exception
        r3 = r1
        r1 = r6
    L_0x0118:
        int r2 = r4.getResponseCode()     // Catch:{ Exception -> 0x0131 }
        r10.f16899b = r2     // Catch:{ Exception -> 0x0131 }
        java.util.Map r2 = r4.getHeaderFields()     // Catch:{ Exception -> 0x0131 }
        r10.f16900c = r2     // Catch:{ Exception -> 0x0131 }
        r10.f16901d = r1     // Catch:{ Exception -> 0x0131 }
        if (r3 == 0) goto L_0x012b
        r3.close()     // Catch:{ Exception -> 0x0131 }
    L_0x012b:
        if (r4 == 0) goto L_0x0135
        r4.disconnect()     // Catch:{ Exception -> 0x0131 }
        goto L_0x0135
    L_0x0131:
        r1 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r1)
    L_0x0135:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.base.p387d.C5194l.m21432c():java.lang.String");
    }

    /* renamed from: c */
    public static boolean m21433c(String str) {
        return str.startsWith("https://");
    }

    /* renamed from: d */
    public static C5194l m21434d(String str) {
        return new C5194l(str, false);
    }

    /* renamed from: d */
    private static String m21435d() {
        if (C5207q.m21476a((CharSequence) f16898a)) {
            f16898a = System.getProperty("http.agent");
        }
        return f16898a;
    }

    /* renamed from: e */
    public static C5194l m21436e(String str) {
        return new C5194l(str, true);
    }

    /* renamed from: f */
    public static void m21437f(final String str) {
        C5208r.m21482b(new Runnable() {
            public void run() {
                C5194l.m21438g(str);
            }
        });
    }

    /* renamed from: g */
    public static String m21438g(String str) {
        return m21434d(str).mo26813a();
    }

    /* renamed from: a */
    public C5194l mo26812a(int i) {
        if (i > 0) {
            this.f16904g = i * 1000;
        }
        return this;
    }

    /* renamed from: a */
    public String mo26813a() {
        return this.f16902e ? m21430b() : m21432c();
    }

    /* renamed from: b */
    public C5194l mo26814b(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            this.f16903f = i2;
            this.f16904g = i2;
        }
        return this;
    }

    /* renamed from: c */
    public C5194l mo26815c(int i) {
        if (i > 0) {
            this.f16903f = i * 1000;
        }
        return this;
    }

    /* renamed from: h */
    public C5194l mo26816h(String str) {
        this.f16908k = str;
        return this;
    }
}
