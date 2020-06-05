package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.module.common.data.ListEmptyData;

public class ItemListEmptyBindingImpl extends ItemListEmptyBinding {
    /* renamed from: b */
    private static final IncludedLayouts f11042b = null;
    /* renamed from: c */
    private static final SparseIntArray f11043c = null;
    /* renamed from: d */
    private final LinearLayout f11044d;
    /* renamed from: e */
    private final TextView f11045e;
    /* renamed from: f */
    private long f11046f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemListEmptyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f11042b, f11043c));
    }

    private ItemListEmptyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11046f = -1;
        this.f11044d = objArr[0];
        this.f11044d.setTag(null);
        this.f11045e = objArr[1];
        this.f11045e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11046f = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11046f != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20187a((ListEmptyData) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20187a(ListEmptyData listEmptyData) {
        this.f11041a = listEmptyData;
        synchronized (this) {
            this.f11046f |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11046f;
            this.f11046f = 0;
        }
        String str = null;
        ListEmptyData listEmptyData = this.f11041a;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i == 0 || listEmptyData == null)) {
            str = listEmptyData.getDesc();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f11045e, str);
            TextViewAdapter.m12786a(this.f11045e, listEmptyData);
        }
    }
}
