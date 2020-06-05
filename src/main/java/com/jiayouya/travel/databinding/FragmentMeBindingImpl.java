package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.jiayouya.travel.module.p276me.data.DogProgressRspKt;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import tech.linjiang.android.drawable.Drawables;

public class FragmentMeBindingImpl extends FragmentMeBinding {
    /* renamed from: i */
    private static final IncludedLayouts f10759i = null;
    /* renamed from: j */
    private static final SparseIntArray f10760j = new SparseIntArray();
    /* renamed from: k */
    private final FrameLayout f10761k;
    /* renamed from: l */
    private final RelativeLayout f10762l;
    /* renamed from: m */
    private final TextView f10763m;
    /* renamed from: n */
    private final CircleImageView f10764n;
    /* renamed from: o */
    private final TextView f10765o;
    /* renamed from: p */
    private long f10766p;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10760j.put(R.id.refresh, 7);
        f10760j.put(R.id.status_view, 8);
        f10760j.put(R.id.lyt_progress, 9);
        f10760j.put(R.id.list, 10);
    }

    public FragmentMeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, f10759i, f10760j));
    }

    private FragmentMeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[10], (FrameLayout) objArr[9], (RndCornerProgressBar) objArr[6], (SmartRefreshLayout) objArr[7], (View) objArr[8], (TextView) objArr[2]);
        this.f10766p = -1;
        this.f10761k = objArr[0];
        this.f10761k.setTag(null);
        this.f10762l = objArr[1];
        this.f10762l.setTag(null);
        this.f10763m = objArr[3];
        this.f10763m.setTag(null);
        this.f10764n = objArr[4];
        this.f10764n.setTag(null);
        this.f10765o = objArr[5];
        this.f10765o.setTag(null);
        this.f10753c.setTag(null);
        this.f10756f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10766p = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10766p != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (31 == i) {
            mo20152a((DogProgressRsp) obj);
        } else if (33 != i) {
            return false;
        } else {
            mo20151a((User) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20152a(DogProgressRsp dogProgressRsp) {
        this.f10758h = dogProgressRsp;
        synchronized (this) {
            this.f10766p |= 1;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20151a(User user) {
        this.f10757g = user;
        synchronized (this) {
            this.f10766p |= 2;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        CharSequence charSequence;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j = this.f10766p;
            this.f10766p = 0;
        }
        DogProgressRsp dogProgressRsp = this.f10758h;
        float f = 0.0f;
        User user = this.f10757g;
        int i = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i != 0) {
            if (dogProgressRsp != null) {
                f = dogProgressRsp.getPercent();
            }
            z = dogProgressRsp != null;
            if (i != 0) {
                j = z ? j | 16 : j | 8;
            }
        } else {
            z = false;
        }
        int i2 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (user != null) {
                str = user.getAvatar();
                str4 = user.getNickname();
                str5 = user.getUid();
            } else {
                str5 = null;
                str = null;
                str4 = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ID:");
            sb.append(str5);
            str2 = sb.toString();
            charSequence = str4;
        } else {
            charSequence = null;
            str2 = null;
            str = null;
        }
        if ((16 & j) != 0) {
            str3 = DogProgressRspKt.progress(dogProgressRsp);
        } else {
            str3 = null;
        }
        int i3 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i3 == 0) {
            str3 = null;
        } else if (!z) {
            str3 = "";
        }
        if ((j & 4) != 0) {
            RelativeLayout relativeLayout = this.f10762l;
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
            Drawable drawable = null;
            Drawable drawable2 = drawable;
            Drawable drawable3 = drawable;
            Drawable drawable4 = drawable;
            Drawable drawable5 = drawable;
            Drawable drawable6 = drawable;
            Drawable drawable7 = drawable;
            Drawable drawable8 = drawable;
            Drawables.m37723a(relativeLayout, 0, num133, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Integer.valueOf(getColorFromResource(relativeLayout, R.color.green_start)), num155, Integer.valueOf(getColorFromResource(this.f10762l, R.color.green_end)), 6, 0, f38, f41, 0.0f, num104, num123, num128, num134, num135, num145, num148, f53, num156, f58, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num112, num120, num124, 0, 0, f35, f50, 0.0f, num140, num143, num146, num147, num149, num152, num157, f54, num161, f57, 0, num164, 0, num166, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num96, num97, 0, 0, f39, f40, 0.0f, num101, num105, num106, num108, num109, num113, num117, f47, num122, f45, 0, num127, 0, num129, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num141, num142, num144, 0, 0, f51, f52, 0.0f, num150, num151, num153, num154, num158, num159, num160, f55, num162, f56, 0, num163, 0, num165, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f31, f32, 0.0f, num, num, num, num92, num93, num94, num95, f37, num98, f48, 0, num99, 0, num100, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num102, num103, num107, 0, 0, f42, f43, 0.0f, num110, num111, num114, num116, num118, num119, num121, f46, num115, f44, 0, num125, 0, num126, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num130, num131, num132, 0, 0, f49, f36, 0.0f, num136, num137, num138, num139, num, num, num, f33, num, f34, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
            ViewAdapter.m12794a((View) this.f10764n, "/me/setting");
            Drawables.m37723a(this.f10753c, 0, Integer.valueOf(getColorFromResource(this.f10753c, R.color.white)), 0, num2, 0.0f, 0.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f, num56, num79, num88, 0, 0, f19, f5, 0.0f, num3, num28, num47, num57, num58, num69, num72, f27, num80, f30, 0, num4, 0, num5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num37, num48, 0, 0, f8, f20, 0.0f, num63, num67, num70, num71, num73, num76, num81, f25, num85, f29, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num9, num20, num21, 0, 0, f12, f11, 0.0f, num25, num30, num31, num33, num34, num38, num41, f16, num44, f18, 0, num51, 0, num52, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num64, num66, num68, 0, 0, f23, f24, 0.0f, num74, num75, num77, num78, num82, num83, num84, f26, num86, f28, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num7, num8, 0, 0, f3, f4, 0.0f, num10, num12, num14, num16, num17, num18, num19, f9, num22, f10, 0, num23, 0, num24, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num26, num27, num32, 0, 0, f13, f14, 0.0f, num35, num36, num39, num40, num42, num43, num45, f17, num46, f15, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num53, num54, num55, 0, 0, f22, f21, 0.0f, num59, num60, num61, num62, num15, num65, num13, f6, num11, f7, drawable5, drawable7, drawable4, drawable8, drawable3, drawable6, drawable2);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f10763m, str2);
            ImageAdapter.m12783a((ImageView) this.f10764n, str, 0, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f10756f, charSequence);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.f10765o, str3);
            CustomAdapter.m12777a(this.f10753c, Float.valueOf(f));
        }
    }
}
