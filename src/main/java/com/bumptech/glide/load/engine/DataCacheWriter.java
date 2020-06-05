package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache.C1661b;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.e */
class DataCacheWriter<DataType> implements C1661b {
    /* renamed from: a */
    private final Encoder<DataType> f4559a;
    /* renamed from: b */
    private final DataType f4560b;
    /* renamed from: c */
    private final Options f4561c;

    DataCacheWriter(Encoder<DataType> aVar, DataType datatype, Options fVar) {
        this.f4559a = aVar;
        this.f4560b = datatype;
        this.f4561c = fVar;
    }

    /* renamed from: a */
    public boolean mo12788a(File file) {
        return this.f4559a.encode(this.f4560b, file, this.f4561c);
    }
}
