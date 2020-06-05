package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.widget.countdownview.CountdownView;
import com.jiayouya.travel.module.travel.data.PositionItem;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import tech.linjiang.android.drawable.Drawables;

public class ItemMergeBindingImpl extends ItemMergeBinding {
    /* renamed from: l */
    private static final IncludedLayouts f11106l = null;
    /* renamed from: m */
    private static final SparseIntArray f11107m = new SparseIntArray();
    /* renamed from: n */
    private final TextView f11108n;
    /* renamed from: o */
    private long f11109o;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f11107m.put(R.id.lyt_profit, 5);
        f11107m.put(R.id.iv_hb, 6);
        f11107m.put(R.id.lyt_profit_txt, 7);
        f11107m.put(R.id.iv_gold, 8);
        f11107m.put(R.id.tv_profit, 9);
    }

    public ItemMergeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, f11106l, f11107m));
    }

    private ItemMergeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CountdownView) objArr[4], (ImageView) objArr[1], (ImageView) objArr[8], (ImageView) objArr[6], (LinearLayout) objArr[3], (FrameLayout) objArr[0], (FrameLayout) objArr[5], (LinearLayout) objArr[7], (TextView) objArr[9]);
        this.f11109o = -1;
        this.f11095a.setTag(null);
        this.f11096b.setTag(null);
        this.f11099e.setTag(null);
        this.f11100f.setTag(null);
        this.f11108n = objArr[2];
        this.f11108n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11109o = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11109o != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20196a((PositionItem) obj);
        } else if (34 != i) {
            return false;
        } else {
            mo20195a(((Integer) obj).intValue());
        }
        return true;
    }

    /* renamed from: a */
    public void mo20196a(PositionItem positionItem) {
        this.f11104j = positionItem;
        synchronized (this) {
            this.f11109o |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20195a(int i) {
        this.f11105k = i;
        synchronized (this) {
            this.f11109o |= 2;
        }
        notifyPropertyChanged(34);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        synchronized (this) {
            j = this.f11109o;
            this.f11109o = 0;
        }
        PositionItem positionItem = this.f11104j;
        int i = this.f11105k;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            int level = positionItem != null ? positionItem.getLevel() : 0;
            StringBuilder sb = new StringBuilder();
            sb.append(level);
            sb.append("");
            charSequence = sb.toString();
        } else {
            charSequence = null;
        }
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((j & 4) != 0) {
            CustomAdapter.m12778a(this.f11095a, null, null, 1);
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
            Integer num92 = num;
            Integer num93 = num;
            Integer num94 = num;
            Integer num95 = num;
            Integer num96 = num;
            Integer num97 = num;
            Integer num98 = num;
            Integer num99 = num;
            Integer num100 = num;
            Integer num101 = num;
            Integer num102 = num;
            Integer num103 = num;
            Integer num104 = num;
            Integer num105 = num;
            Integer num106 = num;
            Integer num107 = num;
            Integer num108 = num;
            Integer num109 = num;
            Integer num110 = num;
            Integer num111 = num;
            Integer num112 = num;
            Integer num113 = num;
            Integer num114 = num;
            Integer num115 = num;
            Integer num116 = num;
            Integer num117 = num;
            Integer num118 = num;
            Integer num119 = num;
            Integer num120 = num;
            Integer num121 = num;
            Integer num122 = num;
            Integer num123 = num;
            Integer num124 = num;
            Integer num125 = num;
            Integer num126 = num;
            Integer num127 = num;
            Integer num128 = num;
            Integer num129 = num;
            Integer num130 = num;
            Integer num131 = num;
            Integer num132 = num;
            Integer num133 = num;
            Integer num134 = num;
            Integer num135 = num;
            Integer num136 = num;
            Integer num137 = num;
            Integer num138 = num;
            Integer num139 = num;
            Integer num140 = num;
            Integer num141 = num;
            Integer num142 = num;
            Integer num143 = num;
            Integer num144 = num;
            Integer num145 = num;
            Integer num146 = num;
            Integer num147 = num;
            Integer num148 = num;
            Integer num149 = num;
            Integer num150 = num;
            Integer num151 = num;
            Integer num152 = num;
            Integer num153 = num;
            Integer num154 = num;
            Integer num155 = num;
            Integer num156 = num;
            Integer num157 = num;
            Integer num158 = num;
            Integer num159 = num;
            Integer num160 = num;
            Integer num161 = num;
            Integer num162 = num;
            Integer num163 = num;
            Integer num164 = num;
            Integer num165 = num;
            Integer num166 = num;
            Integer num167 = num;
            Integer num168 = num;
            Integer num169 = num;
            Integer num170 = num;
            Integer num171 = num;
            Integer num172 = num;
            Integer num173 = num;
            Integer num174 = num;
            Integer num175 = num;
            Integer num176 = num;
            Integer num177 = num;
            Integer num178 = num;
            Integer num179 = num;
            Integer num180 = num;
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
            Float f30 = f;
            Float f31 = f;
            Float f32 = f;
            Float f33 = f;
            Float f34 = f;
            Float f35 = f;
            Float f36 = f;
            Float f37 = f;
            Float f38 = f;
            Float f39 = f;
            Float f40 = f;
            Float f41 = f;
            Float f42 = f;
            Float f43 = f;
            Float f44 = f;
            Float f45 = f;
            Float f46 = f;
            Float f47 = f;
            Float f48 = f;
            Float f49 = f;
            Float f50 = f;
            Float f51 = f;
            Float f52 = f;
            Float f53 = f;
            Float f54 = f;
            Float f55 = f;
            Float f56 = f;
            Float f57 = f;
            Drawable drawable = null;
            Drawable drawable2 = drawable;
            Drawable drawable3 = drawable;
            Drawable drawable4 = drawable;
            Drawable drawable5 = drawable;
            Drawable drawable6 = drawable;
            Drawable drawable7 = drawable;
            Drawable drawable8 = drawable;
            Drawables.m37723a(this.f11099e, 0, Integer.valueOf(2014581779), 0, num116, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, num146, num168, num177, 0, 0, f36, f41, 0.0f, num117, num136, num141, num147, num152, num158, num161, f52, num169, f57, 0, num91, 0, num95, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num126, num133, num137, 0, 0, f40, f49, 0.0f, num153, num156, num159, num160, num162, num165, num170, f53, num174, f56, 0, num178, 0, num180, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num103, num108, num109, 0, 0, f38, f39, 0.0f, num113, num118, num119, num121, num122, num127, num130, f45, num135, f47, 0, num140, 0, num142, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num154, num155, num157, 0, 0, f50, f51, 0.0f, num163, num164, num166, num167, num171, num172, num173, f54, num175, f55, 0, num176, 0, num179, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num92, num93, num94, 0, 0, f30, f31, 0.0f, num97, num101, num102, num104, num105, num106, num107, f35, num110, f37, 0, num111, 0, num112, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num114, num115, num120, 0, 0, f42, f43, 0.0f, num123, num124, num128, num129, num131, num132, num134, f44, num125, f46, 0, num138, 0, num139, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num143, num144, num145, 0, 0, f48, f34, 0.0f, num148, num149, num150, num151, num100, num99, num98, f32, num96, f33, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
            TextView textView = this.f11108n;
            Drawables.m37723a(textView, 0, num2, 0, num3, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, Integer.valueOf(getColorFromResource(textView, R.color.green_start)), num57, Integer.valueOf(getColorFromResource(this.f11108n, R.color.green_end)), 6, 0, f4, f8, 0.0f, num28, num47, num52, num58, num59, num70, num73, f24, num80, f29, 0, num4, 0, num5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num37, num48, 0, 0, f7, f19, 0.0f, num64, num68, num71, num72, num74, num77, num81, f25, num85, f28, 0, num88, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num9, num20, num21, 0, 0, f12, f11, 0.0f, num25, num30, num31, num33, num34, num38, num41, f16, num44, f18, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num67, num69, 0, 0, f22, f23, 0.0f, num75, num76, num78, num79, num82, num83, num84, f26, num86, f27, 0, num87, 0, num89, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num7, num8, 0, 0, f2, f3, 0.0f, num10, num12, num14, num16, num17, num18, num19, f9, num22, f10, 0, num23, 0, num24, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num26, num27, num32, 0, 0, f13, f14, 0.0f, num35, num36, num39, num40, num42, num43, num45, f17, num46, f15, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f21, f20, 0.0f, num60, num61, num62, num63, num15, num66, num13, f5, num11, f6, drawable5, drawable6, drawable4, drawable8, drawable3, drawable7, drawable2);
        }
        if (i3 != 0) {
            ImageAdapter.m12781a(this.f11096b, Integer.valueOf(i), 0, (CornerType) null, (Integer) null);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f11108n, charSequence);
        }
    }
}
