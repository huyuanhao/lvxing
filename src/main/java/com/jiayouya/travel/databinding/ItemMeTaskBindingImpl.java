package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.p276me.data.MeMenuKt;
import com.jiayouya.travel.module.p276me.data.TaskItem;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import tech.linjiang.android.drawable.Drawables;

public class ItemMeTaskBindingImpl extends ItemMeTaskBinding {
    /* renamed from: c */
    private static final IncludedLayouts f11087c = null;
    /* renamed from: d */
    private static final SparseIntArray f11088d = null;
    /* renamed from: e */
    private final LinearLayout f11089e;
    /* renamed from: f */
    private final ImageView f11090f;
    /* renamed from: g */
    private final TextView f11091g;
    /* renamed from: h */
    private final TextView f11092h;
    /* renamed from: i */
    private final TextView f11093i;
    /* renamed from: j */
    private long f11094j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemMeTaskBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f11087c, f11088d));
    }

    private ItemMeTaskBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11094j = -1;
        this.f11089e = objArr[0];
        this.f11089e.setTag(null);
        this.f11090f = objArr[1];
        this.f11090f.setTag(null);
        this.f11091g = objArr[2];
        this.f11091g.setTag(null);
        this.f11092h = objArr[3];
        this.f11092h.setTag(null);
        this.f11093i = objArr[4];
        this.f11093i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11094j = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11094j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20193a((TaskItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20192a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20193a(TaskItem taskItem) {
        this.f11085a = taskItem;
        synchronized (this) {
            this.f11094j |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20192a(OnClickListener onClickListener) {
        this.f11086b = onClickListener;
        synchronized (this) {
            this.f11094j |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        CharSequence charSequence;
        String str;
        CharSequence charSequence2;
        int i;
        Drawable drawable;
        int i2;
        synchronized (this) {
            j = this.f11094j;
            this.f11094j = 0;
        }
        TaskItem taskItem = this.f11085a;
        OnClickListener onClickListener = this.f11086b;
        int i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (taskItem != null) {
                i2 = taskItem.getHbId();
                charSequence2 = taskItem.getTitle();
                str = taskItem.getImage();
                charSequence = taskItem.getDesc();
            } else {
                charSequence2 = null;
                str = null;
                charSequence = null;
                i2 = 0;
            }
            drawable = MeMenuKt.getBgDrawable(taskItem);
            boolean z2 = true;
            z = i2 != 0;
            if (i2 != 0) {
                z2 = false;
            }
            if (i3 != 0) {
                j |= z2 ? 16 : 8;
            }
            i = getColorFromResource(this.f11093i, z2 ? R.color.grey_f4 : R.color.green_39CD63);
        } else {
            drawable = null;
            charSequence2 = null;
            str = null;
            charSequence = null;
            i = 0;
            z = false;
        }
        int i4 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((j & 5) != 0) {
            ViewAdapter.m12791a((View) this.f11089e, drawable);
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
            ImageAdapter.m12783a(this.f11090f, str, 0, (CornerType) null, num);
            TextViewBindingAdapter.setText(this.f11091g, charSequence2);
            TextViewBindingAdapter.setText(this.f11092h, charSequence);
            ViewAdapter.m12793a((View) this.f11093i, Boolean.valueOf(z));
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
            Drawable drawable2 = null;
            Drawables.m37723a(this.f11093i, 0, Integer.valueOf(i), 0, num2, 0.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f, num56, num79, num88, 0, 0, f9, f12, 0.0f, num3, num28, num47, num57, num58, num69, num72, f24, num80, f29, 0, num4, 0, num5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num29, num37, num48, 0, 0, f6, f20, 0.0f, num63, num67, num70, num71, num73, num76, num81, f25, num85, f28, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num9, num20, num21, 0, 0, f10, f11, 0.0f, num25, num30, num31, num33, num34, num38, num41, f17, num44, f16, 0, num51, 0, num52, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num64, num66, num68, 0, 0, f22, f23, 0.0f, num74, num75, num77, num78, num82, num83, num84, f26, num86, f27, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num6, num7, num8, 0, 0, f2, f3, 0.0f, num10, num12, num14, num16, num17, num18, num19, f8, num22, f21, 0, num23, 0, num24, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num26, num27, num32, 0, 0, f13, f14, 0.0f, num35, num36, num39, num40, num42, num43, num45, f18, num46, f15, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num53, num54, num55, 0, 0, f19, f7, 0.0f, num59, num60, num61, num62, num15, num65, num13, f4, num11, f5, drawable2, drawable2, drawable2, drawable2, drawable2, drawable2, drawable2);
        }
        if (i4 != 0) {
            ViewAdapter.m12792a(this.f11089e, onClickListener, null);
        }
    }
}
