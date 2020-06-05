package com.pgl.sys.ces.p365a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import org.slf4j.Marker;

/* renamed from: com.pgl.sys.ces.a.d */
public class C4800d {
    /* renamed from: a */
    public static int f15446a;
    /* renamed from: b */
    public static int f15447b;
    /* renamed from: c */
    public static int f15448c;
    /* renamed from: d */
    private static int f15449d;
    /* renamed from: e */
    private static int f15450e;
    /* renamed from: f */
    private static int f15451f;

    /* renamed from: a */
    public static String m19648a(Context context) {
        try {
            m19649b(context);
            m19650c(context);
            m19651d(context);
        } catch (Throwable unused) {
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(f15448c);
        String str = "[<!>]";
        sb.append(str);
        sb.append(f15446a);
        sb.append(Marker.ANY_MARKER);
        sb.append(f15447b);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    private static void m19649b(Context context) {
        int height;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
                f15446a = point.x;
            } else if (VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
                f15446a = point.x;
            } else {
                f15446a = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
                f15447b = height;
            }
            height = point.y;
            f15447b = height;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private static void m19650c(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                f15449d = (int) displayMetrics.density;
                f15448c = displayMetrics.densityDpi;
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    private static void m19651d(Context context) {
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f15450e = (int) displayMetrics.xdpi;
            f15451f = (int) displayMetrics.ydpi;
        } catch (Throwable unused) {
        }
    }
}
