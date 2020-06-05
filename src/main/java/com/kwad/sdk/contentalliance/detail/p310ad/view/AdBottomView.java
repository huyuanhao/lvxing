package com.kwad.sdk.contentalliance.detail.p310ad.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.C4375b;
import com.kwad.sdk.draw.view.DrawCardApp;
import com.kwad.sdk.draw.view.DrawCardApp.C4380a;
import com.kwad.sdk.draw.view.DrawCardH5;
import com.kwad.sdk.draw.view.DrawCardH5.C4382a;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.contentalliance.detail.ad.view.AdBottomView */
public class AdBottomView extends FrameLayout {
    /* renamed from: a */
    private AdBaseFrameLayout f13093a;
    /* renamed from: b */
    private Context f13094b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public AdInfo f13095c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public AdTemplate f13096d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C4089b f13097e;
    /* renamed from: f */
    private KsAppDownloadListener f13098f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public ViewGroup f13099g;
    /* renamed from: h */
    private TextView f13100h;
    /* renamed from: i */
    private TextView f13101i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public TextView f13102j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public DrawDownloadProgressBar f13103k;
    /* renamed from: l */
    private boolean f13104l;
    /* renamed from: m */
    private boolean f13105m;
    /* renamed from: n */
    private ValueAnimator f13106n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public int f13107o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public int f13108p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public int f13109q;
    /* renamed from: r */
    private boolean f13110r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public DrawCardApp f13111s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public DrawCardH5 f13112t;
    /* renamed from: u */
    private C3990f f13113u;

    public AdBottomView(Context context) {
        super(context);
        m16068a(context);
    }

