package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;

public class ItemMayHarvestBindingImpl extends ItemMayHarvestBinding {
    /* renamed from: a */
    private static final IncludedLayouts f11067a = null;
    /* renamed from: b */
    private static final SparseIntArray f11068b = null;
    /* renamed from: c */
    private final FrameLayout f11069c;
    /* renamed from: d */
    private long f11070d;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    public ItemMayHarvestBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f11067a, f11068b));
    }

    private ItemMayHarvestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11070d = -1;
        this.f11069c = objArr[0];
        this.f11069c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11070d = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11070d != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f11070d;
            this.f11070d = 0;
        }
    }
}
