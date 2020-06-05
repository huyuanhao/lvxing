package com.jiayouya.travel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.travel.data.UnlockCity;
import ezy.p653ui.widget.round.RoundText;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class DialogUnlockCityBindingImpl extends DialogUnlockCityBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10694d = null;
    /* renamed from: e */
    private static final SparseIntArray f10695e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10696f;
    /* renamed from: g */
    private final TextView f10697g;
    /* renamed from: h */
    private final CircleImageView f10698h;
    /* renamed from: i */
    private final TextView f10699i;
    /* renamed from: j */
    private final TextView f10700j;
    /* renamed from: k */
    private final TextView f10701k;
    /* renamed from: l */
    private long f10702l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10695e.put(R.id.btn, 6);
        f10695e.put(R.id.iv_close, 7);
    }

    public DialogUnlockCityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f10694d, f10695e));
    }

    private DialogUnlockCityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[6], (ImageView) objArr[7]);
        this.f10702l = -1;
        this.f10696f = objArr[0];
        this.f10696f.setTag(null);
        this.f10697g = objArr[1];
        this.f10697g.setTag(null);
        this.f10698h = objArr[2];
        this.f10698h.setTag(null);
        this.f10699i = objArr[3];
        this.f10699i.setTag(null);
        this.f10700j = objArr[4];
        this.f10700j.setTag(null);
        this.f10701k = objArr[5];
        this.f10701k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10702l = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10702l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20146a((UnlockCity) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20146a(UnlockCity unlockCity) {
        this.f10693c = unlockCity;
        synchronized (this) {
            this.f10702l |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        CharSequence charSequence;
        boolean z2;
        String str5;
        String str6;
        String str7;
        synchronized (this) {
            j = this.f10702l;
            this.f10702l = 0;
        }
        UnlockCity unlockCity = this.f10693c;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (unlockCity != null) {
                str6 = unlockCity.getStartRate();
                str4 = unlockCity.getCity();
                str = unlockCity.getEndRate();
                str5 = unlockCity.getDesc();
                str7 = unlockCity.getImage();
            } else {
                str7 = null;
                str6 = null;
                str4 = null;
                str = null;
                str5 = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str6);
            sb.append("%→");
            String sb2 = sb.toString();
            z = TextUtils.isEmpty(str6);
            if (i != 0) {
                j = z ? j | 8 : j | 4;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(str);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append("%");
            str2 = sb5.toString();
            str3 = str7;
            charSequence = str5;
        } else {
            charSequence = null;
            z = false;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((4 & j) != 0) {
            z2 = TextUtils.isEmpty(str);
        } else {
            z2 = false;
        }
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        boolean z3 = i2 != 0 ? z ? true : z2 : false;
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f10697g, charSequence);
            ImageAdapter.m12783a((ImageView) this.f10698h, str3, 0, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f10699i, str4);
            ViewAdapter.m12798c((View) this.f10700j, Boolean.valueOf(z3));
            TextViewBindingAdapter.setText(this.f10701k, str2);
            ViewAdapter.m12798c((View) this.f10701k, Boolean.valueOf(z3));
        }
    }
}
