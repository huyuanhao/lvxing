package com.jiayouya.travel.module.p281tb.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.ViewEx;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004RSTUB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0014\u00100\u001a\u000601R\u00020\u00002\u0006\u00102\u001a\u00020\nH\u0002J\b\u00103\u001a\u00020-H\u0002J\u0010\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020-H\u0014J\b\u00107\u001a\u00020-H\u0014J\u0010\u00108\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0014J\u0018\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J(\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0014J\u001a\u0010A\u001a\u00020-2\b\u0010B\u001a\u0004\u0018\u00010\u00012\u0006\u0010C\u001a\u00020\u0007H\u0014J\u000e\u0010D\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020-2\u0006\u0010I\u001a\u00020\u0007J\u001a\u0010J\u001a\u00020-2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020\nJ\u0018\u0010M\u001a\u00020-2\u0006\u0010L\u001a\u00020\n2\b\b\u0002\u0010N\u001a\u00020\nJ \u0010O\u001a\u00020-2\u0006\u0010L\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010I\u001a\u00020QH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "angle", "", "animator", "Landroid/animation/ValueAnimator;", "arcHeight", "arcRectF", "Landroid/graphics/RectF;", "curProgress", "halfAh", "iProgress", "Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$IProgress;", "isAnimStarted", "", "isAutoPlay", "isDetached", "listener", "Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$OnCompleteListener;", "mDuration", "max", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "progressEndColor", "progressStartColor", "radius", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "runnable$delegate", "Lkotlin/Lazy;", "rx", "startAngle", "type", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "getDrawEnd", "Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$DrawStop;", "percent", "initPaint", "measure", "measureSpec", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onVisibilityChanged", "changedView", "visibility", "setAutoPlay", "setColor", "startColor", "endColor", "setDuration", "duration", "setListener", "setMax", "value", "setProgress", "lastValue", "toProgressValue", "beforeValue", "", "DrawStop", "IProgress", "OnCompleteListener", "Place", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CircleProgressBar.kt */
/* renamed from: com.jiayouya.travel.module.tb.widget.CircleProgressBar */
public final class CircleProgressBar extends View {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11858a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(CircleProgressBar.class), "runnable", "getRunnable()Ljava/lang/Runnable;"))};
    /* renamed from: b */
    private float f11859b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public float f11860c;
    /* renamed from: d */
    private int f11861d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public float f11862e;
    /* renamed from: f */
    private float f11863f;
    /* renamed from: g */
    private int f11864g;
    /* renamed from: h */
    private int f11865h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public float f11866i;
    /* renamed from: j */
    private float f11867j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean f11868k;
    /* renamed from: l */
    private RectF f11869l;
    /* renamed from: m */
    private final Paint f11870m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public C3314c f11871n;
    /* renamed from: o */
    private int f11872o;
    /* renamed from: p */
    private float f11873p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public C3313b f11874q;
    /* renamed from: r */
    private final float f11875r;
    /* renamed from: s */
    private final Path f11876s;
    /* renamed from: t */
    private final Lazy f11877t;
    /* renamed from: u */
    private ValueAnimator f11878u;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public boolean f11879v;
    /* access modifiers changed from: private */
    /* renamed from: w */
    public boolean f11880w;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$Place;", "", "(Ljava/lang/String;I)V", "TOP", "RIGHT", "BOTTOM", "LEFT", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: CircleProgressBar.kt */
    /* renamed from: com.jiayouya.travel.module.tb.widget.CircleProgressBar$Place */
    public enum Place {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$DrawStop;", "", "(Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar;)V", "location", "", "getLocation", "()F", "setLocation", "(F)V", "place", "Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$Place;", "getPlace", "()Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$Place;", "setPlace", "(Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$Place;)V", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: CircleProgressBar.kt */
    /* renamed from: com.jiayouya.travel.module.tb.widget.CircleProgressBar$a */
    private final class C3312a {
        /* renamed from: b */
        private Place f11882b;
        /* renamed from: c */
        private float f11883c;

        public C3312a() {
        }

        /* renamed from: a */
        public final Place mo21606a() {
            return this.f11882b;
        }

        /* renamed from: a */
        public final void mo21608a(Place place) {
            this.f11882b = place;
        }

        /* renamed from: a */
        public final void mo21607a(float f) {
            this.f11883c = f;
        }

        /* renamed from: b */
        public final float mo21609b() {
            return this.f11883c;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$IProgress;", "", "getProgress", "", "setProgress", "", "progress", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: CircleProgressBar.kt */
    /* renamed from: com.jiayouya.travel.module.tb.widget.CircleProgressBar$b */
    public interface C3313b {
        float getProgress();

        void setProgress(float f);
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$OnCompleteListener;", "", "onComplete", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: CircleProgressBar.kt */
    /* renamed from: com.jiayouya.travel.module.tb.widget.CircleProgressBar$c */
    public interface C3314c {
        /* renamed from: a */
        void mo21582a();
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CircleProgressBar.kt */
    /* renamed from: com.jiayouya.travel.module.tb.widget.CircleProgressBar$d */
    static final class C3315d implements Runnable {
        /* renamed from: a */
        final /* synthetic */ CircleProgressBar f11884a;

        C3315d(CircleProgressBar circleProgressBar) {
            this.f11884a = circleProgressBar;
        }

        public final void run() {
            if (ViewEx.m12844b(this.f11884a) && !this.f11884a.f11880w) {
                C3313b b = this.f11884a.f11874q;
                float progress = b != null ? b.getProgress() : 0.0f;
                CircleProgressBar circleProgressBar = this.f11884a;
                if (progress >= circleProgressBar.f11860c) {
                    progress = 0.0f;
                }
                circleProgressBar.mo21595a(100.0f, progress);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CircleProgressBar.kt */
    /* renamed from: com.jiayouya.travel.module.tb.widget.CircleProgressBar$e */
    static final class C3316e extends Lambda implements C8246a<Runnable> {
        final /* synthetic */ CircleProgressBar this$0;

        C3316e(CircleProgressBar circleProgressBar) {
            this.this$0 = circleProgressBar;
            super(0);
        }

        public final Runnable invoke() {
            return new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C3316e f11885a;

                {
                    this.f11885a = r1;
                }

                public final void run() {
                    if (!this.f11885a.this$0.f11879v && !this.f11885a.this$0.f11880w && this.f11885a.this$0.f11868k && ViewEx.m12844b(this.f11885a.this$0)) {
                        CircleProgressBar.m14393a(this.f11885a.this$0, 100.0f, 0.0f, 2, null);
                    }
                }
            };
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo39189d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/jiayouya/travel/module/tb/widget/CircleProgressBar$toProgressValue$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CircleProgressBar.kt */
    /* renamed from: com.jiayouya.travel.module.tb.widget.CircleProgressBar$f */
    static final class C3318f implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ CircleProgressBar f11886a;
        /* renamed from: b */
        final /* synthetic */ long f11887b;
        /* renamed from: c */
        final /* synthetic */ float f11888c;

        C3318f(CircleProgressBar circleProgressBar, long j, float f) {
            this.f11886a = circleProgressBar;
            this.f11887b = j;
            this.f11888c = f;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            C8271i.m35382a((Object) valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                this.f11886a.f11862e = floatValue;
                CircleProgressBar circleProgressBar = this.f11886a;
                circleProgressBar.f11866i = ((float) 360) * (floatValue / circleProgressBar.f11860c);
                C3313b b = this.f11886a.f11874q;
                if (b != null) {
                    b.setProgress(floatValue);
                }
                this.f11886a.postInvalidate();
                if (floatValue == this.f11888c) {
                    this.f11886a.f11880w = false;
                    C3314c d = this.f11886a.f11871n;
                    if (d != null) {
                        d.mo21582a();
                    }
                    Handler handler = this.f11886a.getHandler();
                    if (handler != null) {
                        handler.postDelayed(this.f11886a.getRunnable(), 310);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public CircleProgressBar(Context context) {
        this(context, null, 0, 6, null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* access modifiers changed from: private|final */
    public final Runnable getRunnable() {
        Lazy bVar = this.f11877t;
        C8280j jVar = f11858a[0];
        return (Runnable) bVar.getValue();
    }

    public /* synthetic */ CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        C8271i.m35386b(context, "context");
        super(context, attributeSet, i);
        this.f11860c = 100.0f;
        this.f11861d = 1000;
        this.f11864g = ContextCompat.getColor(context, R.color.green_start);
        this.f11865h = ContextCompat.getColor(context, R.color.green_end);
        this.f11868k = true;
        this.f11869l = new RectF();
        this.f11870m = new Paint();
        this.f11873p = (float) ezy.p642a.Context.m34741a(context, 7.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar);
        this.f11864g = obtainStyledAttributes.getColor(6, this.f11864g);
        this.f11865h = obtainStyledAttributes.getColor(5, this.f11865h);
        this.f11860c = obtainStyledAttributes.getFloat(3, this.f11860c);
        this.f11861d = obtainStyledAttributes.getInteger(1, 1000);
        this.f11862e = obtainStyledAttributes.getFloat(4, this.f11862e);
        this.f11863f = obtainStyledAttributes.getDimension(0, this.f11863f);
        this.f11868k = obtainStyledAttributes.getBoolean(2, this.f11868k);
        this.f11872o = obtainStyledAttributes.getInteger(7, 0);
        obtainStyledAttributes.recycle();
        this.f11875r = this.f11863f / ((float) 2);
        this.f11876s = new Path();
        this.f11877t = C8182c.m35317a(new C3316e(this));
    }

    /* access modifiers changed from: protected|declared_synchronized */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(m14387a(i), m14387a(i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11859b = ((float) Math.min(i, i2)) / 2.0f;
        RectF rectF = this.f11869l;
        float f = this.f11863f;
        float f2 = (float) 2;
        float f3 = f / f2;
        float f4 = f / f2;
        float f5 = this.f11859b;
        rectF.set(f3, f4, (f5 * f2) - (f / f2), (f5 * f2) - (f / f2));
        this.f11867j = ((this.f11863f / f2) / (this.f11859b * 6.28f)) * ((float) 360);
        m14389a();
    }

    /* renamed from: a */
    private final int m14387a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        return mode == 1073741824 ? size : Math.min(0, size);
    }

    /* renamed from: a */
    private final void m14389a() {
        Paint paint = this.f11870m;
        paint.setAntiAlias(true);
        paint.setStrokeCap(Cap.ROUND);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.f11863f);
        int i = this.f11872o;
        if (i == 0) {
            float f = this.f11859b;
            paint.setShader(new SweepGradient(f, f, new int[]{this.f11864g, this.f11865h}, null));
        } else if (i == 1) {
            paint.setColor(this.f11864g);
            paint.setPathEffect(new CornerPathEffect(this.f11873p));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C8271i.m35386b(canvas, "canvas");
        super.onDraw(canvas);
        int i = this.f11872o;
        if (i == 0) {
            float f = this.f11859b;
            canvas.rotate(-90.0f, f, f);
            canvas.drawArc(this.f11869l, this.f11867j, this.f11866i, false, this.f11870m);
        } else if (i == 1) {
            m14391a(canvas);
        }
    }

    /* renamed from: a */
    private final void m14391a(Canvas canvas) {
        this.f11876s.reset();
        C3312a a = m14388a(((((float) ((getWidth() * 2) + (getHeight() * 2))) - (((float) 4) * this.f11863f)) / this.f11860c) * this.f11862e);
        Place a2 = a.mo21606a();
        if (a2 != null) {
            int i = C3321a.f11895a[a2.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.f11876s.moveTo(((float) getWidth()) / 2.0f, this.f11875r);
                    Path path = this.f11876s;
                    float width = (float) getWidth();
                    float f = this.f11875r;
                    path.lineTo(width - f, f);
                    this.f11876s.lineTo(((float) getWidth()) - this.f11875r, a.mo21609b());
                } else if (i == 3) {
                    this.f11876s.moveTo(((float) getWidth()) / 2.0f, this.f11875r);
                    Path path2 = this.f11876s;
                    float width2 = (float) getWidth();
                    float f2 = this.f11875r;
                    path2.lineTo(width2 - f2, f2);
                    this.f11876s.lineTo(((float) getWidth()) - this.f11875r, ((float) getHeight()) - this.f11875r);
                    this.f11876s.lineTo(a.mo21609b(), ((float) getHeight()) - this.f11875r);
                } else if (i == 4) {
                    this.f11876s.moveTo(((float) getWidth()) / 2.0f, this.f11875r);
                    Path path3 = this.f11876s;
                    float width3 = (float) getWidth();
                    float f3 = this.f11875r;
                    path3.lineTo(width3 - f3, f3);
                    this.f11876s.lineTo(((float) getWidth()) - this.f11875r, ((float) getHeight()) - this.f11875r);
                    this.f11876s.lineTo(this.f11875r, ((float) getHeight()) - this.f11875r);
                    this.f11876s.lineTo(this.f11875r, a.mo21609b());
                }
            } else if (a.mo21609b() <= ((float) getWidth()) / 2.0f || this.f11862e == this.f11860c) {
                this.f11876s.moveTo(((float) getWidth()) / 2.0f, this.f11875r);
                Path path4 = this.f11876s;
                float width4 = (float) getWidth();
                float f4 = this.f11875r;
                path4.lineTo(width4 - f4, f4);
                this.f11876s.lineTo(((float) getWidth()) - this.f11875r, ((float) getHeight()) - this.f11875r);
                this.f11876s.lineTo(this.f11875r, ((float) getHeight()) - this.f11875r);
                Path path5 = this.f11876s;
                float f5 = this.f11875r;
                path5.lineTo(f5, f5);
                this.f11876s.lineTo(a.mo21609b(), this.f11875r);
            } else {
                this.f11876s.moveTo(((float) getWidth()) / 2.0f, this.f11875r);
                this.f11876s.lineTo(a.mo21609b(), this.f11875r);
            }
        }
        canvas.drawPath(this.f11876s, this.f11870m);
    }

    /* renamed from: a */
    private final C3312a m14388a(float f) {
        C3312a aVar = new C3312a();
        float width = ((float) getWidth()) / 2.0f;
        if (f > width) {
            float f2 = f - width;
            if (f2 > ((float) getHeight()) - this.f11863f) {
                float height = f2 - (((float) getHeight()) - this.f11863f);
                if (height > ((float) getWidth()) - this.f11863f) {
                    float width2 = height - (((float) getWidth()) - this.f11863f);
                    if (width2 > ((float) getHeight()) - this.f11863f) {
                        float height2 = width2 - (((float) getHeight()) - this.f11863f);
                        aVar.mo21608a(Place.TOP);
                        aVar.mo21607a(this.f11863f + height2);
                    } else {
                        aVar.mo21608a(Place.LEFT);
                        aVar.mo21607a((((float) getHeight()) - this.f11863f) - width2);
                    }
                } else {
                    aVar.mo21608a(Place.BOTTOM);
                    aVar.mo21607a((((float) getWidth()) - this.f11863f) - height);
                }
            } else {
                aVar.mo21608a(Place.RIGHT);
                aVar.mo21607a(this.f11863f + f2);
            }
        } else {
            aVar.mo21608a(Place.TOP);
            aVar.mo21607a(width + f);
        }
        return aVar;
    }

    /* renamed from: a */
    public static /* synthetic */ void m14393a(CircleProgressBar circleProgressBar, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        circleProgressBar.mo21595a(f, f2);
    }

    /* renamed from: a */
    public final void mo21595a(float f, float f2) {
        float f3 = this.f11860c;
        if (f >= f2 && f <= f3) {
            m14390a(f, f2, (long) (f2 == 0.0f ? (float) this.f11861d : ((f - f2) / f) * ((float) this.f11861d)));
        }
    }

    public final void setDuration(int i) {
        this.f11861d = i;
    }

    public final void setMax(float f) {
        this.f11860c = f;
    }

    /* renamed from: a */
    public final void mo21596a(C3314c cVar, C3313b bVar) {
        C8271i.m35386b(cVar, "listener");
        this.f11874q = bVar;
        this.f11871n = cVar;
    }

    public final void setAutoPlay(boolean z) {
        this.f11868k = z;
        if (!z) {
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(getRunnable());
            }
        }
    }

    /* renamed from: a */
    private final void m14390a(float f, float f2, long j) {
        ValueAnimator valueAnimator = this.f11878u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f11878u = ValueAnimator.ofFloat(new float[]{f2, f});
        ValueAnimator valueAnimator2 = this.f11878u;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(j);
            valueAnimator2.setInterpolator(new LinearInterpolator());
            valueAnimator2.addUpdateListener(new C3318f(this, j, f));
            this.f11880w = true;
            valueAnimator2.start();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11879v = false;
        if (!this.f11880w && this.f11868k) {
            C3313b bVar = this.f11874q;
            float progress = bVar != null ? bVar.getProgress() : 0.0f;
            if (progress >= this.f11860c) {
                progress = 0.0f;
            }
            mo21595a(100.0f, progress);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11879v = true;
        this.f11880w = false;
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(getRunnable());
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        postDelayed(new C3315d(this), 200);
    }
}
