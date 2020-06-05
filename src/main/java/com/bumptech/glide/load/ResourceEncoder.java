package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.h */
public interface ResourceEncoder<T> extends Encoder<Resource<T>> {
    EncodeStrategy getEncodeStrategy(Options fVar);
}
