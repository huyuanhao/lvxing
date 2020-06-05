package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout;
import ezy.p653ui.widget.round.RoundText;
import tech.linjiang.android.drawable.Drawables;

public class DialogDoubleCoinBindingImpl extends DialogDoubleCoinBinding {
    /* renamed from: g */
    private static final IncludedLayouts f10376g = null;
    /* renamed from: h */
    private static final SparseIntArray f10377h = new SparseIntArray();
    /* renamed from: i */
    private final LinearLayout f10378i;
    /* renamed from: j */
    private final LinearLayout f10379j;
    /* renamed from: k */
    private final FrameLayout f10380k;
    /* renamed from: l */
    private long f10381l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10377h.put(R.id.tv_coin, 3);
        f10377h.put(R.id.btn, 4);
        f10377h.put(R.id.iv_close, 5);
        f10377h.put(R.id.lyt_ad, 6);
        f10377h.put(R.id.iv_gif, 7);
    }

    public DialogDoubleCoinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f10376g, f10377h));
    }

    private DialogDoubleCoinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[4], (TextView) objArr[5], (ImageView) objArr[7], (GeneralRoundLinearLayout) objArr[6], (TextView) objArr[3]);
        this.f10381l = -1;
        this.f10378i = objArr[0];
        this.f10378i.setTag(null);
        this.f10379j = objArr[1];
        this.f10379j.setTag(null);
        this.f10380k = objArr[2];
        this.f10380k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10381l = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10381l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (26 != i) {
            return false;
        }
        mo20115a(((Boolean) obj).booleanValue());
        return true;
    }

    /* renamed from: a */
    public void mo20115a(boolean z) {
        this.f10375f = z;
        synchronized (this) {
            this.f10381l |= 1;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10381l;
            this.f10381l = 0;
        }
        boolean z = false;
        boolean z2 = this.f10375f;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i != 0) {
            z = !z2;
        }
        if ((j & 2) != 0) {
            LinearLayout linearLayout = this.f10379j;
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
            Drawable drawable = null;
            Drawable drawable2 = drawable;
            Drawable drawable3 = drawable;
            Drawable drawable4 = drawable;
            Drawables.m37723a(linearLayout, 0, Integer.valueOf(getColorFromResource(linearLayout, R.color.grey_f4)), 0, num27, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, num57, num79, num88, 0, 0, f3, f8, 0.0f, num28, num47, num52, num58, num63, num69, num72, f19, num80, f24, 0, num2, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num37, num44, num48, 0, 0, f7, f16, 0.0f, num64, num67, num70, num71, num73, num76, num81, f20, num85, f23, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num14, num19, num20, 0, 0, f5, f6, 0.0f, num24, num29, num30, num32, num33, num38, num41, f12, num46, f14, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num66, num68, 0, 0, f17, f18, 0.0f, num74, num75, num77, num78, num82, num83, num84, f21, num86, f22, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num3, num4, num5, 0, 0, f, f, 0.0f, num8, num12, num13, num15, num16, num17, num18, f2, num21, f4, 0, num22, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num25, num26, num31, 0, 0, f9, f10, 0.0f, num34, num35, num39, num40, num42, num43, num45, f11, num36, f13, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f15, f, 0.0f, num59, num60, num61, num62, num11, num10, num9, f, num7, f, drawable, drawable, drawable2, drawable3, drawable4, drawable, drawable);
        }
        if (i != 0) {
            ViewAdapter.m12798c((View) this.f10380k, Boolean.valueOf(z));
        }
    }
}
