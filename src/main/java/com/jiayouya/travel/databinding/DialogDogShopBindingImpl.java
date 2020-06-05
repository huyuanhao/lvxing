package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;

public class DialogDogShopBindingImpl extends DialogDogShopBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10352d = null;
    /* renamed from: e */
    private static final SparseIntArray f10353e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10354f;
    /* renamed from: g */
    private long f10355g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10353e.put(R.id.tv_icon, 1);
        f10353e.put(R.id.list, 2);
        f10353e.put(R.id.iv_close, 3);
    }

    public DialogDogShopBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f10352d, f10353e));
    }

    private DialogDogShopBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (RecyclerView) objArr[2], (TextView) objArr[1]);
        this.f10355g = -1;
        this.f10354f = objArr[0];
        this.f10354f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10355g = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10355g != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10355g;
            this.f10355g = 0;
        }
    }
}
