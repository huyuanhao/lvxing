package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.travel.widget.RandomMergeView;

public class DialogRandomMergeBindingImpl extends DialogRandomMergeBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10573e = null;
    /* renamed from: f */
    private static final SparseIntArray f10574f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f10575g;
    /* renamed from: h */
    private long f10576h;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10574f.put(R.id.lyt_container, 1);
        f10574f.put(R.id.random_merge_view, 2);
        f10574f.put(R.id.btn, 3);
        f10574f.put(R.id.iv_close, 4);
    }

    public DialogRandomMergeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10573e, f10574f));
    }

    private DialogRandomMergeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ImageView) objArr[4], (FrameLayout) objArr[1], (RandomMergeView) objArr[2]);
        this.f10576h = -1;
        this.f10575g = objArr[0];
        this.f10575g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10576h = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10576h != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10576h;
            this.f10576h = 0;
        }
    }
}
