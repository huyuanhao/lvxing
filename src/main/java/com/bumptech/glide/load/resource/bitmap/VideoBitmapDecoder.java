package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.p137a.BitmapPool;

@Deprecated
public class VideoBitmapDecoder extends VideoDecoder<ParcelFileDescriptor> {
    public VideoBitmapDecoder(Context context) {
        this(Glide.m5169a(context).mo12528a());
    }

    public VideoBitmapDecoder(BitmapPool eVar) {
        super(eVar, new ParcelFileDescriptorInitializer());
    }
}
