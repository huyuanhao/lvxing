package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.module.explore.data.DynamicTitle;

public class ItemDynamicTitleBindingImpl extends ItemDynamicTitleBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10987b = null;
    /* renamed from: c */
    private static final SparseIntArray f10988c = null;
    /* renamed from: d */
    private final TextView f10989d;
    /* renamed from: e */
    private long f10990e;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemDynamicTitleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f10987b, f10988c));
    }

    private ItemDynamicTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10990e = -1;
        this.f10989d = objArr[0];
        this.f10989d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10990e = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10990e != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20179a((DynamicTitle) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20179a(DynamicTitle dynamicTitle) {
        this.f10986a = dynamicTitle;
        synchronized (this) {
            this.f10990e |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10990e;
            this.f10990e = 0;
        }
        String str = null;
        DynamicTitle dynamicTitle = this.f10986a;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i == 0 || dynamicTitle == null)) {
            str = dynamicTitle.getTitle();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f10989d, str);
        }
    }
}
