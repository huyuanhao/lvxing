package com.ksad.download.p297c;

import android.text.TextUtils;
import java.io.File;

/* renamed from: com.ksad.download.c.a */
public class C3606a {
    /* JADX WARNING: type inference failed for: r0v0, types: [android.os.StatFs] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.StatFs] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [long] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v2
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
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    public static long m15042a(java.lang.String r5) {
        /*
        android.os.StatFs r0 = new android.os.StatFs
        r0.<init>(r5)
        int r5 = android.os.Build.VERSION.SDK_INT
        r1 = 18
        if (r5 < r1) goto L_0x0014
        long r0 = r0.getAvailableBytes()     // Catch:{ all -> 0x0010 }
        return r0
    L_0x0010:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0014:
        int r5 = r0.getBlockSize()
        long r1 = (long) r5
        int r5 = r0.getAvailableBlocks()
        long r3 = (long) r5
        long r1 = r1 * r3
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ksad.download.p297c.C3606a.m15042a(java.lang.String):long");
    }

    /* renamed from: a */
    public static boolean m15043a(File file) {
        return file != null && file.exists();
    }

    /* renamed from: b */
    public static String m15044b(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            str2 = str.substring(lastIndexOf + 1);
        }
        return str2;
    }
}
