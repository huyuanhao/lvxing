package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.module.travel.data.LuckDog;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import ezy.p653ui.widget.round.RoundText;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class DialogTempBonusProfitBindingImpl extends DialogTempBonusProfitBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10670e = null;
    /* renamed from: f */
    private static final SparseIntArray f10671f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f10672g;
    /* renamed from: h */
    private final ImageView f10673h;
    /* renamed from: i */
    private final RoundText f10674i;
    /* renamed from: j */
    private final TextView f10675j;
    /* renamed from: k */
    private final TextView f10676k;
    /* renamed from: l */
    private long f10677l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10671f.put(R.id.iv_close, 6);
        f10671f.put(R.id.btn, 7);
    }

    public DialogTempBonusProfitBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f10670e, f10671f));
    }

    private DialogTempBonusProfitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[7], (ImageView) objArr[6], (TextView) objArr[5]);
        this.f10677l = -1;
        this.f10672g = objArr[0];
        this.f10672g.setTag(null);
        this.f10673h = objArr[1];
        this.f10673h.setTag(null);
        this.f10674i = objArr[2];
        this.f10674i.setTag(null);
        this.f10675j = objArr[3];
        this.f10675j.setTag(null);
        this.f10676k = objArr[4];
        this.f10676k.setTag(null);
        this.f10668c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10677l = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10677l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20144a((LuckDog) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20144a(LuckDog luckDog) {
        this.f10669d = luckDog;
        synchronized (this) {
            this.f10677l |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        CharSequence charSequence2;
        synchronized (this) {
            j = this.f10677l;
            this.f10677l = 0;
        }
        LuckDog luckDog = this.f10669d;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i == 0 || luckDog == null) {
            charSequence2 = null;
            charSequence = null;
        } else {
            charSequence = luckDog.getAmount();
            charSequence2 = luckDog.getTimeText();
        }
        if ((j & 2) != 0) {
            ImageAdapter.m12781a(this.f10673h, Integer.valueOf(MergeUtil.m14455b(47)), 0, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f10674i, "Lv.38");
            TextViewAdapter.m12787a(this.f10668c, this.f10668c.getResources().getString(R.string.temp_bonus));
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f10675j, charSequence2);
            TextViewBindingAdapter.setText(this.f10676k, charSequence);
        }
    }
}
