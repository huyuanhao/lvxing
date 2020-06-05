package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import tech.linjiang.android.drawable.Drawables;

public class ActivityTodayProfitLogsBindingImpl extends ActivityTodayProfitLogsBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10235c = null;
    /* renamed from: d */
    private static final SparseIntArray f10236d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10237e;
    /* renamed from: f */
    private final FrameLayout f10238f;
    /* renamed from: g */
    private long f10239g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10236d.put(R.id.refresh, 2);
        f10236d.put(R.id.list, 3);
    }

    public ActivityTodayProfitLogsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f10235c, f10236d));
    }

    private ActivityTodayProfitLogsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[3], (SmartRefreshLayout) objArr[2]);
        this.f10239g = -1;
        this.f10237e = objArr[0];
        this.f10237e.setTag(null);
        this.f10238f = objArr[1];
        this.f10238f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10239g = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10239g != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10239g;
            this.f10239g = 0;
        }
        if ((j & 1) != 0) {
            FrameLayout frameLayout = this.f10238f;
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
            Drawable drawable = null;
            Drawable drawable2 = drawable;
            Drawable drawable3 = drawable;
            Drawable drawable4 = drawable;
            Drawables.m37723a(frameLayout, 0, Integer.valueOf(getColorFromResource(frameLayout, R.color.grey_f4)), 0, num19, 0.0f, 0.0f, 15.0f, 0.0f, 0.0f, 0.0f, 0.0f, num49, num71, num80, 0, 0, f6, f11, 0.0f, num20, num39, num44, num50, num55, num61, num64, f22, num72, f27, 0, num, 0, num, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num36, num40, 0, 0, f10, f19, 0.0f, num56, num59, num62, num63, num65, num68, num73, f23, num77, f26, 0, num81, 0, num83, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num11, num12, 0, 0, f8, f9, 0.0f, num16, num21, num22, num24, num25, num30, num33, f15, num38, f17, 0, num43, 0, num45, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num57, num58, num60, 0, 0, f20, f21, 0.0f, num66, num67, num69, num70, num74, num75, num76, f24, num78, f25, 0, num79, 0, num82, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num, num, num, 0, 0, f2, f3, 0.0f, num, num4, num5, num7, num8, num9, num10, f5, num13, f7, 0, num14, 0, num15, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num17, num18, num23, 0, 0, f12, f13, 0.0f, num26, num27, num31, num32, num34, num35, num37, f14, num28, f16, 0, num41, 0, num42, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num46, num47, num48, 0, 0, f18, f4, 0.0f, num51, num52, num53, num54, num3, num2, num, f, num, f, drawable, drawable, drawable2, drawable3, drawable4, drawable, drawable);
        }
    }
}
