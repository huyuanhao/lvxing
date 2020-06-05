package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout.C6496c;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import com.scwang.smartrefresh.layout.p527a.RefreshFooter;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshInternal;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;

public abstract class InternalAbstract extends RelativeLayout implements RefreshInternal {
    /* renamed from: aa */
    protected View f20936aa;
    /* renamed from: ab */
    protected SpinnerStyle f20937ab;
    /* renamed from: ac */
    protected RefreshInternal f20938ac;

    protected InternalAbstract(View view) {
        this(view, view instanceof RefreshInternal ? (RefreshInternal) view : null);
    }

    protected InternalAbstract(View view, RefreshInternal hVar) {
        super(view.getContext(), null, 0);
        this.f20936aa = view;
        this.f20938ac = hVar;
    }

    protected InternalAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof RefreshInternal)) {
            return false;
        }
        if (getView() != ((RefreshInternal) obj).getView()) {
            z = false;
        }
        return z;
    }

    public View getView() {
        View view = this.f20936aa;
        return view == null ? this : view;
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        RefreshInternal hVar = this.f20938ac;
        if (hVar == null || hVar == this) {
            return 0;
        }
        return hVar.mo30670a(jVar, z);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        RefreshInternal hVar = this.f20938ac;
        if (hVar != null && hVar != this) {
            hVar.setPrimaryColors(iArr);
        }
    }

    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle spinnerStyle = this.f20937ab;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        RefreshInternal hVar = this.f20938ac;
        if (hVar != null && hVar != this) {
            return hVar.getSpinnerStyle();
        }
        View view = this.f20936aa;
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof C6496c) {
                this.f20937ab = ((C6496c) layoutParams).f20838b;
                SpinnerStyle spinnerStyle2 = this.f20937ab;
                if (spinnerStyle2 != null) {
                    return spinnerStyle2;
                }
            }
            if (layoutParams != null && (layoutParams.height == 0 || layoutParams.height == -1)) {
                SpinnerStyle spinnerStyle3 = SpinnerStyle.Scale;
                this.f20937ab = spinnerStyle3;
                return spinnerStyle3;
            }
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
        this.f20937ab = spinnerStyle4;
        return spinnerStyle4;
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        RefreshInternal hVar = this.f20938ac;
        if (hVar == null || hVar == this) {
            View view = this.f20936aa;
            if (view != null) {
                LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof C6496c) {
                    iVar.mo30927a((RefreshInternal) this, ((C6496c) layoutParams).f20837a);
                    return;
                }
                return;
            }
            return;
        }
        hVar.mo30677a(iVar, i, i2);
    }

    /* renamed from: f */
    public boolean mo30952f() {
        RefreshInternal hVar = this.f20938ac;
        return (hVar == null || hVar == this || !hVar.mo30952f()) ? false : true;
    }

    /* renamed from: a */
    public void mo30951a(float f, int i, int i2) {
        RefreshInternal hVar = this.f20938ac;
        if (hVar != null && hVar != this) {
            hVar.mo30951a(f, i, i2);
        }
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        RefreshInternal hVar = this.f20938ac;
        if (hVar != null && hVar != this) {
            hVar.mo30672a(z, f, i, i2, i3);
        }
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        RefreshInternal hVar = this.f20938ac;
        if (hVar != null && hVar != this) {
            hVar.mo30671a(jVar, i, i2);
        }
    }

    /* renamed from: b */
    public void mo30679b(RefreshLayout jVar, int i, int i2) {
        RefreshInternal hVar = this.f20938ac;
        if (hVar != null && hVar != this) {
            hVar.mo30679b(jVar, i, i2);
        }
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        RefreshInternal hVar = this.f20938ac;
        if (hVar != null && hVar != this) {
            if ((this instanceof RefreshFooterWrapper) && (hVar instanceof RefreshHeader)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof RefreshHeaderWrapper) && (this.f20938ac instanceof RefreshFooter)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            this.f20938ac.mo30678a(jVar, refreshState, refreshState2);
        }
    }
}
