package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;

public class DialogCashRuleBindingImpl extends DialogCashRuleBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10293d = null;
    /* renamed from: e */
    private static final SparseIntArray f10294e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10295f;
    /* renamed from: g */
    private long f10296g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10294e.put(R.id.iv_close, 1);
        f10294e.put(R.id.list, 2);
        f10294e.put(R.id.btn, 3);
    }

    public DialogCashRuleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f10293d, f10294e));
    }

    private DialogCashRuleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[3], (ImageView) objArr[1], (RecyclerView) objArr[2]);
        this.f10296g = -1;
        this.f10295f = objArr[0];
        this.f10295f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10296g = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10296g != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10296g;
            this.f10296g = 0;
        }
    }
}
