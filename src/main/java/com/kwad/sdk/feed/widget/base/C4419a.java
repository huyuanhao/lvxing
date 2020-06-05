package com.kwad.sdk.feed.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.page.widget.C4248a;
import com.kwad.sdk.core.page.widget.C4248a.C4249a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3803g.C3804a;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.feed.widget.base.a */
public abstract class C4419a extends RatioFrameLayout {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AdTemplate f14492a;
    /* access modifiers changed from: protected */
    /* renamed from: b */
    public AdInfo f14493b;
    /* renamed from: c */
    protected C4421a f14494c;
    /* renamed from: d */
    protected Context f14495d;
    /* renamed from: e */
    protected C3804a f14496e;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a */
    public interface C4421a {
        /* renamed from: a */
        void mo24709a();

        /* renamed from: b */
        void mo24710b();

        /* renamed from: c */
        void mo24711c();
    }

    public C4419a(Context context) {
        this(context, null);
    }

    public C4419a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C4419a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14496e = new C3804a();
        this.f14495d = context;
        m18027e();
    }

    /* renamed from: a */
    private void m18025a(ViewGroup viewGroup) {
        C4248a b = m18026b(viewGroup);
        if (b == null) {
            b = new C4248a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new C4249a() {
            /* renamed from: a */
            public void mo24349a() {
            }

            /* renamed from: a */
            public void mo24350a(View view) {
                C4419a.this.mo24719b();
            }

            /* renamed from: a */
            public void mo24351a(boolean z) {
            }

            /* renamed from: b */
            public void mo24352b() {
            }
        });
        b.setNeedCheckingShow(true);
    }

    /* renamed from: b */
    private C4248a m18026b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof C4248a) {
                return (C4248a) childAt;
            }
        }
        return null;
    }

    /* renamed from: e */
    private void m18027e() {
        inflate(this.f14495d, getLayoutId(), this);
        setRatio(getHWRatio());
        mo24712a();
        m18025a((ViewGroup) this);
    }

    /* renamed from: a */
    public abstract void mo24712a();

    /* renamed from: a */
    public void mo24713a(AdTemplate adTemplate) {
        this.f14492a = adTemplate;
        this.f14493b = C4324c.m17668e(adTemplate);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo24719b() {
        if (!this.f14492a.mPvReported) {
            C4421a aVar = this.f14494c;
            if (aVar != null) {
                aVar.mo24710b();
            }
        }
        C4143b.m17123a(this.f14492a, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo24720c() {
        C4143b.m17122a(this.f14492a, getTouchCoords());
        C4421a aVar = this.f14494c;
        if (aVar != null) {
            aVar.mo24709a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo24721d() {
        C4143b.m17115a(this.f14492a);
        C4421a aVar = this.f14494c;
        if (aVar != null) {
            aVar.mo24711c();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14496e = new C3804a(getWidth(), getHeight());
            this.f14496e.mo23197a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f14496e.mo23200b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public C3804a getTouchCoords() {
        return this.f14496e;
    }

    public void setAdClickListener(C4421a aVar) {
        this.f14494c = aVar;
    }
}
