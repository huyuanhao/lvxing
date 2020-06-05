package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.engine.p137a.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

final class DrawableToBitmapConverter {
    private static final BitmapPool NO_RECYCLE_BITMAP_POOL = new BitmapPoolAdapter() {
        public void put(Bitmap bitmap) {
        }
    };
    private static final String TAG = "DrawableToBitmap";

    private DrawableToBitmapConverter() {
    }

    static Resource<Bitmap> convert(BitmapPool eVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = drawToBitmap(eVar, current, i, i2);
            z = true;
        } else {
            bitmap = null;
        }
        if (!z) {
            eVar = NO_RECYCLE_BITMAP_POOL;
        }
        return BitmapResource.obtain(bitmap, eVar);
    }

    private static Bitmap drawToBitmap(BitmapPool eVar, Drawable drawable, int i, int i2) {
        String str = "Unable to draw ";
        String str2 = TAG;
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(str2, 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(drawable);
                sb.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                Log.w(str2, sb.toString());
            }
            return null;
        } else if (i2 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock bitmapDrawableLock = TransformationUtils.getBitmapDrawableLock();
            bitmapDrawableLock.lock();
            Bitmap bitmap = eVar.get(i, i2, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return bitmap;
            } finally {
                bitmapDrawableLock.unlock();
            }
        } else {
            if (Log.isLoggable(str2, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(drawable);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                Log.w(str2, sb2.toString());
            }
            return null;
        }
    }
}
