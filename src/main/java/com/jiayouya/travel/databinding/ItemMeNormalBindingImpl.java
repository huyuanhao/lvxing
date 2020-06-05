package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.p276me.data.MeItem;
import com.jiayouya.travel.module.p276me.data.MeItemKt;
import com.jiayouya.travel.module.p276me.data.MeMenuKt;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ItemMeNormalBindingImpl extends ItemMeNormalBinding {
    /* renamed from: d */
    private static final IncludedLayouts f11078d = null;
    /* renamed from: e */
    private static final SparseIntArray f11079e = null;
    /* renamed from: f */
    private final LinearLayout f11080f;
    /* renamed from: g */
    private final ImageView f11081g;
    /* renamed from: h */
    private final TextView f11082h;
    /* renamed from: i */
    private final ImageView f11083i;
    /* renamed from: j */
    private long f11084j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemMeNormalBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f11078d, f11079e));
    }

    private ItemMeNormalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[3], (TextView) objArr[4]);
        this.f11084j = -1;
        this.f11080f = objArr[0];
        this.f11080f.setTag(null);
        this.f11081g = objArr[1];
        this.f11081g.setTag(null);
        this.f11082h = objArr[2];
        this.f11082h.setTag(null);
        this.f11083i = objArr[5];
        this.f11083i.setTag(null);
        this.f11075a.setTag(null);
        this.f11076b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11084j = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11084j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20191a((MeItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20191a(MeItem meItem) {
        this.f11077c = meItem;
        synchronized (this) {
            this.f11084j |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        CharSequence charSequence;
        CharSequence charSequence2;
        String str;
        boolean z2;
        boolean z3;
        String str2;
        Drawable drawable;
        synchronized (this) {
            j = this.f11084j;
            this.f11084j = 0;
        }
        MeItem meItem = this.f11077c;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            drawable = MeMenuKt.getBgDrawable(meItem);
            str2 = MeItemKt.formatRoute(meItem);
            z3 = MeItemKt.isNotice(meItem);
            boolean isHasNotice = MeItemKt.isHasNotice(meItem);
            if (meItem != null) {
                charSequence2 = meItem.getTitle();
                charSequence = meItem.getValue();
                str = meItem.getImage();
            } else {
                str = null;
                charSequence2 = null;
                charSequence = null;
            }
            z = TextUtils.isEmpty(str2);
            z2 = !isHasNotice;
        } else {
            drawable = null;
            str2 = null;
            str = null;
            charSequence2 = null;
            charSequence = null;
            z3 = false;
            z2 = false;
            z = false;
        }
        if (i != 0) {
            ViewAdapter.m12791a((View) this.f11080f, drawable);
            ViewAdapter.m12794a((View) this.f11080f, str2);
            ImageAdapter.m12783a(this.f11081g, str, 0, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f11082h, charSequence2);
            ViewAdapter.m12798c((View) this.f11083i, Boolean.valueOf(z));
            ViewAdapter.m12798c(this.f11075a, Boolean.valueOf(z2));
            TextViewBindingAdapter.setText(this.f11076b, charSequence);
            ViewAdapter.m12798c((View) this.f11076b, Boolean.valueOf(z3));
        }
    }
}
