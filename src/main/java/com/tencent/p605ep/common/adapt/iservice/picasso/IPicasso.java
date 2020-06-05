package com.tencent.p605ep.common.adapt.iservice.picasso;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

/* renamed from: com.tencent.ep.common.adapt.iservice.picasso.IPicasso */
public interface IPicasso {
    void cancelRequest(Object obj);

    IPicasso centerCrop();

    IPicasso error(Drawable drawable);

    IPicasso expiredInMills(long j);

    IPicasso fast();

    String fetch();

    Bitmap get();

    String into(ImageView imageView);

    String into(ImageView imageView, boolean z);

    String into(ImageView imageView, boolean z, int i);

    void into(Target target);

    void into(Target target, boolean z);

    IPicasso load(Resources resources, int i);

    IPicasso load(Uri uri);

    IPicasso noFade();

    IPicasso placeholder(Drawable drawable);

    boolean quickInto(ImageView imageView, Drawable drawable, String str);

    IPicasso resize(int i, int i2);

    IPicasso round(int i);

    void shutdown();

    IPicasso skipMemoryCache();

    IPicasso stroke(int i, int i2);
}
