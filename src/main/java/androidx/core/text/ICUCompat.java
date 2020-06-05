package androidx.core.text;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        String str = "addLikelySubtags";
        String str2 = "libcore.icu.ICU";
        if (VERSION.SDK_INT < 21) {
            try {
                Class cls = Class.forName(str2);
                if (cls != null) {
                    sGetScriptMethod = cls.getMethod("getScript", new Class[]{String.class});
                    sAddLikelySubtagsMethod = cls.getMethod(str, new Class[]{String.class});
                }
            } catch (Exception e) {
                sGetScriptMethod = null;
                sAddLikelySubtagsMethod = null;
                Log.w(TAG, e);
            }
        } else if (VERSION.SDK_INT < 24) {
            try {
                sAddLikelySubtagsMethod = Class.forName(str2).getMethod(str, new Class[]{Locale.class});
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.util.Locale] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.util.Locale] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Locale, code=null, for r4v0, types: [java.util.Locale] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v5
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 5 */
    public static java.lang.String maximizeAndGetScript(? r4) {
        /*
        java.lang.String r0 = "ICUCompat"
        int r1 = android.os.Build.VERSION.SDK_INT
        r2 = 24
        if (r1 < r2) goto L_0x0015
        android.icu.util.ULocale r4 = android.icu.util.ULocale.forLocale(r4)
        android.icu.util.ULocale r4 = android.icu.util.ULocale.addLikelySubtags(r4)
        java.lang.String r4 = r4.getScript()
        return r4
    L_0x0015:
        int r1 = android.os.Build.VERSION.SDK_INT
        r2 = 21
        r3 = 0
        if (r1 < r2) goto L_0x003d
        r1 = 1
        java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ InvocationTargetException -> 0x0034, IllegalAccessException -> 0x002f }
        r2 = 0
        r1[r2] = r4     // Catch:{ InvocationTargetException -> 0x0034, IllegalAccessException -> 0x002f }
        java.lang.reflect.Method r2 = sAddLikelySubtagsMethod     // Catch:{ InvocationTargetException -> 0x0034, IllegalAccessException -> 0x002f }
        java.lang.Object r1 = r2.invoke(r3, r1)     // Catch:{ InvocationTargetException -> 0x0034, IllegalAccessException -> 0x002f }
        java.util.Locale r1 = (java.util.Locale) r1     // Catch:{ InvocationTargetException -> 0x0034, IllegalAccessException -> 0x002f }
        java.lang.String r4 = r1.getScript()     // Catch:{ InvocationTargetException -> 0x0034, IllegalAccessException -> 0x002f }
        return r4
    L_0x002f:
        r1 = move-exception
        android.util.Log.w(r0, r1)
        goto L_0x0038
    L_0x0034:
        r1 = move-exception
        android.util.Log.w(r0, r1)
    L_0x0038:
        java.lang.String r4 = r4.getScript()
        return r4
    L_0x003d:
        java.lang.String r4 = addLikelySubtags(r4)
        if (r4 == 0) goto L_0x0048
        java.lang.String r4 = getScript(r4)
        return r4
    L_0x0048:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.ICUCompat.maximizeAndGetScript(java.util.Locale):java.lang.String");
    }

    private static String getScript(String str) {
        String str2 = TAG;
        try {
            if (sGetScriptMethod != null) {
                return (String) sGetScriptMethod.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
            Log.w(str2, e);
        } catch (InvocationTargetException e2) {
            Log.w(str2, e2);
        }
        return null;
    }

    private static String addLikelySubtags(Locale locale) {
        String str = TAG;
        String locale2 = locale.toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                return (String) sAddLikelySubtagsMethod.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
            Log.w(str, e);
        } catch (InvocationTargetException e2) {
            Log.w(str, e2);
        }
        return locale2;
    }

    private ICUCompat() {
    }
}
