package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;

public class ItemAnswerWrongSubBindingImpl extends ItemAnswerWrongSubBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10906b = null;
    /* renamed from: c */
    private static final SparseIntArray f10907c = null;
    /* renamed from: d */
    private final TextView f10908d;
    /* renamed from: e */
    private long f10909e;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemAnswerWrongSubBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f10906b, f10907c));
    }

    private ItemAnswerWrongSubBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10909e = -1;
        this.f10908d = objArr[0];
        this.f10908d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10909e = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10909e != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20165a((String) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20165a(String str) {
        this.f10905a = str;
        synchronized (this) {
            this.f10909e |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10909e;
            this.f10909e = 0;
        }
        String str = this.f10905a;
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.f10908d, str);
        }
    }
}
