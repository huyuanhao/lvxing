package com.bumptech.glide.p130b;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.b.a */
public class EncoderRegistry {
    /* renamed from: a */
    private final List<C1603a<?>> f4145a = new ArrayList();

    /* compiled from: EncoderRegistry */
    /* renamed from: com.bumptech.glide.b.a$a */
    private static final class C1603a<T> {
        /* renamed from: a */
        final Encoder<T> f4146a;
        /* renamed from: b */
        private final Class<T> f4147b;

        C1603a(Class<T> cls, Encoder<T> aVar) {
            this.f4147b = cls;
            this.f4146a = aVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo12395a(Class<?> cls) {
            return this.f4147b.isAssignableFrom(cls);
        }
    }

    /* renamed from: a */
    public synchronized <T> Encoder<T> mo12393a(Class<T> cls) {
        for (C1603a aVar : this.f4145a) {
            if (aVar.mo12395a(cls)) {
                return aVar.f4146a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized <T> void mo12394a(Class<T> cls, Encoder<T> aVar) {
        this.f4145a.add(new C1603a(cls, aVar));
    }
}
