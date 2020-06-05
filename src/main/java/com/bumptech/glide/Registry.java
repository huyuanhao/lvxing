package com.bumptech.glide;

import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.p135a.DataRewinder;
import com.bumptech.glide.load.p135a.DataRewinder.C1624a;
import com.bumptech.glide.load.p135a.DataRewinderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.p130b.EncoderRegistry;
import com.bumptech.glide.p130b.ImageHeaderParserRegistry;
import com.bumptech.glide.p130b.LoadPathCache;
import com.bumptech.glide.p130b.ModelToResourceClassCache;
import com.bumptech.glide.p130b.ResourceDecoderRegistry;
import com.bumptech.glide.p130b.ResourceEncoderRegistry;
import com.bumptech.glide.util.p140a.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {
    /* renamed from: a */
    private final ModelLoaderRegistry f4094a = new ModelLoaderRegistry(this.f4103j);
    /* renamed from: b */
    private final EncoderRegistry f4095b = new EncoderRegistry();
    /* renamed from: c */
    private final ResourceDecoderRegistry f4096c = new ResourceDecoderRegistry();
    /* renamed from: d */
    private final ResourceEncoderRegistry f4097d = new ResourceEncoderRegistry();
    /* renamed from: e */
    private final DataRewinderRegistry f4098e = new DataRewinderRegistry();
    /* renamed from: f */
    private final TranscoderRegistry f4099f = new TranscoderRegistry();
    /* renamed from: g */
    private final ImageHeaderParserRegistry f4100g = new ImageHeaderParserRegistry();
    /* renamed from: h */
    private final ModelToResourceClassCache f4101h = new ModelToResourceClassCache();
    /* renamed from: i */
    private final LoadPathCache f4102i = new LoadPathCache();
    /* renamed from: j */
    private final Pool<List<Throwable>> f4103j = FactoryPools.m6093a();

    /* renamed from: com.bumptech.glide.Registry$MissingComponentException */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* renamed from: com.bumptech.glide.Registry$NoImageHeaderParserException */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* renamed from: com.bumptech.glide.Registry$NoModelLoaderAvailableException */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders for model: ");
            sb.append(obj);
            super(sb.toString());
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders for model: ");
            sb.append(cls);
            sb.append(" and data: ");
            sb.append(cls2);
            super(sb.toString());
        }
    }

    /* renamed from: com.bumptech.glide.Registry$NoResultEncoderAvailableException */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find result encoder for resource class: ");
            sb.append(cls);
            sb.append(", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            super(sb.toString());
        }
    }

    /* renamed from: com.bumptech.glide.Registry$NoSourceEncoderAvailableException */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find source encoder for data class: ");
            sb.append(cls);
            super(sb.toString());
        }
    }

    public Registry() {
        mo12350a(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    /* renamed from: a */
    public <Data> Registry mo12344a(Class<Data> cls, Encoder<Data> aVar) {
        this.f4095b.mo12394a(cls, aVar);
        return this;
    }

    /* renamed from: a */
    public <Data, TResource> Registry mo12346a(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> gVar) {
        mo12349a("legacy_append", cls, cls2, gVar);
        return this;
    }

    /* renamed from: a */
    public <Data, TResource> Registry mo12349a(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> gVar) {
        this.f4096c.mo12404a(str, gVar, cls, cls2);
        return this;
    }

    /* renamed from: a */
    public final Registry mo12350a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f4096c.mo12405a((List<String>) arrayList);
        return this;
    }

    /* renamed from: a */
    public <TResource> Registry mo12345a(Class<TResource> cls, ResourceEncoder<TResource> hVar) {
        this.f4097d.mo12409a(cls, hVar);
        return this;
    }

    /* renamed from: a */
    public Registry mo12343a(C1624a<?> aVar) {
        this.f4098e.mo12647a(aVar);
        return this;
    }

    /* renamed from: a */
    public <TResource, Transcode> Registry mo12348a(Class<TResource> cls, Class<Transcode> cls2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f4099f.register(cls, cls2, resourceTranscoder);
        return this;
    }

    /* renamed from: a */
    public Registry mo12342a(ImageHeaderParser imageHeaderParser) {
        this.f4100g.mo12397a(imageHeaderParser);
        return this;
    }

    /* renamed from: a */
    public <Model, Data> Registry mo12347a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> nVar) {
        this.f4094a.mo12980a(cls, cls2, nVar);
        return this;
    }

    /* renamed from: b */
    public <Model, Data> Registry mo12355b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> nVar) {
        this.f4094a.mo12981b(cls, cls2, nVar);
        return this;
    }

    /* renamed from: a */
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> mo12352a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> a = this.f4102i.mo12398a(cls, cls2, cls3);
        if (this.f4102i.mo12400a(a)) {
            return null;
        }
        if (a == null) {
            List c = m4856c(cls, cls2, cls3);
            if (c.isEmpty()) {
                a = null;
            } else {
                a = new LoadPath<>(cls, cls2, cls3, c, this.f4103j);
            }
            this.f4102i.mo12399a(cls, cls2, cls3, a);
        }
        return a;
    }

    /* renamed from: c */
    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> m4856c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f4096c.mo12406b(cls, cls2)) {
            for (Class cls5 : this.f4099f.getTranscodeClasses(cls4, cls3)) {
                DecodePath iVar = new DecodePath(cls, cls4, cls5, this.f4096c.mo12403a(cls, cls4), this.f4099f.get(cls4, cls5), this.f4103j);
                arrayList.add(iVar);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public <Model, TResource, Transcode> List<Class<?>> mo12358b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a = this.f4101h.mo12401a(cls, cls2, cls3);
        if (a == null) {
            a = new ArrayList<>();
            for (Class b : this.f4094a.mo12978a(cls)) {
                for (Class cls4 : this.f4096c.mo12406b(b, cls2)) {
                    if (!this.f4099f.getTranscodeClasses(cls4, cls3).isEmpty() && !a.contains(cls4)) {
                        a.add(cls4);
                    }
                }
            }
            this.f4101h.mo12402a(cls, cls2, cls3, Collections.unmodifiableList(a));
        }
        return a;
    }

    /* renamed from: a */
    public boolean mo12354a(Resource<?> uVar) {
        return this.f4097d.mo12408a(uVar.getResourceClass()) != null;
    }

    /* renamed from: b */
    public <X> ResourceEncoder<X> mo12357b(Resource<X> uVar) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> a = this.f4097d.mo12408a(uVar.getResourceClass());
        if (a != null) {
            return a;
        }
        throw new NoResultEncoderAvailableException(uVar.getResourceClass());
    }

    /* renamed from: a */
    public <X> Encoder<X> mo12351a(X x) throws NoSourceEncoderAvailableException {
        Encoder<X> a = this.f4095b.mo12393a(x.getClass());
        if (a != null) {
            return a;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    /* renamed from: b */
    public <X> DataRewinder<X> mo12356b(X x) {
        return this.f4098e.mo12646a(x);
    }

    /* renamed from: c */
    public <Model> List<ModelLoader<Model, ?>> mo12359c(Model model) {
        List<ModelLoader<Model, ?>> a = this.f4094a.mo12979a(model);
        if (!a.isEmpty()) {
            return a;
        }
        throw new NoModelLoaderAvailableException(model);
    }

    /* renamed from: a */
    public List<ImageHeaderParser> mo12353a() {
        List<ImageHeaderParser> a = this.f4100g.mo12396a();
        if (!a.isEmpty()) {
            return a;
        }
        throw new NoImageHeaderParserException();
    }
}
