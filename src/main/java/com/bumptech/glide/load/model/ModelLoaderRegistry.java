package com.bumptech.glide.load.model;

import androidx.core.util.Pools.Pool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.model.o */
public class ModelLoaderRegistry {
    /* renamed from: a */
    private final MultiModelLoaderFactory f4799a;
    /* renamed from: b */
    private final C1726a f4800b;

    /* compiled from: ModelLoaderRegistry */
    /* renamed from: com.bumptech.glide.load.model.o$a */
    private static class C1726a {
        /* renamed from: a */
        private final Map<Class<?>, C1727a<?>> f4801a = new HashMap();

        /* compiled from: ModelLoaderRegistry */
        /* renamed from: com.bumptech.glide.load.model.o$a$a */
        private static class C1727a<Model> {
            /* renamed from: a */
            final List<ModelLoader<Model, ?>> f4802a;

            public C1727a(List<ModelLoader<Model, ?>> list) {
                this.f4802a = list;
            }
        }

        C1726a() {
        }

        /* renamed from: a */
        public void mo12983a() {
            this.f4801a.clear();
        }

        /* renamed from: a */
        public <Model> void mo12984a(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (((C1727a) this.f4801a.put(cls, new C1727a(list))) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Already cached loaders for model: ");
                sb.append(cls);
                throw new IllegalStateException(sb.toString());
            }
        }

        /* renamed from: a */
        public <Model> List<ModelLoader<Model, ?>> mo12982a(Class<Model> cls) {
            C1727a aVar = (C1727a) this.f4801a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f4802a;
        }
    }

    public ModelLoaderRegistry(Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory qVar) {
        this.f4800b = new C1726a();
        this.f4799a = qVar;
    }

    /* renamed from: a */
    public synchronized <Model, Data> void mo12980a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> nVar) {
        this.f4799a.mo12988a(cls, cls2, nVar);
        this.f4800b.mo12983a();
    }

    /* renamed from: b */
    public synchronized <Model, Data> void mo12981b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> nVar) {
        m5888a(this.f4799a.mo12991b(cls, cls2, nVar));
        this.f4800b.mo12983a();
    }

    /* renamed from: a */
    private <Model, Data> void m5888a(List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory a : list) {
            a.mo12930a();
        }
    }

    /* renamed from: a */
    public <A> List<ModelLoader<A, ?>> mo12979a(A a) {
        List b = m5890b(m5889b(a));
        int size = b.size();
        List emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            ModelLoader mVar = (ModelLoader) b.get(i);
            if (mVar.mo12928a(a)) {
                if (z) {
                    emptyList = new ArrayList(size - i);
                    z = false;
                }
                emptyList.add(mVar);
            }
        }
        return emptyList;
    }

    /* renamed from: a */
    public synchronized List<Class<?>> mo12978a(Class<?> cls) {
        return this.f4799a.mo12990b(cls);
    }

    /* renamed from: b */
    private synchronized <A> List<ModelLoader<A, ?>> m5890b(Class<A> cls) {
        List<ModelLoader<A, ?>> a;
        a = this.f4800b.mo12982a(cls);
        if (a == null) {
            a = Collections.unmodifiableList(this.f4799a.mo12986a(cls));
            this.f4800b.mo12984a(cls, a);
        }
        return a;
    }

    /* renamed from: b */
    private static <A> Class<A> m5889b(A a) {
        return a.getClass();
    }
}
