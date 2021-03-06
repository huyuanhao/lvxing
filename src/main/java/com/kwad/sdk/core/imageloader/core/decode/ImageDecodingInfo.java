package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;

public class ImageDecodingInfo {
    private final boolean considerExifParams;
    private final Options decodingOptions = new Options();
    private final ImageDownloader downloader;
    private final Object extraForDownloader;
    private final String imageKey;
    private final ImageScaleType imageScaleType;
    private final String imageUri;
    private final String originalImageUri;
    private final ImageSize targetSize;
    private final ViewScaleType viewScaleType;

    public ImageDecodingInfo(String str, String str2, String str3, ImageSize imageSize, ViewScaleType viewScaleType2, ImageDownloader imageDownloader, DisplayImageOptions displayImageOptions) {
        this.imageKey = str;
        this.imageUri = str2;
        this.originalImageUri = str3;
        this.targetSize = imageSize;
        this.imageScaleType = displayImageOptions.getImageScaleType();
        this.viewScaleType = viewScaleType2;
        this.downloader = imageDownloader;
        this.extraForDownloader = displayImageOptions.getExtraForDownloader();
        this.considerExifParams = displayImageOptions.isConsiderExifParams();
        copyOptions(displayImageOptions.getDecodingOptions(), this.decodingOptions);
    }

    private void copyOptions(Options options, Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        if (VERSION.SDK_INT >= 10) {
            copyOptions10(options, options2);
        }
        if (VERSION.SDK_INT >= 11) {
            copyOptions11(options, options2);
        }
    }

    private void copyOptions10(Options options, Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    private void copyOptions11(Options options, Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public ImageDownloader getDownloader() {
        return this.downloader;
    }

    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public String getImageKey() {
        return this.imageKey;
    }

    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public String getImageUri() {
        return this.imageUri;
    }

    public String getOriginalImageUri() {
        return this.originalImageUri;
    }

    public ImageSize getTargetSize() {
        return this.targetSize;
    }

    public ViewScaleType getViewScaleType() {
        return this.viewScaleType;
    }

    public boolean shouldConsiderExifParams() {
        return this.considerExifParams;
    }
}
