package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.contentalliance.detail.photo.comment.C3958a.C3964a;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3811n;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.c */
public class C3966c extends C3969f<C3968e, PhotoComment> {
    /* renamed from: c */
    private long f13350c;
    /* renamed from: d */
    private List<C3964a> f13351d = new ArrayList();

    public C3966c(RecyclerView recyclerView, C3967d dVar) {
        super(recyclerView.getContext());
        mo23512a(dVar.mo23509e());
        if (dVar.mo23509e() != null) {
            for (int i = 0; i < dVar.mo23510f(); i++) {
                PhotoComment photoComment = (PhotoComment) dVar.mo23509e().get(i);
                C3964a aVar = new C3964a();
                aVar.f13342a = photoComment;
                aVar.f13343b = dVar.mo23504a();
                aVar.f13344c = dVar.mo23508d();
                aVar.f13346e = i;
                aVar.f13348g = C3811n.m15816c(photoComment.content);
                this.f13351d.add(aVar);
            }
        }
    }

    /* renamed from: a */
    private void m16413a(int i) {
        long j = (long) i;
        if (j > this.f13350c) {
            this.f13350c = j;
        }
    }

    /* renamed from: a */
    public long mo23501a() {
        return this.f13350c;
    }

    /* renamed from: a */
    public C3968e onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C3968e(i == 0 ? new C3958a(this.f13359a) : LayoutInflater.from(this.f13359a).inflate(C3809l.m15792b(this.f13359a, "ksad_photo_comment_list_footer"), viewGroup, false), i);
    }

    /* renamed from: a */
    public void onBindViewHolder(C3968e eVar, int i) {
        if (getItemViewType(i) == 0) {
            eVar.mo23511a((C3964a) this.f13351d.get(i));
        }
    }

    public int getItemViewType(int i) {
        m16413a(i);
        return i == getItemCount() - 1 ? 1 : 0;
    }
}
