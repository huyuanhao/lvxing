package com.kwad.sdk.draw.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.draw.C4375b;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.reward.widget.AppScoreView;

public class DrawCardApp extends FrameLayout implements OnClickListener {
    /* renamed from: a */
    private AdTemplate f14325a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AdInfo f14326b;
    /* renamed from: c */
    private C4089b f14327c;
    /* renamed from: d */
    private KsAppDownloadListener f14328d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C4380a f14329e;
    /* renamed from: f */
    private int f14330f;
    /* renamed from: g */
    private ImageView f14331g;
    /* renamed from: h */
    private ImageView f14332h;
    /* renamed from: i */
    private TextView f14333i;
    /* renamed from: j */
    private ViewGroup f14334j;
    /* renamed from: k */
    private AppScoreView f14335k;
    /* renamed from: l */
    private TextView f14336l;
    /* renamed from: m */
    private TextView f14337m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public DrawDownloadProgressBar f14338n;
    /* renamed from: o */
    private ValueAnimator f14339o;

    /* renamed from: com.kwad.sdk.draw.view.DrawCardApp$a */
    public interface C4380a {
        /* renamed from: a */
        void mo23363a();

        /* renamed from: b */
        void mo23364b();
    }

    public DrawCardApp(Context context) {
        super(context);
        m17858a(context);
    }

    public DrawCardApp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17858a(context);
    }

    public DrawCardApp(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17858a(context);
    }

    /* renamed from: a */
    private void m17857a(int i, int i2) {
        m17861d();
        this.f14339o = C4375b.m17853a(this, i, i2);
        this.f14339o.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f14339o.setDuration(300);
        this.f14339o.start();
    }

    /* renamed from: a */
    private void m17858a(Context context) {
        inflate(context, C3809l.m15792b(context, "ksad_draw_card_app"), this);
        this.f14331g = (ImageView) findViewById(C3809l.m15789a(context, "ksad_card_app_close"));
        this.f14332h = (ImageView) findViewById(C3809l.m15789a(context, "ksad_card_app_icon"));
        this.f14333i = (TextView) findViewById(C3809l.m15789a(context, "ksad_card_app_name"));
        this.f14334j = (ViewGroup) findViewById(C3809l.m15789a(context, "ksad_card_app_score_container"));
        this.f14335k = (AppScoreView) findViewById(C3809l.m15789a(context, "ksad_card_app_score"));
        this.f14336l = (TextView) findViewById(C3809l.m15789a(context, "ksad_card_app_download_count"));
        this.f14337m = (TextView) findViewById(C3809l.m15789a(context, "ksad_card_app_desc"));
        this.f14338n = (DrawDownloadProgressBar) findViewById(C3809l.m15789a(context, "ksad_card_app_download_btn"));
        this.f14338n.setTextSize(16);
        this.f14330f = C3817t.m15862a(context, 156.0f);
    }

    /* renamed from: d */
    private void m17861d() {
        ValueAnimator valueAnimator = this.f14339o;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f14339o.cancel();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f14328d == null) {
            this.f14328d = new KsAppDownloadListener() {
                public void onDownloadFinished() {
                    DrawCardApp.this.f14338n.mo24567a(C4322a.m17630a(), DrawCardApp.this.f14338n.getMax());
                }

                public void onIdle() {
                    DrawCardApp.this.f14338n.mo24567a(C4322a.m17650r(DrawCardApp.this.f14326b), DrawCardApp.this.f14338n.getMax());
                }

                public void onInstalled() {
                    DrawCardApp.this.f14338n.mo24567a(C4322a.m17634b(), DrawCardApp.this.f14338n.getMax());
                }

                public void onProgressUpdate(int i) {
                    DrawDownloadProgressBar b = DrawCardApp.this.f14338n;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append("%");
                    b.mo24567a(sb.toString(), i);
                }
            };
        }
        return this.f14328d;
    }

    /* renamed from: a */
    public void mo24557a() {
        m17861d();
        this.f14327c = null;
    }

    /* renamed from: a */
    public void mo24558a(AdTemplate adTemplate, C4380a aVar) {
        this.f14325a = adTemplate;
        this.f14326b = C4324c.m17668e(this.f14325a);
        this.f14329e = aVar;
        this.f14327c = new C4089b(this.f14325a, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.f14332h, C4322a.m17644l(this.f14326b), 11);
        this.f14333i.setText(C4322a.m17645m(this.f14326b));
        String o = C4322a.m17647o(this.f14326b);
        float p = C4322a.m17648p(this.f14326b);
        boolean z = p >= 3.0f;
        if (z) {
            this.f14335k.setScore(p);
            this.f14335k.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(o);
        if (z2) {
            this.f14336l.setText(o);
            this.f14336l.setVisibility(0);
        }
        if (z || z2) {
            this.f14334j.setVisibility(0);
        } else {
            this.f14334j.setVisibility(8);
        }
        this.f14337m.setText(C4322a.m17643k(this.f14326b));
        this.f14331g.setOnClickListener(this);
        this.f14338n.setOnClickListener(this);
        setOnClickListener(this);
    }

    /* renamed from: b */
    public void mo24559b() {
        m17857a(0, this.f14330f);
    }

    /* renamed from: c */
    public void mo24560c() {
        m17857a(this.f14330f, 0);
    }

    public void onClick(View view) {
        if (view == this.f14331g) {
            mo24560c();
            C4380a aVar = this.f14329e;
            if (aVar != null) {
                aVar.mo23363a();
                return;
            }
            return;
        }
        C4087a.m16967a(getContext(), this.f14325a, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (DrawCardApp.this.f14329e != null) {
                    DrawCardApp.this.f14329e.mo23364b();
                }
            }
        }, this.f14327c);
    }
}
