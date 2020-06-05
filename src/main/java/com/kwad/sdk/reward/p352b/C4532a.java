package com.kwad.sdk.reward.p352b;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4323b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.reward.C4536c;
import com.kwad.sdk.reward.p351a.C4529b;
import com.kwad.sdk.reward.p351a.C4530c;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.reward.b.a */
public class C4532a extends C4536c implements OnClickListener {
    /* renamed from: b */
    public JSONObject f14768b;
    /* renamed from: c */
    private AdBaseFrameLayout f14769c;
    /* renamed from: d */
    private TextView f14770d;
    /* renamed from: e */
    private TextView f14771e;
    /* renamed from: f */
    private C4529b f14772f;
    /* renamed from: g */
    private AdTemplate f14773g;
    /* renamed from: h */
    private C4089b f14774h;
    /* renamed from: i */
    private C4530c f14775i = new C4530c() {
        /* renamed from: a */
        public void mo24817a() {
            C4532a.this.m18415g();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18415g() {
        TextView textView;
        String c = C4323b.m17661c(this.f14773g);
        if (!TextUtils.isEmpty(c)) {
            if (this.f14781a.f14761e == 1) {
                this.f14771e.setVisibility(8);
                this.f14770d.setText(c);
                this.f14770d.setVisibility(0);
                textView = this.f14770d;
            } else {
                this.f14770d.setVisibility(8);
                this.f14771e.setText(c);
                this.f14771e.setVisibility(0);
                textView = this.f14771e;
            }
            textView.setOnClickListener(this);
            m18416h();
        }
    }

    /* renamed from: h */
    private void m18416h() {
        C4143b.m17131c(this.f14773g, 17, this.f14768b);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m18417i() {
        C4143b.m17118a(this.f14773g, 39, this.f14769c.getTouchCoords(), this.f14768b);
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m18418q() {
        this.f14772f.mo24759a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14772f = this.f14781a.f14758b;
        this.f14768b = this.f14781a.f14759c;
        this.f14773g = this.f14781a.f14760d;
        this.f14774h = this.f14781a.f14762f;
        this.f14781a.f14764h.add(this.f14775i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14769c = (AdBaseFrameLayout) mo24760a("ksad_root_container");
        this.f14770d = (TextView) mo24760a("ksad_end_left_call_btn");
        this.f14771e = (TextView) mo24760a("ksad_end_right_call_btn");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14781a.f14764h.remove(this.f14775i);
    }

    public void onClick(View view) {
        if (view == this.f14770d || view == this.f14771e) {
            C4087a.m16967a(view.getContext(), this.f14773g, new C4088a() {
                /* renamed from: a */
                public void mo23360a() {
                    C4532a.this.m18417i();
                    C4532a.this.m18418q();
                }
            }, this.f14774h);
        }
    }
}
