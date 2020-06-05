package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.module.explore.data.DynamicContentKt;
import com.jiayouya.travel.module.explore.data.DynamicItem;
import com.jiayouya.travel.module.explore.data.ExploreIndexKt;

public class ItemExploreDynamicBindingImpl extends ItemExploreDynamicBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10995e = null;
    /* renamed from: f */
    private static final SparseIntArray f10996f = new SparseIntArray();
    /* renamed from: g */
    private final ConstraintLayout f10997g;
    /* renamed from: h */
    private final TextView f10998h;
    /* renamed from: i */
    private long f10999i;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10996f.put(R.id.tv_name, 4);
    }

    public ItemExploreDynamicBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10995e, f10996f));
    }

    private ItemExploreDynamicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[3]);
        this.f10999i = -1;
        this.f10991a.setTag(null);
        this.f10997g = objArr[0];
        this.f10997g.setTag(null);
        this.f10998h = objArr[2];
        this.f10998h.setTag(null);
        this.f10993c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10999i = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10999i != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20180a((DynamicItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20180a(DynamicItem dynamicItem) {
        this.f10994d = dynamicItem;
        synchronized (this) {
            this.f10999i |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        synchronized (this) {
            j = this.f10999i;
            this.f10999i = 0;
        }
        DynamicItem dynamicItem = this.f10994d;
        String str = null;
        int i = 0;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (dynamicItem != null) {
                i = dynamicItem.getType();
            }
            str = ExploreIndexKt.content(dynamicItem);
            charSequence = ExploreIndexKt.timeText(dynamicItem);
            i = DynamicContentKt.dynamicTypeImage(i);
        } else {
            charSequence = null;
        }
        if (i2 != 0) {
            ImageAdapter.m12780a(this.f10991a, Integer.valueOf(i));
            TextViewBindingAdapter.setText(this.f10998h, str);
            TextViewBindingAdapter.setText(this.f10993c, charSequence);
        }
    }
}
