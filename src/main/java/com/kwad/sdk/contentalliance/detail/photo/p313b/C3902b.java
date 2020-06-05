package com.kwad.sdk.contentalliance.detail.photo.p313b;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel;
import com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.C3957a;
import com.kwad.sdk.contentalliance.detail.photo.p314c.C3940e.C3941a;
import com.kwad.sdk.contentalliance.detail.video.C3987c;
import com.kwad.sdk.contentalliance.detail.video.C3988d;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.core.response.model.AdTemplate;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.b */
public class C3902b extends C3872b {
    /* renamed from: c */
    OnKeyListener f13198c = new OnKeyListener() {
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            C3902b.this.m16205g();
            return true;
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: d */
    public CommentListPanel f13199d;
    /* renamed from: e */
    private C3987c f13200e = new C3988d() {
        /* renamed from: b */
        public void mo23349b() {
            C3902b.this.m16205g();
        }
    };
    /* renamed from: f */
    private C3828a f13201f = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            C3902b.this.m16205g();
        }
    };
    /* renamed from: g */
    private C3957a f13202g = new C3957a() {
        /* renamed from: a */
        public void mo23414a() {
            C3902b.this.m16205g();
        }
    };
    /* renamed from: h */
    private C3941a f13203h = new C3941a() {
        /* renamed from: a */
        public void mo23415a(AdTemplate adTemplate, long j) {
            C3902b.this.f13199d.mo23475a(adTemplate, j);
            C3902b.this.f13199d.mo23473a();
            C3902b.this.m16206h();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16205g() {
        this.f13125b.f13131e = false;
        if (this.f13199d.getVisibility() == 0) {
            this.f13199d.setVisibility(8);
            this.f13199d.setFocusableInTouchMode(false);
            this.f13199d.setOnKeyListener(null);
            this.f13199d.mo23480c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16206h() {
        this.f13199d.setVisibility(0);
        this.f13199d.setFocusableInTouchMode(true);
        this.f13199d.requestFocus();
        this.f13199d.setOnKeyListener(this.f13198c);
        this.f13125b.f13131e = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13125b.f13127a.add(this.f13201f);
        this.f13125b.f13135i.mo23556a(this.f13200e);
        this.f13125b.f13130d.add(this.f13203h);
        this.f13199d.mo23474a(this.f13202g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13199d = (CommentListPanel) mo24760a("ksad_photo_comment_list_panel");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13125b.f13127a.remove(this.f13201f);
        this.f13125b.f13130d.remove(this.f13203h);
        m16205g();
        this.f13199d.mo23479b(this.f13202g);
    }
}
