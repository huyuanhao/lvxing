package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;

public class EntryViewPager extends ViewPager {
    /* renamed from: a */
    private int f14454a = 0;
    /* renamed from: b */
    private final int f14455b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    /* renamed from: c */
    private float f14456c;
    /* renamed from: d */
    private float f14457d;
    /* renamed from: e */
    private float f14458e;

    public EntryViewPager(Context context) {
        super(context);
    }

    public EntryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
            if ((java.lang.Math.abs(r3) - java.lang.Math.abs(r0)) > ((float) r6.f14455b)) goto L_0x0063;
     */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        int r0 = r7.getAction()
        r1 = 0
        r2 = 1
        if (r0 == 0) goto L_0x006b
        r3 = 2
        if (r0 == r3) goto L_0x000d
        goto L_0x00b8
    L_0x000d:
        float r0 = r7.getRawX()
        float r3 = r7.getRawY()
        float r4 = r6.f14456c
        float r0 = r0 - r4
        float r4 = r6.f14457d
        float r3 = r3 - r4
        float r4 = java.lang.Math.abs(r0)
        float r5 = java.lang.Math.abs(r3)
        float r4 = r4 - r5
        int r5 = r6.f14455b
        float r5 = (float) r5
        int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
        if (r4 <= 0) goto L_0x0053
        int r3 = r6.f14454a
        if (r3 == r2) goto L_0x004b
        int r3 = r6.getCurrentItem()
        r4 = 0
        if (r3 != 0) goto L_0x003b
        int r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
        if (r3 <= 0) goto L_0x003b
        goto L_0x0063
    L_0x003b:
        int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
        if (r0 >= 0) goto L_0x004b
        int r0 = r6.getScrollX()
        float r0 = (float) r0
        float r3 = r6.f14458e
        int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
        if (r0 < 0) goto L_0x004b
        goto L_0x0063
    L_0x004b:
        android.view.ViewParent r0 = r6.getParent()
        r0.requestDisallowInterceptTouchEvent(r2)
        goto L_0x00b8
    L_0x0053:
        float r2 = java.lang.Math.abs(r3)
        float r0 = java.lang.Math.abs(r0)
        float r2 = r2 - r0
        int r0 = r6.f14455b
        float r0 = (float) r0
        int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
        if (r0 <= 0) goto L_0x00b8
    L_0x0063:
        android.view.ViewParent r0 = r6.getParent()
        r0.requestDisallowInterceptTouchEvent(r1)
        goto L_0x00b8
    L_0x006b:
        int r0 = r6.f14454a
        if (r0 != r2) goto L_0x0077
        android.view.ViewParent r0 = r6.getParent()
        r0.requestDisallowInterceptTouchEvent(r2)
        goto L_0x007e
    L_0x0077:
        android.view.ViewParent r0 = r6.getParent()
        r0.requestDisallowInterceptTouchEvent(r1)
    L_0x007e:
        float r0 = r7.getRawX()
        r6.f14456c = r0
        float r0 = r7.getRawY()
        r6.f14457d = r0
        androidx.viewpager.widget.PagerAdapter r0 = r6.getAdapter()
        int r0 = r0.getCount()
        float r3 = (float) r0
        androidx.viewpager.widget.PagerAdapter r4 = r6.getAdapter()
        float r1 = r4.getPageWidth(r1)
        float r3 = r3 * r1
        int r1 = r6.getWidth()
        float r1 = (float) r1
        float r3 = r3 * r1
        int r0 = r0 - r2
        int r1 = r6.getPageMargin()
        int r0 = r0 * r1
        float r0 = (float) r0
        float r3 = r3 + r0
        int r0 = r6.getWidth()
        float r0 = (float) r0
        float r3 = r3 - r0
        r0 = 1084227584(0x40a00000, float:5.0)
        float r3 = r3 - r0
        r6.f14458e = r3
    L_0x00b8:
        boolean r7 = super.dispatchTouchEvent(r7)
        return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.entry.view.EntryViewPager.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDragMode(int i) {
        this.f14454a = i;
    }
}
