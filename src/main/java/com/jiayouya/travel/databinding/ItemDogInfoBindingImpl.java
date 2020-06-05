package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;

public class ItemDogInfoBindingImpl extends ItemDogInfoBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10949b = null;
    /* renamed from: c */
    private static final SparseIntArray f10950c = null;
    /* renamed from: d */
    private final TextView f10951d;
    /* renamed from: e */
    private long f10952e;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemDogInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f10949b, f10950c));
    }

    private ItemDogInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10952e = -1;
        this.f10951d = objArr[0];
        this.f10951d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10952e = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10952e != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20174a((String) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20174a(String str) {
        this.f10948a = str;
        synchronized (this) {
            this.f10952e |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10952e;
            this.f10952e = 0;
        }
        String str = this.f10948a;
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.f10951d, str);
        }
    }
}
