package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;

public class LayoutTabBindingImpl extends LayoutTabBinding {
    /* renamed from: d */
    private static final IncludedLayouts f11205d = null;
    /* renamed from: e */
    private static final SparseIntArray f11206e = null;
    /* renamed from: f */
    private long f11207f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public LayoutTabBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f11205d, f11206e));
    }

    private LayoutTabBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.f11207f = -1;
        this.f11202a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11207f = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11207f != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (7 == i) {
            mo20208a(((Integer) obj).intValue());
        } else if (28 != i) {
            return false;
        } else {
            mo20207a((String) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20208a(int i) {
        this.f11203b = i;
    }

    /* renamed from: a */
    public void mo20207a(String str) {
        this.f11204c = str;
        synchronized (this) {
            this.f11207f |= 2;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11207f;
            this.f11207f = 0;
        }
        String str = this.f11204c;
        if ((j & 6) != 0) {
            TextViewBindingAdapter.setText(this.f11202a, str);
        }
    }
}
