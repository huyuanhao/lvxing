package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.viewpager.widget.ViewPager;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import ezy.p653ui.widget.round.RoundText;
import tech.linjiang.android.drawable.Drawables;

public class ActivityInviteLogsBindingImpl extends ActivityInviteLogsBinding {
    /* renamed from: f */
    private static final IncludedLayouts f10031f = null;
    /* renamed from: g */
    private static final SparseIntArray f10032g = new SparseIntArray();
    /* renamed from: h */
    private final LinearLayout f10033h;
    /* renamed from: i */
    private final View f10034i;
    /* renamed from: j */
    private long f10035j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10032g.put(R.id.tv_sort, 3);
        f10032g.put(R.id.tab_indicator, 4);
        f10032g.put(R.id.lyt_tab, 5);
        f10032g.put(R.id.view_pager, 6);
    }

    public ActivityInviteLogsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f10031f, f10032g));
    }

    private ActivityInviteLogsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[5], (RoundText) objArr[4], (TextView) objArr[2], (TextView) objArr[3], (ViewPager) objArr[6]);
        this.f10035j = -1;
        this.f10033h = objArr[0];
        this.f10033h.setTag(null);
        this.f10034i = objArr[1];
        this.f10034i.setTag(null);
        this.f10028c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10035j = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10035j != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10035j;
            this.f10035j = 0;
        }
        if ((j & 1) != 0) {
            View view = this.f10034i;
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
            Drawables.m37723a(view, 0, Integer.valueOf(getColorFromResource(view, R.color.grey_f4)), 0, num109, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, num139, num161, num170, 0, 0, f34, f39, 0.0f, num110, num129, num134, num140, num145, num151, num154, f50, num162, f55, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num119, num126, num130, 0, 0, f38, f47, 0.0f, num146, num149, num152, num153, num155, num158, num163, f51, num167, f54, 0, num171, 0, num173, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num96, num101, num102, 0, 0, f36, f37, 0.0f, num106, num111, num112, num114, num115, num120, num123, f43, num128, f45, 0, num133, 0, num135, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num147, num148, num150, 0, 0, f48, f49, 0.0f, num156, num157, num159, num160, num164, num165, num166, f52, num168, f53, 0, num169, 0, num172, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f30, f31, 0.0f, num, num94, num95, num97, num98, num99, num100, f33, num103, f35, 0, num104, 0, num105, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num107, num108, num113, 0, 0, f40, f41, 0.0f, num116, num117, num121, num122, num124, num125, num127, f42, num118, f44, 0, num131, 0, num132, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num136, num137, num138, 0, 0, f46, f32, 0.0f, num141, num142, num143, num144, num93, num92, num, f, num, f, drawable, drawable, drawable9, drawable10, drawable11, drawable, drawable);
            TextViewAdapter.m12787a(this.f10028c, this.f10028c.getResources().getString(R.string.validate_profit));
            Drawables.m37723a(this.f10028c, 0, Integer.valueOf(getColorFromResource(this.f10028c, R.color.grey_f4)), 0, num2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 3.0f, 0.0f, num56, num79, num88, 0, 0, f18, f4, 0.0f, num3, num28, num47, num57, num58, num69, num72, f26, num80, f29, 0, num4, 0, num5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num37, num48, 0, 0, f7, f19, 0.0f, num63, num67, num70, num71, num73, num76, num81, f24, num85, f28, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num9, num20, num21, 0, 0, f11, f10, 0.0f, num25, num30, num31, num33, num34, num38, num41, f15, num44, f17, 0, num51, 0, num52, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num64, num66, num68, 0, 0, f22, f23, 0.0f, num74, num75, num77, num78, num82, num83, num84, f25, num86, f27, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num7, num8, 0, 0, f2, f3, 0.0f, num10, num12, num14, num16, num17, num18, num19, f8, num22, f9, 0, num23, 0, num24, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num26, num27, num32, 0, 0, f12, f13, 0.0f, num35, num36, num39, num40, num42, num43, num45, f16, num46, f14, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num53, num54, num55, 0, 0, f21, f20, 0.0f, num59, num60, num61, num62, num15, num65, num13, f5, num11, f6, drawable5, drawable7, drawable4, drawable8, drawable3, drawable6, drawable2);
        }
    }
}
