package com.jiayouya.travel.common.glide;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import okhttp3.C8379e.C8380a;
import okhttp3.C8513x;

/* renamed from: com.jiayouya.travel.common.glide.f */
public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    /* renamed from: a */
    private final C8380a f9654a;

    /* compiled from: OkHttpUrlLoader */
    /* renamed from: com.jiayouya.travel.common.glide.f$a */
    public static class C2905a implements ModelLoaderFactory<GlideUrl, InputStream> {
        /* renamed from: a */
        private static volatile C8380a f9655a;
        /* renamed from: b */
        private C8380a f9656b;

        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: b */
        private static C8380a m13091b() {
            if (f9655a == null) {
                synchronized (C2905a.class) {
                    if (f9655a == null) {
                        f9655a = new C8513x();
                    }
                }
            }
            return f9655a;
        }

        public C2905a() {
            this(m13091b());
        }

        public C2905a(C8380a aVar) {
            this.f9656b = aVar;
        }

        /* renamed from: a */
        public ModelLoader<GlideUrl, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new OkHttpUrlLoader(this.f9656b);
        }
    }

    /* renamed from: a */
    public boolean mo12928a(GlideUrl gVar) {
        return true;
    }

    public OkHttpUrlLoader(C8380a aVar) {
        this.f9654a = aVar;
    }

    /* renamed from: a */
    public C1725a<InputStream> mo12926a(GlideUrl gVar, int i, int i2, Options fVar) {
        return new C1725a<>(gVar, new OkHttpStreamFetcher(this.f9654a, gVar));
    }
}
