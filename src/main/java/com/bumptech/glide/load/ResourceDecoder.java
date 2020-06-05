package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.g */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t, int i, int i2, Options fVar) throws IOException;

    boolean handles(T t, Options fVar) throws IOException;
}
