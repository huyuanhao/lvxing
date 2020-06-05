package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class PopSortBindingImpl extends PopSortBinding {
    /* renamed from: c */
    private static final IncludedLayouts f11210c = null;
    /* renamed from: d */
    private static final SparseIntArray f11211d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f11212e;
    /* renamed from: f */
    private long f11213f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f11211d.put(R.id.tv_persons, 1);
        f11211d.put(R.id.tv_time, 2);
    }

    public PopSortBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f11210c, f11211d));
    }

    private PopSortBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2]);
        this.f11213f = -1;
        this.f11212e = objArr[0];
        this.f11212e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11213f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11213f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f11213f;
            this.f11213f = 0;
        }
    }
}
