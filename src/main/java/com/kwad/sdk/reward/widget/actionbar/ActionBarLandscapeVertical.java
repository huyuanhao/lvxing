package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

public class ActionBarLandscapeVertical extends FrameLayout implements OnClickListener {
    /* renamed from: a */
    private ViewGroup f14821a;
    /* renamed from: b */
    private ImageView f14822b;
    /* renamed from: c */
    private AppScoreView f14823c;
    /* renamed from: d */
    private TextView f14824d;
    /* renamed from: e */
    private View f14825e;
    /* renamed from: f */
    private ViewGroup f14826f;
    /* renamed from: g */
    private TextView f14827g;
    /* renamed from: h */
    private TextView f14828h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TextProgressBar f14829i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public View f14830j;
    /* renamed from: k */
    private AdTemplate f14831k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public AdInfo f14832l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public C4553a f14833m;
    /* renamed from: n */
    private C4089b f14834n;
    /* renamed from: o */
    private KsAppDownloadListener f14835o;

    /* renamed from: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical$a */
    public interface C4553a {
        /* renamed from: a */
        void mo24747a();
    }

    public ActionBarLandscapeVertical(Context context) {
        super(context);
        m18462a(context);
    }

    public ActionBarLandscapeVertical(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18462a(context);
    }

    public ActionBarLandscapeVertical(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18462a(context);
    }

    /* renamed from: a */
    private void m18462a(Context context) {
        inflate(context, C3809l.m15792b(context, "ksad_video_actionbar_landscape_vertical"), this);
        this.f14821a = (ViewGroup) findViewById(C3809l.m15789a(context, "ksad_top_container"));
        this.f14822b = (ImageView) findViewById(C3809l.m15789a(context, "ksad_app_icon"));
        this.f14823c = (AppScoreView) findViewById(C3809l.m15789a(context, "ksad_app_score"));
        this.f14824d = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_download_count"));
        this.f14825e = findViewById(C3809l.m15789a(context, "ksad_video_place_holder"));
        this.f14826f = (ViewGroup) findViewById(C3809l.m15789a(context, "ksad_bottom_container"));
        this.f14827g = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_name"));
        this.f14828h = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_desc"));
        this.f14829i = (TextProgressBar) findViewById(C3809l.m15789a(context, "ksad_app_download_btn"));
        this.f14829i.setTextDimen((float) C3817t.m15862a(getContext(), 16.0f));
        this.f14829i.setTextColor(-1);
        this.f14830j = findViewById(C3809l.m15789a(context, "ksad_app_download_btn_cover"));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f14835o == null) {
            this.f14835o = new KsAppDownloadListener() {
                public void onDownloadFinished() {
                    ActionBarLandscapeVertical.this.f14829i.mo24328a(C4322a.m17630a(), 0);
                    ActionBarLandscapeVertical.this.f14830j.setVisibility(0);
                }

                public void onIdle() {
                    ActionBarLandscapeVertical.this.f14829i.mo24328a(C4322a.m17650r(ActionBarLandscapeVertical.this.f14832l), 0);
                    ActionBarLandscapeVertical.this.f14830j.setVisibility(0);
                }

                public void onInstalled() {
                    ActionBarLandscapeVertical.this.f14829i.mo24328a(C4322a.m17634b(), 0);
                    ActionBarLandscapeVertical.this.f14830j.setVisibility(0);
                }

                public void onProgressUpdate(int i) {
                    ActionBarLandscapeVertical.this.f14829i.mo24328a(C4322a.m17631a(i), i);
                    ActionBarLandscapeVertical.this.f14830j.setVisibility(8);
                }
            };
        }
        return this.f14835o;
    }

    /* renamed from: a */
    public void mo24835a(AdTemplate adTemplate, C4089b bVar, C4553a aVar, int i) {
        this.f14831k = adTemplate;
        this.f14832l = C4324c.m17668e(adTemplate);
        this.f14833m = aVar;
        this.f14834n = bVar;
        KSImageLoader.loadAppIcon(this.f14822b, C4322a.m17644l(this.f14832l), 16);
        float p = C4322a.m17648p(this.f14832l);
        if (p >= 3.0f) {
            this.f14823c.setScore(p);
            this.f14823c.setVisibility(0);
        } else {
            this.f14823c.setVisibility(8);
        }
        String o = C4322a.m17647o(this.f14832l);
        if (true ^ TextUtils.isEmpty(o)) {
            this.f14824d.setText(o);
            this.f14824d.setVisibility(0);
        } else {
            this.f14824d.setVisibility(8);
        }
        LayoutParams layoutParams = this.f14825e.getLayoutParams();
        layoutParams.width = i;
        this.f14825e.setLayoutParams(layoutParams);
        this.f14827g.setText(C4322a.m17645m(this.f14832l));
        this.f14828h.setText(C4322a.m17643k(this.f14832l));
        this.f14829i.mo24328a(C4322a.m17650r(this.f14832l), this.f14829i.getMax());
        this.f14830j.setVisibility(8);
        C4089b bVar2 = this.f14834n;
        if (bVar2 != null) {
            bVar2.mo23770a(getAppDownloadListener());
        }
        this.f14821a.setOnClickListener(this);
        this.f14826f.setOnClickListener(this);
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14831k, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (ActionBarLandscapeVertical.this.f14833m != null) {
                    ActionBarLandscapeVertical.this.f14833m.mo24747a();
                }
            }
        }, this.f14834n);
    }
}
