package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.p306a.C3818u;
import com.kwad.sdk.p306a.C3818u.C3819a;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.core.page.widget.a */
public class C4248a extends View implements C3819a {
    /* renamed from: a */
    private C4249a f14060a;
    /* renamed from: b */
    private View f14061b;
    /* renamed from: c */
    private boolean f14062c;
    /* renamed from: d */
    private boolean f14063d;
    /* renamed from: e */
    private boolean f14064e;
    /* renamed from: f */
    private final C3818u f14065f = new C3818u(this);
    /* renamed from: g */
    private final AtomicBoolean f14066g = new AtomicBoolean(true);

    /* renamed from: com.kwad.sdk.core.page.widget.a$a */
    public interface C4249a {
        /* renamed from: a */
        void mo24349a();

        /* renamed from: a */
        void mo24350a(View view);

        /* renamed from: a */
        void mo24351a(boolean z);

        /* renamed from: b */
        void mo24352b();
    }

    public C4248a(Context context, View view) {
        super(context);
        this.f14061b = view;
        setLayoutParams(new LayoutParams(0, 0));
    }

    /* renamed from: a */
    private void m17489a() {
        if (this.f14066g.getAndSet(false)) {
            C4249a aVar = this.f14060a;
            if (aVar != null) {
                aVar.mo24349a();
            }
        }
    }

    /* renamed from: b */
    private void m17490b() {
        if (!this.f14066g.getAndSet(true)) {
            C4249a aVar = this.f14060a;
            if (aVar != null) {
                aVar.mo24352b();
            }
        }
    }

    /* renamed from: c */
    private void m17491c() {
        if (this.f14063d) {
            this.f14065f.removeCallbacksAndMessages(null);
            this.f14063d = false;
        }
    }

    /* renamed from: d */
    private void m17492d() {
        if (this.f14064e && !this.f14063d) {
            this.f14063d = true;
            this.f14065f.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    public void mo23214a(Message message) {
        int i = message.what;
        String str = "EmptyView";
        if (i == 1) {
            C4065b.m16863a(str, "handleMsg MSG_CHECKING");
            if (!this.f14063d) {
                return;
            }
            if (C3817t.m15867a(this.f14061b, 30)) {
                m17491c();
                Message obtainMessage = this.f14065f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f14065f.sendMessageDelayed(obtainMessage, 1000);
                return;
            }
            this.f14065f.sendEmptyMessageDelayed(1, 500);
        } else if (i == 2) {
            C4065b.m16863a(str, "handleMsg MSG_SHOWING");
            if (C3817t.m15867a(this.f14061b, 30)) {
                if (message.arg1 == 1000) {
                    C4249a aVar = this.f14060a;
                    if (aVar != null) {
                        aVar.mo24350a(this.f14061b);
                    }
                }
                this.f14065f.sendEmptyMessageDelayed(2, 500);
            } else if (!this.f14062c) {
                setNeedCheckingShow(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        StringBuilder sb = new StringBuilder();
        sb.append("onAttachedToWindow:");
        sb.append(this);
        C4065b.m16863a("EmptyView", sb.toString());
        m17492d();
        this.f14062c = false;
        m17489a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StringBuilder sb = new StringBuilder();
        sb.append("onDetachedFromWindow");
        sb.append(this);
        C4065b.m16863a("EmptyView", sb.toString());
        m17491c();
        this.f14062c = true;
        m17490b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        StringBuilder sb = new StringBuilder();
        sb.append("onFinishTemporaryDetach:");
        sb.append(this.f14061b.getParent());
        C4065b.m16863a("EmptyView", sb.toString());
        m17489a();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        StringBuilder sb = new StringBuilder();
        sb.append("onStartTemporaryDetach:");
        sb.append(this.f14061b.getParent());
        C4065b.m16863a("EmptyView", sb.toString());
        m17490b();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        StringBuilder sb = new StringBuilder();
        sb.append("onWindowFocusChanged hasWindowFocus:");
        sb.append(z);
        C4065b.m16863a("EmptyView", sb.toString());
        C4249a aVar = this.f14060a;
        if (aVar != null) {
            aVar.mo24351a(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        StringBuilder sb = new StringBuilder();
        sb.append("onWindowVisibilityChanged visibility:");
        sb.append(i);
        C4065b.m16863a("EmptyView", sb.toString());
    }

    public void setNeedCheckingShow(boolean z) {
        this.f14064e = z;
        if (!z && this.f14063d) {
            m17491c();
        } else if (z && !this.f14063d) {
            m17492d();
        }
    }

    public void setViewCallback(C4249a aVar) {
        this.f14060a = aVar;
    }
}
