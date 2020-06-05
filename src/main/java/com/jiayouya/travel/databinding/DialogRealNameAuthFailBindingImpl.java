package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;

public class DialogRealNameAuthFailBindingImpl extends DialogRealNameAuthFailBinding {
    /* renamed from: c */
    private static final IncludedLayouts f10579c = null;
    /* renamed from: d */
    private static final SparseIntArray f10580d = new SparseIntArray();
    /* renamed from: e */
    private final LinearLayout f10581e;
    /* renamed from: f */
    private final TextView f10582f;
    /* renamed from: g */
    private long f10583g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10580d.put(R.id.btn, 2);
    }

    public DialogRealNameAuthFailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10579c, f10580d));
    }

    private DialogRealNameAuthFailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2]);
        this.f10583g = -1;
        this.f10581e = objArr[0];
        this.f10581e.setTag(null);
        this.f10582f = objArr[1];
        this.f10582f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10583g = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10583g != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (27 != i) {
            return false;
        }
        mo20136a((String) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20136a(String str) {
        this.f10578b = str;
        synchronized (this) {
            this.f10583g |= 1;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10583g;
            this.f10583g = 0;
        }
        CharSequence charSequence = null;
        String str = this.f10578b;
        boolean z = false;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (str == null) {
                z = true;
            }
            if (i != 0) {
                j |= z ? 8 : 4;
            }
        }
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            charSequence = z ? "支付宝未实名，认证不通过" : str;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f10582f, charSequence);
        }
    }
}
