package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.p135a.p136a.MediaStoreUtil;
import com.bumptech.glide.load.p135a.p136a.ThumbFetcher;
import com.bumptech.glide.p134d.ObjectKey;
import java.io.InputStream;

public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {
    /* renamed from: a */
    private final Context f4828a;

    /* renamed from: com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader$Factory */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        /* renamed from: a */
        private final Context f4829a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public Factory(Context context) {
            this.f4829a = context;
        }

        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new MediaStoreImageThumbLoader(this.f4829a);
        }
    }

    public MediaStoreImageThumbLoader(Context context) {
        this.f4828a = context.getApplicationContext();
    }

    /* renamed from: a */
    public C1725a<InputStream> mo12926a(Uri uri, int i, int i2, Options fVar) {
        if (MediaStoreUtil.m5300a(i, i2)) {
            return new C1725a<>(new ObjectKey(uri), ThumbFetcher.m5305a(this.f4828a, uri));
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo12928a(Uri uri) {
        return MediaStoreUtil.m5303c(uri);
    }
}
