package com.qiyukf.unicorn.widget.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    /* renamed from: a */
    protected List<List<View>> f19852a;
    /* renamed from: b */
    protected List<Integer> f19853b;
    /* renamed from: c */
    protected List<Integer> f19854c;
    /* renamed from: d */
    private int f19855d;
    /* renamed from: e */
    private List<View> f19856e;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19852a = new ArrayList();
        this.f19853b = new ArrayList();
        this.f19854c = new ArrayList();
        this.f19855d = -1;
        this.f19856e = new ArrayList();
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new MarginLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        this.f19852a.clear();
        this.f19853b.clear();
        this.f19854c.clear();
        this.f19856e.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i7 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f19853b.add(Integer.valueOf(i6));
                    this.f19852a.add(this.f19856e);
                    this.f19854c.add(Integer.valueOf(i7));
                    i6 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.f19856e = new ArrayList();
                    i7 = 0;
                }
                i7 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i6 = Math.max(i6, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.f19856e.add(childAt);
            }
        }
        this.f19853b.add(Integer.valueOf(i6));
        this.f19854c.add(Integer.valueOf(i7));
        this.f19852a.add(this.f19856e);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f19852a.size();
        int i9 = paddingLeft;
        int i10 = 0;
        while (i10 < size) {
            this.f19856e = (List) this.f19852a.get(i10);
            int intValue = ((Integer) this.f19853b.get(i10)).intValue();
            int intValue2 = ((Integer) this.f19854c.get(i10)).intValue();
            int i11 = this.f19855d;
            if (i11 != -1) {
                if (i11 == 0) {
                    i5 = (width - intValue2) / 2;
                } else if (i11 == 1) {
                    i5 = width - intValue2;
                }
                i9 = i5 + getPaddingLeft();
            } else {
                i9 = getPaddingLeft();
            }
            int i12 = i9;
            for (int i13 = 0; i13 < this.f19856e.size(); i13++) {
                View view = (View) this.f19856e.get(i13);
                if (view.getVisibility() != 8) {
                    MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                    int i14 = marginLayoutParams2.leftMargin + i12;
                    int i15 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i14, i15, view.getMeasuredWidth() + i14, view.getMeasuredHeight() + i15);
                    i12 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingTop += intValue;
            i10++;
            i9 = i12;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8) {
                if (i4 == childCount - 1) {
                    i5 = Math.max(i6, i5);
                    i8 += i7;
                }
                int i9 = i;
                int i10 = i2;
                i3 = size2;
            } else {
                measureChild(childAt, i, i2);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                i3 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i11 = i6 + measuredWidth;
                if (i11 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i5 = Math.max(i5, i6);
                    i8 += i7;
                } else {
                    measuredHeight = Math.max(i7, measuredHeight);
                    measuredWidth = i11;
                }
                if (i4 == childCount - 1) {
                    i5 = Math.max(measuredWidth, i5);
                    i8 += measuredHeight;
                }
                i7 = measuredHeight;
                i6 = measuredWidth;
            }
            i4++;
            size2 = i3;
        }
        int i12 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + i5 + getPaddingLeft();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i12 : i8 + getPaddingTop() + getPaddingBottom());
    }
}
