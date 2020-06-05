package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.p137a.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {

    /* renamed from: com.bumptech.glide.load.ImageHeaderParser$ImageType */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        private ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int getOrientation(InputStream inputStream, ArrayPool bVar) throws IOException;

    ImageType getType(InputStream inputStream) throws IOException;

    ImageType getType(ByteBuffer byteBuffer) throws IOException;
}
