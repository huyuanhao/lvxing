package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.reward.widget.AppScoreView;

public class ActionBarAppPortrait extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private ImageView f14802a;
    /* renamed from: b */
    private TextView f14803b;
    /* renamed from: c */
    private TextView f14804c;
    /* renamed from: d */
    private AppScoreView f14805d;
    /* renamed from: e */
    private TextView f14806e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public TextProgressBar f14807f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public View f14808g;
    /* renamed from: h */
    private AdTemplate f14809h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public AdInfo f14810i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public C4548a f14811j;
    /* renamed from: k */
    private C4089b f14812k;
    /* renamed from: l */
    private KsAppDownloadListener f14813l;

    /* renamed from: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait$a */
    public interface C4548a {
        /* renamed from: a */
        void mo24753a();
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18448a();
    }

    /* renamed from: a */
    private void m18448a() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_video_actionbar_app_portrait"), this);
        this.f14802a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_app_icon"));
        this.f14803b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_title"));
        this.f14804c = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_desc"));
        this.f14805d = (AppScoreView) findViewById(C3809l.m15789a(getContext(), "ksad_app_score"));
        this.f14806e = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_download_count"));
        this.f14807f = (TextProgressBar) findViewById(C3809l.m15789a(getContext(), "ksad_app_download_btn"));
        this.f14807f.setTextDimen((float) C3817t.m15862a(getContext(), 16.0f));
        this.f14807f.setTextColor(-1);
        this.f14808g = findViewById(C3809l.m15789a(getContext(), "ksad_download_bar_cover"));
    }

    /* renamed from: b */
    private void m18450b() {
        String o = C4322a.m17647o(this.f14810i);
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(o);
        float p = C4322a.m17648p(this.f14810i);
        if (p < 3.0f) {
            z = false;
        }
        if (z2 && z) {
            ((LayoutParams) this.f14803b.getLayoutParams()).bottomMargin = C3817t.m15862a(getContext(), 1.0f);
            ((LayoutParams) this.f14805d.getLayoutParams()).bottomMargin = C3817t.m15862a(getContext(), 1.0f);
            this.f14806e.setText(o);
            this.f14806e.setVisibility(0);
            this.f14805d.setVisibility(0);
            this.f14805d.setScore(p);
        } else if (z2) {
            this.f14806e.setText(o);
            this.f14806e.setVisibility(0);
            this.f14805d.setVisibility(8);
        } else if (z) {
            this.f14806e.setVisibility(8);
            this.f14805d.setScore(p);
            this.f14805d.setVisibility(0);
        } else {
            this.f14804c.setText(C4322a.m17643k(this.f14810i));
            this.f14806e.setVisibility(8);
            this.f14805d.setVisibility(8);
            this.f14804c.setVisibility(0);
            return;
        }
        this.f14804c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f14813l == null) {
            this.f14813l = new KsAppDownloadListener() {
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f14807f.mo24328a(C4322a.m17630a(), 0);
                    ActionBarAppPortrait.this.f14808g.setVisibility(0);
                }

                public void onIdle() {
                    ActionBarAppPortrait.this.f14807f.mo24328a(C4322a.m17650r(ActionBarAppPortrait.this.f14810i), 0);
                    ActionBarAppPortrait.this.f14808g.setVisibility(0);
                }

                public void onInstalled() {
                    ActionBarAppPortrait.this.f14807f.mo24328a(C4322a.m17634b(), 0);
                    ActionBarAppPortrait.this.f14808g.setVisibility(0);
                }

                public void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.f14807f.mo24328a(C4322a.m17631a(i), i);
                    ActionBarAppPortrait.this.f14808g.setVisibility(8);
                }
            };
        }
        return this.f14813l;
    }

    /* renamed from: a */
    public void mo24830a(AdTemplate adTemplate, C4089b bVar, C4548a aVar) {
        this.f14809h = adTemplate;
        this.f14810i = C4324c.m17668e(adTemplate);
        this.f14811j = aVar;
        this.f14812k = bVar;
        KSImageLoader.loadAppIcon(this.f14802a, C4322a.m17644l(this.f14810i), 12);
        this.f14803b.setText(C4322a.m17645m(this.f14810i));
        m18450b();
        this.f14807f.mo24328a(C4322a.m17650r(this.f14810i), 0);
        C4089b bVar2 = this.f14812k;
        if (bVar2 != null) {
            bVar2.mo23770a(getAppDownloadListener());
        }
        setOnClickListener(this);
    }

    public C4089b getApkDownloadHelper() {
        return this.f14812k;
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14809h, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (ActionBarAppPortrait.this.f14811j != null) {
                    ActionBarAppPortrait.this.f14811j.mo24753a();
                }
            }
        }, this.f14812k);
    }
}
