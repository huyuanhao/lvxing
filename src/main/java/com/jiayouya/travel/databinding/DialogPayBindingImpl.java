package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import tech.linjiang.android.drawable.Drawables;

public class DialogPayBindingImpl extends DialogPayBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10556e = null;
    /* renamed from: f */
    private static final SparseIntArray f10557f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f10558g;
    /* renamed from: h */
    private final TextView f10559h;
    /* renamed from: i */
    private final TextView f10560i;
    /* renamed from: j */
    private long f10561j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10557f.put(R.id.iv_close, 4);
        f10557f.put(R.id.lyt_pay, 5);
    }

    public DialogPayBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f10556e, f10557f));
    }

    private DialogPayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (RecyclerView) objArr[2], (LinearLayout) objArr[5]);
        this.f10561j = -1;
        this.f10553b.setTag(null);
        this.f10558g = objArr[0];
        this.f10558g.setTag(null);
        this.f10559h = objArr[1];
        this.f10559h.setTag(null);
        this.f10560i = objArr[3];
        this.f10560i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10561j = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10561j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (20 != i) {
            return false;
        }
        mo20135a((String) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20135a(String str) {
        this.f10555d = str;
        synchronized (this) {
            this.f10561j |= 1;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        synchronized (this) {
            j = this.f10561j;
            this.f10561j = 0;
        }
        String str = this.f10555d;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("¥");
            sb.append(str);
            charSequence = sb.toString();
        } else {
            charSequence = null;
        }
        if ((j & 2) != 0) {
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
            Integer num181 = num;
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
            Drawable drawable9 = drawable;
            Drawable drawable10 = drawable;
            Drawable drawable11 = drawable;
            Drawables.m37723a(this.f10553b, 0, Integer.valueOf(getColorFromResource(this.f10553b, R.color.white)), 0, num117, 0.0f, 0.0f, 7.0f, 0.0f, 0.0f, 0.0f, 0.0f, num147, num169, num178, 0, 0, f36, f41, 0.0f, num118, num137, num142, num148, num153, num159, num162, f52, num170, f57, 0, num92, 0, num96, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num127, num134, num138, 0, 0, f40, f49, 0.0f, num154, num157, num160, num161, num163, num166, num171, f53, num175, f56, 0, num179, 0, num181, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num104, num109, num110, 0, 0, f38, f39, 0.0f, num114, num119, num120, num122, num123, num128, num131, f45, num136, f47, 0, num141, 0, num143, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num155, num156, num158, 0, 0, f50, f51, 0.0f, num164, num165, num167, num168, num172, num173, num174, f54, num176, f55, 0, num177, 0, num180, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num93, num94, num95, 0, 0, f30, f31, 0.0f, num98, num102, num103, num105, num106, num107, num108, f35, num111, f37, 0, num112, 0, num113, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num115, num116, num121, 0, 0, f42, f43, 0.0f, num124, num125, num129, num130, num132, num133, num135, f44, num126, f46, 0, num139, 0, num140, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num144, num145, num146, 0, 0, f48, f34, 0.0f, num149, num150, num151, num152, num101, num100, num99, f32, num97, f33, drawable, drawable, drawable9, drawable10, drawable11, drawable, drawable);
            LinearLayout linearLayout = this.f10558g;
            Drawables.m37723a(linearLayout, 0, Integer.valueOf(getColorFromResource(linearLayout, R.color.grey_F5F5F9)), 0, num2, 0.0f, 0.0f, 0.0f, 20.0f, 0.0f, 20.0f, 0.0f, num56, num79, num88, 0, 0, f18, f4, 0.0f, num3, num28, num47, num57, num58, num69, num72, f26, num80, f29, 0, num4, 0, num5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num37, num48, 0, 0, f7, f19, 0.0f, num63, num67, num70, num71, num73, num76, num81, f24, num85, f28, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num9, num20, num21, 0, 0, f11, f10, 0.0f, num25, num30, num31, num33, num34, num38, num41, f15, num44, f17, 0, num51, 0, num52, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num64, num66, num68, 0, 0, f22, f23, 0.0f, num74, num75, num77, num78, num82, num83, num84, f25, num86, f27, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num7, num8, 0, 0, f2, f3, 0.0f, num10, num12, num14, num16, num17, num18, num19, f8, num22, f9, 0, num23, 0, num24, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num26, num27, num32, 0, 0, f12, f13, 0.0f, num35, num36, num39, num40, num42, num43, num45, f16, num46, f14, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num53, num54, num55, 0, 0, f21, f20, 0.0f, num59, num60, num61, num62, num15, num65, num13, f5, num11, f6, drawable5, drawable7, drawable4, drawable8, drawable3, drawable6, drawable2);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f10559h, str);
            TextViewBindingAdapter.setText(this.f10560i, charSequence);
        }
    }
}
