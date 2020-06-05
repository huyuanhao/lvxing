package com.kwad.sdk.contentalliance.detail.photo.p312a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.kwad.sdk.contentalliance.detail.photo.p314c.C3937b;
import com.kwad.sdk.contentalliance.detail.photo.p314c.C3938c;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p306a.C3809l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.a.b */
public class C3887b extends LinearLayout {
    /* renamed from: a */
    protected Presenter f13169a;
    /* renamed from: b */
    protected C3893c f13170b;
    /* renamed from: c */
    private LinearLayout f13171c = null;
    /* renamed from: d */
    private Button f13172d = null;
    /* renamed from: e */
    private List<C3892a> f13173e = new ArrayList();
    /* renamed from: f */
    private C3937b f13174f = new C3937b() {
        /* renamed from: a */
        public void mo23391a(C3938c cVar) {
            C3887b.this.m16171c();
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.a.b$a */
    public interface C3892a {
        /* renamed from: a */
        void mo23395a();

        /* renamed from: b */
        void mo23396b();
    }

    public C3887b(Context context) {
        super(context);
        m16168b();
    }

    /* renamed from: b */
    private C3893c m16167b(C3894d dVar) {
        C3893c cVar = new C3893c();
        cVar.f13179a = dVar;
        cVar.f13180b = this.f13174f;
        return cVar;
    }

    /* renamed from: b */
    private void m16168b() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_bottom_panel"), this, true);
        this.f13171c = (LinearLayout) findViewById(C3809l.m15789a(getContext(), "ksad_photo_bottom_panel_buttons_layout"));
        this.f13171c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.f13172d = (Button) findViewById(C3809l.m15789a(getContext(), "ksad_photo_bottom_panel_cancel_button"));
        this.f13172d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C3887b.this.m16172d();
            }
        });
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C3887b.this.m16172d();
            }
        });
    }

    /* renamed from: c */
    private Presenter m16170c(C3894d dVar) {
        Presenter presenter = new Presenter();
        presenter.mo24762a((Presenter) new C3898g());
        return presenter;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16171c() {
        for (C3892a a : this.f13173e) {
            a.mo23395a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16172d() {
        for (C3892a b : this.f13173e) {
            b.mo23396b();
        }
    }

    /* renamed from: a */
    public void mo23387a() {
        this.f13169a.mo24765k();
    }

    /* renamed from: a */
    public void mo23388a(C3892a aVar) {
        this.f13173e.add(aVar);
    }

    /* renamed from: a */
    public void mo23389a(C3894d dVar) {
        this.f13170b = m16167b(dVar);
        if (this.f13169a == null) {
            this.f13169a = m16170c(dVar);
            this.f13169a.mo24761a((View) this.f13171c);
        }
        this.f13169a.mo24763a((Object) this.f13170b);
    }

    /* renamed from: b */
    public void mo23390b(C3892a aVar) {
        this.f13173e.remove(aVar);
    }
}
