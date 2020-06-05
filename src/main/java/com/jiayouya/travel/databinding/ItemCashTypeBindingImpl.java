package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.common.data.PayChannelItem;
import com.jiayouya.travel.module.common.data.PayChannelItemKt;

public class ItemCashTypeBindingImpl extends ItemCashTypeBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10933c = null;
    /* renamed from: d */
    private static final SparseIntArray f10934d = null;
    /* renamed from: e */
    private final ImageView f10935e;
    /* renamed from: f */
    private long f10936f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemCashTypeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, f10933c, f10934d));
    }

    private ItemCashTypeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10936f = -1;
        this.f10935e = objArr[0];
        this.f10935e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10936f = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10936f != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20172a((PayChannelItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20171a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20172a(PayChannelItem payChannelItem) {
        this.f10931a = payChannelItem;
        synchronized (this) {
            this.f10936f |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20171a(OnClickListener onClickListener) {
        this.f10932b = onClickListener;
        synchronized (this) {
            this.f10936f |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.f10936f;
            this.f10936f = 0;
        }
        PayChannelItem payChannelItem = this.f10931a;
        OnClickListener onClickListener = this.f10932b;
        boolean z = false;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (payChannelItem != null) {
                z = payChannelItem.isSelected();
            }
            i = PayChannelItemKt.logoSelector(payChannelItem);
        } else {
            i = 0;
        }
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            ImageAdapter.m12780a(this.f10935e, Integer.valueOf(i));
            ViewAdapter.m12796b((View) this.f10935e, Boolean.valueOf(z));
        }
        if (i3 != 0) {
            ViewAdapter.m12792a(this.f10935e, onClickListener, null);
        }
    }
}
