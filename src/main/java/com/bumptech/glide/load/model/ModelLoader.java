package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.load.model.m */
public interface ModelLoader<Model, Data> {

    /* compiled from: ModelLoader */
    /* renamed from: com.bumptech.glide.load.model.m$a */
    public static class C1725a<Data> {
        /* renamed from: a */
        public final Key f4796a;
        /* renamed from: b */
        public final List<Key> f4797b;
        /* renamed from: c */
        public final DataFetcher<Data> f4798c;

        public C1725a(Key cVar, DataFetcher<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public C1725a(Key cVar, List<Key> list, DataFetcher<Data> dVar) {
            this.f4796a = (Key) Preconditions.m6138a(cVar);
            this.f4797b = (List) Preconditions.m6138a(list);
            this.f4798c = (DataFetcher) Preconditions.m6138a(dVar);
        }
    }

    /* renamed from: a */
    C1725a<Data> mo12926a(Model model, int i, int i2, Options fVar);

    /* renamed from: a */
    boolean mo12928a(Model model);
}
