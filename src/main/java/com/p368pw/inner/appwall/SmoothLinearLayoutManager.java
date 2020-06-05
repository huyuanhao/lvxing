package com.p368pw.inner.appwall;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;

/* renamed from: com.pw.inner.appwall.SmoothLinearLayoutManager */
public class SmoothLinearLayoutManager extends LinearLayoutManager {
    public SmoothLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        C49681 r2 = new LinearSmoothScroller(recyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 0.3f;
            }
        };
        r2.setTargetPosition(i);
        startSmoothScroll(r2);
    }
}
