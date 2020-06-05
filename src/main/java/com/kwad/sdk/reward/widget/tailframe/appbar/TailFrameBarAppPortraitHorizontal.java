package com.kwad.sdk.reward.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.reward.widget.AppScoreView;

public class TailFrameBarAppPortraitHorizontal extends LinearLayout {
    /* renamed from: a */
    private ImageView f14910a;
    /* renamed from: b */
    private TextView f14911b;
    /* renamed from: c */
    private AppScoreView f14912c;
    /* renamed from: d */
    private TextView f14913d;
    /* renamed from: e */
    private TextView f14914e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public TextProgressBar f14915f;
    /* renamed from: g */
    private ValueAnimator f14916g;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal$2 */
    static /* synthetic */ class C45722 {
        /* renamed from: a */
        static final /* synthetic */ int[] f14918a = new int[DOWNLOADSTAUS.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.kwad.sdk.core.download.DOWNLOADSTAUS[] r0 = com.kwad.sdk.core.download.DOWNLOADSTAUS.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f14918a = r0
            int[] r0 = f14918a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.kwad.sdk.core.download.DOWNLOADSTAUS r1 = com.kwad.sdk.core.download.DOWNLOADSTAUS.START     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f14918a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.kwad.sdk.core.download.DOWNLOADSTAUS r1 = com.kwad.sdk.core.download.DOWNLOADSTAUS.DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f14918a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.kwad.sdk.core.download.DOWNLOADSTAUS r1 = com.kwad.sdk.core.download.DOWNLOADSTAUS.PROGRESS     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal.C45722.m48588clinit():void");
        }
    }

    public TailFrameBarAppPortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18534b();
    }

    /* renamed from: b */
    private void m18534b() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_video_tf_bar_app_portrait_horizontal"), this);
        this.f14910a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_app_icon"));
        this.f14911b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_name"));
        this.f14912c = (AppScoreView) findViewById(C3809l.m15789a(getContext(), "ksad_app_score"));
        this.f14913d = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_download_count"));
        this.f14914e = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_introduce"));
        this.f14915f = (TextProgressBar) findViewById(C3809l.m15789a(getContext(), "ksad_download_bar"));
        this.f14915f.setTextDimen((float) C3817t.m15862a(getContext(), 16.0f));
        this.f14915f.setTextColor(-1);
    }

    /* renamed from: c */
    private void m18535c() {
        ValueAnimator valueAnimator = this.f14916g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.f14916g = ValueAnimator.ofFloat(new float[]{1.0f, 1.2f, 1.0f});
            this.f14916g.setDuration(1200);
            this.f14916g.setRepeatCount(-1);
            this.f14916g.setRepeatMode(1);
            this.f14916g.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    TailFrameBarAppPortraitHorizontal.this.f14915f.setScaleY(floatValue);
                    TailFrameBarAppPortraitHorizontal.this.f14915f.setScaleX(floatValue);
                }
            });
            this.f14916g.start();
        }
    }

    /* renamed from: a */
    public void mo24856a() {
        ValueAnimator valueAnimator = this.f14916g;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f14916g.cancel();
            this.f14916g.end();
        }
    }

    /* renamed from: a */
    public void mo24857a(AdInfo adInfo) {
        int i = C45722.f14918a[adInfo.status.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            mo24856a();
        } else {
            m18535c();
        }
    }

    /* renamed from: a */
    public void mo24858a(AdTemplate adTemplate) {
        AdInfo e = C4324c.m17668e(adTemplate);
        KSImageLoader.loadAppIcon(this.f14910a, C4322a.m17644l(e), 20);
        this.f14911b.setText(C4322a.m17645m(e));
        float p = C4322a.m17648p(e);
        if (p >= 3.0f) {
            this.f14912c.setScore(p);
            this.f14912c.setVisibility(0);
        } else {
            this.f14912c.setVisibility(8);
        }
        String o = C4322a.m17647o(e);
        if (!TextUtils.isEmpty(o)) {
            this.f14913d.setText(o);
            this.f14913d.setVisibility(0);
        } else {
            this.f14913d.setVisibility(8);
        }
        this.f14914e.setText(C4322a.m17643k(e));
        this.f14915f.mo24328a(C4322a.m17650r(e), 0);
        mo24857a(e);
    }

    public TextProgressBar getTextProgressBar() {
        return this.f14915f;
    }
}
