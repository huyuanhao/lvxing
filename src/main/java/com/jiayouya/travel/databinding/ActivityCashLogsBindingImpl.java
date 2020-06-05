package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class ActivityCashLogsBindingImpl extends ActivityCashLogsBinding {
    /* renamed from: c */
    private static final IncludedLayouts f9946c = null;
    /* renamed from: d */
    private static final SparseIntArray f9947d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f9948e;
    /* renamed from: f */
    private long f9949f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f9947d.put(R.id.refresh, 1);
        f9947d.put(R.id.list, 2);
    }

    public ActivityCashLogsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f9946c, f9947d));
    }

    private ActivityCashLogsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (SmartRefreshLayout) objArr[1]);
        this.f9949f = -1;
        this.f9948e = objArr[0];
        this.f9948e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9949f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9949f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f9949f;
            this.f9949f = 0;
        }
    }
}
