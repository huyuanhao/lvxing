package p672jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.security.MessageDigest;

/* renamed from: jp.wasabeef.glide.transformations.RoundedCornersTransformation */
public class RoundedCornersTransformation extends BitmapTransformation {
    /* renamed from: b */
    private int f27722b;
    /* renamed from: c */
    private int f27723c = (this.f27722b * 2);
    /* renamed from: d */
    private int f27724d;
    /* renamed from: e */
    private CornerType f27725e;

    /* renamed from: jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType */
    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(int i, int i2, CornerType cornerType) {
        this.f27722b = i;
        this.f27724d = i2;
        this.f27725e = cornerType;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap mo39177a(Context context, BitmapPool eVar, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = eVar.get(width, height, Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
        m35211a(canvas, paint, (float) width, (float) height);
        return bitmap2;
    }

    /* renamed from: a */
    private void m35211a(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        float f3 = f - ((float) i);
        float f4 = f2 - ((float) i);
        switch (this.f27725e) {
            case ALL:
                int i2 = this.f27724d;
                RectF rectF = new RectF((float) i2, (float) i2, f3, f4);
                int i3 = this.f27722b;
                canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
                return;
            case TOP_LEFT:
                m35212b(canvas, paint, f3, f4);
                return;
            case TOP_RIGHT:
                m35213c(canvas, paint, f3, f4);
                return;
            case BOTTOM_LEFT:
                m35214d(canvas, paint, f3, f4);
                return;
            case BOTTOM_RIGHT:
                m35215e(canvas, paint, f3, f4);
                return;
            case TOP:
                m35216f(canvas, paint, f3, f4);
                return;
            case BOTTOM:
                m35217g(canvas, paint, f3, f4);
                return;
            case LEFT:
                m35218h(canvas, paint, f3, f4);
                return;
            case RIGHT:
                m35219i(canvas, paint, f3, f4);
                return;
            case OTHER_TOP_LEFT:
                m35220j(canvas, paint, f3, f4);
                return;
            case OTHER_TOP_RIGHT:
                m35221k(canvas, paint, f3, f4);
                return;
            case OTHER_BOTTOM_LEFT:
                m35222l(canvas, paint, f3, f4);
                return;
            case OTHER_BOTTOM_RIGHT:
                m35223m(canvas, paint, f3, f4);
                return;
            case DIAGONAL_FROM_TOP_LEFT:
                m35224n(canvas, paint, f3, f4);
                return;
            case DIAGONAL_FROM_TOP_RIGHT:
                m35225o(canvas, paint, f3, f4);
                return;
            default:
                int i4 = this.f27724d;
                RectF rectF2 = new RectF((float) i4, (float) i4, f3, f4);
                int i5 = this.f27722b;
                canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
                return;
        }
    }

    /* renamed from: b */
    private void m35212b(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        float f3 = (float) i;
        float f4 = (float) i;
        int i2 = this.f27723c;
        RectF rectF = new RectF(f3, f4, (float) (i + i2), (float) (i + i2));
        int i3 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f27724d;
        float f5 = (float) i4;
        int i5 = this.f27722b;
        canvas.drawRect(new RectF(f5, (float) (i4 + i5), (float) (i4 + i5), f2), paint);
        int i6 = this.f27724d;
        canvas.drawRect(new RectF((float) (this.f27722b + i6), (float) i6, f, f2), paint);
    }

    /* renamed from: c */
    private void m35213c(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27723c;
        float f3 = f - ((float) i);
        int i2 = this.f27724d;
        RectF rectF = new RectF(f3, (float) i2, f, (float) (i2 + i));
        int i3 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f27724d;
        canvas.drawRect(new RectF((float) i4, (float) i4, f - ((float) this.f27722b), f2), paint);
        int i5 = this.f27722b;
        canvas.drawRect(new RectF(f - ((float) i5), (float) (this.f27724d + i5), f, f2), paint);
    }

    /* renamed from: d */
    private void m35214d(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        float f3 = (float) i;
        int i2 = this.f27723c;
        RectF rectF = new RectF(f3, f2 - ((float) i2), (float) (i + i2), f2);
        int i3 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f27724d;
        canvas.drawRect(new RectF((float) i4, (float) i4, (float) (i4 + this.f27723c), f2 - ((float) this.f27722b)), paint);
        int i5 = this.f27724d;
        canvas.drawRect(new RectF((float) (this.f27722b + i5), (float) i5, f, f2), paint);
    }

    /* renamed from: e */
    private void m35215e(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27723c;
        RectF rectF = new RectF(f - ((float) i), f2 - ((float) i), f, f2);
        int i2 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.f27724d;
        canvas.drawRect(new RectF((float) i3, (float) i3, f - ((float) this.f27722b), f2), paint);
        int i4 = this.f27722b;
        canvas.drawRect(new RectF(f - ((float) i4), (float) this.f27724d, f, f2 - ((float) i4)), paint);
    }

    /* renamed from: f */
    private void m35216f(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.f27723c));
        int i2 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.f27724d;
        canvas.drawRect(new RectF((float) i3, (float) (i3 + this.f27722b), f, f2), paint);
    }

