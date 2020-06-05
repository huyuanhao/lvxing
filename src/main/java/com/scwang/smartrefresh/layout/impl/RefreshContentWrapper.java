package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smartrefresh.layout.p527a.RefreshContent;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.p528b.CoordinatorLayoutListener;
import com.scwang.smartrefresh.layout.p529c.DesignUtil;
import com.scwang.smartrefresh.layout.p529c.ScrollBoundaryUtil;
import com.scwang.smartrefresh.layout.p529c.SmartUtil;
import java.util.Collections;
import java.util.LinkedList;

/* renamed from: com.scwang.smartrefresh.layout.impl.a */
public class RefreshContentWrapper implements AnimatorUpdateListener, RefreshContent, CoordinatorLayoutListener {
    /* renamed from: a */
    protected View f20924a;
    /* renamed from: b */
    protected View f20925b;
    /* renamed from: c */
    protected View f20926c;
    /* renamed from: d */
    protected View f20927d;
    /* renamed from: e */
    protected View f20928e;
    /* renamed from: f */
    protected int f20929f = 0;
    /* renamed from: g */
    protected boolean f20930g = true;
    /* renamed from: h */
    protected boolean f20931h = true;
    /* renamed from: i */
    protected ScrollBoundaryDeciderAdapter f20932i = new ScrollBoundaryDeciderAdapter();

