package com.bumptech.glide.p130b;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.b.c */
public class LoadPathCache {
    /* renamed from: a */
    private static final LoadPath<?, ?, ?> f4149a;
    /* renamed from: b */
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> f4150b = new ArrayMap<>();
    /* renamed from: c */
    private final AtomicReference<MultiClassKey> f4151c = new AtomicReference<>();

    static {
        DecodePath iVar = new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null);
        LoadPath sVar = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(iVar), null);
        f4149a = sVar;
    }

    /* renamed from: a */
    public boolean mo12400a(LoadPath<?, ?, ?> sVar) {
        return f4149a.equals(sVar);
    }

    /* renamed from: a */
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> mo12398a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> sVar;
        MultiClassKey b = m4940b(cls, cls2, cls3);
        synchronized (this.f4150b) {
            sVar = (LoadPath) this.f4150b.get(b);
        }
        this.f4151c.set(b);
        return sVar;
    }

    /* renamed from: a */
    public void mo12399a(Class<?> cls, Class<?> cls2, Class<?> cls3, LoadPath<?, ?, ?> sVar) {
        synchronized (this.f4150b) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.f4150b;
            MultiClassKey hVar = new MultiClassKey(cls, cls2, cls3);
            if (sVar == null) {
                sVar = f4149a;
            }
            arrayMap.put(hVar, sVar);
        }
    }

    /* renamed from: b */
    private MultiClassKey m4940b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey hVar = (MultiClassKey) this.f4151c.getAndSet(null);
        if (hVar == null) {
            hVar = new MultiClassKey();
        }
        hVar.mo13238a(cls, cls2, cls3);
        return hVar;
    }
}
