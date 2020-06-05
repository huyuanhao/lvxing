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
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.module.group.data.NextCity;
import com.jiayouya.travel.module.group.data.NowCity;
import com.jiayouya.travel.module.group.data.TravelCity;
import com.jiayouya.travel.module.group.data.TravelCityKt;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.jiayouya.travel.module.p276me.data.DogProgressRspKt;
import com.jiayouya.travel.module.p276me.widget.MapView;
import ezy.p653ui.widget.round.RoundText;
import tech.linjiang.android.drawable.Drawables;

public class ActivityMapBindingImpl extends ActivityMapBinding {
    /* renamed from: k */
    private static final IncludedLayouts f10064k = null;
    /* renamed from: l */
    private static final SparseIntArray f10065l = new SparseIntArray();
    /* renamed from: m */
    private final FrameLayout f10066m;
    /* renamed from: n */
    private final FrameLayout f10067n;
    /* renamed from: o */
    private final TextView f10068o;
    /* renamed from: p */
    private final RndCornerProgressBar f10069p;
    /* renamed from: q */
    private final TextView f10070q;
    /* renamed from: r */
    private final TextView f10071r;
    /* renamed from: s */
    private final TextView f10072s;
    /* renamed from: t */
    private final RoundText f10073t;
    /* renamed from: u */
    private long f10074u;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10065l.put(R.id.map_view, 9);
        f10065l.put(R.id.status_view, 10);
        f10065l.put(R.id.iv_back, 11);
        f10065l.put(R.id.list, 12);
        f10065l.put(R.id.tv_start, 13);
        f10065l.put(R.id.lyt_progress, 14);
        f10065l.put(R.id.tv_progress, 15);
    }

    public ActivityMapBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, f10064k, f10065l));
    }

    private ActivityMapBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[11], (RecyclerView) objArr[12], (FrameLayout) objArr[14], (MapView) objArr[9], (RndCornerProgressBar) objArr[5], (FrameLayout) objArr[10], (LinearLayout) objArr[15], (TextView) objArr[13]);
        this.f10074u = -1;
        this.f10066m = objArr[0];
        this.f10066m.setTag(null);
        this.f10067n = objArr[1];
        this.f10067n.setTag(null);
        this.f10068o = objArr[2];
        this.f10068o.setTag(null);
        this.f10069p = objArr[3];
        this.f10069p.setTag(null);
        this.f10070q = objArr[4];
        this.f10070q.setTag(null);
        this.f10071r = objArr[6];
        this.f10071r.setTag(null);
        this.f10072s = objArr[7];
        this.f10072s.setTag(null);
        this.f10073t = objArr[8];
        this.f10073t.setTag(null);
        this.f10058e.setTag(null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10074u = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10074u != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20090a((TravelCity) obj);
        } else if (31 != i) {
            return false;
        } else {
            mo20091a((DogProgressRsp) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20090a(TravelCity travelCity) {
        this.f10062i = travelCity;
        synchronized (this) {
            this.f10074u |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20091a(DogProgressRsp dogProgressRsp) {
        this.f10063j = dogProgressRsp;
        synchronized (this) {
            this.f10074u |= 2;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        float f;
        boolean z;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String str;
        NextCity nextCity;
        NowCity nowCity;
        CharSequence charSequence4;
        String str2;
        synchronized (this) {
            j = this.f10074u;
            this.f10074u = 0;
        }
        TravelCity travelCity = this.f10062i;
        DogProgressRsp dogProgressRsp = this.f10063j;
        float f2 = 0.0f;
        boolean z2 = false;
        int i = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i != 0) {
            if (travelCity != null) {
                nowCity = travelCity.getNowCity();
                nextCity = travelCity.getNextCity();
            } else {
                nowCity = null;
                nextCity = null;
            }
            z = travelCity == null;
            if (i != 0) {
                j = z ? j | 64 : j | 32;
            }
            charSequence3 = nowCity != null ? nowCity.getName() : null;
            if (nextCity != null) {
                String distance = nextCity.getDistance();
                f = nextCity.getPercent();
                String str3 = distance;
                charSequence4 = nextCity.getName();
                str2 = str3;
            } else {
                str2 = null;
                charSequence4 = null;
                f = 0.0f;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("km");
            charSequence2 = sb.toString();
            charSequence = charSequence4;
        } else {
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
            z = false;
            f = 0.0f;
        }
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (dogProgressRsp != null) {
                f2 = dogProgressRsp.getPercent();
            }
            if (dogProgressRsp != null) {
                z2 = true;
            }
            if (i2 != 0) {
                j = z2 ? j | 16 : j | 8;
            }
        }
        String progress = (j & 16) != 0 ? DogProgressRspKt.progress(dogProgressRsp) : null;
        if ((32 & j) != 0) {
            str = TravelCityKt.progressText(travelCity);
        } else {
            str = null;
        }
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i3 == 0) {
            progress = null;
        } else if (!z2) {
            progress = "--%";
        }
        int i4 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i4 == 0) {
            str = null;
        } else if (z) {
            str = "";
        }
        if ((j & 4) != 0) {
            FrameLayout frameLayout = this.f10067n;
            FrameLayout frameLayout2 = frameLayout;
            Integer valueOf = Integer.valueOf(getColorFromResource(frameLayout, R.color.white));
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
            Float f3 = null;
            Float f4 = f3;
            Float f5 = f3;
            Float f6 = f3;
            Float f7 = f3;
            Float f8 = f3;
            Float f9 = f3;
            Float f10 = f3;
            Float f11 = f3;
            Float f12 = f3;
            Float f13 = f3;
            Float f14 = f3;
            Float f15 = f3;
            Float f16 = f3;
            Float f17 = f3;
            Float f18 = f3;
            Float f19 = f3;
            Float f20 = f3;
            Float f21 = f3;
            Float f22 = f3;
            Float f23 = f3;
            Float f24 = f3;
            Float f25 = f3;
            Float f26 = f3;
            Float f27 = f3;
            Float f28 = f3;
            Float f29 = f3;
            Float f30 = f3;
            Float f31 = f3;
            Drawable drawable = null;
            Drawables.m37723a(frameLayout2, 0, valueOf, 0, num27, 0.0f, 0.0f, 22.0f, 0.0f, 0.0f, 0.0f, 0.0f, num57, num79, num88, 0, 0, f10, f15, 0.0f, num28, num47, num52, num58, num63, num69, num72, f26, num80, f31, 0, num2, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num37, num44, num48, 0, 0, f14, f23, 0.0f, num64, num67, num70, num71, num73, num76, num81, f27, num85, f30, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num14, num19, num20, 0, 0, f12, f13, 0.0f, num24, num29, num30, num32, num33, num38, num41, f19, num46, f21, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num66, num68, 0, 0, f24, f25, 0.0f, num74, num75, num77, num78, num82, num83, num84, f28, num86, f29, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num3, num4, num5, 0, 0, f4, f5, 0.0f, num8, num12, num13, num15, num16, num17, num18, f9, num21, f11, 0, num22, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num25, num26, num31, 0, 0, f16, f17, 0.0f, num34, num35, num39, num40, num42, num43, num45, f18, num36, f20, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f22, f8, 0.0f, num59, num60, num61, num62, num11, num10, num9, f6, num7, f7, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.f10068o, progress);
            CustomAdapter.m12777a(this.f10069p, Float.valueOf(f2));
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.f10070q, charSequence2);
            TextViewBindingAdapter.setText(this.f10071r, charSequence3);
            TextViewBindingAdapter.setText(this.f10072s, charSequence);
            TextViewBindingAdapter.setText(this.f10073t, str);
            CustomAdapter.m12777a(this.f10058e, Float.valueOf(f));
        }
    }
}
