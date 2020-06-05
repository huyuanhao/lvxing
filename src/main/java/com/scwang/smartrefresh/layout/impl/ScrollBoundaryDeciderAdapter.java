package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.p527a.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.p529c.ScrollBoundaryUtil;

/* renamed from: com.scwang.smartrefresh.layout.impl.b */
public class ScrollBoundaryDeciderAdapter implements ScrollBoundaryDecider {
    /* renamed from: a */
    public PointF f20933a;
    /* renamed from: b */
    public ScrollBoundaryDecider f20934b;
    /* renamed from: c */
    public boolean f20935c = true;

    /* renamed from: a */
    public boolean mo30955a(View view) {
        ScrollBoundaryDecider kVar = this.f20934b;
        if (kVar != null) {
            return kVar.mo30955a(view);
        }
        return ScrollBoundaryUtil.m25577a(view, this.f20933a);
    }

    /* renamed from: b */
    public boolean mo30956b(View view) {
        ScrollBoundaryDecider kVar = this.f20934b;
        if (kVar != null) {
            return kVar.mo30956b(view);
        }
        return ScrollBoundaryUtil.m25578a(view, this.f20933a, this.f20935c);
    }
}
