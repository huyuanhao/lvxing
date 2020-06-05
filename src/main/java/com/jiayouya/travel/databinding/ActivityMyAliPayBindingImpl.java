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
import com.jiayouya.travel.module.common.data.AliUserRsp;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ActivityMyAliPayBindingImpl extends ActivityMyAliPayBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10077c = null;
    /* renamed from: d */
    private static final SparseIntArray f10078d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10079e;
    /* renamed from: f */
    private final CircleImageView f10080f;
    /* renamed from: g */
    private final TextView f10081g;
    /* renamed from: h */
    private final TextView f10082h;
    /* renamed from: i */
    private long f10083i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10078d.put(R.id.btn, 4);
    }

    public ActivityMyAliPayBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10077c, f10078d));
    }

    private ActivityMyAliPayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[4]);
        this.f10083i = -1;
        this.f10079e = objArr[0];
        this.f10079e.setTag(null);
        this.f10080f = objArr[1];
        this.f10080f.setTag(null);
        this.f10081g = objArr[2];
        this.f10081g.setTag(null);
        this.f10082h = objArr[3];
        this.f10082h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10083i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10083i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (17 != i) {
            return false;
        }
        mo20092a((AliUserRsp) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20092a(AliUserRsp aliUserRsp) {
        this.f10076b = aliUserRsp;
        synchronized (this) {
            this.f10083i |= 1;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        String str;
        CharSequence charSequence;
        CharSequence charSequence2;
        synchronized (this) {
            j = this.f10083i;
            this.f10083i = 0;
        }
        AliUserRsp aliUserRsp = this.f10076b;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i == 0 || aliUserRsp == null) {
            charSequence2 = null;
            charSequence = null;
            str = null;
        } else {
            charSequence2 = aliUserRsp.getCity();
            charSequence = aliUserRsp.getNickname();
            str = aliUserRsp.getAvatar();
        }
        if (i != 0) {
            ImageAdapter.m12783a((ImageView) this.f10080f, str, 0, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f10081g, charSequence);
            TextViewBindingAdapter.setText(this.f10082h, charSequence2);
        }
    }
}
