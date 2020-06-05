package com.qiyukf.unicorn.p516j;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* renamed from: com.qiyukf.unicorn.j.j */
public final class C6228j {
    /* renamed from: a */
    public static void m24666a(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m24666a(viewGroup.getChildAt(i), z);
            }
        }
    }

    /* renamed from: a */
    public static void m24667a(Window window, float f) {
        LayoutParams attributes = window.getAttributes();
        attributes.alpha = f;
        window.setAttributes(attributes);
    }
}
