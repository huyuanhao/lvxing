package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class ActivityAvatarBindingImpl extends ActivityAvatarBinding {
    /* renamed from: c */
    private static final IncludedLayouts f9861c = null;
    /* renamed from: d */
    private static final SparseIntArray f9862d = new SparseIntArray();
    /* renamed from: e */
    private final FrameLayout f9863e;
    /* renamed from: f */
    private long f9864f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f9862d.put(R.id.iv_title_right, 1);
        f9862d.put(R.id.iv_avatar, 2);
    }

    public ActivityAvatarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f9861c, f9862d));
    }

    private ActivityAvatarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (ImageView) objArr[1]);
        this.f9864f = -1;
        this.f9863e = objArr[0];
        this.f9863e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9864f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9864f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f9864f;
            this.f9864f = 0;
        }
    }
}
