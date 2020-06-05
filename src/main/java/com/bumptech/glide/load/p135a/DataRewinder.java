package com.bumptech.glide.load.p135a;

import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.e */
public interface DataRewinder<T> {

    /* compiled from: DataRewinder */
    /* renamed from: com.bumptech.glide.load.a.e$a */
    public interface C1624a<T> {
        DataRewinder<T> build(T t);

        Class<T> getDataClass();
    }

    void cleanup();

    T rewindAndGet() throws IOException;
}
