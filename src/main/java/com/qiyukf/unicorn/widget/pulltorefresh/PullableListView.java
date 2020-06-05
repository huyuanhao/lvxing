package com.qiyukf.unicorn.widget.pulltorefresh;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ListView;

public class PullableListView extends ListView implements C6377a {
    /* renamed from: a */
    private boolean f19905a = false;
    /* renamed from: b */
    private boolean f19906b = false;

    public PullableListView(Context context) {
        super(context);
    }

    public PullableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: b */
    private boolean m25048b(int i) {
        if (VERSION.SDK_INT >= 14) {
            return canScrollVertically(i);
        }
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int computeVerticalScrollRange = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange - 1;
    }

    /* renamed from: a */
    public final void mo29621a(int i) {
        smoothScrollBy(i, 0);
    }

    /* renamed from: a */
    public final void mo29622a(boolean z) {
        this.f19905a = false;
        this.f19906b = z;
    }

    /* renamed from: a */
    public final boolean mo29623a() {
        return this.f19905a && !m25048b(-1);
    }

    /* renamed from: b */
    public final boolean mo29624b() {
        return this.f19906b && !m25048b(1);
    }
}
