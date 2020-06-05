package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.bumptech.glide.load.d */
public class MultiTransformation<T> implements Transformation<T> {
    /* renamed from: b */
    private final Collection<? extends Transformation<T>> f4427b;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... iVarArr) {
        if (iVarArr.length != 0) {
            this.f4427b = Arrays.asList(iVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public Resource<T> transform(Context context, Resource<T> uVar, int i, int i2) {
        Resource<T> uVar2 = uVar;
        for (Transformation transform : this.f4427b) {
            Resource<T> transform2 = transform.transform(context, uVar2, i, i2);
            if (uVar2 != null && !uVar2.equals(uVar) && !uVar2.equals(transform2)) {
                uVar2.recycle();
            }
            uVar2 = transform2;
        }
        return uVar2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MultiTransformation)) {
            return false;
        }
        return this.f4427b.equals(((MultiTransformation) obj).f4427b);
    }

    public int hashCode() {
        return this.f4427b.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (Transformation updateDiskCacheKey : this.f4427b) {
            updateDiskCacheKey.updateDiskCacheKey(messageDigest);
        }
    }
}
