package com.jiayouya.travel.module.travel.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.module.travel.data.LuckPoolItem;
import com.jiayouya.travel.module.travel.data.LuckPoolItemKt;
import com.p522qq.p523e.comm.constants.Constants;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.List;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J(\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.H\u0014J\u0018\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0016H\u0014J\u0006\u0010:\u001a\u00020\u0010J\u0014\u0010;\u001a\u00020\u00102\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=J\u000e\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b)\u0010*¨\u0006@"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/widget/LuckDrawView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animator", "Landroid/animation/ObjectAnimator;", "center", "", "list", "", "Lcom/jiayouya/travel/module/travel/data/LuckPoolItem;", "onEndListener", "Lkotlin/Function0;", "", "getOnEndListener", "()Lkotlin/jvm/functions/Function0;", "setOnEndListener", "(Lkotlin/jvm/functions/Function0;)V", "radius", "", "sectorRectF", "Landroid/graphics/RectF;", "startAngle", "sweepBitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "getSweepBitmap", "()Landroid/graphics/Bitmap;", "sweepBitmap$delegate", "Lkotlin/Lazy;", "textPaint", "Landroid/graphics/Paint;", "textPath", "Landroid/graphics/Path;", "getTextPath", "()Landroid/graphics/Path;", "textPath$delegate", "textRadius", "getTextRadius", "()F", "textRadius$delegate", "drawIcons", "canvas", "Landroid/graphics/Canvas;", "bitmap", "sweepAngle", "isBox", "", "drawText", "text", "", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "rotate", "setData", "l", "", "setResult", "position", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LuckDrawView.kt */
public final class LuckDrawView extends View {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f12231a;
    /* renamed from: b */
    private final List<LuckPoolItem> f12232b;
    /* renamed from: c */
    private final Lazy f12233c;
    /* renamed from: d */
    private final Paint f12234d;
    /* renamed from: e */
    private int f12235e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public float f12236f;
    /* renamed from: g */
    private int f12237g;
    /* renamed from: h */
    private final RectF f12238h;
    /* renamed from: i */
    private ObjectAnimator f12239i;
    /* renamed from: j */
    private final Lazy f12240j;
    /* renamed from: k */
    private final Lazy f12241k;
    /* renamed from: l */
    private C8246a<Unit> f12242l;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, mo39189d2 = {"com/jiayouya/travel/module/travel/widget/LuckDrawView$setResult$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: LuckDrawView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.LuckDrawView$a */
    public static final class C3556a extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ LuckDrawView f12243a;
        /* renamed from: b */
        final /* synthetic */ float f12244b;

        C3556a(LuckDrawView luckDrawView, float f) {
            this.f12243a = luckDrawView;
            this.f12244b = f;
        }

        public void onAnimationEnd(Animator animator) {
            C8246a onEndListener = this.f12243a.getOnEndListener();
            if (onEndListener != null) {
                Unit jVar = (Unit) onEndListener.invoke();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckDrawView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.LuckDrawView$b */
    static final class C3557b extends Lambda implements C8246a<Bitmap> {
        public static final C3557b INSTANCE = new C3557b();

        C3557b() {
            super(0);
        }

        public final Bitmap invoke() {
            Drawable c = GloblaEx.m12820c(R.mipmap.bg_sweep);
            if (c != null) {
                return ((BitmapDrawable) c).getBitmap();
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Path;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckDrawView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.LuckDrawView$c */
    static final class C3558c extends Lambda implements C8246a<Path> {
        final /* synthetic */ LuckDrawView this$0;

        C3558c(LuckDrawView luckDrawView) {
            this.this$0 = luckDrawView;
            super(0);
        }

        public final Path invoke() {
            Path path = new Path();
            path.addCircle(this.this$0.f12236f, this.this$0.f12236f, this.this$0.getTextRadius(), Direction.CW);
            return path;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckDrawView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.LuckDrawView$d */
    static final class C3559d extends Lambda implements C8246a<Float> {
        public static final C3559d INSTANCE = new C3559d();

        C3559d() {
            super(0);
        }

        public final float invoke() {
            return (float) GloblaEx.m12810a(63.0f);
        }
    }

    static {
        Class<LuckDrawView> cls = LuckDrawView.class;
        f12231a = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "sweepBitmap", "getSweepBitmap()Landroid/graphics/Bitmap;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "textRadius", "getTextRadius()F")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "textPath", "getTextPath()Landroid/graphics/Path;"))};
    }

    public LuckDrawView(Context context) {
        this(context, null, 2, null);
    }

    private final Bitmap getSweepBitmap() {
        Lazy bVar = this.f12233c;
        C8280j jVar = f12231a[0];
        return (Bitmap) bVar.getValue();
    }

    private final Path getTextPath() {
        Lazy bVar = this.f12241k;
        C8280j jVar = f12231a[2];
        return (Path) bVar.getValue();
    }

    /* access modifiers changed from: private|final */
    public final float getTextRadius() {
        Lazy bVar = this.f12240j;
        C8280j jVar = f12231a[1];
        return ((Number) bVar.getValue()).floatValue();
    }

    public /* synthetic */ LuckDrawView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker fVar) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public LuckDrawView(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        super(context, attributeSet);
        this.f12232b = new ArrayList();
        this.f12233c = C8182c.m35317a(C3557b.INSTANCE);
        this.f12234d = new Paint(1);
        this.f12238h = new RectF();
        Paint paint = this.f12234d;
        paint.setColor(-1);
        paint.setTextSize((float) GloblaEx.m12817b(10.0f));
        paint.setFakeBoldText(true);
        setLayerType(1, null);
        this.f12240j = C8182c.m35317a(C3559d.INSTANCE);
        this.f12241k = C8182c.m35317a(new C3558c(this));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int min = Math.min(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        float f = (float) min;
        this.f12236f = f / 2.0f;
        this.f12235e = min / 2;
        this.f12238h.set(0.0f, 0.0f, f, f);
        setMeasuredDimension(min, min);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C8271i.m35386b(canvas, "canvas");
        canvas.save();
        float f = this.f12236f;
        canvas.rotate(35.0f, f, f);
        canvas.drawBitmap(getSweepBitmap(), 0.0f, 0.0f, null);
        canvas.restore();
        if (!this.f12232b.isEmpty()) {
            canvas.save();
            float size = -90.0f - ((float) (TinkerReport.KEY_APPLIED_VERSION_CHECK / this.f12232b.size()));
            float f2 = this.f12236f;
            canvas.rotate(size, f2, f2);
            this.f12237g = 0;
            int size2 = 360 / this.f12232b.size();
            for (LuckPoolItem luckPoolItem : this.f12232b) {
                m14901a(canvas, luckPoolItem.getName());
                luckPoolItem.setRotateAngel(LuckPoolItemKt.isHb(luckPoolItem) ? this.f12237g + 10 : this.f12237g + 110);
                m14900a(canvas, luckPoolItem.getRotateBitmap(), LuckPoolItemKt.isBox(luckPoolItem) ? size2 - 20 : size2, LuckPoolItemKt.isBox(luckPoolItem));
                this.f12237g += size2;
            }
            canvas.restore();
        }
    }

    /* renamed from: a */
    private final void m14900a(Canvas canvas, Bitmap bitmap, int i, boolean z) {
        double d = ((((double) this.f12237g) + (((double) i) / 2.0d)) * 3.141592653589793d) / ((double) TinkerReport.KEY_APPLIED_VERSION_CHECK);
        double a = (double) (this.f12235e - GloblaEx.m12810a(!z ? 20.0f : 10.0f));
        float cos = (float) (((double) this.f12236f) + (Math.cos(d) * a));
        float sin = (float) (((double) this.f12236f) + (a * Math.sin(d)));
        float width = (float) (bitmap.getWidth() / 2);
        float height = (float) (bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, null, new RectF(cos - width, sin - height, cos + width, sin + height), null);
    }

    /* renamed from: a */
    private final void m14901a(Canvas canvas, String str) {
        canvas.save();
        float f = (float) this.f12237g;
        float f2 = this.f12236f;
        canvas.rotate(f, f2, f2);
        canvas.drawTextOnPath(str, getTextPath(), 0.0f, 0.0f, this.f12234d);
        canvas.restore();
    }

    /* renamed from: a */
    public final void mo22488a() {
        this.f12239i = ObjectAnimator.ofFloat(this, C7887a.ROTATION, new float[]{0.0f, 360.0f});
        ObjectAnimator objectAnimator = this.f12239i;
        if (objectAnimator != null) {
            objectAnimator.setDuration(500);
            objectAnimator.setRepeatCount(-1);
            objectAnimator.setInterpolator(new LinearInterpolator());
            objectAnimator.start();
        }
    }

    public final void setResult(int i) {
        ObjectAnimator objectAnimator = this.f12239i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        float size = ((360.0f / ((float) this.f12232b.size())) * ((float) (this.f12232b.size() - i))) + 1080.0f;
        this.f12239i = ObjectAnimator.ofFloat(this, C7887a.ROTATION, new float[]{0.0f, size});
        ObjectAnimator objectAnimator2 = this.f12239i;
        if (objectAnimator2 != null) {
            objectAnimator2.setDuration(((long) 3) * ((long) ((size / ((float) 360)) * ((float) 500))));
            objectAnimator2.setRepeatCount(0);
            objectAnimator2.setInterpolator(new DecelerateInterpolator(2.0f));
            objectAnimator2.addListener(new C3556a(this, size));
            objectAnimator2.start();
        }
    }

    public final C8246a<Unit> getOnEndListener() {
        return this.f12242l;
    }

    public final void setOnEndListener(C8246a<Unit> aVar) {
        this.f12242l = aVar;
    }

    public final void setData(List<LuckPoolItem> list) {
        C8271i.m35386b(list, Constants.LANDSCAPE);
        this.f12232b.clear();
        this.f12232b.addAll(list);
        postInvalidate();
    }
}
