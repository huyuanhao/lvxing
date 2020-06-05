package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.assets.data.CashApplyRsp;
import ezy.p653ui.widget.CenteredTitleBar;
import ezy.p653ui.widget.round.RoundText;

public class ActivityCashApplyBindingImpl extends ActivityCashApplyBinding {
    /* renamed from: e */
    private static final IncludedLayouts f9920e = null;
    /* renamed from: f */
    private static final SparseIntArray f9921f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f9922g;
    /* renamed from: h */
    private final TextView f9923h;
    /* renamed from: i */
    private final TextView f9924i;
    /* renamed from: j */
    private final TextView f9925j;
    /* renamed from: k */
    private final TextView f9926k;
    /* renamed from: l */
    private long f9927l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9921f.put(R.id.toolbar, 5);
        f9921f.put(R.id.nestedScrollView, 6);
        f9921f.put(R.id.btn_complete, 7);
    }

    public ActivityCashApplyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f9920e, f9921f));
    }

    private ActivityCashApplyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[7], (ScrollView) objArr[6], (CenteredTitleBar) objArr[5]);
        this.f9927l = -1;
        this.f9922g = objArr[0];
        this.f9922g.setTag(null);
        this.f9923h = objArr[1];
        this.f9923h.setTag(null);
        this.f9924i = objArr[2];
        this.f9924i.setTag(null);
        this.f9925j = objArr[3];
        this.f9925j.setTag(null);
        this.f9926k = objArr[4];
        this.f9926k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9927l = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9927l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20080a((CashApplyRsp) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20080a(CashApplyRsp cashApplyRsp) {
        this.f9919d = cashApplyRsp;
        synchronized (this) {
            this.f9927l |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        synchronized (this) {
            j = this.f9927l;
            this.f9927l = 0;
        }
        CashApplyRsp cashApplyRsp = this.f9919d;
        String str = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i == 0 || cashApplyRsp == null) {
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
        } else {
            str = cashApplyRsp.getDesc();
            charSequence3 = cashApplyRsp.getFee();
            charSequence2 = cashApplyRsp.getChannel();
            charSequence = cashApplyRsp.getAmount();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f9923h, str);
            TextViewBindingAdapter.setText(this.f9924i, charSequence);
            TextViewBindingAdapter.setText(this.f9925j, charSequence3);
            TextViewBindingAdapter.setText(this.f9926k, charSequence2);
        }
    }
}
