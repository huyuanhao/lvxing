package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;

public class DialogResurgenceBindingImpl extends DialogResurgenceBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10612c = null;
    /* renamed from: d */
    private static final SparseIntArray f10613d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10614e;
    /* renamed from: f */
    private long f10615f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10613d.put(R.id.btn, 1);
        f10613d.put(R.id.iv_close, 2);
    }

    public DialogResurgenceBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10612c, f10613d));
    }

    private DialogResurgenceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[1], (ImageView) objArr[2]);
        this.f10615f = -1;
        this.f10614e = objArr[0];
        this.f10614e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10615f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10615f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10615f;
            this.f10615f = 0;
        }
    }
}
