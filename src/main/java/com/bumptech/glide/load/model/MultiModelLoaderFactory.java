package com.bumptech.glide.load.model;

import androidx.core.util.Pools.Pool;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.model.q */
public class MultiModelLoaderFactory {
    /* renamed from: a */
    private static final C1731c f4812a = new C1731c();
    /* renamed from: b */
    private static final ModelLoader<Object, Object> f4813b = new C1729a();
    /* renamed from: c */
    private final List<C1730b<?, ?>> f4814c;
    /* renamed from: d */
    private final C1731c f4815d;
    /* renamed from: e */
    private final Set<C1730b<?, ?>> f4816e;
    /* renamed from: f */
    private final Pool<List<Throwable>> f4817f;

    /* compiled from: MultiModelLoaderFactory */
    /* renamed from: com.bumptech.glide.load.model.q$a */
    private static class C1729a implements ModelLoader<Object, Object> {
        /* renamed from: a */
        public C1725a<Object> mo12926a(Object obj, int i, int i2, Options fVar) {
            return null;
        }

        /* renamed from: a */
        public boolean mo12928a(Object obj) {
            return false;
        }

        C1729a() {
        }
    }

    /* compiled from: MultiModelLoaderFactory */
    /* renamed from: com.bumptech.glide.load.model.q$b */
    private static class C1730b<Model, Data> {
        /* renamed from: a */
        final Class<Data> f4818a;
        /* renamed from: b */
        final ModelLoaderFactory<? extends Model, ? extends Data> f4819b;
        /* renamed from: c */
        private final Class<Model> f4820c;

        public C1730b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> nVar) {
            this.f4820c = cls;
            this.f4818a = cls2;
            this.f4819b = nVar;
        }

        /* renamed from: a */
        public boolean mo12993a(Class<?> cls, Class<?> cls2) {
            return mo12992a(cls) && this.f4818a.isAssignableFrom(cls2);
        }

        /* renamed from: a */
        public boolean mo12992a(Class<?> cls) {
            return this.f4820c.isAssignableFrom(cls);
        }
    }

    /* compiled from: MultiModelLoaderFactory */
    /* renamed from: com.bumptech.glide.load.model.q$c */
    static class C1731c {
        C1731c() {
        }

        /* renamed from: a */
        public <Model, Data> MultiModelLoader<Model, Data> mo12994a(List<ModelLoader<Model, Data>> list, Pool<List<Throwable>> pool) {
            return new MultiModelLoader<>(list, pool);
        }
    }

    public MultiModelLoaderFactory(Pool<List<Throwable>> pool) {
        this(pool, f4812a);
    }

    MultiModelLoaderFactory(Pool<List<Throwable>> pool, C1731c cVar) {
        this.f4814c = new ArrayList();
        this.f4816e = new HashSet();
        this.f4817f = pool;
        this.f4815d = cVar;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized <Model, Data> void mo12988a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> nVar) {
        m5910a(cls, cls2, nVar, true);
    }

    /* renamed from: a */
    private <Model, Data> void m5910a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> nVar, boolean z) {
        C1730b bVar = new C1730b(cls, cls2, nVar);
        List<C1730b<?, ?>> list = this.f4814c;
        list.add(z ? list.size() : 0, bVar);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> mo12991b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> nVar) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> a;
        a = mo12987a(cls, cls2);
        mo12988a(cls, cls2, nVar);
        return a;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> mo12987a(Class<Model> cls, Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f4814c.iterator();
        while (it.hasNext()) {
            C1730b bVar = (C1730b) it.next();
            if (bVar.mo12993a(cls, cls2)) {
                it.remove();
                arrayList.add(m5909a(bVar));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized <Model> List<ModelLoader<Model, ?>> mo12986a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (C1730b bVar : this.f4814c) {
                if (!this.f4816e.contains(bVar)) {
                    if (bVar.mo12992a(cls)) {
                        this.f4816e.add(bVar);
                        arrayList.add(m5911b(bVar));
                        this.f4816e.remove(bVar);
                    }
                }
            }
        } catch (Throwable th) {
            this.f4816e.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized List<Class<?>> mo12990b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C1730b bVar : this.f4814c) {
            if (!arrayList.contains(bVar.f4818a) && bVar.mo12992a(cls)) {
                arrayList.add(bVar.f4818a);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized <Model, Data> ModelLoader<Model, Data> mo12989b(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (C1730b bVar : this.f4814c) {
                if (this.f4816e.contains(bVar)) {
                    z = true;
                } else if (bVar.mo12993a(cls, cls2)) {
                    this.f4816e.add(bVar);
                    arrayList.add(m5911b(bVar));
                    this.f4816e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f4815d.mo12994a(arrayList, this.f4817f);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return m5908a();
            } else {
                throw new NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f4816e.clear();
            throw th;
        }
    }

    /* renamed from: a */
    private <Model, Data> ModelLoaderFactory<Model, Data> m5909a(C1730b<?, ?> bVar) {
        return bVar.f4819b;
    }

    /* renamed from: b */
    private <Model, Data> ModelLoader<Model, Data> m5911b(C1730b<?, ?> bVar) {
        return (ModelLoader) Preconditions.m6138a(bVar.f4819b.mo12929a(this));
    }

    /* renamed from: a */
    private static <Model, Data> ModelLoader<Model, Data> m5908a() {
        return f4813b;
    }
}
