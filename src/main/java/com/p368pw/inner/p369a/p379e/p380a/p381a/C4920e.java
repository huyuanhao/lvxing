package com.p368pw.inner.p369a.p379e.p380a.p381a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;

/* renamed from: com.pw.inner.a.e.a.a.e */
public class C4920e extends FrameLayout implements C4913a, C4914b {
    /* renamed from: a */
    private SurfaceView f15905a;
    /* renamed from: b */
    private SurfaceHolder f15906b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C4913a f15907c;
    /* renamed from: d */
    private Context f15908d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public Activity f15909e;
    /* renamed from: f */
    private int f15910f;
    /* renamed from: g */
    private int f15911g;
    /* renamed from: h */
    private double f15912h;
    /* renamed from: i */
    private double f15913i;
    /* renamed from: j */
    private boolean f15914j;
    /* renamed from: k */
    private boolean f15915k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean f15916l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean f15917m;
    /* renamed from: n */
    private C4914b f15918n;
    /* renamed from: o */
    private C4924c f15919o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public C4915c f15920p;
    /* renamed from: q */
    private int f15921q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean f15922r;

    /* renamed from: com.pw.inner.a.e.a.a.e$a */
    public static class C4922a implements C4914b {
        /* renamed from: b */
        public void mo26068b(String str) {
        }

        /* renamed from: d */
        public void mo26069d(int i) {
        }

        /* renamed from: e */
        public void mo26070e(int i) {
        }

        /* renamed from: g */
        public void mo26071g() {
        }

        /* renamed from: h */
        public void mo26072h() {
        }

        /* renamed from: i */
        public void mo26073i() {
        }

        /* renamed from: j */
        public void mo26074j() {
        }

        /* renamed from: k */
        public void mo26075k() {
        }

        /* renamed from: l */
        public void mo26076l() {
        }

        /* renamed from: m */
        public void mo26077m() {
        }
    }

    /* renamed from: com.pw.inner.a.e.a.a.e$b */
    public interface C4923b {
        /* renamed from: a */
        void mo26113a(MediaPlayer mediaPlayer, int i, int i2);
    }

