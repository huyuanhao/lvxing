package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;

public class DialogTaobaoAuthBindingImpl extends DialogTaobaoAuthBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10635d = null;
    /* renamed from: e */
    private static final SparseIntArray f10636e = new SparseIntArray();
    /* renamed from: f */
    private long f10637f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10636e.put(R.id.btn_go_taobao, 1);
        f10636e.put(R.id.iv_close, 2);
    }

    public DialogTaobaoAuthBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10635d, f10636e));
    }

    private DialogTaobaoAuthBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[1], (ImageView) objArr[2], (LinearLayout) objArr[0]);
        this.f10637f = -1;
        this.f10634c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10637f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10637f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10637f;
            this.f10637f = 0;
        }
    }
}
