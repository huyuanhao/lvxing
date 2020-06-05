package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.travel.data.ProfitRankListItem;
import com.jiayouya.travel.module.travel.data.ProfitRankListItemKt;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ItemProfitRankListBindingImpl extends ItemProfitRankListBinding {
    /* renamed from: b */
    private static final IncludedLayouts f11145b = null;
    /* renamed from: c */
    private static final SparseIntArray f11146c = null;
    /* renamed from: d */
    private final LinearLayout f11147d;
    /* renamed from: e */
    private final ImageView f11148e;
    /* renamed from: f */
    private final TextView f11149f;
    /* renamed from: g */
    private final CircleImageView f11150g;
    /* renamed from: h */
    private final TextView f11151h;
    /* renamed from: i */
    private final TextView f11152i;
    /* renamed from: j */
    private long f11153j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemProfitRankListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f11145b, f11146c));
    }

    private ItemProfitRankListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11153j = -1;
        this.f11147d = objArr[0];
        this.f11147d.setTag(null);
        this.f11148e = objArr[1];
        this.f11148e.setTag(null);
        this.f11149f = objArr[2];
        this.f11149f.setTag(null);
        this.f11150g = objArr[3];
        this.f11150g.setTag(null);
        this.f11151h = objArr[4];
        this.f11151h.setTag(null);
        this.f11152i = objArr[5];
        this.f11152i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11153j = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11153j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20202a((ProfitRankListItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20202a(ProfitRankListItem profitRankListItem) {
        this.f11144a = profitRankListItem;
        synchronized (this) {
            this.f11153j |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        boolean z2;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String str;
        int i2;
        synchronized (this) {
            j = this.f11153j;
            this.f11153j = 0;
        }
        ProfitRankListItem profitRankListItem = this.f11144a;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (profitRankListItem != null) {
                str = profitRankListItem.getAvatar();
                charSequence3 = profitRankListItem.getProfit();
                i2 = profitRankListItem.getPosition();
                charSequence = profitRankListItem.getNickname();
            } else {
                str = null;
                charSequence3 = null;
                charSequence = null;
                i2 = 0;
            }
            i = ProfitRankListItemKt.positionImage(profitRankListItem);
            z2 = ProfitRankListItemKt.isShowImage(profitRankListItem);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i2);
            charSequence2 = sb.toString();
            z = !z2;
        } else {
            str = null;
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
            z2 = false;
            i = 0;
            z = false;
        }
        if (i3 != 0) {
            ViewAdapter.m12798c((View) this.f11148e, Boolean.valueOf(z));
            CornerType cornerType = null;
            Integer num = null;
            ImageAdapter.m12781a(this.f11148e, Integer.valueOf(i), 0, cornerType, num);
            TextViewBindingAdapter.setText(this.f11149f, charSequence2);
            ViewAdapter.m12798c((View) this.f11149f, Boolean.valueOf(z2));
            ImageAdapter.m12783a((ImageView) this.f11150g, str, 0, cornerType, num);
            TextViewBindingAdapter.setText(this.f11151h, charSequence);
            TextViewBindingAdapter.setText(this.f11152i, charSequence3);
        }
    }
}
