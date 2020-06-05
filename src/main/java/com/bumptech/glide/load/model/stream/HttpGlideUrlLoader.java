package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.p135a.HttpUrlFetcher;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.stream.a */
public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    /* renamed from: a */
    public static final Option<Integer> f4832a = Option.m5384a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
    /* renamed from: b */
    private final ModelCache<GlideUrl, GlideUrl> f4833b;

    /* compiled from: HttpGlideUrlLoader */
    /* renamed from: com.bumptech.glide.load.model.stream.a$a */
    public static class C1736a implements ModelLoaderFactory<GlideUrl, InputStream> {
        /* renamed from: a */
        private final ModelCache<GlideUrl, GlideUrl> f4834a = new ModelCache<>(500);

        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<GlideUrl, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new HttpGlideUrlLoader(this.f4834a);
        }
    }

    /* renamed from: a */
    public boolean mo12928a(GlideUrl gVar) {
        return true;
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    public HttpGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> lVar) {
        this.f4833b = lVar;
    }

    /* renamed from: a */
    public C1725a<InputStream> mo12926a(GlideUrl gVar, int i, int i2, Options fVar) {
        ModelCache<GlideUrl, GlideUrl> lVar = this.f4833b;
        if (lVar != null) {
            GlideUrl gVar2 = (GlideUrl) lVar.mo12972a(gVar, 0, 0);
            if (gVar2 == null) {
                this.f4833b.mo12973a(gVar, 0, 0, gVar);
            } else {
                gVar = gVar2;
            }
        }
        return new C1725a<>(gVar, new HttpUrlFetcher(gVar, ((Integer) fVar.mo12919a(f4832a)).intValue()));
    }
}
