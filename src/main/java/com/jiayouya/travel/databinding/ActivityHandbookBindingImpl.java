package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class ActivityHandbookBindingImpl extends ActivityHandbookBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10008c = null;
    /* renamed from: d */
    private static final SparseIntArray f10009d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10010e;
    /* renamed from: f */
    private long f10011f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10009d.put(R.id.refresh, 1);
        f10009d.put(R.id.list, 2);
    }

    public ActivityHandbookBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10008c, f10009d));
    }

    private ActivityHandbookBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (SmartRefreshLayout) objArr[1]);
        this.f10011f = -1;
        this.f10010e = objArr[0];
        this.f10010e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10011f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10011f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10011f;
            this.f10011f = 0;
        }
    }
}
