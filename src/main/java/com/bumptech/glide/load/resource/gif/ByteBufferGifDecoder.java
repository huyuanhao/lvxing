package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder.C1617a;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory GIF_DECODER_FACTORY = new GifDecoderFactory();
    private static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    /* renamed from: com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$GifDecoderFactory */
    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        /* access modifiers changed from: 0000 */
        public GifDecoder build(C1617a aVar, GifHeader bVar, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(aVar, bVar, byteBuffer, i);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$GifHeaderParserPool */
    static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> pool = C1772j.m6153a(0);

        GifHeaderParserPool() {
        }

        /* access modifiers changed from: declared_synchronized */
        public synchronized GifHeaderParser obtain(ByteBuffer byteBuffer) {
            GifHeaderParser cVar;
            cVar = (GifHeaderParser) this.pool.poll();
            if (cVar == null) {
                cVar = new GifHeaderParser();
            }
            return cVar.mo12575a(byteBuffer);
        }

        /* access modifiers changed from: declared_synchronized */
        public synchronized void release(GifHeaderParser cVar) {
            cVar.mo12576a();
            this.pool.offer(cVar);
        }
    }

    public ByteBufferGifDecoder(Context context2) {
        this(context2, Glide.m5169a(context2).mo12539h().mo12353a(), Glide.m5169a(context2).mo12528a(), Glide.m5169a(context2).mo12532b());
    }

    public ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool eVar, ArrayPool bVar) {
        this(context2, list, eVar, bVar, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool eVar, ArrayPool bVar, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory2) {
        this.context = context2.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory2;
        this.provider = new GifBitmapProvider(eVar, bVar);
        this.parserPool = gifHeaderParserPool;
    }

    public boolean handles(ByteBuffer byteBuffer, Options fVar) throws IOException {
        return !((Boolean) fVar.mo12919a(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.m5381a(this.parsers, byteBuffer) == ImageType.GIF;
    }

    public GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, Options fVar) {
        GifHeaderParser obtain = this.parserPool.obtain(byteBuffer);
        try {
            GifDrawableResource decode = decode(byteBuffer, i, i2, obtain, fVar);
            return decode;
        } finally {
            this.parserPool.release(obtain);
        }
    }

    private GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser cVar, Options fVar) {
        String str = "Decoded GIF from stream in ";
        String str2 = TAG;
        long a = LogTime.m6125a();
        try {
            GifHeader b = cVar.mo12577b();
            if (b.mo12573c() > 0) {
                if (b.mo12574d() == 0) {
                    Config config = fVar.mo12919a(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565 ? Config.RGB_565 : Config.ARGB_8888;
                    GifDecoder build = this.gifDecoderFactory.build(this.provider, b, byteBuffer, getSampleSize(b, i, i2));
                    build.mo12555a(config);
                    build.mo12556b();
                    Bitmap i3 = build.mo12563i();
                    if (i3 == null) {
                        if (Log.isLoggable(str2, 2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(LogTime.m6124a(a));
                            Log.v(str2, sb.toString());
                        }
                        return null;
                    }
                    GifDrawable gifDrawable = new GifDrawable(this.context, build, UnitTransformation.get(), i, i2, i3);
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(gifDrawable);
                    if (Log.isLoggable(str2, 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(LogTime.m6124a(a));
                        Log.v(str2, sb2.toString());
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(LogTime.m6124a(a));
                Log.v(str2, sb3.toString());
            }
        }
    }

    private static int getSampleSize(GifHeader bVar, int i, int i2) {
        int i3;
        int min = Math.min(bVar.mo12571a() / i2, bVar.mo12572b() / i);
        if (min == 0) {
            i3 = 0;
        } else {
            i3 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i3);
        String str = TAG;
        if (Log.isLoggable(str, 2) && max > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Downsampling GIF, sampleSize: ");
            sb.append(max);
            sb.append(", target dimens: [");
            sb.append(i);
            String str2 = "x";
            sb.append(str2);
            sb.append(i2);
            sb.append("], actual dimens: [");
            sb.append(bVar.mo12572b());
            sb.append(str2);
            sb.append(bVar.mo12571a());
            sb.append("]");
            Log.v(str, sb.toString());
        }
        return max;
    }
}
