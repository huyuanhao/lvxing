package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme;
import com.kwad.sdk.core.imageloader.utils.C4246L;
import com.kwad.sdk.core.imageloader.utils.ImageSizeUtils;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.IOException;
import java.io.InputStream;

public class BaseImageDecoder implements ImageDecoder {
    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    /* renamed from: com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder$ExifInfo */
    protected static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        protected ExifInfo(int i, boolean z) {
            this.rotation = i;
            this.flipHorizontal = z;
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder$ImageFileInfo */
    protected static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        protected ImageFileInfo(ImageSize imageSize2, ExifInfo exifInfo) {
            this.imageSize = imageSize2;
            this.exif = exifInfo;
        }
    }

    public BaseImageDecoder(boolean z) {
        this.loggingEnabled = z;
    }

    private boolean canDefineExifParams(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && Scheme.ofUri(str) == Scheme.FILE;
    }

    /* access modifiers changed from: protected */
    public Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imageDecodingInfo, int i, boolean z) {
        Matrix matrix = new Matrix();
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.EXACTLY || imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize imageSize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i);
            float computeImageScale = ImageSizeUtils.computeImageScale(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(computeImageScale, 1.0f) != 0) {
                matrix.setScale(computeImageScale, computeImageScale);
                if (this.loggingEnabled) {
                    C4246L.m17479d(LOG_SCALE_IMAGE, imageSize, imageSize.scale(computeImageScale), Float.valueOf(computeImageScale), imageDecodingInfo.getImageKey());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                C4246L.m17479d(LOG_FLIP_IMAGE, imageDecodingInfo.getImageKey());
            }
        }
        if (i != 0) {
            matrix.postRotate((float) i);
            if (this.loggingEnabled) {
                C4246L.m17479d(LOG_ROTATE_IMAGE, Integer.valueOf(i), imageDecodingInfo.getImageKey());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public Bitmap decode(ImageDecodingInfo imageDecodingInfo) {
        InputStream imageStream = getImageStream(imageDecodingInfo);
        if (imageStream == null) {
            C4246L.m17480e(ERROR_NO_IMAGE_STREAM, imageDecodingInfo.getImageKey());
            return null;
        }
        try {
            ImageFileInfo defineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
            imageStream = resetStream(imageStream, imageDecodingInfo);
            Bitmap decodeStream = BitmapFactory.decodeStream(imageStream, null, prepareDecodingOptions(defineImageSizeAndRotation.imageSize, imageDecodingInfo));
            if (decodeStream == null) {
                C4246L.m17480e(ERROR_CANT_DECODE_IMAGE, imageDecodingInfo.getImageKey());
            } else {
                decodeStream = considerExactScaleAndOrientatiton(decodeStream, imageDecodingInfo, defineImageSizeAndRotation.exif.rotation, defineImageSizeAndRotation.exif.flipHorizontal);
            }
            return decodeStream;
        } finally {
            IoUtils.closeSilently(imageStream);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v4, types: [int] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
            r1 = r0;
            r0 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
            r1 = r0;
            r0 = 270(0x10e, float:3.78E-43);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            r1 = r0;
            r0 = 180(0xb4, float:2.52E-43);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    public com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder.ExifInfo defineExifOrientation(java.lang.String r5) {
        /*
        r4 = this;
        r0 = 0
        r1 = 1
        android.media.ExifInterface r2 = new android.media.ExifInterface     // Catch:{ IOException -> 0x002c }
        com.kwad.sdk.core.imageloader.core.download.ImageDownloader$Scheme r3 = com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme.FILE     // Catch:{ IOException -> 0x002c }
        java.lang.String r3 = r3.crop(r5)     // Catch:{ IOException -> 0x002c }
        r2.<init>(r3)     // Catch:{ IOException -> 0x002c }
        java.lang.String r3 = "Orientation"
        int r5 = r2.getAttributeInt(r3, r1)     // Catch:{ IOException -> 0x002c }
        switch(r5) {
            case 1: goto L_0x0035;
            case 2: goto L_0x0036;
            case 3: goto L_0x0026;
            case 4: goto L_0x0025;
            case 5: goto L_0x001e;
            case 6: goto L_0x0018;
            case 7: goto L_0x0017;
            case 8: goto L_0x001f;
            default: goto L_0x0016;
        }
    L_0x0016:
        goto L_0x0035
    L_0x0017:
        r0 = 1
    L_0x0018:
        r5 = 90
        r1 = r0
        r0 = 90
        goto L_0x0036
    L_0x001e:
        r0 = 1
    L_0x001f:
        r5 = 270(0x10e, float:3.78E-43)
        r1 = r0
        r0 = 270(0x10e, float:3.78E-43)
        goto L_0x0036
    L_0x0025:
        r0 = 1
    L_0x0026:
        r5 = 180(0xb4, float:2.52E-43)
        r1 = r0
        r0 = 180(0xb4, float:2.52E-43)
        goto L_0x0036
    L_0x002c:
        java.lang.Object[] r1 = new java.lang.Object[r1]
        r1[r0] = r5
        java.lang.String r5 = "Can't read EXIF tags from file [%s]"
        com.kwad.sdk.core.imageloader.utils.C4246L.m17484w(r5, r1)
    L_0x0035:
        r1 = 0
    L_0x0036:
        com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder$ExifInfo r5 = new com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder$ExifInfo
        r5.m48122init(r0, r1)
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder.defineExifOrientation(java.lang.String):com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder$ExifInfo");
    }

    /* access modifiers changed from: protected */
    public ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String imageUri = imageDecodingInfo.getImageUri();
        ExifInfo exifInfo = (!imageDecodingInfo.shouldConsiderExifParams() || !canDefineExifParams(imageUri, options.outMimeType)) ? new ExifInfo() : defineExifOrientation(imageUri);
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exifInfo.rotation), exifInfo);
    }

    /* access modifiers changed from: protected */
    public InputStream getImageStream(ImageDecodingInfo imageDecodingInfo) {
        return imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader());
    }

    /* access modifiers changed from: protected */
    public Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo imageDecodingInfo) {
        int i;
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.NONE) {
            i = 1;
        } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
            i = ImageSizeUtils.computeMinImageSampleSize(imageSize);
        } else {
            i = ImageSizeUtils.computeImageSampleSize(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (i > 1 && this.loggingEnabled) {
            C4246L.m17479d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(i), Integer.valueOf(i), imageDecodingInfo.getImageKey());
        }
        Options decodingOptions = imageDecodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = i;
        return decodingOptions;
    }

    /* access modifiers changed from: protected */
    public InputStream resetStream(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        IoUtils.closeSilently(inputStream);
        return getImageStream(imageDecodingInfo);
    }
}
