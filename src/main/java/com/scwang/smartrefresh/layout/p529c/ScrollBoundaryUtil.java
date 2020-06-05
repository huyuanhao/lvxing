package com.scwang.smartrefresh.layout.p529c;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

/* renamed from: com.scwang.smartrefresh.layout.c.d */
public class ScrollBoundaryUtil {
    /* renamed from: a */
    public static boolean m25577a(View view, PointF pointF) {
        if (m25576a(view) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (m25579a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a = m25577a(childAt, pointF);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m25578a(View view, PointF pointF, boolean z) {
        boolean z2 = false;
        if (m25580b(view) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !SmartUtil.m25584b(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (m25579a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a = m25578a(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a;
                }
            }
        }
        if (z || m25576a(view)) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: a */
    public static boolean m25576a(View view) {
        if (VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(-1);
        }
        boolean z = true;
        if (view instanceof AbsListView) {
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            if (viewGroup.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && viewGroup.getChildAt(0).getTop() >= view.getPaddingTop())) {
                z = false;
            }
            return z;
        }
        if (view.getScrollY() <= 0) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
            if (r0.getChildAt(r4).getBottom() <= r5.getPaddingBottom()) goto L_0x002e;
     */
    /* renamed from: b */
    public static boolean m25580b(android.view.View r5) {
        /*
        int r0 = android.os.Build.VERSION.SDK_INT
        r1 = 1
        r2 = 14
        if (r0 >= r2) goto L_0x0039
        boolean r0 = r5 instanceof android.widget.AbsListView
        r2 = 0
        if (r0 == 0) goto L_0x0030
        r0 = r5
        android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        r3 = r5
        android.widget.AbsListView r3 = (android.widget.AbsListView) r3
        int r4 = r0.getChildCount()
        if (r4 <= 0) goto L_0x002e
        int r3 = r3.getLastVisiblePosition()
        int r4 = r4 - r1
        if (r3 < r4) goto L_0x002f
        android.view.View r0 = r0.getChildAt(r4)
        int r0 = r0.getBottom()
        int r5 = r5.getPaddingBottom()
        if (r0 <= r5) goto L_0x002e
        goto L_0x002f
    L_0x002e:
        r1 = 0
    L_0x002f:
        return r1
    L_0x0030:
        int r5 = r5.getScrollY()
        if (r5 >= 0) goto L_0x0037
        goto L_0x0038
    L_0x0037:
        r1 = 0
    L_0x0038:
        return r1
    L_0x0039:
        boolean r5 = r5.canScrollVertically(r1)
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.p529c.ScrollBoundaryUtil.m25580b(android.view.View):boolean");
    }

    /* renamed from: a */
    public static boolean m25579a(View view, View view2, float f, float f2, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f, f2};
        fArr[0] = fArr[0] + ((float) (view.getScrollX() - view2.getLeft()));
        fArr[1] = fArr[1] + ((float) (view.getScrollY() - view2.getTop()));
        boolean z = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f, fArr[1] - f2);
        }
        return z;
    }
}
