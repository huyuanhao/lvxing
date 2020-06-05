package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class DialogTargetExplainBindingImpl extends DialogTargetExplainBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10639b = null;
    /* renamed from: c */
    private static final SparseIntArray f10640c = new SparseIntArray();
    /* renamed from: d */
    private final LinearLayout f10641d;
    /* renamed from: e */
    private long f10642e;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10640c.put(R.id.btn, 1);
    }

    public DialogTargetExplainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f10639b, f10640c));
    }

    private DialogTargetExplainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1]);
        this.f10642e = -1;
        this.f10641d = objArr[0];
        this.f10641d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10642e = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10642e != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10642e;
            this.f10642e = 0;
        }
    }
}
