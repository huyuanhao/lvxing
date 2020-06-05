package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.c */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    /* renamed from: a */
    public boolean encode(ByteBuffer byteBuffer, File file, Options fVar) {
        try {
            ByteBufferUtil.m6089a(byteBuffer, file);
            return true;
        } catch (IOException e) {
            String str = "ByteBufferEncoder";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to write data", e);
            }
            return false;
        }
    }
}
