package com.kwad.sdk.contentalliance.detail.photo.p313b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.os.SystemClock;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.detail.photo.p314c.C3943g;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.contentalliance.p308a.C3832e;
import com.kwad.sdk.contentalliance.widget.C4055a;
import com.kwad.sdk.contentalliance.widget.KsAdFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p306a.C3809l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.c */
public class C3908c extends C3872b implements C3832e {
    /* renamed from: c */
    private final Random f13209c = new Random();
    /* renamed from: d */
    private List<Integer> f13210d = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: e */
    public RelativeLayout f13211e;
    /* renamed from: f */
    private KsAdFrameLayout f13212f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C4055a f13213g;
    /* renamed from: h */
    private SimpleOnGestureListener f13214h;
    /* renamed from: i */
    private long f13215i;
    /* renamed from: j */
    private boolean f13216j;
    /* renamed from: k */
    private int f13217k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public LinkedList<LottieAnimationView> f13218l = new LinkedList<>();
    /* renamed from: m */
    private C3943g f13219m = new C3943g();
    /* access modifiers changed from: private|final */
    /* renamed from: n */
    public final Runnable f13220n = new Runnable() {
        public void run() {
            C3908c.this.f13213g.mo23715a((long) C4055a.f13616b);
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: o */
    public C3832e f13221o = new C3832e() {
        /* renamed from: a */
        public boolean mo23239a(float f, float f2) {
            return C3908c.this.mo23239a(f, f2);
        }
    };
    /* renamed from: p */
    private C3828a f13222p = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            super.mo23230a();
            C3908c.this.f13211e.removeCallbacks(C3908c.this.f13220n);
            C3908c.this.f13213g.mo23715a((long) C4055a.f13616b);
            C3908c.this.f13125b.f13129c.remove(C3908c.this.f13221o);
            if (C3908c.this.f13211e != null) {
                int i = 0;
                while (i < C3908c.this.f13211e.getChildCount()) {
                    if ((C3908c.this.f13211e.getChildAt(i) instanceof LottieAnimationView) && ((LottieAnimationView) C3908c.this.f13211e.getChildAt(i)).mo22761c()) {
                        ((LottieAnimationView) C3908c.this.f13211e.getChildAt(i)).mo22762d();
                    }
                    i++;
                }
            }
            C3908c.this.f13218l.clear();
            if (C3908c.this.f13211e != null) {
                C3908c.this.f13211e.removeAllViews();
            }
        }

        /* renamed from: b */
        public void mo23231b() {
            super.mo23231b();
            C3908c.this.f13125b.f13129c.add(C3908c.this.f13221o);
        }
    };

    C3908c() {
        mo24762a((Presenter) this.f13219m);
    }

