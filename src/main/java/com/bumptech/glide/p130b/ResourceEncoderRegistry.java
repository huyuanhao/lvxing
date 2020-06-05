package com.bumptech.glide.p130b;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.b.f */
public class ResourceEncoderRegistry {
    /* renamed from: a */
    private final List<C1605a<?>> f4159a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry */
    /* renamed from: com.bumptech.glide.b.f$a */
    private static final class C1605a<T> {
        /* renamed from: a */
        final ResourceEncoder<T> f4160a;
        /* renamed from: b */
        private final Class<T> f4161b;

        C1605a(Class<T> cls, ResourceEncoder<T> hVar) {
            this.f4161b = cls;
            this.f4160a = hVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo12410a(Class<?> cls) {
            return this.f4161b.isAssignableFrom(cls);
        }
    }

    /* renamed from: a */
    public synchronized <Z> void mo12409a(Class<Z> cls, ResourceEncoder<Z> hVar) {
        this.f4159a.add(new C1605a(cls, hVar));
    }

    /* renamed from: a */
    public synchronized <Z> ResourceEncoder<Z> mo12408a(Class<Z> cls) {
        int size = this.f4159a.size();
        for (int i = 0; i < size; i++) {
            C1605a aVar = (C1605a) this.f4159a.get(i);
            if (aVar.mo12410a(cls)) {
                return aVar.f4160a;
            }
        }
        return null;
    }
}
