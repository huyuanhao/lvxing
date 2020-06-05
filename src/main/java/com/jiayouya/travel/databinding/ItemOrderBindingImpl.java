package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;

public class ItemOrderBindingImpl extends ItemOrderBinding {
    /* renamed from: b */
    private static final IncludedLayouts f11121b = null;
    /* renamed from: c */
    private static final SparseIntArray f11122c = null;
    /* renamed from: d */
    private final LinearLayout f11123d;
    /* renamed from: e */
    private final TextView f11124e;
    /* renamed from: f */
    private long f11125f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemOrderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f11121b, f11122c));
    }

    private ItemOrderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11125f = -1;
        this.f11123d = objArr[0];
        this.f11123d.setTag(null);
        this.f11124e = objArr[1];
        this.f11124e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11125f = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11125f != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        mo20198a((OnClickListener) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20198a(OnClickListener onClickListener) {
        this.f11120a = onClickListener;
        synchronized (this) {
            this.f11125f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11125f;
            this.f11125f = 0;
        }
        OnClickListener onClickListener = this.f11120a;
        if ((3 & j) != 0) {
            ViewAdapter.m12792a(this.f11123d, onClickListener, null);
        }
        if ((j & 2) != 0) {
            TextViewAdapter.m12788b(this.f11124e, "淘宝");
        }
    }
}
