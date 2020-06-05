package com.jiayouya.travel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import ezy.p653ui.widget.round.RoundText;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class DialogGetMaxLevelDogBindingImpl extends DialogGetMaxLevelDogBinding {
    /* renamed from: f */
    private static final IncludedLayouts f10432f = null;
    /* renamed from: g */
    private static final SparseIntArray f10433g = new SparseIntArray();
    /* renamed from: h */
    private final LinearLayout f10434h;
    /* renamed from: i */
    private final ImageView f10435i;
    /* renamed from: j */
    private final RoundText f10436j;
    /* renamed from: k */
    private final TextView f10437k;
    /* renamed from: l */
    private final TextView f10438l;
    /* renamed from: m */
    private long f10439m;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10433g.put(R.id.iv_close, 5);
        f10433g.put(R.id.btn, 6);
    }

    public DialogGetMaxLevelDogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f10432f, f10433g));
    }

    private DialogGetMaxLevelDogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[6], (ImageView) objArr[5]);
        this.f10439m = -1;
        this.f10434h = objArr[0];
        this.f10434h.setTag(null);
        this.f10435i = objArr[1];
        this.f10435i.setTag(null);
        this.f10436j = objArr[2];
        this.f10436j.setTag(null);
        this.f10437k = objArr[3];
        this.f10437k.setTag(null);
        this.f10438l = objArr[4];
        this.f10438l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10439m = 8;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10439m != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (25 == i) {
            mo20119a(((Integer) obj).intValue());
        } else if (35 == i) {
            mo20121b((String) obj);
        } else if (30 != i) {
            return false;
        } else {
            mo20120a((String) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20119a(int i) {
        this.f10429c = i;
        synchronized (this) {
            this.f10439m |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* renamed from: b */
    public void mo20121b(String str) {
        this.f10431e = str;
        synchronized (this) {
            this.f10439m |= 2;
        }
        notifyPropertyChanged(35);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20120a(String str) {
        this.f10430d = str;
        synchronized (this) {
            this.f10439m |= 4;
        }
        notifyPropertyChanged(30);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10439m;
            this.f10439m = 0;
        }
        int i = this.f10429c;
        String str = this.f10431e;
        String str2 = this.f10430d;
        int i2 = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        int i3 = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        boolean isEmpty = i3 != 0 ? TextUtils.isEmpty(str) : false;
        int i4 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        String string = i4 != 0 ? this.f10437k.getResources().getString(R.string.c33_and_red, new Object[]{"恭喜您获得", str2}) : null;
        if (i2 != 0) {
            ImageAdapter.m12781a(this.f10435i, Integer.valueOf(i), 0, (CornerType) null, (Integer) null);
        }
        if ((j & 8) != 0) {
            TextViewBindingAdapter.setText(this.f10436j, "Lv.38");
        }
        if (i4 != 0) {
            TextViewAdapter.m12787a(this.f10437k, string);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.f10438l, str);
            ViewAdapter.m12798c((View) this.f10438l, Boolean.valueOf(isEmpty));
        }
    }
}
