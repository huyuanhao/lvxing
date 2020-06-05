package com.kwad.sdk.draw.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.p334h.p336b.C4187b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4323b;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.draw.C4375b;
import com.kwad.sdk.draw.view.C4387b.C4388a;
import com.kwad.sdk.draw.view.DrawCardApp.C4380a;
import com.kwad.sdk.draw.view.DrawCardH5.C4382a;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.p307b.C3823a;
import com.kwad.sdk.p307b.C3823a.C3826a;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.draw.view.c */
public class C4389c extends C4386a {
    /* renamed from: A */
    private C3823a f14381A;
    /* renamed from: B */
    private C3826a f14382B = new C3826a() {
        /* renamed from: a */
        public void mo23225a() {
            if (C4389c.this.f14386d != null) {
                C4389c.this.f14386d.mo24552a();
            }
        }
    };
    /* renamed from: a */
    private Context f14383a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AdTemplate f14384b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public AdInfo f14385c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C4401a f14386d;
    /* renamed from: e */
    private FrameLayout f14387e;
    /* renamed from: f */
    private C4387b f14388f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public ImageView f14389g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public ViewGroup f14390h;
    /* renamed from: i */
    private TextView f14391i;
    /* renamed from: j */
    private TextView f14392j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public TextView f14393k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public DrawDownloadProgressBar f14394l;
    /* renamed from: m */
    private boolean f14395m;
    /* renamed from: n */
    private boolean f14396n;
    /* renamed from: o */
    private ValueAnimator f14397o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public int f14398p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public int f14399q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public int f14400r;
    /* renamed from: s */
    private boolean f14401s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public DrawCardApp f14402t;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public DrawCardH5 f14403u;
    /* renamed from: v */
    private DrawVideoTailFrame f14404v;
    /* renamed from: w */
    private C4388a f14405w;
    /* access modifiers changed from: private */
    /* renamed from: x */
    public C4089b f14406x;
    /* renamed from: y */
    private KsAppDownloadListener f14407y;
    /* renamed from: z */
    private FrameLayout f14408z;

    /* renamed from: com.kwad.sdk.draw.view.c$a */
    public interface C4401a {
        /* renamed from: a */
        void mo24552a();

        /* renamed from: b */
        void mo24553b();
    }

