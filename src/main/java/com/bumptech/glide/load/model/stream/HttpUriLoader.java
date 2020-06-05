package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.model.stream.b */
public class HttpUriLoader implements ModelLoader<Uri, InputStream> {
    /* renamed from: a */
    private static final Set<String> f4835a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    /* renamed from: b */
    private final ModelLoader<GlideUrl, InputStream> f4836b;

    /* compiled from: HttpUriLoader */
    /* renamed from: com.bumptech.glide.load.model.stream.b$a */
    public static class C1737a implements ModelLoaderFactory<Uri, InputStream> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new HttpUriLoader(qVar.mo12989b(GlideUrl.class, InputStream.class));
        }
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> mVar) {
        this.f4836b = mVar;
    }

    /* renamed from: a */
    public C1725a<InputStream> mo12926a(Uri uri, int i, int i2, Options fVar) {
        return this.f4836b.mo12926a(new GlideUrl(uri.toString()), i, i2, fVar);
    }

    /* renamed from: a */
    public boolean mo12928a(Uri uri) {
        return f4835a.contains(uri.getScheme());
    }
}