    /* renamed from: com.pw.inner.a.e.a.a.e$c */
    private class C4924c implements Callback {
        private C4924c() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            String str;
            C5205o.m21462a("play vw surfaceCreated");
            try {
                if (C4920e.this.f15916l) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("play vw restarted,  destroyed = ");
                    sb.append(C4920e.this.f15917m);
                    C5205o.m21462a(sb.toString());
                    if (C4920e.this.f15917m) {
                        Configuration configuration = C4920e.this.f15909e.getResources().getConfiguration();
                        if (configuration.orientation == 2) {
                            C4920e.this.m20391i(0);
                        } else if (configuration.orientation == 1) {
                            C4920e.this.m20391i(1);
                        }
                        C4920e.this.f15907c.mo26057a(surfaceHolder);
                        return;
                    }
                    C4920e.this.f15907c.mo26062c();
                    if (C4920e.this.f15920p != null) {
                        C4920e.this.f15920p.mo26079o();
                        return;
                    }
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("play vw started, destroyed = ");
                sb2.append(C4920e.this.f15917m);
                C5205o.m21462a(sb2.toString());
                if (!C4920e.this.f15917m) {
                    C4920e.this.f15907c.mo26059b(surfaceHolder);
                    C4920e.this.f15922r = true;
                    C4920e.this.f15907c.mo26060b();
                    if (C4920e.this.f15920p != null) {
                        C4920e.this.f15920p.mo26078n();
                    }
                    str = "play vm pl";
                } else {
                    if (C4920e.this.f15920p != null) {
                        C4920e.this.f15920p.mo26080p();
                    }
                    ((C4916d) C4920e.this.f15907c).mo26086c(surfaceHolder);
                    str = "play vm ed";
                }
                C5205o.m21462a(str);
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            C5205o.m21462a("play vw surfaceDestroyed");
            C4920e.this.f15917m = true;
            try {
                if (C4920e.this.f15907c.mo26065f()) {
                    C4920e.this.f15907c.mo26063d();
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }

    public C4920e(Context context) {
        this(context, null);
    }

    public C4920e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C4920e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15914j = true;
        this.f15921q = Integer.MIN_VALUE;
        this.f15922r = false;
        this.f15908d = context.getApplicationContext();
    }

    /* renamed from: a */
    private int m20378a(Activity activity) {
        if (VERSION.SDK_INT < 19) {
            return activity.getApplication().getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: a */
    private void m20380a(View... viewArr) {
        if (viewArr != null && viewArr.length != 0) {
            for (View view : viewArr) {
                if (view != null) {
                    try {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(view);
                        }
                        if (view instanceof ViewGroup) {
                            ((ViewGroup) view).removeAllViews();
                        }
                        view.destroyDrawingCache();
                    } catch (Throwable th) {
                        C5205o.m21464a(th);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private int m20383b(Activity activity) {
        if (VERSION.SDK_INT < 19) {
            return activity.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* renamed from: b */
    private void m20384b(C4913a aVar) {
        if (aVar == null) {
            aVar = m20393q();
        }
        this.f15907c = aVar;
        this.f15907c.mo26053a((C4914b) this);
    }

    /* access modifiers changed from: private */
    public C4914b getPlayerListener() {
        if (this.f15918n == null) {
            this.f15918n = new C4922a();
        }
        return this.f15918n;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m20391i(int i) {
        double d;
        double d2;
        this.f15921q = i;
        Activity activity = this.f15909e;
        if (activity != null) {
            int b = m20383b(activity);
            int a = m20378a(this.f15909e);
            this.f15912h = (double) ((C4916d) this.f15907c).mo26089g();
            this.f15913i = (double) ((C4916d) this.f15907c).mo26090h();
            if (this.f15912h == 0.0d) {
                this.f15912h = (double) b;
            }
            if (this.f15913i == 0.0d) {
                this.f15913i = (double) a;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("play vw mVideoWidth: ");
            sb.append(this.f15912h);
            sb.append(" mVideoHeight: ");
            sb.append(this.f15913i);
            C5205o.m21462a(sb.toString());
            if (VERSION.SDK_INT < 19 && (i == 0 || i == 8)) {
                int i2 = a;
                a = b;
                b = i2;
            }
            float f = ((float) b) / ((float) this.f15912h);
            float f2 = ((float) a) / ((float) this.f15913i);
            float min = Math.min(f, f2);
            if (this.f15913i <= this.f15912h || !(i == 1 || i == 7)) {
                d = (double) min;
                this.f15910f = (int) (this.f15912h * d);
                d2 = this.f15913i;
            } else {
                float max = Math.max(f, f2);
                this.f15910f = (int) (this.f15912h * ((double) f));
                d2 = this.f15913i;
                d = (double) max;
            }
            this.f15911g = (int) (d2 * d);
            LayoutParams layoutParams = new LayoutParams(this.f15910f, this.f15911g);
            layoutParams.gravity = 17;
            this.f15905a.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: p */
    private void m20392p() {
        if (this.f15905a == null) {
            this.f15905a = new SurfaceView(this.f15908d);
        }
        this.f15906b = this.f15905a.getHolder();
        this.f15906b.setType(3);
        this.f15906b.setFormat(-3);
        if (this.f15919o == null) {
            this.f15919o = new C4924c();
            this.f15906b.addCallback(this.f15919o);
        }
    }

    /* renamed from: q */
    private C4913a m20393q() {
        return new C4916d();
    }

    /* renamed from: a */
    public C4920e mo26100a(C4913a aVar) {
        m20392p();
        m20384b(aVar);
        return this;
    }

    /* renamed from: a */
    public void mo26101a(int i, Activity activity) {
        this.f15909e = activity;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        m20391i(i);
        LayoutParams layoutParams = new LayoutParams(this.f15910f, this.f15911g);
        layoutParams.gravity = 17;
        addView(this.f15905a, layoutParams);
    }

    /* renamed from: a */
    public void mo26057a(SurfaceHolder surfaceHolder) {
        this.f15907c.mo26057a(surfaceHolder);
    }

    /* renamed from: b */
    public C4920e mo26053a(C4914b bVar) {
        this.f15918n = bVar;
        return this;
    }

    /* renamed from: b */
    public C4920e mo26054a(C4915c cVar) {
        this.f15920p = cVar;
        return this;
    }

    /* renamed from: b */
    public C4920e mo26056a(boolean z) {
        this.f15914j = z;
        this.f15907c.mo26056a(z);
        return this;
    }

    /* renamed from: b */
    public void mo26060b() {
        C5205o.m21462a("play vw play");
        this.f15922r = true;
        this.f15907c.mo26060b();
    }

    /* renamed from: b */
    public void mo26068b(String str) {
        getPlayerListener().mo26068b(str);
    }

    /* renamed from: c */
    public C4920e mo26059b(SurfaceHolder surfaceHolder) {
        this.f15907c.mo26059b(surfaceHolder);
        return this;
    }

    /* renamed from: c */
    public C4920e mo26055a(String str) {
        this.f15907c.mo26055a(str);
        return this;
    }

    /* renamed from: c */
    public void mo26062c() {
        C5205o.m21462a("play vw resume");
        try {
            if (this.f15915k && !this.f15916l) {
                this.f15915k = false;
                this.f15916l = true;
                if (this.f15917m) {
                    m20392p();
                } else {
                    if (this.f15920p != null) {
                        this.f15920p.mo26079o();
                    }
                    this.f15907c.mo26062c();
                }
                if (this.f15920p != null) {
                    this.f15920p.mo26082r();
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: d */
    public void mo26063d() {
        C5205o.m21462a("play vw pause");
        try {
            this.f15915k = true;
            this.f15916l = false;
            if (this.f15920p != null) {
                this.f15920p.mo26081q();
            }
            this.f15907c.mo26063d();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: d */
    public void mo26069d(int i) {
        getPlayerListener().mo26069d(i);
    }

    /* renamed from: e */
    public void mo26064e() {
        try {
            if (this.f15907c != null) {
                this.f15907c.mo26064e();
                this.f15907c = null;
            }
            if (this.f15906b != null) {
                if (this.f15919o != null) {
                    this.f15906b.removeCallback(this.f15919o);
                }
                this.f15906b = null;
            }
            getPlayerListener().mo26077m();
            this.f15918n = null;
            this.f15909e = null;
            m20380a(this.f15905a);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: e */
    public void mo26070e(int i) {
        getPlayerListener().mo26070e(i);
    }

    /* renamed from: f */
    public C4920e mo26058b(int i) {
        this.f15912h = (double) i;
        return this;
    }

    /* renamed from: f */
    public boolean mo26065f() {
        return this.f15907c.mo26065f();
    }

    /* renamed from: g */
    public C4920e mo26061c(int i) {
        this.f15913i = (double) i;
        return this;
    }

    /* renamed from: g */
    public void mo26071g() {
        getPlayerListener().mo26071g();
    }

    public int getCurrentPosition() {
        return this.f15907c.getCurrentPosition();
    }

    public int getDuration() {
        return this.f15907c.getDuration();
    }

    /* renamed from: h */
    public C4920e mo26052a(int i) {
        m20391i(i);
        requestLayout();
        return this;
    }

    /* renamed from: h */
    public void mo26072h() {
        getPlayerListener().mo26072h();
    }

    /* renamed from: i */
    public void mo26073i() {
        int i = this.f15921q;
        if (i != Integer.MIN_VALUE) {
            m20391i(i);
        }
        if (this.f15922r && !this.f15915k) {
            this.f15907c.mo26060b();
        }
        getPlayerListener().mo26073i();
    }

    /* renamed from: j */
    public void mo26074j() {
        this.f15917m = false;
        getPlayerListener().mo26074j();
    }

    /* renamed from: k */
    public void mo26075k() {
        getPlayerListener().mo26075k();
    }

    /* renamed from: l */
    public void mo26076l() {
        C5208r.m21479a(new Runnable() {
            public void run() {
                C4920e.this.getPlayerListener().mo26076l();
            }
        });
    }

    /* renamed from: m */
    public void mo26077m() {
        getPlayerListener().mo26077m();
    }

    /* renamed from: n */
    public C4920e mo26110n() {
        mo26100a((C4913a) null);
        return this;
    }

    /* renamed from: o */
    public C4920e mo26051a() {
        this.f15907c.mo26051a();
        return this;
    }
}
