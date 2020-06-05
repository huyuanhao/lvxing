package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class FragmentDogRankListBindingImpl extends FragmentDogRankListBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10741c = null;
    /* renamed from: d */
    private static final SparseIntArray f10742d = new SparseIntArray();
    /* renamed from: e */
    private final FrameLayout f10743e;
    /* renamed from: f */
    private long f10744f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10742d.put(R.id.refresh, 1);
        f10742d.put(R.id.list, 2);
    }

    public FragmentDogRankListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10741c, f10742d));
    }

    private FragmentDogRankListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (SmartRefreshLayout) objArr[1]);
        this.f10744f = -1;
        this.f10743e = objArr[0];
        this.f10743e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10744f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10744f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10744f;
            this.f10744f = 0;
        }
    }
}
