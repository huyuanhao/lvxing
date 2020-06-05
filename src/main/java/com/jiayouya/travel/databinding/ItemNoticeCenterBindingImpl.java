package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.p276me.data.NoticeItem;
import tech.linjiang.android.drawable.Drawables;

public class ItemNoticeCenterBindingImpl extends ItemNoticeCenterBinding {
    /* renamed from: b */
    private static final IncludedLayouts f11111b = null;
    /* renamed from: c */
    private static final SparseIntArray f11112c = null;
    /* renamed from: d */
    private final LinearLayout f11113d;
    /* renamed from: e */
    private final TextView f11114e;
    /* renamed from: f */
    private final LinearLayout f11115f;
    /* renamed from: g */
    private final View f11116g;
    /* renamed from: h */
    private final TextView f11117h;
    /* renamed from: i */
    private final TextView f11118i;
    /* renamed from: j */
    private long f11119j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemNoticeCenterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f11111b, f11112c));
    }

    private ItemNoticeCenterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11119j = -1;
        this.f11113d = objArr[0];
        this.f11113d.setTag(null);
        this.f11114e = objArr[1];
        this.f11114e.setTag(null);
        this.f11115f = objArr[2];
        this.f11115f.setTag(null);
        this.f11116g = objArr[3];
        this.f11116g.setTag(null);
        this.f11117h = objArr[4];
        this.f11117h.setTag(null);
        this.f11118i = objArr[5];
        this.f11118i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11119j = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11119j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20197a((NoticeItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20197a(NoticeItem noticeItem) {
        this.f11110a = noticeItem;
        synchronized (this) {
            this.f11119j |= 1;
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
        synchronized (this) {
            j = this.f11119j;
            this.f11119j = 0;
        }
        NoticeItem noticeItem = this.f11110a;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i == 0 || noticeItem == null) {
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
        } else {
            charSequence2 = noticeItem.getTime();
            charSequence = noticeItem.getTitle();
            charSequence3 = noticeItem.getContent();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f11114e, charSequence2);
            TextViewBindingAdapter.setText(this.f11117h, charSequence);
            TextViewBindingAdapter.setText(this.f11118i, charSequence3);
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
            Integer num182 = num;
            Integer num183 = num;
            Integer num184 = num;
            Integer num185 = num;
            Integer num186 = num;
            Integer num187 = num;
            Integer num188 = num;
            Integer num189 = num;
            Integer num190 = num;
            Integer num191 = num;
            Integer num192 = num;
            Integer num193 = num;
            Integer num194 = num;
            Integer num195 = num;
            Integer num196 = num;
            Integer num197 = num;
            Integer num198 = num;
            Integer num199 = num;
            Integer num200 = num;
            Integer num201 = num;
            Integer num202 = num;
            Integer num203 = num;
            Integer num204 = num;
            Integer num205 = num;
            Integer num206 = num;
            Integer num207 = num;
            Integer num208 = num;
            Integer num209 = num;
            Integer num210 = num;
            Integer num211 = num;
            Integer num212 = num;
            Integer num213 = num;
            Integer num214 = num;
            Integer num215 = num;
            Integer num216 = num;
            Integer num217 = num;
            Integer num218 = num;
            Integer num219 = num;
            Integer num220 = num;
            Integer num221 = num;
            Integer num222 = num;
            Integer num223 = num;
            Integer num224 = num;
            Integer num225 = num;
            Integer num226 = num;
            Integer num227 = num;
            Integer num228 = num;
            Integer num229 = num;
            Integer num230 = num;
            Integer num231 = num;
            Integer num232 = num;
            Integer num233 = num;
            Integer num234 = num;
            Integer num235 = num;
            Integer num236 = num;
            Integer num237 = num;
            Integer num238 = num;
            Integer num239 = num;
            Integer num240 = num;
            Integer num241 = num;
            Integer num242 = num;
            Integer num243 = num;
            Integer num244 = num;
            Integer num245 = num;
            Integer num246 = num;
            Integer num247 = num;
            Integer num248 = num;
            Integer num249 = num;
            Integer num250 = num;
            Integer num251 = num;
            Integer num252 = num;
            Integer num253 = num;
            Integer num254 = num;
            Integer num255 = num;
            Integer num256 = num;
            Integer num257 = num;
            Integer num258 = num;
            Integer num259 = num;
            Integer num260 = num;
            Integer num261 = num;
            Integer num262 = num;
            Integer num263 = num;
            Integer num264 = num;
            Integer num265 = num;
            Integer num266 = num;
            Integer num267 = num;
            Integer num268 = num;
            Integer num269 = num;
            Integer num270 = num;
            Integer num271 = num;
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
            Float f58 = f;
            Float f59 = f;
            Float f60 = f;
            Float f61 = f;
            Float f62 = f;
            Float f63 = f;
            Float f64 = f;
            Float f65 = f;
            Float f66 = f;
            Float f67 = f;
            Float f68 = f;
            Float f69 = f;
            Float f70 = f;
            Float f71 = f;
            Float f72 = f;
            Float f73 = f;
            Float f74 = f;
            Float f75 = f;
            Float f76 = f;
            Float f77 = f;
            Float f78 = f;
            Float f79 = f;
            Float f80 = f;
            Float f81 = f;
            Float f82 = f;
            Float f83 = f;
            Float f84 = f;
            Float f85 = f;
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
            Drawable drawable12 = drawable;
            Drawable drawable13 = drawable;
            Drawable drawable14 = drawable;
            Drawable drawable15 = drawable;
            Drawable drawable16 = drawable;
            Drawable drawable17 = drawable;
            Drawable drawable18 = drawable;
            Drawables.m37723a(this.f11114e, 0, Integer.valueOf(-1973791), 0, num207, 0.0f, 0.0f, 9.0f, 0.0f, 0.0f, 0.0f, 0.0f, num237, num259, num268, 0, 0, f64, f69, 0.0f, num208, num227, num232, num238, num243, num249, num252, f80, num260, f85, 0, num182, 0, num186, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num217, num224, num228, 0, 0, f68, f77, 0.0f, num244, num247, num250, num251, num253, num256, num261, f81, num265, f84, 0, num269, 0, num271, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num194, num199, num200, 0, 0, f66, f67, 0.0f, num204, num209, num210, num212, num213, num218, num221, f73, num226, f75, 0, num231, 0, num233, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num245, num246, num248, 0, 0, f78, f79, 0.0f, num254, num255, num257, num258, num262, num263, num264, f82, num266, f83, 0, num267, 0, num270, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num183, num184, num185, 0, 0, f58, f59, 0.0f, num188, num192, num193, num195, num196, num197, num198, f63, num201, f65, 0, num202, 0, num203, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num205, num206, num211, 0, 0, f70, f71, 0.0f, num214, num215, num219, num220, num222, num223, num225, f72, num216, f74, 0, num229, 0, num230, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num234, num235, num236, 0, 0, f76, f62, 0.0f, num239, num240, num241, num242, num191, num190, num189, f60, num187, f61, drawable, drawable, drawable16, drawable17, drawable18, drawable, drawable);
            LinearLayout linearLayout = this.f11115f;
            Drawables.m37723a(linearLayout, 0, Integer.valueOf(getColorFromResource(linearLayout, R.color.white)), 0, num92, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, num146, num169, num178, 0, 0, f46, f32, 0.0f, num93, num118, num137, num147, num148, num159, num162, f54, num170, f57, 0, num94, 0, num95, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num119, num127, num138, 0, 0, f35, f47, 0.0f, num153, num157, num160, num161, num163, num166, num171, f52, num175, f56, 0, num179, 0, num181, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num99, num110, num111, 0, 0, f39, f38, 0.0f, num115, num120, num121, num123, num124, num128, num131, f43, num134, f45, 0, num141, 0, num142, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num154, num156, num158, 0, 0, f50, f51, 0.0f, num164, num165, num167, num168, num172, num173, num174, f53, num176, f55, 0, num177, 0, num180, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num96, num97, num98, 0, 0, f30, f31, 0.0f, num100, num102, num104, num106, num107, num108, num109, f36, num112, f37, 0, num113, 0, num114, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num116, num117, num122, 0, 0, f40, f41, 0.0f, num125, num126, num129, num130, num132, num133, num135, f44, num136, f42, 0, num139, 0, num140, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num143, num144, num145, 0, 0, f49, f48, 0.0f, num149, num150, num151, num152, num105, num155, num103, f33, num101, f34, drawable12, drawable14, drawable11, drawable15, drawable10, drawable13, drawable9);
            Drawables.m37723a(this.f11116g, 0, Integer.valueOf(-11939221), 0, num2, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, num56, num79, num88, 0, 0, f18, f4, 0.0f, num3, num28, num47, num57, num58, num69, num72, f26, num80, f29, 0, num4, 0, num5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num37, num48, 0, 0, f7, f19, 0.0f, num63, num67, num70, num71, num73, num76, num81, f24, num85, f28, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num9, num20, num21, 0, 0, f11, f10, 0.0f, num25, num30, num31, num33, num34, num38, num41, f15, num44, f17, 0, num51, 0, num52, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num64, num66, num68, 0, 0, f22, f23, 0.0f, num74, num75, num77, num78, num82, num83, num84, f25, num86, f27, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num7, num8, 0, 0, f2, f3, 0.0f, num10, num12, num14, num16, num17, num18, num19, f8, num22, f9, 0, num23, 0, num24, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num26, num27, num32, 0, 0, f12, f13, 0.0f, num35, num36, num39, num40, num42, num43, num45, f16, num46, f14, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num53, num54, num55, 0, 0, f21, f20, 0.0f, num59, num60, num61, num62, num15, num65, num13, f5, num11, f6, drawable5, drawable7, drawable4, drawable8, drawable3, drawable6, drawable2);
        }
    }
}
