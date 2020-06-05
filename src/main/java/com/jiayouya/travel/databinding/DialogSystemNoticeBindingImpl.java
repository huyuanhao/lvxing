package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.common.data.SystemNotice;

public class DialogSystemNoticeBindingImpl extends DialogSystemNoticeBinding {
    /* renamed from: d */
    private static final IncludedLayouts f10628d = null;
    /* renamed from: e */
    private static final SparseIntArray f10629e = null;
    /* renamed from: f */
    private final LinearLayout f10630f;
    /* renamed from: g */
    private long f10631g;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public DialogSystemNoticeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, f10628d, f10629e));
    }

    private DialogSystemNoticeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[2]);
        this.f10631g = -1;
        this.f10625a.setTag(null);
        this.f10626b.setTag(null);
        this.f10630f = objArr[0];
        this.f10630f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10631g = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10631g != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20141a((SystemNotice) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20141a(SystemNotice systemNotice) {
        this.f10627c = systemNotice;
        synchronized (this) {
            this.f10631g |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10631g;
            this.f10631g = 0;
        }
        boolean z = false;
        String str = null;
        SystemNotice systemNotice = this.f10627c;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i == 0 || systemNotice == null)) {
            z = systemNotice.isForce();
            str = systemNotice.getImage();
        }
        if (i != 0) {
            ImageAdapter.m12782a(this.f10625a, str);
            ViewAdapter.m12798c((View) this.f10626b, Boolean.valueOf(z));
        }
    }
}
