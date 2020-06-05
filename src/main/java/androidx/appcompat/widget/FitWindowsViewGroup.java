package androidx.appcompat.widget;

import android.graphics.Rect;

public interface FitWindowsViewGroup {

    /* renamed from: androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener */
    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(Rect rect);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener);
}
