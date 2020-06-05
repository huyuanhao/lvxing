package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class ActivityNoticeCenterBindingImpl extends ActivityNoticeCenterBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10093c = null;
    /* renamed from: d */
    private static final SparseIntArray f10094d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10095e;
    /* renamed from: f */
    private long f10096f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10094d.put(R.id.refresh, 1);
        f10094d.put(R.id.list, 2);
    }

    public ActivityNoticeCenterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10093c, f10094d));
    }

    private ActivityNoticeCenterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (SmartRefreshLayout) objArr[1]);
        this.f10096f = -1;
        this.f10095e = objArr[0];
        this.f10095e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10096f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10096f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10096f;
            this.f10096f = 0;
        }
    }
}
