package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.TextViewAdapter;

public class DialogTravelCityBindingImpl extends DialogTravelCityBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10686c = null;
    /* renamed from: d */
    private static final SparseIntArray f10687d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10688e;
    /* renamed from: f */
    private final TextView f10689f;
    /* renamed from: g */
    private long f10690g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10687d.put(R.id.btn, 2);
    }

    public DialogTravelCityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10686c, f10687d));
    }

    private DialogTravelCityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2]);
        this.f10690g = -1;
        this.f10688e = objArr[0];
        this.f10688e.setTag(null);
        this.f10689f = objArr[1];
        this.f10689f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10690g = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10690g != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (31 != i) {
            return false;
        }
        mo20145a((String) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20145a(String str) {
        this.f10685b = str;
        synchronized (this) {
            this.f10690g |= 1;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10690g;
            this.f10690g = 0;
        }
        String str = null;
        String str2 = this.f10685b;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            str = this.f10689f.getResources().getString(R.string.c66_and_green, new Object[]{"必得分红犬进度", str2});
        }
        if (i != 0) {
            TextViewAdapter.m12787a(this.f10689f, str);
        }
    }
}
