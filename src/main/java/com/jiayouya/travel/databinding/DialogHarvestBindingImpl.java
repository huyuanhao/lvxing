package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class DialogHarvestBindingImpl extends DialogHarvestBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10441b = null;
    /* renamed from: c */
    private static final SparseIntArray f10442c = new SparseIntArray();
    /* renamed from: d */
    private final LinearLayout f10443d;
    /* renamed from: e */
    private long f10444e;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10442c.put(R.id.iv_close, 1);
    }

    public DialogHarvestBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f10441b, f10442c));
    }

    private DialogHarvestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1]);
        this.f10444e = -1;
        this.f10443d = objArr[0];
        this.f10443d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10444e = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10444e != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10444e;
            this.f10444e = 0;
        }
    }
}
