package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public interface GifDecoder {

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.bumptech.glide.gifdecoder.GifDecoder$GifDecodeStatus */
    public @interface GifDecodeStatus {
    }

    /* renamed from: com.bumptech.glide.gifdecoder.GifDecoder$a */
    public interface C1617a {
        Bitmap obtain(int i, int i2, Config config);

        byte[] obtainByteArray(int i);

        int[] obtainIntArray(int i);

        void release(Bitmap bitmap);

        void release(byte[] bArr);

        void release(int[] iArr);
    }

    /* renamed from: a */
    ByteBuffer mo12554a();

    /* renamed from: a */
    void mo12555a(Config config);

    /* renamed from: b */
    void mo12556b();

    /* renamed from: c */
    int mo12557c();

    /* renamed from: d */
    int mo12558d();

    /* renamed from: e */
    int mo12559e();

    /* renamed from: f */
    void mo12560f();

    /* renamed from: g */
    int mo12561g();

    /* renamed from: h */
    int mo12562h();

    /* renamed from: i */
    Bitmap mo12563i();

    /* renamed from: j */
    void mo12564j();
}
