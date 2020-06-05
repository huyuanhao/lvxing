package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.common.data.AdRsp;
import ezy.p653ui.widget.round.RoundLayout;

public class DialogLuckTicketBindingImpl extends DialogLuckTicketBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10478d = null;
    /* renamed from: e */
    private static final SparseIntArray f10479e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10480f;
    /* renamed from: g */
    private final TextView f10481g;
    /* renamed from: h */
    private long f10482h;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10479e.put(R.id.iv_close, 2);
        f10479e.put(R.id.btn, 3);
    }

    public DialogLuckTicketBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f10478d, f10479e));
    }

    private DialogLuckTicketBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundLayout) objArr[3], (ImageView) objArr[2]);
        this.f10482h = -1;
        this.f10480f = objArr[0];
        this.f10480f.setTag(null);
        this.f10481g = objArr[1];
        this.f10481g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10482h = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10482h != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (21 != i) {
            return false;
        }
        mo20127a((AdRsp) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20127a(AdRsp adRsp) {
        this.f10477c = adRsp;
        synchronized (this) {
            this.f10482h |= 1;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10482h;
            this.f10482h = 0;
        }
        int i = 0;
        AdRsp adRsp = this.f10477c;
        String str = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (adRsp != null) {
                i = adRsp.getAdNumVideo();
                str = adRsp.getAdDesc();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("(剩余");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(i);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append("次)");
            str = sb5.toString();
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f10481g, str);
        }
    }
}
