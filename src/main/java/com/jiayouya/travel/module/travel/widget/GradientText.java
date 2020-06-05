package com.jiayouya.travel.module.travel.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
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

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/widget/GradientText;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "endColor", "", "mLinearGradient", "Landroid/graphics/LinearGradient;", "getMLinearGradient", "()Landroid/graphics/LinearGradient;", "mLinearGradient$delegate", "Lkotlin/Lazy;", "paint2", "Landroid/text/TextPaint;", "kotlin.jvm.PlatformType", "getPaint2", "()Landroid/text/TextPaint;", "paint2$delegate", "startColor", "textHeight", "", "getTextHeight", "()F", "textHeight$delegate", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GradientText.kt */
public final class GradientText extends AppCompatTextView {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f12225a;
    /* renamed from: b */
    private final Lazy f12226b = C8182c.m35317a(new C3553a(this));
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f12227c = GloblaEx.m12811a((int) R.color.orange_start);
    /* access modifiers changed from: private */
    /* renamed from: d */
    public int f12228d = GloblaEx.m12811a((int) R.color.orange_end);
    /* renamed from: e */
    private final Lazy f12229e = C8182c.m35317a(new C3555c(this));
    /* renamed from: f */
    private final Lazy f12230f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/LinearGradient;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GradientText.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.GradientText$a */
    static final class C3553a extends Lambda implements C8246a<LinearGradient> {
        final /* synthetic */ GradientText this$0;

        C3553a(GradientText gradientText) {
            this.this$0 = gradientText;
            super(0);
        }

        public final LinearGradient invoke() {
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) this.this$0.getMeasuredHeight(), new int[]{this.this$0.f12227c, this.this$0.f12228d}, null, TileMode.REPEAT);
            return linearGradient;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Landroid/text/TextPaint;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GradientText.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.GradientText$b */
    static final class C3554b extends Lambda implements C8246a<TextPaint> {
        final /* synthetic */ GradientText this$0;

        C3554b(GradientText gradientText) {
            this.this$0 = gradientText;
            super(0);
        }

        public final TextPaint invoke() {
            TextPaint paint = this.this$0.getPaint();
            paint.setStyle(Style.FILL);
            paint.setShader(this.this$0.getMLinearGradient());
            return paint;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GradientText.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.GradientText$c */
    static final class C3555c extends Lambda implements C8246a<Float> {
        final /* synthetic */ GradientText this$0;

        C3555c(GradientText gradientText) {
            this.this$0 = gradientText;
            super(0);
        }

        public final float invoke() {
            return this.this$0.getPaint().descent() - this.this$0.getPaint().ascent();
        }
    }

    static {
        Class<GradientText> cls = GradientText.class;
        f12225a = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "mLinearGradient", "getMLinearGradient()Landroid/graphics/LinearGradient;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "textHeight", "getTextHeight()F")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "paint2", "getPaint2()Landroid/text/TextPaint;"))};
    }

    /* access modifiers changed from: private|final */
    public final LinearGradient getMLinearGradient() {
        Lazy bVar = this.f12226b;
        C8280j jVar = f12225a[0];
        return (LinearGradient) bVar.getValue();
    }

    private final TextPaint getPaint2() {
        Lazy bVar = this.f12230f;
        C8280j jVar = f12225a[2];
        return (TextPaint) bVar.getValue();
    }

    private final float getTextHeight() {
        Lazy bVar = this.f12229e;
        C8280j jVar = f12225a[1];
        return ((Number) bVar.getValue()).floatValue();
    }

    public GradientText(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(attributeSet, "attrs");
        super(context, attributeSet);
        TextPaint paint = getPaint();
        paint.setStyle(Style.STROKE);
        paint.setShader(null);
        paint.setColor(Color.parseColor("#BC6900"));
        paint.setStrokeWidth((float) GloblaEx.m12810a(0.33f));
        paint.setFakeBoldText(true);
        this.f12230f = C8182c.m35317a(new C3554b(this));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawText(getText().toString(), 0.0f, getTextHeight(), getPaint());
        }
        if (canvas != null) {
            canvas.drawText(getText().toString(), 0.0f, getTextHeight(), getPaint2());
        }
    }
}
