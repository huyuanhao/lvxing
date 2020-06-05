package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class FragmentProfitRankListBindingImpl extends FragmentProfitRankListBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10775c = null;
    /* renamed from: d */
    private static final SparseIntArray f10776d = new SparseIntArray();
    /* renamed from: e */
    private final FrameLayout f10777e;
    /* renamed from: f */
    private long f10778f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10776d.put(R.id.refresh, 1);
        f10776d.put(R.id.list, 2);
    }

    public FragmentProfitRankListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10775c, f10776d));
    }

    private FragmentProfitRankListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (SmartRefreshLayout) objArr[1]);
        this.f10778f = -1;
        this.f10777e = objArr[0];
        this.f10777e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10778f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10778f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10778f;
            this.f10778f = 0;
        }
    }
}
