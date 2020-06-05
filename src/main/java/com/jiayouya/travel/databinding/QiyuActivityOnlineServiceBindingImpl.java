package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.CenteredTitleBar;

public class QiyuActivityOnlineServiceBindingImpl extends QiyuActivityOnlineServiceBinding {
    /* renamed from: d */
    private static final IncludedLayouts f11217d = null;
    /* renamed from: e */
    private static final SparseIntArray f11218e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f11219f;
    /* renamed from: g */
    private long f11220g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f11218e.put(R.id.toolbar, 1);
        f11218e.put(R.id.sdkIconContainer, 2);
        f11218e.put(R.id.container, 3);
    }

    public QiyuActivityOnlineServiceBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f11217d, f11218e));
    }

    private QiyuActivityOnlineServiceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[3], (FrameLayout) objArr[2], (CenteredTitleBar) objArr[1]);
        this.f11220g = -1;
        this.f11219f = objArr[0];
        this.f11219f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11220g = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11220g != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f11220g;
            this.f11220g = 0;
        }
    }
}
