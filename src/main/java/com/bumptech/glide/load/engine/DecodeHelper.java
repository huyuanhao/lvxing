package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.Registry.NoSourceEncoderAvailableException;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.load.engine.g */
final class DecodeHelper<Transcode> {
    /* renamed from: a */
    private final List<C1725a<?>> f4562a = new ArrayList();
    /* renamed from: b */
    private final List<Key> f4563b = new ArrayList();
    /* renamed from: c */
    private GlideContext f4564c;
    /* renamed from: d */
    private Object f4565d;
    /* renamed from: e */
    private int f4566e;
    /* renamed from: f */
    private int f4567f;
    /* renamed from: g */
    private Class<?> f4568g;
    /* renamed from: h */
    private C1673d f4569h;
    /* renamed from: i */
    private Options f4570i;
    /* renamed from: j */
    private Map<Class<?>, Transformation<?>> f4571j;
    /* renamed from: k */
    private Class<Transcode> f4572k;
    /* renamed from: l */
    private boolean f4573l;
    /* renamed from: m */
    private boolean f4574m;
    /* renamed from: n */
    private Key f4575n;
    /* renamed from: o */
    private Priority f4576o;
    /* renamed from: p */
    private DiskCacheStrategy f4577p;
    /* renamed from: q */
    private boolean f4578q;
    /* renamed from: r */
    private boolean f4579r;

    DecodeHelper() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <R> void mo12812a(GlideContext gVar, Object obj, Key cVar, int i, int i2, DiskCacheStrategy jVar, Class<?> cls, Class<R> cls2, Priority priority, Options fVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, C1673d dVar) {
        this.f4564c = gVar;
        this.f4565d = obj;
        this.f4575n = cVar;
        this.f4566e = i;
        this.f4567f = i2;
        this.f4577p = jVar;
        this.f4568g = cls;
        this.f4569h = dVar;
        this.f4572k = cls2;
        this.f4576o = priority;
        this.f4570i = fVar;
        this.f4571j = map;
        this.f4578q = z;
        this.f4579r = z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12811a() {
        this.f4564c = null;
        this.f4565d = null;
        this.f4575n = null;
        this.f4568g = null;
        this.f4572k = null;
        this.f4570i = null;
        this.f4576o = null;
        this.f4571j = null;
        this.f4577p = null;
        this.f4562a.clear();
        this.f4573l = false;
        this.f4563b.clear();
        this.f4574m = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public DiskCache mo12816b() {
        return this.f4569h.mo12849a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public DiskCacheStrategy mo12819c() {
        return this.f4577p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Priority mo12821d() {
        return this.f4576o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Options mo12822e() {
        return this.f4570i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public Key mo12823f() {
        return this.f4575n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo12824g() {
        return this.f4566e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int mo12825h() {
        return this.f4567f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public ArrayPool mo12826i() {
        return this.f4564c.mo12552f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public Class<?> mo12827j() {
        return this.f4572k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public Class<?> mo12828k() {
        return this.f4565d.getClass();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public List<Class<?>> mo12829l() {
        return this.f4564c.mo12550d().mo12358b(this.f4565d.getClass(), this.f4568g, this.f4572k);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo12815a(Class<?> cls) {
        return mo12817b(cls) != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <Data> LoadPath<Data, ?, Transcode> mo12817b(Class<Data> cls) {
        return this.f4564c.mo12550d().mo12352a(cls, this.f4568g, this.f4572k);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo12830m() {
        return this.f4579r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public <Z> Transformation<Z> mo12820c(Class<Z> cls) {
        Transformation<Z> iVar = (Transformation) this.f4571j.get(cls);
        if (iVar == null) {
            Iterator it = this.f4571j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    iVar = (Transformation) entry.getValue();
                    break;
                }
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (!this.f4571j.isEmpty() || !this.f4578q) {
            return UnitTransformation.get();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Missing transformation for ");
        sb.append(cls);
        sb.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo12814a(Resource<?> uVar) {
        return this.f4564c.mo12550d().mo12354a(uVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <Z> ResourceEncoder<Z> mo12818b(Resource<Z> uVar) {
        return this.f4564c.mo12550d().mo12357b(uVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<ModelLoader<File, ?>> mo12810a(File file) throws NoModelLoaderAvailableException {
        return this.f4564c.mo12550d().mo12359c(file);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo12813a(Key cVar) {
        List n = mo12831n();
        int size = n.size();
        for (int i = 0; i < size; i++) {
            if (((C1725a) n.get(i)).f4796a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public List<C1725a<?>> mo12831n() {
        if (!this.f4573l) {
            this.f4573l = true;
            this.f4562a.clear();
            List c = this.f4564c.mo12550d().mo12359c(this.f4565d);
            int size = c.size();
            for (int i = 0; i < size; i++) {
                C1725a a = ((ModelLoader) c.get(i)).mo12926a(this.f4565d, this.f4566e, this.f4567f, this.f4570i);
                if (a != null) {
                    this.f4562a.add(a);
                }
            }
        }
        return this.f4562a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public List<Key> mo12832o() {
        if (!this.f4574m) {
            this.f4574m = true;
            this.f4563b.clear();
            List n = mo12831n();
            int size = n.size();
            for (int i = 0; i < size; i++) {
                C1725a aVar = (C1725a) n.get(i);
                if (!this.f4563b.contains(aVar.f4796a)) {
                    this.f4563b.add(aVar.f4796a);
                }
                for (int i2 = 0; i2 < aVar.f4797b.size(); i2++) {
                    if (!this.f4563b.contains(aVar.f4797b.get(i2))) {
                        this.f4563b.add(aVar.f4797b.get(i2));
                    }
                }
            }
        }
        return this.f4563b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <X> Encoder<X> mo12809a(X x) throws NoSourceEncoderAvailableException {
        return this.f4564c.mo12550d().mo12351a(x);
    }
}
