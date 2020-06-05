package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.p135a.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.i */
public class DecodePath<DataType, ResourceType, Transcode> {
    /* renamed from: a */
    private final Class<DataType> f4624a;
    /* renamed from: b */
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f4625b;
    /* renamed from: c */
    private final ResourceTranscoder<ResourceType, Transcode> f4626c;
    /* renamed from: d */
    private final Pool<List<Throwable>> f4627d;
    /* renamed from: e */
    private final String f4628e;

    /* compiled from: DecodePath */
    /* renamed from: com.bumptech.glide.load.engine.i$a */
    interface C1677a<ResourceType> {
        /* renamed from: a */
        Resource<ResourceType> mo12844a(Resource<ResourceType> uVar);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pool<List<Throwable>> pool) {
        this.f4624a = cls;
        this.f4625b = list;
        this.f4626c = resourceTranscoder;
        this.f4627d = pool;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed DecodePath{");
        sb.append(cls.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(cls2.getSimpleName());
        sb.append(str);
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.f4628e = sb.toString();
    }

    /* renamed from: a */
    public Resource<Transcode> mo12854a(DataRewinder<DataType> eVar, int i, int i2, Options fVar, C1677a<ResourceType> aVar) throws GlideException {
        return this.f4626c.transcode(aVar.mo12844a(m5648a(eVar, i, i2, fVar)), fVar);
    }

    /* renamed from: a */
    private Resource<ResourceType> m5648a(DataRewinder<DataType> eVar, int i, int i2, Options fVar) throws GlideException {
        List list = (List) Preconditions.m6138a(this.f4627d.acquire());
        try {
            Resource<ResourceType> a = m5649a(eVar, i, i2, fVar, list);
            return a;
        } finally {
            this.f4627d.release(list);
        }
    }

    /* renamed from: a */
    private Resource<ResourceType> m5649a(DataRewinder<DataType> eVar, int i, int i2, Options fVar, List<Throwable> list) throws GlideException {
        Resource<ResourceType> uVar;
        int size = this.f4625b.size();
        Resource<ResourceType> uVar2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder gVar = (ResourceDecoder) this.f4625b.get(i3);
            try {
                if (gVar.handles(eVar.rewindAndGet(), fVar)) {
                    uVar2 = gVar.decode(eVar.rewindAndGet(), i, i2, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                String str = "DecodePath";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(gVar);
                    Log.v(str, sb.toString(), e);
                }
                list.add(e);
            }
            if (uVar2 != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f4628e, (List<Throwable>) new ArrayList<Throwable>(list));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecodePath{ dataClass=");
        sb.append(this.f4624a);
        sb.append(", decoders=");
        sb.append(this.f4625b);
        sb.append(", transcoder=");
        sb.append(this.f4626c);
        sb.append('}');
        return sb.toString();
    }
}
