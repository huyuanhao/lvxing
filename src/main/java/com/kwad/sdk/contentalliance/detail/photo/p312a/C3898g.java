package com.kwad.sdk.contentalliance.detail.photo.p312a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.contentalliance.detail.photo.p314c.C3937b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.request.C4304k;
import com.kwad.sdk.core.request.C4304k.C4309a;
import com.kwad.sdk.core.response.model.PhotoShareInfo;
import com.kwad.sdk.p306a.C3796b;
import com.kwad.sdk.p306a.C3801f;
import com.kwad.sdk.protocol.model.AdScene;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.a.g */
public class C3898g extends C3886a {
    /* renamed from: c */
    public C3894d f13192c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C3937b f13193d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f13194e = false;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13192c = this.f13167a.f13179a;
        this.f13193d = this.f13167a.f13180b;
        C4145c.m17169d(this.f13192c.mo23397a(), this.f13192c.mo23400d());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13193d = null;
    }

    /* renamed from: g */
    public LinearLayout mo23408g() {
        C3897f fVar = new C3897f(mo24770p());
        fVar.setButtonImageResource("ksad_func_button_photo_share");
        fVar.setButtonText("复制链接");
        return fVar;
    }

    public void onClick(View view) {
        C3894d dVar = this.f13192c;
        if (dVar != null) {
            if (this.f13194e) {
                StringBuilder sb = new StringBuilder();
                sb.append("mIsRequesting= ");
                sb.append(this.f13194e);
                C4065b.m16863a("PhotoShareButtonPresenter", sb.toString());
                return;
            }
            this.f13194e = true;
            new C4304k().mo24427a(new AdScene(dVar.mo23399c()), this.f13192c.mo23398b(), (C4309a) new C4309a() {
                /* renamed from: a */
                public void mo23410a(int i, String str) {
                    Context context;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onError() code=");
                    sb.append(i);
                    sb.append(" msg=");
                    sb.append(str);
                    C4065b.m16863a("PhotoShareButtonPresenter", sb.toString());
                    if (i == 100007) {
                        context = C3898g.this.mo24770p();
                    } else {
                        context = C3898g.this.mo24770p();
                        str = "复制链接失败，请稍后重试";
                    }
                    C3801f.m15757a(context, str);
                    if (C3898g.this.f13193d != null) {
                        C3898g.this.f13193d.mo23391a(C3898g.this);
                    }
                    C4145c.m17162a(C3898g.this.f13192c.mo23397a(), C3898g.this.f13192c.mo23400d(), false);
                    C3898g.this.f13194e = false;
                }

                /* renamed from: a */
                public void mo23411a(PhotoShareInfo photoShareInfo) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onLoad() shareUrl=");
                    sb.append(photoShareInfo.getShareUrl());
                    C4065b.m16863a("PhotoShareButtonPresenter", sb.toString());
                    C3796b.m15732a(C3898g.this.mo24770p(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                    C3801f.m15757a(C3898g.this.mo24770p(), "链接已经复制\n快分享给好友吧");
                    if (C3898g.this.f13193d != null) {
                        C3898g.this.f13193d.mo23391a(C3898g.this);
                    }
                    C4145c.m17162a(C3898g.this.f13192c.mo23397a(), C3898g.this.f13192c.mo23400d(), true);
                    C3898g.this.f13194e = false;
                }
            });
        }
    }
}
