package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.module.p276me.data.AnalysisItem;
import com.jiayouya.travel.module.p276me.data.DogAnalysisRsp;
import com.jiayouya.travel.module.p276me.widget.ScoreView;
import tech.linjiang.android.drawable.Drawables;

public class ActivityBonusDogBindingImpl extends ActivityBonusDogBinding {
    /* renamed from: m */
    private static final IncludedLayouts f9897m = null;
    /* renamed from: n */
    private static final SparseIntArray f9898n = new SparseIntArray();
    /* renamed from: o */
    private final LinearLayout f9899o;
    /* renamed from: p */
    private final ImageView f9900p;
    /* renamed from: q */
    private final ImageView f9901q;
    /* renamed from: r */
    private final ImageView f9902r;
    /* renamed from: s */
    private final ImageView f9903s;
    /* renamed from: t */
    private final ImageView f9904t;
    /* renamed from: u */
    private final LinearLayout f9905u;
    /* renamed from: v */
    private final TextView f9906v;
    /* renamed from: w */
    private final RndCornerProgressBar f9907w;
    /* renamed from: x */
    private final ImageView f9908x;
    /* renamed from: y */
    private long f9909y;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9898n.put(R.id.scroll_view, 10);
        f9898n.put(R.id.iv_bg, 11);
        f9898n.put(R.id.lyt_radar, 12);
        f9898n.put(R.id.tv_video_title, 13);
        f9898n.put(R.id.tv_merge_title, 14);
        f9898n.put(R.id.tv_friend_title, 15);
        f9898n.put(R.id.tv_profit_title, 16);
        f9898n.put(R.id.tv_city_title, 17);
        f9898n.put(R.id.tv_my_dog, 18);
        f9898n.put(R.id.iv_invite, 19);
        f9898n.put(R.id.iv_promote_active, 20);
    }

    public ActivityBonusDogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, f9897m, f9898n));
    }

    private ActivityBonusDogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[11], (ImageView) objArr[19], (ImageView) objArr[20], (ScoreView) objArr[12], (ScrollView) objArr[10], (TextView) objArr[17], (TextView) objArr[15], (TextView) objArr[14], (TextView) objArr[18], (TextView) objArr[16], (TextView) objArr[13]);
        this.f9909y = -1;
        this.f9899o = objArr[0];
        this.f9899o.setTag(null);
        this.f9900p = objArr[1];
        this.f9900p.setTag(null);
        this.f9901q = objArr[2];
        this.f9901q.setTag(null);
        this.f9902r = objArr[3];
        this.f9902r.setTag(null);
        this.f9903s = objArr[4];
        this.f9903s.setTag(null);
        this.f9904t = objArr[5];
        this.f9904t.setTag(null);
        this.f9905u = objArr[6];
        this.f9905u.setTag(null);
        this.f9906v = objArr[7];
        this.f9906v.setTag(null);
        this.f9907w = objArr[8];
        this.f9907w.setTag(null);
        this.f9908x = objArr[9];
        this.f9908x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9909y = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9909y != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20079a((DogAnalysisRsp) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20079a(DogAnalysisRsp dogAnalysisRsp) {
        this.f9896l = dogAnalysisRsp;
        synchronized (this) {
            this.f9909y |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        CharSequence charSequence;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        AnalysisItem analysisItem;
        AnalysisItem analysisItem2;
        AnalysisItem analysisItem3;
        AnalysisItem analysisItem4;
        AnalysisItem analysisItem5;
        int i;
        synchronized (this) {
            j = this.f9909y;
            this.f9909y = 0;
        }
        float f = 0.0f;
        DogAnalysisRsp dogAnalysisRsp = this.f9896l;
        boolean z10 = false;
        int i2 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (dogAnalysisRsp != null) {
                f = dogAnalysisRsp.getPercent();
                analysisItem4 = dogAnalysisRsp.getAdFee();
                analysisItem3 = dogAnalysisRsp.getInvite();
                analysisItem2 = dogAnalysisRsp.getCity();
                analysisItem = dogAnalysisRsp.getMerge();
                analysisItem5 = dogAnalysisRsp.getAdVideo();
            } else {
                analysisItem5 = null;
                analysisItem4 = null;
                analysisItem3 = null;
                analysisItem2 = null;
                analysisItem = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(f);
            sb.append("%");
            charSequence = sb.toString();
            int status = analysisItem4 != null ? analysisItem4.getStatus() : 0;
            int status2 = analysisItem3 != null ? analysisItem3.getStatus() : 0;
            int status3 = analysisItem2 != null ? analysisItem2.getStatus() : 0;
            int status4 = analysisItem != null ? analysisItem.getStatus() : 0;
            if (analysisItem5 != null) {
                i = analysisItem5.getStatus();
            } else {
                i = 0;
            }
            z5 = status == 1;
            z9 = status == 0;
            z4 = status2 == 1;
            z8 = status2 == 0;
            z3 = status3 == 0;
            z7 = status3 == 1;
            z2 = status4 == 1;
            z6 = status4 == 0;
            z = i == 0;
            if (i == 1) {
                z10 = true;
            }
        } else {
            charSequence = null;
            z9 = false;
            z8 = false;
            z7 = false;
            z6 = false;
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        if (i2 != 0) {
            ViewAdapter.m12798c((View) this.f9900p, Boolean.valueOf(z));
            ViewAdapter.m12796b((View) this.f9900p, Boolean.valueOf(z10));
            ViewAdapter.m12798c((View) this.f9901q, Boolean.valueOf(z6));
            ViewAdapter.m12796b((View) this.f9901q, Boolean.valueOf(z2));
            ViewAdapter.m12798c((View) this.f9902r, Boolean.valueOf(z8));
            ViewAdapter.m12796b((View) this.f9902r, Boolean.valueOf(z4));
            ViewAdapter.m12798c((View) this.f9903s, Boolean.valueOf(z9));
            ViewAdapter.m12796b((View) this.f9903s, Boolean.valueOf(z5));
            ViewAdapter.m12798c((View) this.f9904t, Boolean.valueOf(z3));
            ViewAdapter.m12796b((View) this.f9904t, Boolean.valueOf(z7));
            TextViewBindingAdapter.setText(this.f9906v, charSequence);
            CustomAdapter.m12777a(this.f9907w, Float.valueOf(f));
        }
        if ((j & 2) != 0) {
            LinearLayout linearLayout = this.f9905u;
            LinearLayout linearLayout2 = linearLayout;
            Integer valueOf = Integer.valueOf(getColorFromResource(linearLayout, R.color.white));
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
            Drawable drawable = null;
            Drawables.m37723a(linearLayout2, 0, valueOf, 0, num27, 0.0f, 0.0f, 0.0f, 20.0f, 0.0f, 20.0f, 0.0f, num57, num79, num88, 0, 0, f9, f14, 0.0f, num28, num47, num52, num58, num63, num69, num72, f25, num80, f30, 0, num2, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num37, num44, num48, 0, 0, f13, f22, 0.0f, num64, num67, num70, num71, num73, num76, num81, f26, num85, f29, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num14, num19, num20, 0, 0, f11, f12, 0.0f, num24, num29, num30, num32, num33, num38, num41, f18, num46, f20, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num66, num68, 0, 0, f23, f24, 0.0f, num74, num75, num77, num78, num82, num83, num84, f27, num86, f28, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num3, num4, num5, 0, 0, f3, f4, 0.0f, num8, num12, num13, num15, num16, num17, num18, f8, num21, f10, 0, num22, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num25, num26, num31, 0, 0, f15, f16, 0.0f, num34, num35, num39, num40, num42, num43, num45, f17, num36, f19, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f21, f7, 0.0f, num59, num60, num61, num62, num11, num10, num9, f5, num7, f6, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
            ViewAdapter.m12794a((View) this.f9908x, "/me/map");
        }
    }
}
