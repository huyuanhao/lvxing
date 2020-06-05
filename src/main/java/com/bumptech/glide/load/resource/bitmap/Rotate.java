package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.util.C1772j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class Rotate extends BitmapTransformation {
    /* renamed from: ID */
    private static final String f4854ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = f4854ID.getBytes(f4426a);
    private final int degreesToRotate;

    public Rotate(int i) {
        this.degreesToRotate = i;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool eVar, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.rotateImage(bitmap, this.degreesToRotate);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rotate)) {
            return false;
        }
        if (this.degreesToRotate == ((Rotate) obj).degreesToRotate) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C1772j.m6158b(f4854ID.hashCode(), C1772j.m6157b(this.degreesToRotate));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}
