package p672jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.C1772j;

/* renamed from: jp.wasabeef.glide.transformations.a */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    /* renamed from: a */
    public abstract Bitmap mo39177a(Context context, BitmapPool eVar, Bitmap bitmap, int i, int i2);

    public final Resource<Bitmap> transform(Context context, Resource<Bitmap> uVar, int i, int i2) {
        if (C1772j.m6155a(i, i2)) {
            BitmapPool a = Glide.m5169a(context).mo12528a();
            Bitmap bitmap = (Bitmap) uVar.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            int i3 = i;
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap a2 = mo39177a(context.getApplicationContext(), a, bitmap, i3, i2);
            if (bitmap.equals(a2)) {
                return uVar;
            }
            return BitmapResource.obtain(a2, a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot apply transformation on width: ");
        sb.append(i);
        sb.append(" or height: ");
        sb.append(i2);
        sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        throw new IllegalArgumentException(sb.toString());
    }
}
