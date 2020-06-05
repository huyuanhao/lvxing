package com.kwad.sdk.nativead;

import android.text.TextUtils;

public class KsImage {
    private int height;
    private String imageUrl;
    private int width;

    public KsImage(int i, int i2, String str) {
        this.width = i;
        this.height = i2;
        this.imageUrl = str;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isValid() {
        return this.width > 0 && this.height > 0 && !TextUtils.isEmpty(this.imageUrl);
    }
}
