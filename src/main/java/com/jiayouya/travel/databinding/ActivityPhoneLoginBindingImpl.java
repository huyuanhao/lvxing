package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import ezy.p653ui.widget.round.RoundText;

public class ActivityPhoneLoginBindingImpl extends ActivityPhoneLoginBinding {
    /* renamed from: f */
    private static final IncludedLayouts f10135f = null;
    /* renamed from: g */
    private static final SparseIntArray f10136g = new SparseIntArray();
    /* renamed from: h */
    private final LinearLayout f10137h;
    /* renamed from: i */
    private final TextView f10138i;
    /* renamed from: j */
    private final LinearLayout f10139j;
    /* renamed from: k */
    private final View f10140k;
    /* renamed from: l */
    private long f10141l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10136g.put(R.id.edit_phone, 5);
        f10136g.put(R.id.edit_code, 6);
        f10136g.put(R.id.btn, 7);
    }

    public ActivityPhoneLoginBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, f10135f, f10136g));
    }

    private ActivityPhoneLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[7], (RoundText) objArr[1], (EditText) objArr[6], (EditText) objArr[5]);
        this.f10141l = -1;
        this.f10131b.setTag(null);
        this.f10137h = objArr[0];
        this.f10137h.setTag(null);
        this.f10138i = objArr[2];
        this.f10138i.setTag(null);
        this.f10139j = objArr[3];
        this.f10139j.setTag(null);
        this.f10140k = objArr[4];
        this.f10140k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10141l = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10141l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (32 != i) {
            return false;
        }
        mo20097a(((Integer) obj).intValue());
        return true;
    }

    /* renamed from: a */
    public void mo20097a(int i) {
        this.f10134e = i;
        synchronized (this) {
            this.f10141l |= 1;
        }
        notifyPropertyChanged(32);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        synchronized (this) {
            j = this.f10141l;
            this.f10141l = 0;
        }
        int i = this.f10134e;
        boolean z2 = false;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            z = i != 0;
            if (i != 1) {
                z2 = true;
            }
        } else {
            z = false;
        }
        if (i2 != 0) {
            ViewAdapter.m12798c((View) this.f10131b, Boolean.valueOf(z2));
            ViewAdapter.m12798c((View) this.f10138i, Boolean.valueOf(z));
            ViewAdapter.m12798c((View) this.f10139j, Boolean.valueOf(z2));
            ViewAdapter.m12798c(this.f10140k, Boolean.valueOf(z2));
        }
    }
}
