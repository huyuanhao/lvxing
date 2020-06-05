package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.explore.data.DynamicContent;
import com.jiayouya.travel.module.explore.data.DynamicContentKt;

public class ItemDynamicContentBindingImpl extends ItemDynamicContentBinding {
    /* renamed from: b */
    private static final IncludedLayouts f10977b = null;
    /* renamed from: c */
    private static final SparseIntArray f10978c = null;
    /* renamed from: d */
    private final LinearLayout f10979d;
    /* renamed from: e */
    private final View f10980e;
    /* renamed from: f */
    private final ImageView f10981f;
    /* renamed from: g */
    private final TextView f10982g;
    /* renamed from: h */
    private final TextView f10983h;
    /* renamed from: i */
    private final TextView f10984i;
    /* renamed from: j */
    private long f10985j;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemDynamicContentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f10977b, f10978c));
    }

    private ItemDynamicContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10985j = -1;
        this.f10979d = objArr[0];
        this.f10979d.setTag(null);
        this.f10980e = objArr[1];
        this.f10980e.setTag(null);
        this.f10981f = objArr[2];
        this.f10981f.setTag(null);
        this.f10982g = objArr[3];
        this.f10982g.setTag(null);
        this.f10983h = objArr[4];
        this.f10983h.setTag(null);
        this.f10984i = objArr[5];
        this.f10984i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10985j = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10985j != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20178a((DynamicContent) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20178a(DynamicContent dynamicContent) {
        this.f10976a = dynamicContent;
        synchronized (this) {
            this.f10985j |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        int i;
        int i2;
        synchronized (this) {
            j = this.f10985j;
            this.f10985j = 0;
        }
        DynamicContent dynamicContent = this.f10976a;
        String str = null;
        boolean z = false;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            i2 = DynamicContentKt.image(dynamicContent);
            str = DynamicContentKt.content(dynamicContent);
            i = DynamicContentKt.marginTop(dynamicContent);
            charSequence = DynamicContentKt.time(dynamicContent);
            if (dynamicContent != null) {
                z = dynamicContent.isFirst();
            }
            z = !z;
        } else {
            charSequence = null;
            i2 = 0;
            i = 0;
        }
        if (i3 != 0) {
            ViewAdapter.m12798c(this.f10980e, Boolean.valueOf(z));
            ImageAdapter.m12780a(this.f10981f, Integer.valueOf(i2));
            ViewAdapter.m12790a((View) this.f10982g, i);
            ViewAdapter.m12790a((View) this.f10983h, i);
            TextViewBindingAdapter.setText(this.f10983h, str);
            ViewAdapter.m12790a((View) this.f10984i, i);
            TextViewBindingAdapter.setText(this.f10984i, charSequence);
        }
    }
}
