package com.kwad.sdk.contentalliance.home.p315a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.contentalliance.detail.photo.C3885a;
import com.kwad.sdk.contentalliance.home.C4012d;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3810m;

/* renamed from: com.kwad.sdk.contentalliance.home.a.d */
public class C4002d extends C4012d {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public LottieAnimationView f13443b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public View f13444c;
    /* renamed from: d */
    private TextView f13445d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public SlidePlayViewPager f13446e;
    /* renamed from: f */
    private SimpleOnGestureListener f13447f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public SimpleOnGestureListener f13448g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public GestureDetector f13449h;
    /* renamed from: i */
    private OnPageChangeListener f13450i;
    /* renamed from: j */
    private boolean f13451j = false;
    /* renamed from: k */
    private boolean f13452k = false;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public int f13453l = 0;
    /* renamed from: m */
    private boolean f13454m = false;
    /* renamed from: n */
    private Runnable f13455n = new Runnable() {
        public void run() {
            C4002d.this.f13444c.setOnTouchListener(null);
            C4002d.this.f13444c.setVisibility(8);
        }
    };

    /* renamed from: g */
    private void m16601g() {
        this.f13450i = new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
                if (C4002d.this.mo24770p() != null && i == 2 && C3810m.m15802a(C4002d.this.mo24770p()) && !C3810m.m15805d(C4002d.this.mo24770p())) {
                    C3810m.m15801a(C4002d.this.mo24770p(), true);
                }
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (C4002d.this.f13453l == 1) {
                    C4002d.this.f13453l = 2;
                    if ((C4002d.this.f13446e.getAdapter().mo23609a() instanceof C3885a) && C4002d.this.mo24770p() != null) {
                        if (C4002d.this.mo24770p() != null && C3810m.m15802a(C4002d.this.mo24770p())) {
                            C3810m.m15801a(C4002d.this.mo24770p(), true);
                        }
                        C4002d.this.m16616r();
                        C4002d dVar = C4002d.this;
                        dVar.f13449h = new GestureDetector(dVar.mo24770p(), C4002d.this.f13448g);
                        C4002d.this.f13444c.setClickable(true);
                        C4002d.this.f13444c.setOnTouchListener(new OnTouchListener() {
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                return C4002d.this.f13449h.onTouchEvent(motionEvent);
                            }
                        });
                    }
                }
            }
        };
        this.f13446e.mo23259a(this.f13450i);
    }

    /* renamed from: h */
    private void m16602h() {
        GestureDetector gestureDetector;
        if (this.f13447f == null) {
            this.f13447f = new SimpleOnGestureListener() {
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return (f2 >= -5000.0f || Math.abs(f2) <= Math.abs(f) * 3.0f) ? super.onFling(motionEvent, motionEvent2, f, f2) : C4002d.this.m16613q();
                }

                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return (f2 <= 60.0f || Math.abs(f2) <= Math.abs(f) * 2.0f) ? super.onScroll(motionEvent, motionEvent2, f, f2) : C4002d.this.m16613q();
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return C4002d.this.m16613q();
                }

                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return C4002d.this.m16613q();
                }
            };
            this.f13448g = new SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    Fragment a = C4002d.this.f13446e.getAdapter().mo23609a();
                    if (a instanceof C3885a) {
                        ((C3885a) a).mo23384a(motionEvent.getX(), motionEvent.getY());
                    }
                    return C4002d.this.m16605i();
                }

                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return C4002d.this.m16605i();
                }

                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return C4002d.this.m16605i();
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return C4002d.this.m16605i();
                }
            };
            int i = this.f13453l;
            if (i == 0) {
                gestureDetector = new GestureDetector(mo24770p(), this.f13447f);
            } else {
                if (i == 1) {
                    gestureDetector = new GestureDetector(mo24770p(), this.f13448g);
                }
                this.f13444c.setClickable(true);
                this.f13444c.setOnTouchListener(new OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return C4002d.this.f13449h.onTouchEvent(motionEvent);
                    }
                });
            }
            this.f13449h = gestureDetector;
            this.f13444c.setClickable(true);
            this.f13444c.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return C4002d.this.f13449h.onTouchEvent(motionEvent);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m16605i() {
        if (!this.f13451j) {
            return false;
        }
        this.f13444c.setOnTouchListener(null);
        this.f13451j = false;
        this.f13453l = 2;
        if (mo24770p() != null) {
            C3810m.m15803b(mo24770p());
        }
        this.f13444c.setVisibility(4);
        this.f13443b.mo22762d();
        this.f13444c.postDelayed(this.f13455n, 500);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public boolean m16613q() {
        if (!this.f13452k) {
            return false;
        }
        this.f13444c.setOnTouchListener(null);
        this.f13443b.mo22762d();
        this.f13444c.setOnTouchListener(null);
        this.f13452k = false;
        this.f13453l = 1;
        if (mo24770p() != null) {
            this.f13444c.animate().translationYBy((float) (-mo24770p().getResources().getDisplayMetrics().heightPixels)).setDuration(600).setListener(new AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                    C4002d.this.f13444c.setVisibility(8);
                    C4002d.this.f13444c.setVisibility(8);
                    C4002d.this.f13443b.mo22762d();
                }

                public void onAnimationEnd(Animator animator) {
                    C4002d.this.f13444c.setVisibility(8);
                    C4002d.this.f13444c.setVisibility(8);
                    C4002d.this.f13443b.mo22762d();
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            }).start();
            this.f13454m = true;
        }
        if (mo24770p() != null) {
            C3810m.m15806e(mo24770p());
            C3810m.m15801a(mo24770p(), false);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m16616r() {
        this.f13443b.mo22762d();
        this.f13444c.setVisibility(0);
        int g = C3809l.m15798g(mo24770p(), "ksad_detail_double_click_like_guide_anim");
        this.f13443b.setVisibility(0);
        this.f13443b.setAnimation(g);
        this.f13443b.setRepeatMode(1);
        this.f13443b.setRepeatCount(-1);
        this.f13443b.mo22759b();
        this.f13445d.setText(C3809l.m15796e(mo24770p(), "ksad_double_click_like_tips"));
        if (this.f13454m) {
            int i = this.f13444c.getContext().getResources().getDisplayMetrics().heightPixels;
            View view = this.f13444c;
            view.setTranslationY(view.getTranslationY() + ((float) i));
        }
    }

    /* renamed from: s */
    private void m16617s() {
        this.f13443b.mo22762d();
        int g = C3809l.m15798g(mo24770p(), "ksad_detail_guider_slider_up_guide");
        this.f13444c.setVisibility(0);
        this.f13443b.setVisibility(0);
        this.f13443b.setAnimation(g);
        this.f13443b.setRepeatMode(1);
        this.f13443b.setRepeatCount(-1);
        this.f13443b.mo22759b();
        this.f13445d.setText(C3809l.m15796e(mo24770p(), "ksad_slide_up_tips"));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* renamed from: a */
    public void mo23338a() {
        /*
        r3 = this;
        super.mo23338a()
        android.content.Context r0 = r3.mo24770p()
        if (r0 == 0) goto L_0x0063
        android.content.Context r0 = r3.mo24770p()
        boolean r0 = com.kwad.sdk.p306a.C3810m.m15802a(r0)
        r3.f13451j = r0
        android.content.Context r0 = r3.mo24770p()
        boolean r0 = com.kwad.sdk.p306a.C3810m.m15805d(r0)
        r3.f13452k = r0
        boolean r0 = r3.f13452k
        r1 = 0
        r2 = 1
        if (r0 == 0) goto L_0x002d
        r3.f13453l = r1
    L_0x0025:
        android.content.Context r0 = r3.mo24770p()
        com.kwad.sdk.p306a.C3810m.m15801a(r0, r2)
        goto L_0x003e
    L_0x002d:
        boolean r0 = r3.f13451j
        if (r0 == 0) goto L_0x0034
        r3.f13453l = r2
        goto L_0x0025
    L_0x0034:
        r0 = 2
        r3.f13453l = r0
        android.content.Context r0 = r3.mo24770p()
        com.kwad.sdk.p306a.C3810m.m15801a(r0, r1)
    L_0x003e:
        boolean r0 = r3.f13452k
        if (r0 == 0) goto L_0x004c
        r3.m16617s()
        r3.m16602h()
        r3.m16601g()
        goto L_0x0063
    L_0x004c:
        boolean r0 = r3.f13451j
        if (r0 == 0) goto L_0x0057
        r3.m16616r()
        r3.m16602h()
        goto L_0x0063
    L_0x0057:
        com.ksad.lottie.LottieAnimationView r0 = r3.f13443b
        r1 = 8
        r0.setVisibility(r1)
        android.view.View r0 = r3.f13444c
        r0.setVisibility(r1)
    L_0x0063:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.home.p315a.C4002d.mo23338a():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13444c = mo24760a("ksad_guider_mask");
        this.f13445d = (TextView) mo24760a("ksad_guider_title");
        this.f13443b = (LottieAnimationView) mo24760a("ksad_guider_animation");
        this.f13446e = (SlidePlayViewPager) mo24760a("ksad_slide_play_view_pager");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        if (mo24770p() != null && C3810m.m15804c(mo24770p())) {
            C3810m.m15801a(mo24770p(), true);
        }
        this.f13444c.animate().cancel();
        OnPageChangeListener onPageChangeListener = this.f13450i;
        if (onPageChangeListener != null) {
            this.f13446e.mo23267b(onPageChangeListener);
        }
        this.f13444c.setOnTouchListener(null);
        this.f13444c.setVisibility(8);
        if (this.f13443b.mo22761c()) {
            this.f13443b.mo22762d();
        }
        this.f13443b.setVisibility(8);
        this.f13444c.removeCallbacks(this.f13455n);
    }
}
