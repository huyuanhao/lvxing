package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import ezy.p653ui.widget.round.RoundLayout;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ActivityLoginBindingImpl extends ActivityLoginBinding {
    /* renamed from: h */
    private static final IncludedLayouts f10043h = null;
    /* renamed from: i */
    private static final SparseIntArray f10044i = new SparseIntArray();
    /* renamed from: j */
    private final LinearLayout f10045j;
    /* renamed from: k */
    private final ImageView f10046k;
    /* renamed from: l */
    private long f10047l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10044i.put(R.id.status_view, 2);
        f10044i.put(R.id.btn_login, 3);
        f10044i.put(R.id.txt_other_login, 4);
        f10044i.put(R.id.iv_check, 5);
        f10044i.put(R.id.tv_user_protocol, 6);
        f10044i.put(R.id.tv_private, 7);
    }

    public ActivityLoginBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f10043h, f10044i));
    }

    private ActivityLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundLayout) objArr[3], (ImageView) objArr[5], (View) objArr[2], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[4]);
        this.f10047l = -1;
        this.f10045j = objArr[0];
        this.f10045j.setTag(null);
        this.f10046k = objArr[1];
        this.f10046k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10047l = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10047l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (25 != i) {
            return false;
        }
        mo20089a(((Integer) obj).intValue());
        return true;
    }

    /* renamed from: a */
    public void mo20089a(int i) {
        this.f10042g = i;
        synchronized (this) {
            this.f10047l |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10047l;
            this.f10047l = 0;
        }
        int i = this.f10042g;
        if ((j & 3) != 0) {
            ImageAdapter.m12781a(this.f10046k, Integer.valueOf(i), 15, (CornerType) null, (Integer) null);
        }
    }
}
