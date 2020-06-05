package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.bumptech.glide.load.model.stream.c */
public class UrlLoader implements ModelLoader<URL, InputStream> {
    /* renamed from: a */
    private final ModelLoader<GlideUrl, InputStream> f4837a;

    /* compiled from: UrlLoader */
    /* renamed from: com.bumptech.glide.load.model.stream.c$a */
    public static class C1738a implements ModelLoaderFactory<URL, InputStream> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<URL, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new UrlLoader(qVar.mo12989b(GlideUrl.class, InputStream.class));
        }
    }

    /* renamed from: a */
    public boolean mo12928a(URL url) {
        return true;
    }

    public UrlLoader(ModelLoader<GlideUrl, InputStream> mVar) {
        this.f4837a = mVar;
    }

    /* renamed from: a */
    public C1725a<InputStream> mo12926a(URL url, int i, int i2, Options fVar) {
        return this.f4837a.mo12926a(new GlideUrl(url), i, i2, fVar);
    }
}
