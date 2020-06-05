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

public class ActionBarPortraitHorizontal extends FrameLayout implements OnClickListener {
    /* renamed from: a */
    private ViewGroup f14838a;
    /* renamed from: b */
    private ImageView f14839b;
    /* renamed from: c */
    private AppScoreView f14840c;
    /* renamed from: d */
    private TextView f14841d;
    /* renamed from: e */
    private View f14842e;
    /* renamed from: f */
    private ViewGroup f14843f;
    /* renamed from: g */
    private TextView f14844g;
    /* renamed from: h */
    private TextView f14845h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TextProgressBar f14846i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public View f14847j;
    /* renamed from: k */
    private AdTemplate f14848k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public AdInfo f14849l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public C4556a f14850m;
    /* renamed from: n */
    private C4089b f14851n;
    /* renamed from: o */
    private KsAppDownloadListener f14852o;

    /* renamed from: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal$a */
    public interface C4556a {
        /* renamed from: a */
        void mo24748a();
    }

    public ActionBarPortraitHorizontal(Context context) {
        super(context);
        m18470a(context);
    }

    public ActionBarPortraitHorizontal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18470a(context);
    }

    public ActionBarPortraitHorizontal(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18470a(context);
    }

    /* renamed from: a */
    private void m18470a(Context context) {
        inflate(context, C3809l.m15792b(context, "ksad_video_actionbar_portrait_horizontal"), this);
        this.f14838a = (ViewGroup) findViewById(C3809l.m15789a(context, "ksad_top_container"));
        this.f14839b = (ImageView) findViewById(C3809l.m15789a(context, "ksad_app_icon"));
        this.f14840c = (AppScoreView) findViewById(C3809l.m15789a(context, "ksad_app_score"));
        this.f14841d = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_download_count"));
        this.f14842e = findViewById(C3809l.m15789a(context, "ksad_video_place_holder"));
        this.f14843f = (ViewGroup) findViewById(C3809l.m15789a(context, "ksad_bottom_container"));
        this.f14844g = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_name"));
        this.f14845h = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_desc"));
        this.f14846i = (TextProgressBar) findViewById(C3809l.m15789a(context, "ksad_app_download_btn"));
        this.f14846i.setTextDimen((float) C3817t.m15862a(getContext(), 16.0f));
        this.f14846i.setTextColor(-1);
        this.f14847j = findViewById(C3809l.m15789a(context, "ksad_app_download_btn_cover"));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f14852o == null) {
            this.f14852o = new KsAppDownloadListener() {
                public void onDownloadFinished() {
                    ActionBarPortraitHorizontal.this.f14846i.mo24328a(C4322a.m17630a(), 0);
                    ActionBarPortraitHorizontal.this.f14847j.setVisibility(0);
                }

                public void onIdle() {
                    ActionBarPortraitHorizontal.this.f14846i.mo24328a(C4322a.m17650r(ActionBarPortraitHorizontal.this.f14849l), 0);
                    ActionBarPortraitHorizontal.this.f14847j.setVisibility(0);
                }

                public void onInstalled() {
                    ActionBarPortraitHorizontal.this.f14846i.mo24328a(C4322a.m17634b(), 0);
                    ActionBarPortraitHorizontal.this.f14847j.setVisibility(0);
                }

                public void onProgressUpdate(int i) {
                    ActionBarPortraitHorizontal.this.f14846i.mo24328a(C4322a.m17631a(i), i);
                    ActionBarPortraitHorizontal.this.f14847j.setVisibility(8);
                }
            };
        }
        return this.f14852o;
    }

    /* renamed from: a */
    public void mo24837a(AdTemplate adTemplate, C4089b bVar, C4556a aVar, int i) {
        this.f14848k = adTemplate;
        this.f14849l = C4324c.m17668e(this.f14848k);
        this.f14850m = aVar;
        this.f14851n = bVar;
        KSImageLoader.loadAppIcon(this.f14839b, C4322a.m17644l(this.f14849l), 16);
        float p = C4322a.m17648p(this.f14849l);
        if (p >= 3.0f) {
            this.f14840c.setScore(p);
            this.f14840c.setVisibility(0);
        } else {
            this.f14840c.setVisibility(8);
        }
        String o = C4322a.m17647o(this.f14849l);
        if (true ^ TextUtils.isEmpty(o)) {
            this.f14841d.setText(o);
            this.f14841d.setVisibility(0);
        } else {
            this.f14841d.setVisibility(8);
        }
        LayoutParams layoutParams = this.f14842e.getLayoutParams();
        layoutParams.height = i;
        this.f14842e.setLayoutParams(layoutParams);
        this.f14844g.setText(C4322a.m17645m(this.f14849l));
        this.f14845h.setText(C4322a.m17643k(this.f14849l));
        this.f14846i.mo24328a(C4322a.m17650r(this.f14849l), this.f14846i.getMax());
        this.f14847j.setVisibility(8);
        C4089b bVar2 = this.f14851n;
        if (bVar2 != null) {
            bVar2.mo23770a(getAppDownloadListener());
        }
        this.f14838a.setOnClickListener(this);
        this.f14843f.setOnClickListener(this);
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14848k, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (ActionBarPortraitHorizontal.this.f14850m != null) {
                    ActionBarPortraitHorizontal.this.f14850m.mo24748a();
                }
            }
        }, this.f14851n);
    }
}
