package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.explore.data.ExploreIndexKt;
import com.jiayouya.travel.module.explore.data.HarvestItem;

public class ItemExploreHarvestBindingImpl extends ItemExploreHarvestBinding {
    /* renamed from: c */
    private static final IncludedLayouts f11002c = null;
    /* renamed from: d */
    private static final SparseIntArray f11003d = null;
    /* renamed from: e */
    private final LinearLayout f11004e;
    /* renamed from: f */
    private final ImageView f11005f;
    /* renamed from: g */
    private final TextView f11006g;
    /* renamed from: h */
    private final TextView f11007h;
    /* renamed from: i */
    private long f11008i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemExploreHarvestBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f11002c, f11003d));
    }

    private ItemExploreHarvestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11008i = -1;
        this.f11004e = objArr[0];
        this.f11004e.setTag(null);
        this.f11005f = objArr[1];
        this.f11005f.setTag(null);
        this.f11006g = objArr[2];
        this.f11006g.setTag(null);
        this.f11007h = objArr[3];
        this.f11007h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11008i = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11008i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20182a((HarvestItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20181a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20182a(HarvestItem harvestItem) {
        this.f11000a = harvestItem;
        synchronized (this) {
            this.f11008i |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20181a(OnClickListener onClickListener) {
        this.f11001b = onClickListener;
        synchronized (this) {
            this.f11008i |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        String str;
        boolean z;
        String str2;
        int i2;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.f11008i;
            this.f11008i = 0;
        }
        HarvestItem harvestItem = this.f11000a;
        OnClickListener onClickListener = this.f11001b;
        int i3 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            z2 = ExploreIndexKt.isDog(harvestItem);
            i2 = ExploreIndexKt.textColor(harvestItem);
            int image = ExploreIndexKt.image(harvestItem);
            str = ExploreIndexKt.value(harvestItem);
            double value = harvestItem != null ? harvestItem.getValue() : 0.0d;
            z3 = !z2;
            StringBuilder sb = new StringBuilder();
            sb.append("x");
            sb.append(str);
            str2 = sb.toString();
            z = value != 0.0d;
            i = image;
        } else {
            z3 = false;
            z2 = false;
            i2 = 0;
            str2 = null;
            z = false;
            str = null;
            i = 0;
        }
        if ((j & 6) != 0) {
            ViewAdapter.m12792a(this.f11004e, onClickListener, null);
        }
        if (i3 != 0) {
            ImageAdapter.m12780a(this.f11005f, Integer.valueOf(i));
            TextViewBindingAdapter.setText(this.f11006g, str2);
            ViewAdapter.m12793a((View) this.f11006g, Boolean.valueOf(z));
            ViewAdapter.m12798c((View) this.f11006g, Boolean.valueOf(z3));
            TextViewBindingAdapter.setText(this.f11007h, str);
            this.f11007h.setTextColor(i2);
            ViewAdapter.m12799d(this.f11007h, Boolean.valueOf(z2));
        }
    }
}
