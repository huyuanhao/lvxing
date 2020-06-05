package com.kwad.sdk.core.p334h.p336b;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.kwad.sdk.core.h.b.c */
public abstract class C4195c extends FrameLayout {
    /* renamed from: a */
    protected C4198d f13964a;
    /* renamed from: b */
    private Timer f13965b;
    /* renamed from: c */
    private TimerTask f13966c;

    public C4195c(Context context, C4198d dVar) {
        super(context);
        this.f13964a = dVar;
    }

    /* renamed from: a */
    public abstract void mo23931a(int i);

    /* renamed from: c */
    public abstract void mo23933c();

    /* renamed from: g */
    public abstract void mo23937g();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo23969h() {
        mo23970i();
        if (this.f13965b == null) {
            this.f13965b = new Timer();
        }
        if (this.f13966c == null) {
            this.f13966c = new TimerTask() {
                public void run() {
                    C4195c.this.post(new Runnable() {
                        public void run() {
                            C4195c.this.mo23937g();
                        }
                    });
                }
            };
        }
        this.f13965b.schedule(this.f13966c, 0, 1000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo23970i() {
        Timer timer = this.f13965b;
        if (timer != null) {
            timer.cancel();
            this.f13965b = null;
        }
        TimerTask timerTask = this.f13966c;
        if (timerTask != null) {
            timerTask.cancel();
            this.f13966c = null;
        }
    }
}
