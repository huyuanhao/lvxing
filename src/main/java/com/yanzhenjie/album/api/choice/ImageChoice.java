package com.yanzhenjie.album.api.choice;

import android.content.Context;
import com.yanzhenjie.album.api.ImageMultipleWrapper;
import com.yanzhenjie.album.api.ImageSingleWrapper;

public final class ImageChoice implements Choice<ImageMultipleWrapper, ImageSingleWrapper> {
    /* renamed from: a */
    private Context f26120a;

    public ImageChoice(Context context) {
        this.f26120a = context;
    }

    /* renamed from: a */
    public ImageSingleWrapper mo37541b() {
        return new ImageSingleWrapper(this.f26120a);
    }
}
