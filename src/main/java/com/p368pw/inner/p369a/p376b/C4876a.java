package com.p368pw.inner.p369a.p376b;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5196m;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.p369a.C4897d;
import com.p368pw.inner.p369a.p370a.p373c.C4839a;
import com.p368pw.inner.p369a.p370a.p373c.C4847e;
import com.p368pw.inner.p369a.p370a.p373c.C4849g;
import com.p368pw.inner.p369a.p370a.p373c.C4850h;
import com.p368pw.p392us.Setting;
import com.p368pw.view.NativeAdContainer;
import com.p522qq.p523e.ads.nativ.NativeUnifiedADData;
import com.pw.R;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADDownLoad;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;

/* renamed from: com.pw.inner.a.b.a */
public class C4876a extends C4897d {
    /* renamed from: b */
    private NativeAdContainer f15738b;
    /* renamed from: c */
    private RelativeLayout f15739c;
    /* renamed from: d */
    private ImageView f15740d;
    /* renamed from: e */
    private ImageView f15741e;
    /* renamed from: f */
    private ImageView f15742f;
    /* renamed from: g */
    private ImageView f15743g;
    /* renamed from: h */
    private TextView f15744h;
    /* renamed from: i */
    private TextView f15745i;
    /* renamed from: j */
    private TextView f15746j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public C4879b f15747k;
    /* renamed from: l */
    private AnimatorSet f15748l;

    protected C4876a(Activity activity) {
        super(activity);
    }

    /* renamed from: d */
    private void m20027d() {
        this.f15747k = (C4879b) this.f15824a.getIntent().getSerializableExtra("ins_data");
        this.f15745i.setText(this.f15747k.mo25916e());
        this.f15746j.setText(C5207q.m21478b((CharSequence) this.f15747k.mo25922h()) ? this.f15747k.mo25922h() : "查看");
        C5196m.m21445a(C5233e.m21559b(), this.f15747k.mo25920g(), this.f15742f);
        this.f15744h.setText(this.f15747k.mo25913d());
        this.f15738b.setBackgroundColor(Color.parseColor("#99000000"));
        this.f15740d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C4880c.m20089a().mo25952b(C5233e.m21559b(), C4876a.this.f15747k);
                C4876a.this.f15824a.finish();
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15743g, "scaleX", new float[]{1.0f, 1.3f, 1.0f});
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f15743g, "scaleY", new float[]{1.0f, 1.3f, 1.0f});
        ofFloat2.setRepeatMode(1);
        ofFloat2.setRepeatCount(-1);
        this.f15748l = new AnimatorSet();
        this.f15748l.setDuration(700);
        this.f15748l.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f15748l.play(ofFloat).with(ofFloat2);
        this.f15748l.start();
        int intExtra = this.f15824a.getIntent().getIntExtra("win_setting_identity", -1);
        if (intExtra == -1) {
            m20028s();
            return;
        }
        Setting a = C4893g.m20177a(intExtra);
        if (a == null) {
            m20028s();
            return;
        }
        final C4850h hVar = (C4850h) a.getAdObject();
        hVar.mo25862a((C4847e) new C4847e() {
            /* renamed from: a */
            public void mo25854a() {
                C5205o.m21462a("珊瑚插屏onAdShow");
            }

            /* renamed from: a */
            public void mo25855a(NativeUnifiedADData nativeUnifiedADData) {
                C5205o.m21462a("珊瑚插屏onAdClick");
                C4880c.m20089a().mo25949a(C5233e.m21559b(), C4876a.this.f15747k);
                new C4849g(((AdMetaInfo) hVar.f15620b.get(0)).title, C4839a.m19870d((AdMetaInfo) hVar.f15620b.get(0))).mo26660c();
            }
        });
        ADDownLoad aDDownLoad = (ADDownLoad) hVar.f15622d;
        this.f15738b.allowAddView = false;
        aDDownLoad.registerViewForInteraction((AdMetaInfo) hVar.f15620b.get(0), this.f15738b, this.f15739c);
        this.f15738b.allowAddView = true;
    }

    /* renamed from: s */
    private void m20028s() {
        C5205o.m21462a("没有获取到setting，展示失败");
        this.f15824a.finish();
    }

    /* renamed from: t */
    private void m20029t() {
        this.f15824a.requestWindowFeature(1);
    }

    /* renamed from: u */
    private void m20030u() {
        this.f15824a.getWindow().addFlags(1024);
    }

    /* renamed from: v */
    private void m20031v() {
        if (VERSION.SDK_INT != 26) {
            this.f15824a.setRequestedOrientation(1);
        }
    }

    /* renamed from: w */
    private void m20032w() {
        if (this.f15741e == null) {
            this.f15741e = (ImageView) this.f15824a.findViewById(R.id.win_interstitial_bg);
        }
        LayoutParams layoutParams = (LayoutParams) this.f15741e.getLayoutParams();
        layoutParams.width = C5191i.m21384a(C5233e.m21559b(), 1);
        layoutParams.height = (int) (((float) layoutParams.width) * 0.5888889f);
        this.f15741e.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public void mo25895a() {
        super.mo25895a();
    }

    /* renamed from: a */
    public void mo25896a(Configuration configuration) {
        super.mo25896a(configuration);
        m20032w();
    }

    /* renamed from: a */
    public void mo25897a(Bundle bundle) {
        super.mo25897a(bundle);
        m20029t();
        m20030u();
        m20031v();
    }

    /* renamed from: b */
    public void mo25898b() {
        super.mo25898b();
        this.f15740d.setOnClickListener(null);
        if (this.f15748l != null) {
            try {
                if (VERSION.SDK_INT >= 19) {
                    this.f15748l.pause();
                }
                this.f15743g.clearAnimation();
                this.f15748l = null;
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }

    /* renamed from: b */
    public void mo25899b(Bundle bundle) {
        try {
            this.f15824a.setContentView(R.layout.win_sdk_activity_interstitial);
            this.f15738b = (NativeAdContainer) this.f15824a.findViewById(R.id.win_interstitial_container);
            this.f15739c = (RelativeLayout) this.f15824a.findViewById(R.id.win_interstitial_group);
            this.f15740d = (ImageView) this.f15824a.findViewById(R.id.win_interstitial_close);
            this.f15741e = (ImageView) this.f15824a.findViewById(R.id.win_interstitial_bg);
            this.f15745i = (TextView) this.f15824a.findViewById(R.id.win_interstitial_desc);
            this.f15746j = (TextView) this.f15824a.findViewById(R.id.win_interstitial_btn);
            this.f15742f = (ImageView) this.f15824a.findViewById(R.id.win_interstitial_icon);
            this.f15744h = (TextView) this.f15824a.findViewById(R.id.win_interstitial_title);
            this.f15743g = (ImageView) this.f15824a.findViewById(R.id.win_interstitial_hand);
            m20032w();
            m20027d();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            this.f15824a.finish();
        }
    }

    /* renamed from: c */
    public boolean mo25900c() {
        C4880c.m20089a().mo25953c(C5233e.m21559b(), this.f15747k);
        return false;
    }
}
