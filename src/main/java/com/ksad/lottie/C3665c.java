package com.ksad.lottie;

import android.util.Log;
import androidx.core.p003os.TraceCompat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.ksad.lottie.c */
public class C3665c {
    /* renamed from: a */
    public static boolean f12569a = false;
    /* renamed from: b */
    private static final Set<String> f12570b = new HashSet();
    /* renamed from: c */
    private static boolean f12571c = false;
    /* renamed from: d */
    private static String[] f12572d;
    /* renamed from: e */
    private static long[] f12573e;
    /* renamed from: f */
    private static int f12574f = 0;
    /* renamed from: g */
    private static int f12575g = 0;

    /* renamed from: a */
    public static void m15250a(String str) {
        if (f12569a) {
            Log.d("LOTTIE", str);
        }
    }

    /* renamed from: b */
    public static void m15251b(String str) {
        if (!f12570b.contains(str)) {
            Log.w("LOTTIE", str);
            f12570b.add(str);
        }
    }

    /* renamed from: c */
    public static void m15252c(String str) {
        if (f12571c) {
            int i = f12574f;
            if (i == 20) {
                f12575g++;
                return;
            }
            f12572d[i] = str;
            f12573e[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f12574f++;
        }
    }

    /* renamed from: d */
    public static float m15253d(String str) {
        int i = f12575g;
        if (i > 0) {
            f12575g = i - 1;
            return 0.0f;
        } else if (!f12571c) {
            return 0.0f;
        } else {
            f12574f--;
            int i2 = f12574f;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f12572d[i2])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f12573e[f12574f])) / 1000000.0f;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unbalanced trace call ");
                sb.append(str);
                sb.append(". Expected ");
                sb.append(f12572d[f12574f]);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
    }
}
