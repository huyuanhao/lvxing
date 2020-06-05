package com.qiyukf.basesdk.p412c.p417d;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;

/* renamed from: com.qiyukf.basesdk.c.d.b */
public final class C5409b {
    /* renamed from: a */
    public static void m22130a(Activity activity) {
        if (activity != null && activity.getCurrentFocus() != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    /* renamed from: a */
    public static void m22131a(final View view) {
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.postDelayed(new Runnable() {
                public final void run() {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            }, 200);
        }
    }

    /* renamed from: a */
    public static void m22132a(Fragment fragment) {
        if (fragment != null) {
            m22130a((Activity) fragment.getActivity());
        }
    }

    /* renamed from: b */
    public static void m22133b(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }
}
