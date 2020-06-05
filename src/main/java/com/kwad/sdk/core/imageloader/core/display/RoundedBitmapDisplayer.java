package com.kwad.sdk.core.imageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageViewAware;

public class RoundedBitmapDisplayer implements BitmapDisplayer {
    protected final int cornerRadius;
    protected final int margin;

    /* renamed from: com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer$RoundedDrawable */
    public static class RoundedDrawable extends Drawable {
        protected final BitmapShader bitmapShader;
        protected final float cornerRadius;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final int margin;
        protected final Paint paint;

        public RoundedDrawable(Bitmap bitmap, int i, int i2) {
            this.cornerRadius = (float) i;
            this.margin = i2;
            this.bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            float f = (float) i2;
            this.mBitmapRect = new RectF(f, f, (float) (bitmap.getWidth() - i2), (float) (bitmap.getHeight() - i2));
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.paint.setShader(this.bitmapShader);
            this.paint.setFilterBitmap(true);
            this.paint.setDither(true);
        }

        public void draw(Canvas canvas) {
            RectF rectF = this.mRect;
            float f = this.cornerRadius;
            canvas.drawRoundRect(rectF, f, f, this.paint);
        }

        public int getOpacity() {
            return -3;
        }

        /* access modifiers changed from: protected */
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.mRect;
            int i = this.margin;
            rectF.set((float) i, (float) i, (float) (rect.width() - this.margin), (float) (rect.height() - this.margin));
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.mBitmapRect, this.mRect, ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(matrix);
        }

        public void setAlpha(int i) {
            this.paint.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    public RoundedBitmapDisplayer(int i) {
        this(i, 0);
    }

    public RoundedBitmapDisplayer(int i, int i2) {
        this.cornerRadius = i;
        this.margin = i2;
    }

    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (imageAware instanceof ImageViewAware) {
            imageAware.setImageDrawable(new RoundedDrawable(bitmap, this.cornerRadius, this.margin));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
