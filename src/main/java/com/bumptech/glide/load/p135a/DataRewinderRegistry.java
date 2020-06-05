package com.bumptech.glide.load.p135a;

import com.bumptech.glide.load.p135a.DataRewinder.C1624a;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.a.f */
public class DataRewinderRegistry {
    /* renamed from: b */
    private static final C1624a<?> f4405b = new C1624a<Object>() {
        public DataRewinder<Object> build(Object obj) {
            return new C1626a(obj);
        }

        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };
    /* renamed from: a */
    private final Map<Class<?>, C1624a<?>> f4406a = new HashMap();

    /* compiled from: DataRewinderRegistry */
    /* renamed from: com.bumptech.glide.load.a.f$a */
    private static final class C1626a implements DataRewinder<Object> {
        /* renamed from: a */
        private final Object f4407a;

        public void cleanup() {
        }

        C1626a(Object obj) {
            this.f4407a = obj;
        }

        public Object rewindAndGet() {
            return this.f4407a;
        }
    }

    /* renamed from: a */
    public synchronized void mo12647a(C1624a<?> aVar) {
        this.f4406a.put(aVar.getDataClass(), aVar);
    }

    /* renamed from: a */
    public synchronized <T> DataRewinder<T> mo12646a(T t) {
        C1624a aVar;
        Preconditions.m6138a(t);
        aVar = (C1624a) this.f4406a.get(t.getClass());
        if (aVar == null) {
            Iterator it = this.f4406a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1624a aVar2 = (C1624a) it.next();
                if (aVar2.getDataClass().isAssignableFrom(t.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f4405b;
        }
        return aVar.build(t);
    }
}
