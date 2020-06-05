package com.yanzhenjie.album.widget.photoview;

import android.os.Build.VERSION;
import android.view.View;
import androidx.core.view.MotionEventCompat;

/* renamed from: com.yanzhenjie.album.widget.photoview.a */
public class Compat {
    /* renamed from: a */
    public static int m33659a(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    /* renamed from: a */
    public static void m33660a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            m33661b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    /* renamed from: b */
    private static void m33661b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
