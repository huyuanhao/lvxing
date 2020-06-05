package com.yanzhenjie.album.widget.divider;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.State;

public class Api21ItemDivider extends Divider {
    /* renamed from: a */
    private final int f26351a;
    /* renamed from: b */
    private final int f26352b;
    /* renamed from: c */
    private final Drawer f26353c;

    public Api21ItemDivider(int i, int i2, int i3) {
        this.f26351a = Math.round(((float) i2) / 2.0f);
        this.f26352b = Math.round(((float) i3) / 2.0f);
        this.f26353c = new ColorDrawer(i, this.f26351a, this.f26352b);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        int i = this.f26351a;
        int i2 = this.f26352b;
        rect.set(i, i2, i, i2);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        canvas.save();
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = layoutManager.getChildAt(i);
            this.f26353c.mo37723a(childAt, canvas);
            this.f26353c.mo37724b(childAt, canvas);
            this.f26353c.mo37725c(childAt, canvas);
            this.f26353c.mo37726d(childAt, canvas);
        }
        canvas.restore();
    }
}
