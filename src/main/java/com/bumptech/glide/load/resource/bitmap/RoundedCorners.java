package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners extends BitmapTransformation {
    /* renamed from: ID */
    private static final String f4855ID = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = f4855ID.getBytes(f4426a);
    private final int roundingRadius;

    public RoundedCorners(int i) {
        Preconditions.m6142a(i > 0, "roundingRadius must be greater than 0.");
        this.roundingRadius = i;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool eVar, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.roundedCorners(eVar, bitmap, this.roundingRadius);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RoundedCorners)) {
            return false;
        }
        if (this.roundingRadius == ((RoundedCorners) obj).roundingRadius) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C1772j.m6158b(f4855ID.hashCode(), C1772j.m6157b(this.roundingRadius));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
