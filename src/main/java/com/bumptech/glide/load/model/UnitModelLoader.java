package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.p134d.ObjectKey;

/* renamed from: com.bumptech.glide.load.model.u */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {
    /* renamed from: a */
    private static final UnitModelLoader<?> f4839a = new UnitModelLoader<>();

    /* compiled from: UnitModelLoader */
    /* renamed from: com.bumptech.glide.load.model.u$a */
    public static class C1742a<Model> implements ModelLoaderFactory<Model, Model> {
        /* renamed from: a */
        private static final C1742a<?> f4840a = new C1742a<>();

        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: b */
        public static <T> C1742a<T> m5983b() {
            return f4840a;
        }

        /* renamed from: a */
        public ModelLoader<Model, Model> mo12929a(MultiModelLoaderFactory qVar) {
            return UnitModelLoader.m5980a();
        }
    }

    /* compiled from: UnitModelLoader */
    /* renamed from: com.bumptech.glide.load.model.u$b */
    private static class C1743b<Model> implements DataFetcher<Model> {
        /* renamed from: a */
        private final Model f4841a;

        /* renamed from: b */
        public void mo12627b() {
        }

        /* renamed from: c */
        public void mo12628c() {
        }

        C1743b(Model model) {
            this.f4841a = model;
        }

        /* renamed from: a */
        public void mo12626a(Priority priority, C1623a<? super Model> aVar) {
            aVar.mo12641a(this.f4841a);
        }

        /* renamed from: a */
        public Class<Model> mo12619a() {
            return this.f4841a.getClass();
        }

        /* renamed from: d */
        public DataSource mo12629d() {
            return DataSource.LOCAL;
        }
    }

    /* renamed from: a */
    public boolean mo12928a(Model model) {
        return true;
    }

    /* renamed from: a */
    public static <T> UnitModelLoader<T> m5980a() {
        return f4839a;
    }

    /* renamed from: a */
    public C1725a<Model> mo12926a(Model model, int i, int i2, Options fVar) {
        return new C1725a<>(new ObjectKey(model), new C1743b(model));
    }
}
