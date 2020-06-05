package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;

public final class GifOptions {
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.m5384a("com.bumptech.glide.load.resource.gif.GifOptions.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option<Boolean> DISABLE_ANIMATION = Option.m5384a("com.bumptech.glide.load.resource.gif.GifOptions.DisableAnimation", Boolean.valueOf(false));

    private GifOptions() {
    }
}
