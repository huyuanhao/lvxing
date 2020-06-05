package discoveryAD;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.DiscoverySdk;

/* renamed from: discoveryAD.va */
public class C7935va {
    private static final String TAG = "ads_SDK";
    /* renamed from: qg */
    private static final float f26966qg = 0.9f;
    /* renamed from: rg */
    private static String f26967rg;

    /* renamed from: a */
    public static C7920oa m34351a(View view, float f) {
        String str = TAG;
        Log.m31483i(str, "checkVisible:");
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            return C7920oa.VIEW_NULL;
        }
        Context context = view.getContext();
        if (view.getParent() == null) {
            return C7920oa.PARENT_NULL;
        }
        if (view.getWindowVisibility() != 0) {
            return C7920oa.WINDOW_NOT_VISIBLE;
        }
        if (view.getVisibility() != 0) {
            return C7920oa.VIEW_NOT_VISIBLE;
        }
        if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            return C7920oa.VIEW_INVISIBLE_DIMENSIONS;
        }
        if (VERSION.SDK_INT >= 11 && view.getAlpha() < f26966qg) {
            return C7920oa.VIEW_TOO_TRANSPARENT;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int[] iArr = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f2 = (float) height;
            if (((float) iArr[1]) < (-f) * f2) {
                return C7920oa.TOP_INVISIBLE;
            }
            if (((float) iArr[1]) + (f2 * (1.0f - f)) > ((float) displayMetrics.heightPixels)) {
                return C7920oa.BOTTOM_INVISIBLE;
            }
            if (iArr[0] < 0) {
                return C7920oa.LEFT_INVISIBLE;
            }
            if (iArr[0] + width > displayMetrics.widthPixels) {
                return C7920oa.RIGHT_INVISIBLE;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("checkVisible cost time:");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            Log.m31477d(str, sb.toString());
            return C7920oa.NO_ERROR;
        } catch (NullPointerException unused) {
            return C7920oa.CAN_NOT_GET_LOCATION;
        }
    }

    /* renamed from: a */
    private static boolean m34352a(Rect rect, View view) {
        boolean z = false;
        if ((view instanceof ViewGroup) && (view.getBackground() == null || (VERSION.SDK_INT >= 19 && view.getBackground().getAlpha() <= 0))) {
            return false;
        }
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        if (rect.left < rect2.right && rect.right > rect2.left && rect.top < rect2.bottom && rect.bottom > rect2.top) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m34353b(Rect rect, View view) {
        if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        for (int indexOfChild = viewGroup.indexOfChild(view) + 1; indexOfChild < viewGroup.getChildCount(); indexOfChild++) {
            if (m34355c(rect, viewGroup.getChildAt(indexOfChild))) {
                return true;
            }
        }
        return m34353b(rect, viewGroup);
    }

    /* renamed from: c */
    public static C7920oa m34354c(View view) {
        Log.m31483i(TAG, "checkAttached:");
        return view == null ? C7920oa.VIEW_NULL : !view.isShown() ? C7920oa.VIEW_NOT_VISIBLE : view.getWindowVisibility() != 0 ? C7920oa.WINDOW_NOT_VISIBLE : (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) ? C7920oa.UN_LAYOUT : (VERSION.SDK_INT < 11 || view.getAlpha() >= f26966qg) ? C7920oa.NO_ERROR : C7920oa.VIEW_TOO_TRANSPARENT;
    }

    /* renamed from: c */
    private static boolean m34355c(Rect rect, View view) {
        if (view.isShown() && (VERSION.SDK_INT < 11 || view.getAlpha() > 0.0f)) {
            if (m34352a(rect, view)) {
                return true;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (m34355c(rect, viewGroup.getChildAt(i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    public static C7920oa m34356d(View view) {
        return m34351a(view, 0.5f);
    }

    /* renamed from: mb */
    public static String m34357mb() {
        if (f26967rg == null) {
            f26967rg = new WebView(DiscoverySdk.getInstance().getContext()).getSettings().getUserAgentString();
        }
        return f26967rg;
    }
}
