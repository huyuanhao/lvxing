package com.kwad.sdk.nativead.p349b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.p348a.C4474a;
import com.kwad.sdk.p306a.C3814q;

/* renamed from: com.kwad.sdk.nativead.b.a */
public class C4477a extends C4474a implements OnClickListener {
    /* renamed from: b */
    private ViewGroup f14640b;
    /* renamed from: c */
    private ImageView f14641c;
    /* renamed from: d */
    private TextView f14642d;
    /* renamed from: e */
    private C3989e f14643e = new C3990f() {
        /* renamed from: a */
        public void mo23373a() {
            super.mo23373a();
            C4477a.this.m18214g();
        }

        /* renamed from: c */
        public void mo23347c() {
            super.mo23347c();
            C4477a.this.m18214g();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18214g() {
        if (this.f14640b.getVisibility() == 0) {
            this.f14640b.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        int i;
        ViewGroup viewGroup;
        super.mo23338a();
        if (!C3607b.m15045a(this.f14640b.getContext()) || C3607b.m15046b(this.f14640b.getContext())) {
            viewGroup = this.f14640b;
            i = 8;
        } else {
            this.f14642d.setText(C3814q.m15858a((long) (C4322a.m17633b(C4324c.m17668e(this.f14621a.f14625d)) * 1000)));
            this.f14641c.setOnClickListener(this);
            viewGroup = this.f14640b;
            i = 0;
        }
        viewGroup.setVisibility(i);
        this.f14621a.f14627f.mo24793a(this.f14643e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14640b = (ViewGroup) mo24760a("ksad_data_flow_container");
        this.f14641c = (ImageView) mo24760a("ksad_data_flow_play_btn");
        this.f14642d = (TextView) mo24760a("ksad_data_flow_play_tip");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14643e);
    }

    public void onClick(View view) {
        if (view == this.f14641c) {
            this.f14621a.f14627f.mo24799f();
        }
    }
}
