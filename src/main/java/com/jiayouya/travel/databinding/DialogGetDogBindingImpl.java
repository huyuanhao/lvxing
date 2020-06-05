package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import ezy.p653ui.widget.round.RoundText;

public class DialogGetDogBindingImpl extends DialogGetDogBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10421e = null;
    /* renamed from: f */
    private static final SparseIntArray f10422f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f10423g;
    /* renamed from: h */
    private final TextView f10424h;
    /* renamed from: i */
    private final ImageView f10425i;
    /* renamed from: j */
    private long f10426j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10422f.put(R.id.btn_confirm, 3);
        f10422f.put(R.id.btn_cancel, 4);
        f10422f.put(R.id.iv_close, 5);
    }

    public DialogGetDogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f10421e, f10422f));
    }

    private DialogGetDogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[4], (RoundText) objArr[3], (ImageView) objArr[5]);
        this.f10426j = -1;
        this.f10423g = objArr[0];
        this.f10423g.setTag(null);
        this.f10424h = objArr[1];
        this.f10424h.setTag(null);
        this.f10425i = objArr[2];
        this.f10425i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10426j = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10426j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (4 != i) {
            return false;
        }
        mo20118a(((Integer) obj).intValue());
        return true;
    }

    /* renamed from: a */
    public void mo20118a(int i) {
        this.f10420d = i;
        synchronized (this) {
            this.f10426j |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.f10426j;
            this.f10426j = 0;
        }
        int i2 = this.f10420d;
        String str = null;
        boolean z = false;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (i2 == 38) {
                z = true;
            }
            i = MergeUtil.m14452a(i2);
            if (i3 != 0) {
                j |= z ? 8 : 4;
            }
            str = z ? "是否移至狗窝" : "是否移至仓库";
        } else {
            i = 0;
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.f10424h, str);
            ImageAdapter.m12780a(this.f10425i, Integer.valueOf(i));
        }
    }
}
