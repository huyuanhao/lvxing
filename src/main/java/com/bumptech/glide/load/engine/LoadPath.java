package com.bumptech.glide.load.engine;

import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p135a.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.s */
public class LoadPath<Data, ResourceType, Transcode> {
    /* renamed from: a */
    private final Class<Data> f4708a;
    /* renamed from: b */
    private final Pool<List<Throwable>> f4709b;
    /* renamed from: c */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f4710c;
    /* renamed from: d */
    private final String f4711d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pool<List<Throwable>> pool) {
        this.f4708a = cls;
        this.f4709b = pool;
        this.f4710c = (List) Preconditions.m6141a(list);
        StringBuilder sb = new StringBuilder();
        sb.append("Failed LoadPath{");
        sb.append(cls.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(cls2.getSimpleName());
        sb.append(str);
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.f4711d = sb.toString();
    }

    /* renamed from: a */
    public Resource<Transcode> mo12911a(DataRewinder<Data> eVar, Options fVar, int i, int i2, C1677a<ResourceType> aVar) throws GlideException {
        List list = (List) Preconditions.m6138a(this.f4709b.acquire());
        try {
            Resource<Transcode> a = m5735a(eVar, fVar, i, i2, aVar, list);
            return a;
        } finally {
            this.f4709b.release(list);
        }
    }

    /* renamed from: a */
    private Resource<Transcode> m5735a(DataRewinder<Data> eVar, Options fVar, int i, int i2, C1677a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        Resource<Transcode> uVar;
        List<Throwable> list2 = list;
        int size = this.f4710c.size();
        Resource<Transcode> uVar2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                uVar2 = ((DecodePath) this.f4710c.get(i3)).mo12854a(eVar, i, i2, fVar, aVar);
            } catch (GlideException e) {
                list2.add(e);
            }
            if (uVar2 != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f4711d, (List<Throwable>) new ArrayList<Throwable>(list2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadPath{decodePaths=");
        sb.append(Arrays.toString(this.f4710c.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