    public RefreshContentWrapper(View view) {
        this.f20926c = view;
        this.f20925b = view;
        this.f20924a = view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31004a(View view, RefreshKernel iVar) {
        boolean isInEditMode = this.f20924a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = mo31003a(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                DesignUtil.m25574a(view, iVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f20926c = view2;
        }
    }

    /* renamed from: a */
    public void mo30957a(boolean z, boolean z2) {
        this.f20930g = z;
        this.f20931h = z2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo31003a(View view, boolean z) {
        LinkedList linkedList = new LinkedList(Collections.singletonList(view));
        View view2 = null;
        while (!linkedList.isEmpty() && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && SmartUtil.m25585c(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedList.add(viewGroup.getChildAt(i));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo31002a(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (ScrollBoundaryUtil.m25579a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ((childAt instanceof ViewPager) || !SmartUtil.m25585c(childAt)) {
                        pointF.offset(pointF2.x, pointF2.y);
                        childAt = mo31002a(childAt, pointF, view2);
                        pointF.offset(-pointF2.x, -pointF2.y);
                    }
                    return childAt;
                }
            }
        }
        return view2;
    }

    /* renamed from: a */
    public View mo30941a() {
        return this.f20924a;
    }

    /* renamed from: b */
    public View mo30947b() {
        return this.f20926c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo30942a(int r6, int r7, int r8) {
        /*
        r5 = this;
        r0 = 1
        r1 = -1
        r2 = 0
        r3 = 0
        if (r7 == r1) goto L_0x0021
        android.view.View r4 = r5.f20925b
        android.view.View r7 = r4.findViewById(r7)
        if (r7 == 0) goto L_0x0021
        if (r6 <= 0) goto L_0x0016
        float r4 = (float) r6
        r7.setTranslationY(r4)
        r7 = 1
        goto L_0x0022
    L_0x0016:
        float r4 = r7.getTranslationY()
        int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
        if (r4 <= 0) goto L_0x0021
        r7.setTranslationY(r3)
    L_0x0021:
        r7 = 0
    L_0x0022:
        if (r8 == r1) goto L_0x003f
        android.view.View r1 = r5.f20925b
        android.view.View r8 = r1.findViewById(r8)
        if (r8 == 0) goto L_0x003f
        if (r6 >= 0) goto L_0x0034
        float r7 = (float) r6
        r8.setTranslationY(r7)
        r7 = 1
        goto L_0x003f
    L_0x0034:
        float r0 = r8.getTranslationY()
        int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
        if (r0 >= 0) goto L_0x003f
        r8.setTranslationY(r3)
    L_0x003f:
        if (r7 != 0) goto L_0x0048
        android.view.View r7 = r5.f20925b
        float r8 = (float) r6
        r7.setTranslationY(r8)
        goto L_0x004d
    L_0x0048:
        android.view.View r7 = r5.f20925b
        r7.setTranslationY(r3)
    L_0x004d:
        android.view.View r7 = r5.f20927d
        if (r7 == 0) goto L_0x0059
        int r8 = java.lang.Math.max(r2, r6)
        float r8 = (float) r8
        r7.setTranslationY(r8)
    L_0x0059:
        android.view.View r7 = r5.f20928e
        if (r7 == 0) goto L_0x0065
        int r6 = java.lang.Math.min(r2, r6)
        float r6 = (float) r6
        r7.setTranslationY(r6)
    L_0x0065:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.impl.RefreshContentWrapper.mo30942a(int, int, int):void");
    }

    /* renamed from: c */
    public boolean mo30948c() {
        return this.f20930g && this.f20932i.mo30955a(this.f20924a);
    }

    /* renamed from: d */
    public boolean mo30949d() {
        return this.f20931h && this.f20932i.mo30956b(this.f20924a);
    }

    /* renamed from: a */
    public void mo30943a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset((float) (-this.f20924a.getLeft()), (float) (-this.f20924a.getTop()));
        View view = this.f20926c;
        View view2 = this.f20924a;
        if (view != view2) {
            this.f20926c = mo31002a(view2, pointF, view);
        }
        if (this.f20926c == this.f20924a) {
            this.f20932i.f20933a = null;
        } else {
            this.f20932i.f20933a = pointF;
        }
    }

    /* renamed from: a */
    public void mo30944a(RefreshKernel iVar, View view, View view2) {
        mo31004a(this.f20924a, iVar);
        if (view != null || view2 != null) {
            this.f20927d = view;
            this.f20928e = view2;
            FrameLayout frameLayout = new FrameLayout(this.f20924a.getContext());
            iVar.mo30931a().getLayout().removeView(this.f20924a);
            LayoutParams layoutParams = this.f20924a.getLayoutParams();
            frameLayout.addView(this.f20924a, -1, -1);
            iVar.mo30931a().getLayout().addView(frameLayout, layoutParams);
            this.f20924a = frameLayout;
            if (view != null) {
                view.setClickable(true);
                LayoutParams layoutParams2 = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams2.height = SmartUtil.m25581a(view);
                viewGroup.addView(new Space(this.f20924a.getContext()), indexOfChild, layoutParams2);
                frameLayout.addView(view);
            }
            if (view2 != null) {
                view2.setClickable(true);
                LayoutParams layoutParams3 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild2 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
                layoutParams3.height = SmartUtil.m25581a(view2);
                viewGroup2.addView(new Space(this.f20924a.getContext()), indexOfChild2, layoutParams3);
                layoutParams4.gravity = 80;
                frameLayout.addView(view2, layoutParams4);
            }
        }
    }

    /* renamed from: a */
    public void mo30945a(ScrollBoundaryDecider kVar) {
        if (kVar instanceof ScrollBoundaryDeciderAdapter) {
            this.f20932i = (ScrollBoundaryDeciderAdapter) kVar;
        } else {
            this.f20932i.f20934b = kVar;
        }
    }

    /* renamed from: a */
    public void mo30946a(boolean z) {
        this.f20932i.f20935c = z;
    }

    /* renamed from: a */
    public AnimatorUpdateListener mo30940a(int i) {
        View view = this.f20926c;
        if (view == null || i == 0 || ((i >= 0 || !ScrollBoundaryUtil.m25580b(view)) && (i <= 0 || !ScrollBoundaryUtil.m25576a(this.f20926c)))) {
            return null;
        }
        this.f20929f = i;
        return this;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            if (this.f20926c instanceof AbsListView) {
                SmartUtil.m25583a((AbsListView) this.f20926c, intValue - this.f20929f);
            } else {
                this.f20926c.scrollBy(0, intValue - this.f20929f);
            }
        } catch (Throwable unused) {
        }
        this.f20929f = intValue;
    }
}
