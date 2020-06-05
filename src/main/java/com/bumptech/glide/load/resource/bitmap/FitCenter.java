package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import java.security.MessageDigest;

public class FitCenter extends BitmapTransformation {
    /* renamed from: ID */
    private static final String f4853ID = "com.bumptech.glide.load.resource.bitmap.FitCenter";
    private static final byte[] ID_BYTES = f4853ID.getBytes(f4426a);

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool eVar, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.fitCenter(eVar, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    public int hashCode() {
        return f4853ID.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
