package com.kwad.sdk.contentalliance.home.p315a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ksad.download.p297c.C3607b;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.contentalliance.home.C3991a;
import com.kwad.sdk.contentalliance.home.C4010b;
import com.kwad.sdk.contentalliance.home.C4012d;
import com.kwad.sdk.contentalliance.home.viewpager.C4026b;
import com.kwad.sdk.contentalliance.home.viewpager.C4026b.C4027a;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3801f;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.contentalliance.home.a.b */
public class C3996b extends C4012d {
    /* renamed from: b */
    private LottieAnimationView f13428b;
    /* renamed from: c */
    private ViewGroup f13429c;
    /* renamed from: d */
    private TextView f13430d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C3991a f13431e;
    /* renamed from: f */
    private C4026b f13432f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean f13433g;
    /* renamed from: h */
    private C4027a f13434h = new C4027a() {
        /* renamed from: a */
        public void mo23581a() {
        }

        /* renamed from: b */
        public void mo23582b() {
            if (C3996b.this.f13433g) {
                C3801f.m15760b(C3996b.this.mo24770p(), "网络信号不好，请检查网络连接后重试");
            }
        }
    };
    /* renamed from: i */
    private C4010b f13435i = new C4010b() {
        /* renamed from: a */
        public void mo23583a() {
            C4065b.m16863a("HomeLoadingPresenter", " onStartLoading");
            if (C3607b.m15045a(C3996b.this.mo24770p())) {
                C3996b.this.m16576i();
            }
            C3996b.this.f13433g = true;
        }

        /* renamed from: a */
        public void mo23584a(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(" onError code ");
            sb.append(i);
            sb.append(" msg ");
            sb.append(str);
            C4065b.m16863a("HomeLoadingPresenter", sb.toString());
            C3996b.this.m16575h();
            C3996b.this.f13433g = false;
        }

        /* renamed from: a */
        public void mo23585a(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(" onFinishLoading  ");
            sb.append(z);
            C4065b.m16863a("HomeLoadingPresenter", sb.toString());
            C3996b.this.m16573g();
            C3996b.this.f13433g = false;
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16573g() {
        if (this.f13428b.mo22761c()) {
            this.f13428b.mo22762d();
        }
        this.f13428b.setVisibility(8);
        this.f13429c.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16575h() {
        if (C3607b.m15045a(mo24770p())) {
            m16578r();
        } else {
            m16577q();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m16576i() {
        this.f13428b.setVisibility(0);
        if (!this.f13428b.mo22761c()) {
            this.f13428b.mo22759b();
        }
        this.f13429c.setVisibility(8);
    }

    /* renamed from: q */
    private void m16577q() {
        C3801f.m15760b(mo24770p(), C3809l.m15796e(mo24770p(), "ksad_loading_retry_when_disconnected"));
        if (!this.f13431e.mo23573a()) {
            this.f13428b.mo22762d();
            this.f13428b.setVisibility(8);
            this.f13429c.setVisibility(0);
        }
    }

    /* renamed from: r */
    private void m16578r() {
        m16576i();
        if (!this.f13431e.mo23573a()) {
            this.f13428b.mo22762d();
            this.f13428b.setVisibility(8);
            this.f13429c.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13431e = this.f13465a.f13467b;
        this.f13431e.mo23572a(this.f13435i);
        m16576i();
        this.f13430d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C3996b.this.f13431e.mo23574a(true);
                C3996b.this.m16576i();
            }
        });
        this.f13432f.mo23616a(this.f13434h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13428b = (LottieAnimationView) mo24760a("ksad_center_loading__animation_view");
        this.f13429c = (ViewGroup) mo24760a("ksad_error_container");
        this.f13430d = (TextView) mo24760a("ksad_retry_btn");
        this.f13432f = (C4026b) mo24760a("ksad_slide_play_view_pager");
        int g = C3809l.m15798g(mo24770p(), "ksad_detail_loading_amin_middle");
        this.f13428b.setVisibility(0);
        this.f13428b.setAnimation(g);
        this.f13428b.setRepeatMode(1);
        this.f13428b.setRepeatCount(-1);
        this.f13428b.setAnimation(g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13431e.mo23576b(this.f13435i);
        this.f13430d.setOnClickListener(null);
        this.f13428b.mo22762d();
        this.f13432f.mo23618b(this.f13434h);
    }
}
