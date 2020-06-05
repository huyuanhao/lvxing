package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.assets.data.CashItem;
import com.jiayouya.travel.module.assets.data.CashItemKt;

public class ItemCashAmountBindingImpl extends ItemCashAmountBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10918c = null;
    /* renamed from: d */
    private static final SparseIntArray f10919d = null;
    /* renamed from: e */
    private final FrameLayout f10920e;
    /* renamed from: f */
    private final LinearLayout f10921f;
    /* renamed from: g */
    private final TextView f10922g;
    /* renamed from: h */
    private final TextView f10923h;
    /* renamed from: i */
    private final ImageView f10924i;
    /* renamed from: j */
    private long f10925j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemCashAmountBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10918c, f10919d));
    }

    private ItemCashAmountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10925j = -1;
        this.f10920e = objArr[0];
        this.f10920e.setTag(null);
        this.f10921f = objArr[1];
        this.f10921f.setTag(null);
        this.f10922g = objArr[2];
        this.f10922g.setTag(null);
        this.f10923h = objArr[3];
        this.f10923h.setTag(null);
        this.f10924i = objArr[4];
        this.f10924i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10925j = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10925j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20169a((CashItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20168a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20169a(CashItem cashItem) {
        this.f10916a = cashItem;
        synchronized (this) {
            this.f10925j |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20168a(OnClickListener onClickListener) {
        this.f10917b = onClickListener;
        synchronized (this) {
            this.f10925j |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        boolean z;
        synchronized (this) {
            j = this.f10925j;
            this.f10925j = 0;
        }
        CashItem cashItem = this.f10916a;
        OnClickListener onClickListener = this.f10917b;
        boolean z2 = false;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (cashItem != null) {
                z2 = cashItem.isSelected();
                charSequence = cashItem.getValue();
            } else {
                charSequence = null;
            }
            z = !CashItemKt.isFirstTime(cashItem);
        } else {
            charSequence = null;
            z = false;
        }
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i != 0) {
            ViewAdapter.m12796b((View) this.f10921f, Boolean.valueOf(z2));
            TextViewBindingAdapter.setText(this.f10922g, charSequence);
            ViewAdapter.m12796b((View) this.f10922g, Boolean.valueOf(z2));
            ViewAdapter.m12796b((View) this.f10923h, Boolean.valueOf(z2));
            ViewAdapter.m12799d(this.f10924i, Boolean.valueOf(z));
        }
        if (i2 != 0) {
            ViewAdapter.m12792a(this.f10921f, onClickListener, null);
        }
    }
}
