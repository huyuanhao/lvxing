package com.bumptech.glide.p130b;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.b.d */
public class ModelToResourceClassCache {
    /* renamed from: a */
    private final AtomicReference<MultiClassKey> f4152a = new AtomicReference<>();
    /* renamed from: b */
    private final ArrayMap<MultiClassKey, List<Class<?>>> f4153b = new ArrayMap<>();

    /* renamed from: a */
    public List<Class<?>> mo12401a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        MultiClassKey hVar = (MultiClassKey) this.f4152a.getAndSet(null);
        if (hVar == null) {
            hVar = new MultiClassKey(cls, cls2, cls3);
        } else {
            hVar.mo13238a(cls, cls2, cls3);
        }
        synchronized (this.f4153b) {
            list = (List) this.f4153b.get(hVar);
        }
        this.f4152a.set(hVar);
        return list;
    }

    /* renamed from: a */
    public void mo12402a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f4153b) {
            this.f4153b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
