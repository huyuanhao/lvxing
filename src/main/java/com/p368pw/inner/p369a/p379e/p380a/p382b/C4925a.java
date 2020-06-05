package com.p368pw.inner.p369a.p379e.p380a.p382b;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.pw.inner.a.e.a.b.a */
public class C4925a {
    /* renamed from: a */
    private static final AtomicInteger f15925a = new AtomicInteger(1);

    /* renamed from: a */
    public static float m20442a(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    public static int m20443a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static Drawable m20444a(int i, int i2, int i3) {
        return new LayerDrawable(new Drawable[]{new ColorDrawable(i), new ClipDrawable(new ColorDrawable(i2), 3, 1), new ClipDrawable(new ColorDrawable(i3), 3, 1)});
    }

    /* renamed from: a */
    public static void m20445a(View... viewArr) {
        if (viewArr != null && viewArr.length != 0) {
            for (View view : viewArr) {
                if (view != null) {
                    try {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(view);
                        }
                        if (view instanceof ViewGroup) {
                            ((ViewGroup) view).removeAllViews();
                        }
                        view.destroyDrawingCache();
                    } catch (Throwable th) {
                        C5205o.m21464a(th);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static int m20446b(float f, Context context) {
        return (int) (m20442a(f, context) + 0.5f);
    }

    /* renamed from: b */
    public static int m20447b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
