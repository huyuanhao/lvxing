package com.bumptech.glide.p130b;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.b.e */
public class ResourceDecoderRegistry {
    /* renamed from: a */
    private final List<String> f4154a = new ArrayList();
    /* renamed from: b */
    private final Map<String, List<C1604a<?, ?>>> f4155b = new HashMap();

    /* compiled from: ResourceDecoderRegistry */
    /* renamed from: com.bumptech.glide.b.e$a */
    private static class C1604a<T, R> {
        /* renamed from: a */
        final Class<R> f4156a;
        /* renamed from: b */
        final ResourceDecoder<T, R> f4157b;
        /* renamed from: c */
        private final Class<T> f4158c;

        public C1604a(Class<T> cls, Class<R> cls2, ResourceDecoder<T, R> gVar) {
            this.f4158c = cls;
            this.f4156a = cls2;
            this.f4157b = gVar;
        }

        /* renamed from: a */
        public boolean mo12407a(Class<?> cls, Class<?> cls2) {
            return this.f4158c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f4156a);
        }
    }

    /* renamed from: a */
    public synchronized void mo12405a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f4154a);
        this.f4154a.clear();
        this.f4154a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f4154a.add(str);
            }
        }
    }

    /* renamed from: a */
    public synchronized <T, R> List<ResourceDecoder<T, R>> mo12403a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f4154a) {
            List<C1604a> list = (List) this.f4155b.get(str);
            if (list != null) {
                for (C1604a aVar : list) {
                    if (aVar.mo12407a(cls, cls2)) {
                        arrayList.add(aVar.f4157b);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized <T, R> List<Class<R>> mo12406b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f4154a) {
            List<C1604a> list = (List) this.f4155b.get(str);
            if (list != null) {
                for (C1604a aVar : list) {
                    if (aVar.mo12407a(cls, cls2) && !arrayList.contains(aVar.f4156a)) {
                        arrayList.add(aVar.f4156a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized <T, R> void mo12404a(String str, ResourceDecoder<T, R> gVar, Class<T> cls, Class<R> cls2) {
        m4946a(str).add(new C1604a(cls, cls2, gVar));
    }

    /* renamed from: a */
    private synchronized List<C1604a<?, ?>> m4946a(String str) {
        List<C1604a<?, ?>> list;
        if (!this.f4154a.contains(str)) {
            this.f4154a.add(str);
        }
        list = (List) this.f4155b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f4155b.put(str, list);
        }
        return list;
    }
}
