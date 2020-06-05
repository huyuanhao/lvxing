package ezy.assist.p647b;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: ezy.assist.b.b */
public class SoftInputUtil {
    /* renamed from: a */
    public static void m34787a(View view) {
        m34788a(view, 0);
    }

    /* renamed from: a */
    public static void m34788a(View view, int i) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, i);
    }

    /* renamed from: b */
    public static boolean m34791b(View view, int i) {
        view.clearFocus();
        return ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), i);
    }

    /* renamed from: b */
    public static boolean m34790b(View view) {
        return m34791b(view, 0);
    }

    /* renamed from: a */
    public static boolean m34789a(Activity activity) {
        View peekDecorView = activity.getWindow().peekDecorView();
        if (peekDecorView != null) {
            return m34791b(peekDecorView, 0);
        }
        return false;
    }
}
