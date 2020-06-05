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
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.common.data.ShareItem;
import com.jiayouya.travel.module.common.data.ShareItemKt;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.travel.data.ShareInfo;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import tech.linjiang.android.drawable.Drawables;

public class ItemShareBindingImpl extends ItemShareBinding {
    /* renamed from: d */
    private static final IncludedLayouts f11166d = null;
    /* renamed from: e */
    private static final SparseIntArray f11167e = new SparseIntArray();
    /* renamed from: f */
    private final FrameLayout f11168f;
    /* renamed from: g */
    private final TextView f11169g;
    /* renamed from: h */
    private final LinearLayout f11170h;
    /* renamed from: i */
    private final CircleImageView f11171i;
    /* renamed from: j */
    private final TextView f11172j;
    /* renamed from: k */
    private final TextView f11173k;
    /* renamed from: l */
    private final ImageView f11174l;
    /* renamed from: m */
    private long f11175m;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f11167e.put(R.id.iv_qr_code, 8);
    }

    public ItemShareBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, f11166d, f11167e));
    }

    private ItemShareBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (ImageView) objArr[1]);
        this.f11175m = -1;
        this.f11168f = objArr[0];
        this.f11168f.setTag(null);
        this.f11169g = objArr[2];
        this.f11169g.setTag(null);
        this.f11170h = objArr[3];
        this.f11170h.setTag(null);
        this.f11171i = objArr[4];
        this.f11171i.setTag(null);
        this.f11172j = objArr[5];
        this.f11172j.setTag(null);
        this.f11173k = objArr[6];
        this.f11173k.setTag(null);
        this.f11174l = objArr[7];
        this.f11174l.setTag(null);
        this.f11164b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11175m = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11175m != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20203a((ShareItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20203a(ShareItem shareItem) {
        this.f11165c = shareItem;
        synchronized (this) {
            this.f11175m |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        CharSequence charSequence;
        CharSequence charSequence2;
        String str;
        CharSequence charSequence3;
        float f;
        boolean z2;
        ShareInfo shareInfo;
        int i2;
        User user;
        boolean z3;
        String str2;
        synchronized (this) {
            j = this.f11175m;
            this.f11175m = 0;
        }
        ShareItem shareItem = this.f11165c;
        float f2 = 0.0f;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            String title = ShareItemKt.title(shareItem);
            if (shareItem != null) {
                user = shareItem.getUser();
                i2 = shareItem.getResId();
                shareInfo = shareItem.getShareInfo();
                z = shareItem.isSelected();
                z2 = shareItem.isEnd();
                z3 = shareItem.isStart();
            } else {
                user = null;
                shareInfo = null;
                z3 = false;
                i2 = 0;
                z = false;
                z2 = false;
            }
            if (i3 != 0) {
                j |= z2 ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j |= z3 ? 8 : 4;
            }
            str = user != null ? user.getAvatar() : null;
            float f3 = 15.0f;
            float f4 = z2 ? 52.0f : 15.0f;
            if (z3) {
                f3 = 52.0f;
            }
            if (shareInfo != null) {
                str2 = shareInfo.getInviteCode();
                charSequence = shareInfo.getDesc();
            } else {
                str2 = null;
                charSequence = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("我的邀请码：");
            sb.append(str2);
            String sb2 = sb.toString();
            charSequence2 = title;
            i = i2;
            f2 = f3;
            charSequence3 = sb2;
            f = f4;
        } else {
            charSequence3 = null;
            str = null;
            charSequence2 = null;
            charSequence = null;
            f = 0.0f;
            i = 0;
            z = false;
        }
        if ((3 & j) != 0) {
            ViewAdapter.m12795b((View) this.f11168f, f2);
            ViewAdapter.m12797c((View) this.f11168f, f);
            TextViewBindingAdapter.setText(this.f11169g, charSequence3);
            CornerType cornerType = null;
            Integer num = null;
            ImageAdapter.m12783a((ImageView) this.f11171i, str, 0, cornerType, num);
            TextViewBindingAdapter.setText(this.f11172j, charSequence2);
            TextViewBindingAdapter.setText(this.f11173k, charSequence);
            ViewAdapter.m12796b((View) this.f11174l, Boolean.valueOf(z));
            ImageAdapter.m12781a(this.f11164b, Integer.valueOf(i), 10, cornerType, num);
        }
        if ((j & 2) != 0) {
            TextView textView = this.f11169g;
            TextView textView2 = textView;
            Integer valueOf = Integer.valueOf(getColorFromResource(textView, R.color.white));
            Integer num2 = null;
            Integer num3 = num2;
            Integer num4 = num2;
            Integer num5 = num2;
            Integer num6 = num2;
            Integer num7 = num2;
            Integer num8 = num2;
            Integer num9 = num2;
            Integer num10 = num2;
            Integer num11 = num2;
            Integer num12 = num2;
            Integer num13 = num2;
            Integer num14 = num2;
            Integer num15 = num2;
            Integer num16 = num2;
            Integer num17 = num2;
            Integer num18 = num2;
            Integer num19 = num2;
            Integer num20 = num2;
            Integer num21 = num2;
            Integer num22 = num2;
            Integer num23 = num2;
            Integer num24 = num2;
            Integer num25 = num2;
            Integer num26 = num2;
            Integer num27 = num2;
            Integer num28 = num2;
            Integer num29 = num2;
            Integer num30 = num2;
            Integer num31 = num2;
            Integer num32 = num2;
            Integer num33 = num2;
            Integer num34 = num2;
            Integer num35 = num2;
            Integer num36 = num2;
            Integer num37 = num2;
            Integer num38 = num2;
            Integer num39 = num2;
            Integer num40 = num2;
            Integer num41 = num2;
            Integer num42 = num2;
            Integer num43 = num2;
            Integer num44 = num2;
            Integer num45 = num2;
            Integer num46 = num2;
            Integer num47 = num2;
            Integer num48 = num2;
            Integer num49 = num2;
            Integer num50 = num2;
            Integer num51 = num2;
            Integer num52 = num2;
            Integer num53 = num2;
            Integer num54 = num2;
            Integer num55 = num2;
            Integer num56 = num2;
            Integer num57 = num2;
            Integer num58 = num2;
            Integer num59 = num2;
            Integer num60 = num2;
            Integer num61 = num2;
            Integer num62 = num2;
            Integer num63 = num2;
            Integer num64 = num2;
            Integer num65 = num2;
            Integer num66 = num2;
            Integer num67 = num2;
            Integer num68 = num2;
            Integer num69 = num2;
            Integer num70 = num2;
            Integer num71 = num2;
            Integer num72 = num2;
            Integer num73 = num2;
            Integer num74 = num2;
            Integer num75 = num2;
            Integer num76 = num2;
            Integer num77 = num2;
            Integer num78 = num2;
            Integer num79 = num2;
            Integer num80 = num2;
            Integer num81 = num2;
            Integer num82 = num2;
            Integer num83 = num2;
            Integer num84 = num2;
            Integer num85 = num2;
            Integer num86 = num2;
            Integer num87 = num2;
            Integer num88 = num2;
            Integer num89 = num2;
            Integer num90 = num2;
            Integer num91 = num2;
            Integer num92 = num2;
            Integer num93 = num2;
            Integer num94 = num2;
            Integer num95 = num2;
            Integer num96 = num2;
            Integer num97 = num2;
            Integer num98 = num2;
            Integer num99 = num2;
            Integer num100 = num2;
            Integer num101 = num2;
            Integer num102 = num2;
            Integer num103 = num2;
            Integer num104 = num2;
            Integer num105 = num2;
            Integer num106 = num2;
            Integer num107 = num2;
            Integer num108 = num2;
            Integer num109 = num2;
            Integer num110 = num2;
            Integer num111 = num2;
            Integer num112 = num2;
            Integer num113 = num2;
            Integer num114 = num2;
            Integer num115 = num2;
            Integer num116 = num2;
            Integer num117 = num2;
            Integer num118 = num2;
            Integer num119 = num2;
            Integer num120 = num2;
            Integer num121 = num2;
            Integer num122 = num2;
            Integer num123 = num2;
            Integer num124 = num2;
            Integer num125 = num2;
            Integer num126 = num2;
            Integer num127 = num2;
            Integer num128 = num2;
            Integer num129 = num2;
            Integer num130 = num2;
            Integer num131 = num2;
            Integer num132 = num2;
            Integer num133 = num2;
            Integer num134 = num2;
            Integer num135 = num2;
            Integer num136 = num2;
            Integer num137 = num2;
            Integer num138 = num2;
            Integer num139 = num2;
            Integer num140 = num2;
            Integer num141 = num2;
            Integer num142 = num2;
            Integer num143 = num2;
            Integer num144 = num2;
            Integer num145 = num2;
            Integer num146 = num2;
            Integer num147 = num2;
            Integer num148 = num2;
            Integer num149 = num2;
            Integer num150 = num2;
            Integer num151 = num2;
            Integer num152 = num2;
            Integer num153 = num2;
            Integer num154 = num2;
            Integer num155 = num2;
            Integer num156 = num2;
            Integer num157 = num2;
            Integer num158 = num2;
            Integer num159 = num2;
            Integer num160 = num2;
            Integer num161 = num2;
            Integer num162 = num2;
            Integer num163 = num2;
            Integer num164 = num2;
            Integer num165 = num2;
            Integer num166 = num2;
            Integer num167 = num2;
            Integer num168 = num2;
            Integer num169 = num2;
            Integer num170 = num2;
            Integer num171 = num2;
            Integer num172 = num2;
            Integer num173 = num2;
            Integer num174 = num2;
            Integer num175 = num2;
            Integer num176 = num2;
            Integer num177 = num2;
            Integer num178 = num2;
            Integer num179 = num2;
            Integer num180 = num2;
            Integer num181 = num2;
            Integer num182 = num2;
            Float f5 = null;
            Float f6 = f5;
            Float f7 = f5;
            Float f8 = f5;
            Float f9 = f5;
            Float f10 = f5;
            Float f11 = f5;
            Float f12 = f5;
            Float f13 = f5;
            Float f14 = f5;
            Float f15 = f5;
            Float f16 = f5;
            Float f17 = f5;
            Float f18 = f5;
            Float f19 = f5;
            Float f20 = f5;
            Float f21 = f5;
            Float f22 = f5;
            Float f23 = f5;
            Float f24 = f5;
            Float f25 = f5;
            Float f26 = f5;
            Float f27 = f5;
            Float f28 = f5;
            Float f29 = f5;
            Float f30 = f5;
            Float f31 = f5;
            Float f32 = f5;
            Float f33 = f5;
            Float f34 = f5;
            Float f35 = f5;
            Float f36 = f5;
            Float f37 = f5;
            Float f38 = f5;
            Float f39 = f5;
            Float f40 = f5;
            Float f41 = f5;
            Float f42 = f5;
            Float f43 = f5;
            Float f44 = f5;
            Float f45 = f5;
            Float f46 = f5;
            Float f47 = f5;
            Float f48 = f5;
            Float f49 = f5;
            Float f50 = f5;
            Float f51 = f5;
            Float f52 = f5;
            Float f53 = f5;
            Float f54 = f5;
            Float f55 = f5;
            Float f56 = f5;
            Float f57 = f5;
            Float f58 = f5;
            Float f59 = f5;
            Float f60 = f5;
            Float f61 = f5;
            Drawable drawable = null;
            Drawable drawable2 = drawable;
            Drawable drawable3 = drawable;
            Drawable drawable4 = drawable;
            Drawable drawable5 = drawable;
            Drawable drawable6 = drawable;
            Drawable drawable7 = drawable;
            Drawable drawable8 = drawable;
            Drawables.m37723a(textView2, 0, valueOf, 0, num118, 0.0f, 0.0f, 0.0f, 12.0f, 0.0f, 12.0f, 0.0f, num148, num170, num179, 0, 0, f40, f45, 0.0f, num119, num138, num143, num149, num154, num160, num163, f56, num171, f61, 0, num93, 0, num97, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num128, num135, num139, 0, 0, f44, f53, 0.0f, num155, num158, num161, num162, num164, num167, num172, f57, num176, f60, 0, num180, 0, num182, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num105, num110, num111, 0, 0, f42, f43, 0.0f, num115, num120, num121, num123, num124, num129, num132, f49, num137, f51, 0, num142, 0, num144, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num156, num157, num159, 0, 0, f54, f55, 0.0f, num165, num166, num168, num169, num173, num174, num175, f58, num177, f59, 0, num178, 0, num181, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num94, num95, num96, 0, 0, f34, f35, 0.0f, num99, num103, num104, num106, num107, num108, num109, f39, num112, f41, 0, num113, 0, num114, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num116, num117, num122, 0, 0, f46, f47, 0.0f, num125, num126, num130, num131, num133, num134, num136, f48, num127, f50, 0, num140, 0, num141, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num145, num146, num147, 0, 0, f52, f38, 0.0f, num150, num151, num152, num153, num102, num101, num100, f36, num98, f37, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
            LinearLayout linearLayout = this.f11170h;
            Drawables.m37723a(linearLayout, 0, Integer.valueOf(getColorFromResource(linearLayout, R.color.white)), 0, num3, 0.0f, 0.0f, 0.0f, 0.0f, 12.0f, 12.0f, 12.0f, num57, num80, num89, 0, 0, f22, f8, 0.0f, num4, num29, num48, num58, num59, num70, num73, f30, num81, f33, 0, num5, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num30, num38, num49, 0, 0, f11, f23, 0.0f, num64, num68, num71, num72, num74, num77, num82, f28, num86, f32, 0, num90, 0, num92, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num10, num21, num22, 0, 0, f15, f14, 0.0f, num26, num31, num32, num34, num35, num39, num42, f19, num45, f21, 0, num52, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num67, num69, 0, 0, f26, f27, 0.0f, num75, num76, num78, num79, num83, num84, num85, f29, num87, f31, 0, num88, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num7, num8, num9, 0, 0, f6, f7, 0.0f, num11, num13, num15, num17, num18, num19, num20, f12, num23, f13, 0, num24, 0, num25, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num27, num28, num33, 0, 0, f16, f17, 0.0f, num36, num37, num40, num41, num43, num44, num46, f20, num47, f18, 0, num50, 0, num51, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f25, f24, 0.0f, num60, num61, num62, num63, num16, num66, num14, f9, num12, f10, drawable5, drawable7, drawable4, drawable8, drawable3, drawable6, drawable2);
        }
    }
}
