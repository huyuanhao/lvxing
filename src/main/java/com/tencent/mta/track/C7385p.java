package com.tencent.mta.track;

import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.p */
class C7385p implements OnGlobalLayoutListener, Runnable {
    /* renamed from: a */
    private volatile boolean f24970a = false;
    /* renamed from: b */
    private boolean f24971b = true;
    /* renamed from: c */
    private final WeakReference f24972c;
    /* renamed from: d */
    private final C7363aw f24973d;
    /* renamed from: e */
    private final Handler f24974e;

    public C7385p(View view, C7363aw awVar, Handler handler) {
        this.f24973d = awVar;
        this.f24972c = new WeakReference(view);
        this.f24974e = handler;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        run();
    }

    public void onGlobalLayout() {
        run();
    }

    public void run() {
        if (this.f24971b) {
            View view = (View) this.f24972c.get();
            if (view == null || this.f24970a) {
                m31810b();
                return;
            }
            this.f24973d.mo35897a(view);
            this.f24974e.removeCallbacks(this);
            this.f24974e.postDelayed(this, 5000);
        }
    }

    /* renamed from: a */
    public void mo35925a() {
        this.f24970a = true;
        this.f24974e.post(this);
    }

    /* renamed from: b */
    private void m31810b() {
        if (this.f24971b) {
            View view = (View) this.f24972c.get();
            if (view != null) {
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    if (VERSION.SDK_INT < 16) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    } else {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            }
            this.f24973d.mo35896a();
        }
        this.f24971b = false;
    }
}
