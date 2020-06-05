package com.kwad.sdk.p306a;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.kwad.sdk.core.p319c.C4065b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.kwad.sdk.a.t */
public class C3817t {
    /* renamed from: a */
    private static int f12937a;
    /* renamed from: b */
    private static long f12938b;

    /* renamed from: a */
    public static int m15861a(Context context) {
        int i = f12937a;
        if (i > 0 || context == null) {
            return i;
        }
        String str = "status_bar_height";
        int identifier = context.getResources().getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            f12937a = context.getResources().getDimensionPixelSize(identifier);
        } else {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                Object newInstance = cls.newInstance();
                Field field = cls.getField(str);
                field.setAccessible(true);
                f12937a = context.getResources().getDimensionPixelSize(Integer.parseInt(field.get(newInstance).toString()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (f12937a <= 0) {
            f12937a = m15862a(context, 25.0f);
        }
        return f12937a;
    }

    /* renamed from: a */
    public static int m15862a(Context context, float f) {
        return (int) (context == null ? f * 2.0f : (f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static <T extends View> T m15863a(View view, String str) {
        return view.findViewById(C3809l.m15789a(view.getContext(), str));
    }

    /* renamed from: a */
    public static View m15864a(ViewGroup viewGroup, String str, boolean z) {
        return m15874e(viewGroup.getContext()).inflate(C3809l.m15792b(viewGroup.getContext(), str), viewGroup, z);
    }

    /* renamed from: a */
    public static void m15865a(View view, int i, int i2) {
        if (!(view == null || i == 0 || i2 == 0)) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                int width = view2.getWidth();
                int height = view2.getHeight();
                if (!(width == 0 || height == 0)) {
                    LayoutParams layoutParams = view.getLayoutParams();
                    if (width > height) {
                        if (i <= i2) {
                            layoutParams.width = (int) ((((float) i) / (((float) i2) * 1.0f)) * ((float) height));
                            layoutParams.height = height;
                            view.setLayoutParams(layoutParams);
                        }
                    } else if (i2 <= i) {
                        layoutParams.width = width;
                        layoutParams.height = (int) ((((float) i2) / (((float) i) * 1.0f)) * ((float) width));
                        view.setLayoutParams(layoutParams);
                    }
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m15866a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(uptimeMillis - f12938b) >= 500) {
            return false;
        }
        f12938b = uptimeMillis;
        return true;
    }

    /* renamed from: a */
    public static boolean m15867a(View view, int i) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (m15873d(view.getContext()) && m15871b(view, i, true)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m15868a(View view, int i, boolean z) {
        boolean z2 = false;
        if (view == null) {
            return false;
        }
        if (m15873d(view.getContext()) && m15871b(view, i, z)) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: a */
    public static int[] m15869a(View view) {
        int[] iArr = new int[2];
        iArr[0] = (int) (((float) iArr[0]) + view.getX());
        iArr[1] = (int) (((float) iArr[1]) + view.getY());
        View rootView = view.getRootView();
        while (view != rootView) {
            view = (View) view.getParent();
            if (view == null) {
                break;
            }
            iArr[0] = (int) (((float) iArr[0]) + view.getX());
            iArr[1] = (int) (((float) iArr[1]) + view.getY());
        }
        return iArr;
    }

    @Deprecated
    /* renamed from: b */
    public static int m15870b(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: b */
    private static boolean m15871b(View view, int i, boolean z) {
        boolean z2 = false;
        if (view == null || view.getParent() == null) {
            return false;
        }
        if (!view.isShown() && view.getVisibility() != 0) {
            return false;
        }
        if (z && !view.hasWindowFocus()) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = ((long) rect.height()) * ((long) rect.width());
            long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
            if (height2 > 0 && height * 100 >= ((long) i) * height2) {
                z2 = true;
            }
        }
        return z2;
    }

    @Deprecated
    /* renamed from: c */
    public static int m15872c(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* renamed from: d */
    private static boolean m15873d(Context context) {
        boolean z = false;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            Method method = powerManager != null ? powerManager.getClass().getMethod("isScreenOn", new Class[0]) : null;
            if (method != null && ((Boolean) method.invoke(powerManager, new Object[0])).booleanValue()) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            C4065b.m16865a(e);
            return false;
        }
    }

    /* renamed from: e */
    private static LayoutInflater m15874e(Context context) {
        return LayoutInflater.from(context);
    }
}
