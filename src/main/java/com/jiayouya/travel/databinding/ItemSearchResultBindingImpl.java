package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class ItemSearchResultBindingImpl extends ItemSearchResultBinding {
    /* renamed from: f */
    private static final IncludedLayouts f11159f = null;
    /* renamed from: g */
    private static final SparseIntArray f11160g = new SparseIntArray();
    /* renamed from: h */
    private final ConstraintLayout f11161h;
    /* renamed from: i */
    private long f11162i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f11160g.put(R.id.iv, 1);
        f11160g.put(R.id.tv_title, 2);
        f11160g.put(R.id.tv_ticket, 3);
        f11160g.put(R.id.tv_num, 4);
        f11160g.put(R.id.tv_price, 5);
    }

    public ItemSearchResultBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f11159f, f11160g));
    }

    private ItemSearchResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[2]);
        this.f11162i = -1;
        this.f11161h = objArr[0];
        this.f11161h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11162i = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11162i != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f11162i;
            this.f11162i = 0;
        }
    }
}
