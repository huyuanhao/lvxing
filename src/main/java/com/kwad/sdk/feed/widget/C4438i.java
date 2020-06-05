package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p334h.p336b.C4185a;
import com.kwad.sdk.core.p334h.p336b.C4198d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.p306a.C3818u;
import com.kwad.sdk.p306a.C3818u.C3819a;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.feed.widget.i */
public class C4438i extends C4185a implements C3819a {
    /* renamed from: b */
    private View f14540b = this;
    /* renamed from: c */
    private final C3818u f14541c = new C3818u(this);
    /* renamed from: d */
    private final AtomicBoolean f14542d = new AtomicBoolean(true);

    public C4438i(Context context, AdTemplate adTemplate, C4198d dVar) {
        super(context, adTemplate, dVar);
    }

    /* renamed from: j */
    private void m18093j() {
        if (this.f14542d.getAndSet(false)) {
            C4065b.m16867b("FeedVideoPlayerController", "onViewAttached");
            this.f14541c.sendEmptyMessage(1);
        }
    }

    /* renamed from: k */
    private void m18094k() {
        if (!this.f14542d.getAndSet(true)) {
            C4065b.m16867b("FeedVideoPlayerController", "onViewDetached");
            this.f14541c.removeCallbacksAndMessages(null);
            mo23936f();
        }
    }

    /* renamed from: a */
    public void mo23214a(Message message) {
        if (message.what == 1) {
            if (C3817t.m15867a(this.f14540b, 30)) {
                mo23934d();
            } else {
                mo23935e();
            }
            this.f14541c.sendEmptyMessageDelayed(1, 500);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C4065b.m16867b("FeedVideoPlayerController", "onAttachedToWindow");
        m18093j();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4065b.m16867b("FeedVideoPlayerController", "onDetachedFromWindow");
        m18094k();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        C4065b.m16867b("FeedVideoPlayerController", "onFinishTemporaryDetach");
        m18093j();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        C4065b.m16867b("FeedVideoPlayerController", "onStartTemporaryDetach");
        m18094k();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
