package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.module.p276me.data.BonusDetailRsp;
import ezy.p653ui.widget.CenteredTitleBar;
import tech.linjiang.android.drawable.Drawables;

public class ActivityBonusDetailBindingImpl extends ActivityBonusDetailBinding {
    /* renamed from: d */
    private static final IncludedLayouts f9868d = null;
    /* renamed from: e */
    private static final SparseIntArray f9869e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f9870f;
    /* renamed from: g */
    private final CenteredTitleBar f9871g;
    /* renamed from: h */
    private final TextView f9872h;
    /* renamed from: i */
    private final TextView f9873i;
    /* renamed from: j */
    private final TextView f9874j;
    /* renamed from: k */
    private final RndCornerProgressBar f9875k;
    /* renamed from: l */
    private final TextView f9876l;
    /* renamed from: m */
    private final LinearLayout f9877m;
    /* renamed from: n */
    private final TextView f9878n;
    /* renamed from: o */
    private final TextView f9879o;
    /* renamed from: p */
    private final FrameLayout f9880p;
    /* renamed from: q */
    private final TextView f9881q;
    /* renamed from: r */
    private final TextView f9882r;
    /* renamed from: s */
    private final TextView f9883s;
    /* renamed from: t */
    private long f9884t;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9869e.put(R.id.scroll_view, 15);
    }

    public ActivityBonusDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, f9868d, f9869e));
    }

    private ActivityBonusDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ScrollView) objArr[15], (TextView) objArr[2]);
        this.f9884t = -1;
        this.f9870f = objArr[0];
        this.f9870f.setTag(null);
        this.f9871g = objArr[1];
        this.f9871g.setTag(null);
        this.f9872h = objArr[10];
        this.f9872h.setTag(null);
        this.f9873i = objArr[11];
        this.f9873i.setTag(null);
        this.f9874j = objArr[12];
        this.f9874j.setTag(null);
        this.f9875k = objArr[13];
        this.f9875k.setTag(null);
        this.f9876l = objArr[14];
        this.f9876l.setTag(null);
        this.f9877m = objArr[3];
        this.f9877m.setTag(null);
        this.f9878n = objArr[4];
        this.f9878n.setTag(null);
        this.f9879o = objArr[5];
        this.f9879o.setTag(null);
        this.f9880p = objArr[6];
        this.f9880p.setTag(null);
        this.f9881q = objArr[7];
        this.f9881q.setTag(null);
        this.f9882r = objArr[8];
        this.f9882r.setTag(null);
        this.f9883s = objArr[9];
        this.f9883s.setTag(null);
        this.f9866b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9884t = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9884t != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20078a((BonusDetailRsp) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20078a(BonusDetailRsp bonusDetailRsp) {
        this.f9867c = bonusDetailRsp;
        synchronized (this) {
            this.f9884t |= 1;
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
        String str5;
        String str6;
        String str7;
        CharSequence charSequence;
        String str8;
        synchronized (this) {
            j = this.f9884t;
            this.f9884t = 0;
        }
        BonusDetailRsp bonusDetailRsp = this.f9867c;
        float f = 0.0f;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (bonusDetailRsp != null) {
                String news = bonusDetailRsp.getNews();
                str7 = bonusDetailRsp.getSuperDogIntro();
                str6 = bonusDetailRsp.getYesterday();
                str8 = bonusDetailRsp.getNum();
                str3 = bonusDetailRsp.getH5Url();
                str2 = bonusDetailRsp.getHistory();
                str = bonusDetailRsp.getPrice();
                CharSequence charSequence2 = news;
                f = bonusDetailRsp.getScorePercent();
                charSequence = charSequence2;
            } else {
                charSequence = null;
                str7 = null;
                str6 = null;
                str8 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str8);
            sb.append("只");
            str4 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("已完成");
            sb2.append(f);
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            sb4.append("%。由个人活跃和好友活跃两个维度综合计算");
            str5 = sb4.toString();
        } else {
            charSequence = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
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
            Float f2 = null;
            Float f3 = f2;
            Float f4 = f2;
            Float f5 = f2;
            Float f6 = f2;
            Float f7 = f2;
            Float f8 = f2;
            Float f9 = f2;
            Float f10 = f2;
            Float f11 = f2;
            Float f12 = f2;
            Float f13 = f2;
            Float f14 = f2;
            Float f15 = f2;
            Float f16 = f2;
            Float f17 = f2;
            Float f18 = f2;
            Float f19 = f2;
            Float f20 = f2;
            Float f21 = f2;
            Float f22 = f2;
            Float f23 = f2;
            Float f24 = f2;
            Float f25 = f2;
            Float f26 = f2;
            Float f27 = f2;
            Float f28 = f2;
            Float f29 = f2;
            Float f30 = f2;
            Float f31 = f2;
            Float f32 = f2;
            Float f33 = f2;
            Float f34 = f2;
            Float f35 = f2;
            Float f36 = f2;
            Float f37 = f2;
            Float f38 = f2;
            Float f39 = f2;
            Float f40 = f2;
            Float f41 = f2;
            Float f42 = f2;
            Float f43 = f2;
            Float f44 = f2;
            Float f45 = f2;
            Float f46 = f2;
            Float f47 = f2;
            Float f48 = f2;
            Float f49 = f2;
            Float f50 = f2;
            Float f51 = f2;
            Float f52 = f2;
            Float f53 = f2;
            Float f54 = f2;
            Float f55 = f2;
            Float f56 = f2;
            Float f57 = f2;
            Float f58 = f2;
            Float f59 = f2;
            Float f60 = f2;
            Float f61 = f2;
            Float f62 = f2;
            Float f63 = f2;
            Float f64 = f2;
            Float f65 = f2;
            Float f66 = f2;
            Float f67 = f2;
            Float f68 = f2;
            Float f69 = f2;
            Float f70 = f2;
            Float f71 = f2;
            Float f72 = f2;
            Float f73 = f2;
            Float f74 = f2;
            Float f75 = f2;
            Float f76 = f2;
            Float f77 = f2;
            Float f78 = f2;
            Float f79 = f2;
            Float f80 = f2;
            Float f81 = f2;
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
            Drawables.m37723a(this.f9871g, 0, num207, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Integer.valueOf(-32164), num230, Integer.valueOf(-32164), 6, 0, f61, f64, 0.0f, num188, num202, num205, num208, num209, num220, num223, f76, num231, f81, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num193, num199, num203, 0, 0, f59, f73, 0.0f, num214, num218, num221, num222, num224, num227, num232, f77, num236, f80, 0, num239, 0, num241, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num181, num185, num186, 0, 0, f62, f63, 0.0f, num187, num189, num190, num191, num192, num194, num196, f70, num201, f68, 0, num204, 0, num206, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num215, num217, num219, 0, 0, f74, f75, 0.0f, num225, num226, num228, num229, num233, num234, num235, f78, num237, f79, 0, num238, 0, num240, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f2, f2, 0.0f, num, num, num, num, num, num, num, f60, num, f71, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f65, f66, 0.0f, num, num, num, num195, num197, num198, num200, f69, num, f67, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f72, f2, 0.0f, num210, num211, num212, num213, num184, num216, num183, f2, num182, f2, drawable, drawable, drawable16, drawable, drawable, drawable, drawable);
            ViewAdapter.m12794a((View) this.f9874j, "/me/bonusDog");
            Drawables.m37723a(this.f9877m, 0, num92, 0, num93, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Integer.valueOf(-32164), num147, Integer.valueOf(-32164), 6, 0, f33, f37, 0.0f, num118, num137, num142, num148, num149, num160, num163, f53, num170, f58, 0, num94, 0, num95, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num119, num127, num138, 0, 0, f36, f48, 0.0f, num154, num158, num161, num162, num164, num167, num171, f54, num175, f57, 0, num178, 0, num180, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num99, num110, num111, 0, 0, f41, f40, 0.0f, num115, num120, num121, num123, num124, num128, num131, f45, num134, f47, 0, num141, 0, num143, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num155, num157, num159, 0, 0, f51, f52, 0.0f, num165, num166, num168, num169, num172, num173, num174, f55, num176, f56, 0, num177, 0, num179, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num96, num97, num98, 0, 0, f31, f32, 0.0f, num100, num102, num104, num106, num107, num108, num109, f38, num112, f39, 0, num113, 0, num114, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num116, num117, num122, 0, 0, f42, f43, 0.0f, num125, num126, num129, num130, num132, num133, num135, f46, num136, f44, 0, num139, 0, num140, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num144, num145, num146, 0, 0, f50, f49, 0.0f, num150, num151, num152, num153, num105, num156, num103, f34, num101, f35, drawable12, drawable13, drawable11, drawable15, drawable10, drawable14, drawable9);
            TextView textView = this.f9878n;
            Drawables.m37723a(textView, 0, Integer.valueOf(getColorFromResource(textView, R.color.white)), 0, num2, 0.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f, num56, num79, num88, 0, 0, f19, f5, 0.0f, num3, num28, num47, num57, num58, num69, num72, f27, num80, f30, 0, num4, 0, num5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num37, num48, 0, 0, f8, f20, 0.0f, num63, num67, num70, num71, num73, num76, num81, f25, num85, f29, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num9, num20, num21, 0, 0, f12, f11, 0.0f, num25, num30, num31, num33, num34, num38, num41, f16, num44, f18, 0, num51, 0, num52, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num64, num66, num68, 0, 0, f23, f24, 0.0f, num74, num75, num77, num78, num82, num83, num84, f26, num86, f28, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num7, num8, 0, 0, f3, f4, 0.0f, num10, num12, num14, num16, num17, num18, num19, f9, num22, f10, 0, num23, 0, num24, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num26, num27, num32, 0, 0, f13, f14, 0.0f, num35, num36, num39, num40, num42, num43, num45, f17, num46, f15, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num53, num54, num55, 0, 0, f22, f21, 0.0f, num59, num60, num61, num62, num15, num65, num13, f6, num11, f7, drawable5, drawable7, drawable4, drawable8, drawable3, drawable6, drawable2);
            ViewAdapter.m12794a((View) this.f9880p, "/travel/todayProfitLogs");
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f9872h, str2);
            TextViewBindingAdapter.setText(this.f9873i, str7);
            CustomAdapter.m12777a(this.f9875k, Float.valueOf(f));
            TextViewBindingAdapter.setText(this.f9876l, str5);
            TextViewBindingAdapter.setText(this.f9879o, charSequence);
            TextViewBindingAdapter.setText(this.f9881q, str);
            TextViewBindingAdapter.setText(this.f9882r, str4);
            TextViewBindingAdapter.setText(this.f9883s, str6);
            ViewAdapter.m12794a((View) this.f9866b, str3);
        }
    }
}
