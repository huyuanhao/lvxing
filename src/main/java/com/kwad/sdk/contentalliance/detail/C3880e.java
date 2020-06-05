package com.kwad.sdk.contentalliance.detail;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ksad.download.p297c.C3607b;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3801f;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.contentalliance.detail.e */
public class C3880e extends C3872b {
    /* renamed from: c */
    private LottieAnimationView f13149c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public ViewGroup f13150d;
    /* renamed from: e */
    private TextView f13151e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public Handler f13152f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean f13153g = false;
    /* renamed from: h */
    private C3828a f13154h = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            super.mo23230a();
            C3880e.this.m16130h();
            C3880e.this.f13153g = false;
        }

        /* renamed from: b */
        public void mo23231b() {
            super.mo23231b();
            if (C3607b.m15045a(C3880e.this.mo24770p()) || C3880e.this.f13125b.f13135i.mo23561c()) {
                C3880e.this.f13150d.setVisibility(8);
            } else {
                C3880e.this.m16132i();
            }
            if (C3880e.this.f13125b.f13135i.mo23562d() && !C3880e.this.f13153g) {
                C3880e.this.m16138q();
            }
            C3880e.this.f13153g = true;
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: i */
    public Runnable f13155i = new Runnable() {
        public void run() {
            C3880e.this.m16130h();
            C3880e.this.f13150d.setVisibility(0);
        }
    };
    /* renamed from: j */
    private C3989e f13156j = new C3990f() {
        /* renamed from: a */
        public void mo23373a() {
            super.mo23373a();
            C3880e.this.f13152f.removeCallbacks(C3880e.this.f13155i);
            C4065b.m16863a("DetailLoadingPresenter", "onVideoPlaying");
            C3880e.this.m16130h();
            C3880e.this.f13150d.setVisibility(8);
        }

        /* renamed from: a */
        public void mo23377a(int i, int i2) {
            C4065b.m16863a("DetailLoadingPresenter", "onVideoPlayError");
            C3880e.this.m16130h();
            C3801f.m15760b(C3880e.this.mo24770p(), C3809l.m15796e(C3880e.this.mo24770p(), "ksad_loading_retry_when_disconnected"));
        }

        /* renamed from: b */
        public void mo23346b() {
            super.mo23346b();
            C3880e.this.m16130h();
            C4065b.m16863a("DetailLoadingPresenter", "onVideoPlayCompleted");
        }

        /* renamed from: c */
        public void mo23347c() {
            super.mo23347c();
            C4065b.m16863a("DetailLoadingPresenter", "onVideoPlayStart");
            C3880e.this.f13152f.removeCallbacks(C3880e.this.f13155i);
            C3880e.this.f13150d.setVisibility(8);
        }

        /* renamed from: d */
        public void mo23378d() {
            super.mo23378d();
            C4065b.m16863a("DetailLoadingPresenter", "onVideoPreparing");
            C3880e.this.m16138q();
        }

        /* renamed from: e */
        public void mo23379e() {
            super.mo23379e();
            C4065b.m16863a("DetailLoadingPresenter", "onVideoPlayBufferingPaused");
            C3880e.this.m16128g();
        }

        /* renamed from: f */
        public void mo23380f() {
            super.mo23380f();
            C4065b.m16863a("DetailLoadingPresenter", "onVideoPlayBufferingPlaying");
            C3880e.this.m16128g();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16128g() {
        ViewGroup viewGroup;
        int i = 0;
        if (!C3607b.m15045a(mo24770p())) {
            m16130h();
            viewGroup = this.f13150d;
        } else if (this.f13149c.getVisibility() != 0 || !this.f13149c.mo22761c()) {
            this.f13149c.setVisibility(0);
            if (!this.f13149c.mo22761c()) {
                this.f13149c.mo22759b();
            }
            viewGroup = this.f13150d;
            i = 8;
        } else {
            return;
        }
        viewGroup.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16130h() {
        if (this.f13149c.mo22761c()) {
            this.f13149c.mo22762d();
        }
        this.f13149c.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m16132i() {
        this.f13149c.mo22762d();
        this.f13149c.setVisibility(8);
        this.f13150d.setVisibility(0);
        C3801f.m15760b(mo24770p(), C3809l.m15796e(mo24770p(), "ksad_loading_retry_when_disconnected"));
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m16138q() {
        if (C3607b.m15045a(mo24770p())) {
            m16128g();
        } else {
            m16130h();
        }
        this.f13152f.removeCallbacks(this.f13155i);
        this.f13152f.postDelayed(this.f13155i, 10000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        C4065b.m16863a("DetailLoadingPresenter", "onBind");
        this.f13151e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!C3607b.m15045a(C3880e.this.mo24770p())) {
                    C3801f.m15760b(C3880e.this.mo24770p(), C3809l.m15796e(C3880e.this.mo24770p(), "ksad_loading_retry_when_disconnected"));
                    return;
                }
                if (!C3880e.this.f13125b.f13135i.mo23561c()) {
                    C3880e.this.f13125b.f13135i.mo23565g();
                }
            }
        });
        this.f13125b.f13127a.add(this.f13154h);
        this.f13125b.f13135i.mo23557a(this.f13156j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13152f = new Handler();
        this.f13150d = (ViewGroup) mo24760a("ksad_error_container");
        this.f13149c = (LottieAnimationView) mo24760a("ksad_center_loading__animation_view");
        int g = C3809l.m15798g(mo24770p(), "ksad_detail_loading_amin_middle");
        this.f13149c.setVisibility(0);
        this.f13149c.setAnimation(g);
        this.f13149c.setRepeatMode(1);
        this.f13149c.setRepeatCount(-1);
        this.f13149c.setAnimation(g);
        this.f13151e = (TextView) mo24760a("ksad_retry_btn");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        Handler handler = this.f13152f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f13125b.f13127a.remove(this.f13154h);
        if (this.f13125b.f13135i != null) {
            this.f13125b.f13135i.mo23560b(this.f13156j);
        }
    }
}
