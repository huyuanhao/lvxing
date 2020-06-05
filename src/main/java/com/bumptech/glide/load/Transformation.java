package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.i */
public interface Transformation<T> extends Key {
    Resource<T> transform(Context context, Resource<T> uVar, int i, int i2);
}
