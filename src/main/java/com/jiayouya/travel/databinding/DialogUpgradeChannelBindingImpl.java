package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;

public class DialogUpgradeChannelBindingImpl extends DialogUpgradeChannelBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10706d = null;
    /* renamed from: e */
    private static final SparseIntArray f10707e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10708f;
    /* renamed from: g */
    private final TextView f10709g;
    /* renamed from: h */
    private long f10710h;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10707e.put(R.id.btn, 2);
        f10707e.put(R.id.iv_close, 3);
    }

    public DialogUpgradeChannelBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f10706d, f10707e));
    }

    private DialogUpgradeChannelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[2], (ImageView) objArr[3]);
        this.f10710h = -1;
        this.f10708f = objArr[0];
        this.f10708f.setTag(null);
        this.f10709g = objArr[1];
        this.f10709g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10710h = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10710h != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (5 != i) {
            return false;
        }
        mo20147a((String) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20147a(String str) {
        this.f10705c = str;
        synchronized (this) {
            this.f10710h |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10710h;
            this.f10710h = 0;
        }
        String str = this.f10705c;
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.f10709g, str);
        }
    }
}
