package com.qiyukf.basesdk.p412c.p414b;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.util.HashMap;

/* renamed from: com.qiyukf.basesdk.c.b.e */
public final class C5397e {
    /* renamed from: a */
    private static final HashMap<String, Integer> f17364a;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f17364a = hashMap;
        hashMap.put("black", Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        HashMap<String, Integer> hashMap2 = f17364a;
        Integer valueOf = Integer.valueOf(-12303292);
        hashMap2.put("darkgray", valueOf);
        HashMap<String, Integer> hashMap3 = f17364a;
        Integer valueOf2 = Integer.valueOf(-7829368);
        hashMap3.put("gray", valueOf2);
        HashMap<String, Integer> hashMap4 = f17364a;
        Integer valueOf3 = Integer.valueOf(-3355444);
        hashMap4.put("lightgray", valueOf3);
        f17364a.put("white", Integer.valueOf(-1));
        f17364a.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
        HashMap<String, Integer> hashMap5 = f17364a;
        Integer valueOf4 = Integer.valueOf(-16711936);
        hashMap5.put("green", valueOf4);
        f17364a.put("blue", Integer.valueOf(-16776961));
        f17364a.put("yellow", Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
        HashMap<String, Integer> hashMap6 = f17364a;
        Integer valueOf5 = Integer.valueOf(-16711681);
        hashMap6.put("cyan", valueOf5);
        HashMap<String, Integer> hashMap7 = f17364a;
        Integer valueOf6 = Integer.valueOf(-65281);
        hashMap7.put("magenta", valueOf6);
        f17364a.put("aqua", valueOf5);
        f17364a.put("fuchsia", valueOf6);
        f17364a.put("darkgrey", valueOf);
        f17364a.put("grey", valueOf2);
        f17364a.put("lightgrey", valueOf3);
        f17364a.put("lime", valueOf4);
        f17364a.put("maroon", Integer.valueOf(-8388608));
        f17364a.put("navy", Integer.valueOf(-16777088));
        f17364a.put("olive", Integer.valueOf(-8355840));
        f17364a.put("purple", Integer.valueOf(-8388480));
        f17364a.put("silver", Integer.valueOf(-4144960));
        f17364a.put("teal", Integer.valueOf(-16744320));
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v9, types: [int] */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r6v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v6
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
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    public static int m22096a(? r6) {
        /*
        java.lang.Class<android.graphics.Color> r0 = android.graphics.Color.class
        java.lang.String r1 = "getHtmlColor"
        r2 = 1
        java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x002a, IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0020 }
        java.lang.Class<java.lang.String> r4 = java.lang.String.class
        r5 = 0
        r3[r5] = r4     // Catch:{ NoSuchMethodException -> 0x002a, IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0020 }
        java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ NoSuchMethodException -> 0x002a, IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0020 }
        r1 = 0
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x002a, IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0020 }
        r2[r5] = r6     // Catch:{ NoSuchMethodException -> 0x002a, IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0020 }
        java.lang.Object r0 = r0.invoke(r1, r2)     // Catch:{ NoSuchMethodException -> 0x002a, IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0020 }
        java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ NoSuchMethodException -> 0x002a, IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0020 }
        int r6 = r0.intValue()     // Catch:{ NoSuchMethodException -> 0x002a, IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0020 }
        return r6
    L_0x0020:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x002e
    L_0x0025:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x002e
    L_0x002a:
        r0 = move-exception
        r0.printStackTrace()
    L_0x002e:
        java.util.HashMap<java.lang.String, java.lang.Integer> r0 = f17364a
        java.lang.Object r6 = r0.get(r6)
        java.lang.Integer r6 = (java.lang.Integer) r6
        if (r6 != 0) goto L_0x003a
        r6 = -1
        return r6
    L_0x003a:
        int r6 = r6.intValue()
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.p414b.C5397e.m22096a(java.lang.String):int");
    }
}
