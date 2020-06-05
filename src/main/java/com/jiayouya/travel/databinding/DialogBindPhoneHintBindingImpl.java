package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;

public class DialogBindPhoneHintBindingImpl extends DialogBindPhoneHintBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10278c = null;
    /* renamed from: d */
    private static final SparseIntArray f10279d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10280e;
    /* renamed from: f */
    private long f10281f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10279d.put(R.id.btn_cancel, 1);
        f10279d.put(R.id.btn_confirm, 2);
    }

    public DialogBindPhoneHintBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10278c, f10279d));
    }

    private DialogBindPhoneHintBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[1], (RoundText) objArr[2]);
        this.f10281f = -1;
        this.f10280e = objArr[0];
        this.f10280e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10281f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10281f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10281f;
            this.f10281f = 0;
        }
    }
}
