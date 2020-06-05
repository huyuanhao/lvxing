package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import ezy.p653ui.widget.round.RoundText;

public class ActivityRealNameAuthBindingImpl extends ActivityRealNameAuthBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10162d = null;
    /* renamed from: e */
    private static final SparseIntArray f10163e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10164f;
    /* renamed from: g */
    private final LinearLayout f10165g;
    /* renamed from: h */
    private final LinearLayout f10166h;
    /* renamed from: i */
    private long f10167i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10163e.put(R.id.lyt_container, 3);
        f10163e.put(R.id.btn, 4);
    }

    public ActivityRealNameAuthBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10162d, f10163e));
    }

    private ActivityRealNameAuthBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[4], (FrameLayout) objArr[3]);
        this.f10167i = -1;
        this.f10164f = objArr[0];
        this.f10164f.setTag(null);
        this.f10165g = objArr[1];
        this.f10165g.setTag(null);
        this.f10166h = objArr[2];
        this.f10166h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10167i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10167i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (9 != i) {
            return false;
        }
        mo20099a(((Boolean) obj).booleanValue());
        return true;
    }

    /* renamed from: a */
    public void mo20099a(boolean z) {
        this.f10161c = z;
        synchronized (this) {
            this.f10167i |= 1;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10167i;
            this.f10167i = 0;
        }
        boolean z = this.f10161c;
        boolean z2 = false;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            z2 = !z;
        }
        if (i != 0) {
            ViewAdapter.m12798c((View) this.f10165g, Boolean.valueOf(z));
            ViewAdapter.m12798c((View) this.f10166h, Boolean.valueOf(z2));
        }
    }
}
