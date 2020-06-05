package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.explore.data.TeamItem;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;

public class ItemExploreTeamBindingImpl extends ItemExploreTeamBinding {
    /* renamed from: b */
    private static final IncludedLayouts f11010b = null;
    /* renamed from: c */
    private static final SparseIntArray f11011c = null;
    /* renamed from: d */
    private final FrameLayout f11012d;
    /* renamed from: e */
    private final ImageView f11013e;
    /* renamed from: f */
    private final TextView f11014f;
    /* renamed from: g */
    private long f11015g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemExploreTeamBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f11010b, f11011c));
    }

    private ItemExploreTeamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11015g = -1;
        this.f11012d = objArr[0];
        this.f11012d.setTag(null);
        this.f11013e = objArr[1];
        this.f11013e.setTag(null);
        this.f11014f = objArr[2];
        this.f11014f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11015g = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11015g != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20183a((TeamItem) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20183a(TeamItem teamItem) {
        this.f11009a = teamItem;
        synchronized (this) {
            this.f11015g |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        boolean z;
        int i2;
        int i3;
        synchronized (this) {
            j = this.f11015g;
            this.f11015g = 0;
        }
        TeamItem teamItem = this.f11009a;
        String str = null;
        boolean z2 = false;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (teamItem != null) {
                i3 = teamItem.getDogId();
                i2 = teamItem.getNum();
            } else {
                i3 = 0;
                i2 = 0;
            }
            i = MergeUtil.m14455b(i3);
            z = i3 == -1;
            StringBuilder sb = new StringBuilder();
            sb.append("x");
            sb.append(i2);
            str = sb.toString();
            if (i2 > 0) {
                z2 = true;
            }
        } else {
            z = false;
            i = 0;
        }
        if (i4 != 0) {
            ImageAdapter.m12780a(this.f11013e, Integer.valueOf(i));
            TextViewBindingAdapter.setText(this.f11014f, str);
            ViewAdapter.m12793a((View) this.f11014f, Boolean.valueOf(z2));
            ViewAdapter.m12798c((View) this.f11014f, Boolean.valueOf(z));
        }
    }
}
