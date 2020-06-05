package com.bumptech.glide.load.engine.p138b;

import android.os.Build.VERSION;

/* renamed from: com.bumptech.glide.load.engine.b.b */
final class RuntimeCompat {
    /* renamed from: a */
    static int m5518a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return VERSION.SDK_INT < 17 ? Math.max(m5519b(), availableProcessors) : availableProcessors;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.io.File[]] */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v10
  assigns: [java.io.File[], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], ?[]]
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
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: b */
    private static int m5519b() {
        /*
        java.lang.String r0 = "GlideRuntimeCompat"
        android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0020 }
        java.lang.String r3 = "/sys/devices/system/cpu/"
        r2.<init>(r3)     // Catch:{ all -> 0x0020 }
        java.lang.String r3 = "cpu[0-9]+"
        java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ all -> 0x0020 }
        com.bumptech.glide.load.engine.b.b$1 r4 = new com.bumptech.glide.load.engine.b.b$1     // Catch:{ all -> 0x0020 }
        r4.m42438init(r3)     // Catch:{ all -> 0x0020 }
        java.io.File[] r0 = r2.listFiles(r4)     // Catch:{ all -> 0x0020 }
        android.os.StrictMode.setThreadPolicy(r1)
        goto L_0x0031
    L_0x0020:
        r2 = move-exception
        r3 = 6
        boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x003c }
        if (r3 == 0) goto L_0x002d
        java.lang.String r3 = "Failed to calculate accurate cpu count"
        android.util.Log.e(r0, r3, r2)     // Catch:{ all -> 0x003c }
    L_0x002d:
        android.os.StrictMode.setThreadPolicy(r1)
        r0 = 0
    L_0x0031:
        r1 = 1
        if (r0 == 0) goto L_0x0036
        int r0 = r0.length
        goto L_0x0037
    L_0x0036:
        r0 = 0
    L_0x0037:
        int r0 = java.lang.Math.max(r1, r0)
        return r0
    L_0x003c:
        r0 = move-exception
        android.os.StrictMode.setThreadPolicy(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.p138b.RuntimeCompat.m5519b():int");
    }
}
