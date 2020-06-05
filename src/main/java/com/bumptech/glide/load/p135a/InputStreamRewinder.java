package com.bumptech.glide.load.p135a;

import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.load.p135a.DataRewinder.C1624a;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.k */
public final class InputStreamRewinder implements DataRewinder<InputStream> {
    /* renamed from: a */
    private final RecyclableBufferedInputStream f4420a;

    /* compiled from: InputStreamRewinder */
    /* renamed from: com.bumptech.glide.load.a.k$a */
    public static final class C1629a implements C1624a<InputStream> {
        /* renamed from: a */
        private final ArrayPool f4421a;

        public C1629a(ArrayPool bVar) {
            this.f4421a = bVar;
        }

        /* renamed from: a */
        public DataRewinder<InputStream> build(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f4421a);
        }

        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    InputStreamRewinder(InputStream inputStream, ArrayPool bVar) {
        this.f4420a = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f4420a.mark(5242880);
    }

    /* renamed from: a */
    public InputStream rewindAndGet() throws IOException {
        this.f4420a.reset();
        return this.f4420a;
    }

    public void cleanup() {
        this.f4420a.release();
    }
}
