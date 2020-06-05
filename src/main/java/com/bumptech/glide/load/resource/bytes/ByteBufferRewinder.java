package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.p135a.DataRewinder;
import com.bumptech.glide.load.p135a.DataRewinder.C1624a;
import java.nio.ByteBuffer;

public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {
    private final ByteBuffer buffer;

    /* renamed from: com.bumptech.glide.load.resource.bytes.ByteBufferRewinder$Factory */
    public static class Factory implements C1624a<ByteBuffer> {
        public DataRewinder<ByteBuffer> build(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }

        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }
    }

    public void cleanup() {
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public ByteBuffer rewindAndGet() {
        this.buffer.position(0);
        return this.buffer;
    }
}
