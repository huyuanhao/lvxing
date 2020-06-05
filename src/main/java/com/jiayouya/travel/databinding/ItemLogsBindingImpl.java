package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.module.assets.data.LogsItem;

public class ItemLogsBindingImpl extends ItemLogsBinding {
    /* renamed from: b */
    private static final IncludedLayouts f11048b = null;
    /* renamed from: c */
    private static final SparseIntArray f11049c = null;
    /* renamed from: d */
    private final LinearLayout f11050d;
    /* renamed from: e */
    private final TextView f11051e;
    /* renamed from: f */
    private final TextView f11052f;
    /* renamed from: g */
    private final TextView f11053g;
    /* renamed from: h */
    private long f11054h;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemLogsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, f11048b, f11049c));
    }

    private ItemLogsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11054h = -1;
        this.f11050d = objArr[0];
        this.f11050d.setTag(null);
        this.f11051e = objArr[1];
        this.f11051e.setTag(null);
        this.f11052f = objArr[2];
        this.f11052f.setTag(null);
        this.f11053g = objArr[3];
        this.f11053g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11054h = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11054h != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20188a((LogsItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20188a(LogsItem logsItem) {
        this.f11047a = logsItem;
        synchronized (this) {
            this.f11054h |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        String str;
        synchronized (this) {
            j = this.f11054h;
            this.f11054h = 0;
        }
        LogsItem logsItem = this.f11047a;
        String str2 = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i == 0 || logsItem == null) {
            str = null;
            charSequence = null;
        } else {
            str2 = logsItem.getTitle();
            str = logsItem.getValue();
            charSequence = logsItem.getTime();
        }
        if (i != 0) {
            TextViewAdapter.m12787a(this.f11051e, str2);
            TextViewBindingAdapter.setText(this.f11052f, charSequence);
            TextViewAdapter.m12787a(this.f11053g, str);
        }
    }
}
