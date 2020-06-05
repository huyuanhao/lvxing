package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class ActivityBonusLogsBindingImpl extends ActivityBonusLogsBinding {
    /* renamed from: c */
    private static final IncludedLayouts f9912c = null;
    /* renamed from: d */
    private static final SparseIntArray f9913d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f9914e;
    /* renamed from: f */
    private long f9915f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f9913d.put(R.id.refresh, 1);
        f9913d.put(R.id.list, 2);
    }

    public ActivityBonusLogsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f9912c, f9913d));
    }

    private ActivityBonusLogsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (SmartRefreshLayout) objArr[1]);
        this.f9915f = -1;
        this.f9914e = objArr[0];
        this.f9914e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9915f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9915f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f9915f;
            this.f9915f = 0;
        }
    }
}
