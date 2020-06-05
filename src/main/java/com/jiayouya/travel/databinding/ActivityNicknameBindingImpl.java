package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;

public class ActivityNicknameBindingImpl extends ActivityNicknameBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10087d = null;
    /* renamed from: e */
    private static final SparseIntArray f10088e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10089f;
    /* renamed from: g */
    private long f10090g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10088e.put(R.id.tv_title_right, 1);
        f10088e.put(R.id.edit_nickname, 2);
        f10088e.put(R.id.iv_clear, 3);
    }

    public ActivityNicknameBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f10087d, f10088e));
    }

    private ActivityNicknameBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[2], (ImageView) objArr[3], (TextView) objArr[1]);
        this.f10090g = -1;
        this.f10089f = objArr[0];
        this.f10089f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10090g = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10090g != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10090g;
            this.f10090g = 0;
        }
    }
}
