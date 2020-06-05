package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class ActivitySplashBindingImpl extends ActivitySplashBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10229b = null;
    /* renamed from: c */
    private static final SparseIntArray f10230c = new SparseIntArray();
    /* renamed from: d */
    private final LinearLayout f10231d;
    /* renamed from: e */
    private long f10232e;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10230c.put(R.id.lyt_container, 1);
    }

    public ActivitySplashBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, f10229b, f10230c));
    }

    private ActivitySplashBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1]);
        this.f10232e = -1;
        this.f10231d = objArr[0];
        this.f10231d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10232e = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10232e != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10232e;
            this.f10232e = 0;
        }
    }
}
