package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class DialogGetBonusDogBindingImpl extends DialogGetBonusDogBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10394b = null;
    /* renamed from: c */
    private static final SparseIntArray f10395c = new SparseIntArray();
    /* renamed from: d */
    private final LinearLayout f10396d;
    /* renamed from: e */
    private long f10397e;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10395c.put(R.id.btn, 1);
    }

    public DialogGetBonusDogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f10394b, f10395c));
    }

    private DialogGetBonusDogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1]);
        this.f10397e = -1;
        this.f10396d = objArr[0];
        this.f10396d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10397e = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10397e != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10397e;
            this.f10397e = 0;
        }
    }
}
