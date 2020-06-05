package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import com.google.android.material.tabs.TabLayout;
import com.jiayouya.travel.R;

public class ActivityMainBindingImpl extends ActivityMainBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10050c = null;
    /* renamed from: d */
    private static final SparseIntArray f10051d = new SparseIntArray();
    /* renamed from: e */
    private final FrameLayout f10052e;
    /* renamed from: f */
    private long f10053f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10051d.put(R.id.container, 1);
        f10051d.put(R.id.tabLayout, 2);
    }

    public ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10050c, f10051d));
    }

    private ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[1], (TabLayout) objArr[2]);
        this.f10053f = -1;
        this.f10052e = objArr[0];
        this.f10052e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10053f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10053f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10053f;
            this.f10053f = 0;
        }
    }
}
