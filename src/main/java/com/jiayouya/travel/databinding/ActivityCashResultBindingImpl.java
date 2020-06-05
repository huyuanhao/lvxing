package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ViewAdapter;

public class ActivityCashResultBindingImpl extends ActivityCashResultBinding {
    /* renamed from: c */
    private static final IncludedLayouts f9952c = null;
    /* renamed from: d */
    private static final SparseIntArray f9953d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f9954e;
    /* renamed from: f */
    private final ImageView f9955f;
    /* renamed from: g */
    private final TextView f9956g;
    /* renamed from: h */
    private final TextView f9957h;
    /* renamed from: i */
    private long f9958i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9953d.put(R.id.btn, 4);
    }

    public ActivityCashResultBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f9952c, f9953d));
    }

    private ActivityCashResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[4]);
        this.f9958i = -1;
        this.f9954e = objArr[0];
        this.f9954e.setTag(null);
        this.f9955f = objArr[1];
        this.f9955f.setTag(null);
        this.f9956g = objArr[2];
        this.f9956g.setTag(null);
        this.f9957h = objArr[3];
        this.f9957h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9958i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9958i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (16 != i) {
            return false;
        }
        mo20083a(((Boolean) obj).booleanValue());
        return true;
    }

    /* renamed from: a */
    public void mo20083a(boolean z) {
        this.f9951b = z;
        synchronized (this) {
            this.f9958i |= 1;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f9958i;
            this.f9958i = 0;
        }
        boolean z = this.f9951b;
        CharSequence charSequence2 = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (i != 0) {
                if (z) {
                    j3 = j | 8;
                    j2 = 32;
                } else {
                    j3 = j | 4;
                    j2 = 16;
                }
                j = j3 | j2;
            }
            charSequence2 = z ? "提现成功" : "提现失败";
            charSequence = z ? "预计三个工作日到账" : "请重新提现";
        } else {
            charSequence = null;
        }
        if ((j & 3) != 0) {
            ViewAdapter.m12796b((View) this.f9955f, Boolean.valueOf(z));
            TextViewBindingAdapter.setText(this.f9956g, charSequence2);
            TextViewBindingAdapter.setText(this.f9957h, charSequence);
        }
    }
}
