package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.travel.data.ExpandPrice;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import ezy.p653ui.widget.round.RoundText;

public class DialogBuyCapacityBindingImpl extends DialogBuyCapacityBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10285d = null;
    /* renamed from: e */
    private static final SparseIntArray f10286e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10287f;
    /* renamed from: g */
    private final TextView f10288g;
    /* renamed from: h */
    private long f10289h;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10286e.put(R.id.btn, 2);
        f10286e.put(R.id.iv_close, 3);
    }

    public DialogBuyCapacityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f10285d, f10286e));
    }

    private DialogBuyCapacityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[2], (ImageView) objArr[3]);
        this.f10289h = -1;
        this.f10287f = objArr[0];
        this.f10287f.setTag(null);
        this.f10288g = objArr[1];
        this.f10288g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10289h = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10289h != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20107a((ExpandPrice) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20107a(ExpandPrice expandPrice) {
        this.f10284c = expandPrice;
        synchronized (this) {
            this.f10289h |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10289h;
            this.f10289h = 0;
        }
        ExpandPrice expandPrice = this.f10284c;
        String str = null;
        double d = 0.0d;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (expandPrice != null) {
                d = expandPrice.getPrice();
            }
            str = GoldUtil.f11900a.mo21651a(d);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f10288g, str);
        }
    }
}
