package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.travel.data.HandbookItem;
import com.jiayouya.travel.module.travel.data.HandbookItemKt;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import tech.linjiang.android.drawable.Drawables;

public class ItemHandbookBindingImpl extends ItemHandbookBinding {
    /* renamed from: b */
    private static final IncludedLayouts f11017b = null;
    /* renamed from: c */
    private static final SparseIntArray f11018c = null;
    /* renamed from: d */
    private final LinearLayout f11019d;
    /* renamed from: e */
    private final ImageView f11020e;
    /* renamed from: f */
    private final TextView f11021f;
    /* renamed from: g */
    private final TextView f11022g;
    /* renamed from: h */
    private final ImageView f11023h;
    /* renamed from: i */
    private final TextView f11024i;
    /* renamed from: j */
    private final TextView f11025j;
    /* renamed from: k */
    private long f11026k;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemHandbookBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f11017b, f11018c));
    }

    private ItemHandbookBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11026k = -1;
        this.f11019d = objArr[0];
        this.f11019d.setTag(null);
        this.f11020e = objArr[1];
        this.f11020e.setTag(null);
        this.f11021f = objArr[2];
        this.f11021f.setTag(null);
        this.f11022g = objArr[3];
        this.f11022g.setTag(null);
        this.f11023h = objArr[4];
        this.f11023h.setTag(null);
        this.f11024i = objArr[5];
        this.f11024i.setTag(null);
        this.f11025j = objArr[6];
        this.f11025j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11026k = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11026k != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20184a((HandbookItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20184a(HandbookItem handbookItem) {
        this.f11016a = handbookItem;
        synchronized (this) {
            this.f11026k |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        String str;
        CharSequence charSequence2;
        boolean z;
        boolean z2;
        int i;
        CharSequence charSequence3;
        int i2;
        CharSequence charSequence4;
        int i3;
        boolean z3;
        synchronized (this) {
            j = this.f11026k;
            this.f11026k = 0;
        }
        HandbookItem handbookItem = this.f11016a;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            String way = HandbookItemKt.way(handbookItem);
            i = HandbookItemKt.loversImage(handbookItem);
            if (handbookItem != null) {
                String image = handbookItem.getImage();
                String name = handbookItem.getName();
                String desc = handbookItem.getDesc();
                int id = handbookItem.getId();
                z3 = handbookItem.isFirst();
                CharSequence charSequence5 = name;
                str = image;
                i3 = id;
                charSequence4 = desc;
                charSequence = charSequence5;
            } else {
                str = null;
                charSequence = null;
                charSequence4 = null;
                z3 = false;
                i3 = 0;
            }
            if (i4 != 0) {
                j |= z3 ? 8 : 4;
            }
            z = i == -1;
            z2 = i3 != 47;
            i2 = z3 ? 10 : 0;
            charSequence2 = way;
            charSequence3 = charSequence4;
        } else {
            charSequence3 = null;
            charSequence2 = null;
            str = null;
            charSequence = null;
            i2 = 0;
            i = 0;
            z2 = false;
            z = false;
        }
        if ((3 & j) != 0) {
            ViewAdapter.m12790a((View) this.f11019d, i2);
            ImageAdapter.m12783a(this.f11020e, str, 0, (CornerType) null, (Integer) null);
            ViewAdapter.m12799d(this.f11021f, Boolean.valueOf(z2));
            TextViewBindingAdapter.setText(this.f11022g, charSequence);
            ViewAdapter.m12798c((View) this.f11023h, Boolean.valueOf(z));
            ImageAdapter.m12780a(this.f11023h, Integer.valueOf(i));
            TextViewBindingAdapter.setText(this.f11024i, charSequence3);
            TextViewBindingAdapter.setText(this.f11025j, charSequence2);
        }
        if ((j & 2) != 0) {
            TextView textView = this.f11021f;
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
            Drawable drawable = null;
            Drawables.m37723a(textView, 0, Integer.valueOf(getColorFromResource(textView, R.color.green_39CD63)), 0, num27, 0.0f, 0.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f, num57, num79, num88, 0, 0, f, f, 0.0f, num28, num47, num52, num58, num63, num69, num72, f, num80, f, 0, num2, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num37, num44, num48, 0, 0, f, f, 0.0f, num64, num67, num70, num71, num73, num76, num81, f, num85, f, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num14, num19, num20, 0, 0, f, f, 0.0f, num24, num29, num30, num32, num33, num38, num41, f, num46, f, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num66, num68, 0, 0, f, f, 0.0f, num74, num75, num77, num78, num82, num83, num84, f, num86, f, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num3, num4, num5, 0, 0, f, f, 0.0f, num8, num12, num13, num15, num16, num17, num18, f, num21, f, 0, num22, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num25, num26, num31, 0, 0, f, f, 0.0f, num34, num35, num39, num40, num42, num43, num45, f, num36, f, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f, f, 0.0f, num59, num60, num61, num62, num11, num10, num9, f, num7, f, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
        }
    }
}
