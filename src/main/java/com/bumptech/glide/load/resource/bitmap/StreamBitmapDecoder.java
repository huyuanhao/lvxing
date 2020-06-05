package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    /* renamed from: com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder$UntrustedCallbacks */
    static class UntrustedCallbacks implements DecodeCallbacks {
        private final RecyclableBufferedInputStream bufferedStream;
        private final ExceptionCatchingInputStream exceptionStream;

        UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream cVar) {
            this.bufferedStream = recyclableBufferedInputStream;
            this.exceptionStream = cVar;
        }

        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }

        public void onDecodeComplete(BitmapPool eVar, Bitmap bitmap) throws IOException {
            IOException a = this.exceptionStream.mo13212a();
            if (a != null) {
                if (bitmap != null) {
                    eVar.put(bitmap);
                }
                throw a;
            }
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler2, ArrayPool bVar) {
        this.downsampler = downsampler2;
        this.byteArrayPool = bVar;
    }

    public boolean handles(InputStream inputStream, Options fVar) {
        return this.downsampler.handles(inputStream);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options fVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.byteArrayPool);
            z = true;
        }
        ExceptionCatchingInputStream a = ExceptionCatchingInputStream.m6118a(recyclableBufferedInputStream);
        try {
            return this.downsampler.decode(new MarkEnforcingInputStream(a), i, i2, fVar, new UntrustedCallbacks(recyclableBufferedInputStream, a));
        } finally {
            a.mo13214b();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }
}
