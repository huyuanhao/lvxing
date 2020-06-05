package p672jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import java.security.MessageDigest;

/* renamed from: jp.wasabeef.glide.transformations.CropTransformation */
public class CropTransformation extends BitmapTransformation {
    /* renamed from: b */
    private int f27718b;
    /* renamed from: c */
    private int f27719c;
    /* renamed from: d */
    private CropType f27720d;

    /* renamed from: jp.wasabeef.glide.transformations.CropTransformation$1 */
    static /* synthetic */ class C81761 {
        /* renamed from: a */
        static final /* synthetic */ int[] f27721a = new int[CropType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            jp.wasabeef.glide.transformations.CropTransformation$CropType[] r0 = p672jp.wasabeef.glide.transformations.CropTransformation.CropType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f27721a = r0
            int[] r0 = f27721a     // Catch:{ NoSuchFieldError -> 0x0014 }
            jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = p672jp.wasabeef.glide.transformations.CropTransformation.CropType.TOP     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f27721a     // Catch:{ NoSuchFieldError -> 0x001f }
            jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = p672jp.wasabeef.glide.transformations.CropTransformation.CropType.CENTER     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f27721a     // Catch:{ NoSuchFieldError -> 0x002a }
            jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = p672jp.wasabeef.glide.transformations.CropTransformation.CropType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: p672jp.wasabeef.glide.transformations.CropTransformation.C81761.m54925clinit():void");
        }
    }

    /* renamed from: jp.wasabeef.glide.transformations.CropTransformation$CropType */
    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap mo39177a(Context context, BitmapPool eVar, Bitmap bitmap, int i, int i2) {
        int i3 = this.f27718b;
        if (i3 == 0) {
            i3 = bitmap.getWidth();
        }
        this.f27718b = i3;
        int i4 = this.f27719c;
        if (i4 == 0) {
            i4 = bitmap.getHeight();
        }
        this.f27719c = i4;
        Bitmap bitmap2 = eVar.get(this.f27718b, this.f27719c, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        float max = Math.max(((float) this.f27718b) / ((float) bitmap.getWidth()), ((float) this.f27719c) / ((float) bitmap.getHeight()));
        float width = ((float) bitmap.getWidth()) * max;
        float height = max * ((float) bitmap.getHeight());
        float f = (((float) this.f27718b) - width) / 2.0f;
        float a = m35209a(height);
        new Canvas(bitmap2).drawBitmap(bitmap, null, new RectF(f, a, width + f, height + a), null);
        return bitmap2;
    }

    /* renamed from: a */
    private float m35209a(float f) {
        int i = C81761.f27721a[this.f27720d.ordinal()];
        if (i == 1) {
            return 0.0f;
        }
        if (i == 2) {
            return (((float) this.f27719c) - f) / 2.0f;
        }
        if (i != 3) {
            return 0.0f;
        }
        return ((float) this.f27719c) - f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CropTransformation(width=");
        sb.append(this.f27718b);
        sb.append(", height=");
        sb.append(this.f27719c);
        sb.append(", cropType=");
        sb.append(this.f27720d);
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof CropTransformation) {
            CropTransformation cropTransformation = (CropTransformation) obj;
            if (cropTransformation.f27718b == this.f27718b && cropTransformation.f27719c == this.f27719c && cropTransformation.f27720d == this.f27720d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return "jp.wasabeef.glide.transformations.CropTransformation.1".hashCode() + (this.f27718b * 100000) + (this.f27719c * 1000) + (this.f27720d.ordinal() * 10);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        StringBuilder sb = new StringBuilder();
        sb.append("jp.wasabeef.glide.transformations.CropTransformation.1");
        sb.append(this.f27718b);
        sb.append(this.f27719c);
        sb.append(this.f27720d);
        messageDigest.update(sb.toString().getBytes(f4426a));
    }
}
