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
import com.jiayouya.travel.module.common.data.User;
import ezy.p653ui.widget.round.RoundText;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ActivityAuthBindingImpl extends ActivityAuthBinding {
    /* renamed from: g */
    private static final IncludedLayouts f9852g = null;
    /* renamed from: h */
    private static final SparseIntArray f9853h = new SparseIntArray();
    /* renamed from: i */
    private final LinearLayout f9854i;
    /* renamed from: j */
    private final TextView f9855j;
    /* renamed from: k */
    private final ImageView f9856k;
    /* renamed from: l */
    private final TextView f9857l;
    /* renamed from: m */
    private long f9858m;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9853h.put(R.id.status_view, 4);
        f9853h.put(R.id.tv_close, 5);
        f9853h.put(R.id.btn_agree, 6);
        f9853h.put(R.id.btn_refuse, 7);
    }

    public ActivityAuthBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f9852g, f9853h));
    }

    private ActivityAuthBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[6], (RoundText) objArr[7], (View) objArr[4], (TextView) objArr[5]);
        this.f9858m = -1;
        this.f9854i = objArr[0];
        this.f9854i.setTag(null);
        this.f9855j = objArr[1];
        this.f9855j.setTag(null);
        this.f9856k = objArr[2];
        this.f9856k.setTag(null);
        this.f9857l = objArr[3];
        this.f9857l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9858m = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9858m != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (33 == i) {
            mo20076a((User) obj);
        } else if (22 != i) {
            return false;
        } else {
            mo20077a((String) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20076a(User user) {
        this.f9851f = user;
        synchronized (this) {
            this.f9858m |= 1;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20077a(String str) {
        this.f9850e = str;
        synchronized (this) {
            this.f9858m |= 2;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        String str;
        CharSequence charSequence2;
        synchronized (this) {
            j = this.f9858m;
            this.f9858m = 0;
        }
        User user = this.f9851f;
        String str2 = this.f9850e;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i == 0 || user == null) {
            str = null;
            charSequence = null;
        } else {
            charSequence = user.getNickname();
            str = user.getAvatar();
        }
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("申请使用");
            charSequence2 = sb.toString();
        } else {
            charSequence2 = null;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f9855j, charSequence2);
        }
        if (i != 0) {
            ImageAdapter.m12783a(this.f9856k, str, 5, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f9857l, charSequence);
        }
    }
}
