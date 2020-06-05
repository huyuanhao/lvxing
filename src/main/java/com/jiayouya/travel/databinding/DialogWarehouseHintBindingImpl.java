package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.module.travel.data.PositionItem;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import ezy.p653ui.widget.round.RoundText;

public class DialogWarehouseHintBindingImpl extends DialogWarehouseHintBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10727d = null;
    /* renamed from: e */
    private static final SparseIntArray f10728e = new SparseIntArray();
    /* renamed from: f */
    private final LinearLayout f10729f;
    /* renamed from: g */
    private final ImageView f10730g;
    /* renamed from: h */
    private final RoundText f10731h;
    /* renamed from: i */
    private long f10732i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10728e.put(R.id.btn, 3);
        f10728e.put(R.id.iv_close, 4);
    }

    public DialogWarehouseHintBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10727d, f10728e));
    }

    private DialogWarehouseHintBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[3], (ImageView) objArr[4]);
        this.f10732i = -1;
        this.f10729f = objArr[0];
        this.f10729f.setTag(null);
        this.f10730g = objArr[1];
        this.f10730g.setTag(null);
        this.f10731h = objArr[2];
        this.f10731h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10732i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10732i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20149a((PositionItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20149a(PositionItem positionItem) {
        this.f10726c = positionItem;
        synchronized (this) {
            this.f10732i |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.f10732i;
            this.f10732i = 0;
        }
        PositionItem positionItem = this.f10726c;
        String str = null;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (positionItem != null) {
                i2 = positionItem.getDogId();
                i = positionItem.getLevel();
            } else {
                i = 0;
            }
            i2 = MergeUtil.m14455b(i2);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            str = sb.toString();
        }
        if (i3 != 0) {
            ImageAdapter.m12780a(this.f10730g, Integer.valueOf(i2));
            TextViewBindingAdapter.setText(this.f10731h, str);
        }
    }
}
