package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.round.RoundText;

public class ActivitySocialInformationBindingImpl extends ActivitySocialInformationBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10224e = null;
    /* renamed from: f */
    private static final SparseIntArray f10225f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f10226g;
    /* renamed from: h */
    private long f10227h;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10225f.put(R.id.lyt_container, 1);
        f10225f.put(R.id.edit_wx, 2);
        f10225f.put(R.id.edit_qq, 3);
        f10225f.put(R.id.btn_save, 4);
    }

    public ActivitySocialInformationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10224e, f10225f));
    }

    private ActivitySocialInformationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[4], (EditText) objArr[3], (EditText) objArr[2], (RelativeLayout) objArr[1]);
        this.f10227h = -1;
        this.f10226g = objArr[0];
        this.f10226g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10227h = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10227h != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10227h;
            this.f10227h = 0;
        }
    }
}
