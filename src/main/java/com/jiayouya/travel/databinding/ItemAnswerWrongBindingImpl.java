package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.answer.data.AnswerErrorItem;

public class ItemAnswerWrongBindingImpl extends ItemAnswerWrongBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10900c = null;
    /* renamed from: d */
    private static final SparseIntArray f10901d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10902e;
    /* renamed from: f */
    private final TextView f10903f;
    /* renamed from: g */
    private long f10904g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10901d.put(R.id.list, 2);
    }

    public ItemAnswerWrongBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10900c, f10901d));
    }

    private ItemAnswerWrongBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2]);
        this.f10904g = -1;
        this.f10902e = objArr[0];
        this.f10902e.setTag(null);
        this.f10903f = objArr[1];
        this.f10903f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10904g = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10904g != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20164a((AnswerErrorItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20164a(AnswerErrorItem answerErrorItem) {
        this.f10899b = answerErrorItem;
        synchronized (this) {
            this.f10904g |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10904g;
            this.f10904g = 0;
        }
        String str = null;
        AnswerErrorItem answerErrorItem = this.f10899b;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i == 0 || answerErrorItem == null)) {
            str = answerErrorItem.getQuestion();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f10903f, str);
        }
    }
}
