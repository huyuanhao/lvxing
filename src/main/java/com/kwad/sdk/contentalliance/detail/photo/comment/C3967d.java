package com.kwad.sdk.contentalliance.detail.photo.comment;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.d */
public class C3967d {
    /* renamed from: a */
    private long f13352a;
    /* renamed from: b */
    private PhotoInfo f13353b;
    /* renamed from: c */
    private AdTemplate f13354c;
    /* renamed from: d */
    private long f13355d;
    /* renamed from: e */
    private List<PhotoComment> f13356e;

    public C3967d(AdTemplate adTemplate, long j) {
        this.f13354c = adTemplate;
        this.f13352a = C4324c.m17665b(adTemplate);
        this.f13353b = C4324c.m17669f(adTemplate);
        this.f13355d = j;
    }

    /* renamed from: a */
    public AdTemplate mo23504a() {
        return this.f13354c;
    }

    /* renamed from: a */
    public void mo23505a(List<PhotoComment> list) {
        this.f13356e = list;
    }

    /* renamed from: b */
    public long mo23506b() {
        return C4325d.m17680i(this.f13353b);
    }

    /* renamed from: c */
    public long mo23507c() {
        return this.f13352a;
    }

    /* renamed from: d */
    public long mo23508d() {
        return this.f13355d;
    }

    /* renamed from: e */
    public List<PhotoComment> mo23509e() {
        return this.f13356e;
    }

    /* renamed from: f */
    public int mo23510f() {
        List<PhotoComment> list = this.f13356e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
