package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.viewpager.widget.ViewPager;
import com.jiayouya.travel.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

public class ActivityOrderBindingImpl extends ActivityOrderBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10105c = null;
    /* renamed from: d */
    private static final SparseIntArray f10106d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10107e;
    /* renamed from: f */
    private long f10108f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10106d.put(R.id.lyt_tab, 1);
        f10106d.put(R.id.view_pager, 2);
    }

    public ActivityOrderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10105c, f10106d));
    }

    private ActivityOrderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MagicIndicator) objArr[1], (ViewPager) objArr[2]);
        this.f10108f = -1;
        this.f10107e = objArr[0];
        this.f10107e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10108f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10108f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10108f;
            this.f10108f = 0;
        }
    }
}
