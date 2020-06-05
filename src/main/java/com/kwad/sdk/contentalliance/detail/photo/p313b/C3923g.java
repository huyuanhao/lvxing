package com.kwad.sdk.contentalliance.detail.photo.p313b;

import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageButton;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.detail.video.C3982b;
import com.kwad.sdk.contentalliance.detail.video.C3982b.C3986a;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.contentalliance.widget.KsAdFrameLayout;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.g */
public class C3923g extends C3872b {
    /* renamed from: c */
    OnClickListener f13258c = new OnClickListener() {
        public void onClick(View view) {
            C3923g.this.m16297i();
            C3923g.this.mo23432g().mo23439a();
        }
    };
    /* renamed from: d */
    private ImageButton f13259d;
    /* renamed from: e */
    private C3982b f13260e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C3931b f13261f = new C3934e();
    /* renamed from: g */
    private KsAdFrameLayout f13262g;
    /* renamed from: h */
    private C3828a f13263h = new C3829b() {
        /* renamed from: b */
        public void mo23231b() {
            C3923g.this.m16296h();
        }
    };
    /* renamed from: i */
    private C3989e f13264i = new C3990f() {
        /* renamed from: a */
        public void mo23373a() {
            C3923g.this.mo23432g().mo23440a(new C3933d());
        }

        /* renamed from: a */
        public void mo23377a(int i, int i2) {
            C3923g.this.m16296h();
        }

        /* renamed from: b */
        public void mo23346b() {
            C3923g.this.m16296h();
        }

        /* renamed from: c */
        public void mo23347c() {
            C3923g.this.m16297i();
            C3923g.this.mo23432g().mo23440a(new C3933d());
            C3923g.this.f13266k = false;
        }

        /* renamed from: g */
        public void mo23431g() {
            C3923g.this.mo23432g().mo23440a(new C3932c());
        }
    };
    /* renamed from: j */
    private Runnable f13265j = new Runnable() {
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("mAutoHidePauseButtonCallback run=");
            sb.append(C3923g.this.f13261f);
            C4065b.m16863a("PhotoVideoControlPresenter", sb.toString());
            if (C3923g.this.f13261f != null) {
                C3923g.this.f13261f.mo23440a(new C3933d());
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean f13266k = false;
    /* renamed from: l */
    private C3986a f13267l = new C3986a() {
        /* renamed from: a */
        public boolean mo23435a() {
            return C3923g.this.f13266k;
        }
    };
    /* renamed from: m */
    private SimpleOnGestureListener f13268m = new SimpleOnGestureListener() {
        /* renamed from: a */
        boolean f13275a = false;
        /* renamed from: b */
        long f13276b = 0;

        /* renamed from: a */
        private boolean m16309a() {
            return SystemClock.elapsedRealtime() - this.f13276b < ((long) ViewConfiguration.getJumpTapTimeout());
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            this.f13276b = SystemClock.elapsedRealtime();
            return this.f13275a;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (m16309a()) {
                return false;
            }
            C3923g.this.m16297i();
            C3923g.this.mo23432g().mo23441b();
            this.f13275a = false;
            this.f13276b = 0;
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f13275a = false;
            return true;
        }
    };
    /* renamed from: n */
    private GestureDetector f13269n;

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.g$a */
    private abstract class C3930a implements C3931b {
        private C3930a() {
        }

        /* renamed from: a */
        public void mo23439a() {
        }

        /* renamed from: a */
        public void mo23440a(C3931b bVar) {
            C3923g.this.f13261f = bVar;
            bVar.mo23442c();
        }

        /* renamed from: b */
        public void mo23441b() {
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.g$b */
    private interface C3931b {
        /* renamed from: a */
        void mo23439a();

        /* renamed from: a */
        void mo23440a(C3931b bVar);

        /* renamed from: b */
        void mo23441b();

        /* renamed from: c */
        void mo23442c();
    }

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.g$c */
    private class C3932c extends C3930a {
        private C3932c() {
            super();
        }

        /* renamed from: a */
        public void mo23439a() {
            C3923g.this.m16286a(0);
        }

        /* renamed from: b */
        public void mo23441b() {
            C3923g.this.m16286a(0);
        }

        /* renamed from: c */
        public void mo23442c() {
            C3923g.this.m16290a(true, 0);
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.g$d */
    private class C3933d extends C3930a {
        private C3933d() {
            super();
        }

        /* renamed from: b */
        public void mo23441b() {
            C3923g.this.m16286a(1);
        }

        /* renamed from: c */
        public void mo23442c() {
            C3923g.this.m16290a(false, 1);
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.g$e */
    private class C3934e extends C3930a {
        private C3934e() {
            super();
        }

        /* renamed from: b */
        public void mo23441b() {
        }

        /* renamed from: c */
        public void mo23442c() {
            C3923g.this.m16290a(false, 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16286a(int i) {
        C3982b bVar = this.f13260e;
        if (bVar == null) {
            return;
        }
        if (i == 1) {
            this.f13266k = true;
            bVar.mo23566h();
            return;
        }
        this.f13266k = false;
        bVar.mo23564f();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16290a(boolean z, int i) {
        m16293b(i == 0 ? "ksad_photo_video_play_icon" : "ksad_photo_video_pause_icon");
        this.f13259d.setVisibility(z ? 0 : 4);
    }

    /* renamed from: b */
    private void m16293b(String str) {
        this.f13259d.setBackgroundResource(C3809l.m15795d(mo24770p(), str));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16296h() {
        m16297i();
        this.f13261f = new C3934e();
        m16290a(false, 1);
        this.f13266k = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m16297i() {
        this.f13259d.removeCallbacks(this.f13265j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13266k = false;
        this.f13260e = this.f13125b.f13135i;
        this.f13260e.mo23555a(this.f13267l);
        this.f13260e.mo23557a(this.f13264i);
        this.f13125b.f13127a.add(this.f13263h);
        m16296h();
        this.f13259d.setOnClickListener(this.f13258c);
        this.f13269n = new GestureDetector(mo24770p(), this.f13268m);
        this.f13262g.mo23712a(this.f13269n);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13259d = (ImageButton) mo24760a("ksad_video_control_button");
        this.f13262g = (KsAdFrameLayout) mo24760a("ksad_video_container");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13260e.mo23558b(this.f13267l);
        this.f13260e.mo23560b(this.f13264i);
        this.f13259d.setOnClickListener(null);
        this.f13125b.f13127a.remove(this.f13263h);
        this.f13262g.mo23713b(this.f13269n);
        m16296h();
    }

    /* renamed from: g */
    public C3931b mo23432g() {
        if (this.f13261f == null) {
            this.f13261f = new C3933d();
        }
        return this.f13261f;
    }
}
