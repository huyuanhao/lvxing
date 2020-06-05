package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.model.w */
public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {
    /* renamed from: a */
    private static final Set<String> f4847a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    /* renamed from: b */
    private final ModelLoader<GlideUrl, Data> f4848b;

    /* compiled from: UrlUriLoader */
    /* renamed from: com.bumptech.glide.load.model.w$a */
    public static class C1748a implements ModelLoaderFactory<Uri, InputStream> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new UrlUriLoader(qVar.mo12989b(GlideUrl.class, InputStream.class));
        }
    }

    public UrlUriLoader(ModelLoader<GlideUrl, Data> mVar) {
        this.f4848b = mVar;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(Uri uri, int i, int i2, Options fVar) {
        return this.f4848b.mo12926a(new GlideUrl(uri.toString()), i, i2, fVar);
    }

    /* renamed from: a */
    public boolean mo12928a(Uri uri) {
        return f4847a.contains(uri.getScheme());
    }
}
