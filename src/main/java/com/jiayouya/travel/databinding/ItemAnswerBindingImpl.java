package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.answer.data.AnswerItem;

public class ItemAnswerBindingImpl extends ItemAnswerBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10892c = null;
    /* renamed from: d */
    private static final SparseIntArray f10893d = null;
    /* renamed from: e */
    private final LinearLayout f10894e;
    /* renamed from: f */
    private final ImageView f10895f;
    /* renamed from: g */
    private final TextView f10896g;
    /* renamed from: h */
    private long f10897h;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemAnswerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10892c, f10893d));
    }

    private ItemAnswerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10897h = -1;
        this.f10894e = objArr[0];
        this.f10894e.setTag(null);
        this.f10895f = objArr[1];
        this.f10895f.setTag(null);
        this.f10896g = objArr[2];
        this.f10896g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10897h = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10897h != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20163a((AnswerItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20162a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20163a(AnswerItem answerItem) {
        this.f10890a = answerItem;
        synchronized (this) {
            this.f10897h |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20162a(OnClickListener onClickListener) {
        this.f10891b = onClickListener;
        synchronized (this) {
            this.f10897h |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        synchronized (this) {
            j = this.f10897h;
            this.f10897h = 0;
        }
        boolean z = false;
        AnswerItem answerItem = this.f10890a;
        OnClickListener onClickListener = this.f10891b;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i == 0 || answerItem == null) {
            charSequence = null;
        } else {
            z = answerItem.isSelected();
            charSequence = answerItem.getAnswer();
        }
        if ((j & 6) != 0) {
            ViewAdapter.m12792a(this.f10894e, onClickListener, null);
        }
        if (i != 0) {
            ViewAdapter.m12796b((View) this.f10895f, Boolean.valueOf(z));
            TextViewBindingAdapter.setText(this.f10896g, charSequence);
        }
    }
}
