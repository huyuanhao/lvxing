package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1 */
    static /* synthetic */ class C42451 {
        /* renamed from: $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType */
        static final /* synthetic */ int[] f14038xaa5c94ea = new int[ViewScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.kwad.sdk.core.imageloader.core.assist.ViewScaleType[] r0 = com.kwad.sdk.core.imageloader.core.assist.ViewScaleType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f14038xaa5c94ea = r0
            int[] r0 = f14038xaa5c94ea     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.kwad.sdk.core.imageloader.core.assist.ViewScaleType r1 = com.kwad.sdk.core.imageloader.core.assist.ViewScaleType.FIT_INSIDE     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f14038xaa5c94ea     // Catch:{ NoSuchFieldError -> 0x001f }
            com.kwad.sdk.core.imageloader.core.assist.ViewScaleType r1 = com.kwad.sdk.core.imageloader.core.assist.ViewScaleType.CROP     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils.C42451.m48154clinit():void");
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    private ImageSizeUtils() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    public static int computeImageSampleSize(com.kwad.sdk.core.imageloader.core.assist.ImageSize r6, com.kwad.sdk.core.imageloader.core.assist.ImageSize r7, com.kwad.sdk.core.imageloader.core.assist.ViewScaleType r8, boolean r9) {
        /*
        int r0 = r6.getWidth()
        int r6 = r6.getHeight()
        int r1 = r7.getWidth()
        int r7 = r7.getHeight()
        int[] r2 = com.kwad.sdk.core.imageloader.utils.ImageSizeUtils.C42451.f14038xaa5c94ea
        int r8 = r8.ordinal()
        r8 = r2[r8]
        r2 = 1
        if (r8 == r2) goto L_0x003d
        r3 = 2
        if (r8 == r3) goto L_0x0020
        r7 = 1
        goto L_0x0057
    L_0x0020:
        if (r9 == 0) goto L_0x0034
        int r8 = r0 / 2
        int r3 = r6 / 2
        r4 = 1
    L_0x0027:
        int r5 = r8 / r4
        if (r5 <= r1) goto L_0x0032
        int r5 = r3 / r4
        if (r5 <= r7) goto L_0x0032
        int r4 = r4 * 2
        goto L_0x0027
    L_0x0032:
        r7 = r4
        goto L_0x0057
    L_0x0034:
        int r8 = r0 / r1
        int r7 = r6 / r7
        int r7 = java.lang.Math.min(r8, r7)
        goto L_0x0057
    L_0x003d:
        if (r9 == 0) goto L_0x004f
        int r8 = r0 / 2
        int r3 = r6 / 2
        r4 = 1
    L_0x0044:
        int r5 = r8 / r4
        if (r5 > r1) goto L_0x004c
        int r5 = r3 / r4
        if (r5 <= r7) goto L_0x0032
    L_0x004c:
        int r4 = r4 * 2
        goto L_0x0044
    L_0x004f:
        int r8 = r0 / r1
        int r7 = r6 / r7
        int r7 = java.lang.Math.max(r8, r7)
    L_0x0057:
        if (r7 >= r2) goto L_0x005a
        r7 = 1
    L_0x005a:
        int r6 = considerMaxTextureSize(r0, r6, r7, r9)
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils.computeImageSampleSize(com.kwad.sdk.core.imageloader.core.assist.ImageSize, com.kwad.sdk.core.imageloader.core.assist.ImageSize, com.kwad.sdk.core.imageloader.core.assist.ViewScaleType, boolean):int");
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f = (float) width;
        float f2 = f / ((float) width2);
        float f3 = (float) height;
        float f4 = f3 / ((float) height2);
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f2 < f4) && (viewScaleType != ViewScaleType.CROP || f2 >= f4)) {
            width2 = (int) (f / f4);
        } else {
            height2 = (int) (f3 / f2);
        }
        if ((z || width2 >= width || height2 >= height) && (!z || width2 == width || height2 == height)) {
            return 1.0f;
        }
        return ((float) width2) / f;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil((double) (((float) width) / ((float) maxBitmapSize.getWidth()))), (int) Math.ceil((double) (((float) height) / ((float) maxBitmapSize.getHeight()))));
    }

    private static int considerMaxTextureSize(int i, int i2, int i3, boolean z) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i / i3 <= width && i2 / i3 <= height) {
                return i3;
            }
            i3 = z ? i3 * 2 : i3 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = imageSize.getHeight();
        }
        return new ImageSize(width, height);
    }
}
