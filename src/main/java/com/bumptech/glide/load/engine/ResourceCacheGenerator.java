package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DataFetcherGenerator.C1668a;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.v */
class ResourceCacheGenerator implements C1623a<Object>, DataFetcherGenerator {
    /* renamed from: a */
    private final C1668a f4717a;
    /* renamed from: b */
    private final DecodeHelper<?> f4718b;
    /* renamed from: c */
    private int f4719c;
    /* renamed from: d */
    private int f4720d = -1;
    /* renamed from: e */
    private Key f4721e;
    /* renamed from: f */
    private List<ModelLoader<File, ?>> f4722f;
    /* renamed from: g */
    private int f4723g;
    /* renamed from: h */
    private volatile C1725a<?> f4724h;
    /* renamed from: i */
    private File f4725i;
    /* renamed from: j */
    private ResourceCacheKey f4726j;

    ResourceCacheGenerator(DecodeHelper<?> gVar, C1668a aVar) {
        this.f4718b = gVar;
        this.f4717a = aVar;
    }

    /* renamed from: a */
    public boolean mo12776a() {
        List o = this.f4718b.mo12832o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List l = this.f4718b.mo12829l();
        if (!l.isEmpty()) {
            while (true) {
                if (this.f4722f == null || !m5744c()) {
                    this.f4720d++;
                    if (this.f4720d >= l.size()) {
                        this.f4719c++;
                        if (this.f4719c >= o.size()) {
                            return false;
                        }
                        this.f4720d = 0;
                    }
                    Key cVar = (Key) o.get(this.f4719c);
                    Class cls = (Class) l.get(this.f4720d);
                    Key cVar2 = cVar;
                    ResourceCacheKey wVar = new ResourceCacheKey(this.f4718b.mo12826i(), cVar2, this.f4718b.mo12823f(), this.f4718b.mo12824g(), this.f4718b.mo12825h(), this.f4718b.mo12820c(cls), cls, this.f4718b.mo12822e());
                    this.f4726j = wVar;
                    this.f4725i = this.f4718b.mo12816b().mo12785a(this.f4726j);
                    File file = this.f4725i;
                    if (file != null) {
                        this.f4721e = cVar;
                        this.f4722f = this.f4718b.mo12810a(file);
                        this.f4723g = 0;
                    }
                } else {
                    this.f4724h = null;
                    while (!z && m5744c()) {
                        List<ModelLoader<File, ?>> list = this.f4722f;
                        int i = this.f4723g;
                        this.f4723g = i + 1;
                        this.f4724h = ((ModelLoader) list.get(i)).mo12926a(this.f4725i, this.f4718b.mo12824g(), this.f4718b.mo12825h(), this.f4718b.mo12822e());
                        if (this.f4724h != null && this.f4718b.mo12815a(this.f4724h.f4798c.mo12619a())) {
                            this.f4724h.f4798c.mo12626a(this.f4718b.mo12821d(), this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
        } else if (File.class.equals(this.f4718b.mo12827j())) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any load path from ");
            sb.append(this.f4718b.mo12828k());
            sb.append(" to ");
            sb.append(this.f4718b.mo12827j());
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: c */
    private boolean m5744c() {
        return this.f4723g < this.f4722f.size();
    }

    /* renamed from: b */
    public void mo12777b() {
        C1725a<?> aVar = this.f4724h;
        if (aVar != null) {
            aVar.f4798c.mo12628c();
        }
    }

    /* renamed from: a */
    public void mo12641a(Object obj) {
        this.f4717a.mo12807a(this.f4721e, obj, this.f4724h.f4798c, DataSource.RESOURCE_DISK_CACHE, this.f4726j);
    }

    /* renamed from: a */
    public void mo12640a(Exception exc) {
        this.f4717a.mo12806a(this.f4726j, exc, this.f4724h.f4798c, DataSource.RESOURCE_DISK_CACHE);
    }
}
