package com.kwad.sdk.draw.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.draw.C4375b;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3812o;
import com.kwad.sdk.p306a.C3817t;

public class DrawCardH5 extends FrameLayout implements OnClickListener {
    /* renamed from: a */
    private Context f14342a;
    /* renamed from: b */
    private AdTemplate f14343b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C4382a f14344c;
    /* renamed from: d */
    private int f14345d;
    /* renamed from: e */
    private ImageView f14346e;
    /* renamed from: f */
    private TextView f14347f;
    /* renamed from: g */
    private TextView f14348g;
    /* renamed from: h */
    private ValueAnimator f14349h;

    /* renamed from: com.kwad.sdk.draw.view.DrawCardH5$a */
    public interface C4382a {
        /* renamed from: a */
        void mo23365a();

        /* renamed from: b */
        void mo23366b();
    }

    public DrawCardH5(Context context) {
        super(context);
        m17871a(context);
    }

    public DrawCardH5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17871a(context);
    }

    public DrawCardH5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17871a(context);
    }

    /* renamed from: a */
    private void m17870a(int i, int i2) {
        m17872d();
        this.f14349h = C4375b.m17853a(this, i, i2);
        this.f14349h.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f14349h.setDuration(300);
        this.f14349h.start();
    }

    /* renamed from: a */
    private void m17871a(Context context) {
        this.f14342a = context;
        inflate(context, C3809l.m15792b(context, "ksad_draw_card_h5"), this);
        this.f14346e = (ImageView) findViewById(C3809l.m15789a(context, "ksad_card_close"));
        this.f14347f = (TextView) findViewById(C3809l.m15789a(context, "ksad_card_ad_desc"));
        this.f14348g = (TextView) findViewById(C3809l.m15789a(context, "ksad_card_h5_open_btn"));
    }

    /* renamed from: d */
    private void m17872d() {
        ValueAnimator valueAnimator = this.f14349h;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f14349h.cancel();
        }
    }

    /* renamed from: a */
    public void mo24562a() {
        m17872d();
    }

    /* renamed from: a */
    public void mo24563a(AdTemplate adTemplate, C4382a aVar) {
        this.f14343b = adTemplate;
        AdInfo e = C4324c.m17668e(this.f14343b);
        this.f14344c = aVar;
        this.f14347f.setText(C4322a.m17643k(e));
        this.f14348g.setText(C4322a.m17650r(e));
        this.f14346e.setOnClickListener(this);
        this.f14348g.setOnClickListener(this);
        setOnClickListener(this);
        this.f14347f.measure(MeasureSpec.makeMeasureSpec((C3812o.m15835g(this.f14342a) - (C3817t.m15862a(this.f14342a, 16.0f) * 2)) - (C3817t.m15862a(this.f14342a, 10.0f) * 2), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        this.f14345d = C3817t.m15862a(this.f14342a, 100.0f) + this.f14347f.getMeasuredHeight();
    }

    /* renamed from: b */
    public void mo24564b() {
        m17870a(0, this.f14345d);
    }

    /* renamed from: c */
    public void mo24565c() {
        m17870a(this.f14345d, 0);
    }

    public void onClick(View view) {
        if (view == this.f14346e) {
            mo24565c();
            C4382a aVar = this.f14344c;
            if (aVar != null) {
                aVar.mo23365a();
                return;
            }
            return;
        }
        C4087a.m16967a(getContext(), this.f14343b, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (DrawCardH5.this.f14344c != null) {
                    DrawCardH5.this.f14344c.mo23366b();
                }
            }
        }, null);
    }
}
