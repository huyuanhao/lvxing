package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import java.security.MessageDigest;

public class CircleCrop extends BitmapTransformation {
    /* renamed from: ID */
    private static final String f4851ID = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = f4851ID.getBytes(f4426a);
    private static final int VERSION = 1;

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool eVar, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.circleCrop(eVar, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof CircleCrop;
    }

    public int hashCode() {
        return f4851ID.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
