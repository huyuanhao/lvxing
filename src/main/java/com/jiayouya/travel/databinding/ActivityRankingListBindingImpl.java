package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.viewpager.widget.ViewPager;
import com.jiayouya.travel.R;
import ezy.p653ui.widget.CenteredTitleBar;
import ezy.p653ui.widget.round.RoundText;
import net.lucode.hackware.magicindicator.MagicIndicator;

public class ActivityRankingListBindingImpl extends ActivityRankingListBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10155e = null;
    /* renamed from: f */
    private static final SparseIntArray f10156f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f10157g;
    /* renamed from: h */
    private long f10158h;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        f10156f.put(R.id.lyt_tab, 1);
        f10156f.put(R.id.view_pager, 2);
        f10156f.put(R.id.toolbar, 3);
        f10156f.put(R.id.btn_share, 4);
    }

    public ActivityRankingListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, f10155e, f10156f));
    }

    private ActivityRankingListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[4], (MagicIndicator) objArr[1], (CenteredTitleBar) objArr[3], (ViewPager) objArr[2]);
        this.f10158h = -1;
        this.f10157g = objArr[0];
        this.f10157g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10158h = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10158h != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.f10158h;
            this.f10158h = 0;
        }
    }
}
