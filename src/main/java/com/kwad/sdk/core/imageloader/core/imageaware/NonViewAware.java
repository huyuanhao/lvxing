package com.kwad.sdk.core.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;

public class NonViewAware implements ImageAware {
    protected final ImageSize imageSize;
    protected final String imageUri;
    protected final ViewScaleType scaleType;

    public NonViewAware(ImageSize imageSize2, ViewScaleType viewScaleType) {
        this(null, imageSize2, viewScaleType);
    }

    public NonViewAware(String str, ImageSize imageSize2, ViewScaleType viewScaleType) {
        if (imageSize2 == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        } else if (viewScaleType != null) {
            this.imageUri = str;
            this.imageSize = imageSize2;
            this.scaleType = viewScaleType;
        } else {
            throw new IllegalArgumentException("scaleType must not be null");
        }
    }

    public int getHeight() {
        return this.imageSize.getHeight();
    }

    public int getId() {
        return TextUtils.isEmpty(this.imageUri) ? super.hashCode() : this.imageUri.hashCode();
    }

    public ViewScaleType getScaleType() {
        return this.scaleType;
    }

    public int getWidth() {
        return this.imageSize.getWidth();
    }

    public View getWrappedView() {
        return null;
    }

    public boolean isCollected() {
        return false;
    }

    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }

    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }
}
