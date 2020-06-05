package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class ActionBarAppLandscape extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private ImageView f14788a;
    /* renamed from: b */
    private TextView f14789b;
    /* renamed from: c */
    private TextView f14790c;
    /* renamed from: d */
    private AppScoreView f14791d;
    /* renamed from: e */
    private TextView f14792e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public TextProgressBar f14793f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public View f14794g;
    /* renamed from: h */
    private AdTemplate f14795h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public AdInfo f14796i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public C4545a f14797j;
    /* renamed from: k */
    private C4089b f14798k;
    /* renamed from: l */
    private KsAppDownloadListener f14799l;

    /* renamed from: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape$a */
    public interface C4545a {
        /* renamed from: a */
        void mo24752a();
    }

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    public ActionBarAppLandscape(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppLandscape(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18439a();
    }

    /* renamed from: a */
    private void m18439a() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_video_actionbar_app_landscape"), this);
        this.f14788a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_app_icon"));
        this.f14789b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_title"));
        this.f14790c = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_desc"));
        this.f14791d = (AppScoreView) findViewById(C3809l.m15789a(getContext(), "ksad_app_score"));
        this.f14792e = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_download_count"));
        this.f14793f = (TextProgressBar) findViewById(C3809l.m15789a(getContext(), "ksad_app_download_btn"));
        this.f14793f.setTextDimen((float) C3817t.m15862a(getContext(), 16.0f));
        this.f14793f.setTextColor(-1);
        this.f14794g = findViewById(C3809l.m15789a(getContext(), "ksad_download_bar_cover"));
    }

    /* renamed from: b */
    private void m18441b() {
        float p = C4322a.m17648p(this.f14796i);
        boolean z = p >= 3.0f;
        if (z) {
            this.f14791d.setScore(p);
            this.f14791d.setVisibility(0);
        }
        String o = C4322a.m17647o(this.f14796i);
        boolean isEmpty = true ^ TextUtils.isEmpty(o);
        if (isEmpty) {
            this.f14792e.setText(o);
            this.f14792e.setVisibility(0);
        }
        if (isEmpty || z) {
            this.f14790c.setVisibility(8);
            return;
        }
        this.f14790c.setText(C4322a.m17643k(this.f14796i));
        this.f14791d.setVisibility(8);
        this.f14792e.setVisibility(8);
        this.f14790c.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f14799l == null) {
            this.f14799l = new KsAppDownloadListener() {
                public void onDownloadFinished() {
                    ActionBarAppLandscape.this.f14793f.mo24328a(C4322a.m17630a(), 0);
                    ActionBarAppLandscape.this.f14794g.setVisibility(0);
                }

                public void onIdle() {
                    ActionBarAppLandscape.this.f14793f.mo24328a(C4322a.m17650r(ActionBarAppLandscape.this.f14796i), 0);
                    ActionBarAppLandscape.this.f14794g.setVisibility(0);
                }

                public void onInstalled() {
                    ActionBarAppLandscape.this.f14793f.mo24328a(C4322a.m17634b(), 0);
                    ActionBarAppLandscape.this.f14794g.setVisibility(0);
                }

                public void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.f14793f.mo24328a(C4322a.m17631a(i), i);
                    ActionBarAppLandscape.this.f14794g.setVisibility(8);
                }
            };
        }
        return this.f14799l;
    }

    /* renamed from: a */
    public void mo24827a(AdTemplate adTemplate, C4089b bVar, C4545a aVar) {
        this.f14795h = adTemplate;
        this.f14796i = C4324c.m17668e(adTemplate);
        this.f14797j = aVar;
        this.f14798k = bVar;
        KSImageLoader.loadAppIcon(this.f14788a, C4322a.m17644l(this.f14796i), 12);
        this.f14789b.setText(C4322a.m17645m(this.f14796i));
        m18441b();
        this.f14793f.mo24328a(C4322a.m17650r(this.f14796i), 0);
        C4089b bVar2 = this.f14798k;
        if (bVar2 != null) {
            bVar2.mo23770a(getAppDownloadListener());
        }
        setOnClickListener(this);
    }

    public C4089b getApkDownloadHelper() {
        return this.f14798k;
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14795h, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (ActionBarAppLandscape.this.f14797j != null) {
                    ActionBarAppLandscape.this.f14797j.mo24752a();
                }
            }
        }, this.f14798k);
    }
}
