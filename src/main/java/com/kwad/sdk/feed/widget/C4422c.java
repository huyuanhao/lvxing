package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.p334h.p336b.C4185a.C4186a;
import com.kwad.sdk.core.p334h.p336b.C4187b;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.feed.widget.base.C4419a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import java.util.List;

/* renamed from: com.kwad.sdk.feed.widget.c */
public class C4422c extends C4419a implements OnClickListener {
    /* renamed from: f */
    private TextView f14498f;
    /* renamed from: g */
    private RatioFrameLayout f14499g;
    /* renamed from: h */
    private ImageView f14500h;
    /* renamed from: i */
    private C4089b f14501i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public TextProgressBar f14502j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public TextView f14503k;
    /* renamed from: l */
    private KsAppDownloadListener f14504l = new KsAppDownloadListener() {
        public void onDownloadFinished() {
            C4422c.this.f14503k.setVisibility(8);
            C4422c.this.f14502j.setVisibility(0);
            C4422c.this.f14502j.mo24328a(C4322a.m17630a(), C4422c.this.f14502j.getMax());
        }

        public void onIdle() {
            C4422c.this.f14503k.setText(C4322a.m17650r(C4422c.this.f14493b));
        }

        public void onInstalled() {
            C4422c.this.f14503k.setVisibility(8);
            C4422c.this.f14502j.setVisibility(0);
            C4422c.this.f14502j.mo24328a(C4322a.m17634b(), C4422c.this.f14502j.getMax());
        }

        public void onProgressUpdate(int i) {
            C4422c.this.f14503k.setVisibility(8);
            C4422c.this.f14502j.setVisibility(0);
            C4422c.this.f14502j.mo24328a(C4322a.m17631a(i), i);
        }
    };

    public C4422c(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18041a(long j) {
        int ceil = (int) Math.ceil((double) (((float) j) / 1000.0f));
        List<String> A = C4322a.m17625A(this.f14493b);
        if (A != null) {
            for (String equals : A) {
                if (String.valueOf(ceil).equals(equals)) {
                    C4143b.m17116a(this.f14492a, ceil);
                    return;
                }
            }
        }
    }

    /* renamed from: e */
    private void m18047e() {
        findViewById(C3809l.m15789a(getContext(), "ksad_ad_h5_container")).setVisibility(0);
        TextView textView = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_h5_open_btn"));
        ((TextView) findViewById(C3809l.m15789a(getContext(), "ksad_h5_desc"))).setText(C4322a.m17643k(this.f14493b));
        textView.setText(C4322a.m17650r(this.f14493b));
        findViewById(C3809l.m15789a(getContext(), "ksad_h5_open_cover")).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    /* renamed from: f */
    private void m18049f() {
        findViewById(C3809l.m15789a(getContext(), "ksad_ad_download_container")).setVisibility(0);
        ImageView imageView = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_app_icon"));
        TextView textView = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_desc"));
        ((TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_title"))).setText(C4322a.m17645m(this.f14493b));
        KSImageLoader.loadAppIcon(imageView, C4322a.m17644l(this.f14493b), 8);
        textView.setText(C4322a.m17643k(this.f14493b));
        this.f14503k = (TextView) findViewById(C3809l.m15789a(this.f14495d, "ksad_app_download_before"));
        this.f14503k.setText(C4322a.m17650r(this.f14493b));
        this.f14503k.setVisibility(0);
        this.f14503k.setOnClickListener(this);
        this.f14502j = (TextProgressBar) findViewById(C3809l.m15789a(getContext(), "ksad_app_download_btn"));
        this.f14502j.setTextDimen((float) C3817t.m15862a(getContext(), 11.0f));
        this.f14502j.setTextColor(-1);
        this.f14502j.setVisibility(8);
        this.f14502j.setOnClickListener(this);
        findViewById(C3809l.m15789a(getContext(), "ksad_app_download_cover")).setOnClickListener(this);
        this.f14501i = new C4089b(this.f14492a, null, this.f14504l);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18050g() {
        C4087a.m16967a(getContext(), this.f14492a, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                C4422c.this.mo24720c();
            }
        }, this.f14501i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24712a() {
        this.f14498f = (TextView) findViewById(C3809l.m15789a(this.f14495d, "ksad_ad_desc"));
        this.f14499g = (RatioFrameLayout) findViewById(C3809l.m15789a(this.f14495d, "ksad_video_container"));
        this.f14499g.setRatio(0.56f);
        this.f14500h = (ImageView) findViewById(C3809l.m15789a(this.f14495d, "ksad_ad_dislike"));
    }

    /* renamed from: a */
    public void mo24713a(AdTemplate adTemplate) {
        super.mo24713a(adTemplate);
        this.f14498f.setText(C4322a.m17643k(this.f14493b));
        if (C4322a.m17651s(this.f14493b)) {
            m18049f();
        } else {
            m18047e();
        }
        this.f14500h.setOnClickListener(this);
        setOnClickListener(this);
    }

    /* renamed from: a */
    public void mo24726a(boolean z) {
        final C4187b bVar = new C4187b(this.f14495d);
        bVar.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        String a = C4322a.m17632a(this.f14493b);
        if (!TextUtils.isEmpty(a)) {
            bVar.mo23944a(a, null);
            bVar.setVideoSoundEnable(z);
            C4438i iVar = new C4438i(this.f14495d, this.f14492a, bVar);
            iVar.setVideoPlayCallback(new C4186a() {
                /* renamed from: a */
                public void mo23940a() {
                    C4143b.m17136e(C4422c.this.f14492a);
                }

                /* renamed from: a */
                public void mo23941a(long j) {
                    C4422c.this.m18041a(j);
                }

                /* renamed from: b */
                public void mo23942b() {
                    C4143b.m17138f(C4422c.this.f14492a);
                }
            });
            bVar.setController(iVar);
            bVar.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (bVar.mo23947d()) {
                        bVar.mo23943a();
                    } else {
                        C4422c.this.m18050g();
                    }
                }
            });
            this.f14499g.removeAllViews();
            this.f14499g.addView(bVar);
        }
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return C3809l.m15792b(this.f14495d, "ksad_feed_text_above_video");
    }

    public void onClick(View view) {
        if (view == this.f14500h) {
            mo24721d();
        } else {
            m18050g();
        }
    }
}
