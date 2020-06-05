package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.p131c.RequestListener;
import com.bumptech.glide.p131c.RequestOptions;
import com.bumptech.glide.p131c.p132a.ImageViewTargetFactory;
import com.bumptech.glide.p131c.p132a.ViewTarget;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.g */
public class GlideContext extends ContextWrapper {
    /* renamed from: a */
    static final TransitionOptions<?, ?> f4292a = new GenericTransitionOptions();
    /* renamed from: b */
    private final ArrayPool f4293b;
    /* renamed from: c */
    private final Registry f4294c;
    /* renamed from: d */
    private final ImageViewTargetFactory f4295d;
    /* renamed from: e */
    private final RequestOptions f4296e;
    /* renamed from: f */
    private final List<RequestListener<Object>> f4297f;
    /* renamed from: g */
    private final Map<Class<?>, TransitionOptions<?, ?>> f4298g;
    /* renamed from: h */
    private final Engine f4299h;
    /* renamed from: i */
    private final boolean f4300i;
    /* renamed from: j */
    private final int f4301j;

    public GlideContext(Context context, ArrayPool bVar, Registry registry, ImageViewTargetFactory eVar, RequestOptions fVar, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, Engine kVar, boolean z, int i) {
        super(context.getApplicationContext());
        this.f4293b = bVar;
        this.f4294c = registry;
        this.f4295d = eVar;
        this.f4296e = fVar;
        this.f4297f = list;
        this.f4298g = map;
        this.f4299h = kVar;
        this.f4300i = z;
        this.f4301j = i;
    }

    /* renamed from: a */
    public List<RequestListener<Object>> mo12547a() {
        return this.f4297f;
    }

    /* renamed from: b */
    public RequestOptions mo12548b() {
        return this.f4296e;
    }

    /* renamed from: a */
    public <T> TransitionOptions<?, T> mo12546a(Class<T> cls) {
        TransitionOptions<?, T> jVar;
        TransitionOptions<?, T> jVar2 = (TransitionOptions) this.f4298g.get(cls);
        if (jVar2 == null) {
            for (Entry entry : this.f4298g.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    jVar2 = (TransitionOptions) entry.getValue();
                }
            }
        }
        return jVar == null ? f4292a : jVar;
    }

    /* renamed from: a */
    public <X> ViewTarget<ImageView, X> mo12545a(ImageView imageView, Class<X> cls) {
        return this.f4295d.mo12479a(imageView, cls);
    }

    /* renamed from: c */
    public Engine mo12549c() {
        return this.f4299h;
    }

    /* renamed from: d */
    public Registry mo12550d() {
        return this.f4294c;
    }

    /* renamed from: e */
    public int mo12551e() {
        return this.f4301j;
    }

    /* renamed from: f */
    public ArrayPool mo12552f() {
        return this.f4293b;
    }

    /* renamed from: g */
    public boolean mo12553g() {
        return this.f4300i;
    }
}
