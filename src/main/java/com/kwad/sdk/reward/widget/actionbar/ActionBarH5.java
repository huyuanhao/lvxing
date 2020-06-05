package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3809l;

public class ActionBarH5 extends FrameLayout implements OnClickListener {
    /* renamed from: a */
    private TextView f14816a;
    /* renamed from: b */
    private TextView f14817b;
    /* renamed from: c */
    private AdTemplate f14818c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C4550a f14819d;

    /* renamed from: com.kwad.sdk.reward.widget.actionbar.ActionBarH5$a */
    public interface C4550a {
        /* renamed from: a */
        void mo24754a();
    }

    public ActionBarH5(Context context) {
        super(context);
        m18457a(context);
    }

    public ActionBarH5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18457a(context);
    }

    public ActionBarH5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18457a(context);
    }

    /* renamed from: a */
    private void m18457a(Context context) {
        inflate(context, C3809l.m15792b(context, "ksad_video_actionbar_h5"), this);
        this.f14816a = (TextView) findViewById(C3809l.m15789a(context, "ksad_h5_ad_desc"));
        this.f14817b = (TextView) findViewById(C3809l.m15789a(context, "ksad_h5_open_btn"));
    }

    /* renamed from: a */
    public void mo24833a(AdTemplate adTemplate, C4550a aVar) {
        this.f14818c = adTemplate;
        this.f14819d = aVar;
        AdInfo e = C4324c.m17668e(this.f14818c);
        this.f14816a.setText(C4322a.m17643k(e));
        this.f14817b.setText(C4322a.m17650r(e));
        setOnClickListener(this);
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14818c, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (ActionBarH5.this.f14819d != null) {
                    ActionBarH5.this.f14819d.mo24754a();
                }
            }
        }, null);
    }
}
