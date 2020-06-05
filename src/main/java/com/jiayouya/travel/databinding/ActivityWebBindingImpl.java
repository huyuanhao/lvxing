package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.common.widget.LollipopFixedWebView;
import ezy.p653ui.widget.CenteredTitleBar;

public class ActivityWebBindingImpl extends ActivityWebBinding {
    /* renamed from: f */
    private static final IncludedLayouts f10251f = null;
    /* renamed from: g */
    private static final SparseIntArray f10252g = new SparseIntArray();
    /* renamed from: h */
    private final LinearLayout f10253h;
    /* renamed from: i */
    private long f10254i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10252g.put(R.id.toolbar, 1);
        f10252g.put(R.id.tv_close, 2);
        f10252g.put(R.id.iv_refresh, 3);
        f10252g.put(R.id.progress_bar, 4);
        f10252g.put(R.id.web, 5);
    }

    public ActivityWebBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f10251f, f10252g));
    }

    private ActivityWebBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ProgressBar) objArr[4], (CenteredTitleBar) objArr[1], (TextView) objArr[2], (LollipopFixedWebView) objArr[5]);
        this.f10254i = -1;
        this.f10253h = objArr[0];
        this.f10253h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10254i = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10254i != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10254i;
            this.f10254i = 0;
        }
    }
}
