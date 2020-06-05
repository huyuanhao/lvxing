package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.kwad.sdk.contentalliance.detail.photo.comment.C3958a.C3964a;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.e */
public class C3968e extends ViewHolder {
    /* renamed from: a */
    private LinearLayout f13357a;
    /* renamed from: b */
    private C3958a f13358b;

    public C3968e(View view, int i) {
        super(view);
        if (i == 0) {
            this.f13358b = (C3958a) view;
        } else if (i == 1) {
            this.f13357a = (LinearLayout) view;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23511a(C3964a aVar) {
        C3958a aVar2 = this.f13358b;
        if (aVar2 != null) {
            aVar2.setData(aVar);
        }
    }
}
