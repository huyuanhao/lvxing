package com.kwad.sdk.reward;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.kwad.sdk.export.p347i.KsRewardVideoAd.RewardAdInteractionListener;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3812o;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.p306a.C3818u;
import com.kwad.sdk.p306a.C3818u.C3819a;
import com.kwad.sdk.p307b.C3823a;
import com.kwad.sdk.p307b.C3823a.C3826a;
import com.kwad.sdk.reward.C4537d.C4541a;
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

public class KSRewardVideoActivity extends C4066a<C4527a> implements OnClickListener, C3819a {
    /* renamed from: d */
    public static RewardAdInteractionListener f14704d;
    /* renamed from: A */
    private boolean f14705A;
    /* renamed from: B */
    private boolean f14706B;
    /* renamed from: C */
    private boolean f14707C;
    /* renamed from: D */
    private int f14708D;
    /* access modifiers changed from: private */
    /* renamed from: E */
    public boolean f14709E;
    /* renamed from: F */
    private C4089b f14710F;
    /* renamed from: G */
    private long f14711G;
    /* renamed from: H */
    private BroadcastReceiver f14712H = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String schemeSpecificPart = (!TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (!TextUtils.isEmpty(schemeSpecificPart)) {
                Message obtainMessage = KSRewardVideoActivity.this.f14719i.obtainMessage(242);
                obtainMessage.obj = schemeSpecificPart;
                obtainMessage.sendToTarget();
            }
        }
    };
    /* renamed from: I */
    private C3826a f14713I = new C3826a() {
        /* renamed from: a */
        public void mo23225a() {
            if (KSRewardVideoActivity.f14704d != null) {
                C4065b.m16867b("RewardVideo", "onAdClicked");
                KSRewardVideoActivity.f14704d.onAdClicked();
            }
        }
    };
    /* renamed from: J */
    private C4529b f14714J = new C4529b() {
        /* renamed from: a */
        public void mo24759a() {
            if (KSRewardVideoActivity.f14704d != null) {
                C4065b.m16867b("RewardVideo", "onAdClicked");
                KSRewardVideoActivity.f14704d.onAdClicked();
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: e */
    public AdTemplate f14715e;
    /* renamed from: f */
    private AdInfo f14716f;
    /* renamed from: g */
    private VideoPlayConfig f14717g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public JSONObject f14718h;
    /* access modifiers changed from: private|final */
    /* renamed from: i */
    public final C3818u f14719i = new C3818u(this);
    /* renamed from: j */
    private C4183b f14720j;
    /* renamed from: k */
    private SafeTextureView f14721k;
    /* renamed from: l */
    private AdBaseFrameLayout f14722l;
    /* renamed from: m */
    private ImageView f14723m;
    /* renamed from: n */
    private TextView f14724n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public View f14725o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public TextView f14726p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public ImageView f14727q;
    /* renamed from: r */
    private View f14728r;
    /* renamed from: s */
    private View f14729s;
    /* renamed from: t */
    private TailFramePortraitHorizontal f14730t;
    /* renamed from: u */
    private TailFramePortraitVertical f14731u;
    /* renamed from: v */
    private TailFrameLandscapeHorizontal f14732v;
    /* renamed from: w */
    private TailFrameLandscapeVertical f14733w;
    /* renamed from: x */
    private C4537d f14734x;
    /* renamed from: y */
    private boolean f14735y;
    /* renamed from: z */
    private boolean f14736z;

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m18320A() {
        if (f14704d != null) {
            C4065b.m16867b("RewardVideo", "onVideoPlayEnd");
            f14704d.onVideoPlayEnd();
            C4143b.m17141g(this.f14715e, this.f14718h);
        }
    }

    /* renamed from: B */
    private void m18321B() {
        if (f14704d != null && !this.f14706B) {
            this.f14706B = true;
            C4065b.m16867b("RewardVideo", "onRewardVerify");
            f14704d.onRewardVerify();
        }
    }

    /* renamed from: C */
    private void m18322C() {
        m18348d(6);
    }

    /* renamed from: D */
    private void m18323D() {
        C4143b.m17131c(this.f14715e, 18, this.f14718h);
    }

    /* renamed from: E */
    private void m18324E() {
        if (this.f13675b != null) {
            for (C4530c a : this.f13675b.f14764h) {
                a.mo24817a();
            }
        }
    }

    /* renamed from: F */
    private boolean m18325F() {
        if (this.f13675b == null || this.f13675b.f14763g == null) {
            return false;
        }
        return this.f13675b.f14763g.mo23220b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18326a(float f) {
        if (this.f14724n.getVisibility() == 0) {
            LayoutParams layoutParams = (LayoutParams) this.f14724n.getLayoutParams();
            layoutParams.rightMargin = (int) (((float) C3817t.m15862a((Context) this, 40.0f)) * f);
            this.f14724n.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    private void m18327a(int i) {
        this.f14729s.setVisibility(8);
        ActionBarLandscapeVertical actionBarLandscapeVertical = (ActionBarLandscapeVertical) findViewById(C3809l.m15789a(this, "ksad_actionbar_landscape_vertical"));
        actionBarLandscapeVertical.mo24835a(this.f14715e, this.f14710F, new C4553a() {
            /* renamed from: a */
            public void mo24747a() {
                KSRewardVideoActivity.this.m18351e(1);
            }
        }, i);
        actionBarLandscapeVertical.setVisibility(0);
        this.f14728r = actionBarLandscapeVertical;
    }

    /* renamed from: a */
    private void m18328a(int i, int i2) {
        int g = C3812o.m15835g(this);
        int h = C3812o.m15837h(this);
        if (h <= g) {
            g = h;
        }
        if (this.f14717g.showLandscape) {
            if (i <= i2) {
                ViewGroup.LayoutParams layoutParams = this.f14721k.getLayoutParams();
                int i3 = (int) ((((float) i) / (((float) i2) * 1.0f)) * ((float) g));
                layoutParams.width = i3;
                layoutParams.height = g;
                this.f14721k.setLayoutParams(layoutParams);
                if (!C4322a.m17651s(this.f14716f) || !C4322a.m17627C(this.f14716f)) {
                    m18374v();
                    if (!C4322a.m17626B(this.f14716f)) {
                        return;
                    }
                    this.f14722l.setOnClickListener(this);
                    return;
                }
                m18327a(i3);
                return;
            }
        } else if (i2 <= i) {
            ViewGroup.LayoutParams layoutParams2 = this.f14721k.getLayoutParams();
            int i4 = (int) ((((float) i2) / (((float) i) * 1.0f)) * ((float) g));
            layoutParams2.width = g;
            layoutParams2.height = i4;
            this.f14721k.setLayoutParams(layoutParams2);
            if (!C4322a.m17651s(this.f14716f) || !C4322a.m17627C(this.f14716f)) {
                m18374v();
                if (!C4322a.m17626B(this.f14716f)) {
                    return;
                }
                this.f14722l.setOnClickListener(this);
                return;
            }
            m18338b(i4);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.f14721k.getLayoutParams();
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        this.f14721k.setLayoutParams(layoutParams3);
        m18374v();
    }

    /* renamed from: a */
    public static void m18329a(Context context, AdTemplate adTemplate, VideoPlayConfig videoPlayConfig, RewardAdInteractionListener rewardAdInteractionListener) {
        Intent intent = new Intent(context, KSRewardVideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        intent.putExtra("key_video_play_config", videoPlayConfig);
        f14704d = rewardAdInteractionListener;
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18330a(C4183b bVar) {
        this.f14723m.setOnClickListener(this);
        m18362j();
        m18328a(bVar.mo23872f(), bVar.mo23873g());
        m18378z();
    }

    /* renamed from: a */
    private void m18336a(VideoPlayConfig videoPlayConfig) {
        boolean z = true;
        setRequestedOrientation(!videoPlayConfig.showLandscape);
        if (!TextUtils.isEmpty(videoPlayConfig.showScene)) {
            this.f14718h = null;
            this.f14718h = new JSONObject();
            C3800e.m15752a(this.f14718h, "ext_showscene", videoPlayConfig.showScene);
        }
        int b = C4322a.m17633b(this.f14716f);
        if (this.f14717g.skipThirtySecond) {
            this.f14708D = 30;
        }
        int i = this.f14708D;
        if (i != 0) {
            this.f14708D = Math.min(i, b);
        } else {
            this.f14708D = b;
        }
        if (this.f14708D != b) {
            z = false;
        }
        this.f14707C = z;
    }

    /* renamed from: b */
    private void m18338b(int i) {
        this.f14729s.setVisibility(8);
        ActionBarPortraitHorizontal actionBarPortraitHorizontal = (ActionBarPortraitHorizontal) findViewById(C3809l.m15789a(this, "ksad_actionbar_portrait_horizontal"));
        actionBarPortraitHorizontal.mo24837a(this.f14715e, this.f14710F, new C4556a() {
            /* renamed from: a */
            public void mo24748a() {
                KSRewardVideoActivity.this.m18351e(1);
            }
        }, i);
        actionBarPortraitHorizontal.setVisibility(0);
        this.f14728r = actionBarPortraitHorizontal;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18339b(int i, int i2) {
        m18344c(i, i2);
        finish();
    }

    /* renamed from: c */
    private void m18343c(int i) {
        this.f14726p.setText(String.valueOf(i));
        this.f14726p.setVisibility(0);
    }

    /* renamed from: c */
    private void m18344c(int i, int i2) {
        if (f14704d != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoPlayError code：");
            sb.append(i);
            sb.append("--extra：");
            sb.append(i2);
            C4065b.m16867b("RewardVideo", sb.toString());
            f14704d.onVideoPlayError(i, i2);
        }
    }

    /* renamed from: c */
    private boolean m18345c() {
        String sb;
        Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
        String str = "RewardVideo";
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
                this.f14715e = (AdTemplate) serializableExtra2;
                this.f14716f = C4324c.m17668e(this.f14715e);
                this.f14717g = (VideoPlayConfig) serializableExtra;
                m18336a(this.f14717g);
                this.f14711G = C4323b.m17659a(this.f14715e);
                return true;
            }
        }
        C4065b.m16869d(str, sb);
        return false;
    }

    /* renamed from: d */
    private void m18347d() {
        this.f14722l = (AdBaseFrameLayout) findViewById(C3809l.m15789a(this, "ksad_root_container"));
        this.f14721k = (SafeTextureView) findViewById(C3809l.m15789a(this, "ksad_video_texture_view"));
        this.f14723m = (ImageView) findViewById(C3809l.m15789a(this, "ksad_video_sound_switch"));
        this.f14723m.setSelected(true);
        this.f14726p = (TextView) findViewById(C3809l.m15789a(this, "ksad_video_count_down"));
        this.f14727q = (ImageView) findViewById(C3809l.m15789a(this, "ksad_video_reward_icon"));
        this.f14725o = findViewById(C3809l.m15789a(this, "ksad_video_page_close"));
        this.f14729s = findViewById(C3809l.m15789a(this, "ksad_ad_label_play_bar"));
        this.f14724n = (TextView) C3817t.m15863a((View) this.f14722l, "ksad_detail_call_btn");
        this.f14721k.setOnClickListener(this);
        this.f14726p.setOnClickListener(this);
        this.f14729s.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18348d(int i) {
        if (f14704d != null && !this.f14705A) {
            this.f14705A = true;
            C4065b.m16867b("RewardVideo", "onPageDismiss");
            f14704d.onPageDismiss();
            C4143b.m17120a(this.f14715e, i, this.f14718h);
        }
    }

    /* renamed from: e */
    private void m18350e() {
        this.f14726p.setText(String.valueOf(C4322a.m17633b(this.f14716f)));
        File c = C4079a.m16947a().mo23762c(C4322a.m17632a(this.f14716f));
        if (c == null || !c.exists()) {
            finish();
            return;
        }
        C4143b.m17123a(this.f14715e, this.f14718h);
        this.f14720j = new C4164a(this.f14721k);
        this.f14720j.mo23864a((C4184a) new C4184a() {
            /* renamed from: a */
            public void mo23925a(C4183b bVar) {
                KSRewardVideoActivity.this.f14709E = false;
                KSRewardVideoActivity.this.m18330a(bVar);
            }

            /* renamed from: a */
            public void mo23926a(C4183b bVar, int i) {
            }

            /* renamed from: a */
            public void mo23927a(C4183b bVar, int i, int i2) {
                KSRewardVideoActivity.this.m18339b(i, i2);
            }

            /* renamed from: b */
            public void mo23928b(C4183b bVar) {
            }

            /* renamed from: c */
            public void mo23929c(C4183b bVar) {
                KSRewardVideoActivity.this.f14709E = true;
                KSRewardVideoActivity.this.m18320A();
                KSRewardVideoActivity.this.m18352f();
            }
        });
        this.f14720j.mo23865a(c.getAbsolutePath());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m18351e(int i) {
        if (f14704d != null) {
            C4065b.m16867b("RewardVideo", "onAdClicked");
            f14704d.onAdClicked();
            C4143b.m17118a(this.f14715e, i, this.f14722l.getTouchCoords(), this.f14718h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m18352f() {
        this.f14735y = true;
        m18321B();
        m18365m();
        m18376x();
        m18368p();
        m18371s();
        m18370r();
        m18372t();
        m18324E();
    }

    /* renamed from: f */
    private void m18353f(int i) {
        List<String> A = C4322a.m17625A(this.f14716f);
        if (A != null) {
            for (String equals : A) {
                if (String.valueOf(i).equals(equals)) {
                    C4143b.m17128b(this.f14715e, i, this.f14718h);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18356g() {
        C4183b bVar = this.f14720j;
        if (bVar == null || !bVar.mo23867a() || this.f14709E) {
            this.f14736z = false;
            return;
        }
        this.f14720j.mo23870d();
        this.f14736z = true;
        m18363k();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m18358h() {
        C4183b bVar = this.f14720j;
        if (bVar != null && this.f14736z && !bVar.mo23867a() && !this.f14709E) {
            this.f14720j.mo23871e();
            m18364l();
        }
    }

    /* renamed from: i */
    private void m18359i() {
        C4183b bVar = this.f14720j;
        if (bVar != null) {
            bVar.mo23869c();
        }
    }

    /* renamed from: j */
    private void m18362j() {
        this.f14719i.removeMessages(241);
        this.f14719i.sendEmptyMessage(241);
    }

    /* renamed from: k */
    private void m18363k() {
        this.f14719i.removeMessages(241);
    }

    /* renamed from: l */
    private void m18364l() {
        if (this.f14726p.getVisibility() != 8) {
            this.f14719i.sendEmptyMessageDelayed(241, 600);
        }
    }

    /* renamed from: m */
    private void m18365m() {
        this.f14719i.removeMessages(241);
    }

    /* renamed from: n */
    private int m18366n() {
        return (int) ((((float) (this.f14720j.mo23874h() - this.f14720j.mo23875i())) / 1000.0f) + 0.5f);
    }

    /* renamed from: o */
    private long m18367o() {
        return this.f14720j.mo23875i();
    }

    /* renamed from: p */
    private void m18368p() {
        this.f14727q.setAlpha(0.0f);
        this.f14727q.setVisibility(0);
        this.f14727q.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                KSRewardVideoActivity.this.f14726p.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                KSRewardVideoActivity.this.f14726p.setAlpha(1.0f - floatValue);
                KSRewardVideoActivity.this.f14727q.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* renamed from: q */
    private void m18369q() {
        if (this.f14724n.getVisibility() != 0) {
            String b = C4323b.m17660b(this.f14715e);
            if (!TextUtils.isEmpty(b)) {
                LayoutParams layoutParams = (LayoutParams) this.f14724n.getLayoutParams();
                if (this.f14725o.getVisibility() == 0) {
                    layoutParams.rightMargin = C3817t.m15862a((Context) this, 40.0f);
                } else {
                    layoutParams.rightMargin = 0;
                }
                this.f14724n.setLayoutParams(layoutParams);
                this.f14724n.setText(b);
                this.f14724n.setVisibility(0);
                this.f14724n.setOnClickListener(this);
                m18323D();
            }
        }
    }

    /* renamed from: r */
    private void m18370r() {
        if (this.f14724n.getVisibility() != 8) {
            this.f14724n.setVisibility(8);
        }
    }

    /* renamed from: s */
    private void m18371s() {
        this.f14723m.setVisibility(8);
    }

    /* renamed from: t */
    private void m18372t() {
        if (this.f14725o.getVisibility() != 0) {
            if (this.f14724n.getVisibility() != 0) {
                this.f14725o.setVisibility(0);
            } else {
                this.f14725o.setAlpha(0.0f);
                this.f14725o.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        KSRewardVideoActivity.this.f14725o.setAlpha(floatValue);
                        KSRewardVideoActivity.this.m18326a(floatValue);
                    }
                });
                ofFloat.start();
            }
            this.f14725o.setOnClickListener(this);
        }
    }

    /* renamed from: u */
    private void m18373u() {
        if (this.f14709E || m18367o() >= ((long) (this.f14708D * 1000))) {
            m18321B();
            finish();
            return;
        }
        this.f14734x = C4537d.m18429a(this, this.f14707C ? "观看完整视频即可获取奖励" : "观看视频30s即可获取奖励", new C4541a() {
            /* renamed from: a */
            public void mo24810a() {
                KSRewardVideoActivity.this.m18356g();
                C4143b.m17145i(KSRewardVideoActivity.this.f14715e, KSRewardVideoActivity.this.f14718h);
            }

            /* renamed from: b */
            public void mo24811b() {
                KSRewardVideoActivity.this.m18348d(1);
                KSRewardVideoActivity.this.finish();
            }

            /* renamed from: c */
            public void mo24812c() {
                KSRewardVideoActivity.this.m18358h();
                C4143b.m17147j(KSRewardVideoActivity.this.f14715e, KSRewardVideoActivity.this.f14718h);
            }
        });
    }

    /* renamed from: v */
    private void m18374v() {
        View view;
        this.f14729s.setVisibility(0);
        if (!C4322a.m17651s(this.f14716f)) {
            ActionBarH5 actionBarH5 = (ActionBarH5) findViewById(C3809l.m15789a(this, "ksad_video_play_bar_h5"));
            actionBarH5.mo24833a(this.f14715e, new C4550a() {
                /* renamed from: a */
                public void mo24754a() {
                    KSRewardVideoActivity.this.m18351e(1);
                }
            });
            actionBarH5.setVisibility(0);
            view = actionBarH5;
        } else if (this.f14717g.showLandscape) {
            ActionBarAppLandscape actionBarAppLandscape = (ActionBarAppLandscape) findViewById(C3809l.m15789a(this, "ksad_video_play_bar_app_landscape"));
            actionBarAppLandscape.mo24827a(this.f14715e, this.f14710F, new C4545a() {
                /* renamed from: a */
                public void mo24752a() {
                    KSRewardVideoActivity.this.m18351e(1);
                }
            });
            actionBarAppLandscape.setVisibility(0);
            view = actionBarAppLandscape;
        } else {
            ActionBarAppPortrait actionBarAppPortrait = (ActionBarAppPortrait) findViewById(C3809l.m15789a(this, "ksad_video_play_bar_app_portrait"));
            actionBarAppPortrait.mo24830a(this.f14715e, this.f14710F, new C4548a() {
                /* renamed from: a */
                public void mo24753a() {
                    KSRewardVideoActivity.this.m18351e(1);
                }
            });
            actionBarAppPortrait.setVisibility(0);
            view = actionBarAppPortrait;
        }
        this.f14728r = view;
    }

    /* renamed from: w */
    private boolean m18375w() {
        MaterialFeature w = C4322a.m17655w(this.f14716f);
        return w.height > w.width;
    }

    /* renamed from: x */
    private void m18376x() {
        this.f14729s.setVisibility(8);
        this.f14728r.setVisibility(8);
        if (!m18325F()) {
            if (!this.f14717g.showLandscape) {
                if (m18375w()) {
                    this.f14731u = (TailFramePortraitVertical) findViewById(C3809l.m15789a(this, "ksad_video_portrait_vertical"));
                    this.f14731u.mo24849a(this.f14715e, this.f14718h, new C4568a() {
                        /* renamed from: a */
                        public void mo24755a() {
                            KSRewardVideoActivity.this.m18351e(2);
                        }
                    });
                    this.f14731u.setVisibility(0);
                } else {
                    this.f14730t = (TailFramePortraitHorizontal) findViewById(C3809l.m15789a(this, "ksad_video_portrait_horizontal"));
                    this.f14730t.mo24846a(this.f14715e, this.f14718h, new C4565a() {
                        /* renamed from: a */
                        public void mo24756a() {
                            KSRewardVideoActivity.this.m18351e(2);
                        }
                    });
                    this.f14730t.setVisibility(0);
                }
            } else if (m18375w()) {
                this.f14733w = (TailFrameLandscapeVertical) findViewById(C3809l.m15789a(this, "ksad_video_landscape_vertical"));
                this.f14733w.mo24843a(this.f14715e, this.f14718h, new C4562a() {
                    /* renamed from: a */
                    public void mo24757a() {
                        KSRewardVideoActivity.this.m18351e(2);
                    }
                });
                this.f14733w.setVisibility(0);
            } else {
                this.f14732v = (TailFrameLandscapeHorizontal) findViewById(C3809l.m15789a(this, "ksad_video_landscape_horizontal"));
                this.f14732v.mo24840a(this.f14715e, this.f14718h, new C4559a() {
                    /* renamed from: a */
                    public void mo24758a() {
                        KSRewardVideoActivity.this.m18351e(2);
                    }
                });
                this.f14732v.setVisibility(0);
            }
        }
    }

    /* renamed from: y */
    private void m18377y() {
        TailFramePortraitHorizontal tailFramePortraitHorizontal = this.f14730t;
        if (tailFramePortraitHorizontal != null) {
            tailFramePortraitHorizontal.mo24845a();
            this.f14730t.setVisibility(8);
        }
        TailFramePortraitVertical tailFramePortraitVertical = this.f14731u;
        if (tailFramePortraitVertical != null) {
            tailFramePortraitVertical.mo24848a();
            this.f14731u.setVisibility(8);
        }
        TailFrameLandscapeVertical tailFrameLandscapeVertical = this.f14733w;
        if (tailFrameLandscapeVertical != null) {
            tailFrameLandscapeVertical.mo24842a();
            this.f14733w.setVisibility(8);
        }
        TailFrameLandscapeHorizontal tailFrameLandscapeHorizontal = this.f14732v;
        if (tailFrameLandscapeHorizontal != null) {
            tailFrameLandscapeHorizontal.mo24839a();
            this.f14732v.setVisibility(8);
        }
    }

    /* renamed from: z */
    private void m18378z() {
        if (f14704d != null) {
            C4065b.m16867b("RewardVideo", "onVideoPlayStart");
            f14704d.onVideoPlayStart();
            C4143b.m17139f(this.f14715e, this.f14718h);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4527a mo23723a() {
        C4527a aVar = new C4527a();
        aVar.f14758b = this.f14714J;
        aVar.f14759c = this.f14718h;
        aVar.f14761e = this.f14717g.showLandscape;
        aVar.f14760d = this.f14715e;
        if (C4322a.m17651s(this.f14716f)) {
            this.f14710F = new C4089b(this.f14715e, this.f14718h);
            aVar.f14762f = this.f14710F;
        }
        if (C4323b.m17662d(this.f14715e)) {
            C3823a aVar2 = new C3823a(this.f14718h);
            aVar2.mo23219a(this.f14713I);
            aVar.f14763g = aVar2;
        }
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo23214a(android.os.Message r7) {
        /*
        r6 = this;
        int r0 = r7.what
        r1 = 241(0xf1, float:3.38E-43)
        if (r0 == r1) goto L_0x002c
        r1 = 242(0xf2, float:3.39E-43)
        if (r0 == r1) goto L_0x000c
        goto L_0x0089
    L_0x000c:
        java.lang.Object r0 = r7.obj
        if (r0 == 0) goto L_0x0089
        java.lang.Object r7 = r7.obj
        com.kwad.sdk.core.response.model.AdInfo r0 = r6.f14716f
        com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r0 = r0.adBaseInfo
        java.lang.String r0 = r0.appPackageName
        boolean r7 = r7.equals(r0)
        if (r7 == 0) goto L_0x0089
        com.kwad.sdk.core.h.b r7 = r6.f14720j
        if (r7 == 0) goto L_0x0025
        r7.mo23868b()
    L_0x0025:
        r7 = 1
        r6.f14709E = r7
        r6.m18352f()
        goto L_0x0089
    L_0x002c:
        com.kwad.sdk.core.h.b r7 = r6.f14720j
        if (r7 == 0) goto L_0x0089
        boolean r0 = r6.f14709E
        if (r0 != 0) goto L_0x0089
        boolean r7 = r7.mo23867a()
        if (r7 != 0) goto L_0x003b
        goto L_0x0089
    L_0x003b:
        long r2 = r6.m18367o()
        float r7 = (float) r2
        r0 = 1148846080(0x447a0000, float:1000.0)
        float r7 = r7 / r0
        double r4 = (double) r7
        double r4 = java.lang.Math.ceil(r4)
        int r7 = (int) r4
        r6.m18353f(r7)
        boolean r0 = r6.f14707C
        r4 = 1000(0x3e8, double:4.94E-321)
        if (r0 == 0) goto L_0x005f
        int r7 = r6.m18366n()
        r6.m18343c(r7)
    L_0x0059:
        com.kwad.sdk.a.u r7 = r6.f14719i
        r7.sendEmptyMessageDelayed(r1, r4)
        goto L_0x006f
    L_0x005f:
        int r0 = r6.f14708D
        if (r7 <= r0) goto L_0x006a
        r6.m18368p()
        r6.m18372t()
        goto L_0x006f
    L_0x006a:
        int r0 = r0 - r7
        r6.m18343c(r0)
        goto L_0x0059
    L_0x006f:
        com.kwad.sdk.core.response.model.AdInfo r7 = r6.f14716f
        boolean r7 = com.kwad.sdk.core.response.p342b.C4322a.m17642j(r7)
        if (r7 == 0) goto L_0x0080
        r0 = 5000(0x1388, double:2.4703E-320)
        int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
        if (r7 < 0) goto L_0x0080
        r6.m18372t()
    L_0x0080:
        long r0 = r6.f14711G
        int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
        if (r7 < 0) goto L_0x0089
        r6.m18369q()
    L_0x0089:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.reward.KSRewardVideoActivity.mo23214a(android.os.Message):void");
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
        C4065b.m16867b("RewardVideo", "page finish");
        m18322C();
        super.finish();
    }

    public void onBackPressed() {
        if (this.f14735y) {
            super.onBackPressed();
            m18321B();
        }
    }

    public void onClick(View view) {
        Context context;
        AdTemplate adTemplate;
        C4088a r1;
        if (view.getId() == C3809l.m15789a(this, "ksad_video_sound_switch")) {
            C4183b bVar = this.f14720j;
            if (bVar != null) {
                bVar.mo23866a(!this.f14723m.isSelected());
                ImageView imageView = this.f14723m;
                imageView.setSelected(!imageView.isSelected());
            }
        } else if (view.getId() == C3809l.m15789a(this, "ksad_video_page_close")) {
            m18373u();
        } else {
            if (view.getId() == C3809l.m15789a(this, "ksad_video_reward_icon")) {
                context = view.getContext();
                adTemplate = this.f14715e;
                r1 = new C4088a() {
                    /* renamed from: a */
                    public void mo23360a() {
                        KSRewardVideoActivity.this.m18351e(41);
                    }
                };
            } else if (view.getId() == C3809l.m15789a(this, "ksad_root_container")) {
                context = view.getContext();
                adTemplate = this.f14715e;
                r1 = new C4088a() {
                    /* renamed from: a */
                    public void mo23360a() {
                        KSRewardVideoActivity.this.m18351e(35);
                    }
                };
            } else if (view.getId() == C3809l.m15789a(this, "ksad_detail_call_btn")) {
                context = view.getContext();
                adTemplate = this.f14715e;
                r1 = new C4088a() {
                    /* renamed from: a */
                    public void mo23360a() {
                        KSRewardVideoActivity.this.m18351e(40);
                    }
                };
            } else {
                return;
            }
            C4087a.m16967a(context, adTemplate, r1, this.f14710F);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!m18345c()) {
            finish();
            return;
        }
        setContentView(C3809l.m15792b(this, "ksad_activity_reward_video"));
        m18347d();
        mo23724a(this.f14722l);
        m18350e();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.f14712H, intentFilter);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C4065b.m16867b("RewardVideo", "page onDestroy");
        try {
            m18377y();
            m18365m();
            m18322C();
            m18359i();
            unregisterReceiver(this.f14712H);
            f14704d = null;
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        getWindow().clearFlags(128);
        C4537d dVar = this.f14734x;
        if (dVar == null || !dVar.mo24819a()) {
            m18356g();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getWindow().addFlags(128);
        C4537d dVar = this.f14734x;
        if (dVar == null || !dVar.mo24819a()) {
            m18358h();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        C4065b.m16867b("RewardVideo", "page onStop");
    }
}
