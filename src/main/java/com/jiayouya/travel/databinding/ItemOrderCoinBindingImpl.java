package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.p281tb.widget.CircleProgressBar;
import p641de.hdodenhof.circleimageview.CircleImageView;

public class ItemOrderCoinBindingImpl extends ItemOrderCoinBinding {
    /* renamed from: f */
    private static final IncludedLayouts f11131f = null;
    /* renamed from: g */
    private static final SparseIntArray f11132g = new SparseIntArray();
    /* renamed from: h */
    private final LinearLayout f11133h;
    /* renamed from: i */
    private long f11134i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f11132g.put(R.id.iv, 4);
    }

    public ItemOrderCoinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f11131f, f11132g));
    }

    private ItemOrderCoinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CircleImageView) objArr[4], (ImageView) objArr[2], (CircleProgressBar) objArr[3], (TextView) objArr[1]);
        this.f11134i = -1;
        this.f11127b.setTag(null);
        this.f11133h = objArr[0];
        this.f11133h.setTag(null);
        this.f11128c.setTag(null);
        this.f11129d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11134i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11134i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        mo20199a((OnClickListener) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20199a(OnClickListener onClickListener) {
        this.f11130e = onClickListener;
        synchronized (this) {
            this.f11134i |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11134i;
            this.f11134i = 0;
        }
        OnClickListener onClickListener = this.f11130e;
        if ((3 & j) != 0) {
            ViewAdapter.m12792a(this.f11127b, onClickListener, null);
        }
        if ((j & 2) != 0) {
            CustomAdapter.m12779a(this.f11128c, Boolean.valueOf(true));
            TextViewBindingAdapter.setText(this.f11129d, "+1111");
        }
    }
}
