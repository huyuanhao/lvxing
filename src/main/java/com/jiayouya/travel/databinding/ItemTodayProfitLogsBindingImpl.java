package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.module.travel.data.TodayPorfitLogsItem;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ItemTodayProfitLogsBindingImpl extends ItemTodayProfitLogsBinding {
    /* renamed from: b */
    private static final IncludedLayouts f11183b = null;
    /* renamed from: c */
    private static final SparseIntArray f11184c = null;
    /* renamed from: d */
    private final FrameLayout f11185d;
    /* renamed from: e */
    private final CircleImageView f11186e;
    /* renamed from: f */
    private final TextView f11187f;
    /* renamed from: g */
    private final TextView f11188g;
    /* renamed from: h */
    private final TextView f11189h;
    /* renamed from: i */
    private long f11190i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemTodayProfitLogsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f11183b, f11184c));
    }

    private ItemTodayProfitLogsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11190i = -1;
        this.f11185d = objArr[0];
        this.f11185d.setTag(null);
        this.f11186e = objArr[1];
        this.f11186e.setTag(null);
        this.f11187f = objArr[2];
        this.f11187f.setTag(null);
        this.f11188g = objArr[3];
        this.f11188g.setTag(null);
        this.f11189h = objArr[4];
        this.f11189h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11190i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11190i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20204a((TodayPorfitLogsItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20204a(TodayPorfitLogsItem todayPorfitLogsItem) {
        this.f11182a = todayPorfitLogsItem;
        synchronized (this) {
            this.f11190i |= 1;
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
            j = this.f11190i;
            this.f11190i = 0;
        }
        TodayPorfitLogsItem todayPorfitLogsItem = this.f11182a;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i == 0 || todayPorfitLogsItem == null) {
            str = null;
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
        } else {
            str = todayPorfitLogsItem.getAvatar();
            charSequence3 = todayPorfitLogsItem.getProfit();
            charSequence2 = todayPorfitLogsItem.getNickname();
            charSequence = todayPorfitLogsItem.getNum();
        }
        if (i != 0) {
            ImageAdapter.m12783a((ImageView) this.f11186e, str, 0, (CornerType) null, (Integer) null);
            TextViewBindingAdapter.setText(this.f11187f, charSequence2);
            TextViewBindingAdapter.setText(this.f11188g, charSequence3);
            TextViewBindingAdapter.setText(this.f11189h, charSequence);
        }
    }
}
