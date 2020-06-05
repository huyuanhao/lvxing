package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;

public class DialogLoadingBindingImpl extends DialogLoadingBinding {
    /* renamed from: a */
    private static final IncludedLayouts f10471a = null;
    /* renamed from: b */
    private static final SparseIntArray f10472b = null;
    /* renamed from: c */
    private final FrameLayout f10473c;
    /* renamed from: d */
    private long f10474d;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    public DialogLoadingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f10471a, f10472b));
    }

    private DialogLoadingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10474d = -1;
        this.f10473c = objArr[0];
        this.f10473c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10474d = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10474d != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10474d;
            this.f10474d = 0;
        }
    }
}
