package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.common.data.UserPrivacyRsp;

public class ActivityPrivateBindingImpl extends ActivityPrivateBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10146e = null;
    /* renamed from: f */
    private static final SparseIntArray f10147f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f10148g;
    /* renamed from: h */
    private final TextView f10149h;
    /* renamed from: i */
    private long f10150i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10147f.put(R.id.lyt_container, 4);
    }

    public ActivityPrivateBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10146e, f10147f));
    }

    private ActivityPrivateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[4], (Switch) objArr[2], (Switch) objArr[3]);
        this.f10150i = -1;
        this.f10148g = objArr[0];
        this.f10148g.setTag(null);
        this.f10149h = objArr[1];
        this.f10149h.setTag(null);
        this.f10143b.setTag(null);
        this.f10144c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10150i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10150i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20098a((UserPrivacyRsp) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20098a(UserPrivacyRsp userPrivacyRsp) {
        this.f10145d = userPrivacyRsp;
        synchronized (this) {
            this.f10150i |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        int i2;
        synchronized (this) {
            j = this.f10150i;
            this.f10150i = 0;
        }
        UserPrivacyRsp userPrivacyRsp = this.f10145d;
        boolean z2 = false;
        int i3 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (userPrivacyRsp != null) {
                i = userPrivacyRsp.getParent();
                i2 = userPrivacyRsp.getChildren();
            } else {
                i2 = 0;
                i = 0;
            }
            z = i == 1;
            if (i2 == 1) {
                z2 = true;
            }
        } else {
            z = false;
        }
        if ((j & 2) != 0) {
            ViewAdapter.m12794a((View) this.f10149h, "/me/socialInfo");
        }
        if (i3 != 0) {
            CustomAdapter.m12776a(this.f10143b, Boolean.valueOf(z));
            CustomAdapter.m12776a(this.f10144c, Boolean.valueOf(z2));
        }
    }
}