    /* renamed from: a */
    private void m16215a(final LottieAnimationView lottieAnimationView, boolean z) {
        lottieAnimationView.mo22762d();
        lottieAnimationView.setVisibility(4);
        lottieAnimationView.setAnimation(C3809l.m15798g(mo24770p(), z ? "ksad_detail_center_like_anim" : "ksad_detail_center_like_anim2"));
        lottieAnimationView.setSpeed(z ? 2.0f : 1.5f);
        lottieAnimationView.mo22755a((AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                lottieAnimationView.mo22760b(this);
                if (C3908c.this.f13211e.indexOfChild(lottieAnimationView) > -1) {
                    lottieAnimationView.setVisibility(4);
                    if (C3908c.this.f13218l.contains(lottieAnimationView)) {
                        C3908c.this.f13218l.offer(lottieAnimationView);
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                lottieAnimationView.setVisibility(0);
            }
        });
        lottieAnimationView.mo22759b();
    }

    /* renamed from: c */
    private void m16218c(float f, float f2) {
        if (mo24770p() != null) {
            boolean z = f > -1.0f && f2 > -1.0f;
            int i = this.f13217k;
            if (!z) {
                i = (int) (((float) i) * 1.2f);
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f13218l.pollFirst();
            if (lottieAnimationView == null) {
                lottieAnimationView = new LottieAnimationView(mo24770p());
                lottieAnimationView.mo22758a(true);
                RelativeLayout relativeLayout = this.f13211e;
                int i2 = this.f13217k;
                relativeLayout.addView(lottieAnimationView, new LayoutParams(i2, i2));
            }
            LayoutParams layoutParams = (LayoutParams) lottieAnimationView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            if (z) {
                float f3 = ((float) i) / 2.0f;
                lottieAnimationView.setTranslationX(f - f3);
                lottieAnimationView.setTranslationY((f2 - f3) - (((float) this.f13217k) / 3.0f));
                List<Integer> list = this.f13210d;
                lottieAnimationView.setRotation((float) ((Integer) list.get(this.f13209c.nextInt(list.size()))).intValue());
                layoutParams.addRule(13, 0);
            } else {
                lottieAnimationView.setTranslationX(0.0f);
                lottieAnimationView.setTranslationY(0.0f);
                lottieAnimationView.setRotation(0.0f);
                layoutParams.addRule(13, -1);
            }
            lottieAnimationView.setLayoutParams(layoutParams);
            m16215a(lottieAnimationView, z);
        }
    }

    /* renamed from: g */
    private void m16223g() {
        if (this.f13214h == null) {
            this.f13214h = new SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    return C3908c.this.mo23416a(motionEvent);
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    C3908c.this.mo23418b(motionEvent);
                    return super.onSingleTapConfirmed(motionEvent);
                }

                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    C3908c.this.mo23419c(motionEvent);
                    return super.onSingleTapUp(motionEvent);
                }
            };
        }
    }

    /* renamed from: h */
    private void m16224h() {
        if (this.f13213g == null) {
            if (this.f13214h == null) {
                m16223g();
            }
            this.f13213g = new C4055a(mo24770p(), this.f13214h) {
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return motionEvent.getActionMasked() == 6 ? C3908c.this.mo23420d(motionEvent) : super.onTouchEvent(motionEvent);
                }
            };
        }
    }

    /* renamed from: i */
    private boolean m16225i() {
        return SystemClock.elapsedRealtime() - this.f13215i < ((long) ViewConfiguration.getJumpTapTimeout());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13125b.f13127a.add(this.f13222p);
        this.f13212f.mo23712a(this.f13213g);
    }

    /* renamed from: a */
    public boolean mo23239a(float f, float f2) {
        this.f13213g.mo23715a(500);
        this.f13211e.removeCallbacks(this.f13220n);
        this.f13211e.postDelayed(this.f13220n, 500);
        this.f13219m.mo23447i();
        m16218c(f, f2);
        return true;
    }

    /* renamed from: a */
    public boolean mo23416a(MotionEvent motionEvent) {
        this.f13215i = SystemClock.elapsedRealtime();
        return this.f13216j || mo23239a(motionEvent.getX(), motionEvent.getY());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        if (mo24770p() != null) {
            this.f13217k = mo24770p().getResources().getDimensionPixelSize(C3809l.m15794c(mo24770p(), "ksad_slide_play_center_like_view_size"));
        }
        this.f13211e = (RelativeLayout) mo24760a("ksad_slide_play_like_image");
        this.f13212f = (KsAdFrameLayout) mo24760a("ksad_video_container");
        m16223g();
        for (int i = -15; i < 15; i++) {
            this.f13210d.add(Integer.valueOf(i));
        }
        this.f13212f.setClickable(true);
        m16224h();
    }

    /* renamed from: b */
    public boolean mo23417b(float f, float f2) {
        this.f13215i = SystemClock.elapsedRealtime();
        this.f13216j = true;
        return mo23239a(f, f2);
    }

    /* renamed from: b */
    public boolean mo23418b(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        mo24768n().setOnTouchListener(null);
        this.f13211e.setOnTouchListener(null);
        this.f13212f.mo23713b(this.f13213g);
        this.f13125b.f13129c.remove(this.f13221o);
    }

    /* renamed from: c */
    public boolean mo23419c(MotionEvent motionEvent) {
        if (m16225i()) {
            return mo23417b(motionEvent.getX(), motionEvent.getY());
        }
        this.f13216j = false;
        return false;
    }

    /* renamed from: d */
    public boolean mo23420d(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (m16225i()) {
            return mo23417b(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo23421f() {
        RelativeLayout relativeLayout = this.f13211e;
        if (relativeLayout != null) {
            relativeLayout.removeCallbacks(this.f13220n);
        }
        super.mo23421f();
    }
}