    public AdBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16068a(context);
    }

    public AdBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16068a(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16067a(int i) {
        C4143b.m17117a(this.f13096d, i, this.f13093a.getTouchCoords());
    }

    /* renamed from: a */
    private void m16068a(Context context) {
        this.f13094b = context;
        Context context2 = this.f13094b;
        inflate(context2, C3809l.m15792b(context2, "ksad_content_alliance_detail_ad_bottom"), this);
        this.f13099g = (ViewGroup) findViewById(C3809l.m15789a(this.f13094b, "ksad_ad_normal_container"));
        this.f13100h = (TextView) findViewById(C3809l.m15789a(this.f13094b, "ksad_ad_normal_title"));
        this.f13101i = (TextView) findViewById(C3809l.m15789a(this.f13094b, "ksad_ad_normal_des"));
        this.f13102j = (TextView) findViewById(C3809l.m15789a(this.f13094b, "ksad_ad_normal_convert_btn"));
        this.f13102j.setVisibility(8);
        this.f13103k = (DrawDownloadProgressBar) findViewById(C3809l.m15789a(this.f13094b, "ksad_ad_light_convert_btn"));
        this.f13103k.setTextSize(16);
        this.f13103k.setVisibility(8);
        this.f13111s = (DrawCardApp) findViewById(C3809l.m15789a(this.f13094b, "ksad_card_app_container"));
        this.f13112t = (DrawCardH5) findViewById(C3809l.m15789a(this.f13094b, "ksad_card_h5_container"));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16072c() {
        if (!this.f13104l && !this.f13105m) {
            this.f13104l = true;
            this.f13102j.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AdBottomView.this.m16073d();
                    C4087a.m16967a(AdBottomView.this.getContext(), AdBottomView.this.f13096d, new C4088a() {
                        /* renamed from: a */
                        public void mo23360a() {
                            AdBottomView.this.m16067a(1);
                        }
                    }, AdBottomView.this.f13097e);
                }
            });
            m16076e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16073d() {
        if (!this.f13105m) {
            this.f13105m = true;
            this.f13103k.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C4087a.m16967a(AdBottomView.this.getContext(), AdBottomView.this.f13096d, new C4088a() {
                        /* renamed from: a */
                        public void mo23360a() {
                            AdBottomView.this.m16067a(1);
                        }
                    }, AdBottomView.this.f13097e);
                }
            });
            this.f13102j.setVisibility(8);
            this.f13103k.setVisibility(0);
        }
    }

    /* renamed from: e */
    private void m16076e() {
        this.f13102j.setVisibility(0);
        this.f13106n = C4375b.m17853a(this.f13102j, 0, C3817t.m15862a(this.f13094b, 44.0f));
        this.f13106n.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f13106n.setDuration(300);
        this.f13106n.start();
    }

    /* renamed from: f */
    private void m16078f() {
        ValueAnimator valueAnimator = this.f13106n;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f13106n.cancel();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16080g() {
        if (!this.f13110r) {
            this.f13110r = true;
            if (!(this.f13095c.status == DOWNLOADSTAUS.START || this.f13095c.status == DOWNLOADSTAUS.DOWNLOADING || this.f13095c.status == DOWNLOADSTAUS.PROGRESS)) {
                if (C4322a.m17651s(this.f13095c)) {
                    m16081h();
                } else {
                    m16084i();
                }
            }
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f13098f == null) {
            this.f13098f = new KsAppDownloadListener() {
                public void onDownloadFinished() {
                    AdBottomView.this.f13102j.setText(C4322a.m17630a());
                    AdBottomView.this.f13103k.mo24567a(C4322a.m17630a(), AdBottomView.this.f13103k.getMax());
                }

                public void onIdle() {
                    AdBottomView.this.f13102j.setText(C4322a.m17650r(AdBottomView.this.f13095c));
                    AdBottomView.this.f13103k.mo24567a(C4322a.m17650r(AdBottomView.this.f13095c), AdBottomView.this.f13103k.getMax());
                }

                public void onInstalled() {
                    AdBottomView.this.f13102j.setText(C4322a.m17634b());
                    AdBottomView.this.f13103k.mo24567a(C4322a.m17634b(), AdBottomView.this.f13103k.getMax());
                }

                public void onProgressUpdate(int i) {
                    TextView b = AdBottomView.this.f13102j;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    String str = "%";
                    sb.append(str);
                    b.setText(sb.toString());
                    DrawDownloadProgressBar c = AdBottomView.this.f13103k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    sb2.append(str);
                    c.mo24567a(sb2.toString(), i);
                }
            };
        }
        return this.f13098f;
    }

    /* renamed from: h */
    private void m16081h() {
        this.f13111s.mo24558a(this.f13096d, (C4380a) new C4380a() {
            /* renamed from: a */
            public void mo23363a() {
                AdBottomView.this.f13099g.setVisibility(0);
                AdBottomView.this.f13111s.setVisibility(8);
            }

            /* renamed from: b */
            public void mo23364b() {
                AdBottomView.this.m16067a(29);
            }
        });
        this.f13099g.setVisibility(8);
        this.f13111s.setVisibility(0);
        this.f13111s.mo24559b();
    }

    /* renamed from: i */
    private void m16084i() {
        this.f13112t.mo24563a(this.f13096d, (C4382a) new C4382a() {
            /* renamed from: a */
            public void mo23365a() {
                AdBottomView.this.f13099g.setVisibility(0);
                AdBottomView.this.f13112t.setVisibility(8);
            }

            /* renamed from: b */
            public void mo23366b() {
                AdBottomView.this.m16067a(29);
            }
        });
        this.f13099g.setVisibility(8);
        this.f13112t.setVisibility(0);
        this.f13112t.mo24564b();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m16086j() {
        C4143b.m17123a(this.f13096d, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo23350a() {
        this.f13097e = null;
    }

    /* renamed from: a */
    public void mo23351a(AdTemplate adTemplate, AdInfo adInfo) {
        this.f13096d = adTemplate;
        this.f13095c = adInfo;
        mo23350a();
        mo23352b();
        this.f13101i.setText(C4322a.m17643k(this.f13095c));
        this.f13102j.setText(C4322a.m17650r(this.f13095c));
        this.f13103k.mo24567a(C4322a.m17650r(this.f13095c), this.f13103k.getMax());
        if (C4322a.m17651s(this.f13095c)) {
            this.f13100h.setText(C4322a.m17645m(this.f13095c));
            this.f13097e = new C4089b(this.f13096d, getAppDownloadListener());
            this.f13100h.setVisibility(0);
        } else {
            this.f13100h.setVisibility(8);
        }
        int[] D = C4322a.m17628D(this.f13095c);
        int i = 3;
        if (D.length < 3) {
            this.f13107o = 3;
        } else {
            this.f13107o = D[0] > 0 ? D[0] : 3;
            this.f13108p = (D[1] > 0 ? D[1] : 3) + this.f13107o;
            if (D[2] > 0) {
                i = D[2];
            }
            this.f13109q = i + this.f13108p;
        }
        this.f13099g.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AdBottomView.this.m16073d();
                C4087a.m16967a(AdBottomView.this.getContext(), AdBottomView.this.f13096d, new C4088a() {
                    /* renamed from: a */
                    public void mo23360a() {
                        AdBottomView.this.m16067a(1);
                    }
                }, AdBottomView.this.f13097e);
            }
        });
    }

    /* renamed from: b */
    public void mo23352b() {
        m16078f();
        this.f13102j.setVisibility(8);
        this.f13103k.setVisibility(8);
        this.f13104l = false;
        this.f13105m = false;
        this.f13099g.setVisibility(0);
        this.f13110r = false;
        this.f13111s.mo24557a();
        this.f13111s.setVisibility(8);
        this.f13112t.mo24562a();
        this.f13112t.setVisibility(8);
    }

    public C3989e getVideoPlayStateListener() {
        if (this.f13113u == null) {
            this.f13113u = new C3990f() {
                /* renamed from: a */
                public void mo23345a(long j, long j2) {
                    int i = (j2 > ((long) (AdBottomView.this.f13109q * 1000)) ? 1 : (j2 == ((long) (AdBottomView.this.f13109q * 1000)) ? 0 : -1));
                    AdBottomView adBottomView = AdBottomView.this;
                    if (i >= 0) {
                        adBottomView.m16080g();
                        return;
                    }
                    int i2 = (j2 > ((long) (adBottomView.f13108p * 1000)) ? 1 : (j2 == ((long) (adBottomView.f13108p * 1000)) ? 0 : -1));
                    AdBottomView adBottomView2 = AdBottomView.this;
                    if (i2 >= 0) {
                        adBottomView2.m16073d();
                    } else if (j2 >= ((long) (adBottomView2.f13107o * 1000))) {
                        AdBottomView.this.m16072c();
                    }
                }

                /* renamed from: b */
                public void mo23346b() {
                    AdBottomView.this.f13099g.setVisibility(8);
                    AdBottomView.this.f13111s.setVisibility(8);
                }

                /* renamed from: c */
                public void mo23347c() {
                    AdBottomView.this.m16086j();
                }
            };
        }
        return this.f13113u;
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f13093a = adBaseFrameLayout;
    }
}
