package com.airbnb.lottie;

import android.util.Log;
import androidx.core.p003os.TraceCompat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.airbnb.lottie.c */
public class L {
    /* renamed from: a */
    public static boolean f1437a = false;
    /* renamed from: b */
    private static final Set<String> f1438b = new HashSet();
    /* renamed from: c */
    private static boolean f1439c = false;
    /* renamed from: d */
    private static String[] f1440d;
    /* renamed from: e */
    private static long[] f1441e;
    /* renamed from: f */
    private static int f1442f = 0;
    /* renamed from: g */
    private static int f1443g = 0;

    /* renamed from: a */
    public static void m1313a(String str) {
        if (f1437a) {
            Log.d("LOTTIE", str);
        }
    }

    /* renamed from: b */
    public static void m1314b(String str) {
        if (!f1438b.contains(str)) {
            Log.w("LOTTIE", str);
            f1438b.add(str);
        }
    }

    /* renamed from: c */
    public static void m1315c(String str) {
        if (f1439c) {
            int i = f1442f;
            if (i == 20) {
                f1443g++;
                return;
            }
            f1440d[i] = str;
            f1441e[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f1442f++;
        }
    }

    /* renamed from: d */
    public static float m1316d(String str) {
        int i = f1443g;
        if (i > 0) {
            f1443g = i - 1;
            return 0.0f;
        } else if (!f1439c) {
            return 0.0f;
        } else {
            f1442f--;
            int i2 = f1442f;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f1440d[i2])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f1441e[f1442f])) / 1000000.0f;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unbalanced trace call ");
                sb.append(str);
                sb.append(". Expected ");
                sb.append(f1440d[f1442f]);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
    }
}
