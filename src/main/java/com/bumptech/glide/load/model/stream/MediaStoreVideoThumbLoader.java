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
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.p134d.ObjectKey;
import java.io.InputStream;

public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
    /* renamed from: a */
    private final Context f4830a;

    /* renamed from: com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader$Factory */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        /* renamed from: a */
        private final Context f4831a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public Factory(Context context) {
            this.f4831a = context;
        }

        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new MediaStoreVideoThumbLoader(this.f4831a);
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f4830a = context.getApplicationContext();
    }

    /* renamed from: a */
    public C1725a<InputStream> mo12926a(Uri uri, int i, int i2, Options fVar) {
        if (!MediaStoreUtil.m5300a(i, i2) || !m5943a(fVar)) {
            return null;
        }
        return new C1725a<>(new ObjectKey(uri), ThumbFetcher.m5307b(this.f4830a, uri));
    }

    /* renamed from: a */
    private boolean m5943a(Options fVar) {
        Long l = (Long) fVar.mo12919a(VideoDecoder.TARGET_FRAME);
        return l != null && l.longValue() == -1;
    }

    /* renamed from: a */
    public boolean mo12928a(Uri uri) {
        return MediaStoreUtil.m5302b(uri);
    }
}
