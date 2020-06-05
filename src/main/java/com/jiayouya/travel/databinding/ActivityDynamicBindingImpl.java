package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.p653ui.widget.CenteredTitleBar;

public class ActivityDynamicBindingImpl extends ActivityDynamicBinding {
    /* renamed from: d */
    private static final IncludedLayouts f9962d = null;
    /* renamed from: e */
    private static final SparseIntArray f9963e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f9964f;
    /* renamed from: g */
    private long f9965g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f9963e.put(R.id.toolbar, 1);
        f9963e.put(R.id.refresh, 2);
        f9963e.put(R.id.list, 3);
    }

    public ActivityDynamicBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f9962d, f9963e));
    }

    private ActivityDynamicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[3], (SmartRefreshLayout) objArr[2], (CenteredTitleBar) objArr[1]);
        this.f9965g = -1;
        this.f9964f = objArr[0];
        this.f9964f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9965g = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9965g != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f9965g;
            this.f9965g = 0;
        }
    }
}
