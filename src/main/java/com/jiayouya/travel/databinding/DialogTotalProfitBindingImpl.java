package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.TextViewAdapter;

public class DialogTotalProfitBindingImpl extends DialogTotalProfitBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10679b = null;
    /* renamed from: c */
    private static final SparseIntArray f10680c = new SparseIntArray();
    /* renamed from: d */
    private final LinearLayout f10681d;
    /* renamed from: e */
    private final TextView f10682e;
    /* renamed from: f */
    private long f10683f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10680c.put(R.id.btn, 2);
    }

    public DialogTotalProfitBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10679b, f10680c));
    }

    private DialogTotalProfitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2]);
        this.f10683f = -1;
        this.f10681d = objArr[0];
        this.f10681d.setTag(null);
        this.f10682e = objArr[1];
        this.f10682e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10683f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10683f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10683f;
            this.f10683f = 0;
        }
        if ((j & 1) != 0) {
            TextView textView = this.f10682e;
            TextViewAdapter.m12787a(textView, textView.getResources().getString(R.string.total_profit_explain));
        }
    }
}
