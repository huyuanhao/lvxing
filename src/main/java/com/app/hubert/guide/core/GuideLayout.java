package com.app.hubert.guide.core;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.app.hubert.guide.model.HighLight.Shape;
import com.app.hubert.guide.model.HighlightOptions;
import com.app.hubert.guide.model.RelativeGuide;
import com.app.hubert.guide.p127a.AnimationListenerAdapter;
import com.app.hubert.guide.p127a.OnLayoutInflatedListener;
import java.util.List;

public class GuideLayout extends FrameLayout {
    /* renamed from: a */
    public GuidePage f4025a;
    /* renamed from: b */
    private Controller f4026b;
    /* renamed from: c */
    private Paint f4027c;
    /* renamed from: d */
    private C1586a f4028d;
    /* renamed from: e */
    private float f4029e;
    /* renamed from: f */
    private float f4030f;
    /* renamed from: g */
    private int f4031g;

    /* renamed from: com.app.hubert.guide.core.GuideLayout$4 */
    static /* synthetic */ class C15854 {
        /* renamed from: a */
        static final /* synthetic */ int[] f4035a = new int[Shape.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            com.app.hubert.guide.model.HighLight$Shape[] r0 = com.app.hubert.guide.model.HighLight.Shape.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f4035a = r0
            int[] r0 = f4035a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.app.hubert.guide.model.HighLight$Shape r1 = com.app.hubert.guide.model.HighLight.Shape.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f4035a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.app.hubert.guide.model.HighLight$Shape r1 = com.app.hubert.guide.model.HighLight.Shape.OVAL     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f4035a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.app.hubert.guide.model.HighLight$Shape r1 = com.app.hubert.guide.model.HighLight.Shape.ROUND_RECTANGLE     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f4035a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.app.hubert.guide.model.HighLight$Shape r1 = com.app.hubert.guide.model.HighLight.Shape.RECTANGLE     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.app.hubert.guide.core.GuideLayout.C15854.m42220clinit():void");
        }
    }

    /* renamed from: com.app.hubert.guide.core.GuideLayout$a */
    public interface C1586a {
        /* renamed from: a */
        void mo12297a(GuideLayout guideLayout);
    }

    public GuideLayout(Context context, GuidePage aVar, Controller bVar) {
        super(context);
        m4787b();
        setGuidePage(aVar);
        this.f4026b = bVar;
    }

    /* renamed from: b */
    private void m4787b() {
        this.f4027c = new Paint();
        this.f4027c.setAntiAlias(true);
        this.f4027c.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f4027c.setMaskFilter(new BlurMaskFilter(10.0f, Blur.INNER));
        setLayerType(1, null);
        setWillNotDraw(false);
        this.f4031g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void setGuidePage(GuidePage aVar) {
        this.f4025a = aVar;
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (GuideLayout.this.f4025a.mo12325b()) {
                    GuideLayout.this.mo12289a();
                }
            }
        });
    }

    public boolean performClick() {
        return super.performClick();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4029e = motionEvent.getX();
            this.f4030f = motionEvent.getY();
        } else if (action == 1 || (action != 2 && action == 3)) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (Math.abs(x - this.f4029e) < ((float) this.f4031g) && Math.abs(y - this.f4030f) < ((float) this.f4031g)) {
                for (HighLight highLight : this.f4025a.mo12326c()) {
                    if (highLight.mo12316a((ViewGroup) getParent()).contains(x, y)) {
                        m4785a(highLight);
                        return true;
                    }
                }
                performClick();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m4785a(HighLight highLight) {
        HighlightOptions d = highLight.mo12320d();
        if (d != null && d.f4075a != null) {
            d.f4075a.onClick(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d = this.f4025a.mo12327d();
        if (d == 0) {
            d = -1308622848;
        }
        canvas.drawColor(d);
        m4782a(canvas);
    }

    /* renamed from: a */
    private void m4782a(Canvas canvas) {
        List<HighLight> c = this.f4025a.mo12326c();
        if (c != null) {
            for (HighLight highLight : c) {
                RectF a = highLight.mo12316a((ViewGroup) getParent());
                int i = C15854.f4035a[highLight.mo12317a().ordinal()];
                if (i == 1) {
                    canvas.drawCircle(a.centerX(), a.centerY(), highLight.mo12318b(), this.f4027c);
                } else if (i == 2) {
                    canvas.drawOval(a, this.f4027c);
                } else if (i != 3) {
                    canvas.drawRect(a, this.f4027c);
                } else {
                    canvas.drawRoundRect(a, (float) highLight.mo12319c(), (float) highLight.mo12319c(), this.f4027c);
                }
                m4783a(canvas, highLight, a);
            }
        }
    }

    /* renamed from: a */
    private void m4783a(Canvas canvas, HighLight highLight, RectF rectF) {
        HighlightOptions d = highLight.mo12320d();
        if (d != null && d.f4077c != null) {
            d.f4077c.mo12286a(canvas, rectF);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m4786a(this.f4025a);
        Animation h = this.f4025a.mo12331h();
        if (h != null) {
            startAnimation(h);
        }
    }

    /* renamed from: a */
    private void m4786a(GuidePage aVar) {
        removeAllViews();
        int e = aVar.mo12328e();
        if (e != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(e, this, false);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            int[] f = aVar.mo12329f();
            if (f != null && f.length > 0) {
                for (int i : f) {
                    View findViewById = inflate.findViewById(i);
                    if (findViewById != null) {
                        findViewById.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                GuideLayout.this.mo12289a();
                            }
                        });
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("can't find the view by id : ");
                        sb.append(i);
                        sb.append(" which used to remove guide page");
                        Log.w("NewbieGuide", sb.toString());
                    }
                }
            }
            OnLayoutInflatedListener g = aVar.mo12330g();
            if (g != null) {
                g.mo12287a(inflate, this.f4026b);
            }
            addView(inflate, layoutParams);
        }
        List<RelativeGuide> j = aVar.mo12333j();
        if (j.size() > 0) {
            for (RelativeGuide a : j) {
                addView(a.mo12337a((ViewGroup) getParent()));
            }
        }
    }

    public void setOnGuideLayoutDismissListener(C1586a aVar) {
        this.f4028d = aVar;
    }

    /* renamed from: a */
    public void mo12289a() {
        Animation i = this.f4025a.mo12332i();
        if (i != null) {
            i.setAnimationListener(new AnimationListenerAdapter() {
                public void onAnimationEnd(Animation animation) {
                    GuideLayout.this.m4788c();
                }
            });
            startAnimation(i);
            return;
        }
        m4788c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4788c() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
            C1586a aVar = this.f4028d;
            if (aVar != null) {
                aVar.mo12297a(this);
            }
        }
    }
}
