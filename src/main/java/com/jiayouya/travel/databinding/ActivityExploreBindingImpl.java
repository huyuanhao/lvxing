package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.explore.data.ExploreIndex;
import com.jiayouya.travel.module.explore.data.ExploreIndexKt;
import java.util.List;
import tech.linjiang.android.drawable.Drawables;

public class ActivityExploreBindingImpl extends ActivityExploreBinding {
    /* renamed from: s */
    private static final IncludedLayouts f9994s = null;
    /* renamed from: t */
    private static final SparseIntArray f9995t = new SparseIntArray();
    /* renamed from: A */
    private final TextView f9996A;
    /* renamed from: B */
    private final FrameLayout f9997B;
    /* renamed from: C */
    private final TextView f9998C;
    /* renamed from: D */
    private long f9999D;
    /* renamed from: u */
    private final FrameLayout f10000u;
    /* renamed from: v */
    private final LinearLayout f10001v;
    /* renamed from: w */
    private final LinearLayout f10002w;
    /* renamed from: x */
    private final TextView f10003x;
    /* renamed from: y */
    private final LinearLayout f10004y;
    /* renamed from: z */
    private final TextView f10005z;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9995t.put(R.id.scroll_view, 12);
        f9995t.put(R.id.far_scroll_view, 13);
        f9995t.put(R.id.bg_far, 14);
        f9995t.put(R.id.middle_scroll_view, 15);
        f9995t.put(R.id.bg_middle, 16);
        f9995t.put(R.id.near_scroll_view, 17);
        f9995t.put(R.id.bg_near, 18);
        f9995t.put(R.id.lyt_shake, 19);
        f9995t.put(R.id.dynamic_list, 20);
        f9995t.put(R.id.tv_harvest, 21);
        f9995t.put(R.id.harvest_list, 22);
        f9995t.put(R.id.team_list, 23);
        f9995t.put(R.id.btn_play, 24);
        f9995t.put(R.id.toolbar, 25);
    }

    public ActivityExploreBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, f9994s, f9995t));
    }

    private ActivityExploreBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[14], objArr[16], objArr[18], objArr[24], objArr[6], objArr[11], objArr[20], objArr[13], objArr[22], objArr[19], objArr[15], objArr[17], objArr[12], objArr[23], objArr[25], objArr[21], objArr[2]);
        this.f9999D = -1;
        this.f9980e.setTag(null);
        this.f9981f.setTag(null);
        this.f10000u = objArr[0];
        this.f10000u.setTag(null);
        this.f10001v = objArr[1];
        this.f10001v.setTag(null);
        this.f10002w = objArr[10];
        this.f10002w.setTag(null);
        this.f10003x = objArr[3];
        this.f10003x.setTag(null);
        this.f10004y = objArr[4];
        this.f10004y.setTag(null);
        this.f10005z = objArr[5];
        this.f10005z.setTag(null);
        this.f9996A = objArr[7];
        this.f9996A.setTag(null);
        this.f9997B = objArr[8];
        this.f9997B.setTag(null);
        this.f9998C = objArr[9];
        this.f9998C.setTag(null);
        this.f9992q.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9999D = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9999D != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20086a((ExploreIndex) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20086a(ExploreIndex exploreIndex) {
        this.f9993r = exploreIndex;
        synchronized (this) {
            this.f9999D |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        long j2;
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        String str2;
        String str3;
        String str4;
        long j3;
        List list;
        int i;
        synchronized (this) {
            j = this.f9999D;
            this.f9999D = 0;
        }
        ExploreIndex exploreIndex = this.f9993r;
        boolean z5 = false;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (exploreIndex != null) {
                j3 = exploreIndex.getSeconds();
                String energy = exploreIndex.getEnergy();
                int status = exploreIndex.getStatus();
                List dynamic = exploreIndex.getDynamic();
                str3 = exploreIndex.getH5Url();
                str4 = energy;
                i = status;
                list = dynamic;
            } else {
                j3 = 0;
                i = 0;
                list = null;
                str4 = null;
                str3 = null;
            }
            boolean z6 = exploreIndex == null;
            if (i2 != 0) {
                j = z6 ? j | 8 | 32 : j | 4 | 16;
            }
            z = j3 > 0;
            long j4 = j3 * 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("总体力值：");
            sb.append(str4);
            str = sb.toString();
            boolean z7 = i == 1;
            z2 = list == null;
            if (list != null) {
                z5 = true;
            }
            z4 = z5;
            z5 = z6;
            long j5 = j4;
            z3 = z7;
            str2 = str3;
            j2 = j5;
        } else {
            j2 = 0;
            str2 = null;
            z4 = false;
            z3 = false;
            z2 = false;
            str = null;
            z = false;
        }
        String playText = (j & 16) != 0 ? ExploreIndexKt.playText(exploreIndex) : null;
        Drawable playImage = (4 & j) != 0 ? ExploreIndexKt.playImage(exploreIndex) : null;
        int i3 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (z5) {
                playImage = ExploreIndexKt.defaultPlayImage();
            }
            if (z5) {
                playText = "";
            }
        } else {
            playImage = null;
            playText = null;
        }
        if (i3 != 0) {
            ViewAdapter.m12798c((View) this.f9980e, Boolean.valueOf(z3));
            CustomAdapter.m12778a(this.f9981f, Long.valueOf(j2), Boolean.valueOf(z), 1);
            ViewAdapter.m12798c((View) this.f10003x, Boolean.valueOf(z4));
            ViewAdapter.m12798c((View) this.f10004y, Boolean.valueOf(z2));
            TextViewBindingAdapter.setText(this.f9996A, str);
            TextViewBindingAdapter.setDrawableStart(this.f9998C, playImage);
            TextViewBindingAdapter.setText(this.f9998C, playText);
            ViewAdapter.m12794a((View) this.f9992q, str2);
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
            Integer num272 = num;
            Integer num273 = num;
            Integer num274 = num;
            Integer num275 = num;
            Integer num276 = num;
            Integer num277 = num;
            Integer num278 = num;
            Integer num279 = num;
            Integer num280 = num;
            Integer num281 = num;
            Integer num282 = num;
            Integer num283 = num;
            Integer num284 = num;
            Integer num285 = num;
            Integer num286 = num;
            Integer num287 = num;
            Integer num288 = num;
            Integer num289 = num;
            Integer num290 = num;
            Integer num291 = num;
            Integer num292 = num;
            Integer num293 = num;
            Integer num294 = num;
            Integer num295 = num;
            Integer num296 = num;
            Integer num297 = num;
            Integer num298 = num;
            Integer num299 = num;
            Integer num300 = num;
            Integer num301 = num;
            Integer num302 = num;
            Integer num303 = num;
            Integer num304 = num;
            Integer num305 = num;
            Integer num306 = num;
            Integer num307 = num;
            Integer num308 = num;
            Integer num309 = num;
            Integer num310 = num;
            Integer num311 = num;
            Integer num312 = num;
            Integer num313 = num;
            Integer num314 = num;
            Integer num315 = num;
            Integer num316 = num;
            Integer num317 = num;
            Integer num318 = num;
            Integer num319 = num;
            Integer num320 = num;
            Integer num321 = num;
            Integer num322 = num;
            Integer num323 = num;
            Integer num324 = num;
            Integer num325 = num;
            Integer num326 = num;
            Integer num327 = num;
            Integer num328 = num;
            Integer num329 = num;
            Integer num330 = num;
            Integer num331 = num;
            Integer num332 = num;
            Integer num333 = num;
            Integer num334 = num;
            Integer num335 = num;
            Integer num336 = num;
            Integer num337 = num;
            Integer num338 = num;
            Integer num339 = num;
            Integer num340 = num;
            Integer num341 = num;
            Integer num342 = num;
            Integer num343 = num;
            Integer num344 = num;
            Integer num345 = num;
            Integer num346 = num;
            Integer num347 = num;
            Integer num348 = num;
            Integer num349 = num;
            Integer num350 = num;
            Integer num351 = num;
            Integer num352 = num;
            Integer num353 = num;
            Integer num354 = num;
            Integer num355 = num;
            Integer num356 = num;
            Integer num357 = num;
            Integer num358 = num;
            Integer num359 = num;
            Integer num360 = num;
            Integer num361 = num;
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
            Drawable drawable19 = drawable;
            Drawable drawable20 = drawable;
            Drawable drawable21 = drawable;
            Drawable drawable22 = drawable;
            Drawables.m37723a(this.f10001v, 0, Integer.valueOf(-394759), 0, num297, 0.0f, 0.0f, 0.0f, 15.0f, 0.0f, 15.0f, 0.0f, num327, num349, num358, 0, 0, f, f, 0.0f, num298, num317, num322, num328, num333, num339, num342, f, num350, f, 0, num272, 0, num276, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num307, num314, num318, 0, 0, f, f, 0.0f, num334, num337, num340, num341, num343, num346, num351, f, num355, f, 0, num359, 0, num361, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num284, num289, num290, 0, 0, f, f, 0.0f, num294, num299, num300, num302, num303, num308, num311, f, num316, f, 0, num321, 0, num323, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num335, num336, num338, 0, 0, f, f, 0.0f, num344, num345, num347, num348, num352, num353, num354, f, num356, f, 0, num357, 0, num360, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num273, num274, num275, 0, 0, f, f, 0.0f, num278, num282, num283, num285, num286, num287, num288, f, num291, f, 0, num292, 0, num293, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num295, num296, num301, 0, 0, f, f, 0.0f, num304, num305, num309, num310, num312, num313, num315, f, num306, f, 0, num319, 0, num320, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num324, num325, num326, 0, 0, f, f, 0.0f, num329, num330, num331, num332, num281, num280, num279, f, num277, f, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
            Drawables.m37723a(this.f10002w, 0, Integer.valueOf(2014581779), 0, num182, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, num236, num259, num268, 0, 0, f74, f60, 0.0f, num183, num208, num227, num237, num238, num249, num252, f82, num260, f85, 0, num184, 0, num185, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num209, num217, num228, 0, 0, f63, f75, 0.0f, num243, num247, num250, num251, num253, num256, num261, f80, num265, f84, 0, num269, 0, num271, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num189, num200, num201, 0, 0, f67, f66, 0.0f, num205, num210, num211, num213, num214, num218, num221, f71, num224, f73, 0, num231, 0, num232, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num244, num246, num248, 0, 0, f78, f79, 0.0f, num254, num255, num257, num258, num262, num263, num264, f81, num266, f83, 0, num267, 0, num270, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num186, num187, num188, 0, 0, f58, f59, 0.0f, num190, num192, num194, num196, num197, num198, num199, f64, num202, f65, 0, num203, 0, num204, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num206, num207, num212, 0, 0, f68, f69, 0.0f, num215, num216, num219, num220, num222, num223, num225, f72, num226, f70, 0, num229, 0, num230, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num233, num234, num235, 0, 0, f77, f76, 0.0f, num239, num240, num241, num242, num195, num245, num193, f61, num191, f62, drawable19, drawable21, drawable18, drawable22, drawable17, drawable20, drawable16);
            ViewAdapter.m12794a((View) this.f10005z, "/explore/dynamic");
            TextView textView = this.f9996A;
            Drawables.m37723a(textView, 0, Integer.valueOf(getColorFromResource(textView, R.color.grey_f4)), 0, num92, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, num146, num169, num178, 0, 0, f46, f32, 0.0f, num93, num118, num137, num147, num148, num159, num162, f54, num170, f57, 0, num94, 0, num95, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num119, num127, num138, 0, 0, f35, f47, 0.0f, num153, num157, num160, num161, num163, num166, num171, f52, num175, f56, 0, num179, 0, num181, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num99, num110, num111, 0, 0, f39, f38, 0.0f, num115, num120, num121, num123, num124, num128, num131, f43, num134, f45, 0, num141, 0, num142, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num154, num156, num158, 0, 0, f50, f51, 0.0f, num164, num165, num167, num168, num172, num173, num174, f53, num176, f55, 0, num177, 0, num180, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num96, num97, num98, 0, 0, f30, f31, 0.0f, num100, num102, num104, num106, num107, num108, num109, f36, num112, f37, 0, num113, 0, num114, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num116, num117, num122, 0, 0, f40, f41, 0.0f, num125, num126, num129, num130, num132, num133, num135, f44, num136, f42, 0, num139, 0, num140, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num143, num144, num145, 0, 0, f49, f48, 0.0f, num149, num150, num151, num152, num105, num155, num103, f33, num101, f34, drawable12, drawable14, drawable11, drawable15, drawable10, drawable13, drawable9);
            Drawables.m37723a(this.f9997B, 0, Integer.valueOf(-394759), 0, num2, 0.0f, 0.0f, 0.0f, 32.0f, 0.0f, 32.0f, 0.0f, num56, num79, num88, 0, 0, f18, f4, 0.0f, num3, num28, num47, num57, num58, num69, num72, f26, num80, f29, 0, num4, 0, num5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num37, num48, 0, 0, f7, f19, 0.0f, num63, num67, num70, num71, num73, num76, num81, f24, num85, f28, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num9, num20, num21, 0, 0, f11, f10, 0.0f, num25, num30, num31, num33, num34, num38, num41, f15, num44, f17, 0, num51, 0, num52, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num64, num66, num68, 0, 0, f22, f23, 0.0f, num74, num75, num77, num78, num82, num83, num84, f25, num86, f27, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num7, num8, 0, 0, f2, f3, 0.0f, num10, num12, num14, num16, num17, num18, num19, f8, num22, f9, 0, num23, 0, num24, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num26, num27, num32, 0, 0, f12, f13, 0.0f, num35, num36, num39, num40, num42, num43, num45, f16, num46, f14, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num53, num54, num55, 0, 0, f21, f20, 0.0f, num59, num60, num61, num62, num15, num65, num13, f5, num11, f6, drawable5, drawable7, drawable4, drawable8, drawable3, drawable6, drawable2);
        }
    }
}
