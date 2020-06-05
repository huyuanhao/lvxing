package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.module.common.data.PayChannelItem;

public class ItemPayBindingImpl extends ItemPayBinding {
    /* renamed from: c */
    private static final IncludedLayouts f11137c = null;
    /* renamed from: d */
    private static final SparseIntArray f11138d = null;
    /* renamed from: e */
    private final LinearLayout f11139e;
    /* renamed from: f */
    private final ImageView f11140f;
    /* renamed from: g */
    private final TextView f11141g;
    /* renamed from: h */
    private final ImageView f11142h;
    /* renamed from: i */
    private long f11143i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemPayBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f11137c, f11138d));
    }

    private ItemPayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11143i = -1;
        this.f11139e = objArr[0];
        this.f11139e.setTag(null);
        this.f11140f = objArr[1];
        this.f11140f.setTag(null);
        this.f11141g = objArr[2];
        this.f11141g.setTag(null);
        this.f11142h = objArr[3];
        this.f11142h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11143i = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11143i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20201a((PayChannelItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20200a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20201a(PayChannelItem payChannelItem) {
        this.f11135a = payChannelItem;
        synchronized (this) {
            this.f11143i |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20200a(OnClickListener onClickListener) {
        this.f11136b = onClickListener;
        synchronized (this) {
            this.f11143i |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (r4 == 1) goto L_0x0035;
     */
    public void executeBindings() {
        /*
        r15 = this;
        monitor-enter(r15)
        long r0 = r15.f11143i     // Catch:{ all -> 0x0068 }
        r2 = 0
        r15.f11143i = r2     // Catch:{ all -> 0x0068 }
        monitor-exit(r15)     // Catch:{ all -> 0x0068 }
        com.jiayouya.travel.module.common.data.PayChannelItem r4 = r15.f11135a
        android.view.View$OnClickListener r5 = r15.f11136b
        r6 = 5
        long r6 = r6 & r0
        r8 = 0
        r9 = 0
        int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
        if (r10 == 0) goto L_0x0031
        if (r4 == 0) goto L_0x0028
        boolean r6 = r4.isSelected()
        java.lang.String r7 = r4.getName()
        java.lang.String r11 = r4.getLogo()
        int r4 = r4.getStatus()
        goto L_0x002c
    L_0x0028:
        r7 = r8
        r11 = r7
        r4 = 0
        r6 = 0
    L_0x002c:
        r12 = 1
        r6 = r6 ^ r12
        if (r4 != r12) goto L_0x0034
        goto L_0x0035
    L_0x0031:
        r7 = r8
        r11 = r7
        r6 = 0
    L_0x0034:
        r12 = 0
    L_0x0035:
        r13 = 6
        long r0 = r0 & r13
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 == 0) goto L_0x0044
        android.widget.LinearLayout r0 = r15.f11139e
        r1 = r8
        java.lang.Integer r1 = (java.lang.Integer) r1
        com.jiayouya.travel.common.p243a.ViewAdapter.m12792a(r0, r5, r1)
    L_0x0044:
        if (r10 == 0) goto L_0x0067
        android.widget.ImageView r0 = r15.f11140f
        r1 = r8
        jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = (p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType) r1
        java.lang.Integer r8 = (java.lang.Integer) r8
        com.jiayouya.travel.common.p243a.ImageAdapter.m12783a(r0, r11, r9, r1, r8)
        android.widget.TextView r0 = r15.f11141g
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r7)
        android.widget.TextView r0 = r15.f11141g
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r12)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12796b(r0, r1)
        android.widget.ImageView r0 = r15.f11142h
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r0, r1)
    L_0x0067:
        return
    L_0x0068:
        r0 = move-exception
        monitor-exit(r15)     // Catch:{ all -> 0x0068 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.databinding.ItemPayBindingImpl.executeBindings():void");
    }
}
