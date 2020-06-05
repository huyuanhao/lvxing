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
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class DialogInviterHintBindingImpl extends DialogInviterHintBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10465d = null;
    /* renamed from: e */
    private static final SparseIntArray f10466e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10467f;
    /* renamed from: g */
    private final CircleImageView f10468g;
    /* renamed from: h */
    private final TextView f10469h;
    /* renamed from: i */
    private long f10470i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10466e.put(R.id.iv_close, 3);
        f10466e.put(R.id.btn, 4);
    }

    public DialogInviterHintBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10465d, f10466e));
    }

    private DialogInviterHintBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[4], (ImageView) objArr[3]);
        this.f10470i = -1;
        this.f10467f = objArr[0];
        this.f10467f.setTag(null);
        this.f10468g = objArr[1];
        this.f10468g.setTag(null);
        this.f10469h = objArr[2];
        this.f10469h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10470i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10470i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (33 != i) {
            return false;
        }
        mo20125a((User) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20125a(User user) {
        this.f10464c = user;
        synchronized (this) {
            this.f10470i |= 1;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        String str;
        synchronized (this) {
            j = this.f10470i;
            this.f10470i = 0;
        }
        User user = this.f10464c;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i == 0 || user == null) {
            str = null;
            charSequence = null;
        } else {
            str = user.getAvatar();
            charSequence = user.getNickname();
        }
        if (i != 0) {
            ImageAdapter.m12783a((ImageView) this.f10468g, str, 0, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f10469h, charSequence);
        }
    }
}
