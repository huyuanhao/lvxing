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
import com.jiayouya.travel.module.travel.data.CoinRankListItem;
import com.jiayouya.travel.module.travel.data.CoinRankListItemKt;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ItemCoinRankListBindingImpl extends ItemCoinRankListBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10938b = null;
    /* renamed from: c */
    private static final SparseIntArray f10939c = null;
    /* renamed from: d */
    private final LinearLayout f10940d;
    /* renamed from: e */
    private final ImageView f10941e;
    /* renamed from: f */
    private final TextView f10942f;
    /* renamed from: g */
    private final CircleImageView f10943g;
    /* renamed from: h */
    private final TextView f10944h;
    /* renamed from: i */
    private final TextView f10945i;
    /* renamed from: j */
    private final TextView f10946j;
    /* renamed from: k */
    private long f10947k;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemCoinRankListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f10938b, f10939c));
    }

    private ItemCoinRankListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10947k = -1;
        this.f10940d = objArr[0];
        this.f10940d.setTag(null);
        this.f10941e = objArr[1];
        this.f10941e.setTag(null);
        this.f10942f = objArr[2];
        this.f10942f.setTag(null);
        this.f10943g = objArr[3];
        this.f10943g.setTag(null);
        this.f10944h = objArr[4];
        this.f10944h.setTag(null);
        this.f10945i = objArr[5];
        this.f10945i.setTag(null);
        this.f10946j = objArr[6];
        this.f10946j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10947k = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10947k != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20173a((CoinRankListItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20173a(CoinRankListItem coinRankListItem) {
        this.f10937a = coinRankListItem;
        synchronized (this) {
            this.f10947k |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        CharSequence charSequence;
        boolean z2;
        CharSequence charSequence2;
        int i;
        CharSequence charSequence3;
        CharSequence charSequence4;
        String str;
        int i2;
        String str2;
        String str3;
        synchronized (this) {
            j = this.f10947k;
            this.f10947k = 0;
        }
        CoinRankListItem coinRankListItem = this.f10937a;
        double d = 0.0d;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (coinRankListItem != null) {
                str = coinRankListItem.getAvatar();
                d = coinRankListItem.getCoin();
                str3 = coinRankListItem.getDogName();
                str2 = coinRankListItem.getLevel();
                i2 = coinRankListItem.getPosition();
                charSequence = coinRankListItem.getNickname();
            } else {
                str = null;
                str3 = null;
                str2 = null;
                charSequence = null;
                i2 = 0;
            }
            z = CoinRankListItemKt.isShowImage(coinRankListItem);
            i = CoinRankListItemKt.positionImage(coinRankListItem);
            charSequence2 = GoldUtil.f11900a.mo21651a(d);
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("Lv.");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(i2);
            charSequence3 = sb3.toString();
            z2 = !z;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append(str2);
            charSequence4 = sb4.toString();
        } else {
            str = null;
            charSequence4 = null;
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
            i = 0;
            z2 = false;
            z = false;
        }
        if (i3 != 0) {
            ViewAdapter.m12798c((View) this.f10941e, Boolean.valueOf(z2));
            CornerType cornerType = null;
            Integer num = null;
            ImageAdapter.m12781a(this.f10941e, Integer.valueOf(i), 0, cornerType, num);
            TextViewBindingAdapter.setText(this.f10942f, charSequence3);
            ViewAdapter.m12798c((View) this.f10942f, Boolean.valueOf(z));
            ImageAdapter.m12783a((ImageView) this.f10943g, str, 0, cornerType, num);
            TextViewBindingAdapter.setText(this.f10944h, charSequence);
            TextViewBindingAdapter.setText(this.f10945i, charSequence4);
            TextViewBindingAdapter.setText(this.f10946j, charSequence2);
        }
    }
}
