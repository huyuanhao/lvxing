package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T> implements Transformation<T> {
    private static final Transformation<?> TRANSFORMATION = new UnitTransformation();

    public Resource<T> transform(Context context, Resource<T> uVar, int i, int i2) {
        return uVar;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public static <T> UnitTransformation<T> get() {
        return (UnitTransformation) TRANSFORMATION;
    }

    private UnitTransformation() {
    }
}
