package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;

public class ItemAssociateBindingImpl extends ItemAssociateBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10913d = null;
    /* renamed from: e */
    private static final SparseIntArray f10914e = null;
    /* renamed from: f */
    private long f10915f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemAssociateBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f10913d, f10914e));
    }

    private ItemAssociateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.f10915f = -1;
        this.f10910a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10915f = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10915f != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20167a((String) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20166a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20167a(String str) {
        this.f10912c = str;
        synchronized (this) {
            this.f10915f |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20166a(OnClickListener onClickListener) {
        this.f10911b = onClickListener;
        synchronized (this) {
            this.f10915f |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10915f;
            this.f10915f = 0;
        }
        String str = this.f10912c;
        OnClickListener onClickListener = this.f10911b;
        int i = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((5 & j) != 0) {
            TextViewBindingAdapter.setText(this.f10910a, str);
        }
        if (i != 0) {
            ViewAdapter.m12792a(this.f10910a, onClickListener, null);
        }
    }
}
