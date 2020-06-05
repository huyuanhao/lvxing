package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.p653ui.widget.round.RoundText;
import tech.linjiang.android.drawable.Drawables;

public class FragmentTbBindingImpl extends FragmentTbBinding {
    /* renamed from: f */
    private static final IncludedLayouts f10784f = null;
    /* renamed from: g */
    private static final SparseIntArray f10785g = new SparseIntArray();
    /* renamed from: h */
    private final FrameLayout f10786h;
    /* renamed from: i */
    private final TextView f10787i;
    /* renamed from: j */
    private long f10788j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10785g.put(R.id.refresh, 3);
        f10785g.put(R.id.tv_tb, 4);
        f10785g.put(R.id.btn_get, 5);
        f10785g.put(R.id.list, 6);
    }

    public FragmentTbBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f10784f, f10785g));
    }

    private FragmentTbBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[5], (RecyclerView) objArr[6], (SmartRefreshLayout) objArr[3], (TextView) objArr[2], (TextView) objArr[4]);
        this.f10788j = -1;
        this.f10786h = objArr[0];
        this.f10786h.setTag(null);
        this.f10787i = objArr[1];
        this.f10787i.setTag(null);
        this.f10782d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10788j = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10788j != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10788j;
            this.f10788j = 0;
        }
        if ((j & 1) != 0) {
            ViewAdapter.m12794a((View) this.f10787i, "/tb/order");
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
            Drawables.m37723a(this.f10782d, 0, Integer.valueOf(getColorFromResource(this.f10782d, R.color.grey_f4)), 0, num27, 0.0f, 0.0f, 6.0f, 0.0f, 0.0f, 0.0f, 0.0f, num57, num79, num88, 0, 0, f3, f8, 0.0f, num28, num47, num52, num58, num63, num69, num72, f19, num80, f24, 0, num2, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num37, num44, num48, 0, 0, f7, f16, 0.0f, num64, num67, num70, num71, num73, num76, num81, f20, num85, f23, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num14, num19, num20, 0, 0, f5, f6, 0.0f, num24, num29, num30, num32, num33, num38, num41, f12, num46, f14, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num66, num68, 0, 0, f17, f18, 0.0f, num74, num75, num77, num78, num82, num83, num84, f21, num86, f22, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num3, num4, num5, 0, 0, f, f, 0.0f, num8, num12, num13, num15, num16, num17, num18, f2, num21, f4, 0, num22, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num25, num26, num31, 0, 0, f9, f10, 0.0f, num34, num35, num39, num40, num42, num43, num45, f11, num36, f13, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f15, f, 0.0f, num59, num60, num61, num62, num11, num10, num9, f, num7, f, drawable, drawable, drawable2, drawable3, drawable4, drawable, drawable);
        }
    }
}
