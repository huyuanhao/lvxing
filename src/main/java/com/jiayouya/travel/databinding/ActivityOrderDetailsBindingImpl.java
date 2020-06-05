package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class ActivityOrderDetailsBindingImpl extends ActivityOrderDetailsBinding {
    /* renamed from: f */
    private static final IncludedLayouts f10114f = null;
    /* renamed from: g */
    private static final SparseIntArray f10115g = new SparseIntArray();
    /* renamed from: h */
    private final LinearLayout f10116h;
    /* renamed from: i */
    private long f10117i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10115g.put(R.id.refresh, 2);
        f10115g.put(R.id.iv_logo, 3);
        f10115g.put(R.id.tv_speed, 4);
        f10115g.put(R.id.tv_total, 5);
    }

    public ActivityOrderDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f10114f, f10115g));
    }

    private ActivityOrderDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (SmartRefreshLayout) objArr[2], (TextView) objArr[1], (TextView) objArr[4], (TextView) objArr[5]);
        this.f10117i = -1;
        this.f10116h = objArr[0];
        this.f10116h.setTag(null);
        this.f10111c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10117i = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10117i != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10117i;
            this.f10117i = 0;
        }
        if ((j & 1) != 0) {
            TextViewAdapter.m12788b(this.f10111c, "淘宝");
        }
    }
}
