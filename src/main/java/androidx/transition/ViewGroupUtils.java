package androidx.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

class ViewGroupUtils {
    static ViewGroupOverlayImpl getOverlay(ViewGroup viewGroup) {
        if (VERSION.SDK_INT >= 18) {
            return new ViewGroupOverlayApi18(viewGroup);
        }
        return ViewGroupOverlayApi14.createFrom(viewGroup);
    }

    static void suppressLayout(ViewGroup viewGroup, boolean z) {
        if (VERSION.SDK_INT >= 18) {
            ViewGroupUtilsApi18.suppressLayout(viewGroup, z);
        } else {
            ViewGroupUtilsApi14.suppressLayout(viewGroup, z);
        }
    }

    private ViewGroupUtils() {
    }
}
