package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.module.travel.data.DogInfo;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import tech.linjiang.android.drawable.Drawables;

public class DialogDogDetailBindingImpl extends DialogDogDetailBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10339c = null;
    /* renamed from: d */
    private static final SparseIntArray f10340d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10341e;
    /* renamed from: f */
    private final ImageView f10342f;
    /* renamed from: g */
    private final TextView f10343g;
    /* renamed from: h */
    private final TextView f10344h;
    /* renamed from: i */
    private final LinearLayout f10345i;
    /* renamed from: j */
    private final TextView f10346j;
    /* renamed from: k */
    private final TextView f10347k;
    /* renamed from: l */
    private long f10348l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10340d.put(R.id.iv_close, 7);
    }

    public DialogDogDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f10339c, f10340d));
    }

    private DialogDogDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[7]);
        this.f10348l = -1;
        this.f10341e = objArr[0];
        this.f10341e.setTag(null);
        this.f10342f = objArr[1];
        this.f10342f.setTag(null);
        this.f10343g = objArr[2];
        this.f10343g.setTag(null);
        this.f10344h = objArr[3];
        this.f10344h.setTag(null);
        this.f10345i = objArr[4];
        this.f10345i.setTag(null);
        this.f10346j = objArr[5];
        this.f10346j.setTag(null);
        this.f10347k = objArr[6];
        this.f10347k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10348l = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10348l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20112a((DogInfo) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20112a(DogInfo dogInfo) {
        this.f10338b = dogInfo;
        synchronized (this) {
            this.f10348l |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        double d;
        double d2;
        int i;
        synchronized (this) {
            j = this.f10348l;
            this.f10348l = 0;
        }
        DogInfo dogInfo = this.f10338b;
        int i2 = 0;
        int i3 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (dogInfo != null) {
                i2 = dogInfo.getDogId();
                i = dogInfo.getLevel();
                d2 = dogInfo.getOffline();
                charSequence2 = dogInfo.getName();
                d = dogInfo.getOnline();
            } else {
                d2 = 0.0d;
                d = 0.0d;
                charSequence2 = null;
                i = 0;
            }
            i2 = MergeUtil.m14455b(i2);
            StringBuilder sb = new StringBuilder();
            sb.append("Lv.");
            sb.append(i);
            charSequence4 = sb.toString();
            String a = GoldUtil.f11900a.mo21651a(d2);
            String a2 = GoldUtil.f11900a.mo21651a(d);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a);
            sb2.append("/");
            charSequence3 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(a2);
            sb3.append("/");
            charSequence = sb3.toString();
        } else {
            charSequence4 = null;
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
        }
        if (i3 != 0) {
            ImageAdapter.m12780a(this.f10342f, Integer.valueOf(i2));
            TextViewBindingAdapter.setText(this.f10343g, charSequence4);
            TextViewBindingAdapter.setText(this.f10344h, charSequence2);
            TextViewBindingAdapter.setText(this.f10346j, charSequence);
            TextViewBindingAdapter.setText(this.f10347k, charSequence3);
        }
        if ((j & 2) != 0) {
            LinearLayout linearLayout = this.f10345i;
            LinearLayout linearLayout2 = linearLayout;
            Integer valueOf = Integer.valueOf(getColorFromResource(linearLayout, R.color.grey_f8));
            Integer num = null;
            Integer num2 = num;
            Integer num3 = num;
            Integer num4 = num;
            Integer num5 = num;
            Integer num6 = num;
            Integer num7 = num;
            Integer num8 = num;
            Integer num9 = num;
            Integer num10 = num;
            Integer num11 = num;
            Integer num12 = num;
            Integer num13 = num;
            Integer num14 = num;
            Integer num15 = num;
            Integer num16 = num;
            Integer num17 = num;
            Integer num18 = num;
            Integer num19 = num;
            Integer num20 = num;
            Integer num21 = num;
            Integer num22 = num;
            Integer num23 = num;
            Integer num24 = num;
            Integer num25 = num;
            Integer num26 = num;
            Integer num27 = num;
            Integer num28 = num;
            Integer num29 = num;
            Integer num30 = num;
            Integer num31 = num;
            Integer num32 = num;
            Integer num33 = num;
            Integer num34 = num;
            Integer num35 = num;
            Integer num36 = num;
            Integer num37 = num;
            Integer num38 = num;
            Integer num39 = num;
            Integer num40 = num;
            Integer num41 = num;
            Integer num42 = num;
            Integer num43 = num;
            Integer num44 = num;
            Integer num45 = num;
            Integer num46 = num;
            Integer num47 = num;
            Integer num48 = num;
            Integer num49 = num;
            Integer num50 = num;
            Integer num51 = num;
            Integer num52 = num;
            Integer num53 = num;
            Integer num54 = num;
            Integer num55 = num;
            Integer num56 = num;
            Integer num57 = num;
            Integer num58 = num;
            Integer num59 = num;
            Integer num60 = num;
            Integer num61 = num;
            Integer num62 = num;
            Integer num63 = num;
            Integer num64 = num;
            Integer num65 = num;
            Integer num66 = num;
            Integer num67 = num;
            Integer num68 = num;
            Integer num69 = num;
            Integer num70 = num;
            Integer num71 = num;
            Integer num72 = num;
            Integer num73 = num;
            Integer num74 = num;
            Integer num75 = num;
            Integer num76 = num;
            Integer num77 = num;
            Integer num78 = num;
            Integer num79 = num;
            Integer num80 = num;
            Integer num81 = num;
            Integer num82 = num;
            Integer num83 = num;
            Integer num84 = num;
            Integer num85 = num;
            Integer num86 = num;
            Integer num87 = num;
            Integer num88 = num;
            Integer num89 = num;
            Integer num90 = num;
            Integer num91 = num;
            Float f = null;
            Float f2 = f;
            Float f3 = f;
            Float f4 = f;
            Float f5 = f;
            Float f6 = f;
            Float f7 = f;
            Float f8 = f;
            Float f9 = f;
            Float f10 = f;
            Float f11 = f;
            Float f12 = f;
            Float f13 = f;
            Float f14 = f;
            Float f15 = f;
            Float f16 = f;
            Float f17 = f;
            Float f18 = f;
            Float f19 = f;
            Float f20 = f;
            Float f21 = f;
            Float f22 = f;
            Float f23 = f;
            Float f24 = f;
            Float f25 = f;
            Float f26 = f;
            Float f27 = f;
            Float f28 = f;
            Float f29 = f;
            Drawable drawable = null;
            Drawable drawable2 = drawable;
            Drawable drawable3 = drawable;
            Drawable drawable4 = drawable;
            Drawables.m37723a(linearLayout2, 0, valueOf, 0, num27, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, num57, num79, num88, 0, 0, f8, f13, 0.0f, num28, num47, num52, num58, num63, num69, num72, f24, num80, f29, 0, num2, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num37, num44, num48, 0, 0, f12, f21, 0.0f, num64, num67, num70, num71, num73, num76, num81, f25, num85, f28, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num14, num19, num20, 0, 0, f10, f11, 0.0f, num24, num29, num30, num32, num33, num38, num41, f17, num46, f19, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num66, num68, 0, 0, f22, f23, 0.0f, num74, num75, num77, num78, num82, num83, num84, f26, num86, f27, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num3, num4, num5, 0, 0, f2, f3, 0.0f, num8, num12, num13, num15, num16, num17, num18, f7, num21, f9, 0, num22, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num25, num26, num31, 0, 0, f14, f15, 0.0f, num34, num35, num39, num40, num42, num43, num45, f16, num36, f18, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f20, f6, 0.0f, num59, num60, num61, num62, num11, num10, num9, f4, num7, f5, drawable, drawable, drawable2, drawable3, drawable4, drawable, drawable);
        }
    }
}
