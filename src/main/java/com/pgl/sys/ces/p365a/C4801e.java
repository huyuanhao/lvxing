package com.pgl.sys.ces.p365a;

import java.io.BufferedInputStream;

/* renamed from: com.pgl.sys.ces.a.e */
public class C4801e {
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b1, code lost:
            if (r8.length() == 0) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b6, code lost:
            return r8;
     */
    /* renamed from: a */
    public static synchronized java.lang.String m19652a(android.content.Context r8) {
        /*
        java.lang.Class<com.pgl.sys.ces.a.e> r0 = com.pgl.sys.ces.p365a.C4801e.class
        monitor-enter(r0)
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
        r1.<init>()     // Catch:{ all -> 0x00a9 }
        java.io.File r2 = r8.getFilesDir()     // Catch:{ all -> 0x00a9 }
        java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x00a9 }
        r1.append(r2)     // Catch:{ all -> 0x00a9 }
        java.lang.String r2 = "/"
        r1.append(r2)     // Catch:{ all -> 0x00a9 }
        java.lang.String r2 = "cid"
        r1.append(r2)     // Catch:{ all -> 0x00a9 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a9 }
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00a9 }
        r2.<init>(r1)     // Catch:{ all -> 0x00a9 }
        boolean r2 = r2.exists()     // Catch:{ all -> 0x00a9 }
        if (r2 == 0) goto L_0x003a
        java.lang.String r2 = m19654a(r1)     // Catch:{ all -> 0x00a9 }
        if (r2 == 0) goto L_0x003a
        int r3 = r2.length()     // Catch:{ all -> 0x00a9 }
        if (r3 <= 0) goto L_0x003a
        monitor-exit(r0)
        return r2
    L_0x003a:
        android.content.res.Resources r8 = r8.getResources()     // Catch:{ all -> 0x00a9 }
        android.content.res.AssetManager r8 = r8.getAssets()     // Catch:{ all -> 0x00a9 }
        java.lang.String r2 = "cid"
        java.io.InputStream r8 = r8.open(r2)     // Catch:{ all -> 0x00a9 }
        java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00a9 }
        r2.<init>()     // Catch:{ all -> 0x00a9 }
        r3 = 4096(0x1000, float:5.74E-42)
        byte[] r4 = new byte[r3]     // Catch:{ all -> 0x00a9 }
    L_0x0051:
        r5 = 0
        int r6 = r8.read(r4, r5, r3)     // Catch:{ all -> 0x00a9 }
        r7 = -1
        if (r6 == r7) goto L_0x005d
        r2.write(r4, r5, r6)     // Catch:{ all -> 0x00a9 }
        goto L_0x0051
    L_0x005d:
        java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a9 }
        r8.<init>(r1)     // Catch:{ all -> 0x00a9 }
        byte[] r2 = r2.toByteArray()     // Catch:{ all -> 0x00a9 }
        r8.write(r2)     // Catch:{ all -> 0x00a9 }
        r8.close()     // Catch:{ all -> 0x00a9 }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
        r8.<init>()     // Catch:{ all -> 0x00a9 }
        java.lang.String r2 = "chmod 777 "
        r8.append(r2)     // Catch:{ all -> 0x00a9 }
        r8.append(r1)     // Catch:{ all -> 0x00a9 }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00a9 }
        m19654a(r8)     // Catch:{ all -> 0x00a9 }
        java.lang.String r8 = m19654a(r1)     // Catch:{ all -> 0x00a9 }
        if (r8 == 0) goto L_0x008c
        int r2 = r8.length()     // Catch:{ all -> 0x00a9 }
        if (r2 != 0) goto L_0x00ab
    L_0x008c:
        java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ all -> 0x00a9 }
        java.lang.String r2 = "rw"
        r8.<init>(r1, r2)     // Catch:{ all -> 0x00a9 }
        r2 = 1
        byte[] r2 = new byte[r2]     // Catch:{ all -> 0x00a9 }
        r3 = 2
        r2[r5] = r3     // Catch:{ all -> 0x00a9 }
        r3 = 16
        r8.seek(r3)     // Catch:{ all -> 0x00a9 }
        r8.write(r2)     // Catch:{ all -> 0x00a9 }
        r8.close()     // Catch:{ all -> 0x00a9 }
        java.lang.String r8 = m19654a(r1)     // Catch:{ all -> 0x00a9 }
        goto L_0x00ab
    L_0x00a9:
        java.lang.String r8 = "0[<!>]EXCEPTION[<!>]"
    L_0x00ab:
        if (r8 == 0) goto L_0x00b3
        int r1 = r8.length()     // Catch:{ all -> 0x00b7 }
        if (r1 != 0) goto L_0x00b5
    L_0x00b3:
        java.lang.String r8 = "0[<!>]ERROR[<!>]"
    L_0x00b5:
        monitor-exit(r0)
        return r8
    L_0x00b7:
        r8 = move-exception
        monitor-exit(r0)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.ces.p365a.C4801e.m19652a(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    private static String m19653a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (read >= 4096);
        return sb.toString();
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
            if (r1 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
            r1.destroy();
            r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0078, code lost:
            if (r1 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007b, code lost:
            return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.lang.String]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.io.BufferedInputStream]
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066 A[SYNTHETIC, Splitter:B:35:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0070 A[SYNTHETIC, Splitter:B:40:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0080 A[SYNTHETIC, Splitter:B:49:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008a A[SYNTHETIC, Splitter:B:54:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0094  */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    private static java.lang.String m19654a(java.lang.String r5) {
        /*
        r0 = 0
        java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
        java.lang.String r2 = "sh"
        java.lang.Process r1 = r1.exec(r2)     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
        java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
        java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
        r2.<init>(r3)     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
        java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0050, all -> 0x004e }
        java.io.InputStream r4 = r1.getInputStream()     // Catch:{ Exception -> 0x0050, all -> 0x004e }
        r3.<init>(r4)     // Catch:{ Exception -> 0x0050, all -> 0x004e }
        byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x004c }
        r2.write(r5)     // Catch:{ Exception -> 0x004c }
        r5 = 10
        r2.write(r5)     // Catch:{ Exception -> 0x004c }
        r2.flush()     // Catch:{ Exception -> 0x004c }
        r2.close()     // Catch:{ Exception -> 0x004c }
        r1.waitFor()     // Catch:{ Exception -> 0x004c }
        java.lang.String r0 = m19653a(r3)     // Catch:{ Exception -> 0x004c }
        r2.close()     // Catch:{ IOException -> 0x003a }
        goto L_0x003e
    L_0x003a:
        r5 = move-exception
        r5.printStackTrace()
    L_0x003e:
        r3.close()     // Catch:{ IOException -> 0x0042 }
        goto L_0x0046
    L_0x0042:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0046:
        if (r1 == 0) goto L_0x007b
    L_0x0048:
        r1.destroy()
        goto L_0x007b
    L_0x004c:
        r5 = move-exception
        goto L_0x0061
    L_0x004e:
        r5 = move-exception
        goto L_0x007e
    L_0x0050:
        r5 = move-exception
        r3 = r0
        goto L_0x0061
    L_0x0053:
        r5 = move-exception
        r2 = r0
        goto L_0x007e
    L_0x0056:
        r5 = move-exception
        r2 = r0
        goto L_0x0060
    L_0x0059:
        r5 = move-exception
        r1 = r0
        r2 = r1
        goto L_0x007e
    L_0x005d:
        r5 = move-exception
        r1 = r0
        r2 = r1
    L_0x0060:
        r3 = r2
    L_0x0061:
        r5.printStackTrace()     // Catch:{ all -> 0x007c }
        if (r2 == 0) goto L_0x006e
        r2.close()     // Catch:{ IOException -> 0x006a }
        goto L_0x006e
    L_0x006a:
        r5 = move-exception
        r5.printStackTrace()
    L_0x006e:
        if (r3 == 0) goto L_0x0078
        r3.close()     // Catch:{ IOException -> 0x0074 }
        goto L_0x0078
    L_0x0074:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0078:
        if (r1 == 0) goto L_0x007b
        goto L_0x0048
    L_0x007b:
        return r0
    L_0x007c:
        r5 = move-exception
        r0 = r3
    L_0x007e:
        if (r2 == 0) goto L_0x0088
        r2.close()     // Catch:{ IOException -> 0x0084 }
        goto L_0x0088
    L_0x0084:
        r2 = move-exception
        r2.printStackTrace()
    L_0x0088:
        if (r0 == 0) goto L_0x0092
        r0.close()     // Catch:{ IOException -> 0x008e }
        goto L_0x0092
    L_0x008e:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0092:
        if (r1 == 0) goto L_0x0097
        r1.destroy()
    L_0x0097:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.ces.p365a.C4801e.m19654a(java.lang.String):java.lang.String");
    }
}
