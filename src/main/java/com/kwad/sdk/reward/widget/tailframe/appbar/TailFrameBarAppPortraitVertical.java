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

public class TailFrameBarAppPortraitVertical extends LinearLayout {
    /* renamed from: a */
    private ImageView f14919a;
    /* renamed from: b */
    private TextView f14920b;
    /* renamed from: c */
    private AppScoreView f14921c;
    /* renamed from: d */
    private TextView f14922d;
    /* renamed from: e */
    private TextView f14923e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public TextProgressBar f14924f;
    /* renamed from: g */
    private ValueAnimator f14925g;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical$2 */
    static /* synthetic */ class C45742 {
        /* renamed from: a */
        static final /* synthetic */ int[] f14927a = new int[DOWNLOADSTAUS.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.kwad.sdk.core.download.DOWNLOADSTAUS[] r0 = com.kwad.sdk.core.download.DOWNLOADSTAUS.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f14927a = r0
            int[] r0 = f14927a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.kwad.sdk.core.download.DOWNLOADSTAUS r1 = com.kwad.sdk.core.download.DOWNLOADSTAUS.START     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f14927a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.kwad.sdk.core.download.DOWNLOADSTAUS r1 = com.kwad.sdk.core.download.DOWNLOADSTAUS.DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f14927a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.kwad.sdk.core.download.DOWNLOADSTAUS r1 = com.kwad.sdk.core.download.DOWNLOADSTAUS.PROGRESS     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.C45742.m48593clinit():void");
        }
    }

    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitVertical(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitVertical(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18540b();
    }

    /* renamed from: b */
    private void m18540b() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_video_tf_bar_app_portrait_vertical"), this);
        this.f14919a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_app_icon"));
        this.f14921c = (AppScoreView) findViewById(C3809l.m15789a(getContext(), "ksad_app_score"));
        this.f14922d = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_download_count"));
        this.f14920b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_name"));
        this.f14923e = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_introduce"));
        this.f14924f = (TextProgressBar) findViewById(C3809l.m15789a(getContext(), "ksad_download_bar"));
        this.f14924f.setTextDimen((float) C3817t.m15862a(getContext(), 16.0f));
        this.f14924f.setTextColor(-1);
    }

    /* renamed from: c */
    private void m18541c() {
        ValueAnimator valueAnimator = this.f14925g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.f14925g = ValueAnimator.ofFloat(new float[]{1.0f, 1.2f, 1.0f});
            this.f14925g.setDuration(1200);
            this.f14925g.setRepeatCount(-1);
            this.f14925g.setRepeatMode(1);
            this.f14925g.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    TailFrameBarAppPortraitVertical.this.f14924f.setScaleY(floatValue);
                    TailFrameBarAppPortraitVertical.this.f14924f.setScaleX(floatValue);
                }
            });
            this.f14925g.start();
        }
    }

    /* renamed from: a */
    public void mo24861a() {
        ValueAnimator valueAnimator = this.f14925g;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f14925g.cancel();
            this.f14925g.end();
        }
    }

    /* renamed from: a */
    public void mo24862a(AdInfo adInfo) {
        int i = C45742.f14927a[adInfo.status.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            mo24861a();
        } else {
            m18541c();
        }
    }

    /* renamed from: a */
    public void mo24863a(AdTemplate adTemplate) {
        AdInfo e = C4324c.m17668e(adTemplate);
        KSImageLoader.loadAppIcon(this.f14919a, C4322a.m17644l(e), 12);
        this.f14920b.setText(C4322a.m17645m(e));
        float p = C4322a.m17648p(e);
        if (p >= 3.0f) {
            this.f14921c.setScore(p);
            this.f14921c.setVisibility(0);
        } else {
            this.f14921c.setVisibility(8);
        }
        String o = C4322a.m17647o(e);
        if (!TextUtils.isEmpty(o)) {
            this.f14922d.setText(o);
            this.f14922d.setVisibility(0);
        } else {
            this.f14922d.setVisibility(8);
        }
        this.f14923e.setText(C4322a.m17643k(e));
        this.f14924f.mo24328a(C4322a.m17650r(e), 0);
        mo24862a(e);
    }

    public TextProgressBar getTextProgressBar() {
        return this.f14924f;
    }
}
