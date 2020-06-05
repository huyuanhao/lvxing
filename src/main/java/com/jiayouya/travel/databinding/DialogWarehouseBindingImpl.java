package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;
import tech.linjiang.android.drawable.Drawables;

public class DialogWarehouseBindingImpl extends DialogWarehouseBinding {
    /* renamed from: h */
    private static final IncludedLayouts f10718h = null;
    /* renamed from: i */
    private static final SparseIntArray f10719i = new SparseIntArray();
    /* renamed from: j */
    private final LinearLayout f10720j;
    /* renamed from: k */
    private final FrameLayout f10721k;
    /* renamed from: l */
    private final TextView f10722l;
    /* renamed from: m */
    private long f10723m;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10719i.put(R.id.iv_close, 3);
        f10719i.put(R.id.list, 4);
        f10719i.put(R.id.lyt_empty, 5);
        f10719i.put(R.id.iv_empty, 6);
        f10719i.put(R.id.btn_expand, 7);
        f10719i.put(R.id.btn, 8);
    }

    public DialogWarehouseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, f10718h, f10719i));
    }

    private DialogWarehouseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[8], (RoundText) objArr[7], (FrameLayout) objArr[3], (ImageView) objArr[6], (RecyclerView) objArr[4], (ConstraintLayout) objArr[5]);
        this.f10723m = -1;
        this.f10720j = objArr[0];
        this.f10720j.setTag(null);
        this.f10721k = objArr[1];
        this.f10721k.setTag(null);
        this.f10722l = objArr[2];
        this.f10722l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10723m = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10723m != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (6 != i) {
            return false;
        }
        mo20148a((String) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20148a(String str) {
        this.f10717g = str;
        synchronized (this) {
            this.f10723m |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        synchronized (this) {
            j = this.f10723m;
            this.f10723m = 0;
        }
        String str = this.f10717g;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("容量 ");
            sb.append(str);
            charSequence = sb.toString();
        } else {
            charSequence = null;
        }
        if ((j & 2) != 0) {
            FrameLayout frameLayout = this.f10721k;
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
            Drawable drawable2 = drawable;
            Drawables.m37723a(frameLayout, 0, num55, 0, num, 0.0f, 0.0f, 0.0f, 10.0f, 0.0f, 10.0f, 0.0f, Integer.valueOf(getColorFromResource(frameLayout, R.color.green_start)), num78, Integer.valueOf(getColorFromResource(this.f10721k, R.color.green_end)), 0, 0, f9, f12, 0.0f, num26, num45, num50, num56, num57, num68, num71, f24, num79, f29, 0, num2, 0, num3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num34, num42, num46, 0, 0, f6, f21, 0.0f, num62, num66, num69, num70, num72, num75, num80, f25, num84, f28, 0, num87, 0, num89, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num7, num18, num19, 0, 0, f10, f11, 0.0f, num23, num27, num28, num30, num31, num35, num39, f18, num44, f16, 0, num49, 0, num51, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num63, num65, num67, 0, 0, f22, f23, 0.0f, num73, num74, num76, num77, num81, num82, num83, f26, num85, f27, 0, num86, 0, num88, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num4, num5, num6, 0, 0, f2, f3, 0.0f, num8, num10, num12, num14, num15, num16, num17, f8, num20, f19, 0, num21, 0, num22, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num24, num25, num29, 0, 0, f13, f14, 0.0f, num32, num33, num36, num38, num40, num41, num43, f17, num37, f15, 0, num47, 0, num48, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num52, num53, num54, 0, 0, f20, f7, 0.0f, num58, num59, num60, num61, num13, num64, num11, f4, num9, f5, drawable, drawable, drawable2, drawable, drawable, drawable, drawable);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f10722l, charSequence);
        }
    }
}
