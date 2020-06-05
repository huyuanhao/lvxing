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
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ActivityAboutUsBindingImpl extends ActivityAboutUsBinding {
    /* renamed from: f */
    private static final IncludedLayouts f9814f = null;
    /* renamed from: g */
    private static final SparseIntArray f9815g = new SparseIntArray();
    /* renamed from: h */
    private final LinearLayout f9816h;
    /* renamed from: i */
    private final ImageView f9817i;
    /* renamed from: j */
    private final TextView f9818j;
    /* renamed from: k */
    private long f9819k;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9815g.put(R.id.lyt_upgrade, 3);
        f9815g.put(R.id.lyt_protocol, 4);
        f9815g.put(R.id.lyt_private, 5);
    }

    public ActivityAboutUsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f9814f, f9815g));
    }

    private ActivityAboutUsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[5], (LinearLayout) objArr[4], (LinearLayout) objArr[3]);
        this.f9819k = -1;
        this.f9816h = objArr[0];
        this.f9816h.setTag(null);
        this.f9817i = objArr[1];
        this.f9817i.setTag(null);
        this.f9818j = objArr[2];
        this.f9818j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9819k = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9819k != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (24 == i) {
            mo20069a((String) obj);
        } else if (25 != i) {
            return false;
        } else {
            mo20068a(((Integer) obj).intValue());
        }
        return true;
    }

    /* renamed from: a */
    public void mo20069a(String str) {
        this.f9812d = str;
        synchronized (this) {
            this.f9819k |= 1;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20068a(int i) {
        this.f9813e = i;
        synchronized (this) {
            this.f9819k |= 2;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9819k;
            this.f9819k = 0;
        }
        String str = this.f9812d;
        int i = this.f9813e;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if ((j & 6) != 0) {
            ImageAdapter.m12781a(this.f9817i, Integer.valueOf(i), 15, (CornerType) null, (Integer) null);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f9818j, str);
        }
    }
}
