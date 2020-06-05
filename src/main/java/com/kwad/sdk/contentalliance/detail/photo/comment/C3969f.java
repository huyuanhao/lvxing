package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.f */
public abstract class C3969f<VH extends ViewHolder, T> extends Adapter<VH> {
    /* renamed from: a */
    protected Context f13359a;
    /* renamed from: b */
    protected List<T> f13360b = new ArrayList();

    public C3969f(Context context) {
        this.f13359a = context;
    }

    /* renamed from: a */
    public void mo23512a(List<T> list) {
        if (list != null) {
            this.f13360b.clear();
            this.f13360b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.f13360b.size() + 1;
    }
}
