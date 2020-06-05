package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.module.travel.data.DogRankListItem;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ItemDogRankListBindingImpl extends ItemDogRankListBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10954b = null;
    /* renamed from: c */
    private static final SparseIntArray f10955c = null;
    /* renamed from: d */
    private final FrameLayout f10956d;
    /* renamed from: e */
    private final CircleImageView f10957e;
    /* renamed from: f */
    private final TextView f10958f;
    /* renamed from: g */
    private final TextView f10959g;
    /* renamed from: h */
    private final TextView f10960h;
    /* renamed from: i */
    private long f10961i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemDogRankListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10954b, f10955c));
    }

    private ItemDogRankListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10961i = -1;
        this.f10956d = objArr[0];
        this.f10956d.setTag(null);
        this.f10957e = objArr[1];
        this.f10957e.setTag(null);
        this.f10958f = objArr[2];
        this.f10958f.setTag(null);
        this.f10959g = objArr[3];
        this.f10959g.setTag(null);
        this.f10960h = objArr[4];
        this.f10960h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10961i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10961i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20175a((DogRankListItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20175a(DogRankListItem dogRankListItem) {
        this.f10953a = dogRankListItem;
        synchronized (this) {
            this.f10961i |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String str;
        synchronized (this) {
            j = this.f10961i;
            this.f10961i = 0;
        }
        DogRankListItem dogRankListItem = this.f10953a;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i == 0 || dogRankListItem == null) {
            str = null;
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
        } else {
            str = dogRankListItem.getAvatar();
            charSequence3 = dogRankListItem.getProfit();
            charSequence2 = dogRankListItem.getSource();
            charSequence = dogRankListItem.getNickname();
        }
        if (i != 0) {
            ImageAdapter.m12783a((ImageView) this.f10957e, str, 0, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f10958f, charSequence);
            TextViewBindingAdapter.setText(this.f10959g, charSequence3);
            TextViewBindingAdapter.setText(this.f10960h, charSequence2);
        }
    }
}