    /* renamed from: g */
    private void m35217g(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF((float) this.f27724d, f2 - ((float) this.f27723c), f, f2);
        int i = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.f27724d;
        canvas.drawRect(new RectF((float) i2, (float) i2, f, f2 - ((float) this.f27722b)), paint);
    }

    /* renamed from: h */
    private void m35218h(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.f27723c), f2);
        int i2 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.f27724d;
        canvas.drawRect(new RectF((float) (this.f27722b + i3), (float) i3, f, f2), paint);
    }

    /* renamed from: i */
    private void m35219i(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - ((float) this.f27723c), (float) this.f27724d, f, f2);
        int i = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.f27724d;
        canvas.drawRect(new RectF((float) i2, (float) i2, f - ((float) this.f27722b), f2), paint);
    }

    /* renamed from: j */
    private void m35220j(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF((float) this.f27724d, f2 - ((float) this.f27723c), f, f2);
        int i = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        RectF rectF2 = new RectF(f - ((float) this.f27723c), (float) this.f27724d, f, f2);
        int i2 = this.f27722b;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, paint);
        int i3 = this.f27724d;
        float f3 = (float) i3;
        float f4 = (float) i3;
        int i4 = this.f27722b;
        canvas.drawRect(new RectF(f3, f4, f - ((float) i4), f2 - ((float) i4)), paint);
    }

    /* renamed from: k */
    private void m35221k(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.f27723c), f2);
        int i2 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF((float) this.f27724d, f2 - ((float) this.f27723c), f, f2);
        int i3 = this.f27722b;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.f27724d;
        int i5 = this.f27722b;
        canvas.drawRect(new RectF((float) (i4 + i5), (float) i4, f, f2 - ((float) i5)), paint);
    }

    /* renamed from: l */
    private void m35222l(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.f27723c));
        int i2 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF(f - ((float) this.f27723c), (float) this.f27724d, f, f2);
        int i3 = this.f27722b;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.f27724d;
        float f3 = (float) i4;
        int i5 = this.f27722b;
        canvas.drawRect(new RectF(f3, (float) (i4 + i5), f - ((float) i5), f2), paint);
    }

    /* renamed from: m */
    private void m35223m(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.f27723c));
        int i2 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.f27724d;
        RectF rectF2 = new RectF((float) i3, (float) i3, (float) (i3 + this.f27723c), f2);
        int i4 = this.f27722b;
        canvas.drawRoundRect(rectF2, (float) i4, (float) i4, paint);
        int i5 = this.f27724d;
        int i6 = this.f27722b;
        canvas.drawRect(new RectF((float) (i5 + i6), (float) (i5 + i6), f, f2), paint);
    }

    /* renamed from: n */
    private void m35224n(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27724d;
        float f3 = (float) i;
        float f4 = (float) i;
        int i2 = this.f27723c;
        RectF rectF = new RectF(f3, f4, (float) (i + i2), (float) (i + i2));
        int i3 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f27723c;
        RectF rectF2 = new RectF(f - ((float) i4), f2 - ((float) i4), f, f2);
        int i5 = this.f27722b;
        canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
        int i6 = this.f27724d;
        canvas.drawRect(new RectF((float) i6, (float) (i6 + this.f27722b), f - ((float) this.f27723c), f2), paint);
        int i7 = this.f27724d;
        canvas.drawRect(new RectF((float) (this.f27723c + i7), (float) i7, f, f2 - ((float) this.f27722b)), paint);
    }

    /* renamed from: o */
    private void m35225o(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f27723c;
        float f3 = f - ((float) i);
        int i2 = this.f27724d;
        RectF rectF = new RectF(f3, (float) i2, f, (float) (i2 + i));
        int i3 = this.f27722b;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f27724d;
        float f4 = (float) i4;
        int i5 = this.f27723c;
        RectF rectF2 = new RectF(f4, f2 - ((float) i5), (float) (i4 + i5), f2);
        int i6 = this.f27722b;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.f27724d;
        float f5 = (float) i7;
        float f6 = (float) i7;
        int i8 = this.f27722b;
        canvas.drawRect(new RectF(f5, f6, f - ((float) i8), f2 - ((float) i8)), paint);
        int i9 = this.f27724d;
        int i10 = this.f27722b;
        canvas.drawRect(new RectF((float) (i9 + i10), (float) (i9 + i10), f, f2), paint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RoundedTransformation(radius=");
        sb.append(this.f27722b);
        sb.append(", margin=");
        sb.append(this.f27724d);
        sb.append(", diameter=");
        sb.append(this.f27723c);
        sb.append(", cornerType=");
        sb.append(this.f27725e.name());
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (roundedCornersTransformation.f27722b == this.f27722b && roundedCornersTransformation.f27723c == this.f27723c && roundedCornersTransformation.f27724d == this.f27724d && roundedCornersTransformation.f27725e == this.f27725e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1".hashCode() + (this.f27722b * C7516p.f25219Cf) + (this.f27723c * 1000) + (this.f27724d * 100) + (this.f27725e.ordinal() * 10);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        StringBuilder sb = new StringBuilder();
        sb.append("jp.wasabeef.glide.transformations.RoundedCornersTransformation.1");
        sb.append(this.f27722b);
        sb.append(this.f27723c);
        sb.append(this.f27724d);
        sb.append(this.f27725e);
        messageDigest.update(sb.toString().getBytes(f4426a));
    }
}
