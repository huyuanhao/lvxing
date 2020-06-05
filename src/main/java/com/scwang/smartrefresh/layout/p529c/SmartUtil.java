package com.scwang.smartrefresh.layout.p529c;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/* renamed from: com.scwang.smartrefresh.layout.c.e */
public class SmartUtil {
    /* renamed from: a */
    public static int m25581a(View view) {
        int i;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        if (layoutParams.height > 0) {
            i = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            i = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
        return view.getMeasuredHeight();
    }

    /* renamed from: a */
    public static void m25583a(AbsListView absListView, int i) {
        if (VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i);
        } else if (absListView instanceof ListView) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition != -1) {
                View childAt = absListView.getChildAt(0);
                if (childAt != null) {
                    ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
                }
            }
        } else {
            absListView.smoothScrollBy(i, 0);
        }
    }

    /* renamed from: b */
    public static boolean m25584b(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    /* renamed from: c */
    public static boolean m25585c(View view) {
        return m25584b(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent);
    }

    /* renamed from: a */
    public static void m25582a(View view, int i) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i);
        } else if (view instanceof AbsListView) {
            if (VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i);
        }
    }
}
