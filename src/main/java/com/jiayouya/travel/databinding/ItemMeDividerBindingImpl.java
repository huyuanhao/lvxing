package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;

public class ItemMeDividerBindingImpl extends ItemMeDividerBinding {
    /* renamed from: a */
    private static final IncludedLayouts f11071a = null;
    /* renamed from: b */
    private static final SparseIntArray f11072b = null;
    /* renamed from: c */
    private final Space f11073c;
    /* renamed from: d */
    private long f11074d;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    public ItemMeDividerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f11071a, f11072b));
    }

    private ItemMeDividerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11074d = -1;
        this.f11073c = objArr[0];
        this.f11073c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11074d = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11074d != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f11074d;
            this.f11074d = 0;
        }
    }
}
