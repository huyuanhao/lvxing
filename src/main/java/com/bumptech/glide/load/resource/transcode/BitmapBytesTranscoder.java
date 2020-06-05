package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {
    private final CompressFormat compressFormat;
    private final int quality;

    public BitmapBytesTranscoder() {
        this(CompressFormat.JPEG, 100);
    }

    public BitmapBytesTranscoder(CompressFormat compressFormat2, int i) {
        this.compressFormat = compressFormat2;
        this.quality = i;
    }

    public Resource<byte[]> transcode(Resource<Bitmap> uVar, Options fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) uVar.get()).compress(this.compressFormat, this.quality, byteArrayOutputStream);
        uVar.recycle();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }
}
