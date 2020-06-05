package com.kwad.sdk.contentalliance.detail.photo.p313b;

import android.view.View;
import android.view.View.OnClickListener;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.detail.photo.PhotoBottomView;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.a */
public class C3900a extends C3872b {
    /* renamed from: c */
    private PhotoBottomView f13196c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        PhotoInfo f = C4324c.m17669f(this.f13125b.f13133g);
        String o = C4325d.m17686o(f);
        String n = C4325d.m17685n(f);
        String p = C4325d.m17687p(f);
        this.f13196c.setAuthorIcon(o);
        this.f13196c.setAuthorName(n);
        this.f13196c.setPhotoDescribe(p);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13196c = (PhotoBottomView) mo24760a("ksad_photo_detail_bottom");
        this.f13196c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
    }
}
