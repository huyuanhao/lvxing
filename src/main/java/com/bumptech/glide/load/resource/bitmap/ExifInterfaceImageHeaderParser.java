package com.bumptech.glide.load.resource.bitmap;

import android.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    public ImageType getType(InputStream inputStream) throws IOException {
        return ImageType.UNKNOWN;
    }

    public ImageType getType(ByteBuffer byteBuffer) throws IOException {
        return ImageType.UNKNOWN;
    }

    public int getOrientation(InputStream inputStream, ArrayPool bVar) throws IOException {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    public int getOrientation(ByteBuffer byteBuffer, ArrayPool bVar) throws IOException {
        return getOrientation(ByteBufferUtil.m6091b(byteBuffer), bVar);
    }
}
