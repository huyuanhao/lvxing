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
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.module.travel.data.TempBonusItem;
import tech.linjiang.android.drawable.Drawables;

public class DialogTempBonusBindingImpl extends DialogTempBonusBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10646d = null;
    /* renamed from: e */
    private static final SparseIntArray f10647e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10648f;
    /* renamed from: g */
    private final TextView f10649g;
    /* renamed from: h */
    private final TextView f10650h;
    /* renamed from: i */
    private final LinearLayout f10651i;
    /* renamed from: j */
    private final TextView f10652j;
    /* renamed from: k */
    private long f10653k;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10647e.put(R.id.iv_close, 6);
    }

    public DialogTempBonusBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f10646d, f10647e));
    }

    private DialogTempBonusBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (TextView) objArr[5]);
        this.f10653k = -1;
        this.f10648f = objArr[0];
        this.f10648f.setTag(null);
        this.f10649g = objArr[1];
        this.f10649g.setTag(null);
        this.f10650h = objArr[2];
        this.f10650h.setTag(null);
        this.f10651i = objArr[3];
        this.f10651i.setTag(null);
        this.f10652j = objArr[4];
        this.f10652j.setTag(null);
        this.f10644b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10653k = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10653k != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20142a((TempBonusItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20142a(TempBonusItem tempBonusItem) {
        this.f10645c = tempBonusItem;
        synchronized (this) {
            this.f10653k |= 1;
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
        long j2;
        String str;
        synchronized (this) {
            j = this.f10653k;
            this.f10653k = 0;
        }
        TempBonusItem tempBonusItem = this.f10645c;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (tempBonusItem != null) {
                j2 = tempBonusItem.getTime();
                str = tempBonusItem.getAmount();
            } else {
                j2 = 0;
                str = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(j2);
            sb.append("分钟限时分红犬");
            charSequence = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("持续获得平台");
            sb2.append(j2);
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("元");
            charSequence3 = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb3);
            sb5.append("分钟广告分红");
            charSequence2 = sb5.toString();
        } else {
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f10649g, charSequence);
            TextViewBindingAdapter.setText(this.f10650h, charSequence2);
            TextViewBindingAdapter.setText(this.f10652j, charSequence3);
        }
        if ((j & 2) != 0) {
            LinearLayout linearLayout = this.f10651i;
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
            TextViewAdapter.m12787a(this.f10644b, this.f10644b.getResources().getString(R.string.temp_bonus));
        }
    }
}
