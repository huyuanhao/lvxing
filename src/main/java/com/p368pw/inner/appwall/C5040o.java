package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.p368pw.inner.base.p387d.C5191i;

/* renamed from: com.pw.inner.appwall.o */
public class C5040o extends ItemDecoration {
    /* renamed from: a */
    private int f16431a;
    /* renamed from: b */
    private boolean f16432b;

    public C5040o(int i) {
        this.f16431a = i;
    }

    /* renamed from: a */
    private boolean m21034a(int i) {
        return i == 0;
    }

    /* renamed from: a */
    private boolean m21035a(int i, RecyclerView recyclerView) {
        return i == recyclerView.getAdapter().getItemCount() - 1;
    }

    /* renamed from: a */
    public C5040o mo26477a(boolean z) {
        this.f16432b = z;
        return this;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int viewLayoutPosition = ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        Context applicationContext = recyclerView.getContext().getApplicationContext();
        int b = C5191i.m21391b(applicationContext, 10);
        if (m21034a(viewLayoutPosition)) {
            if (this.f16432b) {
                rect.set(b, b, b, 0);
            } else {
                rect.set(0, 0, 0, this.f16431a);
            }
        } else if (childViewHolder instanceof C5027h) {
            rect.set(0, C5191i.m21391b(applicationContext, 20), 0, 0);
        } else if ((childViewHolder instanceof C5023d) || (childViewHolder instanceof C5028i)) {
            rect.set(0, b, 0, 0);
        }
        if (m21035a(viewLayoutPosition, recyclerView)) {
            rect.bottom = b;
        }
        if (!m21034a(viewLayoutPosition)) {
            rect.left = b;
            rect.right = b;
        }
    }
}