    public C4389c(Context context, AdTemplate adTemplate) {
        super(context);
        this.f14383a = context;
        this.f14384b = adTemplate;
        this.f14385c = C4324c.m17668e(this.f14384b);
        m17920f();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17911a(int i) {
        C4143b.m17117a(this.f14384b, i, getTouchCoords());
        C4401a aVar = this.f14386d;
        if (aVar != null) {
            aVar.mo24552a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17912a(long j) {
        int ceil = (int) Math.ceil((double) (((float) j) / 1000.0f));
        List<String> A = C4322a.m17625A(this.f14385c);
        if (A != null) {
            for (String equals : A) {
                if (String.valueOf(ceil).equals(equals)) {
                    C4143b.m17116a(this.f14384b, ceil);
                    return;
                }
            }
        }
    }

    /* renamed from: f */
    private void m17920f() {
        Context context = this.f14383a;
        inflate(context, C3809l.m15792b(context, "ksad_draw_video"), this);
        this.f14387e = (FrameLayout) findViewById(C3809l.m15789a(this.f14383a, "ksad_video_container"));
        this.f14389g = (ImageView) findViewById(C3809l.m15789a(this.f14383a, "ksad_video_thumb"));
        this.f14390h = (ViewGroup) findViewById(C3809l.m15789a(this.f14383a, "ksad_ad_normal_container"));
        this.f14391i = (TextView) findViewById(C3809l.m15789a(this.f14383a, "ksad_ad_normal_title"));
        this.f14392j = (TextView) findViewById(C3809l.m15789a(this.f14383a, "ksad_ad_normal_des"));
        this.f14393k = (TextView) findViewById(C3809l.m15789a(this.f14383a, "ksad_ad_normal_convert_btn"));
        this.f14393k.setVisibility(8);
        this.f14394l = (DrawDownloadProgressBar) findViewById(C3809l.m15789a(this.f14383a, "ksad_ad_light_convert_btn"));
        this.f14394l.setTextSize(16);
        this.f14394l.setVisibility(8);
        this.f14402t = (DrawCardApp) findViewById(C3809l.m15789a(this.f14383a, "ksad_card_app_container"));
        this.f14403u = (DrawCardH5) findViewById(C3809l.m15789a(this.f14383a, "ksad_card_h5_container"));
        this.f14404v = (DrawVideoTailFrame) findViewById(C3809l.m15789a(this.f14383a, "ksad_video_tail_frame"));
        this.f14408z = (FrameLayout) C3817t.m15863a((View) this, "ksad_play_end_web_card_container");
        m17938o();
        m17922g();
        this.f14404v.mo24573a(this.f14384b);
        this.f14404v.setAdBaseFrameLayout(this);
        if (C4323b.m17662d(this.f14384b)) {
            this.f14381A = new C3823a();
            this.f14381A.mo23219a(this.f14382B);
        }
    }

    /* renamed from: g */
    private void m17922g() {
        KSImageLoader.loadImage(this.f14389g, C4322a.m17638f(this.f14385c));
        if (C4322a.m17651s(this.f14385c)) {
            this.f14391i.setText(C4322a.m17645m(this.f14385c));
            this.f14391i.setVisibility(0);
        } else {
            this.f14391i.setVisibility(8);
        }
        this.f14392j.setText(C4322a.m17643k(this.f14385c));
        this.f14393k.setText(C4322a.m17650r(this.f14385c));
        this.f14394l.mo24567a(C4322a.m17650r(this.f14385c), this.f14394l.getMax());
        int[] D = C4322a.m17628D(this.f14385c);
        int i = 3;
        if (D.length < 3) {
            this.f14398p = 3;
        } else {
            this.f14398p = D[0] > 0 ? D[0] : 3;
            this.f14399q = (D[1] > 0 ? D[1] : 3) + this.f14398p;
            if (D[2] > 0) {
                i = D[2];
            }
            this.f14400r = i + this.f14399q;
        }
        this.f14390h.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C4389c.this.m17941q();
                C4087a.m16967a(C4389c.this.getContext(), C4389c.this.f14384b, new C4088a() {
                    /* renamed from: a */
                    public void mo23360a() {
                        C4389c.this.m17911a(1);
                    }
                }, C4389c.this.f14406x);
            }
        });
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f14407y == null) {
            this.f14407y = new KsAppDownloadListener() {
                public void onDownloadFinished() {
                    C4389c.this.f14393k.setText(C4322a.m17630a());
                    C4389c.this.f14394l.mo24567a(C4322a.m17630a(), C4389c.this.f14394l.getMax());
                }

                public void onIdle() {
                    C4389c.this.f14393k.setText(C4322a.m17650r(C4389c.this.f14385c));
                    C4389c.this.f14394l.mo24567a(C4322a.m17650r(C4389c.this.f14385c), C4389c.this.f14394l.getMax());
                }

                public void onInstalled() {
                    C4389c.this.f14393k.setText(C4322a.m17634b());
                    C4389c.this.f14394l.mo24567a(C4322a.m17634b(), C4389c.this.f14394l.getMax());
                }

                public void onProgressUpdate(int i) {
                    TextView c = C4389c.this.f14393k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    String str = "%";
                    sb.append(str);
                    c.setText(sb.toString());
                    DrawDownloadProgressBar d = C4389c.this.f14394l;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    sb2.append(str);
                    d.mo24567a(sb2.toString(), i);
                }
            };
        }
        return this.f14407y;
    }

    private C4388a getVideoPlayCallback() {
        if (this.f14405w == null) {
            this.f14405w = new C4388a() {
                /* renamed from: a */
                public void mo24592a() {
                    C4389c.this.f14389g.animate().alpha(0.0f).setDuration(200).setStartDelay(300).start();
                    C4389c.this.m17949w();
                    C4143b.m17136e(C4389c.this.f14384b);
                }

                /* renamed from: a */
                public void mo24593a(long j) {
                    C4389c.this.m17912a(j);
                    if (j >= ((long) (C4389c.this.f14400r * 1000))) {
                        C4389c.this.m17946t();
                    } else if (j >= ((long) (C4389c.this.f14399q * 1000))) {
                        C4389c.this.m17941q();
                    } else if (j >= ((long) (C4389c.this.f14398p * 1000))) {
                        C4389c.this.m17940p();
                    }
                }

                /* renamed from: b */
                public void mo24594b() {
                    C4143b.m17138f(C4389c.this.f14384b);
                    C4389c.this.f14390h.setVisibility(8);
                    C4389c.this.f14402t.setVisibility(8);
                    C4389c.this.m17934m();
                }
            };
        }
        return this.f14405w;
    }

    /* renamed from: h */
    private void m17924h() {
        if (this.f14406x == null) {
            this.f14406x = new C4089b(this.f14384b);
        }
    }

    /* renamed from: i */
    private void m17925i() {
        C4089b bVar = this.f14406x;
        if (bVar != null) {
            bVar.mo23782d();
            this.f14406x = null;
        }
    }

    /* renamed from: j */
    private void m17928j() {
        C4089b bVar = this.f14406x;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f14407y;
            if (ksAppDownloadListener == null) {
                this.f14407y = getAppDownloadListener();
                this.f14406x.mo23779c(this.f14407y);
                return;
            }
            bVar.mo23770a(ksAppDownloadListener);
        }
    }

    /* renamed from: k */
    private void m17930k() {
        this.f14404v.setApkDownloadHelper(this.f14406x);
        C3823a aVar = this.f14381A;
        if (aVar != null) {
            aVar.mo23217a(this.f14408z, this, this.f14384b, this.f14406x);
            this.f14381A.mo23216a();
        }
    }

    /* renamed from: l */
    private void m17931l() {
        this.f14404v.setVisibility(8);
        this.f14404v.mo24574b();
        this.f14408z.setVisibility(8);
        C3823a aVar = this.f14381A;
        if (aVar != null) {
            aVar.mo23222d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m17934m() {
        C3823a aVar = this.f14381A;
        if (aVar == null || !aVar.mo23220b()) {
            this.f14404v.mo24572a();
            this.f14404v.setVisibility(0);
        }
    }

    /* renamed from: n */
    private void m17935n() {
        this.f14389g.setAlpha(1.0f);
        this.f14389g.animate().cancel();
        m17945s();
        this.f14393k.setVisibility(8);
        this.f14394l.setVisibility(8);
        this.f14395m = false;
        this.f14396n = false;
        this.f14390h.setVisibility(0);
        this.f14401s = false;
        this.f14402t.mo24557a();
        this.f14402t.setVisibility(8);
        this.f14403u.mo24562a();
        this.f14403u.setVisibility(8);
    }

    /* renamed from: o */
    private void m17938o() {
        C4187b bVar = new C4187b(this.f14383a);
        bVar.mo23944a(C4322a.m17632a(C4324c.m17668e(this.f14384b)), null);
        bVar.setPortraitFullscreen(true);
        bVar.setVideoSoundEnable(true);
        this.f14388f = new C4387b(this.f14383a, this.f14384b, bVar);
        this.f14388f.setVideoPlayCallback(getVideoPlayCallback());
        bVar.setController(this.f14388f);
        this.f14387e.removeAllViews();
        this.f14387e.addView(bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m17940p() {
        if (!this.f14395m && !this.f14396n) {
            this.f14395m = true;
            this.f14393k.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C4389c.this.m17941q();
                    C4087a.m16967a(C4389c.this.getContext(), C4389c.this.f14384b, new C4088a() {
                        /* renamed from: a */
                        public void mo23360a() {
                            C4389c.this.m17911a(1);
                        }
                    }, C4389c.this.f14406x);
                }
            });
            m17944r();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m17941q() {
        if (!this.f14396n) {
            this.f14396n = true;
            this.f14394l.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C4087a.m16967a(C4389c.this.getContext(), C4389c.this.f14384b, new C4088a() {
                        /* renamed from: a */
                        public void mo23360a() {
                            C4389c.this.m17911a(1);
                        }
                    }, C4389c.this.f14406x);
                }
            });
            this.f14393k.setVisibility(8);
            this.f14394l.setVisibility(0);
        }
    }

    /* renamed from: r */
    private void m17944r() {
        this.f14393k.setVisibility(0);
        this.f14397o = C4375b.m17853a(this.f14393k, 0, C3817t.m15862a(this.f14383a, 44.0f));
        this.f14397o.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f14397o.setDuration(300);
        this.f14397o.start();
    }

    /* renamed from: s */
    private void m17945s() {
        ValueAnimator valueAnimator = this.f14397o;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f14397o.cancel();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m17946t() {
        if (!this.f14401s) {
            this.f14401s = true;
            if (!(C4324c.m17668e(this.f14384b).status == DOWNLOADSTAUS.START || C4324c.m17668e(this.f14384b).status == DOWNLOADSTAUS.DOWNLOADING || C4324c.m17668e(this.f14384b).status == DOWNLOADSTAUS.PROGRESS)) {
                if (C4322a.m17651s(this.f14385c)) {
                    m17947u();
                } else {
                    m17948v();
                }
            }
        }
    }

    /* renamed from: u */
    private void m17947u() {
        this.f14402t.mo24558a(this.f14384b, (C4380a) new C4380a() {
            /* renamed from: a */
            public void mo23363a() {
                C4389c.this.f14390h.setVisibility(0);
                C4389c.this.f14402t.setVisibility(8);
            }

            /* renamed from: b */
            public void mo23364b() {
                C4389c.this.m17911a(29);
            }
        });
        this.f14390h.setVisibility(8);
        this.f14402t.setVisibility(0);
        this.f14402t.mo24559b();
    }

    /* renamed from: v */
    private void m17948v() {
        this.f14403u.mo24563a(this.f14384b, (C4382a) new C4382a() {
            /* renamed from: a */
            public void mo23365a() {
                C4389c.this.f14390h.setVisibility(0);
                C4389c.this.f14403u.setVisibility(8);
            }

            /* renamed from: b */
            public void mo23366b() {
                C4389c.this.m17911a(29);
            }
        });
        this.f14390h.setVisibility(8);
        this.f14403u.setVisibility(0);
        this.f14403u.mo24564b();
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m17949w() {
        if (!this.f14384b.mPvReported) {
            C4401a aVar = this.f14386d;
            if (aVar != null) {
                aVar.mo24553b();
            }
        }
        C4143b.m17123a(this.f14384b, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24578a() {
        m17935n();
        m17925i();
        m17931l();
        C4387b bVar = this.f14388f;
        if (bVar != null) {
            bVar.mo24590f();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo24579b() {
        m17935n();
        m17924h();
        m17928j();
        m17930k();
        m17930k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo24580c() {
        C4387b bVar = this.f14388f;
        if (bVar != null) {
            bVar.mo24588d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo24581d() {
        C4387b bVar = this.f14388f;
        if (bVar != null) {
            bVar.mo24589e();
        }
    }

    /* renamed from: e */
    public void mo24595e() {
        m17938o();
    }

    public void setAdClickListener(C4401a aVar) {
        this.f14386d = aVar;
    }
}
