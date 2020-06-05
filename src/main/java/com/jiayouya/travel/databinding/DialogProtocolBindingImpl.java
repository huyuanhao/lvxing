package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class DialogProtocolBindingImpl extends DialogProtocolBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10565d = null;
    /* renamed from: e */
    private static final SparseIntArray f10566e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10567f;
    /* renamed from: g */
    private long f10568g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10566e.put(R.id.tv_content, 1);
        f10566e.put(R.id.btn_cancel, 2);
        f10566e.put(R.id.btn_confirm, 3);
    }

    public DialogProtocolBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f10565d, f10566e));
    }

    private DialogProtocolBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1]);
        this.f10568g = -1;
        this.f10567f = objArr[0];
        this.f10567f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10568g = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10568g != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10568g;
            this.f10568g = 0;
        }
    }
}
