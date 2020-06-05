package com.qiyukf.unicorn.widget.pulltorefresh;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiyukf.unicorn.C5961R;
import java.util.Timer;
import java.util.TimerTask;

public class PullToRefreshLayout extends FrameLayout {
    /* access modifiers changed from: private */
    /* renamed from: A */
    public Runnable f19870A;
    /* access modifiers changed from: private */
    /* renamed from: a */
    public int f19871a;
    /* renamed from: b */
    private C6374a f19872b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public float f19873c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public float f19874d;
    /* renamed from: e */
    private float f19875e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public float f19876f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public float f19877g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C6375b f19878h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public Handler f19879i;
    /* renamed from: j */
    private boolean f19880j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean f19881k;
    /* renamed from: l */
    private float f19882l;
    /* renamed from: m */
    private RotateAnimation f19883m;
    /* renamed from: n */
    private RotateAnimation f19884n;
    /* renamed from: o */
    private View f19885o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public ImageView f19886p;
    /* renamed from: q */
    private ProgressBar f19887q;
    /* renamed from: r */
    private TextView f19888r;
    /* renamed from: s */
    private View f19889s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public ImageView f19890t;
    /* renamed from: u */
    private ProgressBar f19891u;
    /* renamed from: v */
    private TextView f19892v;
    /* access modifiers changed from: private */
    /* renamed from: w */
    public View f19893w;
    /* renamed from: x */
    private int f19894x;
    /* renamed from: y */
    private boolean f19895y;
    /* renamed from: z */
    private boolean f19896z;

    /* renamed from: com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout$a */
    public interface C6374a {
        /* renamed from: d */
        void mo29453d();
    }

    /* renamed from: com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout$b */
    private class C6375b {
        /* renamed from: b */
        private Timer f19901b = new Timer();
        /* renamed from: c */
        private C6376a f19902c;
        /* renamed from: d */
        private boolean f19903d = false;

        /* renamed from: com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout$b$a */
        private class C6376a extends TimerTask {
            private C6376a() {
            }

            /* synthetic */ C6376a(C6375b bVar, byte b) {
                this();
            }

            public final void run() {
                PullToRefreshLayout.this.f19879i.post(PullToRefreshLayout.this.f19870A);
            }
        }

        public C6375b() {
        }

        /* renamed from: a */
        public final void mo29617a() {
            if (!this.f19903d) {
                C6376a aVar = this.f19902c;
                if (aVar != null) {
                    aVar.cancel();
                    this.f19902c = null;
                }
                this.f19902c = new C6376a(this, 0);
                this.f19901b.schedule(this.f19902c, 0, 5);
            }
        }

        /* renamed from: b */
        public final void mo29618b() {
            C6376a aVar = this.f19902c;
            if (aVar != null) {
                aVar.cancel();
                this.f19902c = null;
            }
        }

        /* renamed from: c */
        public final void mo29619c() {
            this.f19903d = true;
            mo29618b();
            this.f19901b.cancel();
        }
    }

