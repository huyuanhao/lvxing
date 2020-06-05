package com.app.hubert.guide.p128b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* renamed from: com.app.hubert.guide.b.b */
public class ViewUtils {
    /* renamed from: a */
    public static Rect m4781a(View view, View view2) {
        if (view2 == null || view == null) {
            throw new IllegalArgumentException("parent and child can not be null .");
        }
        View view3 = null;
        Context context = view2.getContext();
        if (context instanceof Activity) {
            view3 = ((Activity) context).getWindow().getDecorView();
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        if (view2 == view) {
            view2.getHitRect(rect);
            return rect;
        }
        View view4 = view2;
        while (view4 != view3 && view4 != view) {
            view4.getHitRect(rect2);
            if (!view4.getClass().equals("NoSaveStateFrameLayout")) {
                rect.left += rect2.left;
                rect.top += rect2.top;
            }
            view4 = (View) view4.getParent();
            if (view4 == null) {
                throw new IllegalArgumentException("the view is not showing in the window!");
            } else if (view4.getParent() != null && (view4.getParent() instanceof ViewPager)) {
                view4 = (View) view4.getParent();
            }
        }
        rect.right = rect.left + view2.getMeasuredWidth();
        rect.bottom = rect.top + view2.getMeasuredHeight();
        return rect;
    }
}
