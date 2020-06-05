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
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout;
import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import ezy.p653ui.widget.round.RoundLayout;
import tech.linjiang.android.drawable.Drawables;

public class DialogCoinShortBindingImpl extends DialogCoinShortBinding {
    /* renamed from: i */
    private static final IncludedLayouts f10328i = null;
    /* renamed from: j */
    private static final SparseIntArray f10329j = new SparseIntArray();
    /* renamed from: k */
    private final FrameLayout f10330k;
    /* renamed from: l */
    private final LinearLayout f10331l;
    /* renamed from: m */
    private final TextView f10332m;
    /* renamed from: n */
    private final TextView f10333n;
    /* renamed from: o */
    private final TextView f10334o;
    /* renamed from: p */
    private final FrameLayout f10335p;
    /* renamed from: q */
    private long f10336q;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10329j.put(R.id.lyt_main, 6);
        f10329j.put(R.id.btn_see, 7);
        f10329j.put(R.id.iv_close, 8);
        f10329j.put(R.id.lyt_ad, 9);
        f10329j.put(R.id.iv_gif, 10);
        f10329j.put(R.id.lyt_ad_text, 11);
    }

    public DialogCoinShortBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, f10328i, f10329j));
    }

    private DialogCoinShortBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundLayout) objArr[7], (TextView) objArr[8], (ImageView) objArr[10], (GeneralRoundLinearLayout) objArr[9], (LinearLayout) objArr[11], (LinearLayout) objArr[6]);
        this.f10336q = -1;
        this.f10330k = objArr[0];
        this.f10330k.setTag(null);
        this.f10331l = objArr[1];
        this.f10331l.setTag(null);
        this.f10332m = objArr[2];
        this.f10332m.setTag(null);
        this.f10333n = objArr[3];
        this.f10333n.setTag(null);
        this.f10334o = objArr[4];
        this.f10334o.setTag(null);
        this.f10335p = objArr[5];
        this.f10335p.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10336q = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10336q != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20110a((BuyDogRsp) obj);
        } else if (26 != i) {
            return false;
        } else {
            mo20111a(((Boolean) obj).booleanValue());
        }
        return true;
    }

    /* renamed from: a */
    public void mo20110a(BuyDogRsp buyDogRsp) {
        this.f10326g = buyDogRsp;
        synchronized (this) {
            this.f10336q |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20111a(boolean z) {
        this.f10327h = z;
        synchronized (this) {
            this.f10336q |= 2;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        boolean z;
        CharSequence charSequence2;
        String str;
        CharSequence charSequence3;
        AdRsp adRsp;
        int i;
        String str2;
        synchronized (this) {
            j = this.f10336q;
            this.f10336q = 0;
        }
        BuyDogRsp buyDogRsp = this.f10326g;
        double d = 0.0d;
        boolean z2 = this.f10327h;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (buyDogRsp != null) {
                d = buyDogRsp.getCoin();
                adRsp = buyDogRsp.getAdInfo();
                str = buyDogRsp.getTimeText();
            } else {
                str = null;
                adRsp = null;
            }
            charSequence2 = GoldUtil.f11900a.mo21651a(d);
            z = str == null;
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (adRsp != null) {
                i = adRsp.getAdNumVideo();
                str2 = adRsp.getAdDesc();
            } else {
                str2 = null;
                i = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("(剩余");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(i);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append("次)");
            charSequence = sb5.toString();
        } else {
            str = null;
            charSequence2 = null;
            charSequence = null;
            z = false;
        }
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        boolean z3 = i3 != 0 ? !z2 : false;
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (z) {
                str = "";
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("立即获得");
            sb6.append(str);
            charSequence3 = sb6.toString();
        } else {
            charSequence3 = null;
        }
        if ((j & 4) != 0) {
            LinearLayout linearLayout = this.f10331l;
            LinearLayout linearLayout2 = linearLayout;
            Integer valueOf = Integer.valueOf(getColorFromResource(linearLayout, R.color.grey_f4));
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
            Drawable drawable = null;
            Drawables.m37723a(linearLayout2, 0, valueOf, 0, num27, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, num57, num79, num88, 0, 0, f8, f13, 0.0f, num28, num47, num52, num58, num63, num69, num72, f24, num80, f29, 0, num2, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num37, num44, num48, 0, 0, f12, f21, 0.0f, num64, num67, num70, num71, num73, num76, num81, f25, num85, f28, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num14, num19, num20, 0, 0, f10, f11, 0.0f, num24, num29, num30, num32, num33, num38, num41, f17, num46, f19, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num66, num68, 0, 0, f22, f23, 0.0f, num74, num75, num77, num78, num82, num83, num84, f26, num86, f27, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num3, num4, num5, 0, 0, f2, f3, 0.0f, num8, num12, num13, num15, num16, num17, num18, f7, num21, f9, 0, num22, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num25, num26, num31, 0, 0, f14, f15, 0.0f, num34, num35, num39, num40, num42, num43, num45, f16, num36, f18, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f20, f6, 0.0f, num59, num60, num61, num62, num11, num10, num9, f4, num7, f5, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.f10332m, charSequence2);
            TextViewBindingAdapter.setText(this.f10333n, charSequence3);
            TextViewBindingAdapter.setText(this.f10334o, charSequence);
        }
        if (i3 != 0) {
            ViewAdapter.m12798c((View) this.f10335p, Boolean.valueOf(z3));
        }
    }
}
