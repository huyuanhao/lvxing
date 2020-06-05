package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.bumptech.glide.load.b */
public final class ImageHeaderParserUtils {
    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static ImageType m5380a(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool bVar) throws IOException {
        if (inputStream == null) {
            return ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int i = 0;
        int size = list.size();
        while (i < size) {
            try {
                ImageType type = ((ImageHeaderParser) list.get(i)).getType(inputStream);
                if (type != ImageType.UNKNOWN) {
                    inputStream.reset();
                    return type;
                }
                inputStream.reset();
                i++;
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageType.UNKNOWN;
    }

    /* renamed from: a */
    public static ImageType m5381a(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageType type = ((ImageHeaderParser) list.get(i)).getType(byteBuffer);
            if (type != ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageType.UNKNOWN;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    public static int m5382b(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int i = 0;
        int size = list.size();
        while (i < size) {
            try {
                int orientation = ((ImageHeaderParser) list.get(i)).getOrientation(inputStream, bVar);
                if (orientation != -1) {
                    inputStream.reset();
                    return orientation;
                }
                inputStream.reset();
                i++;
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return -1;
    }
}
