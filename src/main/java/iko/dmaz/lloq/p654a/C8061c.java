package iko.dmaz.lloq.p654a;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: iko.dmaz.lloq.a.c */
public class C8061c {
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v12, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v21, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v14, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v16
  assigns: []
  uses: []
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
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00aa A[SYNTHETIC, Splitter:B:54:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b4 A[SYNTHETIC, Splitter:B:59:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3 A[SYNTHETIC, Splitter:B:67:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00cd A[SYNTHETIC, Splitter:B:72:0x00cd] */
    /* JADX WARNING: Unknown variable types count: 13 */
    /* renamed from: a */
    public static java.lang.String m34881a(java.lang.String r7) {
        /*
        r0 = 0
        java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00a1, all -> 0x009b }
        r1.<init>(r7)     // Catch:{ MalformedURLException -> 0x00a1, all -> 0x009b }
        java.net.URLConnection r7 = r1.openConnection()     // Catch:{ MalformedURLException -> 0x00a1, all -> 0x009b }
        java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ MalformedURLException -> 0x00a1, all -> 0x009b }
        java.lang.String r1 = "GET"
        r7.setRequestMethod(r1)     // Catch:{ MalformedURLException -> 0x0098, all -> 0x0093 }
        r1 = 15000(0x3a98, float:2.102E-41)
        r7.setConnectTimeout(r1)     // Catch:{ MalformedURLException -> 0x0098, all -> 0x0093 }
        r1 = 60000(0xea60, float:8.4078E-41)
        r7.setReadTimeout(r1)     // Catch:{ MalformedURLException -> 0x0098, all -> 0x0093 }
        r7.connect()     // Catch:{ MalformedURLException -> 0x0098, all -> 0x0093 }
        int r1 = r7.getResponseCode()     // Catch:{ MalformedURLException -> 0x0098, all -> 0x0093 }
        r2 = 200(0xc8, float:2.8E-43)
        java.lang.String r3 = "\r\n"
        java.lang.String r4 = "UTF-8"
        if (r1 == r2) goto L_0x0055
        java.io.InputStream r1 = r7.getErrorStream()     // Catch:{ MalformedURLException -> 0x0098, all -> 0x0093 }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ MalformedURLException -> 0x0090, all -> 0x008b }
        java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ MalformedURLException -> 0x0090, all -> 0x008b }
        r5.<init>(r1, r4)     // Catch:{ MalformedURLException -> 0x0090, all -> 0x008b }
        r2.<init>(r5)     // Catch:{ MalformedURLException -> 0x0090, all -> 0x008b }
        java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ MalformedURLException -> 0x0089 }
        r4.<init>()     // Catch:{ MalformedURLException -> 0x0089 }
    L_0x003e:
        java.lang.String r5 = r2.readLine()     // Catch:{ MalformedURLException -> 0x0089 }
        if (r5 == 0) goto L_0x004b
        r4.append(r5)     // Catch:{ MalformedURLException -> 0x0089 }
        r4.append(r3)     // Catch:{ MalformedURLException -> 0x0089 }
        goto L_0x003e
    L_0x004b:
        java.io.IOException r3 = new java.io.IOException     // Catch:{ MalformedURLException -> 0x0089 }
        java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x0089 }
        r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x0089 }
        throw r3     // Catch:{ MalformedURLException -> 0x0089 }
    L_0x0055:
        java.io.InputStream r1 = r7.getInputStream()     // Catch:{ MalformedURLException -> 0x0098, all -> 0x0093 }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ MalformedURLException -> 0x0090, all -> 0x008b }
        java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ MalformedURLException -> 0x0090, all -> 0x008b }
        r5.<init>(r1, r4)     // Catch:{ MalformedURLException -> 0x0090, all -> 0x008b }
        r2.<init>(r5)     // Catch:{ MalformedURLException -> 0x0090, all -> 0x008b }
        java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ MalformedURLException -> 0x0089 }
        r4.<init>()     // Catch:{ MalformedURLException -> 0x0089 }
    L_0x0068:
        java.lang.String r5 = r2.readLine()     // Catch:{ MalformedURLException -> 0x0089 }
        if (r5 == 0) goto L_0x0075
        r4.append(r5)     // Catch:{ MalformedURLException -> 0x0089 }
        r4.append(r3)     // Catch:{ MalformedURLException -> 0x0089 }
        goto L_0x0068
    L_0x0075:
        java.lang.String r0 = r4.toString()     // Catch:{ MalformedURLException -> 0x0089 }
        r2.close()     // Catch:{ IOException -> 0x007d }
        goto L_0x0081
    L_0x007d:
        r2 = move-exception
        r2.printStackTrace()
    L_0x0081:
        if (r1 == 0) goto L_0x00bc
        r1.close()     // Catch:{ IOException -> 0x0087 }
        goto L_0x00bc
    L_0x0087:
        r1 = move-exception
        goto L_0x00b9
    L_0x0089:
        r3 = move-exception
        goto L_0x00a5
    L_0x008b:
        r2 = move-exception
        r6 = r2
        r2 = r0
        r0 = r6
        goto L_0x00c1
    L_0x0090:
        r3 = move-exception
        r2 = r0
        goto L_0x00a5
    L_0x0093:
        r1 = move-exception
        r2 = r0
        r0 = r1
        r1 = r2
        goto L_0x00c1
    L_0x0098:
        r3 = move-exception
        r1 = r0
        goto L_0x00a4
    L_0x009b:
        r7 = move-exception
        r1 = r0
        r2 = r1
        r0 = r7
        r7 = r2
        goto L_0x00c1
    L_0x00a1:
        r3 = move-exception
        r7 = r0
        r1 = r7
    L_0x00a4:
        r2 = r1
    L_0x00a5:
        r3.printStackTrace()     // Catch:{ all -> 0x00c0 }
        if (r2 == 0) goto L_0x00b2
        r2.close()     // Catch:{ IOException -> 0x00ae }
        goto L_0x00b2
    L_0x00ae:
        r2 = move-exception
        r2.printStackTrace()
    L_0x00b2:
        if (r1 == 0) goto L_0x00bc
        r1.close()     // Catch:{ IOException -> 0x00b8 }
        goto L_0x00bc
    L_0x00b8:
        r1 = move-exception
    L_0x00b9:
        r1.printStackTrace()
    L_0x00bc:
        r7.disconnect()
        return r0
    L_0x00c0:
        r0 = move-exception
    L_0x00c1:
        if (r2 == 0) goto L_0x00cb
        r2.close()     // Catch:{ IOException -> 0x00c7 }
        goto L_0x00cb
    L_0x00c7:
        r2 = move-exception
        r2.printStackTrace()
    L_0x00cb:
        if (r1 == 0) goto L_0x00d5
        r1.close()     // Catch:{ IOException -> 0x00d1 }
        goto L_0x00d5
    L_0x00d1:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00d5:
        r7.disconnect()
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: iko.dmaz.lloq.p654a.C8061c.m34881a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v4, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v17, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v12
  assigns: []
  uses: []
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
    /* JADX WARNING: Removed duplicated region for block: B:104:0x013a A[SYNTHETIC, Splitter:B:104:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0102 A[SYNTHETIC, Splitter:B:75:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010c A[SYNTHETIC, Splitter:B:80:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0116 A[SYNTHETIC, Splitter:B:85:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0126 A[SYNTHETIC, Splitter:B:94:0x0126] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0130 A[SYNTHETIC, Splitter:B:99:0x0130] */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* renamed from: a */
    public static java.lang.String m34882a(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
        r0 = 0
        java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00f8, all -> 0x00f3 }
        r1.<init>(r6)     // Catch:{ MalformedURLException -> 0x00f8, all -> 0x00f3 }
        java.net.URLConnection r6 = r1.openConnection()     // Catch:{ MalformedURLException -> 0x00f8, all -> 0x00f3 }
        java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ MalformedURLException -> 0x00f8, all -> 0x00f3 }
        java.lang.String r1 = "POST"
        r6.setRequestMethod(r1)     // Catch:{ MalformedURLException -> 0x00ed, all -> 0x00e8 }
        r1 = 15000(0x3a98, float:2.102E-41)
        r6.setConnectTimeout(r1)     // Catch:{ MalformedURLException -> 0x00ed, all -> 0x00e8 }
        r1 = 60000(0xea60, float:8.4078E-41)
        r6.setReadTimeout(r1)     // Catch:{ MalformedURLException -> 0x00ed, all -> 0x00e8 }
        r1 = 1
        r6.setDoOutput(r1)     // Catch:{ MalformedURLException -> 0x00ed, all -> 0x00e8 }
        r6.setDoInput(r1)     // Catch:{ MalformedURLException -> 0x00ed, all -> 0x00e8 }
        java.lang.String r1 = "Content-Type"
        java.lang.String r2 = "application/json"
        r6.setRequestProperty(r1, r2)     // Catch:{ MalformedURLException -> 0x00ed, all -> 0x00e8 }
        if (r8 == 0) goto L_0x0033
        java.lang.String r1 = "Content-Encoding"
        java.lang.String r2 = "gzip"
        r6.setRequestProperty(r1, r2)     // Catch:{ MalformedURLException -> 0x00ed, all -> 0x00e8 }
    L_0x0033:
        java.io.OutputStream r1 = r6.getOutputStream()     // Catch:{ MalformedURLException -> 0x00ed, all -> 0x00e8 }
        if (r8 == 0) goto L_0x0045
        byte[] r7 = r7.getBytes()     // Catch:{ MalformedURLException -> 0x00e3, all -> 0x00df }
        byte[] r7 = m34883a(r7)     // Catch:{ MalformedURLException -> 0x00e3, all -> 0x00df }
        r1.write(r7)     // Catch:{ MalformedURLException -> 0x00e3, all -> 0x00df }
        goto L_0x004c
    L_0x0045:
        byte[] r7 = r7.getBytes()     // Catch:{ MalformedURLException -> 0x00e3, all -> 0x00df }
        r1.write(r7)     // Catch:{ MalformedURLException -> 0x00e3, all -> 0x00df }
    L_0x004c:
        int r7 = r6.getResponseCode()     // Catch:{ MalformedURLException -> 0x00e3, all -> 0x00df }
        r8 = 200(0xc8, float:2.8E-43)
        java.lang.String r2 = "\r\n"
        java.lang.String r3 = "UTF-8"
        if (r7 == r8) goto L_0x0082
        java.io.InputStream r7 = r6.getErrorStream()     // Catch:{ MalformedURLException -> 0x00e3, all -> 0x00df }
        java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ MalformedURLException -> 0x00d9, all -> 0x00d3 }
        java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ MalformedURLException -> 0x00d9, all -> 0x00d3 }
        r4.<init>(r7, r3)     // Catch:{ MalformedURLException -> 0x00d9, all -> 0x00d3 }
        r8.<init>(r4)     // Catch:{ MalformedURLException -> 0x00d9, all -> 0x00d3 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        r3.<init>()     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
    L_0x006b:
        java.lang.String r4 = r8.readLine()     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        if (r4 == 0) goto L_0x0078
        r3.append(r4)     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        r3.append(r2)     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        goto L_0x006b
    L_0x0078:
        java.io.IOException r2 = new java.io.IOException     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        r2.<init>(r3)     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        throw r2     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
    L_0x0082:
        java.io.InputStream r7 = r6.getInputStream()     // Catch:{ MalformedURLException -> 0x00e3, all -> 0x00df }
        java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ MalformedURLException -> 0x00d9, all -> 0x00d3 }
        java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ MalformedURLException -> 0x00d9, all -> 0x00d3 }
        r4.<init>(r7, r3)     // Catch:{ MalformedURLException -> 0x00d9, all -> 0x00d3 }
        r8.<init>(r4)     // Catch:{ MalformedURLException -> 0x00d9, all -> 0x00d3 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        r3.<init>()     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
    L_0x0095:
        java.lang.String r4 = r8.readLine()     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        if (r4 == 0) goto L_0x00a2
        r3.append(r4)     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        r3.append(r2)     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        goto L_0x0095
    L_0x00a2:
        java.lang.String r0 = r3.toString()     // Catch:{ MalformedURLException -> 0x00cd, all -> 0x00c7 }
        r8.close()     // Catch:{ IOException -> 0x00aa }
        goto L_0x00ae
    L_0x00aa:
        r8 = move-exception
        r8.printStackTrace()
    L_0x00ae:
        if (r1 == 0) goto L_0x00b8
        r1.close()     // Catch:{ IOException -> 0x00b4 }
        goto L_0x00b8
    L_0x00b4:
        r8 = move-exception
        r8.printStackTrace()
    L_0x00b8:
        if (r7 == 0) goto L_0x00c2
        r7.close()     // Catch:{ IOException -> 0x00be }
        goto L_0x00c2
    L_0x00be:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00c2:
        r6.disconnect()
        goto L_0x0121
    L_0x00c7:
        r0 = move-exception
        r2 = r6
        r6 = r7
        r7 = r0
        goto L_0x0123
    L_0x00cd:
        r2 = move-exception
        r5 = r2
        r2 = r6
        r6 = r7
        r7 = r5
        goto L_0x00fd
    L_0x00d3:
        r8 = move-exception
        r2 = r6
        r6 = r7
        r7 = r8
        goto L_0x0124
    L_0x00d9:
        r8 = move-exception
        r2 = r6
        r6 = r7
        r7 = r8
        r8 = r0
        goto L_0x00fd
    L_0x00df:
        r7 = move-exception
        r2 = r6
        r6 = r0
        goto L_0x0124
    L_0x00e3:
        r7 = move-exception
        r2 = r6
        r6 = r0
        r8 = r6
        goto L_0x00fd
    L_0x00e8:
        r7 = move-exception
        r2 = r6
        r6 = r0
        r1 = r6
        goto L_0x0124
    L_0x00ed:
        r7 = move-exception
        r2 = r6
        r6 = r0
        r8 = r6
        r1 = r8
        goto L_0x00fd
    L_0x00f3:
        r7 = move-exception
        r6 = r0
        r1 = r6
        r2 = r1
        goto L_0x0124
    L_0x00f8:
        r7 = move-exception
        r6 = r0
        r8 = r6
        r1 = r8
        r2 = r1
    L_0x00fd:
        r7.printStackTrace()     // Catch:{ all -> 0x0122 }
        if (r8 == 0) goto L_0x010a
        r8.close()     // Catch:{ IOException -> 0x0106 }
        goto L_0x010a
    L_0x0106:
        r7 = move-exception
        r7.printStackTrace()
    L_0x010a:
        if (r1 == 0) goto L_0x0114
        r1.close()     // Catch:{ IOException -> 0x0110 }
        goto L_0x0114
    L_0x0110:
        r7 = move-exception
        r7.printStackTrace()
    L_0x0114:
        if (r6 == 0) goto L_0x011e
        r6.close()     // Catch:{ IOException -> 0x011a }
        goto L_0x011e
    L_0x011a:
        r6 = move-exception
        r6.printStackTrace()
    L_0x011e:
        r2.disconnect()
    L_0x0121:
        return r0
    L_0x0122:
        r7 = move-exception
    L_0x0123:
        r0 = r8
    L_0x0124:
        if (r0 == 0) goto L_0x012e
        r0.close()     // Catch:{ IOException -> 0x012a }
        goto L_0x012e
    L_0x012a:
        r8 = move-exception
        r8.printStackTrace()
    L_0x012e:
        if (r1 == 0) goto L_0x0138
        r1.close()     // Catch:{ IOException -> 0x0134 }
        goto L_0x0138
    L_0x0134:
        r8 = move-exception
        r8.printStackTrace()
    L_0x0138:
        if (r6 == 0) goto L_0x0142
        r6.close()     // Catch:{ IOException -> 0x013e }
        goto L_0x0142
    L_0x013e:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0142:
        r2.disconnect()
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: iko.dmaz.lloq.p654a.C8061c.m34882a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: a */
    public static byte[] m34883a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
