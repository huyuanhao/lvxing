package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.travel.data.DogShopItem;
import com.jiayouya.travel.module.travel.data.DogShopItemKt;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import ezy.p653ui.widget.round.RoundText;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import tech.linjiang.android.drawable.Drawables;

public class ItemDogShopBindingImpl extends ItemDogShopBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10965d = null;
    /* renamed from: e */
    private static final SparseIntArray f10966e = null;
    /* renamed from: f */
    private final LinearLayout f10967f;
    /* renamed from: g */
    private final FrameLayout f10968g;
    /* renamed from: h */
    private final ImageView f10969h;
    /* renamed from: i */
    private final RoundText f10970i;
    /* renamed from: j */
    private final TextView f10971j;
    /* renamed from: k */
    private final TextView f10972k;
    /* renamed from: l */
    private final ImageView f10973l;
    /* renamed from: m */
    private final TextView f10974m;
    /* renamed from: n */
    private long f10975n;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemDogShopBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, f10965d, f10966e));
    }

    private ItemDogShopBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[6]);
        this.f10975n = -1;
        this.f10962a.setTag(null);
        this.f10967f = objArr[0];
        this.f10967f.setTag(null);
        this.f10968g = objArr[1];
        this.f10968g.setTag(null);
        this.f10969h = objArr[2];
        this.f10969h.setTag(null);
        this.f10970i = objArr[3];
        this.f10970i.setTag(null);
        this.f10971j = objArr[4];
        this.f10971j.setTag(null);
        this.f10972k = objArr[5];
        this.f10972k.setTag(null);
        this.f10973l = objArr[7];
        this.f10973l.setTag(null);
        this.f10974m = objArr[8];
        this.f10974m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10975n = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10975n != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20177a((DogShopItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20176a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20177a(DogShopItem dogShopItem) {
        this.f10963b = dogShopItem;
        synchronized (this) {
            this.f10975n |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20176a(OnClickListener onClickListener) {
        this.f10964c = onClickListener;
        synchronized (this) {
            this.f10975n |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        boolean z;
        int i2;
        String str;
        boolean z2;
        int i3;
        CharSequence charSequence;
        CharSequence charSequence2;
        int i4;
        String str2;
        String str3;
        double d;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f10975n;
            this.f10975n = 0;
        }
        DogShopItem dogShopItem = this.f10963b;
        OnClickListener onClickListener = this.f10964c;
        int i5 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (dogShopItem != null) {
                d = dogShopItem.getCoinProfit();
                z = dogShopItem.isLock();
                int level = dogShopItem.getLevel();
                str3 = dogShopItem.getName();
                i4 = level;
            } else {
                i4 = 0;
                d = 0.0d;
                z = false;
                str3 = null;
            }
            if (i5 != 0) {
                j = z ? j | 16 : j | 8;
            }
            i = DogShopItemKt.image(dogShopItem);
            String a = GoldUtil.f11900a.mo21651a(d);
            z2 = !z;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i4);
            str = sb.toString();
            if ((j & 5) != 0) {
                if (z2) {
                    j3 = j | 64;
                    j2 = 256;
                } else {
                    j3 = j | 32;
                    j2 = 128;
                }
                j = j3 | j2;
            }
            int i6 = R.color.grey_f4;
            int colorFromResource = z2 ? getColorFromResource(this.f10962a, R.color.green_start) : getColorFromResource(this.f10962a, R.color.grey_f4);
            LinearLayout linearLayout = this.f10962a;
            if (z2) {
                i6 = R.color.green_end;
            }
            i3 = getColorFromResource(linearLayout, i6);
            i2 = colorFromResource;
            charSequence = a;
            charSequence2 = str3;
        } else {
            i4 = 0;
            charSequence2 = null;
            charSequence = null;
            i3 = 0;
            z2 = false;
            str = null;
            i2 = 0;
            z = false;
            i = 0;
        }
        int i7 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        CharSequence curPriceStr = (8 & j) != 0 ? DogShopItemKt.curPriceStr(dogShopItem) : null;
        if ((16 & j) != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Lv.");
            sb2.append(i4);
            str2 = sb2.toString();
        } else {
            str2 = null;
        }
        int i8 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i8 == 0) {
            curPriceStr = null;
        } else if (z) {
            curPriceStr = str2;
        }
        if (i8 != 0) {
            ViewAdapter.m12793a((View) this.f10962a, Boolean.valueOf(z2));
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
            Drawables.m37723a(this.f10962a, 0, num24, 0, num, 0.0f, 0.0f, 15.0f, 0.0f, 0.0f, 0.0f, 0.0f, Integer.valueOf(i2), num42, Integer.valueOf(i3), 6, 0, f9, f12, 0.0f, num5, num19, num22, num25, num26, num32, num35, f24, num43, f29, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num10, num16, num20, 0, 0, f6, f21, 0.0f, num27, num30, num33, num34, num36, num39, num44, f25, num48, f28, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num2, num3, 0, 0, f10, f11, 0.0f, num4, num6, num7, num8, num9, num11, num13, f18, num18, f16, 0, num21, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num28, num29, num31, 0, 0, f22, f23, 0.0f, num37, num38, num40, num41, num45, num46, num47, f26, num49, f27, 0, num50, 0, num52, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f2, f3, 0.0f, num, num, num, num, num, num, num, f8, num, f19, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f13, f14, 0.0f, num, num, num, num12, num14, num15, num17, f17, num, f15, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f20, f7, 0.0f, num, num, num, num, num, num, num, f4, num, f5, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
            ImageAdapter.m12781a(this.f10969h, Integer.valueOf(i), 0, (CornerType) null, num);
            TextViewBindingAdapter.setText(this.f10970i, str);
            TextViewBindingAdapter.setText(this.f10971j, charSequence2);
            TextViewBindingAdapter.setText(this.f10972k, charSequence);
            ViewAdapter.m12793a((View) this.f10973l, Boolean.valueOf(z2));
            TextViewBindingAdapter.setText(this.f10974m, curPriceStr);
            ViewAdapter.m12793a((View) this.f10974m, Boolean.valueOf(z2));
        }
        if (i7 != 0) {
            ViewAdapter.m12792a(this.f10967f, onClickListener, Integer.valueOf(500));
        }
        if ((j & 4) != 0) {
            FrameLayout frameLayout = this.f10968g;
            Integer num54 = null;
            Integer num55 = num54;
            Integer num56 = num54;
            Integer num57 = num54;
            Integer num58 = num54;
            Integer num59 = num54;
            Integer num60 = num54;
            Integer num61 = num54;
            Integer num62 = num54;
            Integer num63 = num54;
            Integer num64 = num54;
            Integer num65 = num54;
            Integer num66 = num54;
            Integer num67 = num54;
            Integer num68 = num54;
            Integer num69 = num54;
            Integer num70 = num54;
            Integer num71 = num54;
            Integer num72 = num54;
            Integer num73 = num54;
            Integer num74 = num54;
            Integer num75 = num54;
            Integer num76 = num54;
            Integer num77 = num54;
            Integer num78 = num54;
            Integer num79 = num54;
            Integer num80 = num54;
            Integer num81 = num54;
            Integer num82 = num54;
            Integer num83 = num54;
            Integer num84 = num54;
            Integer num85 = num54;
            Integer num86 = num54;
            Integer num87 = num54;
            Integer num88 = num54;
            Integer num89 = num54;
            Integer num90 = num54;
            Integer num91 = num54;
            Integer num92 = num54;
            Integer num93 = num54;
            Integer num94 = num54;
            Integer num95 = num54;
            Integer num96 = num54;
            Integer num97 = num54;
            Integer num98 = num54;
            Integer num99 = num54;
            Integer num100 = num54;
            Integer num101 = num54;
            Integer num102 = num54;
            Integer num103 = num54;
            Integer num104 = num54;
            Integer num105 = num54;
            Integer num106 = num54;
            Integer num107 = num54;
            Integer num108 = num54;
            Integer num109 = num54;
            Integer num110 = num54;
            Integer num111 = num54;
            Integer num112 = num54;
            Integer num113 = num54;
            Integer num114 = num54;
            Integer num115 = num54;
            Integer num116 = num54;
            Integer num117 = num54;
            Integer num118 = num54;
            Integer num119 = num54;
            Integer num120 = num54;
            Integer num121 = num54;
            Integer num122 = num54;
            Integer num123 = num54;
            Integer num124 = num54;
            Integer num125 = num54;
            Integer num126 = num54;
            Integer num127 = num54;
            Integer num128 = num54;
            Integer num129 = num54;
            Integer num130 = num54;
            Integer num131 = num54;
            Integer num132 = num54;
            Integer num133 = num54;
            Integer num134 = num54;
            Integer num135 = num54;
            Integer num136 = num54;
            Integer num137 = num54;
            Integer num138 = num54;
            Integer num139 = num54;
            Integer num140 = num54;
            Integer num141 = num54;
            Integer num142 = num54;
            Integer num143 = num54;
            Integer num144 = num54;
            Float f30 = null;
            Float f31 = f30;
            Float f32 = f30;
            Float f33 = f30;
            Drawable drawable2 = null;
            Drawables.m37723a(frameLayout, 0, Integer.valueOf(getColorFromResource(frameLayout, R.color.grey_f8)), 0, num80, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, num110, num132, num141, 0, 0, f30, f31, 0.0f, num81, num100, num105, num111, num116, num122, num125, f32, num133, f33, 0, num55, 0, num59, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num90, num97, num101, 0, 0, f30, f30, 0.0f, num117, num120, num123, num124, num126, num129, num134, f30, num138, f30, 0, num142, 0, num144, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num67, num72, num73, 0, 0, f30, f30, 0.0f, num77, num82, num83, num85, num86, num91, num94, f30, num99, f30, 0, num104, 0, num106, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num118, num119, num121, 0, 0, f30, f30, 0.0f, num127, num128, num130, num131, num135, num136, num137, f30, num139, f30, 0, num140, 0, num143, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num56, num57, num58, 0, 0, f30, f30, 0.0f, num61, num65, num66, num68, num69, num70, num71, f30, num74, f30, 0, num75, 0, num76, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num78, num79, num84, 0, 0, f30, f30, 0.0f, num87, num88, num92, num93, num95, num96, num98, f30, num89, f30, 0, num102, 0, num103, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num107, num108, num109, 0, 0, f30, f30, 0.0f, num112, num113, num114, num115, num64, num63, num62, f30, num60, f30, drawable2, drawable2, drawable2, drawable2, drawable2, drawable2, drawable2);
        }
    }
}
