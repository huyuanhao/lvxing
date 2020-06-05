package com.kwad.sdk.fullscreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.kwad.sdk.core.diskcache.p322b.C4079a;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p320d.C4066a;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.p334h.C4164a;
import com.kwad.sdk.core.p334h.C4183b;
import com.kwad.sdk.core.p334h.C4183b.C4184a;
import com.kwad.sdk.core.page.widget.SafeTextureView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4323b;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.export.p347i.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3812o;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.p306a.C3818u;
import com.kwad.sdk.p306a.C3818u.C3819a;
import com.kwad.sdk.p307b.C3823a;
import com.kwad.sdk.p307b.C3823a.C3826a;
import com.kwad.sdk.reward.C4527a;
import com.kwad.sdk.reward.p351a.C4529b;
import com.kwad.sdk.reward.p351a.C4530c;
import com.kwad.sdk.reward.p352b.C4532a;
import com.kwad.sdk.reward.p352b.C4535b;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.C4545a;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.C4548a;
import com.kwad.sdk.reward.widget.actionbar.ActionBarH5;
import com.kwad.sdk.reward.widget.actionbar.ActionBarH5.C4550a;
import com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical;
import com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.C4553a;
import com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal;
import com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.C4556a;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.C4559a;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.C4562a;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.C4565a;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.C4568a;
import com.kwad.sdk.video.VideoPlayConfig;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

public class KsFullScreenVideoActivity extends C4066a<C4527a> implements OnClickListener, C3819a {
    /* renamed from: d */
    public static FullScreenVideoAdInteractionListener f14543d;
    /* access modifiers changed from: private */
    /* renamed from: A */
    public boolean f14544A;
    /* renamed from: B */
    private C4089b f14545B;
    /* renamed from: C */
    private long f14546C;
    /* renamed from: D */
    private C3826a f14547D = new C3826a() {
        /* renamed from: a */
        public void mo23225a() {
            if (KsFullScreenVideoActivity.f14543d != null) {
                C4065b.m16867b("FullScreenVideo", "onAdClicked");
                KsFullScreenVideoActivity.f14543d.onAdClicked();
            }
        }
    };
    /* renamed from: E */
    private C4529b f14548E = new C4529b() {
        /* renamed from: a */
        public void mo24759a() {
            if (KsFullScreenVideoActivity.f14543d != null) {
                C4065b.m16867b("FullScreenVideo", "onAdClicked");
                KsFullScreenVideoActivity.f14543d.onAdClicked();
            }
        }
    };
    /* renamed from: e */
    private AdTemplate f14549e;
    /* renamed from: f */
    private AdInfo f14550f;
    /* renamed from: g */
    private VideoPlayConfig f14551g;
    /* renamed from: h */
    private JSONObject f14552h;
    /* renamed from: i */
    private final C3818u f14553i = new C3818u(this);
    /* renamed from: j */
    private C4183b f14554j;
    /* renamed from: k */
    private SafeTextureView f14555k;
    /* renamed from: l */
    private AdBaseFrameLayout f14556l;
    /* renamed from: m */
    private ImageView f14557m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public View f14558n;
    /* renamed from: o */
    private TextView f14559o;
    /* renamed from: p */
    private TextView f14560p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public ImageView f14561q;
    /* renamed from: r */
    private View f14562r;
    /* renamed from: s */
    private View f14563s;
    /* renamed from: t */
    private TailFramePortraitHorizontal f14564t;
    /* renamed from: u */
    private TailFramePortraitVertical f14565u;
    /* renamed from: v */
    private TailFrameLandscapeHorizontal f14566v;
    /* renamed from: w */
    private TailFrameLandscapeVertical f14567w;
    /* renamed from: x */
    private boolean f14568x;
    /* renamed from: y */
    private boolean f14569y;
    /* renamed from: z */
    private boolean f14570z;

    /* renamed from: A */
    private void m18096A() {
        TailFramePortraitHorizontal tailFramePortraitHorizontal = this.f14564t;
        if (tailFramePortraitHorizontal != null) {
            tailFramePortraitHorizontal.mo24845a();
            this.f14564t.setVisibility(8);
        }
        TailFramePortraitVertical tailFramePortraitVertical = this.f14565u;
        if (tailFramePortraitVertical != null) {
            tailFramePortraitVertical.mo24848a();
            this.f14565u.setVisibility(8);
        }
        TailFrameLandscapeVertical tailFrameLandscapeVertical = this.f14567w;
        if (tailFrameLandscapeVertical != null) {
            tailFrameLandscapeVertical.mo24842a();
            this.f14567w.setVisibility(8);
        }
        TailFrameLandscapeHorizontal tailFrameLandscapeHorizontal = this.f14566v;
        if (tailFrameLandscapeHorizontal != null) {
            tailFrameLandscapeHorizontal.mo24839a();
            this.f14566v.setVisibility(8);
        }
    }

