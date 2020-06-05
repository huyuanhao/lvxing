package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;

public class ActivityOnlineServiceBindingImpl extends ActivityOnlineServiceBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10099c = null;
    /* renamed from: d */
    private static final SparseIntArray f10100d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10101e;
    /* renamed from: f */
    private long f10102f;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10100d.put(R.id.iv_qr_code, 1);
        f10100d.put(R.id.btn, 2);
    }

    public ActivityOnlineServiceBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10099c, f10100d));
    }

    private ActivityOnlineServiceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[2], (ImageView) objArr[1]);
        this.f10102f = -1;
        this.f10101e = objArr[0];
        this.f10101e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10102f = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10102f != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10102f;
            this.f10102f = 0;
        }
    }
}
