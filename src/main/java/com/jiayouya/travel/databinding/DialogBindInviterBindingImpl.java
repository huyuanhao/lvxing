package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import ezy.p653ui.widget.round.RoundText;

public class DialogBindInviterBindingImpl extends DialogBindInviterBinding {
    /* renamed from: f */
    private static final IncludedLayouts f10271f = null;
    /* renamed from: g */
    private static final SparseIntArray f10272g = new SparseIntArray();
    /* renamed from: h */
    private final LinearLayout f10273h;
    /* renamed from: i */
    private final TextView f10274i;
    /* renamed from: j */
    private long f10275j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10272g.put(R.id.edit_code, 3);
        f10272g.put(R.id.btn, 4);
        f10272g.put(R.id.tv_no_code, 5);
    }

    public DialogBindInviterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f10271f, f10272g));
    }

    private DialogBindInviterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[4], (EditText) objArr[3], (ImageView) objArr[1], (TextView) objArr[5]);
        this.f10275j = -1;
        this.f10268c.setTag(null);
        this.f10273h = objArr[0];
        this.f10273h.setTag(null);
        this.f10274i = objArr[2];
        this.f10274i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10275j = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10275j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (18 != i) {
            return false;
        }
        mo20105a(((Boolean) obj).booleanValue());
        return true;
    }

    /* renamed from: a */
    public void mo20105a(boolean z) {
        this.f10270e = z;
        synchronized (this) {
            this.f10275j |= 1;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10275j;
            this.f10275j = 0;
        }
        int i = 0;
        boolean z = this.f10270e;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (i2 != 0) {
                j |= z ? 8 : 4;
            }
            i = z ? 30 : -20;
        }
        if ((j & 3) != 0) {
            ViewAdapter.m12798c((View) this.f10268c, Boolean.valueOf(z));
            ViewAdapter.m12790a((View) this.f10274i, i);
        }
    }
}