    /* renamed from: B */
    private void m18097B() {
        if (f14543d != null) {
            C4065b.m16867b("FullScreenVideo", "onVideoPlayStart");
            f14543d.onVideoPlayStart();
            C4143b.m17139f(this.f14549e, this.f14552h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m18098C() {
        if (f14543d != null) {
            C4065b.m16867b("FullScreenVideo", "onVideoPlayEnd");
            f14543d.onVideoPlayEnd();
            C4143b.m17141g(this.f14549e, this.f14552h);
        }
    }

    /* renamed from: D */
    private void m18099D() {
        if (f14543d != null) {
            C4065b.m16867b("FullScreenVideo", "onSkippedVideo");
            f14543d.onSkippedVideo();
            C4143b.m17143h(this.f14549e, this.f14552h);
        }
    }

    /* renamed from: E */
    private void m18100E() {
        if (f14543d != null && !this.f14570z) {
            this.f14570z = true;
            C4065b.m16867b("FullScreenVideo", "onPageDismiss");
            f14543d.onPageDismiss();
            C4143b.m17120a(this.f14549e, 6, this.f14552h);
        }
    }

    /* renamed from: F */
    private void m18101F() {
        C4143b.m17131c(this.f14549e, 18, this.f14552h);
    }

    /* renamed from: G */
    private void m18102G() {
        if (this.f13675b != null) {
            for (C4530c a : this.f13675b.f14764h) {
                a.mo24817a();
            }
        }
    }

    /* renamed from: H */
    private boolean m18103H() {
        if (this.f13675b == null || this.f13675b.f14763g == null) {
            return false;
        }
        return this.f13675b.f14763g.mo23220b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18104a(float f) {
        if (this.f14560p.getVisibility() == 0) {
            LayoutParams layoutParams = (LayoutParams) this.f14560p.getLayoutParams();
            layoutParams.rightMargin = (int) (((float) C3817t.m15862a((Context) this, 40.0f)) * f);
            this.f14560p.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    private void m18105a(int i) {
        this.f14563s.setVisibility(8);
        ActionBarLandscapeVertical actionBarLandscapeVertical = (ActionBarLandscapeVertical) findViewById(C3809l.m15789a(this, "ksad_actionbar_landscape_vertical"));
        actionBarLandscapeVertical.mo24835a(this.f14549e, this.f14545B, new C4553a() {
            /* renamed from: a */
            public void mo24747a() {
                KsFullScreenVideoActivity.this.m18125d(1);
            }
        }, i);
        actionBarLandscapeVertical.setVisibility(0);
        this.f14562r = actionBarLandscapeVertical;
    }

    /* renamed from: a */
    private void m18106a(int i, int i2) {
        int g = C3812o.m15835g(this);
        int h = C3812o.m15837h(this);
        if (h <= g) {
            g = h;
        }
        if (this.f14551g.showLandscape) {
            if (i <= i2) {
                ViewGroup.LayoutParams layoutParams = this.f14555k.getLayoutParams();
                int i3 = (int) ((((float) i) / (((float) i2) * 1.0f)) * ((float) g));
                layoutParams.width = i3;
                layoutParams.height = g;
                this.f14555k.setLayoutParams(layoutParams);
                if (!C4322a.m17651s(this.f14550f) || !C4322a.m17627C(this.f14550f)) {
                    m18146x();
                    if (!C4322a.m17626B(this.f14550f)) {
                        return;
                    }
                    this.f14556l.setOnClickListener(this);
                    return;
                }
                m18105a(i3);
                return;
            }
        } else if (i2 <= i) {
            ViewGroup.LayoutParams layoutParams2 = this.f14555k.getLayoutParams();
            int i4 = (int) ((((float) i2) / (((float) i) * 1.0f)) * ((float) g));
            layoutParams2.width = g;
            layoutParams2.height = i4;
            this.f14555k.setLayoutParams(layoutParams2);
            if (!C4322a.m17651s(this.f14550f) || !C4322a.m17627C(this.f14550f)) {
                m18146x();
                if (!C4322a.m17626B(this.f14550f)) {
                    return;
                }
                this.f14556l.setOnClickListener(this);
                return;
            }
            m18116b(i4);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.f14555k.getLayoutParams();
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        this.f14555k.setLayoutParams(layoutParams3);
        m18146x();
    }

    /* renamed from: a */
    public static void m18107a(Context context, AdTemplate adTemplate, VideoPlayConfig videoPlayConfig, FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Intent intent = new Intent(context, KsFullScreenVideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        intent.putExtra("key_video_play_config", videoPlayConfig);
        f14543d = fullScreenVideoAdInteractionListener;
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18108a(C4183b bVar) {
        this.f14557m.setOnClickListener(this);
        m18133k();
        m18106a(bVar.mo23872f(), bVar.mo23873g());
        m18097B();
    }

    /* renamed from: a */
    private void m18114a(VideoPlayConfig videoPlayConfig) {
        setRequestedOrientation(!videoPlayConfig.showLandscape);
        if (!TextUtils.isEmpty(videoPlayConfig.showScene)) {
            this.f14552h = null;
            this.f14552h = new JSONObject();
            C3800e.m15752a(this.f14552h, "ext_showscene", videoPlayConfig.showScene);
        }
    }

    /* renamed from: b */
    private void m18116b(int i) {
        this.f14563s.setVisibility(8);
        ActionBarPortraitHorizontal actionBarPortraitHorizontal = (ActionBarPortraitHorizontal) findViewById(C3809l.m15789a(this, "ksad_actionbar_portrait_horizontal"));
        actionBarPortraitHorizontal.mo24837a(this.f14549e, this.f14545B, new C4556a() {
            /* renamed from: a */
            public void mo24748a() {
                KsFullScreenVideoActivity.this.m18125d(1);
            }
        }, i);
        actionBarPortraitHorizontal.setVisibility(0);
        this.f14562r = actionBarPortraitHorizontal;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18117b(int i, int i2) {
        m18121c(i, i2);
        finish();
    }

    /* renamed from: c */
    private void m18120c(int i) {
        this.f14559o.setText(String.valueOf(i));
        this.f14559o.setVisibility(0);
    }

    /* renamed from: c */
    private void m18121c(int i, int i2) {
        if (f14543d != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoPlayError code：");
            sb.append(i);
            sb.append("--extra：");
            sb.append(i2);
            C4065b.m16867b("FullScreenVideo", sb.toString());
            f14543d.onVideoPlayError(i, i2);
        }
    }

    /* renamed from: c */
    private boolean m18122c() {
        String sb;
        Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
        String str = "FullScreenVideo";
        if (!(serializableExtra instanceof VideoPlayConfig)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("data is not instanceof VideoPlayConfig:");
            sb2.append(serializableExtra);
            sb = sb2.toString();
        } else {
            Serializable serializableExtra2 = getIntent().getSerializableExtra("key_template");
            if (!(serializableExtra2 instanceof AdTemplate)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("data is not instanceof AdTemplate:");
                sb3.append(serializableExtra2);
                sb = sb3.toString();
            } else {
                this.f14549e = (AdTemplate) serializableExtra2;
                this.f14550f = C4324c.m17668e(this.f14549e);
                this.f14551g = (VideoPlayConfig) serializableExtra;
                m18114a(this.f14551g);
                this.f14546C = C4323b.m17659a(this.f14549e);
                return true;
            }
        }
        C4065b.m16869d(str, sb);
        return false;
    }

    /* renamed from: d */
    private void m18124d() {
        this.f14556l = (AdBaseFrameLayout) findViewById(C3809l.m15789a(this, "ksad_root_container"));
        this.f14555k = (SafeTextureView) findViewById(C3809l.m15789a(this, "ksad_video_texture_view"));
        this.f14557m = (ImageView) findViewById(C3809l.m15789a(this, "ksad_video_sound_switch"));
        this.f14557m.setSelected(true);
        this.f14559o = (TextView) findViewById(C3809l.m15789a(this, "ksad_video_count_down"));
        this.f14561q = (ImageView) findViewById(C3809l.m15789a(this, "ksad_video_skip_icon"));
        this.f14558n = findViewById(C3809l.m15789a(this, "ksad_video_page_close"));
        this.f14563s = findViewById(C3809l.m15789a(this, "ksad_ad_label_play_bar"));
        this.f14560p = (TextView) C3817t.m15863a((View) this.f14556l, "ksad_detail_call_btn");
        this.f14555k.setOnClickListener(this);
        this.f14559o.setOnClickListener(this);
        this.f14563s.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18125d(int i) {
        C4143b.m17118a(this.f14549e, i, this.f14556l.getTouchCoords(), this.f14552h);
        FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = f14543d;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdClicked();
        }
    }

    /* renamed from: e */
    private void m18126e() {
        this.f14559o.setText(String.valueOf(C4322a.m17633b(this.f14550f)));
        File c = C4079a.m16947a().mo23762c(C4322a.m17632a(this.f14550f));
        if (c == null || !c.exists()) {
            finish();
            return;
        }
        C4143b.m17123a(this.f14549e, this.f14552h);
        this.f14554j = new C4164a(this.f14555k);
        this.f14554j.mo23864a((C4184a) new C4184a() {
            /* renamed from: a */
            public void mo23925a(C4183b bVar) {
                KsFullScreenVideoActivity.this.f14544A = false;
                KsFullScreenVideoActivity.this.m18108a(bVar);
            }

            /* renamed from: a */
            public void mo23926a(C4183b bVar, int i) {
            }

            /* renamed from: a */
            public void mo23927a(C4183b bVar, int i, int i2) {
                KsFullScreenVideoActivity.this.m18117b(i, i2);
            }

            /* renamed from: b */
            public void mo23928b(C4183b bVar) {
            }

            /* renamed from: c */
            public void mo23929c(C4183b bVar) {
                KsFullScreenVideoActivity.this.f14544A = true;
                KsFullScreenVideoActivity.this.m18098C();
                KsFullScreenVideoActivity.this.m18128f();
            }
        });
        this.f14554j.mo23865a(c.getAbsolutePath());
    }

    /* renamed from: e */
    private void m18127e(int i) {
        List<String> A = C4322a.m17625A(this.f14550f);
        if (A != null) {
            for (String equals : A) {
                if (String.valueOf(i).equals(equals)) {
                    C4143b.m17128b(this.f14549e, i, this.f14552h);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m18128f() {
        this.f14568x = true;
        m18136n();
        m18148z();
        m18143u();
        m18144v();
        m18140r();
        m18145w();
        m18102G();
    }

    /* renamed from: g */
    private void m18129g() {
        C4183b bVar = this.f14554j;
        if (bVar == null || !bVar.mo23867a() || this.f14544A) {
            this.f14569y = false;
            return;
        }
        this.f14554j.mo23870d();
        this.f14569y = true;
        m18134l();
    }

    /* renamed from: h */
    private void m18130h() {
        C4183b bVar = this.f14554j;
        if (bVar != null && this.f14569y && !bVar.mo23867a() && !this.f14544A) {
            this.f14554j.mo23871e();
            m18135m();
        }
    }

    /* renamed from: i */
    private void m18131i() {
        C4183b bVar = this.f14554j;
        if (bVar != null) {
            bVar.mo23868b();
        }
    }

    /* renamed from: j */
    private void m18132j() {
        C4183b bVar = this.f14554j;
        if (bVar != null) {
            bVar.mo23869c();
        }
    }

    /* renamed from: k */
    private void m18133k() {
        this.f14553i.removeMessages(241);
        this.f14553i.sendEmptyMessage(241);
    }

    /* renamed from: l */
    private void m18134l() {
        this.f14553i.removeMessages(241);
    }

    /* renamed from: m */
    private void m18135m() {
        if (this.f14559o.getVisibility() != 8) {
            this.f14553i.sendEmptyMessageDelayed(241, 600);
        }
    }

    /* renamed from: n */
    private void m18136n() {
        this.f14553i.removeMessages(241);
    }

    /* renamed from: o */
    private int m18137o() {
        return (int) ((((float) (this.f14554j.mo23874h() - this.f14554j.mo23875i())) / 1000.0f) + 0.5f);
    }

    /* renamed from: p */
    private long m18138p() {
        return this.f14554j.mo23875i();
    }

    /* renamed from: q */
    private void m18139q() {
        if (this.f14560p.getVisibility() != 0) {
            String b = C4323b.m17660b(this.f14549e);
            if (!TextUtils.isEmpty(b)) {
                LayoutParams layoutParams = (LayoutParams) this.f14560p.getLayoutParams();
                if (this.f14561q.getVisibility() == 0) {
                    layoutParams.rightMargin = C3817t.m15862a((Context) this, 40.0f);
                } else {
                    layoutParams.rightMargin = 0;
                }
                this.f14560p.setLayoutParams(layoutParams);
                this.f14560p.setText(b);
                this.f14560p.setVisibility(0);
                this.f14560p.setOnClickListener(this);
                m18101F();
            }
        }
    }

    /* renamed from: r */
    private void m18140r() {
        if (this.f14560p.getVisibility() != 8) {
            this.f14560p.setVisibility(8);
        }
    }

    /* renamed from: s */
    private void m18141s() {
        if (this.f14561q.getVisibility() != 0) {
            this.f14561q.setAlpha(0.0f);
            this.f14561q.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    KsFullScreenVideoActivity.this.f14561q.setAlpha(floatValue);
                    KsFullScreenVideoActivity.this.m18104a(floatValue);
                }
            });
            ofFloat.start();
            this.f14561q.setOnClickListener(this);
        }
    }

    /* renamed from: t */
    private void m18142t() {
        m18099D();
        m18131i();
        m18128f();
    }

    /* renamed from: u */
    private void m18143u() {
        this.f14557m.setVisibility(8);
    }

    /* renamed from: v */
    private void m18144v() {
        this.f14559o.setVisibility(8);
    }

    /* renamed from: w */
    private void m18145w() {
        if (this.f14558n.getVisibility() != 0) {
            this.f14558n.setAlpha(0.0f);
            this.f14558n.setVisibility(0);
            this.f14558n.setOnClickListener(this);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    KsFullScreenVideoActivity.this.f14561q.setVisibility(8);
                }
            });
            ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    KsFullScreenVideoActivity.this.f14561q.setAlpha(1.0f - floatValue);
                    KsFullScreenVideoActivity.this.f14558n.setAlpha(floatValue);
                }
            });
            ofFloat.start();
        }
    }

    /* renamed from: x */
    private void m18146x() {
        View view;
        this.f14563s.setVisibility(0);
        if (!C4322a.m17651s(this.f14550f)) {
            ActionBarH5 actionBarH5 = (ActionBarH5) findViewById(C3809l.m15789a(this, "ksad_video_play_bar_h5"));
            actionBarH5.mo24833a(this.f14549e, new C4550a() {
                /* renamed from: a */
                public void mo24754a() {
                    KsFullScreenVideoActivity.this.m18125d(1);
                }
            });
            actionBarH5.setVisibility(0);
            view = actionBarH5;
        } else if (this.f14551g.showLandscape) {
            ActionBarAppLandscape actionBarAppLandscape = (ActionBarAppLandscape) findViewById(C3809l.m15789a(this, "ksad_video_play_bar_app_landscape"));
            actionBarAppLandscape.mo24827a(this.f14549e, this.f14545B, new C4545a() {
                /* renamed from: a */
                public void mo24752a() {
                    KsFullScreenVideoActivity.this.m18125d(1);
                }
            });
            actionBarAppLandscape.setVisibility(0);
            view = actionBarAppLandscape;
        } else {
            ActionBarAppPortrait actionBarAppPortrait = (ActionBarAppPortrait) findViewById(C3809l.m15789a(this, "ksad_video_play_bar_app_portrait"));
            actionBarAppPortrait.mo24830a(this.f14549e, this.f14545B, new C4548a() {
                /* renamed from: a */
                public void mo24753a() {
                    KsFullScreenVideoActivity.this.m18125d(1);
                }
            });
            actionBarAppPortrait.setVisibility(0);
            view = actionBarAppPortrait;
        }
        this.f14562r = view;
    }

    /* renamed from: y */
    private boolean m18147y() {
        MaterialFeature w = C4322a.m17655w(this.f14550f);
        return w.height > w.width;
    }

    /* renamed from: z */
    private void m18148z() {
        this.f14563s.setVisibility(8);
        this.f14562r.setVisibility(8);
        if (!m18103H()) {
            if (!this.f14551g.showLandscape) {
                if (m18147y()) {
                    this.f14565u = (TailFramePortraitVertical) findViewById(C3809l.m15789a(this, "ksad_video_portrait_vertical"));
                    this.f14565u.mo24849a(this.f14549e, this.f14552h, new C4568a() {
                        /* renamed from: a */
                        public void mo24755a() {
                            KsFullScreenVideoActivity.this.m18125d(2);
                        }
                    });
                    this.f14565u.setVisibility(0);
                } else {
                    this.f14564t = (TailFramePortraitHorizontal) findViewById(C3809l.m15789a(this, "ksad_video_portrait_horizontal"));
                    this.f14564t.mo24846a(this.f14549e, this.f14552h, new C4565a() {
                        /* renamed from: a */
                        public void mo24756a() {
                            KsFullScreenVideoActivity.this.m18125d(2);
                        }
                    });
                    this.f14564t.setVisibility(0);
                }
            } else if (m18147y()) {
                this.f14567w = (TailFrameLandscapeVertical) findViewById(C3809l.m15789a(this, "ksad_video_landscape_vertical"));
                this.f14567w.mo24843a(this.f14549e, this.f14552h, new C4562a() {
                    /* renamed from: a */
                    public void mo24757a() {
                        KsFullScreenVideoActivity.this.m18125d(2);
                    }
                });
                this.f14567w.setVisibility(0);
            } else {
                this.f14566v = (TailFrameLandscapeHorizontal) findViewById(C3809l.m15789a(this, "ksad_video_landscape_horizontal"));
                this.f14566v.mo24840a(this.f14549e, this.f14552h, new C4559a() {
                    /* renamed from: a */
                    public void mo24758a() {
                        KsFullScreenVideoActivity.this.m18125d(2);
                    }
                });
                this.f14566v.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4527a mo23723a() {
        C4527a aVar = new C4527a();
        aVar.f14758b = this.f14548E;
        aVar.f14759c = this.f14552h;
        aVar.f14761e = this.f14551g.showLandscape;
        aVar.f14760d = this.f14549e;
        if (C4322a.m17651s(this.f14550f)) {
            this.f14545B = new C4089b(this.f14549e, this.f14552h);
            aVar.f14762f = this.f14545B;
        }
        if (C4323b.m17662d(this.f14549e)) {
            C3823a aVar2 = new C3823a(this.f14552h);
            aVar2.mo23219a(this.f14547D);
            aVar.f14763g = aVar2;
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo23214a(Message message) {
        if (message.what == 241) {
            C4183b bVar = this.f14554j;
            if (bVar != null && !this.f14544A && bVar.mo23867a()) {
                m18120c(m18137o());
                this.f14553i.sendEmptyMessageDelayed(241, 1000);
                long p = m18138p();
                m18127e((int) Math.ceil((double) (((float) p) / 1000.0f)));
                if (p >= this.f14546C) {
                    m18139q();
                }
                if (p >= 5000) {
                    m18141s();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Presenter mo23725b() {
        Presenter presenter = new Presenter();
        presenter.mo24762a((Presenter) new C4535b());
        presenter.mo24762a((Presenter) new C4532a());
        return presenter;
    }

    public void finish() {
        C4065b.m16867b("FullScreenVideo", "page finish");
        m18100E();
        super.finish();
    }

    public void onBackPressed() {
        if (this.f14568x) {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        Context context;
        AdTemplate adTemplate;
        C4088a r1;
        if (view.getId() == C3809l.m15789a(this, "ksad_video_sound_switch")) {
            C4183b bVar = this.f14554j;
            if (bVar != null) {
                bVar.mo23866a(!this.f14557m.isSelected());
                ImageView imageView = this.f14557m;
                imageView.setSelected(!imageView.isSelected());
            }
        } else if (view.getId() == C3809l.m15789a(this, "ksad_video_skip_icon")) {
            m18142t();
        } else if (view.getId() == C3809l.m15789a(this, "ksad_video_page_close")) {
            finish();
        } else {
            if (view.getId() == C3809l.m15789a(this, "ksad_root_container")) {
                context = view.getContext();
                adTemplate = this.f14549e;
                r1 = new C4088a() {
                    /* renamed from: a */
                    public void mo23360a() {
                        KsFullScreenVideoActivity.this.m18125d(35);
                    }
                };
            } else if (view.getId() == C3809l.m15789a(this, "ksad_detail_call_btn")) {
                context = view.getContext();
                adTemplate = this.f14549e;
                r1 = new C4088a() {
                    /* renamed from: a */
                    public void mo23360a() {
                        KsFullScreenVideoActivity.this.m18125d(40);
                    }
                };
            } else {
                return;
            }
            C4087a.m16967a(context, adTemplate, r1, this.f14545B);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!m18122c()) {
            finish();
            return;
        }
        setContentView(C3809l.m15792b(this, "ksad_activity_fullscreen_video"));
        m18124d();
        mo23724a(this.f14556l);
        m18126e();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C4065b.m16867b("FullScreenVideo", "page onDestroy");
        try {
            m18096A();
            m18100E();
            m18136n();
            m18132j();
            f14543d = null;
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        getWindow().clearFlags(128);
        m18129g();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getWindow().addFlags(128);
        m18130h();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        C4065b.m16867b("FullScreenVideo", "page onStop");
    }
}
