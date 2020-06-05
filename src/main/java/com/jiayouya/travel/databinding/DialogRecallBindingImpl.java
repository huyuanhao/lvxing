package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;

public class DialogRecallBindingImpl extends DialogRecallBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10586c = null;
    /* renamed from: d */
    private static final SparseIntArray f10587d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10588e;
    /* renamed from: f */
    private long f10589f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10587d.put(R.id.btn, 1);
        f10587d.put(R.id.iv_close, 2);
    }

    public DialogRecallBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10586c, f10587d));
    }

    private DialogRecallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[1], (ImageView) objArr[2]);
        this.f10589f = -1;
        this.f10588e = objArr[0];
        this.f10588e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10589f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10589f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10589f;
            this.f10589f = 0;
        }
    }
}
