package com.jiayouya.travel.module.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.common.p244b.GloblaEx;
import java.util.Objects;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ;2\u00020\u0001:\u0002;<B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0018\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J(\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J.\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006="}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/PosterView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "filter", "Landroid/graphics/PaintFlagsDrawFilter;", "listener", "Lcom/jiayouya/travel/module/common/widget/PosterView$Listener;", "getListener", "()Lcom/jiayouya/travel/module/common/widget/PosterView$Listener;", "setListener", "(Lcom/jiayouya/travel/module/common/widget/PosterView$Listener;)V", "mAvatar", "Landroid/graphics/drawable/Drawable;", "mClipPath", "Landroid/graphics/Path;", "mNickname", "", "mQrCode", "mRect", "Landroid/graphics/RectF;", "rectPaint", "Landroid/graphics/Paint;", "getRectPaint", "()Landroid/graphics/Paint;", "rectPaint$delegate", "Lkotlin/Lazy;", "shareBitmap", "Landroid/graphics/Bitmap;", "getShareBitmap", "()Landroid/graphics/Bitmap;", "getDensity", "", "getRect", "getRectRadius", "getScale", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "update", "resId", "nickname", "avatar", "qrCodeUrl", "avatarType", "Companion", "Listener", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PosterView.kt */
public final class PosterView extends AppCompatImageView {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11337a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(PosterView.class), "rectPaint", "getRectPaint()Landroid/graphics/Paint;"))};
    /* renamed from: b */
    public static final C2989a f11338b = new C2989a(null);
    /* renamed from: c */
    private final Path f11339c;
    /* renamed from: d */
    private final RectF f11340d;
    /* renamed from: e */
    private Drawable f11341e;
    /* renamed from: f */
    private Drawable f11342f;
    /* renamed from: g */
    private String f11343g;
    /* renamed from: h */
    private C2990b f11344h;
    /* renamed from: i */
    private final PaintFlagsDrawFilter f11345i;
    /* renamed from: j */
    private final Lazy f11346j;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJm\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\f¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/PosterView$Companion;", "", "()V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "scale", "", "drawable", "Landroid/graphics/drawable/Drawable;", "x", "", "y", "size", "text", "", "color", "lineExtra", "isBold", "", "isAutoBr", "textMaxWidth", "(Landroid/graphics/Canvas;FLjava/lang/String;IIIILjava/lang/Integer;ZZI)V", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: PosterView.kt */
    /* renamed from: com.jiayouya.travel.module.common.widget.PosterView$a */
    public static final class C2989a {
        private C2989a() {
        }

        public /* synthetic */ C2989a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¨\u0006\u000e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/PosterView$Listener;", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "density", "", "scale", "nickname", "", "avatar", "Landroid/graphics/drawable/Drawable;", "qrCode", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: PosterView.kt */
    /* renamed from: com.jiayouya.travel.module.common.widget.PosterView$b */
    public interface C2990b {
        /* renamed from: a */
        void mo20754a(Canvas canvas, float f, float f2, String str, Drawable drawable, Drawable drawable2);
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PosterView.kt */
    /* renamed from: com.jiayouya.travel.module.common.widget.PosterView$c */
    static final class C2991c extends Lambda implements C8246a<Paint> {
        public static final C2991c INSTANCE = new C2991c();

        C2991c() {
            super(0);
        }

        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setColor(-1);
            return paint;
        }
    }

    public PosterView(Context context) {
        this(context, null, 0, 6, null);
    }

    public PosterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final Paint getRectPaint() {
        Lazy bVar = this.f11346j;
        C8280j jVar = f11337a[0];
        return (Paint) bVar.getValue();
    }

    public /* synthetic */ PosterView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public PosterView(Context context, AttributeSet attributeSet, int i) {
        C8271i.m35386b(context, "context");
        super(context, attributeSet, i);
        this.f11339c = new Path();
        this.f11340d = new RectF();
        ViewCompat.setElevation(this, 0.0f);
        setLayerType(1, null);
        this.f11345i = new PaintFlagsDrawFilter(0, 3);
        this.f11346j = C8182c.m35317a(C2991c.INSTANCE);
    }

    public final Bitmap getShareBitmap() {
        Objects.requireNonNull(getDrawable(), "drawable-xxhdpi == null");
        Drawable drawable = getDrawable();
        String str = "drawable";
        C8271i.m35382a((Object) drawable, str);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Drawable drawable2 = getDrawable();
        C8271i.m35382a((Object) drawable2, str);
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, drawable2.getIntrinsicHeight(), Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Drawable drawable3 = getDrawable();
        Drawable drawable4 = getDrawable();
        C8271i.m35382a((Object) drawable4, str);
        int intrinsicWidth2 = drawable4.getIntrinsicWidth();
        Drawable drawable5 = getDrawable();
        C8271i.m35382a((Object) drawable5, str);
        drawable3.setBounds(0, 0, intrinsicWidth2, drawable5.getIntrinsicHeight());
        getDrawable().draw(canvas);
        C2990b bVar = this.f11344h;
        if (bVar != null) {
            float density = getDensity();
            Drawable drawable6 = getDrawable();
            C8271i.m35382a((Object) drawable6, str);
            bVar.mo20754a(canvas, density, ((float) drawable6.getIntrinsicWidth()) / 1080.0f, this.f11343g, this.f11341e, this.f11342f);
        }
        return createBitmap;
    }

    public final C2990b getListener() {
        return this.f11344h;
    }

    public final void setListener(C2990b bVar) {
        this.f11344h = bVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (((float) getMeasuredHeight()) / ((float) getMeasuredWidth()) != 0.5625f) {
            setMeasuredDimension(getMeasuredWidth(), (int) (((float) getMeasuredWidth()) * 1.7777778f));
            StringBuilder sb = new StringBuilder();
            sb.append("resize width==>");
            sb.append(getMeasuredWidth());
            sb.append(" height==>");
            sb.append((int) (((float) getMeasuredWidth()) * 1.7777778f));
            XLog.m12692b(sb.toString());
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11340d.set(0.0f, 0.0f, (float) i, (float) i2);
        this.f11339c.reset();
        Path path = this.f11339c;
        RectF rectF = this.f11340d;
        Context context = getContext();
        String str = "context";
        C8271i.m35382a((Object) context, str);
        float a = (float) ezy.p642a.Context.m34741a(context, 5.0f);
        Context context2 = getContext();
        C8271i.m35382a((Object) context2, str);
        path.addRoundRect(rectF, a, (float) ezy.p642a.Context.m34741a(context2, 5.0f), Direction.CW);
    }

    private final float getScale() {
        return ((float) getMeasuredWidth()) / 1080.0f;
    }

    private final RectF getRect() {
        return new RectF(((float) GloblaEx.m12810a(10.0f)) * getScale(), ((float) getMeasuredHeight()) - (((float) GloblaEx.m12810a(152.0f)) * getScale()), ((float) getMeasuredWidth()) - (((float) GloblaEx.m12810a(10.0f)) * getScale()), ((float) getMeasuredHeight()) - (((float) GloblaEx.m12810a(14.0f)) * getScale()));
    }

    private final float getRectRadius() {
        return ((float) GloblaEx.m12810a(20.0f)) * getScale();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            canvas.clipPath(this.f11339c);
        }
        if (canvas != null) {
            canvas.setDrawFilter(this.f11345i);
        }
        super.onDraw(canvas);
        StringBuilder sb = new StringBuilder();
        sb.append("scale==");
        sb.append(getScale());
        XLog.m12692b(sb.toString());
    }

    private final float getDensity() {
        float a = (((float) GloblaEx.m12809a()) * 1.0f) / 360.0f;
        StringBuilder sb = new StringBuilder();
        sb.append("density==");
        sb.append(a);
        XLog.m12691a(sb.toString());
        return a;
    }
}
