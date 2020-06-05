package com.tencent.p605ep.common.adapt.iservice.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* renamed from: com.tencent.ep.common.adapt.iservice.picasso.Target */
public interface Target {
    void onBitmapFailed(Drawable drawable);

    void onBitmapLoaded(Bitmap bitmap);

    void onPrepareLoad(Drawable drawable);
}