    public PullToRefreshLayout(Context context) {
        this(context, null);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19871a = 0;
        this.f19873c = 0.0f;
        this.f19874d = 0.0f;
        this.f19876f = 200.0f;
        this.f19877g = 200.0f;
        this.f19878h = new C6375b();
        this.f19879i = new Handler();
        this.f19880j = false;
        this.f19881k = false;
        this.f19882l = 2.0f;
        this.f19895y = true;
        this.f19896z = true;
        this.f19870A = new Runnable() {
            public final void run() {
                float tan = (float) ((Math.tan((1.5707963267948966d / ((double) PullToRefreshLayout.this.getMeasuredHeight())) * ((double) (PullToRefreshLayout.this.f19873c + Math.abs(PullToRefreshLayout.this.f19874d)))) * 5.0d) + 8.0d);
                if (!PullToRefreshLayout.this.f19881k) {
                    if (PullToRefreshLayout.this.f19871a == 2 && PullToRefreshLayout.this.f19873c <= PullToRefreshLayout.this.f19876f) {
                        PullToRefreshLayout pullToRefreshLayout = PullToRefreshLayout.this;
                        pullToRefreshLayout.f19873c = pullToRefreshLayout.f19876f;
                    } else if (PullToRefreshLayout.this.f19871a == 4 && (-PullToRefreshLayout.this.f19874d) <= PullToRefreshLayout.this.f19877g) {
                        PullToRefreshLayout pullToRefreshLayout2 = PullToRefreshLayout.this;
                        pullToRefreshLayout2.f19874d = -pullToRefreshLayout2.f19877g;
                    }
                    PullToRefreshLayout.this.f19878h.mo29618b();
                }
                if (PullToRefreshLayout.this.f19873c > 0.0f) {
                    PullToRefreshLayout pullToRefreshLayout3 = PullToRefreshLayout.this;
                    pullToRefreshLayout3.f19873c = pullToRefreshLayout3.f19873c - tan;
                } else if (PullToRefreshLayout.this.f19874d < 0.0f) {
                    PullToRefreshLayout pullToRefreshLayout4 = PullToRefreshLayout.this;
                    pullToRefreshLayout4.f19874d = pullToRefreshLayout4.f19874d + tan;
                }
                if (PullToRefreshLayout.this.f19873c < 0.0f) {
                    PullToRefreshLayout.this.f19873c = 0.0f;
                    PullToRefreshLayout.this.f19886p.clearAnimation();
                    if (!(PullToRefreshLayout.this.f19871a == 2 || PullToRefreshLayout.this.f19871a == 4)) {
                        PullToRefreshLayout.this.m25030b(0);
                    }
                    PullToRefreshLayout.this.f19878h.mo29618b();
                    PullToRefreshLayout.this.requestLayout();
                }
                if (PullToRefreshLayout.this.f19874d > 0.0f) {
                    PullToRefreshLayout.this.f19874d = 0.0f;
                    PullToRefreshLayout.this.f19890t.clearAnimation();
                    if (!(PullToRefreshLayout.this.f19871a == 2 || PullToRefreshLayout.this.f19871a == 4)) {
                        PullToRefreshLayout.this.m25030b(0);
                    }
                    PullToRefreshLayout.this.f19878h.mo29618b();
                    PullToRefreshLayout.this.requestLayout();
                }
                PullToRefreshLayout.this.requestLayout();
                if (PullToRefreshLayout.this.f19873c + Math.abs(PullToRefreshLayout.this.f19874d) == 0.0f) {
                    PullToRefreshLayout.this.f19878h.mo29618b();
                }
            }
        };
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.f19883m = rotateAnimation;
        this.f19883m.setInterpolator(new LinearInterpolator());
        this.f19883m.setFillAfter(true);
        this.f19883m.setDuration(100);
        RotateAnimation rotateAnimation2 = new RotateAnimation(180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f19884n = rotateAnimation2;
        this.f19884n.setInterpolator(new LinearInterpolator());
        this.f19884n.setFillAfter(true);
        this.f19884n.setDuration(100);
    }

    /* renamed from: a */
    private void m25024a() {
        this.f19895y = true;
        this.f19896z = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25029b() {
        C6375b bVar = this.f19878h;
        if (bVar != null) {
            bVar.mo29617a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25030b(int i) {
        TextView textView;
        int i2;
        this.f19871a = i;
        int i3 = this.f19871a;
        if (i3 == 0) {
            if (this.f19886p.getAnimation() != null) {
                this.f19886p.startAnimation(this.f19884n);
            }
            this.f19886p.setVisibility(0);
            this.f19888r.setText(C5961R.string.ysf_ptr_pull_to_refresh);
            if (this.f19890t.getAnimation() != null) {
                this.f19890t.startAnimation(this.f19884n);
            }
            this.f19890t.setVisibility(0);
            textView = this.f19892v;
            i2 = C5961R.string.ysf_ptr_pull_to_load;
        } else if (i3 == 1) {
            this.f19886p.startAnimation(this.f19883m);
            textView = this.f19888r;
            i2 = C5961R.string.ysf_ptr_release_to_refresh;
        } else if (i3 == 2) {
            this.f19886p.clearAnimation();
            this.f19886p.setVisibility(4);
            this.f19887q.setVisibility(0);
            textView = this.f19888r;
            i2 = C5961R.string.ysf_ptr_refreshing;
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.f19890t.clearAnimation();
                this.f19890t.setVisibility(4);
                this.f19891u.setVisibility(0);
                this.f19892v.setText(C5961R.string.ysf_ptr_loading);
            }
            return;
        } else {
            this.f19890t.startAnimation(this.f19883m);
            textView = this.f19892v;
            i2 = C5961R.string.ysf_ptr_release_to_load;
        }
        textView.setText(i2);
    }

    /* renamed from: a */
    public final void mo29608a(int i) {
        this.f19891u.setVisibility(4);
        TextView textView = this.f19892v;
        int i2 = i != 0 ? i != 2 ? C5961R.string.ysf_ptr_load_failed : C5961R.string.ysf_ptr_load_completed : C5961R.string.ysf_ptr_load_succeed;
        textView.setText(i2);
        if (this.f19874d >= 0.0f || !(i == 1 || i == 2)) {
            m25030b(5);
            post(new Runnable() {
                public final void run() {
                    ((C6377a) PullToRefreshLayout.this.f19893w).mo29621a((int) (-PullToRefreshLayout.this.f19874d));
                    PullToRefreshLayout.this.f19874d = 0.0f;
                    PullToRefreshLayout.this.requestLayout();
                }
            });
            return;
        }
        postDelayed(new Runnable() {
            public final void run() {
                PullToRefreshLayout.this.m25030b(5);
                PullToRefreshLayout.this.m25029b();
            }
        }, 1000);
    }

    /* renamed from: a */
    public final void mo29609a(C6374a aVar) {
        this.f19872b = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0088, code lost:
            if (r12.f19871a == 4) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ba, code lost:
            if (r12.f19871a == 2) goto L_0x00bc;
     */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
        r12 = this;
        int r0 = r13.getActionMasked()
        r1 = 0
        if (r0 == 0) goto L_0x0184
        r2 = 4
        r3 = 3
        r4 = 2
        r5 = 1
        if (r0 == r5) goto L_0x0157
        r6 = 5
        if (r0 == r4) goto L_0x001c
        if (r0 == r6) goto L_0x0017
        r1 = 6
        if (r0 == r1) goto L_0x0017
        goto L_0x0194
    L_0x0017:
        r0 = -1
        r12.f19894x = r0
        goto L_0x0194
    L_0x001c:
        int r0 = r12.f19894x
        r7 = 0
        if (r0 != 0) goto L_0x00bf
        float r0 = r12.f19873c
        int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
        if (r0 > 0) goto L_0x008b
        android.view.View r0 = r12.f19893w
        com.qiyukf.unicorn.widget.pulltorefresh.a r0 = (com.qiyukf.unicorn.widget.pulltorefresh.C6377a) r0
        boolean r0 = r0.mo29623a()
        if (r0 == 0) goto L_0x003a
        boolean r0 = r12.f19895y
        if (r0 == 0) goto L_0x003a
        int r0 = r12.f19871a
        if (r0 == r2) goto L_0x003a
        goto L_0x008b
    L_0x003a:
        float r0 = r12.f19874d
        int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
        if (r0 < 0) goto L_0x0057
        android.view.View r0 = r12.f19893w
        com.qiyukf.unicorn.widget.pulltorefresh.a r0 = (com.qiyukf.unicorn.widget.pulltorefresh.C6377a) r0
        boolean r0 = r0.mo29624b()
        if (r0 == 0) goto L_0x0053
        boolean r0 = r12.f19896z
        if (r0 == 0) goto L_0x0053
        int r0 = r12.f19871a
        if (r0 == r4) goto L_0x0053
        goto L_0x0057
    L_0x0053:
        r12.m25024a()
        goto L_0x00c1
    L_0x0057:
        float r0 = r12.f19874d
        float r4 = r13.getY()
        float r8 = r12.f19875e
        float r4 = r4 - r8
        float r8 = r12.f19882l
        float r4 = r4 / r8
        float r0 = r0 + r4
        r12.f19874d = r0
        float r0 = r12.f19874d
        int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
        if (r0 <= 0) goto L_0x0072
        r12.f19874d = r7
        r12.f19895y = r5
        r12.f19896z = r1
    L_0x0072:
        float r0 = r12.f19874d
        int r4 = r12.getMeasuredHeight()
        int r4 = -r4
        float r4 = (float) r4
        int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
        if (r0 >= 0) goto L_0x0086
        int r0 = r12.getMeasuredHeight()
        int r0 = -r0
        float r0 = (float) r0
        r12.f19874d = r0
    L_0x0086:
        int r0 = r12.f19871a
        if (r0 != r2) goto L_0x00c1
        goto L_0x00bc
    L_0x008b:
        float r0 = r12.f19873c
        float r2 = r13.getY()
        float r8 = r12.f19875e
        float r2 = r2 - r8
        float r8 = r12.f19882l
        float r2 = r2 / r8
        float r0 = r0 + r2
        r12.f19873c = r0
        float r0 = r12.f19873c
        int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
        if (r0 >= 0) goto L_0x00a6
        r12.f19873c = r7
        r12.f19895y = r1
        r12.f19896z = r5
    L_0x00a6:
        float r0 = r12.f19873c
        int r2 = r12.getMeasuredHeight()
        float r2 = (float) r2
        int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r0 <= 0) goto L_0x00b8
        int r0 = r12.getMeasuredHeight()
        float r0 = (float) r0
        r12.f19873c = r0
    L_0x00b8:
        int r0 = r12.f19871a
        if (r0 != r4) goto L_0x00c1
    L_0x00bc:
        r12.f19881k = r5
        goto L_0x00c1
    L_0x00bf:
        r12.f19894x = r1
    L_0x00c1:
        float r0 = r13.getY()
        r12.f19875e = r0
        r8 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
        int r0 = r12.getMeasuredHeight()
        double r10 = (double) r0
        double r8 = r8 / r10
        float r0 = r12.f19873c
        float r2 = r12.f19874d
        float r2 = java.lang.Math.abs(r2)
        float r0 = r0 + r2
        double r10 = (double) r0
        double r8 = r8 * r10
        double r8 = java.lang.Math.tan(r8)
        r10 = 4611686018427387904(0x4000000000000000, double:2.0)
        double r8 = r8 * r10
        double r8 = r8 + r10
        float r0 = (float) r8
        r12.f19882l = r0
        float r0 = r12.f19873c
        int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
        if (r0 > 0) goto L_0x00f6
        float r0 = r12.f19874d
        int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
        if (r0 >= 0) goto L_0x00f9
    L_0x00f6:
        r12.requestLayout()
    L_0x00f9:
        float r0 = r12.f19873c
        int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
        if (r2 <= 0) goto L_0x011e
        float r2 = r12.f19876f
        int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r0 > 0) goto L_0x010e
        int r0 = r12.f19871a
        if (r0 == r5) goto L_0x010b
        if (r0 != r6) goto L_0x010e
    L_0x010b:
        r12.m25030b(r1)
    L_0x010e:
        float r0 = r12.f19873c
        float r1 = r12.f19876f
        int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
        if (r0 < 0) goto L_0x0144
        int r0 = r12.f19871a
        if (r0 != 0) goto L_0x0144
        r12.m25030b(r5)
        goto L_0x0144
    L_0x011e:
        float r0 = r12.f19874d
        int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
        if (r2 >= 0) goto L_0x0144
        float r0 = -r0
        float r2 = r12.f19877g
        int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r0 > 0) goto L_0x0134
        int r0 = r12.f19871a
        if (r0 == r3) goto L_0x0131
        if (r0 != r6) goto L_0x0134
    L_0x0131:
        r12.m25030b(r1)
    L_0x0134:
        float r0 = r12.f19874d
        float r0 = -r0
        float r1 = r12.f19877g
        int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
        if (r0 < 0) goto L_0x0144
        int r0 = r12.f19871a
        if (r0 != 0) goto L_0x0144
        r12.m25030b(r3)
    L_0x0144:
        float r0 = r12.f19873c
        float r1 = r12.f19874d
        float r1 = java.lang.Math.abs(r1)
        float r0 = r0 + r1
        r1 = 1090519040(0x41000000, float:8.0)
        int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
        if (r0 <= 0) goto L_0x0194
        r13.setAction(r3)
        goto L_0x0194
    L_0x0157:
        float r0 = r12.f19873c
        float r6 = r12.f19876f
        int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
        if (r0 > 0) goto L_0x0168
        float r0 = r12.f19874d
        float r0 = -r0
        float r6 = r12.f19877g
        int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
        if (r0 <= 0) goto L_0x016a
    L_0x0168:
        r12.f19881k = r1
    L_0x016a:
        int r0 = r12.f19871a
        if (r0 != r5) goto L_0x0174
        r12.m25030b(r4)
        com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout$a r0 = r12.f19872b
        goto L_0x0180
    L_0x0174:
        if (r0 != r3) goto L_0x0180
        r12.m25030b(r2)
        com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout$a r0 = r12.f19872b
        if (r0 == 0) goto L_0x0180
        r0.mo29453d()
    L_0x0180:
        r12.m25029b()
        goto L_0x0194
    L_0x0184:
        float r0 = r13.getY()
        r12.f19875e = r0
        com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout$b r0 = r12.f19878h
        r0.mo29618b()
        r12.f19894x = r1
        r12.m25024a()
    L_0x0194:
        boolean r13 = super.dispatchTouchEvent(r13)
        return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f19885o = LayoutInflater.from(getContext()).inflate(C5961R.C5964layout.ysf_ptr_header, this, false);
        this.f19889s = LayoutInflater.from(getContext()).inflate(C5961R.C5964layout.ysf_ptr_footer, this, false);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        addView(this.f19885o, 0, layoutParams);
        addView(this.f19889s, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f19878h.mo29619c();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.f19880j) {
            this.f19885o = getChildAt(0);
            this.f19893w = getChildAt(1);
            this.f19889s = getChildAt(2);
            this.f19880j = true;
            this.f19886p = (ImageView) this.f19885o.findViewById(C5961R.C5963id.ysf_ptr_header_pull_icon);
            this.f19887q = (ProgressBar) this.f19885o.findViewById(C5961R.C5963id.ysf_ptr_header_refreshing_icon);
            this.f19888r = (TextView) this.f19885o.findViewById(C5961R.C5963id.ysf_ptr_header_state_hint);
            this.f19890t = (ImageView) this.f19889s.findViewById(C5961R.C5963id.ysf_ptr_footer_pull_icon);
            this.f19891u = (ProgressBar) this.f19889s.findViewById(C5961R.C5963id.ysf_ptr_footer_loading_icon);
            this.f19892v = (TextView) this.f19889s.findViewById(C5961R.C5963id.ysf_ptr_footer_state_hint);
            this.f19876f = (float) ((ViewGroup) this.f19885o).getChildAt(0).getMeasuredHeight();
            this.f19877g = (float) ((ViewGroup) this.f19889s).getChildAt(0).getMeasuredHeight();
        }
        View view = this.f19885o;
        view.layout(0, ((int) (this.f19873c + this.f19874d)) - view.getMeasuredHeight(), this.f19885o.getMeasuredWidth(), (int) (this.f19873c + this.f19874d));
        View view2 = this.f19893w;
        view2.layout(0, (int) (this.f19873c + this.f19874d), view2.getMeasuredWidth(), ((int) (this.f19873c + this.f19874d)) + this.f19893w.getMeasuredHeight());
        this.f19889s.layout(0, ((int) (this.f19873c + this.f19874d)) + this.f19893w.getMeasuredHeight(), this.f19889s.getMeasuredWidth(), ((int) (this.f19873c + this.f19874d)) + this.f19893w.getMeasuredHeight() + this.f19889s.getMeasuredHeight());
    }
}
