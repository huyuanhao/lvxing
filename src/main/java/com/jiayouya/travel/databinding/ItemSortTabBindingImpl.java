package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class ItemSortTabBindingImpl extends ItemSortTabBinding {
    /* renamed from: c */
    private static final IncludedLayouts f11178c = null;
    /* renamed from: d */
    private static final SparseIntArray f11179d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f11180e;
    /* renamed from: f */
    private long f11181f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f11179d.put(R.id.tab_name_txt, 1);
        f11179d.put(R.id.tab_img, 2);
    }

    public ItemSortTabBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f11178c, f11179d));
    }

    private ItemSortTabBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (TextView) objArr[1]);
        this.f11181f = -1;
        this.f11180e = objArr[0];
        this.f11180e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11181f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11181f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f11181f;
            this.f11181f = 0;
        }
    }
}
