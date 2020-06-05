package com.jiayouya.travel.module.common.widget.round.p262b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0002J(\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006\""}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/round/policy/GeneralRoundView18Policy;", "Lcom/jiayouya/travel/module/common/widget/round/policy/AbsRoundViewPolicy;", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "attrs", "", "attrIndex", "", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;[II)V", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mRectF", "Landroid/graphics/RectF;", "afterDispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "beforeDispatchDraw", "initViewData", "onLayout", "left", "top", "right", "bottom", "resetRoundPath", "setCornerRadius", "cornerRadius", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.widget.round.b.b */
public final class GeneralRoundView18Policy extends AbsRoundViewPolicy {
    /* renamed from: b */
    private Paint f11380b;
    /* renamed from: c */
    private RectF f11381c;
    /* renamed from: d */
    private Path f11382d;

    public GeneralRoundView18Policy(View view, Context context, AttributeSet attributeSet, int[] iArr, int i) {
        C8271i.m35386b(view, "view");
        C8271i.m35386b(context, "context");
        C8271i.m35386b(iArr, "attrs");
        super(view, context, attributeSet, iArr, i);
        m13636c();
    }

    /* renamed from: a */
    public void mo20803a(Canvas canvas) {
        if (canvas != null) {
            canvas.save();
        }
    }

    /* renamed from: b */
    public void mo20804b(Canvas canvas) {
        if (canvas != null) {
            Path path = this.f11382d;
            if (path == null) {
                C8271i.m35387b("mPath");
            }
            Paint paint = this.f11380b;
            if (paint == null) {
                C8271i.m35387b("mPaint");
            }
            canvas.drawPath(path, paint);
        }
        if (canvas != null) {
            canvas.restore();
        }
    }

    /* renamed from: a */
    public void mo20802a(int i, int i2, int i3, int i4) {
        RectF rectF = this.f11381c;
        if (rectF == null) {
            C8271i.m35387b("mRectF");
        }
        rectF.set(0.0f, 0.0f, (float) mo20800b().getWidth(), (float) mo20800b().getHeight());
        m13637d();
    }

    /* renamed from: c */
    private final void m13636c() {
        this.f11381c = new RectF();
        this.f11380b = new Paint(5);
        Paint paint = this.f11380b;
        if (paint == null) {
            C8271i.m35387b("mPaint");
        }
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.f11382d = new Path();
    }

    /* renamed from: d */
    private final void m13637d() {
        Path path = this.f11382d;
        String str = "mPath";
        if (path == null) {
            C8271i.m35387b(str);
        }
        path.reset();
        Path path2 = this.f11382d;
        if (path2 == null) {
            C8271i.m35387b(str);
        }
        RectF rectF = this.f11381c;
        if (rectF == null) {
            C8271i.m35387b("mRectF");
        }
        path2.addRoundRect(rectF, mo20798a(), mo20798a(), Direction.CW);
    }

    /* renamed from: b */
    public void mo20801b(float f) {
        mo20799a(f);
        m13637d();
    }
}
